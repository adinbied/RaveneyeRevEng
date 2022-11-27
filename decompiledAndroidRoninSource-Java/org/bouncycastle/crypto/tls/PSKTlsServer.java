package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.agreement.DHStandardGroups;
import org.bouncycastle.crypto.params.DHParameters;

public class PSKTlsServer
  extends AbstractTlsServer
{
  protected TlsPSKIdentityManager pskIdentityManager;
  
  public PSKTlsServer(TlsCipherFactory paramTlsCipherFactory, TlsPSKIdentityManager paramTlsPSKIdentityManager)
  {
    super(paramTlsCipherFactory);
    this.pskIdentityManager = paramTlsPSKIdentityManager;
  }
  
  public PSKTlsServer(TlsPSKIdentityManager paramTlsPSKIdentityManager)
  {
    this(new DefaultTlsCipherFactory(), paramTlsPSKIdentityManager);
  }
  
  protected TlsKeyExchange createPSKKeyExchange(int paramInt)
  {
    return new TlsPSKKeyExchange(paramInt, this.supportedSignatureAlgorithms, null, this.pskIdentityManager, getDHParameters(), this.namedCurves, this.clientECPointFormats, this.serverECPointFormats);
  }
  
  protected int[] getCipherSuites()
  {
    return new int[] { 49207, 49205, 178, 144 };
  }
  
  public TlsCredentials getCredentials()
    throws IOException
  {
    int i = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
    if (i != 24) {
      switch (i)
      {
      default: 
        throw new TlsFatalAlert((short)80);
      case 15: 
        return getRSAEncryptionCredentials();
      }
    }
    return null;
  }
  
  protected DHParameters getDHParameters()
  {
    return DHStandardGroups.rfc3526_2048;
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
  
  protected TlsEncryptionCredentials getRSAEncryptionCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\PSKTlsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */