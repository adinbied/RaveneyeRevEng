package dji.midware.data.model.P3;

public class DataCameraTauParamRotate
  extends DataCameraTauParamer
{
  public DataCameraTauParamRotate()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.PICTURE_ROTATE;
  }
  
  public RotateType getRotateType()
  {
    return null;
  }
  
  public DataCameraTauParamRotate setRotateType(RotateType paramRotateType)
  {
    return null;
  }
  
  public static enum RotateType
  {
    private int data;
    
    static
    {
      ANGLE_180 = new RotateType("ANGLE_180", 2, 2);
      ANGLE_270 = new RotateType("ANGLE_270", 3, 3);
      RotateType localRotateType = new RotateType("OTHER", 4, 100);
      OTHER = localRotateType;
      $VALUES = new RotateType[] { ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270, localRotateType };
    }
    
    private RotateType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RotateType find(int paramInt)
    {
      RotateType localRotateType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRotateType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamRotate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */