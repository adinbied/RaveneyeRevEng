package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOnBoardSdkSetIOState
  extends DataBase
  implements DJIDataSyncListener
{
  private CtrlAction action = CtrlAction.OTHER;
  private int dutyRatio = 0;
  private int frequency = 0;
  private GPIOMode gpiOMode = GPIOMode.OTHER;
  private int iOIndex = 0;
  private int initDutyRatio = 0;
  private IOProperty property = IOProperty.OTHER;
  private boolean setHighElectricLevel = false;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataOnBoardSdkSetIOState setAction(CtrlAction paramCtrlAction)
  {
    this.action = paramCtrlAction;
    return this;
  }
  
  public void setDutyRatio(int paramInt)
  {
    this.dutyRatio = paramInt;
  }
  
  public void setFrequency(int paramInt)
  {
    this.frequency = paramInt;
  }
  
  public DataOnBoardSdkSetIOState setGPIOMode(GPIOMode paramGPIOMode)
  {
    this.gpiOMode = paramGPIOMode;
    return this;
  }
  
  public DataOnBoardSdkSetIOState setHighElectricLevel(boolean paramBoolean)
  {
    this.setHighElectricLevel = paramBoolean;
    return this;
  }
  
  public DataOnBoardSdkSetIOState setIOIndex(int paramInt)
  {
    this.iOIndex = paramInt;
    return this;
  }
  
  public DataOnBoardSdkSetIOState setInitDutyRatio(int paramInt)
  {
    this.initDutyRatio = paramInt;
    return this;
  }
  
  public DataOnBoardSdkSetIOState setProperty(IOProperty paramIOProperty)
  {
    this.property = paramIOProperty;
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
  
  public static enum CtrlAction
  {
    private int data;
    
    static
    {
      CtrlAction localCtrlAction = new CtrlAction("OTHER", 2, 255);
      OTHER = localCtrlAction;
      $VALUES = new CtrlAction[] { Initiate, SetParams, localCtrlAction };
    }
    
    private CtrlAction(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CtrlAction find(int paramInt)
    {
      CtrlAction localCtrlAction = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCtrlAction;
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
  
  public static enum GPIOMode
  {
    private int data;
    
    static
    {
      PullDownInput = new GPIOMode("PullDownInput", 2, 2);
      PushPullInput = new GPIOMode("PushPullInput", 3, 3);
      GPIOMode localGPIOMode = new GPIOMode("OTHER", 4, 255);
      OTHER = localGPIOMode;
      $VALUES = new GPIOMode[] { FloatInput, PullUpInput, PullDownInput, PushPullInput, localGPIOMode };
    }
    
    private GPIOMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GPIOMode find(int paramInt)
    {
      GPIOMode localGPIOMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGPIOMode;
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
  
  public static enum IOProperty
  {
    private int data;
    
    static
    {
      IOProperty localIOProperty = new IOProperty("OTHER", 2, 255);
      OTHER = localIOProperty;
      $VALUES = new IOProperty[] { GPIO, PWM, localIOProperty };
    }
    
    private IOProperty(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static IOProperty find(int paramInt)
    {
      IOProperty localIOProperty = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localIOProperty;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOnBoardSdkSetIOState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */