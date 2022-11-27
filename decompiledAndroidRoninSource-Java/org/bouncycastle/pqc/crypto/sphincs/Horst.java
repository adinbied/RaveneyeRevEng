package org.bouncycastle.pqc.crypto.sphincs;

class Horst
{
  static final int HORST_K = 32;
  static final int HORST_LOGT = 16;
  static final int HORST_SIGBYTES = 13312;
  static final int HORST_SKBYTES = 32;
  static final int HORST_T = 65536;
  static final int N_MASKS = 32;
  
  static void expand_seed(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Seed.prg(paramArrayOfByte1, 0, 2097152L, paramArrayOfByte2, 0);
  }
  
  static int horst_sign(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    byte[] arrayOfByte1 = new byte[2097152];
    byte[] arrayOfByte2 = new byte[4194272];
    expand_seed(arrayOfByte1, paramArrayOfByte3);
    int n = 0;
    int i = 0;
    while (i < 65536)
    {
      paramHashFunctions.hash_n_n(arrayOfByte2, (65535 + i) * 32, arrayOfByte1, i * 32);
      i += 1;
    }
    i = 0;
    int j;
    int k;
    while (i < 16)
    {
      j = 16 - i;
      long l2 = (1 << j) - 1;
      j = 1 << j - 1;
      long l1 = j - 1;
      k = 0;
      while (k < j)
      {
        paramHashFunctions.hash_2n_n_mask(arrayOfByte2, (int)((k + l1) * 32L), arrayOfByte2, (int)((k * 2 + l2) * 32L), paramArrayOfByte4, i * 2 * 32);
        k += 1;
      }
      i += 1;
    }
    i = 2016;
    while (i < 4064)
    {
      paramArrayOfByte1[paramInt] = arrayOfByte2[i];
      i += 1;
      paramInt += 1;
    }
    i = 0;
    for (;;)
    {
      j = n;
      if (i >= 32) {
        break;
      }
      j = i * 2;
      k = (paramArrayOfByte5[j] & 0xFF) + ((paramArrayOfByte5[(j + 1)] & 0xFF) << 8);
      j = 0;
      while (j < 32)
      {
        paramArrayOfByte1[paramInt] = arrayOfByte1[(k * 32 + j)];
        j += 1;
        paramInt += 1;
      }
      k += 65535;
      j = 0;
      while (j < 10)
      {
        if ((k & 0x1) != 0) {
          k += 1;
        } else {
          k -= 1;
        }
        int m = 0;
        while (m < 32)
        {
          paramArrayOfByte1[paramInt] = arrayOfByte2[(k * 32 + m)];
          m += 1;
          paramInt += 1;
        }
        k = (k - 1) / 2;
        j += 1;
      }
      i += 1;
    }
    while (j < 32)
    {
      paramArrayOfByte2[j] = arrayOfByte2[j];
      j += 1;
    }
    return 13312;
  }
  
  static int horst_verify(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    int i = paramInt + 2048;
    int j = 0;
    while (j < 32)
    {
      int k = j * 2;
      int m = (paramArrayOfByte4[k] & 0xFF) + ((paramArrayOfByte4[(k + 1)] & 0xFF) << 8);
      if ((m & 0x1) == 0)
      {
        paramHashFunctions.hash_n_n(arrayOfByte, 0, paramArrayOfByte2, i);
        k = 0;
        while (k < 32)
        {
          arrayOfByte[(k + 32)] = paramArrayOfByte2[(i + 32 + k)];
          k += 1;
        }
      }
      paramHashFunctions.hash_n_n(arrayOfByte, 32, paramArrayOfByte2, i);
      k = 0;
      while (k < 32)
      {
        arrayOfByte[k] = paramArrayOfByte2[(i + 32 + k)];
        k += 1;
      }
      i += 64;
      k = 1;
      while (k < 10)
      {
        int n = m >>> 1;
        if ((n & 0x1) == 0)
        {
          paramHashFunctions.hash_2n_n_mask(arrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte3, (k - 1) * 2 * 32);
          m = 0;
          while (m < 32)
          {
            arrayOfByte[(m + 32)] = paramArrayOfByte2[(i + m)];
            m += 1;
          }
        }
        paramHashFunctions.hash_2n_n_mask(arrayOfByte, 32, arrayOfByte, 0, paramArrayOfByte3, (k - 1) * 2 * 32);
        m = 0;
        while (m < 32)
        {
          arrayOfByte[m] = paramArrayOfByte2[(i + m)];
          m += 1;
        }
        i += 32;
        k += 1;
        m = n;
      }
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte3, 576);
      k = 0;
      while (k < 32)
      {
        if (paramArrayOfByte2[((m >>> 1) * 32 + paramInt + k)] != arrayOfByte[k])
        {
          paramInt = 0;
          while (paramInt < 32)
          {
            paramArrayOfByte1[paramInt] = 0;
            paramInt += 1;
          }
          return -1;
        }
        k += 1;
      }
      j += 1;
    }
    i = 0;
    while (i < 32)
    {
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, i * 32, paramArrayOfByte2, paramInt + i * 2 * 32, paramArrayOfByte3, 640);
      i += 1;
    }
    paramInt = 0;
    while (paramInt < 16)
    {
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, paramInt * 32, arrayOfByte, paramInt * 2 * 32, paramArrayOfByte3, 704);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 8)
    {
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, paramInt * 32, arrayOfByte, paramInt * 2 * 32, paramArrayOfByte3, 768);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 4)
    {
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, paramInt * 32, arrayOfByte, paramInt * 2 * 32, paramArrayOfByte3, 832);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 2)
    {
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, paramInt * 32, arrayOfByte, paramInt * 2 * 32, paramArrayOfByte3, 896);
      paramInt += 1;
    }
    paramHashFunctions.hash_2n_n_mask(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte3, 960);
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\Horst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */