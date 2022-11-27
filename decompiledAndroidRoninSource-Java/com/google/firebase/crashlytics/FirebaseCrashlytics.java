package com.google.firebase.crashlytics;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.Onboarding;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class FirebaseCrashlytics
{
  private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
  private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
  private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
  private final CrashlyticsCore core;
  
  private FirebaseCrashlytics(CrashlyticsCore paramCrashlyticsCore)
  {
    this.core = paramCrashlyticsCore;
  }
  
  public static FirebaseCrashlytics getInstance()
  {
    FirebaseCrashlytics localFirebaseCrashlytics = (FirebaseCrashlytics)FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
    if (localFirebaseCrashlytics != null) {
      return localFirebaseCrashlytics;
    }
    throw new NullPointerException("FirebaseCrashlytics component is not present.");
  }
  
  static FirebaseCrashlytics init(final FirebaseApp paramFirebaseApp, final FirebaseInstallationsApi paramFirebaseInstallationsApi, final CrashlyticsNativeComponent paramCrashlyticsNativeComponent, AnalyticsConnector paramAnalyticsConnector)
  {
    Context localContext = paramFirebaseApp.getApplicationContext();
    IdManager localIdManager = new IdManager(localContext, localContext.getPackageName(), paramFirebaseInstallationsApi);
    DataCollectionArbiter localDataCollectionArbiter = new DataCollectionArbiter(paramFirebaseApp);
    Object localObject;
    if (paramCrashlyticsNativeComponent == null) {
      localObject = new MissingNativeComponent();
    } else {
      localObject = paramCrashlyticsNativeComponent;
    }
    Onboarding localOnboarding = new Onboarding(paramFirebaseApp, localContext, localIdManager, localDataCollectionArbiter);
    if (paramAnalyticsConnector != null)
    {
      Logger.getLogger().d("Firebase Analytics is available.");
      paramCrashlyticsNativeComponent = new CrashlyticsOriginAnalyticsEventLogger(paramAnalyticsConnector);
      CrashlyticsAnalyticsListener localCrashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
      if (subscribeToAnalyticsEvents(paramAnalyticsConnector, localCrashlyticsAnalyticsListener) != null)
      {
        Logger.getLogger().d("Firebase Analytics listener registered successfully.");
        paramFirebaseInstallationsApi = new BreadcrumbAnalyticsEventReceiver();
        paramCrashlyticsNativeComponent = new BlockingAnalyticsEventLogger(paramCrashlyticsNativeComponent, 500, TimeUnit.MILLISECONDS);
        localCrashlyticsAnalyticsListener.setBreadcrumbEventReceiver(paramFirebaseInstallationsApi);
        localCrashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(paramCrashlyticsNativeComponent);
      }
      else
      {
        Logger.getLogger().d("Firebase Analytics listener registration failed.");
        paramFirebaseInstallationsApi = new DisabledBreadcrumbSource();
      }
    }
    else
    {
      Logger.getLogger().d("Firebase Analytics is unavailable.");
      paramFirebaseInstallationsApi = new DisabledBreadcrumbSource();
      paramCrashlyticsNativeComponent = new UnavailableAnalyticsEventLogger();
    }
    paramFirebaseInstallationsApi = new CrashlyticsCore(paramFirebaseApp, localIdManager, (CrashlyticsNativeComponent)localObject, localDataCollectionArbiter, paramFirebaseInstallationsApi, paramCrashlyticsNativeComponent, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
    if (!localOnboarding.onPreExecute())
    {
      Logger.getLogger().e("Unable to start Crashlytics.");
      return null;
    }
    paramCrashlyticsNativeComponent = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
    paramFirebaseApp = localOnboarding.retrieveSettingsData(localContext, paramFirebaseApp, paramCrashlyticsNativeComponent);
    Tasks.call(paramCrashlyticsNativeComponent, new Callable()
    {
      public Void call()
        throws Exception
      {
        FirebaseCrashlytics.this.doOnboarding(paramCrashlyticsNativeComponent, paramFirebaseApp);
        if (this.val$finishCoreInBackground) {
          paramFirebaseInstallationsApi.doBackgroundInitializationAsync(paramFirebaseApp);
        }
        return null;
      }
    });
    return new FirebaseCrashlytics(paramFirebaseInstallationsApi);
  }
  
  private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector paramAnalyticsConnector, CrashlyticsAnalyticsListener paramCrashlyticsAnalyticsListener)
  {
    AnalyticsConnector.AnalyticsConnectorHandle localAnalyticsConnectorHandle = paramAnalyticsConnector.registerAnalyticsConnectorListener("clx", paramCrashlyticsAnalyticsListener);
    Object localObject = localAnalyticsConnectorHandle;
    if (localAnalyticsConnectorHandle == null)
    {
      Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
      paramAnalyticsConnector = paramAnalyticsConnector.registerAnalyticsConnectorListener("crash", paramCrashlyticsAnalyticsListener);
      localObject = paramAnalyticsConnector;
      if (paramAnalyticsConnector != null)
      {
        Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        localObject = paramAnalyticsConnector;
      }
    }
    return (AnalyticsConnector.AnalyticsConnectorHandle)localObject;
  }
  
  public Task<Boolean> checkForUnsentReports()
  {
    return this.core.checkForUnsentReports();
  }
  
  public void deleteUnsentReports()
  {
    this.core.deleteUnsentReports();
  }
  
  public boolean didCrashOnPreviousExecution()
  {
    return this.core.didCrashOnPreviousExecution();
  }
  
  public void log(String paramString)
  {
    this.core.log(paramString);
  }
  
  public void recordException(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      Logger.getLogger().w("Crashlytics is ignoring a request to log a null exception.");
      return;
    }
    this.core.logException(paramThrowable);
  }
  
  public void sendUnsentReports()
  {
    this.core.sendUnsentReports();
  }
  
  public void setCrashlyticsCollectionEnabled(Boolean paramBoolean)
  {
    this.core.setCrashlyticsCollectionEnabled(paramBoolean);
  }
  
  public void setCrashlyticsCollectionEnabled(boolean paramBoolean)
  {
    this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(paramBoolean));
  }
  
  public void setCustomKey(String paramString, double paramDouble)
  {
    this.core.setCustomKey(paramString, Double.toString(paramDouble));
  }
  
  public void setCustomKey(String paramString, float paramFloat)
  {
    this.core.setCustomKey(paramString, Float.toString(paramFloat));
  }
  
  public void setCustomKey(String paramString, int paramInt)
  {
    this.core.setCustomKey(paramString, Integer.toString(paramInt));
  }
  
  public void setCustomKey(String paramString, long paramLong)
  {
    this.core.setCustomKey(paramString, Long.toString(paramLong));
  }
  
  public void setCustomKey(String paramString1, String paramString2)
  {
    this.core.setCustomKey(paramString1, paramString2);
  }
  
  public void setCustomKey(String paramString, boolean paramBoolean)
  {
    this.core.setCustomKey(paramString, Boolean.toString(paramBoolean));
  }
  
  public void setUserId(String paramString)
  {
    this.core.setUserId(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\FirebaseCrashlytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */