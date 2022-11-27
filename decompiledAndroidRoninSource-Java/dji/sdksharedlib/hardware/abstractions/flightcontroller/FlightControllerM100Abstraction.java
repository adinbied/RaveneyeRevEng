package dji.sdksharedlib.hardware.abstractions.flightcontroller;

public class FlightControllerM100Abstraction
  extends FlightControllerPhantom3Abstraction
{
  /* Error */
  protected void initFlightControllerSupportParameter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void initializeComponentCharacteristics()
  {
    super.initializeComponentCharacteristics();
  }
  
  protected boolean isNewProgressOfActivation()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerM100Abstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */