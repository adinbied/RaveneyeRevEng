package com.huawei.hms.support.api.entity.game;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GameGetPhoneInfoResp
  extends AbstractMessageEntity
{
  @a
  private int statusCode;
  @a
  private String temperature;
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getTemperature()
  {
    return this.temperature;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void setTemperature(String paramString)
  {
    this.temperature = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameGetPhoneInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */