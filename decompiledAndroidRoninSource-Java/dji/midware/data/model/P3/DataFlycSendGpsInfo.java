package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSendGpsInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSendGpsInfo instance;
  private double latitude;
  private double longitude;
  private short mAltitude = 0;
  private short mHeading = 0;
  
  public static DataFlycSendGpsInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSendGpsInfo();
      }
      DataFlycSendGpsInfo localDataFlycSendGpsInfo = instance;
      return localDataFlycSendGpsInfo;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycSendGpsInfo setAltitude(short paramShort)
  {
    this.mAltitude = paramShort;
    return this;
  }
  
  public DataFlycSendGpsInfo setHeading(short paramShort)
  {
    this.mHeading = paramShort;
    return this;
  }
  
  public DataFlycSendGpsInfo setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
    return this;
  }
  
  public DataFlycSendGpsInfo setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSendGpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */