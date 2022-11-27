package org.bouncycastle.jcajce.provider.asymmetric.util;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.jce.spec.IESParameterSpec;

public class IESUtil
{
  public static IESParameterSpec guessParameterSpec(BufferedBlockCipher paramBufferedBlockCipher, byte[] paramArrayOfByte)
  {
    if (paramBufferedBlockCipher == null) {
      return new IESParameterSpec(null, null, 128);
    }
    paramBufferedBlockCipher = paramBufferedBlockCipher.getUnderlyingCipher();
    if ((!paramBufferedBlockCipher.getAlgorithmName().equals("DES")) && (!paramBufferedBlockCipher.getAlgorithmName().equals("RC2")) && (!paramBufferedBlockCipher.getAlgorithmName().equals("RC5-32")) && (!paramBufferedBlockCipher.getAlgorithmName().equals("RC5-64")))
    {
      if (paramBufferedBlockCipher.getAlgorithmName().equals("SKIPJACK")) {
        return new IESParameterSpec(null, null, 80, 80, paramArrayOfByte);
      }
      if (paramBufferedBlockCipher.getAlgorithmName().equals("GOST28147")) {
        return new IESParameterSpec(null, null, 256, 256, paramArrayOfByte);
      }
      return new IESParameterSpec(null, null, 128, 128, paramArrayOfByte);
    }
    return new IESParameterSpec(null, null, 64, 64, paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\IESUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */