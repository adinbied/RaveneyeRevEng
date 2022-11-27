package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataRcSetControlMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetControlMode instance;
  private ArrayList<ChannelCustomModel> arrayList = new ArrayList(4);
  private ControlMode controlMode = ControlMode.Japan;
  
  public DataRcSetControlMode(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataRcSetControlMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetControlMode(true);
      }
      DataRcSetControlMode localDataRcSetControlMode = instance;
      return localDataRcSetControlMode;
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
  
  public int getControlModeForRecord()
  {
    return 0;
  }
  
  public ControlMode getControlType()
  {
    return this.controlMode;
  }
  
  public DataRcSetControlMode setChannels(ArrayList<ChannelCustomModel> paramArrayList)
  {
    this.arrayList = paramArrayList;
    return this;
  }
  
  public DataRcSetControlMode setControlType(ControlMode paramControlMode)
  {
    this.controlMode = paramControlMode;
    return this;
  }
  
  public void setDataToRecDataForRecord()
  {
    doPack();
    this._recData = this._sendData;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ChannelCustomModel
  {
    public int direction;
    public int function;
    
    public ChannelCustomModel() {}
    
    public ChannelCustomModel(int paramInt1, int paramInt2)
    {
      this.direction = paramInt1;
      this.function = paramInt2;
    }
    
    public ChannelCustomModel copy()
    {
      return null;
    }
  }
  
  public static enum ChannelType
  {
    private int data;
    
    static
    {
      A = new ChannelType("A", 1, 1);
      E = new ChannelType("E", 2, 2);
      T = new ChannelType("T", 3, 3);
      R = new ChannelType("R", 4, 4);
      ChannelType localChannelType = new ChannelType("OTHER", 5, 100);
      OTHER = localChannelType;
      $VALUES = new ChannelType[] { None, A, E, T, R, localChannelType };
    }
    
    private ChannelType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ChannelType find(int paramInt)
    {
      ChannelType localChannelType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localChannelType;
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
  
  public static enum ControlMode
  {
    private int data;
    
    static
    {
      America = new ControlMode("America", 1, 2);
      China = new ControlMode("China", 2, 3);
      Custom = new ControlMode("Custom", 3, 4);
      ControlMode localControlMode = new ControlMode("OTHER", 4, 100);
      OTHER = localControlMode;
      $VALUES = new ControlMode[] { Japan, America, China, Custom, localControlMode };
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */