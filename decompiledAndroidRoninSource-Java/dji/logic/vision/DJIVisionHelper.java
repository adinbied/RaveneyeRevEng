package dji.logic.vision;

import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.model.P3.DataEyeGetPushFrontAvoidance;
import dji.midware.data.model.P3.DataEyeGetPushFrontAvoidance.SensorType;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIVisionHelper
{
  private final HashMap<DataEyeGetPushFrontAvoidance.SensorType, DataEyeGetPushFrontAvoidance> mAvoidDatas = new HashMap(6);
  private final HashMap<DataEyeGetPushFrontAvoidance.SensorType, VisionEvent> mEventMap = new HashMap(6);
  
  private DJIVisionHelper()
  {
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Front, VisionEvent.RADAR_FRONT_CHANGED);
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Back, VisionEvent.RADAR_BACK_CHANGED);
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Left, VisionEvent.RADAR_LEFT_CHANGED);
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Right, VisionEvent.RADAR_RIGHT_CHANGED);
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Top, VisionEvent.RADAR_TOP_CHANGED);
    this.mEventMap.put(DataEyeGetPushFrontAvoidance.SensorType.Bottom, VisionEvent.RADAR_BOTTOM_CHANGED);
    EventBus.getDefault().register(this);
  }
  
  /* Error */
  private void clearAllDatas()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIVisionHelper getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  public DataEyeGetPushFrontAvoidance getData(DataEyeGetPushFrontAvoidance.SensorType paramSensorType)
  {
    return null;
  }
  
  public HashMap<DataEyeGetPushFrontAvoidance.SensorType, DataEyeGetPushFrontAvoidance> getDatas()
  {
    return null;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    if (DataCameraEvent.ConnectLose == paramDataCameraEvent) {
      clearAllDatas();
    }
  }
  
  /* Error */
  public void updateAvoidDatas(DataEyeGetPushFrontAvoidance arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static final class SingletonHolder
  {
    private static final DJIVisionHelper mInstance = new DJIVisionHelper(null);
  }
  
  public static enum VisionEvent
  {
    static
    {
      RADAR_BACK_CHANGED = new VisionEvent("RADAR_BACK_CHANGED", 1);
      RADAR_LEFT_CHANGED = new VisionEvent("RADAR_LEFT_CHANGED", 2);
      RADAR_RIGHT_CHANGED = new VisionEvent("RADAR_RIGHT_CHANGED", 3);
      RADAR_TOP_CHANGED = new VisionEvent("RADAR_TOP_CHANGED", 4);
      VisionEvent localVisionEvent = new VisionEvent("RADAR_BOTTOM_CHANGED", 5);
      RADAR_BOTTOM_CHANGED = localVisionEvent;
      $VALUES = new VisionEvent[] { RADAR_FRONT_CHANGED, RADAR_BACK_CHANGED, RADAR_LEFT_CHANGED, RADAR_RIGHT_CHANGED, RADAR_TOP_CHANGED, localVisionEvent };
    }
    
    private VisionEvent() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\vision\DJIVisionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */