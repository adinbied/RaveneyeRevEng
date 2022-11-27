package org.bouncycastle.pqc.crypto.sphincs;

class Wots
{
  static final int WOTS_L = 67;
  static final int WOTS_L1 = 64;
  static final int WOTS_LOGW = 4;
  static final int WOTS_LOG_L = 7;
  static final int WOTS_SIGBYTES = 2144;
  static final int WOTS_W = 16;
  
  private static void clear(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i != paramInt2)
    {
      paramArrayOfByte[(i + paramInt1)] = 0;
      i += 1;
    }
  }
  
  static void expand_seed(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    clear(paramArrayOfByte1, paramInt1, 2144);
    Seed.prg(paramArrayOfByte1, paramInt1, 2144L, paramArrayOfByte2, paramInt2);
  }
  
  static void gen_chain(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 32) {
        break;
      }
      paramArrayOfByte1[(i + paramInt1)] = paramArrayOfByte2[(i + paramInt2)];
      i += 1;
    }
    while ((j < paramInt4) && (j < 16))
    {
      paramHashFunctions.hash_n_n_mask(paramArrayOfByte1, paramInt1, paramArrayOfByte1, paramInt1, paramArrayOfByte3, paramInt3 + j * 32);
      j += 1;
    }
  }
  
  void wots_pkgen(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    expand_seed(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    paramInt2 = 0;
    while (paramInt2 < 67)
    {
      int i = paramInt1 + paramInt2 * 32;
      gen_chain(paramHashFunctions, paramArrayOfByte1, i, paramArrayOfByte1, i, paramArrayOfByte3, paramInt3, 15);
      paramInt2 += 1;
    }
  }
  
  void wots_sign(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int[] arrayOfInt = new int[67];
    int n = 0;
    int i = 0;
    int j = 0;
    int k;
    int m;
    for (;;)
    {
      k = i;
      m = j;
      if (i >= 64) {
        break;
      }
      k = i / 2;
      paramArrayOfByte2[k] &= 0xF;
      m = i + 1;
      arrayOfInt[m] = ((paramArrayOfByte2[k] & 0xFF) >>> 4);
      j = j + (15 - arrayOfInt[i]) + (15 - arrayOfInt[m]);
      i += 2;
    }
    while (k < 67)
    {
      arrayOfInt[k] = (m & 0xF);
      m >>>= 4;
      k += 1;
    }
    expand_seed(paramArrayOfByte1, paramInt, paramArrayOfByte3, 0);
    i = n;
    while (i < 67)
    {
      j = paramInt + i * 32;
      gen_chain(paramHashFunctions, paramArrayOfByte1, j, paramArrayOfByte1, j, paramArrayOfByte4, 0, arrayOfInt[i]);
      i += 1;
    }
  }
  
  void wots_verify(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int[] arrayOfInt = new int[67];
    int n = 0;
    int i = 0;
    int j = 0;
    int k;
    int m;
    for (;;)
    {
      k = i;
      m = j;
      if (i >= 64) {
        break;
      }
      k = i / 2;
      paramArrayOfByte3[k] &= 0xF;
      m = i + 1;
      arrayOfInt[m] = ((paramArrayOfByte3[k] & 0xFF) >>> 4);
      j = j + (15 - arrayOfInt[i]) + (15 - arrayOfInt[m]);
      i += 2;
    }
    for (;;)
    {
      i = n;
      if (k >= 67) {
        break;
      }
      arrayOfInt[k] = (m & 0xF);
      m >>>= 4;
      k += 1;
    }
    while (i < 67)
    {
      j = i * 32;
      gen_chain(paramHashFunctions, paramArrayOfByte1, j, paramArrayOfByte2, paramInt + j, paramArrayOfByte4, arrayOfInt[i] * 32, 15 - arrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\Wots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */