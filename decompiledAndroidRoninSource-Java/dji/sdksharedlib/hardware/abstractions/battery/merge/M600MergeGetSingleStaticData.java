package dji.sdksharedlib.hardware.abstractions.battery.merge;

import dji.midware.data.model.P3.DataSmartBatteryGetStaticData;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;
import java.util.List;

public class M600MergeGetSingleStaticData
  extends DJISDKMergeGet
{
  private int batteryIndex = 0;
  protected DataSmartBatteryGetStaticData staticData = null;
  
  public M600MergeGetSingleStaticData(int paramInt)
  {
    this.batteryIndex = paramInt;
    DataSmartBatteryGetStaticData localDataSmartBatteryGetStaticData = new DataSmartBatteryGetStaticData();
    this.staticData = localDataSmartBatteryGetStaticData;
    localDataSmartBatteryGetStaticData.setIndex(paramInt + 1);
  }
  
  /* Error */
  protected void execute(List<Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void get(M600SingleStaticDataCallback paramM600SingleStaticDataCallback)
  {
    addCommand(paramM600SingleStaticDataCallback);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\merge\M600MergeGetSingleStaticData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */