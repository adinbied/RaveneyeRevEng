package dji.sdksharedlib.hardware.abstractions.airlink.lb.merge;

import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;

public class MergeGetOcuSyncInfo
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
  public void getInfo(String arg1, DJISDKCacheCommonMergeCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class OcuSyncCallbackContainerClass
    implements DJIDataCallBack
  {
    private MergeGetOcuSyncInfo.OcuSyncConfigCommand[] ocuSyncConfigCommands;
    
    public OcuSyncCallbackContainerClass(MergeGetOcuSyncInfo.OcuSyncConfigCommand[] paramArrayOfOcuSyncConfigCommand)
    {
      this.ocuSyncConfigCommands = paramArrayOfOcuSyncConfigCommand;
    }
    
    /* Error */
    public void onFailure(dji.midware.data.config.P3.Ccode arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static class OcuSyncConfigCommand
  {
    public DJISDKCacheCommonMergeCallback callback;
    public String index;
    
    public OcuSyncConfigCommand(String paramString, DJISDKCacheCommonMergeCallback paramDJISDKCacheCommonMergeCallback)
    {
      this.index = paramString;
      this.callback = paramDJISDKCacheCommonMergeCallback;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\merge\MergeGetOcuSyncInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */