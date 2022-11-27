package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRonin2SetTimelapseParams
  extends DataBase
  implements DJIDataSyncListener
{
  public static final int MAX_ROTA_POSITION = 5;
  private static final String TAG = "DataRonin2SetTimelapseParams";
  private long mDuration;
  private byte mInfoByte;
  ArrayList<TimelapseRoadObject> roadList = new ArrayList();
  
  public boolean addRoadPosition(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataRonin2SetTimelapseParams setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public DataRonin2SetTimelapseParams setIsTripod(int paramInt)
  {
    return null;
  }
  
  public DataRonin2SetTimelapseParams setMode(int paramInt)
  {
    return null;
  }
  
  public DataRonin2SetTimelapseParams setStartOrPreview(int paramInt)
  {
    return null;
  }
  
  public DataRonin2SetTimelapseParams setStartOrStop(int paramInt)
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
    public long duration = 0L;
    public int pitch = 0;
    public int roll = 0;
    public int yaw = 0;
    
    public TimelapseRoadObject(long paramLong, int paramInt1, int paramInt2, int paramInt3)
    {
      this.duration = paramLong;
      this.roll = (paramInt1 * 10);
      this.pitch = (paramInt2 * 10);
      this.yaw = (paramInt3 * 10);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRonin2SetTimelapseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */