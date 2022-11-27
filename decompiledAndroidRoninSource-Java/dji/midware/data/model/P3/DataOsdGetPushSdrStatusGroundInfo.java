package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSdrStatusGroundInfo
  extends DataBase
{
  private static DataOsdGetPushSdrStatusGroundInfo instance;
  private String[] mTitleName = new String[32];
  private float[] mValue = new float[32];
  
  public static DataOsdGetPushSdrStatusGroundInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSdrStatusGroundInfo();
      }
      DataOsdGetPushSdrStatusGroundInfo localDataOsdGetPushSdrStatusGroundInfo = instance;
      return localDataOsdGetPushSdrStatusGroundInfo;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSdrStatusGroundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */