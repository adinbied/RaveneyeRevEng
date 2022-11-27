package org.bouncycastle.crypto.tls;

public class HashAlgorithm
{
  public static final short md5 = 1;
  public static final short none = 0;
  public static final short sha1 = 2;
  public static final short sha224 = 3;
  public static final short sha256 = 4;
  public static final short sha384 = 5;
  public static final short sha512 = 6;
  
  public static String getName(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      return "UNKNOWN";
    case 6: 
      return "sha512";
    case 5: 
      return "sha384";
    case 4: 
      return "sha256";
    case 3: 
      return "sha224";
    case 2: 
      return "sha1";
    case 1: 
      return "md5";
    }
    return "none";
  }
  
  public static String getText(short paramShort)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName(paramShort));
    localStringBuilder.append("(");
    localStringBuilder.append(paramShort);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static boolean isPrivate(short paramShort)
  {
    return (224 <= paramShort) && (paramShort <= 255);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\HashAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */