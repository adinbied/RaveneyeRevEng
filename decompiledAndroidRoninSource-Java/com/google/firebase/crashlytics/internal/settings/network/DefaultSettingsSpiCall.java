package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DefaultSettingsSpiCall
  extends AbstractSpiCall
  implements SettingsSpiCall
{
  static final String BUILD_VERSION_PARAM = "build_version";
  static final String DISPLAY_VERSION_PARAM = "display_version";
  static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
  static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
  static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
  static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
  static final String INSTANCE_PARAM = "instance";
  static final String SOURCE_PARAM = "source";
  private Logger logger;
  
  public DefaultSettingsSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory)
  {
    this(paramString1, paramString2, paramHttpRequestFactory, HttpMethod.GET, Logger.getLogger());
  }
  
  DefaultSettingsSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod, Logger paramLogger)
  {
    super(paramString1, paramString2, paramHttpRequestFactory, paramHttpMethod);
    this.logger = paramLogger;
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, SettingsRequest paramSettingsRequest)
  {
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", paramSettingsRequest.googleAppId);
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getVersion());
    applyNonNullHeader(paramHttpRequest, "Accept", "application/json");
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-DEVICE-MODEL", paramSettingsRequest.deviceModel);
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", paramSettingsRequest.osBuildVersion);
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", paramSettingsRequest.osDisplayVersion);
    applyNonNullHeader(paramHttpRequest, "X-CRASHLYTICS-INSTALLATION-ID", paramSettingsRequest.installIdProvider.getCrashlyticsInstallId());
    return paramHttpRequest;
  }
  
  private void applyNonNullHeader(HttpRequest paramHttpRequest, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramHttpRequest.header(paramString1, paramString2);
    }
  }
  
  private JSONObject getJsonObjectFrom(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Object localObject = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to parse settings JSON from ");
      localStringBuilder.append(getUrl());
      ((Logger)localObject).d(localStringBuilder.toString(), localException);
      Logger localLogger = this.logger;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Settings response ");
      ((StringBuilder)localObject).append(paramString);
      localLogger.d(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private Map<String, String> getQueryParamsFor(SettingsRequest paramSettingsRequest)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", paramSettingsRequest.buildVersion);
    localHashMap.put("display_version", paramSettingsRequest.displayVersion);
    localHashMap.put("source", Integer.toString(paramSettingsRequest.source));
    paramSettingsRequest = paramSettingsRequest.instanceId;
    if (!CommonUtils.isNullOrEmpty(paramSettingsRequest)) {
      localHashMap.put("instance", paramSettingsRequest);
    }
    return localHashMap;
  }
  
  JSONObject handleResponse(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.code();
    Object localObject = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Settings result was: ");
    localStringBuilder.append(i);
    ((Logger)localObject).d(localStringBuilder.toString());
    if (requestWasSuccessful(i)) {
      return getJsonObjectFrom(paramHttpResponse.body());
    }
    paramHttpResponse = this.logger;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to retrieve settings from ");
    ((StringBuilder)localObject).append(getUrl());
    paramHttpResponse.e(((StringBuilder)localObject).toString());
    return null;
  }
  
  public JSONObject invoke(SettingsRequest paramSettingsRequest, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        Object localObject1 = getQueryParamsFor(paramSettingsRequest);
        paramSettingsRequest = applyHeadersTo(getHttpRequest((Map)localObject1), paramSettingsRequest);
        Object localObject2 = this.logger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Requesting settings from ");
        localStringBuilder.append(getUrl());
        ((Logger)localObject2).d(localStringBuilder.toString());
        localObject2 = this.logger;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Settings query params were: ");
        localStringBuilder.append(localObject1);
        ((Logger)localObject2).d(localStringBuilder.toString());
        paramSettingsRequest = paramSettingsRequest.execute();
        localObject1 = this.logger;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Settings request ID: ");
        ((StringBuilder)localObject2).append(paramSettingsRequest.header("X-REQUEST-ID"));
        ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
        paramSettingsRequest = handleResponse(paramSettingsRequest);
        return paramSettingsRequest;
      }
      catch (IOException paramSettingsRequest)
      {
        this.logger.e("Settings request failed.", paramSettingsRequest);
        return null;
      }
    }
    throw new RuntimeException("An invalid data collection token was used.");
  }
  
  boolean requestWasSuccessful(int paramInt)
  {
    return (paramInt == 200) || (paramInt == 201) || (paramInt == 202) || (paramInt == 203);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\network\DefaultSettingsSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */