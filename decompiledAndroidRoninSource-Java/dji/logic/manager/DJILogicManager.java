package dji.logic.manager;

import dji.logic.camera.DJILogicCameraInfo;
import dji.logic.mc.DJILogicHomePoint;
import dji.logic.mc.DJIMcHelper;
import dji.logic.ofdm.DJILogicMaxMcs;
import dji.logic.vision.DJIVisionHelper;
import dji.logic.wifi.DJIWifiHelper;

public class DJILogicManager
{
  private static DJILogicManager mInstance;
  
  private DJILogicManager()
  {
    DJIMcHelper.getInstance();
    DJILogicHomePoint.getInstance();
    DJILogicCameraInfo.getInstance();
    DJILogicMaxMcs.getInstance();
    DJIVisionHelper.getInstance();
    DJIWifiHelper.getInstance();
  }
  
  public static DJILogicManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DJILogicManager();
      }
      DJILogicManager localDJILogicManager = mInstance;
      return localDJILogicManager;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\manager\DJILogicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */