package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.base.IExpModeSetter;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetExposureMode
  extends DataBase
  implements DJIDataSyncListener, IExpModeSetter
{
  private static DataCameraSetExposureMode instance;
  private int expMode;
  private int senceMode;
  
  public static DataCameraSetExposureMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetExposureMode();
      }
      DataCameraSetExposureMode localDataCameraSetExposureMode = instance;
      return localDataCameraSetExposureMode;
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
  
  public DataCameraSetExposureMode setExpMode(int paramInt)
  {
    this.expMode = paramInt;
    return this;
  }
  
  public DataCameraSetExposureMode setSenceMode(int paramInt)
  {
    this.senceMode = paramInt;
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
  
  public static enum ExposureMode
  {
    private int data;
    
    static
    {
      A = new ExposureMode("A", 3, 3);
      M = new ExposureMode("M", 4, 4);
      B = new ExposureMode("B", 5, 5);
      SCN = new ExposureMode("SCN", 6, 6);
      C = new ExposureMode("C", 7, 7);
      ExposureMode localExposureMode = new ExposureMode("OTHER", 8, 100);
      OTHER = localExposureMode;
      $VALUES = new ExposureMode[] { AUTO, P, S, A, M, B, SCN, C, localExposureMode };
    }
    
    private ExposureMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ExposureMode find(int paramInt)
    {
      ExposureMode localExposureMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localExposureMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetExposureMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */