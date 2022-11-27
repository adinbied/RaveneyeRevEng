package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000h\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\017\030\0002\0020\001By\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\b\020\n\032\004\030\0010\013\022\b\020\f\032\004\030\0010\r\022\b\020\016\032\004\030\0010\017\022\006\020\020\032\0020\021\022\b\020\022\032\004\030\0010\023\022\f\020\024\032\b\022\004\022\0020\0260\025\022\f\020\027\032\b\022\004\022\0020\0300\025\022\006\020\031\032\0020\032¢\006\002\020\033J\017\020\016\032\004\030\0010\017H\007¢\006\002\b(J\023\020\027\032\b\022\004\022\0020\0300\025H\007¢\006\002\b)J\r\020\006\032\0020\007H\007¢\006\002\b*J\023\020+\032\0020,2\b\020-\032\004\030\0010\001H\002J\025\020.\032\0020,2\006\020/\032\0020\000H\000¢\006\002\b0J\b\0201\032\0020\005H\026J\017\020\f\032\004\030\0010\rH\007¢\006\002\b2J\023\020\024\032\b\022\004\022\0020\0260\025H\007¢\006\002\b3J\017\020\022\032\004\030\0010\023H\007¢\006\002\b4J\r\020\020\032\0020\021H\007¢\006\002\b5J\r\020\031\032\0020\032H\007¢\006\002\b6J\r\020\b\032\0020\tH\007¢\006\002\b7J\017\020\n\032\004\030\0010\013H\007¢\006\002\b8J\b\0209\032\0020\003H\026J\r\020%\032\0020&H\007¢\006\002\b:R\025\020\016\032\004\030\0010\0178\007¢\006\b\n\000\032\004\b\016\020\034R\031\020\027\032\b\022\004\022\0020\0300\0258G¢\006\b\n\000\032\004\b\027\020\035R\023\020\006\032\0020\0078\007¢\006\b\n\000\032\004\b\006\020\036R\025\020\f\032\004\030\0010\r8\007¢\006\b\n\000\032\004\b\f\020\037R\031\020\024\032\b\022\004\022\0020\0260\0258G¢\006\b\n\000\032\004\b\024\020\035R\025\020\022\032\004\030\0010\0238\007¢\006\b\n\000\032\004\b\022\020 R\023\020\020\032\0020\0218\007¢\006\b\n\000\032\004\b\020\020!R\023\020\031\032\0020\0328\007¢\006\b\n\000\032\004\b\031\020\"R\023\020\b\032\0020\t8\007¢\006\b\n\000\032\004\b\b\020#R\025\020\n\032\004\030\0010\0138\007¢\006\b\n\000\032\004\b\n\020$R\023\020%\032\0020&8G¢\006\b\n\000\032\004\b%\020'¨\006;"}, d2={"Lokhttp3/Address;", "", "uriHost", "", "uriPort", "", "dns", "Lokhttp3/Dns;", "socketFactory", "Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "certificatePinner", "Lokhttp3/CertificatePinner;", "proxyAuthenticator", "Lokhttp3/Authenticator;", "proxy", "Ljava/net/Proxy;", "protocols", "", "Lokhttp3/Protocol;", "connectionSpecs", "Lokhttp3/ConnectionSpec;", "proxySelector", "Ljava/net/ProxySelector;", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "()Lokhttp3/CertificatePinner;", "()Ljava/util/List;", "()Lokhttp3/Dns;", "()Ljavax/net/ssl/HostnameVerifier;", "()Ljava/net/Proxy;", "()Lokhttp3/Authenticator;", "()Ljava/net/ProxySelector;", "()Ljavax/net/SocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "url", "Lokhttp3/HttpUrl;", "()Lokhttp3/HttpUrl;", "-deprecated_certificatePinner", "-deprecated_connectionSpecs", "-deprecated_dns", "equals", "", "other", "equalsNonHost", "that", "equalsNonHost$okhttp", "hashCode", "-deprecated_hostnameVerifier", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "toString", "-deprecated_url", "okhttp"}, k=1, mv={1, 1, 16})
public final class Address
{
  private final CertificatePinner certificatePinner;
  private final List<ConnectionSpec> connectionSpecs;
  private final Dns dns;
  private final HostnameVerifier hostnameVerifier;
  private final List<Protocol> protocols;
  private final Proxy proxy;
  private final Authenticator proxyAuthenticator;
  private final ProxySelector proxySelector;
  private final SocketFactory socketFactory;
  private final SSLSocketFactory sslSocketFactory;
  private final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<? extends Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    this.dns = paramDns;
    this.socketFactory = paramSocketFactory;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
    this.proxyAuthenticator = paramAuthenticator;
    this.proxy = paramProxy;
    this.proxySelector = paramProxySelector;
    paramSocketFactory = new HttpUrl.Builder();
    if (this.sslSocketFactory != null) {
      paramDns = "https";
    } else {
      paramDns = "http";
    }
    this.url = paramSocketFactory.scheme(paramDns).host(paramString).port(paramInt).build();
    this.protocols = Util.toImmutableList(paramList);
    this.connectionSpecs = Util.toImmutableList(paramList1);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="certificatePinner", imports={}))
  public final CertificatePinner -deprecated_certificatePinner()
  {
    return this.certificatePinner;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="connectionSpecs", imports={}))
  public final List<ConnectionSpec> -deprecated_connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="dns", imports={}))
  public final Dns -deprecated_dns()
  {
    return this.dns;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hostnameVerifier", imports={}))
  public final HostnameVerifier -deprecated_hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="protocols", imports={}))
  public final List<Protocol> -deprecated_protocols()
  {
    return this.protocols;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxy", imports={}))
  public final Proxy -deprecated_proxy()
  {
    return this.proxy;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxyAuthenticator", imports={}))
  public final Authenticator -deprecated_proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxySelector", imports={}))
  public final ProxySelector -deprecated_proxySelector()
  {
    return this.proxySelector;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="socketFactory", imports={}))
  public final SocketFactory -deprecated_socketFactory()
  {
    return this.socketFactory;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sslSocketFactory", imports={}))
  public final SSLSocketFactory -deprecated_sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="url", imports={}))
  public final HttpUrl -deprecated_url()
  {
    return this.url;
  }
  
  public final CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }
  
  public final List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }
  
  public final Dns dns()
  {
    return this.dns;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Address))
    {
      HttpUrl localHttpUrl = this.url;
      paramObject = (Address)paramObject;
      if ((Intrinsics.areEqual(localHttpUrl, ((Address)paramObject).url)) && (equalsNonHost$okhttp((Address)paramObject))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean equalsNonHost$okhttp(Address paramAddress)
  {
    Intrinsics.checkParameterIsNotNull(paramAddress, "that");
    return (Intrinsics.areEqual(this.dns, paramAddress.dns)) && (Intrinsics.areEqual(this.proxyAuthenticator, paramAddress.proxyAuthenticator)) && (Intrinsics.areEqual(this.protocols, paramAddress.protocols)) && (Intrinsics.areEqual(this.connectionSpecs, paramAddress.connectionSpecs)) && (Intrinsics.areEqual(this.proxySelector, paramAddress.proxySelector)) && (Intrinsics.areEqual(this.proxy, paramAddress.proxy)) && (Intrinsics.areEqual(this.sslSocketFactory, paramAddress.sslSocketFactory)) && (Intrinsics.areEqual(this.hostnameVerifier, paramAddress.hostnameVerifier)) && (Intrinsics.areEqual(this.certificatePinner, paramAddress.certificatePinner)) && (this.url.port() == paramAddress.url.port());
  }
  
  public int hashCode()
  {
    return (((((((((527 + this.url.hashCode()) * 31 + this.dns.hashCode()) * 31 + this.proxyAuthenticator.hashCode()) * 31 + this.protocols.hashCode()) * 31 + this.connectionSpecs.hashCode()) * 31 + this.proxySelector.hashCode()) * 31 + Objects.hashCode(this.proxy)) * 31 + Objects.hashCode(this.sslSocketFactory)) * 31 + Objects.hashCode(this.hostnameVerifier)) * 31 + Objects.hashCode(this.certificatePinner);
  }
  
  public final HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public final List<Protocol> protocols()
  {
    return this.protocols;
  }
  
  public final Proxy proxy()
  {
    return this.proxy;
  }
  
  public final Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }
  
  public final ProxySelector proxySelector()
  {
    return this.proxySelector;
  }
  
  public final SocketFactory socketFactory()
  {
    return this.socketFactory;
  }
  
  public final SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Address{");
    localStringBuilder2.append(this.url.host());
    localStringBuilder2.append(':');
    localStringBuilder2.append(this.url.port());
    localStringBuilder2.append(", ");
    StringBuilder localStringBuilder1;
    Object localObject;
    if (this.proxy != null)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("proxy=");
      localObject = this.proxy;
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("proxySelector=");
      localObject = this.proxySelector;
    }
    localStringBuilder1.append(localObject);
    localStringBuilder2.append(localStringBuilder1.toString());
    localStringBuilder2.append("}");
    return localStringBuilder2.toString();
  }
  
  public final HttpUrl url()
  {
    return this.url;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */