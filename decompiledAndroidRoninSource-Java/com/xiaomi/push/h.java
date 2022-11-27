package com.xiaomi.push;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class h
{
  private static final byte[] a = { 100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32 };
  
  private static Cipher a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(a);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramArrayOfByte, localIvParameterSpec);
    return localCipher;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 2).doFinal(paramArrayOfByte2);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 1).doFinal(paramArrayOfByte2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */