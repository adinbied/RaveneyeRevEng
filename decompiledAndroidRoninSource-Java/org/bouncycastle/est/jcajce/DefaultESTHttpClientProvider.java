package org.bouncycastle.est.jcajce;

import java.util.Set;
import org.bouncycastle.est.ESTClient;
import org.bouncycastle.est.ESTClientProvider;
import org.bouncycastle.est.ESTException;

class DefaultESTHttpClientProvider
  implements ESTClientProvider
{
  private final Long absoluteLimit;
  private final ChannelBindingProvider bindingProvider;
  private final Set<String> cipherSuites;
  private final boolean filterCipherSuites;
  private final JsseHostnameAuthorizer hostNameAuthorizer;
  private final SSLSocketFactoryCreator socketFactoryCreator;
  private final int timeout;
  
  public DefaultESTHttpClientProvider(JsseHostnameAuthorizer paramJsseHostnameAuthorizer, SSLSocketFactoryCreator paramSSLSocketFactoryCreator, int paramInt, ChannelBindingProvider paramChannelBindingProvider, Set<String> paramSet, Long paramLong, boolean paramBoolean)
  {
    this.hostNameAuthorizer = paramJsseHostnameAuthorizer;
    this.socketFactoryCreator = paramSSLSocketFactoryCreator;
    this.timeout = paramInt;
    this.bindingProvider = paramChannelBindingProvider;
    this.cipherSuites = paramSet;
    this.absoluteLimit = paramLong;
    this.filterCipherSuites = paramBoolean;
  }
  
  public boolean isTrusted()
  {
    return this.socketFactoryCreator.isTrusted();
  }
  
  public ESTClient makeClient()
    throws ESTException
  {
    try
    {
      DefaultESTClient localDefaultESTClient = new DefaultESTClient(new DefaultESTClientSourceProvider(this.socketFactoryCreator.createFactory(), this.hostNameAuthorizer, this.timeout, this.bindingProvider, this.cipherSuites, this.absoluteLimit, this.filterCipherSuites));
      return localDefaultESTClient;
    }
    catch (Exception localException)
    {
      throw new ESTException(localException.getMessage(), localException.getCause());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\DefaultESTHttpClientProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */