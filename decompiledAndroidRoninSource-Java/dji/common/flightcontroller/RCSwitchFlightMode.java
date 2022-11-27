package dji.common.flightcontroller;

import dji.sdksharedlib.extension.CacheHelper;

public enum RCSwitchFlightMode
{
  static
  {
    A = new RCSwitchFlightMode("A", 1);
    P = new RCSwitchFlightMode("P", 2);
    S = new RCSwitchFlightMode("S", 3);
    G = new RCSwitchFlightMode("G", 4);
    M = new RCSwitchFlightMode("M", 5);
    RCSwitchFlightMode localRCSwitchFlightMode = new RCSwitchFlightMode("UNKNOWN", 6);
    UNKNOWN = localRCSwitchFlightMode;
    $VALUES = new RCSwitchFlightMode[] { F, A, P, S, G, M, localRCSwitchFlightMode };
  }
  
  private RCSwitchFlightMode() {}
  
  public boolean isMissionAvailable()
  {
    if (((String)CacheHelper.getFlightController("FirmwareVersion")).compareTo("03.02") >= 0) {
      return equals(P);
    }
    return equals(F);
  }
  
  public boolean isTypeGSPMode()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\RCSwitchFlightMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */