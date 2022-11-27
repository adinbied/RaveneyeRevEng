package com.huawei.hms.support.api.pay;

import android.app.PendingIntent;
import com.huawei.hms.support.api.client.Result;

public class GetWalletUiIntentResult
  extends Result
{
  private PendingIntent a;
  
  public PendingIntent getPindingIntent()
  {
    return this.a;
  }
  
  public void setPendingIntent(PendingIntent paramPendingIntent)
  {
    this.a = paramPendingIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\GetWalletUiIntentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */