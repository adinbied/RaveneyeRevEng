package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleCtrlTrackSelect
  extends DataBase
  implements DJIDataSyncListener
{
  private short mSessionId = 0;
  private TrackCtrlState mState = TrackCtrlState.CONFIRM;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleCtrlTrackSelect setCtrlState(TrackCtrlState paramTrackCtrlState)
  {
    this.mState = paramTrackCtrlState;
    return this;
  }
  
  public DataSingleCtrlTrackSelect setSessionId(short paramShort)
  {
    this.mSessionId = paramShort;
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
  
  public static enum TrackCtrlState
  {
    private int data;
    
    static
    {
      TrackCtrlState localTrackCtrlState = new TrackCtrlState("OTHER", 3, 8);
      OTHER = localTrackCtrlState;
      $VALUES = new TrackCtrlState[] { CANCEL, CONFIRM, PAUSE, localTrackCtrlState };
    }
    
    private TrackCtrlState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackCtrlState find(int paramInt)
    {
      TrackCtrlState localTrackCtrlState = CONFIRM;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTrackCtrlState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleCtrlTrackSelect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */