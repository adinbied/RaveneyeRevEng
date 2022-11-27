package dji.common.airlink;

public enum OcuSyncWarningMessage
{
  static
  {
    STRONG_DOWN_LINK_INTERFERENCE = new OcuSyncWarningMessage("STRONG_DOWN_LINK_INTERFERENCE", 1);
    STRONG_UP_LINK_INTERFERENCE = new OcuSyncWarningMessage("STRONG_UP_LINK_INTERFERENCE", 2);
    WEAK_SIGNAL = new OcuSyncWarningMessage("WEAK_SIGNAL", 3);
    STRONG_INTERFERENCE_WITH_MANUAL_SETTING = new OcuSyncWarningMessage("STRONG_INTERFERENCE_WITH_MANUAL_SETTING", 4);
    WEAK_SIGNAL_FROM_REMOTE_CONTROLLER_TO_GLASS = new OcuSyncWarningMessage("WEAK_SIGNAL_FROM_REMOTE_CONTROLLER_TO_GLASS", 5);
    WEAK_SIGNAL_FROM_GLASS_TO_REMOTE_CONTROLLER = new OcuSyncWarningMessage("WEAK_SIGNAL_FROM_GLASS_TO_REMOTE_CONTROLLER", 6);
    DEBUG = new OcuSyncWarningMessage("DEBUG", 7);
    AIRCRAFT_LINK_REBOOT = new OcuSyncWarningMessage("AIRCRAFT_LINK_REBOOT", 8);
    UP_LINK_BROKEN = new OcuSyncWarningMessage("UP_LINK_BROKEN", 9);
    DOWN_LINK_BROKEN = new OcuSyncWarningMessage("DOWN_LINK_BROKEN", 10);
    OcuSyncWarningMessage localOcuSyncWarningMessage = new OcuSyncWarningMessage("LINK_UNUSABLE", 11);
    LINK_UNUSABLE = localOcuSyncWarningMessage;
    $VALUES = new OcuSyncWarningMessage[] { STRONG_TAKE_OFF_INTERFERENCE, STRONG_DOWN_LINK_INTERFERENCE, STRONG_UP_LINK_INTERFERENCE, WEAK_SIGNAL, STRONG_INTERFERENCE_WITH_MANUAL_SETTING, WEAK_SIGNAL_FROM_REMOTE_CONTROLLER_TO_GLASS, WEAK_SIGNAL_FROM_GLASS_TO_REMOTE_CONTROLLER, DEBUG, AIRCRAFT_LINK_REBOOT, UP_LINK_BROKEN, DOWN_LINK_BROKEN, localOcuSyncWarningMessage };
  }
  
  private OcuSyncWarningMessage() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\OcuSyncWarningMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */