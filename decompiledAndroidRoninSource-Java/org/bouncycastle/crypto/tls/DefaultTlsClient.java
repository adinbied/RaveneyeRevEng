package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract class DefaultTlsClient
  extends AbstractTlsClient
{
  public DefaultTlsClient() {}
  
  public DefaultTlsClient(TlsCipherFactory paramTlsCipherFactory)
  {
    super(paramTlsCipherFactory);
  }
  
  protected TlsKeyExchange createDHEKeyExchange(int paramInt)
  {
    return new TlsDHEKeyExchange(paramInt, this.supportedSignatureAlgorithms, null);
  }
  
  protected TlsKeyExchange createDHKeyExchange(int paramInt)
  {
    return new TlsDHKeyExchange(paramInt, this.supportedSignatureAlgorithms, null);
  }
  
  protected TlsKeyExchange createECDHEKeyExchange(int paramInt)
  {
    return new TlsECDHEKeyExchange(paramInt, this.supportedSignatureAlgorithms, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
  }
  
  protected TlsKeyExchange createECDHKeyExchange(int paramInt)
  {
    return new TlsECDHKeyExchange(paramInt, this.supportedSignatureAlgorithms, this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
  }
  
  protected TlsKeyExchange createRSAKeyExchange()
  {
    return new TlsRSAKeyExchange(this.supportedSignatureAlgorithms);
  }
  
  public int[] getCipherSuites()
  {
    return new int[] { 49195, 49187, 49161, 49199, 49191, 49171, 162, 64, 50, 158, 103, 51, 156, 60, 47 };
  }
  
  public TlsKeyExchange getKeyExchange()
    throws IOException
  {
    int i = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
    if (i != 1)
    {
      if ((i != 3) && (i != 5))
      {
        if ((i != 7) && (i != 9) && (i != 11))
        {
          switch (i)
          {
          default: 
            throw new TlsFatalAlert((short)80);
          case 17: 
          case 19: 
            return createECDHEKeyExchange(i);
          }
          return createECDHKeyExchange(i);
        }
        return createDHKeyExchange(i);
      }
      return createDHEKeyExchange(i);
    }
    return createRSAKeyExchange();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */