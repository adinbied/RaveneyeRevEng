package org.bouncycastle.pkcs.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
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
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;

public class JcePKCSPBEOutputEncryptorBuilder
{
  private ASN1ObjectIdentifier algorithm;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  private int iterationCount = 1024;
  private ASN1ObjectIdentifier keyEncAlgorithm;
  private SecretKeySizeProvider keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;
  private SecureRandom random;
  
  public JcePKCSPBEOutputEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if (isPKCS12(paramASN1ObjectIdentifier)) {
      this.algorithm = paramASN1ObjectIdentifier;
    } else {
      this.algorithm = PKCSObjectIdentifiers.id_PBES2;
    }
    this.keyEncAlgorithm = paramASN1ObjectIdentifier;
  }
  
  private static byte[] PKCS12PasswordToBytes(char[] paramArrayOfChar)
  {
    int i = 0;
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length > 0))
    {
      byte[] arrayOfByte = new byte[(paramArrayOfChar.length + 1) * 2];
      while (i != paramArrayOfChar.length)
      {
        int j = i * 2;
        arrayOfByte[j] = ((byte)(paramArrayOfChar[i] >>> '\b'));
        arrayOfByte[(j + 1)] = ((byte)paramArrayOfChar[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  private static byte[] PKCS5PasswordToBytes(char[] paramArrayOfChar)
  {
    int i = 0;
    if (paramArrayOfChar != null)
    {
      int j = paramArrayOfChar.length;
      byte[] arrayOfByte = new byte[j];
      while (i != j)
      {
        arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  private boolean isPKCS12(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (paramASN1ObjectIdentifier.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) || (paramASN1ObjectIdentifier.on(BCObjectIdentifiers.bc_pbe_sha1_pkcs12)) || (paramASN1ObjectIdentifier.on(BCObjectIdentifiers.bc_pbe_sha256_pkcs12));
  }
  
  public OutputEncryptor build(final char[] paramArrayOfChar)
    throws OperatorCreationException
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    final Object localObject2 = new byte[20];
    this.random.nextBytes((byte[])localObject2);
    try
    {
      if (isPKCS12(this.algorithm))
      {
        localObject1 = this.helper.createCipher(this.algorithm.getId());
        ((Cipher)localObject1).init(1, new PKCS12KeyWithParameters(paramArrayOfChar, (byte[])localObject2, this.iterationCount));
        localObject2 = new AlgorithmIdentifier(this.algorithm, new PKCS12PBEParams((byte[])localObject2, this.iterationCount));
      }
      else
      {
        if (!this.algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
          break label274;
        }
        SecretKey localSecretKey = this.helper.createSecretKeyFactory(PKCSObjectIdentifiers.id_PBKDF2.getId()).generateSecret(new PBEKeySpec(paramArrayOfChar, (byte[])localObject2, this.iterationCount, this.keySizeProvider.getKeySize(new AlgorithmIdentifier(this.keyEncAlgorithm))));
        localObject1 = this.helper.createCipher(this.keyEncAlgorithm.getId());
        ((Cipher)localObject1).init(1, localSecretKey, this.random);
        localObject2 = new PBES2Parameters(new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params((byte[])localObject2, this.iterationCount)), new EncryptionScheme(this.keyEncAlgorithm, ASN1Primitive.fromByteArray(((Cipher)localObject1).getParameters().getEncoded())));
        localObject2 = new AlgorithmIdentifier(this.algorithm, (ASN1Encodable)localObject2);
      }
      new OutputEncryptor()
      {
        public AlgorithmIdentifier getAlgorithmIdentifier()
        {
          return localObject2;
        }
        
        public GenericKey getKey()
        {
          if (JcePKCSPBEOutputEncryptorBuilder.this.isPKCS12(localObject2.getAlgorithm())) {
            return new GenericKey(localObject2, JcePKCSPBEOutputEncryptorBuilder.PKCS12PasswordToBytes(paramArrayOfChar));
          }
          return new GenericKey(localObject2, JcePKCSPBEOutputEncryptorBuilder.PKCS5PasswordToBytes(paramArrayOfChar));
        }
        
        public OutputStream getOutputStream(OutputStream paramAnonymousOutputStream)
        {
          return new CipherOutputStream(paramAnonymousOutputStream, localObject1);
        }
      };
      label274:
      throw new OperatorCreationException("unrecognised algorithm");
    }
    catch (Exception paramArrayOfChar)
    {
      final Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unable to create OutputEncryptor: ");
      ((StringBuilder)localObject1).append(paramArrayOfChar.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject1).toString(), paramArrayOfChar);
    }
  }
  
  public JcePKCSPBEOutputEncryptorBuilder setIterationCount(int paramInt)
  {
    this.iterationCount = paramInt;
    return this;
  }
  
  public JcePKCSPBEOutputEncryptorBuilder setKeySizeProvider(SecretKeySizeProvider paramSecretKeySizeProvider)
  {
    this.keySizeProvider = paramSecretKeySizeProvider;
    return this;
  }
  
  public JcePKCSPBEOutputEncryptorBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePKCSPBEOutputEncryptorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcePKCSPBEOutputEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */