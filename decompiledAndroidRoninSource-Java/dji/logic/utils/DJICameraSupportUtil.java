package dji.logic.utils;

import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetPushShotInfo;
import dji.midware.data.model.P3.DataCameraGetPushShotInfo.ShotFDType;
import dji.midware.data.model.P3.DataCameraGetPushShotInfo.ZoomFocusType;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;

public class DJICameraSupportUtil
{
  private static final String TAG = "DJICameraSupportUtil";
  
  public static int getCameraFOV(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600) {
      return 74;
    }
    return 84;
  }
  
  public static boolean isFC550SeriesCamera(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) {
      return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw;
    }
    return true;
  }
  
  public static boolean isInspire2Camera(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520);
  }
  
  public static boolean isSupportAudioWithInnerMic(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    return isFC550SeriesCamera(localCameraType) ^ true;
  }
  
  public static boolean isSupportElectronicStabilization(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350;
  }
  
  public static boolean isSupportFocus(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    return (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) || (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600);
  }
  
  public static boolean isSupportFocusDistance(DataCameraGetPushShotInfo paramDataCameraGetPushShotInfo)
  {
    return (paramDataCameraGetPushShotInfo.getShotFDType(new int[0]) == DataCameraGetPushShotInfo.ShotFDType.ZoomShotFD) && (paramDataCameraGetPushShotInfo.getZoomFocusType(new int[0]) == DataCameraGetPushShotInfo.ZoomFocusType.AutoZoomFocus);
  }
  
  public static boolean isSupportMF(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    return (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw);
  }
  
  public static boolean isSupportOpticsZoom(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    boolean bool1 = DataCameraGetPushShotInfo.getInstance().isGetted();
    boolean bool2 = false;
    if (bool1) {
      bool1 = isSupportFocusDistance(DataCameraGetPushShotInfo.getInstance());
    } else {
      bool1 = false;
    }
    if ((localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public static boolean isSupportPano(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) {
      return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600;
    }
    return true;
  }
  
  public static boolean isSupportPeakingFocus(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (isInspire2Camera(paramCameraType)) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) || (supportMfNSwitch(paramCameraType));
  }
  
  public static boolean isSupportPortraitColor(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) {
      return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600;
    }
    return true;
  }
  
  public static boolean isSupportRefLineAndCenterPoint(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) {
      return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw;
    }
    return true;
  }
  
  public static boolean isSupportTimelapse(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350) {
      return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600;
    }
    return true;
  }
  
  public static boolean shouldShowDetailFormat(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510 != localCameraType) {
      return DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520 == localCameraType;
    }
    return true;
  }
  
  public static boolean suport3t2PhotoSize(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310 != localCameraType) {
      return DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510 == localCameraType;
    }
    return true;
  }
  
  public static boolean supportAdjustAperture(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw);
  }
  
  public static boolean supportCameraFocus(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeCV600);
  }
  
  public static boolean supportCameraFocusHandwheel(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550) || (paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw);
  }
  
  public static boolean supportClickCameraOsd(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    boolean bool = true;
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    if (localCameraType != DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520)
    {
      if (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6510) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean supportDZoom(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return paramCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC350;
  }
  
  public static boolean supportMfNSwitch(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220 == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310 == paramCameraType);
  }
  
  public static boolean supportRawBurst(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    paramCameraType = DJIProductManager.getInstance().getType();
    return (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520) && (ProductType.Orange2 == paramCameraType);
  }
  
  public static boolean supportSSD(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DataCameraGetPushStateInfo.getInstance().getCameraType(new int[] { 0 });
    }
    paramCameraType = DJIProductManager.getInstance().getType();
    return (localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6520) && (ProductType.Orange2 == paramCameraType);
  }
  
  public static boolean unsupportRawPicture(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC1102 == paramCameraType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logi\\utils\DJICameraSupportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */