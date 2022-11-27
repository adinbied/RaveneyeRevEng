package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Pack;

class Poly
{
  static void add(short[] paramArrayOfShort1, short[] paramArrayOfShort2, short[] paramArrayOfShort3)
  {
    int i = 0;
    while (i < 1024)
    {
      paramArrayOfShort3[i] = Reduce.barrett((short)(paramArrayOfShort1[i] + paramArrayOfShort2[i]));
      i += 1;
    }
  }
  
  static void fromBytes(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 256)
    {
      int i3 = i * 7;
      int j = paramArrayOfByte[(i3 + 0)];
      int k = paramArrayOfByte[(i3 + 1)] & 0xFF;
      int m = paramArrayOfByte[(i3 + 2)];
      int n = paramArrayOfByte[(i3 + 3)] & 0xFF;
      int i1 = paramArrayOfByte[(i3 + 4)];
      int i2 = paramArrayOfByte[(i3 + 5)] & 0xFF;
      i3 = paramArrayOfByte[(i3 + 6)];
      int i4 = i * 4;
      paramArrayOfShort[(i4 + 0)] = ((short)(j & 0xFF | (k & 0x3F) << 8));
      paramArrayOfShort[(i4 + 1)] = ((short)(k >>> 6 | (m & 0xFF) << 2 | (n & 0xF) << 10));
      paramArrayOfShort[(i4 + 2)] = ((short)(n >>> 4 | (i1 & 0xFF) << 4 | (i2 & 0x3) << 12));
      paramArrayOfShort[(i4 + 3)] = ((short)((i3 & 0xFF) << 6 | i2 >>> 2));
      i += 1;
    }
  }
  
  static void fromNTT(short[] paramArrayOfShort)
  {
    NTT.bitReverse(paramArrayOfShort);
    NTT.core(paramArrayOfShort, Precomp.OMEGAS_INV_MONTGOMERY);
    NTT.mulCoefficients(paramArrayOfShort, Precomp.PSIS_INV_MONTGOMERY);
  }
  
  static void getNoise(short[] paramArrayOfShort, byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte1 = new byte[8];
    arrayOfByte1[0] = paramByte;
    byte[] arrayOfByte2 = new byte['က'];
    ChaCha20.process(paramArrayOfByte, arrayOfByte1, arrayOfByte2, 0, 4096);
    int i = 0;
    while (i < 1024)
    {
      int m = Pack.bigEndianToInt(arrayOfByte2, i * 4);
      int j = 0;
      int k = 0;
      while (j < 8)
      {
        k += (m >> j & 0x1010101);
        j += 1;
      }
      paramArrayOfShort[i] = ((short)(((k >>> 24) + (k >>> 0) & 0xFF) + 12289 - ((k >>> 16) + (k >>> 8) & 0xFF)));
      i += 1;
    }
  }
  
  private static short normalize(short paramShort)
  {
    int i = Reduce.barrett(paramShort);
    int j = i - 12289;
    return (short)((i ^ j) & j >> 31 ^ j);
  }
  
  static void pointWise(short[] paramArrayOfShort1, short[] paramArrayOfShort2, short[] paramArrayOfShort3)
  {
    int i = 0;
    while (i < 1024)
    {
      paramArrayOfShort3[i] = Reduce.montgomery((paramArrayOfShort1[i] & 0xFFFF) * (0xFFFF & Reduce.montgomery((paramArrayOfShort2[i] & 0xFFFF) * 3186)));
      i += 1;
    }
  }
  
  static void toBytes(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < 256)
    {
      int n = i * 4;
      int j = normalize(paramArrayOfShort[(n + 0)]);
      int k = normalize(paramArrayOfShort[(n + 1)]);
      int m = normalize(paramArrayOfShort[(n + 2)]);
      n = normalize(paramArrayOfShort[(n + 3)]);
      int i1 = i * 7;
      paramArrayOfByte[(i1 + 0)] = ((byte)j);
      paramArrayOfByte[(i1 + 1)] = ((byte)(j >> 8 | k << 6));
      paramArrayOfByte[(i1 + 2)] = ((byte)(k >> 2));
      paramArrayOfByte[(i1 + 3)] = ((byte)(k >> 10 | m << 4));
      paramArrayOfByte[(i1 + 4)] = ((byte)(m >> 4));
      paramArrayOfByte[(i1 + 5)] = ((byte)(m >> 12 | n << 2));
      paramArrayOfByte[(i1 + 6)] = ((byte)(n >> 6));
      i += 1;
    }
  }
  
  static void toNTT(short[] paramArrayOfShort)
  {
    NTT.mulCoefficients(paramArrayOfShort, Precomp.PSIS_BITREV_MONTGOMERY);
    NTT.core(paramArrayOfShort, Precomp.OMEGAS_MONTGOMERY);
  }
  
  static void uniform(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    SHAKEDigest localSHAKEDigest = new SHAKEDigest(128);
    localSHAKEDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    int k = 0;
    paramArrayOfByte = new byte['Ā'];
    localSHAKEDigest.doOutput(paramArrayOfByte, 0, 256);
    int i = 0;
    for (int j = k;; j = k)
    {
      k = j;
      if (i >= 256) {
        break;
      }
      int m = (paramArrayOfByte[i] & 0xFF | (paramArrayOfByte[(i + 1)] & 0xFF) << 8) & 0x3FFF;
      k = j;
      if (m < 12289)
      {
        k = j + 1;
        paramArrayOfShort[j] = ((short)m);
        if (k == 1024) {
          return;
        }
      }
      i += 2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\Poly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */