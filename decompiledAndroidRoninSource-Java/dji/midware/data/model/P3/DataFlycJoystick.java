package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataFlycJoystick
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataFlycJoystick instance;
  private byte flag;
  private float pitch;
  private float roll;
  private float throttle;
  private float yaw;
  
  public static DataFlycJoystick getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycJoystick();
      }
      DataFlycJoystick localDataFlycJoystick = instance;
      return localDataFlycJoystick;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataFlycJoystick setFlag(byte paramByte)
  {
    this.flag = paramByte;
    return this;
  }
  
  public DataFlycJoystick setPitch(float paramFloat)
  {
    this.pitch = paramFloat;
    return this;
  }
  
  public DataFlycJoystick setRoll(float paramFloat)
  {
    this.roll = paramFloat;
    return this;
  }
  
  public DataFlycJoystick setThrottle(float paramFloat)
  {
    this.throttle = paramFloat;
    return this;
  }
  
  public DataFlycJoystick setYaw(float paramFloat)
  {
    this.yaw = paramFloat;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycJoystick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */