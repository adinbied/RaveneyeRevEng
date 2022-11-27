package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSaveParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSaveParams instance;
  private USER user = USER.DEFAULT;
  
  public static DataCameraSaveParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSaveParams();
      }
      DataCameraSaveParams localDataCameraSaveParams = instance;
      return localDataCameraSaveParams;
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
  
  public DataCameraSaveParams setMode(USER paramUSER)
  {
    this.user = paramUSER;
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
  
  public static enum USER
  {
    private int data;
    
    static
    {
      USER localUSER = new USER("OTHER", 5, 6);
      OTHER = localUSER;
      $VALUES = new USER[] { DEFAULT, USER1, USER2, USER3, USER4, localUSER };
    }
    
    private USER(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static USER find(int paramInt)
    {
      USER localUSER = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localUSER;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSaveParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */