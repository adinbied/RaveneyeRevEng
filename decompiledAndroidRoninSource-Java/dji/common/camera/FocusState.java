package dji.common.camera;

public class FocusState
{
  private SettingsDefinitions.FocusMode focusMode;
  private SettingsDefinitions.FocusStatus focusStatus;
  private boolean isAFSwitchOn;
  private boolean isFocusAssistantEnabledForAF;
  private boolean isFocusAssistantEnabledForMF;
  private boolean isFocusAssistantWorking;
  private boolean isLensMounted;
  
  private FocusState(Builder paramBuilder)
  {
    this.isLensMounted = paramBuilder.isLensMounted;
    this.isAFSwitchOn = paramBuilder.isAFSwitchOn;
    this.focusStatus = paramBuilder.focusStatus;
    this.focusMode = paramBuilder.focusMode;
    this.isFocusAssistantWorking = paramBuilder.isFocusAssistantWorking;
    this.isFocusAssistantEnabledForAF = paramBuilder.isFocusAssistantEnabledForAF;
    this.isFocusAssistantEnabledForMF = paramBuilder.isFocusAssistantEnabledForMF;
  }
  
  public SettingsDefinitions.FocusMode getFocusMode()
  {
    return this.focusMode;
  }
  
  public SettingsDefinitions.FocusStatus getFocusStatus()
  {
    return this.focusStatus;
  }
  
  public boolean isAFSwitchOn()
  {
    return this.isAFSwitchOn;
  }
  
  public boolean isFocusAssistantEnabledForAF()
  {
    return this.isFocusAssistantEnabledForAF;
  }
  
  public boolean isFocusAssistantEnabledForMF()
  {
    return this.isFocusAssistantEnabledForMF;
  }
  
  public boolean isFocusAssistantWorking()
  {
    return this.isFocusAssistantWorking;
  }
  
  public boolean isLensMounted()
  {
    return this.isLensMounted;
  }
  
  public static final class Builder
  {
    private SettingsDefinitions.FocusMode focusMode = SettingsDefinitions.FocusMode.UNKNOWN;
    private SettingsDefinitions.FocusStatus focusStatus = SettingsDefinitions.FocusStatus.UNKNOWN;
    private boolean isAFSwitchOn;
    private boolean isFocusAssistantEnabledForAF;
    private boolean isFocusAssistantEnabledForMF;
    private boolean isFocusAssistantWorking;
    private boolean isLensMounted;
    
    public FocusState build()
    {
      return new FocusState(this, null);
    }
    
    public Builder focusMode(SettingsDefinitions.FocusMode paramFocusMode)
    {
      this.focusMode = paramFocusMode;
      return this;
    }
    
    public Builder focusStatus(SettingsDefinitions.FocusStatus paramFocusStatus)
    {
      this.focusStatus = paramFocusStatus;
      return this;
    }
    
    public Builder isAFSwitchOn(boolean paramBoolean)
    {
      this.isAFSwitchOn = paramBoolean;
      return this;
    }
    
    public Builder isFocusAssistantEnabledForAF(boolean paramBoolean)
    {
      this.isFocusAssistantEnabledForAF = paramBoolean;
      return this;
    }
    
    public Builder isFocusAssistantEnabledForMF(boolean paramBoolean)
    {
      this.isFocusAssistantEnabledForMF = paramBoolean;
      return this;
    }
    
    public Builder isFocusAssistantWorking(boolean paramBoolean)
    {
      this.isFocusAssistantWorking = paramBoolean;
      return this;
    }
    
    public Builder isLensMounted(boolean paramBoolean)
    {
      this.isLensMounted = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(FocusState paramFocusState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\FocusState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */