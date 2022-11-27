package org.bouncycastle.crypto.params;

public class IESWithCipherParameters
  extends IESParameters
{
  private int cipherKeySize;
  
  public IESWithCipherParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte1, paramArrayOfByte2, paramInt1);
    this.cipherKeySize = paramInt2;
  }
  
  public int getCipherKeySize()
  {
    return this.cipherKeySize;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\IESWithCipherParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */