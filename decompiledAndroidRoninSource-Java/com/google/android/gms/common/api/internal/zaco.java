package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zap;

final class zaco
  extends zap
{
  public zaco(zacm paramzacm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        i = paramMessage.what;
        paramMessage = new StringBuilder(70);
        paramMessage.append("TransformationResultHandler received unknown message type: ");
        paramMessage.append(i);
        Log.e("TransformedResultImpl", paramMessage.toString());
        return;
      }
      localObject1 = (RuntimeException)paramMessage.obj;
      paramMessage = String.valueOf(((RuntimeException)localObject1).getMessage());
      if (paramMessage.length() != 0) {
        paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);
      } else {
        paramMessage = new String("Runtime exception on the transformation worker thread: ");
      }
      Log.e("TransformedResultImpl", paramMessage);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = (PendingResult)paramMessage.obj;
    paramMessage = zacm.zaf(this.zakw);
    if (localObject1 == null) {}
    try
    {
      zacm.zaa(zacm.zag(this.zakw), new Status(13, "Transform returned null"));
      break label189;
      if ((localObject1 instanceof zacd)) {
        zacm.zaa(zacm.zag(this.zakw), ((zacd)localObject1).getStatus());
      } else {
        zacm.zag(this.zakw).zaa((PendingResult)localObject1);
      }
      label189:
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */