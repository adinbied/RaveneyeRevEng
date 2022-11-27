package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

public class DJICameraX5Abstraction
  extends DJICameraX5BaseAbstraction
{
  private static final String TAG = "X5Camera";
  
  protected String getDisplayName()
  {
    return "Zenmuse X5";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isAFSupported()
  {
    return true;
  }
  
  protected boolean isMFSupported()
  {
    return true;
  }
  
  protected boolean isMediaDownloadModeSupported()
  {
    return false;
  }
  
  protected boolean isPlaybackSupported()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX5Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */