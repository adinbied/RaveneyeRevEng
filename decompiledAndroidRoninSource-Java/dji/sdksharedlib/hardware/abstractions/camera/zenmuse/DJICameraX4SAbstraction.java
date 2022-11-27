package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

public class DJICameraX4SAbstraction
  extends DJICameraInspire2Abstraction
{
  protected String getDisplayName()
  {
    return "Zenmuse X4S";
  }
  
  protected boolean isSSDSupported()
  {
    return false;
  }
  
  protected boolean isShootPhotoRawBurstSupported()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraX4SAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */