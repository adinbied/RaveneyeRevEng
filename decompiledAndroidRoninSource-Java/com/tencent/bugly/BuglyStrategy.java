package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.a;
import java.util.Map;

public class BuglyStrategy
{
  protected int a = 31;
  protected boolean b = false;
  private String c;
  private String d;
  private String e;
  private long f;
  private String g;
  private String h;
  private String i;
  private boolean j = true;
  private boolean k = true;
  private boolean l = false;
  private boolean m = true;
  private Class<?> n = null;
  private boolean o = true;
  private boolean p = true;
  private boolean q = true;
  private boolean r = true;
  private boolean s = false;
  private a t;
  private boolean u = true;
  
  public String getAppChannel()
  {
    try
    {
      if (this.d == null)
      {
        str = a.b().l;
        return str;
      }
      String str = this.d;
      return str;
    }
    finally {}
  }
  
  public String getAppPackageName()
  {
    try
    {
      if (this.e == null)
      {
        str = a.b().c;
        return str;
      }
      String str = this.e;
      return str;
    }
    finally {}
  }
  
  public long getAppReportDelay()
  {
    try
    {
      long l1 = this.f;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getAppVersion()
  {
    try
    {
      if (this.c == null)
      {
        str = a.b().j;
        return str;
      }
      String str = this.c;
      return str;
    }
    finally {}
  }
  
  public int getCallBackType()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean getCloseErrorCallback()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public a getCrashHandleCallback()
  {
    try
    {
      a locala = this.t;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceID()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceModel()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLibBuglySOFilePath()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Class<?> getUserInfoActivity()
  {
    try
    {
      Class localClass = this.n;
      return localClass;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isBuglyLogUpload()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableANRCrashMonitor()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableCatchAnrTrace()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableNativeCrashMonitor()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableUserInfo()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isMerged()
  {
    return this.u;
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.p;
  }
  
  public boolean isUploadProcess()
  {
    try
    {
      boolean bool = this.q;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isUploadSpotCrash()
  {
    try
    {
      boolean bool = this.r;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean recordUserInfoOnceADay()
  {
    try
    {
      boolean bool = this.s;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setAppChannel(String paramString)
  {
    try
    {
      this.d = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppPackageName(String paramString)
  {
    try
    {
      this.e = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppReportDelay(long paramLong)
  {
    try
    {
      this.f = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setAppVersion(String paramString)
  {
    try
    {
      this.c = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setBuglyLogUpload(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setCallBackType(int paramInt)
  {
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setCloseErrorCallback(boolean paramBoolean)
  {
    try
    {
      this.b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setCrashHandleCallback(a parama)
  {
    try
    {
      this.t = parama;
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public BuglyStrategy setDeviceID(String paramString)
  {
    try
    {
      this.h = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setDeviceModel(String paramString)
  {
    try
    {
      this.i = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setEnableCatchAnrTrace(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setLibBuglySOFilePath(String paramString)
  {
    try
    {
      this.g = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setMerged(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.s = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setReplaceOldChannel(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public BuglyStrategy setUploadProcess(boolean paramBoolean)
  {
    try
    {
      this.q = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setUploadSpotCrash(boolean paramBoolean)
  {
    try
    {
      this.r = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setUserInfoActivity(Class<?> paramClass)
  {
    try
    {
      this.n = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static class a
  {
    public static final int CRASHTYPE_ANR = 4;
    public static final int CRASHTYPE_BLOCK = 7;
    public static final int CRASHTYPE_COCOS2DX_JS = 5;
    public static final int CRASHTYPE_COCOS2DX_LUA = 6;
    public static final int CRASHTYPE_JAVA_CATCH = 1;
    public static final int CRASHTYPE_JAVA_CRASH = 0;
    public static final int CRASHTYPE_NATIVE = 2;
    public static final int CRASHTYPE_U3D = 3;
    public static final int MAX_USERDATA_KEY_LENGTH = 100;
    public static final int MAX_USERDATA_VALUE_LENGTH = 100000;
    
    public Map<String, String> onCrashHandleStart(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
    
    public byte[] onCrashHandleStart2GetExtraDatas(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\BuglyStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */