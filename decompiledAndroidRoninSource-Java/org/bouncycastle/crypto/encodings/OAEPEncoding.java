package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class OAEPEncoding
  implements AsymmetricBlockCipher
{
  private byte[] defHash;
  private AsymmetricBlockCipher engine;
  private boolean forEncryption;
  private Digest mgf1Hash;
  private SecureRandom random;
  
  public OAEPEncoding(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this(paramAsymmetricBlockCipher, DigestFactory.createSHA1(), null);
  }
  
  public OAEPEncoding(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest)
  {
    this(paramAsymmetricBlockCipher, paramDigest, null);
  }
  
  public OAEPEncoding(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest1, Digest paramDigest2, byte[] paramArrayOfByte)
  {
    this.engine = paramAsymmetricBlockCipher;
    this.mgf1Hash = paramDigest2;
    this.defHash = new byte[paramDigest1.getDigestSize()];
    paramDigest1.reset();
    if (paramArrayOfByte != null) {
      paramDigest1.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    paramDigest1.doFinal(this.defHash, 0);
  }
  
  public OAEPEncoding(AsymmetricBlockCipher paramAsymmetricBlockCipher, Digest paramDigest, byte[] paramArrayOfByte)
  {
    this(paramAsymmetricBlockCipher, paramDigest, paramDigest, paramArrayOfByte);
  }
  
  private void ItoOSP(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(paramInt >>> 24));
    paramArrayOfByte[1] = ((byte)(paramInt >>> 16));
    paramArrayOfByte[2] = ((byte)(paramInt >>> 8));
    paramArrayOfByte[3] = ((byte)(paramInt >>> 0));
  }
  
  private byte[] maskGeneratorFunction1(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = new byte[paramInt3];
    int j = this.mgf1Hash.getDigestSize();
    byte[] arrayOfByte2 = new byte[j];
    byte[] arrayOfByte3 = new byte[4];
    this.mgf1Hash.reset();
    int i = 0;
    while (i < paramInt3 / j)
    {
      ItoOSP(i, arrayOfByte3);
      this.mgf1Hash.update(paramArrayOfByte, paramInt1, paramInt2);
      this.mgf1Hash.update(arrayOfByte3, 0, 4);
      this.mgf1Hash.doFinal(arrayOfByte2, 0);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i * j, j);
      i += 1;
    }
    j *= i;
    if (j < paramInt3)
    {
      ItoOSP(i, arrayOfByte3);
      this.mgf1Hash.update(paramArrayOfByte, paramInt1, paramInt2);
      this.mgf1Hash.update(arrayOfByte3, 0, 4);
      this.mgf1Hash.doFinal(arrayOfByte2, 0);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, paramInt3 - j);
    }
    return arrayOfByte1;
  }
  
  public byte[] decodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    byte[] arrayOfByte1 = this.engine.processBlock(paramArrayOfByte, paramInt1, paramInt2);
    int n = this.engine.getOutputBlockSize();
    paramArrayOfByte = new byte[n];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, n - arrayOfByte1.length, arrayOfByte1.length);
    if (n < this.defHash.length * 2 + 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    arrayOfByte1 = this.defHash;
    arrayOfByte1 = maskGeneratorFunction1(paramArrayOfByte, arrayOfByte1.length, n - arrayOfByte1.length, arrayOfByte1.length);
    paramInt1 = 0;
    byte[] arrayOfByte2;
    for (;;)
    {
      arrayOfByte2 = this.defHash;
      if (paramInt1 == arrayOfByte2.length) {
        break;
      }
      paramArrayOfByte[paramInt1] = ((byte)(paramArrayOfByte[paramInt1] ^ arrayOfByte1[paramInt1]));
      paramInt1 += 1;
    }
    arrayOfByte1 = maskGeneratorFunction1(paramArrayOfByte, 0, arrayOfByte2.length, n - arrayOfByte2.length);
    paramInt1 = this.defHash.length;
    while (paramInt1 != n)
    {
      paramArrayOfByte[paramInt1] = ((byte)(paramArrayOfByte[paramInt1] ^ arrayOfByte1[(paramInt1 - this.defHash.length)]));
      paramInt1 += 1;
    }
    paramInt1 = 0;
    int i = 0;
    for (;;)
    {
      arrayOfByte1 = this.defHash;
      if (paramInt1 == arrayOfByte1.length) {
        break;
      }
      if (arrayOfByte1[paramInt1] != paramArrayOfByte[(arrayOfByte1.length + paramInt1)]) {
        i = 1;
      }
      paramInt1 += 1;
    }
    paramInt1 = arrayOfByte1.length * 2;
    int j = n;
    int k;
    while (paramInt1 != n)
    {
      if (paramArrayOfByte[paramInt1] != 0) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if (j == n) {
        m = 1;
      } else {
        m = 0;
      }
      if ((k & m) != 0) {
        j = paramInt1;
      }
      paramInt1 += 1;
    }
    if (j > n - 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramArrayOfByte[j] != 1) {
      k = 1;
    } else {
      k = 0;
    }
    j += 1;
    if ((paramInt2 | i | paramInt1 | k) == 0)
    {
      paramInt1 = n - j;
      arrayOfByte1 = new byte[paramInt1];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, paramInt1);
      return arrayOfByte1;
    }
    Arrays.fill(paramArrayOfByte, (byte)0);
    throw new InvalidCipherTextException("data wrong");
  }
  
  public byte[] encodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (paramInt2 <= getInputBlockSize())
    {
      int i = getInputBlockSize() + 1 + this.defHash.length * 2;
      byte[] arrayOfByte1 = new byte[i];
      int j = i - paramInt2;
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte1, j, paramInt2);
      arrayOfByte1[(j - 1)] = 1;
      paramArrayOfByte = this.defHash;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, paramArrayOfByte.length, paramArrayOfByte.length);
      paramInt1 = this.defHash.length;
      paramArrayOfByte = new byte[paramInt1];
      this.random.nextBytes(paramArrayOfByte);
      byte[] arrayOfByte2 = maskGeneratorFunction1(paramArrayOfByte, 0, paramInt1, i - this.defHash.length);
      paramInt1 = this.defHash.length;
      while (paramInt1 != i)
      {
        arrayOfByte1[paramInt1] = ((byte)(arrayOfByte1[paramInt1] ^ arrayOfByte2[(paramInt1 - this.defHash.length)]));
        paramInt1 += 1;
      }
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, this.defHash.length);
      paramArrayOfByte = this.defHash;
      paramArrayOfByte = maskGeneratorFunction1(arrayOfByte1, paramArrayOfByte.length, i - paramArrayOfByte.length, paramArrayOfByte.length);
      paramInt1 = 0;
      while (paramInt1 != this.defHash.length)
      {
        arrayOfByte1[paramInt1] = ((byte)(arrayOfByte1[paramInt1] ^ paramArrayOfByte[paramInt1]));
        paramInt1 += 1;
      }
      return this.engine.processBlock(arrayOfByte1, 0, i);
    }
    throw new DataLengthException("input data too long");
  }
  
  public int getInputBlockSize()
  {
    int j = this.engine.getInputBlockSize();
    int i = j;
    if (this.forEncryption) {
      i = j - 1 - this.defHash.length * 2;
    }
    return i;
  }
  
  public int getOutputBlockSize()
  {
    int i = this.engine.getOutputBlockSize();
    if (this.forEncryption) {
      return i;
    }
    return i - 1 - this.defHash.length * 2;
  }
  
  public AsymmetricBlockCipher getUnderlyingCipher()
  {
    return this.engine;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    SecureRandom localSecureRandom;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localSecureRandom = ((ParametersWithRandom)paramCipherParameters).getRandom();
    } else {
      localSecureRandom = new SecureRandom();
    }
    this.random = localSecureRandom;
    this.engine.init(paramBoolean, paramCipherParameters);
    this.forEncryption = paramBoolean;
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.forEncryption) {
      return encodeBlock(paramArrayOfByte, paramInt1, paramInt2);
    }
    return decodeBlock(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\encodings\OAEPEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */