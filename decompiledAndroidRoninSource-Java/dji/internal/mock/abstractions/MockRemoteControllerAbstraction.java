package dji.internal.mock.abstractions;

import dji.common.remotecontroller.GPSData;
import dji.common.remotecontroller.GPSData.Builder;
import dji.common.remotecontroller.GPSData.GPSLocation;
import dji.sdksharedlib.hardware.abstractions.remotecontroller.DJIRCAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockRemoteControllerAbstraction
  extends DJIRCAbstraction
{
  GPSData gpsData;
  
  public MockRemoteControllerAbstraction()
  {
    GPSData.GPSLocation localGPSLocation = new GPSData.GPSLocation();
    localGPSLocation.setLongitude(-122.137387D);
    localGPSLocation.setLatitude(37.421975D);
    this.gpsData = new GPSData.Builder().location(localGPSLocation).build();
    generateFakeGPSData();
  }
  
  /* Error */
  private void generateFakeGPSData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockRemoteControllerAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */