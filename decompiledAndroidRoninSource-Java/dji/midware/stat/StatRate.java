package dji.midware.stat;

public class StatRate
  extends StatBase
{
  float count = 0.0F;
  long start_time = System.currentTimeMillis();
  
  public StatRate(String paramString)
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
    return 1.372713003E-315D;
  }
  
  public double getValueAndReset()
  {
    return 1.372713033E-315D;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */