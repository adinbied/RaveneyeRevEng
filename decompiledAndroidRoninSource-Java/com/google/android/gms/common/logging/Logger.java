package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger
{
  private final String mTag;
  private final String zzei;
  private final GmsLogger zzew;
  private final int zzex;
  
  private Logger(String paramString1, String paramString2)
  {
    this.zzei = paramString2;
    this.mTag = paramString1;
    this.zzew = new GmsLogger(paramString1);
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i))) {
      i += 1;
    }
    this.zzex = i;
  }
  
  public Logger(String paramString, String... paramVarArgs)
  {
    this(paramString, paramVarArgs);
  }
  
  private final String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(Locale.US, paramString, paramVarArgs);
      }
    }
    return this.zzei.concat(str);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    if (isLoggable(3)) {
      Log.d(this.mTag, format(paramString, paramVarArgs));
    }
  }
  
  public void e(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.e(this.mTag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    Log.e(this.mTag, format(paramString, paramVarArgs));
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, format(paramString, paramVarArgs));
  }
  
  public boolean isLoggable(int paramInt)
  {
    return this.zzex <= paramInt;
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    if (isLoggable(2)) {
      Log.v(this.mTag, format(paramString, paramVarArgs));
    }
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, format(paramString, paramVarArgs));
  }
  
  public void wtf(String paramString, Throwable paramThrowable, Object... paramVarArgs)
  {
    Log.wtf(this.mTag, format(paramString, paramVarArgs), paramThrowable);
  }
  
  public void wtf(Throwable paramThrowable)
  {
    Log.wtf(this.mTag, paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\logging\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */