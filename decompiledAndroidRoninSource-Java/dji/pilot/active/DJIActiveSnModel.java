package dji.pilot.active;

import java.util.ArrayList;

public class DJIActiveSnModel
{
  public ArrayList<DJISnModel> item;
  public long now_time;
  public int status;
  public String status_msg;
  
  public static class DJISnModel
  {
    public int deviceType;
    public int enabled;
    public String sn;
    public long timestamp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\DJIActiveSnModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */