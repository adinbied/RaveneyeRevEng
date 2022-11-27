package com.huawei.hms.support.api.entity.sns.internal;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class SNSIntentResp
  implements IMessageEntity
{
  @a
  private Intent intent;
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\SNSIntentResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */