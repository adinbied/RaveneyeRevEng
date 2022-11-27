package com.huawei.hms.support.api.entity.game.internal;

import com.huawei.hms.core.aidl.a.a;

public class AddPlayerInfoReq
  extends GameBaseRequest
{
  @a
  private PlayerInfo playerInfo;
  
  public PlayerInfo getPlayerInfo()
  {
    return this.playerInfo;
  }
  
  public void setPlayerInfo(PlayerInfo paramPlayerInfo)
  {
    this.playerInfo = paramPlayerInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\internal\AddPlayerInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */