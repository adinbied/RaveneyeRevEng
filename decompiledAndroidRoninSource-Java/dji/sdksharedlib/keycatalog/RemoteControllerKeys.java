package dji.sdksharedlib.keycatalog;

import dji.common.Stick;
import dji.common.remotecontroller.AircraftMapping;
import dji.common.remotecontroller.AircraftMappingStyle;
import dji.common.remotecontroller.AuthorizationInfo;
import dji.common.remotecontroller.ChargeMobileMode;
import dji.common.remotecontroller.ChargeRemaining;
import dji.common.remotecontroller.Credentials;
import dji.common.remotecontroller.CustomButtonTags;
import dji.common.remotecontroller.FocusControllerState.ControlType;
import dji.common.remotecontroller.FocusControllerState.Direction;
import dji.common.remotecontroller.GPSData;
import dji.common.remotecontroller.GimbalAxis;
import dji.common.remotecontroller.GimbalControlSpeedCoefficient;
import dji.common.remotecontroller.GimbalMapping;
import dji.common.remotecontroller.GimbalMappingStyle;
import dji.common.remotecontroller.HardwareState.Button;
import dji.common.remotecontroller.HardwareState.FiveDButton;
import dji.common.remotecontroller.HardwareState.FlightModeSwitch;
import dji.common.remotecontroller.HardwareState.RightWheel;
import dji.common.remotecontroller.HardwareState.TransformationSwitch;
import dji.common.remotecontroller.Information;
import dji.common.remotecontroller.JoinMasterParams;
import dji.common.remotecontroller.MasterSlaveState;
import dji.common.remotecontroller.PairingState;
import dji.common.remotecontroller.RCMode;
import dji.common.remotecontroller.RequestGimbalControlResult;
import dji.common.remotecontroller.ResponseForGimbalControl;
import dji.midware.data.model.P3.DataRcSetAppSpecialControl.RcAircraftType;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.remotecontroller.DJIRCFoldingDroneAbstraction;
import dji.sdksharedlib.hardware.abstractions.remotecontroller.DJIRCInspire2Abstraction;
import dji.sdksharedlib.keycatalog.extension.Key;
import java.util.ArrayList;

public class RemoteControllerKeys
  extends DJISDKCacheKeys
{
  @Key(accessType=3, type=AircraftMapping.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AIRCRAFT_CUSTOM_MAPPING = "AircraftCustomMapping";
  @Key(accessType=3, type=AircraftMappingStyle.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String AIRCRAFT_MAPPING_STYLE = "AircraftMappingStyle";
  @Key(accessType=1, type=Information[].class)
  public static final String AVAILABLE_MASTERS = "AvailableMasters";
  @Key(accessType=3, includedAbstractions={DJIRCInspire2Abstraction.class}, type=ChargeMobileMode.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CHARGE_MOBILE_MODE = "ChargeMobileMode";
  @Key(accessType=4, type=ChargeRemaining.class)
  public static final String CHARGE_REMAINING = "ChargeRemaining";
  public static final String COMPONENT_KEY = "RemoteController";
  @Key(accessType=1, type=Credentials.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONNECTED_MASTER_CREDENTIALS = "ConnectedMasterCredentials";
  @Key(accessType=8, type=Credentials.class)
  public static final String CONNECT_TO_MASTER = "connectToMaster";
  @Key(accessType=8, includedAbstractions={DJIRCInspire2Abstraction.class}, type=AuthorizationInfo.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CONNECT_TO_MASTER_WITH_ID = "connectToMasterWithID";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String CUSTOM_BUTTON_1 = "CustomButton1";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String CUSTOM_BUTTON_2 = "CustomButton2";
  @Key(accessType=3, type=CustomButtonTags.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CUSTOM_BUTTON_TAGS = "CustomButtonTags";
  @Key(accessType=3, type=GimbalMapping.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String CUSTOM_GIMBAL_MAPPING = "CustomGimbalMapping";
  @Key(accessType=4, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String DISPLAY_NAME = "DisplayName";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String ENTER_RC_TO_AIRCRAFT_PAIRING_MODE = "EnterRCToAircraftPairingMode";
  @Key(accessType=8, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String EXIT_RC_TO_AIRCRAFT_PAIRING_MODE = "ExitRCToAircraftPairingMode";
  @Key(accessType=4, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Boolean.class)
  public static final String FIVE_DIMENS_BUTTON_PUSH_DOWN = "FiveDimensButtonPushDown";
  @Key(accessType=4, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Boolean.class)
  public static final String FIVE_DIMENS_BUTTON_PUSH_LEFT = "FiveDimensButtonPushLeft";
  @Key(accessType=4, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Boolean.class)
  public static final String FIVE_DIMENS_BUTTON_PUSH_PRESSED = "FiveDimensButtonPushPressed";
  @Key(accessType=4, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Boolean.class)
  public static final String FIVE_DIMENS_BUTTON_PUSH_RIGHT = "FiveDimensButtonPushRight";
  @Key(accessType=4, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Boolean.class)
  public static final String FIVE_DIMENS_BUTTON_PUSH_UP = "FiveDimensButtonPushUp";
  @Key(accessType=4, type=HardwareState.FiveDButton.class)
  public static final String FIVE_D_BUTTON = "FiveDButton";
  @Key(accessType=4, type=HardwareState.FlightModeSwitch.class)
  public static final String FLIGHT_MODE_SWITCH_POSITION = "FlightModeSwitchPosition";
  @Key(accessType=4, type=FocusControllerState.ControlType.class)
  public static final String FOCUS_CONTROLLER_CONTROL_TYPE = "FocusControllerControlType";
  @Key(accessType=4, type=FocusControllerState.Direction.class)
  public static final String FOCUS_CONTROLLER_DIRECTION = "FocusControllerDirection";
  @Key(accessType=4, type=Boolean.class)
  public static final String FOCUS_CONTROLLER_IS_WORKING = "FocusControllerIsWorking";
  @Key(accessType=1, excludedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FULL_SERIAL_NUMBER_HASH = "FullSerialNumberHash";
  @Key(accessType=8, includedAbstractions={DJIRCInspire2Abstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String GET_MASTER_AUTH_CODE = "GetMasterAuthCode";
  @Key(accessType=1, type=PairingState.class)
  public static final String GET_PAIRING_STATE = "GetPairingState";
  @Key(accessType=1, type=GimbalControlSpeedCoefficient.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_CONTROL_SPEED_COEFFICIENT = "GimbalControlSpeedCoefficient";
  @Key(accessType=3, type=GimbalMappingStyle.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String GIMBAL_MAPPING_STYLE = "GimbalMappingStyle";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String GO_HOME_BUTTON = "GoHomeButton";
  @Key(accessType=4, type=GPSData.class)
  public static final String GPS_DATA = "GPSData";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_FOCUS_CONTROLLER_SUPPORTED = "IsFocusControllerSupported";
  @Key(accessType=4, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_MASTER_SLAVE_MODE_SUPPORTED = "IsMasterSlaveModeSupported";
  @Key(accessType=1, includedAbstractions={DJIRCInspire2Abstraction.class}, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String IS_MASTER_SLAVE_MODE_V2_SUPPORTED = "IsMasterSlaveModeV2Supported";
  @Key(accessType=8, type=JoinMasterParams.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String JOIN_MASTER = "JoinMaster";
  @Key(accessType=4, type=Stick.class)
  public static final String LEFT_STICK_VALUE = "LeftStickValue";
  @Key(accessType=4, type=Integer.class)
  public static final String LEFT_WHEEL = "LeftWheel";
  @Key(accessType=3, excludedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=GimbalAxis.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String LEFT_WHEEL_GIMBAL_CONTROL_AXIS = "LeftWheelGimbalControlAxis";
  @Key(accessType=1, includedAbstractions={DJIRCInspire2Abstraction.class}, type=String[].class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MASTER_LIST = "MasterList";
  @Key(accessType=1, type=Boolean.class)
  public static final String MASTER_SEARCHING_STATE = "MasterSearchingState";
  @Key(accessType=3, includedAbstractions={DJIRCInspire2Abstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String MASTER_SLAVE_ID = "MasterSlaveID";
  @Key(accessType=4, includedAbstractions={DJIRCInspire2Abstraction.class}, type=MasterSlaveState.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MASTER_SLAVE_STATE = "MasterSlaveState";
  @Key(accessType=3, type=RCMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String MODE = "Mode";
  @Key(accessType=3, excludedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String NAME = "Name";
  @Key(accessType=3, excludedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String PASSWORD = "Password";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String PAUSE_BUTTON = "PauseButton";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String PLAYBACK_BUTTON = "PlaybackButton";
  @Key(accessType=3, type=DataRcSetAppSpecialControl.RcAircraftType.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RC_AIRCRAFT_TYPE = "RcAircraftType";
  @Key(accessType=3, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String RC_CALIBRATION = "RcCalibration";
  @Key(accessType=3, type=Boolean.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RC_MASTER_SLAVE_OPEN = "RcMasterSlaveOpen";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String RECORD_BUTTON = "RecordButton";
  @Key(accessType=8, includedAbstractions={DJIRCFoldingDroneAbstraction.class})
  public static final String REMOTE_CONTROLLER_CALIBRATION = "RemoteControllerCalibration";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_A_AXIS_STATUS = "RemoteControllerAAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_B_AXIS_STATUS = "RemoteControllerBAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_C_AXIS_STATUS = "RemoteControllerCAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_D_AXIS_STATUS = "RemoteControllerDAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_E_AXIS_STATUS = "RemoteControllerEAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_F_AXIS_STATUS = "RemoteControllerFAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_G_AXIS_STATUS = "RemoteControllerGAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_H_AXIS_STATUS = "RemoteControllerHAxisStatus";
  @Key(accessType=1, includedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=Integer.class)
  public static final String REMOTE_CONTROLLER_CALIBRATION_NUMBER_OF_SEGMENT = "RemoteControllerCalibrationNumberOfFragment";
  public static final String REMOTE_CONTROLLER_CALIBRATION_STATE = "RemoteControllerCalibrationState";
  @Key(accessType=1, type=RequestGimbalControlResult.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String REQUEST_GIMBAL_CONTROL = "RequestGimbalControl";
  @Key(accessType=8, type=ResponseForGimbalControl.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String RESPONSE_TO_REQUEST_FOR_GIMBAL_CONTROL = "ResponseToRequestForGimbalControl";
  @Key(accessType=4, type=Stick.class)
  public static final String RIGHT_STICK_VALUE = "RightStickValue";
  @Key(accessType=4, type=HardwareState.RightWheel.class)
  public static final String RIGHT_WHEEL = "RightWheel";
  @Key(accessType=1, excludedAbstractions={DJIRCFoldingDroneAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SERIAL_NUMBER = "SerialNumber";
  @Key(accessType=2, includedAbstractions={DJIRCInspire2Abstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String SET_MASTER_AUTH_CODE = "SetMasterAuthCode";
  @Key(accessType=4, type=HardwareState.Button.class)
  public static final String SHUTTER_BUTTON = "ShutterButton";
  @Key(accessType=1, type=Information[].class)
  public static final String SLAVE_LIST = "SlaveList";
  @Key(accessType=8)
  public static final String START_PAIRING = "StartPairing";
  @Key(accessType=8)
  public static final String START_SEARCH_MASTER = "StartSearchMaster";
  @Key(accessType=1, type=ArrayList.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String STICK_MAPPING = "StickMapping";
  @Key(accessType=8)
  public static final String STOP_MASTER_SEARCHING = "StopMasterSearching";
  @Key(accessType=8)
  public static final String STOP_PAIRING = "StopPairing";
  @Key(accessType=4, type=HardwareState.TransformationSwitch.class)
  public static final String TRANSFORMATION_SWITCH = "TransformationSwitch";
  
  public RemoteControllerKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "RemoteController";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\RemoteControllerKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */