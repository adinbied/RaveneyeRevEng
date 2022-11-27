package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp
{
  public static final String DEFAULT_APP_NAME = "[DEFAULT]";
  private static final String FIREBASE_ANDROID = "fire-android";
  private static final String FIREBASE_COMMON = "fire-core";
  static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
  private static final String KOTLIN = "kotlin";
  private static final Object LOCK = new Object();
  private static final String LOG_TAG = "FirebaseApp";
  private static final Executor UI_EXECUTOR = new UiExecutor(null);
  private final Context applicationContext;
  private final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
  private final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
  private final ComponentRuntime componentRuntime;
  private final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
  private final AtomicBoolean deleted = new AtomicBoolean();
  private final List<FirebaseAppLifecycleListener> lifecycleListeners = new CopyOnWriteArrayList();
  private final String name;
  private final FirebaseOptions options;
  
  protected FirebaseApp(Context paramContext, String paramString, FirebaseOptions paramFirebaseOptions)
  {
    this.applicationContext = ((Context)Preconditions.checkNotNull(paramContext));
    this.name = Preconditions.checkNotEmpty(paramString);
    this.options = ((FirebaseOptions)Preconditions.checkNotNull(paramFirebaseOptions));
    List localList = ComponentDiscovery.forContext(paramContext, ComponentDiscoveryService.class).discover();
    paramString = KotlinDetector.detectVersion();
    Executor localExecutor = UI_EXECUTOR;
    Component localComponent1 = Component.of(paramContext, Context.class, new Class[0]);
    Component localComponent2 = Component.of(this, FirebaseApp.class, new Class[0]);
    paramFirebaseOptions = Component.of(paramFirebaseOptions, FirebaseOptions.class, new Class[0]);
    Component localComponent3 = LibraryVersionComponent.create("fire-android", "");
    Component localComponent4 = LibraryVersionComponent.create("fire-core", "19.3.1");
    if (paramString != null) {
      paramString = LibraryVersionComponent.create("kotlin", paramString);
    } else {
      paramString = null;
    }
    this.componentRuntime = new ComponentRuntime(localExecutor, localList, new Component[] { localComponent1, localComponent2, paramFirebaseOptions, localComponent3, localComponent4, paramString, DefaultUserAgentPublisher.component(), DefaultHeartBeatInfo.component() });
    this.dataCollectionConfigStorage = new Lazy(FirebaseApp..Lambda.1.lambdaFactory$(this, paramContext));
  }
  
  private void checkNotDeleted()
  {
    Preconditions.checkState(this.deleted.get() ^ true, "FirebaseApp was deleted");
  }
  
  public static void clearInstancesForTest()
  {
    synchronized (LOCK)
    {
      INSTANCES.clear();
      return;
    }
  }
  
  private static List<String> getAllAppNames()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (LOCK)
    {
      Iterator localIterator = INSTANCES.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((FirebaseApp)localIterator.next()).getName());
      }
      Collections.sort(localArrayList);
      return localArrayList;
    }
  }
  
  public static List<FirebaseApp> getApps(Context arg0)
  {
    synchronized (LOCK)
    {
      ArrayList localArrayList = new ArrayList(INSTANCES.values());
      return localArrayList;
    }
  }
  
  public static FirebaseApp getInstance()
  {
    synchronized (LOCK)
    {
      Object localObject2 = (FirebaseApp)INSTANCES.get("[DEFAULT]");
      if (localObject2 != null) {
        return (FirebaseApp)localObject2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Default FirebaseApp is not initialized in this process ");
      ((StringBuilder)localObject2).append(ProcessUtils.getMyProcessName());
      ((StringBuilder)localObject2).append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
  }
  
  public static FirebaseApp getInstance(String paramString)
  {
    synchronized (LOCK)
    {
      Object localObject1 = (FirebaseApp)INSTANCES.get(normalize(paramString));
      if (localObject1 != null) {
        return (FirebaseApp)localObject1;
      }
      localObject1 = getAllAppNames();
      if (((List)localObject1).isEmpty())
      {
        localObject1 = "";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Available app names: ");
        localStringBuilder.append(TextUtils.join(", ", (Iterable)localObject1));
        localObject1 = localStringBuilder.toString();
      }
      throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[] { paramString, localObject1 }));
    }
  }
  
  public static String getPersistenceKey(String paramString, FirebaseOptions paramFirebaseOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramString.getBytes(Charset.defaultCharset())));
    localStringBuilder.append("+");
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(paramFirebaseOptions.getApplicationId().getBytes(Charset.defaultCharset())));
    return localStringBuilder.toString();
  }
  
  private void initializeAllApis()
  {
    if ((UserManagerCompat.isUserUnlocked(this.applicationContext) ^ true))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
      localStringBuilder.append(getName());
      Log.i("FirebaseApp", localStringBuilder.toString());
      UserUnlockReceiver.ensureReceiverRegistered(this.applicationContext);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Device unlocked: initializing all Firebase APIs for app ");
    localStringBuilder.append(getName());
    Log.i("FirebaseApp", localStringBuilder.toString());
    this.componentRuntime.initializeEagerComponents(isDefaultApp());
  }
  
  public static FirebaseApp initializeApp(Context paramContext)
  {
    synchronized (LOCK)
    {
      if (INSTANCES.containsKey("[DEFAULT]"))
      {
        paramContext = getInstance();
        return paramContext;
      }
      FirebaseOptions localFirebaseOptions = FirebaseOptions.fromResource(paramContext);
      if (localFirebaseOptions == null)
      {
        Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
        return null;
      }
      paramContext = initializeApp(paramContext, localFirebaseOptions);
      return paramContext;
    }
  }
  
  public static FirebaseApp initializeApp(Context paramContext, FirebaseOptions paramFirebaseOptions)
  {
    return initializeApp(paramContext, paramFirebaseOptions, "[DEFAULT]");
  }
  
  public static FirebaseApp initializeApp(Context paramContext, FirebaseOptions paramFirebaseOptions, String paramString)
  {
    GlobalBackgroundStateListener.ensureBackgroundStateListenerRegistered(paramContext);
    paramString = normalize(paramString);
    if (paramContext.getApplicationContext() != null) {
      paramContext = paramContext.getApplicationContext();
    }
    for (;;)
    {
      synchronized (LOCK)
      {
        if (!INSTANCES.containsKey(paramString))
        {
          bool = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FirebaseApp name ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" already exists!");
          Preconditions.checkState(bool, localStringBuilder.toString());
          Preconditions.checkNotNull(paramContext, "Application context cannot be null.");
          paramContext = new FirebaseApp(paramContext, paramString, paramFirebaseOptions);
          INSTANCES.put(paramString, paramContext);
          paramContext.initializeAllApis();
          return paramContext;
        }
      }
      boolean bool = false;
    }
  }
  
  private static String normalize(String paramString)
  {
    return paramString.trim();
  }
  
  private void notifyBackgroundStateChangeListeners(boolean paramBoolean)
  {
    Log.d("FirebaseApp", "Notifying background state change listeners.");
    Iterator localIterator = this.backgroundStateChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((BackgroundStateChangeListener)localIterator.next()).onBackgroundStateChanged(paramBoolean);
    }
  }
  
  private void notifyOnAppDeleted()
  {
    Iterator localIterator = this.lifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((FirebaseAppLifecycleListener)localIterator.next()).onDeleted(this.name, this.options);
    }
  }
  
  public void addBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    checkNotDeleted();
    if ((this.automaticResourceManagementEnabled.get()) && (BackgroundDetector.getInstance().isInBackground())) {
      paramBackgroundStateChangeListener.onBackgroundStateChanged(true);
    }
    this.backgroundStateChangeListeners.add(paramBackgroundStateChangeListener);
  }
  
  public void addLifecycleEventListener(FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener)
  {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.add(paramFirebaseAppLifecycleListener);
  }
  
  public void delete()
  {
    if (!this.deleted.compareAndSet(false, true)) {
      return;
    }
    synchronized (LOCK)
    {
      INSTANCES.remove(this.name);
      notifyOnAppDeleted();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseApp)) {
      return false;
    }
    return this.name.equals(((FirebaseApp)paramObject).getName());
  }
  
  public <T> T get(Class<T> paramClass)
  {
    checkNotDeleted();
    return (T)this.componentRuntime.get(paramClass);
  }
  
  public Context getApplicationContext()
  {
    checkNotDeleted();
    return this.applicationContext;
  }
  
  public String getName()
  {
    checkNotDeleted();
    return this.name;
  }
  
  public FirebaseOptions getOptions()
  {
    checkNotDeleted();
    return this.options;
  }
  
  public String getPersistenceKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())));
    localStringBuilder.append("+");
    localStringBuilder.append(Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset())));
    return localStringBuilder.toString();
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public boolean isDataCollectionDefaultEnabled()
  {
    checkNotDeleted();
    return ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).isEnabled();
  }
  
  public boolean isDefaultApp()
  {
    return "[DEFAULT]".equals(getName());
  }
  
  public void removeBackgroundStateChangeListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    checkNotDeleted();
    this.backgroundStateChangeListeners.remove(paramBackgroundStateChangeListener);
  }
  
  public void removeLifecycleEventListener(FirebaseAppLifecycleListener paramFirebaseAppLifecycleListener)
  {
    checkNotDeleted();
    Preconditions.checkNotNull(paramFirebaseAppLifecycleListener);
    this.lifecycleListeners.remove(paramFirebaseAppLifecycleListener);
  }
  
  public void setAutomaticResourceManagementEnabled(boolean paramBoolean)
  {
    checkNotDeleted();
    if (this.automaticResourceManagementEnabled.compareAndSet(paramBoolean ^ true, paramBoolean))
    {
      boolean bool = BackgroundDetector.getInstance().isInBackground();
      if ((paramBoolean) && (bool))
      {
        notifyBackgroundStateChangeListeners(true);
        return;
      }
      if ((!paramBoolean) && (bool)) {
        notifyBackgroundStateChangeListeners(false);
      }
    }
  }
  
  public void setDataCollectionDefaultEnabled(Boolean paramBoolean)
  {
    checkNotDeleted();
    ((DataCollectionConfigStorage)this.dataCollectionConfigStorage.get()).setEnabled(paramBoolean);
  }
  
  @Deprecated
  public void setDataCollectionDefaultEnabled(boolean paramBoolean)
  {
    setDataCollectionDefaultEnabled(Boolean.valueOf(paramBoolean));
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("options", this.options).toString();
  }
  
  public static abstract interface BackgroundStateChangeListener
  {
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
  
  private static class GlobalBackgroundStateListener
    implements BackgroundDetector.BackgroundStateChangeListener
  {
    private static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference();
    
    private static void ensureBackgroundStateListenerRegistered(Context paramContext)
    {
      if (PlatformVersion.isAtLeastIceCreamSandwich())
      {
        if (!(paramContext.getApplicationContext() instanceof Application)) {
          return;
        }
        paramContext = (Application)paramContext.getApplicationContext();
        if (INSTANCE.get() == null)
        {
          GlobalBackgroundStateListener localGlobalBackgroundStateListener = new GlobalBackgroundStateListener();
          if (INSTANCE.compareAndSet(null, localGlobalBackgroundStateListener))
          {
            BackgroundDetector.initialize(paramContext);
            BackgroundDetector.getInstance().addListener(localGlobalBackgroundStateListener);
          }
        }
      }
    }
    
    public void onBackgroundStateChanged(boolean paramBoolean)
    {
      synchronized (FirebaseApp.LOCK)
      {
        Iterator localIterator = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
        while (localIterator.hasNext())
        {
          FirebaseApp localFirebaseApp = (FirebaseApp)localIterator.next();
          if (localFirebaseApp.automaticResourceManagementEnabled.get()) {
            localFirebaseApp.notifyBackgroundStateChangeListeners(paramBoolean);
          }
        }
        return;
      }
    }
  }
  
  private static class UiExecutor
    implements Executor
  {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    
    public void execute(Runnable paramRunnable)
    {
      HANDLER.post(paramRunnable);
    }
  }
  
  private static class UserUnlockReceiver
    extends BroadcastReceiver
  {
    private static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference();
    private final Context applicationContext;
    
    public UserUnlockReceiver(Context paramContext)
    {
      this.applicationContext = paramContext;
    }
    
    private static void ensureReceiverRegistered(Context paramContext)
    {
      if (INSTANCE.get() == null)
      {
        UserUnlockReceiver localUserUnlockReceiver = new UserUnlockReceiver(paramContext);
        if (INSTANCE.compareAndSet(null, localUserUnlockReceiver)) {
          paramContext.registerReceiver(localUserUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        }
      }
    }
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      synchronized (FirebaseApp.LOCK)
      {
        paramIntent = FirebaseApp.INSTANCES.values().iterator();
        while (paramIntent.hasNext()) {
          ((FirebaseApp)paramIntent.next()).initializeAllApis();
        }
        unregister();
        return;
      }
    }
    
    public void unregister()
    {
      this.applicationContext.unregisterReceiver(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\FirebaseApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */