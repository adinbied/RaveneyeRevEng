package org.bouncycastle.util.test;

public final class NumberParsing
{
  public static int decodeIntFromHex(String paramString)
  {
    if ((paramString.charAt(1) != 'x') && (paramString.charAt(1) != 'X')) {
      return Integer.parseInt(paramString, 16);
    }
    return Integer.parseInt(paramString.substring(2), 16);
  }
  
  public static long decodeLongFromHex(String paramString)
  {
    if ((paramString.charAt(1) != 'x') && (paramString.charAt(1) != 'X')) {
      return Long.parseLong(paramString, 16);
    }
    return Long.parseLong(paramString.substring(2), 16);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\NumberParsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */