package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.DSADigestSigner;

public abstract class TlsDSASigner
  extends AbstractTlsSigner
{
  protected abstract DSA createDSAImpl(short paramShort);
  
  public Signer createSigner(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return makeSigner(paramSignatureAndHashAlgorithm, false, true, paramAsymmetricKeyParameter);
  }
  
  public Signer createVerifyer(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return makeSigner(paramSignatureAndHashAlgorithm, false, false, paramAsymmetricKeyParameter);
  }
  
  public byte[] generateRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
    throws CryptoException
  {
    paramAsymmetricKeyParameter = makeSigner(paramSignatureAndHashAlgorithm, true, true, new ParametersWithRandom(paramAsymmetricKeyParameter, this.context.getSecureRandom()));
    int j;
    int i;
    if (paramSignatureAndHashAlgorithm == null)
    {
      j = 16;
      i = 20;
    }
    else
    {
      j = 0;
      i = paramArrayOfByte.length;
    }
    paramAsymmetricKeyParameter.update(paramArrayOfByte, j, i);
    return paramAsymmetricKeyParameter.generateSignature();
  }
  
  protected abstract short getSignatureAlgorithm();
  
  protected CipherParameters makeInitParameters(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    return paramCipherParameters;
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
      if ((paramSignatureAndHashAlgorithm != null) && (paramSignatureAndHashAlgorithm.getSignature() != getSignatureAlgorithm())) {
        throw new IllegalStateException();
      }
      short s;
      if (paramSignatureAndHashAlgorithm == null) {
        s = 2;
      } else {
        s = paramSignatureAndHashAlgorithm.getHash();
      }
      if (paramBoolean1) {
        paramSignatureAndHashAlgorithm = new NullDigest();
      } else {
        paramSignatureAndHashAlgorithm = TlsUtils.createHash(s);
      }
      paramSignatureAndHashAlgorithm = new DSADigestSigner(createDSAImpl(s), paramSignatureAndHashAlgorithm);
      paramSignatureAndHashAlgorithm.init(paramBoolean2, makeInitParameters(paramBoolean2, paramCipherParameters));
      return paramSignatureAndHashAlgorithm;
    }
    throw new IllegalStateException();
  }
  
  public boolean verifyRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, byte[] paramArrayOfByte1, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte2)
    throws CryptoException
  {
    paramAsymmetricKeyParameter = makeSigner(paramSignatureAndHashAlgorithm, true, false, paramAsymmetricKeyParameter);
    if (paramSignatureAndHashAlgorithm == null) {
      paramAsymmetricKeyParameter.update(paramArrayOfByte2, 16, 20);
    } else {
      paramAsymmetricKeyParameter.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    }
    return paramAsymmetricKeyParameter.verifySignature(paramArrayOfByte1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsDSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */