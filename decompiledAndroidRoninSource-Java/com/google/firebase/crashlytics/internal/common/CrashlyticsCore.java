package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore
{
  private static final float CLS_DEFAULT_PROCESS_DELAY = 1.0F;
  static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
  static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
  static final String CRASH_MARKER_FILE_NAME = "crash_marker";
  static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
  private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
  private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
  private final AnalyticsEventLogger analyticsEventLogger;
  private final FirebaseApp app;
  private CrashlyticsBackgroundWorker backgroundWorker;
  private final BreadcrumbSource breadcrumbSource;
  private final Context context;
  private CrashlyticsController controller;
  private ExecutorService crashHandlerExecutor;
  private CrashlyticsFileMarker crashMarker;
  private final DataCollectionArbiter dataCollectionArbiter;
  private boolean didCrashOnPreviousExecution;
  private final IdManager idManager;
  private CrashlyticsFileMarker initializationMarker;
  private CrashlyticsNativeComponent nativeComponent;
  private final long startTime;
  
  public CrashlyticsCore(FirebaseApp paramFirebaseApp, IdManager paramIdManager, CrashlyticsNativeComponent paramCrashlyticsNativeComponent, DataCollectionArbiter paramDataCollectionArbiter, BreadcrumbSource paramBreadcrumbSource, AnalyticsEventLogger paramAnalyticsEventLogger, ExecutorService paramExecutorService)
  {
    this.app = paramFirebaseApp;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    this.context = paramFirebaseApp.getApplicationContext();
    this.idManager = paramIdManager;
    this.nativeComponent = paramCrashlyticsNativeComponent;
    this.breadcrumbSource = paramBreadcrumbSource;
    this.analyticsEventLogger = paramAnalyticsEventLogger;
    this.crashHandlerExecutor = paramExecutorService;
    this.backgroundWorker = new CrashlyticsBackgroundWorker(paramExecutorService);
    this.startTime = System.currentTimeMillis();
  }
  
  private void checkForPreviousCrash()
  {
    Object localObject = this.backgroundWorker.submit(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        return Boolean.valueOf(CrashlyticsCore.this.controller.didCrashOnPreviousExecution());
      }
    });
    try
    {
      localObject = (Boolean)Utils.awaitEvenIfOnMainThread((Task)localObject);
      this.didCrashOnPreviousExecution = Boolean.TRUE.equals(localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.didCrashOnPreviousExecution = false;
  }
  
  /* Error */
  private Task<Void> doBackgroundInitialization(SettingsDataProvider paramSettingsDataProvider)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 148	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationStarted	()V
    //   4: aload_0
    //   5: getfield 117	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:controller	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;
    //   8: invokevirtual 153	com/google/firebase/crashlytics/internal/common/CrashlyticsController:cleanInvalidTempFiles	()V
    //   11: aload_0
    //   12: getfield 83	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:breadcrumbSource	Lcom/google/firebase/crashlytics/internal/breadcrumbs/BreadcrumbSource;
    //   15: aload_0
    //   16: invokestatic 159	com/google/firebase/crashlytics/internal/common/CrashlyticsCore$$Lambda$1:lambdaFactory$	(Lcom/google/firebase/crashlytics/internal/common/CrashlyticsCore;)Lcom/google/firebase/crashlytics/internal/breadcrumbs/BreadcrumbHandler;
    //   19: invokeinterface 165 2 0
    //   24: aload_1
    //   25: invokeinterface 171 1 0
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface 177 1 0
    //   37: getfield 182	com/google/firebase/crashlytics/internal/settings/model/FeaturesSettingsData:collectReports	Z
    //   40: ifne +30 -> 70
    //   43: invokestatic 188	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   46: ldc -66
    //   48: invokevirtual 194	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   51: new 196	java/lang/RuntimeException
    //   54: dup
    //   55: ldc -66
    //   57: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: invokestatic 204	com/google/android/gms/tasks/Tasks:forException	(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual 207	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   68: aload_1
    //   69: areturn
    //   70: aload_0
    //   71: getfield 117	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:controller	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;
    //   74: aload_2
    //   75: invokeinterface 211 1 0
    //   80: getfield 216	com/google/firebase/crashlytics/internal/settings/model/SessionSettingsData:maxCustomExceptionEvents	I
    //   83: invokevirtual 220	com/google/firebase/crashlytics/internal/common/CrashlyticsController:finalizeSessions	(I)Z
    //   86: ifne +11 -> 97
    //   89: invokestatic 188	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   92: ldc -34
    //   94: invokevirtual 194	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 117	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:controller	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;
    //   101: fconst_1
    //   102: aload_1
    //   103: invokeinterface 226 1 0
    //   108: invokevirtual 230	com/google/firebase/crashlytics/internal/common/CrashlyticsController:submitAllReports	(FLcom/google/android/gms/tasks/Task;)Lcom/google/android/gms/tasks/Task;
    //   111: astore_1
    //   112: aload_0
    //   113: invokevirtual 207	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   116: aload_1
    //   117: areturn
    //   118: astore_1
    //   119: goto +24 -> 143
    //   122: astore_1
    //   123: invokestatic 188	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   126: ldc -24
    //   128: aload_1
    //   129: invokevirtual 236	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_1
    //   133: invokestatic 204	com/google/android/gms/tasks/Tasks:forException	(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   136: astore_1
    //   137: aload_0
    //   138: invokevirtual 207	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   141: aload_1
    //   142: areturn
    //   143: aload_0
    //   144: invokevirtual 207	com/google/firebase/crashlytics/internal/common/CrashlyticsCore:markInitializationComplete	()V
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	CrashlyticsCore
    //   0	149	1	paramSettingsDataProvider	SettingsDataProvider
    //   30	45	2	localSettings	com.google.firebase.crashlytics.internal.settings.model.Settings
    // Exception table:
    //   from	to	target	type
    //   11	64	118	finally
    //   70	97	118	finally
    //   97	112	118	finally
    //   123	137	118	finally
    //   11	64	122	java/lang/Exception
    //   70	97	122	java/lang/Exception
    //   97	112	122	java/lang/Exception
  }
  
  private void finishInitSynchronously(final SettingsDataProvider paramSettingsDataProvider)
  {
    paramSettingsDataProvider = new Runnable()
    {
      public void run()
      {
        CrashlyticsCore.this.doBackgroundInitialization(paramSettingsDataProvider);
      }
    };
    paramSettingsDataProvider = this.crashHandlerExecutor.submit(paramSettingsDataProvider);
    Logger.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    try
    {
      paramSettingsDataProvider.get(4L, TimeUnit.SECONDS);
      return;
    }
    catch (TimeoutException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Crashlytics timed out during initialization.", paramSettingsDataProvider);
      return;
    }
    catch (ExecutionException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Problem encountered during Crashlytics initialization.", paramSettingsDataProvider);
      return;
    }
    catch (InterruptedException paramSettingsDataProvider)
    {
      Logger.getLogger().e("Crashlytics was interrupted during initialization.", paramSettingsDataProvider);
    }
  }
  
  public static String getVersion()
  {
    return "17.2.2";
  }
  
  static boolean isBuildIdValid(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Logger.getLogger().d("Configured not to require a build ID.");
      return true;
    }
    if (!CommonUtils.isNullOrEmpty(paramString)) {
      return true;
    }
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", ".     |  | ");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".   \\ |  | /");
    Log.e("FirebaseCrashlytics", ".    \\    /");
    Log.e("FirebaseCrashlytics", ".     \\  /");
    Log.e("FirebaseCrashlytics", ".      \\/");
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    Log.e("FirebaseCrashlytics", ".");
    Log.e("FirebaseCrashlytics", ".      /\\");
    Log.e("FirebaseCrashlytics", ".     /  \\");
    Log.e("FirebaseCrashlytics", ".    /    \\");
    Log.e("FirebaseCrashlytics", ".   / |  | \\");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".     |  |");
    Log.e("FirebaseCrashlytics", ".");
    return false;
  }
  
  public Task<Boolean> checkForUnsentReports()
  {
    return this.controller.checkForUnsentReports();
  }
  
  public Task<Void> deleteUnsentReports()
  {
    return this.controller.deleteUnsentReports();
  }
  
  public boolean didCrashOnPreviousExecution()
  {
    return this.didCrashOnPreviousExecution;
  }
  
  boolean didPreviousInitializationFail()
  {
    return this.initializationMarker.isPresent();
  }
  
  public Task<Void> doBackgroundInitializationAsync(final SettingsDataProvider paramSettingsDataProvider)
  {
    Utils.callTask(this.crashHandlerExecutor, new Callable()
    {
      public Task<Void> call()
        throws Exception
      {
        return CrashlyticsCore.this.doBackgroundInitialization(paramSettingsDataProvider);
      }
    });
  }
  
  CrashlyticsController getController()
  {
    return this.controller;
  }
  
  public void log(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.startTime;
    this.controller.writeToLog(l1 - l2, paramString);
  }
  
  public void logException(Throwable paramThrowable)
  {
    this.controller.writeNonFatalException(Thread.currentThread(), paramThrowable);
  }
  
  void markInitializationComplete()
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Boolean call()
        throws Exception
      {
        try
        {
          boolean bool = CrashlyticsCore.this.initializationMarker.remove();
          Logger localLogger = Logger.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Initialization marker file removed: ");
          localStringBuilder.append(bool);
          localLogger.d(localStringBuilder.toString());
          return Boolean.valueOf(bool);
        }
        catch (Exception localException)
        {
          Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", localException);
        }
        return Boolean.valueOf(false);
      }
    });
  }
  
  void markInitializationStarted()
  {
    this.backgroundWorker.checkRunningOnThread();
    this.initializationMarker.create();
    Logger.getLogger().d("Initialization marker file created.");
  }
  
  public boolean onPreExecute(SettingsDataProvider paramSettingsDataProvider)
  {
    Object localObject1 = CommonUtils.getMappingFileId(this.context);
    Object localObject2 = Logger.getLogger();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Mapping file ID is: ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((Logger)localObject2).d(((StringBuilder)localObject3).toString());
    if (isBuildIdValid((String)localObject1, CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.RequireBuildId", true)))
    {
      Object localObject4 = this.app.getOptions().getApplicationId();
      try
      {
        localObject2 = Logger.getLogger();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Initializing Crashlytics ");
        ((StringBuilder)localObject3).append(getVersion());
        ((Logger)localObject2).i(((StringBuilder)localObject3).toString());
        localObject2 = new FileStoreImpl(this.context);
        this.crashMarker = new CrashlyticsFileMarker("crash_marker", (FileStore)localObject2);
        this.initializationMarker = new CrashlyticsFileMarker("initialization_marker", (FileStore)localObject2);
        localObject3 = new HttpRequestFactory();
        localObject1 = AppData.create(this.context, this.idManager, (String)localObject4, (String)localObject1);
        localObject4 = new ResourceUnityVersionProvider(this.context);
        Logger localLogger = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Installer package name is: ");
        localStringBuilder.append(((AppData)localObject1).installerPackageName);
        localLogger.d(localStringBuilder.toString());
        this.controller = new CrashlyticsController(this.context, this.backgroundWorker, (HttpRequestFactory)localObject3, this.idManager, this.dataCollectionArbiter, (FileStore)localObject2, this.crashMarker, (AppData)localObject1, null, null, this.nativeComponent, (UnityVersionProvider)localObject4, this.analyticsEventLogger, paramSettingsDataProvider);
        boolean bool = didPreviousInitializationFail();
        checkForPreviousCrash();
        this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), paramSettingsDataProvider);
        if ((bool) && (CommonUtils.canTryConnection(this.context)))
        {
          Logger.getLogger().d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
          finishInitSynchronously(paramSettingsDataProvider);
          return false;
        }
        Logger.getLogger().d("Exception handling initialization successful");
        return true;
      }
      catch (Exception paramSettingsDataProvider)
      {
        Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", paramSettingsDataProvider);
        this.controller = null;
        return false;
      }
    }
    throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
  }
  
  public Task<Void> sendUnsentReports()
  {
    return this.controller.sendUnsentReports();
  }
  
  public void setCrashlyticsCollectionEnabled(Boolean paramBoolean)
  {
    this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(paramBoolean);
  }
  
  public void setCustomKey(String paramString1, String paramString2)
  {
    this.controller.setCustomKey(paramString1, paramString2);
  }
  
  public void setUserId(String paramString)
  {
    this.controller.setUserId(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */