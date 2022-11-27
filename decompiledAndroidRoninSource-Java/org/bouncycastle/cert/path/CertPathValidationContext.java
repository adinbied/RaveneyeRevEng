package org.bouncycastle.cert.path;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.util.Memoable;

public class CertPathValidationContext
  implements Memoable
{
  private Set criticalExtensions;
  private boolean endEntity;
  private Set handledExtensions = new HashSet();
  private int index;
  
  public CertPathValidationContext(Set paramSet)
  {
    this.criticalExtensions = paramSet;
  }
  
  public void addHandledExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.handledExtensions.add(paramASN1ObjectIdentifier);
  }
  
  public Memoable copy()
  {
    return null;
  }
  
  public Set getUnhandledCriticalExtensionOIDs()
  {
    HashSet localHashSet = new HashSet(this.criticalExtensions);
    localHashSet.removeAll(this.handledExtensions);
    return localHashSet;
  }
  
  public boolean isEndEntity()
  {
    return this.endEntity;
  }
  
  public void reset(Memoable paramMemoable) {}
  
  public void setIsEndEntity(boolean paramBoolean)
  {
    this.endEntity = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPathValidationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */