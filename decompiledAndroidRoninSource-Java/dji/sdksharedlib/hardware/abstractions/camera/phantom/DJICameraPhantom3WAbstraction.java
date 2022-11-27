package dji.sdksharedlib.hardware.abstractions.camera.phantom;

import dji.sdksharedlib.hardware.abstractions.camera.DJICameraBaseAbstraction;

public class DJICameraPhantom3WAbstraction
  extends DJICameraBaseAbstraction
{
  protected String getDisplayName()
  {
    return "Phantom 3 4K Camera";
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
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\phantom\DJICameraPhantom3WAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */