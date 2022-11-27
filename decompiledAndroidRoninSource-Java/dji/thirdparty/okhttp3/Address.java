package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address
{
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    String str;
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    }
    this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
    if (paramDns != null)
    {
      this.dns = paramDns;
      if (paramSocketFactory != null)
      {
        this.socketFactory = paramSocketFactory;
        if (paramAuthenticator != null)
        {
          this.proxyAuthenticator = paramAuthenticator;
          if (paramList != null)
          {
            this.protocols = Util.immutableList(paramList);
            if (paramList1 != null)
            {
              this.connectionSpecs = Util.immutableList(paramList1);
              if (paramProxySelector != null)
              {
                this.proxySelector = paramProxySelector;
                this.proxy = paramProxy;
                this.sslSocketFactory = paramSSLSocketFactory;
                this.hostnameVerifier = paramHostnameVerifier;
                this.certificatePinner = paramCertificatePinner;
                return;
              }
              throw new IllegalArgumentException("proxySelector == null");
            }
            throw new IllegalArgumentException("connectionSpecs == null");
          }
          throw new IllegalArgumentException("protocols == null");
        }
        throw new IllegalArgumentException("proxyAuthenticator == null");
      }
      throw new IllegalArgumentException("socketFactory == null");
    }
    throw new IllegalArgumentException("dns == null");
  }
  
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public Dns dns()
  {
    return this.dns;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */