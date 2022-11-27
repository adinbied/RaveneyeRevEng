package org.bouncycastle.operator.jcajce;

import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.ProviderException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public class JceAsymmetricKeyUnwrapper
  extends AsymmetricKeyUnwrapper
{
  private Map extraMappings = new HashMap();
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private PrivateKey privKey;
  private boolean unwrappedKeyMustBeEncodable;
  
  public JceAsymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, PrivateKey paramPrivateKey)
  {
    super(paramAlgorithmIdentifier);
    this.privKey = paramPrivateKey;
  }
  
  public GenericKey generateUnwrappedKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
    throws OperatorException
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localCipher = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm(), this.extraMappings);
        localObject1 = this.helper.createAlgorithmParameters(getAlgorithmIdentifier());
        localObject3 = null;
        if (localObject1 == null) {}
      }
      catch (BadPaddingException paramAlgorithmIdentifier)
      {
        Cipher localCipher;
        Object localObject1;
        Key localKey;
        boolean bool;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("bad padding: ");
        paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
        throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
      }
      catch (IllegalBlockSizeException paramAlgorithmIdentifier)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("illegal blocksize: ");
        paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
        throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
      }
      catch (InvalidKeyException paramAlgorithmIdentifier)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("key invalid: ");
        paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
        throw new OperatorException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
      }
      try
      {
        localCipher.init(4, this.privKey, (AlgorithmParameters)localObject1);
        continue;
        localCipher.init(4, this.privKey);
        localKey = localCipher.unwrap(paramArrayOfByte, this.helper.getKeyAlgorithmName(paramAlgorithmIdentifier.getAlgorithm()), 3);
      }
      catch (GeneralSecurityException|IllegalStateException|UnsupportedOperationException|ProviderException|Exception localGeneralSecurityException1)
      {
        Object localObject2 = localObject3;
        continue;
      }
      try
      {
        bool = this.unwrappedKeyMustBeEncodable;
        if (bool)
        {
          byte[] arrayOfByte = localKey.getEncoded();
          localObject1 = localObject3;
          if (arrayOfByte == null) {
            continue;
          }
          int i = arrayOfByte.length;
          if (i == 0) {
            localObject1 = localObject3;
          }
        }
      }
      catch (GeneralSecurityException|IllegalStateException|UnsupportedOperationException|ProviderException localGeneralSecurityException2) {}
    }
    localObject1 = localKey;
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localCipher.init(2, this.privKey);
      localObject3 = new SecretKeySpec(localCipher.doFinal(paramArrayOfByte), paramAlgorithmIdentifier.getAlgorithm().getId());
    }
    paramAlgorithmIdentifier = new JceGenericKey(paramAlgorithmIdentifier, (Key)localObject3);
    return paramAlgorithmIdentifier;
  }
  
  public JceAsymmetricKeyUnwrapper setAlgorithmMapping(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    this.extraMappings.put(paramASN1ObjectIdentifier, paramString);
    return this;
  }
  
  public JceAsymmetricKeyUnwrapper setMustProduceEncodableUnwrappedKey(boolean paramBoolean)
  {
    this.unwrappedKeyMustBeEncodable = paramBoolean;
    return this;
  }
  
  public JceAsymmetricKeyUnwrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceAsymmetricKeyUnwrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceAsymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */