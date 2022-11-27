package org.bouncycastle.crypto.encodings;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding
  implements AsymmetricBlockCipher
{
  private static final BigInteger SIX;
  private static final BigInteger SIXTEEN = BigInteger.valueOf(16L);
  private static byte[] inverse = { 8, 15, 6, 1, 5, 2, 11, 12, 3, 4, 13, 10, 14, 9, 0, 7 };
  private static byte[] shadows;
  private int bitSize;
  private AsymmetricBlockCipher engine;
  private boolean forEncryption;
  private BigInteger modulus;
  private int padBits = 0;
  
  static
  {
    SIX = BigInteger.valueOf(6L);
    shadows = new byte[] { 14, 3, 5, 8, 9, 4, 2, 15, 0, 13, 11, 6, 7, 10, 12, 1 };
  }
  
  public ISO9796d1Encoding(AsymmetricBlockCipher paramAsymmetricBlockCipher)
  {
    this.engine = paramAsymmetricBlockCipher;
  }
  
  private static byte[] convertOutputDecryptOnly(BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    if (paramBigInteger[0] == 0)
    {
      int i = paramBigInteger.length - 1;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
  
  private byte[] decodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    paramArrayOfByte = this.engine.processBlock(paramArrayOfByte, paramInt1, paramInt2);
    int i2 = (this.bitSize + 13) / 16;
    paramArrayOfByte = new BigInteger(1, paramArrayOfByte);
    if (!paramArrayOfByte.mod(SIXTEEN).equals(SIX))
    {
      if (this.modulus.subtract(paramArrayOfByte).mod(SIXTEEN).equals(SIX)) {
        paramArrayOfByte = this.modulus.subtract(paramArrayOfByte);
      }
    }
    else
    {
      paramArrayOfByte = convertOutputDecryptOnly(paramArrayOfByte);
      if ((paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xF) == 6)
      {
        paramArrayOfByte[(paramArrayOfByte.length - 1)] = ((byte)((paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF) >>> 4 | inverse[((paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF) >> 4)] << 4));
        byte[] arrayOfByte = shadows;
        paramInt1 = arrayOfByte[((paramArrayOfByte[1] & 0xFF) >>> 4)];
        int i = (byte)(arrayOfByte[(paramArrayOfByte[1] & 0xF)] | paramInt1 << 4);
        int n = 0;
        paramArrayOfByte[0] = i;
        paramInt1 = paramArrayOfByte.length - 1;
        int j = 0;
        int k = 0;
        paramInt2 = 1;
        while (paramInt1 >= paramArrayOfByte.length - i2 * 2)
        {
          arrayOfByte = shadows;
          int m = arrayOfByte[((paramArrayOfByte[paramInt1] & 0xFF) >>> 4)];
          int i3 = arrayOfByte[(paramArrayOfByte[paramInt1] & 0xF)] | m << 4;
          int i1 = paramInt1 - 1;
          m = k;
          if (((paramArrayOfByte[i1] ^ i3) & 0xFF) != 0) {
            if (k == 0)
            {
              paramInt2 = (paramArrayOfByte[i1] ^ i3) & 0xFF;
              j = i1;
              m = 1;
            }
            else
            {
              throw new InvalidCipherTextException("invalid tsums in block");
            }
          }
          paramInt1 -= 2;
          k = m;
        }
        paramArrayOfByte[j] = 0;
        k = (paramArrayOfByte.length - j) / 2;
        arrayOfByte = new byte[k];
        paramInt1 = n;
        while (paramInt1 < k)
        {
          arrayOfByte[paramInt1] = paramArrayOfByte[(paramInt1 * 2 + j + 1)];
          paramInt1 += 1;
        }
        this.padBits = (paramInt2 - 1);
        return arrayOfByte;
      }
      throw new InvalidCipherTextException("invalid forcing byte in block");
    }
    throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
  }
  
  private byte[] encodeBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    int j = this.bitSize;
    int m = (j + 7) / 8;
    byte[] arrayOfByte = new byte[m];
    int n = this.padBits;
    int k = 1;
    int i1 = (j + 13) / 16;
    j = 0;
    while (j < i1)
    {
      if (j > i1 - paramInt2)
      {
        int i2 = i1 - j;
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i2, arrayOfByte, m - i1, i2);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, m - (j + paramInt2), paramInt2);
      }
      j += paramInt2;
    }
    paramInt1 = m - i1 * 2;
    while (paramInt1 != m)
    {
      int i = arrayOfByte[(m - i1 + paramInt1 / 2)];
      paramArrayOfByte = shadows;
      j = paramArrayOfByte[((i & 0xFF) >>> 4)];
      arrayOfByte[paramInt1] = ((byte)(paramArrayOfByte[(i & 0xF)] | j << 4));
      arrayOfByte[(paramInt1 + 1)] = i;
      paramInt1 += 2;
    }
    paramInt1 = m - paramInt2 * 2;
    arrayOfByte[paramInt1] = ((byte)(arrayOfByte[paramInt1] ^ n + 1));
    paramInt1 = m - 1;
    arrayOfByte[paramInt1] = ((byte)(arrayOfByte[paramInt1] << 4 | 0x6));
    paramInt1 = 8 - (this.bitSize - 1) % 8;
    if (paramInt1 != 8)
    {
      arrayOfByte[0] = ((byte)(arrayOfByte[0] & 255 >>> paramInt1));
      arrayOfByte[0] = ((byte)(128 >>> paramInt1 | arrayOfByte[0]));
      paramInt1 = 0;
    }
    else
    {
      arrayOfByte[0] = 0;
      arrayOfByte[1] = ((byte)(arrayOfByte[1] | 0x80));
      paramInt1 = k;
    }
    return this.engine.processBlock(arrayOfByte, paramInt1, m - paramInt1);
  }
  
  public int getInputBlockSize()
  {
    int j = this.engine.getInputBlockSize();
    int i = j;
    if (this.forEncryption) {
      i = (j + 1) / 2;
    }
    return i;
  }
  
  public int getOutputBlockSize()
  {
    int i = this.engine.getOutputBlockSize();
    if (this.forEncryption) {
      return i;
    }
    return (i + 1) / 2;
  }
  
  public int getPadBits()
  {
    return this.padBits;
  }
  
  public AsymmetricBlockCipher getUnderlyingCipher()
  {
    return this.engine;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    RSAKeyParameters localRSAKeyParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localRSAKeyParameters = (RSAKeyParameters)((ParametersWithRandom)paramCipherParameters).getParameters();
    } else {
      localRSAKeyParameters = (RSAKeyParameters)paramCipherParameters;
    }
    this.engine.init(paramBoolean, paramCipherParameters);
    paramCipherParameters = localRSAKeyParameters.getModulus();
    this.modulus = paramCipherParameters;
    this.bitSize = paramCipherParameters.bitLength();
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
  
  public void setPadBits(int paramInt)
  {
    if (paramInt <= 7)
    {
      this.padBits = paramInt;
      return;
    }
    throw new IllegalArgumentException("padBits > 7");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\encodings\ISO9796d1Encoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */