package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

public class GenericSigner
  implements Signer
{
  private final Digest digest;
  private final AsymmetricBlockCipher engine;
  private boolean forSigning;
  
  public GenericSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest)
  {
    this.engine = paramAsymmetricBlockCipher;
    this.digest = paramDigest;
  }
  
  public byte[] generateSignature()
    throws CryptoException, DataLengthException
  {
    if (this.forSigning)
    {
      int i = this.digest.getDigestSize();
      byte[] arrayOfByte = new byte[i];
      this.digest.doFinal(arrayOfByte, 0);
      return this.engine.processBlock(arrayOfByte, 0, i);
    }
    throw new IllegalStateException("GenericSigner not initialised for signature generation.");
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forSigning = paramBoolean;
    AsymmetricKeyParameter localAsymmetricKeyParameter;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)((ParametersWithRandom)paramCipherParameters).getParameters();
    } else {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)paramCipherParameters;
    }
    if ((paramBoolean) && (!localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("signing requires private key");
    }
    if ((!paramBoolean) && (localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("verification requires public key");
    }
    reset();
    this.engine.init(paramBoolean, paramCipherParameters);
  }
  
  public void reset()
  {
    this.digest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.digest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    int i;
    byte[] arrayOfByte2;
    if (!this.forSigning)
    {
      i = this.digest.getDigestSize();
      arrayOfByte2 = new byte[i];
      this.digest.doFinal(arrayOfByte2, 0);
    }
    try
    {
      byte[] arrayOfByte1 = this.engine.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = arrayOfByte1;
      if (arrayOfByte1.length < i)
      {
        paramArrayOfByte = new byte[i];
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, i - arrayOfByte1.length, arrayOfByte1.length);
      }
      boolean bool = Arrays.constantTimeAreEqual(paramArrayOfByte, arrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte) {}
    throw new IllegalStateException("GenericSigner not initialised for verification");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\GenericSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */