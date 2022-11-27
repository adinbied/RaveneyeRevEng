package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA512Digest
  extends LongDigest
{
  private static final int DIGEST_LENGTH = 64;
  
  public SHA512Digest() {}
  
  public SHA512Digest(SHA512Digest paramSHA512Digest)
  {
    super(paramSHA512Digest);
  }
  
  public SHA512Digest(byte[] paramArrayOfByte)
  {
    restoreState(paramArrayOfByte);
  }
  
  public Memoable copy()
  {
    return new SHA512Digest(this);
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
    Pack.longToBigEndian(this.H7, paramArrayOfByte, paramInt + 48);
    Pack.longToBigEndian(this.H8, paramArrayOfByte, paramInt + 56);
    reset();
    return 64;
  }
  
  public String getAlgorithmName()
  {
    return "SHA-512";
  }
  
  public int getDigestSize()
  {
    return 64;
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
    this.H1 = 7640891576956012808L;
    this.H2 = -4942790177534073029L;
    this.H3 = 4354685564936845355L;
    this.H4 = -6534734903238641935L;
    this.H5 = 5840696475078001361L;
    this.H6 = -7276294671716946913L;
    this.H7 = 2270897969802886507L;
    this.H8 = 6620516959819538809L;
  }
  
  public void reset(Memoable paramMemoable)
  {
    copyIn((SHA512Digest)paramMemoable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SHA512Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */