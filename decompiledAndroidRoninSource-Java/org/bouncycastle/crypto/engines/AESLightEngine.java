package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class AESLightEngine
  implements BlockCipher
{
  private static final int BLOCK_SIZE = 16;
  private static final byte[] S = { 99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22 };
  private static final byte[] Si = { 82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, -128, -20, 95, 96, 81, 127, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125 };
  private static final int m1 = -2139062144;
  private static final int m2 = 2139062143;
  private static final int m3 = 27;
  private static final int m4 = -1061109568;
  private static final int m5 = 1061109567;
  private static final int[] rcon = { 1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145 };
  private int C0;
  private int C1;
  private int C2;
  private int C3;
  private int ROUNDS;
  private int[][] WorkingKey = (int[][])null;
  private boolean forEncryption;
  
  private static int FFmulX(int paramInt)
  {
    return ((paramInt & 0x80808080) >>> 7) * 27 ^ (0x7F7F7F7F & paramInt) << 1;
  }
  
  private static int FFmulX2(int paramInt)
  {
    int i = paramInt & 0xC0C0C0C0;
    i ^= i >>> 1;
    return i >>> 5 ^ (0x3F3F3F3F & paramInt) << 2 ^ i >>> 2;
  }
  
  private void decryptBlock(int[][] paramArrayOfInt)
  {
    int i = this.C0;
    int n = this.ROUNDS;
    int j = i ^ paramArrayOfInt[n][0];
    int k = this.C1 ^ paramArrayOfInt[n][1];
    int m = this.C2 ^ paramArrayOfInt[n][2];
    i = n - 1;
    int i1 = this.C3;
    n = paramArrayOfInt[n][3] ^ i1;
    for (;;)
    {
      arrayOfByte = Si;
      i1 = j & 0xFF;
      if (i <= 1) {
        break;
      }
      i1 = arrayOfByte[i1];
      i2 = arrayOfByte[(n >> 8 & 0xFF)];
      i3 = arrayOfByte[(m >> 16 & 0xFF)];
      i1 = inv_mcol(arrayOfByte[(k >> 24 & 0xFF)] << 24 ^ i1 & 0xFF ^ (i2 & 0xFF) << 8 ^ (i3 & 0xFF) << 16) ^ paramArrayOfInt[i][0];
      arrayOfByte = Si;
      i2 = arrayOfByte[(k & 0xFF)];
      i3 = arrayOfByte[(j >> 8 & 0xFF)];
      i4 = arrayOfByte[(n >> 16 & 0xFF)];
      i2 = inv_mcol(arrayOfByte[(m >> 24 & 0xFF)] << 24 ^ i2 & 0xFF ^ (i3 & 0xFF) << 8 ^ (i4 & 0xFF) << 16) ^ paramArrayOfInt[i][1];
      arrayOfByte = Si;
      i3 = arrayOfByte[(m & 0xFF)];
      i4 = arrayOfByte[(k >> 8 & 0xFF)];
      i5 = arrayOfByte[(j >> 16 & 0xFF)];
      i3 = inv_mcol(arrayOfByte[(n >> 24 & 0xFF)] << 24 ^ i3 & 0xFF ^ (i4 & 0xFF) << 8 ^ (i5 & 0xFF) << 16) ^ paramArrayOfInt[i][2];
      arrayOfByte = Si;
      n = arrayOfByte[(n & 0xFF)];
      m = arrayOfByte[(m >> 8 & 0xFF)];
      k = arrayOfByte[(k >> 16 & 0xFF)];
      j = inv_mcol(arrayOfByte[(j >> 24 & 0xFF)] << 24 ^ n & 0xFF ^ (m & 0xFF) << 8 ^ (k & 0xFF) << 16);
      i4 = i - 1;
      i = j ^ paramArrayOfInt[i][3];
      arrayOfByte = Si;
      j = arrayOfByte[(i1 & 0xFF)];
      k = arrayOfByte[(i >> 8 & 0xFF)];
      m = arrayOfByte[(i3 >> 16 & 0xFF)];
      j = inv_mcol(arrayOfByte[(i2 >> 24 & 0xFF)] << 24 ^ j & 0xFF ^ (k & 0xFF) << 8 ^ (m & 0xFF) << 16);
      k = paramArrayOfInt[i4][0];
      arrayOfByte = Si;
      m = arrayOfByte[(i2 & 0xFF)];
      n = arrayOfByte[(i1 >> 8 & 0xFF)];
      i5 = arrayOfByte[(i >> 16 & 0xFF)];
      m = inv_mcol(arrayOfByte[(i3 >> 24 & 0xFF)] << 24 ^ m & 0xFF ^ (n & 0xFF) << 8 ^ (i5 & 0xFF) << 16);
      i5 = paramArrayOfInt[i4][1];
      arrayOfByte = Si;
      n = arrayOfByte[(i3 & 0xFF)];
      int i6 = arrayOfByte[(i2 >> 8 & 0xFF)];
      int i7 = arrayOfByte[(i1 >> 16 & 0xFF)];
      i6 = inv_mcol(arrayOfByte[(i >> 24 & 0xFF)] << 24 ^ n & 0xFF ^ (i6 & 0xFF) << 8 ^ (i7 & 0xFF) << 16);
      i7 = paramArrayOfInt[i4][2];
      arrayOfByte = Si;
      i = inv_mcol(arrayOfByte[(i & 0xFF)] & 0xFF ^ (arrayOfByte[(i3 >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i2 >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i1 >> 24 & 0xFF)] << 24);
      n = paramArrayOfInt[i4][3] ^ i;
      j ^= k;
      k = m ^ i5;
      m = i6 ^ i7;
      i = i4 - 1;
    }
    i1 = arrayOfByte[i1];
    int i2 = arrayOfByte[(n >> 8 & 0xFF)];
    int i3 = arrayOfByte[(m >> 16 & 0xFF)];
    i1 = inv_mcol(arrayOfByte[(k >> 24 & 0xFF)] << 24 ^ i1 & 0xFF ^ (i2 & 0xFF) << 8 ^ (i3 & 0xFF) << 16) ^ paramArrayOfInt[i][0];
    byte[] arrayOfByte = Si;
    i2 = arrayOfByte[(k & 0xFF)];
    i3 = arrayOfByte[(j >> 8 & 0xFF)];
    int i4 = arrayOfByte[(n >> 16 & 0xFF)];
    i2 = inv_mcol(arrayOfByte[(m >> 24 & 0xFF)] << 24 ^ i2 & 0xFF ^ (i3 & 0xFF) << 8 ^ (i4 & 0xFF) << 16) ^ paramArrayOfInt[i][1];
    arrayOfByte = Si;
    i3 = arrayOfByte[(m & 0xFF)];
    i4 = arrayOfByte[(k >> 8 & 0xFF)];
    int i5 = arrayOfByte[(j >> 16 & 0xFF)];
    i3 = inv_mcol(arrayOfByte[(n >> 24 & 0xFF)] << 24 ^ i3 & 0xFF ^ (i4 & 0xFF) << 8 ^ (i5 & 0xFF) << 16) ^ paramArrayOfInt[i][2];
    arrayOfByte = Si;
    n = arrayOfByte[(n & 0xFF)];
    m = arrayOfByte[(m >> 8 & 0xFF)];
    k = arrayOfByte[(k >> 16 & 0xFF)];
    i = inv_mcol(arrayOfByte[(j >> 24 & 0xFF)] << 24 ^ n & 0xFF ^ (m & 0xFF) << 8 ^ (k & 0xFF) << 16) ^ paramArrayOfInt[i][3];
    arrayOfByte = Si;
    this.C0 = (arrayOfByte[(i1 & 0xFF)] & 0xFF ^ (arrayOfByte[(i >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i3 >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i2 >> 24 & 0xFF)] << 24 ^ paramArrayOfInt[0][0]);
    this.C1 = (arrayOfByte[(i2 & 0xFF)] & 0xFF ^ (arrayOfByte[(i1 >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i3 >> 24 & 0xFF)] << 24 ^ paramArrayOfInt[0][1]);
    this.C2 = (arrayOfByte[(i3 & 0xFF)] & 0xFF ^ (arrayOfByte[(i2 >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i1 >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i >> 24 & 0xFF)] << 24 ^ paramArrayOfInt[0][2]);
    i = arrayOfByte[(i & 0xFF)];
    j = arrayOfByte[(i3 >> 8 & 0xFF)];
    k = arrayOfByte[(i2 >> 16 & 0xFF)];
    m = arrayOfByte[(i1 >> 24 & 0xFF)];
    this.C3 = (paramArrayOfInt[0][3] ^ i & 0xFF ^ (j & 0xFF) << 8 ^ (k & 0xFF) << 16 ^ m << 24);
  }
  
  private void encryptBlock(int[][] paramArrayOfInt)
  {
    int j = this.C0 ^ paramArrayOfInt[0][0];
    int k = this.C1 ^ paramArrayOfInt[0][1];
    int m = this.C2 ^ paramArrayOfInt[0][2];
    int n = this.C3 ^ paramArrayOfInt[0][3];
    for (int i = 1; i < this.ROUNDS - 1; i = i3 + 1)
    {
      arrayOfByte = S;
      i1 = arrayOfByte[(j & 0xFF)];
      i2 = arrayOfByte[(k >> 8 & 0xFF)];
      i3 = arrayOfByte[(m >> 16 & 0xFF)];
      i1 = mcol(arrayOfByte[(n >> 24 & 0xFF)] << 24 ^ i1 & 0xFF ^ (i2 & 0xFF) << 8 ^ (i3 & 0xFF) << 16) ^ paramArrayOfInt[i][0];
      arrayOfByte = S;
      i2 = arrayOfByte[(k & 0xFF)];
      i3 = arrayOfByte[(m >> 8 & 0xFF)];
      i4 = arrayOfByte[(n >> 16 & 0xFF)];
      i2 = mcol(arrayOfByte[(j >> 24 & 0xFF)] << 24 ^ i2 & 0xFF ^ (i3 & 0xFF) << 8 ^ (i4 & 0xFF) << 16) ^ paramArrayOfInt[i][1];
      arrayOfByte = S;
      i3 = arrayOfByte[(m & 0xFF)];
      i4 = arrayOfByte[(n >> 8 & 0xFF)];
      i5 = arrayOfByte[(j >> 16 & 0xFF)];
      i4 = mcol(arrayOfByte[(k >> 24 & 0xFF)] << 24 ^ i3 & 0xFF ^ (i4 & 0xFF) << 8 ^ (i5 & 0xFF) << 16) ^ paramArrayOfInt[i][2];
      arrayOfByte = S;
      n = arrayOfByte[(n & 0xFF)];
      j = mcol((arrayOfByte[(j >> 8 & 0xFF)] & 0xFF) << 8 ^ n & 0xFF ^ (arrayOfByte[(k >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(m >> 24 & 0xFF)] << 24);
      i3 = i + 1;
      k = j ^ paramArrayOfInt[i][3];
      arrayOfByte = S;
      i = arrayOfByte[(i1 & 0xFF)];
      j = arrayOfByte[(i2 >> 8 & 0xFF)];
      m = arrayOfByte[(i4 >> 16 & 0xFF)];
      i = mcol(arrayOfByte[(k >> 24 & 0xFF)] << 24 ^ i & 0xFF ^ (j & 0xFF) << 8 ^ (m & 0xFF) << 16);
      j = paramArrayOfInt[i3][0];
      arrayOfByte = S;
      m = arrayOfByte[(i2 & 0xFF)];
      n = arrayOfByte[(i4 >> 8 & 0xFF)];
      i5 = arrayOfByte[(k >> 16 & 0xFF)];
      m = mcol(arrayOfByte[(i1 >> 24 & 0xFF)] << 24 ^ m & 0xFF ^ (n & 0xFF) << 8 ^ (i5 & 0xFF) << 16);
      n = paramArrayOfInt[i3][1];
      arrayOfByte = S;
      i5 = arrayOfByte[(i4 & 0xFF)];
      int i6 = arrayOfByte[(k >> 8 & 0xFF)];
      int i7 = arrayOfByte[(i1 >> 16 & 0xFF)];
      i5 = mcol(arrayOfByte[(i2 >> 24 & 0xFF)] << 24 ^ i5 & 0xFF ^ (i6 & 0xFF) << 8 ^ (i7 & 0xFF) << 16);
      i6 = paramArrayOfInt[i3][2];
      arrayOfByte = S;
      i1 = mcol(arrayOfByte[(k & 0xFF)] & 0xFF ^ (arrayOfByte[(i1 >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i2 >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i4 >> 24 & 0xFF)] << 24);
      i2 = paramArrayOfInt[i3][3];
      k = m ^ n;
      n = i1 ^ i2;
      j = i ^ j;
      m = i5 ^ i6;
    }
    byte[] arrayOfByte = S;
    int i1 = arrayOfByte[(j & 0xFF)];
    int i2 = arrayOfByte[(k >> 8 & 0xFF)];
    int i3 = arrayOfByte[(m >> 16 & 0xFF)];
    i1 = mcol(arrayOfByte[(n >> 24 & 0xFF)] << 24 ^ i1 & 0xFF ^ (i2 & 0xFF) << 8 ^ (i3 & 0xFF) << 16) ^ paramArrayOfInt[i][0];
    arrayOfByte = S;
    i2 = arrayOfByte[(k & 0xFF)];
    i3 = arrayOfByte[(m >> 8 & 0xFF)];
    int i4 = arrayOfByte[(n >> 16 & 0xFF)];
    i2 = mcol(arrayOfByte[(j >> 24 & 0xFF)] << 24 ^ i2 & 0xFF ^ (i3 & 0xFF) << 8 ^ (i4 & 0xFF) << 16) ^ paramArrayOfInt[i][1];
    arrayOfByte = S;
    i3 = arrayOfByte[(m & 0xFF)];
    i4 = arrayOfByte[(n >> 8 & 0xFF)];
    int i5 = arrayOfByte[(j >> 16 & 0xFF)];
    i3 = mcol(arrayOfByte[(k >> 24 & 0xFF)] << 24 ^ i3 & 0xFF ^ (i4 & 0xFF) << 8 ^ (i5 & 0xFF) << 16) ^ paramArrayOfInt[i][2];
    arrayOfByte = S;
    n = arrayOfByte[(n & 0xFF)];
    k = mcol((arrayOfByte[(j >> 8 & 0xFF)] & 0xFF) << 8 ^ n & 0xFF ^ (arrayOfByte[(k >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(m >> 24 & 0xFF)] << 24);
    j = i + 1;
    i = k ^ paramArrayOfInt[i][3];
    arrayOfByte = S;
    k = arrayOfByte[(i1 & 0xFF)];
    m = arrayOfByte[(i2 >> 8 & 0xFF)];
    n = arrayOfByte[(i3 >> 16 & 0xFF)];
    i4 = arrayOfByte[(i >> 24 & 0xFF)];
    this.C0 = (paramArrayOfInt[j][0] ^ k & 0xFF ^ (m & 0xFF) << 8 ^ (n & 0xFF) << 16 ^ i4 << 24);
    this.C1 = (arrayOfByte[(i2 & 0xFF)] & 0xFF ^ (arrayOfByte[(i3 >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i1 >> 24 & 0xFF)] << 24 ^ paramArrayOfInt[j][1]);
    this.C2 = (arrayOfByte[(i3 & 0xFF)] & 0xFF ^ (arrayOfByte[(i >> 8 & 0xFF)] & 0xFF) << 8 ^ (arrayOfByte[(i1 >> 16 & 0xFF)] & 0xFF) << 16 ^ arrayOfByte[(i2 >> 24 & 0xFF)] << 24 ^ paramArrayOfInt[j][2]);
    i = arrayOfByte[(i & 0xFF)];
    k = arrayOfByte[(i1 >> 8 & 0xFF)];
    m = arrayOfByte[(i2 >> 16 & 0xFF)];
    n = arrayOfByte[(i3 >> 24 & 0xFF)];
    this.C3 = (paramArrayOfInt[j][3] ^ i & 0xFF ^ (k & 0xFF) << 8 ^ (m & 0xFF) << 16 ^ n << 24);
  }
  
  private int[][] generateWorkingKey(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length;
    if ((i >= 16) && (i <= 32) && ((i & 0x7) == 0))
    {
      i >>= 2;
      int j = i + 6;
      this.ROUNDS = j;
      int i6 = 1;
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { j + 1, 4 });
      int m;
      int n;
      int k;
      if (i != 4)
      {
        int i5;
        int i2;
        int i1;
        int i4;
        int i3;
        int i7;
        if (i != 6)
        {
          if (i == 8)
          {
            i5 = Pack.littleEndianToInt(paramArrayOfByte, 0);
            arrayOfInt[0][0] = i5;
            i2 = Pack.littleEndianToInt(paramArrayOfByte, 4);
            arrayOfInt[0][1] = i2;
            i1 = Pack.littleEndianToInt(paramArrayOfByte, 8);
            arrayOfInt[0][2] = i1;
            m = Pack.littleEndianToInt(paramArrayOfByte, 12);
            arrayOfInt[0][3] = m;
            i4 = Pack.littleEndianToInt(paramArrayOfByte, 16);
            arrayOfInt[1][0] = i4;
            n = Pack.littleEndianToInt(paramArrayOfByte, 20);
            arrayOfInt[1][1] = n;
            j = Pack.littleEndianToInt(paramArrayOfByte, 24);
            arrayOfInt[1][2] = j;
            i3 = Pack.littleEndianToInt(paramArrayOfByte, 28);
            arrayOfInt[1][3] = i3;
            k = 2;
            i = 1;
            for (;;)
            {
              i7 = i;
              if (k >= 14) {
                break;
              }
              int i8 = subWord(shift(i3, 8));
              i = i7 << 1;
              i5 ^= i8 ^ i7;
              arrayOfInt[k][0] = i5;
              i2 ^= i5;
              arrayOfInt[k][1] = i2;
              i1 ^= i2;
              arrayOfInt[k][2] = i1;
              m ^= i1;
              arrayOfInt[k][3] = m;
              i4 ^= subWord(m);
              i7 = k + 1;
              arrayOfInt[i7][0] = i4;
              n ^= i4;
              arrayOfInt[i7][1] = n;
              j ^= n;
              arrayOfInt[i7][2] = j;
              i3 ^= j;
              arrayOfInt[i7][3] = i3;
              k += 2;
            }
            i = subWord(shift(i3, 8)) ^ i7 ^ i5;
            arrayOfInt[14][0] = i;
            i ^= i2;
            arrayOfInt[14][1] = i;
            i ^= i1;
            arrayOfInt[14][2] = i;
            arrayOfInt[14][3] = (i ^ m);
          }
          else
          {
            throw new IllegalStateException("Should never get here");
          }
        }
        else
        {
          i1 = Pack.littleEndianToInt(paramArrayOfByte, 0);
          arrayOfInt[0][0] = i1;
          n = Pack.littleEndianToInt(paramArrayOfByte, 4);
          arrayOfInt[0][1] = n;
          m = Pack.littleEndianToInt(paramArrayOfByte, 8);
          arrayOfInt[0][2] = m;
          k = Pack.littleEndianToInt(paramArrayOfByte, 12);
          arrayOfInt[0][3] = k;
          j = Pack.littleEndianToInt(paramArrayOfByte, 16);
          arrayOfInt[1][0] = j;
          i = Pack.littleEndianToInt(paramArrayOfByte, 20);
          arrayOfInt[1][1] = i;
          i2 = i1 ^ subWord(shift(i, 8)) ^ 0x1;
          arrayOfInt[1][2] = i2;
          i1 = n ^ i2;
          arrayOfInt[1][3] = i1;
          n = m ^ i1;
          arrayOfInt[2][0] = n;
          k ^= n;
          arrayOfInt[2][1] = k;
          m = j ^ k;
          arrayOfInt[2][2] = m;
          j = i ^ m;
          arrayOfInt[2][3] = j;
          i = 3;
          i3 = 2;
          while (i < 12)
          {
            i5 = subWord(shift(j, 8));
            i4 = i3 << 1;
            i2 ^= i5 ^ i3;
            arrayOfInt[i][0] = i2;
            i1 ^= i2;
            arrayOfInt[i][1] = i1;
            n ^= i1;
            arrayOfInt[i][2] = n;
            k ^= n;
            arrayOfInt[i][3] = k;
            m ^= k;
            i5 = i + 1;
            arrayOfInt[i5][0] = m;
            j ^= m;
            arrayOfInt[i5][1] = j;
            i7 = subWord(shift(j, 8));
            i3 = i4 << 1;
            i2 ^= i7 ^ i4;
            arrayOfInt[i5][2] = i2;
            i1 ^= i2;
            arrayOfInt[i5][3] = i1;
            n ^= i1;
            i4 = i + 2;
            arrayOfInt[i4][0] = n;
            k ^= n;
            arrayOfInt[i4][1] = k;
            m ^= k;
            arrayOfInt[i4][2] = m;
            j ^= m;
            arrayOfInt[i4][3] = j;
            i += 3;
          }
          i = subWord(shift(j, 8)) ^ i3 ^ i2;
          arrayOfInt[12][0] = i;
          i ^= i1;
          arrayOfInt[12][1] = i;
          i ^= n;
          arrayOfInt[12][2] = i;
          arrayOfInt[12][3] = (i ^ k);
        }
      }
      else
      {
        n = Pack.littleEndianToInt(paramArrayOfByte, 0);
        arrayOfInt[0][0] = n;
        k = Pack.littleEndianToInt(paramArrayOfByte, 4);
        arrayOfInt[0][1] = k;
        j = Pack.littleEndianToInt(paramArrayOfByte, 8);
        arrayOfInt[0][2] = j;
        m = Pack.littleEndianToInt(paramArrayOfByte, 12);
        arrayOfInt[0][3] = m;
        i = 1;
        while (i <= 10)
        {
          n ^= subWord(shift(m, 8)) ^ rcon[(i - 1)];
          arrayOfInt[i][0] = n;
          k ^= n;
          arrayOfInt[i][1] = k;
          j ^= k;
          arrayOfInt[i][2] = j;
          m ^= j;
          arrayOfInt[i][3] = m;
          i += 1;
        }
      }
      if (!paramBoolean)
      {
        i = i6;
        while (i < this.ROUNDS)
        {
          j = 0;
          while (j < 4)
          {
            arrayOfInt[i][j] = inv_mcol(arrayOfInt[i][j]);
            j += 1;
          }
          i += 1;
        }
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException("Key length not 128/192/256 bits.");
  }
  
  private static int inv_mcol(int paramInt)
  {
    int i = shift(paramInt, 8) ^ paramInt;
    paramInt ^= FFmulX(i);
    i ^= FFmulX2(paramInt);
    return paramInt ^ i ^ shift(i, 16);
  }
  
  private static int mcol(int paramInt)
  {
    int i = shift(paramInt, 8);
    paramInt ^= i;
    int j = shift(paramInt, 16);
    return FFmulX(paramInt) ^ i ^ j;
  }
  
  private void packBlock(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    int i = this.C0;
    paramArrayOfByte[paramInt] = ((byte)i);
    paramInt = j + 1;
    paramArrayOfByte[j] = ((byte)(i >> 8));
    int k = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(i >> 16));
    j = k + 1;
    paramArrayOfByte[k] = ((byte)(i >> 24));
    i = j + 1;
    paramInt = this.C1;
    paramArrayOfByte[j] = ((byte)paramInt);
    j = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt >> 8));
    k = j + 1;
    paramArrayOfByte[j] = ((byte)(paramInt >> 16));
    i = k + 1;
    paramArrayOfByte[k] = ((byte)(paramInt >> 24));
    j = i + 1;
    paramInt = this.C2;
    paramArrayOfByte[i] = ((byte)paramInt);
    i = j + 1;
    paramArrayOfByte[j] = ((byte)(paramInt >> 8));
    j = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt >> 16));
    i = j + 1;
    paramArrayOfByte[j] = ((byte)(paramInt >> 24));
    paramInt = i + 1;
    j = this.C3;
    paramArrayOfByte[i] = ((byte)j);
    i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(j >> 8));
    paramArrayOfByte[i] = ((byte)(j >> 16));
    paramArrayOfByte[(i + 1)] = ((byte)(j >> 24));
  }
  
  private static int shift(int paramInt1, int paramInt2)
  {
    return paramInt1 << -paramInt2 | paramInt1 >>> paramInt2;
  }
  
  private static int subWord(int paramInt)
  {
    byte[] arrayOfByte = S;
    int i = arrayOfByte[(paramInt & 0xFF)];
    int j = arrayOfByte[(paramInt >> 8 & 0xFF)];
    int k = arrayOfByte[(paramInt >> 16 & 0xFF)];
    return arrayOfByte[(paramInt >> 24 & 0xFF)] << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  private void unpackBlock(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramArrayOfByte[paramInt] & 0xFF;
    this.C0 = j;
    paramInt = i + 1;
    j |= (paramArrayOfByte[i] & 0xFF) << 8;
    this.C0 = j;
    i = paramInt + 1;
    j |= (paramArrayOfByte[paramInt] & 0xFF) << 16;
    this.C0 = j;
    paramInt = i + 1;
    this.C0 = (j | paramArrayOfByte[i] << 24);
    i = paramInt + 1;
    j = paramArrayOfByte[paramInt] & 0xFF;
    this.C1 = j;
    paramInt = i + 1;
    j = (paramArrayOfByte[i] & 0xFF) << 8 | j;
    this.C1 = j;
    i = paramInt + 1;
    j |= (paramArrayOfByte[paramInt] & 0xFF) << 16;
    this.C1 = j;
    paramInt = i + 1;
    this.C1 = (j | paramArrayOfByte[i] << 24);
    i = paramInt + 1;
    j = paramArrayOfByte[paramInt] & 0xFF;
    this.C2 = j;
    paramInt = i + 1;
    j = (paramArrayOfByte[i] & 0xFF) << 8 | j;
    this.C2 = j;
    i = paramInt + 1;
    j |= (paramArrayOfByte[paramInt] & 0xFF) << 16;
    this.C2 = j;
    paramInt = i + 1;
    this.C2 = (j | paramArrayOfByte[i] << 24);
    i = paramInt + 1;
    j = paramArrayOfByte[paramInt] & 0xFF;
    this.C3 = j;
    paramInt = i + 1;
    i = (paramArrayOfByte[i] & 0xFF) << 8 | j;
    this.C3 = i;
    i |= (paramArrayOfByte[paramInt] & 0xFF) << 16;
    this.C3 = i;
    this.C3 = (paramArrayOfByte[(paramInt + 1)] << 24 | i);
  }
  
  public String getAlgorithmName()
  {
    return "AES";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.WorkingKey = generateWorkingKey(((KeyParameter)paramCipherParameters).getKey(), paramBoolean);
      this.forEncryption = paramBoolean;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to AES init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.WorkingKey != null)
    {
      if (paramInt1 + 16 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 16 <= paramArrayOfByte2.length)
        {
          boolean bool = this.forEncryption;
          unpackBlock(paramArrayOfByte1, paramInt1);
          paramArrayOfByte1 = this.WorkingKey;
          if (bool) {
            encryptBlock(paramArrayOfByte1);
          } else {
            decryptBlock(paramArrayOfByte1);
          }
          packBlock(paramArrayOfByte2, paramInt2);
          return 16;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("AES engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\AESLightEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */