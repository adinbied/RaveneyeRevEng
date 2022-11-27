package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine
  implements BlockCipher
{
  public static final int BLOCKSIZE_1024 = 1024;
  public static final int BLOCKSIZE_256 = 256;
  public static final int BLOCKSIZE_512 = 512;
  private static final long C_240 = 2004413935125273122L;
  private static final int MAX_ROUNDS = 80;
  private static int[] MOD17;
  private static int[] MOD3;
  private static int[] MOD5;
  private static int[] MOD9;
  private static final int ROUNDS_1024 = 80;
  private static final int ROUNDS_256 = 72;
  private static final int ROUNDS_512 = 72;
  private static final int TWEAK_SIZE_BYTES = 16;
  private static final int TWEAK_SIZE_WORDS = 2;
  private int blocksizeBytes;
  private int blocksizeWords;
  private ThreefishCipher cipher;
  private long[] currentBlock;
  private boolean forEncryption;
  private long[] kw;
  private long[] t;
  
  static
  {
    int[] arrayOfInt = new int[80];
    MOD9 = arrayOfInt;
    MOD17 = new int[arrayOfInt.length];
    MOD5 = new int[arrayOfInt.length];
    MOD3 = new int[arrayOfInt.length];
    int i = 0;
    for (;;)
    {
      arrayOfInt = MOD9;
      if (i >= arrayOfInt.length) {
        break;
      }
      MOD17[i] = (i % 17);
      arrayOfInt[i] = (i % 9);
      MOD5[i] = (i % 5);
      MOD3[i] = (i % 3);
      i += 1;
    }
  }
  
  public ThreefishEngine(int paramInt)
  {
    Object localObject = new long[5];
    this.t = ((long[])localObject);
    int i = paramInt / 8;
    this.blocksizeBytes = i;
    i /= 8;
    this.blocksizeWords = i;
    this.currentBlock = new long[i];
    long[] arrayOfLong = new long[i * 2 + 1];
    this.kw = arrayOfLong;
    if (paramInt != 256)
    {
      if (paramInt != 512)
      {
        if (paramInt == 1024) {
          localObject = new Threefish1024Cipher(arrayOfLong, (long[])localObject);
        } else {
          throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
      }
      else {
        localObject = new Threefish512Cipher(arrayOfLong, (long[])localObject);
      }
    }
    else {
      localObject = new Threefish256Cipher(arrayOfLong, (long[])localObject);
    }
    this.cipher = ((ThreefishCipher)localObject);
  }
  
  public static long bytesToWord(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 8 <= paramArrayOfByte.length)
    {
      int i = paramInt + 1;
      long l1 = paramArrayOfByte[paramInt];
      paramInt = i + 1;
      long l2 = paramArrayOfByte[i];
      i = paramInt + 1;
      long l3 = paramArrayOfByte[paramInt];
      paramInt = i + 1;
      long l4 = paramArrayOfByte[i];
      i = paramInt + 1;
      long l5 = paramArrayOfByte[paramInt];
      paramInt = i + 1;
      long l6 = paramArrayOfByte[i];
      long l7 = paramArrayOfByte[paramInt];
      return (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    throw new IllegalArgumentException();
  }
  
  static long rotlXor(long paramLong1, int paramInt, long paramLong2)
  {
    return (paramLong1 >>> -paramInt | paramLong1 << paramInt) ^ paramLong2;
  }
  
  private void setKey(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == this.blocksizeWords)
    {
      long l = 2004413935125273122L;
      int i = 0;
      int j;
      for (;;)
      {
        j = this.blocksizeWords;
        if (i >= j) {
          break;
        }
        long[] arrayOfLong = this.kw;
        arrayOfLong[i] = paramArrayOfLong[i];
        l ^= arrayOfLong[i];
        i += 1;
      }
      paramArrayOfLong = this.kw;
      paramArrayOfLong[j] = l;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfLong, j + 1, j);
      return;
    }
    paramArrayOfLong = new StringBuilder();
    paramArrayOfLong.append("Threefish key must be same size as block (");
    paramArrayOfLong.append(this.blocksizeWords);
    paramArrayOfLong.append(" words)");
    throw new IllegalArgumentException(paramArrayOfLong.toString());
  }
  
  private void setTweak(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 2)
    {
      long[] arrayOfLong = this.t;
      arrayOfLong[0] = paramArrayOfLong[0];
      arrayOfLong[1] = paramArrayOfLong[1];
      arrayOfLong[2] = (arrayOfLong[0] ^ arrayOfLong[1]);
      arrayOfLong[3] = arrayOfLong[0];
      arrayOfLong[4] = arrayOfLong[1];
      return;
    }
    throw new IllegalArgumentException("Tweak must be 2 words.");
  }
  
  public static void wordToBytes(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt + 8 <= paramArrayOfByte.length)
    {
      int i = paramInt + 1;
      paramArrayOfByte[paramInt] = ((byte)(int)paramLong);
      paramInt = i + 1;
      paramArrayOfByte[i] = ((byte)(int)(paramLong >> 8));
      i = paramInt + 1;
      paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 16));
      paramInt = i + 1;
      paramArrayOfByte[i] = ((byte)(int)(paramLong >> 24));
      i = paramInt + 1;
      paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 32));
      paramInt = i + 1;
      paramArrayOfByte[i] = ((byte)(int)(paramLong >> 40));
      paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 48));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 56));
      return;
    }
    throw new IllegalArgumentException();
  }
  
  static long xorRotr(long paramLong1, int paramInt, long paramLong2)
  {
    paramLong1 ^= paramLong2;
    return paramLong1 << -paramInt | paramLong1 >>> paramInt;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Threefish-");
    localStringBuilder.append(this.blocksizeBytes * 8);
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.blocksizeBytes;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    boolean bool = paramCipherParameters instanceof TweakableBlockCipherParameters;
    Object localObject3 = null;
    if (bool)
    {
      paramCipherParameters = (TweakableBlockCipherParameters)paramCipherParameters;
      localObject2 = paramCipherParameters.getKey().getKey();
      paramCipherParameters = paramCipherParameters.getTweak();
    }
    else
    {
      if (!(paramCipherParameters instanceof KeyParameter)) {
        break label221;
      }
      localObject2 = ((KeyParameter)paramCipherParameters).getKey();
      paramCipherParameters = null;
    }
    if (localObject2 != null)
    {
      if (localObject2.length == this.blocksizeBytes)
      {
        int j = this.blocksizeWords;
        long[] arrayOfLong = new long[j];
        int i = 0;
        for (;;)
        {
          localObject1 = arrayOfLong;
          if (i >= j) {
            break;
          }
          arrayOfLong[i] = bytesToWord((byte[])localObject2, i * 8);
          i += 1;
        }
      }
      paramCipherParameters = new StringBuilder();
      paramCipherParameters.append("Threefish key must be same size as block (");
      paramCipherParameters.append(this.blocksizeBytes);
      paramCipherParameters.append(" bytes)");
      throw new IllegalArgumentException(paramCipherParameters.toString());
    }
    Object localObject1 = null;
    Object localObject2 = localObject3;
    if (paramCipherParameters != null) {
      if (paramCipherParameters.length == 16)
      {
        localObject2 = new long[2];
        localObject2[0] = bytesToWord(paramCipherParameters, 0);
        localObject2[1] = bytesToWord(paramCipherParameters, 8);
      }
      else
      {
        throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
      }
    }
    init(paramBoolean, (long[])localObject1, (long[])localObject2);
    return;
    label221:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid parameter passed to Threefish init - ");
    ((StringBuilder)localObject1).append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public void init(boolean paramBoolean, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.forEncryption = paramBoolean;
    if (paramArrayOfLong1 != null) {
      setKey(paramArrayOfLong1);
    }
    if (paramArrayOfLong2 != null) {
      setTweak(paramArrayOfLong2);
    }
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blocksizeBytes;
    if (paramInt2 + i <= paramArrayOfByte2.length)
    {
      if (i + paramInt1 <= paramArrayOfByte1.length)
      {
        int j = 0;
        i = 0;
        while (i < this.blocksizeBytes)
        {
          this.currentBlock[(i >> 3)] = bytesToWord(paramArrayOfByte1, paramInt1 + i);
          i += 8;
        }
        paramArrayOfByte1 = this.currentBlock;
        processBlock(paramArrayOfByte1, paramArrayOfByte1);
        paramInt1 = j;
        for (;;)
        {
          i = this.blocksizeBytes;
          if (paramInt1 >= i) {
            break;
          }
          wordToBytes(this.currentBlock[(paramInt1 >> 3)], paramArrayOfByte2, paramInt2 + paramInt1);
          paramInt1 += 8;
        }
        return i;
      }
      throw new DataLengthException("Input buffer too short");
    }
    throw new DataLengthException("Output buffer too short");
  }
  
  public int processBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    throws DataLengthException, IllegalStateException
  {
    long[] arrayOfLong = this.kw;
    int i = this.blocksizeWords;
    if (arrayOfLong[i] != 0L)
    {
      if (paramArrayOfLong1.length == i)
      {
        if (paramArrayOfLong2.length == i)
        {
          if (this.forEncryption) {
            this.cipher.encryptBlock(paramArrayOfLong1, paramArrayOfLong2);
          } else {
            this.cipher.decryptBlock(paramArrayOfLong1, paramArrayOfLong2);
          }
          return this.blocksizeWords;
        }
        throw new DataLengthException("Output buffer too short");
      }
      throw new DataLengthException("Input buffer too short");
    }
    throw new IllegalStateException("Threefish engine not initialised");
  }
  
  public void reset() {}
  
  private static final class Threefish1024Cipher
    extends ThreefishEngine.ThreefishCipher
  {
    private static final int ROTATION_0_0 = 24;
    private static final int ROTATION_0_1 = 13;
    private static final int ROTATION_0_2 = 8;
    private static final int ROTATION_0_3 = 47;
    private static final int ROTATION_0_4 = 8;
    private static final int ROTATION_0_5 = 17;
    private static final int ROTATION_0_6 = 22;
    private static final int ROTATION_0_7 = 37;
    private static final int ROTATION_1_0 = 38;
    private static final int ROTATION_1_1 = 19;
    private static final int ROTATION_1_2 = 10;
    private static final int ROTATION_1_3 = 55;
    private static final int ROTATION_1_4 = 49;
    private static final int ROTATION_1_5 = 18;
    private static final int ROTATION_1_6 = 23;
    private static final int ROTATION_1_7 = 52;
    private static final int ROTATION_2_0 = 33;
    private static final int ROTATION_2_1 = 4;
    private static final int ROTATION_2_2 = 51;
    private static final int ROTATION_2_3 = 13;
    private static final int ROTATION_2_4 = 34;
    private static final int ROTATION_2_5 = 41;
    private static final int ROTATION_2_6 = 59;
    private static final int ROTATION_2_7 = 17;
    private static final int ROTATION_3_0 = 5;
    private static final int ROTATION_3_1 = 20;
    private static final int ROTATION_3_2 = 48;
    private static final int ROTATION_3_3 = 41;
    private static final int ROTATION_3_4 = 47;
    private static final int ROTATION_3_5 = 28;
    private static final int ROTATION_3_6 = 16;
    private static final int ROTATION_3_7 = 25;
    private static final int ROTATION_4_0 = 41;
    private static final int ROTATION_4_1 = 9;
    private static final int ROTATION_4_2 = 37;
    private static final int ROTATION_4_3 = 31;
    private static final int ROTATION_4_4 = 12;
    private static final int ROTATION_4_5 = 47;
    private static final int ROTATION_4_6 = 44;
    private static final int ROTATION_4_7 = 30;
    private static final int ROTATION_5_0 = 16;
    private static final int ROTATION_5_1 = 34;
    private static final int ROTATION_5_2 = 56;
    private static final int ROTATION_5_3 = 51;
    private static final int ROTATION_5_4 = 4;
    private static final int ROTATION_5_5 = 53;
    private static final int ROTATION_5_6 = 42;
    private static final int ROTATION_5_7 = 41;
    private static final int ROTATION_6_0 = 31;
    private static final int ROTATION_6_1 = 44;
    private static final int ROTATION_6_2 = 47;
    private static final int ROTATION_6_3 = 46;
    private static final int ROTATION_6_4 = 19;
    private static final int ROTATION_6_5 = 42;
    private static final int ROTATION_6_6 = 44;
    private static final int ROTATION_6_7 = 25;
    private static final int ROTATION_7_0 = 9;
    private static final int ROTATION_7_1 = 48;
    private static final int ROTATION_7_2 = 35;
    private static final int ROTATION_7_3 = 52;
    private static final int ROTATION_7_4 = 23;
    private static final int ROTATION_7_5 = 31;
    private static final int ROTATION_7_6 = 37;
    private static final int ROTATION_7_7 = 20;
    
    public Threefish1024Cipher(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      super(paramArrayOfLong2);
    }
    
    void decryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong1 = this.kw;
      long[] arrayOfLong2 = this.t;
      int[] arrayOfInt1 = ThreefishEngine.MOD17;
      int[] arrayOfInt2 = ThreefishEngine.MOD3;
      if (arrayOfLong1.length == 33)
      {
        if (arrayOfLong2.length == 5)
        {
          long l16 = paramArrayOfLong1[0];
          long l4 = paramArrayOfLong1[1];
          long l15 = paramArrayOfLong1[2];
          long l2 = paramArrayOfLong1[3];
          long l14 = paramArrayOfLong1[4];
          long l3 = paramArrayOfLong1[5];
          long l13 = paramArrayOfLong1[6];
          long l1 = paramArrayOfLong1[7];
          long l12 = paramArrayOfLong1[8];
          long l5 = paramArrayOfLong1[9];
          long l11 = paramArrayOfLong1[10];
          long l7 = paramArrayOfLong1[11];
          long l10 = paramArrayOfLong1[12];
          long l6 = paramArrayOfLong1[13];
          long l9 = paramArrayOfLong1[14];
          long l8 = paramArrayOfLong1[15];
          int i = 19;
          paramArrayOfLong1 = arrayOfInt2;
          while (i >= 1)
          {
            int j = arrayOfInt1[i];
            int k = paramArrayOfLong1[i];
            int m = j + 1;
            l17 = l16 - arrayOfLong1[m];
            int n = j + 2;
            l16 = arrayOfLong1[n];
            int i1 = j + 3;
            l18 = l15 - arrayOfLong1[i1];
            int i2 = j + 4;
            l15 = arrayOfLong1[i2];
            int i3 = j + 5;
            l20 = l14 - arrayOfLong1[i3];
            int i4 = j + 6;
            l14 = arrayOfLong1[i4];
            int i5 = j + 7;
            l19 = l13 - arrayOfLong1[i5];
            int i6 = j + 8;
            l13 = arrayOfLong1[i6];
            int i7 = j + 9;
            l12 -= arrayOfLong1[i7];
            int i8 = j + 10;
            l21 = arrayOfLong1[i8];
            int i9 = j + 11;
            l11 -= arrayOfLong1[i9];
            int i10 = j + 12;
            l25 = arrayOfLong1[i10];
            int i11 = j + 13;
            l10 -= arrayOfLong1[i11];
            int i12 = j + 14;
            l23 = arrayOfLong1[i12];
            int i13 = k + 1;
            l24 = arrayOfLong2[i13];
            int i14 = j + 15;
            l22 = l9 - (arrayOfLong1[i14] + arrayOfLong2[(k + 2)]);
            l26 = arrayOfLong1[(j + 16)];
            l9 = i;
            l8 = ThreefishEngine.xorRotr(l8 - (l26 + l9 + 1L), 9, l17);
            l17 -= l8;
            l7 = ThreefishEngine.xorRotr(l7 - l25, 48, l18);
            l18 -= l7;
            l6 = ThreefishEngine.xorRotr(l6 - (l23 + l24), 35, l19);
            l19 -= l6;
            l5 = ThreefishEngine.xorRotr(l5 - l21, 52, l20);
            l20 -= l5;
            l21 = ThreefishEngine.xorRotr(l4 - l16, 23, l22);
            l16 = l22 - l21;
            l3 = ThreefishEngine.xorRotr(l3 - l14, 31, l12);
            l12 -= l3;
            l4 = ThreefishEngine.xorRotr(l2 - l15, 37, l11);
            l11 -= l4;
            l1 = ThreefishEngine.xorRotr(l1 - l13, 20, l10);
            l10 -= l1;
            l2 = ThreefishEngine.xorRotr(l1, 31, l17);
            l13 = l17 - l2;
            l1 = ThreefishEngine.xorRotr(l3, 44, l18);
            l18 -= l1;
            l4 = ThreefishEngine.xorRotr(l4, 47, l20);
            l14 = l20 - l4;
            l3 = ThreefishEngine.xorRotr(l21, 46, l19);
            l19 -= l3;
            l20 = ThreefishEngine.xorRotr(l8, 19, l10);
            l15 = l10 - l20;
            l6 = ThreefishEngine.xorRotr(l6, 42, l16);
            l16 -= l6;
            l21 = ThreefishEngine.xorRotr(l7, 44, l12);
            l17 = l12 - l21;
            l7 = ThreefishEngine.xorRotr(l5, 25, l11);
            l5 = l11 - l7;
            l10 = ThreefishEngine.xorRotr(l7, 16, l13);
            l7 = l13 - l10;
            l13 = ThreefishEngine.xorRotr(l6, 34, l18);
            l8 = l18 - l13;
            l18 = ThreefishEngine.xorRotr(l21, 56, l19);
            l6 = l19 - l18;
            l20 = ThreefishEngine.xorRotr(l20, 51, l14);
            l14 -= l20;
            l2 = ThreefishEngine.xorRotr(l2, 4, l5);
            l11 = l5 - l2;
            l4 = ThreefishEngine.xorRotr(l4, 53, l15);
            l12 = l15 - l4;
            l19 = ThreefishEngine.xorRotr(l1, 42, l16);
            l5 = l16 - l19;
            l1 = ThreefishEngine.xorRotr(l3, 41, l17);
            l15 = l17 - l1;
            l3 = ThreefishEngine.xorRotr(l1, 41, l7);
            l1 = ThreefishEngine.xorRotr(l4, 9, l8);
            l4 = ThreefishEngine.xorRotr(l19, 37, l14);
            l2 = ThreefishEngine.xorRotr(l2, 31, l6);
            l10 = ThreefishEngine.xorRotr(l10, 12, l15);
            l19 = ThreefishEngine.xorRotr(l18, 47, l11);
            l18 = ThreefishEngine.xorRotr(l13, 44, l12);
            l17 = ThreefishEngine.xorRotr(l20, 30, l5);
            l25 = l7 - l3 - arrayOfLong1[j];
            l13 = arrayOfLong1[m];
            l21 = l8 - l1 - arrayOfLong1[n];
            l7 = arrayOfLong1[i1];
            l20 = l14 - l4 - arrayOfLong1[i2];
            l14 = arrayOfLong1[i3];
            l22 = l6 - l2 - arrayOfLong1[i4];
            l8 = arrayOfLong1[i5];
            l16 = l15 - l10 - arrayOfLong1[i6];
            l23 = arrayOfLong1[i7];
            l15 = l11 - l19 - arrayOfLong1[i8];
            l27 = arrayOfLong1[i9];
            l12 = l12 - l18 - arrayOfLong1[i10];
            l11 = arrayOfLong1[i11];
            l26 = arrayOfLong2[k];
            l24 = l5 - l17 - (arrayOfLong1[i12] + arrayOfLong2[i13]);
            l6 = ThreefishEngine.xorRotr(l17 - (arrayOfLong1[i14] + l9), 5, l25);
            l17 = l25 - l6;
            l5 = ThreefishEngine.xorRotr(l19 - l27, 20, l21);
            l19 = l21 - l5;
            l11 = ThreefishEngine.xorRotr(l18 - (l11 + l26), 48, l22);
            l18 = l22 - l11;
            l9 = ThreefishEngine.xorRotr(l10 - l23, 41, l20);
            l20 -= l9;
            l3 = ThreefishEngine.xorRotr(l3 - l13, 47, l24);
            l10 = l24 - l3;
            l21 = ThreefishEngine.xorRotr(l4 - l14, 28, l16);
            l4 = l16 - l21;
            l7 = ThreefishEngine.xorRotr(l1 - l7, 16, l15);
            l13 = l15 - l7;
            l1 = ThreefishEngine.xorRotr(l2 - l8, 25, l12);
            l12 -= l1;
            l2 = ThreefishEngine.xorRotr(l1, 33, l17);
            l14 = l17 - l2;
            l1 = ThreefishEngine.xorRotr(l21, 4, l19);
            l15 = l19 - l1;
            l7 = ThreefishEngine.xorRotr(l7, 51, l20);
            l8 = l20 - l7;
            l3 = ThreefishEngine.xorRotr(l3, 13, l18);
            l16 = l18 - l3;
            l17 = ThreefishEngine.xorRotr(l6, 34, l12);
            l12 -= l17;
            l6 = ThreefishEngine.xorRotr(l11, 41, l10);
            l10 -= l6;
            l19 = ThreefishEngine.xorRotr(l5, 59, l4);
            l11 = l4 - l19;
            l4 = ThreefishEngine.xorRotr(l9, 17, l13);
            l20 = l13 - l4;
            l5 = ThreefishEngine.xorRotr(l4, 38, l14);
            l18 = l14 - l5;
            l6 = ThreefishEngine.xorRotr(l6, 19, l15);
            l13 = l15 - l6;
            l9 = ThreefishEngine.xorRotr(l19, 10, l16);
            l19 = l16 - l9;
            l14 = ThreefishEngine.xorRotr(l17, 55, l8);
            l4 = l8 - l14;
            l8 = ThreefishEngine.xorRotr(l2, 49, l20);
            l17 = l20 - l8;
            l2 = ThreefishEngine.xorRotr(l7, 18, l12);
            l12 -= l2;
            l16 = ThreefishEngine.xorRotr(l1, 23, l10);
            l7 = l10 - l16;
            l3 = ThreefishEngine.xorRotr(l3, 52, l11);
            l1 = l11 - l3;
            l11 = ThreefishEngine.xorRotr(l3, 24, l18);
            l2 = ThreefishEngine.xorRotr(l2, 13, l13);
            l15 = l13 - l2;
            l3 = ThreefishEngine.xorRotr(l16, 8, l4);
            l13 = ThreefishEngine.xorRotr(l8, 47, l19);
            l5 = ThreefishEngine.xorRotr(l5, 8, l1);
            l16 = ThreefishEngine.xorRotr(l9, 17, l17);
            l6 = ThreefishEngine.xorRotr(l6, 22, l12);
            l8 = ThreefishEngine.xorRotr(l14, 37, l7);
            l9 = l7 - l8;
            l7 = l16;
            l10 = l12 - l6;
            l12 = l1 - l5;
            l14 = l4 - l3;
            l4 = l11;
            i -= 2;
            l1 = l13;
            l17 -= l16;
            l13 = l19 - l13;
            l16 = l18 - l11;
            l11 = l17;
          }
          long l17 = arrayOfLong1[0];
          long l18 = arrayOfLong1[1];
          long l19 = arrayOfLong1[2];
          long l20 = arrayOfLong1[3];
          long l21 = arrayOfLong1[4];
          long l22 = arrayOfLong1[5];
          long l23 = arrayOfLong1[6];
          long l24 = arrayOfLong1[7];
          long l25 = arrayOfLong1[8];
          long l26 = arrayOfLong1[9];
          long l27 = arrayOfLong1[10];
          long l28 = arrayOfLong1[11];
          long l29 = arrayOfLong1[12];
          long l30 = arrayOfLong1[13];
          long l31 = arrayOfLong2[0];
          long l32 = arrayOfLong1[14];
          long l33 = arrayOfLong2[1];
          long l34 = arrayOfLong1[15];
          paramArrayOfLong2[0] = (l16 - l17);
          paramArrayOfLong2[1] = (l4 - l18);
          paramArrayOfLong2[2] = (l15 - l19);
          paramArrayOfLong2[3] = (l2 - l20);
          paramArrayOfLong2[4] = (l14 - l21);
          paramArrayOfLong2[5] = (l3 - l22);
          paramArrayOfLong2[6] = (l13 - l23);
          paramArrayOfLong2[7] = (l1 - l24);
          paramArrayOfLong2[8] = (l12 - l25);
          paramArrayOfLong2[9] = (l5 - l26);
          paramArrayOfLong2[10] = (l11 - l27);
          paramArrayOfLong2[11] = (l7 - l28);
          paramArrayOfLong2[12] = (l10 - l29);
          paramArrayOfLong2[13] = (l6 - (l30 + l31));
          paramArrayOfLong2[14] = (l9 - (l32 + l33));
          paramArrayOfLong2[15] = (l8 - l34);
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    void encryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong2 = this.kw;
      long[] arrayOfLong1 = this.t;
      int[] arrayOfInt1 = ThreefishEngine.MOD17;
      int[] arrayOfInt2 = ThreefishEngine.MOD3;
      if (arrayOfLong2.length == 33)
      {
        if (arrayOfLong1.length == 5)
        {
          long l16 = paramArrayOfLong1[0];
          int i = 1;
          long l15 = paramArrayOfLong1[1];
          long l14 = paramArrayOfLong1[2];
          long l13 = paramArrayOfLong1[3];
          long l12 = paramArrayOfLong1[4];
          long l11 = paramArrayOfLong1[5];
          long l10 = paramArrayOfLong1[6];
          long l9 = paramArrayOfLong1[7];
          long l8 = paramArrayOfLong1[8];
          long l7 = paramArrayOfLong1[9];
          long l6 = paramArrayOfLong1[10];
          long l5 = paramArrayOfLong1[11];
          long l4 = paramArrayOfLong1[12];
          long l3 = paramArrayOfLong1[13];
          long l2 = paramArrayOfLong1[14];
          long l1 = paramArrayOfLong1[15];
          l16 += arrayOfLong2[0];
          l15 += arrayOfLong2[1];
          l14 += arrayOfLong2[2];
          long l17 = arrayOfLong2[3];
          l12 += arrayOfLong2[4];
          long l18 = arrayOfLong2[5];
          l10 += arrayOfLong2[6];
          long l19 = arrayOfLong2[7];
          l8 += arrayOfLong2[8];
          long l20 = arrayOfLong2[9];
          l6 += arrayOfLong2[10];
          long l21 = arrayOfLong2[11];
          l4 += arrayOfLong2[12];
          long l22 = arrayOfLong2[13];
          long l23 = arrayOfLong1[0];
          l2 += arrayOfLong2[14] + arrayOfLong1[1];
          long l24 = arrayOfLong2[15];
          l13 += l17;
          l11 += l18;
          l9 += l19;
          l7 += l20;
          l5 += l21;
          l3 += l22 + l23;
          l1 += l24;
          paramArrayOfLong1 = arrayOfLong2;
          while (i < 20)
          {
            int j = arrayOfInt1[i];
            int k = arrayOfInt2[i];
            l16 += l15;
            l15 = ThreefishEngine.rotlXor(l15, 24, l16);
            l14 += l13;
            l13 = ThreefishEngine.rotlXor(l13, 13, l14);
            l12 += l11;
            l11 = ThreefishEngine.rotlXor(l11, 8, l12);
            l17 = l10 + l9;
            l9 = ThreefishEngine.rotlXor(l9, 47, l17);
            l8 += l7;
            l10 = ThreefishEngine.rotlXor(l7, 8, l8);
            l18 = l6 + l5;
            l6 = ThreefishEngine.rotlXor(l5, 17, l18);
            l19 = l4 + l3;
            l3 = ThreefishEngine.rotlXor(l3, 22, l19);
            l20 = l2 + l1;
            l4 = ThreefishEngine.rotlXor(l1, 37, l20);
            l7 = l16 + l10;
            l1 = ThreefishEngine.rotlXor(l10, 38, l7);
            l10 = l14 + l3;
            l2 = ThreefishEngine.rotlXor(l3, 19, l10);
            l5 = l17 + l6;
            l3 = ThreefishEngine.rotlXor(l6, 10, l5);
            l16 = l12 + l4;
            l6 = ThreefishEngine.rotlXor(l4, 55, l16);
            l4 = l18 + l9;
            l9 = ThreefishEngine.rotlXor(l9, 49, l4);
            l17 = l19 + l13;
            l13 = ThreefishEngine.rotlXor(l13, 18, l17);
            l18 = l20 + l11;
            l20 = ThreefishEngine.rotlXor(l11, 23, l18);
            l19 = l8 + l15;
            l8 = ThreefishEngine.rotlXor(l15, 52, l19);
            l12 = l7 + l9;
            l11 = ThreefishEngine.rotlXor(l9, 33, l12);
            l14 = l10 + l20;
            l9 = ThreefishEngine.rotlXor(l20, 4, l14);
            l7 = l16 + l13;
            l10 = ThreefishEngine.rotlXor(l13, 51, l7);
            l15 = l5 + l8;
            l8 = ThreefishEngine.rotlXor(l8, 13, l15);
            l13 = l17 + l6;
            l5 = ThreefishEngine.rotlXor(l6, 34, l13);
            l16 = l18 + l2;
            l2 = ThreefishEngine.rotlXor(l2, 41, l16);
            l17 = l19 + l3;
            l20 = ThreefishEngine.rotlXor(l3, 59, l17);
            l18 = l4 + l1;
            l19 = ThreefishEngine.rotlXor(l1, 17, l18);
            l3 = l12 + l5;
            l6 = ThreefishEngine.rotlXor(l5, 5, l3);
            l5 = l14 + l20;
            l1 = ThreefishEngine.rotlXor(l20, 20, l5);
            l4 = l15 + l2;
            l12 = ThreefishEngine.rotlXor(l2, 48, l4);
            l7 += l19;
            l14 = ThreefishEngine.rotlXor(l19, 41, l7);
            l2 = l16 + l8;
            l16 = ThreefishEngine.rotlXor(l8, 47, l2);
            l8 = l17 + l9;
            l15 = ThreefishEngine.rotlXor(l9, 28, l8);
            l9 = l18 + l10;
            l17 = ThreefishEngine.rotlXor(l10, 16, l9);
            l10 = l13 + l11;
            l11 = ThreefishEngine.rotlXor(l11, 25, l10);
            l18 = paramArrayOfLong1[j];
            int m = j + 1;
            long l27 = l16 + paramArrayOfLong1[m];
            int n = j + 2;
            l21 = paramArrayOfLong1[n];
            int i1 = j + 3;
            long l26 = l17 + paramArrayOfLong1[i1];
            int i2 = j + 4;
            l24 = paramArrayOfLong1[i2];
            int i3 = j + 5;
            long l25 = l15 + paramArrayOfLong1[i3];
            int i4 = j + 6;
            l22 = paramArrayOfLong1[i4];
            int i5 = j + 7;
            l23 = l11 + paramArrayOfLong1[i5];
            int i6 = j + 8;
            l19 = paramArrayOfLong1[i6];
            int i7 = j + 9;
            l20 = l14 + paramArrayOfLong1[i7];
            int i8 = j + 10;
            l16 = paramArrayOfLong1[i8];
            int i9 = j + 11;
            l17 = l1 + paramArrayOfLong1[i9];
            int i10 = j + 12;
            l13 = paramArrayOfLong1[i10];
            int i11 = j + 13;
            l14 = l12 + (paramArrayOfLong1[i11] + arrayOfLong1[k]);
            int i12 = j + 14;
            l11 = paramArrayOfLong1[i12];
            int i13 = k + 1;
            l12 = arrayOfLong1[i13];
            int i14 = j + 15;
            l15 = paramArrayOfLong1[i14];
            l1 = i;
            l15 = l6 + (l15 + l1);
            l18 = l3 + l18 + l27;
            l3 = ThreefishEngine.rotlXor(l27, 41, l18);
            l21 = l5 + l21 + l26;
            l5 = ThreefishEngine.rotlXor(l26, 9, l21);
            l7 = l7 + l24 + l25;
            l6 = ThreefishEngine.rotlXor(l25, 37, l7);
            l24 = l4 + l22 + l23;
            l22 = ThreefishEngine.rotlXor(l23, 31, l24);
            l4 = l8 + l19 + l20;
            l8 = ThreefishEngine.rotlXor(l20, 12, l4);
            l16 = l9 + l16 + l17;
            l9 = ThreefishEngine.rotlXor(l17, 47, l16);
            l13 = l10 + l13 + l14;
            l10 = ThreefishEngine.rotlXor(l14, 44, l13);
            l17 = l2 + (l11 + l12) + l15;
            l11 = ThreefishEngine.rotlXor(l15, 30, l17);
            l12 = l18 + l8;
            l2 = ThreefishEngine.rotlXor(l8, 16, l12);
            l14 = l21 + l10;
            l8 = ThreefishEngine.rotlXor(l10, 34, l14);
            l10 = l24 + l9;
            l9 = ThreefishEngine.rotlXor(l9, 56, l10);
            l18 = l7 + l11;
            l11 = ThreefishEngine.rotlXor(l11, 51, l18);
            l7 = l16 + l22;
            l15 = ThreefishEngine.rotlXor(l22, 4, l7);
            l13 += l5;
            l19 = ThreefishEngine.rotlXor(l5, 53, l13);
            l16 = l17 + l6;
            l5 = ThreefishEngine.rotlXor(l6, 42, l16);
            l17 = l4 + l3;
            l20 = ThreefishEngine.rotlXor(l3, 41, l17);
            l4 = l12 + l15;
            l3 = ThreefishEngine.rotlXor(l15, 31, l4);
            l15 = l14 + l5;
            l5 = ThreefishEngine.rotlXor(l5, 44, l15);
            l12 = l18 + l19;
            l6 = ThreefishEngine.rotlXor(l19, 47, l12);
            l18 = l10 + l20;
            l10 = ThreefishEngine.rotlXor(l20, 46, l18);
            l13 += l11;
            l11 = ThreefishEngine.rotlXor(l11, 19, l13);
            l16 += l8;
            l8 = ThreefishEngine.rotlXor(l8, 42, l16);
            l19 = l17 + l9;
            l9 = ThreefishEngine.rotlXor(l9, 44, l19);
            l20 = l7 + l2;
            l7 = ThreefishEngine.rotlXor(l2, 25, l20);
            l14 = l4 + l11;
            l2 = ThreefishEngine.rotlXor(l11, 9, l14);
            l17 = l15 + l9;
            l9 = ThreefishEngine.rotlXor(l9, 48, l17);
            l4 = l18 + l8;
            l11 = ThreefishEngine.rotlXor(l8, 35, l4);
            l12 += l7;
            l7 = ThreefishEngine.rotlXor(l7, 52, l12);
            l8 = l16 + l10;
            l15 = ThreefishEngine.rotlXor(l10, 23, l8);
            l10 = l19 + l5;
            l22 = ThreefishEngine.rotlXor(l5, 31, l10);
            l5 = l20 + l6;
            l25 = ThreefishEngine.rotlXor(l6, 37, l5);
            l20 = l13 + l3;
            long l28 = ThreefishEngine.rotlXor(l3, 20, l20);
            l16 = paramArrayOfLong1[m];
            l21 = paramArrayOfLong1[n];
            l18 = paramArrayOfLong1[i1];
            l13 = paramArrayOfLong1[i2];
            l19 = paramArrayOfLong1[i3];
            l27 = paramArrayOfLong1[i4];
            l23 = paramArrayOfLong1[i5];
            long l29 = paramArrayOfLong1[i6];
            l24 = paramArrayOfLong1[i7];
            l7 += paramArrayOfLong1[i8];
            l6 = l5 + paramArrayOfLong1[i9];
            l5 = l9 + paramArrayOfLong1[i10];
            l26 = paramArrayOfLong1[i11];
            l3 = l11 + (paramArrayOfLong1[i12] + arrayOfLong1[i13]);
            long l30 = paramArrayOfLong1[i14];
            long l31 = arrayOfLong1[(k + 2)];
            l1 = l2 + (paramArrayOfLong1[(j + 16)] + l1 + 1L);
            l9 = l28 + l29;
            l13 = l25 + l13;
            l11 = l22 + l27;
            l2 = l8 + (l30 + l31);
            l8 = l10 + l24;
            l10 = l4 + l23;
            l4 = l20 + l26;
            l15 += l21;
            i += 2;
            l12 += l19;
            l16 = l14 + l16;
            l14 = l17 + l18;
          }
          paramArrayOfLong2[0] = l16;
          paramArrayOfLong2[1] = l15;
          paramArrayOfLong2[2] = l14;
          paramArrayOfLong2[3] = l13;
          paramArrayOfLong2[4] = l12;
          paramArrayOfLong2[5] = l11;
          paramArrayOfLong2[6] = l10;
          paramArrayOfLong2[7] = l9;
          paramArrayOfLong2[8] = l8;
          paramArrayOfLong2[9] = l7;
          paramArrayOfLong2[10] = l6;
          paramArrayOfLong2[11] = l5;
          paramArrayOfLong2[12] = l4;
          paramArrayOfLong2[13] = l3;
          paramArrayOfLong2[14] = l2;
          paramArrayOfLong2[15] = l1;
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
  }
  
  private static final class Threefish256Cipher
    extends ThreefishEngine.ThreefishCipher
  {
    private static final int ROTATION_0_0 = 14;
    private static final int ROTATION_0_1 = 16;
    private static final int ROTATION_1_0 = 52;
    private static final int ROTATION_1_1 = 57;
    private static final int ROTATION_2_0 = 23;
    private static final int ROTATION_2_1 = 40;
    private static final int ROTATION_3_0 = 5;
    private static final int ROTATION_3_1 = 37;
    private static final int ROTATION_4_0 = 25;
    private static final int ROTATION_4_1 = 33;
    private static final int ROTATION_5_0 = 46;
    private static final int ROTATION_5_1 = 12;
    private static final int ROTATION_6_0 = 58;
    private static final int ROTATION_6_1 = 22;
    private static final int ROTATION_7_0 = 32;
    private static final int ROTATION_7_1 = 32;
    
    public Threefish256Cipher(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      super(paramArrayOfLong2);
    }
    
    void decryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong1 = this.kw;
      long[] arrayOfLong2 = this.t;
      int[] arrayOfInt1 = ThreefishEngine.MOD5;
      int[] arrayOfInt2 = ThreefishEngine.MOD3;
      if (arrayOfLong1.length == 9)
      {
        if (arrayOfLong2.length == 5)
        {
          long l4 = paramArrayOfLong1[0];
          long l1 = paramArrayOfLong1[1];
          long l3 = paramArrayOfLong1[2];
          long l2 = paramArrayOfLong1[3];
          int i = 17;
          paramArrayOfLong1 = arrayOfInt2;
          while (i >= 1)
          {
            int j = arrayOfInt1[i];
            int k = paramArrayOfLong1[i];
            int m = j + 1;
            l7 = l4 - arrayOfLong1[m];
            int n = j + 2;
            l4 = arrayOfLong1[n];
            int i1 = k + 1;
            l5 = arrayOfLong2[i1];
            int i2 = j + 3;
            l6 = l3 - (arrayOfLong1[i2] + arrayOfLong2[(k + 2)]);
            l8 = arrayOfLong1[(j + 4)];
            l3 = i;
            l2 = ThreefishEngine.xorRotr(l2 - (l8 + l3 + 1L), 32, l7);
            l7 -= l2;
            l1 = ThreefishEngine.xorRotr(l1 - (l4 + l5), 32, l6);
            l4 = l6 - l1;
            l1 = ThreefishEngine.xorRotr(l1, 58, l7);
            l5 = l7 - l1;
            l6 = ThreefishEngine.xorRotr(l2, 22, l4);
            l2 = l4 - l6;
            l4 = ThreefishEngine.xorRotr(l6, 46, l5);
            l5 -= l4;
            l1 = ThreefishEngine.xorRotr(l1, 12, l2);
            l2 -= l1;
            l1 = ThreefishEngine.xorRotr(l1, 25, l5);
            l7 = ThreefishEngine.xorRotr(l4, 33, l2);
            l8 = l5 - l1 - arrayOfLong1[j];
            l4 = arrayOfLong1[m];
            l5 = arrayOfLong2[k];
            l6 = l2 - l7 - (arrayOfLong1[n] + arrayOfLong2[i1]);
            l2 = ThreefishEngine.xorRotr(l7 - (arrayOfLong1[i2] + l3), 5, l8);
            l3 = l8 - l2;
            l1 = ThreefishEngine.xorRotr(l1 - (l4 + l5), 37, l6);
            l4 = l6 - l1;
            l1 = ThreefishEngine.xorRotr(l1, 23, l3);
            l3 -= l1;
            l2 = ThreefishEngine.xorRotr(l2, 40, l4);
            l4 -= l2;
            l2 = ThreefishEngine.xorRotr(l2, 52, l3);
            l3 -= l2;
            l1 = ThreefishEngine.xorRotr(l1, 57, l4);
            l5 = l4 - l1;
            l1 = ThreefishEngine.xorRotr(l1, 14, l3);
            l4 = l3 - l1;
            l2 = ThreefishEngine.xorRotr(l2, 16, l5);
            l3 = l5 - l2;
            i -= 2;
          }
          long l5 = arrayOfLong1[0];
          long l6 = arrayOfLong1[1];
          long l7 = arrayOfLong2[0];
          long l8 = arrayOfLong1[2];
          long l9 = arrayOfLong2[1];
          long l10 = arrayOfLong1[3];
          paramArrayOfLong2[0] = (l4 - l5);
          paramArrayOfLong2[1] = (l1 - (l6 + l7));
          paramArrayOfLong2[2] = (l3 - (l8 + l9));
          paramArrayOfLong2[3] = (l2 - l10);
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    void encryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong1 = this.kw;
      long[] arrayOfLong2 = this.t;
      int[] arrayOfInt1 = ThreefishEngine.MOD5;
      int[] arrayOfInt2 = ThreefishEngine.MOD3;
      if (arrayOfLong1.length == 9)
      {
        if (arrayOfLong2.length == 5)
        {
          long l4 = paramArrayOfLong1[0];
          long l3 = paramArrayOfLong1[1];
          long l2 = paramArrayOfLong1[2];
          long l1 = paramArrayOfLong1[3];
          l4 += arrayOfLong1[0];
          l3 += arrayOfLong1[1] + arrayOfLong2[0];
          l2 += arrayOfLong1[2] + arrayOfLong2[1];
          l1 += arrayOfLong1[3];
          int i = 1;
          paramArrayOfLong1 = arrayOfInt2;
          while (i < 18)
          {
            int j = arrayOfInt1[i];
            int k = paramArrayOfLong1[i];
            l4 += l3;
            l3 = ThreefishEngine.rotlXor(l3, 14, l4);
            l2 += l1;
            l1 = ThreefishEngine.rotlXor(l1, 16, l2);
            l4 += l1;
            l1 = ThreefishEngine.rotlXor(l1, 52, l4);
            l2 += l3;
            long l5 = ThreefishEngine.rotlXor(l3, 57, l2);
            l3 = l4 + l5;
            l5 = ThreefishEngine.rotlXor(l5, 23, l3);
            long l6 = l2 + l1;
            l1 = ThreefishEngine.rotlXor(l1, 40, l6);
            l2 = l3 + l1;
            l4 = ThreefishEngine.rotlXor(l1, 5, l2);
            l3 = l6 + l5;
            l1 = ThreefishEngine.rotlXor(l5, 37, l3);
            long l7 = arrayOfLong1[j];
            int m = j + 1;
            long l8 = l1 + (arrayOfLong1[m] + arrayOfLong2[k]);
            int n = j + 2;
            l5 = arrayOfLong1[n];
            int i1 = k + 1;
            l6 = arrayOfLong2[i1];
            int i2 = j + 3;
            long l9 = arrayOfLong1[i2];
            l1 = i;
            l4 += l9 + l1;
            l7 = l2 + l7 + l8;
            l2 = ThreefishEngine.rotlXor(l8, 25, l7);
            l5 = l3 + (l5 + l6) + l4;
            l3 = ThreefishEngine.rotlXor(l4, 33, l5);
            l4 = l7 + l3;
            l3 = ThreefishEngine.rotlXor(l3, 46, l4);
            l5 += l2;
            l2 = ThreefishEngine.rotlXor(l2, 12, l5);
            l4 += l2;
            l2 = ThreefishEngine.rotlXor(l2, 58, l4);
            l6 = l5 + l3;
            l5 = ThreefishEngine.rotlXor(l3, 22, l6);
            l3 = l4 + l5;
            l5 = ThreefishEngine.rotlXor(l5, 32, l3);
            l6 += l2;
            l2 = ThreefishEngine.rotlXor(l2, 32, l6);
            l4 = l3 + arrayOfLong1[m];
            l3 = l2 + (arrayOfLong1[n] + arrayOfLong2[i1]);
            l2 = l6 + (arrayOfLong1[i2] + arrayOfLong2[(k + 2)]);
            l1 = l5 + (arrayOfLong1[(j + 4)] + l1 + 1L);
            i += 2;
          }
          paramArrayOfLong2[0] = l4;
          paramArrayOfLong2[1] = l3;
          paramArrayOfLong2[2] = l2;
          paramArrayOfLong2[3] = l1;
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
  }
  
  private static final class Threefish512Cipher
    extends ThreefishEngine.ThreefishCipher
  {
    private static final int ROTATION_0_0 = 46;
    private static final int ROTATION_0_1 = 36;
    private static final int ROTATION_0_2 = 19;
    private static final int ROTATION_0_3 = 37;
    private static final int ROTATION_1_0 = 33;
    private static final int ROTATION_1_1 = 27;
    private static final int ROTATION_1_2 = 14;
    private static final int ROTATION_1_3 = 42;
    private static final int ROTATION_2_0 = 17;
    private static final int ROTATION_2_1 = 49;
    private static final int ROTATION_2_2 = 36;
    private static final int ROTATION_2_3 = 39;
    private static final int ROTATION_3_0 = 44;
    private static final int ROTATION_3_1 = 9;
    private static final int ROTATION_3_2 = 54;
    private static final int ROTATION_3_3 = 56;
    private static final int ROTATION_4_0 = 39;
    private static final int ROTATION_4_1 = 30;
    private static final int ROTATION_4_2 = 34;
    private static final int ROTATION_4_3 = 24;
    private static final int ROTATION_5_0 = 13;
    private static final int ROTATION_5_1 = 50;
    private static final int ROTATION_5_2 = 10;
    private static final int ROTATION_5_3 = 17;
    private static final int ROTATION_6_0 = 25;
    private static final int ROTATION_6_1 = 29;
    private static final int ROTATION_6_2 = 39;
    private static final int ROTATION_6_3 = 43;
    private static final int ROTATION_7_0 = 8;
    private static final int ROTATION_7_1 = 35;
    private static final int ROTATION_7_2 = 56;
    private static final int ROTATION_7_3 = 22;
    
    protected Threefish512Cipher(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      super(paramArrayOfLong2);
    }
    
    public void decryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong2 = this.kw;
      long[] arrayOfLong1 = this.t;
      int[] arrayOfInt2 = ThreefishEngine.MOD9;
      int[] arrayOfInt1 = ThreefishEngine.MOD3;
      if (arrayOfLong2.length == 17)
      {
        if (arrayOfLong1.length == 5)
        {
          long l8 = paramArrayOfLong1[0];
          long l4 = paramArrayOfLong1[1];
          long l7 = paramArrayOfLong1[2];
          long l1 = paramArrayOfLong1[3];
          long l6 = paramArrayOfLong1[4];
          long l2 = paramArrayOfLong1[5];
          long l5 = paramArrayOfLong1[6];
          long l3 = paramArrayOfLong1[7];
          int i = 17;
          paramArrayOfLong1 = arrayOfInt2;
          while (i >= 1)
          {
            int j = paramArrayOfLong1[i];
            int k = arrayOfInt1[i];
            int m = j + 1;
            l9 = l8 - arrayOfLong2[m];
            int n = j + 2;
            l10 = arrayOfLong2[n];
            int i1 = j + 3;
            l8 = l7 - arrayOfLong2[i1];
            int i2 = j + 4;
            l7 = arrayOfLong2[i2];
            int i3 = j + 5;
            l6 -= arrayOfLong2[i3];
            int i4 = j + 6;
            l11 = arrayOfLong2[i4];
            int i5 = k + 1;
            l12 = arrayOfLong1[i5];
            int i6 = j + 7;
            l14 = l5 - (arrayOfLong2[i6] + arrayOfLong1[(k + 2)]);
            l13 = arrayOfLong2[(j + 8)];
            l5 = i;
            l10 = ThreefishEngine.xorRotr(l4 - l10, 8, l14);
            l4 = l14 - l10;
            l3 = ThreefishEngine.xorRotr(l3 - (l13 + l5 + 1L), 35, l9);
            l9 -= l3;
            l11 = ThreefishEngine.xorRotr(l2 - (l11 + l12), 56, l8);
            l2 = l8 - l11;
            l1 = ThreefishEngine.xorRotr(l1 - l7, 22, l6);
            l6 -= l1;
            l10 = ThreefishEngine.xorRotr(l10, 25, l6);
            l6 -= l10;
            l1 = ThreefishEngine.xorRotr(l1, 29, l4);
            l7 = l4 - l1;
            l11 = ThreefishEngine.xorRotr(l11, 39, l9);
            l8 = l9 - l11;
            l3 = ThreefishEngine.xorRotr(l3, 43, l2);
            l4 = l2 - l3;
            l2 = ThreefishEngine.xorRotr(l10, 13, l4);
            l4 -= l2;
            l9 = ThreefishEngine.xorRotr(l3, 50, l6);
            l6 -= l9;
            l10 = ThreefishEngine.xorRotr(l11, 10, l7);
            l3 = l7 - l10;
            l1 = ThreefishEngine.xorRotr(l1, 17, l8);
            l8 -= l1;
            l7 = ThreefishEngine.xorRotr(l2, 39, l8);
            l1 = ThreefishEngine.xorRotr(l1, 30, l4);
            l2 = ThreefishEngine.xorRotr(l10, 34, l6);
            l9 = ThreefishEngine.xorRotr(l9, 24, l3);
            l10 = l8 - l7 - arrayOfLong2[j];
            l13 = arrayOfLong2[m];
            l8 = l4 - l1 - arrayOfLong2[n];
            l4 = arrayOfLong2[i1];
            l6 = l6 - l2 - arrayOfLong2[i2];
            l11 = arrayOfLong2[i3];
            l12 = arrayOfLong1[k];
            l3 = l3 - l9 - (arrayOfLong2[i4] + arrayOfLong1[i5]);
            l14 = arrayOfLong2[i6];
            l7 = ThreefishEngine.xorRotr(l7 - l13, 44, l3);
            l3 -= l7;
            l5 = ThreefishEngine.xorRotr(l9 - (l14 + l5), 9, l10);
            l9 = l10 - l5;
            l10 = ThreefishEngine.xorRotr(l2 - (l11 + l12), 54, l8);
            l2 = l8 - l10;
            l1 = ThreefishEngine.xorRotr(l1 - l4, 56, l6);
            l6 -= l1;
            l4 = ThreefishEngine.xorRotr(l7, 17, l6);
            l6 -= l4;
            l1 = ThreefishEngine.xorRotr(l1, 49, l3);
            l3 -= l1;
            l8 = ThreefishEngine.xorRotr(l10, 36, l9);
            l7 = l9 - l8;
            l5 = ThreefishEngine.xorRotr(l5, 39, l2);
            l9 = l2 - l5;
            l2 = ThreefishEngine.xorRotr(l4, 33, l9);
            l4 = l9 - l2;
            l5 = ThreefishEngine.xorRotr(l5, 27, l6);
            l6 -= l5;
            l10 = ThreefishEngine.xorRotr(l8, 14, l3);
            l9 = l3 - l10;
            l1 = ThreefishEngine.xorRotr(l1, 42, l7);
            l8 = l7 - l1;
            l7 = ThreefishEngine.xorRotr(l2, 46, l8);
            l1 = ThreefishEngine.xorRotr(l1, 36, l4);
            l2 = ThreefishEngine.xorRotr(l10, 19, l6);
            l6 -= l2;
            l3 = ThreefishEngine.xorRotr(l5, 37, l9);
            l5 = l9 - l3;
            l9 = l4 - l1;
            l4 = l7;
            i -= 2;
            l8 -= l7;
            l7 = l9;
          }
          long l9 = arrayOfLong2[0];
          long l10 = arrayOfLong2[1];
          long l11 = arrayOfLong2[2];
          long l12 = arrayOfLong2[3];
          long l13 = arrayOfLong2[4];
          long l14 = arrayOfLong2[5];
          long l15 = arrayOfLong1[0];
          long l16 = arrayOfLong2[6];
          long l17 = arrayOfLong1[1];
          long l18 = arrayOfLong2[7];
          paramArrayOfLong2[0] = (l8 - l9);
          paramArrayOfLong2[1] = (l4 - l10);
          paramArrayOfLong2[2] = (l7 - l11);
          paramArrayOfLong2[3] = (l1 - l12);
          paramArrayOfLong2[4] = (l6 - l13);
          paramArrayOfLong2[5] = (l2 - (l14 + l15));
          paramArrayOfLong2[6] = (l5 - (l16 + l17));
          paramArrayOfLong2[7] = (l3 - l18);
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    
    public void encryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      long[] arrayOfLong1 = this.kw;
      long[] arrayOfLong2 = this.t;
      int[] arrayOfInt1 = ThreefishEngine.MOD9;
      int[] arrayOfInt2 = ThreefishEngine.MOD3;
      if (arrayOfLong1.length == 17)
      {
        if (arrayOfLong2.length == 5)
        {
          long l8 = paramArrayOfLong1[0];
          long l7 = paramArrayOfLong1[1];
          long l6 = paramArrayOfLong1[2];
          long l5 = paramArrayOfLong1[3];
          long l4 = paramArrayOfLong1[4];
          long l3 = paramArrayOfLong1[5];
          long l2 = paramArrayOfLong1[6];
          long l1 = paramArrayOfLong1[7];
          l8 += arrayOfLong1[0];
          l7 += arrayOfLong1[1];
          l6 += arrayOfLong1[2];
          long l9 = arrayOfLong1[3];
          l4 += arrayOfLong1[4];
          long l10 = arrayOfLong1[5];
          long l11 = arrayOfLong2[0];
          l2 += arrayOfLong1[6] + arrayOfLong2[1];
          long l12 = arrayOfLong1[7];
          l5 += l9;
          l3 += l10 + l11;
          l1 += l12;
          int i = 1;
          paramArrayOfLong1 = arrayOfInt2;
          while (i < 18)
          {
            int j = arrayOfInt1[i];
            int k = paramArrayOfLong1[i];
            l8 += l7;
            l7 = ThreefishEngine.rotlXor(l7, 46, l8);
            l6 += l5;
            l5 = ThreefishEngine.rotlXor(l5, 36, l6);
            l9 = l4 + l3;
            l3 = ThreefishEngine.rotlXor(l3, 19, l9);
            l10 = l2 + l1;
            l2 = ThreefishEngine.rotlXor(l1, 37, l10);
            l1 = l6 + l7;
            l4 = ThreefishEngine.rotlXor(l7, 33, l1);
            l6 = l9 + l2;
            l2 = ThreefishEngine.rotlXor(l2, 27, l6);
            l7 = l10 + l3;
            l3 = ThreefishEngine.rotlXor(l3, 14, l7);
            l8 += l5;
            l9 = ThreefishEngine.rotlXor(l5, 42, l8);
            l5 = l6 + l4;
            l4 = ThreefishEngine.rotlXor(l4, 17, l5);
            l6 = l7 + l9;
            l7 = ThreefishEngine.rotlXor(l9, 49, l6);
            l9 = l8 + l3;
            l8 = ThreefishEngine.rotlXor(l3, 36, l9);
            l10 = l1 + l2;
            l11 = ThreefishEngine.rotlXor(l2, 39, l10);
            l2 = l6 + l4;
            l1 = ThreefishEngine.rotlXor(l4, 44, l2);
            l3 = l9 + l11;
            l6 = ThreefishEngine.rotlXor(l11, 9, l3);
            l4 = l10 + l8;
            l8 = ThreefishEngine.rotlXor(l8, 54, l4);
            l5 += l7;
            l7 = ThreefishEngine.rotlXor(l7, 56, l5);
            long l13 = arrayOfLong1[j];
            int m = j + 1;
            long l14 = l1 + arrayOfLong1[m];
            int n = j + 2;
            l11 = arrayOfLong1[n];
            int i1 = j + 3;
            l12 = l7 + arrayOfLong1[i1];
            int i2 = j + 4;
            l9 = arrayOfLong1[i2];
            int i3 = j + 5;
            l10 = l8 + (arrayOfLong1[i3] + arrayOfLong2[k]);
            int i4 = j + 6;
            l7 = arrayOfLong1[i4];
            int i5 = k + 1;
            l8 = arrayOfLong2[i5];
            int i6 = j + 7;
            long l15 = arrayOfLong1[i6];
            l1 = i;
            l6 += l15 + l1;
            l3 = l3 + l13 + l14;
            l13 = ThreefishEngine.rotlXor(l14, 39, l3);
            l11 = l4 + l11 + l12;
            l4 = ThreefishEngine.rotlXor(l12, 30, l11);
            l5 = l5 + l9 + l10;
            l9 = ThreefishEngine.rotlXor(l10, 34, l5);
            l7 = l2 + (l7 + l8) + l6;
            l8 = ThreefishEngine.rotlXor(l6, 24, l7);
            l2 = l11 + l13;
            l6 = ThreefishEngine.rotlXor(l13, 13, l2);
            l10 = l5 + l8;
            l5 = ThreefishEngine.rotlXor(l8, 50, l10);
            l7 += l9;
            l8 = ThreefishEngine.rotlXor(l9, 10, l7);
            l9 = l3 + l4;
            l11 = ThreefishEngine.rotlXor(l4, 17, l9);
            l3 = l10 + l6;
            l4 = ThreefishEngine.rotlXor(l6, 25, l3);
            l6 = l7 + l11;
            l7 = ThreefishEngine.rotlXor(l11, 29, l6);
            l10 = l9 + l8;
            l9 = ThreefishEngine.rotlXor(l8, 39, l10);
            l12 = l2 + l5;
            l5 = ThreefishEngine.rotlXor(l5, 43, l12);
            l2 = l6 + l4;
            l11 = ThreefishEngine.rotlXor(l4, 8, l2);
            l8 = l10 + l5;
            l4 = ThreefishEngine.rotlXor(l5, 35, l8);
            l6 = l12 + l9;
            l5 = ThreefishEngine.rotlXor(l9, 56, l6);
            l3 += l7;
            l10 = ThreefishEngine.rotlXor(l7, 22, l3);
            l9 = arrayOfLong1[m];
            l7 = l11 + arrayOfLong1[n];
            l11 = arrayOfLong1[i1];
            l12 = arrayOfLong1[i2];
            l15 = arrayOfLong1[i3];
            l13 = arrayOfLong1[i4];
            l14 = arrayOfLong2[i5];
            l2 += arrayOfLong1[i6] + arrayOfLong2[(k + 2)];
            l1 = l4 + (arrayOfLong1[(j + 8)] + l1 + 1L);
            l4 = l3 + l15;
            l3 = l5 + (l13 + l14);
            i += 2;
            l5 = l10 + l12;
            l6 += l11;
            l8 += l9;
          }
          paramArrayOfLong2[0] = l8;
          paramArrayOfLong2[1] = l7;
          paramArrayOfLong2[2] = l6;
          paramArrayOfLong2[3] = l5;
          paramArrayOfLong2[4] = l4;
          paramArrayOfLong2[5] = l3;
          paramArrayOfLong2[6] = l2;
          paramArrayOfLong2[7] = l1;
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
  }
  
  private static abstract class ThreefishCipher
  {
    protected final long[] kw;
    protected final long[] t;
    
    protected ThreefishCipher(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.kw = paramArrayOfLong1;
      this.t = paramArrayOfLong2;
    }
    
    abstract void decryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2);
    
    abstract void encryptBlock(long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ThreefishEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */