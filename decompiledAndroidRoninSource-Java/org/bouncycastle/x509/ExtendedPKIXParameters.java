package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

public class ExtendedPKIXParameters
  extends PKIXParameters
{
  public static final int CHAIN_VALIDITY_MODEL = 1;
  public static final int PKIX_VALIDITY_MODEL = 0;
  private boolean additionalLocationsEnabled;
  private List additionalStores = new ArrayList();
  private Set attrCertCheckers = new HashSet();
  private Set necessaryACAttributes = new HashSet();
  private Set prohibitedACAttributes = new HashSet();
  private Selector selector;
  private List stores = new ArrayList();
  private Set trustedACIssuers = new HashSet();
  private boolean useDeltas = false;
  private int validityModel = 0;
  
  public ExtendedPKIXParameters(Set paramSet)
    throws InvalidAlgorithmParameterException
  {
    super(paramSet);
  }
  
  public static ExtendedPKIXParameters getInstance(PKIXParameters paramPKIXParameters)
  {
    try
    {
      ExtendedPKIXParameters localExtendedPKIXParameters = new ExtendedPKIXParameters(paramPKIXParameters.getTrustAnchors());
      localExtendedPKIXParameters.setParams(paramPKIXParameters);
      return localExtendedPKIXParameters;
    }
    catch (Exception paramPKIXParameters)
    {
      throw new RuntimeException(paramPKIXParameters.getMessage());
    }
  }
  
  public void addAddionalStore(Store paramStore)
  {
    addAdditionalStore(paramStore);
  }
  
  public void addAdditionalStore(Store paramStore)
  {
    if (paramStore != null) {
      this.additionalStores.add(paramStore);
    }
  }
  
  public void addStore(Store paramStore)
  {
    if (paramStore != null) {
      this.stores.add(paramStore);
    }
  }
  
  public Object clone()
  {
    try
    {
      ExtendedPKIXParameters localExtendedPKIXParameters = new ExtendedPKIXParameters(getTrustAnchors());
      localExtendedPKIXParameters.setParams(this);
      return localExtendedPKIXParameters;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.getMessage());
    }
  }
  
  public List getAdditionalStores()
  {
    return Collections.unmodifiableList(this.additionalStores);
  }
  
  public Set getAttrCertCheckers()
  {
    return Collections.unmodifiableSet(this.attrCertCheckers);
  }
  
  public Set getNecessaryACAttributes()
  {
    return Collections.unmodifiableSet(this.necessaryACAttributes);
  }
  
  public Set getProhibitedACAttributes()
  {
    return Collections.unmodifiableSet(this.prohibitedACAttributes);
  }
  
  public List getStores()
  {
    return Collections.unmodifiableList(new ArrayList(this.stores));
  }
  
  public Selector getTargetConstraints()
  {
    Selector localSelector = this.selector;
    if (localSelector != null) {
      return (Selector)localSelector.clone();
    }
    return null;
  }
  
  public Set getTrustedACIssuers()
  {
    return Collections.unmodifiableSet(this.trustedACIssuers);
  }
  
  public int getValidityModel()
  {
    return this.validityModel;
  }
  
  public boolean isAdditionalLocationsEnabled()
  {
    return this.additionalLocationsEnabled;
  }
  
  public boolean isUseDeltasEnabled()
  {
    return this.useDeltas;
  }
  
  public void setAdditionalLocationsEnabled(boolean paramBoolean)
  {
    this.additionalLocationsEnabled = paramBoolean;
  }
  
  public void setAttrCertCheckers(Set paramSet)
  {
    if (paramSet == null)
    {
      this.attrCertCheckers.clear();
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof PKIXAttrCertChecker))
      {
        paramSet = new StringBuilder();
        paramSet.append("All elements of set must be of type ");
        paramSet.append(PKIXAttrCertChecker.class.getName());
        paramSet.append(".");
        throw new ClassCastException(paramSet.toString());
      }
    }
    this.attrCertCheckers.clear();
    this.attrCertCheckers.addAll(paramSet);
  }
  
  public void setCertStores(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addCertStore((CertStore)paramList.next());
      }
    }
  }
  
  public void setNecessaryACAttributes(Set paramSet)
  {
    if (paramSet == null)
    {
      this.necessaryACAttributes.clear();
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof String)) {
        throw new ClassCastException("All elements of set must be of type String.");
      }
    }
    this.necessaryACAttributes.clear();
    this.necessaryACAttributes.addAll(paramSet);
  }
  
  protected void setParams(PKIXParameters paramPKIXParameters)
  {
    setDate(paramPKIXParameters.getDate());
    setCertPathCheckers(paramPKIXParameters.getCertPathCheckers());
    setCertStores(paramPKIXParameters.getCertStores());
    setAnyPolicyInhibited(paramPKIXParameters.isAnyPolicyInhibited());
    setExplicitPolicyRequired(paramPKIXParameters.isExplicitPolicyRequired());
    setPolicyMappingInhibited(paramPKIXParameters.isPolicyMappingInhibited());
    setRevocationEnabled(paramPKIXParameters.isRevocationEnabled());
    setInitialPolicies(paramPKIXParameters.getInitialPolicies());
    setPolicyQualifiersRejected(paramPKIXParameters.getPolicyQualifiersRejected());
    setSigProvider(paramPKIXParameters.getSigProvider());
    setTargetCertConstraints(paramPKIXParameters.getTargetCertConstraints());
    try
    {
      setTrustAnchors(paramPKIXParameters.getTrustAnchors());
      if ((paramPKIXParameters instanceof ExtendedPKIXParameters))
      {
        ExtendedPKIXParameters localExtendedPKIXParameters = (ExtendedPKIXParameters)paramPKIXParameters;
        this.validityModel = localExtendedPKIXParameters.validityModel;
        this.useDeltas = localExtendedPKIXParameters.useDeltas;
        this.additionalLocationsEnabled = localExtendedPKIXParameters.additionalLocationsEnabled;
        paramPKIXParameters = localExtendedPKIXParameters.selector;
        if (paramPKIXParameters == null) {
          paramPKIXParameters = null;
        } else {
          paramPKIXParameters = (Selector)paramPKIXParameters.clone();
        }
        this.selector = paramPKIXParameters;
        this.stores = new ArrayList(localExtendedPKIXParameters.stores);
        this.additionalStores = new ArrayList(localExtendedPKIXParameters.additionalStores);
        this.trustedACIssuers = new HashSet(localExtendedPKIXParameters.trustedACIssuers);
        this.prohibitedACAttributes = new HashSet(localExtendedPKIXParameters.prohibitedACAttributes);
        this.necessaryACAttributes = new HashSet(localExtendedPKIXParameters.necessaryACAttributes);
        this.attrCertCheckers = new HashSet(localExtendedPKIXParameters.attrCertCheckers);
      }
      return;
    }
    catch (Exception paramPKIXParameters)
    {
      throw new RuntimeException(paramPKIXParameters.getMessage());
    }
  }
  
  public void setProhibitedACAttributes(Set paramSet)
  {
    if (paramSet == null)
    {
      this.prohibitedACAttributes.clear();
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof String)) {
        throw new ClassCastException("All elements of set must be of type String.");
      }
    }
    this.prohibitedACAttributes.clear();
    this.prohibitedACAttributes.addAll(paramSet);
  }
  
  public void setStores(List paramList)
  {
    if (paramList == null)
    {
      this.stores = new ArrayList();
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Store)) {
        throw new ClassCastException("All elements of list must be of type org.bouncycastle.util.Store.");
      }
    }
    this.stores = new ArrayList(paramList);
  }
  
  public void setTargetCertConstraints(CertSelector paramCertSelector)
  {
    super.setTargetCertConstraints(paramCertSelector);
    if (paramCertSelector != null) {
      paramCertSelector = X509CertStoreSelector.getInstance((X509CertSelector)paramCertSelector);
    } else {
      paramCertSelector = null;
    }
    this.selector = paramCertSelector;
  }
  
  public void setTargetConstraints(Selector paramSelector)
  {
    if (paramSelector != null) {
      paramSelector = (Selector)paramSelector.clone();
    } else {
      paramSelector = null;
    }
    this.selector = paramSelector;
  }
  
  public void setTrustedACIssuers(Set paramSet)
  {
    if (paramSet == null)
    {
      this.trustedACIssuers.clear();
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof TrustAnchor))
      {
        paramSet = new StringBuilder();
        paramSet.append("All elements of set must be of type ");
        paramSet.append(TrustAnchor.class.getName());
        paramSet.append(".");
        throw new ClassCastException(paramSet.toString());
      }
    }
    this.trustedACIssuers.clear();
    this.trustedACIssuers.addAll(paramSet);
  }
  
  public void setUseDeltasEnabled(boolean paramBoolean)
  {
    this.useDeltas = paramBoolean;
  }
  
  public void setValidityModel(int paramInt)
  {
    this.validityModel = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\ExtendedPKIXParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */