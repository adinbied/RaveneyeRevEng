package dji.thirdparty.okhttp3;

import dji.thirdparty.okio.ByteString;
import java.io.UnsupportedEncodingException;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      paramString1 = ByteString.of(localStringBuilder.toString().getBytes("ISO-8859-1")).base64();
      paramString2 = new StringBuilder();
      paramString2.append("Basic ");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;) {}
    }
    throw new AssertionError();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */