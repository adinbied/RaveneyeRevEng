package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdGetSdrConfig
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdGetSdrConfig instance;
  
  public static DataOsdGetSdrConfig getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetSdrConfig();
      }
      DataOsdGetSdrConfig localDataOsdGetSdrConfig = instance;
      return localDataOsdGetSdrConfig;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAutoChannel()
  {
    return 0;
  }
  
  public float getAutoChannelShow()
  {
    return 0.0F;
  }
  
  public float getAutoMcs()
  {
    return 0.0F;
  }
  
  public int getBandwidthType()
  {
    return 0;
  }
  
  public int getChannel()
  {
    return 0;
  }
  
  public boolean getIsAuto()
  {
    return false;
  }
  
  public boolean getIsMaster()
  {
    return false;
  }
  
  public int getMcs()
  {
    return 0;
  }
  
  public int getMcsType()
  {
    return 0;
  }
  
  public int getSdrBand()
  {
    return 0;
  }
  
  public int getSdrNf()
  {
    return 0;
  }
  
  public int getSelectionMode()
  {
    return 0;
  }
  
  public boolean getSingleOrDouble()
  {
    return false;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetSdrConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */