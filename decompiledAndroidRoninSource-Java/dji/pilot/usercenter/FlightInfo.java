package dji.pilot.usercenter;

import org.json.JSONObject;

public class FlightInfo
{
  public static final int DEVICE_TYPE_BATTERY = 11;
  public static final int DEVICE_TYPE_CAMERA = 1;
  public static final int DEVICE_TYPE_MC = 3;
  public static final int DEVICE_TYPE_NONE = 0;
  public static final int DEVICE_TYPE_RC = 14;
  public String mActiveDay = "";
  public String mAppVersion = "";
  public String mDeviceName = "";
  public int mDeviceType = 0;
  public String mEmail = "";
  public String mFirmwareVersion = "";
  public String mIp = "";
  public String mProductType = "";
  public String mSerialNum = "";
  
  public static FlightInfo parseJSON(JSONObject paramJSONObject, FlightInfo paramFlightInfo)
  {
    FlightInfo localFlightInfo = paramFlightInfo;
    if (paramJSONObject != null)
    {
      localFlightInfo = paramFlightInfo;
      if (paramFlightInfo == null) {
        localFlightInfo = new FlightInfo();
      }
    }
    try
    {
      localFlightInfo.mSerialNum = paramJSONObject.optString("sn", "");
      localFlightInfo.mDeviceType = paramJSONObject.optInt("deviceType", 0);
      localFlightInfo.mProductType = paramJSONObject.optString("productType", "");
      localFlightInfo.mEmail = paramJSONObject.optString("email", "");
      localFlightInfo.mAppVersion = paramJSONObject.optString("appVersion", "");
      localFlightInfo.mDeviceName = paramJSONObject.optString("deviceName", "");
      localFlightInfo.mActiveDay = paramJSONObject.optString("activeday", "");
      localFlightInfo.mIp = paramJSONObject.optString("ip", "");
      localFlightInfo.mFirmwareVersion = paramJSONObject.optString("firmwareVersion", "");
      return localFlightInfo;
    }
    catch (Exception paramJSONObject) {}
    return localFlightInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\FlightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */