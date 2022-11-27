package dji.sdksharedlib.hardware.abstractions.battery.merge;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataSmartBatteryGetStaticData;

public abstract interface M600SingleStaticDataCallback
{
  public abstract void onFailure(Ccode paramCcode);
  
  public abstract void onSuccess(DataSmartBatteryGetStaticData paramDataSmartBatteryGetStaticData);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\battery\merge\M600SingleStaticDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */