package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraSetAction
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataThirdPartyCameraSetAction instance;
  private int actionValue = ThirdPartyCameraAction.OTHER.value();
  private boolean mMonitorControl;
  
  public static DataThirdPartyCameraSetAction getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataThirdPartyCameraSetAction();
      }
      DataThirdPartyCameraSetAction localDataThirdPartyCameraSetAction = instance;
      return localDataThirdPartyCameraSetAction;
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
  
  public DataThirdPartyCameraSetAction setAction(ThirdPartyCameraAction paramThirdPartyCameraAction)
  {
    this.actionValue = paramThirdPartyCameraAction.value();
    return this;
  }
  
  public DataThirdPartyCameraSetAction setMonitorControl(boolean paramBoolean)
  {
    this.mMonitorControl = paramBoolean;
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
  
  public static enum ThirdPartyCameraAction
  {
    private int data;
    
    static
    {
      START_RECORD = new ThirdPartyCameraAction("START_RECORD", 2, 3);
      STOP_RECORD = new ThirdPartyCameraAction("STOP_RECORD", 3, 4);
      CENTER_AF = new ThirdPartyCameraAction("CENTER_AF", 4, 5);
      FOCUS_OFFSET = new ThirdPartyCameraAction("FOCUS_OFFSET", 5, 6);
      ThirdPartyCameraAction localThirdPartyCameraAction = new ThirdPartyCameraAction("OTHER", 6, 100);
      OTHER = localThirdPartyCameraAction;
      $VALUES = new ThirdPartyCameraAction[] { CAPTURE, STOP_CAPTURE, START_RECORD, STOP_RECORD, CENTER_AF, FOCUS_OFFSET, localThirdPartyCameraAction };
    }
    
    private ThirdPartyCameraAction(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ThirdPartyCameraAction find(int paramInt)
    {
      ThirdPartyCameraAction localThirdPartyCameraAction = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThirdPartyCameraAction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraSetAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */