package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;

public class Blake2bDigest
  implements ExtendedDigest
{
  private static final int BLOCK_LENGTH_BYTES = 128;
  private static final long[] blake2b_IV = { 7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L };
  private static final byte[][] blake2b_sigma;
  private static int rOUNDS = 12;
  private byte[] buffer = null;
  private int bufferPos = 0;
  private long[] chainValue = null;
  private int digestLength = 64;
  private long f0 = 0L;
  private long[] internalState = new long[16];
  private byte[] key = null;
  private int keyLength = 0;
  private byte[] personalization = null;
  private byte[] salt = null;
  private long t0 = 0L;
  private long t1 = 0L;
  
  static
  {
    byte[] arrayOfByte1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    byte[] arrayOfByte2 = { 7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8 };
    byte[] arrayOfByte3 = { 9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13 };
    byte[] arrayOfByte4 = { 2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9 };
    byte[] arrayOfByte5 = { 12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11 };
    byte[] arrayOfByte6 = { 6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5 };
    byte[] arrayOfByte7 = { 10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0 };
    byte[] arrayOfByte8 = { 14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3 };
    blake2b_sigma = new byte[][] { arrayOfByte1, { 14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3 }, { 11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4 }, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, { 13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10 }, arrayOfByte6, arrayOfByte7, { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, arrayOfByte8 };
  }
  
  public Blake2bDigest()
  {
    this(512);
  }
  
  public Blake2bDigest(int paramInt)
  {
    if ((paramInt != 160) && (paramInt != 256) && (paramInt != 384) && (paramInt != 512)) {
      throw new IllegalArgumentException("Blake2b digest restricted to one of [160, 256, 384, 512]");
    }
    this.buffer = new byte[''];
    this.keyLength = 0;
    this.digestLength = (paramInt / 8);
    init();
  }
  
  public Blake2bDigest(Blake2bDigest paramBlake2bDigest)
  {
    this.bufferPos = paramBlake2bDigest.bufferPos;
    this.buffer = Arrays.clone(paramBlake2bDigest.buffer);
    this.keyLength = paramBlake2bDigest.keyLength;
    this.key = Arrays.clone(paramBlake2bDigest.key);
    this.digestLength = paramBlake2bDigest.digestLength;
    this.chainValue = Arrays.clone(paramBlake2bDigest.chainValue);
    this.personalization = Arrays.clone(paramBlake2bDigest.personalization);
    this.salt = Arrays.clone(paramBlake2bDigest.salt);
    this.t0 = paramBlake2bDigest.t0;
    this.t1 = paramBlake2bDigest.t1;
    this.f0 = paramBlake2bDigest.f0;
  }
  
  public Blake2bDigest(byte[] paramArrayOfByte)
  {
    this.buffer = new byte[''];
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      this.key = arrayOfByte;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      if (paramArrayOfByte.length <= 64)
      {
        this.keyLength = paramArrayOfByte.length;
        System.arraycopy(paramArrayOfByte, 0, this.buffer, 0, paramArrayOfByte.length);
        this.bufferPos = 128;
      }
      else
      {
        throw new IllegalArgumentException("Keys > 64 are not supported");
      }
    }
    this.digestLength = 64;
    init();
  }
  
  public Blake2bDigest(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.buffer = new byte[''];
    if ((paramInt >= 1) && (paramInt <= 64))
    {
      this.digestLength = paramInt;
      if (paramArrayOfByte2 != null) {
        if (paramArrayOfByte2.length == 16)
        {
          byte[] arrayOfByte = new byte[16];
          this.salt = arrayOfByte;
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 0, paramArrayOfByte2.length);
        }
        else
        {
          throw new IllegalArgumentException("salt length must be exactly 16 bytes");
        }
      }
      if (paramArrayOfByte3 != null) {
        if (paramArrayOfByte3.length == 16)
        {
          paramArrayOfByte2 = new byte[16];
          this.personalization = paramArrayOfByte2;
          System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, 0, paramArrayOfByte3.length);
        }
        else
        {
          throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
        }
      }
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
        this.key = paramArrayOfByte2;
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
        if (paramArrayOfByte1.length <= 64)
        {
          this.keyLength = paramArrayOfByte1.length;
          System.arraycopy(paramArrayOfByte1, 0, this.buffer, 0, paramArrayOfByte1.length);
          this.bufferPos = 128;
        }
        else
        {
          throw new IllegalArgumentException("Keys > 64 are not supported");
        }
      }
      init();
      return;
    }
    throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
  }
  
  private void G(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long[] arrayOfLong = this.internalState;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] + arrayOfLong[paramInt2] + paramLong1);
    arrayOfLong[paramInt4] = rotr64(arrayOfLong[paramInt4] ^ arrayOfLong[paramInt1], 32);
    arrayOfLong = this.internalState;
    arrayOfLong[paramInt3] += arrayOfLong[paramInt4];
    arrayOfLong[paramInt2] = rotr64(arrayOfLong[paramInt2] ^ arrayOfLong[paramInt3], 24);
    arrayOfLong = this.internalState;
    arrayOfLong[paramInt1] = (arrayOfLong[paramInt1] + arrayOfLong[paramInt2] + paramLong2);
    arrayOfLong[paramInt4] = rotr64(arrayOfLong[paramInt4] ^ arrayOfLong[paramInt1], 16);
    arrayOfLong = this.internalState;
    arrayOfLong[paramInt3] += arrayOfLong[paramInt4];
    arrayOfLong[paramInt2] = rotr64(arrayOfLong[paramInt2] ^ arrayOfLong[paramInt3], 63);
  }
  
  private final long bytes2long(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  private void compress(byte[] paramArrayOfByte, int paramInt)
  {
    initializeInternalState();
    long[] arrayOfLong = new long[16];
    int j = 0;
    int i = 0;
    while (i < 16)
    {
      arrayOfLong[i] = bytes2long(paramArrayOfByte, i * 8 + paramInt);
      i += 1;
    }
    paramInt = 0;
    for (;;)
    {
      i = j;
      if (paramInt >= rOUNDS) {
        break;
      }
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][0]], arrayOfLong[paramArrayOfByte[paramInt][1]], 0, 4, 8, 12);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][2]], arrayOfLong[paramArrayOfByte[paramInt][3]], 1, 5, 9, 13);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][4]], arrayOfLong[paramArrayOfByte[paramInt][5]], 2, 6, 10, 14);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][6]], arrayOfLong[paramArrayOfByte[paramInt][7]], 3, 7, 11, 15);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][8]], arrayOfLong[paramArrayOfByte[paramInt][9]], 0, 5, 10, 15);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][10]], arrayOfLong[paramArrayOfByte[paramInt][11]], 1, 6, 11, 12);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][12]], arrayOfLong[paramArrayOfByte[paramInt][13]], 2, 7, 8, 13);
      paramArrayOfByte = blake2b_sigma;
      G(arrayOfLong[paramArrayOfByte[paramInt][14]], arrayOfLong[paramArrayOfByte[paramInt][15]], 3, 4, 9, 14);
      paramInt += 1;
    }
    for (;;)
    {
      paramArrayOfByte = this.chainValue;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      long l = paramArrayOfByte[i];
      arrayOfLong = this.internalState;
      paramArrayOfByte[i] = (l ^ arrayOfLong[i] ^ arrayOfLong[(i + 8)]);
      i += 1;
    }
  }
  
  private void init()
  {
    if (this.chainValue == null)
    {
      long[] arrayOfLong = new long[8];
      this.chainValue = arrayOfLong;
      Object localObject = blake2b_IV;
      localObject[0] ^= (this.digestLength | this.keyLength << 8 | 0x1010000);
      arrayOfLong[1] = localObject[1];
      arrayOfLong[2] = localObject[2];
      arrayOfLong[3] = localObject[3];
      arrayOfLong[4] = localObject[4];
      arrayOfLong[5] = localObject[5];
      localObject = this.salt;
      if (localObject != null)
      {
        arrayOfLong[4] ^= bytes2long((byte[])localObject, 0);
        arrayOfLong = this.chainValue;
        arrayOfLong[5] ^= bytes2long(this.salt, 8);
      }
      arrayOfLong = this.chainValue;
      localObject = blake2b_IV;
      arrayOfLong[6] = localObject[6];
      arrayOfLong[7] = localObject[7];
      localObject = this.personalization;
      if (localObject != null)
      {
        long l = arrayOfLong[6];
        arrayOfLong[6] = (bytes2long((byte[])localObject, 0) ^ l);
        arrayOfLong = this.chainValue;
        arrayOfLong[7] ^= bytes2long(this.personalization, 8);
      }
    }
  }
  
  private void initializeInternalState()
  {
    long[] arrayOfLong1 = this.chainValue;
    System.arraycopy(arrayOfLong1, 0, this.internalState, 0, arrayOfLong1.length);
    System.arraycopy(blake2b_IV, 0, this.internalState, this.chainValue.length, 4);
    arrayOfLong1 = this.internalState;
    long l = this.t0;
    long[] arrayOfLong2 = blake2b_IV;
    arrayOfLong1[12] = (l ^ arrayOfLong2[4]);
    arrayOfLong1[13] = (this.t1 ^ arrayOfLong2[5]);
    arrayOfLong1[14] = (this.f0 ^ arrayOfLong2[6]);
    arrayOfLong1[15] = arrayOfLong2[7];
  }
  
  private final byte[] long2bytes(long paramLong)
  {
    return new byte[] { (byte)(int)paramLong, (byte)(int)(paramLong >> 8), (byte)(int)(paramLong >> 16), (byte)(int)(paramLong >> 24), (byte)(int)(paramLong >> 32), (byte)(int)(paramLong >> 40), (byte)(int)(paramLong >> 48), (byte)(int)(paramLong >> 56) };
  }
  
  private long rotr64(long paramLong, int paramInt)
  {
    return paramLong << 64 - paramInt | paramLong >>> paramInt;
  }
  
  public void clearKey()
  {
    byte[] arrayOfByte = this.key;
    if (arrayOfByte != null)
    {
      Arrays.fill(arrayOfByte, (byte)0);
      Arrays.fill(this.buffer, (byte)0);
    }
  }
  
  public void clearSalt()
  {
    byte[] arrayOfByte = this.salt;
    if (arrayOfByte != null) {
      Arrays.fill(arrayOfByte, (byte)0);
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    this.f0 = -1L;
    long l = this.t0;
    int i = this.bufferPos;
    l += i;
    this.t0 = l;
    if ((l < 0L) && (i > -l)) {
      this.t1 += 1L;
    }
    compress(this.buffer, 0);
    Arrays.fill(this.buffer, (byte)0);
    Arrays.fill(this.internalState, 0L);
    i = 0;
    for (;;)
    {
      Object localObject = this.chainValue;
      if (i >= localObject.length) {
        break;
      }
      int j = i * 8;
      if (j >= this.digestLength) {
        break;
      }
      localObject = long2bytes(localObject[i]);
      int k = this.digestLength;
      if (j < k - 8) {
        System.arraycopy(localObject, 0, paramArrayOfByte, j + paramInt, 8);
      } else {
        System.arraycopy(localObject, 0, paramArrayOfByte, paramInt + j, k - j);
      }
      i += 1;
    }
    Arrays.fill(this.chainValue, 0L);
    reset();
    return this.digestLength;
  }
  
  public String getAlgorithmName()
  {
    return "Blake2b";
  }
  
  public int getByteLength()
  {
    return 128;
  }
  
  public int getDigestSize()
  {
    return this.digestLength;
  }
  
  public void reset()
  {
    this.bufferPos = 0;
    this.f0 = 0L;
    this.t0 = 0L;
    this.t1 = 0L;
    this.chainValue = null;
    Arrays.fill(this.buffer, (byte)0);
    byte[] arrayOfByte = this.key;
    if (arrayOfByte != null)
    {
      System.arraycopy(arrayOfByte, 0, this.buffer, 0, arrayOfByte.length);
      this.bufferPos = 128;
    }
    init();
  }
  
  public void update(byte paramByte)
  {
    int i = this.bufferPos;
    if (128 - i == 0)
    {
      long l = this.t0 + 128L;
      this.t0 = l;
      if (l == 0L) {
        this.t1 += 1L;
      }
      compress(this.buffer, 0);
      Arrays.fill(this.buffer, (byte)0);
      this.buffer[0] = paramByte;
      this.bufferPos = 1;
      return;
    }
    this.buffer[i] = paramByte;
    this.bufferPos = (i + 1);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt2 == 0) {
        return;
      }
      int j = this.bufferPos;
      int i;
      long l;
      if (j != 0)
      {
        i = 128 - j;
        if (i < paramInt2)
        {
          System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, j, i);
          l = this.t0 + 128L;
          this.t0 = l;
          if (l == 0L) {
            this.t1 += 1L;
          }
          compress(this.buffer, 0);
          this.bufferPos = 0;
          Arrays.fill(this.buffer, (byte)0);
          break label131;
        }
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, j, paramInt2);
      }
      for (;;)
      {
        this.bufferPos += paramInt2;
        return;
        i = 0;
        label131:
        paramInt2 += paramInt1;
        paramInt1 += i;
        while (paramInt1 < paramInt2 - 128)
        {
          l = this.t0 + 128L;
          this.t0 = l;
          if (l == 0L) {
            this.t1 += 1L;
          }
          compress(paramArrayOfByte, paramInt1);
          paramInt1 += 128;
        }
        byte[] arrayOfByte = this.buffer;
        paramInt2 -= paramInt1;
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\Blake2bDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */