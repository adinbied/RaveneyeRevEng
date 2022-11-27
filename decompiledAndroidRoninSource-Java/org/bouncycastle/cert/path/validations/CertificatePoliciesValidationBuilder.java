package org.bouncycastle.cert.path.validations;

import org.bouncycastle.cert.path.CertPath;

public class CertificatePoliciesValidationBuilder
{
  private boolean isAnyPolicyInhibited;
  private boolean isExplicitPolicyRequired;
  private boolean isPolicyMappingInhibited;
  
  public CertificatePoliciesValidation build(int paramInt)
  {
    return new CertificatePoliciesValidation(paramInt, this.isExplicitPolicyRequired, this.isAnyPolicyInhibited, this.isPolicyMappingInhibited);
  }
  
  public CertificatePoliciesValidation build(CertPath paramCertPath)
  {
    return build(paramCertPath.length());
  }
  
  public void setAnyPolicyInhibited(boolean paramBoolean)
  {
    this.isAnyPolicyInhibited = paramBoolean;
  }
  
  public void setExplicitPolicyRequired(boolean paramBoolean)
  {
    this.isExplicitPolicyRequired = paramBoolean;
  }
  
  public void setPolicyMappingInhibited(boolean paramBoolean)
  {
    this.isPolicyMappingInhibited = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\CertificatePoliciesValidationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */