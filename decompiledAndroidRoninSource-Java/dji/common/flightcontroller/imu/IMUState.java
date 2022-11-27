package dji.common.flightcontroller.imu;

public class IMUState
{
  private SensorState accelerometerState;
  private int calibrationProgress;
  private CalibrationState calibrationState;
  private boolean[] currentDownside = { 0, 0, 0, 0, 0, 0 };
  private int currentSideStatus = 2;
  private boolean[] finishCalibrationSide = { 1, 1, 1, 1, 1, 1 };
  private SensorState gyroscopeState;
  private int index = -1;
  private boolean isConnected = false;
  private boolean isMultiSideCalibrationType = false;
  private MultipleOrientationCalibrationHint multiOrientationCalibrationHint = new MultipleOrientationCalibrationHint();
  private boolean[] needCalibrationSide = { 1, 1, 1, 1, 1, 1 };
  private IMUState[] subIMUState;
  
  public IMUState() {}
  
  public IMUState(int paramInt)
  {
    if (paramInt > 1)
    {
      this.subIMUState = new IMUState[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        IMUState localIMUState = new IMUState(0);
        localIMUState.setIndex(i);
        this.subIMUState[i] = localIMUState;
        i += 1;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public SensorState getAccelerometerState()
  {
    return this.accelerometerState;
  }
  
  public int getCalibrationProgress()
  {
    return this.calibrationProgress;
  }
  
  public CalibrationState getCalibrationState()
  {
    return this.calibrationState;
  }
  
  public boolean[] getCurrentDownside()
  {
    return this.currentDownside;
  }
  
  public int getCurrentSideStatus()
  {
    return this.currentSideStatus;
  }
  
  public boolean[] getFinishCalibrationSide()
  {
    return this.finishCalibrationSide;
  }
  
  public SensorState getGyroscopeState()
  {
    return this.gyroscopeState;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public MultipleOrientationCalibrationHint getMultipleOrientationCalibrationHint()
  {
    return this.multiOrientationCalibrationHint;
  }
  
  public boolean[] getNeedCalibrationSide()
  {
    return this.needCalibrationSide;
  }
  
  public IMUState[] getSubIMUState()
  {
    return this.subIMUState;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isConnected()
  {
    return this.isConnected;
  }
  
  public boolean isMultiSideCalibrationType()
  {
    return this.isMultiSideCalibrationType;
  }
  
  public void setAccelerometerState(SensorState paramSensorState)
  {
    this.accelerometerState = paramSensorState;
  }
  
  public void setCalibrationProgress(int paramInt)
  {
    this.calibrationProgress = paramInt;
  }
  
  public void setCalibrationState(CalibrationState paramCalibrationState)
  {
    this.calibrationState = paramCalibrationState;
  }
  
  public void setCurrentDownside(boolean[] paramArrayOfBoolean)
  {
    this.currentDownside = paramArrayOfBoolean;
  }
  
  public void setCurrentSideStatus(int paramInt)
  {
    this.currentSideStatus = paramInt;
  }
  
  public void setFinishCalibrationSide(boolean[] paramArrayOfBoolean)
  {
    this.finishCalibrationSide = paramArrayOfBoolean;
  }
  
  public void setGyroscopeState(SensorState paramSensorState)
  {
    this.gyroscopeState = paramSensorState;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setIsConnected(boolean paramBoolean)
  {
    this.isConnected = paramBoolean;
  }
  
  public void setMultiOrientationCalibrationHint(MultipleOrientationCalibrationHint paramMultipleOrientationCalibrationHint)
  {
    this.multiOrientationCalibrationHint = paramMultipleOrientationCalibrationHint;
  }
  
  public void setMultiSideCalibrationType(boolean paramBoolean)
  {
    this.isMultiSideCalibrationType = paramBoolean;
  }
  
  public void setNeedCalibrationSide(boolean[] paramArrayOfBoolean)
  {
    this.needCalibrationSide = paramArrayOfBoolean;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(IMUState paramIMUState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\imu\IMUState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */