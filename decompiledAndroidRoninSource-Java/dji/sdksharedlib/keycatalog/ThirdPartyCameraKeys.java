package dji.sdksharedlib.keycatalog;

import dji.common.camera.FrameInfo;
import dji.midware.data.model.hg702.CameraParamType;
import dji.midware.data.model.hg702.CameraType;
import dji.midware.data.model.hg702.CaptureStatus;
import dji.midware.data.model.hg702.EVMode;
import dji.midware.data.model.hg702.LineType;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.keycatalog.extension.Key;

public class ThirdPartyCameraKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=4, type=String.class)
  public static final String APERTURE = "Aperture";
  @Key(accessType=4, type=CameraType.class)
  public static final String CAMERA_TYPE = "CameraType";
  @Key(accessType=4, type=CaptureStatus.class)
  public static final String CAPTURE_STATUS = "CaptureStatus";
  public static final String COMPONENT_KEY = "ThirdPartyCamera";
  @Key(accessType=4, type=String.class)
  public static final String EV = "EV";
  @Key(accessType=4, type=EVMode.class)
  public static final String EV_MODE = "EVMode";
  @Key(accessType=4, type=Integer.class)
  public static final String FOCUS_RANK = "FocusRank";
  @Key(accessType=1, type=FrameInfo.class)
  public static final String GET_FRAME_INFO = "GetFrameInfo";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GET_TABLE = "GetTable";
  @Key(accessType=4, type=String.class)
  public static final String ISO = "ISO";
  @Key(accessType=4, type=LineType.class)
  public static final String LINE_TYPE = "LineType";
  @Key(accessType=4, type=Boolean.class)
  public static final String MONITOR_CONTROL = "MonitorControl";
  @Key(accessType=8, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SET_FRAME = "SetFrame";
  @Key(accessType=8, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SET_PARAM = "SetParam";
  @Key(accessType=4, type=String.class)
  public static final String SHUTTER = "Shutter";
  @Key(accessType=4, type=Boolean.class)
  public static final String SHUTTER_CONNECTED = "ShutterConnected";
  @Key(accessType=8, type=CameraParamType.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SUBSCRIBE = "Subscribe";
  @Key(accessType=4, type=Integer.class)
  public static final String ZOOM_RANK = "ZoomRank";
  
  public ThirdPartyCameraKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "ThirdPartyCamera";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\ThirdPartyCameraKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */