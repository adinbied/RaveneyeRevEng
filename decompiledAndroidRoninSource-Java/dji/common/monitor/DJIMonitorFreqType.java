package dji.common.monitor;

public enum DJIMonitorFreqType
{
  private final int mValue;
  
  static
  {
    DJIMonitorFreqType localDJIMonitorFreqType = new DJIMonitorFreqType("Unknown", 3, -1);
    Unknown = localDJIMonitorFreqType;
    $VALUES = new DJIMonitorFreqType[] { Freq_2_4_G, Freq_5_G, Freq_Auto, localDJIMonitorFreqType };
  }
  
  private DJIMonitorFreqType(int paramInt)
  {
    this.mValue = paramInt;
  }
  
  public static DJIMonitorFreqType find(int paramInt)
  {
    DJIMonitorFreqType localDJIMonitorFreqType = Unknown;
    DJIMonitorFreqType[] arrayOfDJIMonitorFreqType = values();
    int i = 0;
    while (i < arrayOfDJIMonitorFreqType.length)
    {
      if (arrayOfDJIMonitorFreqType[i]._equals(paramInt)) {
        return arrayOfDJIMonitorFreqType[i];
      }
      i += 1;
    }
    return localDJIMonitorFreqType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.mValue == paramInt;
  }
  
  public int value()
  {
    return this.mValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\monitor\DJIMonitorFreqType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */