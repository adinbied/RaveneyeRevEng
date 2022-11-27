package dji.sdksharedlib.hardware.abstractions.flightcontroller.merge;

import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKMergeGet;

public class MergeGetFlycParamInfo
  extends DJISDKMergeGet
{
  private static MergeGetFlycParamInfo instance;
  
  public static MergeGetFlycParamInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new MergeGetFlycParamInfo();
      }
      MergeGetFlycParamInfo localMergeGetFlycParamInfo = instance;
      return localMergeGetFlycParamInfo;
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
  public void getInfo(String arg1, ParamInfoCallBack arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class FcCallBack
    implements DJIDataCallBack
  {
    private MergeGetFlycParamInfo.FcCommand[] list;
    
    public FcCallBack(MergeGetFlycParamInfo.FcCommand[] paramArrayOfFcCommand)
    {
      this.list = paramArrayOfFcCommand;
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
  
  public static class FcCommand
  {
    public ParamInfoCallBack callBack;
    public String index;
    
    public FcCommand(String paramString, ParamInfoCallBack paramParamInfoCallBack)
    {
      this.index = paramString;
      this.callBack = paramParamInfoCallBack;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\merge\MergeGetFlycParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */