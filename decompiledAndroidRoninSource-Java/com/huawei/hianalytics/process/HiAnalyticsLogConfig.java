package com.huawei.hianalytics.process;

import com.huawei.hianalytics.e.f;

public class HiAnalyticsLogConfig
{
  private f logData = new f();
  
  private HiAnalyticsLogConfig(Builder paramBuilder)
  {
    setMinLogLevel(paramBuilder.minLogLevel);
    setFileMaxSize(paramBuilder.fileMaxSize);
    setFailedFileMaxSize(paramBuilder.failedFileMaxSize);
    setMcc(paramBuilder.mcc);
    setLogServerUrl(paramBuilder.logServerUrl);
    setThrowableInfo(paramBuilder.throwableInfo);
    setThrowableFlag(paramBuilder.throwableFlag);
    setLogIsEnableImei(paramBuilder.logIsEnableImei);
    setLogIsEnableUdid(paramBuilder.logIsEnableUdid);
    setLogIsEnableSN(paramBuilder.logIsEnableSN);
    setLogImei(paramBuilder.logImei);
    setLogUdid(paramBuilder.logUdid);
    setLogSN(paramBuilder.logSN);
  }
  
  /* Error */
  private void setFailedFileMaxSize(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setFileMaxSize(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private void setLogImei(String paramString)
  {
    this.logData.c(paramString);
  }
  
  private void setLogIsEnableImei(boolean paramBoolean)
  {
    this.logData.a(paramBoolean);
  }
  
  private void setLogIsEnableSN(boolean paramBoolean)
  {
    this.logData.c(paramBoolean);
  }
  
  private void setLogIsEnableUdid(boolean paramBoolean)
  {
    this.logData.b(paramBoolean);
  }
  
  private void setLogSN(String paramString)
  {
    this.logData.e(paramString);
  }
  
  /* Error */
  private void setLogServerUrl(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setLogUdid(String paramString)
  {
    this.logData.d(paramString);
  }
  
  /* Error */
  private void setMcc(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setMinLogLevel(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setThrowableFlag(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setThrowableInfo(String[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  f getLogData()
  {
    return this.logData;
  }
  
  public static final class Builder
  {
    private int failedFileMaxSize = 5;
    private int fileMaxSize = 3;
    private String logImei = "";
    private boolean logIsEnableImei;
    private boolean logIsEnableSN;
    private boolean logIsEnableUdid;
    private String logSN = "";
    private String logServerUrl;
    private String logUdid = "";
    private String mcc;
    private int minLogLevel;
    private int throwableFlag = 0;
    private String[] throwableInfo = new String[0];
    
    public Builder(int paramInt, String paramString1, String paramString2)
    {
      this.minLogLevel = paramInt;
      this.mcc = paramString1;
      this.logServerUrl = paramString2;
    }
    
    public HiAnalyticsLogConfig build()
    {
      return new HiAnalyticsLogConfig(this, null);
    }
    
    public Builder setFailedFileMaxSize(int paramInt)
    {
      this.failedFileMaxSize = paramInt;
      return this;
    }
    
    public Builder setFileMaxSize(int paramInt)
    {
      this.fileMaxSize = paramInt;
      return this;
    }
    
    @Deprecated
    public Builder setLogEnableImei(boolean paramBoolean)
    {
      this.logIsEnableImei = paramBoolean;
      return this;
    }
    
    @Deprecated
    public Builder setLogEnableSN(boolean paramBoolean)
    {
      this.logIsEnableSN = paramBoolean;
      return this;
    }
    
    @Deprecated
    public Builder setLogEnableUdid(boolean paramBoolean)
    {
      this.logIsEnableUdid = paramBoolean;
      return this;
    }
    
    public Builder setLogImei(String paramString)
    {
      return null;
    }
    
    public Builder setLogSN(String paramString)
    {
      return null;
    }
    
    public Builder setLogUdid(String paramString)
    {
      return null;
    }
    
    public Builder setThrowableInfo(int paramInt, String[] paramArrayOfString)
    {
      this.throwableFlag = paramInt;
      if (paramArrayOfString != null)
      {
        this.throwableInfo = ((String[])paramArrayOfString.clone());
        return this;
      }
      this.throwableInfo = new String[0];
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\HiAnalyticsLogConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */