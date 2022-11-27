package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSetFileIndexMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSetFileIndexMode instance;
  private FileIndexMode mMode = FileIndexMode.RESET;
  
  public static DataCameraSetFileIndexMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetFileIndexMode();
      }
      DataCameraSetFileIndexMode localDataCameraSetFileIndexMode = instance;
      return localDataCameraSetFileIndexMode;
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
  
  public void setFileIndexMode(FileIndexMode paramFileIndexMode)
  {
    this.mMode = paramFileIndexMode;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FileIndexMode
  {
    private int data;
    
    static
    {
      FileIndexMode localFileIndexMode = new FileIndexMode("CONTINUOUS", 1, 1);
      CONTINUOUS = localFileIndexMode;
      $VALUES = new FileIndexMode[] { RESET, localFileIndexMode };
    }
    
    private FileIndexMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FileIndexMode find(int paramInt)
    {
      FileIndexMode localFileIndexMode = RESET;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFileIndexMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetFileIndexMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */