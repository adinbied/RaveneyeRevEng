package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class X931Signer
  implements Signer
{
  public static final int TRAILER_IMPLICIT = 188;
  public static final int TRAILER_RIPEMD128 = 13004;
  public static final int TRAILER_RIPEMD160 = 12748;
  public static final int TRAILER_SHA1 = 13260;
  public static final int TRAILER_SHA224 = 14540;
  public static final int TRAILER_SHA256 = 13516;
  public static final int TRAILER_SHA384 = 14028;
  public static final int TRAILER_SHA512 = 13772;
  public static final int TRAILER_WHIRLPOOL = 14284;
  private byte[] block;
  private AsymmetricBlockCipher cipher;
  private Digest digest;
  private RSAKeyParameters kParam;
  private int keyBits;
  private int trailer;
  
  public X931Signer(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest)
  {
    this(paramAsymmetricBlockCipher, paramDigest, false);
  }
  
  public X931Signer(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, boolean paramBoolean)
  {
    this.cipher = paramAsymmetricBlockCipher;
    this.digest = paramDigest;
    if (paramBoolean) {}
    for (int i = 188;; i = paramAsymmetricBlockCipher.intValue())
    {
      this.trailer = i;
      return;
      paramAsymmetricBlockCipher = ISOTrailers.getTrailer(paramDigest);
      if (paramAsymmetricBlockCipher == null) {
        break;
      }
    }
    paramAsymmetricBlockCipher = new StringBuilder();
    paramAsymmetricBlockCipher.append("no valid trailer for digest: ");
    paramAsymmetricBlockCipher.append(paramDigest.getAlgorithmName());
    throw new IllegalArgumentException(paramAsymmetricBlockCipher.toString());
  }
  
  private void clearBlock(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  private void createSignatureBlock()
  {
    int i = this.digest.getDigestSize();
    byte[] arrayOfByte;
    if (this.trailer == 188)
    {
      arrayOfByte = this.block;
      i = arrayOfByte.length - i - 1;
      this.digest.doFinal(arrayOfByte, i);
      arrayOfByte = this.block;
      arrayOfByte[(arrayOfByte.length - 1)] = -68;
    }
    else
    {
      arrayOfByte = this.block;
      i = arrayOfByte.length - i - 2;
      this.digest.doFinal(arrayOfByte, i);
      arrayOfByte = this.block;
      j = arrayOfByte.length;
      int k = this.trailer;
      arrayOfByte[(j - 2)] = ((byte)(k >>> 8));
      arrayOfByte[(arrayOfByte.length - 1)] = ((byte)k);
    }
    this.block[0] = 107;
    int j = i - 2;
    while (j != 0)
    {
      this.block[j] = -69;
      j -= 1;
    }
    this.block[(i - 1)] = -70;
  }
  
  public byte[] generateSignature()
    throws CryptoException
  {
    createSignatureBlock();
    Object localObject = this.cipher;
    byte[] arrayOfByte = this.block;
    localObject = new BigInteger(1, ((AsymmetricBlockCipher)localObject).processBlock(arrayOfByte, 0, arrayOfByte.length));
    clearBlock(this.block);
    localObject = ((BigInteger)localObject).min(this.kParam.getModulus().subtract((BigInteger)localObject));
    return BigIntegers.asUnsignedByteArray((this.kParam.getModulus().bitLength() + 7) / 8, (BigInteger)localObject);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    paramCipherParameters = (RSAKeyParameters)paramCipherParameters;
    this.kParam = paramCipherParameters;
    this.cipher.init(paramBoolean, paramCipherParameters);
    int i = this.kParam.getModulus().bitLength();
    this.keyBits = i;
    this.block = new byte[(i + 7) / 8];
    reset();
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
    boolean bool = false;
    try
    {
      this.block = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = new BigInteger(1, this.block);
      if ((paramArrayOfByte.intValue() & 0xF) != 12)
      {
        paramArrayOfByte = this.kParam.getModulus().subtract(paramArrayOfByte);
        if ((paramArrayOfByte.intValue() & 0xF) != 12) {}
      }
      else
      {
        createSignatureBlock();
        paramArrayOfByte = BigIntegers.asUnsignedByteArray(this.block.length, paramArrayOfByte);
        bool = Arrays.constantTimeAreEqual(this.block, paramArrayOfByte);
        clearBlock(this.block);
        clearBlock(paramArrayOfByte);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\X931Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */