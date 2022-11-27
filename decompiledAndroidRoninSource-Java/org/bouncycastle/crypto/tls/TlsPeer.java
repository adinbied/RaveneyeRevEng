package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface TlsPeer
{
  public abstract TlsCipher getCipher()
    throws IOException;
  
  public abstract TlsCompression getCompression()
    throws IOException;
  
  public abstract void notifyAlertRaised(short paramShort1, short paramShort2, String paramString, Throwable paramThrowable);
  
  public abstract void notifyAlertReceived(short paramShort1, short paramShort2);
  
  public abstract void notifyHandshakeComplete()
    throws IOException;
  
  public abstract void notifySecureRenegotiation(boolean paramBoolean)
    throws IOException;
  
  public abstract boolean shouldUseGMTUnixTime();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsPeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */