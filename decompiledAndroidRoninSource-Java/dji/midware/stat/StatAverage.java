package dji.midware.stat;

public class StatAverage
  extends StatBase
{
  float sum = 0.0F;
  int times = 0;
  
  public StatAverage(String paramString)
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
    return 1.37271254E-315D;
  }
  
  public double getValueAndReset()
  {
    return 1.37271257E-315D;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\StatAverage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */