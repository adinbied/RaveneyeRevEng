package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractSpiCall
{
  public static final String ACCEPT_JSON_VALUE = "application/json";
  public static final String ANDROID_CLIENT_TYPE = "android";
  public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
  public static final String HEADER_ACCEPT = "Accept";
  public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
  public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
  public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
  public static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
  public static final String HEADER_ORG_ID = "X-CRASHLYTICS-ORG-ID";
  public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
  public static final String HEADER_USER_AGENT = "User-Agent";
  private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
  private final HttpMethod method;
  private final String protocolAndHostOverride;
  private final HttpRequestFactory requestFactory;
  private final String url;
  
  public AbstractSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod)
  {
    if (paramString2 != null)
    {
      if (paramHttpRequestFactory != null)
      {
        this.protocolAndHostOverride = paramString1;
        this.url = overrideProtocolAndHost(paramString2);
        this.requestFactory = paramHttpRequestFactory;
        this.method = paramHttpMethod;
        return;
      }
      throw new IllegalArgumentException("requestFactory must not be null.");
    }
    throw new IllegalArgumentException("url must not be null.");
  }
  
  private String overrideProtocolAndHost(String paramString)
  {
    String str = paramString;
    if (!CommonUtils.isNullOrEmpty(this.protocolAndHostOverride)) {
      str = PROTOCOL_AND_HOST_PATTERN.matcher(paramString).replaceFirst(this.protocolAndHostOverride);
    }
    return str;
  }
  
  protected HttpRequest getHttpRequest()
  {
    return getHttpRequest(Collections.emptyMap());
  }
  
  protected HttpRequest getHttpRequest(Map<String, String> paramMap)
  {
    paramMap = this.requestFactory.buildHttpRequest(this.method, getUrl(), paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Crashlytics Android SDK/");
    localStringBuilder.append(CrashlyticsCore.getVersion());
    return paramMap.header("User-Agent", localStringBuilder.toString()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }
  
  protected String getUrl()
  {
    return this.url;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\AbstractSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */