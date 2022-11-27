package org.bouncycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.Digest;

public class WinternitzOTSignature
{
  private int checksumsize;
  private GMSSRandom gmssRandom;
  private int keysize;
  private int mdsize;
  private Digest messDigestOTS;
  private int messagesize;
  private byte[][] privateKeyOTS;
  private int w;
  
  public WinternitzOTSignature(byte[] paramArrayOfByte, Digest paramDigest, int paramInt)
  {
    this.w = paramInt;
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    int i = this.messDigestOTS.getDigestSize();
    this.mdsize = i;
    double d1 = i << 3;
    double d2 = paramInt;
    i = (int)Math.ceil(d1 / d2);
    this.messagesize = i;
    paramInt = getLog((i << paramInt) + 1);
    this.checksumsize = paramInt;
    i = this.messagesize + (int)Math.ceil(paramInt / d2);
    this.keysize = i;
    int j = this.mdsize;
    paramInt = 0;
    this.privateKeyOTS = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { i, j }));
    i = this.mdsize;
    paramDigest = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, paramDigest, 0, i);
    while (paramInt < this.keysize)
    {
      this.privateKeyOTS[paramInt] = this.gmssRandom.nextSeed(paramDigest);
      paramInt += 1;
    }
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
  
  public byte[][] getPrivateKey()
  {
    return this.privateKeyOTS;
  }
  
  public byte[] getPublicKey()
  {
    int j = this.keysize;
    int i = this.mdsize;
    int k = j * i;
    byte[] arrayOfByte = new byte[k];
    Object localObject = new byte[i];
    int m = this.w;
    i = 0;
    while (i < this.keysize)
    {
      localObject = this.messDigestOTS;
      byte[][] arrayOfByte1 = this.privateKeyOTS;
      ((Digest)localObject).update(arrayOfByte1[i], 0, arrayOfByte1[i].length);
      localObject = new byte[this.messDigestOTS.getDigestSize()];
      this.messDigestOTS.doFinal((byte[])localObject, 0);
      j = 2;
      while (j < 1 << m)
      {
        this.messDigestOTS.update((byte[])localObject, 0, localObject.length);
        localObject = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal((byte[])localObject, 0);
        j += 1;
      }
      j = this.mdsize;
      System.arraycopy(localObject, 0, arrayOfByte, j * i, j);
      i += 1;
    }
    this.messDigestOTS.update(arrayOfByte, 0, k);
    localObject = new byte[this.messDigestOTS.getDigestSize()];
    this.messDigestOTS.doFinal((byte[])localObject, 0);
    return (byte[])localObject;
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    int i = this.keysize;
    int j = this.mdsize;
    byte[] arrayOfByte2 = new byte[i * j];
    byte[] arrayOfByte1 = new byte[j];
    this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    int i4 = this.messDigestOTS.getDigestSize();
    byte[] arrayOfByte3 = new byte[i4];
    this.messDigestOTS.doFinal(arrayOfByte3, 0);
    int i3 = this.w;
    int i2;
    int m;
    int k;
    int i1;
    int n;
    if (8 % i3 == 0)
    {
      int i5 = 8 / i3;
      i2 = (1 << i3) - 1;
      paramArrayOfByte = new byte[this.mdsize];
      j = 0;
      m = 0;
      i = 0;
      while (j < i4)
      {
        k = 0;
        while (k < i5)
        {
          i1 = arrayOfByte3[j] & i2;
          n = m + i1;
          System.arraycopy(this.privateKeyOTS[i], 0, paramArrayOfByte, 0, this.mdsize);
          m = i1;
          while (m > 0)
          {
            this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
            paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(paramArrayOfByte, 0);
            m -= 1;
          }
          m = this.mdsize;
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i * m, m);
          arrayOfByte3[j] = ((byte)(arrayOfByte3[j] >>> this.w));
          i += 1;
          k += 1;
          m = n;
        }
        j += 1;
      }
      k = (this.messagesize << this.w) - m;
      m = 0;
      j = i;
      i = m;
      while (i < this.checksumsize)
      {
        m = k & i2;
        System.arraycopy(this.privateKeyOTS[j], 0, paramArrayOfByte, 0, this.mdsize);
        while (m > 0)
        {
          this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte, 0);
          m -= 1;
        }
        m = this.mdsize;
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, j * m, m);
        m = this.w;
        k >>>= m;
        j += 1;
        i += m;
      }
    }
    long l;
    if (i3 < 8)
    {
      i = this.mdsize;
      n = i / i3;
      i4 = (1 << i3) - 1;
      paramArrayOfByte = new byte[i];
      m = 0;
      k = 0;
      i = 0;
      for (j = 0; m < n; j = i1)
      {
        i1 = 0;
        l = 0L;
        while (i1 < this.w)
        {
          l ^= (arrayOfByte3[k] & 0xFF) << (i1 << 3);
          k += 1;
          i1 += 1;
        }
        i2 = 0;
        i1 = j;
        j = i2;
        while (j < 8)
        {
          i3 = (int)(l & i4);
          i2 = i1 + i3;
          System.arraycopy(this.privateKeyOTS[i], 0, paramArrayOfByte, 0, this.mdsize);
          i1 = i3;
          while (i1 > 0)
          {
            this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
            paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(paramArrayOfByte, 0);
            i1 -= 1;
          }
          i1 = this.mdsize;
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i * i1, i1);
          l >>>= this.w;
          i += 1;
          j += 1;
          i1 = i2;
        }
        m += 1;
      }
      i1 = this.mdsize % this.w;
      m = 0;
      l = 0L;
      n = k;
      k = i1;
      while (m < k)
      {
        l ^= (arrayOfByte3[n] & 0xFF) << (m << 3);
        n += 1;
        m += 1;
      }
      n = 0;
      m = j;
      j = n;
      while (j < k << 3)
      {
        i1 = (int)(i4 & l);
        n = m + i1;
        System.arraycopy(this.privateKeyOTS[i], 0, paramArrayOfByte, 0, this.mdsize);
        m = i1;
        while (m > 0)
        {
          this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte, 0);
          m -= 1;
        }
        m = this.mdsize;
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i * m, m);
        m = this.w;
        l >>>= m;
        i += 1;
        j += m;
        m = n;
      }
      k = (this.messagesize << this.w) - m;
      m = 0;
      j = i;
      i = m;
      while (i < this.checksumsize)
      {
        m = k & i4;
        System.arraycopy(this.privateKeyOTS[j], 0, paramArrayOfByte, 0, this.mdsize);
        while (m > 0)
        {
          this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte, 0);
          m -= 1;
        }
        m = this.mdsize;
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, j * m, m);
        m = this.w;
        k >>>= m;
        j += 1;
        i += m;
      }
    }
    if (i3 < 57)
    {
      i4 = this.mdsize;
      i2 = (1 << i3) - 1;
      paramArrayOfByte = new byte[i4];
      j = 0;
      k = 0;
      i = 0;
      for (;;)
      {
        n = k;
        if (n > (i4 << 3) - i3) {
          break;
        }
        k = n >>> 3;
        i1 = n + this.w;
        m = 0;
        l = 0L;
        while (k < i1 + 7 >>> 3)
        {
          l ^= (arrayOfByte3[k] & 0xFF) << (m << 3);
          m += 1;
          k += 1;
        }
        l = l >>> n % 8 & i2;
        j = (int)(j + l);
        System.arraycopy(this.privateKeyOTS[i], 0, paramArrayOfByte, 0, this.mdsize);
        while (l > 0L)
        {
          this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte, 0);
          l -= 1L;
        }
        k = this.mdsize;
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i * k, k);
        i += 1;
        k = i1;
      }
      i1 = n >>> 3;
      arrayOfByte1 = paramArrayOfByte;
      m = j;
      k = i;
      if (i1 < this.mdsize)
      {
        m = 0;
        l = 0L;
        k = i1;
        for (;;)
        {
          i1 = this.mdsize;
          if (k >= i1) {
            break;
          }
          l ^= (arrayOfByte3[k] & 0xFF) << (m << 3);
          m += 1;
          k += 1;
        }
        l = l >>> n % 8 & i2;
        m = (int)(j + l);
        System.arraycopy(this.privateKeyOTS[i], 0, paramArrayOfByte, 0, i1);
        while (l > 0L)
        {
          this.messDigestOTS.update(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramArrayOfByte = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(paramArrayOfByte, 0);
          l -= 1L;
        }
        j = this.mdsize;
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i * j, j);
        k = i + 1;
        arrayOfByte1 = paramArrayOfByte;
      }
      m = (this.messagesize << this.w) - m;
      j = k;
      i = 0;
      k = m;
      while (i < this.checksumsize)
      {
        l = k & i2;
        System.arraycopy(this.privateKeyOTS[j], 0, arrayOfByte1, 0, this.mdsize);
        while (l > 0L)
        {
          this.messDigestOTS.update(arrayOfByte1, 0, arrayOfByte1.length);
          arrayOfByte1 = new byte[this.messDigestOTS.getDigestSize()];
          this.messDigestOTS.doFinal(arrayOfByte1, 0);
          l -= 1L;
        }
        m = this.mdsize;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, j * m, m);
        m = this.w;
        k >>>= m;
        j += 1;
        i += m;
      }
    }
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gms\\util\WinternitzOTSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */