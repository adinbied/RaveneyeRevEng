package dji.midware.ronin2;

import android.util.SparseArray;
import dji.midware.data.manager.P3.DJIGimbalParamInfoManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.model.P3.DataGimbalGetUserParams;
import dji.midware.data.model.P3.DataGimbalRoninGetUserParams;
import dji.midware.data.params.P3.ParamInfo;
import java.util.HashMap;
import java.util.Map;

public class Ronin2GimbalParamsManager
{
  private static Ronin2GimbalParamsManager instance;
  private Map<Class<? extends DataBase>, SparseArray<BaseCommand>> mClassCmdMap = new HashMap();
  
  private Ronin2GimbalParamsManager()
  {
    BaseCommand[] arrayOfBaseCommand = BaseCommand.values();
    int j = arrayOfBaseCommand.length;
    int i = 0;
    while (i < j)
    {
      BaseCommand localBaseCommand = arrayOfBaseCommand[i];
      if (!this.mClassCmdMap.containsKey(localBaseCommand.getPushClazz())) {
        this.mClassCmdMap.put(localBaseCommand.getPushClazz(), new SparseArray());
      }
      ((SparseArray)this.mClassCmdMap.get(localBaseCommand.getPushClazz())).put(localBaseCommand.getId(), localBaseCommand);
      i += 1;
    }
  }
  
  private SparseArray<BaseCommand> getIdKeyStrSpArray(DataBase paramDataBase)
  {
    return null;
  }
  
  public static Ronin2GimbalParamsManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new Ronin2GimbalParamsManager();
      }
      Ronin2GimbalParamsManager localRonin2GimbalParamsManager = instance;
      return localRonin2GimbalParamsManager;
    }
    finally {}
  }
  
  /* Error */
  public void extractData(DataBase arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class AutoTuneParam
  {
    public boolean isStarted;
    public int mProgress;
    
    public static AutoTuneParam generateParam(int paramInt)
    {
      AutoTuneParam localAutoTuneParam = new AutoTuneParam();
      boolean bool;
      if ((paramInt & 0x1) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localAutoTuneParam.isStarted = bool;
      localAutoTuneParam.mProgress = (paramInt >> 1);
      return localAutoTuneParam;
    }
  }
  
  public static enum BaseCommand
  {
    private int mId;
    private String mKeyNameStr;
    private Class<? extends DataBase> mPushClazz = DataGimbalGetUserParams.class;
    
    static
    {
      FILTERING_PITCH = new BaseCommand("FILTERING_PITCH", 6, 6, "ronin_filter_pitch", DataGimbalRoninGetUserParams.class);
      FILTERING_ROLL = new BaseCommand("FILTERING_ROLL", 7, 7, "ronin_filter_roll", DataGimbalRoninGetUserParams.class);
      FILTERING_YAW = new BaseCommand("FILTERING_YAW", 8, 8, "ronin_filter_yaw", DataGimbalRoninGetUserParams.class);
      PRECONTROL_PITCH = new BaseCommand("PRECONTROL_PITCH", 9, 9, "ronin_feedback_pitch", DataGimbalRoninGetUserParams.class);
      PRECONTROL_ROLL = new BaseCommand("PRECONTROL_ROLL", 10, 10, "ronin_feedback_roll", DataGimbalRoninGetUserParams.class);
      PRECONTROL_YAW = new BaseCommand("PRECONTROL_YAW", 11, 11, "ronin_feedback_yaw", DataGimbalRoninGetUserParams.class);
      USER_PROFILE = new BaseCommand("USER_PROFILE", 12, 0, "table_choice", DataGimbalGetUserParams.class);
      SILENT_MODE = new BaseCommand("SILENT_MODE", 13, 1, "silent_mode", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_SPEED_YAW = new BaseCommand("SMOOTH_TRACK_SPEED_YAW", 14, 2, "yaw_speed", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_SPEED_PITCH = new BaseCommand("SMOOTH_TRACK_SPEED_PITCH", 15, 3, "pitch_speed", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_DEADBAND_YAW = new BaseCommand("SMOOTH_TRACK_DEADBAND_YAW", 16, 4, "yaw_deadband", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_DEADBAND_PITCH = new BaseCommand("SMOOTH_TRACK_DEADBAND_PITCH", 17, 5, "pitch_deadband", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_SPEED_ROLL = new BaseCommand("SMOOTH_TRACK_SPEED_ROLL", 18, 12, "roll_speed", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_DEADBAND_ROLL = new BaseCommand("SMOOTH_TRACK_DEADBAND_ROLL", 19, 13, "roll_deadband", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ACCELERATION_ROLL = new BaseCommand("SMOOTH_TRACK_ACCELERATION_ROLL", 20, 16, "roll_accel", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ACCELERATION_YAW = new BaseCommand("SMOOTH_TRACK_ACCELERATION_YAW", 21, 14, "yaw_accel", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ACCELERATION_PITCH = new BaseCommand("SMOOTH_TRACK_ACCELERATION_PITCH", 22, 15, "pitch_accel", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ENABLED_YAW = new BaseCommand("SMOOTH_TRACK_ENABLED_YAW", 23, 17, "yaw_smooth_track", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ENABLED_PITCH = new BaseCommand("SMOOTH_TRACK_ENABLED_PITCH", 24, 18, "pitch_smooth_track", DataGimbalGetUserParams.class);
      SMOOTH_TRACK_ENABLED_ROLL = new BaseCommand("SMOOTH_TRACK_ENABLED_ROLL", 25, 19, "roll_smooth_track", DataGimbalGetUserParams.class);
      PUSH_ENABLE_YAW = new BaseCommand("PUSH_ENABLE_YAW", 26, 20, "yaw_push_enable", DataGimbalGetUserParams.class);
      PUSH_ENABLE_PITCH = new BaseCommand("PUSH_ENABLE_PITCH", 27, 21, "pitch_push_enable", DataGimbalGetUserParams.class);
      PUSH_ENABLE_ROLL = new BaseCommand("PUSH_ENABLE_ROLL", 28, 22, "roll_push_enable", DataGimbalGetUserParams.class);
      YAW_FINE_TUNING = new BaseCommand("YAW_FINE_TUNING", 29, 23, "yaw_fine_tuning", DataGimbalGetUserParams.class);
      PITCH_FINE_TUNING = new BaseCommand("PITCH_FINE_TUNING", 30, 24, "pitch_fine_tuning", DataGimbalGetUserParams.class);
      FLOWER_SPECIAL_CMD = new BaseCommand("FLOWER_SPECIAL_CMD", 31, 34, "flower_special_cmd", DataGimbalGetUserParams.class);
      MOTOR_SPECIAL_CMD = new BaseCommand("MOTOR_SPECIAL_CMD", 32, 35, "motor_special_cmd", DataGimbalGetUserParams.class);
      BALANCE_TEST = new BaseCommand("BALANCE_TEST", 33, 37, "balance_test", DataGimbalGetUserParams.class);
      CONTROLLER_DEADBAND_YAW = new BaseCommand("CONTROLLER_DEADBAND_YAW", 34, 26, "yaw_dead_zone");
      CONTROLLER_DEADBAND_PITCH = new BaseCommand("CONTROLLER_DEADBAND_PITCH", 35, 27, "pitch_dead_zone");
      CONTROLLER_DEADBAND_ROLL = new BaseCommand("CONTROLLER_DEADBAND_ROLL", 36, 40, "roll_control_dead_band");
      CONTROLLER_SMOOTHING_YAW = new BaseCommand("CONTROLLER_SMOOTHING_YAW", 37, 8, "yaw_time_expo");
      CONTROLLER_SMOOTHING_PITCH = new BaseCommand("CONTROLLER_SMOOTHING_PITCH", 38, 9, "pitch_time_expo");
      CONTROLLER_SMOOTHING_ROLL = new BaseCommand("CONTROLLER_SMOOTHING_ROLL", 39, 39, "roll_control_smoothing");
      CONTROLLER_MAX_SPEED_YAW = new BaseCommand("CONTROLLER_MAX_SPEED_YAW", 40, "yaw_max_speed");
      CONTROLLER_MAX_SPEED_PITCH = new BaseCommand("CONTROLLER_MAX_SPEED_PITCH", 41, "pitch_max_speed");
      CONTROLLER_MAX_SPEED_ROLL = new BaseCommand("CONTROLLER_MAX_SPEED_ROLL", 42, "roll_max_speed");
      RONIN2_MAX_ANGLE_YAW = new BaseCommand("RONIN2_MAX_ANGLE_YAW", 43, "ronin2_max_angle_yaw");
      RONIN2_MIN_ANGLE_YAW = new BaseCommand("RONIN2_MIN_ANGLE_YAW", 44, "ronin2_min_angle_yaw");
      RONIN2_MAX_ANGLE_PITCH = new BaseCommand("RONIN2_MAX_ANGLE_PITCH", 45, "ronin2_max_angle_pitch");
      RONIN2_MIN_ANGLE_PITCH = new BaseCommand("RONIN2_MIN_ANGLE_PITCH", 46, "ronin2_min_angle_pitch");
      RONIN2_MAX_ANGLE_ROLL = new BaseCommand("RONIN2_MAX_ANGLE_ROLL", 47, "ronin2_max_angle_roll");
      RONIN2_MIN_ANGLE_ROLL = new BaseCommand("RONIN2_MIN_ANGLE_ROLL", 48, "ronin2_min_angle_roll");
      RONIN2_CHANNEL_1_PARAMS = new BaseCommand("RONIN2_CHANNEL_1_PARAMS", 49, "ronin2_channel_1");
      RONIN2_CHANNEL_2_PARAMS = new BaseCommand("RONIN2_CHANNEL_2_PARAMS", 50, "ronin2_channel_2");
      RONIN2_CHANNEL_3_PARAMS = new BaseCommand("RONIN2_CHANNEL_3_PARAMS", 51, "ronin2_channel_3");
      RONIN2_CHANNEL_4_PARAMS = new BaseCommand("RONIN2_CHANNEL_4_PARAMS", 52, "ronin2_channel_4");
      RONIN2_CHANNEL_5_PARAMS = new BaseCommand("RONIN2_CHANNEL_5_PARAMS", 53, "ronin2_channel_5");
      RONIN2_CHANNEL_6_PARAMS = new BaseCommand("RONIN2_CHANNEL_6_PARAMS", 54, "ronin2_channel_6");
      MOTOR_BLOCK_UP_TIME = new BaseCommand("MOTOR_BLOCK_UP_TIME", 55, 59, "ronin_block_up_time", DataGimbalGetUserParams.class);
      GIMBAL_HOLD_TYPE = new BaseCommand("GIMBAL_HOLD_TYPE", 56, 60, "ronin_gimbal_hold_type", DataGimbalGetUserParams.class);
      GIMBAL_TEST_ENDPOINT = new BaseCommand("GIMBAL_TEST_ENDPOINT", 57, 61, "ronin_gimbal_test_endpoint", DataGimbalGetUserParams.class);
      GIMBAL_WORK_MODE = new BaseCommand("GIMBAL_WORK_MODE", 58, 62, "ronin_gimbal_work_mode", DataGimbalGetUserParams.class);
      AUTO_TUNE_ENABLED = new BaseCommand("AUTO_TUNE_ENABLED", 59, 63, "ronin_auto_tune_enabled", DataGimbalGetUserParams.class);
      AUTO_TUNE_PERCENT = new BaseCommand("AUTO_TUNE_PERCENT", 60, 64, "ronin_auto_tune_percent", DataGimbalGetUserParams.class);
      FOLLOW_SPEED_MODE = new BaseCommand("FOLLOW_SPEED_MODE", 61, 65, "ronin_follow_speed_mode", DataGimbalGetUserParams.class);
      FOLLOW_DEAD_ZONE_MODE = new BaseCommand("FOLLOW_DEAD_ZONE_MODE", 62, 66, "ronin_follow_dead_zone_mode", DataGimbalGetUserParams.class);
      RC_SPEED_MODE = new BaseCommand("RC_SPEED_MODE", 63, 67, "ronin_rc_speed_mode", DataGimbalGetUserParams.class);
      RC_DEAD_ZONE_MODE = new BaseCommand("RC_DEAD_ZONE_MODE", 64, 68, "ronin_rc_dead_zone_mode", DataGimbalGetUserParams.class);
      RC_SMOOTH_MODE = new BaseCommand("RC_SMOOTH_MODE", 65, 69, "ronin_rc_smooth_mode", DataGimbalGetUserParams.class);
      CONTROL_PARAM_MODE = new BaseCommand("CONTROL_PARAM_MODE", 66, 70, "ronin_control_param_mode", DataGimbalGetUserParams.class);
      FOLLOW_ACCE_MODE = new BaseCommand("FOLLOW_ACCE_MODE", 67, 71, "ronin_follow_acce_mode", DataGimbalGetUserParams.class);
      GIMBAL_INPUT_SOURCE = new BaseCommand("GIMBAL_INPUT_SOURCE", 68, 72, "gimbal_input_source", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_SMOOTH_ROLL = new BaseCommand("GIMBAL_CREATE_SMOOTH_ROLL", 69, 76, "gimbal_create_smooth_roll", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_SMOOTH_PITCH = new BaseCommand("GIMBAL_CREATE_SMOOTH_PITCH", 70, 77, "gimbal_create_smooth_pitch", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_SMOOTH_YAW = new BaseCommand("GIMBAL_CREATE_SMOOTH_YAW", 71, 78, "gimbal_create_smooth_yaw", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_MAX_SPEED_ROLL = new BaseCommand("GIMBAL_CREATE_MAX_SPEED_ROLL", 72, 79, "gimbal_create_max_speed_roll", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_MAX_SPEED_PITCH = new BaseCommand("GIMBAL_CREATE_MAX_SPEED_PITCH", 73, 80, "gimbal_create_max_speed_pitch", DataGimbalGetUserParams.class);
      GIMBAL_CREATE_MAX_SPEED_YAW = new BaseCommand("GIMBAL_CREATE_MAX_SPEED_YAW", 74, 81, "gimbal_create_max_speed_yaw", DataGimbalGetUserParams.class);
      GIMBAL_AUTO_MOVEMENT = new BaseCommand("GIMBAL_AUTO_MOVEMENT", 75, 105, "ronin_gimbal_auto_movement", DataGimbalGetUserParams.class);
      GIMBAL_FOLD_MODE = new BaseCommand("GIMBAL_FOLD_MODE", 76, 107, "ronin_fold_mode", DataGimbalGetUserParams.class);
      TRACKING_SPEED = new BaseCommand("TRACKING_SPEED", 77, 117, "ronin_tracking_speed", DataGimbalGetUserParams.class);
      BaseCommand localBaseCommand = new BaseCommand("TRACKING_ORIENTATION_VERTICAL", 78, 122, "ronin_tracking_orientation_vertical", DataGimbalGetUserParams.class);
      TRACKING_ORIENTATION_VERTICAL = localBaseCommand;
      $VALUES = new BaseCommand[] { STIFFNESS_PITCH, STIFFNESS_ROLL, STIFFNESS_YAW, STRENGTH_PITCH, STRENGTH_ROLL, STRENGTH_YAW, FILTERING_PITCH, FILTERING_ROLL, FILTERING_YAW, PRECONTROL_PITCH, PRECONTROL_ROLL, PRECONTROL_YAW, USER_PROFILE, SILENT_MODE, SMOOTH_TRACK_SPEED_YAW, SMOOTH_TRACK_SPEED_PITCH, SMOOTH_TRACK_DEADBAND_YAW, SMOOTH_TRACK_DEADBAND_PITCH, SMOOTH_TRACK_SPEED_ROLL, SMOOTH_TRACK_DEADBAND_ROLL, SMOOTH_TRACK_ACCELERATION_ROLL, SMOOTH_TRACK_ACCELERATION_YAW, SMOOTH_TRACK_ACCELERATION_PITCH, SMOOTH_TRACK_ENABLED_YAW, SMOOTH_TRACK_ENABLED_PITCH, SMOOTH_TRACK_ENABLED_ROLL, PUSH_ENABLE_YAW, PUSH_ENABLE_PITCH, PUSH_ENABLE_ROLL, YAW_FINE_TUNING, PITCH_FINE_TUNING, FLOWER_SPECIAL_CMD, MOTOR_SPECIAL_CMD, BALANCE_TEST, CONTROLLER_DEADBAND_YAW, CONTROLLER_DEADBAND_PITCH, CONTROLLER_DEADBAND_ROLL, CONTROLLER_SMOOTHING_YAW, CONTROLLER_SMOOTHING_PITCH, CONTROLLER_SMOOTHING_ROLL, CONTROLLER_MAX_SPEED_YAW, CONTROLLER_MAX_SPEED_PITCH, CONTROLLER_MAX_SPEED_ROLL, RONIN2_MAX_ANGLE_YAW, RONIN2_MIN_ANGLE_YAW, RONIN2_MAX_ANGLE_PITCH, RONIN2_MIN_ANGLE_PITCH, RONIN2_MAX_ANGLE_ROLL, RONIN2_MIN_ANGLE_ROLL, RONIN2_CHANNEL_1_PARAMS, RONIN2_CHANNEL_2_PARAMS, RONIN2_CHANNEL_3_PARAMS, RONIN2_CHANNEL_4_PARAMS, RONIN2_CHANNEL_5_PARAMS, RONIN2_CHANNEL_6_PARAMS, MOTOR_BLOCK_UP_TIME, GIMBAL_HOLD_TYPE, GIMBAL_TEST_ENDPOINT, GIMBAL_WORK_MODE, AUTO_TUNE_ENABLED, AUTO_TUNE_PERCENT, FOLLOW_SPEED_MODE, FOLLOW_DEAD_ZONE_MODE, RC_SPEED_MODE, RC_DEAD_ZONE_MODE, RC_SMOOTH_MODE, CONTROL_PARAM_MODE, FOLLOW_ACCE_MODE, GIMBAL_INPUT_SOURCE, GIMBAL_CREATE_SMOOTH_ROLL, GIMBAL_CREATE_SMOOTH_PITCH, GIMBAL_CREATE_SMOOTH_YAW, GIMBAL_CREATE_MAX_SPEED_ROLL, GIMBAL_CREATE_MAX_SPEED_PITCH, GIMBAL_CREATE_MAX_SPEED_YAW, GIMBAL_AUTO_MOVEMENT, GIMBAL_FOLD_MODE, TRACKING_SPEED, localBaseCommand };
    }
    
    private BaseCommand(int paramInt, String paramString)
    {
      this.mId = paramInt;
      this.mKeyNameStr = paramString;
    }
    
    private BaseCommand(int paramInt, String paramString, Class<? extends DataBase> paramClass)
    {
      this.mId = paramInt;
      this.mKeyNameStr = paramString;
      this.mPushClazz = paramClass;
    }
    
    private BaseCommand(String paramString)
    {
      this.mKeyNameStr = paramString;
      ??? = DJIGimbalParamInfoManager.read(paramString);
      if (??? != null) {
        this.mId = ((ParamInfo)???).index;
      }
    }
    
    public int getId()
    {
      return this.mId;
    }
    
    public String getKeyNameStr()
    {
      return this.mKeyNameStr;
    }
    
    public Class<? extends DataBase> getPushClazz()
    {
      return this.mPushClazz;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\ronin2\Ronin2GimbalParamsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */