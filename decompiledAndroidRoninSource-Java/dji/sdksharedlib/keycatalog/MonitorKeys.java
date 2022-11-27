package dji.sdksharedlib.keycatalog;

import dji.common.airlink.WifiChannelInterference;
import dji.common.monitor.DJIMonitorFreqType;
import dji.midware.data.model.P3.DataCameraSetTrackingParms.TrackingParam;
import dji.midware.data.model.P3.DataCameraSetVideoEncode.VideoEncodeType;
import dji.midware.data.model.P3.DataMonitorGetPushType.MonitorType;
import dji.midware.data.model.P3.DataSingleVisualParam.FollowSpeed;
import dji.midware.data.model.P3.DataSmartGetTrackPush.TrackRect;
import dji.midware.data.model.P3.DataSmartGetTrackPush.TrackState;
import dji.midware.data.model.common.DJIMonitorFreqSupportType;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.keycatalog.extension.Key;

public class MonitorKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CHANNEL = "Channel";
  public static final String COMPONENT_KEY = "Monitor";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String COUNTRY_CODE = "CountryCode";
  @Key(accessType=3, type=DJIMonitorFreqType.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FREQUENCY = "Frequency";
  @Key(accessType=4, type=DJIMonitorFreqSupportType.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FREQUENCY_SUPPORT = "FrequencySupport";
  @Key(accessType=1, type=DataCameraSetVideoEncode.VideoEncodeType.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GET_IMAGE_STREAM_ENCODE_FORMAT = "GetImageStreamEncodeFormat";
  @Key(accessType=4, type=DataMonitorGetPushType.MonitorType.class)
  public static final String MONITOR_TYPE = "MonitorType";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PASSWORD = "Password";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESTART = "Restart";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SERIAL_NUMBER = "SerialNumber";
  @Key(accessType=2, type=DataCameraSetVideoEncode.VideoEncodeType.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SET_IMAGE_STREAM_ENCODE_FORMAT = "SetImageStreamEncodeFormat";
  @Key(accessType=2, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SET_MONITOR_TIME_STAMP = "SetMonitorTimeStamp";
  @Key(accessType=2, type=DataCameraSetTrackingParms.TrackingParam.class)
  public static final String SET_TRACKING = "SetTracking";
  @Key(accessType=2, type=DataSingleVisualParam.FollowSpeed.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SET_TRACKING_FOLLOW_SPEED = "SetTrackingFollowSpeed";
  @Key(accessType=2, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SET_TRACKING_FOV_CALIBRATE = "SetTrackingFovCalibrate";
  @Key(accessType=4, type=WifiChannelInterference[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String SNR_LIST = "SnrList";
  @Key(accessType=8, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SNR_PUSH_ENABLED = "SnrPushEnabled";
  @Key(accessType=4, type=Integer.class)
  public static final String TRACKING_FOLLOW_SPEED = "TrackingFollowSpeed";
  @Key(accessType=4, type=Integer.class)
  public static final String TRACKING_FOV_CALIBRATE_PROGRESS = "TrackingFovCalibrateProgress";
  @Key(accessType=4, type=Integer.class)
  public static final String TRACKING_FOV_CALIBRATE_STATE = "TrackingFovCalibrateState";
  @Key(accessType=4, type=DataSmartGetTrackPush.TrackRect.class)
  public static final String TRACKING_RECT = "TrackingRect";
  @Key(accessType=4, type=DataSmartGetTrackPush.TrackState.class)
  public static final String TRACKING_STATE = "TrackingState";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String WIFI_SSID = "WifiSSID";
  
  public MonitorKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "Monitor";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\MonitorKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */