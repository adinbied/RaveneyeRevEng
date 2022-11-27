package com.huawei.hms.support.api.entity.game;

public class GameUserData
{
  private String a;
  private String b;
  private Integer c;
  private String d;
  private String e;
  private Integer f;
  
  public String getDisplayName()
  {
    return this.b;
  }
  
  public String getGameAuthSign()
  {
    return this.d;
  }
  
  public Integer getIsAuth()
  {
    return this.c;
  }
  
  public String getPlayerId()
  {
    return this.a;
  }
  
  public Integer getPlayerLevel()
  {
    return this.f;
  }
  
  public String getTs()
  {
    return this.e;
  }
  
  public void setDisplayName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setGameAuthSign(String paramString)
  {
    this.d = paramString;
  }
  
  public void setIsAuth(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void setPlayerId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPlayerLevel(Integer paramInteger)
  {
    this.f = paramInteger;
  }
  
  public void setTs(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameUserData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */