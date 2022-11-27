package dji.logic.camera;

import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import org.greenrobot.eventbus.EventBus;

public class DJILogicCameraInfo
{
  private static DJILogicCameraInfo mInstance;
  private long setDateStartTime = 0L;
  private int version = 0;
  
  private DJILogicCameraInfo()
  {
    EventBus.getDefault().register(this);
    setRateType();
    if (DataCameraGetPushStateInfo.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataCameraGetPushStateInfo.getInstance());
    }
  }
  
  public static DJILogicCameraInfo getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DJILogicCameraInfo();
      }
      DJILogicCameraInfo localDJILogicCameraInfo = mInstance;
      return localDJILogicCameraInfo;
    }
    finally {}
  }
  
  /* Error */
  private void setRateType()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\camera\DJILogicCameraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */