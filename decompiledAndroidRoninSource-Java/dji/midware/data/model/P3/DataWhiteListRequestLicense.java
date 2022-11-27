package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWhiteListRequestLicense
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int DATA_START_POSITION = 36;
  private static final int DESCRIPTION_START_POSITION = 0;
  private static final int END_TIME_START_POSITION = 24;
  private static final int FACTOR = 1000000;
  private static final int HEADER_LENGTH = 4;
  private static final int LEVEL_START_POSITION = 31;
  private static final int LICENSE_ID_START_POSITION = 32;
  private static final int START_TIME_START_POISITION = 20;
  private static final int TYPE_START_POSITION = 30;
  private static DataWhiteListRequestLicense instance;
  private int requestId = -1;
  
  public static DataWhiteListRequestLicense getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWhiteListRequestLicense();
      }
      DataWhiteListRequestLicense localDataWhiteListRequestLicense = instance;
      return localDataWhiteListRequestLicense;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getCircleUnlockAreaLatitude()
  {
    return 0.0F;
  }
  
  public int getCircleUnlockAreaLimitedHeight()
  {
    return 0;
  }
  
  public float getCircleUnlockAreaLongitude()
  {
    return 0.0F;
  }
  
  public int getCircleUnlockAreaRadius()
  {
    return 0;
  }
  
  public int getCountryUnlockId()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return null;
  }
  
  public byte[] getDescription()
  {
    return null;
  }
  
  public byte[] getEndTime()
  {
    return null;
  }
  
  public int[] getGEOAreaIds()
  {
    return null;
  }
  
  public int getLevel()
  {
    return 0;
  }
  
  public byte[] getLicenseBytes()
  {
    return null;
  }
  
  public int getLicenseId()
  {
    return 0;
  }
  
  public int getParameterConfigurationType()
  {
    return 0;
  }
  
  public int[] getParameterConfigurationValues()
  {
    return null;
  }
  
  public float[][] getPentagonUnlockAreaPoints()
  {
    return null;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public byte[] getStartTime()
  {
    return null;
  }
  
  public int getTotalNumberOfLicense()
  {
    return 0;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public boolean isEnable()
  {
    return false;
  }
  
  public boolean isValid()
  {
    return false;
  }
  
  public DataWhiteListRequestLicense setRequestId(int paramInt)
  {
    this.requestId = paramInt;
    return this;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWhiteListRequestLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */