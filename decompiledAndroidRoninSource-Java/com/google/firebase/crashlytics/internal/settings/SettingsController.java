package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsController
  implements SettingsDataProvider
{
  private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
  private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
  private final AtomicReference<TaskCompletionSource<AppSettingsData>> appSettingsData = new AtomicReference(new TaskCompletionSource());
  private final CachedSettingsIo cachedSettingsIo;
  private final Context context;
  private final CurrentTimeProvider currentTimeProvider;
  private final DataCollectionArbiter dataCollectionArbiter;
  private final AtomicReference<Settings> settings = new AtomicReference();
  private final SettingsJsonParser settingsJsonParser;
  private final SettingsRequest settingsRequest;
  private final SettingsSpiCall settingsSpiCall;
  
  SettingsController(Context paramContext, SettingsRequest paramSettingsRequest, CurrentTimeProvider paramCurrentTimeProvider, SettingsJsonParser paramSettingsJsonParser, CachedSettingsIo paramCachedSettingsIo, SettingsSpiCall paramSettingsSpiCall, DataCollectionArbiter paramDataCollectionArbiter)
  {
    this.context = paramContext;
    this.settingsRequest = paramSettingsRequest;
    this.currentTimeProvider = paramCurrentTimeProvider;
    this.settingsJsonParser = paramSettingsJsonParser;
    this.cachedSettingsIo = paramCachedSettingsIo;
    this.settingsSpiCall = paramSettingsSpiCall;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    this.settings.set(DefaultSettingsJsonTransform.defaultSettings(paramCurrentTimeProvider));
  }
  
  public static SettingsController create(Context paramContext, String paramString1, IdManager paramIdManager, HttpRequestFactory paramHttpRequestFactory, String paramString2, String paramString3, String paramString4, DataCollectionArbiter paramDataCollectionArbiter)
  {
    String str = paramIdManager.getInstallerPackageName();
    SystemCurrentTimeProvider localSystemCurrentTimeProvider = new SystemCurrentTimeProvider();
    SettingsJsonParser localSettingsJsonParser = new SettingsJsonParser(localSystemCurrentTimeProvider);
    CachedSettingsIo localCachedSettingsIo = new CachedSettingsIo(paramContext);
    paramHttpRequestFactory = new DefaultSettingsSpiCall(paramString4, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", new Object[] { paramString1 }), paramHttpRequestFactory);
    return new SettingsController(paramContext, new SettingsRequest(paramString1, paramIdManager.getModelName(), paramIdManager.getOsBuildVersionString(), paramIdManager.getOsDisplayVersionString(), paramIdManager, CommonUtils.createInstanceIdFrom(new String[] { CommonUtils.getMappingFileId(paramContext), paramString1, paramString3, paramString2 }), paramString3, paramString2, DeliveryMechanism.determineFrom(str).getId()), localSystemCurrentTimeProvider, localSettingsJsonParser, localCachedSettingsIo, paramHttpRequestFactory, paramDataCollectionArbiter);
  }
  
  private SettingsData getCachedSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(paramSettingsCacheBehavior))
      {
        JSONObject localJSONObject = this.cachedSettingsIo.readCachedSettings();
        if (localJSONObject != null)
        {
          localObject1 = this.settingsJsonParser.parseSettingsJson(localJSONObject);
          if (localObject1 != null)
          {
            logSettings(localJSONObject, "Loaded cached settings: ");
            long l = this.currentTimeProvider.getCurrentTimeMillis();
            if ((!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(paramSettingsCacheBehavior)) && (((SettingsData)localObject1).isExpired(l)))
            {
              Logger.getLogger().d("Cached settings have expired.");
              return null;
            }
            try
            {
              Logger.getLogger().d("Returning cached settings.");
              return (SettingsData)localObject1;
            }
            catch (Exception localException2)
            {
              paramSettingsCacheBehavior = (SettingsCacheBehavior)localObject1;
              localObject1 = localException2;
            }
          }
          else
          {
            Logger.getLogger().e("Failed to parse cached settings data.", null);
            return null;
          }
        }
        else
        {
          Logger.getLogger().d("No cached settings data found.");
          return null;
        }
      }
    }
    catch (Exception localException1)
    {
      paramSettingsCacheBehavior = localException2;
      Logger.getLogger().e("Failed to get cached settings", localException1);
      SettingsCacheBehavior localSettingsCacheBehavior = paramSettingsCacheBehavior;
      return localSettingsCacheBehavior;
    }
  }
  
  private String getStoredBuildInstanceIdentifier()
  {
    return CommonUtils.getSharedPrefs(this.context).getString("existing_instance_identifier", "");
  }
  
  private void logSettings(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramJSONObject.toString());
    localLogger.d(localStringBuilder.toString());
  }
  
  private boolean setStoredBuildInstanceIdentifier(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonUtils.getSharedPrefs(this.context).edit();
    localEditor.putString("existing_instance_identifier", paramString);
    localEditor.apply();
    return true;
  }
  
  boolean buildInstanceIdentifierChanged()
  {
    return getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId) ^ true;
  }
  
  public Task<AppSettingsData> getAppSettings()
  {
    return ((TaskCompletionSource)this.appSettingsData.get()).getTask();
  }
  
  public Settings getSettings()
  {
    return (Settings)this.settings.get();
  }
  
  public Task<Void> loadSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior, Executor paramExecutor)
  {
    if (!buildInstanceIdentifierChanged())
    {
      paramSettingsCacheBehavior = getCachedSettingsData(paramSettingsCacheBehavior);
      if (paramSettingsCacheBehavior != null)
      {
        this.settings.set(paramSettingsCacheBehavior);
        ((TaskCompletionSource)this.appSettingsData.get()).trySetResult(paramSettingsCacheBehavior.getAppSettingsData());
        return Tasks.forResult(null);
      }
    }
    paramSettingsCacheBehavior = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
    if (paramSettingsCacheBehavior != null)
    {
      this.settings.set(paramSettingsCacheBehavior);
      ((TaskCompletionSource)this.appSettingsData.get()).trySetResult(paramSettingsCacheBehavior.getAppSettingsData());
    }
    this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(paramExecutor, new SuccessContinuation()
    {
      public Task<Void> then(Void paramAnonymousVoid)
        throws Exception
      {
        Object localObject = SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
        if (localObject != null)
        {
          paramAnonymousVoid = SettingsController.this.settingsJsonParser.parseSettingsJson((JSONObject)localObject);
          SettingsController.this.cachedSettingsIo.writeCachedSettings(paramAnonymousVoid.getExpiresAtMillis(), (JSONObject)localObject);
          SettingsController.this.logSettings((JSONObject)localObject, "Loaded settings: ");
          localObject = SettingsController.this;
          ((SettingsController)localObject).setStoredBuildInstanceIdentifier(((SettingsController)localObject).settingsRequest.instanceId);
          SettingsController.this.settings.set(paramAnonymousVoid);
          ((TaskCompletionSource)SettingsController.this.appSettingsData.get()).trySetResult(paramAnonymousVoid.getAppSettingsData());
          localObject = new TaskCompletionSource();
          ((TaskCompletionSource)localObject).trySetResult(paramAnonymousVoid.getAppSettingsData());
          SettingsController.this.appSettingsData.set(localObject);
        }
        return Tasks.forResult(null);
      }
    });
  }
  
  public Task<Void> loadSettingsData(Executor paramExecutor)
  {
    return loadSettingsData(SettingsCacheBehavior.USE_CACHE, paramExecutor);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */