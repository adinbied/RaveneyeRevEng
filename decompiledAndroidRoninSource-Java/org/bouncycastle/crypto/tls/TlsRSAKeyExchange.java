package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.io.Streams;

public class TlsRSAKeyExchange
  extends AbstractTlsKeyExchange
{
  protected byte[] premasterSecret;
  protected RSAKeyParameters rsaServerPublicKey = null;
  protected TlsEncryptionCredentials serverCredentials = null;
  protected AsymmetricKeyParameter serverPublicKey = null;
  
  public TlsRSAKeyExchange(Vector paramVector)
  {
    super(1, paramVector);
  }
  
  public void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException
  {
    this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, paramOutputStream);
  }
  
  public byte[] generatePremasterSecret()
    throws IOException
  {
    byte[] arrayOfByte = this.premasterSecret;
    if (arrayOfByte != null)
    {
      this.premasterSecret = null;
      return arrayOfByte;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if ((paramTlsCredentials instanceof TlsSignerCredentials)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void processClientKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    if (TlsUtils.isSSL(this.context)) {
      paramInputStream = Streams.readAll(paramInputStream);
    } else {
      paramInputStream = TlsUtils.readOpaque16(paramInputStream);
    }
    this.premasterSecret = this.serverCredentials.decryptPreMasterSecret(paramInputStream);
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (!paramCertificate.isEmpty())
    {
      org.bouncycastle.asn1.x509.Certificate localCertificate = paramCertificate.getCertificateAt(0);
      Object localObject = localCertificate.getSubjectPublicKeyInfo();
      try
      {
        localObject = PublicKeyFactory.createKey((SubjectPublicKeyInfo)localObject);
        this.serverPublicKey = ((AsymmetricKeyParameter)localObject);
        if (!((AsymmetricKeyParameter)localObject).isPrivate())
        {
          this.rsaServerPublicKey = validateRSAPublicKey((RSAKeyParameters)this.serverPublicKey);
          TlsUtils.validateKeyUsage(localCertificate, 32);
          super.processServerCertificate(paramCertificate);
          return;
        }
        throw new TlsFatalAlert((short)80);
      }
      catch (RuntimeException paramCertificate)
      {
        throw new TlsFatalAlert((short)43, paramCertificate);
      }
    }
    throw new TlsFatalAlert((short)42);
  }
  
  public void processServerCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if ((paramTlsCredentials instanceof TlsEncryptionCredentials))
    {
      processServerCertificate(paramTlsCredentials.getCertificate());
      this.serverCredentials = ((TlsEncryptionCredentials)paramTlsCredentials);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void skipServerCredentials()
    throws IOException
  {
    throw new TlsFatalAlert((short)10);
  }
  
  public void validateCertificateRequest(CertificateRequest paramCertificateRequest)
    throws IOException
  {
    paramCertificateRequest = paramCertificateRequest.getCertificateTypes();
    int i = 0;
    while (i < paramCertificateRequest.length)
    {
      int j = paramCertificateRequest[i];
      if ((j != 1) && (j != 2) && (j != 64)) {
        throw new TlsFatalAlert((short)47);
      }
      i += 1;
    }
  }
  
  protected RSAKeyParameters validateRSAPublicKey(RSAKeyParameters paramRSAKeyParameters)
    throws IOException
  {
    if (paramRSAKeyParameters.getExponent().isProbablePrime(2)) {
      return paramRSAKeyParameters;
    }
    throw new TlsFatalAlert((short)47);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsRSAKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */