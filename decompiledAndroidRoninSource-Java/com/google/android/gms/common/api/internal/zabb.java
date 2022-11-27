package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

final class zabb
  extends zap
{
  zabb(zaaw paramzaaw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        i = paramMessage.what;
        paramMessage = new StringBuilder(31);
        paramMessage.append("Unknown message id: ");
        paramMessage.append(i);
        Log.w("GoogleApiClientImpl", paramMessage.toString());
        return;
      }
      zaaw.zaa(this.zahh);
      return;
    }
    zaaw.zab(this.zahh);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */