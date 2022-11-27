package org.bouncycastle.cert.path.validations;

import java.math.BigInteger;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;

public class BasicConstraintsValidation
  implements CertPathValidation
{
  private BasicConstraints bc;
  private boolean isMandatory;
  private BigInteger maxPathLength;
  private int pathLengthRemaining;
  
  public BasicConstraintsValidation()
  {
    this(true);
  }
  
  public BasicConstraintsValidation(boolean paramBoolean)
  {
    this.isMandatory = paramBoolean;
  }
  
  public Memoable copy()
  {
    BasicConstraintsValidation localBasicConstraintsValidation = new BasicConstraintsValidation(this.isMandatory);
    localBasicConstraintsValidation.bc = this.bc;
    localBasicConstraintsValidation.pathLengthRemaining = this.pathLengthRemaining;
    return localBasicConstraintsValidation;
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (BasicConstraintsValidation)paramMemoable;
    this.isMandatory = paramMemoable.isMandatory;
    this.bc = paramMemoable.bc;
    this.pathLengthRemaining = paramMemoable.pathLengthRemaining;
  }
  
  public void validate(CertPathValidationContext paramCertPathValidationContext, X509CertificateHolder paramX509CertificateHolder)
    throws CertPathValidationException
  {
    if ((this.maxPathLength != null) && (this.pathLengthRemaining < 0)) {
      throw new CertPathValidationException("BasicConstraints path length exceeded");
    }
    paramCertPathValidationContext.addHandledExtension(Extension.basicConstraints);
    paramCertPathValidationContext = BasicConstraints.fromExtensions(paramX509CertificateHolder.getExtensions());
    int i;
    if (paramCertPathValidationContext != null)
    {
      if (this.bc != null)
      {
        if (!paramCertPathValidationContext.isCA()) {
          break label148;
        }
        paramX509CertificateHolder = paramCertPathValidationContext.getPathLenConstraint();
        if (paramX509CertificateHolder == null) {
          break label148;
        }
        i = paramX509CertificateHolder.intValue();
        if (i >= this.pathLengthRemaining) {
          break label148;
        }
        this.pathLengthRemaining = i;
        this.bc = paramCertPathValidationContext;
        break label148;
      }
      this.bc = paramCertPathValidationContext;
      if (!paramCertPathValidationContext.isCA()) {
        break label148;
      }
      paramCertPathValidationContext = paramCertPathValidationContext.getPathLenConstraint();
      this.maxPathLength = paramCertPathValidationContext;
      if (paramCertPathValidationContext == null) {
        break label148;
      }
      i = paramCertPathValidationContext.intValue();
    }
    else
    {
      if (this.bc == null) {
        break label148;
      }
      i = this.pathLengthRemaining - 1;
    }
    this.pathLengthRemaining = i;
    label148:
    if (this.isMandatory)
    {
      if (this.bc != null) {
        return;
      }
      throw new CertPathValidationException("BasicConstraints not present in path");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\validations\BasicConstraintsValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */