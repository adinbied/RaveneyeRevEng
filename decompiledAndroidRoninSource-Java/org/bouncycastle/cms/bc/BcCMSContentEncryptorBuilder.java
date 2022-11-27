package org.bouncycastle.cms.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.util.Integers;

public class BcCMSContentEncryptorBuilder
{
  private static Map keySizes;
  private final ASN1ObjectIdentifier encryptionOID;
  private EnvelopedDataHelper helper = new EnvelopedDataHelper();
  private final int keySize;
  private SecureRandom random;
  
  static
  {
    HashMap localHashMap = new HashMap();
    keySizes = localHashMap;
    localHashMap.put(CMSAlgorithm.AES128_CBC, Integers.valueOf(128));
    keySizes.put(CMSAlgorithm.AES192_CBC, Integers.valueOf(192));
    keySizes.put(CMSAlgorithm.AES256_CBC, Integers.valueOf(256));
    keySizes.put(CMSAlgorithm.CAMELLIA128_CBC, Integers.valueOf(128));
    keySizes.put(CMSAlgorithm.CAMELLIA192_CBC, Integers.valueOf(192));
    keySizes.put(CMSAlgorithm.CAMELLIA256_CBC, Integers.valueOf(256));
  }
  
  public BcCMSContentEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this(paramASN1ObjectIdentifier, getKeySize(paramASN1ObjectIdentifier));
  }
  
  public BcCMSContentEncryptorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
  {
    this.encryptionOID = paramASN1ObjectIdentifier;
    this.keySize = paramInt;
  }
  
  private static int getKeySize(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    paramASN1ObjectIdentifier = (Integer)keySizes.get(paramASN1ObjectIdentifier);
    if (paramASN1ObjectIdentifier != null) {
      return paramASN1ObjectIdentifier.intValue();
    }
    return -1;
  }
  
  public OutputEncryptor build()
    throws CMSException
  {
    return new CMSOutputEncryptor(this.encryptionOID, this.keySize, this.random);
  }
  
  public BcCMSContentEncryptorBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  private class CMSOutputEncryptor
    implements OutputEncryptor
  {
    private AlgorithmIdentifier algorithmIdentifier;
    private Object cipher;
    private KeyParameter encKey;
    
    CMSOutputEncryptor(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, SecureRandom paramSecureRandom)
      throws CMSException
    {
      SecureRandom localSecureRandom = paramSecureRandom;
      if (paramSecureRandom == null) {
        localSecureRandom = new SecureRandom();
      }
      this.encKey = new KeyParameter(BcCMSContentEncryptorBuilder.this.helper.createKeyGenerator(paramASN1ObjectIdentifier, localSecureRandom).generateKey());
      this.algorithmIdentifier = BcCMSContentEncryptorBuilder.this.helper.generateAlgorithmIdentifier(paramASN1ObjectIdentifier, this.encKey, localSecureRandom);
      this.cipher = EnvelopedDataHelper.createContentCipher(true, this.encKey, this.algorithmIdentifier);
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return this.algorithmIdentifier;
    }
    
    public GenericKey getKey()
    {
      return new GenericKey(this.algorithmIdentifier, this.encKey.getKey());
    }
    
    public OutputStream getOutputStream(OutputStream paramOutputStream)
    {
      if ((this.cipher instanceof BufferedBlockCipher)) {
        return new CipherOutputStream(paramOutputStream, (BufferedBlockCipher)this.cipher);
      }
      return new CipherOutputStream(paramOutputStream, (StreamCipher)this.cipher);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcCMSContentEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */