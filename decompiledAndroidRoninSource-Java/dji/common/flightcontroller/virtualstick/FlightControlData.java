package dji.common.flightcontroller.virtualstick;

public class FlightControlData
{
  private float pitch;
  private float roll;
  private float verticalThrottle;
  private float yaw;
  
  public FlightControlData(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.pitch = paramFloat1;
    this.roll = paramFloat2;
    this.yaw = paramFloat3;
    this.verticalThrottle = paramFloat4;
  }
  
  public float getPitch()
  {
    return this.pitch;
  }
  
  public float getRoll()
  {
    return this.roll;
  }
  
  public float getVerticalThrottle()
  {
    return this.verticalThrottle;
  }
  
  public float getYaw()
  {
    return this.yaw;
  }
  
  public void setPitch(float paramFloat)
  {
    this.pitch = paramFloat;
  }
  
  public void setRoll(float paramFloat)
  {
    this.roll = paramFloat;
  }
  
  public void setVerticalThrottle(float paramFloat)
  {
    this.verticalThrottle = paramFloat;
  }
  
  public void setYaw(float paramFloat)
  {
    this.yaw = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\virtualstick\FlightControlData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */