package com.facebook.common.util;

import android.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureHashUtil
{
  private static final int BUFFER_SIZE = 4096;
  static final byte[] HEX_CHAR_TABLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String convertToHex(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k >>> 4)]);
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String makeHash(InputStream paramInputStream, String paramString)
    throws IOException
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString.update(arrayOfByte, 0, i);
      }
      paramInputStream = convertToHex(paramString.digest());
      return paramInputStream;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
    catch (NoSuchAlgorithmException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
  }
  
  private static String makeHash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = convertToHex(paramString.digest());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public static String makeMD5Hash(InputStream paramInputStream)
    throws IOException
  {
    return makeHash(paramInputStream, "MD5");
  }
  
  public static String makeMD5Hash(String paramString)
  {
    try
    {
      paramString = makeMD5Hash(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String makeMD5Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "MD5");
  }
  
  public static String makeSHA1Hash(String paramString)
  {
    try
    {
      paramString = makeSHA1Hash(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String makeSHA1Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-1");
  }
  
  public static String makeSHA1HashBase64(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Base64.encodeToString(localMessageDigest.digest(), 11);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public static String makeSHA256Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-256");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\commo\\util\SecureHashUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */