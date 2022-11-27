package dji.logic.ofdm;

import dji.midware.interfaces.DJIDataCallBack;

public class DJILogicMaxMcs
{
  private static DJILogicMaxMcs mInstance;
  private int curMcs = 0;
  
  public static DJILogicMaxMcs getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DJILogicMaxMcs();
      }
      DJILogicMaxMcs localDJILogicMaxMcs = mInstance;
      return localDJILogicMaxMcs;
    }
    finally {}
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushMaxMcs arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\ofdm\DJILogicMaxMcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */