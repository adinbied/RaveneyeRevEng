package dji.sdksharedlib.keycatalog;

import dji.common.flightcontroller.DJIVisionDrawHeadingMode;
import dji.common.flightcontroller.DJIVisionDrawStatus;
import dji.common.flightcontroller.DJIVisionTrackHeadingMode;
import dji.common.flightcontroller.DJIVisionTrackMode;
import dji.common.flightcontroller.ObstacleDetectionSector;
import dji.common.flightcontroller.StabilizationState;
import dji.common.flightcontroller.VisionLandingProtectionState;
import dji.common.flightcontroller.VisionSystemWarning;
import dji.common.flightcontroller.flightassistant.FaceDetectionState;
import dji.common.flightcontroller.flightassistant.PalmControlState;
import dji.common.flightcontroller.flightassistant.PalmDetectionState;
import dji.common.mission.activetrack.ActiveTrackMode;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataEyeGetPushFixedWingState.FixedWingState;
import dji.midware.data.model.P3.DataSingleVisualParam.DrawMode;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant.IntelligentFlightAssistant1860Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant.IntelligentFlightAssistantInspire2Abstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant.IntelligentFlightAssistantMavicProAbstraction;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.flightassistant.IntelligentFlightAssistantPhantom4ProAbstraction;
import dji.sdksharedlib.keycatalog.extension.Key;

public class IntelligentFlightAssistantKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=3, type=Boolean.class)
  public static final String ACTIVE_BACKWARD_FLYING_ENABLED = "ActiveBackwardFlyingEnabled";
  @Key(accessType=4, type=Boolean.class)
  public static final String ACTIVE_OBSTACLE_AVOIDANCE_ENABLED = "ActiveAvoidanceEnabled";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ACTIVE_TRACK_CIRCULAR_SPEED = "ActiveTrackCircularSpeed";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ACTIVE_TRACK_GESTURE_MODE_ENABLED = "ActiveTrackGestureModeEnabled";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ACTIVE_TRACK_GPS_ASSISTANT_ENABLED = "ActiveTrackGPSAssistantEnabled";
  @Key(accessType=7, type=ActiveTrackMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String ACTIVE_TRACK_MODE = "ActiveTrackMode";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ADVANCED_GO_HOME_ENABLED = "AdvancedGoHomeEnabled";
  public static final String ADVANCED_GO_HOME_STATE = "AdvancedGoHomeState";
  @Key(accessType=3, includedAbstractions={IntelligentFlightAssistantInspire2Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class, IntelligentFlightAssistantPhantom4ProAbstraction.class, IntelligentFlightAssistant1860Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String COLLISION_AVOIDANCE_ENABLED = "CollisionAvoidanceEnabled";
  public static final String COMPONENT_KEY = "IntelligentFlightAssistant";
  @Key(accessType=4, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class}, type=ObstacleDetectionSector[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String DETECTION_SECTORS = "DetectionSectors";
  @Key(accessType=4, type=FaceDetectionState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FACE_DETECTION_STATE = "FaceDetectionState";
  @Key(accessType=3, type=DJIVisionDrawHeadingMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_DRAW_HEADING_MODE = "FlightControllerDrawHeadingMode";
  @Key(accessType=7, type=DataSingleVisualParam.DrawMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_DRAW_MODE = "FlightControllerDrawMode";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_DRAW_SPEED = "FlightControllerDrawSpeed";
  @Key(accessType=4, type=DJIVisionDrawStatus.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_DRAW_STATUS = "FlightControllerDrawStatus";
  @Key(accessType=4, type=DataEyeGetPushFixedWingState.FixedWingState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_FIXEDWING_STATE = "FlightControllerFixedWingState";
  @Key(accessType=6, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_FIXWING_GIMBALCTRL = "FlightControllerFixWingGimbalCtrl";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FLIGHT_CONTROLLER_HOMING_SENSE_ON = "FlightControllerHomingSenseOn";
  public static final String FLIGHT_CONTROLLER_IS_IN_ADVANCED_GO_HOME = "FlightControllerIsInAdvancedGoHome";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_IS_IN_DRAW = "FlightControllerIsInDraw";
  public static final String FLIGHT_CONTROLLER_IS_IN_PRECISE_LANDING = "IsInPreciseLanding";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_IS_IN_TAPFLY = "FlightControllerIsInTapFly";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_IS_IN_TRACKING = "FlightControllerIsInTracking";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_IS_MOVINGEOBJ_DETECT = "FlightControllerIsMovingObjDetect";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_SELFIE_GPS = "FlightControllerSelfieGPS";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TAPFLY_RC_GIMBALCTRL = "FlightControllerTapFlyRcGimbalCtrl";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TAPFLY_SPEED = "FlightControllerTapFlySpeed";
  @Key(accessType=3, type=Float.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TRACK_CIRCLEY = "FlightControllerTrackCircleY";
  @Key(accessType=3, type=DJIVisionTrackHeadingMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TRACK_HEADING_MODE = "FlightControllerTrackHeadingMode";
  @Key(accessType=3, type=DJIVisionTrackMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_TRACK_MODE = "FlightControllerTrackMode";
  @Key(accessType=4, type=Long.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String FLIGHT_CONTROLLER_VISION_VERSION = "FlightControllerVisionVersion";
  @Key(accessType=7, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GO_HOME_AVOIDANCE_ENABLED = "VisionGHAVoidEnabled";
  @Key(accessType=4, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantInspire2Abstraction.class}, type=StabilizationState.class)
  public static final String INTELLIGENT_FLIGHT_ASSISTANT_STABILIZATION_STATE = "StabilizationState";
  public static final String INTELLIGENT_FLIGHT_ASSISTANT_VISION_ASSISTANT_STATUS = "IntelligentFlightAssistantVisionAssistantStatus";
  @Key(accessType=4, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_BRAKING = "IsBraking";
  @Key(accessType=4, type=Boolean.class)
  public static final String IS_PERFORMING_PRECISION_LANDING = "PreciseLandingState";
  @Key(accessType=4, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_SENSOR_WORKING = "IsSensorWorking";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String IS_TRACKING = "IsTracking";
  @Key(accessType=7, type=Boolean.class)
  public static final String IS_USERAVOID_ENABLE = "IsUserAvoidEnable";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LANDING_PROTECTION_ENABLED = "LandingProtectionEnabled";
  @Key(accessType=4, type=VisionLandingProtectionState.class)
  public static final String LANDING_PROTECTION_STATE = "LandingProtectionState";
  @Key(accessType=3, type=Boolean.class)
  public static final String PALM_CONTROL_ENABLED = "HandGestureEnabled";
  @Key(accessType=4, type=PalmControlState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String PALM_CONTROL_STATE = "PalmControlState";
  @Key(accessType=4, type=PalmDetectionState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String PALM_DETECTION_STATE = "PalmDetectionState";
  public static final String PRECISE_LANDING_STATE = "PreciseLandingState";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PRECISION_LANDING_ENABLED = "PreciseLandingEnabled";
  public static final String PRECISION_MODE_ENABLED = "PrecisionModeEnabled";
  @Key(accessType=2, type=DataCameraGetPushStateInfo.CameraType.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SET_ACTIVE_TRACK_CAMERA = "setActiveTrackCamera";
  @Key(accessType=2, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STABILIZATION_ENABLED = "stabilization";
  @Key(accessType=3, includedAbstractions={IntelligentFlightAssistantInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String UPWARDS_AVOIDANCE_ENABLED = "RoofAvoidance";
  @Key(accessType=3, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class, IntelligentFlightAssistantPhantom4ProAbstraction.class, IntelligentFlightAssistantInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String VISION_ASSISTED_POSITIONING_ENABLED = "VisionPositioningEnabled";
  @Key(accessType=4, includedAbstractions={IntelligentFlightAssistant1860Abstraction.class, IntelligentFlightAssistantMavicProAbstraction.class}, type=VisionSystemWarning.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String VISION_SYSTEM_WARNING = "VisionSystemWarning";
  public static final String waypointProtocol_AVOIDANCE_ENABLED = "RthCollisionAvoidanceEnabled";
  
  public IntelligentFlightAssistantKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "IntelligentFlightAssistant";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\IntelligentFlightAssistantKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */