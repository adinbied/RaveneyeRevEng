package dji.midware.stat;

public class StatMax
  extends StatBase
{
  private static final double MAX_INITIAL_VALUE = -1000000.0D;
  double max = -1000000.0D;
  
  public StatMax(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public void addEvent(double arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public double getValue()
  {
    try
    {
      double d = this.max;
      return d;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public double getValueAndReset()
  {
    return 1.372712796E-315D;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */