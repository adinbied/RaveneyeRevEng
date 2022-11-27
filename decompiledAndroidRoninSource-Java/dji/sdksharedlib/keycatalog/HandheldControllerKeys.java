package dji.sdksharedlib.keycatalog;

import dji.common.Stick;
import dji.common.handheld.LEDCommand;
import dji.common.handheld.PowerMode;
import dji.common.handheld.RecordAndShutterButtons;
import dji.common.handheld.StickHorizontalDirection;
import dji.common.handheld.StickVerticalDirection;
import dji.common.handheld.TriggerButton;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;
import dji.sdksharedlib.hardware.abstractions.handheldcontroller.MobileHandheldControllerAbstraction;
import dji.sdksharedlib.keycatalog.extension.Key;

public class HandheldControllerKeys
  extends DJISDKCacheKeys
{
  public static final String COMPONENT_KEY = "HandheldController";
  public static final String FAKE_ACTION = "FakeAction";
  @Key(accessType=1, type=String.class, updateType=DJISDKCacheUpdateType.USER_DRIVEN)
  public static final String FULL_SERIAL_NUMBER_HASH = "FullSerialNumberHash";
  @Key(accessType=3, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=String.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String HANDHELD_NAME = "HandheldName";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=Boolean.class)
  public static final String IS_TRIGGER_BEING_PRESSED = "IsTriggerBeingPressed";
  @Key(accessType=8, includedAbstractions={MobileHandheldControllerAbstraction.class}, types={LEDCommand.class})
  public static final String LED_COMMAND = "LEDCommand";
  @Key(accessType=6, excludedAbstractions={MobileHandheldControllerAbstraction.class}, type=PowerMode.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String POWER_MODE = "PowerMode";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=RecordAndShutterButtons.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String RECORD_AND_SHUTTER_BUTTONS = "RecordAndShutterButtons";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, types={Stick.class})
  public static final String STICK = "Stick";
  @Key(accessType=6, includedAbstractions={MobileHandheldControllerAbstraction.class}, types={Boolean.class})
  public static final String STICK_GIMBAL_CONTROL_ENABLED = "StickGimbalControlEnabled";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=StickHorizontalDirection.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String STICK_HORIZONTAL_DIRECTION = "StickHorizontalDirection";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=StickVerticalDirection.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String STICK_VERTICAL_DIRECTION = "StickVerticalDirection";
  @Key(accessType=4, includedAbstractions={MobileHandheldControllerAbstraction.class}, type=TriggerButton.class, updateType=DJISDKCacheUpdateType.DYNAMIC)
  public static final String TRIGGER_BUTTON = "TriggerButton";
  
  public HandheldControllerKeys(String paramString)
  {
    super(paramString);
  }
  
  protected String getDefaultAbstractionName()
  {
    return "handHeld";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\HandheldControllerKeys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */