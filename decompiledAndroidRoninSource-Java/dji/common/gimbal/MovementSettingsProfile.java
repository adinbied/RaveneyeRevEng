package dji.common.gimbal;

public enum MovementSettingsProfile
{
  private int value;
  
  static
  {
    MovementSettingsProfile localMovementSettingsProfile = new MovementSettingsProfile("UNKNOWN", 5, 255);
    UNKNOWN = localMovementSettingsProfile;
    $VALUES = new MovementSettingsProfile[] { CUSTOM_1, CUSTOM_2, FAST, MEDIUM, SLOW, localMovementSettingsProfile };
  }
  
  private MovementSettingsProfile(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MovementSettingsProfile find(int paramInt)
  {
    MovementSettingsProfile localMovementSettingsProfile = CUSTOM_1;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localMovementSettingsProfile;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\MovementSettingsProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */