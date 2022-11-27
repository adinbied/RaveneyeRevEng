package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushMicInfo
  extends DataBase
{
  private static DataOsdGetPushMicInfo instance;
  
  public static DataOsdGetPushMicInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushMicInfo();
      }
      DataOsdGetPushMicInfo localDataOsdGetPushMicInfo = instance;
      return localDataOsdGetPushMicInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public MIC_TYPE getMicType()
  {
    return null;
  }
  
  public int getMicVolume()
  {
    return 0;
  }
  
  public static enum MIC_TYPE
  {
    private int data;
    
    static
    {
      MIC_TYPE localMIC_TYPE = new MIC_TYPE("OTHER", 2, 2);
      OTHER = localMIC_TYPE;
      $VALUES = new MIC_TYPE[] { IN, OUT, localMIC_TYPE };
    }
    
    private MIC_TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MIC_TYPE find(int paramInt)
    {
      MIC_TYPE localMIC_TYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMIC_TYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushMicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */