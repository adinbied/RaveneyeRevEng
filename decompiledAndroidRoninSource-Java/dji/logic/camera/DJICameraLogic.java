package dji.logic.camera;

import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;

public class DJICameraLogic
{
  public static boolean isMachineCamera(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    return (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC260 == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300S == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300X == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC330X == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220 == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC300XW == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC6310 == paramCameraType) || (DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC220S == paramCameraType);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\camera\DJICameraLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */