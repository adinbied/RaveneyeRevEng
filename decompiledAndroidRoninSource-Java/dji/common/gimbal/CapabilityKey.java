package dji.common.gimbal;

import dji.common.util.DJIParamCapability;
import dji.common.util.DJIParamMinMaxCapability;

public enum CapabilityKey
{
  private Class<? extends DJIParamCapability> capabilityCls;
  
  static
  {
    ADJUST_ROLL = new CapabilityKey("ADJUST_ROLL", 2, DJIParamMinMaxCapability.class);
    PITCH_RANGE_EXTENSION = new CapabilityKey("PITCH_RANGE_EXTENSION", 3, DJIParamMinMaxCapability.class);
    PITCH_CONTROLLER_SPEED_COEFFICIENT = new CapabilityKey("PITCH_CONTROLLER_SPEED_COEFFICIENT", 4, DJIParamMinMaxCapability.class);
    YAW_CONTROLLER_SPEED_COEFFICIENT = new CapabilityKey("YAW_CONTROLLER_SPEED_COEFFICIENT", 5, DJIParamMinMaxCapability.class);
    PITCH_CONTROLLER_SMOOTHING_FACTOR = new CapabilityKey("PITCH_CONTROLLER_SMOOTHING_FACTOR", 6, DJIParamMinMaxCapability.class);
    YAW_CONTROLLER_SMOOTHING_FACTOR = new CapabilityKey("YAW_CONTROLLER_SMOOTHING_FACTOR", 7, DJIParamMinMaxCapability.class);
    PITCH_CONTROLLER_DEADBAND = new CapabilityKey("PITCH_CONTROLLER_DEADBAND", 8, DJIParamMinMaxCapability.class);
    YAW_CONTROLLER_DEADBAND = new CapabilityKey("YAW_CONTROLLER_DEADBAND", 9, DJIParamMinMaxCapability.class);
    PITCH_SMOOTH_TRACK_ENABLED = new CapabilityKey("PITCH_SMOOTH_TRACK_ENABLED", 10, DJIParamCapability.class);
    YAW_SMOOTH_TRACK_ENABLED = new CapabilityKey("YAW_SMOOTH_TRACK_ENABLED", 11, DJIParamCapability.class);
    PITCH_SMOOTH_TRACK_ACCELERATION = new CapabilityKey("PITCH_SMOOTH_TRACK_ACCELERATION", 12, DJIParamMinMaxCapability.class);
    YAW_SMOOTH_TRACK_ACCELERATION = new CapabilityKey("YAW_SMOOTH_TRACK_ACCELERATION", 13, DJIParamMinMaxCapability.class);
    PITCH_SMOOTH_TRACK_SPEED = new CapabilityKey("PITCH_SMOOTH_TRACK_SPEED", 14, DJIParamMinMaxCapability.class);
    YAW_SMOOTH_TRACK_SPEED = new CapabilityKey("YAW_SMOOTH_TRACK_SPEED", 15, DJIParamMinMaxCapability.class);
    PITCH_SMOOTH_TRACK_DEADBAND = new CapabilityKey("PITCH_SMOOTH_TRACK_DEADBAND", 16, DJIParamMinMaxCapability.class);
    YAW_SMOOTH_TRACK_DEADBAND = new CapabilityKey("YAW_SMOOTH_TRACK_DEADBAND", 17, DJIParamMinMaxCapability.class);
    ROLL_SMOOTH_TRACK_DEADBAND = new CapabilityKey("ROLL_SMOOTH_TRACK_DEADBAND", 18, DJIParamMinMaxCapability.class);
    PITCH_UP_ENDPOINT = new CapabilityKey("PITCH_UP_ENDPOINT", 19, DJIParamMinMaxCapability.class);
    PITCH_DOWN_ENDPOINT = new CapabilityKey("PITCH_DOWN_ENDPOINT", 20, DJIParamMinMaxCapability.class);
    YAW_LEFT_ENDPOINT = new CapabilityKey("YAW_LEFT_ENDPOINT", 21, DJIParamMinMaxCapability.class);
    YAW_RIGHT_ENDPOINT = new CapabilityKey("YAW_RIGHT_ENDPOINT", 22, DJIParamMinMaxCapability.class);
    PITCH_MOTOR_CONTROL_STIFFNESS = new CapabilityKey("PITCH_MOTOR_CONTROL_STIFFNESS", 23, DJIParamMinMaxCapability.class);
    YAW_MOTOR_CONTROL_STIFFNESS = new CapabilityKey("YAW_MOTOR_CONTROL_STIFFNESS", 24, DJIParamMinMaxCapability.class);
    ROLL_MOTOR_CONTROL_STIFFNESS = new CapabilityKey("ROLL_MOTOR_CONTROL_STIFFNESS", 25, DJIParamMinMaxCapability.class);
    PITCH_MOTOR_CONTROL_STRENGTH = new CapabilityKey("PITCH_MOTOR_CONTROL_STRENGTH", 26, DJIParamMinMaxCapability.class);
    YAW_MOTOR_CONTROL_STRENGTH = new CapabilityKey("YAW_MOTOR_CONTROL_STRENGTH", 27, DJIParamMinMaxCapability.class);
    ROLL_MOTOR_CONTROL_STRENGTH = new CapabilityKey("ROLL_MOTOR_CONTROL_STRENGTH", 28, DJIParamMinMaxCapability.class);
    PITCH_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = new CapabilityKey("PITCH_MOTOR_CONTROL_GYRO_FILTERING_FACTOR", 29, DJIParamMinMaxCapability.class);
    YAW_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = new CapabilityKey("YAW_MOTOR_CONTROL_GYRO_FILTERING_FACTOR", 30, DJIParamMinMaxCapability.class);
    ROLL_MOTOR_CONTROL_GYRO_FILTERING_FACTOR = new CapabilityKey("ROLL_MOTOR_CONTROL_GYRO_FILTERING_FACTOR", 31, DJIParamMinMaxCapability.class);
    PITCH_MOTOR_CONTROL_PRE_CONTROL = new CapabilityKey("PITCH_MOTOR_CONTROL_PRE_CONTROL", 32, DJIParamMinMaxCapability.class);
    YAW_MOTOR_CONTROL_PRE_CONTROL = new CapabilityKey("YAW_MOTOR_CONTROL_PRE_CONTROL", 33, DJIParamMinMaxCapability.class);
    ROLL_MOTOR_CONTROL_PRE_CONTROL = new CapabilityKey("ROLL_MOTOR_CONTROL_PRE_CONTROL", 34, DJIParamMinMaxCapability.class);
    CapabilityKey localCapabilityKey = new CapabilityKey("MOVEMENT_SETTINGS", 35, DJIParamCapability.class);
    MOVEMENT_SETTINGS = localCapabilityKey;
    $VALUES = new CapabilityKey[] { ADJUST_PITCH, ADJUST_YAW, ADJUST_ROLL, PITCH_RANGE_EXTENSION, PITCH_CONTROLLER_SPEED_COEFFICIENT, YAW_CONTROLLER_SPEED_COEFFICIENT, PITCH_CONTROLLER_SMOOTHING_FACTOR, YAW_CONTROLLER_SMOOTHING_FACTOR, PITCH_CONTROLLER_DEADBAND, YAW_CONTROLLER_DEADBAND, PITCH_SMOOTH_TRACK_ENABLED, YAW_SMOOTH_TRACK_ENABLED, PITCH_SMOOTH_TRACK_ACCELERATION, YAW_SMOOTH_TRACK_ACCELERATION, PITCH_SMOOTH_TRACK_SPEED, YAW_SMOOTH_TRACK_SPEED, PITCH_SMOOTH_TRACK_DEADBAND, YAW_SMOOTH_TRACK_DEADBAND, ROLL_SMOOTH_TRACK_DEADBAND, PITCH_UP_ENDPOINT, PITCH_DOWN_ENDPOINT, YAW_LEFT_ENDPOINT, YAW_RIGHT_ENDPOINT, PITCH_MOTOR_CONTROL_STIFFNESS, YAW_MOTOR_CONTROL_STIFFNESS, ROLL_MOTOR_CONTROL_STIFFNESS, PITCH_MOTOR_CONTROL_STRENGTH, YAW_MOTOR_CONTROL_STRENGTH, ROLL_MOTOR_CONTROL_STRENGTH, PITCH_MOTOR_CONTROL_GYRO_FILTERING_FACTOR, YAW_MOTOR_CONTROL_GYRO_FILTERING_FACTOR, ROLL_MOTOR_CONTROL_GYRO_FILTERING_FACTOR, PITCH_MOTOR_CONTROL_PRE_CONTROL, YAW_MOTOR_CONTROL_PRE_CONTROL, ROLL_MOTOR_CONTROL_PRE_CONTROL, localCapabilityKey };
  }
  
  private CapabilityKey(Class<? extends DJIParamCapability> paramClass)
  {
    this.capabilityCls = paramClass;
  }
  
  public Class<? extends DJIParamCapability> capabilityClass()
  {
    return this.capabilityCls;
  }
  
  public String value()
  {
    return name();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\CapabilityKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */