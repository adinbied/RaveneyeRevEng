package dji.common.gimbal;

public class Rotation
{
  public static final float NO_ROTATION = Float.MAX_VALUE;
  private final RotationMode mode;
  private final float pitch;
  private final float roll;
  private final double time;
  private final float yaw;
  
  private Rotation(Builder paramBuilder)
  {
    this.mode = paramBuilder.mode;
    this.pitch = paramBuilder.pitch;
    this.roll = paramBuilder.roll;
    this.yaw = paramBuilder.yaw;
    this.time = paramBuilder.time;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public RotationMode getMode()
  {
    return this.mode;
  }
  
  public float getPitch()
  {
    return this.pitch;
  }
  
  public float getRoll()
  {
    return this.roll;
  }
  
  public double getTime()
  {
    return this.time;
  }
  
  public float getYaw()
  {
    return this.yaw;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public static final class Builder
  {
    private RotationMode mode;
    private float pitch = Float.MAX_VALUE;
    private float roll = Float.MAX_VALUE;
    private double time;
    private float yaw = Float.MAX_VALUE;
    
    public Builder() {}
    
    public Builder(Rotation paramRotation)
    {
      this.mode = paramRotation.getMode();
      this.pitch = paramRotation.getPitch();
      this.roll = paramRotation.getRoll();
      this.yaw = paramRotation.getYaw();
      this.time = paramRotation.getTime();
    }
    
    public Rotation build()
    {
      return new Rotation(this, null);
    }
    
    public Builder mode(RotationMode paramRotationMode)
    {
      this.mode = paramRotationMode;
      return this;
    }
    
    public Builder pitch(float paramFloat)
    {
      this.pitch = paramFloat;
      return this;
    }
    
    public Builder roll(float paramFloat)
    {
      this.roll = paramFloat;
      return this;
    }
    
    public Builder time(double paramDouble)
    {
      this.time = paramDouble;
      return this;
    }
    
    public Builder yaw(float paramFloat)
    {
      this.yaw = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\Rotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */