package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.security.cert.LDAPCertStoreParameters;
import org.bouncycastle.x509.X509StoreParameters;

public class X509LDAPCertStoreParameters
  implements X509StoreParameters, CertStoreParameters
{
  private String aACertificateAttribute;
  private String aACertificateSubjectAttributeName;
  private String attributeAuthorityRevocationListAttribute;
  private String attributeAuthorityRevocationListIssuerAttributeName;
  private String attributeCertificateAttributeAttribute;
  private String attributeCertificateAttributeSubjectAttributeName;
  private String attributeCertificateRevocationListAttribute;
  private String attributeCertificateRevocationListIssuerAttributeName;
  private String attributeDescriptorCertificateAttribute;
  private String attributeDescriptorCertificateSubjectAttributeName;
  private String authorityRevocationListAttribute;
  private String authorityRevocationListIssuerAttributeName;
  private String baseDN;
  private String cACertificateAttribute;
  private String cACertificateSubjectAttributeName;
  private String certificateRevocationListAttribute;
  private String certificateRevocationListIssuerAttributeName;
  private String crossCertificateAttribute;
  private String crossCertificateSubjectAttributeName;
  private String deltaRevocationListAttribute;
  private String deltaRevocationListIssuerAttributeName;
  private String ldapAACertificateAttributeName;
  private String ldapAttributeAuthorityRevocationListAttributeName;
  private String ldapAttributeCertificateAttributeAttributeName;
  private String ldapAttributeCertificateRevocationListAttributeName;
  private String ldapAttributeDescriptorCertificateAttributeName;
  private String ldapAuthorityRevocationListAttributeName;
  private String ldapCACertificateAttributeName;
  private String ldapCertificateRevocationListAttributeName;
  private String ldapCrossCertificateAttributeName;
  private String ldapDeltaRevocationListAttributeName;
  private String ldapURL;
  private String ldapUserCertificateAttributeName;
  private String searchForSerialNumberIn;
  private String userCertificateAttribute;
  private String userCertificateSubjectAttributeName;
  
  private X509LDAPCertStoreParameters(Builder paramBuilder)
  {
    this.ldapURL = paramBuilder.ldapURL;
    this.baseDN = paramBuilder.baseDN;
    this.userCertificateAttribute = paramBuilder.userCertificateAttribute;
    this.cACertificateAttribute = paramBuilder.cACertificateAttribute;
    this.crossCertificateAttribute = paramBuilder.crossCertificateAttribute;
    this.certificateRevocationListAttribute = paramBuilder.certificateRevocationListAttribute;
    this.deltaRevocationListAttribute = paramBuilder.deltaRevocationListAttribute;
    this.authorityRevocationListAttribute = paramBuilder.authorityRevocationListAttribute;
    this.attributeCertificateAttributeAttribute = paramBuilder.attributeCertificateAttributeAttribute;
    this.aACertificateAttribute = paramBuilder.aACertificateAttribute;
    this.attributeDescriptorCertificateAttribute = paramBuilder.attributeDescriptorCertificateAttribute;
    this.attributeCertificateRevocationListAttribute = paramBuilder.attributeCertificateRevocationListAttribute;
    this.attributeAuthorityRevocationListAttribute = paramBuilder.attributeAuthorityRevocationListAttribute;
    this.ldapUserCertificateAttributeName = paramBuilder.ldapUserCertificateAttributeName;
    this.ldapCACertificateAttributeName = paramBuilder.ldapCACertificateAttributeName;
    this.ldapCrossCertificateAttributeName = paramBuilder.ldapCrossCertificateAttributeName;
    this.ldapCertificateRevocationListAttributeName = paramBuilder.ldapCertificateRevocationListAttributeName;
    this.ldapDeltaRevocationListAttributeName = paramBuilder.ldapDeltaRevocationListAttributeName;
    this.ldapAuthorityRevocationListAttributeName = paramBuilder.ldapAuthorityRevocationListAttributeName;
    this.ldapAttributeCertificateAttributeAttributeName = paramBuilder.ldapAttributeCertificateAttributeAttributeName;
    this.ldapAACertificateAttributeName = paramBuilder.ldapAACertificateAttributeName;
    this.ldapAttributeDescriptorCertificateAttributeName = paramBuilder.ldapAttributeDescriptorCertificateAttributeName;
    this.ldapAttributeCertificateRevocationListAttributeName = paramBuilder.ldapAttributeCertificateRevocationListAttributeName;
    this.ldapAttributeAuthorityRevocationListAttributeName = paramBuilder.ldapAttributeAuthorityRevocationListAttributeName;
    this.userCertificateSubjectAttributeName = paramBuilder.userCertificateSubjectAttributeName;
    this.cACertificateSubjectAttributeName = paramBuilder.cACertificateSubjectAttributeName;
    this.crossCertificateSubjectAttributeName = paramBuilder.crossCertificateSubjectAttributeName;
    this.certificateRevocationListIssuerAttributeName = paramBuilder.certificateRevocationListIssuerAttributeName;
    this.deltaRevocationListIssuerAttributeName = paramBuilder.deltaRevocationListIssuerAttributeName;
    this.authorityRevocationListIssuerAttributeName = paramBuilder.authorityRevocationListIssuerAttributeName;
    this.attributeCertificateAttributeSubjectAttributeName = paramBuilder.attributeCertificateAttributeSubjectAttributeName;
    this.aACertificateSubjectAttributeName = paramBuilder.aACertificateSubjectAttributeName;
    this.attributeDescriptorCertificateSubjectAttributeName = paramBuilder.attributeDescriptorCertificateSubjectAttributeName;
    this.attributeCertificateRevocationListIssuerAttributeName = paramBuilder.attributeCertificateRevocationListIssuerAttributeName;
    this.attributeAuthorityRevocationListIssuerAttributeName = paramBuilder.attributeAuthorityRevocationListIssuerAttributeName;
    this.searchForSerialNumberIn = paramBuilder.searchForSerialNumberIn;
  }
  
  private int addHashCode(int paramInt, Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return paramInt * 29 + i;
  }
  
  private boolean checkField(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 == null) {
      return false;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static X509LDAPCertStoreParameters getInstance(LDAPCertStoreParameters paramLDAPCertStoreParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ldap://");
    localStringBuilder.append(paramLDAPCertStoreParameters.getServerName());
    localStringBuilder.append(":");
    localStringBuilder.append(paramLDAPCertStoreParameters.getPort());
    return new Builder(localStringBuilder.toString(), "").build();
  }
  
  public Object clone()
  {
    return this;
  }
  
  public boolean equal(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof X509LDAPCertStoreParameters)) {
      return false;
    }
    paramObject = (X509LDAPCertStoreParameters)paramObject;
    return (checkField(this.ldapURL, ((X509LDAPCertStoreParameters)paramObject).ldapURL)) && (checkField(this.baseDN, ((X509LDAPCertStoreParameters)paramObject).baseDN)) && (checkField(this.userCertificateAttribute, ((X509LDAPCertStoreParameters)paramObject).userCertificateAttribute)) && (checkField(this.cACertificateAttribute, ((X509LDAPCertStoreParameters)paramObject).cACertificateAttribute)) && (checkField(this.crossCertificateAttribute, ((X509LDAPCertStoreParameters)paramObject).crossCertificateAttribute)) && (checkField(this.certificateRevocationListAttribute, ((X509LDAPCertStoreParameters)paramObject).certificateRevocationListAttribute)) && (checkField(this.deltaRevocationListAttribute, ((X509LDAPCertStoreParameters)paramObject).deltaRevocationListAttribute)) && (checkField(this.authorityRevocationListAttribute, ((X509LDAPCertStoreParameters)paramObject).authorityRevocationListAttribute)) && (checkField(this.attributeCertificateAttributeAttribute, ((X509LDAPCertStoreParameters)paramObject).attributeCertificateAttributeAttribute)) && (checkField(this.aACertificateAttribute, ((X509LDAPCertStoreParameters)paramObject).aACertificateAttribute)) && (checkField(this.attributeDescriptorCertificateAttribute, ((X509LDAPCertStoreParameters)paramObject).attributeDescriptorCertificateAttribute)) && (checkField(this.attributeCertificateRevocationListAttribute, ((X509LDAPCertStoreParameters)paramObject).attributeCertificateRevocationListAttribute)) && (checkField(this.attributeAuthorityRevocationListAttribute, ((X509LDAPCertStoreParameters)paramObject).attributeAuthorityRevocationListAttribute)) && (checkField(this.ldapUserCertificateAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapUserCertificateAttributeName)) && (checkField(this.ldapCACertificateAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapCACertificateAttributeName)) && (checkField(this.ldapCrossCertificateAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapCrossCertificateAttributeName)) && (checkField(this.ldapCertificateRevocationListAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapCertificateRevocationListAttributeName)) && (checkField(this.ldapDeltaRevocationListAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapDeltaRevocationListAttributeName)) && (checkField(this.ldapAuthorityRevocationListAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAuthorityRevocationListAttributeName)) && (checkField(this.ldapAttributeCertificateAttributeAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAttributeCertificateAttributeAttributeName)) && (checkField(this.ldapAACertificateAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAACertificateAttributeName)) && (checkField(this.ldapAttributeDescriptorCertificateAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAttributeDescriptorCertificateAttributeName)) && (checkField(this.ldapAttributeCertificateRevocationListAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAttributeCertificateRevocationListAttributeName)) && (checkField(this.ldapAttributeAuthorityRevocationListAttributeName, ((X509LDAPCertStoreParameters)paramObject).ldapAttributeAuthorityRevocationListAttributeName)) && (checkField(this.userCertificateSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).userCertificateSubjectAttributeName)) && (checkField(this.cACertificateSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).cACertificateSubjectAttributeName)) && (checkField(this.crossCertificateSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).crossCertificateSubjectAttributeName)) && (checkField(this.certificateRevocationListIssuerAttributeName, ((X509LDAPCertStoreParameters)paramObject).certificateRevocationListIssuerAttributeName)) && (checkField(this.deltaRevocationListIssuerAttributeName, ((X509LDAPCertStoreParameters)paramObject).deltaRevocationListIssuerAttributeName)) && (checkField(this.authorityRevocationListIssuerAttributeName, ((X509LDAPCertStoreParameters)paramObject).authorityRevocationListIssuerAttributeName)) && (checkField(this.attributeCertificateAttributeSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).attributeCertificateAttributeSubjectAttributeName)) && (checkField(this.aACertificateSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).aACertificateSubjectAttributeName)) && (checkField(this.attributeDescriptorCertificateSubjectAttributeName, ((X509LDAPCertStoreParameters)paramObject).attributeDescriptorCertificateSubjectAttributeName)) && (checkField(this.attributeCertificateRevocationListIssuerAttributeName, ((X509LDAPCertStoreParameters)paramObject).attributeCertificateRevocationListIssuerAttributeName)) && (checkField(this.attributeAuthorityRevocationListIssuerAttributeName, ((X509LDAPCertStoreParameters)paramObject).attributeAuthorityRevocationListIssuerAttributeName)) && (checkField(this.searchForSerialNumberIn, ((X509LDAPCertStoreParameters)paramObject).searchForSerialNumberIn));
  }
  
  public String getAACertificateAttribute()
  {
    return this.aACertificateAttribute;
  }
  
  public String getAACertificateSubjectAttributeName()
  {
    return this.aACertificateSubjectAttributeName;
  }
  
  public String getAttributeAuthorityRevocationListAttribute()
  {
    return this.attributeAuthorityRevocationListAttribute;
  }
  
  public String getAttributeAuthorityRevocationListIssuerAttributeName()
  {
    return this.attributeAuthorityRevocationListIssuerAttributeName;
  }
  
  public String getAttributeCertificateAttributeAttribute()
  {
    return this.attributeCertificateAttributeAttribute;
  }
  
  public String getAttributeCertificateAttributeSubjectAttributeName()
  {
    return this.attributeCertificateAttributeSubjectAttributeName;
  }
  
  public String getAttributeCertificateRevocationListAttribute()
  {
    return this.attributeCertificateRevocationListAttribute;
  }
  
  public String getAttributeCertificateRevocationListIssuerAttributeName()
  {
    return this.attributeCertificateRevocationListIssuerAttributeName;
  }
  
  public String getAttributeDescriptorCertificateAttribute()
  {
    return this.attributeDescriptorCertificateAttribute;
  }
  
  public String getAttributeDescriptorCertificateSubjectAttributeName()
  {
    return this.attributeDescriptorCertificateSubjectAttributeName;
  }
  
  public String getAuthorityRevocationListAttribute()
  {
    return this.authorityRevocationListAttribute;
  }
  
  public String getAuthorityRevocationListIssuerAttributeName()
  {
    return this.authorityRevocationListIssuerAttributeName;
  }
  
  public String getBaseDN()
  {
    return this.baseDN;
  }
  
  public String getCACertificateAttribute()
  {
    return this.cACertificateAttribute;
  }
  
  public String getCACertificateSubjectAttributeName()
  {
    return this.cACertificateSubjectAttributeName;
  }
  
  public String getCertificateRevocationListAttribute()
  {
    return this.certificateRevocationListAttribute;
  }
  
  public String getCertificateRevocationListIssuerAttributeName()
  {
    return this.certificateRevocationListIssuerAttributeName;
  }
  
  public String getCrossCertificateAttribute()
  {
    return this.crossCertificateAttribute;
  }
  
  public String getCrossCertificateSubjectAttributeName()
  {
    return this.crossCertificateSubjectAttributeName;
  }
  
  public String getDeltaRevocationListAttribute()
  {
    return this.deltaRevocationListAttribute;
  }
  
  public String getDeltaRevocationListIssuerAttributeName()
  {
    return this.deltaRevocationListIssuerAttributeName;
  }
  
  public String getLdapAACertificateAttributeName()
  {
    return this.ldapAACertificateAttributeName;
  }
  
  public String getLdapAttributeAuthorityRevocationListAttributeName()
  {
    return this.ldapAttributeAuthorityRevocationListAttributeName;
  }
  
  public String getLdapAttributeCertificateAttributeAttributeName()
  {
    return this.ldapAttributeCertificateAttributeAttributeName;
  }
  
  public String getLdapAttributeCertificateRevocationListAttributeName()
  {
    return this.ldapAttributeCertificateRevocationListAttributeName;
  }
  
  public String getLdapAttributeDescriptorCertificateAttributeName()
  {
    return this.ldapAttributeDescriptorCertificateAttributeName;
  }
  
  public String getLdapAuthorityRevocationListAttributeName()
  {
    return this.ldapAuthorityRevocationListAttributeName;
  }
  
  public String getLdapCACertificateAttributeName()
  {
    return this.ldapCACertificateAttributeName;
  }
  
  public String getLdapCertificateRevocationListAttributeName()
  {
    return this.ldapCertificateRevocationListAttributeName;
  }
  
  public String getLdapCrossCertificateAttributeName()
  {
    return this.ldapCrossCertificateAttributeName;
  }
  
  public String getLdapDeltaRevocationListAttributeName()
  {
    return this.ldapDeltaRevocationListAttributeName;
  }
  
  public String getLdapURL()
  {
    return this.ldapURL;
  }
  
  public String getLdapUserCertificateAttributeName()
  {
    return this.ldapUserCertificateAttributeName;
  }
  
  public String getSearchForSerialNumberIn()
  {
    return this.searchForSerialNumberIn;
  }
  
  public String getUserCertificateAttribute()
  {
    return this.userCertificateAttribute;
  }
  
  public String getUserCertificateSubjectAttributeName()
  {
    return this.userCertificateSubjectAttributeName;
  }
  
  public int hashCode()
  {
    return addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(0, this.userCertificateAttribute), this.cACertificateAttribute), this.crossCertificateAttribute), this.certificateRevocationListAttribute), this.deltaRevocationListAttribute), this.authorityRevocationListAttribute), this.attributeCertificateAttributeAttribute), this.aACertificateAttribute), this.attributeDescriptorCertificateAttribute), this.attributeCertificateRevocationListAttribute), this.attributeAuthorityRevocationListAttribute), this.ldapUserCertificateAttributeName), this.ldapCACertificateAttributeName), this.ldapCrossCertificateAttributeName), this.ldapCertificateRevocationListAttributeName), this.ldapDeltaRevocationListAttributeName), this.ldapAuthorityRevocationListAttributeName), this.ldapAttributeCertificateAttributeAttributeName), this.ldapAACertificateAttributeName), this.ldapAttributeDescriptorCertificateAttributeName), this.ldapAttributeCertificateRevocationListAttributeName), this.ldapAttributeAuthorityRevocationListAttributeName), this.userCertificateSubjectAttributeName), this.cACertificateSubjectAttributeName), this.crossCertificateSubjectAttributeName), this.certificateRevocationListIssuerAttributeName), this.deltaRevocationListIssuerAttributeName), this.authorityRevocationListIssuerAttributeName), this.attributeCertificateAttributeSubjectAttributeName), this.aACertificateSubjectAttributeName), this.attributeDescriptorCertificateSubjectAttributeName), this.attributeCertificateRevocationListIssuerAttributeName), this.attributeAuthorityRevocationListIssuerAttributeName), this.searchForSerialNumberIn);
  }
  
  public static class Builder
  {
    private String aACertificateAttribute;
    private String aACertificateSubjectAttributeName;
    private String attributeAuthorityRevocationListAttribute;
    private String attributeAuthorityRevocationListIssuerAttributeName;
    private String attributeCertificateAttributeAttribute;
    private String attributeCertificateAttributeSubjectAttributeName;
    private String attributeCertificateRevocationListAttribute;
    private String attributeCertificateRevocationListIssuerAttributeName;
    private String attributeDescriptorCertificateAttribute;
    private String attributeDescriptorCertificateSubjectAttributeName;
    private String authorityRevocationListAttribute;
    private String authorityRevocationListIssuerAttributeName;
    private String baseDN;
    private String cACertificateAttribute;
    private String cACertificateSubjectAttributeName;
    private String certificateRevocationListAttribute;
    private String certificateRevocationListIssuerAttributeName;
    private String crossCertificateAttribute;
    private String crossCertificateSubjectAttributeName;
    private String deltaRevocationListAttribute;
    private String deltaRevocationListIssuerAttributeName;
    private String ldapAACertificateAttributeName;
    private String ldapAttributeAuthorityRevocationListAttributeName;
    private String ldapAttributeCertificateAttributeAttributeName;
    private String ldapAttributeCertificateRevocationListAttributeName;
    private String ldapAttributeDescriptorCertificateAttributeName;
    private String ldapAuthorityRevocationListAttributeName;
    private String ldapCACertificateAttributeName;
    private String ldapCertificateRevocationListAttributeName;
    private String ldapCrossCertificateAttributeName;
    private String ldapDeltaRevocationListAttributeName;
    private String ldapURL;
    private String ldapUserCertificateAttributeName;
    private String searchForSerialNumberIn;
    private String userCertificateAttribute;
    private String userCertificateSubjectAttributeName;
    
    public Builder()
    {
      this("ldap://localhost:389", "");
    }
    
    public Builder(String paramString1, String paramString2)
    {
      this.ldapURL = paramString1;
      if (paramString2 == null) {
        this.baseDN = "";
      } else {
        this.baseDN = paramString2;
      }
      this.userCertificateAttribute = "userCertificate";
      this.cACertificateAttribute = "cACertificate";
      this.crossCertificateAttribute = "crossCertificatePair";
      this.certificateRevocationListAttribute = "certificateRevocationList";
      this.deltaRevocationListAttribute = "deltaRevocationList";
      this.authorityRevocationListAttribute = "authorityRevocationList";
      this.attributeCertificateAttributeAttribute = "attributeCertificateAttribute";
      this.aACertificateAttribute = "aACertificate";
      this.attributeDescriptorCertificateAttribute = "attributeDescriptorCertificate";
      this.attributeCertificateRevocationListAttribute = "attributeCertificateRevocationList";
      this.attributeAuthorityRevocationListAttribute = "attributeAuthorityRevocationList";
      this.ldapUserCertificateAttributeName = "cn";
      this.ldapCACertificateAttributeName = "cn ou o";
      this.ldapCrossCertificateAttributeName = "cn ou o";
      this.ldapCertificateRevocationListAttributeName = "cn ou o";
      this.ldapDeltaRevocationListAttributeName = "cn ou o";
      this.ldapAuthorityRevocationListAttributeName = "cn ou o";
      this.ldapAttributeCertificateAttributeAttributeName = "cn";
      this.ldapAACertificateAttributeName = "cn o ou";
      this.ldapAttributeDescriptorCertificateAttributeName = "cn o ou";
      this.ldapAttributeCertificateRevocationListAttributeName = "cn o ou";
      this.ldapAttributeAuthorityRevocationListAttributeName = "cn o ou";
      this.userCertificateSubjectAttributeName = "cn";
      this.cACertificateSubjectAttributeName = "o ou";
      this.crossCertificateSubjectAttributeName = "o ou";
      this.certificateRevocationListIssuerAttributeName = "o ou";
      this.deltaRevocationListIssuerAttributeName = "o ou";
      this.authorityRevocationListIssuerAttributeName = "o ou";
      this.attributeCertificateAttributeSubjectAttributeName = "cn";
      this.aACertificateSubjectAttributeName = "o ou";
      this.attributeDescriptorCertificateSubjectAttributeName = "o ou";
      this.attributeCertificateRevocationListIssuerAttributeName = "o ou";
      this.attributeAuthorityRevocationListIssuerAttributeName = "o ou";
      this.searchForSerialNumberIn = "uid serialNumber cn";
    }
    
    public X509LDAPCertStoreParameters build()
    {
      if ((this.ldapUserCertificateAttributeName != null) && (this.ldapCACertificateAttributeName != null) && (this.ldapCrossCertificateAttributeName != null) && (this.ldapCertificateRevocationListAttributeName != null) && (this.ldapDeltaRevocationListAttributeName != null) && (this.ldapAuthorityRevocationListAttributeName != null) && (this.ldapAttributeCertificateAttributeAttributeName != null) && (this.ldapAACertificateAttributeName != null) && (this.ldapAttributeDescriptorCertificateAttributeName != null) && (this.ldapAttributeCertificateRevocationListAttributeName != null) && (this.ldapAttributeAuthorityRevocationListAttributeName != null) && (this.userCertificateSubjectAttributeName != null) && (this.cACertificateSubjectAttributeName != null) && (this.crossCertificateSubjectAttributeName != null) && (this.certificateRevocationListIssuerAttributeName != null) && (this.deltaRevocationListIssuerAttributeName != null) && (this.authorityRevocationListIssuerAttributeName != null) && (this.attributeCertificateAttributeSubjectAttributeName != null) && (this.aACertificateSubjectAttributeName != null) && (this.attributeDescriptorCertificateSubjectAttributeName != null) && (this.attributeCertificateRevocationListIssuerAttributeName != null) && (this.attributeAuthorityRevocationListIssuerAttributeName != null)) {
        return new X509LDAPCertStoreParameters(this, null);
      }
      throw new IllegalArgumentException("Necessary parameters not specified.");
    }
    
    public Builder setAACertificateAttribute(String paramString)
    {
      this.aACertificateAttribute = paramString;
      return this;
    }
    
    public Builder setAACertificateSubjectAttributeName(String paramString)
    {
      this.aACertificateSubjectAttributeName = paramString;
      return this;
    }
    
    public Builder setAttributeAuthorityRevocationListAttribute(String paramString)
    {
      this.attributeAuthorityRevocationListAttribute = paramString;
      return this;
    }
    
    public Builder setAttributeAuthorityRevocationListIssuerAttributeName(String paramString)
    {
      this.attributeAuthorityRevocationListIssuerAttributeName = paramString;
      return this;
    }
    
    public Builder setAttributeCertificateAttributeAttribute(String paramString)
    {
      this.attributeCertificateAttributeAttribute = paramString;
      return this;
    }
    
    public Builder setAttributeCertificateAttributeSubjectAttributeName(String paramString)
    {
      this.attributeCertificateAttributeSubjectAttributeName = paramString;
      return this;
    }
    
    public Builder setAttributeCertificateRevocationListAttribute(String paramString)
    {
      this.attributeCertificateRevocationListAttribute = paramString;
      return this;
    }
    
    public Builder setAttributeCertificateRevocationListIssuerAttributeName(String paramString)
    {
      this.attributeCertificateRevocationListIssuerAttributeName = paramString;
      return this;
    }
    
    public Builder setAttributeDescriptorCertificateAttribute(String paramString)
    {
      this.attributeDescriptorCertificateAttribute = paramString;
      return this;
    }
    
    public Builder setAttributeDescriptorCertificateSubjectAttributeName(String paramString)
    {
      this.attributeDescriptorCertificateSubjectAttributeName = paramString;
      return this;
    }
    
    public Builder setAuthorityRevocationListAttribute(String paramString)
    {
      this.authorityRevocationListAttribute = paramString;
      return this;
    }
    
    public Builder setAuthorityRevocationListIssuerAttributeName(String paramString)
    {
      this.authorityRevocationListIssuerAttributeName = paramString;
      return this;
    }
    
    public Builder setCACertificateAttribute(String paramString)
    {
      this.cACertificateAttribute = paramString;
      return this;
    }
    
    public Builder setCACertificateSubjectAttributeName(String paramString)
    {
      this.cACertificateSubjectAttributeName = paramString;
      return this;
    }
    
    public Builder setCertificateRevocationListAttribute(String paramString)
    {
      this.certificateRevocationListAttribute = paramString;
      return this;
    }
    
    public Builder setCertificateRevocationListIssuerAttributeName(String paramString)
    {
      this.certificateRevocationListIssuerAttributeName = paramString;
      return this;
    }
    
    public Builder setCrossCertificateAttribute(String paramString)
    {
      this.crossCertificateAttribute = paramString;
      return this;
    }
    
    public Builder setCrossCertificateSubjectAttributeName(String paramString)
    {
      this.crossCertificateSubjectAttributeName = paramString;
      return this;
    }
    
    public Builder setDeltaRevocationListAttribute(String paramString)
    {
      this.deltaRevocationListAttribute = paramString;
      return this;
    }
    
    public Builder setDeltaRevocationListIssuerAttributeName(String paramString)
    {
      this.deltaRevocationListIssuerAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAACertificateAttributeName(String paramString)
    {
      this.ldapAACertificateAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAttributeAuthorityRevocationListAttributeName(String paramString)
    {
      this.ldapAttributeAuthorityRevocationListAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAttributeCertificateAttributeAttributeName(String paramString)
    {
      this.ldapAttributeCertificateAttributeAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAttributeCertificateRevocationListAttributeName(String paramString)
    {
      this.ldapAttributeCertificateRevocationListAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAttributeDescriptorCertificateAttributeName(String paramString)
    {
      this.ldapAttributeDescriptorCertificateAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapAuthorityRevocationListAttributeName(String paramString)
    {
      this.ldapAuthorityRevocationListAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapCACertificateAttributeName(String paramString)
    {
      this.ldapCACertificateAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapCertificateRevocationListAttributeName(String paramString)
    {
      this.ldapCertificateRevocationListAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapCrossCertificateAttributeName(String paramString)
    {
      this.ldapCrossCertificateAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapDeltaRevocationListAttributeName(String paramString)
    {
      this.ldapDeltaRevocationListAttributeName = paramString;
      return this;
    }
    
    public Builder setLdapUserCertificateAttributeName(String paramString)
    {
      this.ldapUserCertificateAttributeName = paramString;
      return this;
    }
    
    public Builder setSearchForSerialNumberIn(String paramString)
    {
      this.searchForSerialNumberIn = paramString;
      return this;
    }
    
    public Builder setUserCertificateAttribute(String paramString)
    {
      this.userCertificateAttribute = paramString;
      return this;
    }
    
    public Builder setUserCertificateSubjectAttributeName(String paramString)
    {
      this.userCertificateSubjectAttributeName = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\X509LDAPCertStoreParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */