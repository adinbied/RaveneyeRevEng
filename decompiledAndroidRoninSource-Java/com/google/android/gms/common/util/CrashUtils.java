package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class CrashUtils
{
  private static final String[] zzgg = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzgh = null;
  private static boolean zzgi = false;
  private static int zzgj = -1;
  private static int zzgk = 0;
  private static int zzgl = 0;
  
  public static boolean addDynamiteErrorToDropBox(Context paramContext, Throwable paramThrowable)
  {
    return zza(paramContext, paramThrowable, 536870912);
  }
  
  private static boolean zza(Context paramContext, Throwable paramThrowable, int paramInt)
  {
    try
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
      return false;
    }
    catch (Exception paramContext)
    {
      Log.e("CrashUtils", "Error adding exception to DropBox!", paramContext);
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\CrashUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */