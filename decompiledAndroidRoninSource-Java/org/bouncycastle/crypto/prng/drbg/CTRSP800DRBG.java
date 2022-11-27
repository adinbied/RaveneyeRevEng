package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class CTRSP800DRBG
  implements SP80090DRBG
{
  private static final int AES_MAX_BITS_REQUEST = 262144;
  private static final long AES_RESEED_MAX = 140737488355328L;
  private static final byte[] K_BITS = Hex.decode("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
  private static final int TDEA_MAX_BITS_REQUEST = 4096;
  private static final long TDEA_RESEED_MAX = 2147483648L;
  private byte[] _Key;
  private byte[] _V;
  private BlockCipher _engine;
  private EntropySource _entropySource;
  private boolean _isTDEA = false;
  private int _keySizeInBits;
  private long _reseedCounter = 0L;
  private int _securityStrength;
  private int _seedLength;
  
  public CTRSP800DRBG(BlockCipher paramBlockCipher, int paramInt1, int paramInt2, EntropySource paramEntropySource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._entropySource = paramEntropySource;
    this._engine = paramBlockCipher;
    this._keySizeInBits = paramInt1;
    this._securityStrength = paramInt2;
    this._seedLength = (paramBlockCipher.getBlockSize() * 8 + paramInt1);
    this._isTDEA = isTDEA(paramBlockCipher);
    if (paramInt2 <= 256)
    {
      if (getMaxSecurityStrength(paramBlockCipher, paramInt1) >= paramInt2)
      {
        if (paramEntropySource.entropySize() >= paramInt2)
        {
          CTR_DRBG_Instantiate_algorithm(getEntropy(), paramArrayOfByte2, paramArrayOfByte1);
          return;
        }
        throw new IllegalArgumentException("Not enough entropy for security strength required");
      }
      throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
    }
    throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
  }
  
  private void BCC(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int j = this._engine.getBlockSize();
    byte[] arrayOfByte1 = new byte[j];
    int k = paramArrayOfByte4.length / j;
    byte[] arrayOfByte2 = new byte[j];
    this._engine.init(true, new KeyParameter(expandKey(paramArrayOfByte2)));
    this._engine.processBlock(paramArrayOfByte3, 0, arrayOfByte1, 0);
    int i = 0;
    while (i < k)
    {
      XOR(arrayOfByte2, arrayOfByte1, paramArrayOfByte4, i * j);
      this._engine.processBlock(arrayOfByte2, 0, arrayOfByte1, 0);
      i += 1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
  }
  
  private byte[] Block_Cipher_df(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this._engine.getBlockSize();
    int j = paramArrayOfByte.length;
    int k = paramInt / 8;
    int m = j + 8;
    byte[] arrayOfByte1 = new byte[(m + 1 + i - 1) / i * i];
    copyIntToByteArray(arrayOfByte1, j, 0);
    copyIntToByteArray(arrayOfByte1, k, 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 8, j);
    arrayOfByte1[m] = Byte.MIN_VALUE;
    j = this._keySizeInBits;
    int n = j / 8 + i;
    byte[] arrayOfByte2 = new byte[n];
    byte[] arrayOfByte3 = new byte[i];
    byte[] arrayOfByte4 = new byte[i];
    int i1 = j / 8;
    paramArrayOfByte = new byte[i1];
    System.arraycopy(K_BITS, 0, paramArrayOfByte, 0, i1);
    j = 0;
    for (;;)
    {
      int i2 = j * i;
      if (i2 * 8 >= this._keySizeInBits + i * 8) {
        break;
      }
      copyIntToByteArray(arrayOfByte4, j, 0);
      BCC(arrayOfByte3, paramArrayOfByte, arrayOfByte4, arrayOfByte1);
      m = n - i2;
      k = m;
      if (m > i) {
        k = i;
      }
      System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i2, k);
      j += 1;
    }
    arrayOfByte1 = new byte[i];
    System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, 0, i1);
    System.arraycopy(arrayOfByte2, i1, arrayOfByte1, 0, i);
    m = paramInt / 2;
    arrayOfByte2 = new byte[m];
    this._engine.init(true, new KeyParameter(expandKey(paramArrayOfByte)));
    paramInt = 0;
    for (;;)
    {
      n = paramInt * i;
      if (n >= m) {
        break;
      }
      this._engine.processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
      k = m - n;
      j = k;
      if (k > i) {
        j = i;
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, n, j);
      paramInt += 1;
    }
    return arrayOfByte2;
  }
  
  private void CTR_DRBG_Instantiate_algorithm(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = Block_Cipher_df(Arrays.concatenate(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3), this._seedLength);
    int i = this._engine.getBlockSize();
    paramArrayOfByte2 = new byte[(this._keySizeInBits + 7) / 8];
    this._Key = paramArrayOfByte2;
    paramArrayOfByte3 = new byte[i];
    this._V = paramArrayOfByte3;
    CTR_DRBG_Update(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    this._reseedCounter = 1L;
  }
  
  private void CTR_DRBG_Reseed_algorithm(byte[] paramArrayOfByte)
  {
    CTR_DRBG_Update(Block_Cipher_df(Arrays.concatenate(getEntropy(), paramArrayOfByte), this._seedLength), this._Key, this._V);
    this._reseedCounter = 1L;
  }
  
  private void CTR_DRBG_Update(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    int n = paramArrayOfByte1.length;
    byte[] arrayOfByte1 = new byte[n];
    byte[] arrayOfByte2 = new byte[this._engine.getBlockSize()];
    int k = this._engine.getBlockSize();
    this._engine.init(true, new KeyParameter(expandKey(paramArrayOfByte2)));
    int i = 0;
    for (;;)
    {
      int i1 = i * k;
      if (i1 >= paramArrayOfByte1.length) {
        break;
      }
      addOneTo(paramArrayOfByte3);
      this._engine.processBlock(paramArrayOfByte3, 0, arrayOfByte2, 0);
      int m = n - i1;
      int j = m;
      if (m > k) {
        j = k;
      }
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i1, j);
      i += 1;
    }
    XOR(arrayOfByte1, paramArrayOfByte1, arrayOfByte1, 0);
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length);
    System.arraycopy(arrayOfByte1, paramArrayOfByte2.length, paramArrayOfByte3, 0, paramArrayOfByte3.length);
  }
  
  private void XOR(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte2[i] ^ paramArrayOfByte3[(i + paramInt)]));
      i += 1;
    }
  }
  
  private void addOneTo(byte[] paramArrayOfByte)
  {
    int j = 1;
    int i = 1;
    while (j <= paramArrayOfByte.length)
    {
      int k = (paramArrayOfByte[(paramArrayOfByte.length - j)] & 0xFF) + i;
      if (k > 255) {
        i = 1;
      } else {
        i = 0;
      }
      paramArrayOfByte[(paramArrayOfByte.length - j)] = ((byte)k);
      j += 1;
    }
  }
  
  private void copyIntToByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  private byte[] getEntropy()
  {
    byte[] arrayOfByte = this._entropySource.getEntropy();
    if (arrayOfByte.length >= (this._securityStrength + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private int getMaxSecurityStrength(BlockCipher paramBlockCipher, int paramInt)
  {
    if ((isTDEA(paramBlockCipher)) && (paramInt == 168)) {
      return 112;
    }
    if (paramBlockCipher.getAlgorithmName().equals("AES")) {
      return paramInt;
    }
    return -1;
  }
  
  private boolean isTDEA(BlockCipher paramBlockCipher)
  {
    return (paramBlockCipher.getAlgorithmName().equals("DESede")) || (paramBlockCipher.getAlgorithmName().equals("TDEA"));
  }
  
  private void padKey(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramInt1 + 0;
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)(paramArrayOfByte1[i] & 0xFE));
    i = paramArrayOfByte1[i];
    int j = paramInt1 + 1;
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i << 7 | (paramArrayOfByte1[j] & 0xFC) >>> 1));
    i = paramArrayOfByte1[j];
    j = paramInt1 + 2;
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)(i << 6 | (paramArrayOfByte1[j] & 0xF8) >>> 2));
    i = paramArrayOfByte1[j];
    j = paramInt1 + 3;
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)(i << 5 | (paramArrayOfByte1[j] & 0xF0) >>> 3));
    i = paramArrayOfByte1[j];
    j = paramInt1 + 4;
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)(i << 4 | (paramArrayOfByte1[j] & 0xE0) >>> 4));
    i = paramArrayOfByte1[j];
    j = paramInt1 + 5;
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)(i << 3 | (paramArrayOfByte1[j] & 0xC0) >>> 5));
    i = paramArrayOfByte1[j];
    j = paramInt1 + 6;
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)(i << 2 | (paramArrayOfByte1[j] & 0x80) >>> 6));
    paramInt1 = paramInt2 + 7;
    paramArrayOfByte2[paramInt1] = ((byte)(paramArrayOfByte1[j] << 1));
    while (paramInt2 <= paramInt1)
    {
      i = paramArrayOfByte2[paramInt2];
      paramArrayOfByte2[paramInt2] = ((byte)((i >> 7 ^ i >> 1 ^ i >> 2 ^ i >> 3 ^ i >> 4 ^ i >> 5 ^ i >> 6 ^ 0x1) & 0x1 | i & 0xFE));
      paramInt2 += 1;
    }
  }
  
  byte[] expandKey(byte[] paramArrayOfByte)
  {
    if (this._isTDEA)
    {
      byte[] arrayOfByte = new byte[24];
      padKey(paramArrayOfByte, 0, arrayOfByte, 0);
      padKey(paramArrayOfByte, 7, arrayOfByte, 8);
      padKey(paramArrayOfByte, 14, arrayOfByte, 16);
      return arrayOfByte;
    }
    return paramArrayOfByte;
  }
  
  public int generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    boolean bool = this._isTDEA;
    long l = this._reseedCounter;
    if (bool)
    {
      if (l > 2147483648L) {
        return -1;
      }
      if (Utils.isTooLarge(paramArrayOfByte1, 512)) {
        throw new IllegalArgumentException("Number of bits per request limited to 4096");
      }
    }
    else
    {
      if (l > 140737488355328L) {
        return -1;
      }
      if (Utils.isTooLarge(paramArrayOfByte1, 32768)) {
        break label297;
      }
    }
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramBoolean)
    {
      CTR_DRBG_Reseed_algorithm(paramArrayOfByte2);
      arrayOfByte = null;
    }
    if (arrayOfByte != null)
    {
      paramArrayOfByte2 = Block_Cipher_df(arrayOfByte, this._seedLength);
      CTR_DRBG_Update(paramArrayOfByte2, this._Key, this._V);
    }
    else
    {
      paramArrayOfByte2 = new byte[this._seedLength];
    }
    int k = this._V.length;
    arrayOfByte = new byte[k];
    this._engine.init(true, new KeyParameter(expandKey(this._Key)));
    int i = 0;
    while (i <= paramArrayOfByte1.length / k)
    {
      int j = paramArrayOfByte1.length;
      int m = i * k;
      if (j - m > k) {
        j = k;
      } else {
        j = paramArrayOfByte1.length - this._V.length * i;
      }
      if (j != 0)
      {
        addOneTo(this._V);
        this._engine.processBlock(this._V, 0, arrayOfByte, 0);
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte1, m, j);
      }
      i += 1;
    }
    CTR_DRBG_Update(paramArrayOfByte2, this._Key, this._V);
    this._reseedCounter += 1L;
    return paramArrayOfByte1.length * 8;
    label297:
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  public int getBlockSize()
  {
    return this._V.length * 8;
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    CTR_DRBG_Reseed_algorithm(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\CTRSP800DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */