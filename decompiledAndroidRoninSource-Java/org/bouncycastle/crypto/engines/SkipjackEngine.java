package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class SkipjackEngine
  implements BlockCipher
{
  static final int BLOCK_SIZE = 8;
  static short[] ftable = { 163, 215, 9, 131, 248, 72, 246, 244, 179, 33, 21, 120, 153, 177, 175, 249, 231, 45, 77, 138, 206, 76, 202, 46, 82, 149, 217, 30, 78, 56, 68, 40, 10, 223, 2, 160, 23, 241, 96, 104, 18, 183, 122, 195, 233, 250, 61, 83, 150, 132, 107, 186, 242, 99, 154, 25, 124, 174, 229, 245, 247, 22, 106, 162, 57, 182, 123, 15, 193, 147, 129, 27, 238, 180, 26, 234, 208, 145, 47, 184, 85, 185, 218, 133, 63, 65, 191, 224, 90, 88, 128, 95, 102, 11, 216, 144, 53, 213, 192, 167, 51, 6, 101, 105, 69, 0, 148, 86, 109, 152, 155, 118, 151, 252, 178, 194, 176, 254, 219, 32, 225, 235, 214, 228, 221, 71, 74, 29, 66, 237, 158, 110, 73, 60, 205, 67, 39, 210, 7, 212, 222, 199, 103, 24, 137, 203, 48, 31, 141, 198, 143, 170, 200, 116, 220, 201, 93, 92, 49, 164, 112, 136, 97, 44, 159, 13, 43, 135, 80, 130, 84, 100, 38, 125, 3, 64, 52, 75, 28, 115, 209, 196, 253, 59, 204, 251, 127, 171, 230, 62, 91, 165, 173, 4, 35, 156, 20, 81, 34, 240, 41, 121, 113, 126, 255, 140, 14, 226, 12, 239, 188, 114, 117, 111, 55, 161, 236, 211, 142, 98, 139, 134, 16, 232, 8, 119, 17, 190, 146, 79, 36, 197, 50, 54, 157, 207, 243, 166, 187, 172, 94, 108, 169, 19, 87, 37, 181, 227, 189, 168, 58, 1, 5, 89, 42, 70 };
  private boolean encrypting;
  private int[] key0;
  private int[] key1;
  private int[] key2;
  private int[] key3;
  
  private int g(int paramInt1, int paramInt2)
  {
    int i = paramInt2 & 0xFF;
    short[] arrayOfShort = ftable;
    paramInt2 = paramInt2 >> 8 & 0xFF ^ arrayOfShort[(this.key0[paramInt1] ^ i)];
    i ^= arrayOfShort[(this.key1[paramInt1] ^ paramInt2)];
    paramInt2 ^= arrayOfShort[(this.key2[paramInt1] ^ i)];
    return (paramInt2 << 8) + (arrayOfShort[(this.key3[paramInt1] ^ paramInt2)] ^ i);
  }
  
  private int h(int paramInt1, int paramInt2)
  {
    int i = paramInt2 >> 8 & 0xFF;
    short[] arrayOfShort = ftable;
    paramInt2 = paramInt2 & 0xFF ^ arrayOfShort[(this.key3[paramInt1] ^ i)];
    i ^= arrayOfShort[(this.key2[paramInt1] ^ paramInt2)];
    paramInt2 ^= arrayOfShort[(this.key1[paramInt1] ^ i)];
    return ((arrayOfShort[(this.key0[paramInt1] ^ paramInt2)] ^ i) << 8) + paramInt2;
  }
  
  public int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i1 = (paramArrayOfByte1[(paramInt1 + 0)] << 8) + (paramArrayOfByte1[(paramInt1 + 1)] & 0xFF);
    int j = (paramArrayOfByte1[(paramInt1 + 2)] << 8) + (paramArrayOfByte1[(paramInt1 + 3)] & 0xFF);
    int i = (paramArrayOfByte1[(paramInt1 + 4)] << 8) + (paramArrayOfByte1[(paramInt1 + 5)] & 0xFF);
    int k = (paramArrayOfByte1[(paramInt1 + 6)] << 8) + (paramArrayOfByte1[(paramInt1 + 7)] & 0xFF);
    int m = 31;
    int n = 0;
    paramInt1 = i1;
    while (n < 2)
    {
      i1 = 0;
      int i2;
      int i3;
      while (i1 < 8)
      {
        j = h(m, j);
        i2 = m - 1;
        i3 = i1 + 1;
        i1 = paramInt1;
        paramInt1 = j;
        j = i ^ j ^ m + 1;
        i = k;
        k = i1;
        i1 = i3;
        m = i2;
      }
      i1 = 0;
      while (i1 < 8)
      {
        i3 = h(m, j);
        i2 = m - 1;
        i1 += 1;
        m = paramInt1 ^ j ^ m + 1;
        paramInt1 = i3;
        j = i;
        i = k;
        k = m;
        m = i2;
      }
      n += 1;
    }
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)paramInt1);
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)(j >> 8));
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)j);
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)i);
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)(k >> 8));
    paramArrayOfByte2[(paramInt2 + 7)] = ((byte)k);
    return 8;
  }
  
  public int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int k = (paramArrayOfByte1[(paramInt1 + 0)] << 8) + (paramArrayOfByte1[(paramInt1 + 1)] & 0xFF);
    int m = (paramArrayOfByte1[(paramInt1 + 2)] << 8) + (paramArrayOfByte1[(paramInt1 + 3)] & 0xFF);
    int i1 = (paramArrayOfByte1[(paramInt1 + 4)] << 8) + (paramArrayOfByte1[(paramInt1 + 5)] & 0xFF);
    int i = (paramArrayOfByte1[(paramInt1 + 6)] << 8) + (paramArrayOfByte1[(paramInt1 + 7)] & 0xFF);
    int n = 0;
    int j = 0;
    paramInt1 = i1;
    while (n < 2)
    {
      i1 = 0;
      int i2;
      while (i1 < 8)
      {
        k = g(j, k);
        i2 = j + 1;
        i1 += 1;
        j = k;
        k = i ^ k ^ i2;
        i = paramInt1;
        paramInt1 = m;
        m = j;
        j = i2;
      }
      int i3;
      for (i1 = 0; i1 < 8; i1 = i3)
      {
        int i4 = j + 1;
        i2 = g(j, k);
        i3 = i1 + 1;
        j = i4;
        i1 = i2;
        i2 = i;
        i = paramInt1;
        paramInt1 = m ^ k ^ i4;
        k = i2;
        m = i1;
      }
      n += 1;
    }
    paramArrayOfByte2[(paramInt2 + 0)] = ((byte)(k >> 8));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)k);
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)(m >> 8));
    paramArrayOfByte2[(paramInt2 + 3)] = ((byte)m);
    paramArrayOfByte2[(paramInt2 + 4)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 5)] = ((byte)paramInt1);
    paramArrayOfByte2[(paramInt2 + 6)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt2 + 7)] = ((byte)i);
    return 8;
  }
  
  public String getAlgorithmName()
  {
    return "SKIPJACK";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      this.encrypting = paramBoolean;
      this.key0 = new int[32];
      this.key1 = new int[32];
      this.key2 = new int[32];
      this.key3 = new int[32];
      int i = 0;
      while (i < 32)
      {
        localObject = this.key0;
        int j = i * 4;
        localObject[i] = (paramCipherParameters[(j % 10)] & 0xFF);
        this.key1[i] = (paramCipherParameters[((j + 1) % 10)] & 0xFF);
        this.key2[i] = (paramCipherParameters[((j + 2) % 10)] & 0xFF);
        this.key3[i] = (paramCipherParameters[((j + 3) % 10)] & 0xFF);
        i += 1;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid parameter passed to SKIPJACK init - ");
    ((StringBuilder)localObject).append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.key1 != null)
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
    throw new IllegalStateException("SKIPJACK engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SkipjackEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */