package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;

public final class WhirlpoolDigest
  implements ExtendedDigest, Memoable
{
  private static final int BITCOUNT_ARRAY_SIZE = 32;
  private static final int BYTE_LENGTH = 64;
  private static final long[] C0;
  private static final long[] C1;
  private static final long[] C2;
  private static final long[] C3;
  private static final long[] C4;
  private static final long[] C5;
  private static final long[] C6;
  private static final long[] C7;
  private static final int DIGEST_LENGTH_BYTES = 64;
  private static final short[] EIGHT;
  private static final int REDUCTION_POLYNOMIAL = 285;
  private static final int ROUNDS = 10;
  private static final int[] SBOX = { 24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, 200, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134 };
  private long[] _K = new long[8];
  private long[] _L = new long[8];
  private short[] _bitCount = new short[32];
  private long[] _block = new long[8];
  private byte[] _buffer = new byte[64];
  private int _bufferPos = 0;
  private long[] _hash = new long[8];
  private final long[] _rc = new long[11];
  private long[] _state = new long[8];
  
  static
  {
    C0 = new long['Ā'];
    C1 = new long['Ā'];
    C2 = new long['Ā'];
    C3 = new long['Ā'];
    C4 = new long['Ā'];
    C5 = new long['Ā'];
    C6 = new long['Ā'];
    C7 = new long['Ā'];
    short[] arrayOfShort = new short[32];
    EIGHT = arrayOfShort;
    arrayOfShort[31] = 8;
  }
  
  public WhirlpoolDigest()
  {
    int i = 0;
    int j;
    while (i < 256)
    {
      j = SBOX[i];
      int k = maskWithReductionPolynomial(j << 1);
      int m = maskWithReductionPolynomial(k << 1);
      int n = m ^ j;
      int i1 = maskWithReductionPolynomial(m << 1);
      int i2 = i1 ^ j;
      C0[i] = packIntoLong(j, j, m, j, i1, n, k, i2);
      C1[i] = packIntoLong(i2, j, j, m, j, i1, n, k);
      C2[i] = packIntoLong(k, i2, j, j, m, j, i1, n);
      C3[i] = packIntoLong(n, k, i2, j, j, m, j, i1);
      C4[i] = packIntoLong(i1, n, k, i2, j, j, m, j);
      C5[i] = packIntoLong(j, i1, n, k, i2, j, j, m);
      C6[i] = packIntoLong(m, j, i1, n, k, i2, j, j);
      C7[i] = packIntoLong(j, m, j, i1, n, k, i2, j);
      i += 1;
    }
    this._rc[0] = 0L;
    i = 1;
    while (i <= 10)
    {
      j = (i - 1) * 8;
      this._rc[i] = (C0[j] & 0xFF00000000000000 ^ C1[(j + 1)] & 0xFF000000000000 ^ C2[(j + 2)] & 0xFF0000000000 ^ C3[(j + 3)] & 0xFF00000000 ^ C4[(j + 4)] & 0xFF000000 ^ C5[(j + 5)] & 0xFF0000 ^ C6[(j + 6)] & 0xFF00 ^ C7[(j + 7)] & 0xFF);
      i += 1;
    }
  }
  
  public WhirlpoolDigest(WhirlpoolDigest paramWhirlpoolDigest)
  {
    reset(paramWhirlpoolDigest);
  }
  
  private long bytesToLongFromBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[(paramInt + 0)];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return paramArrayOfByte[(paramInt + 7)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  private void convertLongToByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)(int)(paramLong >> 56 - i * 8 & 0xFF));
      i += 1;
    }
  }
  
  private byte[] copyBitLength()
  {
    byte[] arrayOfByte = new byte[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = ((byte)(this._bitCount[i] & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private void finish()
  {
    byte[] arrayOfByte1 = copyBitLength();
    byte[] arrayOfByte2 = this._buffer;
    int i = this._bufferPos;
    int j = i + 1;
    this._bufferPos = j;
    arrayOfByte2[i] = ((byte)(arrayOfByte2[i] | 0x80));
    if (j == arrayOfByte2.length) {
      processFilledBuffer(arrayOfByte2, 0);
    }
    if (this._bufferPos > 32) {
      while (this._bufferPos != 0) {
        update((byte)0);
      }
    }
    while (this._bufferPos <= 32) {
      update((byte)0);
    }
    System.arraycopy(arrayOfByte1, 0, this._buffer, 32, arrayOfByte1.length);
    processFilledBuffer(this._buffer, 0);
  }
  
  private void increment()
  {
    int i = this._bitCount.length - 1;
    int j = 0;
    while (i >= 0)
    {
      short[] arrayOfShort = this._bitCount;
      int k = (arrayOfShort[i] & 0xFF) + EIGHT[i] + j;
      j = k >>> 8;
      arrayOfShort[i] = ((short)(k & 0xFF));
      i -= 1;
    }
  }
  
  private int maskWithReductionPolynomial(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 256L) {
      i = paramInt ^ 0x11D;
    }
    return i;
  }
  
  private long packIntoLong(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    long l = paramInt1;
    return paramInt2 << 48 ^ l << 56 ^ paramInt3 << 40 ^ paramInt4 << 32 ^ paramInt5 << 24 ^ paramInt6 << 16 ^ paramInt7 << 8 ^ paramInt8;
  }
  
  private void processFilledBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = 0;
    while (paramInt < this._state.length)
    {
      this._block[paramInt] = bytesToLongFromBuffer(this._buffer, paramInt * 8);
      paramInt += 1;
    }
    processBlock();
    this._bufferPos = 0;
    Arrays.fill(this._buffer, (byte)0);
  }
  
  public Memoable copy()
  {
    return new WhirlpoolDigest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    int i = 0;
    while (i < 8)
    {
      convertLongToByteArray(this._hash[i], paramArrayOfByte, i * 8 + paramInt);
      i += 1;
    }
    reset();
    return getDigestSize();
  }
  
  public String getAlgorithmName()
  {
    return "Whirlpool";
  }
  
  public int getByteLength()
  {
    return 64;
  }
  
  public int getDigestSize()
  {
    return 64;
  }
  
  protected void processBlock()
  {
    int i = 0;
    long[] arrayOfLong1;
    long l1;
    long[] arrayOfLong2;
    while (i < 8)
    {
      arrayOfLong1 = this._state;
      l1 = this._block[i];
      arrayOfLong2 = this._K;
      long l2 = this._hash[i];
      arrayOfLong2[i] = l2;
      arrayOfLong1[i] = (l1 ^ l2);
      i += 1;
    }
    i = 1;
    while (i <= 10)
    {
      int j = 0;
      long[] arrayOfLong3;
      while (j < 8)
      {
        arrayOfLong1 = this._L;
        arrayOfLong1[j] = 0L;
        l1 = arrayOfLong1[j];
        arrayOfLong2 = C0;
        arrayOfLong3 = this._K;
        arrayOfLong1[j] = (arrayOfLong2[((int)(arrayOfLong3[(j + 0 & 0x7)] >>> 56) & 0xFF)] ^ l1);
        arrayOfLong1[j] ^= C1[((int)(arrayOfLong3[(j - 1 & 0x7)] >>> 48) & 0xFF)];
        arrayOfLong1[j] ^= C2[((int)(arrayOfLong3[(j - 2 & 0x7)] >>> 40) & 0xFF)];
        arrayOfLong1[j] ^= C3[((int)(arrayOfLong3[(j - 3 & 0x7)] >>> 32) & 0xFF)];
        arrayOfLong1[j] ^= C4[((int)(arrayOfLong3[(j - 4 & 0x7)] >>> 24) & 0xFF)];
        arrayOfLong1[j] ^= C5[((int)(arrayOfLong3[(j - 5 & 0x7)] >>> 16) & 0xFF)];
        arrayOfLong1[j] ^= C6[((int)(arrayOfLong3[(j - 6 & 0x7)] >>> 8) & 0xFF)];
        arrayOfLong1[j] ^= C7[((int)arrayOfLong3[(j - 7 & 0x7)] & 0xFF)];
        j += 1;
      }
      arrayOfLong1 = this._L;
      arrayOfLong2 = this._K;
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, arrayOfLong2.length);
      arrayOfLong1 = this._K;
      arrayOfLong1[0] ^= this._rc[i];
      j = 0;
      for (;;)
      {
        arrayOfLong1 = this._L;
        if (j >= 8) {
          break;
        }
        arrayOfLong1[j] = this._K[j];
        l1 = arrayOfLong1[j];
        arrayOfLong2 = C0;
        arrayOfLong3 = this._state;
        arrayOfLong1[j] = (l1 ^ arrayOfLong2[((int)(arrayOfLong3[(j + 0 & 0x7)] >>> 56) & 0xFF)]);
        arrayOfLong1[j] ^= C1[((int)(arrayOfLong3[(j - 1 & 0x7)] >>> 48) & 0xFF)];
        arrayOfLong1[j] ^= C2[((int)(arrayOfLong3[(j - 2 & 0x7)] >>> 40) & 0xFF)];
        arrayOfLong1[j] ^= C3[((int)(arrayOfLong3[(j - 3 & 0x7)] >>> 32) & 0xFF)];
        arrayOfLong1[j] ^= C4[((int)(arrayOfLong3[(j - 4 & 0x7)] >>> 24) & 0xFF)];
        arrayOfLong1[j] ^= C5[((int)(arrayOfLong3[(j - 5 & 0x7)] >>> 16) & 0xFF)];
        arrayOfLong1[j] ^= C6[((int)(arrayOfLong3[(j - 6 & 0x7)] >>> 8) & 0xFF)];
        arrayOfLong1[j] ^= C7[((int)arrayOfLong3[(j - 7 & 0x7)] & 0xFF)];
        j += 1;
      }
      arrayOfLong2 = this._state;
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, arrayOfLong2.length);
      i += 1;
    }
    i = 0;
    while (i < 8)
    {
      arrayOfLong1 = this._hash;
      arrayOfLong1[i] ^= this._state[i] ^ this._block[i];
      i += 1;
    }
  }
  
  public void reset()
  {
    this._bufferPos = 0;
    Arrays.fill(this._bitCount, (short)0);
    Arrays.fill(this._buffer, (byte)0);
    Arrays.fill(this._hash, 0L);
    Arrays.fill(this._K, 0L);
    Arrays.fill(this._L, 0L);
    Arrays.fill(this._block, 0L);
    Arrays.fill(this._state, 0L);
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (WhirlpoolDigest)paramMemoable;
    Object localObject1 = paramMemoable._rc;
    Object localObject2 = this._rc;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    localObject1 = paramMemoable._buffer;
    localObject2 = this._buffer;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    this._bufferPos = paramMemoable._bufferPos;
    localObject1 = paramMemoable._bitCount;
    localObject2 = this._bitCount;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    localObject1 = paramMemoable._hash;
    localObject2 = this._hash;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    localObject1 = paramMemoable._K;
    localObject2 = this._K;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    localObject1 = paramMemoable._L;
    localObject2 = this._L;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    localObject1 = paramMemoable._block;
    localObject2 = this._block;
    System.arraycopy(localObject1, 0, localObject2, 0, localObject2.length);
    paramMemoable = paramMemoable._state;
    localObject1 = this._state;
    System.arraycopy(paramMemoable, 0, localObject1, 0, localObject1.length);
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this._buffer;
    int i = this._bufferPos;
    arrayOfByte[i] = paramByte;
    i += 1;
    this._bufferPos = i;
    if (i == arrayOfByte.length) {
      processFilledBuffer(arrayOfByte, 0);
    }
    increment();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      update(paramArrayOfByte[paramInt1]);
      paramInt1 += 1;
      paramInt2 -= 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\WhirlpoolDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */