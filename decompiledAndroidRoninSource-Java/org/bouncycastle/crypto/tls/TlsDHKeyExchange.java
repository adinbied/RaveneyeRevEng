package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;

public class TlsDHKeyExchange
  extends AbstractTlsKeyExchange
{
  protected TlsAgreementCredentials agreementCredentials;
  protected DHPrivateKeyParameters dhAgreePrivateKey;
  protected DHPublicKeyParameters dhAgreePublicKey;
  protected DHParameters dhParameters;
  protected AsymmetricKeyParameter serverPublicKey;
  protected TlsSigner tlsSigner;
  
  public TlsDHKeyExchange(int paramInt, Vector paramVector, DHParameters paramDHParameters)
  {
    super(paramInt, paramVector);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if ((paramInt != 7) && (paramInt != 9) && (paramInt != 11)) {
          throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        paramVector = null;
      }
      else
      {
        paramVector = new TlsRSASigner();
      }
    }
    else {
      paramVector = new TlsDSSSigner();
    }
    this.tlsSigner = paramVector;
    this.dhParameters = paramDHParameters;
  }
  
  public void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException
  {
    if (this.agreementCredentials == null) {
      this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, paramOutputStream);
    }
  }
  
  public byte[] generatePremasterSecret()
    throws IOException
  {
    Object localObject = this.agreementCredentials;
    if (localObject != null) {
      return ((TlsAgreementCredentials)localObject).generateAgreement(this.dhAgreePublicKey);
    }
    localObject = this.dhAgreePrivateKey;
    if (localObject != null) {
      return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, (DHPrivateKeyParameters)localObject);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    if (!requiresServerKeyExchange()) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected int getMinimumPrimeBits()
  {
    return 1024;
  }
  
  public void init(TlsContext paramTlsContext)
  {
    super.init(paramTlsContext);
    TlsSigner localTlsSigner = this.tlsSigner;
    if (localTlsSigner != null) {
      localTlsSigner.init(paramTlsContext);
    }
  }
  
  public void processClientCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.keyExchange != 11) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if (this.keyExchange != 11)
    {
      if ((paramTlsCredentials instanceof TlsAgreementCredentials))
      {
        this.agreementCredentials = ((TlsAgreementCredentials)paramTlsCredentials);
        return;
      }
      if ((paramTlsCredentials instanceof TlsSignerCredentials)) {
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void processClientKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    if (this.dhAgreePublicKey != null) {
      return;
    }
    this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(paramInputStream), this.dhParameters));
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.keyExchange != 11)
    {
      if (!paramCertificate.isEmpty())
      {
        org.bouncycastle.asn1.x509.Certificate localCertificate = paramCertificate.getCertificateAt(0);
        Object localObject = localCertificate.getSubjectPublicKeyInfo();
        try
        {
          localObject = PublicKeyFactory.createKey((SubjectPublicKeyInfo)localObject);
          this.serverPublicKey = ((AsymmetricKeyParameter)localObject);
          TlsSigner localTlsSigner = this.tlsSigner;
          int i;
          if (localTlsSigner == null)
          {
            try
            {
              localObject = TlsDHUtils.validateDHPublicKey((DHPublicKeyParameters)localObject);
              this.dhAgreePublicKey = ((DHPublicKeyParameters)localObject);
              this.dhParameters = validateDHParameters(((DHPublicKeyParameters)localObject).getParameters());
              i = 8;
            }
            catch (ClassCastException paramCertificate)
            {
              throw new TlsFatalAlert((short)46, paramCertificate);
            }
          }
          else
          {
            if (!localTlsSigner.isValidPublicKey((AsymmetricKeyParameter)localObject)) {
              break label126;
            }
            i = 128;
          }
          TlsUtils.validateKeyUsage(localCertificate, i);
          super.processServerCertificate(paramCertificate);
          return;
          label126:
          throw new TlsFatalAlert((short)46);
        }
        catch (RuntimeException paramCertificate)
        {
          throw new TlsFatalAlert((short)43, paramCertificate);
        }
      }
      throw new TlsFatalAlert((short)42);
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void processServerKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    if (requiresServerKeyExchange())
    {
      paramInputStream = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(paramInputStream).getPublicKey());
      this.dhAgreePublicKey = paramInputStream;
      this.dhParameters = validateDHParameters(paramInputStream.getParameters());
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public boolean requiresServerKeyExchange()
  {
    int i = this.keyExchange;
    return (i == 3) || (i == 5) || (i == 11);
  }
  
  public void skipServerCredentials()
    throws IOException
  {
    if (this.keyExchange == 11) {
      return;
    }
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
      if ((j != 1) && (j != 2) && (j != 3) && (j != 4) && (j != 64)) {
        throw new TlsFatalAlert((short)47);
      }
      i += 1;
    }
  }
  
  protected DHParameters validateDHParameters(DHParameters paramDHParameters)
    throws IOException
  {
    if (paramDHParameters.getP().bitLength() >= getMinimumPrimeBits()) {
      return TlsDHUtils.validateDHParameters(paramDHParameters);
    }
    throw new TlsFatalAlert((short)71);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsDHKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */