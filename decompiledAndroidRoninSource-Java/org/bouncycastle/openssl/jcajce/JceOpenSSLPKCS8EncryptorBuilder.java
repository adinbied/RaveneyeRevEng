package org.bouncycastle.openssl.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.jcajce.JceGenericKey;

public class JceOpenSSLPKCS8EncryptorBuilder
{
  public static final String AES_128_CBC = NISTObjectIdentifiers.id_aes128_CBC.getId();
  public static final String AES_192_CBC = NISTObjectIdentifiers.id_aes192_CBC.getId();
  public static final String AES_256_CBC = NISTObjectIdentifiers.id_aes256_CBC.getId();
  public static final String DES3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.getId();
  public static final String PBE_SHA1_2DES = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC.getId();
  public static final String PBE_SHA1_3DES;
  public static final String PBE_SHA1_RC2_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC.getId();
  public static final String PBE_SHA1_RC2_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC.getId();
  public static final String PBE_SHA1_RC4_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.getId();
  public static final String PBE_SHA1_RC4_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4.getId();
  private ASN1ObjectIdentifier algOID;
  private Cipher cipher;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  int iterationCount;
  private SecretKey key;
  private AlgorithmParameterGenerator paramGen;
  private AlgorithmParameters params;
  private char[] password;
  private SecureRandom random;
  byte[] salt;
  
  static
  {
    PBE_SHA1_3DES = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC.getId();
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.algOID = paramASN1ObjectIdentifier;
    this.iterationCount = 2048;
  }
  
  public OutputEncryptor build()
    throws OperatorCreationException
  {
    this.salt = new byte[20];
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    this.random.nextBytes(this.salt);
    try
    {
      this.cipher = this.helper.createCipher(this.algOID.getId());
      if (PEMUtilities.isPKCS5Scheme2(this.algOID)) {
        this.paramGen = this.helper.createAlgorithmParameterGenerator(this.algOID.getId());
      }
      final Object localObject2;
      if (PEMUtilities.isPKCS5Scheme2(this.algOID))
      {
        Object localObject1 = this.paramGen.generateParameters();
        this.params = ((AlgorithmParameters)localObject1);
        try
        {
          localObject1 = new KeyDerivationFunc(this.algOID, ASN1Primitive.fromByteArray(((AlgorithmParameters)localObject1).getEncoded()));
          localObject3 = new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(this.salt, this.iterationCount));
          ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
          localASN1EncodableVector.add((ASN1Encodable)localObject3);
          localASN1EncodableVector.add((ASN1Encodable)localObject1);
          localObject1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, PBES2Parameters.getInstance(new DERSequence(localASN1EncodableVector)));
          try
          {
            localObject3 = PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.helper, this.algOID.getId(), this.password, this.salt, this.iterationCount);
            this.key = ((SecretKey)localObject3);
            this.cipher.init(1, (Key)localObject3, this.params);
          }
          catch (GeneralSecurityException localGeneralSecurityException1)
          {
            throw new OperatorCreationException(localGeneralSecurityException1.getMessage(), localGeneralSecurityException1);
          }
          if (!PEMUtilities.isPKCS12(this.algOID)) {
            break label394;
          }
        }
        catch (IOException localIOException)
        {
          throw new OperatorCreationException(localIOException.getMessage(), localIOException);
        }
      }
      else
      {
        localObject2 = new ASN1EncodableVector();
        ((ASN1EncodableVector)localObject2).add(new DEROctetString(this.salt));
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(this.iterationCount));
        localObject2 = new AlgorithmIdentifier(this.algOID, PKCS12PBEParams.getInstance(new DERSequence((ASN1EncodableVector)localObject2)));
      }
      try
      {
        this.cipher.init(1, new PKCS12KeyWithParameters(this.password, this.salt, this.iterationCount));
        new OutputEncryptor()
        {
          public AlgorithmIdentifier getAlgorithmIdentifier()
          {
            return localObject2;
          }
          
          public GenericKey getKey()
          {
            return new JceGenericKey(localObject2, JceOpenSSLPKCS8EncryptorBuilder.this.key);
          }
          
          public OutputStream getOutputStream(OutputStream paramAnonymousOutputStream)
          {
            return new CipherOutputStream(paramAnonymousOutputStream, JceOpenSSLPKCS8EncryptorBuilder.this.cipher);
          }
        };
      }
      catch (GeneralSecurityException localGeneralSecurityException2)
      {
        throw new OperatorCreationException(localGeneralSecurityException2.getMessage(), localGeneralSecurityException2);
      }
      label394:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown algorithm: ");
      localStringBuilder.append(this.algOID);
      throw new OperatorCreationException(localStringBuilder.toString(), null);
    }
    catch (GeneralSecurityException localGeneralSecurityException3)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.algOID);
      ((StringBuilder)localObject3).append(" not available: ");
      ((StringBuilder)localObject3).append(localGeneralSecurityException3.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject3).toString(), localGeneralSecurityException3);
    }
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder setIterationCount(int paramInt)
  {
    this.iterationCount = paramInt;
    return this;
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder setPasssword(char[] paramArrayOfChar)
  {
    this.password = paramArrayOfChar;
    return this;
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
  
  public JceOpenSSLPKCS8EncryptorBuilder setRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JceOpenSSLPKCS8EncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */