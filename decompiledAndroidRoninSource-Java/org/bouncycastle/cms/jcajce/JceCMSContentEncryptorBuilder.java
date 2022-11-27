package org.bouncycastle.cms.jcajce;

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
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.jcajce.JceGenericKey;

public class JceCMSContentEncryptorBuilder
{
  private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
  private AlgorithmParameters algorithmParameters;
  private final ASN1ObjectIdentifier encryptionOID;
  private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  private final int keySize;
  private SecureRandom random;
  
  public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this(paramASN1ObjectIdentifier, KEY_SIZE_PROVIDER.getKeySize(paramASN1ObjectIdentifier));
  }
  
  public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
  {
    this.encryptionOID = paramASN1ObjectIdentifier;
    int k = KEY_SIZE_PROVIDER.getKeySize(paramASN1ObjectIdentifier);
    int j;
    int i;
    if (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.des_EDE3_CBC))
    {
      j = 168;
      i = j;
      if (paramInt != 168) {
        if (paramInt == k) {
          i = j;
        } else {
          throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
        }
      }
    }
    for (;;)
    {
      this.keySize = i;
      return;
      if (!paramASN1ObjectIdentifier.equals(OIWObjectIdentifiers.desCBC)) {
        break label136;
      }
      j = 56;
      i = j;
      if (paramInt != 56)
      {
        if (paramInt != k) {
          break;
        }
        i = j;
      }
    }
    throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
    label136:
    if ((k > 0) && (k != paramInt)) {
      throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
    }
    this.keySize = paramInt;
  }
  
  public OutputEncryptor build()
    throws CMSException
  {
    return new CMSOutputEncryptor(this.encryptionOID, this.keySize, this.algorithmParameters, this.random);
  }
  
  public JceCMSContentEncryptorBuilder setAlgorithmParameters(AlgorithmParameters paramAlgorithmParameters)
  {
    this.algorithmParameters = paramAlgorithmParameters;
    return this;
  }
  
  public JceCMSContentEncryptorBuilder setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JceCMSContentEncryptorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
  
  public JceCMSContentEncryptorBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  private class CMSOutputEncryptor
    implements OutputEncryptor
  {
    private AlgorithmIdentifier algorithmIdentifier;
    private Cipher cipher;
    private SecretKey encKey;
    
    CMSOutputEncryptor(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
      throws CMSException
    {
      KeyGenerator localKeyGenerator = JceCMSContentEncryptorBuilder.this.helper.createKeyGenerator(paramASN1ObjectIdentifier);
      SecureRandom localSecureRandom = paramSecureRandom;
      if (paramSecureRandom == null) {
        localSecureRandom = new SecureRandom();
      }
      if (paramInt < 0) {
        localKeyGenerator.init(localSecureRandom);
      } else {
        localKeyGenerator.init(paramInt, localSecureRandom);
      }
      this.cipher = JceCMSContentEncryptorBuilder.this.helper.createCipher(paramASN1ObjectIdentifier);
      this.encKey = localKeyGenerator.generateKey();
      paramSecureRandom = paramAlgorithmParameters;
      if (paramAlgorithmParameters == null) {
        paramSecureRandom = JceCMSContentEncryptorBuilder.this.helper.generateParameters(paramASN1ObjectIdentifier, this.encKey, localSecureRandom);
      }
      try
      {
        this.cipher.init(1, this.encKey, paramSecureRandom, localSecureRandom);
        paramAlgorithmParameters = paramSecureRandom;
        if (paramSecureRandom == null) {
          paramAlgorithmParameters = this.cipher.getParameters();
        }
        this.algorithmIdentifier = JceCMSContentEncryptorBuilder.this.helper.getAlgorithmIdentifier(paramASN1ObjectIdentifier, paramAlgorithmParameters);
        return;
      }
      catch (GeneralSecurityException this$1)
      {
        paramASN1ObjectIdentifier = new StringBuilder();
        paramASN1ObjectIdentifier.append("unable to initialize cipher: ");
        paramASN1ObjectIdentifier.append(JceCMSContentEncryptorBuilder.this.getMessage());
        throw new CMSException(paramASN1ObjectIdentifier.toString(), JceCMSContentEncryptorBuilder.this);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceCMSContentEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */