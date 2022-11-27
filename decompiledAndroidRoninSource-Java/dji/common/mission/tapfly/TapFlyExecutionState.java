package dji.common.mission.tapfly;

import android.graphics.PointF;

public class TapFlyExecutionState
{
  private final BypassDirection bypassDirection;
  private final Vector direction;
  private final PointF imageLocation;
  private final float relativeHeading;
  private final float speed;
  
  private TapFlyExecutionState(Vector paramVector, BypassDirection paramBypassDirection, float paramFloat1, float paramFloat2)
  {
    this.direction = paramVector;
    this.bypassDirection = paramBypassDirection;
    this.relativeHeading = paramFloat1;
    this.imageLocation = getTapFlyPointFromTapFlyDirection(paramVector);
    this.speed = paramFloat2;
  }
  
  private PointF getTapFlyPointFromTapFlyDirection(Vector paramVector)
  {
    return null;
  }
  
  public BypassDirection getBypassDirection()
  {
    return this.bypassDirection;
  }
  
  public Vector getDirection()
  {
    return this.direction;
  }
  
  public PointF getImageLocation()
  {
    return this.imageLocation;
  }
  
  public float getRelativeHeading()
  {
    return this.relativeHeading;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public static class Builder
  {
    private BypassDirection bypassDirection;
    private Vector direction;
    private PointF imageLocation;
    private float relativeHeading;
    private float speed;
    
    public TapFlyExecutionState build()
    {
      return null;
    }
    
    public Builder bypassDirection(BypassDirection paramBypassDirection)
    {
      this.bypassDirection = paramBypassDirection;
      return this;
    }
    
    public Builder direction(Vector paramVector)
    {
      this.direction = paramVector;
      return this;
    }
    
    public Builder imageLocation(PointF paramPointF)
    {
      this.imageLocation = paramPointF;
      return this;
    }
    
    public Builder relativeHeading(float paramFloat)
    {
      this.relativeHeading = paramFloat;
      return this;
    }
    
    public Builder speed(float paramFloat)
    {
      this.speed = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\tapfly\TapFlyExecutionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */