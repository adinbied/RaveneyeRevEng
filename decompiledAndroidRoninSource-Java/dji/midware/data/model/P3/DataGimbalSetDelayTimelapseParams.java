package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataGimbalSetDelayTimelapseParams
  extends DataBase
  implements DJIDataSyncListener
{
  public static final int MAX_ROTA_POSITION = 5;
  private static final String TAG = "DataGimbalSetTimelapseParams";
  private static DataGimbalSetDelayTimelapseParams instance;
  private byte mInfoByte;
  ArrayList<TimelapseRoadObject> roadList = new ArrayList();
  
  public static DataGimbalSetDelayTimelapseParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataGimbalSetDelayTimelapseParams();
      }
      DataGimbalSetDelayTimelapseParams localDataGimbalSetDelayTimelapseParams = instance;
      return localDataGimbalSetDelayTimelapseParams;
    }
    finally {}
  }
  
  public boolean addRoadPosition(int paramInt, short paramShort1, short paramShort2, short paramShort3)
  {
    return false;
  }
  
  /* Error */
  public void clearPoint()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataGimbalSetDelayTimelapseParams setControlExternalDevice(boolean paramBoolean)
  {
    return null;
  }
  
  public DataGimbalSetDelayTimelapseParams setISPreview(int paramInt)
  {
    return null;
  }
  
  public DataGimbalSetDelayTimelapseParams setIsTripod(int paramInt)
  {
    return null;
  }
  
  public DataGimbalSetDelayTimelapseParams setMode(int paramInt)
  {
    return null;
  }
  
  public DataGimbalSetDelayTimelapseParams setStartOrStop(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class TimelapseRoadObject
  {
    public int duration = 0;
    public short pitch = 0;
    public short roll = 0;
    public short yaw = 0;
    
    public TimelapseRoadObject(int paramInt, short paramShort1, short paramShort2, short paramShort3)
    {
      this.duration = paramInt;
      this.roll = paramShort1;
      this.pitch = paramShort2;
      this.yaw = paramShort3;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalSetDelayTimelapseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */