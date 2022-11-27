package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import java.util.Map;

final class zaac
  implements PendingResult.StatusListener
{
  zaac(zaab paramzaab, BasePendingResult paramBasePendingResult) {}
  
  public final void onComplete(Status paramStatus)
  {
    zaab.zaa(this.zafn).remove(this.zafm);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */