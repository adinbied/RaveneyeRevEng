package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.util.Map;

public class NativeSessionReport
  implements Report
{
  private final File reportDirectory;
  
  public NativeSessionReport(File paramFile)
  {
    this.reportDirectory = paramFile;
  }
  
  public Map<String, String> getCustomHeaders()
  {
    return null;
  }
  
  public File getFile()
  {
    return null;
  }
  
  public String getFileName()
  {
    return null;
  }
  
  public File[] getFiles()
  {
    return this.reportDirectory.listFiles();
  }
  
  public String getIdentifier()
  {
    return this.reportDirectory.getName();
  }
  
  public Report.Type getType()
  {
    return Report.Type.NATIVE;
  }
  
  public void remove()
  {
    Object localObject = getFiles();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder1 = localObject[i];
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Removing native report file at ");
      localStringBuilder2.append(localStringBuilder1.getPath());
      localLogger.d(localStringBuilder2.toString());
      localStringBuilder1.delete();
      i += 1;
    }
    localObject = Logger.getLogger();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Removing native report directory at ");
    localStringBuilder1.append(this.reportDirectory);
    ((Logger)localObject).d(localStringBuilder1.toString());
    this.reportDirectory.delete();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\model\NativeSessionReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */