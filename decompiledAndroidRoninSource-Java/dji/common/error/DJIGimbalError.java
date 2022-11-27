package dji.common.error;

import dji.midware.data.config.P3.Ccode;

public class DJIGimbalError
  extends DJIError
{
  public static final DJIGimbalError CANNOT_SET_PARAMETERS_IN_THIS_STATE = new DJIGimbalError("Cannot set the parameters in this state");
  public static final DJIGimbalError GIMBAL_PARMA_LENGTH_IS_ILLEGAL = new DJIGimbalError("The param length is illegal");
  public static final DJIGimbalError RESULT_FAILED = new DJIGimbalError("Failed");
  
  private DJIGimbalError(String paramString)
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
    return COMMON_UNKNOWN;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIGimbalError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */