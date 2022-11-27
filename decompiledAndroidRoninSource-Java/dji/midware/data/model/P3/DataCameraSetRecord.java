package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.SendPack;
import dji.midware.interfaces.DJIDataAsyncListener;
import java.util.Timer;
import java.util.TimerTask;

public class DataCameraSetRecord
  extends DataBase
  implements DJIDataAsyncListener
{
  private static DataCameraSetRecord instance;
  private Timer timer;
  private TYPE type;
  
  public static DataCameraSetRecord getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetRecord();
      }
      DataCameraSetRecord localDataCameraSetRecord = instance;
      return localDataCameraSetRecord;
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
  
  public DataCameraSetRecord setType(TYPE paramTYPE)
  {
    this.type = paramTYPE;
    return this;
  }
  
  /* Error */
  public void start(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop()
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
      START = new TYPE("START", 1, 1);
      PAUSE = new TYPE("PAUSE", 2, 2);
      RESUME = new TYPE("RESUME", 3, 3);
      TYPE localTYPE = new TYPE("OTHER", 4, 7);
      OTHER = localTYPE;
      $VALUES = new TYPE[] { STOP, START, PAUSE, RESUME, localTYPE };
    }
    
    private TYPE(int paramInt)
    {
      this.data = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */