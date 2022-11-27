package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import okio.ByteString.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000T\n\002\030\002\n\002\020\000\n\000\n\002\020\"\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\006\030\000 !2\0020\001:\003 !\"B\037\b\000\022\f\020\002\032\b\022\004\022\0020\0040\003\022\b\020\005\032\004\030\0010\006¢\006\002\020\007J)\020\n\032\0020\0132\006\020\f\032\0020\r2\022\020\016\032\016\022\n\022\b\022\004\022\0020\0210\0200\017H\000¢\006\002\b\022J)\020\n\032\0020\0132\006\020\f\032\0020\r2\022\020\023\032\n\022\006\b\001\022\0020\0250\024\"\0020\025H\007¢\006\002\020\026J\034\020\n\032\0020\0132\006\020\f\032\0020\r2\f\020\023\032\b\022\004\022\0020\0250\020J\023\020\027\032\0020\0302\b\020\031\032\004\030\0010\001H\002J\033\020\032\032\b\022\004\022\0020\0040\0202\006\020\f\032\0020\rH\000¢\006\002\b\033J\b\020\034\032\0020\035H\026J\027\020\036\032\0020\0002\b\020\005\032\004\030\0010\006H\000¢\006\002\b\037R\026\020\005\032\004\030\0010\006X\004¢\006\b\n\000\032\004\b\b\020\tR\024\020\002\032\b\022\004\022\0020\0040\003X\004¢\006\002\n\000¨\006#"}, d2={"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "findMatchingPins$okhttp", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, k=1, mv={1, 1, 16})
public final class CertificatePinner
{
  public static final Companion Companion = new Companion(null);
  public static final CertificatePinner DEFAULT = new Builder().build();
  private final CertificateChainCleaner certificateChainCleaner;
  private final Set<Pin> pins;
  
  public CertificatePinner(Set<Pin> paramSet, CertificateChainCleaner paramCertificateChainCleaner)
  {
    this.pins = paramSet;
    this.certificateChainCleaner = paramCertificateChainCleaner;
  }
  
  @JvmStatic
  public static final String pin(Certificate paramCertificate)
  {
    return Companion.pin(paramCertificate);
  }
  
  public final void check(final String paramString, final List<? extends Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramList, "peerCertificates");
    check$okhttp(paramString, (Function0)new Lambda(paramList)
    {
      public final List<X509Certificate> invoke()
      {
        Object localObject1 = this.this$0.getCertificateChainCleaner$okhttp();
        if (localObject1 != null)
        {
          localObject1 = ((CertificateChainCleaner)localObject1).clean(paramList, paramString);
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = paramList;
        }
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Certificate localCertificate = (Certificate)((Iterator)localObject2).next();
          if (localCertificate != null) {
            ((Collection)localObject1).add((X509Certificate)localCertificate);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
          }
        }
        return (List)localObject1;
      }
    });
  }
  
  @Deprecated(message="replaced with {@link #check(String, List)}.", replaceWith=@ReplaceWith(expression="check(hostname, peerCertificates.toList())", imports={}))
  public final void check(String paramString, Certificate... paramVarArgs)
    throws SSLPeerUnverifiedException
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "peerCertificates");
    check(paramString, ArraysKt.toList(paramVarArgs));
  }
  
  public final void check$okhttp(String paramString, Function0<? extends List<? extends X509Certificate>> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "cleanedPeerCertificatesFn");
    List localList1 = findMatchingPins$okhttp(paramString);
    if (localList1.isEmpty()) {
      return;
    }
    List localList2 = (List)paramFunction0.invoke();
    Iterator localIterator1 = localList2.iterator();
    Pin localPin;
    Object localObject2;
    do
    {
      X509Certificate localX509Certificate;
      do
      {
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localX509Certificate = (X509Certificate)localIterator1.next();
          localObject1 = (ByteString)null;
          localIterator2 = localList1.iterator();
          paramFunction0 = (Function0<? extends List<? extends X509Certificate>>)localObject1;
        }
        localPin = (Pin)localIterator2.next();
        localObject2 = localPin.getHashAlgorithm();
        int i = ((String)localObject2).hashCode();
        if (i == 109397962) {
          break;
        }
        if ((i != 2052263656) || (!((String)localObject2).equals("sha256/"))) {
          break label228;
        }
        localObject2 = paramFunction0;
        if (paramFunction0 == null) {
          localObject2 = Companion.toSha256ByteString$okhttp(localX509Certificate);
        }
        paramFunction0 = (Function0<? extends List<? extends X509Certificate>>)localObject2;
      } while (!Intrinsics.areEqual(localPin.getHash(), localObject2));
      return;
      if (!((String)localObject2).equals("sha1/")) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = Companion.toSha1ByteString$okhttp(localX509Certificate);
      }
      localObject1 = localObject2;
    } while (!Intrinsics.areEqual(localPin.getHash(), localObject2));
    return;
    label228:
    paramString = new StringBuilder();
    paramString.append("unsupported hashAlgorithm: ");
    paramString.append(localPin.getHashAlgorithm());
    throw ((Throwable)new AssertionError(paramString.toString()));
    paramFunction0 = new StringBuilder();
    paramFunction0.append("Certificate pinning failure!");
    paramFunction0.append("\n  Peer certificate chain:");
    Object localObject1 = localList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (X509Certificate)((Iterator)localObject1).next();
      paramFunction0.append("\n    ");
      paramFunction0.append(Companion.pin((Certificate)localObject2));
      paramFunction0.append(": ");
      localObject2 = ((X509Certificate)localObject2).getSubjectDN();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "element.subjectDN");
      paramFunction0.append(((Principal)localObject2).getName());
    }
    paramFunction0.append("\n  Pinned certificates for ");
    paramFunction0.append(paramString);
    paramFunction0.append(":");
    paramString = localList1.iterator();
    while (paramString.hasNext())
    {
      localObject1 = (Pin)paramString.next();
      paramFunction0.append("\n    ");
      paramFunction0.append(localObject1);
    }
    paramString = paramFunction0.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder().apply(builderAction).toString()");
    throw ((Throwable)new SSLPeerUnverifiedException(paramString));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CertificatePinner))
    {
      paramObject = (CertificatePinner)paramObject;
      if ((Intrinsics.areEqual(((CertificatePinner)paramObject).pins, this.pins)) && (Intrinsics.areEqual(((CertificatePinner)paramObject).certificateChainCleaner, this.certificateChainCleaner))) {
        return true;
      }
    }
    return false;
  }
  
  public final List<Pin> findMatchingPins$okhttp(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Object localObject1 = CollectionsKt.emptyList();
    Iterator localIterator = this.pins.iterator();
    while (localIterator.hasNext())
    {
      Pin localPin = (Pin)localIterator.next();
      if (localPin.matches(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = (List)new ArrayList();
        }
        if (localObject2 != null)
        {
          TypeIntrinsics.asMutableList(localObject2).add(localPin);
          localObject1 = localObject2;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableList<okhttp3.CertificatePinner.Pin>");
        }
      }
    }
    return (List<Pin>)localObject1;
  }
  
  public final CertificateChainCleaner getCertificateChainCleaner$okhttp()
  {
    return this.certificateChainCleaner;
  }
  
  public int hashCode()
  {
    int j = this.pins.hashCode();
    CertificateChainCleaner localCertificateChainCleaner = this.certificateChainCleaner;
    int i;
    if (localCertificateChainCleaner != null) {
      i = localCertificateChainCleaner.hashCode();
    } else {
      i = 0;
    }
    return (1517 + j) * 41 + i;
  }
  
  public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner paramCertificateChainCleaner)
  {
    if (Intrinsics.areEqual(this.certificateChainCleaner, paramCertificateChainCleaner)) {
      return this;
    }
    return new CertificatePinner(this.pins, paramCertificateChainCleaner);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\002\n\002\020\016\n\002\020\021\n\002\b\002\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J'\020\006\032\0020\0002\006\020\007\032\0020\b2\022\020\003\032\n\022\006\b\001\022\0020\b0\t\"\0020\b¢\006\002\020\nJ\006\020\013\032\0020\fR\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/CertificatePinner$Builder;", "", "()V", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "add", "pattern", "", "", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private final List<CertificatePinner.Pin> pins = (List)new ArrayList();
    
    public final Builder add(String paramString, String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "pattern");
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "pins");
      Builder localBuilder = (Builder)this;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        localBuilder.pins.add(CertificatePinner.Companion.newPin$okhttp(paramString, str));
        i += 1;
      }
      return localBuilder;
    }
    
    public final CertificatePinner build()
    {
      return new CertificatePinner(CollectionsKt.toSet((Iterable)this.pins), null);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\035\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\bH\000¢\006\002\b\nJ\020\020\t\032\0020\b2\006\020\013\032\0020\fH\007J\021\020\r\032\0020\016*\0020\017H\000¢\006\002\b\020J\021\020\021\032\0020\016*\0020\017H\000¢\006\002\b\022R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\023"}, d2={"Lokhttp3/CertificatePinner$Companion;", "", "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "newPin", "Lokhttp3/CertificatePinner$Pin;", "pattern", "", "pin", "newPin$okhttp", "certificate", "Ljava/security/cert/Certificate;", "toSha1ByteString", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "toSha1ByteString$okhttp", "toSha256ByteString", "toSha256ByteString$okhttp", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final CertificatePinner.Pin newPin$okhttp(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "pattern");
      Intrinsics.checkParameterIsNotNull(paramString2, "pin");
      int i;
      if (((StringsKt.startsWith$default(paramString1, "*.", false, 2, null)) && (StringsKt.indexOf$default((CharSequence)paramString1, "*", 1, false, 4, null) == -1)) || ((StringsKt.startsWith$default(paramString1, "**.", false, 2, null)) && (StringsKt.indexOf$default((CharSequence)paramString1, "*", 2, false, 4, null) == -1)) || (StringsKt.indexOf$default((CharSequence)paramString1, "*", 0, false, 6, null) == -1)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        String str = HostnamesKt.toCanonicalHost(paramString1);
        if (str != null)
        {
          if (StringsKt.startsWith$default(paramString2, "sha1/", false, 2, null))
          {
            paramString1 = ByteString.Companion;
            paramString2 = paramString2.substring(5);
            Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).substring(startIndex)");
            paramString1 = paramString1.decodeBase64(paramString2);
            if (paramString1 == null) {
              Intrinsics.throwNpe();
            }
            return new CertificatePinner.Pin(str, "sha1/", paramString1);
          }
          if (StringsKt.startsWith$default(paramString2, "sha256/", false, 2, null))
          {
            paramString1 = ByteString.Companion;
            paramString2 = paramString2.substring(7);
            Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).substring(startIndex)");
            paramString1 = paramString1.decodeBase64(paramString2);
            if (paramString1 == null) {
              Intrinsics.throwNpe();
            }
            return new CertificatePinner.Pin(str, "sha256/", paramString1);
          }
          paramString1 = new StringBuilder();
          paramString1.append("pins must start with 'sha256/' or 'sha1/': ");
          paramString1.append(paramString2);
          throw ((Throwable)new IllegalArgumentException(paramString1.toString()));
        }
        paramString2 = new StringBuilder();
        paramString2.append("Invalid pattern: ");
        paramString2.append(paramString1);
        throw ((Throwable)new IllegalArgumentException(paramString2.toString()));
      }
      paramString2 = new StringBuilder();
      paramString2.append("Unexpected pattern: ");
      paramString2.append(paramString1);
      throw ((Throwable)new IllegalArgumentException(paramString2.toString().toString()));
    }
    
    @JvmStatic
    public final String pin(Certificate paramCertificate)
    {
      Intrinsics.checkParameterIsNotNull(paramCertificate, "certificate");
      if ((paramCertificate instanceof X509Certificate))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sha256/");
        localStringBuilder.append(((Companion)this).toSha256ByteString$okhttp((X509Certificate)paramCertificate).base64());
        return localStringBuilder.toString();
      }
      throw ((Throwable)new IllegalArgumentException("Certificate pinning requires X509 certificates".toString()));
    }
    
    public final ByteString toSha1ByteString$okhttp(X509Certificate paramX509Certificate)
    {
      Intrinsics.checkParameterIsNotNull(paramX509Certificate, "$this$toSha1ByteString");
      ByteString.Companion localCompanion = ByteString.Companion;
      paramX509Certificate = paramX509Certificate.getPublicKey();
      Intrinsics.checkExpressionValueIsNotNull(paramX509Certificate, "publicKey");
      paramX509Certificate = paramX509Certificate.getEncoded();
      Intrinsics.checkExpressionValueIsNotNull(paramX509Certificate, "publicKey.encoded");
      return ByteString.Companion.of$default(localCompanion, paramX509Certificate, 0, 0, 3, null).sha1();
    }
    
    public final ByteString toSha256ByteString$okhttp(X509Certificate paramX509Certificate)
    {
      Intrinsics.checkParameterIsNotNull(paramX509Certificate, "$this$toSha256ByteString");
      ByteString.Companion localCompanion = ByteString.Companion;
      paramX509Certificate = paramX509Certificate.getPublicKey();
      Intrinsics.checkExpressionValueIsNotNull(paramX509Certificate, "publicKey");
      paramX509Certificate = paramX509Certificate.getEncoded();
      Intrinsics.checkExpressionValueIsNotNull(paramX509Certificate, "publicKey.encoded");
      return ByteString.Companion.of$default(localCompanion, paramX509Certificate, 0, 0, 3, null).sha256();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\n\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\004\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006¢\006\002\020\007J\t\020\f\032\0020\003HÂ\003J\t\020\r\032\0020\003HÆ\003J\t\020\016\032\0020\006HÆ\003J'\020\017\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\006HÆ\001J\023\020\020\032\0020\0212\b\020\022\032\004\030\0010\001HÖ\003J\t\020\023\032\0020\024HÖ\001J\016\020\025\032\0020\0212\006\020\026\032\0020\003J\b\020\027\032\0020\003H\026R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\b\020\tR\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\n\020\013R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\030"}, d2={"Lokhttp3/CertificatePinner$Pin;", "", "pattern", "", "hashAlgorithm", "hash", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "getHash", "()Lokio/ByteString;", "getHashAlgorithm", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "matches", "hostname", "toString", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Pin
  {
    private final ByteString hash;
    private final String hashAlgorithm;
    private final String pattern;
    
    public Pin(String paramString1, String paramString2, ByteString paramByteString)
    {
      this.pattern = paramString1;
      this.hashAlgorithm = paramString2;
      this.hash = paramByteString;
    }
    
    private final String component1()
    {
      return this.pattern;
    }
    
    public final String component2()
    {
      return this.hashAlgorithm;
    }
    
    public final ByteString component3()
    {
      return this.hash;
    }
    
    public final Pin copy(String paramString1, String paramString2, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "pattern");
      Intrinsics.checkParameterIsNotNull(paramString2, "hashAlgorithm");
      Intrinsics.checkParameterIsNotNull(paramByteString, "hash");
      return new Pin(paramString1, paramString2, paramByteString);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof Pin))
        {
          paramObject = (Pin)paramObject;
          if ((Intrinsics.areEqual(this.pattern, ((Pin)paramObject).pattern)) && (Intrinsics.areEqual(this.hashAlgorithm, ((Pin)paramObject).hashAlgorithm)) && (Intrinsics.areEqual(this.hash, ((Pin)paramObject).hash))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public final ByteString getHash()
    {
      return this.hash;
    }
    
    public final String getHashAlgorithm()
    {
      return this.hashAlgorithm;
    }
    
    public int hashCode()
    {
      Object localObject = this.pattern;
      int k = 0;
      int i;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.hashAlgorithm;
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      localObject = this.hash;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (i * 31 + j) * 31 + k;
    }
    
    public final boolean matches(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "hostname");
      String str = this.pattern;
      boolean bool2 = false;
      int i;
      int j;
      if (StringsKt.startsWith$default(str, "**.", false, 2, null))
      {
        i = this.pattern.length() - 3;
        j = paramString.length() - i;
        bool1 = bool2;
        if (!StringsKt.regionMatches$default(paramString, paramString.length() - i, this.pattern, 3, i, false, 16, null)) {
          break label189;
        }
        if (j != 0)
        {
          bool1 = bool2;
          if (paramString.charAt(j - 1) != '.') {
            break label189;
          }
        }
      }
      for (;;)
      {
        return true;
        if (!StringsKt.startsWith$default(this.pattern, "*.", false, 2, null)) {
          break;
        }
        i = this.pattern.length() - 1;
        j = paramString.length();
        bool1 = bool2;
        if (!StringsKt.regionMatches$default(paramString, paramString.length() - i, this.pattern, 1, i, false, 16, null)) {
          break label189;
        }
        bool1 = bool2;
        if (StringsKt.lastIndexOf$default((CharSequence)paramString, '.', j - i - 1, false, 4, null) != -1) {
          break label189;
        }
      }
      boolean bool1 = Intrinsics.areEqual(paramString, this.pattern);
      label189:
      return bool1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.hashAlgorithm);
      localStringBuilder.append(this.hash.base64());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\CertificatePinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */