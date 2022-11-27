package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWiFiSetWiFiCountryCodePlane
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWiFiSetWiFiCountryCodePlane instance;
  private String codeFor2Point4G;
  private String codeFor5G;
  private boolean is5GSupported;
  
  public static DataWiFiSetWiFiCountryCodePlane getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWiFiSetWiFiCountryCodePlane();
      }
      DataWiFiSetWiFiCountryCodePlane localDataWiFiSetWiFiCountryCodePlane = instance;
      return localDataWiFiSetWiFiCountryCodePlane;
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
  
  public boolean hasCountryCodeUpdated()
  {
    return false;
  }
  
  public DataWiFiSetWiFiCountryCodePlane set2Point4GCountryCode(String paramString)
  {
    this.codeFor2Point4G = paramString;
    return this;
  }
  
  public DataWiFiSetWiFiCountryCodePlane set5GCountryCode(String paramString)
  {
    this.codeFor5G = paramString;
    return this;
  }
  
  public DataWiFiSetWiFiCountryCodePlane setSupported5G(boolean paramBoolean)
  {
    this.is5GSupported = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWiFiSetWiFiCountryCodePlane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */