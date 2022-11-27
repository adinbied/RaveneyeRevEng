package dji.midware.data.model.common;

public enum DJIMonitorFreqSupportType
{
  private final int value;
  
  static
  {
    DJIMonitorFreqSupportType localDJIMonitorFreqSupportType = new DJIMonitorFreqSupportType("Unknown", 3, -1);
    Unknown = localDJIMonitorFreqSupportType;
    $VALUES = new DJIMonitorFreqSupportType[] { Support_2_4_G_Only, Support_5_G_Only, Support_Dual_Band, localDJIMonitorFreqSupportType };
  }
  
  private DJIMonitorFreqSupportType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static DJIMonitorFreqSupportType find(int paramInt)
  {
    DJIMonitorFreqSupportType localDJIMonitorFreqSupportType = Unknown;
    DJIMonitorFreqSupportType[] arrayOfDJIMonitorFreqSupportType = values();
    int i = 0;
    while (i < arrayOfDJIMonitorFreqSupportType.length)
    {
      if (arrayOfDJIMonitorFreqSupportType[i]._equals(paramInt)) {
        return arrayOfDJIMonitorFreqSupportType[i];
      }
      i += 1;
    }
    return localDJIMonitorFreqSupportType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\common\DJIMonitorFreqSupportType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */