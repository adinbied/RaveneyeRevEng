package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraVideoControl
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraVideoControl instance;
  private int progress;
  private ControlType type;
  
  public static DataCameraVideoControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraVideoControl();
      }
      DataCameraVideoControl localDataCameraVideoControl = instance;
      return localDataCameraVideoControl;
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
  
  public DataCameraVideoControl setControlType(ControlType paramControlType)
  {
    this.type = paramControlType;
    return this;
  }
  
  public DataCameraVideoControl setProgress(int paramInt)
  {
    this.progress = paramInt;
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
  
  public static enum ControlType
  {
    private int data;
    
    static
    {
      Start = new ControlType("Start", 1, 1);
      FastForword = new ControlType("FastForword", 2, 2);
      FastReverse = new ControlType("FastReverse", 3, 3);
      StepTo = new ControlType("StepTo", 4, 4);
      Pause = new ControlType("Pause", 5, 5);
      ControlType localControlType = new ControlType("OTHER", 6, 100);
      OTHER = localControlType;
      $VALUES = new ControlType[] { Stop, Start, FastForword, FastReverse, StepTo, Pause, localControlType };
    }
    
    private ControlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ControlType find(int paramInt)
    {
      ControlType localControlType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localControlType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraVideoControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */