package dji.midware.data.model.P3;

public class DataCameraTauFFCMode
  extends DataCameraTauParamer
{
  public DataCameraTauFFCMode()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.FFC_MODE;
  }
  
  public FFCMode getMode()
  {
    return null;
  }
  
  public DataCameraTauFFCMode setMode(FFCMode paramFFCMode)
  {
    return null;
  }
  
  public static enum FFCMode
  {
    private int data;
    
    static
    {
      AUTO = new FFCMode("AUTO", 1, 1);
      FFCMode localFFCMode = new FFCMode("OTHER", 2, 100);
      OTHER = localFFCMode;
      $VALUES = new FFCMode[] { MANUAL, AUTO, localFFCMode };
    }
    
    private FFCMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FFCMode find(int paramInt)
    {
      FFCMode localFFCMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFFCMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauFFCMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */