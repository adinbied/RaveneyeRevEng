package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public abstract class BcAsymmetricKeyUnwrapper
  extends AsymmetricKeyUnwrapper
{
  private AsymmetricKeyParameter privateKey;
  
  public BcAsymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, AsymmetricKeyParameter paramAsymmetricKeyParameter)
  {
    super(paramAlgorithmIdentifier);
    this.privateKey = paramAsymmetricKeyParameter;
  }
  
  protected abstract AsymmetricBlockCipher createAsymmetricUnwrapper(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public GenericKey generateUnwrappedKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
    throws OperatorException
  {
    AsymmetricBlockCipher localAsymmetricBlockCipher = createAsymmetricUnwrapper(getAlgorithmIdentifier().getAlgorithm());
    localAsymmetricBlockCipher.init(false, this.privateKey);
    try
    {
      paramArrayOfByte = localAsymmetricBlockCipher.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.des_EDE3_CBC)) {
        return new GenericKey(paramAlgorithmIdentifier, paramArrayOfByte);
      }
      paramAlgorithmIdentifier = new GenericKey(paramAlgorithmIdentifier, paramArrayOfByte);
      return paramAlgorithmIdentifier;
    }
    catch (InvalidCipherTextException paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("unable to recover secret key: ");
      paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
      throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcAsymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */