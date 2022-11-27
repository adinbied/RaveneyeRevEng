package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycWayPointSetIdleSpeed
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycWayPointSetIdleSpeed instance;
  private float idleSpeed = 0.0F;
  
  public static DataFlycWayPointSetIdleSpeed getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycWayPointSetIdleSpeed();
      }
      DataFlycWayPointSetIdleSpeed localDataFlycWayPointSetIdleSpeed = instance;
      return localDataFlycWayPointSetIdleSpeed;
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
  
  public float getIdleSpeed()
  {
    return 0.0F;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public void setIdleSpeed(float paramFloat)
  {
    this.idleSpeed = paramFloat;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycWayPointSetIdleSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */