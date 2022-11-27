package com.huawei.hianalytics.f.d;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public abstract class a
{
  public static void a(String paramString1, String paramString2, a parama)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(l);
    paramString1 = localStringBuilder.toString();
    try
    {
      paramString1 = localMessageDigest.digest(paramString1.getBytes("UTF-8"));
      if (parama == null) {
        break label80;
      }
      parama.a(l, paramString1);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label80:
      for (;;) {}
    }
    Log.w("Generator", "getHmac(): UnsupportedEncodingException: Exception when writing the log file.");
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, byte[] paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */