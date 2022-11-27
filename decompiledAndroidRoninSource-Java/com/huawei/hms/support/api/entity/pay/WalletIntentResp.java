package com.huawei.hms.support.api.entity.pay;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class WalletIntentResp
  extends AbstractMessageEntity
{
  @a
  public PendingIntent pendingIntent;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public PendingIntent getPendingIntent()
  {
    return null;
  }
  
  public void setPendingIntent(PendingIntent paramPendingIntent)
  {
    this.pendingIntent = paramPendingIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\WalletIntentResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */