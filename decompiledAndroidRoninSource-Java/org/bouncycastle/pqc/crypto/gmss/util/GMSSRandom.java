package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class GMSSRandom
{
  private Digest messDigestTree;
  
  public GMSSRandom(Digest paramDigest)
  {
    this.messDigestTree = paramDigest;
  }
  
  private void addByteArrays(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte1.length)
    {
      j = (paramArrayOfByte1[i] & 0xFF) + (paramArrayOfByte2[i] & 0xFF) + j;
      paramArrayOfByte1[i] = ((byte)j);
      j = (byte)(j >> 8);
      i += 1;
    }
  }
  
  private void addOne(byte[] paramArrayOfByte)
  {
    int j = 1;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = (paramArrayOfByte[i] & 0xFF) + j;
      paramArrayOfByte[i] = ((byte)j);
      j = (byte)(j >> 8);
      i += 1;
    }
  }
  
  public byte[] nextSeed(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    this.messDigestTree.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    arrayOfByte = new byte[this.messDigestTree.getDigestSize()];
    this.messDigestTree.doFinal(arrayOfByte, 0);
    addByteArrays(paramArrayOfByte, arrayOfByte);
    addOne(paramArrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gms\\util\GMSSRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */