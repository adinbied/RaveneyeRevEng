package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;

public class NativeCreateReportSpiCall
  extends AbstractSpiCall
  implements CreateReportSpiCall
{
  private static final String APP_META_FILE_MULTIPART_PARAM = "app_meta_file";
  private static final String BINARY_IMAGES_FILE_MULTIPART_PARAM = "binary_images_file";
  private static final String DEVICE_META_FILE_MULTIPART_PARAM = "device_meta_file";
  private static final String GZIP_FILE_CONTENT_TYPE = "application/octet-stream";
  private static final String KEYS_FILE_MULTIPART_PARAM = "keys_file";
  private static final String LOGS_FILE_MULTIPART_PARAM = "logs_file";
  private static final String METADATA_FILE_MULTIPART_PARAM = "crash_meta_file";
  private static final String MINIDUMP_FILE_MULTIPART_PARAM = "minidump_file";
  static final String ORGANIZATION_IDENTIFIER_PARAM = "org_id";
  private static final String OS_META_FILE_MULTIPART_PARAM = "os_meta_file";
  private static final String REPORT_IDENTIFIER_PARAM = "report_id";
  private static final String SESSION_META_FILE_MULTIPART_PARAM = "session_meta_file";
  private static final String USER_META_FILE_MULTIPART_PARAM = "user_meta_file";
  private final String version;
  
  public NativeCreateReportSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, String paramString3)
  {
    super(paramString1, paramString2, paramHttpRequestFactory, HttpMethod.POST);
    this.version = paramString3;
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Crashlytics Android SDK/");
    localStringBuilder.append(CrashlyticsCore.getVersion());
    paramHttpRequest.header("User-Agent", localStringBuilder.toString()).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.version).header("X-CRASHLYTICS-GOOGLE-APP-ID", paramString);
    return paramHttpRequest;
  }
  
  private HttpRequest applyMultipartDataTo(HttpRequest paramHttpRequest, String paramString, Report paramReport)
  {
    if (paramString != null) {
      paramHttpRequest.part("org_id", paramString);
    }
    paramHttpRequest.part("report_id", paramReport.getIdentifier());
    paramString = paramReport.getFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramReport = paramString[i];
      if (paramReport.getName().equals("minidump")) {
        paramHttpRequest.part("minidump_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("metadata")) {
        paramHttpRequest.part("crash_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("binaryImages")) {
        paramHttpRequest.part("binary_images_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("session")) {
        paramHttpRequest.part("session_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("app")) {
        paramHttpRequest.part("app_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("device")) {
        paramHttpRequest.part("device_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("os")) {
        paramHttpRequest.part("os_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("user")) {
        paramHttpRequest.part("user_meta_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("logs")) {
        paramHttpRequest.part("logs_file", paramReport.getName(), "application/octet-stream", paramReport);
      } else if (paramReport.getName().equals("keys")) {
        paramHttpRequest.part("keys_file", paramReport.getName(), "application/octet-stream", paramReport);
      }
      i += 1;
    }
    return paramHttpRequest;
  }
  
  public boolean invoke(CreateReportRequest paramCreateReportRequest, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCreateReportRequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), paramCreateReportRequest.googleAppId), paramCreateReportRequest.organizationId, paramCreateReportRequest.report);
      Object localObject = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sending report to: ");
      localStringBuilder.append(getUrl());
      ((Logger)localObject).d(localStringBuilder.toString());
      try
      {
        int i = paramCreateReportRequest.execute().code();
        paramCreateReportRequest = Logger.getLogger();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Result was: ");
        ((StringBuilder)localObject).append(i);
        paramCreateReportRequest.d(((StringBuilder)localObject).toString());
        i = ResponseParser.parse(i);
        return i == 0;
      }
      catch (IOException paramCreateReportRequest)
      {
        throw new RuntimeException(paramCreateReportRequest);
      }
    }
    throw new RuntimeException("An invalid data collection token was used.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\network\NativeCreateReportSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */