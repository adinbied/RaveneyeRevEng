package dji.midware.data.params.P3;

public class RangeModel
{
  public Number defaultValue;
  public Number maxValue;
  public Number minValue;
  
  public RangeModel() {}
  
  public RangeModel(Number paramNumber1, Number paramNumber2, Number paramNumber3)
  {
    this.minValue = paramNumber1;
    this.maxValue = paramNumber2;
    this.defaultValue = paramNumber3;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\params\P3\RangeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */