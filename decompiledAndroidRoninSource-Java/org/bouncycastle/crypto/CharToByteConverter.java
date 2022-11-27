package org.bouncycastle.crypto;

public abstract interface CharToByteConverter
{
  public abstract byte[] convert(char[] paramArrayOfChar);
  
  public abstract String getType();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\CharToByteConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */