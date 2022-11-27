package dji.common.airlink;

public enum OcuSyncBandwidth
{
  private int value;
  
  static
  {
    Bandwidth10MHz = new OcuSyncBandwidth("Bandwidth10MHz", 1, 1);
    OcuSyncBandwidth localOcuSyncBandwidth = new OcuSyncBandwidth("Unknown", 2, 255);
    Unknown = localOcuSyncBandwidth;
    $VALUES = new OcuSyncBandwidth[] { Bandwidth20MHz, Bandwidth10MHz, localOcuSyncBandwidth };
  }
  
  private OcuSyncBandwidth(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static OcuSyncBandwidth find(int paramInt)
  {
    OcuSyncBandwidth localOcuSyncBandwidth = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localOcuSyncBandwidth;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\OcuSyncBandwidth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */