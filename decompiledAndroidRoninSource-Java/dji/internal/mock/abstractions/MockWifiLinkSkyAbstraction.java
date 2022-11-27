package dji.internal.mock.abstractions;

import dji.sdksharedlib.hardware.abstractions.airlink.wifi.DJIWifiLinkSkyAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockWifiLinkSkyAbstraction
  extends DJIWifiLinkSkyAbstraction
{
  boolean goingUp = true;
  int signalQuality = 0;
  
  public MockWifiLinkSkyAbstraction()
  {
    generateFakeSignalQuality();
  }
  
  /* Error */
  private void generateFakeSignalQuality()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockWifiLinkSkyAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */