package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRemoteControllerGetParam
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRemoteControllerGetParam instance;
  private int type = 0;
  
  public static DataRemoteControllerGetParam getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRemoteControllerGetParam();
      }
      DataRemoteControllerGetParam localDataRemoteControllerGetParam = instance;
      return localDataRemoteControllerGetParam;
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
  
  public int[] getChannelRange()
  {
    return null;
  }
  
  public int getCountryCode()
  {
    return 0;
  }
  
  public ParamType getParamType()
  {
    return null;
  }
  
  public boolean is2point4GSupported()
  {
    return false;
  }
  
  public boolean is5point7GSupported()
  {
    return false;
  }
  
  public boolean is5point8GSupported()
  {
    return false;
  }
  
  public DataRemoteControllerGetParam setType(ParamType paramParamType)
  {
    this.type = paramParamType.value;
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
  
  public static enum ParamType
  {
    private final int value;
    
    static
    {
      FREQUENCY_BAND_2POINT4G_RANGE = new ParamType("FREQUENCY_BAND_2POINT4G_RANGE", 2, 3);
      FREQUENCY_BAND_5POINT7G_RANGE = new ParamType("FREQUENCY_BAND_5POINT7G_RANGE", 3, 4);
      FREQUENCY_BAND_5POINT8G_RANGE = new ParamType("FREQUENCY_BAND_5POINT8G_RANGE", 4, 5);
      GPS = new ParamType("GPS", 5, 6);
      ParamType localParamType = new ParamType("UNKNOWN", 6, 255);
      UNKNOWN = localParamType;
      $VALUES = new ParamType[] { COUNTRY_CODE, SUPPORTED_FREQUENCY_BAND, FREQUENCY_BAND_2POINT4G_RANGE, FREQUENCY_BAND_5POINT7G_RANGE, FREQUENCY_BAND_5POINT8G_RANGE, GPS, localParamType };
    }
    
    private ParamType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static ParamType find(int paramInt)
    {
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return UNKNOWN;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRemoteControllerGetParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */