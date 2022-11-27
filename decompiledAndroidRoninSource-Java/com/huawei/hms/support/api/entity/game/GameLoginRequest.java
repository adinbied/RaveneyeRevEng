package com.huawei.hms.support.api.entity.game;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GameLoginRequest
  implements IMessageEntity
{
  @a
  private String cpId;
  @a
  private int flag;
  @a
  private String hmsSdkVersionName;
  @a
  private int isForceLogin;
  @a
  private String playerId;
  
  public String getCpID()
  {
    return this.cpId;
  }
  
  public int getFlag()
  {
    return this.flag;
  }
  
  public String getHmsSdkVersionName()
  {
    return this.hmsSdkVersionName;
  }
  
  public int getIsForceLogin()
  {
    return this.isForceLogin;
  }
  
  public String getPlayerId()
  {
    return this.playerId;
  }
  
  public void setCpID(String paramString)
  {
    this.cpId = paramString;
  }
  
  public void setFlag(int paramInt)
  {
    this.flag = paramInt;
  }
  
  public void setHmsSdkVersionName(String paramString)
  {
    this.hmsSdkVersionName = paramString;
  }
  
  public void setIsForceLogin(int paramInt)
  {
    this.isForceLogin = paramInt;
  }
  
  public void setPlayerId(String paramString)
  {
    this.playerId = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameLoginRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */