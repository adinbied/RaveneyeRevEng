package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushPrepareOpenFan
  extends DJICameraDataBase
{
  private static DataCameraGetPushPrepareOpenFan instance;
  
  public static DataCameraGetPushPrepareOpenFan getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushPrepareOpenFan();
      }
      DataCameraGetPushPrepareOpenFan localDataCameraGetPushPrepareOpenFan = instance;
      return localDataCameraGetPushPrepareOpenFan;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getLeftSeconds()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushPrepareOpenFan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */