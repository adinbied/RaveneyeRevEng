package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbm
{
  public static Looper zza(Looper paramLooper)
  {
    if (paramLooper != null) {
      return paramLooper;
    }
    return zzc();
  }
  
  public static Looper zzc()
  {
    boolean bool;
    if (Looper.myLooper() != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "Can't create handler inside thread that has not called Looper.prepare()");
    return Looper.myLooper();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */