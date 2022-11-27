package com.huawei.updatesdk.sdk.a.d.a;

import com.huawei.updatesdk.sdk.a.d.e;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

public abstract class a
{
  private static String a = "AESUtil";
  
  public static String a(String paramString)
  {
    if (e.a(paramString)) {
      return null;
    }
    try
    {
      localObject = MessageDigest.getInstance("SHA-256");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = new StringBuffer();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramString.append(String.format("%02X", new Object[] { Byte.valueOf(localObject[i]) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Object localObject;
      for (;;) {}
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    catch (IllegalFormatException paramString)
    {
      for (;;) {}
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    localObject = a;
    paramString = "sha256EncryptStr error:Exception";
    break label122;
    localObject = a;
    paramString = "sha256EncryptStr error:IllegalFormatException";
    break label122;
    localObject = a;
    paramString = "sha256EncryptStr error:UnsupportedEncodingException";
    break label122;
    localObject = a;
    paramString = "sha256EncryptStr error:NoSuchAlgorithmException";
    label122:
    com.huawei.updatesdk.sdk.a.c.a.a.a.d((String)localObject, paramString);
    return null;
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(Locale.getDefault());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */