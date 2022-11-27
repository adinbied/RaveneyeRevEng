package dji.sdksharedlib.hardware.abstractions.flightcontroller.merge;

import dji.common.error.DJIError;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeSetCommand;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;

public class MergeSetFlyParamInfo
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
  public void getInfo(String arg1, Number arg2, dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class NewFlyParamInfoMergeSetContainClass
    implements DJISDKCacheHWAbstraction.InnerCallback
  {
    private DJISDKCacheCommonMergeSetCommand[] newFlyParamInfoCommands;
    
    public NewFlyParamInfoMergeSetContainClass(DJISDKCacheCommonMergeSetCommand[] paramArrayOfDJISDKCacheCommonMergeSetCommand)
    {
      this.newFlyParamInfoCommands = paramArrayOfDJISDKCacheCommonMergeSetCommand;
    }
    
    public void onFails(DJIError paramDJIError) {}
    
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\merge\MergeSetFlyParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */