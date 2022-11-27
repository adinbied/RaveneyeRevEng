package dji.publics.LogReport.base;

public abstract interface Fields
{
  public static abstract interface Dgo_discover
    extends Fields.ReportCommon
  {
    public static final String MODULE_TYPE = "module_type";
  }
  
  public static abstract interface ReportCommon
  {
    public static final String DEVICE_SN = "device_sn";
    public static final String STR_ACTION = "action";
    public static final String STR_APP_VERSION = "app_ver";
    public static final String STR_CREATE_TIME = "createtime";
    public static final String STR_DEVICE_TYPE = "device_type";
    public static final String STR_DEVICE_TYPE_SPEC = "device_type_spec";
    public static final String STR_DEVICE_VER = "device_ver";
    public static final String STR_RC_VER = "rc_ver";
    public static final String STR_SN_SIGN = "firmware_sign";
    public static final String STR_TYPE = "type";
    public static final String UUID = "uuid";
  }
  
  public static abstract interface RoninAppUpgrade
    extends Fields.ReportCommon
  {
    public static final String APP_UPGRADE_ACTION = "action";
    public static final String APP_UPGRADE_TYPE = "update_type";
  }
  
  public static abstract interface RoninCreateTracking
    extends Fields.ReportCommon
  {
    public static final String FOLLOW_SPEED = "follow_speed";
    public static final String TRACKING_OBJECT = "tracking_object";
    public static final String TRACKING_RESULT = "tracking_result";
  }
  
  public static abstract interface RoninFirmwareUpgrade
    extends Fields.ReportCommon
  {
    public static final String FAIL_MODULE = "failure_module";
    public static final String UPGRADE_TYPE = "update_type";
  }
  
  public static abstract interface RoninGimbalBalanceTest
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
    public static final String PITCH_TEST_RESULT = "pitch_test_result";
    public static final String ROLL_TEST_RESULT = "roll_test_result";
    public static final String YAW_TEST_RESULT = "yaw_test_result";
  }
  
  public static abstract interface RoninGimbalBalanceTutorial
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
  }
  
  public static abstract interface RoninS3DRoll360
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
    public static final String RESULT = "result";
  }
  
  public static abstract interface RoninSMotor
    extends Fields.ReportCommon
  {
    public static final String RONIN_S_MOTOR_ACTION = "action";
  }
  
  public static abstract interface RoninSSmoothTrackPan
    extends Fields.ReportCommon
  {
    public static final String PAN_DEADBAND = "pan_deadband";
    public static final String PAN_PUSH = "pan_push";
    public static final String PAN_SENSITIVITY = "pan_sensitivity";
    public static final String PAN_SETTINGS = "pan_settings";
    public static final String PAN_SPEED = "pan_speed";
    public static final String PROFILE = "profile";
  }
  
  public static abstract interface RoninSSmoothTrackRoll
    extends Fields.ReportCommon
  {
    public static final String PROFILE = "profile";
    public static final String ROLL_DEADBAND = "roll_deadband";
    public static final String ROLL_PUSH = "roll_push";
    public static final String ROLL_SENSITIVITY = "roll_sensitivity";
    public static final String ROLL_SETTINGS = "roll_settings";
    public static final String ROLL_SPEED = "roll_speed";
  }
  
  public static abstract interface RoninSSmoothTrackTilt
    extends Fields.ReportCommon
  {
    public static final String PROFILE = "profile";
    public static final String TiltDeadband = "tilt_deadband";
    public static final String TiltPush = "tilt_push";
    public static final String TiltSensitivity = "tilt_sensitivity";
    public static final String TiltSettings = "tilt_settings";
    public static final String TiltSpeed = "tilt_speed";
  }
  
  public static abstract interface RoninScDeviceData
    extends Fields.ReportCommon
  {
    public static final String RONIN_SC_DEVICE_ACTION = "hg701_device_action";
    public static final String RONIN_SC_DEVICE_ACTION_VALUE = "hg701_device_action_value";
  }
  
  public static abstract interface RoninSystemStatus
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
  }
  
  public static abstract interface RoninTutorial
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
    public static final String LANGUAGE = "language";
    public static final String TUTORIAL_DEVICE = "tutorial_device";
  }
  
  public static abstract interface RoninUserProfile
    extends Fields.ReportCommon
  {
    public static final String profile = "profile";
    public static final String push_mode = "push_mode";
    public static final String smooth_track_deadband = "smooth_track_deadband";
    public static final String smooth_track_deadband_pitch_customize = "smooth_track_deadband_pitch_customize";
    public static final String smooth_track_deadband_roll_customize = "smooth_track_deadband_roll_customize";
    public static final String smooth_track_deadband_yaw_customize = "smooth_track_deadband_yaw_customize";
    public static final String smooth_track_mode = "smooth_track_mode";
    public static final String smooth_track_mode_customize = "smooth_track_mode_customize";
    public static final String smooth_track_speed = "smooth_track_speed";
    public static final String smooth_track_speed_pitch_customize = "smooth_track_speed_pitch_customize";
    public static final String smooth_track_speed_roll_customize = "smooth_track_speed_roll_customize";
    public static final String smooth_track_speed_yaw_customize = "smooth_track_speed_yaw_customize";
  }
  
  public static abstract interface RoninsCreate
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
    public static final String TYPE = "type";
  }
  
  public static abstract interface RoninsCreateDelay
    extends Fields.ReportCommon
  {
    public static final String FRAME = "frame";
    public static final String PHOTO_DURATION = "photo_duration";
    public static final String POINT = "point";
    public static final String PUSH_MODE = "push_mode";
  }
  
  public static abstract interface RoninsCreatePanorama
    extends Fields.ReportCommon
  {
    public static final String FOCAL_LENGTH = "focal_length";
    public static final String SENSOR = "sensor";
  }
  
  public static abstract interface RoninscBeginnerGuide
    extends Fields.ReportCommon
  {
    public static final String ACTION = "action";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\LogReport\base\Fields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */