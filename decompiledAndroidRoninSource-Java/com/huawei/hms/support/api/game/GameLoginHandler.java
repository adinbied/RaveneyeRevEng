package com.huawei.hms.support.api.game;

import com.huawei.hms.support.api.entity.game.GameUserData;

public abstract interface GameLoginHandler
{
  public abstract void onChange();
  
  public abstract void onResult(int paramInt, GameUserData paramGameUserData);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\GameLoginHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */