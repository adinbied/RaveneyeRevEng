package org.bouncycastle.cert.path.validations;

import java.util.Collection;
import java.util.Iterator;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

public class CRLValidation
  implements CertPathValidation
{
  private Store crls;
  private X500Name workingIssuerName;
  
  public CRLValidation(X500Name paramX500Name, Store paramStore)
  {
    this.workingIssuerName = paramX500Name;
    this.crls = paramStore;
  }
  
  public Memoable copy()
  {
    return new CRLValidation(this.workingIssuerName, this.crls);
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (CRLValidation)paramMemoable;
    this.workingIssuerName = paramMemoable.workingIssuerName;
    this.crls = paramMemoable.crls;
  }
  
  public void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException
  {
    paramCertPathValidationContext = this.crls.getMatches(new Selector()
    {
      public Object clone()
      {
        return this;
      }
      
      public boolean match(Object paramAnonymousObject)
      {
        return ((X509CRLHolder)paramAnonymousObject).getIssuer().equals(CRLValidation.this.workingIssuerName);
      }
    });
    if (!paramCertPathValidationContext.isEmpty())
    {
      paramCertPathValidationContext = paramCertPathValidationContext.iterator();
      while (paramCertPathValidationContext.hasNext()) {
        if (((X509CRLHolder)paramCertPathValidationContext.next()).getRevokedCertificate(paramX509CertificateHolder.getSerialNumber()) != null) {
          throw new CertPathValidationException("Certificate revoked");
        }
      }
      this.workingIssuerName = paramX509CertificateHolder.getSubject();
      return;
    }
    paramCertPathValidationContext = new StringBuilder();
    paramCertPathValidationContext.append("CRL for ");
    paramCertPathValidationContext.append(this.workingIssuerName);
    paramCertPathValidationContext.append(" not found");
    throw new CertPathValidationException(paramCertPathValidationContext.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\CRLValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */