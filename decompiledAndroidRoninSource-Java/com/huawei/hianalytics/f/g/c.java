package com.huawei.hianalytics.f.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hianalytics.g.b;
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

public abstract class c
{
  public static Pair<byte[], String> a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 32))
    {
      String str = paramString.substring(0, 32);
      paramString = paramString.substring(32);
      return new Pair(e.a(str), paramString);
    }
    return new Pair(new byte[0], paramString);
  }
  
  public static String a(String paramString, Context paramContext)
  {
    paramContext = a.a(paramContext).a();
    paramString = a(paramString);
    return b(paramContext, (byte[])paramString.first, (String)paramString.second);
  }
  
  public static String a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString2 != null) && (paramString1 != null) && (paramArrayOfByte != null)) {
      if (paramArrayOfByte.length == 0) {
        return "";
      }
    }
    try
    {
      paramString1 = e.a(b(paramString1, paramArrayOfByte, paramString2.getBytes("UTF-8")));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;) {}
    }
    b.c("AesCrypter", "aesEncrypt():getBytes - Unsupported coding format!");
    return "";
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 != null) && (paramString != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0)) {
      return e.a(b(paramString, paramArrayOfByte1, paramArrayOfByte2));
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramString;
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return e.a(paramArrayOfByte).concat(str);
    }
    return paramString;
  }
  
  public static byte[] a()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public static String b(String paramString, Context paramContext)
  {
    paramContext = a.a(paramContext).a();
    byte[] arrayOfByte = a();
    return a(arrayOfByte, a(paramContext, arrayOfByte, paramString));
  }
  
  public static String b(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString1 != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      if (paramString2 == null) {
        return "";
      }
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, new SecretKeySpec(e.a(paramString1), "AES"), new IvParameterSpec(paramArrayOfByte));
      paramString1 = new String(localCipher.doFinal(e.a(paramString2)), "UTF-8");
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
    catch (InvalidAlgorithmParameterException paramString1)
    {
      for (;;) {}
    }
    catch (NoSuchPaddingException paramString1)
    {
      for (;;) {}
    }
    catch (BadPaddingException paramString1)
    {
      for (;;) {}
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;) {}
    }
    catch (IllegalBlockSizeException paramString1)
    {
      for (;;) {}
    }
    paramString1 = "aesDecrypt(): doFinal - The provided block is not filled with";
    break label111;
    paramString1 = "aesDecrypt(): getBytes - Unsupported coding format!";
    break label111;
    paramString1 = "aesDecrypt(): False filling parameters!";
    break label111;
    paramString1 = "aesDecrypt():  No such filling parameters ";
    break label111;
    paramString1 = "aesDecrypt(): init - Invalid algorithm parameters !";
    break label111;
    paramString1 = "aesDecrypt(): init - Invalid key!";
    break label111;
    paramString1 = "aesDecrypt(): getInstance - No such algorithm,transformation";
    label111:
    b.c("AesCrypter", paramString1);
    return "";
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramString != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0)) {}
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, new SecretKeySpec(e.a(paramString), "AES"), new IvParameterSpec(paramArrayOfByte1));
      paramString = localCipher.doFinal(paramArrayOfByte2);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
    catch (InvalidKeyException paramString)
    {
      for (;;) {}
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      for (;;) {}
    }
    catch (NoSuchPaddingException paramString)
    {
      for (;;) {}
    }
    catch (BadPaddingException paramString)
    {
      for (;;) {}
    }
    catch (IllegalBlockSizeException paramString)
    {
      for (;;) {}
    }
    paramString = "aesEncrypt(): doFinal - The provided block is not filled with";
    for (;;)
    {
      b.c("AesCrypter", paramString);
      return new byte[0];
      paramString = "aesEncrypt(): False filling parameters!";
      continue;
      paramString = "aesEncrypt(): No such filling parameters ";
      continue;
      paramString = "aesEncrypt(): init - Invalid algorithm parameters !";
      continue;
      paramString = "aesEncrypt(): init - Invalid key!";
      continue;
      paramString = "aesEncrypt(): getInstance - No such algorithm,transformation";
    }
    return new byte[0];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */