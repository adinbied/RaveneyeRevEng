package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIAirLinkError
  extends DJIError
{
  public static final DJIAirLinkError IMAGE_TRANSMITTER_CANNOT_SET_PARAMETERS_IN_THIS_STATE = new DJIAirLinkError("Cannot set the parameters in this state");
  public static final DJIAirLinkError IMAGE_TRANSMITTER_INVALID_PARAMETER = new DJIAirLinkError("The input parameter is out of bound or invalid.");
  
  private DJIAirLinkError(String paramString)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIAirLinkError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */