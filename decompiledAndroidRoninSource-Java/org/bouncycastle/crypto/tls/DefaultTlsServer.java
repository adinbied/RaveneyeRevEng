package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.agreement.DHStandardGroups;
import org.bouncycastle.crypto.params.DHParameters;

public abstract class DefaultTlsServer
  extends AbstractTlsServer
{
  public DefaultTlsServer() {}
  
  public DefaultTlsServer(TlsCipherFactory paramTlsCipherFactory)
  {
    super(paramTlsCipherFactory);
  }
  
  protected TlsKeyExchange createDHEKeyExchange(int paramInt)
  {
    return new TlsDHEKeyExchange(paramInt, this.supportedSignatureAlgorithms, getDHParameters());
  }
  
  protected TlsKeyExchange createDHKeyExchange(int paramInt)
  {
    return new TlsDHKeyExchange(paramInt, this.supportedSignatureAlgorithms, getDHParameters());
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
  
  protected int[] getCipherSuites()
  {
    return new int[] { 49200, 49199, 49192, 49191, 49172, 49171, 159, 158, 107, 103, 57, 51, 157, 156, 61, 60, 53, 47 };
  }
  
  public TlsCredentials getCredentials()
    throws IOException
  {
    int i = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          if (i != 11) {
            if (i != 17)
            {
              if (i == 19) {
                break label67;
              }
              if (i != 20) {
                throw new TlsFatalAlert((short)80);
              }
            }
            else
            {
              return getECDSASignerCredentials();
            }
          }
          return null;
        }
        label67:
        return getRSASignerCredentials();
      }
      return getDSASignerCredentials();
    }
    return getRSAEncryptionCredentials();
  }
  
  protected DHParameters getDHParameters()
  {
    return DHStandardGroups.rfc3526_2048;
  }
  
  protected TlsSignerCredentials getDSASignerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  protected TlsSignerCredentials getECDSASignerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
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
  
  protected TlsEncryptionCredentials getRSAEncryptionCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  protected TlsSignerCredentials getRSASignerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DefaultTlsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */