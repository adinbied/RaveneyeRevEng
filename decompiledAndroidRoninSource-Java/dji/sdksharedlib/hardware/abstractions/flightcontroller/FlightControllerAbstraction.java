package dji.sdksharedlib.hardware.abstractions.flightcontroller;

import dji.common.error.DJIError;
import dji.common.error.DJIFlightControllerError;
import dji.common.flightcontroller.CompassCalibrationState;
import dji.common.flightcontroller.FlightOrientationMode;
import dji.common.flightcontroller.GoHomeExecutionState;
import dji.common.flightcontroller.RCSwitchFlightMode;
import dji.common.flightcontroller.imu.CalibrationState;
import dji.common.flightcontroller.imu.IMUState;
import dji.common.flightcontroller.virtualstick.FlightControlData;
import dji.common.flightcontroller.virtualstick.FlightCoordinateSystem;
import dji.common.flightcontroller.virtualstick.RollPitchControlMode;
import dji.common.flightcontroller.virtualstick.VerticalControlMode;
import dji.common.flightcontroller.virtualstick.YawControlMode;
import dji.common.model.LocationCoordinate2D;
import dji.common.util.CallbackUtils;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DJIFlycParamInfoManager;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.data.model.P3.DataFlycActiveStatus;
import dji.midware.data.model.P3.DataFlycDownloadWayPointMissionMsg;
import dji.midware.data.model.P3.DataFlycFunctionControl.FLYC_COMMAND;
import dji.midware.data.model.P3.DataFlycGetPushParamsByHash;
import dji.midware.data.model.P3.DataOsdGetPushCommon.FLYC_STATE;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import dji.midware.data.model.P3.DataSimulatorGetPushConnectHeartPacket;
import dji.midware.data.model.P3.DataSimulatorGetPushFlightStatusParams;
import dji.midware.data.model.common.DataCommonActiveGetVer;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.Action;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.OnValueChangeListener;
import dji.sdksharedlib.hardware.abstractions.Getter;
import dji.sdksharedlib.hardware.abstractions.Setter;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.MergeGetFlycParamInfo;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.MergeGetNewFlyParamInfo;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.MergeSetFlyParamInfo;
import dji.sdksharedlib.hardware.abstractions.flightcontroller.merge.ParamInfoCallBack;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import dji.sdksharedlib.util.DJICompletionHelper;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class FlightControllerAbstraction
  extends DJISDKCacheHWAbstraction
{
  private static final float AIRPORT_WARNING_MAX_HEIGHT = 120.0F;
  private static final int ATTI = 1;
  private static final int CLICKGO = 7;
  private static final int COURSE_LOCK = 0;
  private static final int DRAW = 18;
  private static final int GOHOME = 4;
  private static final int HOME_LOCK = 1;
  private static final String[] IMU_CALC_STAT_ALL = { "g_status.all_gyr_acc.msc_current_side_0", "g_status.all_gyr_acc.msc_sampled_side_0", "g_config.gyr_acc_cfg.msc_require_side_0", "g_status.all_gyr_acc.cali_state_0", "g_status.all_gyr_acc.cali_cnt_0", "g_status.all_gyr_acc.need_cali_type_0" };
  private static final String INTERNAL_FIRMWARE_VERSION_TURN = "03.01";
  private static final int JOYSTICK = 5;
  private static final int LANDING = 2;
  private static final int MANUAL = 0;
  private static final int MAX_IMU_COUNT = 3;
  private static final int NAVI = 6;
  private static final int NOVICE = 17;
  private static final int N_A = 255;
  private static final int POINTING = 15;
  private static final int P_ATTI = 8;
  private static final int P_GPS = 10;
  private static final int P_LOCK = 2;
  private static final int P_POTI = 9;
  private static final int SPORT = 16;
  private static String TAG = "DJIFlightControllerAbstraction";
  private static final int TAKEOFF = 3;
  private static final int TRACKING = 14;
  private final String[] IMU_CALC_STAT_CONFIG_ONLY_ONE = { "imu_app_temp_cali.cali_cnt_0", "imu_app_temp_cali.state_0" };
  private final String[] IMU_CALC_STAT_CONFIG_WITH_THREE = { "imu_app_temp_cali.state_0", "g_status.acc_gyro[0].state_0", "g_status.acc_gyro[1].state_0", "g_status.acc_gyro[2].state_0", "g_status.acc_gyro[0].cali_cnt_0", "g_status.acc_gyro[1].cali_cnt_0", "g_status.acc_gyro[2].cali_cnt_0", "g_config.fdi_sensor[0].gyr_stat_0", "g_config.fdi_sensor[1].gyr_stat_0", "g_config.fdi_sensor[2].gyr_stat_0", "g_config.fdi_sensor[0].acc_stat_0", "g_config.fdi_sensor[1].acc_stat_0", "g_config.fdi_sensor[2].acc_stat_0" };
  private final String[] IMU_CALC_STAT_CONFIG_WITH_TWO = { "imu_app_temp_cali.state_0", "g_status.acc_gyro[0].state_0", "g_status.acc_gyro[1].state_0", "g_status.acc_gyro[0].cali_cnt_0", "g_status.acc_gyro[1].cali_cnt_0", "g_config.fdi_sensor[0].gyr_stat_0", "g_config.fdi_sensor[1].gyr_stat_0", "g_config.fdi_sensor[0].acc_stat_0", "g_config.fdi_sensor[1].acc_stat_0" };
  private boolean hasCompassCalibrationRecorded = false;
  private boolean hasSimulatorStarted = false;
  private boolean hasStartedCalibration = false;
  private DJICompletionHelper helper = DJICompletionHelper.getInstance();
  protected int imuCount = 3;
  protected int internalFCVerion = -1;
  protected int isBeginnerMode = -1;
  private boolean isHomePointAltitudeSetted;
  private boolean isInitialHomePointSet = false;
  private CompassCalibrationState lastCalibrationStatus = CompassCalibrationState.NOT_CALIBRATING;
  private long lastGetNaviPushTimeStamp;
  private GoHomeExecutionState lastGoHomeStatus = GoHomeExecutionState.NOT_EXECUTING;
  protected MergeGetFlycParamInfo mergeGetFlycParamInfo;
  protected MergeSetFlyParamInfo mergeSetFlyParamInfo;
  protected MergeGetNewFlyParamInfo newMergeGetFlycParamInfo;
  protected int previousRCSwitchPosition = -1;
  private Timer simulatorTimer;
  private SimulatorInternalState state = SimulatorInternalState.Disconnected;
  
  /* Error */
  private void cancelFlightOrientationMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private FlightControlData checkSwapYawAndThrottle(FlightControlData paramFlightControlData)
  {
    return null;
  }
  
  /* Error */
  private void enterNavigationMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void exitNavigationMode(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private float get(DataSimulatorGetPushFlightStatusParams paramDataSimulatorGetPushFlightStatusParams, int paramInt)
  {
    return 0.0F;
  }
  
  /* Error */
  private void getBatteryWarning(dji.midware.data.model.P3.DataFlycGetVoltageWarnning.WarnningLevel arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private byte getControlModeFlag(VerticalControlMode paramVerticalControlMode, RollPitchControlMode paramRollPitchControlMode, YawControlMode paramYawControlMode, FlightCoordinateSystem paramFlightCoordinateSystem, boolean paramBoolean)
  {
    return (byte)((byte)(paramRollPitchControlMode.value() << 6) + (byte)(paramVerticalControlMode.value() << 4) + (byte)(paramYawControlMode.value() << 3) + (byte)(paramFlightCoordinateSystem.value() << 1) + (byte)paramBoolean);
  }
  
  static DJIFlightControllerError getDJIErrorByCode(int paramInt)
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
                          return null;
                        case 244: 
                          return DJIFlightControllerError.MISSION_RESULT_WRONG_CMD;
                        case 243: 
                          return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_STARTING_MOTOR;
                        case 242: 
                          return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_GOINGHOME;
                        case 241: 
                          return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_LANDING;
                        }
                        return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_TAKINGOFF;
                      case 238: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_IDLE_VELOCITY_INVALID;
                      case 237: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_NOT_RUNNING;
                      case 236: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_REQUEST_IS_RUNNING;
                      case 235: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_UPLOAD_NOT_COMPLETE;
                      case 234: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_MISSION_INFO_NOT_UPLOADED;
                      case 233: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_UPLOADING;
                      case 232: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_ACTION_PARAM_INVALID;
                      case 231: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_DAMPING_CHECK_FAILED;
                      case 230: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_DISTANCE_TOO_LONG;
                      case 229: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_DISTANCE_TOO_CLOSE;
                      case 228: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_INDEX_OVERRANGE;
                      case 227: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_TOTAL_TRACE_TOO_LONG;
                      case 226: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_TRACE_TOO_LONG;
                      case 225: 
                        return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_INFO_INVALID;
                      case 224: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_INFO_INVALID;
                      case 223: 
                        return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_IN_NOFLYZONE;
                      case 222: 
                        return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_NOT_RECORDED;
                      case 221: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_ACROSS_NOFLYZONE;
                      case 220: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_CONDITION_NOT_SATISFIED;
                      case 219: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_PARAM_INVALID;
                      case 218: 
                        return DJIFlightControllerError.MISSION_RESULT_AIRCRAFT_NOT_IN_THE_AIR;
                      case 217: 
                        return DJIFlightControllerError.MISSION_RESULT_LOW_BATTERY;
                      case 216: 
                        return DJIFlightControllerError.MISSION_RESULT_GPS_SIGNAL_WEAK;
                      case 215: 
                        return DJIFlightControllerError.MISSION_RESULT_HIGH_PRIORITY_MISSION_EXECUTING;
                      case 214: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_ESTIMATE_TIME_TOO_LONG;
                      case 213: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_CONFLICT;
                      case 212: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_NOT_EXIST;
                      case 211: 
                        return DJIFlightControllerError.MISSION_RESULT_MISSION_NOT_INIT;
                      case 210: 
                        return DJIFlightControllerError.MISSION_RESULT_IOC_WORKING;
                      case 209: 
                        return DJIFlightControllerError.MISSION_RESULT_NAVIGATION_IS_NOT_OPEN;
                      }
                      return DJIFlightControllerError.MISSION_RESULT_RC_MODE_ERROR;
                    case 202: 
                      return DJIFlightControllerError.MISSION_RESULT_IN_NOVICE_MODE;
                    case 201: 
                      return DJIFlightControllerError.MISSION_RESULT_DISTANCE_FROM_MISSION_TARGET_TOO_LONG;
                    case 200: 
                      return DJIFlightControllerError.MISSION_RESULT_UNSUPPORTED_NAVIGATION_FOR_THE_PRODUCT;
                    case 199: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_RADIUS_OVERLIMITED;
                    case 198: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_RESUME_FAILED;
                    case 197: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_HEADING_MODE_INVALID;
                    case 196: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_ENTRYPOINT_INVALID;
                    case 195: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_SPEED_TOO_LARGE;
                    case 194: 
                      return DJIFlightControllerError.MISSION_RESULT_MISSION_RADIUS_INVALID;
                    case 193: 
                      return DJIFlightControllerError.MISSION_RESULT_ALTITUDE_TOO_LOW;
                    }
                    return DJIFlightControllerError.MISSION_RESULT_ALTITUDE_TOO_HIGH;
                  case 178: 
                    return DJIFlightControllerError.MISSION_RESULT_FOLLOWME_GIMBAL_PITCH_ERROR;
                  case 177: 
                    return DJIFlightControllerError.MISSION_RESULT_FOLLOWME_DISCONNECT_TIME_TOO_LONG;
                  }
                  return DJIFlightControllerError.MISSION_RESULT_FOLLOWME_DISTANCE_TOO_LARGE;
                case 163: 
                  return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_LOCATION_INVALID;
                case 162: 
                  return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_VALUE_INVALID;
                case 161: 
                  return DJIFlightControllerError.MISSION_RESULT_IOC_TYPE_UNKNOWN;
                }
                return DJIFlightControllerError.MISSION_RESULT_TOO_CLOSE_TO_HOMEPOINT;
              case 13: 
                return DJIFlightControllerError.MISSION_RESULT_KEY_LEVEL_LOW;
              case 12: 
                return DJIFlightControllerError.MISSION_RESULT_WAYPOINT_UPLOADING;
              case 11: 
                return DJIFlightControllerError.MISSION_RESULT_UPLOAD_WAYPOINT_NUM_MAX_LIMIT;
              case 10: 
                return DJIFlightControllerError.MISSION_RESULT_NOT_AUTO_MODE;
              case 9: 
                return DJIFlightControllerError.MISSION_RESULT_IS_FLYING;
              case 8: 
                return DJIFlightControllerError.MISSION_RESULT_TAKEOFF;
              case 7: 
                return DJIFlightControllerError.MISSION_RESULT_MOTOR_NOT_START;
              case 6: 
                return DJIFlightControllerError.MISSION_RESULT_GPS_NOT_READY;
              case 5: 
                return DJIFlightControllerError.MISSION_RESULT_MODE_ERROR;
              case 4: 
                return DJIFlightControllerError.MISSION_RESULT_TIMEOUT;
              case 3: 
                return DJIFlightControllerError.MISSION_RESULT_FAILED;
              case 2: 
                return DJIFlightControllerError.MISSION_RESULT_CANCELED;
              }
              return DJIFlightControllerError.MISSION_RESULT_BEGAN;
            }
            return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_NOT_PAUSED;
          }
          return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_PAUSED;
        }
        return DJIFlightControllerError.MISSION_RESULT_UNKNOWN;
      }
      return DJIFlightControllerError.MISSION_RESULT_HOMEPOINT_DIRECTION_UNKNOWN;
    }
    return DJIFlightControllerError.MISSION_RESULT_NAVIGATION_IS_NOT_OPEN;
  }
  
  private int[] getFlycModeResId(DataOsdGetPushCommon.FLYC_STATE paramFLYC_STATE, boolean paramBoolean)
  {
    return null;
  }
  
  private int getGpsLevelForOldFlightController(int paramInt)
  {
    return 0;
  }
  
  private String[] getImuCaliParam()
  {
    return null;
  }
  
  /* Error */
  private void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getSubIMUCalibrateState(IMUState arg1, int arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean guardrailsForHomePoint(LocationCoordinate2D paramLocationCoordinate2D)
  {
    return false;
  }
  
  private boolean isOldMC()
  {
    return false;
  }
  
  /* Error */
  private void readFirstImuState(IMUState arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readSecondImuState(IMUState arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readTheOnlyOneImuState(IMUState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readThirdImuState(IMUState arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendImuCalibrationCmd(String[] arg1, Number[] arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setBatteryWarning(int arg1, dji.midware.data.model.P3.DataFlycGetVoltageWarnning.WarnningLevel arg2, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private RCSwitchFlightMode translateRcChannelIntoMode(DataOsdGetPushCommon.RcModeChannel paramRcModeChannel)
  {
    return null;
  }
  
  @Action("AutoLanding")
  public void autoLanding(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.AUTO_LANDING, paramInnerCallback);
  }
  
  public boolean canTakeOff()
  {
    return false;
  }
  
  @Action("CancelAutoLanding")
  public void cancelAutoLanding(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.DropLanding, paramInnerCallback);
  }
  
  @Action("CancelGoHome")
  public void cancelGoHome(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.DropGohome, paramInnerCallback);
  }
  
  /* Error */
  @Action("CancelTakeOff")
  public void cancelTakeOff(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("CompassStartCalibration")
  public void compassStartCalibration(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.Calibration, paramInnerCallback);
  }
  
  @Action("CompassStopCalibration")
  public void compassStopCalibration(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.DropCalibration, paramInnerCallback);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("AircraftName")
  public void getAircraftName(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback) {}
  
  /* Error */
  @Getter("AutoLandingGear")
  public void getAutoLandingGear(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("AutoLandingGearGroundNotify")
  public void getAutoLandingGearGroundNotify(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("Enable1860")
  public void getEnableStateOf1860(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FirmwareVersion")
  public void getFirmwareVersion(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("FlightFailSafeOperation")
  public void getFlightFailSafeOperation(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("FullSerialNumberHash")
  public void getFullSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 2);
  }
  
  /* Error */
  @Getter("GeoFeatureInSimulatorEnabled")
  public void getGeoFeatureInSimulatorEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("GoHomeAltitude")
  public void getGoHomeAltitude(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("HomeLocation")
  public void getHomeLocation(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("IMUState")
  public void getIMUMultiSideCalibrationState(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("InternalSerialNumber")
  public void getInternalSerialNumber(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("isVirtualStickControlModeAvailable")
  public void getIsVirtualStickControlModeAvailiable(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  @Getter("LEDsEnabled")
  public void getLedsEnables(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("MaxFlightHeight")
  public void getMaxFlightHeight(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("MaxFlightRadius")
  public void getMaxFlightRadius(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("MaxFlightRadiusEnabled")
  public void getMaxFlightRadiusEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("Mode")
  public void getModes(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("MultiLEDsEnabled")
  public void getMultiLedsEnables(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigRcScaleInAvoidance")
  public void getRcScaleInAvoidance(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigRcScaleInNormal")
  public void getRcScaleInNormal(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigRcScaleInSport")
  public void getRcScaleInSport(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Getter("SerialNumber")
  public void getSerialNumber(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    getSerialNumber(paramInnerCallback, 0);
  }
  
  /* Error */
  @Getter("TerrainFollowModeEnabled")
  public void getTerrainModeEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("WaypointMissionSpeed")
  public void getWaypointMissionSpeed(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigYawRateInAvoidance")
  public void getYawRateInAvoidance(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigYawRateInNormal")
  public void getYawRateInNormal(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Getter("ConfigYawRateInSport")
  public void getYawRateInSport(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("GoHome")
  public void goHome(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.GOHOME, paramInnerCallback);
  }
  
  /* Error */
  @Action("HomeLocationUsingCurrentAircraftLocation")
  public void homeLocationUsingCurrentAircraftLocation(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(String paramString, int paramInt, DJISDKCacheStoreLayer paramDJISDKCacheStoreLayer, DJISDKCacheHWAbstraction.OnValueChangeListener paramOnValueChangeListener)
  {
    super.init(paramString, paramInt, paramDJISDKCacheStoreLayer, paramOnValueChangeListener);
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
    initFlightControllerSupportParameter();
    this.mergeGetFlycParamInfo = MergeGetFlycParamInfo.getInstance();
    this.newMergeGetFlycParamInfo = MergeGetNewFlyParamInfo.getInstance();
    this.mergeSetFlyParamInfo = new MergeSetFlyParamInfo();
  }
  
  /* Error */
  protected void initFlightControllerSupportParameter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void initializeComponentCharacteristics()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract boolean isNewProgressOfActivation();
  
  /* Error */
  @Getter("ConfigRTHInCurrentAltitude")
  public void isRTHInCurrentAltitudeEnabled(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("LockCourseUsingCurrentDirection")
  public void lockCourseUsingCurrentDirection(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND.HOMEPOINT_LOC, paramInnerCallback);
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushAvoid arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushAvoidParam arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushFlycInstallError arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataFlycGetPushParamsByHash paramDataFlycGetPushParamsByHash)
  {
    updateIMUState(paramDataFlycGetPushParamsByHash);
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushSmartBattery arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataFlycGetPushWayPointMissionInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.ASYNC)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataOsdGetPushHome arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataRcGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataSimulatorGetPushConnectHeartPacket paramDataSimulatorGetPushConnectHeartPacket) {}
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataSimulatorGetPushFlightStatusParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("PauseTerrainFollowMode")
  public void pauseTerrainFollow(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("ResumeTerrainFollowMode")
  public void resumeTerrainFollow(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("SendDataToOnboardSDKDevice")
  public void sendDataToOnBoardSdkDevice(DJISDKCacheHWAbstraction.InnerCallback arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void sendFlightControllerCommand(DataFlycFunctionControl.FLYC_COMMAND arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("SendVirtualStickFlightControlData")
  public void sendVirtualStickFlightControlData(DJISDKCacheHWAbstraction.InnerCallback arg1, FlightControlData arg2, VerticalControlMode arg3, RollPitchControlMode arg4, YawControlMode arg5, FlightCoordinateSystem arg6, boolean arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("AircraftName")
  public void setAircraftName(String paramString, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback) {}
  
  /* Error */
  @Setter("AutoLandingGear")
  public void setAutoLandingGear(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("AutoLandingGearGroundNotify")
  public void setAutoLandingGearGroundNotify(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("Enable1860")
  public void setEnableStateOf1860(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("FlightFailSafeOperation")
  public void setFlightFailSafeOperation(dji.common.flightcontroller.ConnectionFailSafeBehavior arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("FlightOrientationMode")
  public void setFlightOrientationMode(FlightOrientationMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("GeoFeatureInSimulatorEnabled")
  public void setGeoFeatureInSimulatorEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("GoHomeAltitude")
  public void setGoHomeAltitude(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("GoHomeBatteryThreshold")
  public void setGoHomeBatteryThreshold(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("HomeLocation")
  public void setHomeLocation(LocationCoordinate2D arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("LandImmediatelyBatteryThreshold")
  public void setLandImmediatelyBatteryThreshold(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("LEDsEnabled")
  public void setLedsEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("MaxFlightHeight")
  public void setMaxFlightHeight(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("MaxFlightRadius")
  public void setMaxFlightRadius(double arg1, DJISDKCacheHWAbstraction.InnerCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("MaxFlightRadiusEnabled")
  public void setMaxFlightRadiusEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("MultiLEDsEnabled")
  public void setMultiLedsEnabled(dji.common.flightcontroller.DJIMultiLEDControlMode arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Setter("NavigationModeEnabled")
  public void setNavigationModeEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramBoolean)
    {
      enterNavigationMode(paramInnerCallback);
      return;
    }
    exitNavigationMode(paramInnerCallback);
  }
  
  /* Error */
  @Setter("ConfigRTHInCurrentAltitude")
  public void setRTHInCurrentAltitudeEnabled(Boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ConfigRcScaleInAvoidance")
  public void setRcScaleInAvoidance(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ConfigRcScaleInNormal")
  public void setRcScaleInNormal(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ConfigRcScaleInSport")
  public void setRcScaleInSport(float arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("TerrainFollowModeEnabled")
  public void setTerrainFollowEnabled(Boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("Tripod")
  public void setTripodModeEnabled(boolean arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  @Setter("VirtualStickControlModeEnabled")
  public void setVirtualStickControlModeEnabled(boolean paramBoolean, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    setNavigationModeEnabled(paramBoolean, paramInnerCallback);
  }
  
  /* Error */
  @Setter("ConfigYawRateInAvoidance")
  public void setYawRateInAvoidance(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ConfigYawRateInNormal")
  public void setYawRateInNormal(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Setter("ConfigYawRateInSport")
  public void setYawRateInSport(int arg1, DJISDKCacheHWAbstraction.InnerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("confirmLanding")
  public void startForceLanding(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StartIMUCalibration")
  public void startImuCalibration(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Action("StartIMUCalibrationWithID")
  public void startImuCalibrationWithID(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, int paramInt)
  {
    CallbackUtils.onFailure(paramInnerCallback, DJIError.COMMON_UNSUPPORTED);
  }
  
  /* Error */
  @Action("StartSimulator")
  public void startSimulator(DJISDKCacheHWAbstraction.InnerCallback arg1, dji.common.flightcontroller.simulator.InitializationData arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("StopSimulator")
  public void stopSimulator(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void syncPushDataFromMidware()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("TakeOff")
  public void takeOff(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("TurnOffMotors")
  public void turnOffMotors(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Action("TurnOnMotors")
  public void turnOnMotors(DJISDKCacheHWAbstraction.InnerCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected CalibrationState updateIMUCaliStatus(String paramString)
  {
    return CalibrationState.convertIMUCalibrationStatus(DJIFlycParamInfoManager.read(paramString).value.intValue());
  }
  
  /* Error */
  protected void updateIMUState(DataFlycGetPushParamsByHash arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class HeartPinTimerTask
    extends TimerTask
  {
    private HeartPinTimerTask() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static enum SimulatorInternalState
  {
    static
    {
      Connected = new SimulatorInternalState("Connected", 1);
      Starting = new SimulatorInternalState("Starting", 2);
      ResponseReceived = new SimulatorInternalState("ResponseReceived", 3);
      Running = new SimulatorInternalState("Running", 4);
      Stopping = new SimulatorInternalState("Stopping", 5);
      SimulatorInternalState localSimulatorInternalState = new SimulatorInternalState("Stopped", 6);
      Stopped = localSimulatorInternalState;
      $VALUES = new SimulatorInternalState[] { Disconnected, Connected, Starting, ResponseReceived, Running, Stopping, localSimulatorInternalState };
    }
    
    private SimulatorInternalState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\FlightControllerAbstraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */