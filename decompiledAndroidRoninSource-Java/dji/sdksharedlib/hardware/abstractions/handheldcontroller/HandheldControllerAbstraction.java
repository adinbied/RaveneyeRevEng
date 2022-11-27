package dji.sdksharedlib.hardware.abstractions.handheldcontroller;

import dji.common.handheld.PowerMode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Getter;

public class HandheldControllerAbstraction
  extends HandheldControllerBaseAbstraction
{
  @Getter("FullSerialNumberHash")
  public void getFullSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 2);
  }
  
  @Getter("SerialNumber")
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 0);
  }
  
  /* Error */
  protected void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Setter("PowerMode")
  public void setHandheldPowerMode(PowerMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\handheldcontroller\HandheldControllerAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */