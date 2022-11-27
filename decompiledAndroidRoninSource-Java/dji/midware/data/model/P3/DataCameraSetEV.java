package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.base.IExpEVSetter;

public class DataCameraSetEV
  extends DataBase
  implements IExpEVSetter
{
  private int mExposureCompensation = 0;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraSetEV setEV(int paramInt)
  {
    this.mExposureCompensation = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSetEV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */