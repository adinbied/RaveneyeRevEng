package com.xiaomi.push;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bf
{
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt(62)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(a(paramString));
      localObject = String.format("%1$032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return "";
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length();
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (k >= paramInt) {}
    }
    else
    {
      paramInt = k / 3;
      if (paramInt <= 1) {
        paramInt = 1;
      }
      i = paramInt;
      if (paramInt > 3) {
        i = 3;
      }
    }
    int j;
    for (paramInt = 0; paramInt < k; paramInt = j)
    {
      j = paramInt + 1;
      if (j % i == 0) {
        localStringBuilder.append("*");
      } else {
        localStringBuilder.append(paramString.charAt(paramInt));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Collection<?> paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return null;
    }
    return a(paramCollection.iterator(), paramString);
  }
  
  public static String a(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator == null) {
      return null;
    }
    if (!paramIterator.hasNext()) {
      return "";
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return localObject.toString();
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (localObject != null) {}
    for (;;)
    {
      localStringBuffer.append(localObject);
      do
      {
        if (!paramIterator.hasNext()) {
          break;
        }
        if (paramString != null) {
          localStringBuffer.append(paramString);
        }
        localObject = paramIterator.next();
      } while (localObject == null);
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return new String(paramArrayOfByte);
    return null;
  }
  
  public static String a(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    return a(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
  }
  
  public static String a(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = paramInt2 - paramInt1;
    if (j <= 0) {
      return "";
    }
    if (paramArrayOfObject[paramInt1] == null) {
      i = 16;
    } else {
      i = paramArrayOfObject[paramInt1].toString().length();
    }
    paramString = new StringBuffer(j * (i + str.length()));
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (i > paramInt1) {
        paramString.append(str);
      }
      if (paramArrayOfObject[i] != null) {
        paramString.append(paramArrayOfObject[i]);
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if (j >= 0)
        {
          if (j > 127) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
    }
    return true;
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return paramString.getBytes();
  }
  
  public static String b(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = MessageDigest.getInstance("SHA1");
      ((MessageDigest)localObject).update(a(paramString));
      localObject = String.format("%1$032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
    return paramString;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^[A-Za-z0-9]+$").matcher(paramString).matches();
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int j = paramString.charAt(0);
    int i = 1;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) != j) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */