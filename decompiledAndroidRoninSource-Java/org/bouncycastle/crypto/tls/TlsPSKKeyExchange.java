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
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public class TlsPSKKeyExchange
  extends AbstractTlsKeyExchange
{
  protected short[] clientECPointFormats;
  protected DHPrivateKeyParameters dhAgreePrivateKey = null;
  protected DHPublicKeyParameters dhAgreePublicKey = null;
  protected DHParameters dhParameters;
  protected ECPrivateKeyParameters ecAgreePrivateKey = null;
  protected ECPublicKeyParameters ecAgreePublicKey = null;
  protected int[] namedCurves;
  protected byte[] premasterSecret;
  protected byte[] psk = null;
  protected TlsPSKIdentity pskIdentity;
  protected TlsPSKIdentityManager pskIdentityManager;
  protected byte[] psk_identity_hint = null;
  protected RSAKeyParameters rsaServerPublicKey = null;
  protected TlsEncryptionCredentials serverCredentials = null;
  protected short[] serverECPointFormats;
  protected AsymmetricKeyParameter serverPublicKey = null;
  
  public TlsPSKKeyExchange(int paramInt, Vector paramVector, TlsPSKIdentity paramTlsPSKIdentity, TlsPSKIdentityManager paramTlsPSKIdentityManager, DHParameters paramDHParameters, int[] paramArrayOfInt, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(paramInt, paramVector);
    if (paramInt != 24) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("unsupported key exchange algorithm");
      }
    }
    this.pskIdentity = paramTlsPSKIdentity;
    this.pskIdentityManager = paramTlsPSKIdentityManager;
    this.dhParameters = paramDHParameters;
    this.namedCurves = paramArrayOfInt;
    this.clientECPointFormats = paramArrayOfShort1;
    this.serverECPointFormats = paramArrayOfShort2;
  }
  
  public void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte1 = this.psk_identity_hint;
    if (arrayOfByte1 == null) {
      this.pskIdentity.skipIdentityHint();
    } else {
      this.pskIdentity.notifyIdentityHint(arrayOfByte1);
    }
    arrayOfByte1 = this.pskIdentity.getPSKIdentity();
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = this.pskIdentity.getPSK();
      this.psk = arrayOfByte2;
      if (arrayOfByte2 != null)
      {
        TlsUtils.writeOpaque16(arrayOfByte1, paramOutputStream);
        this.context.getSecurityParameters().pskIdentity = Arrays.clone(arrayOfByte1);
        if (this.keyExchange == 14)
        {
          this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, paramOutputStream);
          return;
        }
        if (this.keyExchange == 24)
        {
          this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.serverECPointFormats, this.ecAgreePublicKey.getParameters(), paramOutputStream);
          return;
        }
        if (this.keyExchange == 15) {
          this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, paramOutputStream);
        }
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected byte[] generateOtherSecret(int paramInt)
    throws IOException
  {
    Object localObject;
    if (this.keyExchange == 14)
    {
      localObject = this.dhAgreePrivateKey;
      if (localObject != null) {
        return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, (DHPrivateKeyParameters)localObject);
      }
      throw new TlsFatalAlert((short)80);
    }
    if (this.keyExchange == 24)
    {
      localObject = this.ecAgreePrivateKey;
      if (localObject != null) {
        return TlsECCUtils.calculateECDHBasicAgreement(this.ecAgreePublicKey, (ECPrivateKeyParameters)localObject);
      }
      throw new TlsFatalAlert((short)80);
    }
    if (this.keyExchange == 15) {
      return this.premasterSecret;
    }
    return new byte[paramInt];
  }
  
  public byte[] generatePremasterSecret()
    throws IOException
  {
    byte[] arrayOfByte = generateOtherSecret(this.psk.length);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(arrayOfByte.length + 4 + this.psk.length);
    TlsUtils.writeOpaque16(arrayOfByte, localByteArrayOutputStream);
    TlsUtils.writeOpaque16(this.psk, localByteArrayOutputStream);
    Arrays.fill(this.psk, (byte)0);
    this.psk = null;
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    Object localObject = this.pskIdentityManager.getHint();
    this.psk_identity_hint = ((byte[])localObject);
    if ((localObject == null) && (!requiresServerKeyExchange())) {
      return null;
    }
    localObject = new ByteArrayOutputStream();
    byte[] arrayOfByte = this.psk_identity_hint;
    if (arrayOfByte == null) {
      TlsUtils.writeOpaque16(TlsUtils.EMPTY_BYTES, (OutputStream)localObject);
    } else {
      TlsUtils.writeOpaque16(arrayOfByte, (OutputStream)localObject);
    }
    if (this.keyExchange == 14)
    {
      if (this.dhParameters != null) {
        this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, (OutputStream)localObject);
      } else {
        throw new TlsFatalAlert((short)80);
      }
    }
    else if (this.keyExchange == 24) {
      this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.namedCurves, this.clientECPointFormats, (OutputStream)localObject);
    }
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public void processClientKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    Object localObject = TlsUtils.readOpaque16(paramInputStream);
    byte[] arrayOfByte = this.pskIdentityManager.getPSK((byte[])localObject);
    this.psk = arrayOfByte;
    if (arrayOfByte != null)
    {
      this.context.getSecurityParameters().pskIdentity = ((byte[])localObject);
      if (this.keyExchange == 14)
      {
        this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(paramInputStream), this.dhParameters));
        return;
      }
      if (this.keyExchange == 24)
      {
        paramInputStream = TlsUtils.readOpaque8(paramInputStream);
        localObject = this.ecAgreePrivateKey.getParameters();
        this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.serverECPointFormats, (ECDomainParameters)localObject, paramInputStream));
        return;
      }
      if (this.keyExchange == 15)
      {
        if (TlsUtils.isSSL(this.context)) {
          paramInputStream = Streams.readAll(paramInputStream);
        } else {
          paramInputStream = TlsUtils.readOpaque16(paramInputStream);
        }
        this.premasterSecret = this.serverCredentials.decryptPreMasterSecret(paramInputStream);
      }
      return;
    }
    throw new TlsFatalAlert((short)115);
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.keyExchange == 15)
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
    throw new TlsFatalAlert((short)10);
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
  
  public void processServerKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    this.psk_identity_hint = TlsUtils.readOpaque16(paramInputStream);
    if (this.keyExchange == 14)
    {
      paramInputStream = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(paramInputStream).getPublicKey());
      this.dhAgreePublicKey = paramInputStream;
      this.dhParameters = paramInputStream.getParameters();
      return;
    }
    if (this.keyExchange == 24)
    {
      ECDomainParameters localECDomainParameters = TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, paramInputStream);
      paramInputStream = TlsUtils.readOpaque8(paramInputStream);
      this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, localECDomainParameters, paramInputStream));
    }
  }
  
  public boolean requiresServerKeyExchange()
  {
    int i = this.keyExchange;
    return (i == 14) || (i == 24);
  }
  
  public void skipServerCredentials()
    throws IOException
  {
    if (this.keyExchange != 15) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void validateCertificateRequest(CertificateRequest paramCertificateRequest)
    throws IOException
  {
    throw new TlsFatalAlert((short)10);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsPSKKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */