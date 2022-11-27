package dji.common.flightcontroller.imu;

import dji.common.flightcontroller.CalibrationOrientation;
import java.util.HashSet;

public class MultipleOrientationCalibrationHint
{
  private HashSet<CalibrationOrientation> orientationsCalibrated = new HashSet(6);
  private HashSet<CalibrationOrientation> orientationsToCalibrate = new HashSet(6);
  private OrientationCalibrationState state;
  
  public HashSet<CalibrationOrientation> getOrientationsCalibrated()
  {
    return this.orientationsCalibrated;
  }
  
  public HashSet<CalibrationOrientation> getOrientationsToCalibrate()
  {
    return this.orientationsToCalibrate;
  }
  
  public OrientationCalibrationState getState()
  {
    return this.state;
  }
  
  public void setOrientationsCalibrated(HashSet<CalibrationOrientation> paramHashSet)
  {
    this.orientationsCalibrated = paramHashSet;
  }
  
  public void setOrientationsToCalibrate(HashSet<CalibrationOrientation> paramHashSet)
  {
    this.orientationsToCalibrate = paramHashSet;
  }
  
  public void setState(OrientationCalibrationState paramOrientationCalibrationState)
  {
    this.state = paramOrientationCalibrationState;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\imu\MultipleOrientationCalibrationHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */