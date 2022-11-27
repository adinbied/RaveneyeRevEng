package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetJoyStickParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetJoyStickParams instance;
  private int buttonData = 0;
  private int change = 0;
  private int channel0 = 1024;
  private int channel1 = 1024;
  private int channel2 = 1024;
  private int channel3 = 1024;
  private int channel4 = 1024;
  private int channel5 = 1024;
  private int channel6 = 1024;
  private int focus = 1;
  private int gohome = 0;
  private int ioc_key = 0;
  private boolean isButton = false;
  private boolean isMenu = false;
  private boolean isPlayback = false;
  private boolean isRecord = false;
  private int mode_sw = FlycMode.P.value();
  private byte rs_key = 0;
  private int shutter = 0;
  private int symbol = 0;
  private int transform_sw = 0;
  
  public DataFlycSetJoyStickParams(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private byte[] generateChannelByte()
  {
    return null;
  }
  
  public static DataFlycSetJoyStickParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetJoyStickParams(false);
      }
      DataFlycSetJoyStickParams localDataFlycSetJoyStickParams = instance;
      return localDataFlycSetJoyStickParams;
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
  
  public byte[] getDataForRecord()
  {
    return this._sendData;
  }
  
  public int getModeForRecord()
  {
    return 0;
  }
  
  public int getPitchForRecord()
  {
    return 0;
  }
  
  public int getRollForRecord()
  {
    return 0;
  }
  
  public int getThrottleForRecord()
  {
    return 0;
  }
  
  public int getYawForRecord()
  {
    return 0;
  }
  
  public DataFlycSetJoyStickParams setJoyStick(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.channel0 = paramInt3;
    this.channel1 = paramInt2;
    this.channel2 = paramInt1;
    this.channel3 = paramInt4;
    return this;
  }
  
  public DataFlycSetJoyStickParams setMode(FlycMode paramFlycMode)
  {
    this.mode_sw = paramFlycMode.value();
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
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FlycMode
  {
    private int data;
    
    static
    {
      F = new FlycMode("F", 2, 2);
      FlycMode localFlycMode = new FlycMode("OTHER", 3, 100);
      OTHER = localFlycMode;
      $VALUES = new FlycMode[] { A, P, F, localFlycMode };
    }
    
    private FlycMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FlycMode find(int paramInt)
    {
      FlycMode localFlycMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFlycMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetJoyStickParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */