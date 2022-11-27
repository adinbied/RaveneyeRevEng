package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.util.io.TeeInputStream;

public class TlsECDHEKeyExchange
  extends TlsECDHKeyExchange
{
  protected TlsSignerCredentials serverCredentials = null;
  
  public TlsECDHEKeyExchange(int paramInt, Vector paramVector, int[] paramArrayOfInt, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    super(paramInt, paramVector, paramArrayOfInt, paramArrayOfShort1, paramArrayOfShort2);
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    DigestInputBuffer localDigestInputBuffer = new DigestInputBuffer();
    this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.namedCurves, this.clientECPointFormats, localDigestInputBuffer);
    SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(this.context, this.serverCredentials);
    Digest localDigest = TlsUtils.createHash(localSignatureAndHashAlgorithm);
    Object localObject = this.context.getSecurityParameters();
    localDigest.update(((SecurityParameters)localObject).clientRandom, 0, ((SecurityParameters)localObject).clientRandom.length);
    localDigest.update(((SecurityParameters)localObject).serverRandom, 0, ((SecurityParameters)localObject).serverRandom.length);
    localDigestInputBuffer.updateDigest(localDigest);
    localObject = new byte[localDigest.getDigestSize()];
    localDigest.doFinal((byte[])localObject, 0);
    new DigitallySigned(localSignatureAndHashAlgorithm, this.serverCredentials.generateCertificateSignature((byte[])localObject)).encode(localDigestInputBuffer);
    return localDigestInputBuffer.toByteArray();
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
    if ((paramTlsCredentials instanceof TlsSignerCredentials)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public void processServerCredentials(TlsCredentials paramTlsCredentials)
    throws IOException
  {
    if ((paramTlsCredentials instanceof TlsSignerCredentials))
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
    Object localObject1 = this.context.getSecurityParameters();
    SignerInputBuffer localSignerInputBuffer = new SignerInputBuffer();
    Object localObject2 = new TeeInputStream(paramInputStream, localSignerInputBuffer);
    ECDomainParameters localECDomainParameters = TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, (InputStream)localObject2);
    localObject2 = TlsUtils.readOpaque8((InputStream)localObject2);
    paramInputStream = parseSignature(paramInputStream);
    localObject1 = initVerifyer(this.tlsSigner, paramInputStream.getAlgorithm(), (SecurityParameters)localObject1);
    localSignerInputBuffer.updateSigner((Signer)localObject1);
    if (((Signer)localObject1).verifySignature(paramInputStream.getSignature()))
    {
      this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, localECDomainParameters, (byte[])localObject2));
      return;
    }
    throw new TlsFatalAlert((short)51);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsECDHEKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */