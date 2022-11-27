package dji.midware.data.model.P3;

public class DataCameraTauParamThermometricEnable
  extends DataCameraTauParamer
{
  public DataCameraTauParamThermometricEnable()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.THERMOMETRIC_TYPE;
  }
  
  public ThermometricType getThermometricType()
  {
    return null;
  }
  
  public DataCameraTauParamThermometricEnable setType(ThermometricType paramThermometricType)
  {
    return null;
  }
  
  public static enum ThermometricType
  {
    private final int _value;
    
    static
    {
      AREA = new ThermometricType("AREA", 2, 2);
      ThermometricType localThermometricType = new ThermometricType("OTHER", 3, 99);
      OTHER = localThermometricType;
      $VALUES = new ThermometricType[] { DISABLED, SPOT, AREA, localThermometricType };
    }
    
    private ThermometricType(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return paramInt == this._value;
    }
    
    public static ThermometricType find(int paramInt)
    {
      ThermometricType[] arrayOfThermometricType = values();
      int j = arrayOfThermometricType.length;
      int i = 0;
      while (i < j)
      {
        ThermometricType localThermometricType = arrayOfThermometricType[i];
        if (localThermometricType._equals(paramInt)) {
          return localThermometricType;
        }
        i += 1;
      }
      return DISABLED;
    }
    
    public int value()
    {
      return this._value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamThermometricEnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */