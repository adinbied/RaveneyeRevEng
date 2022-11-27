package dji.sdksharedlib.hardware.abstractions.camera.zenmuse;

public class DJICameraTau336Abstraction
  extends DJICameraXTBaseAbstraction
{
  protected String getDisplayName()
  {
    return "Zenmuse XT";
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isTau336Camera()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\camera\zenmuse\DJICameraTau336Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */