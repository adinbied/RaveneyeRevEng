package dji.logic.mc;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.manager.P3.DataEvent;
import dji.midware.data.model.P3.DataOsdGetPushHome;
import dji.midware.interfaces.DJIDataCallBack;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJILogicHomePoint
{
  private static DJILogicHomePoint mInstance;
  private volatile int isOsdDone = 0;
  private volatile int isWifiDone = 0;
  
  private DJILogicHomePoint()
  {
    EventBus.getDefault().register(this);
    if (DataOsdGetPushHome.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataOsdGetPushHome.getInstance());
    }
  }
  
  public static DJILogicHomePoint getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DJILogicHomePoint();
      }
      DJILogicHomePoint localDJILogicHomePoint = mInstance;
      return localDJILogicHomePoint;
    }
    finally {}
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    this.isWifiDone = 0;
    this.isOsdDone = 0;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent)
  {
    this.isWifiDone = 0;
    this.isOsdDone = 0;
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushHome arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\mc\DJILogicHomePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */