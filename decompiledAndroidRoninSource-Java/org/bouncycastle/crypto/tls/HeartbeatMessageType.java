package org.bouncycastle.crypto.tls;

public class HeartbeatMessageType
{
  public static final short heartbeat_request = 1;
  public static final short heartbeat_response = 2;
  
  public static boolean isValid(short paramShort)
  {
    return (paramShort >= 1) && (paramShort <= 2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\HeartbeatMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */