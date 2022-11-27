package org.bouncycastle.cms.jcajce;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;

public class JceAlgorithmIdentifierConverter
{
  private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  private SecureRandom random;
  
  public AlgorithmParameters getAlgorithmParameters(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CMSException
  {
    if (paramAlgorithmIdentifier.getParameters() == null) {
      return null;
    }
    try
    {
      AlgorithmParameters localAlgorithmParameters = this.helper.createAlgorithmParameters(paramAlgorithmIdentifier.getAlgorithm());
      CMSUtils.loadParameters(localAlgorithmParameters, paramAlgorithmIdentifier.getParameters());
      return localAlgorithmParameters;
    }
    catch (NoSuchProviderException paramAlgorithmIdentifier)
    {
      throw new CMSException("can't find provider for algorithm", paramAlgorithmIdentifier);
    }
    catch (NoSuchAlgorithmException paramAlgorithmIdentifier)
    {
      throw new CMSException("can't find parameters for algorithm", paramAlgorithmIdentifier);
    }
  }
  
  public JceAlgorithmIdentifierConverter setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JceAlgorithmIdentifierConverter setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceAlgorithmIdentifierConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */