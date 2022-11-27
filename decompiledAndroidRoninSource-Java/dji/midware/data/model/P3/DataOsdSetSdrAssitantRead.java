package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataOsdSetSdrAssitantRead
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataOsdSetSdrAssitantRead instance;
  private int address = 0;
  private SdrCpuType cpuType = SdrCpuType.CP_A7;
  private SdrDataType dataType = SdrDataType.Int_Data;
  private SdrDeviceType deviceType = SdrDeviceType.Sky;
  
  public static DataOsdSetSdrAssitantRead getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdSetSdrAssitantRead();
      }
      DataOsdSetSdrAssitantRead localDataOsdSetSdrAssitantRead = instance;
      return localDataOsdSetSdrAssitantRead;
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
  
  public int getIntValue()
  {
    return 0;
  }
  
  public DataOsdSetSdrAssitantRead setAddress(int paramInt)
  {
    this.address = paramInt;
    return this;
  }
  
  public DataOsdSetSdrAssitantRead setSdrCpuType(SdrCpuType paramSdrCpuType)
  {
    this.cpuType = paramSdrCpuType;
    return this;
  }
  
  public DataOsdSetSdrAssitantRead setSdrDataType(SdrDataType paramSdrDataType)
  {
    this.dataType = paramSdrDataType;
    return this;
  }
  
  public DataOsdSetSdrAssitantRead setSdrDeviceType(SdrDeviceType paramSdrDeviceType)
  {
    this.deviceType = paramSdrDeviceType;
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
  
  public static enum SdrCpuType
  {
    private int data;
    
    static
    {
      AP = new SdrCpuType("AP", 3, 3);
      SdrCpuType localSdrCpuType = new SdrCpuType("OTHER", 4, 100);
      OTHER = localSdrCpuType;
      $VALUES = new SdrCpuType[] { CP_A7, CP_X1643, CP_XC4210, AP, localSdrCpuType };
    }
    
    private SdrCpuType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SdrCpuType find(int paramInt)
    {
      SdrCpuType localSdrCpuType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSdrCpuType;
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
  
  public static enum SdrDataType
  {
    private int data;
    
    static
    {
      Byte_Data = new SdrDataType("Byte_Data", 2, 2);
      SdrDataType localSdrDataType = new SdrDataType("OTHER", 3, 100);
      OTHER = localSdrDataType;
      $VALUES = new SdrDataType[] { Int_Data, Short_Data, Byte_Data, localSdrDataType };
    }
    
    private SdrDataType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SdrDataType find(int paramInt)
    {
      SdrDataType localSdrDataType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSdrDataType;
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
  
  public static enum SdrDeviceType
  {
    private int data;
    
    static
    {
      Ground = new SdrDeviceType("Ground", 1, 1);
      SdrDeviceType localSdrDeviceType = new SdrDeviceType("OTHER", 2, 100);
      OTHER = localSdrDeviceType;
      $VALUES = new SdrDeviceType[] { Sky, Ground, localSdrDeviceType };
    }
    
    private SdrDeviceType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SdrDeviceType find(int paramInt)
    {
      SdrDeviceType localSdrDeviceType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSdrDeviceType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdSetSdrAssitantRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */