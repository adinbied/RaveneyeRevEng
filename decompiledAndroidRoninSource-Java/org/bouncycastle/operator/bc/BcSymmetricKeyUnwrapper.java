package org.bouncycastle.operator.bc;

import java.security.SecureRandom;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;

public class BcSymmetricKeyUnwrapper
  extends SymmetricKeyUnwrapper
{
  private SecureRandom random;
  private Wrapper wrapper;
  private KeyParameter wrappingKey;
  
  public BcSymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, Wrapper paramWrapper, KeyParameter paramKeyParameter)
  {
    super(paramAlgorithmIdentifier);
    this.wrapper = paramWrapper;
    this.wrappingKey = paramKeyParameter;
  }
  
  public GenericKey generateUnwrappedKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
    throws OperatorException
  {
    this.wrapper.init(false, this.wrappingKey);
    try
    {
      paramAlgorithmIdentifier = new GenericKey(paramAlgorithmIdentifier, this.wrapper.unwrap(paramArrayOfByte, 0, paramArrayOfByte.length));
      return paramAlgorithmIdentifier;
    }
    catch (InvalidCipherTextException paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("unable to unwrap key: ");
      paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
      throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
    }
  }
  
  public BcSymmetricKeyUnwrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcSymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */