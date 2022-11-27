package org.bouncycastle.cert.crmf.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.jcajce.util.AlgorithmParametersUtils;
import org.bouncycastle.jcajce.util.JcaJceHelper;

class CRMFHelper
{
  protected static final Map BASE_CIPHER_NAMES = new HashMap();
  protected static final Map CIPHER_ALG_NAMES = new HashMap();
  protected static final Map DIGEST_ALG_NAMES = new HashMap();
  protected static final Map KEY_ALG_NAMES = new HashMap();
  protected static final Map MAC_ALG_NAMES = new HashMap();
  private JcaJceHelper helper;
  
  static
  {
    BASE_CIPHER_NAMES.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESEDE");
    BASE_CIPHER_NAMES.put(NISTObjectIdentifiers.id_aes128_CBC, "AES");
    BASE_CIPHER_NAMES.put(NISTObjectIdentifiers.id_aes192_CBC, "AES");
    BASE_CIPHER_NAMES.put(NISTObjectIdentifiers.id_aes256_CBC, "AES");
    CIPHER_ALG_NAMES.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
    CIPHER_ALG_NAMES.put(CMSAlgorithm.AES128_CBC, "AES/CBC/PKCS5Padding");
    CIPHER_ALG_NAMES.put(CMSAlgorithm.AES192_CBC, "AES/CBC/PKCS5Padding");
    CIPHER_ALG_NAMES.put(CMSAlgorithm.AES256_CBC, "AES/CBC/PKCS5Padding");
    CIPHER_ALG_NAMES.put(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()), "RSA/ECB/PKCS1Padding");
    DIGEST_ALG_NAMES.put(OIWObjectIdentifiers.idSHA1, "SHA1");
    DIGEST_ALG_NAMES.put(NISTObjectIdentifiers.id_sha224, "SHA224");
    DIGEST_ALG_NAMES.put(NISTObjectIdentifiers.id_sha256, "SHA256");
    DIGEST_ALG_NAMES.put(NISTObjectIdentifiers.id_sha384, "SHA384");
    DIGEST_ALG_NAMES.put(NISTObjectIdentifiers.id_sha512, "SHA512");
    MAC_ALG_NAMES.put(IANAObjectIdentifiers.hmacSHA1, "HMACSHA1");
    MAC_ALG_NAMES.put(PKCSObjectIdentifiers.id_hmacWithSHA1, "HMACSHA1");
    MAC_ALG_NAMES.put(PKCSObjectIdentifiers.id_hmacWithSHA224, "HMACSHA224");
    MAC_ALG_NAMES.put(PKCSObjectIdentifiers.id_hmacWithSHA256, "HMACSHA256");
    MAC_ALG_NAMES.put(PKCSObjectIdentifiers.id_hmacWithSHA384, "HMACSHA384");
    MAC_ALG_NAMES.put(PKCSObjectIdentifiers.id_hmacWithSHA512, "HMACSHA512");
    KEY_ALG_NAMES.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
    KEY_ALG_NAMES.put(X9ObjectIdentifiers.id_dsa, "DSA");
  }
  
  CRMFHelper(JcaJceHelper paramJcaJceHelper)
  {
    this.helper = paramJcaJceHelper;
  }
  
  static Object execute(JCECallback paramJCECallback)
    throws CRMFException
  {
    try
    {
      paramJCECallback = paramJCECallback.doInJCE();
      return paramJCECallback;
    }
    catch (InvalidParameterSpecException paramJCECallback)
    {
      throw new CRMFException("MAC algorithm parameter spec invalid.", paramJCECallback);
    }
    catch (InvalidAlgorithmParameterException paramJCECallback)
    {
      throw new CRMFException("algorithm parameters invalid.", paramJCECallback);
    }
    catch (NoSuchPaddingException paramJCECallback)
    {
      throw new CRMFException("required padding not supported.", paramJCECallback);
    }
    catch (NoSuchProviderException paramJCECallback)
    {
      throw new CRMFException("can't find provider.", paramJCECallback);
    }
    catch (InvalidKeyException paramJCECallback)
    {
      throw new CRMFException("key invalid in message.", paramJCECallback);
    }
    catch (NoSuchAlgorithmException paramJCECallback)
    {
      throw new CRMFException("can't find algorithm.", paramJCECallback);
    }
  }
  
  AlgorithmParameterGenerator createAlgorithmParameterGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws GeneralSecurityException
  {
    Object localObject = (String)BASE_CIPHER_NAMES.get(paramASN1ObjectIdentifier);
    if (localObject != null) {}
    try
    {
      localObject = this.helper.createAlgorithmParameterGenerator((String)localObject);
      return (AlgorithmParameterGenerator)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;) {}
    }
    return this.helper.createAlgorithmParameterGenerator(paramASN1ObjectIdentifier.getId());
  }
  
  AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    Object localObject = (String)BASE_CIPHER_NAMES.get(paramASN1ObjectIdentifier);
    if (localObject != null) {}
    try
    {
      localObject = this.helper.createAlgorithmParameters((String)localObject);
      return (AlgorithmParameters)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;) {}
    }
    return this.helper.createAlgorithmParameters(paramASN1ObjectIdentifier.getId());
  }
  
  Cipher createCipher(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CRMFException
  {
    try
    {
      localObject = (String)CIPHER_ALG_NAMES.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create cipher: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createCipher((String)localObject);
      return (Cipher)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createCipher(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  Cipher createContentCipher(final Key paramKey, final AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CRMFException
  {
    (Cipher)execute(new JCECallback()
    {
      public Object doInJCE()
        throws CRMFException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException
      {
        Cipher localCipher = CRMFHelper.this.createCipher(paramAlgorithmIdentifier.getAlgorithm());
        ASN1Primitive localASN1Primitive = (ASN1Primitive)paramAlgorithmIdentifier.getParameters();
        ASN1ObjectIdentifier localASN1ObjectIdentifier = paramAlgorithmIdentifier.getAlgorithm();
        if ((localASN1Primitive != null) && (!(localASN1Primitive instanceof ASN1Null))) {
          try
          {
            AlgorithmParameters localAlgorithmParameters = CRMFHelper.this.createAlgorithmParameters(paramAlgorithmIdentifier.getAlgorithm());
            try
            {
              AlgorithmParametersUtils.loadParameters(localAlgorithmParameters, localASN1Primitive);
              localCipher.init(2, paramKey, localAlgorithmParameters);
              return localCipher;
            }
            catch (IOException localIOException)
            {
              throw new CRMFException("error decoding algorithm parameters.", localIOException);
            }
            if (localASN1ObjectIdentifier.equals(CMSAlgorithm.DES_EDE3_CBC)) {
              break label221;
            }
          }
          catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
          {
            if ((!localASN1ObjectIdentifier.equals(CMSAlgorithm.DES_EDE3_CBC)) && (!localASN1ObjectIdentifier.equals(CMSAlgorithm.IDEA_CBC)) && (!localASN1ObjectIdentifier.equals(CMSAlgorithm.AES128_CBC)) && (!localASN1ObjectIdentifier.equals(CMSAlgorithm.AES192_CBC)) && (!localASN1ObjectIdentifier.equals(CMSAlgorithm.AES256_CBC))) {
              throw localNoSuchAlgorithmException;
            }
            localCipher.init(2, paramKey, new IvParameterSpec(ASN1OctetString.getInstance(localASN1Primitive).getOctets()));
            return localCipher;
          }
        }
        if ((!localASN1ObjectIdentifier.equals(CMSAlgorithm.IDEA_CBC)) && (!localASN1ObjectIdentifier.equals(CMSAlgorithm.CAST5_CBC)))
        {
          localCipher.init(2, paramKey);
          return localCipher;
        }
        label221:
        localCipher.init(2, paramKey, new IvParameterSpec(new byte[8]));
        return localCipher;
      }
    });
  }
  
  MessageDigest createDigest(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CRMFException
  {
    try
    {
      localObject = (String)DIGEST_ALG_NAMES.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create cipher: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createDigest((String)localObject);
      return (MessageDigest)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createDigest(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  KeyFactory createKeyFactory(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CRMFException
  {
    try
    {
      localObject = (String)KEY_ALG_NAMES.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create cipher: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createKeyFactory((String)localObject);
      return (KeyFactory)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createKeyFactory(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  public KeyGenerator createKeyGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CRMFException
  {
    try
    {
      localObject = (String)BASE_CIPHER_NAMES.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create key generator: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createKeyGenerator((String)localObject);
      return (KeyGenerator)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createKeyGenerator(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  Mac createMac(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CRMFException
  {
    try
    {
      localObject = (String)MAC_ALG_NAMES.get(paramASN1ObjectIdentifier);
      if (localObject == null) {}
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      label30:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create mac: ");
      ((StringBuilder)localObject).append(paramASN1ObjectIdentifier.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramASN1ObjectIdentifier);
    }
    try
    {
      localObject = this.helper.createMac((String)localObject);
      return (Mac)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label30;
    }
    paramASN1ObjectIdentifier = this.helper.createMac(paramASN1ObjectIdentifier.getId());
    return paramASN1ObjectIdentifier;
  }
  
  AlgorithmParameters generateParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, SecretKey paramSecretKey, SecureRandom paramSecureRandom)
    throws CRMFException
  {
    try
    {
      AlgorithmParameterGenerator localAlgorithmParameterGenerator = createAlgorithmParameterGenerator(paramASN1ObjectIdentifier);
      if (paramASN1ObjectIdentifier.equals(CMSAlgorithm.RC2_CBC))
      {
        paramASN1ObjectIdentifier = new byte[8];
        paramSecureRandom.nextBytes(paramASN1ObjectIdentifier);
        try
        {
          localAlgorithmParameterGenerator.init(new RC2ParameterSpec(paramSecretKey.getEncoded().length * 8, paramASN1ObjectIdentifier), paramSecureRandom);
        }
        catch (InvalidAlgorithmParameterException paramASN1ObjectIdentifier)
        {
          paramSecretKey = new StringBuilder();
          paramSecretKey.append("parameters generation error: ");
          paramSecretKey.append(paramASN1ObjectIdentifier);
          throw new CRMFException(paramSecretKey.toString(), paramASN1ObjectIdentifier);
        }
      }
      paramASN1ObjectIdentifier = localAlgorithmParameterGenerator.generateParameters();
      return paramASN1ObjectIdentifier;
    }
    catch (GeneralSecurityException paramASN1ObjectIdentifier)
    {
      paramSecretKey = new StringBuilder();
      paramSecretKey.append("exception creating algorithm parameter generator: ");
      paramSecretKey.append(paramASN1ObjectIdentifier);
      throw new CRMFException(paramSecretKey.toString(), paramASN1ObjectIdentifier);
      return null;
    }
    catch (NoSuchAlgorithmException paramASN1ObjectIdentifier)
    {
      for (;;) {}
    }
  }
  
  AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmParameters paramAlgorithmParameters)
    throws CRMFException
  {
    if (paramAlgorithmParameters != null) {
      try
      {
        paramAlgorithmParameters = AlgorithmParametersUtils.extractParameters(paramAlgorithmParameters);
      }
      catch (IOException paramASN1ObjectIdentifier)
      {
        paramAlgorithmParameters = new StringBuilder();
        paramAlgorithmParameters.append("cannot encode parameters: ");
        paramAlgorithmParameters.append(paramASN1ObjectIdentifier.getMessage());
        throw new CRMFException(paramAlgorithmParameters.toString(), paramASN1ObjectIdentifier);
      }
    } else {
      paramAlgorithmParameters = DERNull.INSTANCE;
    }
    return new AlgorithmIdentifier(paramASN1ObjectIdentifier, paramAlgorithmParameters);
  }
  
  PublicKey toPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws CRMFException
  {
    try
    {
      localObject = new X509EncodedKeySpec(paramSubjectPublicKeyInfo.getEncoded());
      paramSubjectPublicKeyInfo = createKeyFactory(paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm()).generatePublic((KeySpec)localObject);
      return paramSubjectPublicKeyInfo;
    }
    catch (Exception paramSubjectPublicKeyInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid key: ");
      ((StringBuilder)localObject).append(paramSubjectPublicKeyInfo.getMessage());
      throw new CRMFException(((StringBuilder)localObject).toString(), paramSubjectPublicKeyInfo);
    }
  }
  
  static abstract interface JCECallback
  {
    public abstract Object doInJCE()
      throws CRMFException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\jcajce\CRMFHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */