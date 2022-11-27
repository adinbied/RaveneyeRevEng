package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushFovParam
  extends DJICameraDataBase
{
  private static DataCameraGetPushFovParam instance;
  private float mFovH = 0.0F;
  private float mFovV = 0.0F;
  
  public static DataCameraGetPushFovParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushFovParam();
      }
      DataCameraGetPushFovParam localDataCameraGetPushFovParam = instance;
      return localDataCameraGetPushFovParam;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getFovH()
  {
    return 0.0F;
  }
  
  public float getFovV()
  {
    return 0.0F;
  }
  
  public int getImageHeight()
  {
    return 0;
  }
  
  public int getImageRatio()
  {
    return 0;
  }
  
  public int getImageWidth()
  {
    return 0;
  }
  
  public int getLensFocalLength()
  {
    return 0;
  }
  
  public boolean hasFovData()
  {
    return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushFovParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */