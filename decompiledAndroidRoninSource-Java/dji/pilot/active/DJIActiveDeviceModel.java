package dji.pilot.active;

import java.util.ArrayList;

public class DJIActiveDeviceModel
{
  public ArrayList<DJIDeviceModel> models;
  
  public static class DJIDeviceModel
  {
    public String appVersion;
    public String deviceName;
    public int deviceType;
    public String email;
    public String firewareVersion;
    public String productType;
    public String registerPhone;
    public String sn;
    public String uid;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\DJIActiveDeviceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */