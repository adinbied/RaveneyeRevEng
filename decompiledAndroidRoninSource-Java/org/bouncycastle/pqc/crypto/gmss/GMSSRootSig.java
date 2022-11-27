package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootSig
{
  private long big8;
  private int checksum;
  private int counter;
  private GMSSRandom gmssRandom;
  private byte[] hash;
  private int height;
  private int ii;
  private int k;
  private int keysize;
  private int mdsize;
  private Digest messDigestOTS;
  private int messagesize;
  private byte[] privateKeyOTS;
  private int r;
  private byte[] seed;
  private byte[] sign;
  private int steps;
  private int test;
  private long test8;
  private int w;
  
  public GMSSRootSig(Digest paramDigest, int paramInt1, int paramInt2)
  {
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    int i = this.messDigestOTS.getDigestSize();
    this.mdsize = i;
    this.w = paramInt1;
    this.height = paramInt2;
    this.k = ((1 << paramInt1) - 1);
    this.messagesize = ((int)Math.ceil((i << 3) / paramInt1));
  }
  
  public GMSSRootSig(Digest paramDigest, byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    this.counter = paramArrayOfInt[0];
    this.test = paramArrayOfInt[1];
    this.ii = paramArrayOfInt[2];
    this.r = paramArrayOfInt[3];
    this.steps = paramArrayOfInt[4];
    this.keysize = paramArrayOfInt[5];
    this.height = paramArrayOfInt[6];
    this.w = paramArrayOfInt[7];
    this.checksum = paramArrayOfInt[8];
    int i = this.messDigestOTS.getDigestSize();
    this.mdsize = i;
    int j = this.w;
    this.k = ((1 << j) - 1);
    this.messagesize = ((int)Math.ceil((i << 3) / j));
    this.privateKeyOTS = paramArrayOfByte[0];
    this.seed = paramArrayOfByte[1];
    this.hash = paramArrayOfByte[2];
    this.sign = paramArrayOfByte[3];
    long l = paramArrayOfByte[4][0] & 0xFF;
    this.test8 = ((paramArrayOfByte[4][1] & 0xFF) << 8 | l | (paramArrayOfByte[4][2] & 0xFF) << 16 | (paramArrayOfByte[4][3] & 0xFF) << 24 | (paramArrayOfByte[4][4] & 0xFF) << 32 | (paramArrayOfByte[4][5] & 0xFF) << 40 | (paramArrayOfByte[4][6] & 0xFF) << 48 | (paramArrayOfByte[4][7] & 0xFF) << 56);
    this.big8 = (paramArrayOfByte[4][8] & 0xFF | (paramArrayOfByte[4][9] & 0xFF) << 8 | (paramArrayOfByte[4][10] & 0xFF) << 16 | (paramArrayOfByte[4][11] & 0xFF) << 24 | (paramArrayOfByte[4][12] & 0xFF) << 32 | (paramArrayOfByte[4][13] & 0xFF) << 40 | (paramArrayOfByte[4][14] & 0xFF) << 48 | (paramArrayOfByte[4][15] & 0xFF) << 56);
  }
  
  private void oneStep()
  {
    int n = this.w;
    int i;
    Object localObject;
    byte[] arrayOfByte;
    int j;
    if (8 % n == 0)
    {
      i = this.test;
      if (i == 0)
      {
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
        i = this.ii;
        if (i < this.mdsize)
        {
          localObject = this.hash;
          this.test = (localObject[i] & this.k);
          localObject[i] = ((byte)(localObject[i] >>> this.w));
        }
        else
        {
          i = this.checksum;
          this.test = (this.k & i);
          this.checksum = (i >>> this.w);
        }
      }
      else if (i > 0)
      {
        localObject = this.messDigestOTS;
        arrayOfByte = this.privateKeyOTS;
        ((Digest)localObject).update(arrayOfByte, 0, arrayOfByte.length);
        localObject = new byte[this.messDigestOTS.getDigestSize()];
        this.privateKeyOTS = ((byte[])localObject);
        this.messDigestOTS.doFinal((byte[])localObject, 0);
        this.test -= 1;
      }
      if (this.test == 0)
      {
        localObject = this.privateKeyOTS;
        arrayOfByte = this.sign;
        i = this.counter;
        j = this.mdsize;
        System.arraycopy(localObject, 0, arrayOfByte, i * j, j);
        i = this.counter + 1;
        this.counter = i;
        if (i % (8 / this.w) == 0) {
          this.ii += 1;
        }
      }
    }
    else
    {
      int m;
      long l;
      if (n < 8)
      {
        i = this.test;
        if (i == 0)
        {
          i = this.counter;
          if (i % 8 == 0)
          {
            j = this.ii;
            m = this.mdsize;
            if (j < m)
            {
              this.big8 = 0L;
              if (i < m / n << 3)
              {
                i = 0;
                while (i < this.w)
                {
                  l = this.big8;
                  localObject = this.hash;
                  j = this.ii;
                  this.big8 = (l ^ (localObject[j] & 0xFF) << (i << 3));
                  this.ii = (j + 1);
                  i += 1;
                }
              }
              i = 0;
              while (i < this.mdsize % this.w)
              {
                l = this.big8;
                localObject = this.hash;
                j = this.ii;
                this.big8 = (l ^ (localObject[j] & 0xFF) << (i << 3));
                this.ii = (j + 1);
                i += 1;
              }
            }
          }
          if (this.counter == this.messagesize) {
            this.big8 = this.checksum;
          }
          this.test = ((int)(this.big8 & this.k));
          this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
        }
        else if (i > 0)
        {
          localObject = this.messDigestOTS;
          arrayOfByte = this.privateKeyOTS;
          ((Digest)localObject).update(arrayOfByte, 0, arrayOfByte.length);
          localObject = new byte[this.messDigestOTS.getDigestSize()];
          this.privateKeyOTS = ((byte[])localObject);
          this.messDigestOTS.doFinal((byte[])localObject, 0);
          this.test -= 1;
        }
        if (this.test == 0)
        {
          localObject = this.privateKeyOTS;
          arrayOfByte = this.sign;
          i = this.counter;
          j = this.mdsize;
          System.arraycopy(localObject, 0, arrayOfByte, i * j, j);
          this.big8 >>>= this.w;
        }
      }
      else
      {
        for (;;)
        {
          this.counter += 1;
          return;
          if (n >= 57) {
            break;
          }
          l = this.test8;
          if (l == 0L)
          {
            this.big8 = 0L;
            this.ii = 0;
            m = this.r;
            j = m >>> 3;
            i = this.mdsize;
            if (j < i)
            {
              if (m <= (i << 3) - n)
              {
                i = m + n;
                this.r = i;
                i = i + 7 >>> 3;
              }
              else
              {
                this.r = (m + n);
              }
              for (;;)
              {
                l = this.big8;
                if (j >= i) {
                  break;
                }
                n = this.hash[j];
                int i1 = this.ii;
                this.big8 = (l ^ (n & 0xFF) << (i1 << 3));
                this.ii = (i1 + 1);
                j += 1;
              }
              l >>>= m % 8;
              this.big8 = l;
              this.test8 = (l & this.k);
            }
            else
            {
              i = this.checksum;
              this.test8 = (this.k & i);
              this.checksum = (i >>> n);
            }
            this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
          }
          else if (l > 0L)
          {
            localObject = this.messDigestOTS;
            arrayOfByte = this.privateKeyOTS;
            ((Digest)localObject).update(arrayOfByte, 0, arrayOfByte.length);
            localObject = new byte[this.messDigestOTS.getDigestSize()];
            this.privateKeyOTS = ((byte[])localObject);
            this.messDigestOTS.doFinal((byte[])localObject, 0);
            this.test8 -= 1L;
          }
          if (this.test8 != 0L) {
            break;
          }
          localObject = this.privateKeyOTS;
          arrayOfByte = this.sign;
          i = this.counter;
          j = this.mdsize;
          System.arraycopy(localObject, 0, arrayOfByte, i * j, j);
        }
      }
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
  
  public byte[] getSig()
  {
    return this.sign;
  }
  
  public byte[][] getStatByte()
  {
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, this.mdsize });
    arrayOfByte[0] = this.privateKeyOTS;
    arrayOfByte[1] = this.seed;
    arrayOfByte[2] = this.hash;
    arrayOfByte[3] = this.sign;
    arrayOfByte[4] = getStatLong();
    return arrayOfByte;
  }
  
  public int[] getStatInt()
  {
    return new int[] { this.counter, this.test, this.ii, this.r, this.steps, this.keysize, this.height, this.w, this.checksum };
  }
  
  public byte[] getStatLong()
  {
    long l = this.test8;
    int i = (byte)(int)(l & 0xFF);
    int j = (byte)(int)(l >> 8 & 0xFF);
    int m = (byte)(int)(l >> 16 & 0xFF);
    int n = (byte)(int)(l >> 24 & 0xFF);
    int i1 = (byte)(int)(l >> 32 & 0xFF);
    int i2 = (byte)(int)(l >> 40 & 0xFF);
    int i3 = (byte)(int)(l >> 48 & 0xFF);
    int i4 = (byte)(int)(l >> 56 & 0xFF);
    l = this.big8;
    return new byte[] { i, j, m, n, i1, i2, i3, i4, (byte)(int)(l & 0xFF), (byte)(int)(l >> 8 & 0xFF), (byte)(int)(l >> 16 & 0xFF), (byte)(int)(l >> 24 & 0xFF), (byte)(int)(l >> 32 & 0xFF), (byte)(int)(l >> 40 & 0xFF), (byte)(int)(l >> 48 & 0xFF), (byte)(int)(l >> 56 & 0xFF) };
  }
  
  public void initSign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.hash = new byte[this.mdsize];
    this.messDigestOTS.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramArrayOfByte2 = new byte[this.messDigestOTS.getDigestSize()];
    this.hash = paramArrayOfByte2;
    this.messDigestOTS.doFinal(paramArrayOfByte2, 0);
    int i = this.mdsize;
    paramArrayOfByte2 = new byte[i];
    System.arraycopy(this.hash, 0, paramArrayOfByte2, 0, i);
    int i2 = getLog((this.messagesize << this.w) + 1);
    i = this.w;
    int n;
    int m;
    if (8 % i == 0)
    {
      n = 8 / i;
      j = 0;
      i = 0;
      while (j < this.mdsize)
      {
        m = 0;
        while (m < n)
        {
          i += (paramArrayOfByte2[j] & this.k);
          paramArrayOfByte2[j] = ((byte)(paramArrayOfByte2[j] >>> this.w));
          m += 1;
        }
        j += 1;
      }
      n = (this.messagesize << this.w) - i;
      this.checksum = n;
      m = 0;
      j = i;
      for (;;)
      {
        i = j;
        if (m >= i2) {
          break;
        }
        j += (this.k & n);
        i = this.w;
        n >>>= i;
        m += i;
      }
    }
    int i1;
    long l;
    if (i < 8)
    {
      n = this.mdsize / i;
      m = 0;
      j = 0;
      i = 0;
      while (m < n)
      {
        i1 = 0;
        l = 0L;
        while (i1 < this.w)
        {
          l ^= (paramArrayOfByte2[j] & 0xFF) << (i1 << 3);
          j += 1;
          i1 += 1;
        }
        i1 = 0;
        while (i1 < 8)
        {
          i += (int)(this.k & l);
          l >>>= this.w;
          i1 += 1;
        }
        m += 1;
      }
      i1 = this.mdsize % this.w;
      n = 0;
      l = 0L;
      m = j;
      j = n;
      while (j < i1)
      {
        l ^= (paramArrayOfByte2[m] & 0xFF) << (j << 3);
        m += 1;
        j += 1;
      }
      j = 0;
      while (j < i1 << 3)
      {
        i += (int)(this.k & l);
        m = this.w;
        l >>>= m;
        j += m;
      }
      n = (this.messagesize << this.w) - i;
      this.checksum = n;
      m = 0;
      j = i;
      for (;;)
      {
        i = j;
        if (m >= i2) {
          break;
        }
        j += (this.k & n);
        i = this.w;
        n >>>= i;
        m += i;
      }
    }
    if (i < 57)
    {
      j = 0;
      i = 0;
      for (;;)
      {
        n = j;
        i1 = this.mdsize;
        m = this.w;
        if (n > (i1 << 3) - m) {
          break;
        }
        j = n >>> 3;
        i1 = n + m;
        l = 0L;
        m = 0;
        while (j < i1 + 7 >>> 3)
        {
          l ^= (paramArrayOfByte2[j] & 0xFF) << (m << 3);
          m += 1;
          j += 1;
        }
        i = (int)(i + (l >>> n % 8 & this.k));
        j = i1;
      }
      m = n >>> 3;
      j = i;
      if (m < i1)
      {
        i1 = 0;
        l = 0L;
        j = m;
        m = i1;
        while (j < this.mdsize)
        {
          l ^= (paramArrayOfByte2[j] & 0xFF) << (m << 3);
          m += 1;
          j += 1;
        }
        j = (int)(i + (l >>> n % 8 & this.k));
      }
      n = (this.messagesize << this.w) - j;
      this.checksum = n;
      m = 0;
      for (;;)
      {
        i = j;
        if (m >= i2) {
          break;
        }
        j += (this.k & n);
        i = this.w;
        n >>>= i;
        m += i;
      }
    }
    i = 0;
    int j = this.messagesize + (int)Math.ceil(i2 / this.w);
    this.keysize = j;
    this.steps = ((int)Math.ceil((j + i) / (1 << this.height)));
    i = this.keysize;
    j = this.mdsize;
    this.sign = new byte[i * j];
    this.counter = 0;
    this.test = 0;
    this.ii = 0;
    this.test8 = 0L;
    this.r = 0;
    this.privateKeyOTS = new byte[j];
    paramArrayOfByte2 = new byte[j];
    this.seed = paramArrayOfByte2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, j);
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.big8);
    ((StringBuilder)localObject1).append("  ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int[] arrayOfInt = getStatInt();
    int i = this.mdsize;
    int m = 0;
    Object localObject2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 5, i });
    byte[][] arrayOfByte = getStatByte();
    i = 0;
    int j;
    for (;;)
    {
      localObject2 = localObject1;
      j = m;
      if (i >= 9) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(arrayOfInt[i]);
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    while (j < 5)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(new String(Hex.encode(arrayOfByte[j])));
      ((StringBuilder)localObject1).append(" ");
      localObject2 = ((StringBuilder)localObject1).toString();
      j += 1;
    }
    return (String)localObject2;
  }
  
  public boolean updateSign()
  {
    int i = 0;
    while (i < this.steps)
    {
      if (this.counter < this.keysize) {
        oneStep();
      }
      if (this.counter == this.keysize) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSRootSig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */