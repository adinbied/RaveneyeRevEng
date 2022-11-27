package com.huawei.hms.support.api.entity.game.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class AddPlayerInfoResp
  implements IMessageEntity
{
  @a
  String rtnCode;
  
  public String getRtnCode()
  {
    return this.rtnCode;
  }
  
  public void setRtnCode(String paramString)
  {
    this.rtnCode = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\internal\AddPlayerInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */