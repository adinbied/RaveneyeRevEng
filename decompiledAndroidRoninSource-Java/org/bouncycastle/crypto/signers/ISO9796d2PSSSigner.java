package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSalt;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class ISO9796d2PSSSigner
  implements SignerWithRecovery
{
  public static final int TRAILER_IMPLICIT = 188;
  public static final int TRAILER_RIPEMD128 = 13004;
  public static final int TRAILER_RIPEMD160 = 12748;
  public static final int TRAILER_SHA1 = 13260;
  public static final int TRAILER_SHA256 = 13516;
  public static final int TRAILER_SHA384 = 14028;
  public static final int TRAILER_SHA512 = 13772;
  public static final int TRAILER_WHIRLPOOL = 14284;
  private byte[] block;
  private AsymmetricBlockCipher cipher;
  private Digest digest;
  private boolean fullMessage;
  private int hLen;
  private int keyBits;
  private byte[] mBuf;
  private int messageLength;
  private byte[] preBlock;
  private int preMStart;
  private byte[] preSig;
  private int preTLength;
  private SecureRandom random;
  private byte[] recoveredMessage;
  private int saltLength;
  private byte[] standardSalt;
  private int trailer;
  
  public ISO9796d2PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, int paramInt)
  {
    this(paramAsymmetricBlockCipher, paramDigest, paramInt, false);
  }
  
  public ISO9796d2PSSSigner(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, int paramInt, boolean paramBoolean)
  {
    this.cipher = paramAsymmetricBlockCipher;
    this.digest = paramDigest;
    this.hLen = paramDigest.getDigestSize();
    this.saltLength = paramInt;
    if (paramBoolean) {}
    for (paramInt = 188;; paramInt = paramAsymmetricBlockCipher.intValue())
    {
      this.trailer = paramInt;
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
  
  private void ItoOSP(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(paramInt >>> 24));
    paramArrayOfByte[1] = ((byte)(paramInt >>> 16));
    paramArrayOfByte[2] = ((byte)(paramInt >>> 8));
    paramArrayOfByte[3] = ((byte)(paramInt >>> 0));
  }
  
  private void LtoOSP(long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(int)(paramLong >>> 56));
    paramArrayOfByte[1] = ((byte)(int)(paramLong >>> 48));
    paramArrayOfByte[2] = ((byte)(int)(paramLong >>> 40));
    paramArrayOfByte[3] = ((byte)(int)(paramLong >>> 32));
    paramArrayOfByte[4] = ((byte)(int)(paramLong >>> 24));
    paramArrayOfByte[5] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[6] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[7] = ((byte)(int)(paramLong >>> 0));
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
  
  private boolean isSameAs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool;
    if (this.messageLength != paramArrayOfByte2.length) {
      bool = false;
    } else {
      bool = true;
    }
    int i = 0;
    while (i != paramArrayOfByte2.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  private byte[] maskGeneratorFunction1(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = new byte[paramInt3];
    byte[] arrayOfByte2 = new byte[this.hLen];
    byte[] arrayOfByte3 = new byte[4];
    this.digest.reset();
    int i = 0;
    int j;
    for (;;)
    {
      j = this.hLen;
      if (i >= paramInt3 / j) {
        break;
      }
      ItoOSP(i, arrayOfByte3);
      this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
      this.digest.update(arrayOfByte3, 0, 4);
      this.digest.doFinal(arrayOfByte2, 0);
      j = this.hLen;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * j, j);
      i += 1;
    }
    if (j * i < paramInt3)
    {
      ItoOSP(i, arrayOfByte3);
      this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
      this.digest.update(arrayOfByte3, 0, 4);
      this.digest.doFinal(arrayOfByte2, 0);
      paramInt1 = this.hLen;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * paramInt1, paramInt3 - i * paramInt1);
    }
    return arrayOfByte1;
  }
  
  public byte[] generateSignature()
    throws CryptoException
  {
    int i = this.digest.getDigestSize();
    byte[] arrayOfByte1 = new byte[i];
    this.digest.doFinal(arrayOfByte1, 0);
    byte[] arrayOfByte2 = new byte[8];
    LtoOSP(this.messageLength * 8, arrayOfByte2);
    this.digest.update(arrayOfByte2, 0, 8);
    this.digest.update(this.mBuf, 0, this.messageLength);
    this.digest.update(arrayOfByte1, 0, i);
    arrayOfByte1 = this.standardSalt;
    if (arrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[this.saltLength];
      this.random.nextBytes(arrayOfByte1);
    }
    this.digest.update(arrayOfByte1, 0, arrayOfByte1.length);
    int j = this.digest.getDigestSize();
    arrayOfByte2 = new byte[j];
    this.digest.doFinal(arrayOfByte2, 0);
    i = this.trailer;
    boolean bool = true;
    if (i == 188) {
      i = 1;
    } else {
      i = 2;
    }
    byte[] arrayOfByte3 = this.block;
    int m = arrayOfByte3.length;
    int k = this.messageLength;
    m = m - k - arrayOfByte1.length - this.hLen - i - 1;
    arrayOfByte3[m] = 1;
    byte[] arrayOfByte4 = this.mBuf;
    m += 1;
    System.arraycopy(arrayOfByte4, 0, arrayOfByte3, m, k);
    System.arraycopy(arrayOfByte1, 0, this.block, m + this.messageLength, arrayOfByte1.length);
    arrayOfByte1 = maskGeneratorFunction1(arrayOfByte2, 0, j, this.block.length - this.hLen - i);
    j = 0;
    while (j != arrayOfByte1.length)
    {
      arrayOfByte3 = this.block;
      arrayOfByte3[j] = ((byte)(arrayOfByte3[j] ^ arrayOfByte1[j]));
      j += 1;
    }
    arrayOfByte1 = this.block;
    j = arrayOfByte1.length;
    k = this.hLen;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j - k - i, k);
    i = this.trailer;
    if (i == 188)
    {
      arrayOfByte1 = this.block;
      arrayOfByte1[(arrayOfByte1.length - 1)] = -68;
    }
    else
    {
      arrayOfByte1 = this.block;
      arrayOfByte1[(arrayOfByte1.length - 2)] = ((byte)(i >>> 8));
      arrayOfByte1[(arrayOfByte1.length - 1)] = ((byte)i);
    }
    arrayOfByte1 = this.block;
    arrayOfByte1[0] = ((byte)(arrayOfByte1[0] & 0x7F));
    arrayOfByte1 = this.cipher.processBlock(arrayOfByte1, 0, arrayOfByte1.length);
    i = this.messageLength;
    this.recoveredMessage = new byte[i];
    if (i > this.mBuf.length) {
      bool = false;
    }
    this.fullMessage = bool;
    arrayOfByte2 = this.mBuf;
    arrayOfByte3 = this.recoveredMessage;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte3.length);
    clearBlock(this.mBuf);
    clearBlock(this.block);
    this.messageLength = 0;
    return arrayOfByte1;
  }
  
  public byte[] getRecoveredMessage()
  {
    return this.recoveredMessage;
  }
  
  public boolean hasFullMessage()
  {
    return this.fullMessage;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    int j = this.saltLength;
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      localObject2 = (ParametersWithRandom)paramCipherParameters;
      localObject1 = (RSAKeyParameters)((ParametersWithRandom)localObject2).getParameters();
      i = j;
      paramCipherParameters = (CipherParameters)localObject1;
      if (paramBoolean) {
        localObject2 = ((ParametersWithRandom)localObject2).getRandom();
      }
    }
    else
    {
      for (paramCipherParameters = (CipherParameters)localObject1;; paramCipherParameters = (CipherParameters)localObject1)
      {
        this.random = ((SecureRandom)localObject2);
        i = j;
        break;
        if ((paramCipherParameters instanceof ParametersWithSalt))
        {
          localObject1 = (ParametersWithSalt)paramCipherParameters;
          paramCipherParameters = (RSAKeyParameters)((ParametersWithSalt)localObject1).getParameters();
          localObject1 = ((ParametersWithSalt)localObject1).getSalt();
          this.standardSalt = ((byte[])localObject1);
          i = localObject1.length;
          if (localObject1.length == this.saltLength) {
            break;
          }
          throw new IllegalArgumentException("Fixed salt is of wrong length");
        }
        localObject1 = (RSAKeyParameters)paramCipherParameters;
        i = j;
        paramCipherParameters = (CipherParameters)localObject1;
        if (!paramBoolean) {
          break;
        }
        localObject2 = new SecureRandom();
      }
    }
    this.cipher.init(paramBoolean, paramCipherParameters);
    j = paramCipherParameters.getModulus().bitLength();
    this.keyBits = j;
    paramCipherParameters = new byte[(j + 7) / 8];
    this.block = paramCipherParameters;
    j = this.trailer;
    int k = paramCipherParameters.length;
    if (j == 188) {
      this.mBuf = new byte[k - this.digest.getDigestSize() - i - 1 - 1];
    } else {
      this.mBuf = new byte[k - this.digest.getDigestSize() - i - 1 - 2];
    }
    reset();
  }
  
  public void reset()
  {
    this.digest.reset();
    this.messageLength = 0;
    byte[] arrayOfByte = this.mBuf;
    if (arrayOfByte != null) {
      clearBlock(arrayOfByte);
    }
    arrayOfByte = this.recoveredMessage;
    if (arrayOfByte != null)
    {
      clearBlock(arrayOfByte);
      this.recoveredMessage = null;
    }
    this.fullMessage = false;
    if (this.preSig != null)
    {
      this.preSig = null;
      clearBlock(this.preBlock);
      this.preBlock = null;
    }
  }
  
  public void update(byte paramByte)
  {
    if (this.preSig == null)
    {
      int i = this.messageLength;
      byte[] arrayOfByte = this.mBuf;
      if (i < arrayOfByte.length)
      {
        this.messageLength = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
    }
    this.digest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (this.preSig == null) {
      for (;;)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt2 <= 0) {
          break;
        }
        i = paramInt1;
        j = paramInt2;
        if (this.messageLength >= this.mBuf.length) {
          break;
        }
        update(paramArrayOfByte[paramInt1]);
        paramInt1 += 1;
        paramInt2 -= 1;
      }
    }
    if (j > 0) {
      this.digest.update(paramArrayOfByte, i, j);
    }
  }
  
  public void updateWithRecoveredMessage(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    Object localObject2 = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
    int i = localObject2.length;
    int j = this.keyBits;
    Object localObject1 = localObject2;
    if (i < (j + 7) / 8)
    {
      i = (j + 7) / 8;
      localObject1 = new byte[i];
      System.arraycopy(localObject2, 0, localObject1, i - localObject2.length, localObject2.length);
      clearBlock((byte[])localObject2);
    }
    i = localObject1.length;
    boolean bool = true;
    j = localObject1[(i - 1)];
    i = 2;
    if ((j & 0xFF ^ 0xBC) == 0)
    {
      i = 1;
    }
    else
    {
      j = (localObject1[(localObject1.length - 2)] & 0xFF) << 8 | localObject1[(localObject1.length - 1)] & 0xFF;
      localObject2 = ISOTrailers.getTrailer(this.digest);
      if (localObject2 == null) {
        break label424;
      }
      if (j != ((Integer)localObject2).intValue()) {
        break label391;
      }
    }
    localObject2 = new byte[this.hLen];
    this.digest.doFinal((byte[])localObject2, 0);
    j = localObject1.length;
    int k = this.hLen;
    localObject2 = maskGeneratorFunction1((byte[])localObject1, j - k - i, k, localObject1.length - k - i);
    j = 0;
    while (j != localObject2.length)
    {
      localObject1[j] = ((byte)(localObject1[j] ^ localObject2[j]));
      j += 1;
    }
    localObject1[0] = ((byte)(localObject1[0] & 0x7F));
    j = 0;
    while ((j != localObject1.length) && (localObject1[j] != 1)) {
      j += 1;
    }
    j += 1;
    if (j >= localObject1.length) {
      clearBlock((byte[])localObject1);
    }
    if (j <= 1) {
      bool = false;
    }
    this.fullMessage = bool;
    localObject2 = new byte[localObject2.length - j - this.saltLength];
    this.recoveredMessage = ((byte[])localObject2);
    System.arraycopy(localObject1, j, localObject2, 0, localObject2.length);
    localObject2 = this.recoveredMessage;
    System.arraycopy(localObject2, 0, this.mBuf, 0, localObject2.length);
    this.preSig = paramArrayOfByte;
    this.preBlock = ((byte[])localObject1);
    this.preMStart = j;
    this.preTLength = i;
    return;
    label391:
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("signer initialised with wrong digest for trailer ");
    paramArrayOfByte.append(j);
    throw new IllegalStateException(paramArrayOfByte.toString());
    label424:
    throw new IllegalArgumentException("unrecognised hash in signature");
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    int i = this.hLen;
    byte[] arrayOfByte1 = new byte[i];
    this.digest.doFinal(arrayOfByte1, 0);
    byte[] arrayOfByte2 = this.preSig;
    if (arrayOfByte2 == null) {}
    try
    {
      updateWithRecoveredMessage(paramArrayOfByte);
      if (Arrays.areEqual(arrayOfByte2, paramArrayOfByte))
      {
        paramArrayOfByte = this.preBlock;
        int j = this.preMStart;
        int k = this.preTLength;
        this.preSig = null;
        this.preBlock = null;
        arrayOfByte2 = new byte[8];
        LtoOSP(this.recoveredMessage.length * 8, arrayOfByte2);
        this.digest.update(arrayOfByte2, 0, 8);
        arrayOfByte2 = this.recoveredMessage;
        if (arrayOfByte2.length != 0) {
          this.digest.update(arrayOfByte2, 0, arrayOfByte2.length);
        }
        this.digest.update(arrayOfByte1, 0, i);
        arrayOfByte1 = this.standardSalt;
        if (arrayOfByte1 != null) {
          this.digest.update(arrayOfByte1, 0, arrayOfByte1.length);
        } else {
          this.digest.update(paramArrayOfByte, j + this.recoveredMessage.length, this.saltLength);
        }
        int m = this.digest.getDigestSize();
        arrayOfByte1 = new byte[m];
        this.digest.doFinal(arrayOfByte1, 0);
        int n = paramArrayOfByte.length;
        i = 0;
        j = 1;
        while (i != m)
        {
          if (arrayOfByte1[i] != paramArrayOfByte[(n - k - m + i)]) {
            j = 0;
          }
          i += 1;
        }
        clearBlock(paramArrayOfByte);
        clearBlock(arrayOfByte1);
        if (j == 0)
        {
          this.fullMessage = false;
          this.messageLength = 0;
          clearBlock(this.recoveredMessage);
          return false;
        }
        if ((this.messageLength != 0) && (!isSameAs(this.mBuf, this.recoveredMessage)))
        {
          this.messageLength = 0;
          clearBlock(this.mBuf);
          return false;
        }
        this.messageLength = 0;
        clearBlock(this.mBuf);
        return true;
      }
      throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ISO9796d2PSSSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */