package dji.common.error;

public class DJIBatteryError
  extends DJIError
{
  public static final DJIBatteryError GET_SMART_BATTERY_INFO_FAILED = new DJIBatteryError("Get smart battery info failed");
  public static final DJIBatteryError UPDATE_WRONG = new DJIBatteryError("Update error");
  
  private DJIBatteryError(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\error\DJIBatteryError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */