package org.bouncycastle.jcajce.provider.digest;

import java.security.MessageDigest;
import org.bouncycastle.crypto.Digest;

public class BCMessageDigest
  extends MessageDigest
{
  protected Digest digest;
  
  protected BCMessageDigest(Digest paramDigest)
  {
    super(paramDigest.getAlgorithmName());
    this.digest = paramDigest;
  }
  
  public byte[] engineDigest()
  {
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public void engineReset()
  {
    this.digest.reset();
  }
  
  public void engineUpdate(byte paramByte)
  {
    this.digest.update(paramByte);
  }
  
  public void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\BCMessageDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */