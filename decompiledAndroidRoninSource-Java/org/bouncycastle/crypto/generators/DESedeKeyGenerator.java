package org.bouncycastle.crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DESedeParameters;

public class DESedeKeyGenerator
  extends DESKeyGenerator
{
  private static final int MAX_IT = 20;
  
  public byte[] generateKey()
  {
    int k = this.strength;
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    do
    {
      int j;
      do
      {
        this.random.nextBytes(arrayOfByte);
        DESedeParameters.setOddParity(arrayOfByte);
        j = i + 1;
        if (j >= 20) {
          break;
        }
        i = j;
      } while (DESedeParameters.isWeakKey(arrayOfByte, 0, k));
      i = j;
    } while (!DESedeParameters.isRealEDEKey(arrayOfByte, 0));
    if ((!DESedeParameters.isWeakKey(arrayOfByte, 0, k)) && (DESedeParameters.isRealEDEKey(arrayOfByte, 0))) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Unable to generate DES-EDE key");
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.random = paramKeyGenerationParameters.getRandom();
    this.strength = ((paramKeyGenerationParameters.getStrength() + 7) / 8);
    if ((this.strength != 0) && (this.strength != 21))
    {
      if (this.strength == 14)
      {
        this.strength = 16;
        return;
      }
      if (this.strength != 24)
      {
        if (this.strength == 16) {
          return;
        }
        throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
      }
    }
    else
    {
      this.strength = 24;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DESedeKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */