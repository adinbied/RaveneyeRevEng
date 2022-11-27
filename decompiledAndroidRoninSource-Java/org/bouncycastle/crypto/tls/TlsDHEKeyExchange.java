package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.util.io.TeeInputStream;

public class TlsDHEKeyExchange
  extends TlsDHKeyExchange
{
  protected TlsSignerCredentials serverCredentials = null;
  
  public TlsDHEKeyExchange(int paramInt, Vector paramVector, DHParameters paramDHParameters)
  {
    super(paramInt, paramVector, paramDHParameters);
  }
  
  public byte[] generateServerKeyExchange()
    throws IOException
  {
    if (this.dhParameters != null)
    {
      DigestInputBuffer localDigestInputBuffer = new DigestInputBuffer();
      this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, localDigestInputBuffer);
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
    throw new TlsFatalAlert((short)80);
  }
  
  protected Signer initVerifyer(TlsSigner paramTlsSigner, SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, SecurityParameters paramSecurityParameters)
  {
    paramTlsSigner = paramTlsSigner.createVerifyer(paramSignatureAndHashAlgorithm, this.serverPublicKey);
    paramTlsSigner.update(paramSecurityParameters.clientRandom, 0, paramSecurityParameters.clientRandom.length);
    paramTlsSigner.update(paramSecurityParameters.serverRandom, 0, paramSecurityParameters.serverRandom.length);
    return paramTlsSigner;
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
    Object localObject = this.context.getSecurityParameters();
    SignerInputBuffer localSignerInputBuffer = new SignerInputBuffer();
    ServerDHParams localServerDHParams = ServerDHParams.parse(new TeeInputStream(paramInputStream, localSignerInputBuffer));
    paramInputStream = parseSignature(paramInputStream);
    localObject = initVerifyer(this.tlsSigner, paramInputStream.getAlgorithm(), (SecurityParameters)localObject);
    localSignerInputBuffer.updateSigner((Signer)localObject);
    if (((Signer)localObject).verifySignature(paramInputStream.getSignature()))
    {
      this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(localServerDHParams.getPublicKey());
      this.dhParameters = validateDHParameters(this.dhAgreePublicKey.getParameters());
      return;
    }
    throw new TlsFatalAlert((short)51);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsDHEKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */