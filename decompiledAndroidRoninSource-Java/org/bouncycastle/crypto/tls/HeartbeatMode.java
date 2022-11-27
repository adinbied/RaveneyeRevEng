package org.bouncycastle.crypto.tls;

public class HeartbeatMode
{
  public static final short peer_allowed_to_send = 1;
  public static final short peer_not_allowed_to_send = 2;
  
  public static boolean isValid(short paramShort)
  {
    return (paramShort >= 1) && (paramShort <= 2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\HeartbeatMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */