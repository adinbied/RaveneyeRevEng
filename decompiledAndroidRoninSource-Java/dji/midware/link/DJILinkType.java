package dji.midware.link;

public enum DJILinkType
{
  static
  {
    NON = new DJILinkType("NON", 4);
    DJILinkType localDJILinkType = new DJILinkType("BLE", 5);
    BLE = localDJILinkType;
    $VALUES = new DJILinkType[] { AOA, HOST, HOSTRC, WIFI, NON, localDJILinkType };
  }
  
  private DJILinkType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\link\DJILinkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */