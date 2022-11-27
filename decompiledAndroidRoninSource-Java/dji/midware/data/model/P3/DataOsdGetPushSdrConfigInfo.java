package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataOsdGetPushSdrConfigInfo
  extends DataBase
{
  private static DataOsdGetPushSdrConfigInfo instance;
  
  public static DataOsdGetPushSdrConfigInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushSdrConfigInfo();
      }
      DataOsdGetPushSdrConfigInfo localDataOsdGetPushSdrConfigInfo = instance;
      return localDataOsdGetPushSdrConfigInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public float getAutoChannelShow()
  {
    return 0.0F;
  }
  
  public float getAutoMcs()
  {
    return 0.0F;
  }
  
  public int getBand()
  {
    return 0;
  }
  
  public int getChannel()
  {
    return 0;
  }
  
  public int getMcsType()
  {
    return 0;
  }
  
  public int getNF()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSdrConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */