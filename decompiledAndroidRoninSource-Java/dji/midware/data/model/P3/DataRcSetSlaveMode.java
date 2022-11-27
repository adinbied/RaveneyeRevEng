package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRcSetSlaveMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetSlaveMode instance;
  private ArrayList<SlaveCustomModel> arrayList = new ArrayList(4);
  private ControlMode controlMode;
  
  public static DataRcSetSlaveMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetSlaveMode();
      }
      DataRcSetSlaveMode localDataRcSetSlaveMode = instance;
      return localDataRcSetSlaveMode;
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
  
  public DataRcSetSlaveMode setChannels(ArrayList<SlaveCustomModel> paramArrayList)
  {
    this.arrayList = paramArrayList;
    return this;
  }
  
  public DataRcSetSlaveMode setControlType(ControlMode paramControlMode)
  {
    this.controlMode = paramControlMode;
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
  
  public static enum ControlMode
  {
    private int data;
    
    static
    {
      Custom = new ControlMode("Custom", 1, 1);
      ControlMode localControlMode = new ControlMode("OTHER", 2, 100);
      OTHER = localControlMode;
      $VALUES = new ControlMode[] { Default, Custom, localControlMode };
    }
    
    private ControlMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ControlMode find(int paramInt)
    {
      ControlMode localControlMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localControlMode;
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
  
  public static enum ModeFunction
  {
    private int data;
    
    static
    {
      ModeFunction localModeFunction = new ModeFunction("OTHER", 4, 100);
      OTHER = localModeFunction;
      $VALUES = new ModeFunction[] { None, Pitch, Roll, Yaw, localModeFunction };
    }
    
    private ModeFunction(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ModeFunction find(int paramInt)
    {
      ModeFunction localModeFunction = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localModeFunction;
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
  
  public static class SlaveCustomModel
  {
    public int direction;
    public int function;
    
    public SlaveCustomModel() {}
    
    public SlaveCustomModel(int paramInt1, int paramInt2)
    {
      this.direction = paramInt1;
      this.function = paramInt2;
    }
    
    public SlaveCustomModel copy()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetSlaveMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */