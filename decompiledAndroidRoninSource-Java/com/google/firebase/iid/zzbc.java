package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;

public final class zzbc
  extends Binder
{
  private final zzbe zza;
  
  public zzbc(zzbe paramzzbe)
  {
    this.zza = paramzzbe;
  }
  
  final void zza(zzbg paramzzbg)
  {
    if (Binder.getCallingUid() == Process.myUid())
    {
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
      }
      this.zza.zza(paramzzbg.zza).addOnCompleteListener(zzh.zza(), new zzbf(paramzzbg));
      return;
    }
    throw new SecurityException("Binding only allowed within app");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */