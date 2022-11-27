package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzm
{
  private static final zzm zzac = new zzm(true, null, null);
  private final Throwable cause;
  final boolean zzad;
  private final String zzae;
  
  zzm(boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    this.zzad = paramBoolean;
    this.zzae = paramString;
    this.cause = paramThrowable;
  }
  
  static zzm zza(String paramString, Throwable paramThrowable)
  {
    return new zzm(false, paramString, paramThrowable);
  }
  
  static zzm zza(Callable<String> paramCallable)
  {
    return new zzo(paramCallable, null);
  }
  
  static zzm zzb(String paramString)
  {
    return new zzm(false, paramString, null);
  }
  
  static String zzc(String paramString, zze paramzze, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2) {
      str = "debug cert rejected";
    } else {
      str = "not whitelisted";
    }
    return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[] { str, paramString, Hex.bytesToStringLowercase(AndroidUtilsLight.zzj("SHA-1").digest(paramzze.getBytes())), Boolean.valueOf(paramBoolean1), "12451009.false" });
  }
  
  static zzm zze()
  {
    return zzac;
  }
  
  @Nullable
  String getErrorMessage()
  {
    return this.zzae;
  }
  
  final void zzf()
  {
    if ((!this.zzad) && (Log.isLoggable("GoogleCertificatesRslt", 3)))
    {
      if (this.cause != null)
      {
        Log.d("GoogleCertificatesRslt", getErrorMessage(), this.cause);
        return;
      }
      Log.d("GoogleCertificatesRslt", getErrorMessage());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */