package dji.internal.mock.abstractions;

import android.graphics.PointF;
import dji.common.camera.SettingsDefinitions.CameraMode;
import dji.common.camera.SettingsDefinitions.ExposureMode;
import dji.common.camera.SettingsDefinitions.PhotoBurstCount;
import dji.common.camera.SettingsDefinitions.PhotoTimeIntervalSettings;
import dji.common.camera.SettingsDefinitions.ShootPhotoMode;
import dji.common.camera.SettingsDefinitions.ThermalFFCMode;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.hardware.abstractions.camera.zenmuse.DJICameraXTBaseAbstraction;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;

public class MockCameraAbstraction
  extends DJICameraXTBaseAbstraction
{
  private SettingsDefinitions.CameraMode cameraMode = SettingsDefinitions.CameraMode.SHOOT_PHOTO;
  private int counter = 0;
  private Integer currentShootingTime = Integer.valueOf(0);
  private SettingsDefinitions.ExposureMode exposureMode = SettingsDefinitions.ExposureMode.PROGRAM;
  private int interverForStoring = 3;
  private Boolean isRecording = Boolean.valueOf(false);
  private boolean isShootingIntervalPhoto = false;
  private boolean isShootingPhoto = false;
  private boolean isShootingPhotoEnabled = true;
  private SettingsDefinitions.PhotoBurstCount photoBurstCount = SettingsDefinitions.PhotoBurstCount.BURST_COUNT_3;
  private SettingsDefinitions.PhotoTimeIntervalSettings photoIntervalParam = new SettingsDefinitions.PhotoTimeIntervalSettings(255, 2);
  private SettingsDefinitions.ShootPhotoMode shootPhotoMode = SettingsDefinitions.ShootPhotoMode.SINGLE;
  private int startInterForStoring = 0;
  
  public MockCameraAbstraction()
  {
    generateFakeCameraInfo();
  }
  
  /* Error */
  private void generateFakeCameraInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DJISDKCacheKey genKeyPath(String paramString)
  {
    return null;
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isOverallTemperatureMeterSupported()
  {
    return true;
  }
  
  protected boolean isPlaybackSupported()
  {
    return true;
  }
  
  /* Error */
  @Setter("Mode")
  public void setCameraMode(SettingsDefinitions.CameraMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("ShootPhotoMode")
  public void setCameraShootPhotoMode(SettingsDefinitions.ShootPhotoMode paramShootPhotoMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramShootPhotoMode.value();
    this.shootPhotoMode = paramShootPhotoMode;
    if (paramInnerCallback != null) {
      paramInnerCallback.onSuccess(null);
    }
  }
  
  /* Error */
  @Setter("ThermalAtmosphericTemperature")
  public void setThermalAtmosphericTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalAtmosphericTransmissionCoefficient")
  public void setThermalAtmosphericTransmissionCoefficient(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalBackgroundTemperature")
  public void setThermalBackgroundTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalCustomExternalSceneSettingsProfile")
  public void setThermalCustomExternalSceneSettingsProfile(dji.common.camera.SettingsDefinitions.ThermalCustomExternalSceneSettingsProfile arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalCustomExternalSceneSettingsProfile")
  public void setThermalExternalSceneSettings(dji.common.camera.ThermalExternalSceneSettings arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("ThermalFFCMode")
  public void setThermalFFCMode(SettingsDefinitions.ThermalFFCMode paramThermalFFCMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    notifyValueChangeForKeyPath(paramThermalFFCMode, "ThermalFFCMode");
  }
  
  /* Error */
  @Setter("ThermalSceneEmissivity")
  public void setThermalSceneEmissivity(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalMeteringArea")
  public void setThermalSpotMeteringArea(android.graphics.RectF arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("ThermalSpotMeteringTargetPoint")
  public void setThermalSpotMeteringTargetPoint(PointF paramPointF, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    notifyValueChangeForKeyPath(paramPointF, convertKeyToPath("ThermalSpotMeteringTargetPoint"));
    notifyValueChangeForKeyPath(Integer.valueOf(0), convertKeyToPath("ThermalTemperatureData"));
  }
  
  /* Error */
  @Setter("ThermalWindowReflectedTemperature")
  public void setThermalWindowReflectedTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalWindowReflection")
  public void setThermalWindowReflection(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalWindowTemperature")
  public void setThermalWindowTemperature(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ThermalWindowTransmissionCoefficient")
  public void setThermalWindowTransmissionCoefficient(short arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartRecordVideo")
  public void startRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StartShootPhoto")
  public void startShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1, SettingsDefinitions.ShootPhotoMode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StopRecordVideo")
  public void stopRecordVideo(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("StopShootPhoto")
  public void stopShootPhoto(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @dji.sdksharedlib.hardware.abstractions.Action("TriggerThermalFFC")
  public void triggerFFC(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\abstractions\MockCameraAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */