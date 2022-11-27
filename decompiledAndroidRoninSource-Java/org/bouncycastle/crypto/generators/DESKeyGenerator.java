package org.bouncycastle.crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DESParameters;

public class DESKeyGenerator
  extends CipherKeyGenerator
{
  public byte[] generateKey()
  {
    byte[] arrayOfByte = new byte[8];
    do
    {
      this.random.nextBytes(arrayOfByte);
      DESParameters.setOddParity(arrayOfByte);
    } while (DESParameters.isWeakKey(arrayOfByte, 0));
    return arrayOfByte;
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    super.init(paramKeyGenerationParameters);
    if ((this.strength != 0) && (this.strength != 7))
    {
      if (this.strength == 8) {
        return;
      }
      throw new IllegalArgumentException("DES key must be 64 bits long.");
    }
    this.strength = 8;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DESKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */