package dji.publics.LogReport.base;

public abstract interface Values
{
  public static abstract interface AppUpgrade
  {
    public static final String APP_UPGRADE_TYPE_FORCE = "2";
    public static final String APP_UPGRADE_TYPE_NORMAL = "1";
    public static final String APP_UPGRADE_VALUE_CANCEL = "4";
    public static final String APP_UPGRADE_VALUE_IGNORE = "3";
    public static final String APP_UPGRADE_VALUE_SHOW = "1";
    public static final String APP_UPGRADE_VALUE_START = "2";
  }
  
  public static abstract interface BLE
  {
    public static final String BLE_CONNECT_AUTO = "6";
    public static final String BLE_CONNECT_CLICKED = "5";
    public static final String BLE_DISCONNECT_CLICKED = "7";
    public static final String BLE_DISCONNECT_UNEXP = "8";
    public static final String BLE_HOME_CLICK_BINNER = "2";
    public static final String BLE_HOME_CLICK_CONNECT = "3";
    public static final String BLE_HOME_GOTOPREVIEW = "9";
    public static final String BLE_HOME_SHOW_BINNER = "1";
    public static final String BLE_PAGEID_HONE = "1";
    public static final String BLE_PAGEID_PREVIEW = "2";
    public static final String BLE_SHOW_LIST = "4";
  }
  
  public static abstract interface CommonResult
  {
    public static final String RESULT_FAIL = "2";
    public static final String RESULT_SUCCESS = "1";
  }
  
  public static abstract interface CreateAction
  {
    public static final String CREATE_ACTION_CAMERA_SETTINGS = "8";
    public static final String CREATE_ACTION_ENTER = "1";
    public static final String CREATE_ACTION_JOYSTICK_ROLL = "3";
    public static final String CREATE_ACTION_OPEN_JOYSTICK = "2";
    public static final String CREATE_ACTION_PREVIEW = "4";
    public static final String CREATE_ACTION_START_TAKE = "5";
    public static final String CREATE_ACTION_STOP_TAKE = "6";
    public static final String CREATE_ACTION_TAKE_FINISH = "7";
  }
  
  public static abstract interface CreateDelayType
  {
    public static final String CREATE_DELAY_TYPE_MOTIONLAPSE = "2";
    public static final String CREATE_DELAY_TYPE_TIMELAPSE = "1";
  }
  
  public static abstract interface CreatePanoramaSensor
  {
    public static final String CREATE_PANORAMA_SENSOR_1 = "1";
    public static final String CREATE_PANORAMA_SENSOR_2 = "2";
    public static final String CREATE_PANORAMA_SENSOR_3 = "3";
  }
  
  public static abstract interface CreateTrackingAction
  {
    public static final String TRACKING_ACTION_BOX_IN = "3";
    public static final String TRACKING_ACTION_ENTER = "1";
    public static final String TRACKING_ACTION_LOST = "4";
    public static final String TRACKING_ACTION_POINT_IN = "8";
    public static final String TRACKING_ACTION_RECORD = "5";
    public static final String TRACKING_ACTION_TRIGGER_IN = "2";
    public static final String TRACKING_ACTION_TRIGGER_OUT = "6";
    public static final String TRACKING_ACTION_USER_OUT = "7";
  }
  
  public static abstract interface CreateTrackingSpeed
  {
    public static final String TRACKING_SEPEED_FAST = "2";
    public static final String TRACKING_SEPEED_SLOW = "1";
  }
  
  public static abstract interface CreateTrackingTarget
  {
    public static final String TRACKING_TARGET_MAN = "1";
    public static final String TRACKING_TARGET_OBJECT = "2";
    public static final String TRACKING_TARGET_UNKOWN = "0";
  }
  
  public static abstract interface CreateType
  {
    public static final String CREATE_TYPE_FORCEMOBILE = "7";
    public static final String CREATE_TYPE_GAMEPAD = "8";
    public static final String CREATE_TYPE_MOTIONLAPSE = "4";
    public static final String CREATE_TYPE_PANORAMA = "2";
    public static final String CREATE_TYPE_TIMELAPSE = "3";
    public static final String CREATE_TYPE_TIMELAPSE_NEW = "6";
    public static final String CREATE_TYPE_TRACK = "5";
    public static final String CREATE_TYPE_UNKOWN = "0";
    public static final String CREATE_TYPE_VIRTUAL_JOYSTICK = "1";
  }
  
  public static abstract interface FirmwareUpgradeAction
  {
    public static final String UPGRADE_ACTION_DIALOG = "2";
    public static final String UPGRADE_ACTION_DOWNLOAD_SUCCESS = "4";
    public static final String UPGRADE_ACTION_POPUP = "1";
    public static final String UPGRADE_ACTION_START_DOWNLOAD = "3";
    public static final String UPGRADE_ACTION_START_UPDATE = "5";
    public static final String UPGRADE_ACTION_UPGRADE_FAIL = "7";
    public static final String UPGRADE_ACTION_UPGRADE_SUCCESS = "6";
  }
  
  public static abstract interface FirmwareUpgradeModule
  {
    public static final String UPGRADE_MODULE_BLE = "3";
    public static final String UPGRADE_MODULE_FOCUS_MOTOR = "6";
    public static final String UPGRADE_MODULE_FOCUS_WHEEL = "4";
    public static final String UPGRADE_MODULE_GCU = "2";
    public static final String UPGRADE_MODULE_IMU = "1";
    public static final String UPGRADE_MODULE_LCD = "5";
    public static final String UPGRADE_MODULE_NA = "0";
  }
  
  public static abstract interface FirmwareUpgradeType
  {
    public static final String UPGRADE_TYPE_DOWNGRADE = "2";
    public static final String UPGRADE_TYPE_UPGRADE = "1";
  }
  
  public static abstract interface MotorAdvancedSetting
  {
    public static final String ADVANCED_SETTING_CONTROL = "4";
    public static final String ADVANCED_SETTING_FILTER = "3";
    public static final String ADVANCED_SETTING_STRENGTH = "2";
    public static final String OPEN_ADVANCED_SETTING = "1";
  }
  
  public static abstract interface MotorCustomSettingAxis
  {
    public static final String CUSTOM_SETTING_AXIS_PITCH = "2";
    public static final String CUSTOM_SETTING_AXIS_ROLL = "3";
    public static final String CUSTOM_SETTING_AXIS_YAW = "1";
  }
  
  public static abstract interface Motor_AutoTune
  {
    public static final String MOTOR_AUTOTUNE_ENTER_CONFIG = "1";
    public static final String MOTOR_AUTOTUNE_LEVEL_HIGH = "3";
    public static final String MOTOR_AUTOTUNE_LEVEL_LOW = "4";
    public static final String MOTOR_AUTOTUNE_LEVEL_MIDDLE = "2";
    public static final String MOTOR_AUTOTUNE_SUCCESS = "5";
  }
  
  public static abstract interface RoninGimbalBalanceTest
  {
    public static final String ACTION_ENTER = "1";
    public static final String ACTION_FAIL = "5";
    public static final String ACTION_START = "2";
    public static final String ACTION_SUCCESS = "4";
    public static final String ACTION_UNTILTED = "3";
    public static final String RESULT_BAD = "2";
    public static final String RESULT_GOOD = "1";
  }
  
  public static abstract interface RoninGimbalBalanceTutorial
  {
    public static final String ACTION_ENTER = "1";
    public static final String ACTION_FINISH = "6";
    public static final String ACTION_PITCH = "2";
    public static final String ACTION_ROLL = "3";
    public static final String ACTION_SKIP_EXIT = "5";
    public static final String ACTION_YAW = "4";
  }
  
  public static abstract interface RoninS3DRoll360Action
  {
    public static final String ACTION_CLOSED_3DROLL360 = "2";
    public static final String ACTION_OPEN_3DROLL360 = "1";
  }
  
  public static abstract interface RoninS3DRoll360Result
  {
    public static final String RESULT_FAIL_3DROLL360 = "2";
    public static final String RESULT_SUCCESS_3DROLL360 = "1";
  }
  
  public static abstract interface RoninScBeginnerGuide
  {
    public static final String ACTION_ENTER = "1";
    public static final String ACTION_FINISH = "6";
    public static final String ACTION_PAGE_BALANCE_ADJUST = "2";
    public static final String ACTION_PAGE_BUTTON_INTRODUCE = "5";
    public static final String ACTION_PAGE_MOTOR_CONFIG = "4";
    public static final String ACTION_SKIP = "3";
  }
  
  public static abstract interface RoninSystemStatus
  {
    public static final String ACTION_ENTER_SETTING = "1";
    public static final String ACTION_ENTER_STATUS = "2";
    public static final String ACTION_MOTOR_OFF = "8";
    public static final String ACTION_MOTOR_ON = "7";
    public static final String ACTION_PARAMS_RESET = "4";
    public static final String ACTION_SELFIE_OFF = "6";
    public static final String ACTION_SELFIE_ON = "5";
    public static final String ACTION_SYSTEM_CALIBRATE = "3";
  }
  
  public static abstract interface RoninTutorial
  {
    public static final String ACTION_ENTER = "1";
    public static final String ACTION_EXIT = "2";
    public static final String DEVICE_RONIN_2 = "1";
    public static final String DEVICE_RONIN_S = "2";
    public static final String DEVICE_RONIN_SC = "3";
    public static final String LANGUAGE_CN = "1";
    public static final String LANGUAGE_EN = "2";
  }
  
  public static abstract interface SmoothTrackEnable
  {
    public static final String CLOSE_SMOOTH_TRACK = "2";
    public static final String OPEN_SMOOTH_TRACK = "1";
  }
  
  public static abstract interface SmoothTrackPushEnable
  {
    public static final String CLOSE_SMOOTH_PUSH_TRACK = "2";
    public static final String OPEN_SMOOTH_PUSH_TRACK = "1";
  }
  
  public static abstract interface SmoothTrackValueType
  {
    public static final String OPEN_SMOOTH_VALUE_TYPE_HIGH = "101";
    public static final String OPEN_SMOOTH_VALUE_TYPE_LOW = "103";
    public static final String OPEN_SMOOTH_VALUE_TYPE_MIDDLE = "102";
  }
  
  public static abstract interface UserProfileDeadband
  {
    public static final String USER_PROFILE_CUSTOM = "4";
    public static final String USER_PROFILE_HIGH = "1";
    public static final String USER_PROFILE_LOW = "3";
    public static final String USER_PROFILE_MIDDLE = "2";
  }
  
  public static abstract interface UserProfilePushMode
  {
    public static final String USER_PROFILE_OFF = "1";
    public static final String USER_PROFILE_ON = "4";
    public static final String USER_PROFILE_PITCH = "3";
    public static final String USER_PROFILE_YAW = "2";
  }
  
  public static abstract interface UserProfileSPEED
  {
    public static final String USER_PROFILE_CUSTOM = "4";
    public static final String USER_PROFILE_FAST = "1";
    public static final String USER_PROFILE_MIDDLE = "2";
    public static final String USER_PROFILE_SLOW = "3";
  }
  
  public static abstract interface UserProfileTrackMode
  {
    public static final String USER_PROFILE_360 = "5";
    public static final String USER_PROFILE_ALL = "2";
    public static final String USER_PROFILE_CUSTOM = "4";
    public static final String USER_PROFILE_FPV = "3";
    public static final String USER_PROFILE_YAW = "1";
  }
  
  public static abstract interface UserProfileType
  {
    public static final String USER_PROFILE_1 = "1";
    public static final String USER_PROFILE_2 = "2";
    public static final String USER_PROFILE_3 = "3";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\LogReport\base\Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */