package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;

public class TlsECDHKeyExchange
  extends AbstractTlsKeyExchange
{
  protected TlsAgreementCredentials agreementCredentials;
  protected short[] clientECPointFormats;
  protected ECPrivateKeyParameters ecAgreePrivateKey;
  protected ECPublicKeyParameters ecAgreePublicKey;
  protected int[] namedCurves;
  protected short[] serverECPointFormats;
  protected AsymmetricKeyParameter serverPublicKey;
  protected TlsSigner tlsSigner;
  
  public TlsECDHKeyExchange(int paramInt, Vector paramVector, int[] paramArrayOfInt, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(paramInt, paramVector);
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unsupported key exchange algorithm");
    case 19: 
      paramVector = new TlsRSASigner();
      break;
    case 17: 
      paramVector = new TlsECDSASigner();
      break;
    case 16: 
    case 18: 
    case 20: 
      paramVector = null;
    }
    this.tlsSigner = paramVector;
    this.namedCurves = paramArrayOfInt;
    this.clientECPointFormats = paramArrayOfShort1;
    this.serverECPointFormats = paramArrayOfShort2;
  }
  
  public void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException
  {
    if (this.agreementCredentials == null) {
      this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.serverECPointFormats, this.ecAgreePublicKey.getParameters(), paramOutputStream);
    }
  }
  
  public byte[] generatePremasterSecret()
    throws IOException
  {
    Object localObject = this.agreementCredentials;
    if (localObject != null) {
      return ((TlsAgreementCredentials)localObject).generateAgreement(this.ecAgreePublicKey);
    }
    localObject = this.ecAgreePrivateKey;
    if (localObject != null) {
      return TlsECCUtils.calculateECDHBasicAgreement(this.ecAgreePublicKey, (ECPrivateKeyParameters)localObject);
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
    this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.namedCurves, this.clientECPointFormats, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
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
    if (this.keyExchange != 20) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if (this.keyExchange != 20)
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
    if (this.ecAgreePublicKey != null) {
      return;
    }
    paramInputStream = TlsUtils.readOpaque8(paramInputStream);
    ECDomainParameters localECDomainParameters = this.ecAgreePrivateKey.getParameters();
    this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.serverECPointFormats, localECDomainParameters, paramInputStream));
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.keyExchange != 20)
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
              this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey((ECPublicKeyParameters)localObject);
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
              break label109;
            }
            i = 128;
          }
          TlsUtils.validateKeyUsage(localCertificate, i);
          super.processServerCertificate(paramCertificate);
          return;
          label109:
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
      ECDomainParameters localECDomainParameters = TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, paramInputStream);
      paramInputStream = TlsUtils.readOpaque8(paramInputStream);
      this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, localECDomainParameters, paramInputStream));
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public boolean requiresServerKeyExchange()
  {
    int i = this.keyExchange;
    return (i == 17) || (i == 19) || (i == 20);
  }
  
  public void skipServerCredentials()
    throws IOException
  {
    if (this.keyExchange == 20) {
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
      if ((j != 1) && (j != 2)) {
        switch (j)
        {
        default: 
          throw new TlsFatalAlert((short)47);
        }
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsECDHKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */