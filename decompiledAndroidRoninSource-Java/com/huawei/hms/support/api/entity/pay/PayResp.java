package com.huawei.hms.support.api.entity.pay;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PayResp
  extends AbstractMessageEntity
{
  @a
  public PendingIntent pendingIntent;
  @a
  public int retCode;
  
  public PendingIntent getPendingIntent()
  {
    return this.pendingIntent;
  }
  
  /* Error */
  public void setPendingIntent(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PayResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */