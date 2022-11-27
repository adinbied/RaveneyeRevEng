package org.bouncycastle.est;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Store;

public class EnrollmentResponse
{
  private final long notBefore;
  private final ESTRequest requestToRetry;
  private final Source source;
  private final Store<X509CertificateHolder> store;
  
  public EnrollmentResponse(Store<X509CertificateHolder> paramStore, long paramLong, ESTRequest paramESTRequest, Source paramSource)
  {
    this.store = paramStore;
    this.notBefore = paramLong;
    this.requestToRetry = paramESTRequest;
    this.source = paramSource;
  }
  
  public boolean canRetry()
  {
    return this.notBefore < System.currentTimeMillis();
  }
  
  public long getNotBefore()
  {
    return this.notBefore;
  }
  
  public ESTRequest getRequestToRetry()
  {
    return this.requestToRetry;
  }
  
  public Object getSession()
  {
    return this.source.getSession();
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public Store<X509CertificateHolder> getStore()
  {
    return this.store;
  }
  
  public boolean isCompleted()
  {
    return this.requestToRetry == null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\EnrollmentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */