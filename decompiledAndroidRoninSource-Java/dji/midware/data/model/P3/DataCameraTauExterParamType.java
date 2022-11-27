package dji.midware.data.model.P3;

public class DataCameraTauExterParamType
  extends DataCameraTauParamer
{
  public DataCameraTauExterParamType()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.EXTER_PARAM_TYPE;
  }
  
  public ExterParamType getExterParamType()
  {
    return null;
  }
  
  public DataCameraTauExterParamType setType(ExterParamType paramExterParamType)
  {
    return null;
  }
  
  public static enum ExterParamType
  {
    private final int _value;
    
    static
    {
      ExterParamType localExterParamType = new ExterParamType("OTHER", 3, 99);
      OTHER = localExterParamType;
      $VALUES = new ExterParamType[] { USER1, USER2, USER3, localExterParamType };
    }
    
    private ExterParamType(int paramInt)
    {
      this._value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return paramInt == this._value;
    }
    
    public static ExterParamType find(int paramInt)
    {
      ExterParamType[] arrayOfExterParamType = values();
      int j = arrayOfExterParamType.length;
      int i = 0;
      while (i < j)
      {
        ExterParamType localExterParamType = arrayOfExterParamType[i];
        if (localExterParamType._equals(paramInt)) {
          return localExterParamType;
        }
        i += 1;
      }
      return USER1;
    }
    
    public int value()
    {
      return this._value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauExterParamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */