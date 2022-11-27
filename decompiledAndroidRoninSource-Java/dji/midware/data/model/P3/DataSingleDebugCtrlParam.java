package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleDebugCtrlParam
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSingleDebugCtrlParam mInstance;
  private CtrlType mCtrlType = CtrlType.OTHER;
  private float mValue = 0.0F;
  
  public DataSingleDebugCtrlParam()
  {
    super(false);
  }
  
  public static DataSingleDebugCtrlParam getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSingleDebugCtrlParam();
    }
    return mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleDebugCtrlParam setCtrlParam(CtrlType paramCtrlType, float paramFloat)
  {
    this.mCtrlType = paramCtrlType;
    this.mValue = paramFloat;
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
  
  public static enum CtrlType
  {
    private final int data;
    
    static
    {
      CLEAR_OBSTACLE = new CtrlType("CLEAR_OBSTACLE", 1, 100);
      TAPFLY_RESET = new CtrlType("TAPFLY_RESET", 2, 408);
      FIXWING_GIMBALCTRL = new CtrlType("FIXWING_GIMBALCTRL", 3, 416);
      CtrlType localCtrlType = new CtrlType("OTHER", 4, 10000);
      OTHER = localCtrlType;
      $VALUES = new CtrlType[] { TRACKING_MAXIMUM_SPEED, CLEAR_OBSTACLE, TAPFLY_RESET, FIXWING_GIMBALCTRL, localCtrlType };
    }
    
    private CtrlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CtrlType find(int paramInt)
    {
      CtrlType localCtrlType1 = TAPFLY_RESET;
      CtrlType[] arrayOfCtrlType = values();
      int j = arrayOfCtrlType.length;
      int i = 0;
      while (i < j)
      {
        CtrlType localCtrlType2 = arrayOfCtrlType[i];
        if (localCtrlType2._equals(paramInt)) {
          return localCtrlType2;
        }
        i += 1;
      }
      return localCtrlType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleDebugCtrlParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */