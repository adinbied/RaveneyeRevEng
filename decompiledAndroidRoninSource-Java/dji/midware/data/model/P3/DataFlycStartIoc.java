package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycStartIoc
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycStartIoc instance;
  private IOCType mIocType;
  
  public static DataFlycStartIoc getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycStartIoc();
      }
      DataFlycStartIoc localDataFlycStartIoc = instance;
      return localDataFlycStartIoc;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycStartIoc setMode(IOCType paramIOCType)
  {
    this.mIocType = paramIOCType;
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
  
  public static enum IOCType
  {
    private int data;
    
    static
    {
      IOCTripod = new IOCType("IOCTripod", 2, 3);
      IOCTypeHomeLockA2 = new IOCType("IOCTypeHomeLockA2", 3, 4);
      Cinematic = new IOCType("Cinematic", 4, 4);
      IOCType localIOCType = new IOCType("IOCTypeOther", 5, 100);
      IOCTypeOther = localIOCType;
      $VALUES = new IOCType[] { IOCTypeCourseLock, IOCTypeHomeLock, IOCTripod, IOCTypeHomeLockA2, Cinematic, localIOCType };
    }
    
    private IOCType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static IOCType find(int paramInt)
    {
      IOCType localIOCType = IOCTypeOther;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localIOCType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycStartIoc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */