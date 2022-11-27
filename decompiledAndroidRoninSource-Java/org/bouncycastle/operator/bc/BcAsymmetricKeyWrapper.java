package org.bouncycastle.operator.bc;

import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public abstract class BcAsymmetricKeyWrapper
  extends AsymmetricKeyWrapper
{
  private AsymmetricKeyParameter publicKey;
  private SecureRandom random;
  
  public BcAsymmetricKeyWrapper(AlgorithmIdentifier paramAlgorithmIdentifier, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    super(paramAlgorithmIdentifier);
    this.publicKey = paramAsymmetricKeyParameter;
  }
  
  protected abstract AsymmetricBlockCipher createAsymmetricWrapper(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public byte[] generateWrappedKey(GenericKey paramGenericKey)
    throws OperatorException
  {
    AsymmetricBlockCipher localAsymmetricBlockCipher = createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
    AsymmetricKeyParameter localAsymmetricKeyParameter = this.publicKey;
    SecureRandom localSecureRandom = this.random;
    Object localObject = localAsymmetricKeyParameter;
    if (localSecureRandom != null) {
      localObject = new ParametersWithRandom(localAsymmetricKeyParameter, localSecureRandom);
    }
    try
    {
      paramGenericKey = OperatorUtils.getKeyBytes(paramGenericKey);
      localAsymmetricBlockCipher.init(true, (CipherParameters)localObject);
      paramGenericKey = localAsymmetricBlockCipher.processBlock(paramGenericKey, 0, paramGenericKey.length);
      return paramGenericKey;
    }
    catch (InvalidCipherTextException paramGenericKey)
    {
      throw new OperatorException("unable to encrypt contents key", paramGenericKey);
    }
  }
  
  public BcAsymmetricKeyWrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcAsymmetricKeyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */