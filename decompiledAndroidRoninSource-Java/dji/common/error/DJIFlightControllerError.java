package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIFlightControllerError
  extends DJIError
{
  public static final DJIFlightControllerError ALREADY_IN_THE_AIR;
  public static final DJIFlightControllerError CANNOT_TURN_OFF_MOTORS_WHILE_AIRCRAFT_FLYING = new DJIFlightControllerError("The aircraft is flying and the motors could not be shut down.");
  public static final DJIFlightControllerError COULD_NOT_ENTER_TRANSPORT_MODE;
  public static final DJIFlightControllerError FAIL_TO_ENTER_TRANSPORT_MODE_WHEN_MOTORS_ON = new DJIFlightControllerError("When the motors are on, the aircraft could not get into transport mode.");
  public static final DJIFlightControllerError GO_HOME_ALTITUDE_TOO_HIGH;
  public static final DJIFlightControllerError GO_HOME_ALTITUDE_TOO_LOW = new DJIFlightControllerError("The go home altitude is too low (lower than 20m).");
  public static final DJIFlightControllerError GPS_SIGNAL_WEAK;
  public static final DJIFlightControllerError HOME_POINT_TOO_FAR;
  public static final DJIFlightControllerError IMU_CALIBRATION_ERROR_IN_THE_AIR_OR_MOTORS_ON;
  public static final DJIFlightControllerError INVALID_PARAMETER;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_GOINGHOME;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_IN_NOFLYZONE;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_LANDING;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_NOT_IN_THE_AIR;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_STARTING_MOTOR;
  public static final DJIFlightControllerError MISSION_RESULT_AIRCRAFT_TAKINGOFF;
  public static final DJIFlightControllerError MISSION_RESULT_ALTITUDE_TOO_HIGH;
  public static final DJIFlightControllerError MISSION_RESULT_ALTITUDE_TOO_LOW;
  public static final DJIFlightControllerError MISSION_RESULT_BEGAN;
  public static final DJIFlightControllerError MISSION_RESULT_CANCELED;
  public static final DJIFlightControllerError MISSION_RESULT_DISTANCE_FROM_MISSION_TARGET_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_FAILED;
  public static final DJIFlightControllerError MISSION_RESULT_FOLLOWME_DISCONNECT_TIME_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_FOLLOWME_DISTANCE_TOO_LARGE;
  public static final DJIFlightControllerError MISSION_RESULT_FOLLOWME_GIMBAL_PITCH_ERROR;
  public static final DJIFlightControllerError MISSION_RESULT_GPS_NOT_READY;
  public static final DJIFlightControllerError MISSION_RESULT_GPS_SIGNAL_WEAK;
  public static final DJIFlightControllerError MISSION_RESULT_HIGH_PRIORITY_MISSION_EXECUTING;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_DIRECTION_UNKNOWN;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_LOCATION_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_NOT_PAUSED;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_NOT_RECORDED;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_PAUSED;
  public static final DJIFlightControllerError MISSION_RESULT_HOMEPOINT_VALUE_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_IN_NOVICE_MODE;
  public static final DJIFlightControllerError MISSION_RESULT_IOC_TYPE_UNKNOWN;
  public static final DJIFlightControllerError MISSION_RESULT_IOC_WORKING;
  public static final DJIFlightControllerError MISSION_RESULT_IS_FLYING;
  public static final DJIFlightControllerError MISSION_RESULT_KEY_LEVEL_LOW;
  public static final DJIFlightControllerError MISSION_RESULT_LOW_BATTERY;
  public static final DJIFlightControllerError MISSION_RESULT_MC_MODE_ERROR;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_ACROSS_NOFLYZONE;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_CONDITION_NOT_SATISFIED;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_CONFLICT;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_ENTRYPOINT_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_ESTIMATE_TIME_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_HEADING_MODE_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_INFO_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_NOT_EXIST;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_NOT_INIT;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_PARAM_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_RADIUS_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_RADIUS_OVERLIMITED;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_RESUME_FAILED;
  public static final DJIFlightControllerError MISSION_RESULT_MISSION_SPEED_TOO_LARGE;
  public static final DJIFlightControllerError MISSION_RESULT_MODE_ERROR;
  public static final DJIFlightControllerError MISSION_RESULT_MOTOR_NOT_START;
  public static final DJIFlightControllerError MISSION_RESULT_NAVIGATION_IS_NOT_OPEN;
  public static final DJIFlightControllerError MISSION_RESULT_NOT_AUTO_MODE;
  public static final DJIFlightControllerError MISSION_RESULT_RC_MODE_ERROR;
  public static final DJIFlightControllerError MISSION_RESULT_TAKEOFF;
  public static final DJIFlightControllerError MISSION_RESULT_TIMEOUT;
  public static final DJIFlightControllerError MISSION_RESULT_TOO_CLOSE_TO_HOMEPOINT;
  public static final DJIFlightControllerError MISSION_RESULT_UNKNOWN;
  public static final DJIFlightControllerError MISSION_RESULT_UNSUPPORTED_NAVIGATION_FOR_THE_PRODUCT;
  public static final DJIFlightControllerError MISSION_RESULT_UPLOAD_WAYPOINT_NUM_MAX_LIMIT;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINTS_UPLOADING;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_ACTION_PARAM_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_DAMPING_CHECK_FAILED;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_DISTANCE_TOO_CLOSE;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_DISTANCE_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_IDLE_VELOCITY_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_INDEX_OVERRANGE;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_INFO_INVALID;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_MISSION_INFO_NOT_UPLOADED;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_NOT_RUNNING;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_REQUEST_IS_RUNNING;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_TOTAL_TRACE_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_TRACE_TOO_LONG;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_UPLOADING;
  public static final DJIFlightControllerError MISSION_RESULT_WAYPOINT_UPLOAD_NOT_COMPLETE;
  public static final DJIFlightControllerError MISSION_RESULT_WRONG_CMD;
  public static final DJIFlightControllerError OBJECT_EMPTY_OR_NOT_AVAILABLE;
  public static final DJIFlightControllerError RTK_BS_ANTENNA_ERROR = new DJIFlightControllerError("The RTK base station antenna is broken.");
  public static final DJIFlightControllerError RTK_BS_COORDINATE_RESET = new DJIFlightControllerError("The RTK base station location has been reset");
  public static final DJIFlightControllerError RTK_CANNOT_START;
  public static final DJIFlightControllerError RTK_CONNECTION_BROKEN;
  public static final DJIFlightControllerError UNSUPPORTED;
  public static final DJIFlightControllerError WHITE_LIST_FAIL_TO_CHECK_SN;
  public static final DJIFlightControllerError WHITE_LIST_FILE_SIZE_ERROR;
  public static final DJIFlightControllerError WHITE_LIST_FLYC_VERSION_NOT_MATCH;
  public static final DJIFlightControllerError WHITE_LIST_ILLEGAL_INDEX;
  public static final DJIFlightControllerError WHITE_LIST_INCORRECT_CRC;
  public static final DJIFlightControllerError WHITE_LIST_LICENSE_IS_INVALID;
  public static final DJIFlightControllerError WHITE_LIST_LICENSE_NOT_SUPPORT;
  public static final DJIFlightControllerError WHITE_LIST_NEED_TO_CONNECT_NEWTORK;
  public static final DJIFlightControllerError WHITE_LIST_NO_FETCHED_LICENSE;
  public static final DJIFlightControllerError WHITE_LIST_OPERATE_CODE_ERROR;
  public static final DJIFlightControllerError WHITE_LIST_REQ_ID_NOT_MATCH;
  
  static
  {
    GO_HOME_ALTITUDE_TOO_HIGH = new DJIFlightControllerError("The go home altitude is too high (higher than 500m).");
    HOME_POINT_TOO_FAR = new DJIFlightControllerError("Location is not within 30M of initial take-off location OR current RC location.");
    IMU_CALIBRATION_ERROR_IN_THE_AIR_OR_MOTORS_ON = new DJIFlightControllerError("IMU calibration is now allowed if the aircraft's motors are on or the aircraft is in the air.");
    INVALID_PARAMETER = new DJIFlightControllerError("FlightController received invalid parameters");
    COULD_NOT_ENTER_TRANSPORT_MODE = new DJIFlightControllerError("Aircraft could not enter transport mode, since the gimbal is still connected");
    GPS_SIGNAL_WEAK = new DJIFlightControllerError("GPS level is too weak to allow flight controller to obtain accurate location.");
    OBJECT_EMPTY_OR_NOT_AVAILABLE = new DJIFlightControllerError(" ");
    UNSUPPORTED = new DJIFlightControllerError("Unsupported");
    MISSION_RESULT_BEGAN = new DJIFlightControllerError("began");
    MISSION_RESULT_CANCELED = new DJIFlightControllerError("canceled");
    MISSION_RESULT_FAILED = new DJIFlightControllerError("failed");
    MISSION_RESULT_TIMEOUT = new DJIFlightControllerError("Execution of this process has timed out");
    MISSION_RESULT_MODE_ERROR = new DJIFlightControllerError("The control mode of the aircraft is not in the correct state");
    MISSION_RESULT_GPS_NOT_READY = new DJIFlightControllerError("GPS of aircraft is not ready");
    MISSION_RESULT_MOTOR_NOT_START = new DJIFlightControllerError("The aircraft's motor has not started");
    MISSION_RESULT_TAKEOFF = new DJIFlightControllerError("Aircraft is taking off");
    MISSION_RESULT_IS_FLYING = new DJIFlightControllerError("Aircraft is flying");
    MISSION_RESULT_NOT_AUTO_MODE = new DJIFlightControllerError("Aircraft is not in the auto mode");
    MISSION_RESULT_UPLOAD_WAYPOINT_NUM_MAX_LIMIT = new DJIFlightControllerError("Waypoint mission has reached the maximum points limit");
    MISSION_RESULT_WAYPOINT_UPLOADING = new DJIFlightControllerError("Waypoint mission is uploading");
    MISSION_RESULT_KEY_LEVEL_LOW = new DJIFlightControllerError("The API key provided to you is not at the correct permission level");
    MISSION_RESULT_NAVIGATION_IS_NOT_OPEN = new DJIFlightControllerError("Navigation is not open");
    MISSION_RESULT_TOO_CLOSE_TO_HOMEPOINT = new DJIFlightControllerError("Aircraft is too close to home point");
    MISSION_RESULT_IOC_TYPE_UNKNOWN = new DJIFlightControllerError("The type of IOC is unknown");
    MISSION_RESULT_HOMEPOINT_VALUE_INVALID = new DJIFlightControllerError("The home point is not a valid float value");
    MISSION_RESULT_HOMEPOINT_LOCATION_INVALID = new DJIFlightControllerError("The latitude and longitude of the home point are invalid");
    MISSION_RESULT_HOMEPOINT_DIRECTION_UNKNOWN = new DJIFlightControllerError("The direction of the home point is unknown");
    MISSION_RESULT_HOMEPOINT_PAUSED = new DJIFlightControllerError("The home point is paused");
    MISSION_RESULT_HOMEPOINT_NOT_PAUSED = new DJIFlightControllerError("The home point is not paused");
    MISSION_RESULT_FOLLOWME_DISTANCE_TOO_LARGE = new DJIFlightControllerError("Distance between the aircraft and mobile phone is beyond acceptable limit(must be lower than 20000m)");
    MISSION_RESULT_FOLLOWME_DISCONNECT_TIME_TOO_LONG = new DJIFlightControllerError("The disconnect time of follow me mission is too long");
    MISSION_RESULT_FOLLOWME_GIMBAL_PITCH_ERROR = new DJIFlightControllerError("The initial pitch angle of gimbal is too large");
    MISSION_RESULT_ALTITUDE_TOO_HIGH = new DJIFlightControllerError("The altitude is too high");
    MISSION_RESULT_ALTITUDE_TOO_LOW = new DJIFlightControllerError("The altitude is too low");
    MISSION_RESULT_MISSION_RADIUS_INVALID = new DJIFlightControllerError("The radius of the mission is invalid");
    MISSION_RESULT_MISSION_SPEED_TOO_LARGE = new DJIFlightControllerError("The speed of the mission is too large");
    MISSION_RESULT_MISSION_ENTRYPOINT_INVALID = new DJIFlightControllerError("The entry point of the mission is invalid");
    MISSION_RESULT_MISSION_HEADING_MODE_INVALID = new DJIFlightControllerError("The heading mode of the mission is invalid");
    MISSION_RESULT_MISSION_RESUME_FAILED = new DJIFlightControllerError("Failed to resume the mission");
    MISSION_RESULT_MISSION_RADIUS_OVERLIMITED = new DJIFlightControllerError("The radius of mission is over the acceptable limit");
    MISSION_RESULT_UNSUPPORTED_NAVIGATION_FOR_THE_PRODUCT = new DJIFlightControllerError("Navigation in the product is unsupported");
    MISSION_RESULT_DISTANCE_FROM_MISSION_TARGET_TOO_LONG = new DJIFlightControllerError("Navigation in the product is unsupported");
    MISSION_RESULT_RC_MODE_ERROR = new DJIFlightControllerError("Mode error, please make sure the remote controller's mode switch is in 'F' or 'P' mode. For Phantom 4, all of the intelligent missions are allowed to execute in the 'P' mode");
    MISSION_RESULT_MC_MODE_ERROR = new DJIFlightControllerError("The mode of the main controller is error");
    MISSION_RESULT_IOC_WORKING = new DJIFlightControllerError("The IOC mode is working");
    MISSION_RESULT_MISSION_NOT_INIT = new DJIFlightControllerError("The mission is not initialized");
    MISSION_RESULT_MISSION_NOT_EXIST = new DJIFlightControllerError("The mission does not exist");
    MISSION_RESULT_MISSION_CONFLICT = new DJIFlightControllerError("There is a conflicting setting in the mission");
    MISSION_RESULT_MISSION_ESTIMATE_TIME_TOO_LONG = new DJIFlightControllerError("The estimated time for the mission is too long");
    MISSION_RESULT_IN_NOVICE_MODE = new DJIFlightControllerError("The aircraft is in novice mode now");
    MISSION_RESULT_HIGH_PRIORITY_MISSION_EXECUTING = new DJIFlightControllerError("A higher priority mission is executing");
    MISSION_RESULT_GPS_SIGNAL_WEAK = new DJIFlightControllerError("The GPS signal of the aircraft is weak");
    MISSION_RESULT_LOW_BATTERY = new DJIFlightControllerError("Low battery level warning");
    MISSION_RESULT_AIRCRAFT_NOT_IN_THE_AIR = new DJIFlightControllerError("The aircraft is not in the air");
    MISSION_RESULT_MISSION_PARAM_INVALID = new DJIFlightControllerError("The parameters of the mission are invalid");
    MISSION_RESULT_MISSION_CONDITION_NOT_SATISFIED = new DJIFlightControllerError("The condition of the mission is not satisfied");
    MISSION_RESULT_MISSION_ACROSS_NOFLYZONE = new DJIFlightControllerError("The mission is across the no fly zone");
    MISSION_RESULT_HOMEPOINT_NOT_RECORDED = new DJIFlightControllerError("The home point of aircraft is not recorded");
    MISSION_RESULT_AIRCRAFT_IN_NOFLYZONE = new DJIFlightControllerError("The aircraft is in the no fly zone");
    MISSION_RESULT_MISSION_INFO_INVALID = new DJIFlightControllerError("The information of the mission is invalid");
    MISSION_RESULT_WAYPOINT_INFO_INVALID = new DJIFlightControllerError("The information of the waypoint is invalid");
    MISSION_RESULT_WAYPOINT_TRACE_TOO_LONG = new DJIFlightControllerError("The trace of the waypoint is too long");
    MISSION_RESULT_WAYPOINT_TOTAL_TRACE_TOO_LONG = new DJIFlightControllerError("The total trace of the waypoint is too long");
    MISSION_RESULT_WAYPOINT_INDEX_OVERRANGE = new DJIFlightControllerError("The index of the waypoint is over range");
    MISSION_RESULT_WAYPOINT_DISTANCE_TOO_CLOSE = new DJIFlightControllerError("The waypoint distance is too close");
    MISSION_RESULT_WAYPOINT_DISTANCE_TOO_LONG = new DJIFlightControllerError("The waypoint distance is too long");
    MISSION_RESULT_WAYPOINT_DAMPING_CHECK_FAILED = new DJIFlightControllerError("The damping check is failed");
    MISSION_RESULT_WAYPOINT_ACTION_PARAM_INVALID = new DJIFlightControllerError("The parameter of the waypoint action is invalid");
    MISSION_RESULT_WAYPOINTS_UPLOADING = new DJIFlightControllerError("The waypoints are still uploading");
    MISSION_RESULT_WAYPOINT_MISSION_INFO_NOT_UPLOADED = new DJIFlightControllerError("The info of the waypoint mission is not completely uploaded");
    MISSION_RESULT_WAYPOINT_UPLOAD_NOT_COMPLETE = new DJIFlightControllerError("The waypoint uploading is not complete");
    MISSION_RESULT_WAYPOINT_REQUEST_IS_RUNNING = new DJIFlightControllerError("The waypoint request is running");
    MISSION_RESULT_WAYPOINT_NOT_RUNNING = new DJIFlightControllerError("The waypoint mission is not running");
    MISSION_RESULT_WAYPOINT_IDLE_VELOCITY_INVALID = new DJIFlightControllerError("The idle velocity is invalid");
    MISSION_RESULT_AIRCRAFT_TAKINGOFF = new DJIFlightControllerError("The aircraft is taking off");
    MISSION_RESULT_AIRCRAFT_LANDING = new DJIFlightControllerError("The aircraft is landing");
    MISSION_RESULT_AIRCRAFT_GOINGHOME = new DJIFlightControllerError("The aircraft is going home");
    MISSION_RESULT_AIRCRAFT_STARTING_MOTOR = new DJIFlightControllerError("The aircraft is starting the motor");
    MISSION_RESULT_WRONG_CMD = new DJIFlightControllerError("The command is wrong");
    ALREADY_IN_THE_AIR = new DJIFlightControllerError("If the motors are already turned on or the aircraft is already flying, the takeoff() did not execute.");
    MISSION_RESULT_UNKNOWN = new DJIFlightControllerError("Unknown result");
    RTK_CANNOT_START = new DJIFlightControllerError("The RTK starting is failed.");
    RTK_CONNECTION_BROKEN = new DJIFlightControllerError("The RTK connection is lost.");
    WHITE_LIST_NO_FETCHED_LICENSE = new DJIFlightControllerError("Fetch the white list license from aircraft before calling getWhiteListLicense()");
    WHITE_LIST_ILLEGAL_INDEX = new DJIFlightControllerError("Illegal index");
    WHITE_LIST_OPERATE_CODE_ERROR = new DJIFlightControllerError("Operation code error");
    WHITE_LIST_REQ_ID_NOT_MATCH = new DJIFlightControllerError("Request ID does not match");
    WHITE_LIST_NEED_TO_CONNECT_NEWTORK = new DJIFlightControllerError("The license need to be verified through network");
    WHITE_LIST_LICENSE_NOT_SUPPORT = new DJIFlightControllerError("The license is not support");
    WHITE_LIST_LICENSE_IS_INVALID = new DJIFlightControllerError("The license is invalid");
    WHITE_LIST_FILE_SIZE_ERROR = new DJIFlightControllerError("The file size pushed to aircraft is wrong");
    WHITE_LIST_INCORRECT_CRC = new DJIFlightControllerError("CRC is not correct");
    WHITE_LIST_FAIL_TO_CHECK_SN = new DJIFlightControllerError("SN is not matching.");
    WHITE_LIST_FLYC_VERSION_NOT_MATCH = new DJIFlightControllerError("The flight controller firmware is not support this feature.");
  }
  
  private DJIFlightControllerError(String paramString)
  {
    super(paramString);
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    if (COMMON_UNKNOWN != DJIError.getDJIError(paramCcode)) {
      return DJIError.getDJIError(paramCcode);
    }
    if (1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()] != 1) {
      return COMMON_UNKNOWN;
    }
    return COMMON_TIMEOUT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIFlightControllerError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */