package com.huawei.hianalytics.log.a;

import android.util.Base64;
import com.huawei.hianalytics.g.b;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class c
{
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = Base64.encode(b(paramString1, paramString2), 2);
    if (paramString1 == null) {
      return null;
    }
    return new String(paramString1, Charset.forName("UTF-8"));
  }
  
  private static byte[] b(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes(Charset.forName("UTF-8"));
    paramString2 = new SecretKeySpec(paramString2.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
    try
    {
      Mac localMac = Mac.getInstance(paramString2.getAlgorithm());
      localMac.init(paramString2);
      paramString1 = localMac.doFinal(paramString1);
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramString1)
    {
      for (;;) {}
    }
    paramString1 = "Exception has happened when digest2byte,From Invalid key!";
    break label59;
    paramString1 = "When digest2byte executed Exception has happened!From Algorithm error !";
    label59:
    b.c("HmacUtil", paramString1);
    return new byte[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */