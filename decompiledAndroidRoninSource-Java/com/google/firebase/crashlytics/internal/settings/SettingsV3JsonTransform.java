package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class SettingsV3JsonTransform
  implements SettingsJsonTransform
{
  private static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
  private static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
  private static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
  private static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";
  
  private static AppSettingsData buildAppDataFrom(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
    throws JSONException
  {
    String str1 = paramJSONObject2.getString("status");
    boolean bool = "new".equals(str1);
    String str2 = paramJSONObject1.getString("bundle_id");
    String str3 = paramJSONObject1.getString("org_id");
    if (bool) {
      paramJSONObject1 = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    } else {
      paramJSONObject1 = String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", new Object[] { str2 });
    }
    return new AppSettingsData(str1, paramJSONObject1, String.format(Locale.US, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", new Object[] { str2 }), String.format(Locale.US, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", new Object[] { str2 }), str2, str3, paramJSONObject2.optBoolean("update_required", false), paramJSONObject2.optInt("report_upload_variant", 0), paramJSONObject2.optInt("native_report_upload_variant", 0));
  }
  
  private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject paramJSONObject)
  {
    return new FeaturesSettingsData(paramJSONObject.optBoolean("collect_reports", true));
  }
  
  private static SessionSettingsData defaultSessionData()
  {
    return new SessionSettingsData(8, 4);
  }
  
  private static long getExpiresAtFrom(CurrentTimeProvider paramCurrentTimeProvider, long paramLong, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("expires_at")) {
      return paramJSONObject.optLong("expires_at");
    }
    return paramCurrentTimeProvider.getCurrentTimeMillis() + paramLong * 1000L;
  }
  
  private JSONObject toAppJson(AppSettingsData paramAppSettingsData)
    throws JSONException
  {
    return new JSONObject().put("status", paramAppSettingsData.status).put("update_required", paramAppSettingsData.updateRequired).put("report_upload_variant", paramAppSettingsData.reportUploadVariant).put("native_report_upload_variant", paramAppSettingsData.nativeReportUploadVariant);
  }
  
  private JSONObject toFabricJson(AppSettingsData paramAppSettingsData)
    throws JSONException
  {
    return new JSONObject().put("bundle_id", paramAppSettingsData.bundleId).put("org_id", paramAppSettingsData.organizationId);
  }
  
  private JSONObject toFeaturesJson(FeaturesSettingsData paramFeaturesSettingsData)
    throws JSONException
  {
    return new JSONObject().put("collect_reports", paramFeaturesSettingsData.collectReports);
  }
  
  public SettingsData buildFromJson(CurrentTimeProvider paramCurrentTimeProvider, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = paramJSONObject.optInt("settings_version", 0);
    int j = paramJSONObject.optInt("cache_duration", 3600);
    AppSettingsData localAppSettingsData = buildAppDataFrom(paramJSONObject.getJSONObject("fabric"), paramJSONObject.getJSONObject("app"));
    SessionSettingsData localSessionSettingsData = defaultSessionData();
    FeaturesSettingsData localFeaturesSettingsData = buildFeaturesSessionDataFrom(paramJSONObject.getJSONObject("features"));
    return new SettingsData(getExpiresAtFrom(paramCurrentTimeProvider, j, paramJSONObject), localAppSettingsData, localSessionSettingsData, localFeaturesSettingsData, i, j);
  }
  
  public JSONObject toJson(SettingsData paramSettingsData)
    throws JSONException
  {
    return new JSONObject().put("expires_at", paramSettingsData.expiresAtMillis).put("cache_duration", paramSettingsData.cacheDuration).put("settings_version", paramSettingsData.settingsVersion).put("features", toFeaturesJson(paramSettingsData.featuresData)).put("app", toAppJson(paramSettingsData.appData)).put("fabric", toFabricJson(paramSettingsData.appData));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsV3JsonTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */