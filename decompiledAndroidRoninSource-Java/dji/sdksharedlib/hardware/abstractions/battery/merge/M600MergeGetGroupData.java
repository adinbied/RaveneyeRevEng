package dji.sdksharedlib.hardware.abstractions.battery.merge;

import dji.midware.data.model.P3.DataSmartBatteryGetMultBatteryInfo;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;
import java.util.List;

public class M600MergeGetGroupData
  extends DJISDKMergeGet
{
  protected DataSmartBatteryGetMultBatteryInfo groupData = null;
  
  /* Error */
  protected void execute(List<Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void get(M600GroupDataCallback paramM600GroupDataCallback)
  {
    addCommand(paramM600GroupDataCallback);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\merge\M600MergeGetGroupData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */