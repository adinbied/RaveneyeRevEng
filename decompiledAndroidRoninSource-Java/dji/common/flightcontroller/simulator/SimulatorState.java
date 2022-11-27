package dji.common.flightcontroller.simulator;

import dji.common.model.LocationCoordinate2D;

public class SimulatorState
{
  private final boolean areMotorsOn;
  private final boolean isFlying;
  private final LocationCoordinate2D location;
  private final float pitch;
  private final float positionX;
  private final float positionY;
  private final float positionZ;
  private final float roll;
  private final float yaw;
  
  private SimulatorState(Builder paramBuilder)
  {
    this.areMotorsOn = paramBuilder.areMotorsOn;
    this.isFlying = paramBuilder.isFlying;
    this.pitch = paramBuilder.pitch;
    this.roll = paramBuilder.roll;
    this.yaw = paramBuilder.yaw;
    this.positionX = paramBuilder.positionX;
    this.positionY = paramBuilder.positionY;
    this.positionZ = paramBuilder.positionZ;
    this.location = paramBuilder.location;
  }
  
  public boolean areMotorsOn()
  {
    return this.areMotorsOn;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public LocationCoordinate2D getLocation()
  {
    return this.location;
  }
  
  public float getPitch()
  {
    return this.pitch;
  }
  
  public float getPositionX()
  {
    return this.positionX;
  }
  
  public float getPositionY()
  {
    return this.positionY;
  }
  
  public float getPositionZ()
  {
    return this.positionZ;
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
  
  public boolean isFlying()
  {
    return this.isFlying;
  }
  
  public static final class Builder
  {
    private boolean areMotorsOn;
    private boolean isFlying;
    private LocationCoordinate2D location;
    private float pitch;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float roll;
    private float yaw;
    
    public Builder areMotorsOn(boolean paramBoolean)
    {
      this.areMotorsOn = paramBoolean;
      return this;
    }
    
    public SimulatorState build()
    {
      return new SimulatorState(this, null);
    }
    
    public Builder isFlying(boolean paramBoolean)
    {
      this.isFlying = paramBoolean;
      return this;
    }
    
    public Builder location(LocationCoordinate2D paramLocationCoordinate2D)
    {
      this.location = paramLocationCoordinate2D;
      return this;
    }
    
    public Builder pitch(float paramFloat)
    {
      this.pitch = paramFloat;
      return this;
    }
    
    public Builder positionX(float paramFloat)
    {
      this.positionX = paramFloat;
      return this;
    }
    
    public Builder positionY(float paramFloat)
    {
      this.positionY = paramFloat;
      return this;
    }
    
    public Builder positionZ(float paramFloat)
    {
      this.positionZ = paramFloat;
      return this;
    }
    
    public Builder roll(float paramFloat)
    {
      this.roll = paramFloat;
      return this;
    }
    
    public Builder yaw(float paramFloat)
    {
      this.yaw = paramFloat;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(SimulatorState paramSimulatorState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\simulator\SimulatorState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */