package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

class ChaCha20
{
  static void process(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2)
  {
    ChaChaEngine localChaChaEngine = new ChaChaEngine(20);
    localChaChaEngine.init(true, new ParametersWithIV(new KeyParameter(paramArrayOfByte1), paramArrayOfByte2));
    localChaChaEngine.processBytes(paramArrayOfByte3, paramInt1, paramInt2, paramArrayOfByte3, paramInt1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\ChaCha20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */