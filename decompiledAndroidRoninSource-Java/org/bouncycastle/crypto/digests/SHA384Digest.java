package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA384Digest
  extends LongDigest
{
  private static final int DIGEST_LENGTH = 48;
  
  public SHA384Digest() {}
  
  public SHA384Digest(SHA384Digest paramSHA384Digest)
  {
    super(paramSHA384Digest);
  }
  
  public SHA384Digest(byte[] paramArrayOfByte)
  {
    restoreState(paramArrayOfByte);
  }
  
  public Memoable copy()
  {
    return new SHA384Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    Pack.longToBigEndian(this.H1, paramArrayOfByte, paramInt);
    Pack.longToBigEndian(this.H2, paramArrayOfByte, paramInt + 8);
    Pack.longToBigEndian(this.H3, paramArrayOfByte, paramInt + 16);
    Pack.longToBigEndian(this.H4, paramArrayOfByte, paramInt + 24);
    Pack.longToBigEndian(this.H5, paramArrayOfByte, paramInt + 32);
    Pack.longToBigEndian(this.H6, paramArrayOfByte, paramInt + 40);
    reset();
    return 48;
  }
  
  public String getAlgorithmName()
  {
    return "SHA-384";
  }
  
  public int getDigestSize()
  {
    return 48;
  }
  
  public byte[] getEncodedState()
  {
    byte[] arrayOfByte = new byte[getEncodedStateSize()];
    super.populateState(arrayOfByte);
    return arrayOfByte;
  }
  
  public void reset()
  {
    super.reset();
    this.H1 = -3766243637369397544L;
    this.H2 = 7105036623409894663L;
    this.H3 = -7973340178411365097L;
    this.H4 = 1526699215303891257L;
    this.H5 = 7436329637833083697L;
    this.H6 = -8163818279084223215L;
    this.H7 = -2662702644619276377L;
    this.H8 = 5167115440072839076L;
  }
  
  public void reset(Memoable paramMemoable)
  {
    super.copyIn((SHA384Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA384Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */