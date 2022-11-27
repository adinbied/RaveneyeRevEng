package com.google.firebase.crashlytics.internal.report.model;

import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SessionReport
  implements Report
{
  private final Map<String, String> customHeaders;
  private final File file;
  private final File[] files;
  
  public SessionReport(File paramFile)
  {
    this(paramFile, Collections.emptyMap());
  }
  
  public SessionReport(File paramFile, Map<String, String> paramMap)
  {
    this.file = paramFile;
    this.files = new File[] { paramFile };
    this.customHeaders = new HashMap(paramMap);
  }
  
  public Map<String, String> getCustomHeaders()
  {
    return Collections.unmodifiableMap(this.customHeaders);
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public String getFileName()
  {
    return getFile().getName();
  }
  
  public File[] getFiles()
  {
    return this.files;
  }
  
  public String getIdentifier()
  {
    String str = getFileName();
    return str.substring(0, str.lastIndexOf('.'));
  }
  
  public Report.Type getType()
  {
    return Report.Type.JAVA;
  }
  
  public void remove()
  {
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Removing report at ");
    localStringBuilder.append(this.file.getPath());
    localLogger.d(localStringBuilder.toString());
    this.file.delete();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\model\SessionReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */