package dji.common.gimbal;

public class Attitude
{
  private float pitch;
  private float roll;
  private float yaw;
  
  public Attitude(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.pitch = paramFloat1;
    this.roll = paramFloat2;
    this.yaw = paramFloat3;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public float getPitch()
  {
    return this.pitch;
  }
  
  public float getRoll()
  {
    return this.roll;
  }
  
  public float getYaw()
  {
    return this.yaw;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\Attitude.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */