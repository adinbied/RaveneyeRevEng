package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleCommonCtrl
  extends DataBase
  implements DJIDataSyncListener
{
  private CtrlState mCtrlCmd = CtrlState.NORMAL;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleCommonCtrl setCtrlCmd(CtrlState paramCtrlState)
  {
    this.mCtrlCmd = paramCtrlState;
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
  
  public static enum CtrlState
  {
    private int data;
    
    static
    {
      CtrlState localCtrlState = new CtrlState("OTHER", 2, 8);
      OTHER = localCtrlState;
      $VALUES = new CtrlState[] { NORMAL, STOP, localCtrlState };
    }
    
    private CtrlState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CtrlState find(int paramInt)
    {
      CtrlState localCtrlState = NORMAL;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCtrlState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleCommonCtrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */