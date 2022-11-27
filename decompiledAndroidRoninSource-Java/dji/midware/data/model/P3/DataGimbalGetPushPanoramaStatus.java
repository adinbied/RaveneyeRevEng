package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataGimbalGetPushPanoramaStatus
  extends DataBase
{
  private static final String TAG = "DataGimbalGetPushTimelapseStatus";
  private static final DataGimbalGetPushPanoramaStatus mInstance = new DataGimbalGetPushPanoramaStatus();
  
  public static DataGimbalGetPushPanoramaStatus getInstance()
  {
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getCurPicture()
  {
    return 0;
  }
  
  public int getStatus()
  {
    return 0;
  }
  
  public int getTotalPictures()
  {
    return 0;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    start();
    return super.isChanged(paramArrayOfByte);
  }
  
  /* Error */
  protected void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGimbalGetPushPanoramaStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */