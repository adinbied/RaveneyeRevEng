package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIRemoteControllerError
  extends DJIError
{
  public static final DJIRemoteControllerError FIRMWARE_CRC_WRONG;
  public static final DJIRemoteControllerError FIRMWARE_LENGTH_WRONG;
  public static final DJIRemoteControllerError FIRMWARE_MATCH_ERROR = new DJIRemoteControllerError("Firmware match error");
  public static final DJIRemoteControllerError FIRMWARE_NON_SEQUENCE = new DJIRemoteControllerError("Firmware not pattern");
  public static final DJIRemoteControllerError FLASH_CLEAR_WRONG;
  public static final DJIRemoteControllerError FLASH_FLUSHING = new DJIRemoteControllerError("Firmware flushing");
  public static final DJIRemoteControllerError FLASH_WRITE_WRONG;
  public static final DJIRemoteControllerError UPDATE_WRONG;
  
  static
  {
    FIRMWARE_LENGTH_WRONG = new DJIRemoteControllerError("Firmware length invalid");
    FIRMWARE_CRC_WRONG = new DJIRemoteControllerError("Firmware CRC value invalid");
    FLASH_CLEAR_WRONG = new DJIRemoteControllerError("Flash clear error");
    FLASH_WRITE_WRONG = new DJIRemoteControllerError("Flash write error");
    UPDATE_WRONG = new DJIRemoteControllerError("Update error");
  }
  
  private DJIRemoteControllerError(String paramString)
  {
    super(paramString);
  }
  
  public static DJIError getDJIError(Ccode paramCcode)
  {
    if (COMMON_UNKNOWN != DJIError.getDJIError(paramCcode)) {
      return DJIError.getDJIError(paramCcode);
    }
    switch (1.$SwitchMap$dji$midware$data$config$P3$Ccode[paramCcode.ordinal()])
    {
    default: 
      return COMMON_UNKNOWN;
    case 17: 
      return COMMON_UNDEFINED;
    case 16: 
      return FLASH_FLUSHING;
    case 15: 
      return UPDATE_WRONG;
    case 14: 
      return FLASH_WRITE_WRONG;
    case 13: 
      return FLASH_CLEAR_WRONG;
    case 12: 
      return FIRMWARE_CRC_WRONG;
    case 11: 
      return FIRMWARE_LENGTH_WRONG;
    case 10: 
      return FIRMWARE_NON_SEQUENCE;
    case 9: 
      return COMMON_UNKNOWN;
    case 8: 
      return COMMON_UNKNOWN;
    case 7: 
      return COMMON_PARAM_ILLEGAL;
    case 6: 
      return COMMON_UNKNOWN;
    case 5: 
      return COMMON_TIMEOUT;
    case 4: 
      return COMMON_UNKNOWN;
    case 3: 
      return COMMON_UNKNOWN;
    case 2: 
      return COMMON_UNKNOWN;
    }
    return COMMON_TIMEOUT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIRemoteControllerError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */