package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class Poly1305KeyGenerator
  extends CipherKeyGenerator
{
  private static final byte R_MASK_HIGH_4 = 15;
  private static final byte R_MASK_LOW_2 = -4;
  
  public static void checkKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 32)
    {
      checkMask(paramArrayOfByte[3], (byte)15);
      checkMask(paramArrayOfByte[7], (byte)15);
      checkMask(paramArrayOfByte[11], (byte)15);
      checkMask(paramArrayOfByte[15], (byte)15);
      checkMask(paramArrayOfByte[4], (byte)-4);
      checkMask(paramArrayOfByte[8], (byte)-4);
      checkMask(paramArrayOfByte[12], (byte)-4);
      return;
    }
    throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
  }
  
  private static void checkMask(byte paramByte1, byte paramByte2)
  {
    if ((paramByte1 & paramByte2) == 0) {
      return;
    }
    throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
  }
  
  public static void clamp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 32)
    {
      paramArrayOfByte[3] = ((byte)(paramArrayOfByte[3] & 0xF));
      paramArrayOfByte[7] = ((byte)(paramArrayOfByte[7] & 0xF));
      paramArrayOfByte[11] = ((byte)(paramArrayOfByte[11] & 0xF));
      paramArrayOfByte[15] = ((byte)(paramArrayOfByte[15] & 0xF));
      paramArrayOfByte[4] = ((byte)(paramArrayOfByte[4] & 0xFFFFFFFC));
      paramArrayOfByte[8] = ((byte)(paramArrayOfByte[8] & 0xFFFFFFFC));
      paramArrayOfByte[12] = ((byte)(paramArrayOfByte[12] & 0xFFFFFFFC));
      return;
    }
    throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
  }
  
  public byte[] generateKey()
  {
    byte[] arrayOfByte = super.generateKey();
    clamp(arrayOfByte);
    return arrayOfByte;
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    super.init(new KeyGenerationParameters(paramKeyGenerationParameters.getRandom(), 256));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\Poly1305KeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */