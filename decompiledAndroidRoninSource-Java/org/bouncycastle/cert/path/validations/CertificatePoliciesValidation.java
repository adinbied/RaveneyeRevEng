package org.bouncycastle.cert.path.validations;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.PolicyConstraints;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;

public class CertificatePoliciesValidation
  implements CertPathValidation
{
  private int explicitPolicy;
  private int inhibitAnyPolicy;
  private int policyMapping;
  
  CertificatePoliciesValidation(int paramInt)
  {
    this(paramInt, false, false, false);
  }
  
  CertificatePoliciesValidation(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      this.explicitPolicy = 0;
    } else {
      this.explicitPolicy = (paramInt + 1);
    }
    if (paramBoolean2) {
      this.inhibitAnyPolicy = 0;
    } else {
      this.inhibitAnyPolicy = (paramInt + 1);
    }
    if (paramBoolean3)
    {
      this.policyMapping = 0;
      return;
    }
    this.policyMapping = (paramInt + 1);
  }
  
  private int countDown(int paramInt)
  {
    if (paramInt != 0) {
      return paramInt - 1;
    }
    return 0;
  }
  
  public Memoable copy()
  {
    return new CertificatePoliciesValidation(0);
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (CertificatePoliciesValidation)paramMemoable;
  }
  
  public void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException
  {
    paramCertPathValidationContext.addHandledExtension(Extension.policyConstraints);
    paramCertPathValidationContext.addHandledExtension(Extension.inhibitAnyPolicy);
    if ((!paramCertPathValidationContext.isEndEntity()) && (!ValidationUtils.isSelfIssued(paramX509CertificateHolder)))
    {
      this.explicitPolicy = countDown(this.explicitPolicy);
      this.policyMapping = countDown(this.policyMapping);
      this.inhibitAnyPolicy = countDown(this.inhibitAnyPolicy);
      paramCertPathValidationContext = PolicyConstraints.fromExtensions(paramX509CertificateHolder.getExtensions());
      if (paramCertPathValidationContext != null)
      {
        BigInteger localBigInteger = paramCertPathValidationContext.getRequireExplicitPolicyMapping();
        if ((localBigInteger != null) && (localBigInteger.intValue() < this.explicitPolicy)) {
          this.explicitPolicy = localBigInteger.intValue();
        }
        paramCertPathValidationContext = paramCertPathValidationContext.getInhibitPolicyMapping();
        if ((paramCertPathValidationContext != null) && (paramCertPathValidationContext.intValue() < this.policyMapping)) {
          this.policyMapping = paramCertPathValidationContext.intValue();
        }
      }
      paramCertPathValidationContext = paramX509CertificateHolder.getExtension(Extension.inhibitAnyPolicy);
      if (paramCertPathValidationContext != null)
      {
        int i = ASN1Integer.getInstance(paramCertPathValidationContext.getParsedValue()).getValue().intValue();
        if (i < this.inhibitAnyPolicy) {
          this.inhibitAnyPolicy = i;
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\CertificatePoliciesValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */