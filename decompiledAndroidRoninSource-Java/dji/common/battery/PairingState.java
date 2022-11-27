package dji.common.battery;

public enum PairingState
{
  static
  {
    PairingState localPairingState = new PairingState("UNKNOWN", 2);
    UNKNOWN = localPairingState;
    $VALUES = new PairingState[] { PAIRED, UNPAIRED, localPairingState };
  }
  
  private PairingState() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\PairingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */