package dji.common.util;

import dji.common.camera.CameraSSDVideoLicense;
import dji.common.camera.ResolutionAndFrameRate;
import dji.common.camera.SettingsDefinitions.VideoFrameRate;
import dji.common.camera.SettingsDefinitions.VideoResolution;
import dji.midware.data.model.P3.DataCameraGetPushRawParams.RawMode;

public class DJICameraEnumMappingUtil
{
  public int getFrameRateProtocolValue(SettingsDefinitions.VideoFrameRate paramVideoFrameRate)
  {
    return 0;
  }
  
  public DataCameraGetPushRawParams.RawMode getRAWModeFromSDKLicense(CameraSSDVideoLicense paramCameraSSDVideoLicense)
  {
    return null;
  }
  
  public int getResolutionProtocolValue(SettingsDefinitions.VideoResolution paramVideoResolution)
  {
    return 0;
  }
  
  public CameraSSDVideoLicense getSDKLicenseFromRAWMode(DataCameraGetPushRawParams.RawMode paramRawMode)
  {
    return null;
  }
  
  public SettingsDefinitions.VideoFrameRate mapProtocolToFrameRate(int paramInt)
  {
    return null;
  }
  
  public SettingsDefinitions.VideoResolution mapProtocolToResolution(int paramInt)
  {
    return null;
  }
  
  public ResolutionAndFrameRate wrapResolutionAndFrameRate(int paramInt1, int paramInt2)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\DJICameraEnumMappingUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */