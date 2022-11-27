package dji.common.mission.activetrack;

public enum ActiveTrackCannotConfirmReason
{
  static
  {
    TARGET_TOO_HIGH = new ActiveTrackCannotConfirmReason("TARGET_TOO_HIGH", 2);
    BLOCKED_BY_OBSTACLE = new ActiveTrackCannotConfirmReason("BLOCKED_BY_OBSTACLE", 3);
    GIMBAL_ATTITUDE_ERROR = new ActiveTrackCannotConfirmReason("GIMBAL_ATTITUDE_ERROR", 4);
    TARGET_TOO_FAR = new ActiveTrackCannotConfirmReason("TARGET_TOO_FAR", 5);
    TARGET_TOO_CLOSE = new ActiveTrackCannotConfirmReason("TARGET_TOO_CLOSE", 6);
    AIRCRAFT_TOO_HIGH = new ActiveTrackCannotConfirmReason("AIRCRAFT_TOO_HIGH", 7);
    AIRCRAFT_TOO_LOW = new ActiveTrackCannotConfirmReason("AIRCRAFT_TOO_LOW", 8);
    OBSTACLE_SENSOR_ERROR = new ActiveTrackCannotConfirmReason("OBSTACLE_SENSOR_ERROR", 9);
    ActiveTrackCannotConfirmReason localActiveTrackCannotConfirmReason = new ActiveTrackCannotConfirmReason("UNKNOWN", 10);
    UNKNOWN = localActiveTrackCannotConfirmReason;
    $VALUES = new ActiveTrackCannotConfirmReason[] { NONE, UNSTABLE_TARGET, TARGET_TOO_HIGH, BLOCKED_BY_OBSTACLE, GIMBAL_ATTITUDE_ERROR, TARGET_TOO_FAR, TARGET_TOO_CLOSE, AIRCRAFT_TOO_HIGH, AIRCRAFT_TOO_LOW, OBSTACLE_SENSOR_ERROR, localActiveTrackCannotConfirmReason };
  }
  
  private ActiveTrackCannotConfirmReason() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackCannotConfirmReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */