package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushDCFInfo
  extends DJICameraDataBase
{
  private static DataCameraGetPushDCFInfo instance;
  
  public static DataCameraGetPushDCFInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushDCFInfo();
      }
      DataCameraGetPushDCFInfo localDataCameraGetPushDCFInfo = instance;
      return localDataCameraGetPushDCFInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getFileListMD5()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushDCFInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */