package com.huawei.hms.support.api.entity.game;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class RegisterGameResp
  extends AbstractMessageEntity
{
  @a
  private int limitTimes;
  @a
  private String packageName;
  @a
  private int statusCode;
  
  public int getLimitTimes()
  {
    return this.limitTimes;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public void setLimitTimes(int paramInt)
  {
    this.limitTimes = paramInt;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\RegisterGameResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */