package com.huawei.hms.support.api.push.b.b;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() >= 48)
    {
      localStringBuffer.append(paramString.substring(6, 12));
      localStringBuffer.append(paramString.substring(16, 26));
      localStringBuffer.append(paramString.substring(32, 48));
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if ((paramString2.length() >= 16) && (paramString1.length() >= 16))
      {
        localStringBuffer.append(paramString2.substring(0, 6));
        localStringBuffer.append(paramString1.substring(0, 6));
        localStringBuffer.append(paramString2.substring(6, 10));
        localStringBuffer.append(paramString1.substring(6, 16));
        localStringBuffer.append(paramString2.substring(10, 16));
        localStringBuffer.append(paramString1.substring(16));
        localStringBuffer.append(paramString2.substring(16));
      }
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null)) {
      if (paramArrayOfByte.length <= 0) {
        return "";
      }
    }
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecureRandom localSecureRandom = new SecureRandom();
      paramArrayOfByte = new byte[16];
      localSecureRandom.nextBytes(paramArrayOfByte);
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramArrayOfByte));
      paramString = localCipher.doFinal(paramString.getBytes("UTF-8"));
      paramString = a(com.huawei.hms.support.api.push.b.a.a.a.a(paramArrayOfByte), com.huawei.hms.support.api.push.b.a.a.a.a(paramString));
      return paramString;
    }
    catch (IllegalArgumentException|InvalidKeyException|InvalidAlgorithmParameterException|IllegalBlockSizeException|BadPaddingException|UnsupportedEncodingException|NoSuchAlgorithmException|NoSuchPaddingException paramString)
    {
      for (;;) {}
    }
    com.huawei.hms.support.log.a.d("AES128_CBC", "aes cbc encrypter data error");
    return "";
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString.length() >= 48)
    {
      localStringBuffer.append(paramString.substring(0, 6));
      localStringBuffer.append(paramString.substring(12, 16));
      localStringBuffer.append(paramString.substring(26, 32));
      localStringBuffer.append(paramString.substring(48));
    }
    return localStringBuffer.toString();
  }
  
  public static String b(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 32) && (paramArrayOfByte != null)) {
      if (paramArrayOfByte.length <= 0) {
        return "";
      }
    }
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      String str = a(paramString);
      paramString = b(paramString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)))
      {
        localCipher.init(2, paramArrayOfByte, new IvParameterSpec(com.huawei.hms.support.api.push.b.a.a.a.b(str)));
        return new String(localCipher.doFinal(com.huawei.hms.support.api.push.b.a.a.a.b(paramString)), "UTF-8");
      }
      com.huawei.hms.support.log.a.c("AES128_CBC", "iv or enData is null");
      return "";
    }
    catch (IllegalArgumentException|InvalidKeyException|InvalidAlgorithmParameterException|IllegalBlockSizeException|BadPaddingException|UnsupportedEncodingException|NoSuchAlgorithmException|NoSuchPaddingException paramString)
    {
      for (;;) {}
    }
    com.huawei.hms.support.log.a.d("AES128_CBC", "aes cbc decrypter data error");
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */