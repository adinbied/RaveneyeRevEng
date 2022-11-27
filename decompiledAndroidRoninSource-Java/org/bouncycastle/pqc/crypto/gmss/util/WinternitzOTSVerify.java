package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class WinternitzOTSVerify
{
  private Digest messDigestOTS;
  private int w;
  
  public WinternitzOTSVerify(Digest paramDigest, int paramInt)
  {
    this.w = paramInt;
    this.messDigestOTS = paramDigest;
  }
  
  public byte[] Verify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte1 = paramArrayOfByte2;
    int i7 = this.messDigestOTS.getDigestSize();
    byte[] arrayOfByte2 = new byte[i7];
    this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    int i3 = this.messDigestOTS.getDigestSize();
    byte[] arrayOfByte3 = new byte[i3];
    this.messDigestOTS.doFinal(arrayOfByte3, 0);
    int m = i7 << 3;
    int i = this.w;
    int i5 = (i - 1 + m) / i;
    int i4 = getLog((i5 << i) + 1);
    int k = this.w;
    int j = ((i4 + k - 1) / k + i5) * i7;
    if (j != arrayOfByte1.length) {
      return null;
    }
    arrayOfByte2 = new byte[j];
    int i1;
    int i8;
    int i6;
    int n;
    if (8 % k == 0)
    {
      i1 = 8 / k;
      i8 = (1 << k) - 1;
      paramArrayOfByte1 = new byte[i7];
      k = 0;
      m = 0;
      for (i = 0;; i = n)
      {
        i6 = 0;
        if (k >= i3) {
          break;
        }
        n = i;
        i = m;
        m = i1;
        i2 = j;
        i1 = i6;
        j = i3;
        while (i1 < m)
        {
          i3 = arrayOfByte3[k] & i8;
          i += i3;
          i6 = n * i7;
          System.arraycopy(paramArrayOfByte2, i6, paramArrayOfByte1, 0, i7);
          while (i3 < i8)
          {
            this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
            paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
            i3 += 1;
          }
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i6, i7);
          arrayOfByte3[k] = ((byte)(arrayOfByte3[k] >>> this.w));
          n += 1;
          i1 += 1;
        }
        k += 1;
        i3 = j;
        j = i2;
        i1 = m;
        m = i;
      }
      n = (i5 << this.w) - m;
      k = 0;
      m = i;
      for (;;)
      {
        i = j;
        if (k >= i4) {
          break;
        }
        i = n & i8;
        i1 = m * i7;
        System.arraycopy(paramArrayOfByte2, i1, paramArrayOfByte1, 0, i7);
        while (i < i8)
        {
          this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
          paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
          i += 1;
        }
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i1, i7);
        i = this.w;
        n >>>= i;
        m += 1;
        k += i;
      }
    }
    int i2 = j;
    long l1;
    if (k < 8)
    {
      n = i7 / k;
      i8 = (1 << k) - 1;
      paramArrayOfByte1 = new byte[i7];
      m = 0;
      i = 0;
      j = 0;
      k = 0;
      while (m < n)
      {
        i1 = 0;
        l1 = 0L;
        while (i1 < this.w)
        {
          l1 ^= (arrayOfByte3[i] & 0xFF) << (i1 << 3);
          i += 1;
          i1 += 1;
        }
        i3 = 0;
        i1 = j;
        j = i3;
        while (j < 8)
        {
          i6 = (int)(l1 & i8);
          i3 = i1 + i6;
          int i9 = k * i7;
          System.arraycopy(arrayOfByte1, i9, paramArrayOfByte1, 0, i7);
          i1 = i6;
          while (i1 < i8)
          {
            this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
            paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
            i1 += 1;
          }
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i9, i7);
          l1 >>>= this.w;
          k += 1;
          j += 1;
          i1 = i3;
        }
        m += 1;
        j = i1;
      }
      i1 = i7 % this.w;
      n = 0;
      l1 = 0L;
      m = i;
      i = n;
      while (i < i1)
      {
        l1 ^= (arrayOfByte3[m] & 0xFF) << (i << 3);
        m += 1;
        i += 1;
      }
      i = 0;
      while (i < i1 << 3)
      {
        n = (int)(l1 & i8);
        m = j + n;
        i3 = k * i7;
        System.arraycopy(arrayOfByte1, i3, paramArrayOfByte1, 0, i7);
        j = n;
        while (j < i8)
        {
          this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
          paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
          j += 1;
        }
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i3, i7);
        j = this.w;
        l1 >>>= j;
        k += 1;
        i += j;
        j = m;
      }
      m = (i5 << this.w) - j;
      j = 0;
      for (;;)
      {
        i = i2;
        if (j >= i4) {
          break;
        }
        i = m & i8;
        n = k * i7;
        System.arraycopy(arrayOfByte1, n, paramArrayOfByte1, 0, i7);
        while (i < i8)
        {
          this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
          paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
          i += 1;
        }
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, n, i7);
        i = this.w;
        m >>>= i;
        k += 1;
        j += i;
      }
    }
    i = i2;
    if (k < 57)
    {
      n = m - k;
      i6 = (1 << k) - 1;
      paramArrayOfByte1 = new byte[i7];
      i = 0;
      i1 = 0;
      k = 0;
      m = i5;
      j = i4;
      long l2;
      while (i1 <= n)
      {
        i3 = i1 >>> 3;
        i5 = i1 + this.w;
        i4 = 0;
        l1 = 0L;
        while (i3 < i5 + 7 >>> 3)
        {
          l1 ^= (arrayOfByte3[i3] & 0xFF) << (i4 << 3);
          i4 += 1;
          i3 += 1;
        }
        l2 = i6;
        l1 = l1 >>> i1 % 8 & l2;
        i1 = i5;
        k = (int)(k + l1);
        i3 = i * i7;
        System.arraycopy(arrayOfByte1, i3, paramArrayOfByte1, 0, i7);
        while (l1 < l2)
        {
          this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
          paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
          l1 += 1L;
        }
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i3, i7);
        i += 1;
      }
      i4 = i1 >>> 3;
      paramArrayOfByte2 = paramArrayOfByte1;
      n = i;
      i3 = k;
      if (i4 < i7)
      {
        i3 = 0;
        l1 = 0L;
        n = i4;
        while (n < i7)
        {
          l1 ^= (arrayOfByte3[n] & 0xFF) << (i3 << 3);
          i3 += 1;
          n += 1;
        }
        l2 = i6;
        l1 = l1 >>> i1 % 8 & l2;
        i3 = (int)(k + l1);
        k = i * i7;
        System.arraycopy(arrayOfByte1, k, paramArrayOfByte1, 0, i7);
        while (l1 < l2)
        {
          this.messDigestOTS.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
          paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
          l1 += 1L;
        }
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, k, i7);
        n = i + 1;
        paramArrayOfByte2 = paramArrayOfByte1;
      }
      m = (m << this.w) - i3;
      k = 0;
      for (;;)
      {
        i = i2;
        if (k >= j) {
          break;
        }
        l1 = m & i6;
        i = n * i7;
        System.arraycopy(arrayOfByte1, i, paramArrayOfByte2, 0, i7);
        while (l1 < i6)
        {
          this.messDigestOTS.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
          paramArrayOfByte2 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte2, 0);
          l1 += 1L;
        }
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, i, i7);
        i = this.w;
        m >>>= i;
        n += 1;
        k += i;
      }
    }
    paramArrayOfByte1 = new byte[i7];
    this.messDigestOTS.update(arrayOfByte2, 0, i);
    paramArrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
    this.messDigestOTS.doFinal(paramArrayOfByte1, 0);
    return paramArrayOfByte1;
  }
  
  public int getLog(int paramInt)
  {
    int i = 1;
    int j = 2;
    while (j < paramInt)
    {
      j <<= 1;
      i += 1;
    }
    return i;
  }
  
  public int getSignatureLength()
  {
    int i = this.messDigestOTS.getDigestSize();
    int k = this.w;
    int j = ((i << 3) + (k - 1)) / k;
    k = getLog((j << k) + 1);
    int m = this.w;
    return i * (j + (k + m - 1) / m);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gms\\util\WinternitzOTSVerify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */