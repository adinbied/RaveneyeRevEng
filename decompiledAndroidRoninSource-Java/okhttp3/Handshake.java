package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000H\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\020\016\n\002\b\004\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\b\030\000 &2\0020\001:\001&B9\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\f\020\006\032\b\022\004\022\0020\b0\007\022\022\020\t\032\016\022\n\022\b\022\004\022\0020\b0\0070\n¢\006\002\020\013J\r\020\004\032\0020\005H\007¢\006\002\b\032J\023\020\033\032\0020\0342\b\020\035\032\004\030\0010\001H\002J\b\020\036\032\0020\037H\026J\023\020\006\032\b\022\004\022\0020\b0\007H\007¢\006\002\b J\017\020\016\032\004\030\0010\017H\007¢\006\002\b!J\023\020\021\032\b\022\004\022\0020\b0\007H\007¢\006\002\b\"J\017\020\024\032\004\030\0010\017H\007¢\006\002\b#J\r\020\002\032\0020\003H\007¢\006\002\b$J\b\020%\032\0020\027H\026R\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020\fR\031\020\006\032\b\022\004\022\0020\b0\0078\007¢\006\b\n\000\032\004\b\006\020\rR\023\020\016\032\004\030\0010\0178G¢\006\006\032\004\b\016\020\020R!\020\021\032\b\022\004\022\0020\b0\0078GX\002¢\006\f\n\004\b\022\020\023\032\004\b\021\020\rR\023\020\024\032\004\030\0010\0178G¢\006\006\032\004\b\024\020\020R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\025R\030\020\026\032\0020\027*\0020\b8BX\004¢\006\006\032\004\b\030\020\031¨\006'"}, d2={"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Handshake
{
  public static final Companion Companion = new Companion(null);
  private final CipherSuite cipherSuite;
  private final List<Certificate> localCertificates;
  private final Lazy peerCertificates$delegate;
  private final TlsVersion tlsVersion;
  
  public Handshake(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<? extends Certificate> paramList, Function0<? extends List<? extends Certificate>> paramFunction0)
  {
    this.tlsVersion = paramTlsVersion;
    this.cipherSuite = paramCipherSuite;
    this.localCertificates = paramList;
    this.peerCertificates$delegate = LazyKt.lazy(paramFunction0);
  }
  
  @JvmStatic
  public static final Handshake get(SSLSession paramSSLSession)
    throws IOException
  {
    return Companion.get(paramSSLSession);
  }
  
  @JvmStatic
  public static final Handshake get(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<? extends Certificate> paramList1, List<? extends Certificate> paramList2)
  {
    return Companion.get(paramTlsVersion, paramCipherSuite, paramList1, paramList2);
  }
  
  private final String getName(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate)) {
      return ((X509Certificate)paramCertificate).getSubjectDN().toString();
    }
    paramCertificate = paramCertificate.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramCertificate, "type");
    return paramCertificate;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuite", imports={}))
  public final CipherSuite -deprecated_cipherSuite()
  {
    return this.cipherSuite;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="localCertificates", imports={}))
  public final List<Certificate> -deprecated_localCertificates()
  {
    return this.localCertificates;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="localPrincipal", imports={}))
  public final Principal -deprecated_localPrincipal()
  {
    return localPrincipal();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="peerCertificates", imports={}))
  public final List<Certificate> -deprecated_peerCertificates()
  {
    return peerCertificates();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="peerPrincipal", imports={}))
  public final Principal -deprecated_peerPrincipal()
  {
    return peerPrincipal();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersion", imports={}))
  public final TlsVersion -deprecated_tlsVersion()
  {
    return this.tlsVersion;
  }
  
  public final CipherSuite cipherSuite()
  {
    return this.cipherSuite;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Handshake))
    {
      paramObject = (Handshake)paramObject;
      if ((((Handshake)paramObject).tlsVersion == this.tlsVersion) && (Intrinsics.areEqual(((Handshake)paramObject).cipherSuite, this.cipherSuite)) && (Intrinsics.areEqual(((Handshake)paramObject).peerCertificates(), peerCertificates())) && (Intrinsics.areEqual(((Handshake)paramObject).localCertificates, this.localCertificates))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((527 + this.tlsVersion.hashCode()) * 31 + this.cipherSuite.hashCode()) * 31 + peerCertificates().hashCode()) * 31 + this.localCertificates.hashCode();
  }
  
  public final List<Certificate> localCertificates()
  {
    return this.localCertificates;
  }
  
  public final Principal localPrincipal()
  {
    Object localObject1 = CollectionsKt.firstOrNull(this.localCertificates);
    boolean bool = localObject1 instanceof X509Certificate;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    X509Certificate localX509Certificate = (X509Certificate)localObject1;
    localObject1 = localObject2;
    if (localX509Certificate != null) {
      localObject1 = localX509Certificate.getSubjectX500Principal();
    }
    return (Principal)localObject1;
  }
  
  public final List<Certificate> peerCertificates()
  {
    Lazy localLazy = this.peerCertificates$delegate;
    KProperty localKProperty = $$delegatedProperties[0];
    return (List)localLazy.getValue();
  }
  
  public final Principal peerPrincipal()
  {
    Object localObject1 = CollectionsKt.firstOrNull(peerCertificates());
    boolean bool = localObject1 instanceof X509Certificate;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    X509Certificate localX509Certificate = (X509Certificate)localObject1;
    localObject1 = localObject2;
    if (localX509Certificate != null) {
      localObject1 = localX509Certificate.getSubjectX500Principal();
    }
    return (Principal)localObject1;
  }
  
  public final TlsVersion tlsVersion()
  {
    return this.tlsVersion;
  }
  
  public String toString()
  {
    try
    {
      localObject2 = (Iterable)peerCertificates();
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(getName((Certificate)((Iterator)localObject2).next()));
      }
      localObject1 = ((List)localObject1).toString();
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      Object localObject2;
      Object localObject1;
      Object localObject3;
      for (;;) {}
    }
    localObject1 = "Failed: SSLPeerUnverifiedException";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Handshake{");
    ((StringBuilder)localObject2).append("tlsVersion=");
    ((StringBuilder)localObject2).append(this.tlsVersion);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append("cipherSuite=");
    ((StringBuilder)localObject2).append(this.cipherSuite);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append("peerCertificates=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append("localCertificates=");
    localObject3 = (Iterable)this.localCertificates;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject1).add(getName((Certificate)((Iterator)localObject3).next()));
    }
    ((StringBuilder)localObject2).append((List)localObject1);
    ((StringBuilder)localObject2).append('}');
    return ((StringBuilder)localObject2).toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\b\003\n\002\020\021\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\025\020\003\032\0020\0042\006\020\005\032\0020\006H\007¢\006\002\b\007J4\020\003\032\0020\0042\006\020\b\032\0020\t2\006\020\n\032\0020\0132\f\020\f\032\b\022\004\022\0020\0160\r2\f\020\017\032\b\022\004\022\0020\0160\rH\007J\021\020\020\032\0020\004*\0020\006H\007¢\006\002\b\003J!\020\021\032\b\022\004\022\0020\0160\r*\f\022\006\b\001\022\0020\016\030\0010\022H\002¢\006\002\020\023¨\006\024"}, d2={"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final List<Certificate> toImmutableList(Certificate[] paramArrayOfCertificate)
    {
      if (paramArrayOfCertificate != null) {
        return Util.immutableListOf((Certificate[])Arrays.copyOf(paramArrayOfCertificate, paramArrayOfCertificate.length));
      }
      return CollectionsKt.emptyList();
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="sslSession.handshake()", imports={}))
    public final Handshake -deprecated_get(SSLSession paramSSLSession)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramSSLSession, "sslSession");
      return ((Companion)this).get(paramSSLSession);
    }
    
    @JvmStatic
    public final Handshake get(SSLSession paramSSLSession)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramSSLSession, "$this$handshake");
      Object localObject = paramSSLSession.getCipherSuite();
      CipherSuite localCipherSuite;
      TlsVersion localTlsVersion;
      if (localObject != null)
      {
        int i = ((String)localObject).hashCode();
        if (i != 1019404634 ? (i != 1208658923) || (!((String)localObject).equals("SSL_NULL_WITH_NULL_NULL")) : !((String)localObject).equals("TLS_NULL_WITH_NULL_NULL"))
        {
          localCipherSuite = CipherSuite.Companion.forJavaName((String)localObject);
          localObject = paramSSLSession.getProtocol();
          if (localObject != null) {
            if (!Intrinsics.areEqual("NONE", localObject)) {
              localTlsVersion = TlsVersion.Companion.forJavaName((String)localObject);
            }
          }
        }
      }
      try
      {
        localObject = ((Companion)this).toImmutableList(paramSSLSession.getPeerCertificates());
      }
      catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
      {
        for (;;) {}
      }
      localObject = CollectionsKt.emptyList();
      new Handshake(localTlsVersion, localCipherSuite, ((Companion)this).toImmutableList(paramSSLSession.getLocalCertificates()), (Function0)new Lambda((List)localObject)
      {
        public final List<Certificate> invoke()
        {
          return this.$peerCertificatesCopy;
        }
      });
      throw ((Throwable)new IOException("tlsVersion == NONE"));
      throw ((Throwable)new IllegalStateException("tlsVersion == null".toString()));
      paramSSLSession = new StringBuilder();
      paramSSLSession.append("cipherSuite == ");
      paramSSLSession.append((String)localObject);
      throw ((Throwable)new IOException(paramSSLSession.toString()));
      throw ((Throwable)new IllegalStateException("cipherSuite == null".toString()));
    }
    
    @JvmStatic
    public final Handshake get(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<? extends Certificate> paramList1, List<? extends Certificate> paramList2)
    {
      Intrinsics.checkParameterIsNotNull(paramTlsVersion, "tlsVersion");
      Intrinsics.checkParameterIsNotNull(paramCipherSuite, "cipherSuite");
      Intrinsics.checkParameterIsNotNull(paramList1, "peerCertificates");
      Intrinsics.checkParameterIsNotNull(paramList2, "localCertificates");
      paramList1 = Util.toImmutableList(paramList1);
      new Handshake(paramTlsVersion, paramCipherSuite, Util.toImmutableList(paramList2), (Function0)new Lambda(paramList1)
      {
        public final List<Certificate> invoke()
        {
          return this.$peerCertificatesCopy;
        }
      });
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Handshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */