package dji.sdksharedlib.keycatalog.airlink;

import dji.common.airlink.WiFiFrequencyBand;
import dji.common.airlink.WiFiMagneticInterferenceLevel;
import dji.common.airlink.WifiChannelInterference;
import dji.common.airlink.WifiDataRate;
import dji.internal.mock.abstractions.MockWifiLinkFoldingDroneAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.airlink.wifi.DJIWifiLinkFoldingDroneAbstraction;
import dji.sdksharedlib.keycatalog.extension.Key;

public class WifiLinkKeys
  extends AirLinkKeys
{
  @Key(accessType=1, includedAbstractions={DJIWifiLinkFoldingDroneAbstraction.class, MockWifiLinkFoldingDroneAbstraction.class}, type=Integer[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String AVAILABLE_CHANNEL_NUMBERS = "AvailableChannelNumbers";
  @Key(accessType=1, includedAbstractions={DJIWifiLinkFoldingDroneAbstraction.class, MockWifiLinkFoldingDroneAbstraction.class}, type=WifiChannelInterference[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CHANNEL_INTERFERENCE = "ChannelInterference";
  @Key(accessType=3, includedAbstractions={DJIWifiLinkFoldingDroneAbstraction.class, MockWifiLinkFoldingDroneAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CHANNEL_NUMBER = "ChannelNumber";
  public static final String COMPONENT_KEY = "WifiLink";
  @Key(accessType=3, type=WifiDataRate.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String DATA_RATE = "DataRate";
  @Key(accessType=3, type=WiFiFrequencyBand.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FREQUENCY_BAND = "FrequencyBand";
  @Key(accessType=4, type=WiFiMagneticInterferenceLevel.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MAGNETIC_INTERFERENCE = "MagneticInterference";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PASSWORD = "Password";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String REBOOT = "Reboot";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SSID = "SSID";
  
  public WifiLinkKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\airlink\WifiLinkKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */