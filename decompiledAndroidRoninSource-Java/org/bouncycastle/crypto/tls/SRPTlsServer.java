package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;

public class SRPTlsServer
  extends AbstractTlsServer
{
  protected TlsSRPLoginParameters loginParameters = null;
  protected byte[] srpIdentity = null;
  protected TlsSRPIdentityManager srpIdentityManager;
  
  public SRPTlsServer(TlsCipherFactory paramTlsCipherFactory, TlsSRPIdentityManager paramTlsSRPIdentityManager)
  {
    super(paramTlsCipherFactory);
    this.srpIdentityManager = paramTlsSRPIdentityManager;
  }
  
  public SRPTlsServer(TlsSRPIdentityManager paramTlsSRPIdentityManager)
  {
    this(new DefaultTlsCipherFactory(), paramTlsSRPIdentityManager);
  }
  
  protected TlsKeyExchange createSRPKeyExchange(int paramInt)
  {
    return new TlsSRPKeyExchange(paramInt, this.supportedSignatureAlgorithms, this.srpIdentity, this.loginParameters);
  }
  
  protected int[] getCipherSuites()
  {
    return new int[] { 49186, 49183, 49185, 49182, 49184, 49181 };
  }
  
  public TlsCredentials getCredentials()
    throws IOException
  {
    switch (TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite))
    {
    default: 
      throw new TlsFatalAlert((short)80);
    case 23: 
      return getRSASignerCredentials();
    case 22: 
      return getDSASignerCredentials();
    }
    return null;
  }
  
  protected TlsSignerCredentials getDSASignerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public TlsKeyExchange getKeyExchange()
    throws IOException
  {
    int i = TlsUtils.getKeyExchangeAlgorithm(this.selectedCipherSuite);
    switch (i)
    {
    default: 
      throw new TlsFatalAlert((short)80);
    }
    return createSRPKeyExchange(i);
  }
  
  protected TlsSignerCredentials getRSASignerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public int getSelectedCipherSuite()
    throws IOException
  {
    int i = super.getSelectedCipherSuite();
    if (TlsSRPUtils.isSRPCipherSuite(i))
    {
      byte[] arrayOfByte = this.srpIdentity;
      if (arrayOfByte != null) {
        this.loginParameters = this.srpIdentityManager.getLoginParameters(arrayOfByte);
      }
      if (this.loginParameters != null) {
        return i;
      }
      throw new TlsFatalAlert((short)115);
    }
    return i;
  }
  
  public void processClientExtensions(Hashtable paramHashtable)
    throws IOException
  {
    super.processClientExtensions(paramHashtable);
    this.srpIdentity = TlsSRPUtils.getSRPExtension(paramHashtable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SRPTlsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */