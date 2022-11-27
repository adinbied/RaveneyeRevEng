package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Set;

public class LogFileManager
{
  private static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
  private static final String LOGFILE_EXT = ".temp";
  private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
  static final int MAX_LOG_SIZE = 65536;
  private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore(null);
  private final Context context;
  private FileLogStore currentLog;
  private final DirectoryProvider directoryProvider;
  
  public LogFileManager(Context paramContext, DirectoryProvider paramDirectoryProvider)
  {
    this(paramContext, paramDirectoryProvider, null);
  }
  
  public LogFileManager(Context paramContext, DirectoryProvider paramDirectoryProvider, String paramString)
  {
    this.context = paramContext;
    this.directoryProvider = paramDirectoryProvider;
    this.currentLog = NOOP_LOG_STORE;
    setCurrentSession(paramString);
  }
  
  private String getSessionIdForFile(File paramFile)
  {
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf(".temp");
    if (i == -1) {
      return paramFile;
    }
    return paramFile.substring(20, i);
  }
  
  private File getWorkingFileForSession(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("crashlytics-userlog-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".temp");
    paramString = localStringBuilder.toString();
    return new File(this.directoryProvider.getLogFileDir(), paramString);
  }
  
  public void clearLog()
  {
    this.currentLog.deleteLogFile();
  }
  
  public void discardOldLogFiles(Set<String> paramSet)
  {
    File[] arrayOfFile = this.directoryProvider.getLogFileDir().listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (!paramSet.contains(getSessionIdForFile(localFile))) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public byte[] getBytesForLog()
  {
    return this.currentLog.getLogAsBytes();
  }
  
  public String getLogString()
  {
    return this.currentLog.getLogAsString();
  }
  
  public final void setCurrentSession(String paramString)
  {
    this.currentLog.closeLogFile();
    this.currentLog = NOOP_LOG_STORE;
    if (paramString == null) {
      return;
    }
    if (!CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.CollectCustomLogs", true))
    {
      Logger.getLogger().d("Preferences requested no custom logs. Aborting log file creation.");
      return;
    }
    setLogFile(getWorkingFileForSession(paramString), 65536);
  }
  
  void setLogFile(File paramFile, int paramInt)
  {
    this.currentLog = new QueueFileLogStore(paramFile, paramInt);
  }
  
  public void writeToLog(long paramLong, String paramString)
  {
    this.currentLog.writeToLog(paramLong, paramString);
  }
  
  public static abstract interface DirectoryProvider
  {
    public abstract File getLogFileDir();
  }
  
  private static final class NoopLogStore
    implements FileLogStore
  {
    public void closeLogFile() {}
    
    public void deleteLogFile() {}
    
    public byte[] getLogAsBytes()
    {
      return null;
    }
    
    public String getLogAsString()
    {
      return null;
    }
    
    public void writeToLog(long paramLong, String paramString) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\log\LogFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */