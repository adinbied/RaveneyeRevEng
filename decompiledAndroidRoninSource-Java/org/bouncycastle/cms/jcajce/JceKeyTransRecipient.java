package org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipient;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

public abstract class JceKeyTransRecipient
  implements KeyTransRecipient
{
  protected EnvelopedDataHelper contentHelper;
  protected Map extraMappings;
  protected EnvelopedDataHelper helper;
  private PrivateKey recipientKey;
  protected boolean unwrappedKeyMustBeEncodable;
  protected boolean validateKeySize;
  
  public JceKeyTransRecipient(PrivateKey paramPrivateKey)
  {
    EnvelopedDataHelper localEnvelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    this.helper = localEnvelopedDataHelper;
    this.contentHelper = localEnvelopedDataHelper;
    this.extraMappings = new HashMap();
    this.validateKeySize = false;
    this.recipientKey = paramPrivateKey;
  }
  
  protected Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = this.helper.createAsymmetricUnwrapper(paramAlgorithmIdentifier1, this.recipientKey).setMustProduceEncodableUnwrappedKey(this.unwrappedKeyMustBeEncodable);
    if (!this.extraMappings.isEmpty())
    {
      Iterator localIterator = this.extraMappings.keySet().iterator();
      while (localIterator.hasNext())
      {
        ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localIterator.next();
        paramAlgorithmIdentifier1.setAlgorithmMapping(localASN1ObjectIdentifier, (String)this.extraMappings.get(localASN1ObjectIdentifier));
      }
    }
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
  
  public JceKeyTransRecipient setAlgorithmMapping(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    this.extraMappings.put(paramASN1ObjectIdentifier, paramString);
    return this;
  }
  
  public JceKeyTransRecipient setContentProvider(String paramString)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramString);
    return this;
  }
  
  public JceKeyTransRecipient setContentProvider(Provider paramProvider)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramProvider);
    return this;
  }
  
  public JceKeyTransRecipient setKeySizeValidation(boolean paramBoolean)
  {
    this.validateKeySize = paramBoolean;
    return this;
  }
  
  public JceKeyTransRecipient setMustProduceEncodableUnwrappedKey(boolean paramBoolean)
  {
    this.unwrappedKeyMustBeEncodable = paramBoolean;
    return this;
  }
  
  public JceKeyTransRecipient setProvider(String paramString)
  {
    paramString = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    this.helper = paramString;
    this.contentHelper = paramString;
    return this;
  }
  
  public JceKeyTransRecipient setProvider(Provider paramProvider)
  {
    paramProvider = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    this.helper = paramProvider;
    this.contentHelper = paramProvider;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyTransRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */