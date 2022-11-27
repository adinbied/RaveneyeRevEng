package org.bouncycastle.operator.bc;

import java.security.SecureRandom;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyWrapper;

public class BcSymmetricKeyWrapper
  extends SymmetricKeyWrapper
{
  private SecureRandom random;
  private Wrapper wrapper;
  private KeyParameter wrappingKey;
  
  public BcSymmetricKeyWrapper(AlgorithmIdentifier paramAlgorithmIdentifier, Wrapper paramWrapper, KeyParameter paramKeyParameter)
  {
    super(paramAlgorithmIdentifier);
    this.wrapper = paramWrapper;
    this.wrappingKey = paramKeyParameter;
  }
  
  public byte[] generateWrappedKey(GenericKey paramGenericKey)
    throws OperatorException
  {
    paramGenericKey = OperatorUtils.getKeyBytes(paramGenericKey);
    SecureRandom localSecureRandom = this.random;
    if (localSecureRandom == null) {
      this.wrapper.init(true, this.wrappingKey);
    } else {
      this.wrapper.init(true, new ParametersWithRandom(this.wrappingKey, localSecureRandom));
    }
    return this.wrapper.wrap(paramGenericKey, 0, paramGenericKey.length);
  }
  
  public BcSymmetricKeyWrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcSymmetricKeyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */