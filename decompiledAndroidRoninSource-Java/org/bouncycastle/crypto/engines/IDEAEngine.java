package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class IDEAEngine
  implements BlockCipher
{
  private static final int BASE = 65537;
  protected static final int BLOCK_SIZE = 8;
  private static final int MASK = 65535;
  private int[] workingKey = null;
  
  private int bytesToWord(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 1)] & 0xFF);
  }
  
  private int[] expandKey(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[52];
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = j;
    byte[] arrayOfByte = paramArrayOfByte;
    if (k < 16)
    {
      arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 16 - paramArrayOfByte.length, paramArrayOfByte.length);
      i = j;
    }
    for (;;)
    {
      j = 8;
      if (i >= 8) {
        break;
      }
      arrayOfInt[i] = bytesToWord(arrayOfByte, i * 2);
      i += 1;
    }
    while (j < 52)
    {
      i = j & 0x7;
      if (i < 6) {
        arrayOfInt[j] = (((arrayOfInt[(j - 7)] & 0x7F) << 9 | arrayOfInt[(j - 6)] >> 7) & 0xFFFF);
      } else if (i == 6) {
        arrayOfInt[j] = (((arrayOfInt[(j - 7)] & 0x7F) << 9 | arrayOfInt[(j - 14)] >> 7) & 0xFFFF);
      } else {
        arrayOfInt[j] = (((arrayOfInt[(j - 15)] & 0x7F) << 9 | arrayOfInt[(j - 14)] >> 7) & 0xFFFF);
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  private int[] generateWorkingKey(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return expandKey(paramArrayOfByte);
    }
    return invertKey(expandKey(paramArrayOfByte));
  }
  
  private void ideaFunc(int[] paramArrayOfInt, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int n = bytesToWord(paramArrayOfByte1, paramInt1);
    int k = bytesToWord(paramArrayOfByte1, paramInt1 + 2);
    int j = bytesToWord(paramArrayOfByte1, paramInt1 + 4);
    int i = bytesToWord(paramArrayOfByte1, paramInt1 + 6);
    paramInt1 = 0;
    int i1;
    for (int m = 0; paramInt1 < 8; m = i1 + 1)
    {
      i1 = m + 1;
      m = mul(n, paramArrayOfInt[m]);
      n = i1 + 1;
      k = k + paramArrayOfInt[i1] & 0xFFFF;
      i1 = n + 1;
      n = j + paramArrayOfInt[n] & 0xFFFF;
      j = i1 + 1;
      i = mul(i, paramArrayOfInt[i1]);
      i1 = j + 1;
      j = mul(n ^ m, paramArrayOfInt[j]);
      int i2 = mul((k ^ i) + j & 0xFFFF, paramArrayOfInt[i1]);
      j = j + i2 & 0xFFFF;
      i ^= j;
      j ^= k;
      paramInt1 += 1;
      k = n ^ i2;
      n = m ^ i2;
    }
    paramInt1 = m + 1;
    wordToBytes(mul(n, paramArrayOfInt[m]), paramArrayOfByte2, paramInt2);
    m = paramInt1 + 1;
    wordToBytes(j + paramArrayOfInt[paramInt1], paramArrayOfByte2, paramInt2 + 2);
    wordToBytes(k + paramArrayOfInt[m], paramArrayOfByte2, paramInt2 + 4);
    wordToBytes(mul(i, paramArrayOfInt[(m + 1)]), paramArrayOfByte2, paramInt2 + 6);
  }
  
  private int[] invertKey(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[52];
    int k = mulInv(paramArrayOfInt[0]);
    int i = 1;
    int j = addInv(paramArrayOfInt[1]);
    int m = addInv(paramArrayOfInt[2]);
    arrayOfInt[51] = mulInv(paramArrayOfInt[3]);
    arrayOfInt[50] = m;
    arrayOfInt[49] = j;
    j = 48;
    arrayOfInt[48] = k;
    for (k = 4; i < 8; k = m + 1)
    {
      n = k + 1;
      m = paramArrayOfInt[k];
      k = n + 1;
      n = paramArrayOfInt[n];
      j -= 1;
      arrayOfInt[j] = n;
      j -= 1;
      arrayOfInt[j] = m;
      m = k + 1;
      k = mulInv(paramArrayOfInt[k]);
      int i1 = m + 1;
      n = addInv(paramArrayOfInt[m]);
      m = i1 + 1;
      i1 = addInv(paramArrayOfInt[i1]);
      int i2 = mulInv(paramArrayOfInt[m]);
      j -= 1;
      arrayOfInt[j] = i2;
      j -= 1;
      arrayOfInt[j] = n;
      j -= 1;
      arrayOfInt[j] = i1;
      j -= 1;
      arrayOfInt[j] = k;
      i += 1;
    }
    m = k + 1;
    k = paramArrayOfInt[k];
    i = m + 1;
    m = paramArrayOfInt[m];
    j -= 1;
    arrayOfInt[j] = m;
    j -= 1;
    arrayOfInt[j] = k;
    k = i + 1;
    i = mulInv(paramArrayOfInt[i]);
    int n = k + 1;
    k = addInv(paramArrayOfInt[k]);
    m = addInv(paramArrayOfInt[n]);
    n = mulInv(paramArrayOfInt[(n + 1)]);
    j -= 1;
    arrayOfInt[j] = n;
    j -= 1;
    arrayOfInt[j] = m;
    j -= 1;
    arrayOfInt[j] = k;
    arrayOfInt[(j - 1)] = i;
    return arrayOfInt;
  }
  
  private int mul(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 65537 - paramInt2;
    }
    else if (paramInt2 == 0)
    {
      paramInt1 = 65537 - paramInt1;
    }
    else
    {
      paramInt1 *= paramInt2;
      paramInt2 = paramInt1 & 0xFFFF;
      int i = paramInt1 >>> 16;
      if (paramInt2 < i) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      paramInt1 = paramInt2 - i + paramInt1;
    }
    return paramInt1 & 0xFFFF;
  }
  
  private int mulInv(int paramInt)
  {
    if (paramInt < 2) {
      return paramInt;
    }
    int m = 65537 / paramInt;
    int i = 65537 % paramInt;
    int j = 1;
    int k = paramInt;
    for (paramInt = m; i != 1; paramInt = paramInt + m * j & 0xFFFF)
    {
      m = k / i;
      k %= i;
      j = j + m * paramInt & 0xFFFF;
      if (k == 1) {
        return j;
      }
      m = i / k;
      i %= k;
    }
    return 1 - paramInt & 0xFFFF;
  }
  
  private void wordToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  int addInv(int paramInt)
  {
    return 0 - paramInt & 0xFFFF;
  }
  
  public String getAlgorithmName()
  {
    return "IDEA";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.workingKey = generateWorkingKey(paramBoolean, ((KeyParameter)paramCipherParameters).getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to IDEA init - ");
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
          ideaFunc(arrayOfInt, paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          return 8;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("IDEA engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\IDEAEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */