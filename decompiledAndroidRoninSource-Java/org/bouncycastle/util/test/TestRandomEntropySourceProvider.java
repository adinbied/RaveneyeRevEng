package org.bouncycastle.util.test;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.crypto.prng.EntropySourceProvider;

public class TestRandomEntropySourceProvider
  implements EntropySourceProvider
{
  private final boolean _predictionResistant;
  private final SecureRandom _sr = new SecureRandom();
  
  public TestRandomEntropySourceProvider(boolean paramBoolean)
  {
    this._predictionResistant = paramBoolean;
  }
  
  public EntropySource get(final int paramInt)
  {
    new EntropySource()
    {
      public int entropySize()
      {
        return paramInt;
      }
      
      public byte[] getEntropy()
      {
        byte[] arrayOfByte = new byte[(paramInt + 7) / 8];
        TestRandomEntropySourceProvider.this._sr.nextBytes(arrayOfByte);
        return arrayOfByte;
      }
      
      public boolean isPredictionResistant()
      {
        return TestRandomEntropySourceProvider.this._predictionResistant;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\test\TestRandomEntropySourceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */