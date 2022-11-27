package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.NativeSessionReport;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReportManager
{
  private final ReportUploader.ReportFilesProvider reportFilesProvider;
  
  public ReportManager(ReportUploader.ReportFilesProvider paramReportFilesProvider)
  {
    this.reportFilesProvider = paramReportFilesProvider;
  }
  
  public boolean areReportsAvailable()
  {
    File[] arrayOfFile1 = this.reportFilesProvider.getCompleteSessionFiles();
    File[] arrayOfFile2 = this.reportFilesProvider.getNativeReportFiles();
    if ((arrayOfFile1 != null) && (arrayOfFile1.length > 0)) {
      return true;
    }
    return (arrayOfFile2 != null) && (arrayOfFile2.length > 0);
  }
  
  public void deleteReport(Report paramReport)
  {
    paramReport.remove();
  }
  
  public void deleteReports(List<Report> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      deleteReport((Report)paramList.next());
    }
  }
  
  public List<Report> findReports()
  {
    Logger.getLogger().d("Checking for crash reports...");
    File[] arrayOfFile1 = this.reportFilesProvider.getCompleteSessionFiles();
    File[] arrayOfFile2 = this.reportFilesProvider.getNativeReportFiles();
    LinkedList localLinkedList = new LinkedList();
    int j = 0;
    int k;
    int i;
    if (arrayOfFile1 != null)
    {
      k = arrayOfFile1.length;
      i = 0;
      while (i < k)
      {
        File localFile = arrayOfFile1[i];
        Logger localLogger = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Found crash report ");
        localStringBuilder.append(localFile.getPath());
        localLogger.d(localStringBuilder.toString());
        localLinkedList.add(new SessionReport(localFile));
        i += 1;
      }
    }
    if (arrayOfFile2 != null)
    {
      k = arrayOfFile2.length;
      i = j;
      while (i < k)
      {
        localLinkedList.add(new NativeSessionReport(arrayOfFile2[i]));
        i += 1;
      }
    }
    if (localLinkedList.isEmpty()) {
      Logger.getLogger().d("No reports found.");
    }
    return localLinkedList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\ReportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */