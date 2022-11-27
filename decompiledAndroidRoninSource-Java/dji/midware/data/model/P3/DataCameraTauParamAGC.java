package dji.midware.data.model.P3;

public class DataCameraTauParamAGC
  extends DataCameraTauParamer
{
  public DataCameraTauParamAGC()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.AGC;
  }
  
  public AGCType getType()
  {
    return null;
  }
  
  public DataCameraTauParamAGC setType(AGCType paramAGCType)
  {
    return null;
  }
  
  public static enum AGCType
  {
    private int data;
    
    static
    {
      DEFAULT = new AGCType("DEFAULT", 1, 1);
      SEASKY = new AGCType("SEASKY", 2, 2);
      OUTDOOR = new AGCType("OUTDOOR", 3, 3);
      INDOOR = new AGCType("INDOOR", 4, 4);
      MANUAL = new AGCType("MANUAL", 5, 5);
      USER1 = new AGCType("USER1", 6, 6);
      USER2 = new AGCType("USER2", 7, 7);
      USER3 = new AGCType("USER3", 8, 8);
      AGCType localAGCType = new AGCType("OTHER", 9, 100);
      OTHER = localAGCType;
      $VALUES = new AGCType[] { LINEAR, DEFAULT, SEASKY, OUTDOOR, INDOOR, MANUAL, USER1, USER2, USER3, localAGCType };
    }
    
    private AGCType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static AGCType find(int paramInt)
    {
      AGCType localAGCType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAGCType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamAGC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */