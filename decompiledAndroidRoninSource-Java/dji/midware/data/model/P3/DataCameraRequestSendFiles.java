package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraRequestSendFiles
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraRequestSendFiles instance;
  private FILE_SELECT_MODE mode = FILE_SELECT_MODE.CURRENT;
  
  public static DataCameraRequestSendFiles getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraRequestSendFiles();
      }
      DataCameraRequestSendFiles localDataCameraRequestSendFiles = instance;
      return localDataCameraRequestSendFiles;
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
  
  public DataCameraRequestSendFiles setMode(FILE_SELECT_MODE paramFILE_SELECT_MODE)
  {
    this.mode = paramFILE_SELECT_MODE;
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
  
  public static enum Error
  {
    private int data;
    
    static
    {
      Error localError = new Error("OTHER", 2, 100);
      OTHER = localError;
      $VALUES = new Error[] { FileNotFound, INVALID_CMD, localError };
    }
    
    private Error(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static Error find(int paramInt)
    {
      Error localError = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localError;
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
  
  public static enum FILE_SELECT_MODE
  {
    private int data;
    
    static
    {
      FILE_SELECT_MODE localFILE_SELECT_MODE = new FILE_SELECT_MODE("OTHER", 2, 100);
      OTHER = localFILE_SELECT_MODE;
      $VALUES = new FILE_SELECT_MODE[] { CURRENT, NEXT, localFILE_SELECT_MODE };
    }
    
    private FILE_SELECT_MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FILE_SELECT_MODE find(int paramInt)
    {
      FILE_SELECT_MODE localFILE_SELECT_MODE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFILE_SELECT_MODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraRequestSendFiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */