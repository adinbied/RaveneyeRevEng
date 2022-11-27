package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetWhiteBalance
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetWhiteBalance instance;
  
  public static DataCameraGetWhiteBalance getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetWhiteBalance();
      }
      DataCameraGetWhiteBalance localDataCameraGetWhiteBalance = instance;
      return localDataCameraGetWhiteBalance;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public ColorType getColorType()
  {
    return null;
  }
  
  public Type getType()
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum ColorType
  {
    private int data;
    
    static
    {
      T10000K = new ColorType("T10000K", 16, 16);
      ColorType localColorType = new ColorType("OTHER", 17, 100);
      OTHER = localColorType;
      $VALUES = new ColorType[] { T2000K, T2500K, T3000K, T3500K, T4000K, T4500K, T5000K, T5500K, T6000K, T6500K, T7000K, T7500K, T8000K, T8500K, T9000K, T9500K, T10000K, localColorType };
    }
    
    private ColorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ColorType find(int paramInt)
    {
      ColorType localColorType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localColorType;
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
  
  public static enum Type
  {
    private int data;
    
    static
    {
      Cloudy = new Type("Cloudy", 2, 2);
      Water = new Type("Water", 3, 3);
      Filament = new Type("Filament", 4, 4);
      Fluorescent = new Type("Fluorescent", 5, 5);
      Color = new Type("Color", 6, 6);
      Type localType = new Type("OTHER", 7, 100);
      OTHER = localType;
      $VALUES = new Type[] { AUTO, FineDay, Cloudy, Water, Filament, Fluorescent, Color, localType };
    }
    
    private Type(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static Type find(int paramInt)
    {
      Type localType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetWhiteBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */