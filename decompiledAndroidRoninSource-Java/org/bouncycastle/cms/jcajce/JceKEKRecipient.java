package org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.Provider;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KEKRecipient;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;

public abstract class JceKEKRecipient
  implements KEKRecipient
{
  protected EnvelopedDataHelper contentHelper;
  protected EnvelopedDataHelper helper;
  private SecretKey recipientKey;
  protected boolean validateKeySize;
  
  public JceKEKRecipient(SecretKey paramSecretKey)
  {
    EnvelopedDataHelper localEnvelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    this.helper = localEnvelopedDataHelper;
    this.contentHelper = localEnvelopedDataHelper;
    this.validateKeySize = false;
    this.recipientKey = paramSecretKey;
  }
  
  protected Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = this.helper.createSymmetricUnwrapper(paramAlgorithmIdentifier1, this.recipientKey);
    try
    {
      paramAlgorithmIdentifier1 = this.helper.getJceKey(paramAlgorithmIdentifier2.getAlgorithm(), paramAlgorithmIdentifier1.generateUnwrappedKey(paramAlgorithmIdentifier2, paramArrayOfByte));
      if (this.validateKeySize) {
        this.helper.keySizeCheck(paramAlgorithmIdentifier2, paramAlgorithmIdentifier1);
      }
      return paramAlgorithmIdentifier1;
    }
    catch (OperatorException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("exception unwrapping key: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
  
  public JceKEKRecipient setContentProvider(String paramString)
  {
    this.contentHelper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JceKEKRecipient setContentProvider(Provider paramProvider)
  {
    this.contentHelper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
  
  public JceKEKRecipient setKeySizeValidation(boolean paramBoolean)
  {
    this.validateKeySize = paramBoolean;
    return this;
  }
  
  public JceKEKRecipient setProvider(String paramString)
  {
    paramString = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    this.helper = paramString;
    this.contentHelper = paramString;
    return this;
  }
  
  public JceKEKRecipient setProvider(Provider paramProvider)
  {
    paramProvider = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    this.helper = paramProvider;
    this.contentHelper = paramProvider;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKEKRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */