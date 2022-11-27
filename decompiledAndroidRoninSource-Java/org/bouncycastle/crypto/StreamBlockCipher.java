package org.bouncycastle.crypto;

public abstract class StreamBlockCipher
  implements BlockCipher, StreamCipher
{
  private final BlockCipher cipher;
  
  protected StreamBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
  }
  
  protected abstract byte calculateByte(byte paramByte);
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
    {
      int i = paramInt1 + paramInt2;
      if (i <= paramArrayOfByte1.length)
      {
        while (paramInt1 < i)
        {
          paramArrayOfByte2[paramInt3] = calculateByte(paramArrayOfByte1[paramInt1]);
          paramInt3 += 1;
          paramInt1 += 1;
        }
        return paramInt2;
      }
      throw new DataLengthException("input buffer too small");
    }
    throw new DataLengthException("output buffer too short");
  }
  
  public final byte returnByte(byte paramByte)
  {
    return calculateByte(paramByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\StreamBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */