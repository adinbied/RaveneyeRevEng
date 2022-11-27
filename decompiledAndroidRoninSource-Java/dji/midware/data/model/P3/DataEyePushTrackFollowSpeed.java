package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyePushTrackFollowSpeed
  extends DataBase
{
  private static final String TAG = "DataEyePushTrackFollowSpeed";
  private static volatile DataEyePushTrackFollowSpeed mInstance;
  
  public static DataEyePushTrackFollowSpeed getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DataEyePushTrackFollowSpeed();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public DataSingleVisualParam.FollowSpeed getFollowSpeed()
  {
    return null;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyePushTrackFollowSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */