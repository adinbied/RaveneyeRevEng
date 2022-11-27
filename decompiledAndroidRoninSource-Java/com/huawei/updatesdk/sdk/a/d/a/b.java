package com.huawei.updatesdk.sdk.a.d.a;

import java.security.SecureRandom;

public class b
{
  public static int a()
  {
    return new SecureRandom().nextInt();
  }
  
  public static String b()
  {
    return com.huawei.updatesdk.sdk.a.d.b.a(c());
  }
  
  public static byte[] c()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */