package dji.sdksharedlib.keycatalog.airlink;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.keycatalog.DJISDKCacheKeys;
import dji.sdksharedlib.keycatalog.extension.Key;

public class AirLinkKeys
  extends DJISDKCacheKeys
{
  public static final String COMPONENT_KEY = "AirLink";
  @Key(accessType=2, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String COUNTRY_CODE = "CountryCode";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DOWNLINK_SIGNAL_QUALITY = "DownlinkSignalQuality";
  @Key(accessType=1, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_LIGHTBRIDGE_LINK_SUPPORTED = "IsLightbridgeLinkSupported";
  @Key(accessType=1, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_WIFI_LINK_SUPPORTED = "IsWiFiLinkSupported";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String UPLINK_SIGNAL_QUALITY = "UplinkSignalQuality";
  
  public AirLinkKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\airlink\AirLinkKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */