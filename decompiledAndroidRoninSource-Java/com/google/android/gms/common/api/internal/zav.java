package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zav
  implements zabt
{
  private zav(zas paramzas) {}
  
  public final void zab(int paramInt, boolean paramBoolean)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      if (zas.zac(this.zaeq))
      {
        zas.zaa(this.zaeq, false);
        zas.zaa(this.zaeq, paramInt, paramBoolean);
        return;
      }
      zas.zaa(this.zaeq, true);
      zas.zaf(this.zaeq).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
  
  public final void zab(Bundle paramBundle)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      zas.zab(this.zaeq, ConnectionResult.RESULT_SUCCESS);
      zas.zab(this.zaeq);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
  
  public final void zac(ConnectionResult paramConnectionResult)
  {
    zas.zaa(this.zaeq).lock();
    try
    {
      zas.zab(this.zaeq, paramConnectionResult);
      zas.zab(this.zaeq);
      return;
    }
    finally
    {
      zas.zaa(this.zaeq).unlock();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */