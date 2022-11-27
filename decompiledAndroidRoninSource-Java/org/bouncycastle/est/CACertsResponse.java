package org.bouncycastle.est;

import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Store;

public class CACertsResponse
{
  private Store<X509CRLHolder> crlHolderStore;
  private final ESTRequest requestToRetry;
  private final Source session;
  private final Store<X509CertificateHolder> store;
  private final boolean trusted;
  
  public CACertsResponse(Store<X509CertificateHolder> paramStore, Store<X509CRLHolder> paramStore1, ESTRequest paramESTRequest, Source paramSource, boolean paramBoolean)
  {
    this.store = paramStore;
    this.requestToRetry = paramESTRequest;
    this.session = paramSource;
    this.trusted = paramBoolean;
    this.crlHolderStore = paramStore1;
  }
  
  public Store<X509CertificateHolder> getCertificateStore()
  {
    Store localStore = this.store;
    if (localStore != null) {
      return localStore;
    }
    throw new IllegalStateException("Response has no certificates.");
  }
  
  public Store<X509CRLHolder> getCrlStore()
  {
    Store localStore = this.crlHolderStore;
    if (localStore != null) {
      return localStore;
    }
    throw new IllegalStateException("Response has no CRLs.");
  }
  
  public ESTRequest getRequestToRetry()
  {
    return this.requestToRetry;
  }
  
  public Object getSession()
  {
    return this.session.getSession();
  }
  
  public boolean hasCRLs()
  {
    return this.crlHolderStore != null;
  }
  
  public boolean hasCertificates()
  {
    return this.store != null;
  }
  
  public boolean isTrusted()
  {
    return this.trusted;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\CACertsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */