package dji.midware.stat;

public class StatLatest
  extends StatBase
{
  private static final double LATEST_INITIAL_VALUE = -1.0D;
  double latest = -1.0D;
  
  public StatLatest(String paramString)
  {
    super(paramString);
  }
  
  public void addEvent(double paramDouble)
  {
    try
    {
      this.latest = paramDouble;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public double getValue()
  {
    try
    {
      double d = this.latest;
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
    return 1.37271268E-315D;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */