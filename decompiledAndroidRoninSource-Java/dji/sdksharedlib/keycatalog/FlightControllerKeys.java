package dji.sdksharedlib.keycatalog;

import dji.common.error.DJIError;
import dji.common.flightcontroller.BatteryThresholdBehavior;
import dji.common.flightcontroller.CompassCalibrationState;
import dji.common.flightcontroller.ConnectionFailSafeBehavior;
import dji.common.flightcontroller.ControlGimbalBehavior;
import dji.common.flightcontroller.ControlMode;
import dji.common.flightcontroller.DJIMultiLEDControlMode;
import dji.common.flightcontroller.DJIVisionTrackHeadingMode;
import dji.common.flightcontroller.FlightMode;
import dji.common.flightcontroller.FlightOrientationMode;
import dji.common.flightcontroller.GPSSignalLevel;
import dji.common.flightcontroller.GoHomeExecutionState;
import dji.common.flightcontroller.IOStateOnBoard;
import dji.common.flightcontroller.LandingGearMode;
import dji.common.flightcontroller.LandingGearState;
import dji.common.flightcontroller.PositioningSolution;
import dji.common.flightcontroller.PowerStateOnBoard;
import dji.common.flightcontroller.RCSwitchFlightMode;
import dji.common.flightcontroller.imu.CalibrationState;
import dji.common.flightcontroller.imu.IMUState;
import dji.common.flightcontroller.imu.SensorState;
import dji.common.flightcontroller.simulator.InitializationData;
import dji.common.flightcontroller.simulator.SimulatorState;
import dji.common.flightcontroller.virtualstick.FlightControlData;
import dji.common.flightcontroller.virtualstick.FlightCoordinateSystem;
import dji.common.flightcontroller.virtualstick.RollPitchControlMode;
import dji.common.flightcontroller.virtualstick.VerticalControlMode;
import dji.common.flightcontroller.virtualstick.YawControlMode;
import dji.common.model.LocationCoordinate2D;
import dji.midware.data.model.P3.DataEyeFixedWingControl.FixedWingCtrlType;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerA2Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerA3Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerA3WithLb2Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerFoldingDroneAbstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerInspire1Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerInspire2Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerM200Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerPhantom4Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.FlightControllerPhantom4PAbstraction;
import dji.sdksharedlib.keycatalog.extension.ComplexKey;
import dji.sdksharedlib.keycatalog.extension.Key;

public class FlightControllerKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=2, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ADVANCED_FLIGHT_MODE_ENABLED = "AdvancedFlightModeEnabled";
  @Key(accessType=4, type=Double.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AIRCRAFT_LOCATION_LATITUDE = "AircraftLocationLatitude";
  @Key(accessType=4, type=Double.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AIRCRAFT_LOCATION_LONGITUDE = "AircraftLocationLongitude";
  @Key(accessType=3, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AIRCRAFT_NAME = "AircraftName";
  @Key(accessType=4, type=Boolean.class)
  public static final String AIRCRAFT_SHOULD_GO_HOME = "AircraftShouldGoHome";
  @Key(accessType=4, type=Float.class)
  public static final String ALTITUDE = "Altitude";
  @Key(accessType=4, type=Boolean.class)
  public static final String ARE_MOTOR_ON = "AreMotorsOn";
  @Key(accessType=4, type=Double.class)
  public static final String ATTITUDE_PITCH = "AttitudePitch";
  @Key(accessType=4, type=Double.class)
  public static final String ATTITUDE_ROLL = "AttitudeRoll";
  @Key(accessType=4, type=Double.class)
  public static final String ATTITUDE_YAW = "AttitudeYaw";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AUTO_LANDING_GEAR = "AutoLandingGear";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AUTO_LANDING_GEAR_GROUND_NOTIFY = "AutoLandingGearGroundNotify";
  @Key(accessType=4, type=Integer.class)
  public static final String BATTERY_PERCENTAGE_NEEDED_TO_GO_HOME = "BatteryPercentageNeededToGoHome";
  @Key(accessType=4, type=BatteryThresholdBehavior.class)
  public static final String BATTERY_THRESHOLD_BEHAVIOR = "RemainingBattery";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CANCEL_GO_HOME = "CancelGoHome";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CANCEL_LANDING = "CancelAutoLanding";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CANCEL_TAKE_OFF = "CancelTakeOff";
  public static final String CINEMATIC_COURSE_ANGULAR_VELOCITY_RANGE = "CinematicCourseAngularVelocityRange";
  public static final String CINEMATIC_MODE_GAIN = "CinematicModeGain";
  @Key(accessType=4, type=CompassCalibrationState.class)
  public static final String COMPASS_CALIBRATION_STATUS = "CompassCalibrationStatus";
  @Key(accessType=4, type=Boolean.class)
  public static final String COMPASS_HAS_ERROR = "CompassHasError";
  @Key(accessType=4, type=Float.class)
  public static final String COMPASS_HEADING = "CompassHeading";
  @Key(accessType=4, type=Boolean.class)
  public static final String COMPASS_IS_CALIBRATING = "CompassIsCalibrating";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String COMPASS_START_CALIBRATION = "CompassStartCalibration";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String COMPASS_STOP_CALIBRATION = "CompassStopCalibration";
  public static final String COMPONENT_KEY = "FlightController";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_RC_SCALE_IN_AVOIDANCE = "ConfigRcScaleInAvoidance";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_RC_SCALE_IN_NORMAL = "ConfigRcScaleInNormal";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_RC_SCALE_IN_SPORT = "ConfigRcScaleInSport";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONFIG_RTH_IN_CURRENT_ALTITUDE = "ConfigRTHInCurrentAltitude";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_YAW_RATE_IN_AVOIDANCE = "ConfigYawRateInAvoidance";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_YAW_RATE_IN_NORMAL = "ConfigYawRateInNormal";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONFIG_YAW_RATE_IN_SPORT = "ConfigYawRateInSport";
  @Key(accessType=8, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class, FlightControllerInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONFIRM_LANDING = "confirmLanding";
  @Key(accessType=3, type=ConnectionFailSafeBehavior.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONNECTION_FAIL_SAFE_BEHAVIOR = "FlightFailSafeOperation";
  @Key(accessType=6, includedAbstractions={FlightControllerM200Abstraction.class}, type=ControlGimbalBehavior.class)
  public static final String CONTROL_GIMBAL_BEHAVIOR = "control_gimbal_behavior";
  @Key(accessType=3, includedAbstractions={FlightControllerA3WithLb2Abstraction.class}, type=ControlMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CONTROL_MODE = "ControlMode";
  @Key(accessType=4, type=Short.class)
  public static final String COURSE_LOCK_ANGLE = "CourseLockAngle";
  @Key(accessType=4, excludedAbstractions={FlightControllerA2Abstraction.class}, type=Integer.class)
  public static final String CURRENT_LAND_IMMEDIATELY_BATTERY = "CurrentLandImmediatelyBattery";
  @Key(accessType=4, type=RCSwitchFlightMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String CURRENT_MODE = "CurrentMode";
  @Key(accessType=8, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String DEPLOY_LANDING_GEAR = "DeployLandingGear";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DEVICE_INSTALL_ERROR_HOVER_THRUST_LOW = "DeviceInstallErrorHoverThrustLow";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DEVICE_INSTALL_ERROR_MASS_CENTER = "DeviceInstallErrorMassCenter";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DEVICE_INSTALL_ERROR_VIBRATION = "DeviceInstallErrorVibration";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DEVICE_INSTALL_ERROR_YAW = "DeviceInstallErrorYaw";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String ENABLE_1860 = "Enable1860";
  @Key(accessType=8, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ENTER_TRANSPORT_MODE = "EnterTransportMode";
  @Key(accessType=8, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String EXIT_TRANSPORT_MODE = "ExitTransportMode";
  public static final String FAN_ENABLED = "FanEnabled";
  @Key(accessType=8, includedAbstractions={FlightControllerPhantom4Abstraction.class, FlightControllerFoldingDroneAbstraction.class}, type=DataEyeFixedWingControl.FixedWingCtrlType.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FIXED_WING_CTRL = "FixedWingControl";
  public static final String FLIGHT_CONTROLLER_CONFIG_ACTIVE_AVOIDANCE = "FlightControllerConfigActiveAvoidance";
  public static final String FLIGHT_CONTROLLER_CONFIG_ATTITUDE_RANGE = "FlightControllerConfigAttitudeRange";
  public static final String FLIGHT_CONTROLLER_CONFIG_BASIC_PITCH = "FlightControllerConfigBasicPitch";
  public static final String FLIGHT_CONTROLLER_CONFIG_BASIC_ROLL = "FlightControllerConfigBasicRoll";
  public static final String FLIGHT_CONTROLLER_CONFIG_BASIC_TAIL = "FlightControllerConfigBasicTail";
  public static final String FLIGHT_CONTROLLER_CONFIG_BASIC_YAW = "FlightControllerConfigBasicYaw";
  public static final String FLIGHT_CONTROLLER_CONFIG_BRAKE_SENSITIVE = "FlightControllerConfigBrakeSensitive";
  public static final String FLIGHT_CONTROLLER_CONFIG_GENTLE_LIFT_EXP_MIDDLE_POINT = "FlightControllerConfigGentleLiftExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_GENTLE_TILT_EXP_MIDDLE_POINT = "FlightControllerConfigGentleTiltExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_GENTLE_TORSION_EXP_MIDDLE_POINT = "FlightControllerConfigGentleTorsionExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_GYRO_RANGE = "FlightControllerConfigTripodGyroRange";
  public static final String FLIGHT_CONTROLLER_CONFIG_HIDE_GEAR = "FlightControllerConfigHideGear";
  public static final String FLIGHT_CONTROLLER_CONFIG_IMU_TEMP_REAL_CTL_OUT_PER = "FlightControllerConfigImuTempRealCtlOutPer";
  public static final String FLIGHT_CONTROLLER_CONFIG_LANDING_CHECK_SWITCH = "FlightControllerConfigLandingCheckSwitch";
  public static final String FLIGHT_CONTROLLER_CONFIG_NORMAL_LIFT_EXP_MIDDLE_POINT = "FlightControllerConfigNormalLiftExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_NORMAL_TILT_EXP_MIDDLE_POINT = "FlightControllerConfigNormalTiltExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_NORMAL_TORSION_EXP_MIDDLE_POINT = "FlightControllerConfigNormalTorsionExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_ON_GROUND_HIDE_GEAR = "FlightControllerConfigOnGroundHideGear";
  public static final String FLIGHT_CONTROLLER_CONFIG_RC_TILT_SENSITIVE = "FlightControllerConfigRcTiltSensitive";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_LIFT_EXP_MIDDLE_POINT = "FlightControllerConfigSportLiftExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_THROTTLE_EXPERIENCE_MID_POINT = "FlightControllerConfigSportThrottleExperienceMidPoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_TILT_EXPERIENCE_MID_POINT = "FlightControllerConfigSportTiltExperienceMidPoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_TILT_EXP_MIDDLE_POINT = "FlightControllerConfigSportTiltExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_TORSION_EXP_MIDDLE_POINT = "FlightControllerConfigSportTorsionExpMiddlePoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_SPORT_YAW_EXPERIENCE_MID_POINT = "FlightControllerConfigSportYawExperienceMidPoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_THROTTLE_EXPERIENCE_MID_POINT = "FlightControllerConfigThrottleExperienceMidPoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_TILT_EXPERIENCE_MID_POINT = "FlightControllerConfigTiltExperienceMidPoint";
  public static final String FLIGHT_CONTROLLER_CONFIG_TILT_SENSITIVE = "FlightControllerConfigTiltSensitive";
  public static final String FLIGHT_CONTROLLER_CONFIG_TORSION_GYRO_RANGE = "FlightControllerConfigTorsionGyroRange";
  public static final String FLIGHT_CONTROLLER_CONFIG_TORSION_RATE = "FlightControllerConfigTorsionRate";
  public static final String FLIGHT_CONTROLLER_CONFIG_TRIPOD_RCSCALE = "FlightControllerConfigTripodRcScale";
  public static final String FLIGHT_CONTROLLER_CONFIG_VERTICAL_ATTI = "FlightControllerConfigVerticalAtti";
  public static final String FLIGHT_CONTROLLER_CONFIG_VERT_DOWN = "FlightControllerConfigTripodVertDown";
  public static final String FLIGHT_CONTROLLER_CONFIG_VERT_UP = "FlightControllerConfigTripodVertUp";
  public static final String FLIGHT_CONTROLLER_CONFIG_YAW_AT_SPORT = "FlightControllerConfigYawAtSport";
  public static final String FLIGHT_CONTROLLER_CONFIG_YAW_EXPERIENCE_MID_POINT = "FlightControllerConfigYawExperienceMidPoint";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FLIGHT_CONTROLLER_HOMING_SENSE_ON = "FlightControllerHomingSenseOn";
  @Key(accessType=3, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FLIGHT_CONTROLLER_MAX_DIVE_SPEED = "MaxDiveSpeed";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_SELFIE_GPS = "FlightControllerSelfieGPS";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TAPFLY_RC_GIMBALCTRL = "FlightControllerTapFlyRcGimbalCtrl";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TRACK_CIRCLEY = "FlightControllerTrackCircleY";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class}, type=DJIVisionTrackHeadingMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TRACK_HEADING_MODE = "FlightControllerTrackHeadingMode";
  @Key(accessType=4, type=Integer.class)
  public static final String FLIGHT_LIMIT_SPACE_NUM = "FlightLimitSpaceNum";
  @Key(accessType=4, type=FlightMode.class)
  public static final String FLIGHT_MODE = "FlightMode";
  @Key(accessType=4, type=String.class)
  public static final String FLIGHT_MODE_KEY = "FlightModeKey";
  @Key(accessType=2, excludedAbstractions={FlightControllerA2Abstraction.class}, type=FlightOrientationMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FLIGHT_ORIENTATION_MODE = "FlightOrientationMode";
  @Key(accessType=4, type=Integer.class)
  public static final String FLY_TIME_IN_SECONDS = "FlyTime";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FLY_ZONE_LIMITATION_ENABLED = "GeoFeatureInSimulatorEnabled";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FULL_SERIAL_NUMBER_HASH = "FullSerialNumberHash";
  @Key(accessType=6, excludedAbstractions={FlightControllerA2Abstraction.class}, type=Integer.class)
  public static final String GO_HOME_BATTERY_THRESHOLD = "GoHomeBatteryThreshold";
  @ComplexKey({@Key(accessType=4, excludedAbstractions={FlightControllerA2Abstraction.class}, type=Float.class), @Key(accessType=3, excludedAbstractions={FlightControllerA2Abstraction.class}, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String GO_HOME_HEIGHT_IN_METERS = "GoHomeAltitude";
  @Key(accessType=4, type=GoHomeExecutionState.class)
  public static final String GO_HOME_STATUS = "GoHomeStatus";
  @Key(accessType=4, type=GPSSignalLevel.class)
  public static final String GPS_SIGNAL_LEVEL = "GPSSignalLevel";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_REACHED_MAX_FLIGHT_HEIGHT = "HasReachedMaxFlightHeight";
  @Key(accessType=4, type=Boolean.class)
  public static final String HAS_REACHED_MAX_FLIGHT_RADIUS = "HasReachedMaxFlightRadius";
  @Key(accessType=3, excludedAbstractions={FlightControllerA2Abstraction.class}, type=LocationCoordinate2D.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String HOME_LOCATION = "HomeLocation";
  @Key(accessType=4, type=Double.class)
  public static final String HOME_LOCATION_LATITUDE = "HomeLocationLatitude";
  @Key(accessType=4, type=Double.class)
  public static final String HOME_LOCATION_LONGITUDE = "HomeLocationLongitude";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String HOME_LOCATION_USING_CURRENT_AIRCRAFT_LOCATION = "HomeLocationUsingCurrentAircraftLocation";
  @Key(accessType=4, type=Float.class)
  public static final String HOME_POINT_ALTITUDE = "HomePointAltitude";
  @Key(accessType=1, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_COUNT = "ImuCount";
  @Key(accessType=1, type=IMUState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IMU_STATE = "IMUState";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_ACCELERATION_X = "IMUStateAccelerationX";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_ACCELERATION_Y = "IMUStateAccelerationY";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_ACCELERATION_Z = "IMUStateAccelerationZ";
  @Key(accessType=4, type=SensorState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IMU_STATE_ACCELEROMETER_STATE = "IMUStateAcceleratorState";
  @Key(accessType=4, type=Integer.class)
  public static final String IMU_STATE_CALIBRATION_PROGRESS = "IMUStateCalibrationProgress";
  @Key(accessType=4, type=CalibrationState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IMU_STATE_CALIBRATION_STATE = "IMUStateCalibrationState";
  @Key(accessType=4, type=SensorState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IMU_STATE_GYROSCOPE_STATE = "IMUStateGyroscopeState";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_GYROSCOPE_X = "IMUStateGyroscopeX";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_GYROSCOPE_Y = "IMUStateGyroscopeY";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IMU_STATE_GYROSCOPE_Z = "IMUStateGyroscopeZ";
  @Key(accessType=8, includedAbstractions={FlightControllerM200Abstraction.class}, types={Integer.class, IOStateOnBoard.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String INIT_IO = "InitIo";
  @Key(accessType=7, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String INTELLIGENT_FLIGHT_ASSISTANT_GHAVOID_ENABLED = "VisionGHAVoidEnabled";
  @Key(accessType=3, type=Boolean.class)
  public static final String INTELLIGENT_FLIGHT_ASSISTANT_HAND_GESTURE_ENABLED = "HandGestureEnabled";
  public static final String INTELLIGENT_FLIGHT_ASSISTANT_VISION_ASSISTANT_STATUS = "IntelligentFlightAssistantVisionAssistantStatus";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String INTERNAL_FLIGHT_CONTROLLER_VERSION = "InternalFlightControllerVersion";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String INTERNAL_SERIAL_NUMBER = "InternalSerialNumber";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=IOStateOnBoard.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IOSTATE_0 = "IOState_0";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=IOStateOnBoard.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IOSTATE_1 = "IOState_1";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=IOStateOnBoard.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IOSTATE_2 = "IOState_2";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=IOStateOnBoard.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IOSTATE_3 = "IOState_3";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=IOStateOnBoard.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IOSTATE_4 = "IOState_4";
  @Key(accessType=8, includedAbstractions={FlightControllerM200Abstraction.class}, types={Integer.class, IOStateOnBoard.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IO_STATE = "IOState";
  @Key(accessType=4, includedAbstractions={FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_ASCENT_LIMITED_BY_OBSTACLE = "IsAscentLimitedByObstacle";
  @Key(accessType=4, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class, FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_AVOIDING_ACTIVE_OBSTACLE_COLLISION = "IsAvoidingActiveObstacleCollision";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_FAIL_SAFE = "IsFailSafe";
  @Key(accessType=1, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_FLIGHT_ASSISTANT_SUPPORTED = "IntelligentFlightAssistantSupported";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_FLYING = "IsFlying";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_GOING_HOME = "IsGoingHome";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_GPS_BEING_USED = "IsGpsBeingUsed";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_HOME_LOCATION_SET = "IsHomeLocationSet";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_IMU_PREHEATING = "IsIMUPreheating";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_LANDING = "IsAutoLanding";
  @Key(accessType=4, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class, FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_LANDING_CONFIRMATION_NEEDED = "isLandingConfirmationNeeded";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_LANDING_GEAR_MOVABLE = "IsLandingGearMovable";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_NEAR_DISTANCE_LIMIT = "IsNearDistanceLimit";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_NEAR_HEIGHT_LIMIT = "IsNearHeightLimit";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_ON_BOARD_SDK_AVAILABLE = "IsOnBoardSDKAvailable";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_RTK_SUPPORTED = "RtkSupported";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_SIMULATOR_ACTIVE = "IsSimulatorStarted";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_ULTRASONIC_BEING_USED = "IsUltrasonicBeingUsed";
  @Key(accessType=1, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_VIRTUAL_STICK_CONTROL_MODE_AVAILABLE = "isVirtualStickControlModeAvailable";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_VISION_POSITIONING_SENSOR_BEING_USED = "IsVisionPositioningSensorBeingUsed";
  public static final String IS_VISION_SENSOR_ENABLE = "IsVisionSensorEnable";
  public static final String IS_VISION_SENSOR_WORK = "IswaypointProtocol";
  @Key(accessType=3, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class, FlightControllerA3Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LANDING_GEAR_AUTOMATIC_MOVEMENT_ENABLED = "LandingGearAutomaticMovementEnabled";
  @Key(accessType=4, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, type=LandingGearMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LANDING_GEAR_MODE = "LandingGearMode";
  @Key(accessType=4, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, type=LandingGearState.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LANDING_GEAR_STATUS = "LandingGearStatus";
  @Key(accessType=6, excludedAbstractions={FlightControllerA2Abstraction.class}, type=Integer.class)
  public static final String LAND_IMMEDIATELY_BATTERY_THRESHOLD = "LandImmediatelyBatteryThreshold";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LEDS_ENABLED = "LEDsEnabled";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LOCK_COURSE_USING_CURRENT_HEADING = "LockCourseUsingCurrentDirection";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MAX_FLIGHT_HEIGHT = "MaxFlightHeight";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MAX_FLIGHT_RADIUS = "MaxFlightRadius";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MAX_FLIGHT_RADIUS_LIMITATION_ENABLED = "MaxFlightRadiusEnabled";
  @Key(accessType=4, type=Float.class)
  public static final String MAX_RADIUS_AIRCRAFT_CAN_FLY_AND_GO_HOME = "MaxRadiusAircraftCanFlyAndGoHome";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MISSION_TRIPOD_VELOCITY_CTRL = "MissionTripodVelocityCtrl";
  @Key(accessType=1, type=RCSwitchFlightMode[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MODE = "Mode";
  @Key(accessType=3, type=DJIMultiLEDControlMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MULTI_LEDS_ENABLED = "MultiLEDsEnabled";
  @Key(accessType=4, type=Boolean.class)
  public static final String MULTI_MODE_OPEN = "MultiModeOpen";
  @Key(accessType=6, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String NAVIGATION_MODE_ENABLED = "NavigationModeEnabled";
  @Key(accessType=5, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String NEED_LIMIT_FLIGHT_HEIGHT = "NeedLimitFlightHeight";
  @ComplexKey({@Key(accessType=4, type=Float.class), @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)})
  public static final String NOVICE_FUNC_ENABLED = "NoviceFuncEnabled";
  @Key(accessType=4, type=FlightOrientationMode.class)
  public static final String ORIENTATION_MODE = "IocMode";
  @Key(accessType=8, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PAUSE_TERRAIN_FOLLOW_MODE = "PauseTerrainFollowMode";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=PositioningSolution.class)
  public static final String POSITIONING_SOLUTION = "RTKStatus";
  @Key(accessType=3, includedAbstractions={FlightControllerM200Abstraction.class}, type=PowerStateOnBoard.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String POWER_ON_BOARD = "PowerOnBoard";
  @Key(accessType=3, includedAbstractions={FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String QUICK_SPIN_ENABLED = "QuickSpin";
  @Key(accessType=4, type=Integer.class)
  public static final String REMAINING_FLIGHT_TIME = "RemainingFlightTime";
  @Key(accessType=8, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESUME_TERRAIN_FOLLOW_MODE = "ResumeTerrainFollowMode";
  @Key(accessType=8, includedAbstractions={FlightControllerInspire1Abstraction.class, FlightControllerInspire2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RETRACT_LANDING_GEAR = "RetractLandingGear";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Float.class)
  public static final String RTK_AIR_ALTITUDE = "RTKAirAltitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Double.class)
  public static final String RTK_AIR_LATITUDE = "RTKAirLatitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Double.class)
  public static final String RTK_AIR_LONGITUDE = "RTKAirLongitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Float.class)
  public static final String RTK_DIRECT_ANGLE = "RTKDirectAngle";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_ENABLED = "RTKEnabled";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=DJIError.class)
  public static final String RTK_ERROR = "RTKError";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Float.class)
  public static final String RTK_GROUND_ALTITUDE = "RTKGroundAltitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_GROUND_BEIDOU_COUNT = "RTKGroundBeidoutCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_GROUND_BEIDOU_COUNT_IS_ON = "RTKGroundBeidoutCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_GROUND_GLONASS_COUNT = "RTKGroundGlonassCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_GROUND_GLONASS_COUNT_IS_ON = "RTKGroundGlonassCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_GROUND_GPS_COUNT = "RTKGroundGPSCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_GROUND_GPS_COUNT_IS_ON = "RTKGroundGPSCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Double.class)
  public static final String RTK_GROUND_LATITUDE = "RTKGroundLatitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Double.class)
  public static final String RTK_GROUND_LONGITUDE = "RTKGroundLongitude";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_IS_HEADING_VALID = "RTKDirectEnabled";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_MAIN_BEIDOU_COUNT = "RTKMainBeidouCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_MAIN_BEIDOU_COUNT_IS_ON = "RTKMainBeidouCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_MAIN_GLONASS_COUNT = "RTKMainGlonassCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_MAIN_GLONASS_COUNT_IS_ON = "RTKMainGlonassCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_MAIN_GPS_COUNT = "RTKMainGPSCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_MAIN_GPS_COUNT_IS_ON = "RTKMainGPSCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_SATELLITE_BEIDOU_COUNT = "RTKSatelliteBeidouCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_SATELLITE_BEIDOU_COUNT_IS_ON = "RTKSatelliteBeidouCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_SATELLITE_GLONASS_COUNT = "RTKSatelliteGlonassCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_SATELLITE_GLONASS_COUNT_IS_ON = "RTKSatelliteGlonassCountIsOn";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class)
  public static final String RTK_SATELLITE_GPS_COUNT = "RTKSatelliteGPSCount";
  @Key(accessType=4, includedAbstractions={FlightControllerA3Abstraction.class}, type=Boolean.class)
  public static final String RTK_SATELLITE_GPS_COUNT_IS_ON = "RTKSatelliteGPSCountIsOn";
  @Key(accessType=4, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SATELLITE_COUNT = "SatelliteCount";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, type=byte[].class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SEND_DATA_TO_ON_BOARD_SDK_DEVICE = "SendDataToOnboardSDKDevice";
  @Key(accessType=8, types={FlightControlData.class, VerticalControlMode.class, RollPitchControlMode.class, YawControlMode.class, FlightCoordinateSystem.class, Boolean.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SEND_VIRTUAL_STICK_FLIGHT_CONTROL_DATA = "SendVirtualStickFlightControlData";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SERIAL_NUMBER = "SerialNumber";
  @Key(accessType=4, type=SimulatorState.class)
  public static final String SIMULATOR_STATE = "SimulatorState";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_GO_HOME = "GoHome";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_IMU_CALIBRATION = "StartIMUCalibration";
  @Key(accessType=8, includedAbstractions={FlightControllerA3Abstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_IMU_CALIBRATION_WITH_ID = "StartIMUCalibrationWithID";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_IOC_MODE = "StartIOCMode";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_LANDING = "AutoLanding";
  @Key(accessType=8, type=InitializationData.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String START_SIMULATOR = "StartSimulator";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_IOC_MODE = "StopIOCMode";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STOP_SIMULATOR = "StopSimulator";
  public static final String SUBCOMPONENT_IMU_KEY = "Imu";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TAKE_OFF = "TakeOff";
  @Key(accessType=3, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4Abstraction.class, FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TERRAIN_FOLLOW_MODE_ENABLED = "TerrainFollowModeEnabled";
  @Key(accessType=4, type=Integer.class)
  public static final String TIME_NEEDED_TO_GO_HOME = "TimeNeededToGoHome";
  @Key(accessType=4, type=Integer.class)
  public static final String TIME_NEEDED_TO_LAND_FROM_CURRENT_HEIGHT = "TimeNeededToLandFromCurrentHeight";
  @Key(accessType=6, includedAbstractions={FlightControllerFoldingDroneAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRACKING_MAXIMUM_SPEED = "TrackingMaximumSpeed";
  @Key(accessType=4, includedAbstractions={FlightControllerFoldingDroneAbstraction.class}, type=Integer.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TRACKING_SPEED_THRESHOLD = "TrackingSpeedThreshold";
  @Key(accessType=6, includedAbstractions={FlightControllerFoldingDroneAbstraction.class, FlightControllerPhantom4PAbstraction.class, FlightControllerInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRIPOD = "Tripod";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TURN_OFF_MOTORS = "TurnOffMotors";
  @Key(accessType=8, excludedAbstractions={FlightControllerA2Abstraction.class}, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String TURN_ON_MOTORS = "TurnOnMotors";
  @Key(accessType=4, type=Boolean.class)
  public static final String ULTRASONIC_ERROR = "UltrasonicError";
  @Key(accessType=4, type=Float.class)
  public static final String ULTRASONIC_HEIGHT_IN_METERS = "UltrasonicHeightInMeters";
  @Key(accessType=4, type=Float.class)
  public static final String VELOCITY_X = "VelocityX";
  @Key(accessType=4, type=Float.class)
  public static final String VELOCITY_Y = "VelocityY";
  @Key(accessType=4, type=Float.class)
  public static final String VELOCITY_Z = "VelocityZ";
  @Key(accessType=6, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String VIRTUAL_STICK_CONTROL_MODE_ENABLED = "VirtualStickControlModeEnabled";
  @Key(accessType=1, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String WAYPOINT_MISSION_SPEED = "WaypointMissionSpeed";
  
  public FlightControllerKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "FlightController";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\FlightControllerKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */