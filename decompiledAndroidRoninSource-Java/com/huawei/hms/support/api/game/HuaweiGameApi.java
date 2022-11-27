package com.huawei.hms.support.api.game;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.game.GamePlayerInfo;

public abstract interface HuaweiGameApi
{
  public abstract PendingResult<PlayerCertificationInfo> getPlayerCertificationInfo(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<CertificateIntentResult> getPlayerCertificationIntent(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<TemperatureResult> getTemperature(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract void hideFloatWindow(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity);
  
  public abstract PendingResult<GameLoginResult> login(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity, int paramInt, GameLoginHandler paramGameLoginHandler);
  
  public abstract PendingResult<HardwareCapabilityResult> registerHardwareCapability(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<SavePlayerInfoResult> savePlayerInfo(HuaweiApiClient paramHuaweiApiClient, GamePlayerInfo paramGamePlayerInfo);
  
  public abstract PendingResult<ShowFloatWindowResult> showFloatWindow(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity);
  
  public abstract long updateGameInfo(HuaweiApiClient paramHuaweiApiClient, GameInfo paramGameInfo);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\HuaweiGameApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */