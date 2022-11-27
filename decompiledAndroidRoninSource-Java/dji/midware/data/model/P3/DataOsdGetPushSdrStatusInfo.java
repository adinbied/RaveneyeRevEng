package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSdrStatusInfo
  extends DataBase
{
  private static DataOsdGetPushSdrStatusInfo instance;
  private String[] mTitleName = new String[32];
  private float[] mValue = new float[32];
  
  public static DataOsdGetPushSdrStatusInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSdrStatusInfo();
      }
      DataOsdGetPushSdrStatusInfo localDataOsdGetPushSdrStatusInfo = instance;
      return localDataOsdGetPushSdrStatusInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String[] getTitleList()
  {
    return null;
  }
  
  public float[] getValueList()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSdrStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */