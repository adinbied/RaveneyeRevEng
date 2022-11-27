package dji.log;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ExecutorService;

class DJILogFileManager
{
  private static final String TAG = "DJILogFileManager";
  private DJILogFileConfig config;
  private ExecutorService pool;
  
  private String encrypt(String paramString)
  {
    return null;
  }
  
  private void executeJob(Runnable paramRunnable)
  {
    ExecutorService localExecutorService = this.pool;
    if (localExecutorService != null) {
      localExecutorService.execute(paramRunnable);
    }
  }
  
  /* Error */
  private void executeTransactionJob(List<DJILogEntry> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private String generateLogMsg(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    return null;
  }
  
  private String getHeader(String paramString)
  {
    return null;
  }
  
  /* Error */
  private void writeLog2File(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  String generateFileName()
  {
    return null;
  }
  
  protected String getCachePath()
  {
    return null;
  }
  
  protected String getCachePath(String paramString)
  {
    return null;
  }
  
  String getExtraPath(String paramString)
  {
    return null;
  }
  
  protected String getRootDirectory()
  {
    return this.config.LOG_PATH_ROOT;
  }
  
  public void init(Context paramContext, DJILogFileConfig paramDJILogFileConfig)
  {
    DJILogFileConfig localDJILogFileConfig = paramDJILogFileConfig;
    if (paramDJILogFileConfig == null) {
      localDJILogFileConfig = new DJILogFileConfig.Builder(paramContext).build();
    }
    this.config = localDJILogFileConfig;
    this.pool = localDJILogFileConfig.service;
  }
  
  protected boolean isOpen()
  {
    return this.config.open;
  }
  
  void saveLog(List<DJILogEntry> paramList)
  {
    executeTransactionJob(paramList);
  }
  
  private class TransactionJob
    implements Runnable
  {
    final List<DJILogEntry> logCaches;
    
    public TransactionJob()
    {
      List localList;
      this.logCaches = localList;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */