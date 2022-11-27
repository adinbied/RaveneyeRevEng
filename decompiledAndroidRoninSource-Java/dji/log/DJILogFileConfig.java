package dji.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import dji.log.impl.SimpleEncryption;
import dji.log.impl.SimpleFileFormat;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DJILogFileConfig
{
  String LINE_FEED;
  String LOG_FILE_PREFIX;
  String LOG_FILE_TYPE;
  String LOG_PATH_ROOT;
  String LOG_TIME_FORMAT;
  long SPACE_MARGINAL;
  IEncryption encryption;
  IFileFormat fileFormat;
  boolean open;
  ExecutorService service;
  int versionCode;
  String versionName;
  
  public static class Builder
  {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int MAXIMUM_POOL_SIZE = 10;
    DJILogFileConfig config = new DJILogFileConfig();
    
    static
    {
      int i = Runtime.getRuntime().availableProcessors();
      CPU_COUNT = i;
      CORE_POOL_SIZE = Math.max(2, Math.min(i, 10));
    }
    
    public Builder(Context paramContext)
    {
      setOpen(true);
      setSpaceMarginal(104857600L);
      setFilePrefix("log-");
      setEncryption(new SimpleEncryption());
      setFileFormat(new SimpleFileFormat());
      setLogTimeFormat("kk:mm:ss.SSS");
      setLineFeed("\r\n");
      if (paramContext != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(DJILogConstant.LOG_DIRECTORY_ROOT);
        localStringBuilder.append(paramContext.getPackageName());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(DJILogConstant.LOG_DIR_ROOT);
        setPathRoot(localStringBuilder.toString());
        localObject = paramContext.getPackageManager();
        try
        {
          paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 1);
          setVersionCode(paramContext.versionCode);
          setVersionName(paramContext.versionName);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          paramContext.printStackTrace();
        }
        setExecutorService(new ThreadPoolExecutor(CORE_POOL_SIZE, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory()
        {
          private final AtomicInteger mCount = new AtomicInteger(1);
          
          public Thread newThread(Runnable paramAnonymousRunnable)
          {
            return null;
          }
        }));
      }
    }
    
    public DJILogFileConfig build()
    {
      return this.config;
    }
    
    public Builder setEncryption(IEncryption paramIEncryption)
    {
      this.config.encryption = paramIEncryption;
      return this;
    }
    
    public Builder setExecutorService(ExecutorService paramExecutorService)
    {
      this.config.service = paramExecutorService;
      return this;
    }
    
    public Builder setFileFormat(IFileFormat paramIFileFormat)
    {
      this.config.fileFormat = paramIFileFormat;
      return this;
    }
    
    public Builder setFilePrefix(String paramString)
    {
      this.config.LOG_FILE_PREFIX = paramString;
      return this;
    }
    
    public Builder setFileType(String paramString)
    {
      this.config.LOG_FILE_TYPE = paramString;
      return this;
    }
    
    public Builder setLineFeed(String paramString)
    {
      this.config.LINE_FEED = paramString;
      return this;
    }
    
    public Builder setLogTimeFormat(String paramString)
    {
      this.config.LOG_TIME_FORMAT = paramString;
      return this;
    }
    
    public Builder setOpen(boolean paramBoolean)
    {
      this.config.open = paramBoolean;
      return this;
    }
    
    public Builder setPathRoot(String paramString)
    {
      this.config.LOG_PATH_ROOT = paramString;
      return this;
    }
    
    public Builder setSpaceMarginal(long paramLong)
    {
      this.config.SPACE_MARGINAL = paramLong;
      return this;
    }
    
    public Builder setVersionCode(int paramInt)
    {
      this.config.versionCode = paramInt;
      return this;
    }
    
    public Builder setVersionName(String paramString)
    {
      this.config.versionName = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogFileConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */