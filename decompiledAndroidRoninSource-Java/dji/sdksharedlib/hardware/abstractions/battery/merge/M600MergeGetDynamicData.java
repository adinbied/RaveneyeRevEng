package dji.sdksharedlib.hardware.abstractions.battery.merge;

import dji.midware.data.model.P3.DataSmartBatteryGetPushDynamicData;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;
import java.util.List;

public class M600MergeGetDynamicData
  extends DJISDKMergeGet
{
  private int batteryIndex = 0;
  protected DataSmartBatteryGetPushDynamicData dynamicData = null;
  
  public M600MergeGetDynamicData(int paramInt)
  {
    this.batteryIndex = paramInt;
    DataSmartBatteryGetPushDynamicData localDataSmartBatteryGetPushDynamicData = new DataSmartBatteryGetPushDynamicData();
    this.dynamicData = localDataSmartBatteryGetPushDynamicData;
    if (paramInt == Integer.MAX_VALUE)
    {
      localDataSmartBatteryGetPushDynamicData.setIndex(0).setRequestPush(false);
      return;
    }
    localDataSmartBatteryGetPushDynamicData.setIndex(paramInt + 1).setRequestPush(false);
  }
  
  /* Error */
  protected void execute(List<Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void get(M600DynamicDataCallback paramM600DynamicDataCallback)
  {
    addCommand(paramM600DynamicDataCallback);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\merge\M600MergeGetDynamicData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */