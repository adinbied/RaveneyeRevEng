package com.google.android.gms.common.internal;

import android.util.Log;

public final class GmsLogger
{
  private static final int zzef = 15;
  private static final String zzeg;
  private final String zzeh;
  private final String zzei;
  
  public GmsLogger(String paramString)
  {
    this(paramString, null);
  }
  
  public GmsLogger(String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    boolean bool;
    if (paramString1.length() <= 23) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
    this.zzeh = paramString1;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      this.zzei = paramString2;
      return;
    }
    this.zzei = null;
  }
  
  private final String zza(String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    paramVarArgs = this.zzei;
    if (paramVarArgs == null) {
      return paramString;
    }
    return paramVarArgs.concat(paramString);
  }
  
  private final String zzh(String paramString)
  {
    String str = this.zzei;
    if (str == null) {
      return paramString;
    }
    return str.concat(paramString);
  }
  
  public final boolean canLog(int paramInt)
  {
    return Log.isLoggable(this.zzeh, paramInt);
  }
  
  public final boolean canLogPii()
  {
    return false;
  }
  
  public final void d(String paramString1, String paramString2)
  {
    if (canLog(3)) {
      Log.d(paramString1, zzh(paramString2));
    }
  }
  
  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(3)) {
      Log.d(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void e(String paramString1, String paramString2)
  {
    if (canLog(6)) {
      Log.e(paramString1, zzh(paramString2));
    }
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(6)) {
      Log.e(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void efmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (canLog(6)) {
      Log.e(paramString1, zza(paramString2, paramVarArgs));
    }
  }
  
  public final void i(String paramString1, String paramString2)
  {
    if (canLog(4)) {
      Log.i(paramString1, zzh(paramString2));
    }
  }
  
  public final void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(4)) {
      Log.i(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void pii(String paramString1, String paramString2)
  {
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      if (" PII_LOG".length() != 0) {
        paramString1 = paramString1.concat(" PII_LOG");
      } else {
        paramString1 = new String(paramString1);
      }
      Log.i(paramString1, zzh(paramString2));
    }
  }
  
  public final void pii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLogPii())
    {
      paramString1 = String.valueOf(paramString1);
      if (" PII_LOG".length() != 0) {
        paramString1 = paramString1.concat(" PII_LOG");
      } else {
        paramString1 = new String(paramString1);
      }
      Log.i(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void v(String paramString1, String paramString2)
  {
    if (canLog(2)) {
      Log.v(paramString1, zzh(paramString2));
    }
  }
  
  public final void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(2)) {
      Log.v(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void w(String paramString1, String paramString2)
  {
    if (canLog(5)) {
      Log.w(paramString1, zzh(paramString2));
    }
  }
  
  public final void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(5)) {
      Log.w(paramString1, zzh(paramString2), paramThrowable);
    }
  }
  
  public final void wfmt(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (canLog(5)) {
      Log.w(this.zzeh, zza(paramString2, paramVarArgs));
    }
  }
  
  public final void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (canLog(7))
    {
      Log.e(paramString1, zzh(paramString2), paramThrowable);
      Log.wtf(paramString1, zzh(paramString2), paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\GmsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */