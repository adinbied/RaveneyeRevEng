package com.huawei.hms.support.api.entity.game.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PlayerInfo
  implements IMessageEntity
{
  @a
  private String playerId;
  @a
  private String roleLevel;
  @a
  private String roleName;
  @a
  private String societyName;
  @a
  private String zone;
  
  public String getPlayerId()
  {
    return this.playerId;
  }
  
  public String getRoleLevel()
  {
    return this.roleLevel;
  }
  
  public String getRoleName()
  {
    return this.roleName;
  }
  
  public String getSocietyName()
  {
    return this.societyName;
  }
  
  public String getZone()
  {
    return this.zone;
  }
  
  public void setPlayerId(String paramString)
  {
    this.playerId = paramString;
  }
  
  public void setRoleLevel(String paramString)
  {
    this.roleLevel = paramString;
  }
  
  public void setRoleName(String paramString)
  {
    this.roleName = paramString;
  }
  
  public void setSocietyName(String paramString)
  {
    this.societyName = paramString;
  }
  
  public void setZone(String paramString)
  {
    this.zone = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\internal\PlayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */