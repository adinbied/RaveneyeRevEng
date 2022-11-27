package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\002\n\002\020\021\n\002\020\016\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\006\n\002\020\b\n\002\b\t\030\000 $2\0020\001:\002#$B7\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\016\020\005\032\n\022\004\022\0020\007\030\0010\006\022\016\020\b\032\n\022\004\022\0020\007\030\0010\006¢\006\002\020\tJ\035\020\022\032\0020\0232\006\020\024\032\0020\0252\006\020\026\032\0020\003H\000¢\006\002\b\027J\025\020\n\032\n\022\004\022\0020\f\030\0010\013H\007¢\006\002\b\030J\023\020\031\032\0020\0032\b\020\032\032\004\030\0010\001H\002J\b\020\033\032\0020\034H\026J\016\020\035\032\0020\0032\006\020\036\032\0020\025J\030\020\037\032\0020\0002\006\020\024\032\0020\0252\006\020\026\032\0020\003H\002J\r\020\004\032\0020\003H\007¢\006\002\b J\025\020\020\032\n\022\004\022\0020\021\030\0010\013H\007¢\006\002\b!J\b\020\"\032\0020\007H\026R\031\020\n\032\n\022\004\022\0020\f\030\0010\0138G¢\006\006\032\004\b\n\020\rR\030\020\005\032\n\022\004\022\0020\007\030\0010\006X\004¢\006\004\n\002\020\016R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\017R\023\020\004\032\0020\0038\007¢\006\b\n\000\032\004\b\004\020\017R\031\020\020\032\n\022\004\022\0020\021\030\0010\0138G¢\006\006\032\004\b\020\020\rR\030\020\b\032\n\022\004\022\0020\007\030\0010\006X\004¢\006\004\n\002\020\016¨\006%"}, d2={"Lokhttp3/ConnectionSpec;", "", "isTls", "", "supportsTlsExtensions", "cipherSuitesAsString", "", "", "tlsVersionsAsString", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "cipherSuites", "", "Lokhttp3/CipherSuite;", "()Ljava/util/List;", "[Ljava/lang/String;", "()Z", "tlsVersions", "Lokhttp3/TlsVersion;", "apply", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "apply$okhttp", "-deprecated_cipherSuites", "equals", "other", "hashCode", "", "isCompatible", "socket", "supportedSpec", "-deprecated_supportsTlsExtensions", "-deprecated_tlsVersions", "toString", "Builder", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES;
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final Companion Companion = new Companion(null);
  public static final ConnectionSpec MODERN_TLS;
  private static final CipherSuite[] RESTRICTED_CIPHER_SUITES = { CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 };
  public static final ConnectionSpec RESTRICTED_TLS;
  private final String[] cipherSuitesAsString;
  private final boolean isTls;
  private final boolean supportsTlsExtensions;
  private final String[] tlsVersionsAsString;
  
  static
  {
    APPROVED_CIPHER_SUITES = new CipherSuite[] { CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
    Builder localBuilder = new Builder(true);
    CipherSuite[] arrayOfCipherSuite = RESTRICTED_CIPHER_SUITES;
    RESTRICTED_TLS = localBuilder.cipherSuites((CipherSuite[])Arrays.copyOf(arrayOfCipherSuite, arrayOfCipherSuite.length)).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
    localBuilder = new Builder(true);
    arrayOfCipherSuite = APPROVED_CIPHER_SUITES;
    MODERN_TLS = localBuilder.cipherSuites((CipherSuite[])Arrays.copyOf(arrayOfCipherSuite, arrayOfCipherSuite.length)).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2 }).supportsTlsExtensions(true).build();
    localBuilder = new Builder(true);
    arrayOfCipherSuite = APPROVED_CIPHER_SUITES;
    COMPATIBLE_TLS = localBuilder.cipherSuites((CipherSuite[])Arrays.copyOf(arrayOfCipherSuite, arrayOfCipherSuite.length)).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  }
  
  public ConnectionSpec(boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.isTls = paramBoolean1;
    this.supportsTlsExtensions = paramBoolean2;
    this.cipherSuitesAsString = paramArrayOfString1;
    this.tlsVersionsAsString = paramArrayOfString2;
  }
  
  private final ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    if (this.cipherSuitesAsString != null)
    {
      localObject = paramSSLSocket.getEnabledCipherSuites();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sslSocket.enabledCipherSuites");
      localObject = Util.intersect((String[])localObject, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    }
    else
    {
      localObject = paramSSLSocket.getEnabledCipherSuites();
    }
    String[] arrayOfString1;
    if (this.tlsVersionsAsString != null)
    {
      arrayOfString1 = paramSSLSocket.getEnabledProtocols();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfString1, "sslSocket.enabledProtocols");
      arrayOfString1 = Util.intersect(arrayOfString1, this.tlsVersionsAsString, ComparisonsKt.naturalOrder());
    }
    else
    {
      arrayOfString1 = paramSSLSocket.getEnabledProtocols();
    }
    String[] arrayOfString2 = paramSSLSocket.getSupportedCipherSuites();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfString2, "supportedCipherSuites");
    int i = Util.indexOf(arrayOfString2, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
    paramSSLSocket = (SSLSocket)localObject;
    if (paramBoolean)
    {
      paramSSLSocket = (SSLSocket)localObject;
      if (i != -1)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "cipherSuitesIntersection");
        paramSSLSocket = arrayOfString2[i];
        Intrinsics.checkExpressionValueIsNotNull(paramSSLSocket, "supportedCipherSuites[indexOfFallbackScsv]");
        paramSSLSocket = Util.concat((String[])localObject, paramSSLSocket);
      }
    }
    Object localObject = new Builder(this);
    Intrinsics.checkExpressionValueIsNotNull(paramSSLSocket, "cipherSuitesIntersection");
    paramSSLSocket = ((Builder)localObject).cipherSuites((String[])Arrays.copyOf(paramSSLSocket, paramSSLSocket.length));
    Intrinsics.checkExpressionValueIsNotNull(arrayOfString1, "tlsVersionsIntersection");
    return paramSSLSocket.tlsVersions((String[])Arrays.copyOf(arrayOfString1, arrayOfString1.length)).build();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuites", imports={}))
  public final List<CipherSuite> -deprecated_cipherSuites()
  {
    return cipherSuites();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="supportsTlsExtensions", imports={}))
  public final boolean -deprecated_supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersions", imports={}))
  public final List<TlsVersion> -deprecated_tlsVersions()
  {
    return tlsVersions();
  }
  
  public final void apply$okhttp(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.tlsVersions() != null) {
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.tlsVersionsAsString);
    }
    if (localConnectionSpec.cipherSuites() != null) {
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.cipherSuitesAsString);
    }
  }
  
  public final List<CipherSuite> cipherSuites()
  {
    String[] arrayOfString = this.cipherSuitesAsString;
    if (arrayOfString != null)
    {
      Collection localCollection = (Collection)new ArrayList(arrayOfString.length);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localCollection.add(CipherSuite.Companion.forJavaName(str));
        i += 1;
      }
      return CollectionsKt.toList((Iterable)localCollection);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {
      return false;
    }
    if (paramObject == (ConnectionSpec)this) {
      return true;
    }
    boolean bool = this.isTls;
    paramObject = (ConnectionSpec)paramObject;
    if (bool != ((ConnectionSpec)paramObject).isTls) {
      return false;
    }
    if (bool)
    {
      if (!Arrays.equals(this.cipherSuitesAsString, ((ConnectionSpec)paramObject).cipherSuitesAsString)) {
        return false;
      }
      if (!Arrays.equals(this.tlsVersionsAsString, ((ConnectionSpec)paramObject).tlsVersionsAsString)) {
        return false;
      }
      if (this.supportsTlsExtensions != ((ConnectionSpec)paramObject).supportsTlsExtensions) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.isTls)
    {
      String[] arrayOfString = this.cipherSuitesAsString;
      int j = 0;
      int i;
      if (arrayOfString != null) {
        i = Arrays.hashCode(arrayOfString);
      } else {
        i = 0;
      }
      arrayOfString = this.tlsVersionsAsString;
      if (arrayOfString != null) {
        j = Arrays.hashCode(arrayOfString);
      }
      return ((527 + i) * 31 + j) * 31 + (this.supportsTlsExtensions ^ true);
    }
    return 17;
  }
  
  public final boolean isCompatible(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "socket");
    if (!this.isTls) {
      return false;
    }
    String[] arrayOfString = this.tlsVersionsAsString;
    if ((arrayOfString != null) && (!Util.hasIntersection(arrayOfString, paramSSLSocket.getEnabledProtocols(), ComparisonsKt.naturalOrder()))) {
      return false;
    }
    arrayOfString = this.cipherSuitesAsString;
    return (arrayOfString == null) || (Util.hasIntersection(arrayOfString, paramSSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp()));
  }
  
  public final boolean isTls()
  {
    return this.isTls;
  }
  
  public final boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }
  
  public final List<TlsVersion> tlsVersions()
  {
    String[] arrayOfString = this.tlsVersionsAsString;
    if (arrayOfString != null)
    {
      Collection localCollection = (Collection)new ArrayList(arrayOfString.length);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localCollection.add(TlsVersion.Companion.forJavaName(str));
        i += 1;
      }
      return CollectionsKt.toList((Iterable)localCollection);
    }
    return null;
  }
  
  public String toString()
  {
    if (!this.isTls) {
      return "ConnectionSpec()";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionSpec(");
    localStringBuilder.append("cipherSuites=");
    localStringBuilder.append(Objects.toString(cipherSuites(), "[all enabled]"));
    localStringBuilder.append(", ");
    localStringBuilder.append("tlsVersions=");
    localStringBuilder.append(Objects.toString(tlsVersions(), "[all enabled]"));
    localStringBuilder.append(", ");
    localStringBuilder.append("supportsTlsExtensions=");
    localStringBuilder.append(this.supportsTlsExtensions);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\021\n\002\020\016\n\002\b\022\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\017\b\020\022\006\020\002\032\0020\003¢\006\002\020\004B\017\b\026\022\006\020\005\032\0020\006¢\006\002\020\007J\006\020\031\032\0020\000J\006\020\032\032\0020\000J\006\020\033\032\0020\006J\037\020\b\032\0020\0002\022\020\b\032\n\022\006\b\001\022\0020\n0\t\"\0020\n¢\006\002\020\034J\037\020\b\032\0020\0002\022\020\b\032\n\022\006\b\001\022\0020\0350\t\"\0020\035¢\006\002\020\036J\020\020\020\032\0020\0002\006\020\020\032\0020\003H\007J\037\020\026\032\0020\0002\022\020\026\032\n\022\006\b\001\022\0020\n0\t\"\0020\n¢\006\002\020\034J\037\020\026\032\0020\0002\022\020\026\032\n\022\006\b\001\022\0020\0370\t\"\0020\037¢\006\002\020 R$\020\b\032\n\022\004\022\0020\n\030\0010\tX\016¢\006\020\n\002\020\017\032\004\b\013\020\f\"\004\b\r\020\016R\032\020\020\032\0020\003X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\004R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\024\020\022\"\004\b\025\020\004R$\020\026\032\n\022\004\022\0020\n\030\0010\tX\016¢\006\020\n\002\020\017\032\004\b\027\020\f\"\004\b\030\020\016¨\006!"}, d2={"Lokhttp3/ConnectionSpec$Builder;", "", "tls", "", "(Z)V", "connectionSpec", "Lokhttp3/ConnectionSpec;", "(Lokhttp3/ConnectionSpec;)V", "cipherSuites", "", "", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "supportsTlsExtensions", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "getTls$okhttp", "setTls$okhttp", "tlsVersions", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "allEnabledCipherSuites", "allEnabledTlsVersions", "build", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/CipherSuite;", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/TlsVersion;", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private String[] cipherSuites;
    private boolean supportsTlsExtensions;
    private boolean tls;
    private String[] tlsVersions;
    
    public Builder(ConnectionSpec paramConnectionSpec)
    {
      this.tls = paramConnectionSpec.isTls();
      this.cipherSuites = ConnectionSpec.access$getCipherSuitesAsString$p(paramConnectionSpec);
      this.tlsVersions = ConnectionSpec.access$getTlsVersionsAsString$p(paramConnectionSpec);
      this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions();
    }
    
    public Builder(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }
    
    public final Builder allEnabledCipherSuites()
    {
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        localBuilder.cipherSuites = ((String[])null);
        return localBuilder;
      }
      throw ((Throwable)new IllegalArgumentException("no cipher suites for cleartext connections".toString()));
    }
    
    public final Builder allEnabledTlsVersions()
    {
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        localBuilder.tlsVersions = ((String[])null);
        return localBuilder;
      }
      throw ((Throwable)new IllegalArgumentException("no TLS versions for cleartext connections".toString()));
    }
    
    public final ConnectionSpec build()
    {
      return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
    }
    
    public final Builder cipherSuites(String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "cipherSuites");
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        int i;
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          paramVarArgs = paramVarArgs.clone();
          if (paramVarArgs != null)
          {
            localBuilder.cipherSuites = ((String[])paramVarArgs);
            return localBuilder;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        throw ((Throwable)new IllegalArgumentException("At least one cipher suite is required".toString()));
      }
      throw ((Throwable)new IllegalArgumentException("no cipher suites for cleartext connections".toString()));
    }
    
    public final Builder cipherSuites(CipherSuite... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "cipherSuites");
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          localCollection.add(paramVarArgs[i].javaName());
          i += 1;
        }
        paramVarArgs = ((Collection)localCollection).toArray(new String[0]);
        if (paramVarArgs != null)
        {
          paramVarArgs = (String[])paramVarArgs;
          return localBuilder.cipherSuites((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      throw ((Throwable)new IllegalArgumentException("no cipher suites for cleartext connections".toString()));
    }
    
    public final String[] getCipherSuites$okhttp()
    {
      return this.cipherSuites;
    }
    
    public final boolean getSupportsTlsExtensions$okhttp()
    {
      return this.supportsTlsExtensions;
    }
    
    public final boolean getTls$okhttp()
    {
      return this.tls;
    }
    
    public final String[] getTlsVersions$okhttp()
    {
      return this.tlsVersions;
    }
    
    public final void setCipherSuites$okhttp(String[] paramArrayOfString)
    {
      this.cipherSuites = paramArrayOfString;
    }
    
    public final void setSupportsTlsExtensions$okhttp(boolean paramBoolean)
    {
      this.supportsTlsExtensions = paramBoolean;
    }
    
    public final void setTls$okhttp(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }
    
    public final void setTlsVersions$okhttp(String[] paramArrayOfString)
    {
      this.tlsVersions = paramArrayOfString;
    }
    
    @Deprecated(message="since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
    public final Builder supportsTlsExtensions(boolean paramBoolean)
    {
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        localBuilder.supportsTlsExtensions = paramBoolean;
        return localBuilder;
      }
      throw ((Throwable)new IllegalArgumentException("no TLS extensions for cleartext connections".toString()));
    }
    
    public final Builder tlsVersions(String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "tlsVersions");
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        int i;
        if (paramVarArgs.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          paramVarArgs = paramVarArgs.clone();
          if (paramVarArgs != null)
          {
            localBuilder.tlsVersions = ((String[])paramVarArgs);
            return localBuilder;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        throw ((Throwable)new IllegalArgumentException("At least one TLS version is required".toString()));
      }
      throw ((Throwable)new IllegalArgumentException("no TLS versions for cleartext connections".toString()));
    }
    
    public final Builder tlsVersions(TlsVersion... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "tlsVersions");
      Builder localBuilder = (Builder)this;
      if (localBuilder.tls)
      {
        Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          localCollection.add(paramVarArgs[i].javaName());
          i += 1;
        }
        paramVarArgs = ((Collection)localCollection).toArray(new String[0]);
        if (paramVarArgs != null)
        {
          paramVarArgs = (String[])paramVarArgs;
          return localBuilder.tlsVersions((String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      throw ((Throwable)new IllegalArgumentException("no TLS versions for cleartext connections".toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\026\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\004\n\002\020\006R\020\020\007\032\0020\b8\006X\004¢\006\002\n\000R\020\020\t\032\0020\b8\006X\004¢\006\002\n\000R\020\020\n\032\0020\b8\006X\004¢\006\002\n\000R\026\020\013\032\b\022\004\022\0020\0050\004X\004¢\006\004\n\002\020\006R\020\020\f\032\0020\b8\006X\004¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/ConnectionSpec$Companion;", "", "()V", "APPROVED_CIPHER_SUITES", "", "Lokhttp3/CipherSuite;", "[Lokhttp3/CipherSuite;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\ConnectionSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */