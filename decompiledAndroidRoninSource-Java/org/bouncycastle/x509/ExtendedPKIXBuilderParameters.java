package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.util.Selector;

public class ExtendedPKIXBuilderParameters
  extends ExtendedPKIXParameters
{
  private Set excludedCerts = Collections.EMPTY_SET;
  private int maxPathLength = 5;
  
  public ExtendedPKIXBuilderParameters(Set paramSet, Selector paramSelector)
    throws InvalidAlgorithmParameterException
  {
    super(paramSet);
    setTargetConstraints(paramSelector);
  }
  
  public static ExtendedPKIXParameters getInstance(PKIXParameters paramPKIXParameters)
  {
    try
    {
      ExtendedPKIXBuilderParameters localExtendedPKIXBuilderParameters = new ExtendedPKIXBuilderParameters(paramPKIXParameters.getTrustAnchors(), X509CertStoreSelector.getInstance((X509CertSelector)paramPKIXParameters.getTargetCertConstraints()));
      localExtendedPKIXBuilderParameters.setParams(paramPKIXParameters);
      return localExtendedPKIXBuilderParameters;
    }
    catch (Exception paramPKIXParameters)
    {
      throw new RuntimeException(paramPKIXParameters.getMessage());
    }
  }
  
  public Object clone()
  {
    try
    {
      ExtendedPKIXBuilderParameters localExtendedPKIXBuilderParameters = new ExtendedPKIXBuilderParameters(getTrustAnchors(), getTargetConstraints());
      localExtendedPKIXBuilderParameters.setParams(this);
      return localExtendedPKIXBuilderParameters;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.getMessage());
    }
  }
  
  public Set getExcludedCerts()
  {
    return Collections.unmodifiableSet(this.excludedCerts);
  }
  
  public int getMaxPathLength()
  {
    return this.maxPathLength;
  }
  
  public void setExcludedCerts(Set paramSet)
  {
    if (paramSet == null)
    {
      paramSet = Collections.EMPTY_SET;
      return;
    }
    this.excludedCerts = new HashSet(paramSet);
  }
  
  public void setMaxPathLength(int paramInt)
  {
    if (paramInt >= -1)
    {
      this.maxPathLength = paramInt;
      return;
    }
    throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
  }
  
  protected void setParams(PKIXParameters paramPKIXParameters)
  {
    super.setParams(paramPKIXParameters);
    if ((paramPKIXParameters instanceof ExtendedPKIXBuilderParameters))
    {
      ExtendedPKIXBuilderParameters localExtendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters)paramPKIXParameters;
      this.maxPathLength = localExtendedPKIXBuilderParameters.maxPathLength;
      this.excludedCerts = new HashSet(localExtendedPKIXBuilderParameters.excludedCerts);
    }
    if ((paramPKIXParameters instanceof PKIXBuilderParameters)) {
      this.maxPathLength = ((PKIXBuilderParameters)paramPKIXParameters).getMaxPathLength();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\ExtendedPKIXBuilderParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */