package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonSetAppGpsCyclic
  extends DataBase
  implements DJIDataSyncListener
{
  private float mHeight = -1.0F;
  private double mLatitude = -1.0D;
  private double mLongitude = -1.0D;
  private int mNum = -1;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCommonSetAppGpsCyclic setPushData(int paramInt, double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.mNum = paramInt;
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
    this.mHeight = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonSetAppGpsCyclic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */