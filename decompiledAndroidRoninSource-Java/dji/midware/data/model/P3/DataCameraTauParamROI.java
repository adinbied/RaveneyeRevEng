package dji.midware.data.model.P3;

public class DataCameraTauParamROI
  extends DataCameraTauParamer
{
  public DataCameraTauParamROI()
  {
    this.mParamCmd = DataCameraTauParamer.ParamCmd.INTEREST_REGION;
  }
  
  public ROIType getType()
  {
    return null;
  }
  
  public DataCameraTauParamROI setType(ROIType paramROIType)
  {
    return null;
  }
  
  public static enum ROIType
  {
    private int data;
    
    static
    {
      ROIType localROIType = new ROIType("OTHER", 3, 100);
      OTHER = localROIType;
      $VALUES = new ROIType[] { FULL, SKY_EXCLUDED_33, SKY_EXCLUDED_50, localROIType };
    }
    
    private ROIType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ROIType find(int paramInt)
    {
      ROIType localROIType = FULL;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localROIType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamROI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */