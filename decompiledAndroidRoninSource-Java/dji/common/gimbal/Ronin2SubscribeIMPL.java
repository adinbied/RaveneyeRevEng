package dji.common.gimbal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import dji.midware.component.DJIComponentManager.GimbalComponentType;
import dji.midware.data.config.P3.CmdIdGimbal.CmdIdType;
import dji.midware.data.model.P3.DataGimbalSetPushPeripheralStatus.DataType;
import dji.midware.data.model.P3.DataGimbalSubscribeParams;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.ronin2.Ronin2GimbalParamsManager.BaseCommand;
import dji.sdksharedlib.util.DJISDKCacheThreadManager;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ronin2SubscribeIMPL
  implements IGimbalSubscribe
{
  private static final boolean DEBUG = false;
  private static final long DELAY_TIME = 3000L;
  private static final long RATE_IN_SECOND = 1L;
  private static final String TAG = "Ronin2SubscribeIMPL";
  private DJIDataCallBack mCallback = new DJIDataCallBack()
  {
    /* Error */
    public void onFailure(dji.midware.data.config.P3.Ccode arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSuccess(Object paramAnonymousObject) {}
  };
  private ScheduledExecutorService mExecutor;
  private Handler mHandler;
  private Map<String, Integer> mKeyCmdCallMap = new ConcurrentHashMap();
  private Map<String, Pair<Integer, Integer>> mKeyCmdChannelMap = new ConcurrentHashMap();
  
  public Ronin2SubscribeIMPL()
  {
    put("UserProfile", Ronin2GimbalParamsManager.BaseCommand.USER_PROFILE);
    put("SilentMode", Ronin2GimbalParamsManager.BaseCommand.SILENT_MODE);
    put("PitchMotorControlStiffness", Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_PITCH);
    put("YawMotorControlStiffness", Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_YAW);
    put("RollMotorControlStiffness", Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_ROLL);
    put("PitchMotorControlStrength", Ronin2GimbalParamsManager.BaseCommand.STRENGTH_PITCH);
    put("YawMotorControlStrength", Ronin2GimbalParamsManager.BaseCommand.STRENGTH_YAW);
    put("RollMotorControlStrength", Ronin2GimbalParamsManager.BaseCommand.STRENGTH_ROLL);
    put("PitchMotorControlGyroFilteringFactor", Ronin2GimbalParamsManager.BaseCommand.FILTERING_PITCH);
    put("YawMotorControlGyroFilteringFactor", Ronin2GimbalParamsManager.BaseCommand.FILTERING_YAW);
    put("RollMotorControlGyroFilteringFactor", Ronin2GimbalParamsManager.BaseCommand.FILTERING_ROLL);
    put("PitchMotorControlPreControl", Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_PITCH);
    put("YawMotorControlPreControl", Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_YAW);
    put("RollMotorControlPreControl", Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_ROLL);
    put("MotorBlockUpTime", Ronin2GimbalParamsManager.BaseCommand.MOTOR_BLOCK_UP_TIME);
    put("YawFineTuning", Ronin2GimbalParamsManager.BaseCommand.YAW_FINE_TUNING);
    put("MotorEnabled", Ronin2GimbalParamsManager.BaseCommand.MOTOR_SPECIAL_CMD);
    put("ForbidTriggerSelfie", Ronin2GimbalParamsManager.BaseCommand.MOTOR_SPECIAL_CMD);
    put("ForbidVerticalShootingSwitch", Ronin2GimbalParamsManager.BaseCommand.MOTOR_SPECIAL_CMD);
    put("ForbidRoll360Switch", Ronin2GimbalParamsManager.BaseCommand.MOTOR_SPECIAL_CMD);
    put("StartBalanceTest", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("BalanceTestStatus", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("IsTestingBalance", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("PitchTestResult", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("RollTestResult", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("YawTestResult", Ronin2GimbalParamsManager.BaseCommand.BALANCE_TEST);
    put("PitchFineTuning", Ronin2GimbalParamsManager.BaseCommand.PITCH_FINE_TUNING);
    put("GimbalHoldType", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_HOLD_TYPE);
    put("GimbalWorkMode", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_WORK_MODE);
    put("GimbalAxisMode", Ronin2GimbalParamsManager.BaseCommand.FLOWER_SPECIAL_CMD);
    put("PushEnableYaw", Ronin2GimbalParamsManager.BaseCommand.PUSH_ENABLE_YAW);
    put("PushEnablePitch", Ronin2GimbalParamsManager.BaseCommand.PUSH_ENABLE_PITCH);
    put("PushEnableRoll", Ronin2GimbalParamsManager.BaseCommand.PUSH_ENABLE_ROLL);
    put("GimbalInputSource", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_INPUT_SOURCE);
    put("GimbalCreateSmoothRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_ROLL);
    put("GimbalCreateSmoothPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_PITCH);
    put("GimbalCreateSmoothYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_YAW);
    put("GimbalCreateMaxSpeedRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_ROLL);
    put("GimbalCreateMaxSpeedPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_PITCH);
    put("GimbalCreateMaxSpeedYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_YAW);
    put("GimbalMotionSmoothRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_ROLL);
    put("GimbalMotionSmoothPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_PITCH);
    put("GimbalMotionSmoothYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_YAW);
    put("GimbalMotionMaxSpeedRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_ROLL);
    put("GimbalMotionMaxSpeedPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_PITCH);
    put("GimbalMotionMaxSpeedYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_YAW);
    put("GimbalGamepadSmoothRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_ROLL);
    put("GimbalGamepadSmoothPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_PITCH);
    put("GimbalGamepadSmoothYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_SMOOTH_YAW);
    put("GimbalGamepadMaxSpeedRoll", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_ROLL);
    put("GimbalGamepadMaxSpeedPitch", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_PITCH);
    put("GimbalGamepadMaxSpeedYaw", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_CREATE_MAX_SPEED_YAW);
    put("TrackingSpeed", Ronin2GimbalParamsManager.BaseCommand.TRACKING_SPEED);
    put("TrackingOrientationVertical", Ronin2GimbalParamsManager.BaseCommand.TRACKING_ORIENTATION_VERTICAL);
    put("GimbalAutoMovement", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_AUTO_MOVEMENT);
    put("GimbalFoldMode", Ronin2GimbalParamsManager.BaseCommand.GIMBAL_FOLD_MODE);
    put("YawSmoothTrackEnabled", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ENABLED_YAW);
    put("PitchSmoothTrackEnabled", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ENABLED_PITCH);
    put("RollSmoothTrackEnabled", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ENABLED_ROLL);
    put("YawSmoothTrackSpeed", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_SPEED_YAW);
    put("PitchSmoothTrackSpeed", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_SPEED_PITCH);
    put("RollSmoothTrackSpeed", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_SPEED_ROLL);
    put("YawSmoothTrackDeadband", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_DEADBAND_YAW);
    put("PitchSmoothTrackDeadband", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_DEADBAND_PITCH);
    put("RollSmoothTrackDeadband", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_DEADBAND_ROLL);
    put("YawSmoothTrackAcceleration", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ACCELERATION_YAW);
    put("PitchSmoothTrackAcceleration", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ACCELERATION_PITCH);
    put("RollSmoothTrackAcceleration", Ronin2GimbalParamsManager.BaseCommand.SMOOTH_TRACK_ACCELERATION_ROLL);
    put("YawControllerSmoothingFactor", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_SMOOTHING_YAW);
    put("PitchControllerSmoothingFactor", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_SMOOTHING_PITCH);
    put("RollControllerSmoothingFactor", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_SMOOTHING_ROLL);
    put("YawControllerDeadband", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_DEADBAND_YAW);
    put("PitchControllerDeadband", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_DEADBAND_PITCH);
    put("RollControllerDeadband", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_DEADBAND_ROLL);
    put("ControllerMaxSpeedYaw", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_MAX_SPEED_YAW);
    put("ControllerMaxSpeedPitch", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_MAX_SPEED_PITCH);
    put("ControllerMaxSpeedRoll", Ronin2GimbalParamsManager.BaseCommand.CONTROLLER_MAX_SPEED_ROLL);
    put("Ronin2MaxAngleYaw", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MAX_ANGLE_YAW);
    put("Ronin2MinAngleYaw", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MIN_ANGLE_YAW);
    put("Ronin2MaxAnglePitch", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MAX_ANGLE_PITCH);
    put("Ronin2MinAnglePitch", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MIN_ANGLE_PITCH);
    put("Ronin2MaxAngleRoll", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MAX_ANGLE_ROLL);
    put("Ronin2MinAngleRoll", Ronin2GimbalParamsManager.BaseCommand.RONIN2_MIN_ANGLE_ROLL);
    put("IsChannel1Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_1_PARAMS);
    put("Channel1MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_1_PARAMS);
    put("IsChannel2Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_2_PARAMS);
    put("Channel2MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_2_PARAMS);
    put("IsChannel3Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_3_PARAMS);
    put("Channel3MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_3_PARAMS);
    put("IsChannel4Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_4_PARAMS);
    put("Channel4MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_4_PARAMS);
    put("IsChannel5Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_5_PARAMS);
    put("Channel5MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_5_PARAMS);
    put("IsChannel6Rev", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_6_PARAMS);
    put("Channel6MapState", Ronin2GimbalParamsManager.BaseCommand.RONIN2_CHANNEL_6_PARAMS);
    put("IsAutoTune", Ronin2GimbalParamsManager.BaseCommand.AUTO_TUNE_ENABLED);
    put("AutoTuneProgress", Ronin2GimbalParamsManager.BaseCommand.AUTO_TUNE_ENABLED);
    put("AutoTunePercent", Ronin2GimbalParamsManager.BaseCommand.AUTO_TUNE_PERCENT);
    put("FollowSpeedMode", Ronin2GimbalParamsManager.BaseCommand.FOLLOW_SPEED_MODE);
    put("FollowDeadZoneMode", Ronin2GimbalParamsManager.BaseCommand.FOLLOW_DEAD_ZONE_MODE);
    put("RcSpeedMode", Ronin2GimbalParamsManager.BaseCommand.RC_SPEED_MODE);
    put("RcDeadZoneMode", Ronin2GimbalParamsManager.BaseCommand.RC_DEAD_ZONE_MODE);
    put("RcSmoothMode", Ronin2GimbalParamsManager.BaseCommand.RC_SMOOTH_MODE);
    put("ControlParamMode", Ronin2GimbalParamsManager.BaseCommand.CONTROL_PARAM_MODE);
    put("FollowAcceMode", Ronin2GimbalParamsManager.BaseCommand.FOLLOW_ACCE_MODE);
    put("Channel1Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel1.mId);
    put("Channel2Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel2.mId);
    put("Channel3Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel3.mId);
    put("Channel4Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel4.mId);
    put("Channel5Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel5.mId);
    put("Channel6Val", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.Channel6.mId);
    put("PeripheralPowerPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PMotorPower.mId);
    put("PeripheralPowerYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YMotorPower.mId);
    put("PeripheralPowerRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RMotorPower.mId);
    put("PeripheralAnglePitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PMotorAngle.mId);
    put("PeripheralAngleYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YMotorAngle.mId);
    put("PeripheralAngleRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RMotorAngle.mId);
    put("PeripheralTempPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PMotorTemp.mId);
    put("PeripheralTempYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YMotorTemp.mId);
    put("PeripheralTempRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RMotorTemp.mId);
    put("PeripheralPosPitchBias", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PPoseBias.mId);
    put("PeripheralPosYawBias", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YPoseBias.mId);
    put("PeripheralPosRollBias", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RPoseBias.mId);
    put("PeripheralPosPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PActualPose.mId);
    put("PeripheralPosYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YActualPose.mId);
    put("PeripheralPosRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RActualPose.mId);
    put("PeripheralTargetPosPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PTargetPose.mId);
    put("PeripheralTargetPosYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YTargetPose.mId);
    put("PeripheralTargetPosRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RTargetPose.mId);
    put("PeripheralGyroOutPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PGyroOut.mId);
    put("PeripheralGyroOutYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YGyroOut.mId);
    put("PeripheralGyroOutRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RGyroOut.mId);
    put("PeripheralGyroAccePitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PAcceOut.mId);
    put("PeripheralGyroAcceYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YAcceOut.mId);
    put("PeripheralGyroAcceRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RAcceOut.mId);
    put("PeripheralGyroBiasPitch", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.PGyroBias.mId);
    put("PeripheralGyroBiasYaw", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.YGyroBias.mId);
    put("PeripheralGyroBiasRoll", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.RGyroBias.mId);
    put("PeripheralGpsNum", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsNum.mId);
    put("PeripheralGpsLat", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsLat.mId);
    put("PeripheralGpsLng", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsLong.mId);
    put("PeripheralGpsNorthSpeed", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsNorthSpeed.mId);
    put("PeripheralGpsEastSpeed", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsEastSpeed.mId);
    put("PeripheralGpsNorthAcceSpeed", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsNorthAcceSpeed.mId);
    put("PeripheralGpsEastAcceSpeed", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.GpsEastAcceSpeed.mId);
    put("PeripheralHandDeviceAngle", CmdIdGimbal.CmdIdType.SetPushPeripheralStatus.value(), DataGimbalSetPushPeripheralStatus.DataType.HandDeviceAngle.mId);
    this.mHandler = new InnerHandler(DJISDKCacheThreadManager.getInstance().getBackgroundLooper());
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
    this.mExecutor = localScheduledThreadPoolExecutor;
    localScheduledThreadPoolExecutor.scheduleAtFixedRate(new -..Lambda.Ronin2SubscribeIMPL.QvdLre9uNacWlNhYs8Kq-bni-Lw(this), 0L, 1L, TimeUnit.SECONDS);
  }
  
  private void log(String paramString) {}
  
  private Message obtainMessageWithCmd(int paramInt, String paramString)
  {
    return null;
  }
  
  /* Error */
  private void put(String arg1, Ronin2GimbalParamsManager.BaseCommand arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void callGetValue(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean contains(String paramString)
  {
    return false;
  }
  
  public void destroy()
  {
    this.mExecutor.shutdown();
  }
  
  public Pair<Integer, Integer> get(String paramString)
  {
    return null;
  }
  
  public DJIComponentManager.GimbalComponentType getComponent()
  {
    return DJIComponentManager.GimbalComponentType.Ronin2;
  }
  
  public Set<String> getSubscribeKeys()
  {
    return this.mKeyCmdChannelMap.keySet();
  }
  
  /* Error */
  public void put(String arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerPushValue(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unregisterPushValue(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final class InnerHandler
    extends Handler
  {
    static final int REGISTER = 1;
    static final int UNREGISTER = 2;
    private final DataGimbalSubscribeParams setter = DataGimbalSubscribeParams.getInstance();
    
    public InnerHandler(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\Ronin2SubscribeIMPL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */