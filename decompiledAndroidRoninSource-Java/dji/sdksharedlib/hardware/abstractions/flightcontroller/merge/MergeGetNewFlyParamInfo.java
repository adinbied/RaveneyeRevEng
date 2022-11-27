package dji.sdksharedlib.hardware.abstractions.flightcontroller.merge;

import dji.common.error.DJIError;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeGetCommand;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;

public class MergeGetNewFlyParamInfo
  extends DJISDKMergeGet
{
  private static MergeGetNewFlyParamInfo instance;
  
  public static MergeGetNewFlyParamInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new MergeGetNewFlyParamInfo();
      }
      MergeGetNewFlyParamInfo localMergeGetNewFlyParamInfo = instance;
      return localMergeGetNewFlyParamInfo;
    }
    finally {}
  }
  
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
  
  private class NewFlyParamInfoMergeGetContainClass
    implements DJISDKCacheHWAbstraction.InnerCallback
  {
    private DJISDKCacheCommonMergeGetCommand[] newFlyParamInfoCommands;
    
    public NewFlyParamInfoMergeGetContainClass(DJISDKCacheCommonMergeGetCommand[] paramArrayOfDJISDKCacheCommonMergeGetCommand)
    {
      this.newFlyParamInfoCommands = paramArrayOfDJISDKCacheCommonMergeGetCommand;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\merge\MergeGetNewFlyParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */