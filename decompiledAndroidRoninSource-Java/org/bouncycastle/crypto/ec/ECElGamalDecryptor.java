package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.math.ec.ECPoint;

public class ECElGamalDecryptor
  implements ECDecryptor
{
  private ECPrivateKeyParameters key;
  
  public ECPoint decrypt(ECPair paramECPair)
  {
    if (this.key != null)
    {
      ECPoint localECPoint = paramECPair.getX().multiply(this.key.getD());
      return paramECPair.getY().subtract(localECPoint).normalize();
    }
    throw new IllegalStateException("ECElGamalDecryptor not initialised");
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ECPrivateKeyParameters))
    {
      this.key = ((ECPrivateKeyParameters)paramCipherParameters);
      return;
    }
    throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECElGamalDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */