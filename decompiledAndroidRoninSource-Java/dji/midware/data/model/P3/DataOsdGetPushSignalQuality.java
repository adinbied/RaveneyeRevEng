package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.packages.P3.Pack;

public class DataOsdGetPushSignalQuality
  extends DataBase
{
  private static DataOsdGetPushSignalQuality instance;
  private int Aerial1DownSignalQuality;
  private int Aerial1UpSignalQuality;
  private int Aerial2DownSignalQuality;
  private int Aerial2UpSignalQuality;
  private int downSignalQuality;
  private int upSignalQuality;
  
  public static DataOsdGetPushSignalQuality getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataOsdGetPushSignalQuality = new DataOsdGetPushSignalQuality();
        instance = localDataOsdGetPushSignalQuality;
        localDataOsdGetPushSignalQuality.isNeedPushLosed = true;
        instance.isRemoteModel = false;
      }
      DataOsdGetPushSignalQuality localDataOsdGetPushSignalQuality = instance;
      return localDataOsdGetPushSignalQuality;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAerial1DownSignalQuality()
  {
    return 0;
  }
  
  public int getAerial1UpSignalQuality()
  {
    return 0;
  }
  
  public int getAerial2DownSignalQuality()
  {
    return 0;
  }
  
  public int getAerial2UpSignalQuality()
  {
    return 0;
  }
  
  public int getDownSignalQuality()
  {
    return 0;
  }
  
  public byte[] getResource()
  {
    return this._recData;
  }
  
  public int getUpSignalQuality()
  {
    return 0;
  }
  
  public boolean isGetRcQuality()
  {
    return false;
  }
  
  protected void setPushRecPack(Pack paramPack)
  {
    super.setPushRecPack(paramPack);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushSignalQuality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */