package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GetPlayerCertificationIntentResp
  implements IMessageEntity
{
  @a
  private Intent intent;
  @a
  public int statusCode;
  
  public Intent getCertificateIntent()
  {
    return this.intent;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public void setCertificateIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GetPlayerCertificationIntentResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */