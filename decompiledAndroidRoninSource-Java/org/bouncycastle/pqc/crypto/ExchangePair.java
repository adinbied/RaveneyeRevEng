package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public class ExchangePair
{
  private final AsymmetricKeyParameter publicKey;
  private final byte[] shared;
  
  public ExchangePair(AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
  {
    this.publicKey = paramAsymmetricKeyParameter;
    this.shared = Arrays.clone(paramArrayOfByte);
  }
  
  public AsymmetricKeyParameter getPublicKey()
  {
    return this.publicKey;
  }
  
  public byte[] getSharedValue()
  {
    return Arrays.clone(this.shared);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\ExchangePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */