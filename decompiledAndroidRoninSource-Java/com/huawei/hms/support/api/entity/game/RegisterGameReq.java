package com.huawei.hms.support.api.entity.game;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class RegisterGameReq
  implements IMessageEntity
{
  @a
  private String pid;
  
  public String getPid()
  {
    return this.pid;
  }
  
  public void setPid(String paramString)
  {
    this.pid = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\RegisterGameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */