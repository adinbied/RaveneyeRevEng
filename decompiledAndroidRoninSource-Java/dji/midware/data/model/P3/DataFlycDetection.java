package dji.midware.data.model.P3;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DataBase;

public class DataFlycDetection
  extends DataBase
{
  private static DataFlycDetection instance;
  private SubCmdId curCmd = null;
  private String droneId;
  private String license;
  private byte[][] receDataList = new byte[SubCmdId.values().length][];
  private boolean[] switchList = new boolean[Switch.values().length];
  String uuid;
  
  public DataFlycDetection() {}
  
  public DataFlycDetection(SubCmdId paramSubCmdId)
  {
    this.curCmd = paramSubCmdId;
  }
  
  public static DataFlycDetection getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycDetection(null);
      }
      DataFlycDetection localDataFlycDetection = instance;
      return localDataFlycDetection;
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
  
  public String get2BoardSn()
  {
    return getBoardSn(1);
  }
  
  public String get2DroneId()
  {
    return null;
  }
  
  public String get2License()
  {
    return null;
  }
  
  public String[] getAllUUID()
  {
    return null;
  }
  
  public String getBoardSn()
  {
    return getBoardSn(3);
  }
  
  public String getBoardSn(int paramInt)
  {
    return null;
  }
  
  public Ccode getCcode()
  {
    return null;
  }
  
  public String getDroneId()
  {
    return null;
  }
  
  public boolean[] getEnable()
  {
    return null;
  }
  
  public int getHeight()
  {
    return 0;
  }
  
  public double getHomeLatitude()
  {
    return 1.37187096E-315D;
  }
  
  public double getHomeLongitude()
  {
    return 1.371870987E-315D;
  }
  
  public boolean getIsSetUUID()
  {
    return false;
  }
  
  public double getLatitude()
  {
    return 1.371871036E-315D;
  }
  
  public String getLicense()
  {
    return null;
  }
  
  public double getLongitude()
  {
    return 1.3718711E-315D;
  }
  
  public int getPitch()
  {
    return 0;
  }
  
  public int getRoll()
  {
    return 0;
  }
  
  public String getUUID()
  {
    return null;
  }
  
  public int getXSpeed()
  {
    return 0;
  }
  
  public int getYSpeed()
  {
    return 0;
  }
  
  public int getYaw()
  {
    return 0;
  }
  
  public int getZSpeed()
  {
    return 0;
  }
  
  /* Error */
  public void setDroneId(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setEnable(boolean[] paramArrayOfBoolean)
  {
    this.switchList = paramArrayOfBoolean;
  }
  
  /* Error */
  public void setLicense(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataFlycDetection setSubCmdId(SubCmdId paramSubCmdId)
  {
    this.curCmd = paramSubCmdId;
    return this;
  }
  
  public DataFlycDetection setUUID(String paramString)
  {
    this.uuid = paramString;
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
  
  public static enum SubCmdId
  {
    int data;
    
    static
    {
      GetLicense = new SubCmdId("GetLicense", 1, 2);
      SetDroneId = new SubCmdId("SetDroneId", 2, 3);
      GetDroneId = new SubCmdId("GetDroneId", 3, 4);
      SetSwitch = new SubCmdId("SetSwitch", 4, 5);
      GetSwitch = new SubCmdId("GetSwitch", 5, 6);
      SetUUID = new SubCmdId("SetUUID", 6, 7);
      GetUUID = new SubCmdId("GetUUID", 7, 8);
      GetIsSetUUID = new SubCmdId("GetIsSetUUID", 8, 9);
      SetDJIAppFlag = new SubCmdId("SetDJIAppFlag", 9, 10);
      GetAllUUID = new SubCmdId("GetAllUUID", 10, 11);
      PushOsd = new SubCmdId("PushOsd", 11, 16);
      PushLicense = new SubCmdId("PushLicense", 12, 17);
      SubCmdId localSubCmdId = new SubCmdId("Other", 13, 255);
      Other = localSubCmdId;
      $VALUES = new SubCmdId[] { SetLicense, GetLicense, SetDroneId, GetDroneId, SetSwitch, GetSwitch, SetUUID, GetUUID, GetIsSetUUID, SetDJIAppFlag, GetAllUUID, PushOsd, PushLicense, localSubCmdId };
    }
    
    private SubCmdId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SubCmdId find(int paramInt)
    {
      SubCmdId[] arrayOfSubCmdId = values();
      SubCmdId localSubCmdId = Other;
      int i = 0;
      while (i < arrayOfSubCmdId.length)
      {
        if (arrayOfSubCmdId[i]._equals(paramInt)) {
          return arrayOfSubCmdId[i];
        }
        i += 1;
      }
      return localSubCmdId;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum Switch
  {
    static
    {
      GPS = new Switch("GPS", 1);
      HomeGPS = new Switch("HomeGPS", 2);
      DroneId = new Switch("DroneId", 3);
      Switch localSwitch = new Switch("Liscense", 4);
      Liscense = localSwitch;
      $VALUES = new Switch[] { Sn, GPS, HomeGPS, DroneId, localSwitch };
    }
    
    private Switch() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycDetection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */