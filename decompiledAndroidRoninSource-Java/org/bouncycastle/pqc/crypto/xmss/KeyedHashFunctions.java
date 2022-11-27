package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

public final class KeyedHashFunctions
{
  private final Digest digest;
  private final int digestSize;
  
  protected KeyedHashFunctions(Digest paramDigest, int paramInt)
  {
    if (paramDigest != null)
    {
      this.digest = paramDigest;
      this.digestSize = paramInt;
      return;
    }
    throw new NullPointerException("digest == null");
  }
  
  private byte[] coreDigest(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = this.digestSize;
    int i = paramArrayOfByte1.length + j + paramArrayOfByte2.length;
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = XMSSUtil.toBytesBigEndian(paramInt, j);
    paramInt = 0;
    while (paramInt < arrayOfByte2.length)
    {
      arrayOfByte1[paramInt] = arrayOfByte2[paramInt];
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramArrayOfByte1.length)
    {
      arrayOfByte1[(arrayOfByte2.length + paramInt)] = paramArrayOfByte1[paramInt];
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramArrayOfByte2.length)
    {
      arrayOfByte1[(arrayOfByte2.length + paramArrayOfByte1.length + paramInt)] = paramArrayOfByte2[paramInt];
      paramInt += 1;
    }
    this.digest.update(arrayOfByte1, 0, i);
    paramInt = this.digestSize;
    paramArrayOfByte1 = new byte[paramInt];
    paramArrayOfByte2 = this.digest;
    if ((paramArrayOfByte2 instanceof Xof))
    {
      ((Xof)paramArrayOfByte2).doFinal(paramArrayOfByte1, 0, paramInt);
      return paramArrayOfByte1;
    }
    paramArrayOfByte2.doFinal(paramArrayOfByte1, 0);
    return paramArrayOfByte1;
  }
  
  protected byte[] F(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = this.digestSize;
    if (i == j)
    {
      if (paramArrayOfByte2.length == j) {
        return coreDigest(0, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong in length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
  
  protected byte[] H(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = this.digestSize;
    if (i == j)
    {
      if (paramArrayOfByte2.length == j * 2) {
        return coreDigest(1, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong in length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
  
  protected byte[] HMsg(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == this.digestSize * 3) {
      return coreDigest(2, paramArrayOfByte1, paramArrayOfByte2);
    }
    throw new IllegalArgumentException("wrong key length");
  }
  
  protected byte[] PRF(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == this.digestSize)
    {
      if (paramArrayOfByte2.length == 32) {
        return coreDigest(3, paramArrayOfByte1, paramArrayOfByte2);
      }
      throw new IllegalArgumentException("wrong address length");
    }
    throw new IllegalArgumentException("wrong key length");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\KeyedHashFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */