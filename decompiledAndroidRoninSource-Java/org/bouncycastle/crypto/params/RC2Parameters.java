package org.bouncycastle.crypto.params;

public class RC2Parameters
  extends KeyParameter
{
  private int bits;
  
  public RC2Parameters(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, i);
  }
  
  public RC2Parameters(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte);
    this.bits = paramInt;
  }
  
  public int getEffectiveKeyBits()
  {
    return this.bits;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\RC2Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */