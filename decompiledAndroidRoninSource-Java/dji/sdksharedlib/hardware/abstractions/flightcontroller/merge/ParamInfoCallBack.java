package dji.sdksharedlib.hardware.abstractions.flightcontroller.merge;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.params.P3.ParamInfo;

public abstract interface ParamInfoCallBack
{
  public abstract void onFailure(Ccode paramCcode);
  
  public abstract void onSuccess(ParamInfo paramParamInfo);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\flightcontroller\merge\ParamInfoCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */