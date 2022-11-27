package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Pack;

public class OldIESEngine
  extends IESEngine
{
  public OldIESEngine(BasicAgreement paramBasicAgreement, DerivationFunction paramDerivationFunction, Mac paramMac)
  {
    super(paramBasicAgreement, paramDerivationFunction, paramMac);
  }
  
  public OldIESEngine(BasicAgreement paramBasicAgreement, DerivationFunction paramDerivationFunction, Mac paramMac, BufferedBlockCipher paramBufferedBlockCipher)
  {
    super(paramBasicAgreement, paramDerivationFunction, paramMac, paramBufferedBlockCipher);
  }
  
  protected byte[] getLengthTag(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramArrayOfByte != null) {
      Pack.intToBigEndian(paramArrayOfByte.length * 8, arrayOfByte, 0);
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\OldIESEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */