package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class PSKTlsClient
  extends AbstractTlsClient
{
  protected TlsPSKIdentity pskIdentity;
  
  public PSKTlsClient(TlsCipherFactory paramTlsCipherFactory, TlsPSKIdentity paramTlsPSKIdentity)
  {
    super(paramTlsCipherFactory);
    this.pskIdentity = paramTlsPSKIdentity;
  }
  
  public PSKTlsClient(TlsPSKIdentity paramTlsPSKIdentity)
  {
    this(new DefaultTlsCipherFactory(), paramTlsPSKIdentity);
  }
  
  protected TlsKeyExchange createPSKKeyExchange(int paramInt)
  {
    return new TlsPSKKeyExchange(paramInt, this.supportedSignatureAlgorithms, this.pskIdentity, null, null, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
  }
  
  public TlsAuthentication getAuthentication()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public int[] getCipherSuites()
  {
    return new int[] { 49207, 49205, 178, 144 };
  }
  
  public TlsKeyExchange getKeyExchange()
    throws IOException
  {
    int i = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
    if (i != 24) {
      switch (i)
      {
      default: 
        throw new TlsFatalAlert((short)80);
      }
    }
    return createPSKKeyExchange(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\PSKTlsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */