package dji.internal.mock.abstractions;

import dji.common.flightcontroller.GPSSignalLevel;
import dji.common.model.LocationCoordinate2D;
import dji.common.util.CallbackUtils;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerAbstraction;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockFlightControllerAbstraction
  extends FlightControllerAbstraction
{
  private static final int DEFAULT_FLIGHT_TIME = 2000;
  protected static final int MAX_ALTITUDE = 300;
  protected static final double ONE_METER_OFFSET = 8.99322E-6D;
  double aircraftLatitude;
  double aircraftLongitude;
  double aircraftPitch;
  double aircraftRoll;
  double aircraftYaw;
  float altitude = 0.0F;
  int counter = 0;
  boolean goingUp = true;
  int gpsSatelliteNumber = 0;
  GPSSignalLevel gpsSignalStatus = GPSSignalLevel.find(0);
  LocationCoordinate2D homeLocation;
  boolean isAutoLanding = false;
  boolean isFlying = false;
  boolean isGoingHome = false;
  boolean isMotorUp = false;
  boolean isTakeOff = false;
  int remainingFlightTime = 2000;
  boolean rtkEnabled = false;
  float velocityX = 0.0F;
  float velocityY = 0.0F;
  float velocityZ = 0.0F;
  
  public MockFlightControllerAbstraction()
  {
    LocationCoordinate2D localLocationCoordinate2D = new LocationCoordinate2D(37.421972D, -122.137385D);
    this.homeLocation = localLocationCoordinate2D;
    this.aircraftLatitude = localLocationCoordinate2D.getLatitude();
    this.aircraftLongitude = this.homeLocation.getLongitude();
    this.aircraftPitch = 0.0D;
    this.aircraftYaw = 0.0D;
    this.aircraftRoll = 0.0D;
    generateVeryHighFrequencyData();
    generateHighFrequencyData();
    generateMediumFrequencyData();
    generateLowFrequencyData();
  }
  
  /* Error */
  private void generateHighFrequencyData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void generateMediumFrequencyData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void generateVeryHighFrequencyData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int getGpsLevelForOldFlightController(int paramInt)
  {
    return 0;
  }
  
  @Action("AutoLanding")
  public void autoLanding(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isAutoLanding = true;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
  
  @Action("CancelAutoLanding")
  public void cancelAutoLanding(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isAutoLanding = false;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
  
  @Action("CancelGoHome")
  public void cancelGoHome(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isGoingHome = false;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
  
  /* Error */
  public void generateLowFrequencyData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("GoHome")
  public void goHome(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isGoingHome = true;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isNewProgressOfActivation()
  {
    return false;
  }
  
  /* Error */
  @Action("TakeOff")
  public void takeOff(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("TurnOffMotors")
  public void turnOffMotors(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isMotorUp = false;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
  
  @Action("TurnOnMotors")
  public void turnOnMotors(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.isMotorUp = true;
    CallbackUtils.onSuccess(paramInnerCallback, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockFlightControllerAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */