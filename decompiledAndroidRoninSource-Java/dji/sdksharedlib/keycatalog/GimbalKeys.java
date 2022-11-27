package dji.sdksharedlib.keycatalog;

import dji.common.gimbal.Attitude;
import dji.common.gimbal.BalanceState;
import dji.common.gimbal.BalanceTestResult;
import dji.common.gimbal.DJIGimbalHoldType;
import dji.common.gimbal.DJIGimbalRonin2AxisMode;
import dji.common.gimbal.DJIGimbalRonin2WorkMode;
import dji.common.gimbal.GimbalMapState;
import dji.common.gimbal.GimbalMode;
import dji.common.gimbal.MotorControlPreset;
import dji.common.gimbal.MovementSettingsProfile;
import dji.common.gimbal.Rotation;
import dji.common.handheldcontroller.ControllerMode;
import dji.midware.data.model.P3.DataCommonGetPushUpgradeStatus.DJIUpgradeStep;
import dji.midware.data.model.P3.DataGimbalGetPushCalibrationStatus.CalibrationStatus;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.airlink.lb.Lightbridge2Phantom4PAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalFoldingDroneAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalHandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalMobileHandheldAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalRonin2Abstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalRoninMXAbstraction;
import dji.sdksharedlib.hardware.abstractions.gimbal.DJIGimbalSparkAbstraction;
import dji.sdksharedlib.keycatalog.extension.ComplexKey;
import dji.sdksharedlib.keycatalog.extension.Key;
import java.util.Map;

public class GimbalKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=8, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=MotorControlPreset.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String APPLY_MOTOR_CONTROL_PRESET = "ApplyMotorControlPreset";
  @Key(accessType=4, type=Attitude.class)
  public static final String ATTITUDE_IN_DEGREES = "AttitudeInDegrees";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String AUTO_TUNE_PERCENT = "AutoTunePercent";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String AUTO_TUNE_PROGRESS = "AutoTuneProgress";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=DataGimbalGetPushCalibrationStatus.CalibrationStatus.class)
  public static final String AUTO_TUNE_STATUS = "AutoTuneStatus";
  @Key(accessType=4, includedAbstractions={DJIGimbalMobileHandheldAbstraction.class}, types={BalanceState.class})
  public static final String BALANCE_STATE = "BalanceState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String BALANCE_TEST_STATUS = "BalanceTestStatus";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String BLUETOOTH_PASSWORD = "bluetoothPwd";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String BLUETOOTH_SSID = "bluetoothSSID";
  @Key(accessType=4, includedAbstractions={Lightbridge2Phantom4PAbstraction.class}, type=Integer.class)
  public static final String CALIBRATION_PROGRESS = "CalibrationProgress";
  @Key(accessType=1, type=Map.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CAPABILITIES = "Capabilities";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_1_MAP_STATE = "Channel1MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_1_VAL = "Channel1Val";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_2_MAP_STATE = "Channel2MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_2_VAL = "Channel2Val";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_3_MAP_STATE = "Channel3MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_3_VAL = "Channel3Val";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_4_MAP_STATE = "Channel4MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_4_VAL = "Channel4Val";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_5_MAP_STATE = "Channel5MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_5_VAL = "Channel5Val";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={GimbalMapState.class})
  public static final String CHANNEL_6_MAP_STATE = "Channel6MapState";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Integer.class})
  public static final String CHANNEL_6_VAL = "Channel6Val";
  @Key(accessType=4, type=Integer.class)
  public static final String CHARGE_REMAINING_IN_PERCENT = "ChargeRemainingInPercent";
  public static final String COMPONENT_KEY = "Gimbal";
  @Key(accessType=8, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Number[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONFIGURE_CUSTOM_MOTOR_CONTROL = "MotorCustomControl";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONTROLLER_MAX_SPEED_PITCH = "ControllerMaxSpeedPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONTROLLER_MAX_SPEED_ROLL = "ControllerMaxSpeedRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONTROLLER_MAX_SPEED_YAW = "ControllerMaxSpeedYaw";
  @Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, type=ControllerMode.class)
  public static final String CONTROLLER_MODE = "ControllerMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String CONTROL_PARAM_MODE = "ControlParamMode";
  @Key(accessType=8, includedAbstractions={DJIGimbalSparkAbstraction.class}, type=Float.class)
  public static final String FINE_TUNE_PITCH_IN_DEGREES = "FineTunePitchInDegrees";
  @Key(accessType=8, type=Float.class)
  public static final String FINE_TUNE_ROLL_IN_DEGREES = "FineTuneRollInDegrees";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String FOLLOW_ACCE_MODE = "FollowAcceMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String FOLLOW_DEAD_ZONE_MODE = "FollowDeadZoneMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String FOLLOW_SPEED_MODE = "FollowSpeedMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String FORBID_ROLL_360_SWITCH = "ForbidRoll360Switch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String FORBID_TRIGGER_SELFIE = "ForbidTriggerSelfie";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String FORBID_VERTICAL_SHOOTING_SWITCH = "ForbidVerticalShootingSwitch";
  @Key(accessType=4, type=Integer.class)
  public static final String FPV_SUBMODE = "FpvSubMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_AUTO_MOVEMENT = "GimbalAutoMovement";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=DJIGimbalRonin2AxisMode.class)
  public static final String GIMBAL_AXIS_MODE = "GimbalAxisMode";
  @Key(accessType=4, type=Boolean.class)
  public static final String GIMBAL_CONNECTED_TO_MONITOR = "GimbalConnectedToMonitor";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_MAX_SPEED_PITCH = "GimbalCreateMaxSpeedPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_MAX_SPEED_ROLL = "GimbalCreateMaxSpeedRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_MAX_SPEED_YAW = "GimbalCreateMaxSpeedYaw";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_SMOOTH_PITCH = "GimbalCreateSmoothPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_SMOOTH_ROLL = "GimbalCreateSmoothRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_CREATE_SMOOTH_YAW = "GimbalCreateSmoothYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String GIMBAL_FOLD_MODE = "GimbalFoldMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_MAX_SPEED_PITCH = "GimbalGamepadMaxSpeedPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_MAX_SPEED_ROLL = "GimbalGamepadMaxSpeedRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_MAX_SPEED_YAW = "GimbalGamepadMaxSpeedYaw";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_SMOOTH_PITCH = "GimbalGamepadSmoothPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_SMOOTH_ROLL = "GimbalGamepadSmoothRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_GAMEPAD_SMOOTH_YAW = "GimbalGamepadSmoothYaw";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=DJIGimbalHoldType.class)
  public static final String GIMBAL_HOLD_TYPE = "GimbalHoldType";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_INPUT_SOURCE = "GimbalInputSource";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_MAX_SPEED_PITCH = "GimbalMotionMaxSpeedPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_MAX_SPEED_ROLL = "GimbalMotionMaxSpeedRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_MAX_SPEED_YAW = "GimbalMotionMaxSpeedYaw";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_SMOOTH_PITCH = "GimbalMotionSmoothPitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_SMOOTH_ROLL = "GimbalMotionSmoothRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GIMBAL_MOTION_SMOOTH_YAW = "GimbalMotionSmoothYaw";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_SERIAL_NUMBER = "GimbalSerialNumber";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_UPGRADE_BREAK_POINT_FIRMWARE = "GimbalUpgradeBreakPointFirmWare";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_UPGRADE_BREAK_POINT_MODULEID = "GimbalUpgradeBreakPointModuleId";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_UPGRADE_PROGRESS = "GimbalUpgradeProgress";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=DataCommonGetPushUpgradeStatus.DJIUpgradeStep.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_UPGRADE_STATUS = "GimbalUpgradeStatus";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=DJIGimbalRonin2WorkMode.class)
  public static final String GIMBAL_WORK_MODE = "GimbalWorkMode";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_ATTITUDE_RESET = "IsAttitudeReset";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String IS_AUTO_TUNE = "IsAutoTune";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_CALIBRATING = "IsCalibrating";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_CALIBRATION_SUCCESSFUL = "IsCalibrationSuccessful";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_1_REV = "IsChannel1Rev";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_2_REV = "IsChannel2Rev";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_3_REV = "IsChannel3Rev";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_4_REV = "IsChannel4Rev";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_5_REV = "IsChannel5Rev";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, types={Boolean.class})
  public static final String IS_CHANNEL_6_REV = "IsChannel6Rev";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_GIMBAL_ON_TOP = "IsGimbalOnTopPosition";
  @Key(accessType=4, includedAbstractions={DJIGimbalMobileHandheldAbstraction.class}, types={Boolean.class})
  public static final String IS_MOBILE_DEVICE_MOUNTED = "isMobileDeviceMounted";
  @Key(accessType=4, includedAbstractions={DJIGimbalMobileHandheldAbstraction.class}, types={Boolean.class})
  public static final String IS_MOTOR_OVER_LOADED = "IsMotorOverloaded";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_PITCH_AT_STOP = "IsPitchAtStop";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_ROLL_AT_STOP = "IsRollAtStop";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_STUCK = "IsStuck";
  @Key(accessType=4, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String IS_TESTING_BALANCE = "IsTestingBalance";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_YAW_AT_STOP = "IsYawAtStop";
  @Key(accessType=6, type=GimbalMode.class)
  public static final String MODE = "Mode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String MOTOR_BLOCK_UP_TIME = "MotorBlockUpTime";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Boolean.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)})
  public static final String MOTOR_ENABLED = "MotorEnabled";
  @Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, type=MovementSettingsProfile.class)
  public static final String MOVEMENT_SETTINGS_PROFILE = "MovementSettingsProfile";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_ANGLE_PITCH = "PeripheralAnglePitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_ANGLE_ROLL = "PeripheralAngleRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_ANGLE_YAW = "PeripheralAngleYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_EAST_ACCE_SPEED = "PeripheralGpsEastAcceSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_EAST_SPEED = "PeripheralGpsEastSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Double.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_LAT = "PeripheralGpsLat";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Double.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_LNG = "PeripheralGpsLng";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_NORTH_ACCE_SPEED = "PeripheralGpsNorthAcceSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_NORTH_SPEED = "PeripheralGpsNorthSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GPS_NUM = "PeripheralGpsNum";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_ACCE_PITCH = "PeripheralGyroAccePitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_ACCE_ROLL = "PeripheralGyroAcceRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_ACCE_YAW = "PeripheralGyroAcceYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_BIAS_PITCH = "PeripheralGyroBiasPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_BIAS_ROLL = "PeripheralGyroBiasRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_BIAS_YAW = "PeripheralGyroBiasYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_OUT_PITCH = "PeripheralGyroOutPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_OUT_ROLL = "PeripheralGyroOutRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_GYRO_OUT_YAW = "PeripheralGyroOutYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_HAND_DEVICE_ANGLE = "PeripheralHandDeviceAngle";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_PITCH = "PeripheralPosPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_PITCH_BIAS = "PeripheralPosPitchBias";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_ROLL = "PeripheralPosRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_ROLL_BIAS = "PeripheralPosRollBias";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_YAW = "PeripheralPosYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POS_YAW_BIAS = "PeripheralPosYawBias";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POWER_PITCH = "PeripheralPowerPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POWER_ROLL = "PeripheralPowerRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_POWER_YAW = "PeripheralPowerYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TARGET_POS_PITCH = "PeripheralTargetPosPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TARGET_POS_ROLL = "PeripheralTargetPosRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TARGET_POS_YAW = "PeripheralTargetPosYaw";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TEMP_PITCH = "PeripheralTempPitch";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TEMP_ROLL = "PeripheralTempRoll";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PERIPHERAL_TEMP_YAW = "PeripheralTempYaw";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String PITCH_CONTROLLER_DEADBAND = "PitchControllerDeadband";
  @ComplexKey({@Key(accessType=3, type=Integer.class), @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String PITCH_CONTROLLER_SMOOTHING_FACTOR = "PitchControllerSmoothingFactor";
  @Key(accessType=3, type=Integer.class)
  public static final String PITCH_CONTROLLER_SPEED_COEFFICIENT = "PitchControllerSpeedCoefficient";
  @Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class)
  public static final String PITCH_DOWN_ENDPOINT = "PitchDownEndpoint";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String PITCH_FINE_TUNING = "PitchFineTuning";
  @Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, types={Boolean.class})
  public static final String PITCH_INVERTED_CONTROL_ENABLED = "PitchInvertedControlEnabled";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = "PitchMotorControlGyroFilteringFactor";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_MOTOR_CONTROL_PRE_CONTROL = "PitchMotorControlPreControl";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_MOTOR_CONTROL_STIFFNESS = "PitchMotorControlStiffness";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_MOTOR_CONTROL_STRENGTH = "PitchMotorControlStrength";
  @Key(accessType=3, type=Boolean.class)
  public static final String PITCH_RANGE_EXTENSION_ENABLED = "PitchRangeExtensionEnabled";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_SMOOTH_TRACK_ACCELERATION = "PitchSmoothTrackAcceleration";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class, DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_SMOOTH_TRACK_DEADBAND = "PitchSmoothTrackDeadband";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, type=Boolean.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)})
  public static final String PITCH_SMOOTH_TRACK_ENABLED = "PitchSmoothTrackEnabled";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class, DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String PITCH_SMOOTH_TRACK_SPEED = "PitchSmoothTrackSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, type=BalanceTestResult.class)
  public static final String PITCH_TEST_RESULT = "PitchTestResult";
  @Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class)
  public static final String PITCH_UP_ENDPOINT = "PitchUpEndpoint";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String PUSH_ENABLE_PITCH = "PushEnablePitch";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String PUSH_ENABLE_ROLL = "PushEnableRoll";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String PUSH_ENABLE_YAW = "PushEnableYaw";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String RC_DEAD_ZONE_MODE = "RcDeadZoneMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String RC_SMOOTH_MODE = "RcSmoothMode";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String RC_SPEED_MODE = "RcSpeedMode";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESET_GIMBAL = "ResetGimbal";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESTORE_FACTORY_SETTINGS = "RestoreFactorySettings";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ROLL_CONTROLLER_DEADBAND = "RollControllerDeadband";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ROLL_CONTROLLER_SMOOTHING_FACTOR = "RollControllerSmoothingFactor";
  @Key(accessType=4, type=Float.class)
  public static final String ROLL_FINE_TUNE_IN_DEGREES = "RollFineTuneInDegrees";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String ROLL_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = "RollMotorControlGyroFilteringFactor";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String ROLL_MOTOR_CONTROL_PRE_CONTROL = "RollMotorControlPreControl";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String ROLL_MOTOR_CONTROL_STIFFNESS = "RollMotorControlStiffness";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String ROLL_MOTOR_CONTROL_STRENGTH = "RollMotorControlStrength";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String ROLL_SMOOTH_TRACK_ACCELERATION = "RollSmoothTrackAcceleration";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String ROLL_SMOOTH_TRACK_DEADBAND = "RollSmoothTrackDeadband";
  @ComplexKey({@Key(accessType=3, type=Boolean.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)})
  public static final String ROLL_SMOOTH_TRACK_ENABLED = "RollSmoothTrackEnabled";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String ROLL_SMOOTH_TRACK_SPEED = "RollSmoothTrackSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, type=BalanceTestResult.class)
  public static final String ROLL_TEST_RESULT = "RollTestResult";
  @Key(accessType=4, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Map.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_GIMBAL_CAPABILITIES = "Ronin2Capabilities";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MAX_ANGLE_PITCH = "Ronin2MaxAnglePitch";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MAX_ANGLE_ROLL = "Ronin2MaxAngleRoll";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MAX_ANGLE_YAW = "Ronin2MaxAngleYaw";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MIN_ANGLE_PITCH = "Ronin2MinAnglePitch";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MIN_ANGLE_ROLL = "Ronin2MinAngleRoll";
  @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RONIN2_MIN_ANGLE_YAW = "Ronin2MinAngleYaw";
  @Key(accessType=8, types={Rotation.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ROTATE = "Rotate";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String SILENT_MODE = "SilentMode";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_AUTO_TUNE = "StartAutoTune";
  @Key(accessType=8, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_BALANCE_TEST = "StartBalanceTest";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_CALIBRATION = "StartCalibration";
  @Key(accessType=4, type=Integer.class)
  public static final String TOF_STATUS = "tof_status";
  @Key(accessType=8, includedAbstractions={DJIGimbalHandheldAbstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TOGGLE_SELFIE = "ToggleSelfie";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)
  public static final String TRACKING_ORIENTATION_VERTICAL = "TrackingOrientationVertical";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String TRACKING_SPEED = "TrackingSpeed";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String USER_PROFILE = "UserProfile";
  @Key(accessType=4, type=Float.class)
  public static final String YAW_ANGLE_WITH_AIRCRAFT_IN_DEGREE = "YawAngleWithAircraftInDegree";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN), @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String YAW_CONTROLLER_DEADBAND = "YawControllerDeadband";
  @ComplexKey({@Key(accessType=3, excludedAbstractions={DJIGimbalFoldingDroneAbstraction.class, DJIGimbalSparkAbstraction.class}, type=Integer.class), @Key(accessType=5, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String YAW_CONTROLLER_SMOOTHING_FACTOR = "YawControllerSmoothingFactor";
  @Key(accessType=3, excludedAbstractions={DJIGimbalFoldingDroneAbstraction.class, DJIGimbalSparkAbstraction.class}, type=Integer.class)
  public static final String YAW_CONTROLLER_SPEED_COEFFICIENT = "YawControllerSpeedCoefficient";
  @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)
  public static final String YAW_FINE_TUNING = "YawFineTuning";
  @Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, types={Boolean.class})
  public static final String YAW_INVERTED_CONTROL_ENABLED = "YawInvertedControlEnabled";
  @Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class)
  public static final String YAW_LEFT_ENDPOINT = "YawLeftEndpoint";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = "YawMotorControlGyroFilteringFactor";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_MOTOR_CONTROL_PRE_CONTROL = "YawMotorControlPreControl";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_MOTOR_CONTROL_STIFFNESS = "YawMotorControlStiffness";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_MOTOR_CONTROL_STRENGTH = "YawMotorControlStrength";
  @Key(accessType=3, includedAbstractions={DJIGimbalRoninMXAbstraction.class}, type=Integer.class)
  public static final String YAW_RIGHT_ENDPOINT = "YawRightEndpoint";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_SMOOTH_TRACK_ACCELERATION = "YawSmoothTrackAcceleration";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class, DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_SMOOTH_TRACK_DEADBAND = "YawSmoothTrackDeadband";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalMobileHandheldAbstraction.class}, type=MovementSettingsProfile.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Boolean.class)})
  public static final String YAW_SMOOTH_TRACK_ENABLED = "YawSmoothTrackEnabled";
  @ComplexKey({@Key(accessType=3, includedAbstractions={DJIGimbalHandheldAbstraction.class, DJIGimbalMobileHandheldAbstraction.class, DJIGimbalRoninMXAbstraction.class}, type=Integer.class), @Key(accessType=6, includedAbstractions={DJIGimbalRonin2Abstraction.class}, type=Integer.class)})
  public static final String YAW_SMOOTH_TRACK_SPEED = "YawSmoothTrackSpeed";
  @Key(accessType=4, includedAbstractions={DJIGimbalRoninMXAbstraction.class, DJIGimbalRonin2Abstraction.class}, type=BalanceTestResult.class)
  public static final String YAW_TEST_RESULT = "YawTestResult";
  
  public GimbalKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "Gimbal";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\GimbalKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */