package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract interface TlsSigner
{
  public abstract Signer createSigner(AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract Signer createSigner(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract Signer createVerifyer(AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract Signer createVerifyer(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract byte[] generateRawSignature(AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
    throws CryptoException;
  
  public abstract byte[] generateRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte)
    throws CryptoException;
  
  public abstract void init(TlsContext paramTlsContext);
  
  public abstract boolean isValidPublicKey(AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract boolean verifyRawSignature(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, byte[] paramArrayOfByte1, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte2)
    throws CryptoException;
  
  public abstract boolean verifyRawSignature(byte[] paramArrayOfByte1, AsymmetricKeyParameter paramAsymmetricKeyParameter, byte[] paramArrayOfByte2)
    throws CryptoException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */