package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetMicControl
  extends DataBase
  implements DJIDataSyncListener
{
  private int mInnerMicEnable = -1;
  private int mOutMicEnable = -1;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataOsdSetMicControl set(int paramInt1, int paramInt2)
  {
    this.mInnerMicEnable = paramInt1;
    this.mOutMicEnable = paramInt2;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetMicControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */