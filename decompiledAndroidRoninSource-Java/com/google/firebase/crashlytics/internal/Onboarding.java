package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.concurrent.Executor;

public class Onboarding
{
  static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
  private final FirebaseApp app;
  private String applicationLabel;
  private final Context context;
  private DataCollectionArbiter dataCollectionArbiter;
  private IdManager idManager;
  private String installerPackageName;
  private PackageInfo packageInfo;
  private PackageManager packageManager;
  private String packageName;
  private final HttpRequestFactory requestFactory = new HttpRequestFactory();
  private String targetAndroidSdkVersion;
  private String versionCode;
  private String versionName;
  
  public Onboarding(FirebaseApp paramFirebaseApp, Context paramContext, IdManager paramIdManager, DataCollectionArbiter paramDataCollectionArbiter)
  {
    this.app = paramFirebaseApp;
    this.context = paramContext;
    this.idManager = paramIdManager;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
  }
  
  private AppRequestData buildAppRequest(String paramString1, String paramString2)
  {
    String str = CommonUtils.createInstanceIdFrom(new String[] { CommonUtils.getMappingFileId(getContext()), paramString2, this.versionName, this.versionCode });
    int i = DeliveryMechanism.determineFrom(this.installerPackageName).getId();
    return new AppRequestData(paramString1, paramString2, getIdManager().getAppIdentifier(), this.versionName, this.versionCode, str, this.applicationLabel, i, this.targetAndroidSdkVersion, "0");
  }
  
  private IdManager getIdManager()
  {
    return this.idManager;
  }
  
  private static String getVersion()
  {
    return CrashlyticsCore.getVersion();
  }
  
  private void performAutoConfigure(AppSettingsData paramAppSettingsData, String paramString, SettingsController paramSettingsController, Executor paramExecutor, boolean paramBoolean)
  {
    if ("new".equals(paramAppSettingsData.status))
    {
      if (performCreateApp(paramAppSettingsData, paramString, paramBoolean))
      {
        paramSettingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, paramExecutor);
        return;
      }
      Logger.getLogger().e("Failed to create app with Crashlytics service.", null);
      return;
    }
    if ("configured".equals(paramAppSettingsData.status))
    {
      paramSettingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, paramExecutor);
      return;
    }
    if (paramAppSettingsData.updateRequired)
    {
      Logger.getLogger().d("Server says an update is required - forcing a full App update.");
      performUpdateApp(paramAppSettingsData, paramString, paramBoolean);
    }
  }
  
  private boolean performCreateApp(AppSettingsData paramAppSettingsData, String paramString, boolean paramBoolean)
  {
    paramString = buildAppRequest(paramAppSettingsData.organizationId, paramString);
    return new CreateAppSpiCall(getOverridenSpiEndpoint(), paramAppSettingsData.url, this.requestFactory, getVersion()).invoke(paramString, paramBoolean);
  }
  
  private boolean performUpdateApp(AppSettingsData paramAppSettingsData, String paramString, boolean paramBoolean)
  {
    paramString = buildAppRequest(paramAppSettingsData.organizationId, paramString);
    return new UpdateAppSpiCall(getOverridenSpiEndpoint(), paramAppSettingsData.url, this.requestFactory, getVersion()).invoke(paramString, paramBoolean);
  }
  
  public void doOnboarding(final Executor paramExecutor, final SettingsController paramSettingsController)
  {
    final String str = this.app.getOptions().getApplicationId();
    this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(paramExecutor, new SuccessContinuation()
    {
      public Task<AppSettingsData> then(Void paramAnonymousVoid)
        throws Exception
      {
        return paramSettingsController.getAppSettings();
      }
    }).onSuccessTask(paramExecutor, new SuccessContinuation()
    {
      public Task<Void> then(AppSettingsData paramAnonymousAppSettingsData)
        throws Exception
      {
        try
        {
          Onboarding.this.performAutoConfigure(paramAnonymousAppSettingsData, str, paramSettingsController, paramExecutor, true);
          return null;
        }
        catch (Exception paramAnonymousAppSettingsData)
        {
          Logger.getLogger().e("Error performing auto configuration.", paramAnonymousAppSettingsData);
          throw paramAnonymousAppSettingsData;
        }
      }
    });
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  String getOverridenSpiEndpoint()
  {
    return CommonUtils.getStringsFileValue(this.context, "com.crashlytics.ApiEndpoint");
  }
  
  public boolean onPreExecute()
  {
    try
    {
      this.installerPackageName = this.idManager.getInstallerPackageName();
      this.packageManager = this.context.getPackageManager();
      Object localObject = this.context.getPackageName();
      this.packageName = ((String)localObject);
      localObject = this.packageManager.getPackageInfo((String)localObject, 0);
      this.packageInfo = ((PackageInfo)localObject);
      this.versionCode = Integer.toString(((PackageInfo)localObject).versionCode);
      if (this.packageInfo.versionName == null) {
        localObject = "0.0";
      } else {
        localObject = this.packageInfo.versionName;
      }
      this.versionName = ((String)localObject);
      this.applicationLabel = this.packageManager.getApplicationLabel(this.context.getApplicationInfo()).toString();
      this.targetAndroidSdkVersion = Integer.toString(this.context.getApplicationInfo().targetSdkVersion);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Logger.getLogger().e("Failed init", localNameNotFoundException);
    }
    return false;
  }
  
  public SettingsController retrieveSettingsData(Context paramContext, FirebaseApp paramFirebaseApp, Executor paramExecutor)
  {
    paramContext = SettingsController.create(paramContext, paramFirebaseApp.getOptions().getApplicationId(), this.idManager, this.requestFactory, this.versionCode, this.versionName, getOverridenSpiEndpoint(), this.dataCollectionArbiter);
    paramContext.loadSettingsData(paramExecutor).continueWith(paramExecutor, new Continuation()
    {
      public Object then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        if (!paramAnonymousTask.isSuccessful()) {
          Logger.getLogger().e("Error fetching settings.", paramAnonymousTask.getException());
        }
        return null;
      }
    });
    return paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\Onboarding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */