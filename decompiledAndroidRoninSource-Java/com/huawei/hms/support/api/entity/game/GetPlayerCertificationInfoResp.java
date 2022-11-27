package com.huawei.hms.support.api.entity.game;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GetPlayerCertificationInfoResp
  implements IMessageEntity
{
  @a
  private int isAdult;
  @a
  public int statusCode;
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public int hasAdult()
  {
    return this.isAdult;
  }
  
  public void setIsAdult(int paramInt)
  {
    this.isAdult = paramInt;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GetPlayerCertificationInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */