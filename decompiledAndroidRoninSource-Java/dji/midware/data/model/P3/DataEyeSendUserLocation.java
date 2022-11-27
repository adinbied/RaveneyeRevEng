package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeSendUserLocation
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeSendUserLocation instance;
  private short mAccuracy = 0;
  private float mEastSpeed = 0.0F;
  private double mLantitue = 0.0D;
  private double mLongtitue = 0.0D;
  private float mNorthSpeed = 0.0F;
  
  public static DataEyeSendUserLocation getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeSendUserLocation();
      }
      DataEyeSendUserLocation localDataEyeSendUserLocation = instance;
      return localDataEyeSendUserLocation;
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
  
  public DataEyeSendUserLocation setAccuracy(short paramShort)
  {
    this.mAccuracy = paramShort;
    return this;
  }
  
  public DataEyeSendUserLocation setLocation(double paramDouble1, double paramDouble2)
  {
    this.mLongtitue = paramDouble1;
    this.mLantitue = paramDouble2;
    return this;
  }
  
  public DataEyeSendUserLocation setSpeed(float paramFloat1, float paramFloat2)
  {
    this.mNorthSpeed = paramFloat1;
    this.mEastSpeed = paramFloat2;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSendUserLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */