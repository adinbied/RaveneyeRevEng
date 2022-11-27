package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class X931SecureRandomBuilder
{
  private byte[] dateTimeVector;
  private EntropySourceProvider entropySourceProvider;
  private SecureRandom random;
  
  public X931SecureRandomBuilder()
  {
    this(new SecureRandom(), false);
  }
  
  public X931SecureRandomBuilder(SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    this.random = paramSecureRandom;
    this.entropySourceProvider = new BasicEntropySourceProvider(paramSecureRandom, paramBoolean);
  }
  
  public X931SecureRandomBuilder(EntropySourceProvider paramEntropySourceProvider)
  {
    this.random = null;
    this.entropySourceProvider = paramEntropySourceProvider;
  }
  
  public X931SecureRandom build(BlockCipher paramBlockCipher, KeyParameter paramKeyParameter, boolean paramBoolean)
  {
    if (this.dateTimeVector == null)
    {
      this.dateTimeVector = new byte[paramBlockCipher.getBlockSize()];
      Pack.longToBigEndian(System.currentTimeMillis(), this.dateTimeVector, 0);
    }
    paramBlockCipher.init(true, paramKeyParameter);
    return new X931SecureRandom(this.random, new X931RNG(paramBlockCipher, this.dateTimeVector, this.entropySourceProvider.get(paramBlockCipher.getBlockSize() * 8)), paramBoolean);
  }
  
  public X931SecureRandomBuilder setDateTimeVector(byte[] paramArrayOfByte)
  {
    this.dateTimeVector = paramArrayOfByte;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\X931SecureRandomBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */