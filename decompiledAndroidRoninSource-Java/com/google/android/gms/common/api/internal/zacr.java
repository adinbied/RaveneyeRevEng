package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zacr
  implements IBinder.DeathRecipient, zacs
{
  private final WeakReference<BasePendingResult<?>> zalc;
  private final WeakReference<zac> zald;
  private final WeakReference<IBinder> zale;
  
  private zacr(BasePendingResult<?> paramBasePendingResult, zac paramzac, IBinder paramIBinder)
  {
    this.zald = new WeakReference(paramzac);
    this.zalc = new WeakReference(paramBasePendingResult);
    this.zale = new WeakReference(paramIBinder);
  }
  
  private final void zaby()
  {
    Object localObject = (BasePendingResult)this.zalc.get();
    zac localzac = (zac)this.zald.get();
    if ((localzac != null) && (localObject != null)) {
      localzac.remove(((PendingResult)localObject).zam().intValue());
    }
    localObject = (IBinder)this.zale.get();
    if (localObject != null) {}
    try
    {
      ((IBinder)localObject).unlinkToDeath(this, 0);
      return;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
  }
  
  public final void binderDied()
  {
    zaby();
  }
  
  public final void zac(BasePendingResult<?> paramBasePendingResult)
  {
    zaby();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zacr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */