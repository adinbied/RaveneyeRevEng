package org.bouncycastle.cert.crmf.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.jcajce.JceGenericKey;

public class JceCRMFEncryptorBuilder
{
  private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
  private final ASN1ObjectIdentifier encryptionOID;
  private CRMFHelper helper = new CRMFHelper(new DefaultJcaJceHelper());
  private final int keySize;
  private SecureRandom random;
  
  public JceCRMFEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this(paramASN1ObjectIdentifier, -1);
  }
  
  public JceCRMFEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
  {
    this.encryptionOID = paramASN1ObjectIdentifier;
    this.keySize = paramInt;
  }
  
  public OutputEncryptor build()
    throws CRMFException
  {
    return new CRMFOutputEncryptor(this.encryptionOID, this.keySize, this.random);
  }
  
  public JceCRMFEncryptorBuilder setProvider(String paramString)
  {
    this.helper = new CRMFHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JceCRMFEncryptorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new CRMFHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public JceCRMFEncryptorBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  private class CRMFOutputEncryptor
    implements OutputEncryptor
  {
    private AlgorithmIdentifier algorithmIdentifier;
    private Cipher cipher;
    private SecretKey encKey;
    
    CRMFOutputEncryptor(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, SecureRandom paramSecureRandom)
      throws CRMFException
    {
      Object localObject = JceCRMFEncryptorBuilder.this.helper.createKeyGenerator(paramASN1ObjectIdentifier);
      SecureRandom localSecureRandom = paramSecureRandom;
      if (paramSecureRandom == null) {
        localSecureRandom = new SecureRandom();
      }
      int i = paramInt;
      if (paramInt < 0) {
        i = JceCRMFEncryptorBuilder.KEY_SIZE_PROVIDER.getKeySize(paramASN1ObjectIdentifier);
      }
      if (i < 0) {
        ((KeyGenerator)localObject).init(localSecureRandom);
      } else {
        ((KeyGenerator)localObject).init(i, localSecureRandom);
      }
      this.cipher = JceCRMFEncryptorBuilder.this.helper.createCipher(paramASN1ObjectIdentifier);
      this.encKey = ((KeyGenerator)localObject).generateKey();
      localObject = JceCRMFEncryptorBuilder.this.helper.generateParameters(paramASN1ObjectIdentifier, this.encKey, localSecureRandom);
      try
      {
        this.cipher.init(1, this.encKey, (AlgorithmParameters)localObject, localSecureRandom);
        paramSecureRandom = (SecureRandom)localObject;
        if (localObject == null) {
          paramSecureRandom = this.cipher.getParameters();
        }
        this.algorithmIdentifier = JceCRMFEncryptorBuilder.this.helper.getAlgorithmIdentifier(paramASN1ObjectIdentifier, paramSecureRandom);
        return;
      }
      catch (GeneralSecurityException this$1)
      {
        paramASN1ObjectIdentifier = new StringBuilder();
        paramASN1ObjectIdentifier.append("unable to initialize cipher: ");
        paramASN1ObjectIdentifier.append(JceCRMFEncryptorBuilder.this.getMessage());
        throw new CRMFException(paramASN1ObjectIdentifier.toString(), JceCRMFEncryptorBuilder.this);
      }
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return this.algorithmIdentifier;
    }
    
    public GenericKey getKey()
    {
      return new JceGenericKey(this.algorithmIdentifier, this.encKey);
    }
    
    public OutputStream getOutputStream(OutputStream paramOutputStream)
    {
      return new CipherOutputStream(paramOutputStream, this.cipher);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\jcajce\JceCRMFEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */