package org.bouncycastle.cert.path;

import java.util.Collections;
import java.util.Set;

public class CertPathValidationResult
{
  private final CertPathValidationException cause;
  private int[] certIndexes;
  private final boolean isValid;
  private final Set unhandledCriticalExtensionOIDs;
  
  public CertPathValidationResult(CertPathValidationContext paramCertPathValidationContext)
  {
    paramCertPathValidationContext = Collections.unmodifiableSet(paramCertPathValidationContext.getUnhandledCriticalExtensionOIDs());
    this.unhandledCriticalExtensionOIDs = paramCertPathValidationContext;
    this.isValid = paramCertPathValidationContext.isEmpty();
    this.cause = null;
  }
  
  public CertPathValidationResult(CertPathValidationContext paramCertPathValidationContext, int paramInt1, int paramInt2, CertPathValidationException paramCertPathValidationException)
  {
    this.unhandledCriticalExtensionOIDs = Collections.unmodifiableSet(paramCertPathValidationContext.getUnhandledCriticalExtensionOIDs());
    this.isValid = false;
    this.cause = paramCertPathValidationException;
  }
  
  public CertPathValidationResult(CertPathValidationContext paramCertPathValidationContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2, CertPathValidationException[] paramArrayOfCertPathValidationException)
  {
    this.unhandledCriticalExtensionOIDs = Collections.unmodifiableSet(paramCertPathValidationContext.getUnhandledCriticalExtensionOIDs());
    this.isValid = false;
    this.cause = paramArrayOfCertPathValidationException[0];
    this.certIndexes = paramArrayOfInt1;
  }
  
  public Exception getCause()
  {
    CertPathValidationException localCertPathValidationException = this.cause;
    if (localCertPathValidationException != null) {
      return localCertPathValidationException;
    }
    if (!this.unhandledCriticalExtensionOIDs.isEmpty()) {
      return new CertPathValidationException("Unhandled Critical Extensions");
    }
    return null;
  }
  
  public Set getUnhandledCriticalExtensionOIDs()
  {
    return this.unhandledCriticalExtensionOIDs;
  }
  
  public boolean isDetailed()
  {
    return this.certIndexes != null;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPathValidationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */