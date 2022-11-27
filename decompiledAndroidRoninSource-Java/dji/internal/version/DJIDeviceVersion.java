package dji.internal.version;

import dji.midware.data.config.P3.DeviceType;

public class DJIDeviceVersion
{
  private static final String TAG = "FirmwareVersion";
  public DeviceType deviceType = null;
  public String firmware = null;
  public int moduleId = -1;
  public long version = -1L;
  public String versionStr = null;
  
  public DJIDeviceVersion(String paramString)
  {
    setFirmware(paramString);
  }
  
  public DJIDeviceVersion(String paramString1, String paramString2)
  {
    setFirmware(paramString1);
    setVersion(paramString2);
  }
  
  /* Error */
  public void setFirmware(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setVersion(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIDeviceVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */