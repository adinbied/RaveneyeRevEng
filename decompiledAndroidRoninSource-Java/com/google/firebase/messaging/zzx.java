package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class zzx
{
  private final SharedPreferences zza;
  private final String zzb;
  private final String zzc;
  private final ArrayDeque<String> zzd = new ArrayDeque();
  private final Executor zze;
  private boolean zzf = false;
  
  private zzx(SharedPreferences paramSharedPreferences, String paramString1, String paramString2, Executor paramExecutor)
  {
    this.zza = paramSharedPreferences;
    this.zzb = paramString1;
    this.zzc = paramString2;
    this.zze = paramExecutor;
  }
  
  static zzx zza(SharedPreferences arg0, String paramString1, String paramString2, Executor paramExecutor)
  {
    paramString1 = new zzx(???, paramString1, paramString2, paramExecutor);
    for (;;)
    {
      int i;
      synchronized (paramString1.zzd)
      {
        paramString1.zzd.clear();
        paramString2 = paramString1.zza.getString(paramString1.zzb, "");
        if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains(paramString1.zzc)))
        {
          paramString2 = paramString2.split(paramString1.zzc, -1);
          if (paramString2.length == 0) {
            Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
          }
          int j = paramString2.length;
          i = 0;
          if (i < j)
          {
            paramExecutor = paramString2[i];
            if (!TextUtils.isEmpty(paramExecutor)) {
              paramString1.zzd.add(paramExecutor);
            }
          }
          else
          {
            return paramString1;
          }
        }
        else
        {
          return paramString1;
        }
      }
      i += 1;
    }
  }
  
  private final boolean zza(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.zze.execute(new zzw(this));
    }
    return paramBoolean;
  }
  
  public final String zza()
  {
    synchronized (this.zzd)
    {
      String str = (String)this.zzd.peek();
      return str;
    }
  }
  
  public final boolean zza(Object paramObject)
  {
    synchronized (this.zzd)
    {
      boolean bool = zza(this.zzd.remove(paramObject));
      return bool;
    }
  }
  
  public final boolean zza(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.contains(this.zzc))) {
      synchronized (this.zzd)
      {
        boolean bool = zza(this.zzd.add(paramString));
        return bool;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */