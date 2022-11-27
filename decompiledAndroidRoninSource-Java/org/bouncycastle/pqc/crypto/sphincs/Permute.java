package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Pack;

class Permute
{
  private static final int CHACHA_ROUNDS = 12;
  
  public static void permute(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 16)
    {
      if (paramInt % 2 == 0)
      {
        int i11 = paramArrayOfInt[0];
        int i7 = paramArrayOfInt[1];
        int i3 = paramArrayOfInt[2];
        int m = paramArrayOfInt[3];
        int i8 = paramArrayOfInt[4];
        int i4 = paramArrayOfInt[5];
        int n = paramArrayOfInt[6];
        int i = paramArrayOfInt[7];
        int i9 = paramArrayOfInt[8];
        int i5 = paramArrayOfInt[9];
        int i1 = paramArrayOfInt[10];
        int j = paramArrayOfInt[11];
        int i10 = paramArrayOfInt[12];
        int i6 = paramArrayOfInt[13];
        int i2 = paramArrayOfInt[14];
        int k = paramArrayOfInt[15];
        while (paramInt > 0)
        {
          i11 += i8;
          i10 = rotl(i10 ^ i11, 16);
          i9 += i10;
          i8 = rotl(i8 ^ i9, 12);
          i11 += i8;
          i10 = rotl(i10 ^ i11, 8);
          i9 += i10;
          i8 = rotl(i8 ^ i9, 7);
          i7 += i4;
          i6 = rotl(i6 ^ i7, 16);
          i5 += i6;
          i4 = rotl(i4 ^ i5, 12);
          i7 += i4;
          i6 = rotl(i6 ^ i7, 8);
          i5 += i6;
          i4 = rotl(i4 ^ i5, 7);
          i3 += n;
          i2 = rotl(i2 ^ i3, 16);
          i1 += i2;
          n = rotl(n ^ i1, 12);
          i3 += n;
          i2 = rotl(i2 ^ i3, 8);
          i1 += i2;
          n = rotl(n ^ i1, 7);
          m += i;
          k = rotl(k ^ m, 16);
          j += k;
          i = rotl(i ^ j, 12);
          m += i;
          k = rotl(k ^ m, 8);
          j += k;
          i = rotl(i ^ j, 7);
          i11 += i4;
          k = rotl(k ^ i11, 16);
          i1 += k;
          i4 = rotl(i4 ^ i1, 12);
          i11 += i4;
          k = rotl(k ^ i11, 8);
          i1 += k;
          i4 = rotl(i4 ^ i1, 7);
          i7 += n;
          i10 = rotl(i10 ^ i7, 16);
          j += i10;
          n = rotl(n ^ j, 12);
          i7 += n;
          i10 = rotl(i10 ^ i7, 8);
          j += i10;
          n = rotl(n ^ j, 7);
          i3 += i;
          i6 = rotl(i6 ^ i3, 16);
          i9 += i6;
          i = rotl(i ^ i9, 12);
          i3 += i;
          i6 = rotl(i6 ^ i3, 8);
          i9 += i6;
          i = rotl(i ^ i9, 7);
          m += i8;
          i2 = rotl(i2 ^ m, 16);
          i5 += i2;
          i8 = rotl(i8 ^ i5, 12);
          m += i8;
          i2 = rotl(i2 ^ m, 8);
          i5 += i2;
          i8 = rotl(i8 ^ i5, 7);
          paramInt -= 2;
        }
        paramArrayOfInt[0] = i11;
        paramArrayOfInt[1] = i7;
        paramArrayOfInt[2] = i3;
        paramArrayOfInt[3] = m;
        paramArrayOfInt[4] = i8;
        paramArrayOfInt[5] = i4;
        paramArrayOfInt[6] = n;
        paramArrayOfInt[7] = i;
        paramArrayOfInt[8] = i9;
        paramArrayOfInt[9] = i5;
        paramArrayOfInt[10] = i1;
        paramArrayOfInt[11] = j;
        paramArrayOfInt[12] = i10;
        paramArrayOfInt[13] = i6;
        paramArrayOfInt[14] = i2;
        paramArrayOfInt[15] = k;
        return;
      }
      throw new IllegalArgumentException("Number of rounds must be even");
    }
    throw new IllegalArgumentException();
  }
  
  protected static int rotl(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  void chacha_permute(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt = new int[16];
    int j = 0;
    int i = 0;
    while (i < 16)
    {
      arrayOfInt[i] = Pack.littleEndianToInt(paramArrayOfByte2, i * 4);
      i += 1;
    }
    permute(12, arrayOfInt);
    i = j;
    while (i < 16)
    {
      Pack.intToLittleEndian(arrayOfInt[i], paramArrayOfByte1, i * 4);
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\Permute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */