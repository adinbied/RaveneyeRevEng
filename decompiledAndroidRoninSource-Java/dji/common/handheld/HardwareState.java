package dji.common.handheld;

import dji.common.Stick;

public class HardwareState
{
  private final boolean isTriggerBeingPressed;
  private final RecordAndShutterButtons recordAndShutterButtons;
  private final Stick stick;
  private final StickHorizontalDirection stickHorizontalDirection;
  private final StickVerticalDirection stickVerticalDirection;
  private final TriggerButton triggerButton;
  
  private HardwareState(Builder paramBuilder)
  {
    this.recordAndShutterButtons = paramBuilder.recordAndShutterButtons;
    this.triggerButton = paramBuilder.triggerButton;
    this.stickVerticalDirection = paramBuilder.stickVerticalDirection;
    this.stickHorizontalDirection = paramBuilder.stickHorizontalDirection;
    this.stick = paramBuilder.stick;
    this.isTriggerBeingPressed = paramBuilder.isTriggerBeingPressed;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public RecordAndShutterButtons getRecordAndShutterButtons()
  {
    return this.recordAndShutterButtons;
  }
  
  public Stick getStick()
  {
    return this.stick;
  }
  
  public StickHorizontalDirection getStickHorizontalDirection()
  {
    return this.stickHorizontalDirection;
  }
  
  public StickVerticalDirection getStickVerticalDirection()
  {
    return this.stickVerticalDirection;
  }
  
  public TriggerButton getTriggerButton()
  {
    return this.triggerButton;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isTriggerBeingPressed()
  {
    return this.isTriggerBeingPressed;
  }
  
  public static final class Builder
  {
    private boolean isTriggerBeingPressed;
    private RecordAndShutterButtons recordAndShutterButtons;
    private Stick stick = new Stick(0, 0);
    private StickHorizontalDirection stickHorizontalDirection;
    private StickVerticalDirection stickVerticalDirection;
    private TriggerButton triggerButton;
    
    public HardwareState build()
    {
      return new HardwareState(this, null);
    }
    
    public Builder isTriggerBeingPressed(boolean paramBoolean)
    {
      this.isTriggerBeingPressed = paramBoolean;
      return this;
    }
    
    public Builder recordAndShutterButtons(RecordAndShutterButtons paramRecordAndShutterButtons)
    {
      this.recordAndShutterButtons = paramRecordAndShutterButtons;
      return this;
    }
    
    public Builder stick(Stick paramStick)
    {
      this.stick = paramStick;
      return this;
    }
    
    public Builder stickHorizontalDirection(StickHorizontalDirection paramStickHorizontalDirection)
    {
      this.stickHorizontalDirection = paramStickHorizontalDirection;
      return this;
    }
    
    public Builder stickVerticalDirection(StickVerticalDirection paramStickVerticalDirection)
    {
      this.stickVerticalDirection = paramStickVerticalDirection;
      return this;
    }
    
    public Builder triggerButton(TriggerButton paramTriggerButton)
    {
      this.triggerButton = paramTriggerButton;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(HardwareState paramHardwareState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\HardwareState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */