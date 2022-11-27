package com.huawei.hianalytics.f.g;

import com.huawei.hianalytics.f.a.a;
import com.huawei.hianalytics.g.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class f
{
  public static String a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    catch (a paramString)
    {
      for (;;) {}
    }
    b.c("RsaCryPter", "rsaEncrypt(): Fail to encrypt with RSA!");
    return "";
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a.b());
      ((StringBuilder)localObject).append("2d1e55658d041b98ce28d81f5c7fe8b85b528f6afea350f28da6e833df875e19a6c71c59050298b28323c8910980c12a8e731e0c47dc14da076e88e25a8b7e9a7c33b27baf12e1c9de861523af15f577789389b700578670b6e37ff5e");
      ((StringBuilder)localObject).append(e.d());
      localObject = c(((StringBuilder)localObject).toString());
      if (localObject != null)
      {
        Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        localCipher.init(1, (Key)localObject);
        return localCipher.doFinal(paramArrayOfByte);
      }
      throw new UnsupportedEncodingException();
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (InvalidKeySpecException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      for (;;) {}
    }
    b.c("RsaCryPter", "rsaEncrypt(): doFinal - The provided block is not filled with");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt(): Invalid key specification");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt():False filling parameters!");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt():  No such filling parameters ");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt(): init - Invalid key!");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt(): getInstance - No such algorithm,transformation");
    throw new a();
    b.c("RsaCryPter", "rsaEncrypt(): getBytes - Unsupported coding format!");
    throw new a();
  }
  
  private static String b(String paramString)
  {
    try
    {
      paramString = e.a(a(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    b.c("RsaCryPter", "rsaEncrypt(): Unsupported Encoding - utf-8!");
    throw new a();
  }
  
  private static PublicKey c(String paramString)
  {
    paramString = new X509EncodedKeySpec(e.a(paramString));
    return KeyFactory.getInstance("RSA").generatePublic(paramString);
  }
  
  public static class a
    extends Exception
  {
    public a()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */