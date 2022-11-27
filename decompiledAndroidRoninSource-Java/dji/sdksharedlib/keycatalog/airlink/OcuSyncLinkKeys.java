package dji.sdksharedlib.keycatalog.airlink;

import dji.common.airlink.ChannelSelectionMode;
import dji.common.airlink.FrequencyInterference;
import dji.common.airlink.LightbridgeTransmissionMode;
import dji.common.airlink.OcuSyncBandwidth;
import dji.common.airlink.OcuSyncWarningMessage;
import dji.common.airlink.SDRHdOffsetParams;
import dji.midware.data.model.P3.DataOsdGetPushSDRNfParams.DisLossEvent;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.DJIOcuSyncLinkAbstraction;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.Lightbridge2Abstraction;
import dji.sdksharedlib.keycatalog.extension.Key;

public class OcuSyncLinkKeys
  extends AirLinkKeys
{
  @Key(accessType=3, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=OcuSyncBandwidth.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String BANDWIDTH = "Bandwidth";
  @Key(accessType=3, type=ChannelSelectionMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CHANNEL_SELECTION_MODE = "ChannelSelectionMode";
  public static final String COMPONENT_KEY = "OcuSyncLink";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DYNAMIC_DATA_RATE = "DynamicDataRate";
  @Key(accessType=3, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FREQUENCY_POINT_INDEX = "FrequencyPointIndex";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=Float[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FREQUENCY_POINT_INDEX_VALID_RANGE = "FrequencyPointIndexValidRange";
  @Key(accessType=1, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=FrequencyInterference[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FREQUENCY_POINT_RSSIS = "FrequencyPointRSSIs";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String HD_DIST_OFFSET = "HdDistOffset";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=SDRHdOffsetParams.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String HD_OFFSET_PARAM_VALUES = "HdOffsetParamValues";
  @Key(accessType=3, includedAbstractions={Lightbridge2Abstraction.class, DJIOcuSyncLinkAbstraction.class}, type=LightbridgeTransmissionMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRANSMISSION_MODE = "TransmissionMode";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=DataOsdGetPushSDRNfParams.DisLossEvent.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String USR_CONFIG_EVENT = "UsrConfigEvent";
  @Key(accessType=4, includedAbstractions={DJIOcuSyncLinkAbstraction.class}, type=OcuSyncWarningMessage[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String WARNING_MESSAGES = "WarningMessages";
  
  public OcuSyncLinkKeys(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\airlink\OcuSyncLinkKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */