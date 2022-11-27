package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsJsonTransform
  implements SettingsJsonTransform
{
  private static AppSettingsData buildAppDataFrom(JSONObject paramJSONObject)
    throws JSONException
  {
    return new AppSettingsData(paramJSONObject.getString("status"), paramJSONObject.getString("url"), paramJSONObject.getString("reports_url"), paramJSONObject.getString("ndk_reports_url"), paramJSONObject.optBoolean("update_required", false));
  }
  
  private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject paramJSONObject)
  {
    return new FeaturesSettingsData(paramJSONObject.optBoolean("collect_reports", true));
  }
  
  private static SessionSettingsData buildSessionDataFrom(JSONObject paramJSONObject)
  {
    return new SessionSettingsData(paramJSONObject.optInt("max_custom_exception_events", 8), 4);
  }
  
  static Settings defaultSettings(CurrentTimeProvider paramCurrentTimeProvider)
  {
    JSONObject localJSONObject = new JSONObject();
    SessionSettingsData localSessionSettingsData = buildSessionDataFrom(localJSONObject);
    FeaturesSettingsData localFeaturesSettingsData = buildFeaturesSessionDataFrom(localJSONObject);
    return new SettingsData(getExpiresAtFrom(paramCurrentTimeProvider, 3600L, localJSONObject), null, localSessionSettingsData, localFeaturesSettingsData, 0, 3600);
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
    return new JSONObject().put("status", paramAppSettingsData.status).put("url", paramAppSettingsData.url).put("reports_url", paramAppSettingsData.reportsUrl).put("ndk_reports_url", paramAppSettingsData.ndkReportsUrl).put("update_required", paramAppSettingsData.updateRequired);
  }
  
  private JSONObject toFeaturesJson(FeaturesSettingsData paramFeaturesSettingsData)
    throws JSONException
  {
    return new JSONObject().put("collect_reports", paramFeaturesSettingsData.collectReports);
  }
  
  private JSONObject toSessionJson(SessionSettingsData paramSessionSettingsData)
    throws JSONException
  {
    return new JSONObject().put("max_custom_exception_events", paramSessionSettingsData.maxCustomExceptionEvents).put("max_complete_sessions_count", paramSessionSettingsData.maxCompleteSessionsCount);
  }
  
  public SettingsData buildFromJson(CurrentTimeProvider paramCurrentTimeProvider, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = paramJSONObject.optInt("settings_version", 0);
    int j = paramJSONObject.optInt("cache_duration", 3600);
    AppSettingsData localAppSettingsData = buildAppDataFrom(paramJSONObject.getJSONObject("app"));
    SessionSettingsData localSessionSettingsData = buildSessionDataFrom(paramJSONObject.getJSONObject("session"));
    FeaturesSettingsData localFeaturesSettingsData = buildFeaturesSessionDataFrom(paramJSONObject.getJSONObject("features"));
    return new SettingsData(getExpiresAtFrom(paramCurrentTimeProvider, j, paramJSONObject), localAppSettingsData, localSessionSettingsData, localFeaturesSettingsData, i, j);
  }
  
  public JSONObject toJson(SettingsData paramSettingsData)
    throws JSONException
  {
    return new JSONObject().put("expires_at", paramSettingsData.expiresAtMillis).put("cache_duration", paramSettingsData.cacheDuration).put("settings_version", paramSettingsData.settingsVersion).put("features", toFeaturesJson(paramSettingsData.featuresData)).put("app", toAppJson(paramSettingsData.appData)).put("session", toSessionJson(paramSettingsData.sessionData));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\DefaultSettingsJsonTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */