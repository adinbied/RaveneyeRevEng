package dji.common.remotecontroller;

public enum PairingState
{
  private int value;
  
  static
  {
    PAIRING = new PairingState("PAIRING", 1, 1);
    PAIRED = new PairingState("PAIRED", 2, 2);
    PairingState localPairingState = new PairingState("UNKNOWN", 3, 3);
    UNKNOWN = localPairingState;
    $VALUES = new PairingState[] { UNPAIRED, PAIRING, PAIRED, localPairingState };
  }
  
  private PairingState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static PairingState find(int paramInt)
  {
    PairingState localPairingState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localPairingState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\PairingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */