package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycFormatDataRecorder
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycFormatDataRecorder instance;
  private FORMAT_ACTION mFormatAction = FORMAT_ACTION.FORMAT;
  
  public static DataFlycFormatDataRecorder getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycFormatDataRecorder();
      }
      DataFlycFormatDataRecorder localDataFlycFormatDataRecorder = instance;
      return localDataFlycFormatDataRecorder;
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
  
  public DataFlycFormatDataRecorder setAction(FORMAT_ACTION paramFORMAT_ACTION)
  {
    this.mFormatAction = paramFORMAT_ACTION;
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
  
  public static enum FORMAT_ACTION
  {
    private int data;
    
    static
    {
      FORMAT = new FORMAT_ACTION("FORMAT", 1, 1);
      DELOLDFILES = new FORMAT_ACTION("DELOLDFILES", 2, 2);
      TEST = new FORMAT_ACTION("TEST", 3, 3);
      FORMAT_ACTION localFORMAT_ACTION = new FORMAT_ACTION("OTHER", 4, 100);
      OTHER = localFORMAT_ACTION;
      $VALUES = new FORMAT_ACTION[] { UNDEFINE, FORMAT, DELOLDFILES, TEST, localFORMAT_ACTION };
    }
    
    private FORMAT_ACTION(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FORMAT_ACTION find(int paramInt)
    {
      FORMAT_ACTION localFORMAT_ACTION = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFORMAT_ACTION;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycFormatDataRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */