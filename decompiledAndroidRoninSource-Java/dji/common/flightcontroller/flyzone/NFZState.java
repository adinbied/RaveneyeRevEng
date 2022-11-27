package dji.common.flightcontroller.flyzone;

public enum NFZState
{
  private int data;
  
  static
  {
    AUTO_LANDING_FORCED = new NFZState("AUTO_LANDING_FORCED", 2, 2);
    APPROACHING_NO_FLY_ZONE = new NFZState("APPROACHING_NO_FLY_ZONE", 3, 3);
    UNDER_LIMIT_FLY_ZONE = new NFZState("UNDER_LIMIT_FLY_ZONE", 4, 6);
    AT_NFZ_HEIGHT_LIMIT = new NFZState("AT_NFZ_HEIGHT_LIMIT", 5, 8);
    NFZState localNFZState = new NFZState("UNKNOWN_STATE", 6, 255);
    UNKNOWN_STATE = localNFZState;
    $VALUES = new NFZState[] { FLYING_NORMALLY, TAKEOFF_PROHIBITED, AUTO_LANDING_FORCED, APPROACHING_NO_FLY_ZONE, UNDER_LIMIT_FLY_ZONE, AT_NFZ_HEIGHT_LIMIT, localNFZState };
  }
  
  private NFZState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static NFZState find(int paramInt)
  {
    NFZState localNFZState = UNKNOWN_STATE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localNFZState;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flyzone\NFZState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */