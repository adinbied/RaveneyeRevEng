package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;

public class KeccakDigest
  implements ExtendedDigest
{
  private static int[] KeccakRhoOffsets = keccakInitializeRhoOffsets();
  private static long[] KeccakRoundConstants = ;
  long[] C;
  protected int bitsAvailableForSqueezing;
  protected int bitsInQueue;
  long[] chiC;
  protected byte[] chunk;
  protected byte[] dataQueue;
  protected int fixedOutputLength;
  protected byte[] oneByte;
  protected int rate;
  protected boolean squeezing;
  protected byte[] state;
  long[] tempA;
  
  public KeccakDigest()
  {
    this(288);
  }
  
  public KeccakDigest(int paramInt)
  {
    this.state = new byte['È'];
    this.dataQueue = new byte['À'];
    this.C = new long[5];
    this.tempA = new long[25];
    this.chiC = new long[5];
    init(paramInt);
  }
  
  public KeccakDigest(KeccakDigest paramKeccakDigest)
  {
    byte[] arrayOfByte1 = new byte['È'];
    this.state = arrayOfByte1;
    this.dataQueue = new byte['À'];
    this.C = new long[5];
    this.tempA = new long[25];
    this.chiC = new long[5];
    byte[] arrayOfByte2 = paramKeccakDigest.state;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
    arrayOfByte1 = paramKeccakDigest.dataQueue;
    System.arraycopy(arrayOfByte1, 0, this.dataQueue, 0, arrayOfByte1.length);
    this.rate = paramKeccakDigest.rate;
    this.bitsInQueue = paramKeccakDigest.bitsInQueue;
    this.fixedOutputLength = paramKeccakDigest.fixedOutputLength;
    this.squeezing = paramKeccakDigest.squeezing;
    this.bitsAvailableForSqueezing = paramKeccakDigest.bitsAvailableForSqueezing;
    this.chunk = Arrays.clone(paramKeccakDigest.chunk);
    this.oneByte = Arrays.clone(paramKeccakDigest.oneByte);
  }
  
  private void KeccakAbsorb(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    keccakPermutationAfterXor(paramArrayOfByte1, paramArrayOfByte2, paramInt);
  }
  
  private void KeccakExtract(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramInt * 8);
  }
  
  private void KeccakExtract1024bits(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, 128);
  }
  
  private static boolean LFSR86540(byte[] paramArrayOfByte)
  {
    boolean bool;
    if ((paramArrayOfByte[0] & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramArrayOfByte[0] & 0x80) != 0)
    {
      paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] << 1 ^ 0x71));
      return bool;
    }
    paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] << 1));
    return bool;
  }
  
  private void absorbQueue()
  {
    KeccakAbsorb(this.state, this.dataQueue, this.rate / 8);
    this.bitsInQueue = 0;
  }
  
  private void chi(long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 5)
    {
      int k;
      for (int j = 0; j < 5; j = k)
      {
        long[] arrayOfLong = this.chiC;
        int m = i * 5;
        long l = paramArrayOfLong[(j + m)];
        k = j + 1;
        arrayOfLong[j] = (l ^ paramArrayOfLong[(k % 5 + m)] & paramArrayOfLong[((j + 2) % 5 + m)]);
      }
      j = 0;
      while (j < 5)
      {
        paramArrayOfLong[(i * 5 + j)] = this.chiC[j];
        j += 1;
      }
      i += 1;
    }
  }
  
  private void clearDataQueueSection(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i != paramInt1 + paramInt2)
    {
      this.dataQueue[i] = 0;
      i += 1;
    }
  }
  
  private void fromBytesToWords(long[] paramArrayOfLong, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 25)
    {
      paramArrayOfLong[i] = 0L;
      int j = 0;
      while (j < 8)
      {
        paramArrayOfLong[i] |= (paramArrayOfByte[(i * 8 + j)] & 0xFF) << j * 8;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void fromWordsToBytes(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 25)
    {
      int j = 0;
      while (j < 8)
      {
        paramArrayOfByte[(i * 8 + j)] = ((byte)(int)(paramArrayOfLong[i] >>> j * 8 & 0xFF));
        j += 1;
      }
      i += 1;
    }
  }
  
  private void init(int paramInt)
  {
    if (paramInt != 128)
    {
      int i;
      if (paramInt != 224)
      {
        i = 512;
        if (paramInt != 256)
        {
          if (paramInt != 288)
          {
            if (paramInt != 384)
            {
              if (paramInt == 512)
              {
                initSponge(576, 1024);
                return;
              }
              throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
            }
            i = 832;
            paramInt = 768;
          }
          else
          {
            initSponge(1024, 576);
          }
        }
        else
        {
          int j = 1088;
          paramInt = i;
          i = j;
        }
      }
      else
      {
        i = 1152;
        paramInt = 448;
      }
      initSponge(i, paramInt);
      return;
    }
    initSponge(1344, 256);
  }
  
  private void initSponge(int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 == 1600)
    {
      if ((paramInt1 > 0) && (paramInt1 < 1600) && (paramInt1 % 64 == 0))
      {
        this.rate = paramInt1;
        Arrays.fill(this.state, (byte)0);
        Arrays.fill(this.dataQueue, (byte)0);
        this.bitsInQueue = 0;
        this.squeezing = false;
        this.bitsAvailableForSqueezing = 0;
        this.fixedOutputLength = (paramInt2 / 2);
        this.chunk = new byte[paramInt1 / 8];
        this.oneByte = new byte[1];
        return;
      }
      throw new IllegalStateException("invalid rate value");
    }
    throw new IllegalStateException("rate + capacity != 1600");
  }
  
  private void iota(long[] paramArrayOfLong, int paramInt)
  {
    paramArrayOfLong[0] ^= KeccakRoundConstants[paramInt];
  }
  
  private static int[] keccakInitializeRhoOffsets()
  {
    int[] arrayOfInt = new int[25];
    int k = 0;
    arrayOfInt[0] = 0;
    int i = 0;
    int j = 1;
    for (;;)
    {
      int n = i;
      if (k >= 24) {
        break;
      }
      int m = k + 1;
      arrayOfInt[(j % 5 + n % 5 * 5)] = ((k + 2) * m / 2 % 64);
      i = (j * 2 + n * 3) % 5;
      j = (j * 0 + n * 1) % 5;
      k = m;
    }
    return arrayOfInt;
  }
  
  private static long[] keccakInitializeRoundConstants()
  {
    long[] arrayOfLong = new long[24];
    int i = 0;
    while (i < 24)
    {
      arrayOfLong[i] = 0L;
      int j = 0;
      while (j < 7)
      {
        if (LFSR86540(new byte[] { 1 })) {
          arrayOfLong[i] ^= 1L << (1 << j) - 1;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  private void keccakPermutation(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = new long[paramArrayOfByte.length / 8];
    fromBytesToWords(arrayOfLong, paramArrayOfByte);
    keccakPermutationOnWords(arrayOfLong);
    fromWordsToBytes(paramArrayOfByte, arrayOfLong);
  }
  
  private void keccakPermutationAfterXor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
    keccakPermutation(paramArrayOfByte1);
  }
  
  private void keccakPermutationOnWords(long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 24)
    {
      theta(paramArrayOfLong);
      rho(paramArrayOfLong);
      pi(paramArrayOfLong);
      chi(paramArrayOfLong);
      iota(paramArrayOfLong, i);
      i += 1;
    }
  }
  
  private void padAndSwitchToSqueezingPhase()
  {
    int i = this.bitsInQueue;
    int j = this.rate;
    if (i + 1 == j)
    {
      arrayOfByte = this.dataQueue;
      j = i / 8;
      arrayOfByte[j] = ((byte)(1 << i % 8 | arrayOfByte[j]));
      absorbQueue();
      clearDataQueueSection(0, this.rate / 8);
    }
    else
    {
      clearDataQueueSection((i + 7) / 8, j / 8 - (i + 7) / 8);
      arrayOfByte = this.dataQueue;
      i = this.bitsInQueue;
      j = i / 8;
      arrayOfByte[j] = ((byte)(1 << i % 8 | arrayOfByte[j]));
    }
    byte[] arrayOfByte = this.dataQueue;
    i = this.rate;
    j = (i - 1) / 8;
    arrayOfByte[j] = ((byte)(1 << (i - 1) % 8 | arrayOfByte[j]));
    absorbQueue();
    i = this.rate;
    if (i == 1024)
    {
      KeccakExtract1024bits(this.state, this.dataQueue);
      this.bitsAvailableForSqueezing = 1024;
    }
    else
    {
      KeccakExtract(this.state, this.dataQueue, i / 64);
      this.bitsAvailableForSqueezing = this.rate;
    }
    this.squeezing = true;
  }
  
  private void pi(long[] paramArrayOfLong)
  {
    long[] arrayOfLong = this.tempA;
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, arrayOfLong.length);
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramArrayOfLong[((i * 2 + j * 3) % 5 * 5 + j)] = this.tempA[(j * 5 + i)];
        j += 1;
      }
      i += 1;
    }
  }
  
  private void rho(long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        int k = j * 5 + i;
        int[] arrayOfInt = KeccakRhoOffsets;
        long l;
        if (arrayOfInt[k] != 0) {
          l = paramArrayOfLong[k] << arrayOfInt[k] ^ paramArrayOfLong[k] >>> 64 - arrayOfInt[k];
        } else {
          l = paramArrayOfLong[k];
        }
        paramArrayOfLong[k] = l;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void theta(long[] paramArrayOfLong)
  {
    int i = 0;
    int j;
    long[] arrayOfLong;
    while (i < 5)
    {
      this.C[i] = 0L;
      j = 0;
      while (j < 5)
      {
        arrayOfLong = this.C;
        arrayOfLong[i] ^= paramArrayOfLong[(j * 5 + i)];
        j += 1;
      }
      i += 1;
    }
    int k;
    for (i = 0; i < 5; i = k)
    {
      arrayOfLong = this.C;
      k = i + 1;
      j = k % 5;
      long l1 = arrayOfLong[j];
      long l2 = arrayOfLong[j];
      long l3 = arrayOfLong[((i + 4) % 5)];
      j = 0;
      while (j < 5)
      {
        int m = j * 5 + i;
        paramArrayOfLong[m] ^= l1 << 1 ^ l2 >>> 63 ^ l3;
        j += 1;
      }
    }
  }
  
  protected void absorb(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (this.bitsInQueue % 8 == 0)
    {
      if (!this.squeezing)
      {
        long l1 = 0L;
        while (l1 < paramLong)
        {
          byte[] arrayOfByte1;
          if (this.bitsInQueue == 0)
          {
            i = this.rate;
            if ((paramLong >= i) && (l1 <= paramLong - i))
            {
              long l3 = (paramLong - l1) / i;
              for (l2 = 0L; l2 < l3; l2 += 1L)
              {
                long l4 = paramInt;
                long l5 = l1 / 8L;
                arrayOfByte1 = this.chunk;
                System.arraycopy(paramArrayOfByte, (int)(l4 + l5 + arrayOfByte1.length * l2), arrayOfByte1, 0, arrayOfByte1.length);
                arrayOfByte1 = this.state;
                byte[] arrayOfByte2 = this.chunk;
                KeccakAbsorb(arrayOfByte1, arrayOfByte2, arrayOfByte2.length);
              }
              l1 += l3 * this.rate;
              continue;
            }
          }
          int j = (int)(paramLong - l1);
          int k = this.bitsInQueue;
          int m = this.rate;
          int i = j;
          if (j + k > m) {
            i = m - k;
          }
          j = i % 8;
          i -= j;
          System.arraycopy(paramArrayOfByte, (int)(l1 / 8L) + paramInt, this.dataQueue, this.bitsInQueue / 8, i / 8);
          k = this.bitsInQueue + i;
          this.bitsInQueue = k;
          long l2 = l1 + i;
          if (k == this.rate) {
            absorbQueue();
          }
          l1 = l2;
          if (j > 0)
          {
            arrayOfByte1 = this.dataQueue;
            i = this.bitsInQueue;
            arrayOfByte1[(i / 8)] = ((byte)((1 << j) - 1 & paramArrayOfByte[(paramInt + (int)(l2 / 8L))]));
            this.bitsInQueue = (i + j);
            l1 = l2 + j;
          }
        }
        return;
      }
      throw new IllegalStateException("attempt to absorb while squeezing");
    }
    throw new IllegalStateException("attempt to absorb with odd length queue");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    squeeze(paramArrayOfByte, paramInt, this.fixedOutputLength);
    reset();
    return getDigestSize();
  }
  
  protected int doFinal(byte[] paramArrayOfByte, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      byte[] arrayOfByte = this.oneByte;
      arrayOfByte[0] = paramByte;
      absorb(arrayOfByte, 0, paramInt2);
    }
    squeeze(paramArrayOfByte, paramInt1, this.fixedOutputLength);
    reset();
    return getDigestSize();
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Keccak-");
    localStringBuilder.append(this.fixedOutputLength);
    return localStringBuilder.toString();
  }
  
  public int getByteLength()
  {
    return this.rate / 8;
  }
  
  public int getDigestSize()
  {
    return this.fixedOutputLength / 8;
  }
  
  public void reset()
  {
    init(this.fixedOutputLength);
  }
  
  protected void squeeze(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (!this.squeezing) {
      padAndSwitchToSqueezingPhase();
    }
    long l1 = 0L;
    if (paramLong % 8L == 0L)
    {
      while (l1 < paramLong)
      {
        if (this.bitsAvailableForSqueezing == 0)
        {
          keccakPermutation(this.state);
          i = this.rate;
          if (i == 1024)
          {
            KeccakExtract1024bits(this.state, this.dataQueue);
            this.bitsAvailableForSqueezing = 1024;
          }
          else
          {
            KeccakExtract(this.state, this.dataQueue, i / 64);
            this.bitsAvailableForSqueezing = this.rate;
          }
        }
        int i = this.bitsAvailableForSqueezing;
        long l2 = i;
        long l3 = paramLong - l1;
        if (l2 > l3) {
          i = (int)l3;
        }
        System.arraycopy(this.dataQueue, (this.rate - this.bitsAvailableForSqueezing) / 8, paramArrayOfByte, (int)(l1 / 8L) + paramInt, i / 8);
        this.bitsAvailableForSqueezing -= i;
        l1 += i;
      }
      return;
    }
    throw new IllegalStateException("outputLength not a multiple of 8");
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this.oneByte;
    arrayOfByte[0] = paramByte;
    absorb(arrayOfByte, 0, 8L);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    absorb(paramArrayOfByte, paramInt1, paramInt2 * 8L);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\KeccakDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */