package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public abstract class AbstractTlsKeyExchange
  implements TlsKeyExchange
{
  protected TlsContext context;
  protected int keyExchange;
  protected Vector supportedSignatureAlgorithms;
  
  protected AbstractTlsKeyExchange(int paramInt, Vector paramVector)
  {
    this.keyExchange = paramInt;
    this.supportedSignatureAlgorithms = paramVector;
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    if (!requiresServerKeyExchange()) {
      return null;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void init(TlsContext paramTlsContext)
  {
    this.context = paramTlsContext;
    paramTlsContext = paramTlsContext.getClientVersion();
    int i;
    if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(paramTlsContext))
    {
      if (this.supportedSignatureAlgorithms != null) {
        break label173;
      }
      i = this.keyExchange;
      if (i != 1) {
        if (i != 3)
        {
          if (i == 5) {
            break label156;
          }
          if (i != 7) {
            if (i == 9) {
              break label156;
            }
          }
        }
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        throw new IllegalStateException("unsupported key exchange algorithm");
      }
    case 16: 
    case 17: 
      paramTlsContext = TlsUtils.getDefaultECDSASignatureAlgorithms();
      break;
      paramTlsContext = TlsUtils.getDefaultDSSSignatureAlgorithms();
      break;
    case 15: 
    case 18: 
    case 19: 
      label156:
      paramTlsContext = TlsUtils.getDefaultRSASignatureAlgorithms();
      this.supportedSignatureAlgorithms = paramTlsContext;
      return;
      if (this.supportedSignatureAlgorithms != null) {
        break label174;
      }
    }
    label173:
    return;
    label174:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supported_signature_algorithms not allowed for ");
    localStringBuilder.append(paramTlsContext);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected DigitallySigned parseSignature(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = DigitallySigned.parse(this.context, paramInputStream);
    SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = paramInputStream.getAlgorithm();
    if (localSignatureAndHashAlgorithm != null) {
      TlsUtils.verifySupportedSignatureAlgorithm(this.supportedSignatureAlgorithms, localSignatureAndHashAlgorithm);
    }
    return paramInputStream;
  }
  
  public void processClientCertificate(Certificate paramCertificate)
    throws IOException
  {}
  
  public void processClientKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {}
  
  public void processServerCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    processServerCertificate(paramTlsCredentials.getCertificate());
  }
  
  public void processServerKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    if (requiresServerKeyExchange()) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public boolean requiresServerKeyExchange()
  {
    return false;
  }
  
  public void skipClientCredentials()
    throws IOException
  {}
  
  public void skipServerKeyExchange()
    throws IOException
  {
    if (!requiresServerKeyExchange()) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */