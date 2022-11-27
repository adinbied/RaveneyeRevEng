package org.bouncycastle.cert.crmf.jcajce;

import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cert.crmf.ValueDecryptorGenerator;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

public class JceAsymmetricValueDecryptorGenerator
  implements ValueDecryptorGenerator
{
  private CRMFHelper helper = new CRMFHelper(new DefaultJcaJceHelper());
  private Provider provider = null;
  private String providerName = null;
  private PrivateKey recipientKey;
  
  public JceAsymmetricValueDecryptorGenerator(PrivateKey paramPrivateKey)
  {
    this.recipientKey = paramPrivateKey;
  }
  
  private Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CRMFException
  {
    try
    {
      paramAlgorithmIdentifier1 = new JceAsymmetricKeyUnwrapper(paramAlgorithmIdentifier1, this.recipientKey);
      if (this.provider != null) {
        paramAlgorithmIdentifier1.setProvider(this.provider);
      }
      if (this.providerName != null) {
        paramAlgorithmIdentifier1.setProvider(this.providerName);
      }
      paramAlgorithmIdentifier1 = new SecretKeySpec((byte[])paramAlgorithmIdentifier1.generateUnwrappedKey(paramAlgorithmIdentifier2, paramArrayOfByte).getRepresentation(), paramAlgorithmIdentifier2.getAlgorithm().getId());
      return paramAlgorithmIdentifier1;
    }
    catch (OperatorException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("key invalid in message: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CRMFException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
  
  public InputDecryptor getValueDecryptor(AlgorithmIdentifier paramAlgorithmIdentifier1, final AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CRMFException
  {
    paramAlgorithmIdentifier1 = extractSecretKey(paramAlgorithmIdentifier1, paramAlgorithmIdentifier2, paramArrayOfByte);
    new InputDecryptor()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier2;
      }
      
      public InputStream getInputStream(InputStream paramAnonymousInputStream)
      {
        return new CipherInputStream(paramAnonymousInputStream, this.val$dataCipher);
      }
    };
  }
  
  public JceAsymmetricValueDecryptorGenerator setProvider(String paramString)
  {
    this.helper = new CRMFHelper(new NamedJcaJceHelper(paramString));
    this.provider = null;
    this.providerName = paramString;
    return this;
  }
  
  public JceAsymmetricValueDecryptorGenerator setProvider(Provider paramProvider)
  {
    this.helper = new CRMFHelper(new ProviderJcaJceHelper(paramProvider));
    this.provider = paramProvider;
    this.providerName = null;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\jcajce\JceAsymmetricValueDecryptorGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */