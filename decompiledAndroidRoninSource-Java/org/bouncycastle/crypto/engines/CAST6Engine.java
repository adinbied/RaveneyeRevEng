package org.bouncycastle.crypto.engines;

public final class CAST6Engine
  extends CAST5Engine
{
  protected static final int BLOCK_SIZE = 16;
  protected static final int ROUNDS = 12;
  protected int[] _Km = new int[48];
  protected int[] _Kr = new int[48];
  protected int[] _Tm = new int['À'];
  protected int[] _Tr = new int['À'];
  private int[] _workingKey = new int[8];
  
  protected final void CAST_Decipher(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int i = 0;
    int j;
    int n;
    int k;
    int m;
    int i1;
    int[] arrayOfInt;
    for (;;)
    {
      j = 6;
      n = paramInt1;
      k = paramInt2;
      m = paramInt3;
      i1 = paramInt4;
      if (i >= 6) {
        break;
      }
      j = (11 - i) * 4;
      paramInt3 ^= F1(paramInt4, this._Km[j], this._Kr[j]);
      arrayOfInt = this._Km;
      k = j + 1;
      paramInt2 ^= F2(paramInt3, arrayOfInt[k], this._Kr[k]);
      arrayOfInt = this._Km;
      k = j + 2;
      paramInt1 ^= F3(paramInt2, arrayOfInt[k], this._Kr[k]);
      arrayOfInt = this._Km;
      j += 3;
      paramInt4 ^= F1(paramInt1, arrayOfInt[j], this._Kr[j]);
      i += 1;
    }
    while (j < 12)
    {
      paramInt1 = (11 - j) * 4;
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 3;
      i1 ^= F1(n, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 2;
      n ^= F3(k, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 1;
      k ^= F2(m, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      m ^= F1(i1, this._Km[paramInt1], this._Kr[paramInt1]);
      j += 1;
    }
    paramArrayOfInt[0] = n;
    paramArrayOfInt[1] = k;
    paramArrayOfInt[2] = m;
    paramArrayOfInt[3] = i1;
  }
  
  protected final void CAST_Encipher(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    int i = 0;
    int j;
    int n;
    int k;
    int m;
    int i1;
    int[] arrayOfInt;
    for (;;)
    {
      j = 6;
      n = paramInt1;
      k = paramInt2;
      m = paramInt3;
      i1 = paramInt4;
      if (i >= 6) {
        break;
      }
      j = i * 4;
      paramInt3 ^= F1(paramInt4, this._Km[j], this._Kr[j]);
      arrayOfInt = this._Km;
      k = j + 1;
      paramInt2 ^= F2(paramInt3, arrayOfInt[k], this._Kr[k]);
      arrayOfInt = this._Km;
      k = j + 2;
      paramInt1 ^= F3(paramInt2, arrayOfInt[k], this._Kr[k]);
      arrayOfInt = this._Km;
      j += 3;
      paramInt4 ^= F1(paramInt1, arrayOfInt[j], this._Kr[j]);
      i += 1;
    }
    while (j < 12)
    {
      paramInt1 = j * 4;
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 3;
      i1 ^= F1(n, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 2;
      n ^= F3(k, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      arrayOfInt = this._Km;
      paramInt2 = paramInt1 + 1;
      k ^= F2(m, arrayOfInt[paramInt2], this._Kr[paramInt2]);
      m ^= F1(i1, this._Km[paramInt1], this._Kr[paramInt1]);
      j += 1;
    }
    paramArrayOfInt[0] = n;
    paramArrayOfInt[1] = k;
    paramArrayOfInt[2] = m;
    paramArrayOfInt[3] = i1;
  }
  
  protected int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = new int[4];
    CAST_Decipher(BytesTo32bits(paramArrayOfByte1, paramInt1), BytesTo32bits(paramArrayOfByte1, paramInt1 + 4), BytesTo32bits(paramArrayOfByte1, paramInt1 + 8), BytesTo32bits(paramArrayOfByte1, paramInt1 + 12), arrayOfInt);
    Bits32ToBytes(arrayOfInt[0], paramArrayOfByte2, paramInt2);
    Bits32ToBytes(arrayOfInt[1], paramArrayOfByte2, paramInt2 + 4);
    Bits32ToBytes(arrayOfInt[2], paramArrayOfByte2, paramInt2 + 8);
    Bits32ToBytes(arrayOfInt[3], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  protected int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = new int[4];
    CAST_Encipher(BytesTo32bits(paramArrayOfByte1, paramInt1), BytesTo32bits(paramArrayOfByte1, paramInt1 + 4), BytesTo32bits(paramArrayOfByte1, paramInt1 + 8), BytesTo32bits(paramArrayOfByte1, paramInt1 + 12), arrayOfInt);
    Bits32ToBytes(arrayOfInt[0], paramArrayOfByte2, paramInt2);
    Bits32ToBytes(arrayOfInt[1], paramArrayOfByte2, paramInt2 + 4);
    Bits32ToBytes(arrayOfInt[2], paramArrayOfByte2, paramInt2 + 8);
    Bits32ToBytes(arrayOfInt[3], paramArrayOfByte2, paramInt2 + 12);
    return 16;
  }
  
  public String getAlgorithmName()
  {
    return "CAST6";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public void reset() {}
  
  protected void setKey(byte[] paramArrayOfByte)
  {
    int m = 1518500249;
    int j = 19;
    int i = 0;
    int k;
    int n;
    while (i < 24)
    {
      k = 0;
      while (k < 8)
      {
        localObject = this._Tm;
        n = i * 8 + k;
        localObject[n] = m;
        m += 1859775393;
        this._Tr[n] = j;
        j = j + 17 & 0x1F;
        k += 1;
      }
      i += 1;
    }
    Object localObject = new byte[64];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
    i = 0;
    while (i < 8)
    {
      this._workingKey[i] = BytesTo32bits((byte[])localObject, i * 4);
      i += 1;
    }
    i = 0;
    while (i < 12)
    {
      j = i * 2;
      k = j * 8;
      paramArrayOfByte = this._workingKey;
      paramArrayOfByte[6] ^= F1(paramArrayOfByte[7], this._Tm[k], this._Tr[k]);
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[5];
      n = paramArrayOfByte[6];
      localObject = this._Tm;
      int i1 = k + 1;
      paramArrayOfByte[5] = (m ^ F2(n, localObject[i1], this._Tr[i1]));
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[4];
      n = paramArrayOfByte[5];
      localObject = this._Tm;
      i1 = k + 2;
      paramArrayOfByte[4] = (m ^ F3(n, localObject[i1], this._Tr[i1]));
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[3];
      n = paramArrayOfByte[4];
      localObject = this._Tm;
      i1 = k + 3;
      paramArrayOfByte[3] = (F1(n, localObject[i1], this._Tr[i1]) ^ m);
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[2];
      n = paramArrayOfByte[3];
      localObject = this._Tm;
      i1 = k + 4;
      paramArrayOfByte[2] = (F2(n, localObject[i1], this._Tr[i1]) ^ m);
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[1];
      n = paramArrayOfByte[2];
      localObject = this._Tm;
      i1 = k + 5;
      paramArrayOfByte[1] = (F3(n, localObject[i1], this._Tr[i1]) ^ m);
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[0];
      n = paramArrayOfByte[1];
      localObject = this._Tm;
      i1 = k + 6;
      paramArrayOfByte[0] = (m ^ F1(n, localObject[i1], this._Tr[i1]));
      paramArrayOfByte = this._workingKey;
      m = paramArrayOfByte[7];
      n = paramArrayOfByte[0];
      localObject = this._Tm;
      k += 7;
      paramArrayOfByte[7] = (F2(n, localObject[k], this._Tr[k]) ^ m);
      j = (j + 1) * 8;
      paramArrayOfByte = this._workingKey;
      paramArrayOfByte[6] ^= F1(paramArrayOfByte[7], this._Tm[j], this._Tr[j]);
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[5];
      m = paramArrayOfByte[6];
      localObject = this._Tm;
      n = j + 1;
      paramArrayOfByte[5] = (k ^ F2(m, localObject[n], this._Tr[n]));
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[4];
      m = paramArrayOfByte[5];
      localObject = this._Tm;
      n = j + 2;
      paramArrayOfByte[4] = (k ^ F3(m, localObject[n], this._Tr[n]));
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[3];
      m = paramArrayOfByte[4];
      localObject = this._Tm;
      n = j + 3;
      paramArrayOfByte[3] = (F1(m, localObject[n], this._Tr[n]) ^ k);
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[2];
      m = paramArrayOfByte[3];
      localObject = this._Tm;
      n = j + 4;
      paramArrayOfByte[2] = (F2(m, localObject[n], this._Tr[n]) ^ k);
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[1];
      m = paramArrayOfByte[2];
      localObject = this._Tm;
      n = j + 5;
      paramArrayOfByte[1] = (F3(m, localObject[n], this._Tr[n]) ^ k);
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[0];
      m = paramArrayOfByte[1];
      localObject = this._Tm;
      n = j + 6;
      paramArrayOfByte[0] = (k ^ F1(m, localObject[n], this._Tr[n]));
      paramArrayOfByte = this._workingKey;
      k = paramArrayOfByte[7];
      m = paramArrayOfByte[0];
      localObject = this._Tm;
      j += 7;
      paramArrayOfByte[7] = (F2(m, localObject[j], this._Tr[j]) ^ k);
      localObject = this._Kr;
      j = i * 4;
      paramArrayOfByte = this._workingKey;
      localObject[j] = (paramArrayOfByte[0] & 0x1F);
      k = j + 1;
      localObject[k] = (paramArrayOfByte[2] & 0x1F);
      m = j + 2;
      localObject[m] = (paramArrayOfByte[4] & 0x1F);
      n = j + 3;
      localObject[n] = (paramArrayOfByte[6] & 0x1F);
      localObject = this._Km;
      localObject[j] = paramArrayOfByte[7];
      localObject[k] = paramArrayOfByte[5];
      localObject[m] = paramArrayOfByte[3];
      localObject[n] = paramArrayOfByte[1];
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\CAST6Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */