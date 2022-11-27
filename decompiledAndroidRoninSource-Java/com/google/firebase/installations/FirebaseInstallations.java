package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations
  implements FirebaseInstallationsApi
{
  private static final String API_KEY_VALIDATION_MSG = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
  private static final String APP_ID_VALIDATION_MSG = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
  private static final String AUTH_ERROR_MSG = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.";
  private static final String CHIME_FIREBASE_APP_NAME = "CHIME_ANDROID_SDK";
  private static final int CORE_POOL_SIZE = 0;
  private static final long KEEP_ALIVE_TIME_IN_SECONDS = 30L;
  private static final String LOCKFILE_NAME_GENERATE_FID = "generatefid.lock";
  private static final int MAXIMUM_POOL_SIZE = 1;
  private static final String PROJECT_ID_VALIDATION_MSG = "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
  private static final ThreadFactory THREAD_FACTORY = new ThreadFactory()
  {
    private final AtomicInteger mCount = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, String.format("firebase-installations-executor-%d", new Object[] { Integer.valueOf(this.mCount.getAndIncrement()) }));
    }
  };
  private static final Object lockGenerateFid = new Object();
  private final ExecutorService backgroundExecutor;
  private String cachedFid;
  private final RandomFidGenerator fidGenerator;
  private final FirebaseApp firebaseApp;
  private final IidStore iidStore;
  private final List<StateListener> listeners = new ArrayList();
  private final Object lock = new Object();
  private final ExecutorService networkExecutor;
  private final PersistedInstallation persistedInstallation;
  private final FirebaseInstallationServiceClient serviceClient;
  private final Utils utils;
  
  FirebaseInstallations(FirebaseApp paramFirebaseApp, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo)
  {
    this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY), paramFirebaseApp, new FirebaseInstallationServiceClient(paramFirebaseApp.getApplicationContext(), paramUserAgentPublisher, paramHeartBeatInfo), new PersistedInstallation(paramFirebaseApp), new Utils(), new IidStore(paramFirebaseApp), new RandomFidGenerator());
  }
  
  FirebaseInstallations(ExecutorService paramExecutorService, FirebaseApp paramFirebaseApp, FirebaseInstallationServiceClient paramFirebaseInstallationServiceClient, PersistedInstallation paramPersistedInstallation, Utils paramUtils, IidStore paramIidStore, RandomFidGenerator paramRandomFidGenerator)
  {
    this.firebaseApp = paramFirebaseApp;
    this.serviceClient = paramFirebaseInstallationServiceClient;
    this.persistedInstallation = paramPersistedInstallation;
    this.utils = paramUtils;
    this.iidStore = paramIidStore;
    this.fidGenerator = paramRandomFidGenerator;
    this.backgroundExecutor = paramExecutorService;
    this.networkExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
  }
  
  private Task<InstallationTokenResult> addGetAuthTokenListener()
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    addStateListeners(new GetAuthTokenListener(this.utils, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  private Task<String> addGetIdListener()
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    addStateListeners(new GetIdListener(localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  private void addStateListeners(StateListener paramStateListener)
  {
    synchronized (this.lock)
    {
      this.listeners.add(paramStateListener);
      return;
    }
  }
  
  private Void deleteFirebaseInstallationId()
    throws FirebaseInstallationsException
  {
    updateCacheFid(null);
    PersistedInstallationEntry localPersistedInstallationEntry = getMultiProcessSafePrefs();
    if (localPersistedInstallationEntry.isRegistered()) {
      this.serviceClient.deleteFirebaseInstallation(getApiKey(), localPersistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), localPersistedInstallationEntry.getRefreshToken());
    }
    insertOrUpdatePrefs(localPersistedInstallationEntry.withNoGeneratedFid());
    return null;
  }
  
  private void doNetworkCallIfNecessary(boolean paramBoolean)
  {
    PersistedInstallationEntry localPersistedInstallationEntry2 = getMultiProcessSafePrefs();
    try
    {
      PersistedInstallationEntry localPersistedInstallationEntry1;
      if ((!localPersistedInstallationEntry2.isErrored()) && (!localPersistedInstallationEntry2.isUnregistered()))
      {
        if (!paramBoolean) {
          if (!this.utils.isAuthTokenExpired(localPersistedInstallationEntry2)) {
            return;
          }
        }
        localPersistedInstallationEntry1 = fetchAuthTokenFromServer(localPersistedInstallationEntry2);
      }
      else
      {
        localPersistedInstallationEntry1 = registerFidWithServer(localPersistedInstallationEntry2);
      }
      insertOrUpdatePrefs(localPersistedInstallationEntry1);
      if (localPersistedInstallationEntry1.isRegistered()) {
        updateCacheFid(localPersistedInstallationEntry1.getFirebaseInstallationId());
      }
      if (localPersistedInstallationEntry1.isErrored())
      {
        triggerOnException(localPersistedInstallationEntry1, new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
        return;
      }
      if (localPersistedInstallationEntry1.isNotGenerated())
      {
        triggerOnException(localPersistedInstallationEntry1, new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
        return;
      }
      triggerOnStateReached(localPersistedInstallationEntry1);
      return;
    }
    catch (FirebaseInstallationsException localFirebaseInstallationsException)
    {
      triggerOnException(localPersistedInstallationEntry2, localFirebaseInstallationsException);
      return;
    }
  }
  
  private final void doRegistrationOrRefresh(boolean paramBoolean)
  {
    PersistedInstallationEntry localPersistedInstallationEntry2 = getPrefsWithGeneratedIdMultiProcessSafe();
    PersistedInstallationEntry localPersistedInstallationEntry1 = localPersistedInstallationEntry2;
    if (paramBoolean) {
      localPersistedInstallationEntry1 = localPersistedInstallationEntry2.withClearedAuthToken();
    }
    triggerOnStateReached(localPersistedInstallationEntry1);
    this.networkExecutor.execute(FirebaseInstallations..Lambda.4.lambdaFactory$(this, paramBoolean));
  }
  
  private PersistedInstallationEntry fetchAuthTokenFromServer(PersistedInstallationEntry paramPersistedInstallationEntry)
    throws FirebaseInstallationsException
  {
    TokenResult localTokenResult = this.serviceClient.generateAuthToken(getApiKey(), paramPersistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), paramPersistedInstallationEntry.getRefreshToken());
    int i = 2.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode[localTokenResult.getResponseCode().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          updateCacheFid(null);
          return paramPersistedInstallationEntry.withNoGeneratedFid();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
      }
      return paramPersistedInstallationEntry.withFisError("BAD CONFIG");
    }
    return paramPersistedInstallationEntry.withAuthToken(localTokenResult.getToken(), localTokenResult.getTokenExpirationTimestamp(), this.utils.currentTimeInSecs());
  }
  
  private String getCacheFid()
  {
    try
    {
      String str = this.cachedFid;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static FirebaseInstallations getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }
  
  public static FirebaseInstallations getInstance(FirebaseApp paramFirebaseApp)
  {
    boolean bool;
    if (paramFirebaseApp != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Null is not a valid value of FirebaseApp.");
    return (FirebaseInstallations)paramFirebaseApp.get(FirebaseInstallationsApi.class);
  }
  
  private PersistedInstallationEntry getMultiProcessSafePrefs()
  {
    synchronized (lockGenerateFid)
    {
      CrossProcessLock localCrossProcessLock = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
      try
      {
        PersistedInstallationEntry localPersistedInstallationEntry = this.persistedInstallation.readPersistedInstallationEntryValue();
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
        return localPersistedInstallationEntry;
      }
      finally
      {
        localObject3 = finally;
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
        throw ((Throwable)localObject3);
      }
    }
  }
  
  private PersistedInstallationEntry getPrefsWithGeneratedIdMultiProcessSafe()
  {
    synchronized (lockGenerateFid)
    {
      CrossProcessLock localCrossProcessLock = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
      try
      {
        PersistedInstallationEntry localPersistedInstallationEntry = this.persistedInstallation.readPersistedInstallationEntryValue();
        Object localObject1 = localPersistedInstallationEntry;
        if (localPersistedInstallationEntry.isNotGenerated())
        {
          localObject1 = readExistingIidOrCreateFid(localPersistedInstallationEntry);
          localObject1 = this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(localPersistedInstallationEntry.withUnregisteredFid((String)localObject1));
        }
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
        return (PersistedInstallationEntry)localObject1;
      }
      finally
      {
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
      }
    }
  }
  
  private void insertOrUpdatePrefs(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    synchronized (lockGenerateFid)
    {
      CrossProcessLock localCrossProcessLock = CrossProcessLock.acquire(this.firebaseApp.getApplicationContext(), "generatefid.lock");
      try
      {
        this.persistedInstallation.insertOrUpdatePersistedInstallationEntry(paramPersistedInstallationEntry);
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
        return;
      }
      finally
      {
        paramPersistedInstallationEntry = finally;
        if (localCrossProcessLock != null) {
          localCrossProcessLock.releaseAndClose();
        }
        throw paramPersistedInstallationEntry;
      }
    }
  }
  
  private void preConditionChecks()
  {
    Preconditions.checkNotEmpty(getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
    Preconditions.checkNotEmpty(getProjectIdentifier(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
    Preconditions.checkNotEmpty(getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    Preconditions.checkArgument(Utils.isValidAppIdFormat(getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
    Preconditions.checkArgument(Utils.isValidApiKeyFormat(getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
  }
  
  private String readExistingIidOrCreateFid(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if (((!this.firebaseApp.getName().equals("CHIME_ANDROID_SDK")) && (!this.firebaseApp.isDefaultApp())) || (!paramPersistedInstallationEntry.shouldAttemptMigration())) {
      return this.fidGenerator.createRandomFid();
    }
    String str = this.iidStore.readIid();
    paramPersistedInstallationEntry = str;
    if (TextUtils.isEmpty(str)) {
      paramPersistedInstallationEntry = this.fidGenerator.createRandomFid();
    }
    return paramPersistedInstallationEntry;
  }
  
  private PersistedInstallationEntry registerFidWithServer(PersistedInstallationEntry paramPersistedInstallationEntry)
    throws FirebaseInstallationsException
  {
    if ((paramPersistedInstallationEntry.getFirebaseInstallationId() != null) && (paramPersistedInstallationEntry.getFirebaseInstallationId().length() == 11)) {
      localObject = this.iidStore.readToken();
    } else {
      localObject = null;
    }
    Object localObject = this.serviceClient.createFirebaseInstallation(getApiKey(), paramPersistedInstallationEntry.getFirebaseInstallationId(), getProjectIdentifier(), getApplicationId(), (String)localObject);
    int i = 2.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode[localObject.getResponseCode().ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return paramPersistedInstallationEntry.withFisError("BAD CONFIG");
      }
      throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
    return paramPersistedInstallationEntry.withRegisteredFid(((InstallationResponse)localObject).getFid(), ((InstallationResponse)localObject).getRefreshToken(), this.utils.currentTimeInSecs(), ((InstallationResponse)localObject).getAuthToken().getToken(), ((InstallationResponse)localObject).getAuthToken().getTokenExpirationTimestamp());
  }
  
  private void triggerOnException(PersistedInstallationEntry paramPersistedInstallationEntry, Exception paramException)
  {
    synchronized (this.lock)
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        if (((StateListener)localIterator.next()).onException(paramPersistedInstallationEntry, paramException)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
  
  private void triggerOnStateReached(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    synchronized (this.lock)
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        if (((StateListener)localIterator.next()).onStateReached(paramPersistedInstallationEntry)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
  
  private void updateCacheFid(String paramString)
  {
    try
    {
      this.cachedFid = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Task<Void> delete()
  {
    return Tasks.call(this.backgroundExecutor, FirebaseInstallations..Lambda.3.lambdaFactory$(this));
  }
  
  String getApiKey()
  {
    return this.firebaseApp.getOptions().getApiKey();
  }
  
  String getApplicationId()
  {
    return this.firebaseApp.getOptions().getApplicationId();
  }
  
  public Task<String> getId()
  {
    preConditionChecks();
    Object localObject = getCacheFid();
    if (localObject != null) {
      return Tasks.forResult(localObject);
    }
    localObject = addGetIdListener();
    this.backgroundExecutor.execute(FirebaseInstallations..Lambda.1.lambdaFactory$(this));
    return (Task<String>)localObject;
  }
  
  String getName()
  {
    return this.firebaseApp.getName();
  }
  
  String getProjectIdentifier()
  {
    return this.firebaseApp.getOptions().getProjectId();
  }
  
  public Task<InstallationTokenResult> getToken(boolean paramBoolean)
  {
    preConditionChecks();
    Task localTask = addGetAuthTokenListener();
    this.backgroundExecutor.execute(FirebaseInstallations..Lambda.2.lambdaFactory$(this, paramBoolean));
    return localTask;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\FirebaseInstallations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */