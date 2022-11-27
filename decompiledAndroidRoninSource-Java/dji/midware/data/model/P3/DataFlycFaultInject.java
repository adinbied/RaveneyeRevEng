package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycFaultInject
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycFaultInject mInstance;
  private float break_time = 0.0F;
  private INJECT_CMD cmd = INJECT_CMD.FIT_CMD_STOP;
  private float fault_level = 0.0F;
  private int fault_type = 0;
  private int inject_method = 0;
  private float last_time = 0.0F;
  private int length = 32;
  private int module_index = 0;
  private int module_type = 0;
  private long repeat_num = 0L;
  private float start_time = 0.0F;
  private int system_id = 0;
  private long version = 1L;
  
  public static DataFlycFaultInject getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataFlycFaultInject();
    }
    return mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycFaultInject setBreakTime(float paramFloat)
  {
    this.break_time = paramFloat;
    return this;
  }
  
  public DataFlycFaultInject setCmd(INJECT_CMD paramINJECT_CMD)
  {
    this.cmd = paramINJECT_CMD;
    return this;
  }
  
  public DataFlycFaultInject setFaultLevel(float paramFloat)
  {
    this.fault_level = paramFloat;
    return this;
  }
  
  public DataFlycFaultInject setFaultType(int paramInt)
  {
    this.fault_type = paramInt;
    return this;
  }
  
  public DataFlycFaultInject setInjectMethod(int paramInt)
  {
    this.inject_method = paramInt;
    return this;
  }
  
  public DataFlycFaultInject setLastTime(float paramFloat)
  {
    this.last_time = paramFloat;
    return this;
  }
  
  public DataFlycFaultInject setModuleIndex(int paramInt)
  {
    this.module_index = paramInt;
    return this;
  }
  
  public DataFlycFaultInject setModuleType(int paramInt)
  {
    this.module_type = paramInt;
    return this;
  }
  
  public DataFlycFaultInject setRepeatNum(long paramLong)
  {
    this.repeat_num = paramLong;
    return this;
  }
  
  public DataFlycFaultInject setStartTime(float paramFloat)
  {
    this.start_time = paramFloat;
    return this;
  }
  
  public DataFlycFaultInject setSystemId(int paramInt)
  {
    this.system_id = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum INJECT_CMD
  {
    private int data;
    
    static
    {
      FIT_CMD_OPEN = new INJECT_CMD("FIT_CMD_OPEN", 1, 2);
      INJECT_CMD localINJECT_CMD = new INJECT_CMD("FIT_CMD_SEND", 2, 3);
      FIT_CMD_SEND = localINJECT_CMD;
      $VALUES = new INJECT_CMD[] { FIT_CMD_STOP, FIT_CMD_OPEN, localINJECT_CMD };
    }
    
    private INJECT_CMD(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static INJECT_CMD find(int paramInt)
    {
      INJECT_CMD localINJECT_CMD = FIT_CMD_STOP;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localINJECT_CMD;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycFaultInject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */