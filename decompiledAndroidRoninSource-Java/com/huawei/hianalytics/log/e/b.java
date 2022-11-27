package com.huawei.hianalytics.log.e;

import android.text.TextUtils;
import com.huawei.hianalytics.util.c;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = c.a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    paramString = "getSHA256StrJava, getBytes - Unsupported coding format!";
    break label45;
    paramString = "getSHA256StrJava, getInstance - No such algorithm,transformation!";
    label45:
    com.huawei.hianalytics.g.b.d("LogCrypter", paramString);
    return "";
  }
  
  public static String a(Key paramKey)
  {
    return c.a(paramKey.getEncoded());
  }
  
  public static Cipher a(int paramInt, Key paramKey, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new IvParameterSpec(paramArrayOfByte);
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt, paramKey, paramArrayOfByte);
      return localCipher;
    }
    catch (NoSuchPaddingException paramKey)
    {
      for (;;) {}
    }
    catch (NoSuchAlgorithmException paramKey)
    {
      for (;;) {}
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramKey)
    {
      label45:
      for (;;) {}
    }
    paramKey = "AES:getCipher() init - Invalid key!";
    break label45;
    paramKey = "AES:getCipher() Invalid algorithm parameters";
    break label45;
    paramKey = "AES:getCipher() getInstance - No such algorithm,transformation!";
    break label45;
    paramKey = "AES:getCipher() No such filling parameters !";
    com.huawei.hianalytics.g.b.c("LogCrypter", paramKey);
    return null;
  }
  
  public static byte[] a()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public static Key b()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return new SecretKeySpec(arrayOfByte, "AES");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */