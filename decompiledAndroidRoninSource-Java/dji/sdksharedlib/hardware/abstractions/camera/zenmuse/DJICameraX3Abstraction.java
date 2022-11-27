package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;

public class DJICameraX3Abstraction
  extends DJICameraBaseAbstraction
{
  protected String getDisplayName()
  {
    return "Zenmuse X3";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX3Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */