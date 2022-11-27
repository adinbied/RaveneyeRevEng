package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultCreateReportSpiCall
  extends AbstractSpiCall
  implements CreateReportSpiCall
{
  static final String FILE_CONTENT_TYPE = "application/octet-stream";
  static final String FILE_PARAM = "report[file]";
  static final String IDENTIFIER_PARAM = "report[identifier]";
  static final String MULTI_FILE_PARAM = "report[file";
  private final String version;
  
  DefaultCreateReportSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, HttpMethod paramHttpMethod, String paramString3)
  {
    super(paramString1, paramString2, paramHttpRequestFactory, paramHttpMethod);
    this.version = paramString3;
  }
  
  public DefaultCreateReportSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, String paramString3)
  {
    this(paramString1, paramString2, paramHttpRequestFactory, HttpMethod.POST, paramString3);
  }
  
  private HttpRequest applyHeadersTo(HttpRequest paramHttpRequest, CreateReportRequest paramCreateReportRequest)
  {
    paramHttpRequest = paramHttpRequest.header("X-CRASHLYTICS-GOOGLE-APP-ID", paramCreateReportRequest.googleAppId).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.version);
    paramCreateReportRequest = paramCreateReportRequest.report.getCustomHeaders().entrySet().iterator();
    while (paramCreateReportRequest.hasNext()) {
      paramHttpRequest = paramHttpRequest.header((Map.Entry)paramCreateReportRequest.next());
    }
    return paramHttpRequest;
  }
  
  private HttpRequest applyMultipartDataTo(HttpRequest paramHttpRequest, Report paramReport)
  {
    paramHttpRequest = paramHttpRequest.part("report[identifier]", paramReport.getIdentifier());
    StringBuilder localStringBuilder1;
    if (paramReport.getFiles().length == 1)
    {
      localObject1 = Logger.getLogger();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Adding single file ");
      localStringBuilder1.append(paramReport.getFileName());
      localStringBuilder1.append(" to report ");
      localStringBuilder1.append(paramReport.getIdentifier());
      ((Logger)localObject1).d(localStringBuilder1.toString());
      return paramHttpRequest.part("report[file]", paramReport.getFileName(), "application/octet-stream", paramReport.getFile());
    }
    Object localObject1 = paramReport.getFiles();
    int k = localObject1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localStringBuilder1 = localObject1[i];
      Object localObject2 = Logger.getLogger();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Adding file ");
      localStringBuilder2.append(localStringBuilder1.getName());
      localStringBuilder2.append(" to report ");
      localStringBuilder2.append(paramReport.getIdentifier());
      ((Logger)localObject2).d(localStringBuilder2.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report[file");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("]");
      paramHttpRequest = paramHttpRequest.part(((StringBuilder)localObject2).toString(), localStringBuilder1.getName(), "application/octet-stream", localStringBuilder1);
      j += 1;
      i += 1;
    }
    return paramHttpRequest;
  }
  
  public boolean invoke(CreateReportRequest paramCreateReportRequest, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCreateReportRequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), paramCreateReportRequest), paramCreateReportRequest.report);
      Object localObject = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sending report to: ");
      localStringBuilder.append(getUrl());
      ((Logger)localObject).d(localStringBuilder.toString());
      try
      {
        paramCreateReportRequest = paramCreateReportRequest.execute();
        int i = paramCreateReportRequest.code();
        localObject = Logger.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Create report request ID: ");
        localStringBuilder.append(paramCreateReportRequest.header("X-REQUEST-ID"));
        ((Logger)localObject).d(localStringBuilder.toString());
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
        Logger.getLogger().e("Create report HTTP request failed.", paramCreateReportRequest);
        throw new RuntimeException(paramCreateReportRequest);
      }
    }
    throw new RuntimeException("An invalid data collection token was used.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\network\DefaultCreateReportSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */