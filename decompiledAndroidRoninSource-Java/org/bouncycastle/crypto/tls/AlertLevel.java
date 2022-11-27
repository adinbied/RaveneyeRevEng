package org.bouncycastle.crypto.tls;

public class AlertLevel
{
  public static final short fatal = 2;
  public static final short warning = 1;
  
  public static String getName(short paramShort)
  {
    if (paramShort != 1)
    {
      if (paramShort != 2) {
        return "UNKNOWN";
      }
      return "fatal";
    }
    return "warning";
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AlertLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */