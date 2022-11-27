package dji.sdksharedlib.hardware.abstractions.gimbal;

import dji.common.error.DJIError;
import dji.common.error.DJIGimbalError;
import dji.common.gimbal.Attitude;
import dji.common.gimbal.BalanceTestResult;
import dji.common.gimbal.CapabilityKey;
import dji.common.gimbal.MotorControlPreset;
import dji.common.gimbal.MovementSettingsProfile;
import dji.common.handheldcontroller.ControllerMode;
import dji.common.util.DJIParamCapability;
import dji.common.util.DJIParamMinMaxCapability;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataGimbalGetPushUserParams;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.DoubleCameraSupportUtil;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.DefaultGetInnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.greenrobot.eventbus.EventBus;

public abstract class DJIGimbalAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final String TAG = "DJIGimbalAbstraction";
  protected Attitude attitude;
  protected int calibrationProgress = 0;
  public Map<CapabilityKey, DJIParamCapability> gimbalCapability;
  protected int index = 0;
  protected boolean isCalibrating = false;
  protected boolean isCalibrationSuccessful = true;
  protected boolean isTestingBalance = false;
  protected boolean needPauseStabilization = false;
  protected BalanceTestResult pitchResult = BalanceTestResult.UNKNOWN;
  protected DataGimbalGetPushUserParams pushUserParams = null;
  protected BalanceTestResult rollResult = BalanceTestResult.UNKNOWN;
  private CountDownLatch setParamCdl;
  private DJIError setParamErr;
  private int setParamGetVal = Integer.MIN_VALUE;
  protected List<CountDownLatch> waitList = new LinkedList();
  
  /* Error */
  protected void addDefaultToCapability(CapabilityKey arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addIsSupportedToCapability(CapabilityKey arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addMinMaxToCapability(CapabilityKey arg1, Number arg2, Number arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DJIParamMinMaxCapability castMinMaxCapability(DJIParamCapability paramDJIParamCapability)
  {
    return null;
  }
  
  protected boolean checkValueValid(Number paramNumber1, Number paramNumber2, Number paramNumber3)
  {
    return false;
  }
  
  protected boolean checkValueValid(Number paramNumber1, Number paramNumber2, Number paramNumber3, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    return false;
  }
  
  @Action("ApplyMotorControlPreset")
  public void configureMotorControl(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, MotorControlPreset paramMotorControlPreset)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void didInitAbstraction()
  {
    saveGimbalCapabilityToStore();
  }
  
  /* Error */
  @Action("FineTunePitchInDegrees")
  public void fineTuneGimbalPitchInDegrees(DJISDKCacheHWAbstraction.InnerCallback arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("FineTuneRollInDegrees")
  public void fineTuneGimbalRollInDegrees(DJISDKCacheHWAbstraction.InnerCallback arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Attitude getAttitudeInDegrees()
  {
    return this.attitude;
  }
  
  @Getter("Capabilities")
  public void getCapabilities(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onSuccess(this.gimbalCapability);
  }
  
  @Getter("PitchControllerSmoothingFactor")
  public void getControllerSmoothingOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawControllerSmoothingFactor")
  public void getControllerSmoothingOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("PitchControllerSpeedCoefficient")
  public void getControllerSpeedOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawControllerSpeedCoefficient")
  public void getControllerSpeedOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  protected int getExpectedSenderIdByIndex()
  {
    return DoubleCameraSupportUtil.getGimbalIdInProtocol(this.index);
  }
  
  /* Error */
  @Getter("FirmwareVersion")
  public void getFirmwareVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("ControllerMode")
  public void getGimbalControllerMode(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  protected Number getMaxValueFromCapability(CapabilityKey paramCapabilityKey)
  {
    return null;
  }
  
  protected Number getMinValueFromCapability(CapabilityKey paramCapabilityKey)
  {
    return null;
  }
  
  @Getter("MotorEnabled")
  public void getMotorEnabled(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("MovementSettingsProfile")
  public void getMovementSettingsProfile(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  protected void getParam(SettingParamCmd arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("PitchRangeExtensionEnabled")
  public void getPitchRangeExtensionEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected int getReceiverIdByIndex()
  {
    return DoubleCameraSupportUtil.getGimbalIdInProtocol(this.index);
  }
  
  @Getter("PitchSmoothTrackAcceleration")
  public void getSmoothTrackAccelerationOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawSmoothTrackAcceleration")
  public void getSmoothTrackAccelerationOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("PitchSmoothTrackDeadband")
  public void getSmoothTrackDeadbandOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawSmoothTrackDeadband")
  public void getSmoothTrackDeadbandOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("PitchSmoothTrackEnabled")
  public void getSmoothTrackEnabledOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawSmoothTrackEnabled")
  public void getSmoothTrackEnabledOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("PitchSmoothTrackSpeed")
  public void getSmoothTrackSpeedOnPitch(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Getter("YawSmoothTrackSpeed")
  public void getSmoothTrackSpeedOnYaw(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    this.index = paramInt;
    this.pushUserParams = DataGimbalGetPushUserParams.getInstance();
    EventBus.getDefault().register(this);
    initGimbalCapability();
  }
  
  /* Error */
  protected void initGimbalCapability()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean isCustomAdvancedSettingProfile()
  {
    return false;
  }
  
  /* Error */
  protected void justSendPauseData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("RestoreFactorySettings")
  public void loadFactorySettings(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataEyeGetPushStabilizationState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.ASYNC)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataGimbalGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataGimbalGetPushUserParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("ResetGimbal")
  public void resetGimbal(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("Rotate")
  public void rotate(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.common.gimbal.Rotation arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void saveGimbalCapabilityToStore()
  {
    notifyValueChangeForKey(this.gimbalCapability, "Capabilities");
  }
  
  void setAttitude(Attitude paramAttitude)
  {
    this.attitude = paramAttitude;
  }
  
  @Setter("PitchControllerSmoothingFactor")
  public void setControllerSmoothingOnPitch(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawControllerSmoothingFactor")
  public void setControllerSmoothingOnYaw(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("PitchControllerSpeedCoefficient")
  public void setControllerSpeedOnPitch(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawControllerSpeedCoefficient")
  public void setControllerSpeedOnYaw(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("ControllerMode")
  public void setGimbalControllerMode(ControllerMode paramControllerMode, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  @Setter("Mode")
  public void setGimbalMode(dji.common.gimbal.GimbalMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void setIsTestingBalance(boolean paramBoolean)
  {
    this.isTestingBalance = paramBoolean;
  }
  
  @Setter("MotorEnabled")
  public void setMotorEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("MovementSettingsProfile")
  public void setMovementSettingsProfile(MovementSettingsProfile paramMovementSettingsProfile, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  protected void setParam(int arg1, SettingParamCmd arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("PitchRangeExtensionEnabled")
  public void setPitchRangeExtensionEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  protected void setPitchTestResult(BalanceTestResult paramBalanceTestResult)
  {
    this.pitchResult = paramBalanceTestResult;
  }
  
  protected void setRollTestResult(BalanceTestResult paramBalanceTestResult)
  {
    this.rollResult = paramBalanceTestResult;
  }
  
  @Setter("PitchSmoothTrackAcceleration")
  public void setSmoothTrackAccelerationOnPitch(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawSmoothTrackAcceleration")
  public void setSmoothTrackAccelerationOnYaw(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("PitchSmoothTrackDeadband")
  public void setSmoothTrackDeadbandOnPitch(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawSmoothTrackDeadband")
  public void setSmoothTrackDeadbandOnYaw(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("PitchSmoothTrackEnabled")
  public void setSmoothTrackEnabledOnPitch(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawSmoothTrackEnabled")
  public void setSmoothTrackEnabledOnYaw(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("PitchSmoothTrackSpeed")
  public void setSmoothTrackSpeedOnPitch(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  @Setter("YawSmoothTrackSpeed")
  public void setSmoothTrackSpeedOnYaw(int paramInt, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  @Action("StartCalibration")
  public void startCalibration(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("StartBalanceTest")
  public void startGimbalBalanceTest(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  public void syncPushDataFromMidware()
  {
    super.syncPushDataFromMidware();
    didInitAbstraction();
  }
  
  @Action("ToggleSelfie")
  public void toggleGimbalSelfie(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    paramInnerCallback.onFails(DJIGimbalError.COMMON_UNSUPPORTED);
  }
  
  protected boolean tryToPauseTheStabilizationIfNecessary(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    return false;
  }
  
  /* Error */
  protected void updateCalibrationState(dji.midware.data.model.P3.DataGimbalGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected static enum SettingParamCmd
  {
    private String cmd;
    
    static
    {
      SMOOTH_TRACK_PITCH_SPEED = new SettingParamCmd("SMOOTH_TRACK_PITCH_SPEED", 1, "pitch_speed");
      SMOOTH_TRACK_YAW_SPEED = new SettingParamCmd("SMOOTH_TRACK_YAW_SPEED", 2, "yaw_speed");
      SMOOTH_TRACK_ROLL_SPEED = new SettingParamCmd("SMOOTH_TRACK_ROLL_SPEED", 3, "roll_speed");
      SMOOTH_TRACK_PITCH_DEADBAND = new SettingParamCmd("SMOOTH_TRACK_PITCH_DEADBAND", 4, "pitch_deadband");
      SMOOTH_TRACK_YAW_DEADBAND = new SettingParamCmd("SMOOTH_TRACK_YAW_DEADBAND", 5, "yaw_deadband");
      SMOOTH_TRACK_ROLL_DEADBAND = new SettingParamCmd("SMOOTH_TRACK_ROLL_DEADBAND", 6, "roll_deadband");
      SMOOTH_TRACK_PITCH_ACCEL = new SettingParamCmd("SMOOTH_TRACK_PITCH_ACCEL", 7, "pitch_accel");
      SMOOTH_TRACK_YAW_ACCEL = new SettingParamCmd("SMOOTH_TRACK_YAW_ACCEL", 8, "yaw_accel");
      SMOOTH_TRACK_ROLL_ACCEL = new SettingParamCmd("SMOOTH_TRACK_ROLL_ACCEL", 9, "roll_accel");
      CONTROLLER_PITCH_SPEED = new SettingParamCmd("CONTROLLER_PITCH_SPEED", 10, "pitch_expo");
      CONTROLLER_YAW_SPEED = new SettingParamCmd("CONTROLLER_YAW_SPEED", 11, "yaw_expo");
      CONTROLLER_PITCH_SMOOTH = new SettingParamCmd("CONTROLLER_PITCH_SMOOTH", 12, "pitch_time_expo");
      CONTROLLER_YAW_SMOOTH = new SettingParamCmd("CONTROLLER_YAW_SMOOTH", 13, "yaw_time_expo");
      PITCH_SMOOTH_TRACK_ENABLED = new SettingParamCmd("PITCH_SMOOTH_TRACK_ENABLED", 14, "pitch_smooth_track");
      YAW_SMOOTH_TRACK_ENABLED = new SettingParamCmd("YAW_SMOOTH_TRACK_ENABLED", 15, "yaw_smooth_track");
      PITCH_EXP = new SettingParamCmd("PITCH_EXP", 16, "pitch_exp");
      SettingParamCmd localSettingParamCmd = new SettingParamCmd("ROLL_SMOOTH_TRACK_ENABLED", 17, "roll_smooth_track");
      ROLL_SMOOTH_TRACK_ENABLED = localSettingParamCmd;
      $VALUES = new SettingParamCmd[] { TABLE_CHOICE, SMOOTH_TRACK_PITCH_SPEED, SMOOTH_TRACK_YAW_SPEED, SMOOTH_TRACK_ROLL_SPEED, SMOOTH_TRACK_PITCH_DEADBAND, SMOOTH_TRACK_YAW_DEADBAND, SMOOTH_TRACK_ROLL_DEADBAND, SMOOTH_TRACK_PITCH_ACCEL, SMOOTH_TRACK_YAW_ACCEL, SMOOTH_TRACK_ROLL_ACCEL, CONTROLLER_PITCH_SPEED, CONTROLLER_YAW_SPEED, CONTROLLER_PITCH_SMOOTH, CONTROLLER_YAW_SMOOTH, PITCH_SMOOTH_TRACK_ENABLED, YAW_SMOOTH_TRACK_ENABLED, PITCH_EXP, localSettingParamCmd };
    }
    
    private SettingParamCmd(String paramString)
    {
      this.cmd = paramString;
    }
    
    public String getCmdString()
    {
      return this.cmd;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\gimbal\DJIGimbalAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */