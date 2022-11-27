package dji.midware.util;

import dji.midware.component.DJIComponentManager.CameraComponentType;
import dji.midware.parser.plugins.DJIPluginLBChanneParser.DJILBChannelID;

public class DoubleCameraSupportUtil
{
  public static final int MAIN_CAMERA_ID = 0;
  public static final int MAIN_GIMBAL_ID = 0;
  public static final int SECONDARY_CAMERA_ID = 2;
  public static final int SECONDARY_GIMBAL_ID = 2;
  public static volatile boolean SupportDoubleCamera = false;
  public static final String USER_SET_MAIN_CAMERA_BANDWIDTH_PERCENT = "UserSetMainCameraBandwidthPercent";
  private static volatile int mainCameraBandwidthPercent = 10;
  private static volatile int mainCameraChannelId = -1;
  private static volatile DJIComponentManager.CameraComponentType mainCameraType = DJIComponentManager.CameraComponentType.None;
  private static volatile int secondaryCameraChannelId = -1;
  private static volatile DJIComponentManager.CameraComponentType secondaryCameraType = DJIComponentManager.CameraComponentType.None;
  
  public static final int getCameraIdInProtocol(int paramInt)
  {
    if (paramInt != 1) {
      return 0;
    }
    return 2;
  }
  
  public static final int getGimbalIdInProtocol(int paramInt)
  {
    if (paramInt != 1) {
      return 0;
    }
    return 2;
  }
  
  public static int getMainCameraBandwidthPercent()
  {
    return mainCameraBandwidthPercent;
  }
  
  public static final int getMainCameraChannelID()
  {
    try
    {
      if (mainCameraChannelId != -1)
      {
        i = mainCameraChannelId;
        return i;
      }
      if (mainCameraBandwidthPercent > 0)
      {
        i = 1.$SwitchMap$dji$midware$component$DJIComponentManager$CameraComponentType[mainCameraType.ordinal()];
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if ((i != 4) && (i != 5))
            {
              i = DJIPluginLBChanneParser.DJILBChannelID.LiveView.value();
              return i;
            }
            mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.FourthLiveViewXT.value();
            i = mainCameraChannelId;
            return i;
          }
          mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.ThirdLiveViewZ30.value();
          i = mainCameraChannelId;
          return i;
        }
        mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.LiveView.value();
        i = mainCameraChannelId;
        return i;
      }
      int i = 1.$SwitchMap$dji$midware$component$DJIComponentManager$CameraComponentType[secondaryCameraType.ordinal()];
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          if ((i != 4) && (i != 5))
          {
            i = DJIPluginLBChanneParser.DJILBChannelID.LiveView.value();
            return i;
          }
          mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.FourthLiveViewXT.value();
          i = mainCameraChannelId;
          return i;
        }
        mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.ThirdLiveViewZ30.value();
        i = mainCameraChannelId;
        return i;
      }
      mainCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.LiveView.value();
      i = mainCameraChannelId;
      return i;
    }
    finally {}
  }
  
  public static DJIComponentManager.CameraComponentType getMainCameraType()
  {
    return mainCameraType;
  }
  
  public static final int getSecondaryCameraId()
  {
    try
    {
      if (secondaryCameraChannelId != -1)
      {
        i = secondaryCameraChannelId;
        return i;
      }
      if ((mainCameraBandwidthPercent != 0) && (mainCameraBandwidthPercent != 10))
      {
        i = 1.$SwitchMap$dji$midware$component$DJIComponentManager$CameraComponentType[secondaryCameraType.ordinal()];
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if ((i != 4) && (i != 5))
            {
              i = DJIPluginLBChanneParser.DJILBChannelID.SecondaryLiveView.value();
              return i;
            }
            secondaryCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.FourthLiveViewXT.value();
            i = secondaryCameraChannelId;
            return i;
          }
          secondaryCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.ThirdLiveViewZ30.value();
          i = secondaryCameraChannelId;
          return i;
        }
        secondaryCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.LiveView.value();
        i = secondaryCameraChannelId;
        return i;
      }
      secondaryCameraChannelId = DJIPluginLBChanneParser.DJILBChannelID.SecondaryLiveView.value();
      int i = secondaryCameraChannelId;
      return i;
    }
    finally {}
  }
  
  public static DJIComponentManager.CameraComponentType getSecondaryCameraType()
  {
    return secondaryCameraType;
  }
  
  public static final void reset()
  {
    try
    {
      secondaryCameraChannelId = -1;
      mainCameraChannelId = -1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setMainCameraBandwidthPercent(int paramInt)
  {
    mainCameraBandwidthPercent = paramInt;
    reset();
  }
  
  public static void setMainCameraType(DJIComponentManager.CameraComponentType paramCameraComponentType)
  {
    mainCameraType = paramCameraComponentType;
  }
  
  public static void setSecondaryCameraType(DJIComponentManager.CameraComponentType paramCameraComponentType)
  {
    secondaryCameraType = paramCameraComponentType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DoubleCameraSupportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */