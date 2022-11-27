package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.util.Collection;

public class MultiCertStoreParameters
  implements CertStoreParameters
{
  private Collection certStores;
  private boolean searchAllStores;
  
  public MultiCertStoreParameters(Collection paramCollection)
  {
    this(paramCollection, true);
  }
  
  public MultiCertStoreParameters(Collection paramCollection, boolean paramBoolean)
  {
    this.certStores = paramCollection;
    this.searchAllStores = paramBoolean;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public Collection getCertStores()
  {
    return this.certStores;
  }
  
  public boolean getSearchAllStores()
  {
    return this.searchAllStores;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\MultiCertStoreParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */