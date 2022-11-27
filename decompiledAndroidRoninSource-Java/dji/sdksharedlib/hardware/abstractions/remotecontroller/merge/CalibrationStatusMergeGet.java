package dji.sdksharedlib.hardware.abstractions.remotecontroller.merge;

import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeGetCommand;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;

public class CalibrationStatusMergeGet
  extends DJISDKMergeGet
{
  /* Error */
  protected void execute(java.util.List<Object> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getInfo(String arg1, dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class CalibrationStatusMergeGetContainClass
    implements DJIDataCallBack
  {
    private DJISDKCacheCommonMergeGetCommand[] rcCalibrationStatusCommands;
    
    public CalibrationStatusMergeGetContainClass(DJISDKCacheCommonMergeGetCommand[] paramArrayOfDJISDKCacheCommonMergeGetCommand)
    {
      this.rcCalibrationStatusCommands = paramArrayOfDJISDKCacheCommonMergeGetCommand;
    }
    
    public void onFailure(Ccode paramCcode) {}
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\remotecontroller\merge\CalibrationStatusMergeGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */