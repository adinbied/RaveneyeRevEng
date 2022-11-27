package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataFlycDownloadWayPointMsgByIndex
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycDownloadWayPointMsgByIndex instance;
  private int index;
  
  public static DataFlycDownloadWayPointMsgByIndex getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycDownloadWayPointMsgByIndex();
      }
      DataFlycDownloadWayPointMsgByIndex localDataFlycDownloadWayPointMsgByIndex = instance;
      return localDataFlycDownloadWayPointMsgByIndex;
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
  
  public ArrayList<DataFlycUploadWayPointMsgByIndex.ACTION> getAction()
  {
    return null;
  }
  
  public int getActionNum()
  {
    return 0;
  }
  
  public float getAltitude()
  {
    return 0.0F;
  }
  
  public int getCameraActionInterval()
  {
    return 0;
  }
  
  public int getCameraActionType()
  {
    return 0;
  }
  
  public float getDampingDis()
  {
    return 0.0F;
  }
  
  public boolean getHasAction()
  {
    return false;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public double getLatitude()
  {
    return 1.371872286E-315D;
  }
  
  public double getLongitude()
  {
    return 1.371872306E-315D;
  }
  
  public short getMaxReachTime()
  {
    return 0;
  }
  
  public ArrayList<Integer> getParameter()
  {
    return null;
  }
  
  public int getRepeatNum()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int getSpeed()
  {
    return 0;
  }
  
  public short getTgtPitch()
  {
    return 0;
  }
  
  public short getTgtYaw()
  {
    return 0;
  }
  
  public DataFlycUploadWayPointMsgByIndex.TURNMODE getTurnMode()
  {
    return null;
  }
  
  public boolean hasSpeed()
  {
    return false;
  }
  
  public DataFlycDownloadWayPointMsgByIndex setIndex(int paramInt)
  {
    this.index = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycDownloadWayPointMsgByIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */