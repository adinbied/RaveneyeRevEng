package org.bouncycastle.operator.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyWrapper;

public class JceSymmetricKeyWrapper
  extends SymmetricKeyWrapper
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private SecureRandom random;
  private SecretKey wrappingKey;
  
  public JceSymmetricKeyWrapper(SecretKey paramSecretKey)
  {
    super(determineKeyEncAlg(paramSecretKey));
    this.wrappingKey = paramSecretKey;
  }
  
  static AlgorithmIdentifier determineKeyEncAlg(String paramString, int paramInt)
  {
    if ((!paramString.startsWith("DES")) && (!paramString.startsWith("TripleDES")))
    {
      if (paramString.startsWith("RC2")) {
        return new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.7"), new ASN1Integer(58L));
      }
      if (paramString.startsWith("AES"))
      {
        if (paramInt == 128)
        {
          paramString = NISTObjectIdentifiers.id_aes128_wrap;
        }
        else if (paramInt == 192)
        {
          paramString = NISTObjectIdentifiers.id_aes192_wrap;
        }
        else
        {
          if (paramInt != 256) {
            break label114;
          }
          paramString = NISTObjectIdentifiers.id_aes256_wrap;
        }
        return new AlgorithmIdentifier(paramString);
        label114:
        throw new IllegalArgumentException("illegal keysize in AES");
      }
      if (paramString.startsWith("SEED")) {
        return new AlgorithmIdentifier(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap);
      }
      if (paramString.startsWith("Camellia"))
      {
        if (paramInt == 128)
        {
          paramString = NTTObjectIdentifiers.id_camellia128_wrap;
        }
        else if (paramInt == 192)
        {
          paramString = NTTObjectIdentifiers.id_camellia192_wrap;
        }
        else
        {
          if (paramInt != 256) {
            break label201;
          }
          paramString = NTTObjectIdentifiers.id_camellia256_wrap;
        }
        return new AlgorithmIdentifier(paramString);
        label201:
        throw new IllegalArgumentException("illegal keysize in Camellia");
      }
      throw new IllegalArgumentException("unknown algorithm");
    }
    return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, DERNull.INSTANCE);
  }
  
  private static AlgorithmIdentifier determineKeyEncAlg(SecretKey paramSecretKey)
  {
    return determineKeyEncAlg(paramSecretKey.getAlgorithm(), paramSecretKey.getEncoded().length * 8);
  }
  
  public byte[] generateWrappedKey(GenericKey paramGenericKey)
    throws OperatorException
  {
    paramGenericKey = OperatorUtils.getJceKey(paramGenericKey);
    Object localObject = this.helper.createSymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
    try
    {
      ((Cipher)localObject).init(3, this.wrappingKey, this.random);
      paramGenericKey = ((Cipher)localObject).wrap(paramGenericKey);
      return paramGenericKey;
    }
    catch (GeneralSecurityException paramGenericKey)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot wrap key: ");
      ((StringBuilder)localObject).append(paramGenericKey.getMessage());
      throw new OperatorException(((StringBuilder)localObject).toString(), paramGenericKey);
    }
  }
  
  public JceSymmetricKeyWrapper setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceSymmetricKeyWrapper setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public JceSymmetricKeyWrapper setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JceSymmetricKeyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */