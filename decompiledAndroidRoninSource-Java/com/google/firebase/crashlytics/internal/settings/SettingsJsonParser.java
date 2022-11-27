package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsJsonParser
{
  private final CurrentTimeProvider currentTimeProvider;
  
  SettingsJsonParser(CurrentTimeProvider paramCurrentTimeProvider)
  {
    this.currentTimeProvider = paramCurrentTimeProvider;
  }
  
  private static SettingsJsonTransform getJsonTransformForVersion(int paramInt)
  {
    if (paramInt != 3) {
      return new DefaultSettingsJsonTransform();
    }
    return new SettingsV3JsonTransform();
  }
  
  public SettingsData parseSettingsJson(JSONObject paramJSONObject)
    throws JSONException
  {
    return getJsonTransformForVersion(paramJSONObject.getInt("settings_version")).buildFromJson(this.currentTimeProvider, paramJSONObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsJsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */