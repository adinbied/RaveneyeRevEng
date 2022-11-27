package dji.logic.utils;

public class DJILocationUtils
{
  public static boolean isAvailable(double paramDouble1, double paramDouble2)
  {
    return (Math.abs(paramDouble1) > 1.0E-8D) && (Math.abs(paramDouble2) > 1.0E-8D) && (Math.abs(paramDouble1) <= 90.0D) && (Math.abs(paramDouble2) <= 180.0D);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logi\\utils\DJILocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */