package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract class AbstractTlsSigner
  implements TlsSigner
{
  protected TlsContext context;
  
  public Signer createSigner(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return createSigner(null, paramAsymmetricKeyParameter);
  }
  
  public Signer createVerifyer(AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    return createVerifyer(null, paramAsymmetricKeyParameter);
  }
  
  public byte[] generateRawSignature(AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
    throws CryptoException
  {
    return generateRawSignature(null, paramAsymmetricKeyParameter, paramArrayOfByte);
  }
  
  public void init(TlsContext paramTlsContext)
  {
    this.context = paramTlsContext;
  }
  
  public boolean verifyRawSignature(byte[] paramArrayOfByte1, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte2)
    throws CryptoException
  {
    return verifyRawSignature(null, paramArrayOfByte1, paramAsymmetricKeyParameter, paramArrayOfByte2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */