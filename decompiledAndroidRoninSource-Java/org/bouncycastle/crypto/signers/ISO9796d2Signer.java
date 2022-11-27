package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class ISO9796d2Signer
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
  private int keyBits;
  private byte[] mBuf;
  private int messageLength;
  private byte[] preBlock;
  private byte[] preSig;
  private byte[] recoveredMessage;
  private int trailer;
  
  public ISO9796d2Signer(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest)
  {
    this(paramAsymmetricBlockCipher, paramDigest, false);
  }
  
  public ISO9796d2Signer(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, boolean paramBoolean)
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
  
  private boolean isSameAs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = this.messageLength;
    byte[] arrayOfByte = this.mBuf;
    int j = arrayOfByte.length;
    boolean bool2 = true;
    boolean bool1 = true;
    if (i > j)
    {
      if (arrayOfByte.length > paramArrayOfByte2.length) {
        bool1 = false;
      }
      i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i == this.mBuf.length) {
          break;
        }
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          bool1 = false;
        }
        i += 1;
      }
    }
    bool1 = bool2;
    if (i != paramArrayOfByte2.length) {
      bool1 = false;
    }
    i = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i == paramArrayOfByte2.length) {
        break;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        bool1 = false;
      }
      i += 1;
    }
    return bool2;
  }
  
  private boolean returnFalse(byte[] paramArrayOfByte)
  {
    this.messageLength = 0;
    clearBlock(this.mBuf);
    clearBlock(paramArrayOfByte);
    return false;
  }
  
  public byte[] generateSignature()
    throws CryptoException
  {
    int k = this.digest.getDigestSize();
    int i = this.trailer;
    boolean bool = true;
    if (i == 188)
    {
      localObject = this.block;
      i = localObject.length - k - 1;
      this.digest.doFinal((byte[])localObject, i);
      localObject = this.block;
      localObject[(localObject.length - 1)] = -68;
      j = 8;
    }
    else
    {
      j = 16;
      localObject = this.block;
      i = localObject.length - k - 2;
      this.digest.doFinal((byte[])localObject, i);
      localObject = this.block;
      m = localObject.length;
      int n = this.trailer;
      localObject[(m - 2)] = ((byte)(n >>> 8));
      localObject[(localObject.length - 1)] = ((byte)n);
    }
    int m = this.messageLength;
    int j = (k + m) * 8 + j + 4 - this.keyBits;
    if (j > 0)
    {
      m -= (j + 7) / 8;
      j = 96;
      k = i - m;
      System.arraycopy(this.mBuf, 0, this.block, k, m);
      this.recoveredMessage = new byte[m];
      i = j;
      j = k;
    }
    else
    {
      k = 64;
      j = i - m;
      System.arraycopy(this.mBuf, 0, this.block, j, m);
      this.recoveredMessage = new byte[this.messageLength];
      i = k;
    }
    k = j - 1;
    if (k > 0)
    {
      j = k;
      while (j != 0)
      {
        this.block[j] = -69;
        j -= 1;
      }
      localObject = this.block;
      localObject[k] = ((byte)(localObject[k] ^ 0x1));
      localObject[0] = 11;
      localObject[0] = ((byte)(localObject[0] | i));
    }
    else
    {
      localObject = this.block;
      localObject[0] = 10;
      localObject[0] = ((byte)(localObject[0] | i));
    }
    Object localObject = this.cipher;
    byte[] arrayOfByte1 = this.block;
    localObject = ((AsymmetricBlockCipher)localObject).processBlock(arrayOfByte1, 0, arrayOfByte1.length);
    if ((i & 0x20) != 0) {
      bool = false;
    }
    this.fullMessage = bool;
    arrayOfByte1 = this.mBuf;
    byte[] arrayOfByte2 = this.recoveredMessage;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    this.messageLength = 0;
    clearBlock(this.mBuf);
    clearBlock(this.block);
    return (byte[])localObject;
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
    paramCipherParameters = (RSAKeyParameters)paramCipherParameters;
    this.cipher.init(paramBoolean, paramCipherParameters);
    int i = paramCipherParameters.getModulus().bitLength();
    this.keyBits = i;
    paramCipherParameters = new byte[(i + 7) / 8];
    this.block = paramCipherParameters;
    i = this.trailer;
    int j = paramCipherParameters.length;
    if (i == 188) {
      this.mBuf = new byte[j - this.digest.getDigestSize() - 2];
    } else {
      this.mBuf = new byte[j - this.digest.getDigestSize() - 3];
    }
    reset();
  }
  
  public void reset()
  {
    this.digest.reset();
    this.messageLength = 0;
    clearBlock(this.mBuf);
    byte[] arrayOfByte = this.recoveredMessage;
    if (arrayOfByte != null) {
      clearBlock(arrayOfByte);
    }
    this.recoveredMessage = null;
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
    this.digest.update(paramByte);
    int i = this.messageLength;
    byte[] arrayOfByte = this.mBuf;
    if (i < arrayOfByte.length) {
      arrayOfByte[i] = paramByte;
    }
    this.messageLength += 1;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt2 > 0) && (this.messageLength < this.mBuf.length))
    {
      update(paramArrayOfByte[paramInt1]);
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
    this.messageLength += paramInt2;
  }
  
  public void updateWithRecoveredMessage(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    byte[] arrayOfByte = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
    if ((arrayOfByte[0] & 0xC0 ^ 0x40) == 0)
    {
      if ((arrayOfByte[(arrayOfByte.length - 1)] & 0xF ^ 0xC) == 0)
      {
        int j = arrayOfByte[(arrayOfByte.length - 1)];
        int i = 2;
        Object localObject;
        if ((j & 0xFF ^ 0xBC) == 0)
        {
          i = 1;
        }
        else
        {
          j = (arrayOfByte[(arrayOfByte.length - 2)] & 0xFF) << 8 | arrayOfByte[(arrayOfByte.length - 1)] & 0xFF;
          localObject = ISOTrailers.getTrailer(this.digest);
          if (localObject == null) {
            break label354;
          }
          if (j != ((Integer)localObject).intValue()) {
            break label321;
          }
        }
        j = 0;
        while ((j != arrayOfByte.length) && ((arrayOfByte[j] & 0xF ^ 0xA) != 0)) {
          j += 1;
        }
        j += 1;
        i = arrayOfByte.length - i - this.digest.getDigestSize() - j;
        if (i > 0)
        {
          if ((arrayOfByte[0] & 0x20) == 0)
          {
            this.fullMessage = true;
            localObject = new byte[i];
            this.recoveredMessage = ((byte[])localObject);
            System.arraycopy(arrayOfByte, j, localObject, 0, localObject.length);
          }
          else
          {
            this.fullMessage = false;
            localObject = new byte[i];
            this.recoveredMessage = ((byte[])localObject);
            System.arraycopy(arrayOfByte, j, localObject, 0, localObject.length);
          }
          this.preSig = paramArrayOfByte;
          this.preBlock = arrayOfByte;
          paramArrayOfByte = this.digest;
          arrayOfByte = this.recoveredMessage;
          paramArrayOfByte.update(arrayOfByte, 0, arrayOfByte.length);
          paramArrayOfByte = this.recoveredMessage;
          this.messageLength = paramArrayOfByte.length;
          System.arraycopy(paramArrayOfByte, 0, this.mBuf, 0, paramArrayOfByte.length);
          return;
        }
        throw new InvalidCipherTextException("malformed block");
        label321:
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("signer initialised with wrong digest for trailer ");
        paramArrayOfByte.append(j);
        throw new IllegalStateException(paramArrayOfByte.toString());
        label354:
        throw new IllegalArgumentException("unrecognised hash in signature");
      }
      throw new InvalidCipherTextException("malformed signature");
    }
    throw new InvalidCipherTextException("malformed signature");
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    Object localObject = this.preSig;
    if (localObject == null) {}
    try
    {
      paramArrayOfByte = this.cipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (Arrays.areEqual((byte[])localObject, paramArrayOfByte))
      {
        paramArrayOfByte = this.preBlock;
        this.preSig = null;
        this.preBlock = null;
        if ((paramArrayOfByte[0] & 0xC0 ^ 0x40) != 0) {
          return returnFalse(paramArrayOfByte);
        }
        if ((paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xF ^ 0xC) != 0) {
          return returnFalse(paramArrayOfByte);
        }
        int j = paramArrayOfByte[(paramArrayOfByte.length - 1)];
        int i = 2;
        if ((j & 0xFF ^ 0xBC) == 0)
        {
          i = 1;
        }
        else
        {
          j = (paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) << 8 | paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
          localObject = ISOTrailers.getTrailer(this.digest);
          if (localObject == null) {
            break label572;
          }
          if (j != ((Integer)localObject).intValue()) {
            break label539;
          }
        }
        j = 0;
        while ((j != paramArrayOfByte.length) && ((paramArrayOfByte[j] & 0xF ^ 0xA) != 0)) {
          j += 1;
        }
        int k = j + 1;
        int m = this.digest.getDigestSize();
        localObject = new byte[m];
        int n = paramArrayOfByte.length - i - m;
        int i1 = n - k;
        if (i1 <= 0) {
          return returnFalse(paramArrayOfByte);
        }
        int i2;
        if ((paramArrayOfByte[0] & 0x20) == 0)
        {
          this.fullMessage = true;
          if (this.messageLength > i1) {
            return returnFalse(paramArrayOfByte);
          }
          this.digest.reset();
          this.digest.update(paramArrayOfByte, k, i1);
          this.digest.doFinal((byte[])localObject, 0);
          i = 0;
          j = 1;
          while (i != m)
          {
            i2 = n + i;
            paramArrayOfByte[i2] = ((byte)(paramArrayOfByte[i2] ^ localObject[i]));
            if (paramArrayOfByte[i2] != 0) {
              j = 0;
            }
            i += 1;
          }
          if (j == 0) {
            return returnFalse(paramArrayOfByte);
          }
          localObject = new byte[i1];
          this.recoveredMessage = ((byte[])localObject);
          System.arraycopy(paramArrayOfByte, k, localObject, 0, localObject.length);
        }
        else
        {
          this.fullMessage = false;
          this.digest.doFinal((byte[])localObject, 0);
          i = 0;
          j = 1;
          while (i != m)
          {
            i2 = n + i;
            paramArrayOfByte[i2] = ((byte)(paramArrayOfByte[i2] ^ localObject[i]));
            if (paramArrayOfByte[i2] != 0) {
              j = 0;
            }
            i += 1;
          }
          if (j == 0) {
            return returnFalse(paramArrayOfByte);
          }
          localObject = new byte[i1];
          this.recoveredMessage = ((byte[])localObject);
          System.arraycopy(paramArrayOfByte, k, localObject, 0, localObject.length);
        }
        if ((this.messageLength != 0) && (!isSameAs(this.mBuf, this.recoveredMessage))) {
          return returnFalse(paramArrayOfByte);
        }
        clearBlock(this.mBuf);
        clearBlock(paramArrayOfByte);
        this.messageLength = 0;
        return true;
        label539:
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("signer initialised with wrong digest for trailer ");
        paramArrayOfByte.append(j);
        throw new IllegalStateException(paramArrayOfByte.toString());
        label572:
        throw new IllegalArgumentException("unrecognised hash in signature");
      }
      throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ISO9796d2Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */