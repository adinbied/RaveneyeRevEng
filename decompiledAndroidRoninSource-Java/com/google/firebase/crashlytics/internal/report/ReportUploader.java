package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.Report.Type;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReportUploader
{
  private static final short[] RETRY_INTERVALS = { 10, 20, 30, 60, 120, 300 };
  private final CreateReportSpiCall createReportCall;
  private final DataTransportState dataTransportState;
  private final String googleAppId;
  private final HandlingExceptionCheck handlingExceptionCheck;
  private final String organizationId;
  private final ReportManager reportManager;
  private Thread uploadThread;
  
  public ReportUploader(String paramString1, String paramString2, DataTransportState paramDataTransportState, ReportManager paramReportManager, CreateReportSpiCall paramCreateReportSpiCall, HandlingExceptionCheck paramHandlingExceptionCheck)
  {
    if (paramCreateReportSpiCall != null)
    {
      this.createReportCall = paramCreateReportSpiCall;
      this.organizationId = paramString1;
      this.googleAppId = paramString2;
      this.dataTransportState = paramDataTransportState;
      this.reportManager = paramReportManager;
      this.handlingExceptionCheck = paramHandlingExceptionCheck;
      return;
    }
    throw new IllegalArgumentException("createReportCall must not be null.");
  }
  
  boolean isUploading()
  {
    return this.uploadThread != null;
  }
  
  public boolean uploadReport(Report paramReport, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = new CreateReportRequest(this.organizationId, this.googleAppId, paramReport);
        if (this.dataTransportState == DataTransportState.ALL)
        {
          Logger.getLogger().d("Send to Reports Endpoint disabled. Removing Reports Endpoint report.");
          break label201;
        }
        if ((this.dataTransportState == DataTransportState.JAVA_ONLY) && (paramReport.getType() == Report.Type.JAVA))
        {
          Logger.getLogger().d("Send to Reports Endpoint for non-native reports disabled. Removing Reports Uploader report.");
          break label201;
        }
        paramBoolean = this.createReportCall.invoke((CreateReportRequest)localObject, paramBoolean);
        localLogger = Logger.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Crashlytics Reports Endpoint upload ");
        if (!paramBoolean) {
          break label206;
        }
        localObject = "complete: ";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramReport.getIdentifier());
        localLogger.i(localStringBuilder.toString());
        if (paramBoolean)
        {
          this.reportManager.deleteReport(paramReport);
          return true;
        }
      }
      catch (Exception localException)
      {
        Logger localLogger = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error occurred sending report ");
        localStringBuilder.append(paramReport);
        localLogger.e(localStringBuilder.toString(), localException);
      }
      return false;
      label201:
      paramBoolean = true;
      continue;
      label206:
      String str = "FAILED: ";
    }
  }
  
  public void uploadReportsAsync(List<Report> paramList, boolean paramBoolean, float paramFloat)
  {
    try
    {
      if (this.uploadThread != null)
      {
        Logger.getLogger().d("Report upload has already been started.");
        return;
      }
      paramList = new Thread(new Worker(paramList, paramBoolean, paramFloat), "Crashlytics Report Uploader");
      this.uploadThread = paramList;
      paramList.start();
      return;
    }
    finally {}
  }
  
  public static abstract interface HandlingExceptionCheck
  {
    public abstract boolean isHandlingException();
  }
  
  public static abstract interface Provider
  {
    public abstract ReportUploader createReportUploader(AppSettingsData paramAppSettingsData);
  }
  
  public static abstract interface ReportFilesProvider
  {
    public abstract File[] getCompleteSessionFiles();
    
    public abstract File[] getNativeReportFiles();
  }
  
  private class Worker
    extends BackgroundPriorityRunnable
  {
    private final boolean dataCollectionToken;
    private final float delay;
    private final List<Report> reports;
    
    Worker(boolean paramBoolean, float paramFloat)
    {
      this.reports = paramBoolean;
      this.dataCollectionToken = paramFloat;
      Object localObject;
      this.delay = localObject;
    }
    
    private void attemptUploadWithRetry(List<Report> paramList, boolean paramBoolean)
    {
      Object localObject1 = Logger.getLogger();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Starting report processing in ");
      ((StringBuilder)localObject2).append(this.delay);
      ((StringBuilder)localObject2).append(" second(s)...");
      ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
      float f = this.delay;
      long l;
      if (f > 0.0F) {
        l = (f * 1000.0F);
      }
      try
      {
        Thread.sleep(l);
      }
      catch (InterruptedException paramList)
      {
        int i;
        int j;
        for (;;) {}
      }
      Thread.currentThread().interrupt();
      return;
      if (ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
        return;
      }
      for (i = 0; paramList.size() > 0; i = j)
      {
        if (ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
          return;
        }
        localObject1 = Logger.getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Attempting to send ");
        ((StringBuilder)localObject2).append(paramList.size());
        ((StringBuilder)localObject2).append(" report(s)");
        ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Report)paramList.next();
          if (!ReportUploader.this.uploadReport((Report)localObject2, paramBoolean)) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        j = i;
        if (((List)localObject1).size() > 0)
        {
          l = ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
          paramList = Logger.getLogger();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Report submission: scheduling delayed retry in ");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" seconds");
          paramList.d(((StringBuilder)localObject2).toString());
        }
        try
        {
          Thread.sleep(l * 1000L);
          j = i + 1;
        }
        catch (InterruptedException paramList)
        {
          for (;;) {}
        }
        Thread.currentThread().interrupt();
        return;
        paramList = (List<Report>)localObject1;
      }
    }
    
    public void onRun()
    {
      try
      {
        attemptUploadWithRetry(this.reports, this.dataCollectionToken);
      }
      catch (Exception localException)
      {
        Logger.getLogger().e("An unexpected error occurred while attempting to upload crash reports.", localException);
      }
      ReportUploader.access$002(ReportUploader.this, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\ReportUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */