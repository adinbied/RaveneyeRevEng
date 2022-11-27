package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushDebugInfo
  extends DataBase
{
  private static DataOsdGetPushDebugInfo instance;
  
  public DataOsdGetPushDebugInfo() {}
  
  public DataOsdGetPushDebugInfo(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataOsdGetPushDebugInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushDebugInfo();
      }
      DataOsdGetPushDebugInfo localDataOsdGetPushDebugInfo = instance;
      return localDataOsdGetPushDebugInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public byte[] getData()
  {
    return null;
  }
  
  public DebugType getType()
  {
    return null;
  }
  
  public static enum DebugType
  {
    private final int data;
    
    static
    {
      DebugType localDebugType = new DebugType("OTHER", 3, 100);
      OTHER = localDebugType;
      $VALUES = new DebugType[] { OFDM, OFDM_G, SWEEP_G, localDebugType };
    }
    
    private DebugType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DebugType find(int paramInt)
    {
      DebugType localDebugType1 = OFDM;
      DebugType[] arrayOfDebugType = values();
      int j = arrayOfDebugType.length;
      int i = 0;
      while (i < j)
      {
        DebugType localDebugType2 = arrayOfDebugType[i];
        if (localDebugType2._equals(paramInt)) {
          return localDebugType2;
        }
        i += 1;
      }
      return localDebugType1;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushDebugInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */