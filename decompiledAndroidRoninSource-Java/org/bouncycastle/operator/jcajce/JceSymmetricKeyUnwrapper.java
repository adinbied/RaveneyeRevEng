package org.bouncycastle.operator.jcajce;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;

public class JceSymmetricKeyUnwrapper
  extends SymmetricKeyUnwrapper
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private SecretKey secretKey;
  
  public JceSymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, SecretKey paramSecretKey)
  {
    super(paramAlgorithmIdentifier);
    this.secretKey = paramSecretKey;
  }
  
  public GenericKey generateUnwrappedKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
    throws OperatorException
  {
    try
    {
      Cipher localCipher = this.helper.createSymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
      localCipher.init(4, this.secretKey);
      paramAlgorithmIdentifier = new JceGenericKey(paramAlgorithmIdentifier, localCipher.unwrap(paramArrayOfByte, this.helper.getKeyAlgorithmName(paramAlgorithmIdentifier.getAlgorithm()), 3));
      return paramAlgorithmIdentifier;
    }
    catch (NoSuchAlgorithmException paramAlgorithmIdentifier)
    {
      throw new OperatorException("can't find algorithm.", paramAlgorithmIdentifier);
    }
    catch (InvalidKeyException paramAlgorithmIdentifier)
    {
      throw new OperatorException("key invalid in message.", paramAlgorithmIdentifier);
    }
  }
  
  public JceSymmetricKeyUnwrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceSymmetricKeyUnwrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceSymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */