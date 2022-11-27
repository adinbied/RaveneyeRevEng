package com.huawei.appmarket.component.buoycircle.impl.storage;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.impl.cutout.CutoutInfo;
import java.util.Map;

public class BuoyStorage
{
  private static final String CUTOUT_KEY_PREFIX = "cutout_";
  private static final String ENCODING_UTF8 = "UTF-8";
  private static final String FILE_NAME_BUOY = "hms.game.buoy.info";
  private static final String FILE_NAME_LOGIN = "hms.game.login.info";
  private static final String HMS_GAME_SP_BUOY_HIDE_GUIDE = "hms.game.sp.buoy.hide.guide";
  private static final String HMS_GAME_SP_PLAYERID = "hms.game.sp.playerId";
  private static final String TAG = "BuoyStorage";
  private static BuoyStorage instance = new BuoyStorage();
  
  public static BuoyStorage getInstance()
  {
    return instance;
  }
  
  private String getSecretString(Context paramContext, String paramString)
  {
    return null;
  }
  
  /* Error */
  private void putSecretString(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Map<Integer, CutoutInfo> getCutoutParams(Context paramContext)
  {
    return null;
  }
  
  public String getHideGuideRecord(Context paramContext)
  {
    return getSecretString(paramContext, "hms.game.sp.buoy.hide.guide");
  }
  
  public CutoutInfo getOrientationCutoutInfo(int paramInt, Context paramContext)
  {
    return null;
  }
  
  /* Error */
  public void saveCutoutParams(Context arg1, Map<Integer, CutoutInfo> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveHideGuideRecord(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void savePlayerId(Context paramContext, String paramString)
  {
    putSecretString(paramContext, "hms.game.sp.playerId", paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\storage\BuoyStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */