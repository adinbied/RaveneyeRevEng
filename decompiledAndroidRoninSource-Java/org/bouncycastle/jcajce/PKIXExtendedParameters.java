package org.bouncycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.x509.GeneralName;

public class PKIXExtendedParameters
  implements CertPathParameters
{
  public static final int CHAIN_VALIDITY_MODEL = 1;
  public static final int PKIX_VALIDITY_MODEL = 0;
  private final PKIXParameters baseParameters;
  private final Date date;
  private final List<PKIXCRLStore> extraCRLStores;
  private final List<PKIXCertStore> extraCertStores;
  private final Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
  private final Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
  private final boolean revocationEnabled;
  private final PKIXCertStoreSelector targetConstraints;
  private final Set<TrustAnchor> trustAnchors;
  private final boolean useDeltas;
  private final int validityModel;
  
  private PKIXExtendedParameters(Builder paramBuilder)
  {
    this.baseParameters = paramBuilder.baseParameters;
    this.date = paramBuilder.date;
    this.extraCertStores = Collections.unmodifiableList(paramBuilder.extraCertStores);
    this.namedCertificateStoreMap = Collections.unmodifiableMap(new HashMap(paramBuilder.namedCertificateStoreMap));
    this.extraCRLStores = Collections.unmodifiableList(paramBuilder.extraCRLStores);
    this.namedCRLStoreMap = Collections.unmodifiableMap(new HashMap(paramBuilder.namedCRLStoreMap));
    this.targetConstraints = paramBuilder.targetConstraints;
    this.revocationEnabled = paramBuilder.revocationEnabled;
    this.useDeltas = paramBuilder.useDeltas;
    this.validityModel = paramBuilder.validityModel;
    this.trustAnchors = Collections.unmodifiableSet(paramBuilder.trustAnchors);
  }
  
  public Object clone()
  {
    return this;
  }
  
  public List<PKIXCRLStore> getCRLStores()
  {
    return this.extraCRLStores;
  }
  
  public List getCertPathCheckers()
  {
    return this.baseParameters.getCertPathCheckers();
  }
  
  public List<CertStore> getCertStores()
  {
    return this.baseParameters.getCertStores();
  }
  
  public List<PKIXCertStore> getCertificateStores()
  {
    return this.extraCertStores;
  }
  
  public Date getDate()
  {
    return new Date(this.date.getTime());
  }
  
  public Set getInitialPolicies()
  {
    return this.baseParameters.getInitialPolicies();
  }
  
  public Map<GeneralName, PKIXCRLStore> getNamedCRLStoreMap()
  {
    return this.namedCRLStoreMap;
  }
  
  public Map<GeneralName, PKIXCertStore> getNamedCertificateStoreMap()
  {
    return this.namedCertificateStoreMap;
  }
  
  public String getSigProvider()
  {
    return this.baseParameters.getSigProvider();
  }
  
  public PKIXCertStoreSelector getTargetConstraints()
  {
    return this.targetConstraints;
  }
  
  public Set getTrustAnchors()
  {
    return this.trustAnchors;
  }
  
  public int getValidityModel()
  {
    return this.validityModel;
  }
  
  public boolean isAnyPolicyInhibited()
  {
    return this.baseParameters.isAnyPolicyInhibited();
  }
  
  public boolean isExplicitPolicyRequired()
  {
    return this.baseParameters.isExplicitPolicyRequired();
  }
  
  public boolean isPolicyMappingInhibited()
  {
    return this.baseParameters.isPolicyMappingInhibited();
  }
  
  public boolean isRevocationEnabled()
  {
    return this.revocationEnabled;
  }
  
  public boolean isUseDeltasEnabled()
  {
    return this.useDeltas;
  }
  
  public static class Builder
  {
    private final PKIXParameters baseParameters;
    private final Date date;
    private List<PKIXCRLStore> extraCRLStores = new ArrayList();
    private List<PKIXCertStore> extraCertStores = new ArrayList();
    private Map<GeneralName, PKIXCRLStore> namedCRLStoreMap = new HashMap();
    private Map<GeneralName, PKIXCertStore> namedCertificateStoreMap = new HashMap();
    private boolean revocationEnabled;
    private PKIXCertStoreSelector targetConstraints;
    private Set<TrustAnchor> trustAnchors;
    private boolean useDeltas = false;
    private int validityModel = 0;
    
    public Builder(PKIXParameters paramPKIXParameters)
    {
      this.baseParameters = ((PKIXParameters)paramPKIXParameters.clone());
      Object localObject = paramPKIXParameters.getTargetCertConstraints();
      if (localObject != null) {
        this.targetConstraints = new PKIXCertStoreSelector.Builder((CertSelector)localObject).build();
      }
      Date localDate = paramPKIXParameters.getDate();
      localObject = localDate;
      if (localDate == null) {
        localObject = new Date();
      }
      this.date = ((Date)localObject);
      this.revocationEnabled = paramPKIXParameters.isRevocationEnabled();
      this.trustAnchors = paramPKIXParameters.getTrustAnchors();
    }
    
    public Builder(PKIXExtendedParameters paramPKIXExtendedParameters)
    {
      this.baseParameters = paramPKIXExtendedParameters.baseParameters;
      this.date = paramPKIXExtendedParameters.date;
      this.targetConstraints = paramPKIXExtendedParameters.targetConstraints;
      this.extraCertStores = new ArrayList(paramPKIXExtendedParameters.extraCertStores);
      this.namedCertificateStoreMap = new HashMap(paramPKIXExtendedParameters.namedCertificateStoreMap);
      this.extraCRLStores = new ArrayList(paramPKIXExtendedParameters.extraCRLStores);
      this.namedCRLStoreMap = new HashMap(paramPKIXExtendedParameters.namedCRLStoreMap);
      this.useDeltas = paramPKIXExtendedParameters.useDeltas;
      this.validityModel = paramPKIXExtendedParameters.validityModel;
      this.revocationEnabled = paramPKIXExtendedParameters.isRevocationEnabled();
      this.trustAnchors = paramPKIXExtendedParameters.getTrustAnchors();
    }
    
    public Builder addCRLStore(PKIXCRLStore paramPKIXCRLStore)
    {
      this.extraCRLStores.add(paramPKIXCRLStore);
      return this;
    }
    
    public Builder addCertificateStore(PKIXCertStore paramPKIXCertStore)
    {
      this.extraCertStores.add(paramPKIXCertStore);
      return this;
    }
    
    public Builder addNamedCRLStore(GeneralName paramGeneralName, PKIXCRLStore paramPKIXCRLStore)
    {
      this.namedCRLStoreMap.put(paramGeneralName, paramPKIXCRLStore);
      return this;
    }
    
    public Builder addNamedCertificateStore(GeneralName paramGeneralName, PKIXCertStore paramPKIXCertStore)
    {
      this.namedCertificateStoreMap.put(paramGeneralName, paramPKIXCertStore);
      return this;
    }
    
    public PKIXExtendedParameters build()
    {
      return new PKIXExtendedParameters(this, null);
    }
    
    public void setRevocationEnabled(boolean paramBoolean)
    {
      this.revocationEnabled = paramBoolean;
    }
    
    public Builder setTargetConstraints(PKIXCertStoreSelector paramPKIXCertStoreSelector)
    {
      this.targetConstraints = paramPKIXCertStoreSelector;
      return this;
    }
    
    public Builder setTrustAnchor(TrustAnchor paramTrustAnchor)
    {
      this.trustAnchors = Collections.singleton(paramTrustAnchor);
      return this;
    }
    
    public Builder setTrustAnchors(Set<TrustAnchor> paramSet)
    {
      this.trustAnchors = paramSet;
      return this;
    }
    
    public Builder setUseDeltasEnabled(boolean paramBoolean)
    {
      this.useDeltas = paramBoolean;
      return this;
    }
    
    public Builder setValidityModel(int paramInt)
    {
      this.validityModel = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKIXExtendedParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */