package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GameLoginResp
  implements IMessageEntity
{
  @a
  private String displayName;
  @a
  private String playerId;
  @a
  private Intent playerIntent;
  @a
  private int playerLevel;
  @a
  private String playerSign;
  @a
  private int statusCode;
  @a
  private String ts;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getDisplayName()
  {
    return null;
  }
  
  public String getPlayerId()
  {
    return null;
  }
  
  public Intent getPlayerIntent()
  {
    return null;
  }
  
  public int getPlayerLevel()
  {
    return 0;
  }
  
  public String getPlayerSSign()
  {
    return null;
  }
  
  public int getStatusCode()
  {
    return 0;
  }
  
  public String getTs()
  {
    return null;
  }
  
  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }
  
  public void setPlayerId(String paramString)
  {
    this.playerId = ((String)get(paramString));
  }
  
  public void setPlayerIntent(Intent paramIntent)
  {
    this.playerIntent = paramIntent;
  }
  
  public void setPlayerLevel(int paramInt)
  {
    this.playerLevel = paramInt;
  }
  
  public void setPlayerSSign(String paramString)
  {
    this.playerSign = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void setTs(String paramString)
  {
    this.ts = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameLoginResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */