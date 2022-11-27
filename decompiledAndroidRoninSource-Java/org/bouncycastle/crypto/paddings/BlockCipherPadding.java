package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public abstract interface BlockCipherPadding
{
  public abstract int addPadding(byte[] paramArrayOfByte, int paramInt);
  
  public abstract String getPaddingName();
  
  public abstract void init(SecureRandom paramSecureRandom)
    throws IllegalArgumentException;
  
  public abstract int padCount(byte[] paramArrayOfByte)
    throws InvalidCipherTextException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\paddings\BlockCipherPadding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */