package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIMissionError
  extends DJIError
{
  public static final DJIMissionError ACTION_REPEAT_TIME_NOT_VALID;
  public static final DJIMissionError ACTION_TIMEOUT_NOT_VALID;
  public static final DJIMissionError AIRCRAFT_ALTITUDE_TOO_HIGH;
  public static final DJIMissionError AIRCRAFT_ALTITUDE_TOO_LOW;
  public static final DJIMissionError AIRCRAFT_GOING_HOME;
  public static final DJIMissionError AIRCRAFT_IN_NO_FLY_ZONE;
  public static final DJIMissionError AIRCRAFT_LANDING;
  public static final DJIMissionError AIRCRAFT_NOT_IN_THE_AIR;
  public static final DJIMissionError AIRCRAFT_STARTING_MOTOR;
  public static final DJIMissionError AIRCRAFT_TAKING_OFF;
  public static final DJIMissionError ALTITUDE_NOT_VALID;
  public static final DJIMissionError ALTITUDE_TOO_HIGH;
  public static final DJIMissionError ALTITUDE_TOO_LOW;
  public static final DJIMissionError AUTO_FLIGHT_SPEED_NOT_VALID;
  public static final DJIMissionError BEGAN;
  public static final DJIMissionError CANCELED;
  public static final DJIMissionError CANNOT_BYPASS_OBSTACLE;
  public static final DJIMissionError COMMON_DISCONNECTED;
  public static final DJIMissionError COMMON_UNSUPPORTED;
  public static final DJIMissionError CORNER_RADIUS_NOT_VALID;
  public static final DJIMissionError DISTANCE_FROM_MISSION_TARGET_TOO_LONG;
  public static final DJIMissionError FAILED;
  public static final DJIMissionError FEATURE_POINT_CANNOT_MATCH;
  public static final DJIMissionError FOLLOW_ME_DISCONNECT_TIME_TOO_LONG;
  public static final DJIMissionError FOLLOW_ME_DISTANCE_TOO_LARGE;
  public static final DJIMissionError FOLLOW_ME_GIMBAL_PITCH_ERROR;
  public static final DJIMissionError GIMBAL_PITCH_NOT_VALID;
  public static final DJIMissionError GPS_NOT_READY;
  public static final DJIMissionError GPS_SIGNAL_WEAK;
  public static final DJIMissionError HEADING_NOT_VALID;
  public static final DJIMissionError HIGH_PRIORITY_MISSION_EXECUTING;
  public static final DJIMissionError HOME_POINT_DIRECTION_UNKNOWN;
  public static final DJIMissionError HOME_POINT_LOCATION_INVALID;
  public static final DJIMissionError HOME_POINT_MISSION_NOT_PAUSED;
  public static final DJIMissionError HOME_POINT_MISSION_PAUSED;
  public static final DJIMissionError HOME_POINT_NOT_RECORDED;
  public static final DJIMissionError HOME_POINT_VALUE_INVALID;
  public static final DJIMissionError INCOMPLETE_MISSION;
  public static final DJIMissionError IN_NOVICE_MODE;
  public static final DJIMissionError IOC_TYPE_UNKNOWN;
  public static final DJIMissionError IOC_WORKING;
  public static final DJIMissionError IS_FLYING;
  public static final DJIMissionError KEY_LEVEL_LOW;
  public static final DJIMissionError LOW_BATTERY;
  public static final DJIMissionError MAX_FLIGHT_SPEED_NOT_VALID = new DJIMissionError("Max Flight speed value provided is invalid");
  public static final DJIMissionError MAX_NUMBER_OF_WAYPOINTS_UPLOAD_LIMIT_REACHED;
  public static final DJIMissionError MISSION_ACROSS_NO_FLY_ZONE;
  public static final DJIMissionError MISSION_CONDITION_NOT_SATISFIED;
  public static final DJIMissionError MISSION_CONFLICT;
  public static final DJIMissionError MISSION_ENTRY_POINT_INVALID;
  public static final DJIMissionError MISSION_ESTIMATE_TIME_TOO_LONG;
  public static final DJIMissionError MISSION_HEADING_MODE_INVALID;
  public static final DJIMissionError MISSION_INFO_INVALID;
  public static final DJIMissionError MISSION_NOT_EXIST;
  public static final DJIMissionError MISSION_NOT_INITIALIZED;
  public static final DJIMissionError MISSION_NOT_STARTED = new DJIMissionError("Mission is not started yet");
  public static final DJIMissionError MISSION_PARAMETERS_INVALID;
  public static final DJIMissionError MISSION_RADIUS_INVALID;
  public static final DJIMissionError MISSION_RADIUS_OVER_LIMIT;
  public static final DJIMissionError MISSION_RESUME_FAILED;
  public static final DJIMissionError MISSION_SPEED_TOO_HIGH;
  public static final DJIMissionError MODE_ERROR;
  public static final DJIMissionError MOTORS_DID_NOT_START;
  public static final DJIMissionError NAVIGATION_MODE_DISABLED;
  public static final DJIMissionError NAVIGATION_MODE_NOT_SUPPORTED;
  public static final DJIMissionError NOT_AUTO_MODE;
  public static final DJIMissionError NO_MISSION_RUNNING;
  public static final DJIMissionError NO_VIDEO_FEED;
  public static final DJIMissionError NULL_MISSION;
  public static final DJIMissionError POINTING_AIRCRAFT_NOT_IN_THE_AIR;
  public static final DJIMissionError RC_MODE_ERROR;
  public static final DJIMissionError REACH_ALTITUDE_LOWER_BOUND;
  public static final DJIMissionError REACH_FLIGHT_LIMITATION;
  public static final DJIMissionError REPEAT_TIME_NOT_VALID;
  public static final DJIMissionError ROTATE_AIRCRAFT_ACTION_NOT_VALID;
  public static final DJIMissionError ROTATE_GIMBAL_ACTION_NOT_VALID;
  public static final DJIMissionError RUNNING_MISSION;
  public static final DJIMissionError SHOOT_PHOTO_NOT_VALID;
  public static final DJIMissionError STAY_ACTION_NOT_VALID;
  public static final DJIMissionError STOPPED_BY_USER;
  public static final DJIMissionError TAKE_OFF;
  public static final DJIMissionError TIMEOUT;
  public static final DJIMissionError TOO_CLOSE_TO_HOME_POINT;
  public static final DJIMissionError TRACKING_GIMBAL_PITCH_TOO_LOW;
  public static final DJIMissionError TRACKING_OBSTACLE_DETECTED;
  public static final DJIMissionError TRACKING_PAUSED_BY_USER;
  public static final DJIMissionError TRACKING_RECT_TOO_LARGE;
  public static final DJIMissionError TRACKING_RECT_TOO_SMALL;
  public static final DJIMissionError TRACKING_TARGET_LOST;
  public static final DJIMissionError TRACKING_TARGET_LOW_CONFIDENCE;
  public static final DJIMissionError TRACKING_TARGET_NOT_ENOUGH_FEATURES;
  public static final DJIMissionError TRACKING_TARGET_SHAKING;
  public static final DJIMissionError TRACKING_TARGET_TOO_CLOSE;
  public static final DJIMissionError TRACKING_TARGET_TOO_FAR;
  public static final DJIMissionError TRACKING_TARGET_TOO_HIGH;
  public static final DJIMissionError UNKNOWN = new DJIMissionError("Unknown result");
  public static final DJIMissionError UPLOADING_WAYPOINT;
  public static final DJIMissionError VIDEO_FRAME_RATE_TOO_LOW;
  public static final DJIMissionError VISION_DATA_ABNORMAL;
  public static final DJIMissionError VISION_SENSOR_LOW_QUALITY;
  public static final DJIMissionError VISION_SENSOR_OVEREXPOSED;
  public static final DJIMissionError VISION_SENSOR_UNDEREXPOSED;
  public static final DJIMissionError VISION_SYSTEM_ERROR;
  public static final DJIMissionError VISION_SYSTEM_NEEDS_CALIBRATION;
  public static final DJIMissionError VISION_SYSTEM_NOT_AUTHORIZED;
  public static final DJIMissionError WAYPOINTS_UPLOADING;
  public static final DJIMissionError WAYPOINT_ACTION_PARAMETER_INVALID;
  public static final DJIMissionError WAYPOINT_COORDINATE_NOT_VALID;
  public static final DJIMissionError WAYPOINT_COUNT_NOT_VALID;
  public static final DJIMissionError WAYPOINT_DAMPING_CHECK_FAILED;
  public static final DJIMissionError WAYPOINT_DISTANCE_TOO_CLOSE;
  public static final DJIMissionError WAYPOINT_DISTANCE_TOO_LONG;
  public static final DJIMissionError WAYPOINT_IDLE_VELOCITY_INVALID;
  public static final DJIMissionError WAYPOINT_INDEX_OVER_RANGE;
  public static final DJIMissionError WAYPOINT_INFO_INVALID;
  public static final DJIMissionError WAYPOINT_LIST_SIZE_NOT_VALID;
  public static final DJIMissionError WAYPOINT_MISSION_INFO_NOT_UPLOADED;
  public static final DJIMissionError WAYPOINT_NOT_RUNNING;
  public static final DJIMissionError WAYPOINT_REQUEST_IS_RUNNING;
  public static final DJIMissionError WAYPOINT_SPEED_NOT_VALID;
  public static final DJIMissionError WAYPOINT_TOTAL_TRACE_TOO_LONG;
  public static final DJIMissionError WAYPOINT_TRACE_TOO_LONG;
  public static final DJIMissionError WAYPOINT_UPLOAD_NOT_COMPLETE;
  public static final DJIMissionError WRONG_CMD;
  
  static
  {
    AUTO_FLIGHT_SPEED_NOT_VALID = new DJIMissionError("Auto flight speed value provided is invalid");
    REPEAT_TIME_NOT_VALID = new DJIMissionError("Repeat time value provided is invalid");
    WAYPOINT_COUNT_NOT_VALID = new DJIMissionError("Waypoint count is invalid");
    WAYPOINT_LIST_SIZE_NOT_VALID = new DJIMissionError("Waypoint list size is invalid");
    WAYPOINT_COORDINATE_NOT_VALID = new DJIMissionError("Waypoint coordinate provided is invalid");
    ALTITUDE_NOT_VALID = new DJIMissionError("Waypoint altitude provided is invalid");
    HEADING_NOT_VALID = new DJIMissionError("Waypoint heading provided is invalid");
    ACTION_REPEAT_TIME_NOT_VALID = new DJIMissionError("Waypoint repeat time provided is invalid");
    ACTION_TIMEOUT_NOT_VALID = new DJIMissionError("Waypoint action timeout provided is invalid");
    CORNER_RADIUS_NOT_VALID = new DJIMissionError("Waypoint corner radius provided is invalid");
    GIMBAL_PITCH_NOT_VALID = new DJIMissionError("Waypoint gimbal pitch provided is invalid");
    WAYPOINT_SPEED_NOT_VALID = new DJIMissionError("Waypoint speed provided is invalid");
    SHOOT_PHOTO_NOT_VALID = new DJIMissionError("Waypoint shoot photo distance provided is invalid");
    STAY_ACTION_NOT_VALID = new DJIMissionError("Waypoint stay action param provided is invalid");
    ROTATE_GIMBAL_ACTION_NOT_VALID = new DJIMissionError("Waypoint rotate gimbal action param provided is invalid");
    ROTATE_AIRCRAFT_ACTION_NOT_VALID = new DJIMissionError("Waypoint rotate aircraft action param provided is invalid");
    NULL_MISSION = new DJIMissionError("Null Mission");
    INCOMPLETE_MISSION = new DJIMissionError("Incomplete Mission");
    COMMON_UNSUPPORTED = new DJIMissionError("Not supported");
    COMMON_DISCONNECTED = new DJIMissionError("Disconnected");
    BEGAN = new DJIMissionError("began");
    CANCELED = new DJIMissionError("canceled");
    FAILED = new DJIMissionError("failed");
    NO_MISSION_RUNNING = new DJIMissionError("Mission not existed");
    TIMEOUT = new DJIMissionError("Execution of this process has timed out");
    MODE_ERROR = new DJIMissionError("The control mode of the aircraft is not in the correct state");
    GPS_NOT_READY = new DJIMissionError("GPS of aircraft is not ready");
    MOTORS_DID_NOT_START = new DJIMissionError("The aircraft's motor has not started");
    TAKE_OFF = new DJIMissionError("Aircraft is taking off");
    IS_FLYING = new DJIMissionError("Aircraft is flying");
    NOT_AUTO_MODE = new DJIMissionError("Aircraft is not in auto mode");
    MAX_NUMBER_OF_WAYPOINTS_UPLOAD_LIMIT_REACHED = new DJIMissionError("Waypoint mission has reached the maximum points limit");
    UPLOADING_WAYPOINT = new DJIMissionError("Waypoint mission is uploading");
    KEY_LEVEL_LOW = new DJIMissionError("The API key provided to you is not at the correct permission level");
    NAVIGATION_MODE_DISABLED = new DJIMissionError("Navigation is not open");
    TOO_CLOSE_TO_HOME_POINT = new DJIMissionError("Aircraft is too close to home point");
    IOC_TYPE_UNKNOWN = new DJIMissionError("The type of IOC is unknown");
    HOME_POINT_VALUE_INVALID = new DJIMissionError("The home point is not a valid float value");
    HOME_POINT_LOCATION_INVALID = new DJIMissionError("The latitude and longitude of homepoint are invalid");
    HOME_POINT_DIRECTION_UNKNOWN = new DJIMissionError("The direction of homepoint is unknown");
    HOME_POINT_MISSION_PAUSED = new DJIMissionError("The home-point mission is paused");
    HOME_POINT_MISSION_NOT_PAUSED = new DJIMissionError("The home-point  mission is not paused");
    FOLLOW_ME_DISTANCE_TOO_LARGE = new DJIMissionError("Distance between the aircraft and mobile phone is beyond acceptable limit(must be lower than 20000m)");
    FOLLOW_ME_DISCONNECT_TIME_TOO_LONG = new DJIMissionError("The disconnect time of follow me mission is too long");
    FOLLOW_ME_GIMBAL_PITCH_ERROR = new DJIMissionError("The initial pitch angle of gimbal is too large");
    ALTITUDE_TOO_HIGH = new DJIMissionError("The altitude is too high");
    ALTITUDE_TOO_LOW = new DJIMissionError("The altitude is too low");
    MISSION_RADIUS_INVALID = new DJIMissionError("The radius of mission is invalid");
    MISSION_SPEED_TOO_HIGH = new DJIMissionError("The speed of mission is too large");
    MISSION_ENTRY_POINT_INVALID = new DJIMissionError("The entry point of mission is invalid");
    MISSION_HEADING_MODE_INVALID = new DJIMissionError("The heading mode of mission is invalid");
    MISSION_RESUME_FAILED = new DJIMissionError("Failed to resume the mission");
    MISSION_RADIUS_OVER_LIMIT = new DJIMissionError("The radius of mission is over the acceptable limit");
    NAVIGATION_MODE_NOT_SUPPORTED = new DJIMissionError("Navigation mode is not supported");
    DISTANCE_FROM_MISSION_TARGET_TOO_LONG = new DJIMissionError("Navigation in the product is unsupported");
    RC_MODE_ERROR = new DJIMissionError("Mode error, please make sure the remote controller's mode switch is in 'F' mode.");
    IOC_WORKING = new DJIMissionError("The IOC mode is working");
    MISSION_NOT_INITIALIZED = new DJIMissionError("The mission is not initialized");
    MISSION_NOT_EXIST = new DJIMissionError("The mission does not exist");
    MISSION_CONFLICT = new DJIMissionError("There is a conflicting setting in the mission");
    MISSION_ESTIMATE_TIME_TOO_LONG = new DJIMissionError("The estimated time for the mission is too long");
    IN_NOVICE_MODE = new DJIMissionError("The aircraft is in novice mode now");
    HIGH_PRIORITY_MISSION_EXECUTING = new DJIMissionError("A higher priority mission is executing");
    GPS_SIGNAL_WEAK = new DJIMissionError("The GPS signal of the aircraft is weak");
    LOW_BATTERY = new DJIMissionError("Low battery level warning");
    AIRCRAFT_NOT_IN_THE_AIR = new DJIMissionError("The aircraft is not in the air");
    MISSION_PARAMETERS_INVALID = new DJIMissionError("The parameters of the mission are invalid");
    MISSION_CONDITION_NOT_SATISFIED = new DJIMissionError("The condition of mission is not satisfied");
    MISSION_ACROSS_NO_FLY_ZONE = new DJIMissionError("The mission is across the no fly zone");
    HOME_POINT_NOT_RECORDED = new DJIMissionError("The home point of aircraft is not recorded");
    AIRCRAFT_IN_NO_FLY_ZONE = new DJIMissionError("The aircraft is in the no fly zone");
    MISSION_INFO_INVALID = new DJIMissionError("The information of mission is invalid");
    WAYPOINT_INFO_INVALID = new DJIMissionError("The information of waypoint is invalid");
    WAYPOINT_TRACE_TOO_LONG = new DJIMissionError("The trace of waypoint is too long");
    WAYPOINT_TOTAL_TRACE_TOO_LONG = new DJIMissionError("The total trace of waypoint is too long");
    WAYPOINT_INDEX_OVER_RANGE = new DJIMissionError("The index of waypoint is over range");
    WAYPOINT_DISTANCE_TOO_CLOSE = new DJIMissionError("The waypoint distance is too close");
    WAYPOINT_DISTANCE_TOO_LONG = new DJIMissionError("The waypoint distance is too long");
    WAYPOINT_DAMPING_CHECK_FAILED = new DJIMissionError("The damping check is failed");
    WAYPOINT_ACTION_PARAMETER_INVALID = new DJIMissionError("The parameter of waypoint action is invalid");
    WAYPOINTS_UPLOADING = new DJIMissionError("The waypoints are still uploading");
    WAYPOINT_MISSION_INFO_NOT_UPLOADED = new DJIMissionError("The info of waypoint mission is not completely uploaded");
    WAYPOINT_UPLOAD_NOT_COMPLETE = new DJIMissionError("The waypoint uploading is not complete");
    WAYPOINT_REQUEST_IS_RUNNING = new DJIMissionError("The waypoint request is running");
    WAYPOINT_NOT_RUNNING = new DJIMissionError("The waypoint mission is not running");
    WAYPOINT_IDLE_VELOCITY_INVALID = new DJIMissionError("The idle velocity is invalid");
    AIRCRAFT_TAKING_OFF = new DJIMissionError("The aircraft is taking off");
    AIRCRAFT_LANDING = new DJIMissionError("The aircraft is landing");
    AIRCRAFT_GOING_HOME = new DJIMissionError("The aircraft is going home");
    AIRCRAFT_STARTING_MOTOR = new DJIMissionError("The aircraft is starting the motor");
    WRONG_CMD = new DJIMissionError("The command is wrong");
    RUNNING_MISSION = new DJIMissionError("The aircraft is running a mission");
    TRACKING_TARGET_LOW_CONFIDENCE = new DJIMissionError("The ActiveTrack mission is too unsure the tracking object and confirmation is required.");
    TRACKING_PAUSED_BY_USER = new DJIMissionError("Mission is paused by user.");
    TRACKING_TARGET_TOO_HIGH = new DJIMissionError("The tracking target is too high.");
    TRACKING_OBSTACLE_DETECTED = new DJIMissionError("Obstacles are detected.");
    TRACKING_GIMBAL_PITCH_TOO_LOW = new DJIMissionError("The gimbal pitch is too low.");
    TRACKING_TARGET_TOO_FAR = new DJIMissionError("The tracking target is too far away from the aircraft.");
    TRACKING_TARGET_TOO_CLOSE = new DJIMissionError("The tracking target is too close to the aircraft.");
    AIRCRAFT_ALTITUDE_TOO_HIGH = new DJIMissionError("The aircraft's altitude is too high.");
    AIRCRAFT_ALTITUDE_TOO_LOW = new DJIMissionError("The aircraft's altitude is too low.");
    TRACKING_RECT_TOO_SMALL = new DJIMissionError("The tracking rectangle is too small.");
    TRACKING_RECT_TOO_LARGE = new DJIMissionError("The tracking rectangle is too large.");
    TRACKING_TARGET_NOT_ENOUGH_FEATURES = new DJIMissionError("The tracking target doesn't have enough features to lock onto.");
    TRACKING_TARGET_LOST = new DJIMissionError("The tracking target is lost.");
    VISION_DATA_ABNORMAL = new DJIMissionError("The data from the vision system is abnormal.");
    NO_VIDEO_FEED = new DJIMissionError("No live video feed is captured for the ActiveTrack Mission. ");
    VIDEO_FRAME_RATE_TOO_LOW = new DJIMissionError("The frame rate of the live video feed is too low.");
    REACH_FLIGHT_LIMITATION = new DJIMissionError("The aircraft has reached the flight limitation.");
    VISION_SYSTEM_NOT_AUTHORIZED = new DJIMissionError("The vision system cannot get the authorization to control the aircraft. ");
    TRACKING_TARGET_SHAKING = new DJIMissionError("The tracking target is shaking too much.");
    POINTING_AIRCRAFT_NOT_IN_THE_AIR = new DJIMissionError("The aircraft is not in the air. Please take off first.");
    VISION_SYSTEM_NEEDS_CALIBRATION = new DJIMissionError("The vision system requires calibration.");
    FEATURE_POINT_CANNOT_MATCH = new DJIMissionError("The feature points found by both vision sensors cannot match.");
    VISION_SENSOR_OVEREXPOSED = new DJIMissionError("The vision sensors are overexposed.");
    VISION_SENSOR_UNDEREXPOSED = new DJIMissionError("The vision sensors are underexposed.");
    VISION_SENSOR_LOW_QUALITY = new DJIMissionError("The quality of vision sensor is low.");
    VISION_SYSTEM_ERROR = new DJIMissionError("The vision system encounters system error.");
    REACH_ALTITUDE_LOWER_BOUND = new DJIMissionError("The aircraft reaches the altitude lower bound of the TapFly Mission.");
    CANNOT_BYPASS_OBSTACLE = new DJIMissionError("The aircraft cannot bypass the obstacle.");
    STOPPED_BY_USER = new DJIMissionError("Mission was stopped by the user.");
  }
  
  private DJIMissionError(String paramString)
  {
    super(paramString);
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    if (COMMON_UNKNOWN != DJIError.getDJIError(paramCcode)) {
      return DJIError.getDJIError(paramCcode);
    }
    int i = 1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()];
    return COMMON_UNKNOWN;
  }
  
  public static DJIMissionError getDJIErrorByCode(int paramInt)
  {
    if (paramInt != 15)
    {
      if (paramInt != 166)
      {
        if (paramInt != 255)
        {
          if (paramInt != 169)
          {
            if (paramInt != 170)
            {
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          return UNKNOWN;
                        case 244: 
                          return WRONG_CMD;
                        case 243: 
                          return AIRCRAFT_STARTING_MOTOR;
                        case 242: 
                          return AIRCRAFT_GOING_HOME;
                        case 241: 
                          return AIRCRAFT_LANDING;
                        }
                        return AIRCRAFT_TAKING_OFF;
                      case 238: 
                        return WAYPOINT_IDLE_VELOCITY_INVALID;
                      case 237: 
                        return WAYPOINT_NOT_RUNNING;
                      case 236: 
                        return WAYPOINT_REQUEST_IS_RUNNING;
                      case 235: 
                        return WAYPOINT_UPLOAD_NOT_COMPLETE;
                      case 234: 
                        return WAYPOINT_MISSION_INFO_NOT_UPLOADED;
                      case 233: 
                        return UPLOADING_WAYPOINT;
                      case 232: 
                        return WAYPOINT_ACTION_PARAMETER_INVALID;
                      case 231: 
                        return WAYPOINT_DAMPING_CHECK_FAILED;
                      case 230: 
                        return WAYPOINT_DISTANCE_TOO_LONG;
                      case 229: 
                        return WAYPOINT_DISTANCE_TOO_CLOSE;
                      case 228: 
                        return WAYPOINT_INDEX_OVER_RANGE;
                      case 227: 
                        return WAYPOINT_TOTAL_TRACE_TOO_LONG;
                      case 226: 
                        return WAYPOINT_TRACE_TOO_LONG;
                      case 225: 
                        return WAYPOINT_INFO_INVALID;
                      case 224: 
                        return MISSION_INFO_INVALID;
                      case 223: 
                        return AIRCRAFT_IN_NO_FLY_ZONE;
                      case 222: 
                        return HOME_POINT_NOT_RECORDED;
                      case 221: 
                        return MISSION_ACROSS_NO_FLY_ZONE;
                      case 220: 
                        return MISSION_CONDITION_NOT_SATISFIED;
                      case 219: 
                        return MISSION_PARAMETERS_INVALID;
                      case 218: 
                        return AIRCRAFT_NOT_IN_THE_AIR;
                      case 217: 
                        return LOW_BATTERY;
                      case 216: 
                        return GPS_SIGNAL_WEAK;
                      case 215: 
                        return HIGH_PRIORITY_MISSION_EXECUTING;
                      case 214: 
                        return MISSION_ESTIMATE_TIME_TOO_LONG;
                      case 213: 
                        return MISSION_CONFLICT;
                      case 212: 
                        return MISSION_NOT_EXIST;
                      case 211: 
                        return MISSION_NOT_INITIALIZED;
                      case 210: 
                        return IOC_WORKING;
                      case 209: 
                        return NAVIGATION_MODE_DISABLED;
                      }
                      return RC_MODE_ERROR;
                    case 202: 
                      return IN_NOVICE_MODE;
                    case 201: 
                      return DISTANCE_FROM_MISSION_TARGET_TOO_LONG;
                    case 200: 
                      return NAVIGATION_MODE_NOT_SUPPORTED;
                    case 199: 
                      return MISSION_RADIUS_OVER_LIMIT;
                    case 198: 
                      return MISSION_RESUME_FAILED;
                    case 197: 
                      return MISSION_HEADING_MODE_INVALID;
                    case 196: 
                      return MISSION_ENTRY_POINT_INVALID;
                    case 195: 
                      return MISSION_SPEED_TOO_HIGH;
                    case 194: 
                      return MISSION_RADIUS_INVALID;
                    case 193: 
                      return ALTITUDE_TOO_LOW;
                    }
                    return ALTITUDE_TOO_HIGH;
                  case 178: 
                    return FOLLOW_ME_GIMBAL_PITCH_ERROR;
                  case 177: 
                    return FOLLOW_ME_DISCONNECT_TIME_TOO_LONG;
                  }
                  return FOLLOW_ME_DISTANCE_TOO_LARGE;
                case 163: 
                  return HOME_POINT_LOCATION_INVALID;
                case 162: 
                  return HOME_POINT_VALUE_INVALID;
                case 161: 
                  return IOC_TYPE_UNKNOWN;
                }
                return TOO_CLOSE_TO_HOME_POINT;
              case 13: 
                return KEY_LEVEL_LOW;
              case 12: 
                return UPLOADING_WAYPOINT;
              case 11: 
                return MAX_NUMBER_OF_WAYPOINTS_UPLOAD_LIMIT_REACHED;
              case 10: 
                return NOT_AUTO_MODE;
              case 9: 
                return IS_FLYING;
              case 8: 
                return TAKE_OFF;
              case 7: 
                return MOTORS_DID_NOT_START;
              case 6: 
                return GPS_NOT_READY;
              case 5: 
                return MODE_ERROR;
              case 4: 
                return TIMEOUT;
              case 3: 
                return FAILED;
              case 2: 
                return CANCELED;
              case 1: 
                return BEGAN;
              }
              return null;
            }
            return HOME_POINT_MISSION_NOT_PAUSED;
          }
          return HOME_POINT_MISSION_PAUSED;
        }
        return UNKNOWN;
      }
      return HOME_POINT_DIRECTION_UNKNOWN;
    }
    return NAVIGATION_MODE_DISABLED;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIMissionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */