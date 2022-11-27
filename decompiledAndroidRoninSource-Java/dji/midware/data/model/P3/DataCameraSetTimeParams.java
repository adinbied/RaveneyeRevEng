package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetTimeParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetTimeParams instance;
  private int num;
  private int period;
  private TYPE type;
  
  public static DataCameraSetTimeParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetTimeParams();
      }
      DataCameraSetTimeParams localDataCameraSetTimeParams = instance;
      return localDataCameraSetTimeParams;
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
  
  public DataCameraSetTimeParams setNum(int paramInt)
  {
    this.num = paramInt;
    return this;
  }
  
  public DataCameraSetTimeParams setPeriod(int paramInt)
  {
    this.period = paramInt;
    return this;
  }
  
  public DataCameraSetTimeParams setType(TYPE paramTYPE)
  {
    this.type = paramTYPE;
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
  
  public static enum TYPE
  {
    private int data;
    
    static
    {
      Multiple = new TYPE("Multiple", 1, 1);
      Timelapse = new TYPE("Timelapse", 2, 2);
      TYPE localTYPE = new TYPE("OTHER", 3, 100);
      OTHER = localTYPE;
      $VALUES = new TYPE[] { Single, Multiple, Timelapse, localTYPE };
    }
    
    private TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TYPE find(int paramInt)
    {
      TYPE localTYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTYPE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetTimeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */