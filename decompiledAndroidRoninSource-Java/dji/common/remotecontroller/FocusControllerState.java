package dji.common.remotecontroller;

public class FocusControllerState
{
  private ControlType controlType;
  private Direction direction;
  private boolean isWorking;
  
  private FocusControllerState(Builder paramBuilder)
  {
    this.isWorking = paramBuilder.isWorking;
    this.controlType = paramBuilder.controlType;
    this.direction = paramBuilder.direction;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public ControlType getControlType()
  {
    return this.controlType;
  }
  
  public Direction getDirection()
  {
    return this.direction;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isWorking()
  {
    return this.isWorking;
  }
  
  public static final class Builder
  {
    private FocusControllerState.ControlType controlType;
    private FocusControllerState.Direction direction;
    private boolean isWorking;
    
    public FocusControllerState build()
    {
      return new FocusControllerState(this, null);
    }
    
    public Builder controlType(FocusControllerState.ControlType paramControlType)
    {
      this.controlType = paramControlType;
      return this;
    }
    
    public Builder direction(FocusControllerState.Direction paramDirection)
    {
      this.direction = paramDirection;
      return this;
    }
    
    public Builder isWorking(boolean paramBoolean)
    {
      this.isWorking = paramBoolean;
      return this;
    }
  }
  
  public static enum ControlType
  {
    static
    {
      ControlType localControlType = new ControlType("UNKNOWN", 3);
      UNKNOWN = localControlType;
      $VALUES = new ControlType[] { APERTURE, FOCAL_LENGTH, FOCUS_DISTANCE, localControlType };
    }
    
    private ControlType() {}
  }
  
  public static enum Direction
  {
    static
    {
      Direction localDirection = new Direction("UNKNOWN", 2);
      UNKNOWN = localDirection;
      $VALUES = new Direction[] { CLOCKWISE, COUNTER_CLOCKWISE, localDirection };
    }
    
    private Direction() {}
  }
  
  public static abstract interface FocusControllerStateCallback
  {
    public abstract void onUpdate(FocusControllerState paramFocusControllerState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\FocusControllerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */