package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleCheckPointPosValid
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSingleCheckPointPosValid instance;
  private float mPosX = 0.0F;
  private float mPosY = 0.0F;
  private short mSessionId = 0;
  
  public static DataSingleCheckPointPosValid getInstance()
  {
    if (instance == null) {
      instance = new DataSingleCheckPointPosValid();
    }
    return instance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleCheckPointPosValid setPosXY(float paramFloat1, float paramFloat2)
  {
    this.mPosX = paramFloat1;
    this.mPosY = paramFloat2;
    return this;
  }
  
  public DataSingleCheckPointPosValid setSessionId(short paramShort)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleCheckPointPosValid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */