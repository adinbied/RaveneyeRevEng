package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import java.io.IOException;

abstract class AbstractAppSpiCall
  extends AbstractSpiCall
  implements AppSpiCall
{
  public static final String APP_BUILD_VERSION_PARAM = "app[build_version]";
  public static final String APP_BUILT_SDK_VERSION_PARAM = "app[built_sdk_version]";
  public static final String APP_DISPLAY_VERSION_PARAM = "app[display_version]";
  public static final String APP_IDENTIFIER_PARAM = "app[identifier]";
  public static final String APP_INSTANCE_IDENTIFIER_PARAM = "app[instance_identifier]";
  public static final String APP_MIN_SDK_VERSION_PARAM = "app[minimum_sdk_version]";
  public static final String APP_NAME_PARAM = "app[name]";
  public static final String APP_SOURCE_PARAM = "app[source]";
  public static final String ORGANIZATION_ID_PARAM = "org_id";
  private final String version;
  
  public AbstractAppSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod, String paramString3)
  {
    super(paramString1, paramString2, paramHttpRequestFactory, paramHttpMethod);
    this.version = paramString3;
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, AppRequestData paramAppRequestData)
  {
    return paramHttpRequest.header("X-CRASHLYTICS-ORG-ID", paramAppRequestData.organizationId).header("X-CRASHLYTICS-GOOGLE-APP-ID", paramAppRequestData.googleAppId).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.version);
  }
  
  private HttpRequest applyMultipartDataTo(HttpRequest paramHttpRequest, AppRequestData paramAppRequestData)
  {
    paramHttpRequest = paramHttpRequest.part("org_id", paramAppRequestData.organizationId).part("app[identifier]", paramAppRequestData.appId).part("app[name]", paramAppRequestData.name).part("app[display_version]", paramAppRequestData.displayVersion).part("app[build_version]", paramAppRequestData.buildVersion).part("app[source]", Integer.toString(paramAppRequestData.source)).part("app[minimum_sdk_version]", paramAppRequestData.minSdkVersion).part("app[built_sdk_version]", paramAppRequestData.builtSdkVersion);
    if (!CommonUtils.isNullOrEmpty(paramAppRequestData.instanceIdentifier)) {
      paramHttpRequest.part("app[instance_identifier]", paramAppRequestData.instanceIdentifier);
    }
    return paramHttpRequest;
  }
  
  public boolean invoke(AppRequestData paramAppRequestData, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      paramAppRequestData = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), paramAppRequestData), paramAppRequestData);
      localObject1 = Logger.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Sending app info to ");
      ((StringBuilder)localObject2).append(getUrl());
      ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = paramAppRequestData.execute();
        int i = ((HttpResponse)localObject1).code();
        if (!"POST".equalsIgnoreCase(paramAppRequestData.method())) {
          break label222;
        }
        paramAppRequestData = "Create";
        localObject2 = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppRequestData);
        localStringBuilder.append(" app request ID: ");
        localStringBuilder.append(((HttpResponse)localObject1).header("X-REQUEST-ID"));
        ((Logger)localObject2).d(localStringBuilder.toString());
        paramAppRequestData = Logger.getLogger();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Result was ");
        ((StringBuilder)localObject1).append(i);
        paramAppRequestData.d(((StringBuilder)localObject1).toString());
        i = ResponseParser.parse(i);
        return i == 0;
      }
      catch (IOException paramAppRequestData)
      {
        Logger.getLogger().e("HTTP request failed.", paramAppRequestData);
        throw new RuntimeException(paramAppRequestData);
      }
      throw new RuntimeException("An invalid data collection token was used.");
      label222:
      paramAppRequestData = "Update";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\network\AbstractAppSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */