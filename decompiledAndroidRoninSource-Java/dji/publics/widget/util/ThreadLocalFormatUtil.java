package dji.publics.widget.util;

import java.text.NumberFormat;

public class ThreadLocalFormatUtil
{
  private static ThreadLocal<NumberFormat> mNumberLocal = new ThreadLocal();
  
  public static String format(double paramDouble)
  {
    NumberFormat localNumberFormat2 = (NumberFormat)mNumberLocal.get();
    NumberFormat localNumberFormat1 = localNumberFormat2;
    if (localNumberFormat2 == null)
    {
      localNumberFormat1 = NumberFormat.getPercentInstance();
      localNumberFormat1.setMaximumFractionDigits(0);
      mNumberLocal.set(localNumberFormat1);
    }
    return localNumberFormat1.format(paramDouble);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widge\\util\ThreadLocalFormatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */