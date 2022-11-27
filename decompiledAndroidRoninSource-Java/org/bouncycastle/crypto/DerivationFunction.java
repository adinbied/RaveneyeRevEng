package org.bouncycastle.crypto;

public abstract interface DerivationFunction
{
  public abstract int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException;
  
  public abstract void init(DerivationParameters paramDerivationParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\DerivationFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */