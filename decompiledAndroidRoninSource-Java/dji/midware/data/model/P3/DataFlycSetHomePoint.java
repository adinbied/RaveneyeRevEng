package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetHomePoint
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetHomePoint instance;
  private HOMETYPE mHomeType = HOMETYPE.RC;
  private byte mInterval = 0;
  private double mLantitue = 0.0D;
  private double mLongtitue = 0.0D;
  
  public static DataFlycSetHomePoint getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetHomePoint();
      }
      DataFlycSetHomePoint localDataFlycSetHomePoint = instance;
      return localDataFlycSetHomePoint;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataFlycSetHomePoint setGpsInfo(double paramDouble1, double paramDouble2)
  {
    this.mLantitue = paramDouble1;
    this.mLongtitue = paramDouble2;
    return this;
  }
  
  public DataFlycSetHomePoint setHomeType(HOMETYPE paramHOMETYPE)
  {
    this.mHomeType = paramHOMETYPE;
    return this;
  }
  
  public DataFlycSetHomePoint setInerval(byte paramByte)
  {
    this.mInterval = paramByte;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum HOMETYPE
  {
    private byte mValue = 0;
    
    static
    {
      APP = new HOMETYPE("APP", 2, (byte)2);
      HOMETYPE localHOMETYPE = new HOMETYPE("FOLLOW", 3, (byte)3);
      FOLLOW = localHOMETYPE;
      $VALUES = new HOMETYPE[] { AIRCRAFT, RC, APP, localHOMETYPE };
    }
    
    private HOMETYPE(byte paramByte)
    {
      this.mValue = paramByte;
    }
    
    public static HOMETYPE ofValue(byte paramByte)
    {
      HOMETYPE[] arrayOfHOMETYPE = values();
      int j = arrayOfHOMETYPE.length;
      int i = 0;
      while (i < j)
      {
        HOMETYPE localHOMETYPE = arrayOfHOMETYPE[i];
        if (localHOMETYPE.belongs(paramByte)) {
          return localHOMETYPE;
        }
        i += 1;
      }
      return RC;
    }
    
    public boolean belongs(byte paramByte)
    {
      return this.mValue == paramByte;
    }
    
    public byte value()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetHomePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */