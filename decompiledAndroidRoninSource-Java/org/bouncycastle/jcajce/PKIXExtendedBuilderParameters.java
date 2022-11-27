package org.bouncycastle.jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PKIXExtendedBuilderParameters
  implements CertPathParameters
{
  private final PKIXExtendedParameters baseParameters;
  private final Set<X509Certificate> excludedCerts;
  private final int maxPathLength;
  
  private PKIXExtendedBuilderParameters(Builder paramBuilder)
  {
    this.baseParameters = paramBuilder.baseParameters;
    this.excludedCerts = Collections.unmodifiableSet(paramBuilder.excludedCerts);
    this.maxPathLength = paramBuilder.maxPathLength;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public PKIXExtendedParameters getBaseParameters()
  {
    return this.baseParameters;
  }
  
  public Set getExcludedCerts()
  {
    return this.excludedCerts;
  }
  
  public int getMaxPathLength()
  {
    return this.maxPathLength;
  }
  
  public static class Builder
  {
    private final PKIXExtendedParameters baseParameters;
    private Set<X509Certificate> excludedCerts = new HashSet();
    private int maxPathLength = 5;
    
    public Builder(PKIXBuilderParameters paramPKIXBuilderParameters)
    {
      this.baseParameters = new PKIXExtendedParameters.Builder(paramPKIXBuilderParameters).build();
      this.maxPathLength = paramPKIXBuilderParameters.getMaxPathLength();
    }
    
    public Builder(PKIXExtendedParameters paramPKIXExtendedParameters)
    {
      this.baseParameters = paramPKIXExtendedParameters;
    }
    
    public Builder addExcludedCerts(Set<X509Certificate> paramSet)
    {
      this.excludedCerts.addAll(paramSet);
      return this;
    }
    
    public PKIXExtendedBuilderParameters build()
    {
      return new PKIXExtendedBuilderParameters(this, null);
    }
    
    public Builder setMaxPathLength(int paramInt)
    {
      if (paramInt >= -1)
      {
        this.maxPathLength = paramInt;
        return this;
      }
      throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKIXExtendedBuilderParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */