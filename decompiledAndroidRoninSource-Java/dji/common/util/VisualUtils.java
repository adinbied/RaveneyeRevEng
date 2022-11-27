package dji.common.util;

import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetImageSize.RatioType;
import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import dji.midware.data.model.P3.DataCameraGetPushFovParam;
import dji.midware.data.model.P3.DataCameraGetPushShotParams;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;

public class VisualUtils
{
  static final int FPS_120 = 7;
  static final int VR_1920_1080P = 10;
  static final int VR_2704_1520P = 24;
  static final int VR_3840_1920P = 14;
  static final int VR_3840_2160P = 16;
  static final int VR_3840_2880P = 18;
  static final int VR_4096_2048P = 20;
  static final int VR_4096_2160P = 22;
  
  public static float cameraHorizontalFov()
  {
    if (DataCameraGetPushFovParam.getInstance().hasFovData()) {
      return DataCameraGetPushFovParam.getInstance().getFovH();
    }
    DataCameraGetMode.MODE localMODE = DataCameraGetPushStateInfo.getInstance().getMode(new int[0]);
    ProductType localProductType = DJIProductManager.getInstance().getType();
    if (isKumquatSeries(localProductType)) {
      return cameraHorizontalFovOfKumquat(localMODE);
    }
    if (localProductType == ProductType.Pomato) {
      return cameraHorizontalFovOfPomato(localMODE);
    }
    if (localProductType == ProductType.Orange2) {
      return 75.7F;
    }
    return cameraHorizontalFovOfP4(localMODE);
  }
  
  private static float cameraHorizontalFovOfKumquat(DataCameraGetMode.MODE paramMODE)
  {
    if (paramMODE == DataCameraGetMode.MODE.TAKEPHOTO) {
      return 64.0F;
    }
    if (paramMODE == DataCameraGetMode.MODE.RECORD)
    {
      int i = DataCameraGetPushShotParams.getInstance().getVideoFormat(new int[0]);
      if ((i != 20) && (i != 22)) {
        return 62.0F;
      }
      return cameraHorizontalStandardFov();
    }
    return cameraHorizontalStandardFov();
  }
  
  private static float cameraHorizontalFovOfP4(DataCameraGetMode.MODE paramMODE)
  {
    if (paramMODE == DataCameraGetMode.MODE.TAKEPHOTO) {
      return 82.0F;
    }
    if (paramMODE == DataCameraGetMode.MODE.RECORD)
    {
      int i = DataCameraGetPushShotParams.getInstance().getVideoFormat(new int[0]);
      int j = DataCameraGetPushShotParams.getInstance().getVideoFps(new int[0]);
      if ((i != 20) && (i != 22))
      {
        if ((i != 24) && (i != 14) && (i != 16))
        {
          if (i == 18) {
            return 82.0F;
          }
          if ((i == 10) && (j == 7)) {
            return 41.0F;
          }
          return 80.0F;
        }
        return 82.0F;
      }
      return cameraHorizontalStandardFov();
    }
    return cameraHorizontalStandardFov();
  }
  
  private static float cameraHorizontalFovOfPomato(DataCameraGetMode.MODE paramMODE)
  {
    if (paramMODE == DataCameraGetMode.MODE.TAKEPHOTO)
    {
      paramMODE = DataCameraGetPushShotParams.getInstance().getImageRatio();
      if (DataCameraGetImageSize.RatioType.R_4_3 == paramMODE) {
        return 68.0F;
      }
      if (DataCameraGetImageSize.RatioType.R_16_9 == paramMODE) {
        return 72.5F;
      }
      return cameraHorizontalStandardFov();
    }
    if (paramMODE == DataCameraGetMode.MODE.RECORD)
    {
      int i = DataCameraGetPushShotParams.getInstance().getVideoFormat(new int[0]);
      int j = DataCameraGetPushShotParams.getInstance().getVideoFps(new int[0]);
      if (i != 20)
      {
        if (i == 22) {
          return 68.0F;
        }
        if ((i != 24) && (i != 14) && (i != 16))
        {
          if (i == 18) {
            return 72.5F;
          }
          if ((i == 10) && (j == 7)) {
            return 41.0F;
          }
          return 68.0F;
        }
        return 72.5F;
      }
      return 68.0F;
    }
    return cameraHorizontalStandardFov();
  }
  
  public static float cameraHorizontalStandardFov()
  {
    if (DataCameraGetPushFovParam.getInstance().hasFovData()) {
      return DataCameraGetPushFovParam.getInstance().getFovH();
    }
    ProductType localProductType = DJIProductManager.getInstance().getType();
    if (isKumquatSeries(localProductType)) {
      return 66.0F;
    }
    if (localProductType == ProductType.Pomato) {
      return 74.0F;
    }
    if (localProductType == ProductType.Orange2) {
      return 75.7F;
    }
    return 84.0F;
  }
  
  public static float cameraVerticalFov(DataCameraGetImageSize.RatioType paramRatioType)
  {
    if (DataCameraGetPushFovParam.getInstance().hasFovData()) {
      return DataCameraGetPushFovParam.getInstance().getFovV();
    }
    if (DJIProductManager.getInstance().getType() == ProductType.Orange2) {
      return 60.6F;
    }
    float f = cameraHorizontalFov();
    if (paramRatioType == DataCameraGetImageSize.RatioType.R_4_3) {
      return f * 3.0F / 4.0F;
    }
    if (paramRatioType == DataCameraGetImageSize.RatioType.R_3_2) {
      return f * 2.0F / 3.0F;
    }
    return f * 9.0F / 16.0F;
  }
  
  public static boolean isKumquatSeries(ProductType paramProductType)
  {
    ProductType localProductType = paramProductType;
    if (paramProductType == null) {
      localProductType = DJIProductManager.getInstance().getType();
    }
    return (localProductType == ProductType.KumquatX) || (localProductType == ProductType.KumquatS);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\VisualUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */