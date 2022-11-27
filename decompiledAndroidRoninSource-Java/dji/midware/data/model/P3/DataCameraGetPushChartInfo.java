package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushChartInfo
  extends DataBase
{
  public static final int MAX_LENGTH = 64;
  private static DataCameraGetPushChartInfo instance;
  private final short[] mLightValues = new short[64];
  
  public static DataCameraGetPushChartInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushChartInfo();
      }
      DataCameraGetPushChartInfo localDataCameraGetPushChartInfo = instance;
      return localDataCameraGetPushChartInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public short[] getParams()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushChartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */