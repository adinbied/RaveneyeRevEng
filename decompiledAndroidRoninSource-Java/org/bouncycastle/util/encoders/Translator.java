package org.bouncycastle.util.encoders;

public abstract interface Translator
{
  public abstract int decode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public abstract int encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public abstract int getDecodedBlockSize();
  
  public abstract int getEncodedBlockSize();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\Translator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */