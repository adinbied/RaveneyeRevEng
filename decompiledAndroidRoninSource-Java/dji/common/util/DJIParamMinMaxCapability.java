package dji.common.util;

public class DJIParamMinMaxCapability
  extends DJIParamCapability
{
  protected Number max;
  protected Number min;
  
  public DJIParamMinMaxCapability(boolean paramBoolean, Number paramNumber1, Number paramNumber2)
  {
    super(paramBoolean);
    this.min = paramNumber1;
    this.max = paramNumber2;
  }
  
  public Number getMax()
  {
    return this.max;
  }
  
  public Number getMin()
  {
    return this.min;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\DJIParamMinMaxCapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */