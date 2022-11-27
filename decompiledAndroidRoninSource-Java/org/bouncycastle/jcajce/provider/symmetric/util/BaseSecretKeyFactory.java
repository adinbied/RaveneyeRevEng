package org.bouncycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class BaseSecretKeyFactory
  extends SecretKeyFactorySpi
  implements PBE
{
  protected String algName;
  protected ASN1ObjectIdentifier algOid;
  
  protected BaseSecretKeyFactory(String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.algName = paramString;
    this.algOid = paramASN1ObjectIdentifier;
  }
  
  protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof SecretKeySpec)) {
      return new SecretKeySpec(((SecretKeySpec)paramKeySpec).getEncoded(), this.algName);
    }
    throw new InvalidKeySpecException("Invalid KeySpec");
  }
  
  protected KeySpec engineGetKeySpec(SecretKey paramSecretKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if (paramClass != null)
    {
      if (paramSecretKey != null)
      {
        if (SecretKeySpec.class.isAssignableFrom(paramClass)) {
          return new SecretKeySpec(paramSecretKey.getEncoded(), this.algName);
        }
        try
        {
          paramSecretKey = (KeySpec)paramClass.getConstructor(new Class[] { byte[].class }).newInstance(new Object[] { paramSecretKey.getEncoded() });
          return paramSecretKey;
        }
        catch (Exception paramSecretKey)
        {
          throw new InvalidKeySpecException(paramSecretKey.toString());
        }
      }
      throw new InvalidKeySpecException("key parameter is null");
    }
    throw new InvalidKeySpecException("keySpec parameter is null");
  }
  
  protected SecretKey engineTranslateKey(SecretKey paramSecretKey)
    throws InvalidKeyException
  {
    if (paramSecretKey != null)
    {
      if (paramSecretKey.getAlgorithm().equalsIgnoreCase(this.algName)) {
        return new SecretKeySpec(paramSecretKey.getEncoded(), this.algName);
      }
      paramSecretKey = new StringBuilder();
      paramSecretKey.append("Key not of type ");
      paramSecretKey.append(this.algName);
      paramSecretKey.append(".");
      throw new InvalidKeyException(paramSecretKey.toString());
    }
    throw new InvalidKeyException("key parameter is null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseSecretKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */