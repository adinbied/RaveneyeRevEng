package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender
{
  private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
  private static final String CRASHLYTICS_ENDPOINT;
  private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
  private static final Transformer<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender..Lambda.2.lambdaFactory$();
  private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
  private final Transport<CrashlyticsReport> transport;
  private final Transformer<CrashlyticsReport, byte[]> transportTransform;
  
  static
  {
    CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
  }
  
  DataTransportCrashlyticsReportSender(Transport<CrashlyticsReport> paramTransport, Transformer<CrashlyticsReport, byte[]> paramTransformer)
  {
    this.transport = paramTransport;
    this.transportTransform = paramTransformer;
  }
  
  public static DataTransportCrashlyticsReportSender create(Context paramContext)
  {
    TransportRuntime.initialize(paramContext);
    return new DataTransportCrashlyticsReportSender(TransportRuntime.getInstance().newFactory(new CCTDestination(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY)).getTransport("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, Encoding.of("json"), DEFAULT_TRANSFORM), DEFAULT_TRANSFORM);
  }
  
  private static String mergeStrings(String paramString1, String paramString2)
  {
    int i = paramString1.length() - paramString2.length();
    if ((i >= 0) && (i <= 1))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1.length() + paramString2.length());
      i = 0;
      while (i < paramString1.length())
      {
        localStringBuilder.append(paramString1.charAt(i));
        if (paramString2.length() > i) {
          localStringBuilder.append(paramString2.charAt(i));
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Invalid input received");
  }
  
  public Task<CrashlyticsReportWithSessionId> sendReport(CrashlyticsReportWithSessionId paramCrashlyticsReportWithSessionId)
  {
    CrashlyticsReport localCrashlyticsReport = paramCrashlyticsReportWithSessionId.getReport();
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.transport.schedule(Event.ofUrgent(localCrashlyticsReport), DataTransportCrashlyticsReportSender..Lambda.1.lambdaFactory$(localTaskCompletionSource, paramCrashlyticsReportWithSessionId));
    return localTaskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\send\DataTransportCrashlyticsReportSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */