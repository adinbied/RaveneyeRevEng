package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class SM4Engine
  implements BlockCipher
{
  private static final int BLOCK_SIZE = 16;
  private static final int[] CK = { 462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257 };
  private static final int[] FK = { -1548633402, 1453994832, 1736282519, -1301273892 };
  private static final byte[] Sbox = { -42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, -128, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, 127, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72 };
  private final int[] X = new int[4];
  private int[] rk;
  
  private int F0(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramArrayOfInt[2];
    return T(paramArrayOfInt[3] ^ j ^ k ^ paramInt) ^ i;
  }
  
  private int F1(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[1];
    int j = paramArrayOfInt[2];
    int k = paramArrayOfInt[3];
    return T(paramArrayOfInt[0] ^ j ^ k ^ paramInt) ^ i;
  }
  
  private int F2(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[2];
    int j = paramArrayOfInt[3];
    int k = paramArrayOfInt[0];
    return T(paramArrayOfInt[1] ^ j ^ k ^ paramInt) ^ i;
  }
  
  private int F3(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt[3];
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    return T(paramArrayOfInt[2] ^ j ^ k ^ paramInt) ^ i;
  }
  
  private int L(int paramInt)
  {
    int i = rotateLeft(paramInt, 2);
    int j = rotateLeft(paramInt, 10);
    int k = rotateLeft(paramInt, 18);
    return rotateLeft(paramInt, 24) ^ i ^ paramInt ^ j ^ k;
  }
  
  private int L_ap(int paramInt)
  {
    int i = rotateLeft(paramInt, 13);
    return rotateLeft(paramInt, 23) ^ i ^ paramInt;
  }
  
  private void R(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramInt + 2;
    int k = paramInt + 3;
    paramArrayOfInt[paramInt] ^= paramArrayOfInt[k];
    paramArrayOfInt[paramInt] ^= paramArrayOfInt[k];
    int m = paramArrayOfInt[paramInt];
    paramArrayOfInt[k] ^= m;
    paramArrayOfInt[i] ^= paramArrayOfInt[j];
    paramArrayOfInt[i] ^= paramArrayOfInt[j];
    paramArrayOfInt[i] ^= paramArrayOfInt[j];
  }
  
  private int T(int paramInt)
  {
    return L(tau(paramInt));
  }
  
  private int T_ap(int paramInt)
  {
    return L_ap(tau(paramInt));
  }
  
  private int[] expandKey(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt1 = new int[32];
    int i = 4;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = Pack.bigEndianToInt(paramArrayOfByte, 0);
    arrayOfInt2[1] = Pack.bigEndianToInt(paramArrayOfByte, 4);
    arrayOfInt2[2] = Pack.bigEndianToInt(paramArrayOfByte, 8);
    arrayOfInt2[3] = Pack.bigEndianToInt(paramArrayOfByte, 12);
    paramArrayOfByte = new int[4];
    int j = arrayOfInt2[0];
    int[] arrayOfInt3 = FK;
    paramArrayOfByte[0] = (j ^ arrayOfInt3[0]);
    arrayOfInt2[1] ^= arrayOfInt3[1];
    arrayOfInt2[2] ^= arrayOfInt3[2];
    arrayOfInt2[3] ^= arrayOfInt3[3];
    if (paramBoolean)
    {
      paramArrayOfByte[0] ^= T_ap(paramArrayOfByte[1] ^ paramArrayOfByte[2] ^ paramArrayOfByte[3] ^ CK[0]);
      paramArrayOfByte[1] ^= T_ap(paramArrayOfByte[2] ^ paramArrayOfByte[3] ^ arrayOfInt1[0] ^ CK[1]);
      paramArrayOfByte[2] ^= T_ap(paramArrayOfByte[3] ^ arrayOfInt1[0] ^ arrayOfInt1[1] ^ CK[2]);
      paramArrayOfByte[3] ^= T_ap(arrayOfInt1[0] ^ arrayOfInt1[1] ^ arrayOfInt1[2] ^ CK[3]);
      while (i < 32)
      {
        arrayOfInt1[i] = (arrayOfInt1[(i - 4)] ^ T_ap(arrayOfInt1[(i - 3)] ^ arrayOfInt1[(i - 2)] ^ arrayOfInt1[(i - 1)] ^ CK[i]));
        i += 1;
      }
    }
    arrayOfInt1[31] = (paramArrayOfByte[0] ^ T_ap(paramArrayOfByte[1] ^ paramArrayOfByte[2] ^ paramArrayOfByte[3] ^ CK[0]));
    arrayOfInt1[30] = (paramArrayOfByte[1] ^ T_ap(paramArrayOfByte[2] ^ paramArrayOfByte[3] ^ arrayOfInt1[31] ^ CK[1]));
    arrayOfInt1[29] = (paramArrayOfByte[2] ^ T_ap(paramArrayOfByte[3] ^ arrayOfInt1[31] ^ arrayOfInt1[30] ^ CK[2]));
    i = paramArrayOfByte[3];
    j = arrayOfInt1[31];
    arrayOfInt1[28] = (i ^ T_ap(arrayOfInt1[30] ^ j ^ arrayOfInt1[29] ^ CK[3]));
    i = 27;
    while (i >= 0)
    {
      arrayOfInt1[i] = (arrayOfInt1[(i + 4)] ^ T_ap(arrayOfInt1[(i + 3)] ^ arrayOfInt1[(i + 2)] ^ arrayOfInt1[(i + 1)] ^ CK[(31 - i)]));
      i -= 1;
    }
    return arrayOfInt1;
  }
  
  private int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  private int tau(int paramInt)
  {
    byte[] arrayOfByte = Sbox;
    int i = arrayOfByte[(paramInt >> 24 & 0xFF)];
    int j = arrayOfByte[(paramInt >> 16 & 0xFF)];
    int k = arrayOfByte[(paramInt >> 8 & 0xFF)];
    return arrayOfByte[(paramInt & 0xFF)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public String getAlgorithmName()
  {
    return "SM4";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      if (paramCipherParameters.length == 16)
      {
        this.rk = expandKey(paramBoolean, paramCipherParameters);
        return;
      }
      throw new IllegalArgumentException("SM4 requires a 128 bit key");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to SM4 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.rk != null)
    {
      if (paramInt1 + 16 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 16 <= paramArrayOfByte2.length)
        {
          this.X[0] = Pack.bigEndianToInt(paramArrayOfByte1, paramInt1);
          this.X[1] = Pack.bigEndianToInt(paramArrayOfByte1, paramInt1 + 4);
          this.X[2] = Pack.bigEndianToInt(paramArrayOfByte1, paramInt1 + 8);
          this.X[3] = Pack.bigEndianToInt(paramArrayOfByte1, paramInt1 + 12);
          paramInt1 = 0;
          while (paramInt1 < 32)
          {
            paramArrayOfByte1 = this.X;
            paramArrayOfByte1[0] = F0(paramArrayOfByte1, this.rk[paramInt1]);
            paramArrayOfByte1 = this.X;
            paramArrayOfByte1[1] = F1(paramArrayOfByte1, this.rk[(paramInt1 + 1)]);
            paramArrayOfByte1 = this.X;
            paramArrayOfByte1[2] = F2(paramArrayOfByte1, this.rk[(paramInt1 + 2)]);
            paramArrayOfByte1 = this.X;
            paramArrayOfByte1[3] = F3(paramArrayOfByte1, this.rk[(paramInt1 + 3)]);
            paramInt1 += 4;
          }
          R(this.X, 0);
          Pack.intToBigEndian(this.X[0], paramArrayOfByte2, paramInt2);
          Pack.intToBigEndian(this.X[1], paramArrayOfByte2, paramInt2 + 4);
          Pack.intToBigEndian(this.X[2], paramArrayOfByte2, paramInt2 + 8);
          Pack.intToBigEndian(this.X[3], paramArrayOfByte2, paramInt2 + 12);
          return 16;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("SM4 not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SM4Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */