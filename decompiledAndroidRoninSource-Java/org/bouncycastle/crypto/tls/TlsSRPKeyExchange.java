package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.bouncycastle.crypto.agreement.srp.SRP6Server;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.SRP6GroupParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.io.TeeInputStream;

public class TlsSRPKeyExchange
  extends AbstractTlsKeyExchange
{
  protected TlsSRPGroupVerifier groupVerifier;
  protected byte[] identity;
  protected byte[] password;
  protected TlsSignerCredentials serverCredentials = null;
  protected AsymmetricKeyParameter serverPublicKey = null;
  protected SRP6Client srpClient = null;
  protected SRP6GroupParameters srpGroup = null;
  protected BigInteger srpPeerCredentials = null;
  protected byte[] srpSalt = null;
  protected SRP6Server srpServer = null;
  protected BigInteger srpVerifier = null;
  protected TlsSigner tlsSigner;
  
  public TlsSRPKeyExchange(int paramInt, Vector paramVector, TlsSRPGroupVerifier paramTlsSRPGroupVerifier, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramInt, paramVector);
    this.tlsSigner = createSigner(paramInt);
    this.groupVerifier = paramTlsSRPGroupVerifier;
    this.identity = paramArrayOfByte1;
    this.password = paramArrayOfByte2;
    this.srpClient = new SRP6Client();
  }
  
  public TlsSRPKeyExchange(int paramInt, Vector paramVector, byte[] paramArrayOfByte, TlsSRPLoginParameters paramTlsSRPLoginParameters)
  {
    super(paramInt, paramVector);
    this.tlsSigner = createSigner(paramInt);
    this.identity = paramArrayOfByte;
    this.srpServer = new SRP6Server();
    this.srpGroup = paramTlsSRPLoginParameters.getGroup();
    this.srpVerifier = paramTlsSRPLoginParameters.getVerifier();
    this.srpSalt = paramTlsSRPLoginParameters.getSalt();
  }
  
  public TlsSRPKeyExchange(int paramInt, Vector paramVector, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramInt, paramVector, new DefaultTlsSRPGroupVerifier(), paramArrayOfByte1, paramArrayOfByte2);
  }
  
  protected static TlsSigner createSigner(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unsupported key exchange algorithm");
    case 23: 
      return new TlsRSASigner();
    case 22: 
      return new TlsDSSSigner();
    }
    return null;
  }
  
  public void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException
  {
    TlsSRPUtils.writeSRPParameter(this.srpClient.generateClientCredentials(this.srpSalt, this.identity, this.password), paramOutputStream);
    this.context.getSecurityParameters().srpIdentity = Arrays.clone(this.identity);
  }
  
  public byte[] generatePremasterSecret()
    throws IOException
  {
    try
    {
      if (this.srpServer != null) {
        localObject = this.srpServer.calculateSecret(this.srpPeerCredentials);
      } else {
        localObject = this.srpClient.calculateSecret(this.srpPeerCredentials);
      }
      Object localObject = BigIntegers.asUnsignedByteArray((BigInteger)localObject);
      return (byte[])localObject;
    }
    catch (CryptoException localCryptoException)
    {
      throw new TlsFatalAlert((short)47, localCryptoException);
    }
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    this.srpServer.init(this.srpGroup, this.srpVerifier, TlsUtils.createHash((short)2), this.context.getSecureRandom());
    Object localObject1 = this.srpServer.generateServerCredentials();
    Object localObject2 = new ServerSRPParams(this.srpGroup.getN(), this.srpGroup.getG(), this.srpSalt, (BigInteger)localObject1);
    localObject1 = new DigestInputBuffer();
    ((ServerSRPParams)localObject2).encode((OutputStream)localObject1);
    if (this.serverCredentials != null)
    {
      localObject2 = TlsUtils.getSignatureAndHashAlgorithm(this.context, this.serverCredentials);
      Digest localDigest = TlsUtils.createHash((SignatureAndHashAlgorithm)localObject2);
      Object localObject3 = this.context.getSecurityParameters();
      localDigest.update(((SecurityParameters)localObject3).clientRandom, 0, ((SecurityParameters)localObject3).clientRandom.length);
      localDigest.update(((SecurityParameters)localObject3).serverRandom, 0, ((SecurityParameters)localObject3).serverRandom.length);
      ((DigestInputBuffer)localObject1).updateDigest(localDigest);
      localObject3 = new byte[localDigest.getDigestSize()];
      localDigest.doFinal((byte[])localObject3, 0);
      new DigitallySigned((SignatureAndHashAlgorithm)localObject2, this.serverCredentials.generateCertificateSignature((byte[])localObject3)).encode((OutputStream)localObject1);
    }
    return ((DigestInputBuffer)localObject1).toByteArray();
  }
  
  public void init(TlsContext paramTlsContext)
  {
    super.init(paramTlsContext);
    TlsSigner localTlsSigner = this.tlsSigner;
    if (localTlsSigner != null) {
      localTlsSigner.init(paramTlsContext);
    }
  }
  
  protected Signer initVerifyer(TlsSigner paramTlsSigner, SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, SecurityParameters paramSecurityParameters)
  {
    paramTlsSigner = paramTlsSigner.createVerifyer(paramSignatureAndHashAlgorithm, this.serverPublicKey);
    paramTlsSigner.update(paramSecurityParameters.clientRandom, 0, paramSecurityParameters.clientRandom.length);
    paramTlsSigner.update(paramSecurityParameters.serverRandom, 0, paramSecurityParameters.serverRandom.length);
    return paramTlsSigner;
  }
  
  public void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    throw new TlsFatalAlert((short)80);
  }
  
  public void processClientKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      this.srpPeerCredentials = SRP6Util.validatePublicValue(this.srpGroup.getN(), TlsSRPUtils.readSRPParameter(paramInputStream));
      this.context.getSecurityParameters().srpIdentity = Arrays.clone(this.identity);
      return;
    }
    catch (CryptoException paramInputStream)
    {
      throw new TlsFatalAlert((short)47, paramInputStream);
    }
  }
  
  public void processServerCertificate(Certificate paramCertificate)
    throws IOException
  {
    if (this.tlsSigner != null)
    {
      if (!paramCertificate.isEmpty())
      {
        org.bouncycastle.asn1.x509.Certificate localCertificate = paramCertificate.getCertificateAt(0);
        Object localObject = localCertificate.getSubjectPublicKeyInfo();
        try
        {
          localObject = PublicKeyFactory.createKey((SubjectPublicKeyInfo)localObject);
          this.serverPublicKey = ((AsymmetricKeyParameter)localObject);
          if (this.tlsSigner.isValidPublicKey((AsymmetricKeyParameter)localObject))
          {
            TlsUtils.validateKeyUsage(localCertificate, 128);
            super.processServerCertificate(paramCertificate);
            return;
          }
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
  
  public void processServerCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if ((this.keyExchange != 21) && ((paramTlsCredentials instanceof TlsSignerCredentials)))
    {
      processServerCertificate(paramTlsCredentials.getCertificate());
      this.serverCredentials = ((TlsSignerCredentials)paramTlsCredentials);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void processServerKeyExchange(InputStream paramInputStream)
    throws IOException
  {
    Object localObject2 = this.context.getSecurityParameters();
    SignerInputBuffer localSignerInputBuffer;
    if (this.tlsSigner != null)
    {
      localSignerInputBuffer = new SignerInputBuffer();
      localObject1 = new TeeInputStream(paramInputStream, localSignerInputBuffer);
    }
    else
    {
      localSignerInputBuffer = null;
      localObject1 = paramInputStream;
    }
    Object localObject1 = ServerSRPParams.parse((InputStream)localObject1);
    if (localSignerInputBuffer != null)
    {
      paramInputStream = parseSignature(paramInputStream);
      localObject2 = initVerifyer(this.tlsSigner, paramInputStream.getAlgorithm(), (SecurityParameters)localObject2);
      localSignerInputBuffer.updateSigner((Signer)localObject2);
      if (!((Signer)localObject2).verifySignature(paramInputStream.getSignature())) {
        throw new TlsFatalAlert((short)51);
      }
    }
    paramInputStream = new SRP6GroupParameters(((ServerSRPParams)localObject1).getN(), ((ServerSRPParams)localObject1).getG());
    this.srpGroup = paramInputStream;
    if (this.groupVerifier.accept(paramInputStream))
    {
      this.srpSalt = ((ServerSRPParams)localObject1).getS();
      try
      {
        this.srpPeerCredentials = SRP6Util.validatePublicValue(this.srpGroup.getN(), ((ServerSRPParams)localObject1).getB());
        this.srpClient.init(this.srpGroup, TlsUtils.createHash((short)2), this.context.getSecureRandom());
        return;
      }
      catch (CryptoException paramInputStream)
      {
        throw new TlsFatalAlert((short)47, paramInputStream);
      }
    }
    throw new TlsFatalAlert((short)71);
  }
  
  public boolean requiresServerKeyExchange()
  {
    return true;
  }
  
  public void skipServerCredentials()
    throws IOException
  {
    if (this.tlsSigner == null) {
      return;
    }
    throw new TlsFatalAlert((short)10);
  }
  
  public void validateCertificateRequest(CertificateRequest paramCertificateRequest)
    throws IOException
  {
    throw new TlsFatalAlert((short)10);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSRPKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */