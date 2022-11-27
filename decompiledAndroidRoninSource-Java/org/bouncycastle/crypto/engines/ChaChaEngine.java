package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public class ChaChaEngine
  extends Salsa20Engine
{
  public ChaChaEngine() {}
  
  public ChaChaEngine(int paramInt)
  {
    super(paramInt);
  }
  
  public static void chachaCore(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == 16)
    {
      if (paramArrayOfInt2.length == 16)
      {
        if (paramInt % 2 == 0)
        {
          int i11 = paramArrayOfInt1[0];
          int i7 = paramArrayOfInt1[1];
          int i3 = paramArrayOfInt1[2];
          int m = paramArrayOfInt1[3];
          int i8 = paramArrayOfInt1[4];
          int i4 = paramArrayOfInt1[5];
          int n = paramArrayOfInt1[6];
          int i = paramArrayOfInt1[7];
          int i9 = paramArrayOfInt1[8];
          int i5 = paramArrayOfInt1[9];
          int i1 = paramArrayOfInt1[10];
          int j = paramArrayOfInt1[11];
          int i10 = paramArrayOfInt1[12];
          int i6 = paramArrayOfInt1[13];
          int i2 = paramArrayOfInt1[14];
          int k = paramArrayOfInt1[15];
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
          paramArrayOfInt2[0] = (i11 + paramArrayOfInt1[0]);
          paramArrayOfInt2[1] = (i7 + paramArrayOfInt1[1]);
          paramArrayOfInt2[2] = (i3 + paramArrayOfInt1[2]);
          paramArrayOfInt2[3] = (m + paramArrayOfInt1[3]);
          paramArrayOfInt2[4] = (i8 + paramArrayOfInt1[4]);
          paramArrayOfInt2[5] = (i4 + paramArrayOfInt1[5]);
          paramArrayOfInt2[6] = (n + paramArrayOfInt1[6]);
          paramArrayOfInt2[7] = (i + paramArrayOfInt1[7]);
          paramArrayOfInt2[8] = (i9 + paramArrayOfInt1[8]);
          paramArrayOfInt2[9] = (i5 + paramArrayOfInt1[9]);
          paramArrayOfInt2[10] = (i1 + paramArrayOfInt1[10]);
          paramArrayOfInt2[11] = (j + paramArrayOfInt1[11]);
          paramArrayOfInt2[12] = (i10 + paramArrayOfInt1[12]);
          paramArrayOfInt2[13] = (i6 + paramArrayOfInt1[13]);
          paramArrayOfInt2[14] = (i2 + paramArrayOfInt1[14]);
          paramArrayOfInt2[15] = (k + paramArrayOfInt1[15]);
          return;
        }
        throw new IllegalArgumentException("Number of rounds must be even");
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  protected void advanceCounter()
  {
    int[] arrayOfInt = this.engineState;
    int i = arrayOfInt[12] + 1;
    arrayOfInt[12] = i;
    if (i == 0)
    {
      arrayOfInt = this.engineState;
      arrayOfInt[13] += 1;
    }
  }
  
  protected void advanceCounter(long paramLong)
  {
    int j = (int)(paramLong >>> 32);
    int i = (int)paramLong;
    if (j > 0)
    {
      arrayOfInt = this.engineState;
      arrayOfInt[13] += j;
    }
    j = this.engineState[12];
    int[] arrayOfInt = this.engineState;
    arrayOfInt[12] += i;
    if ((j != 0) && (this.engineState[12] < j))
    {
      arrayOfInt = this.engineState;
      arrayOfInt[13] += 1;
    }
  }
  
  protected void generateKeyStream(byte[] paramArrayOfByte)
  {
    chachaCore(this.rounds, this.engineState, this.x);
    Pack.intToLittleEndian(this.x, paramArrayOfByte, 0);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChaCha");
    localStringBuilder.append(this.rounds);
    return localStringBuilder.toString();
  }
  
  protected long getCounter()
  {
    return this.engineState[13] << 32 | this.engineState[12] & 0xFFFFFFFF;
  }
  
  protected void resetCounter()
  {
    int[] arrayOfInt = this.engineState;
    this.engineState[13] = 0;
    arrayOfInt[12] = 0;
  }
  
  protected void retreatCounter()
  {
    if ((this.engineState[12] == 0) && (this.engineState[13] == 0)) {
      throw new IllegalStateException("attempt to reduce counter past zero.");
    }
    int[] arrayOfInt = this.engineState;
    int i = arrayOfInt[12] - 1;
    arrayOfInt[12] = i;
    if (i == -1)
    {
      arrayOfInt = this.engineState;
      arrayOfInt[13] -= 1;
    }
  }
  
  protected void retreatCounter(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int[] arrayOfInt;
    if (i != 0) {
      if ((this.engineState[13] & 0xFFFFFFFF) >= (i & 0xFFFFFFFF))
      {
        arrayOfInt = this.engineState;
        arrayOfInt[13] -= i;
      }
      else
      {
        throw new IllegalStateException("attempt to reduce counter past zero.");
      }
    }
    if ((this.engineState[12] & 0xFFFFFFFF) >= (j & 0xFFFFFFFF))
    {
      arrayOfInt = this.engineState;
      arrayOfInt[12] -= j;
      return;
    }
    if (this.engineState[13] != 0)
    {
      arrayOfInt = this.engineState;
      arrayOfInt[13] -= 1;
      arrayOfInt = this.engineState;
      arrayOfInt[12] -= j;
      return;
    }
    throw new IllegalStateException("attempt to reduce counter past zero.");
  }
  
  protected void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if ((paramArrayOfByte1.length != 16) && (paramArrayOfByte1.length != 32))
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append(getAlgorithmName());
        paramArrayOfByte1.append(" requires 128 bit or 256 bit key");
        throw new IllegalArgumentException(paramArrayOfByte1.toString());
      }
      packTauOrSigma(paramArrayOfByte1.length, this.engineState, 0);
      Pack.littleEndianToInt(paramArrayOfByte1, 0, this.engineState, 4, 4);
      Pack.littleEndianToInt(paramArrayOfByte1, paramArrayOfByte1.length - 16, this.engineState, 8, 4);
    }
    Pack.littleEndianToInt(paramArrayOfByte2, 0, this.engineState, 14, 2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ChaChaEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */