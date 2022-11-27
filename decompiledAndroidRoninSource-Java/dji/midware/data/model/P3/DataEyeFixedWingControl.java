package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeFixedWingControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeFixedWingControl instance;
  private FixedWingCtrlType mRequestType = FixedWingCtrlType.OTHER;
  
  public static DataEyeFixedWingControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeFixedWingControl();
      }
      DataEyeFixedWingControl localDataEyeFixedWingControl = instance;
      return localDataEyeFixedWingControl;
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
  
  public DataEyeFixedWingControl setRequestType(FixedWingCtrlType paramFixedWingCtrlType)
  {
    this.mRequestType = paramFixedWingCtrlType;
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
  
  public static enum FixedWingCtrlType
  {
    private final int data;
    
    static
    {
      ENTER = new FixedWingCtrlType("ENTER", 1, 1);
      EXIT = new FixedWingCtrlType("EXIT", 2, 2);
      FixedWingCtrlType localFixedWingCtrlType = new FixedWingCtrlType("OTHER", 3, 100);
      OTHER = localFixedWingCtrlType;
      $VALUES = new FixedWingCtrlType[] { READY, ENTER, EXIT, localFixedWingCtrlType };
    }
    
    private FixedWingCtrlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FixedWingCtrlType find(int paramInt)
    {
      FixedWingCtrlType localFixedWingCtrlType1 = READY;
      FixedWingCtrlType[] arrayOfFixedWingCtrlType = values();
      int j = arrayOfFixedWingCtrlType.length;
      int i = 0;
      while (i < j)
      {
        FixedWingCtrlType localFixedWingCtrlType2 = arrayOfFixedWingCtrlType[i];
        if (localFixedWingCtrlType2._equals(paramInt)) {
          return localFixedWingCtrlType2;
        }
        i += 1;
      }
      return localFixedWingCtrlType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeFixedWingControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */