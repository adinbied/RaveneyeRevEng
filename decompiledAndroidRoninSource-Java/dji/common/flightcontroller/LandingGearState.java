package dji.common.flightcontroller;

public enum LandingGearState
{
  private byte _value = 0;
  
  static
  {
    DEPLOYED = new LandingGearState("DEPLOYED", 1, (byte)1);
    RETRACTED = new LandingGearState("RETRACTED", 2, (byte)3);
    DEPLOYING = new LandingGearState("DEPLOYING", 3, (byte)2);
    RETRACTING = new LandingGearState("RETRACTING", 4, (byte)4);
    LandingGearState localLandingGearState = new LandingGearState("STOPPED", 5, (byte)5);
    STOPPED = localLandingGearState;
    $VALUES = new LandingGearState[] { UNKNOWN, DEPLOYED, RETRACTED, DEPLOYING, RETRACTING, localLandingGearState };
  }
  
  private LandingGearState(byte paramByte)
  {
    this._value = paramByte;
  }
  
  public static LandingGearState find(byte paramByte)
  {
    LandingGearState localLandingGearState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramByte)) {
        return values()[i];
      }
      i += 1;
    }
    return localLandingGearState;
  }
  
  public boolean _equals(byte paramByte)
  {
    return this._value == paramByte;
  }
  
  public byte value()
  {
    return this._value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\LandingGearState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */