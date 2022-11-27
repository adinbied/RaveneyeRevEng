package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class DESEngine
  implements BlockCipher
{
  protected static final int BLOCK_SIZE = 8;
  private static final int[] SP1 = { 16843776, 0, 65536, 16843780, 16842756, 66564, 4, 65536, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, 65540, 16777220, 16777220, 65540, 0, 1028, 66564, 16777216, 65536, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, 65540, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, 65540, 66560, 0, 16842756 };
  private static final int[] SP2 = { -2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344 };
  private static final int[] SP3 = { 520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584 };
  private static final int[] SP4 = { 8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928 };
  private static final int[] SP5 = { 256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080 };
  private static final int[] SP6 = { 536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312 };
  private static final int[] SP7 = { 2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154 };
  private static final int[] SP8 = { 268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696 };
  private static final int[] bigbyte;
  private static final short[] bytebit = { 128, 64, 32, 16, 8, 4, 2, 1 };
  private static final byte[] pc1;
  private static final byte[] pc2;
  private static final byte[] totrot;
  private int[] workingKey = null;
  
  static
  {
    bigbyte = new int[] { 8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
    pc1 = new byte[] { 56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3 };
    totrot = new byte[] { 1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28 };
    pc2 = new byte[] { 13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31 };
  }
  
  protected void desFunc(int[] paramArrayOfInt, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = (paramArrayOfByte1[(paramInt1 + 0)] & 0xFF) << 24 | (paramArrayOfByte1[(paramInt1 + 1)] & 0xFF) << 16 | (paramArrayOfByte1[(paramInt1 + 2)] & 0xFF) << 8 | paramArrayOfByte1[(paramInt1 + 3)] & 0xFF;
    paramInt1 = (paramArrayOfByte1[(paramInt1 + 4)] & 0xFF) << 24 | (paramArrayOfByte1[(paramInt1 + 5)] & 0xFF) << 16 | (paramArrayOfByte1[(paramInt1 + 6)] & 0xFF) << 8 | paramArrayOfByte1[(paramInt1 + 7)] & 0xFF;
    int j = (i >>> 4 ^ paramInt1) & 0xF0F0F0F;
    paramInt1 ^= j;
    i ^= j << 4;
    j = (i >>> 16 ^ paramInt1) & 0xFFFF;
    paramInt1 ^= j;
    i ^= j << 16;
    j = (paramInt1 >>> 2 ^ i) & 0x33333333;
    i ^= j;
    j = paramInt1 ^ j << 2;
    int k = (j >>> 8 ^ i) & 0xFF00FF;
    paramInt1 = i ^ k;
    i = j ^ k << 8;
    i = (i >>> 31 & 0x1 | i << 1) & 0xFFFFFFFF;
    j = (paramInt1 ^ i) & 0xAAAAAAAA;
    paramInt1 ^= j;
    i ^= j;
    j = (paramInt1 >>> 31 & 0x1 | paramInt1 << 1) & 0xFFFFFFFF;
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      k = paramInt1 * 4;
      int i2 = (i << 28 | i >>> 4) ^ paramArrayOfInt[(k + 0)];
      paramArrayOfByte1 = SP7;
      int m = paramArrayOfByte1[(i2 & 0x3F)];
      int[] arrayOfInt1 = SP5;
      int n = arrayOfInt1[(i2 >>> 8 & 0x3F)];
      int[] arrayOfInt2 = SP3;
      int i1 = arrayOfInt2[(i2 >>> 16 & 0x3F)];
      int[] arrayOfInt3 = SP1;
      i2 = arrayOfInt3[(i2 >>> 24 & 0x3F)];
      int i3 = paramArrayOfInt[(k + 1)] ^ i;
      int[] arrayOfInt4 = SP8;
      int i4 = arrayOfInt4[(i3 & 0x3F)];
      int[] arrayOfInt5 = SP6;
      int i5 = arrayOfInt5[(i3 >>> 8 & 0x3F)];
      int[] arrayOfInt6 = SP4;
      int i6 = arrayOfInt6[(i3 >>> 16 & 0x3F)];
      int[] arrayOfInt7 = SP2;
      j ^= (i2 | m | n | i1 | i4 | i5 | i6 | arrayOfInt7[(i3 >>> 24 & 0x3F)]);
      i2 = (j << 28 | j >>> 4) ^ paramArrayOfInt[(k + 2)];
      m = paramArrayOfByte1[(i2 & 0x3F)];
      n = arrayOfInt1[(i2 >>> 8 & 0x3F)];
      i1 = arrayOfInt2[(i2 >>> 16 & 0x3F)];
      i2 = arrayOfInt3[(i2 >>> 24 & 0x3F)];
      k = paramArrayOfInt[(k + 3)] ^ j;
      i ^= (i2 | m | n | i1 | arrayOfInt4[(k & 0x3F)] | arrayOfInt5[(k >>> 8 & 0x3F)] | arrayOfInt6[(k >>> 16 & 0x3F)] | arrayOfInt7[(k >>> 24 & 0x3F)]);
      paramInt1 += 1;
    }
    paramInt1 = i >>> 1 | i << 31;
    i = (j ^ paramInt1) & 0xAAAAAAAA;
    j ^= i;
    paramInt1 ^= i;
    i = j >>> 1 | j << 31;
    j = (i >>> 8 ^ paramInt1) & 0xFF00FF;
    paramInt1 ^= j;
    i ^= j << 8;
    j = (i >>> 2 ^ paramInt1) & 0x33333333;
    paramInt1 ^= j;
    i ^= j << 2;
    j = (paramInt1 >>> 16 ^ i) & 0xFFFF;
    i ^= j;
    paramInt1 ^= j << 16;
    j = (paramInt1 >>> 4 ^ i) & 0xF0F0F0F;
    i ^= j;
    paramInt1 ^= j << 4;
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)(paramInt1 >>> 24 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 16 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)(paramInt1 >>> 8 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)(i >>> 24 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)(i >>> 16 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte2[(paramInt2 + 7)] = ((byte)(i & 0xFF));
  }
  
  protected int[] generateWorkingKey(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[32];
    boolean[] arrayOfBoolean1 = new boolean[56];
    boolean[] arrayOfBoolean2 = new boolean[56];
    int n = 0;
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      int i2 = 1;
      if (i >= 56) {
        break;
      }
      j = pc1[i];
      k = paramArrayOfByte[(j >>> 3)];
      if ((bytebit[(j & 0x7)] & k) == 0) {
        i2 = 0;
      }
      arrayOfBoolean1[i] = i2;
      i += 1;
    }
    i = 0;
    int m;
    for (;;)
    {
      j = n;
      if (i >= 16) {
        break;
      }
      if (paramBoolean) {
        j = i << 1;
      } else {
        j = 15 - i << 1;
      }
      int i1 = j + 1;
      arrayOfInt[i1] = 0;
      arrayOfInt[j] = 0;
      k = 0;
      for (;;)
      {
        m = 28;
        if (k >= 28) {
          break;
        }
        m = totrot[i] + k;
        if (m < 28) {
          arrayOfBoolean2[k] = arrayOfBoolean1[m];
        } else {
          arrayOfBoolean2[k] = arrayOfBoolean1[(m - 28)];
        }
        k += 1;
      }
      while (m < 56)
      {
        k = totrot[i] + m;
        if (k < 56) {
          arrayOfBoolean2[m] = arrayOfBoolean1[k];
        } else {
          arrayOfBoolean2[m] = arrayOfBoolean1[(k - 28)];
        }
        m += 1;
      }
      k = 0;
      while (k < 24)
      {
        if (arrayOfBoolean2[pc2[k]] != 0) {
          arrayOfInt[j] |= bigbyte[k];
        }
        if (arrayOfBoolean2[pc2[(k + 24)]] != 0) {
          arrayOfInt[i1] |= bigbyte[k];
        }
        k += 1;
      }
      i += 1;
    }
    while (j != 32)
    {
      i = arrayOfInt[j];
      k = j + 1;
      m = arrayOfInt[k];
      arrayOfInt[j] = ((0xFC0000 & m) >>> 10 | (i & 0xFC0000) << 6 | (i & 0xFC0) << 10 | (m & 0xFC0) >>> 6);
      arrayOfInt[k] = ((i & 0x3F) << 16 | (i & 0x3F000) << 12 | (0x3F000 & m) >>> 4 | m & 0x3F);
      j += 2;
    }
    return arrayOfInt;
  }
  
  public String getAlgorithmName()
  {
    return "DES";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = (KeyParameter)paramCipherParameters;
      if (paramCipherParameters.getKey().length <= 8)
      {
        this.workingKey = generateWorkingKey(paramBoolean, paramCipherParameters.getKey());
        return;
      }
      throw new IllegalArgumentException("DES key too long - should be 8 bytes");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to DES init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = this.workingKey;
    if (arrayOfInt != null)
    {
      if (paramInt1 + 8 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 8 <= paramArrayOfByte2.length)
        {
          desFunc(arrayOfInt, paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          return 8;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("DES engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\DESEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */