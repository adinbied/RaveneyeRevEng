package dji.midware.data.model.P3;

public class DataCameraTauParamGainMode
  extends DataCameraTauParamer
{
  public DataCameraTauParamGainMode()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.GAIN_MODE;
  }
  
  public GainMode getGainMode()
  {
    return null;
  }
  
  public DataCameraTauParamGainMode setMode(GainMode paramGainMode)
  {
    return null;
  }
  
  public static enum GainMode
  {
    private int data;
    
    static
    {
      HIGH = new GainMode("HIGH", 2, 2);
      GainMode localGainMode = new GainMode("OTHER", 3, 100);
      OTHER = localGainMode;
      $VALUES = new GainMode[] { AUTO, LOW, HIGH, localGainMode };
    }
    
    private GainMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GainMode find(int paramInt)
    {
      GainMode localGainMode = AUTO;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGainMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamGainMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */