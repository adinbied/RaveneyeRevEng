package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.Arrays;

public class SRPTlsClient
  extends AbstractTlsClient
{
  protected TlsSRPGroupVerifier groupVerifier;
  protected byte[] identity;
  protected byte[] password;
  
  public SRPTlsClient(TlsCipherFactory paramTlsCipherFactory, TlsSRPGroupVerifier paramTlsSRPGroupVerifier, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramTlsCipherFactory);
    this.groupVerifier = paramTlsSRPGroupVerifier;
    this.identity = Arrays.clone(paramArrayOfByte1);
    this.password = Arrays.clone(paramArrayOfByte2);
  }
  
  public SRPTlsClient(TlsCipherFactory paramTlsCipherFactory, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramTlsCipherFactory, new DefaultTlsSRPGroupVerifier(), paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public SRPTlsClient(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(new DefaultTlsCipherFactory(), new DefaultTlsSRPGroupVerifier(), paramArrayOfByte1, paramArrayOfByte2);
  }
  
  protected TlsKeyExchange createSRPKeyExchange(int paramInt)
  {
    return new TlsSRPKeyExchange(paramInt, this.supportedSignatureAlgorithms, this.groupVerifier, this.identity, this.password);
  }
  
  public TlsAuthentication getAuthentication()
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public int[] getCipherSuites()
  {
    return new int[] { 49182 };
  }
  
  public Hashtable getClientExtensions()
    throws IOException
  {
    Hashtable localHashtable = TlsExtensionsUtils.ensureExtensionsInitialised(super.getClientExtensions());
    TlsSRPUtils.addSRPExtension(localHashtable, this.identity);
    return localHashtable;
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
  
  public void processServerExtensions(Hashtable paramHashtable)
    throws IOException
  {
    if ((!TlsUtils.hasExpectedEmptyExtensionData(paramHashtable, TlsSRPUtils.EXT_SRP, (short)47)) && (requireSRPServerExtension())) {
      throw new TlsFatalAlert((short)47);
    }
    super.processServerExtensions(paramHashtable);
  }
  
  protected boolean requireSRPServerExtension()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SRPTlsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */