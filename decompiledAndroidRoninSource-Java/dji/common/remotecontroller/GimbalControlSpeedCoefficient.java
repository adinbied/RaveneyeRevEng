package dji.common.remotecontroller;

public class GimbalControlSpeedCoefficient
{
  private int pitchSpeedCoefficient;
  private int rollSpeedCoefficient;
  private int yawSpeedCoefficient;
  
  public GimbalControlSpeedCoefficient(int paramInt1, int paramInt2, int paramInt3)
  {
    this.pitchSpeedCoefficient = paramInt1;
    this.rollSpeedCoefficient = paramInt2;
    this.yawSpeedCoefficient = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getPitchSpeedCoefficient()
  {
    return this.pitchSpeedCoefficient;
  }
  
  public int getRollSpeedCoefficient()
  {
    return this.rollSpeedCoefficient;
  }
  
  public int getYawSpeedCoefficient()
  {
    return this.yawSpeedCoefficient;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalControlSpeedCoefficient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */