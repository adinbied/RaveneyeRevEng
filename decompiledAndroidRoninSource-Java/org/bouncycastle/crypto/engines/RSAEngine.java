package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;

public class RSAEngine
  implements AsymmetricBlockCipher
{
  private RSACoreEngine core;
  
  public int getInputBlockSize()
  {
    return this.core.getInputBlockSize();
  }
  
  public int getOutputBlockSize()
  {
    return this.core.getOutputBlockSize();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (this.core == null) {
      this.core = new RSACoreEngine();
    }
    this.core.init(paramBoolean, paramCipherParameters);
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    RSACoreEngine localRSACoreEngine = this.core;
    if (localRSACoreEngine != null) {
      return localRSACoreEngine.convertOutput(localRSACoreEngine.processBlock(localRSACoreEngine.convertInput(paramArrayOfByte, paramInt1, paramInt2)));
    }
    throw new IllegalStateException("RSA engine not initialised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RSAEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */