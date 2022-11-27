package org.bouncycastle.pkcs.jcajce;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.SecretKeySizeProvider;

public class JcePKCSPBEInputDecryptorProviderBuilder
{
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  private SecretKeySizeProvider keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;
  private boolean wrongPKCS12Zero = false;
  
  public InputDecryptorProvider build(final char[] paramArrayOfChar)
  {
    new InputDecryptorProvider()
    {
      private Cipher cipher;
      private AlgorithmIdentifier encryptionAlg;
      
      public InputDecryptor get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        Object localObject2 = paramAnonymousAlgorithmIdentifier.getAlgorithm();
        try
        {
          if (((ASN1ObjectIdentifier)localObject2).on(PKCSObjectIdentifiers.pkcs_12PbeIds))
          {
            localObject1 = PKCS12PBEParams.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
            localObject2 = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createCipher(((ASN1ObjectIdentifier)localObject2).getId());
            this.cipher = ((Cipher)localObject2);
            ((Cipher)localObject2).init(2, new PKCS12KeyWithParameters(paramArrayOfChar, JcePKCSPBEInputDecryptorProviderBuilder.this.wrongPKCS12Zero, ((PKCS12PBEParams)localObject1).getIV(), ((PKCS12PBEParams)localObject1).getIterations().intValue()));
            this.encryptionAlg = paramAnonymousAlgorithmIdentifier;
          }
          else if (((ASN1ObjectIdentifier)localObject2).equals(PKCSObjectIdentifiers.id_PBES2))
          {
            localObject1 = PBES2Parameters.getInstance(paramAnonymousAlgorithmIdentifier.getParameters());
            paramAnonymousAlgorithmIdentifier = PBKDF2Params.getInstance(((PBES2Parameters)localObject1).getKeyDerivationFunc().getParameters());
            localObject2 = AlgorithmIdentifier.getInstance(((PBES2Parameters)localObject1).getEncryptionScheme());
            SecretKeyFactory localSecretKeyFactory = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createSecretKeyFactory(((PBES2Parameters)localObject1).getKeyDerivationFunc().getAlgorithm().getId());
            if (paramAnonymousAlgorithmIdentifier.isDefaultPrf()) {
              paramAnonymousAlgorithmIdentifier = localSecretKeyFactory.generateSecret(new PBEKeySpec(paramArrayOfChar, paramAnonymousAlgorithmIdentifier.getSalt(), paramAnonymousAlgorithmIdentifier.getIterationCount().intValue(), JcePKCSPBEInputDecryptorProviderBuilder.this.keySizeProvider.getKeySize((AlgorithmIdentifier)localObject2)));
            } else {
              paramAnonymousAlgorithmIdentifier = localSecretKeyFactory.generateSecret(new PBKDF2KeySpec(paramArrayOfChar, paramAnonymousAlgorithmIdentifier.getSalt(), paramAnonymousAlgorithmIdentifier.getIterationCount().intValue(), JcePKCSPBEInputDecryptorProviderBuilder.this.keySizeProvider.getKeySize((AlgorithmIdentifier)localObject2), paramAnonymousAlgorithmIdentifier.getPrf()));
            }
            this.cipher = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createCipher(((PBES2Parameters)localObject1).getEncryptionScheme().getAlgorithm().getId());
            this.encryptionAlg = AlgorithmIdentifier.getInstance(((PBES2Parameters)localObject1).getEncryptionScheme());
            localObject2 = ((PBES2Parameters)localObject1).getEncryptionScheme().getParameters();
            if ((localObject2 instanceof ASN1OctetString)) {
              localObject1 = this.cipher;
            }
            for (localObject2 = new IvParameterSpec(ASN1OctetString.getInstance(localObject2).getOctets());; localObject2 = new GOST28147ParameterSpec(((GOST28147Parameters)localObject2).getEncryptionParamSet(), ((GOST28147Parameters)localObject2).getIV()))
            {
              ((Cipher)localObject1).init(2, paramAnonymousAlgorithmIdentifier, (AlgorithmParameterSpec)localObject2);
              break;
              localObject2 = GOST28147Parameters.getInstance(localObject2);
              localObject1 = this.cipher;
            }
          }
          new InputDecryptor()
          {
            public AlgorithmIdentifier getAlgorithmIdentifier()
            {
              return JcePKCSPBEInputDecryptorProviderBuilder.1.this.encryptionAlg;
            }
            
            public InputStream getInputStream(InputStream paramAnonymous2InputStream)
            {
              return new CipherInputStream(paramAnonymous2InputStream, JcePKCSPBEInputDecryptorProviderBuilder.1.this.cipher);
            }
          };
        }
        catch (Exception paramAnonymousAlgorithmIdentifier)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unable to create InputDecryptor: ");
          ((StringBuilder)localObject1).append(paramAnonymousAlgorithmIdentifier.getMessage());
          throw new OperatorCreationException(((StringBuilder)localObject1).toString(), paramAnonymousAlgorithmIdentifier);
        }
      }
    };
  }
  
  public JcePKCSPBEInputDecryptorProviderBuilder setKeySizeProvider(SecretKeySizeProvider paramSecretKeySizeProvider)
  {
    this.keySizeProvider = paramSecretKeySizeProvider;
    return this;
  }
  
  public JcePKCSPBEInputDecryptorProviderBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePKCSPBEInputDecryptorProviderBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
  
  public JcePKCSPBEInputDecryptorProviderBuilder setTryWrongPKCS12Zero(boolean paramBoolean)
  {
    this.wrongPKCS12Zero = paramBoolean;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcePKCSPBEInputDecryptorProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */