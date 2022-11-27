package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ExecutorService;

public final class FirebaseInstanceIdReceiver
  extends WakefulBroadcastReceiver
{
  private final ExecutorService zza = zzh.zzb();
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject = paramIntent.getParcelableExtra("wrapped_intent");
    if ((localObject instanceof Intent)) {
      localObject = (Intent)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      paramIntent = (Intent)localObject;
    }
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18) {
      paramIntent.removeCategory(paramContext.getPackageName());
    }
    if ("google.com/iid".equals(paramIntent.getStringExtra("from"))) {
      paramContext = new zzz(this.zza);
    } else {
      paramContext = new zza(paramContext, this.zza);
    }
    boolean bool = isOrderedBroadcast();
    localObject = goAsync();
    paramContext.zza(paramIntent).addOnCompleteListener(this.zza, new zzr(bool, (BroadcastReceiver.PendingResult)localObject));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\FirebaseInstanceIdReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */