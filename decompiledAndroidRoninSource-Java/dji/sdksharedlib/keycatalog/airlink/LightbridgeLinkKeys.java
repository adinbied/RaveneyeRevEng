package dji.sdksharedlib.keycatalog.airlink;

import dji.common.LightbridgePIPPosition;
import dji.common.LightbridgeSecondaryVideoFormat;
import dji.common.VideoDataChannel;
import dji.common.airlink.ChannelInterference;
import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.LightbridgeAntennaRSSI;
import dji.common.airlink.LightbridgeDataRate;
import dji.common.airlink.LightbridgeFrequencyBand;
import dji.common.airlink.LightbridgeSecondaryVideoDisplayMode;
import dji.common.airlink.LightbridgeSecondaryVideoOutputPort;
import dji.common.airlink.LightbridgeTransmissionMode;
import dji.common.airlink.LightbridgeUnit;
import dji.common.airlink.WorkingFrequency;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.DJIOcuSyncLinkAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.Lightbridge2Abstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.LightbridgeAbstraction;
import dji.sdksharedlib.keycatalog.extension.Key;

public class LightbridgeLinkKeys
  extends AirLinkKeys
{
  @Key(accessType=4, type=LightbridgeAntennaRSSI.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String AIRCRAFT_ANTENNA_RSSI = "AircraftAntennaRSSI";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String BANDWIDTH_ALLOCATION_FOR_HDMI_VIDEO_INPUT_PORT = "BandwidthAllocationForHDMIVideoInputPort";
  @Key(accessType=6, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String BANDWIDTH_ALLOCATION_FOR_LB_VIDEO_INPUT_PORT = "BandwidthAllocationForLBVideoInputPort";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CHANNEL = "Channel";
  @Key(accessType=1, type=Integer[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CHANNEL_RANGE = "ChannelRange";
  @Key(accessType=3, type=ChannelSelectionMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CHANNEL_SELECTION_MODE = "ChannelSelectionMode";
  public static final String COMPONENT_KEY = "LightbridgeLink";
  @Key(accessType=3, type=LightbridgeDataRate.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DATA_RATE = "DataRate";
  @Key(accessType=3, type=LightbridgeFrequencyBand.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FREQUENCY_BAND = "FrequencyBand";
  @Key(accessType=4, includedAbstractions={LightbridgeAbstraction.class}, type=ChannelInterference[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FREQUENCY_POINT_RSSIS = "ChannelRSSIs";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgeSecondaryVideoFormat.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String HDMI_OUTPUT_FORMAT = "HDMIOutputFormat";
  @Key(accessType=6, includedAbstractions={Lightbridge2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_EXT_VIDEO_INPUT_PORT_ENABLED = "isEXTVideoInputPortEnabled";
  @Key(accessType=6, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MAIN_CAMERA_BANDWIDTH_PERCENT = "MainVideoBandwidthPercent";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgePIPPosition.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PIP_POSITION = "PIPPosition";
  @Key(accessType=4, type=LightbridgeAntennaRSSI.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String REMOTE_CONTROLLER_ANTENNA_RSSI = "RemoteControllerAntennaRSSI";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgeSecondaryVideoFormat.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SDI_OUTPUT_FORMAT = "SDIOutputFormat";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgeSecondaryVideoDisplayMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_DISPLAY_MODE = "SecondaryVideoDisplayMode";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_BOTTOM_MARGIN = "SecondaryVideoOSDBottomMargin";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_ENABLED = "SecondaryVideoOSDEnabled";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_LEFT_MARGIN = "SecondaryVideoOSDLeftMargin";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_RIGHT_MARGIN = "SecondaryVideoOSDRightMargin";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_TOP_MARGIN = "SecondaryVideoOSDTopMargin";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgeUnit.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OSD_UNIT = "SecondaryVideoOSDUnits";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SECONDARY_VIDEO_OUTPUT_ENABLED = "SecondaryVideoOutputEnabled";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=LightbridgeSecondaryVideoOutputPort.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SECONDARY_VIDEO_OUTPUT_PORT = "SecondaryVideoOutputPort";
  @Key(accessType=1, type=LightbridgeFrequencyBand[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SUPPORTED_FREQUENCY_BANDS = "SupportedFrequencyBands";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class, DJIOcuSyncLinkAbstraction.class}, type=LightbridgeTransmissionMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRANSMISSION_MODE = "TransmissionMode";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=VideoDataChannel.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String VIDEO_DATA_CHANNEL = "VideoDataChannel";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=ChannelSelectionMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String VIDEO_SOURCE = "VideoSource";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class}, type=WorkingFrequency.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String WORKING_FREQUENCY = "WorkingFrequency";
  
  public LightbridgeLinkKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\airlink\LightbridgeLinkKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */