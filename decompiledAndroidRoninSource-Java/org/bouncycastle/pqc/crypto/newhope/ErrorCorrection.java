package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.util.Arrays;

class ErrorCorrection
{
  static short LDDecode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (short)(g(paramInt1) + g(paramInt2) + g(paramInt3) + g(paramInt4) - 98312 >>> 31);
  }
  
  static int abs(int paramInt)
  {
    int i = paramInt >> 31;
    return (paramInt ^ i) - i;
  }
  
  static int f(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 * 2730 >> 25;
    i -= (12288 - (paramInt3 - i * 12289) >> 31);
    paramArrayOfInt[paramInt1] = ((i >> 1) + (i & 0x1));
    i -= 1;
    paramArrayOfInt[paramInt2] = ((i >> 1) + (i & 0x1));
    return abs(paramInt3 - paramArrayOfInt[paramInt1] * 2 * 12289);
  }
  
  static int g(int paramInt)
  {
    int i = paramInt * 2730 >> 27;
    i -= (49155 - (paramInt - 49156 * i) >> 31);
    return abs(((i >> 1) + (i & 0x1)) * 98312 - paramInt);
  }
  
  static void helpRec(short[] paramArrayOfShort1, short[] paramArrayOfShort2, byte[] paramArrayOfByte, byte paramByte)
  {
    Object localObject = new byte[8];
    localObject[0] = paramByte;
    byte[] arrayOfByte = new byte[32];
    ChaCha20.process(paramArrayOfByte, (byte[])localObject, arrayOfByte, 0, 32);
    paramArrayOfByte = new int[8];
    localObject = new int[4];
    int i = 0;
    while (i < 256)
    {
      int m = arrayOfByte[(i >>> 3)];
      int j = i + 0;
      int k = paramArrayOfShort2[j];
      int i1 = (m >>> (i & 0x7) & 0x1) * 4;
      int i2 = f(paramArrayOfByte, 0, 4, k * 8 + i1);
      k = i + 256;
      int i3 = f(paramArrayOfByte, 1, 5, paramArrayOfShort2[k] * 8 + i1);
      m = i + 512;
      int i4 = f(paramArrayOfByte, 2, 6, paramArrayOfShort2[m] * 8 + i1);
      int n = i + 768;
      i1 = 24577 - (i2 + i3 + i4 + f(paramArrayOfByte, 3, 7, paramArrayOfShort2[n] * 8 + i1)) >> 31;
      i2 = i1;
      localObject[0] = (i2 & paramArrayOfByte[0] ^ i1 & paramArrayOfByte[4]);
      localObject[1] = (i2 & paramArrayOfByte[1] ^ i1 & paramArrayOfByte[5]);
      localObject[2] = (i2 & paramArrayOfByte[2] ^ i1 & paramArrayOfByte[6]);
      i3 = paramArrayOfByte[3];
      localObject[3] = (paramArrayOfByte[7] & i1 ^ i2 & i3);
      paramArrayOfShort1[j] = ((short)(localObject[0] - localObject[3] & 0x3));
      paramArrayOfShort1[k] = ((short)(localObject[1] - localObject[3] & 0x3));
      paramArrayOfShort1[m] = ((short)(localObject[2] - localObject[3] & 0x3));
      paramArrayOfShort1[n] = ((short)(-i1 + localObject[3] * 2 & 0x3));
      i += 1;
    }
  }
  
  static void rec(byte[] paramArrayOfByte, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    Arrays.fill(paramArrayOfByte, (byte)0);
    int[] arrayOfInt = new int[4];
    int i = 0;
    while (i < 256)
    {
      int j = i + 0;
      int k = paramArrayOfShort1[j];
      int m = paramArrayOfShort2[j];
      j = i + 768;
      arrayOfInt[0] = (k * 8 + 196624 - (m * 2 + paramArrayOfShort2[j]) * 12289);
      k = i + 256;
      arrayOfInt[1] = (paramArrayOfShort1[k] * 8 + 196624 - (paramArrayOfShort2[k] * 2 + paramArrayOfShort2[j]) * 12289);
      k = i + 512;
      arrayOfInt[2] = (paramArrayOfShort1[k] * 8 + 196624 - (paramArrayOfShort2[k] * 2 + paramArrayOfShort2[j]) * 12289);
      arrayOfInt[3] = (paramArrayOfShort1[j] * 8 + 196624 - paramArrayOfShort2[j] * 12289);
      j = i >>> 3;
      k = paramArrayOfByte[j];
      paramArrayOfByte[j] = ((byte)(LDDecode(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]) << (i & 0x7) | k));
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\ErrorCorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */