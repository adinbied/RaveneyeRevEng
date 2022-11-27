package dji.common.camera;

import dji.log.DJILog;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetPushShotParams;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataCameraSetExposureMode.ExposureMode;
import dji.sdksharedlib.extension.CacheHelper;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CameraUtils
{
  public static EnumMap<SettingsDefinitions.Aperture, Short> buildApertureMap()
  {
    EnumMap localEnumMap = new EnumMap(SettingsDefinitions.Aperture.class);
    localEnumMap.put(SettingsDefinitions.Aperture.F_10, Short.valueOf((short)1000));
    localEnumMap.put(SettingsDefinitions.Aperture.F_11, Short.valueOf((short)1100));
    localEnumMap.put(SettingsDefinitions.Aperture.F_13, Short.valueOf((short)1300));
    localEnumMap.put(SettingsDefinitions.Aperture.F_14, Short.valueOf((short)1400));
    localEnumMap.put(SettingsDefinitions.Aperture.F_16, Short.valueOf((short)1600));
    localEnumMap.put(SettingsDefinitions.Aperture.F_18, Short.valueOf((short)1800));
    localEnumMap.put(SettingsDefinitions.Aperture.F_1_DOT_6, Short.valueOf((short)160));
    localEnumMap.put(SettingsDefinitions.Aperture.F_1_DOT_7, Short.valueOf((short)170));
    localEnumMap.put(SettingsDefinitions.Aperture.F_1_DOT_8, Short.valueOf((short)180));
    localEnumMap.put(SettingsDefinitions.Aperture.F_20, Short.valueOf((short)2000));
    localEnumMap.put(SettingsDefinitions.Aperture.F_22, Short.valueOf((short)2200));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2, Short.valueOf((short)200));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_2, Short.valueOf((short)220));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_4, Short.valueOf((short)240));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_5, Short.valueOf((short)250));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_8, Short.valueOf((short)280));
    localEnumMap.put(SettingsDefinitions.Aperture.F_3_DOT_2, Short.valueOf((short)320));
    localEnumMap.put(SettingsDefinitions.Aperture.F_3_DOT_4, Short.valueOf((short)340));
    localEnumMap.put(SettingsDefinitions.Aperture.F_3_DOT_5, Short.valueOf((short)350));
    localEnumMap.put(SettingsDefinitions.Aperture.F_4, Short.valueOf((short)400));
    localEnumMap.put(SettingsDefinitions.Aperture.F_4_DOT_5, Short.valueOf((short)450));
    localEnumMap.put(SettingsDefinitions.Aperture.F_4_DOT_8, Short.valueOf((short)480));
    localEnumMap.put(SettingsDefinitions.Aperture.F_5, Short.valueOf((short)500));
    localEnumMap.put(SettingsDefinitions.Aperture.F_5_DOT_6, Short.valueOf((short)560));
    localEnumMap.put(SettingsDefinitions.Aperture.F_6_DOT_3, Short.valueOf((short)630));
    localEnumMap.put(SettingsDefinitions.Aperture.F_6_DOT_8, Short.valueOf((short)680));
    localEnumMap.put(SettingsDefinitions.Aperture.F_7_DOT_1, Short.valueOf((short)710));
    localEnumMap.put(SettingsDefinitions.Aperture.F_8, Short.valueOf((short)800));
    localEnumMap.put(SettingsDefinitions.Aperture.F_9, Short.valueOf((short)900));
    localEnumMap.put(SettingsDefinitions.Aperture.F_9_DOT_6, Short.valueOf((short)960));
    return localEnumMap;
  }
  
  public static HashMap<Integer, SettingsDefinitions.Aperture> buildApertureMapRevert()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1000), SettingsDefinitions.Aperture.F_10);
    localHashMap.put(Integer.valueOf(1100), SettingsDefinitions.Aperture.F_11);
    localHashMap.put(Integer.valueOf(1300), SettingsDefinitions.Aperture.F_13);
    localHashMap.put(Integer.valueOf(1400), SettingsDefinitions.Aperture.F_14);
    localHashMap.put(Integer.valueOf(1600), SettingsDefinitions.Aperture.F_16);
    localHashMap.put(Integer.valueOf(1800), SettingsDefinitions.Aperture.F_18);
    localHashMap.put(Integer.valueOf(160), SettingsDefinitions.Aperture.F_1_DOT_6);
    localHashMap.put(Integer.valueOf(170), SettingsDefinitions.Aperture.F_1_DOT_7);
    localHashMap.put(Integer.valueOf(180), SettingsDefinitions.Aperture.F_1_DOT_8);
    localHashMap.put(Integer.valueOf(2000), SettingsDefinitions.Aperture.F_20);
    localHashMap.put(Integer.valueOf(2200), SettingsDefinitions.Aperture.F_22);
    localHashMap.put(Integer.valueOf(200), SettingsDefinitions.Aperture.F_2);
    localHashMap.put(Integer.valueOf(220), SettingsDefinitions.Aperture.F_2_DOT_2);
    localHashMap.put(Integer.valueOf(240), SettingsDefinitions.Aperture.F_2_DOT_4);
    localHashMap.put(Integer.valueOf(250), SettingsDefinitions.Aperture.F_2_DOT_5);
    localHashMap.put(Integer.valueOf(280), SettingsDefinitions.Aperture.F_2_DOT_8);
    localHashMap.put(Integer.valueOf(320), SettingsDefinitions.Aperture.F_3_DOT_2);
    localHashMap.put(Integer.valueOf(340), SettingsDefinitions.Aperture.F_3_DOT_4);
    localHashMap.put(Integer.valueOf(350), SettingsDefinitions.Aperture.F_3_DOT_5);
    localHashMap.put(Integer.valueOf(400), SettingsDefinitions.Aperture.F_4);
    localHashMap.put(Integer.valueOf(450), SettingsDefinitions.Aperture.F_4_DOT_5);
    localHashMap.put(Integer.valueOf(480), SettingsDefinitions.Aperture.F_4_DOT_8);
    localHashMap.put(Integer.valueOf(500), SettingsDefinitions.Aperture.F_5);
    localHashMap.put(Integer.valueOf(560), SettingsDefinitions.Aperture.F_5_DOT_6);
    localHashMap.put(Integer.valueOf(630), SettingsDefinitions.Aperture.F_6_DOT_3);
    localHashMap.put(Integer.valueOf(680), SettingsDefinitions.Aperture.F_6_DOT_8);
    localHashMap.put(Integer.valueOf(710), SettingsDefinitions.Aperture.F_7_DOT_1);
    localHashMap.put(Integer.valueOf(800), SettingsDefinitions.Aperture.F_8);
    localHashMap.put(Integer.valueOf(900), SettingsDefinitions.Aperture.F_9);
    localHashMap.put(Integer.valueOf(960), SettingsDefinitions.Aperture.F_9_DOT_6);
    return localHashMap;
  }
  
  public static SettingsDefinitions.Aperture getRealCameraAperture(int paramInt)
  {
    paramInt = DataCameraGetPushShotParams.getInstance().getRealApertureSize();
    if (buildApertureMapRevert().containsKey(Integer.valueOf(paramInt))) {
      return (SettingsDefinitions.Aperture)buildApertureMapRevert().get(Integer.valueOf(paramInt));
    }
    return SettingsDefinitions.Aperture.UNKNOWN;
  }
  
  public static SettingsDefinitions.ExposureCompensation getRealCameraExposureCompensation(int paramInt, int... paramVarArgs)
  {
    if (DataCameraGetPushShotParams.getInstance().getExposureMode(paramVarArgs).value() == 1) {
      return SettingsDefinitions.ExposureCompensation.find(DataCameraGetPushShotParams.getInstance().getExposureCompensation(paramVarArgs));
    }
    return SettingsDefinitions.ExposureCompensation.find(paramInt);
  }
  
  public static SettingsDefinitions.ISO getRealCameraISO(int paramInt)
  {
    if (paramInt != 100)
    {
      if (paramInt != 200)
      {
        if (paramInt != 400)
        {
          if (paramInt != 800)
          {
            if (paramInt != 1600)
            {
              if (paramInt != 3200)
              {
                if (paramInt != 6400)
                {
                  if (paramInt != 12800)
                  {
                    if (paramInt != 25600) {
                      return SettingsDefinitions.ISO.UNKNOWN;
                    }
                    return SettingsDefinitions.ISO.ISO_25600;
                  }
                  return SettingsDefinitions.ISO.ISO_12800;
                }
                return SettingsDefinitions.ISO.ISO_6400;
              }
              return SettingsDefinitions.ISO.ISO_3200;
            }
            return SettingsDefinitions.ISO.ISO_1600;
          }
          return SettingsDefinitions.ISO.ISO_800;
        }
        return SettingsDefinitions.ISO.ISO_400;
      }
      return SettingsDefinitions.ISO.ISO_200;
    }
    return SettingsDefinitions.ISO.ISO_100;
  }
  
  public static SettingsDefinitions.ShutterSpeed getRealShutterSpeed(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt2);
    float f = Float.valueOf(localStringBuilder.toString()).floatValue();
    if (!paramBoolean) {
      return SettingsDefinitions.ShutterSpeed.find(f);
    }
    return SettingsDefinitions.ShutterSpeed.find(1.0F / f);
  }
  
  public static boolean isInActionMode(int paramInt)
  {
    return (CacheHelper.getCamera(paramInt, "Mode") != SettingsDefinitions.CameraMode.MEDIA_DOWNLOAD) && (CacheHelper.getCamera(paramInt, "Mode") != SettingsDefinitions.CameraMode.PLAYBACK);
  }
  
  public static boolean isPhotoActionExecutable(int paramInt)
  {
    return (((Boolean)CacheHelper.getCamera(paramInt, "IsShootPhotoEnabled")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsStoringPhoto")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsShootingBurstPhoto")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsShootingIntervalPhoto")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsShootingRawBurstPhoto")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsShootingSinglePhoto")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsShootingSinglePhotoInRAWFormat")).booleanValue());
  }
  
  public static boolean isRecordActionExecutable(int paramInt)
  {
    return (isPhotoActionExecutable(paramInt)) && (!((Boolean)CacheHelper.getCamera(paramInt, "IsRecording")).booleanValue());
  }
  
  public static boolean isSDCardReady(int paramInt)
  {
    return (((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsInserted")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsInitializing")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsReadOnly")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardHasError")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsFull")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsBusy")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsFormatting")).booleanValue()) && (!((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsInvalidFormat")).booleanValue()) && (((Boolean)CacheHelper.getCamera(paramInt, "SDCardIsVerified")).booleanValue()) && (((Long)CacheHelper.getCamera(paramInt, "SDCardAvailableCaptureCount")).longValue() > 0L) && (((Integer)CacheHelper.getCamera(paramInt, "SDCardAvailableRecordingTimeInSeconds")).intValue() > 0);
  }
  
  public static boolean isShootingPhoto(int paramInt)
  {
    return (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingPhoto")).booleanValue()) || (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingBurstPhoto")).booleanValue()) || (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingIntervalPhoto")).booleanValue()) || (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingRawBurstPhoto")).booleanValue()) || (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingSinglePhoto")).booleanValue()) || (((Boolean)CacheHelper.getCamera(paramInt, "IsShootingSinglePhotoInRAWFormat")).booleanValue());
  }
  
  public static boolean isSupportSSD(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    DataCameraGetPushStateInfo.CameraType localCameraType = paramCameraType;
    if (paramCameraType == null) {
      localCameraType = DJIProductManager.getInstance().getCameraType();
    }
    return localCameraType == DataCameraGetPushStateInfo.CameraType.DJICameraTypeFC550Raw;
  }
  
  public static enum RecordVideoTimeoutLock
  {
    private CountDownLatch countDownLatch;
    private int index = 0;
    private boolean result = false;
    private boolean threadInitiatedState = false;
    
    static
    {
      RecordVideoTimeoutLock localRecordVideoTimeoutLock = new RecordVideoTimeoutLock("TIMEOUT_LOCK_2", 2, 2);
      TIMEOUT_LOCK_2 = localRecordVideoTimeoutLock;
      $VALUES = new RecordVideoTimeoutLock[] { TIMEOUT_LOCK_0, TIMEOUT_LOCK_1, localRecordVideoTimeoutLock };
    }
    
    private RecordVideoTimeoutLock(int paramInt)
    {
      this.index = paramInt;
    }
    
    public static RecordVideoTimeoutLock getInstance(int paramInt)
    {
      RecordVideoTimeoutLock localRecordVideoTimeoutLock = TIMEOUT_LOCK_0;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRecordVideoTimeoutLock;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.index == paramInt;
    }
    
    public boolean getResult()
    {
      return this.result;
    }
    
    public boolean getThreadInitiatedState()
    {
      return this.threadInitiatedState;
    }
    
    public void reset()
    {
      this.countDownLatch = new CountDownLatch(1);
      this.result = false;
      this.threadInitiatedState = true;
    }
    
    public void setResult(boolean paramBoolean)
    {
      this.countDownLatch.countDown();
      this.result = paramBoolean;
      this.threadInitiatedState = false;
    }
    
    public void waitResult()
    {
      try
      {
        this.countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static enum ShootPhotoTimeoutLock
  {
    private CountDownLatch countDownLatch;
    private int index = 0;
    private boolean result = false;
    private boolean threadInitiatedState = false;
    
    static
    {
      ShootPhotoTimeoutLock localShootPhotoTimeoutLock = new ShootPhotoTimeoutLock("TIMEOUT_LOCK_2", 2, 2);
      TIMEOUT_LOCK_2 = localShootPhotoTimeoutLock;
      $VALUES = new ShootPhotoTimeoutLock[] { TIMEOUT_LOCK_0, TIMEOUT_LOCK_1, localShootPhotoTimeoutLock };
    }
    
    private ShootPhotoTimeoutLock(int paramInt)
    {
      this.index = paramInt;
    }
    
    public static ShootPhotoTimeoutLock getInstance(int paramInt)
    {
      ShootPhotoTimeoutLock localShootPhotoTimeoutLock = TIMEOUT_LOCK_0;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localShootPhotoTimeoutLock;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.index == paramInt;
    }
    
    public boolean getResult()
    {
      return this.result;
    }
    
    public boolean getThreadInitiatedState()
    {
      return this.threadInitiatedState;
    }
    
    public void reset()
    {
      this.countDownLatch = new CountDownLatch(1);
      DJILog.e("WaitResult", "3", new Object[0]);
      this.result = false;
      this.threadInitiatedState = true;
    }
    
    public void setResult(boolean paramBoolean)
    {
      this.countDownLatch.countDown();
      this.result = paramBoolean;
      this.threadInitiatedState = false;
    }
    
    public void waitResult()
    {
      DJILog.e("WaitResult", "1", new Object[0]);
      try
      {
        this.countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        DJILog.e("WaitResult", "2", new Object[0]);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\CameraUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */