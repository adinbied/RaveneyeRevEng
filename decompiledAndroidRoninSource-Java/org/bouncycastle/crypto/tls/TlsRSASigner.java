package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.GenericSigner;
import org.bouncycastle.crypto.signers.RSADigestSigner;

public class TlsRSASigner
  extends AbstractTlsSigner
{
  protected AsymmetricBlockCipher createRSAImpl()
  {
    return new PKCS1Encoding(new RSABlindedEngine());
  }
  
  public Signer createSigner(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return makeSigner(paramSignatureAndHashAlgorithm, false, true, new ParametersWithRandom(paramAsymmetricKeyParameter, this.context.getSecureRandom()));
  }
  
  public Signer createVerifyer(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return makeSigner(paramSignatureAndHashAlgorithm, false, false, paramAsymmetricKeyParameter);
  }
  
  public byte[] generateRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
    throws CryptoException
  {
    paramSignatureAndHashAlgorithm = makeSigner(paramSignatureAndHashAlgorithm, true, true, new ParametersWithRandom(paramAsymmetricKeyParameter, this.context.getSecureRandom()));
    paramSignatureAndHashAlgorithm.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    return paramSignatureAndHashAlgorithm.generateSignature();
  }
  
  public boolean isValidPublicKey(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return ((paramAsymmetricKeyParameter instanceof RSAKeyParameters)) && (!paramAsymmetricKeyParameter.isPrivate());
  }
  
  protected Signer makeSigner(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, boolean paramBoolean1, boolean paramBoolean2, CipherParameters paramCipherParameters)
  {
    int i;
    if (paramSignatureAndHashAlgorithm != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == TlsUtils.isTLSv12(this.context))
    {
      if ((paramSignatureAndHashAlgorithm != null) && (paramSignatureAndHashAlgorithm.getSignature() != 1)) {
        throw new IllegalStateException();
      }
      Object localObject;
      if (paramBoolean1) {
        localObject = new NullDigest();
      } else if (paramSignatureAndHashAlgorithm == null) {
        localObject = new CombinedHash();
      } else {
        localObject = TlsUtils.createHash(paramSignatureAndHashAlgorithm.getHash());
      }
      if (paramSignatureAndHashAlgorithm != null) {
        paramSignatureAndHashAlgorithm = new RSADigestSigner((Digest)localObject, TlsUtils.getOIDForHashAlgorithm(paramSignatureAndHashAlgorithm.getHash()));
      } else {
        paramSignatureAndHashAlgorithm = new GenericSigner(createRSAImpl(), (Digest)localObject);
      }
      paramSignatureAndHashAlgorithm.init(paramBoolean2, paramCipherParameters);
      return paramSignatureAndHashAlgorithm;
    }
    throw new IllegalStateException();
  }
  
  public boolean verifyRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, byte[] paramArrayOfByte1, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte2)
    throws CryptoException
  {
    paramSignatureAndHashAlgorithm = makeSigner(paramSignatureAndHashAlgorithm, true, false, paramAsymmetricKeyParameter);
    paramSignatureAndHashAlgorithm.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    return paramSignatureAndHashAlgorithm.verifySignature(paramArrayOfByte1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsRSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */