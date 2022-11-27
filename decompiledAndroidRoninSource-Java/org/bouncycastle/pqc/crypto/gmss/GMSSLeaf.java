package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

public class GMSSLeaf
{
  private byte[] concHashs;
  private GMSSRandom gmssRandom;
  private int i;
  private int j;
  private int keysize;
  private byte[] leaf;
  private int mdsize;
  private Digest messDigestOTS;
  byte[] privateKeyOTS;
  private byte[] seed;
  private int steps;
  private int two_power_w;
  private int w;
  
  GMSSLeaf(Digest paramDigest, int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    int k = this.messDigestOTS.getDigestSize();
    this.mdsize = k;
    double d1 = k << 3;
    double d2 = paramInt1;
    k = (int)Math.ceil(d1 / d2);
    k += (int)Math.ceil(getLog((k << paramInt1) + 1) / d2);
    this.keysize = k;
    paramInt1 = 1 << paramInt1;
    this.two_power_w = paramInt1;
    this.steps = ((int)Math.ceil(((paramInt1 - 1) * k + 1 + k) / paramInt2));
    paramInt1 = this.mdsize;
    this.seed = new byte[paramInt1];
    this.leaf = new byte[paramInt1];
    this.privateKeyOTS = new byte[paramInt1];
    this.concHashs = new byte[paramInt1 * this.keysize];
  }
  
  public GMSSLeaf(Digest paramDigest, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.w = paramInt1;
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    int k = this.messDigestOTS.getDigestSize();
    this.mdsize = k;
    double d1 = k << 3;
    double d2 = paramInt1;
    k = (int)Math.ceil(d1 / d2);
    k += (int)Math.ceil(getLog((k << paramInt1) + 1) / d2);
    this.keysize = k;
    paramInt1 = 1 << paramInt1;
    this.two_power_w = paramInt1;
    this.steps = ((int)Math.ceil(((paramInt1 - 1) * k + 1 + k) / paramInt2));
    paramInt1 = this.mdsize;
    this.seed = new byte[paramInt1];
    this.leaf = new byte[paramInt1];
    this.privateKeyOTS = new byte[paramInt1];
    this.concHashs = new byte[paramInt1 * this.keysize];
    initLeafCalc(paramArrayOfByte);
  }
  
  public GMSSLeaf(Digest paramDigest, byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.i = paramArrayOfInt[0];
    this.j = paramArrayOfInt[1];
    this.steps = paramArrayOfInt[2];
    this.w = paramArrayOfInt[3];
    this.messDigestOTS = paramDigest;
    this.gmssRandom = new GMSSRandom(paramDigest);
    int k = this.messDigestOTS.getDigestSize();
    this.mdsize = k;
    k = (int)Math.ceil((k << 3) / this.w);
    this.keysize = (k + (int)Math.ceil(getLog((k << this.w) + 1) / this.w));
    this.two_power_w = (1 << this.w);
    this.privateKeyOTS = paramArrayOfByte[0];
    this.seed = paramArrayOfByte[1];
    this.concHashs = paramArrayOfByte[2];
    this.leaf = paramArrayOfByte[3];
  }
  
  private GMSSLeaf(GMSSLeaf paramGMSSLeaf)
  {
    this.messDigestOTS = paramGMSSLeaf.messDigestOTS;
    this.mdsize = paramGMSSLeaf.mdsize;
    this.keysize = paramGMSSLeaf.keysize;
    this.gmssRandom = paramGMSSLeaf.gmssRandom;
    this.leaf = Arrays.clone(paramGMSSLeaf.leaf);
    this.concHashs = Arrays.clone(paramGMSSLeaf.concHashs);
    this.i = paramGMSSLeaf.i;
    this.j = paramGMSSLeaf.j;
    this.two_power_w = paramGMSSLeaf.two_power_w;
    this.w = paramGMSSLeaf.w;
    this.steps = paramGMSSLeaf.steps;
    this.seed = Arrays.clone(paramGMSSLeaf.seed);
    this.privateKeyOTS = Arrays.clone(paramGMSSLeaf.privateKeyOTS);
  }
  
  private int getLog(int paramInt)
  {
    int k = 1;
    int m = 2;
    while (m < paramInt)
    {
      m <<= 1;
      k += 1;
    }
    return k;
  }
  
  private void updateLeafCalc()
  {
    Object localObject1 = new byte[this.messDigestOTS.getDigestSize()];
    int k = 0;
    while (k < this.steps + 10000)
    {
      Object localObject2;
      if ((this.i == this.keysize) && (this.j == this.two_power_w - 1))
      {
        localObject1 = this.messDigestOTS;
        localObject2 = this.concHashs;
        ((Digest)localObject1).update((byte[])localObject2, 0, localObject2.length);
        localObject1 = new byte[this.messDigestOTS.getDigestSize()];
        this.leaf = ((byte[])localObject1);
        this.messDigestOTS.doFinal((byte[])localObject1, 0);
        return;
      }
      if ((this.i != 0) && (this.j != this.two_power_w - 1))
      {
        localObject2 = this.messDigestOTS;
        byte[] arrayOfByte = this.privateKeyOTS;
        ((Digest)localObject2).update(arrayOfByte, 0, arrayOfByte.length);
        this.privateKeyOTS = ((byte[])localObject1);
        this.messDigestOTS.doFinal((byte[])localObject1, 0);
        int m = this.j + 1;
        this.j = m;
        if (m == this.two_power_w - 1)
        {
          localObject2 = this.privateKeyOTS;
          arrayOfByte = this.concHashs;
          m = this.mdsize;
          System.arraycopy(localObject2, 0, arrayOfByte, (this.i - 1) * m, m);
        }
      }
      else
      {
        this.i += 1;
        this.j = 0;
        this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
      }
      k += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unable to updateLeaf in steps: ");
    ((StringBuilder)localObject1).append(this.steps);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(this.j);
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  public byte[] getLeaf()
  {
    return Arrays.clone(this.leaf);
  }
  
  public byte[][] getStatByte()
  {
    byte[][] arrayOfByte = new byte[4][];
    int k = this.mdsize;
    arrayOfByte[0] = new byte[k];
    arrayOfByte[1] = new byte[k];
    arrayOfByte[2] = new byte[this.keysize * k];
    arrayOfByte[3] = new byte[k];
    arrayOfByte[0] = this.privateKeyOTS;
    arrayOfByte[1] = this.seed;
    arrayOfByte[2] = this.concHashs;
    arrayOfByte[3] = this.leaf;
    return arrayOfByte;
  }
  
  public int[] getStatInt()
  {
    return new int[] { this.i, this.j, this.steps, this.w };
  }
  
  void initLeafCalc(byte[] paramArrayOfByte)
  {
    this.i = 0;
    this.j = 0;
    byte[] arrayOfByte = new byte[this.mdsize];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, this.seed.length);
    this.seed = this.gmssRandom.nextSeed(arrayOfByte);
  }
  
  GMSSLeaf nextLeaf()
  {
    GMSSLeaf localGMSSLeaf = new GMSSLeaf(this);
    localGMSSLeaf.updateLeafCalc();
    return localGMSSLeaf;
  }
  
  public String toString()
  {
    int m = 0;
    Object localObject = "";
    int k = 0;
    while (k < 4)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(getStatInt()[k]);
      localStringBuilder.append(" ");
      localObject = localStringBuilder.toString();
      k += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.mdsize);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.keysize);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.two_power_w);
    localStringBuilder.append(" ");
    localObject = localStringBuilder.toString();
    byte[][] arrayOfByte = getStatByte();
    k = m;
    while (k < 4)
    {
      if (arrayOfByte[k] != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(new String(Hex.encode(arrayOfByte[k])));
        localStringBuilder.append(" ");
        localObject = localStringBuilder;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("null ");
        localObject = localStringBuilder;
      }
      localObject = ((StringBuilder)localObject).toString();
      k += 1;
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSLeaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */