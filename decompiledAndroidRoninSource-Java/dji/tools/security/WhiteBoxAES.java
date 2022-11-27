package dji.tools.security;

public class WhiteBoxAES
{
  static
  {
    System.loadLibrary("waes");
  }
  
  public static String byte2hex(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      StringBuilder localStringBuilder;
      if (str2.length() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append("0");
        localStringBuilder.append(str2);
        str1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        str1 = localStringBuilder.toString();
      }
      i += 1;
    }
    return str1.toUpperCase();
  }
  
  public static native byte[] decryptFromWhiteBox(byte[] paramArrayOfByte);
  
  public static byte[] hex2byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if (i % 2 == 1) {
      return null;
    }
    int j = i / 2;
    byte[] arrayOfByte = new byte[j];
    i = 0;
    while (i != j)
    {
      int k = i * 2;
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(k, k + 2), 16));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\tools\security\WhiteBoxAES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */