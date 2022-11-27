package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract class AbstractTlsPeer
  implements TlsPeer
{
  public void notifyAlertRaised(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable) {}
  
  public void notifyAlertReceived(short paramShort1, short paramShort2) {}
  
  public void notifyHandshakeComplete()
    throws IOException
  {}
  
  public void notifySecureRenegotiation(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
  
  public boolean shouldUseGMTUnixTime()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsPeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */