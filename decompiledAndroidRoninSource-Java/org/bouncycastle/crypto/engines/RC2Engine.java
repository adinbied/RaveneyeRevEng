package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC2Parameters;

public class RC2Engine
  implements BlockCipher
{
  private static final int BLOCK_SIZE = 8;
  private static byte[] piTable = { -39, 120, -7, -60, 25, -35, -75, -19, 40, -23, -3, 121, 74, -96, -40, -99, -58, 126, 55, -125, 43, 118, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, 125, 50, -67, -113, 64, -21, -122, -73, 123, 11, -16, -107, 33, 34, 92, 107, 78, -126, 84, -42, 101, -109, -50, 96, -78, 28, 115, 86, -64, 20, -89, -116, -15, -36, 18, 117, -54, 31, 59, -66, -28, -47, 66, 61, -44, 48, -93, 60, -74, 38, 111, -65, 14, -38, 70, 105, 7, 87, 39, -14, 29, -101, -68, -108, 67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 6, -61, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, -128, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, 42, -106, 26, -46, 113, 90, 21, 73, 116, 75, -97, -48, 94, 4, 24, -92, -20, -62, -32, 65, 110, 15, 81, -53, -52, 36, -111, -81, 80, -95, -12, 112, 57, -103, 124, 58, -123, 35, -72, -76, 122, -4, 2, 54, 91, 37, 85, -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 5, -33, 41, 16, 103, 108, -70, -55, -45, 0, -26, -49, -31, -98, -88, 44, 99, 22, 1, 63, 88, -30, -119, -87, 13, 56, 52, 27, -85, 51, -1, -80, -69, 72, 12, 95, -71, -79, -51, 46, -59, -13, -37, 71, -27, -91, -100, 119, 10, -90, 32, 104, -2, 127, -63, -83 };
  private boolean encrypting;
  private int[] workingKey;
  
  private void decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int m = ((paramArrayOfByte1[(paramInt1 + 7)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 6)] & 0xFF);
    int k = ((paramArrayOfByte1[(paramInt1 + 5)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 4)] & 0xFF);
    int i = ((paramArrayOfByte1[(paramInt1 + 3)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 2)] & 0xFF);
    paramInt1 = ((paramArrayOfByte1[(paramInt1 + 1)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 0)] & 0xFF);
    int j = 60;
    while (j >= 44)
    {
      m = rotateWordLeft(m, 11) - ((k & paramInt1) + (i & k) + this.workingKey[(j + 3)]);
      k = rotateWordLeft(k, 13) - ((i & m) + (paramInt1 & i) + this.workingKey[(j + 2)]);
      i = rotateWordLeft(i, 14) - ((paramInt1 & k) + (m & paramInt1) + this.workingKey[(j + 1)]);
      paramInt1 = rotateWordLeft(paramInt1, 15) - ((m & i) + (k & m) + this.workingKey[j]);
      j -= 4;
    }
    paramArrayOfByte1 = this.workingKey;
    m -= paramArrayOfByte1[(k & 0x3F)];
    k -= paramArrayOfByte1[(i & 0x3F)];
    i -= paramArrayOfByte1[(paramInt1 & 0x3F)];
    paramInt1 -= paramArrayOfByte1[(m & 0x3F)];
    j = 40;
    while (j >= 20)
    {
      m = rotateWordLeft(m, 11) - ((k & paramInt1) + (i & k) + this.workingKey[(j + 3)]);
      k = rotateWordLeft(k, 13) - ((i & m) + (paramInt1 & i) + this.workingKey[(j + 2)]);
      i = rotateWordLeft(i, 14) - ((paramInt1 & k) + (m & paramInt1) + this.workingKey[(j + 1)]);
      paramInt1 = rotateWordLeft(paramInt1, 15) - ((m & i) + (k & m) + this.workingKey[j]);
      j -= 4;
    }
    paramArrayOfByte1 = this.workingKey;
    m -= paramArrayOfByte1[(k & 0x3F)];
    k -= paramArrayOfByte1[(i & 0x3F)];
    j = i - paramArrayOfByte1[(paramInt1 & 0x3F)];
    i = paramInt1 - paramArrayOfByte1[(m & 0x3F)];
    paramInt1 = 16;
    while (paramInt1 >= 0)
    {
      m = rotateWordLeft(m, 11) - ((k & i) + (j & k) + this.workingKey[(paramInt1 + 3)]);
      k = rotateWordLeft(k, 13) - ((j & m) + (i & j) + this.workingKey[(paramInt1 + 2)]);
      j = rotateWordLeft(j, 14) - ((i & k) + (m & i) + this.workingKey[(paramInt1 + 1)]);
      i = rotateWordLeft(i, 15) - ((m & j) + (k & m) + this.workingKey[paramInt1]);
      paramInt1 -= 4;
    }
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)i);
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)j);
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)(j >> 8));
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)k);
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)(k >> 8));
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)m);
    paramArrayOfByte2[(paramInt2 + 7)] = ((byte)(m >> 8));
  }
  
  private void encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = ((paramArrayOfByte1[(paramInt1 + 7)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 6)] & 0xFF);
    int j = ((paramArrayOfByte1[(paramInt1 + 5)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 4)] & 0xFF);
    int k = ((paramArrayOfByte1[(paramInt1 + 3)] & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 2)] & 0xFF);
    int n = paramArrayOfByte1[(paramInt1 + 1)];
    int m = 0;
    n = ((n & 0xFF) << 8) + (paramArrayOfByte1[(paramInt1 + 0)] & 0xFF);
    paramInt1 = m;
    m = n;
    while (paramInt1 <= 16)
    {
      m = rotateWordLeft(m + (i & k) + (j & i) + this.workingKey[paramInt1], 1);
      k = rotateWordLeft(k + (m & j) + (i & m) + this.workingKey[(paramInt1 + 1)], 2);
      j = rotateWordLeft(j + (k & i) + (m & k) + this.workingKey[(paramInt1 + 2)], 3);
      i = rotateWordLeft(i + (j & m) + (k & j) + this.workingKey[(paramInt1 + 3)], 5);
      paramInt1 += 4;
    }
    paramArrayOfByte1 = this.workingKey;
    m += paramArrayOfByte1[(i & 0x3F)];
    k += paramArrayOfByte1[(m & 0x3F)];
    j += paramArrayOfByte1[(k & 0x3F)];
    i += paramArrayOfByte1[(j & 0x3F)];
    paramInt1 = 20;
    while (paramInt1 <= 40)
    {
      m = rotateWordLeft(m + (i & k) + (j & i) + this.workingKey[paramInt1], 1);
      k = rotateWordLeft(k + (m & j) + (i & m) + this.workingKey[(paramInt1 + 1)], 2);
      j = rotateWordLeft(j + (k & i) + (m & k) + this.workingKey[(paramInt1 + 2)], 3);
      i = rotateWordLeft(i + (j & m) + (k & j) + this.workingKey[(paramInt1 + 3)], 5);
      paramInt1 += 4;
    }
    paramArrayOfByte1 = this.workingKey;
    m += paramArrayOfByte1[(i & 0x3F)];
    k += paramArrayOfByte1[(m & 0x3F)];
    j += paramArrayOfByte1[(k & 0x3F)];
    i += paramArrayOfByte1[(j & 0x3F)];
    paramInt1 = 44;
    while (paramInt1 < 64)
    {
      m = rotateWordLeft(m + (i & k) + (j & i) + this.workingKey[paramInt1], 1);
      k = rotateWordLeft(k + (m & j) + (i & m) + this.workingKey[(paramInt1 + 1)], 2);
      j = rotateWordLeft(j + (k & i) + (m & k) + this.workingKey[(paramInt1 + 2)], 3);
      i = rotateWordLeft(i + (j & m) + (k & j) + this.workingKey[(paramInt1 + 3)], 5);
      paramInt1 += 4;
    }
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)m);
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(m >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)k);
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)(k >> 8));
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)j);
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)(j >> 8));
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)i);
    paramArrayOfByte2[(paramInt2 + 7)] = ((byte)(i >> 8));
  }
  
  private int[] generateWorkingKey(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[''];
    int m = 0;
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    int j = paramArrayOfByte.length;
    if (j < 128)
    {
      k = arrayOfInt[(j - 1)];
      i = 0;
      for (;;)
      {
        k = piTable[(k + arrayOfInt[i] & 0xFF)] & 0xFF;
        int n = j + 1;
        arrayOfInt[j] = k;
        if (n >= 128) {
          break;
        }
        j = n;
        i += 1;
      }
    }
    j = paramInt + 7 >> 3;
    paramArrayOfByte = piTable;
    int k = 128 - j;
    i = arrayOfInt[k];
    i = paramArrayOfByte[(255 >> (-paramInt & 0x7) & i)] & 0xFF;
    arrayOfInt[k] = i;
    paramInt = k - 1;
    while (paramInt >= 0)
    {
      i = piTable[(i ^ arrayOfInt[(paramInt + j)])] & 0xFF;
      arrayOfInt[paramInt] = i;
      paramInt -= 1;
    }
    paramArrayOfByte = new int[64];
    paramInt = m;
    while (paramInt != 64)
    {
      i = paramInt * 2;
      arrayOfInt[i] += (arrayOfInt[(i + 1)] << 8);
      paramInt += 1;
    }
    return paramArrayOfByte;
  }
  
  private int rotateWordLeft(int paramInt1, int paramInt2)
  {
    paramInt1 &= 0xFFFF;
    return paramInt1 >> 16 - paramInt2 | paramInt1 << paramInt2;
  }
  
  public String getAlgorithmName()
  {
    return "RC2";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.encrypting = paramBoolean;
    if ((paramCipherParameters instanceof RC2Parameters))
    {
      paramCipherParameters = (RC2Parameters)paramCipherParameters;
      this.workingKey = generateWorkingKey(paramCipherParameters.getKey(), paramCipherParameters.getEffectiveKeyBits());
      return;
    }
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      this.workingKey = generateWorkingKey(paramCipherParameters, paramCipherParameters.length * 8);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC2 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.workingKey != null)
    {
      if (paramInt1 + 8 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 8 <= paramArrayOfByte2.length)
        {
          if (this.encrypting) {
            encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          } else {
            decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return 8;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("RC2 engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC2Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */