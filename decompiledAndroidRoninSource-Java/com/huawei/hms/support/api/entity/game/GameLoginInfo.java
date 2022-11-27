package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import android.os.Bundle;

public final class GameLoginInfo
{
  public static final int CODE_FAIL = -1;
  public static final int CODE_SUCCESS = 0;
  private String a;
  private String b;
  private int c;
  private String d;
  private String e;
  private int f;
  
  public GameLoginInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this.f = paramInt1;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt2;
    this.d = paramString3;
    this.e = paramString4;
  }
  
  public static GameLoginInfo build(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    String str1 = paramIntent.getStringExtra("key_player_id");
    String str2 = paramIntent.getStringExtra("key_display_name");
    int i = paramIntent.getIntExtra("key_player_level", 0);
    String str3 = paramIntent.getStringExtra("key_ts");
    String str4 = paramIntent.getStringExtra("key_player_sign");
    return new GameLoginInfo(paramIntent.getIntExtra("key_code", -1), str1, str2, i, str3, str4);
  }
  
  public int getCode()
  {
    return this.f;
  }
  
  public String getDisplayName()
  {
    return this.b;
  }
  
  public String getPlayerId()
  {
    return this.a;
  }
  
  public int getPlayerLevel()
  {
    return this.c;
  }
  
  public String getPlayerSign()
  {
    return this.e;
  }
  
  public String getTs()
  {
    return this.d;
  }
  
  public boolean isSuccess()
  {
    return this.f == 0;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameLoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */