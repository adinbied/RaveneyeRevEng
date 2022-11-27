package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.base.IExpShutterSetter;

public class DataCameraSetShutterSpeed
  extends DataBase
  implements IExpShutterSetter
{
  private static DataCameraSetShutterSpeed instance;
  private int decimal;
  private int integral;
  private int isReciprocal;
  private TYPE type;
  
  public static DataCameraSetShutterSpeed getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSetShutterSpeed();
      }
      DataCameraSetShutterSpeed localDataCameraSetShutterSpeed = instance;
      return localDataCameraSetShutterSpeed;
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
  
  public DataCameraSetShutterSpeed setAbsolute(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataCameraSetShutterSpeed setAuto()
  {
    this.type = TYPE.AUTO;
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
      TYPE localTYPE = new TYPE("OTHER", 2, 100);
      OTHER = localTYPE;
      $VALUES = new TYPE[] { AUTO, Manual, localTYPE };
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetShutterSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */