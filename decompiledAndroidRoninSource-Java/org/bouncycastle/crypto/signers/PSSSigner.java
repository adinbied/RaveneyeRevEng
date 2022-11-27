package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class PSSSigner
  implements Signer
{
  public static final byte TRAILER_IMPLICIT = -68;
  private byte[] block;
  private AsymmetricBlockCipher cipher;
  private Digest contentDigest;
  private int emBits;
  private int hLen;
  private byte[] mDash;
  private Digest mgfDigest;
  private int mgfhLen;
  private SecureRandom random;
  private int sLen;
  private boolean sSet;
  private byte[] salt;
  private byte trailer;
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, int paramInt)
  {
    this(paramAsymmetricBlockCipher, paramDigest, paramInt, (byte)-68);
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, int paramInt, byte paramByte)
  {
    this(paramAsymmetricBlockCipher, paramDigest, paramDigest, paramInt, paramByte);
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest1, Digest paramDigest2, int paramInt)
  {
    this(paramAsymmetricBlockCipher, paramDigest1, paramDigest2, paramInt, (byte)-68);
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest1, Digest paramDigest2, int paramInt, byte paramByte)
  {
    this.cipher = paramAsymmetricBlockCipher;
    this.contentDigest = paramDigest1;
    this.mgfDigest = paramDigest2;
    this.hLen = paramDigest1.getDigestSize();
    this.mgfhLen = paramDigest2.getDigestSize();
    this.sSet = false;
    this.sLen = paramInt;
    this.salt = new byte[paramInt];
    this.mDash = new byte[paramInt + 8 + this.hLen];
    this.trailer = paramByte;
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest1, Digest paramDigest2, byte[] paramArrayOfByte)
  {
    this(paramAsymmetricBlockCipher, paramDigest1, paramDigest2, paramArrayOfByte, (byte)-68);
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest1, Digest paramDigest2, byte[] paramArrayOfByte, byte paramByte)
  {
    this.cipher = paramAsymmetricBlockCipher;
    this.contentDigest = paramDigest1;
    this.mgfDigest = paramDigest2;
    this.hLen = paramDigest1.getDigestSize();
    this.mgfhLen = paramDigest2.getDigestSize();
    this.sSet = true;
    int i = paramArrayOfByte.length;
    this.sLen = i;
    this.salt = paramArrayOfByte;
    this.mDash = new byte[i + 8 + this.hLen];
    this.trailer = paramByte;
  }
  
  public PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, byte[] paramArrayOfByte)
  {
    this(paramAsymmetricBlockCipher, paramDigest, paramDigest, paramArrayOfByte, (byte)-68);
  }
  
  private void ItoOSP(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(paramInt >>> 24));
    paramArrayOfByte[1] = ((byte)(paramInt >>> 16));
    paramArrayOfByte[2] = ((byte)(paramInt >>> 8));
    paramArrayOfByte[3] = ((byte)(paramInt >>> 0));
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
  
  private byte[] maskGeneratorFunction1(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = new byte[paramInt3];
    byte[] arrayOfByte2 = new byte[this.mgfhLen];
    byte[] arrayOfByte3 = new byte[4];
    this.mgfDigest.reset();
    int i = 0;
    int j;
    for (;;)
    {
      j = this.mgfhLen;
      if (i >= paramInt3 / j) {
        break;
      }
      ItoOSP(i, arrayOfByte3);
      this.mgfDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      this.mgfDigest.update(arrayOfByte3, 0, 4);
      this.mgfDigest.doFinal(arrayOfByte2, 0);
      j = this.mgfhLen;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * j, j);
      i += 1;
    }
    if (j * i < paramInt3)
    {
      ItoOSP(i, arrayOfByte3);
      this.mgfDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      this.mgfDigest.update(arrayOfByte3, 0, 4);
      this.mgfDigest.doFinal(arrayOfByte2, 0);
      paramInt1 = this.mgfhLen;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * paramInt1, paramInt3 - i * paramInt1);
    }
    return arrayOfByte1;
  }
  
  public byte[] generateSignature()
    throws CryptoException, DataLengthException
  {
    Object localObject1 = this.contentDigest;
    Object localObject2 = this.mDash;
    ((Digest)localObject1).doFinal((byte[])localObject2, localObject2.length - this.hLen - this.sLen);
    if (this.sLen != 0)
    {
      if (!this.sSet) {
        this.random.nextBytes(this.salt);
      }
      localObject1 = this.salt;
      localObject2 = this.mDash;
      i = localObject2.length;
      j = this.sLen;
      System.arraycopy(localObject1, 0, localObject2, i - j, j);
    }
    int i = this.hLen;
    localObject1 = new byte[i];
    localObject2 = this.contentDigest;
    byte[] arrayOfByte = this.mDash;
    ((Digest)localObject2).update(arrayOfByte, 0, arrayOfByte.length);
    this.contentDigest.doFinal((byte[])localObject1, 0);
    localObject2 = this.block;
    int j = localObject2.length;
    int k = this.sLen;
    int m = this.hLen;
    localObject2[(j - k - 1 - m - 1)] = 1;
    System.arraycopy(this.salt, 0, localObject2, localObject2.length - k - m - 1, k);
    localObject2 = maskGeneratorFunction1((byte[])localObject1, 0, i, this.block.length - this.hLen - 1);
    i = 0;
    while (i != localObject2.length)
    {
      arrayOfByte = this.block;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ localObject2[i]));
      i += 1;
    }
    localObject2 = this.block;
    localObject2[0] = ((byte)(localObject2[0] & 255 >> localObject2.length * 8 - this.emBits));
    i = localObject2.length;
    j = this.hLen;
    System.arraycopy(localObject1, 0, localObject2, i - j - 1, j);
    localObject1 = this.block;
    localObject1[(localObject1.length - 1)] = this.trailer;
    localObject1 = this.cipher.processBlock((byte[])localObject1, 0, localObject1.length);
    clearBlock(this.block);
    return (byte[])localObject1;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    Object localObject;
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      ParametersWithRandom localParametersWithRandom = (ParametersWithRandom)paramCipherParameters;
      localObject = localParametersWithRandom.getParameters();
      this.random = localParametersWithRandom.getRandom();
    }
    else
    {
      if (paramBoolean) {
        this.random = new SecureRandom();
      }
      localObject = paramCipherParameters;
    }
    if ((localObject instanceof RSABlindingParameters))
    {
      localObject = ((RSABlindingParameters)localObject).getPublicKey();
      this.cipher.init(paramBoolean, paramCipherParameters);
      paramCipherParameters = (CipherParameters)localObject;
    }
    else
    {
      paramCipherParameters = (RSAKeyParameters)localObject;
      this.cipher.init(paramBoolean, (CipherParameters)localObject);
    }
    int i = paramCipherParameters.getModulus().bitLength() - 1;
    this.emBits = i;
    if (i >= this.hLen * 8 + this.sLen * 8 + 9)
    {
      this.block = new byte[(i + 7) / 8];
      reset();
      return;
    }
    throw new IllegalArgumentException("key too small for specified hash and salt lengths");
  }
  
  public void reset()
  {
    this.contentDigest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.contentDigest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.contentDigest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    Object localObject = this.contentDigest;
    byte[] arrayOfByte = this.mDash;
    ((Digest)localObject).doFinal(arrayOfByte, arrayOfByte.length - this.hLen - this.sLen);
    try
    {
      paramArrayOfByte = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      System.arraycopy(paramArrayOfByte, 0, this.block, this.block.length - paramArrayOfByte.length, paramArrayOfByte.length);
      paramArrayOfByte = this.block;
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != this.trailer)
      {
        clearBlock(paramArrayOfByte);
        return false;
      }
      int i = paramArrayOfByte.length;
      int j = this.hLen;
      paramArrayOfByte = maskGeneratorFunction1(paramArrayOfByte, i - j - 1, j, paramArrayOfByte.length - j - 1);
      i = 0;
      while (i != paramArrayOfByte.length)
      {
        localObject = this.block;
        localObject[i] = ((byte)(localObject[i] ^ paramArrayOfByte[i]));
        i += 1;
      }
      paramArrayOfByte = this.block;
      paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] & 255 >> paramArrayOfByte.length * 8 - this.emBits));
      i = 0;
      int k;
      for (;;)
      {
        paramArrayOfByte = this.block;
        int m = paramArrayOfByte.length;
        j = this.hLen;
        k = this.sLen;
        if (i == m - j - k - 2) {
          break;
        }
        if (paramArrayOfByte[i] != 0)
        {
          clearBlock(paramArrayOfByte);
          return false;
        }
        i += 1;
      }
      if (paramArrayOfByte[(paramArrayOfByte.length - j - k - 2)] != 1)
      {
        clearBlock(paramArrayOfByte);
        return false;
      }
      if (this.sSet)
      {
        paramArrayOfByte = this.salt;
        localObject = this.mDash;
        System.arraycopy(paramArrayOfByte, 0, localObject, localObject.length - k, k);
      }
      else
      {
        i = paramArrayOfByte.length;
        localObject = this.mDash;
        System.arraycopy(paramArrayOfByte, i - k - j - 1, localObject, localObject.length - k, k);
      }
      paramArrayOfByte = this.contentDigest;
      localObject = this.mDash;
      paramArrayOfByte.update((byte[])localObject, 0, localObject.length);
      paramArrayOfByte = this.contentDigest;
      localObject = this.mDash;
      paramArrayOfByte.doFinal((byte[])localObject, localObject.length - this.hLen);
      j = this.block.length;
      i = this.hLen;
      j = j - i - 1;
      i = this.mDash.length - i;
      for (;;)
      {
        paramArrayOfByte = this.mDash;
        if (i == paramArrayOfByte.length) {
          break;
        }
        if ((this.block[j] ^ paramArrayOfByte[i]) != 0)
        {
          clearBlock(paramArrayOfByte);
          clearBlock(this.block);
          return false;
        }
        j += 1;
        i += 1;
      }
      clearBlock(paramArrayOfByte);
      clearBlock(this.block);
      return true;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\PSSSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */