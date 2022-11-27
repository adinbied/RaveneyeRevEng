package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

final class zzat
{
  private final Executor zza;
  private final Map<Pair<String, String>, Task<InstanceIdResult>> zzb = new ArrayMap();
  
  zzat(Executor paramExecutor)
  {
    this.zza = paramExecutor;
  }
  
  final Task<InstanceIdResult> zza(String paramString1, String paramString2, zzav paramzzav)
  {
    try
    {
      paramString1 = new Pair(paramString1, paramString2);
      paramString2 = (Task)this.zzb.get(paramString1);
      if (paramString2 != null)
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramString1 = String.valueOf(paramString1);
          paramzzav = new StringBuilder(String.valueOf(paramString1).length() + 29);
          paramzzav.append("Joining ongoing request for: ");
          paramzzav.append(paramString1);
          Log.d("FirebaseInstanceId", paramzzav.toString());
        }
        return paramString2;
      }
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        paramString2 = String.valueOf(paramString1);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 24);
        localStringBuilder.append("Making new request for: ");
        localStringBuilder.append(paramString2);
        Log.d("FirebaseInstanceId", localStringBuilder.toString());
      }
      paramString2 = paramzzav.zza().continueWithTask(this.zza, new zzas(this, paramString1));
      this.zzb.put(paramString1, paramString2);
      return paramString2;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */