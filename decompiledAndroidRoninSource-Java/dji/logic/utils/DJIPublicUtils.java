package dji.logic.utils;

public class DJIPublicUtils
{
  public static long formatVersion(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      l2 = l1;
      if (!paramString.isEmpty())
      {
        paramString = paramString.split("\\.");
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramString.length) {
            break;
          }
          l1 = l1 * 256L + Integer.parseInt(paramString[i], 10);
          i += 1;
        }
      }
    }
    return l2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logi\\utils\DJIPublicUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */