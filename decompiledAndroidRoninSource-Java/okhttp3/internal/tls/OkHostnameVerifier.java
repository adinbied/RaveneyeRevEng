package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020 \n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\006\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\024\020\006\032\b\022\004\022\0020\b0\0072\006\020\t\032\0020\nJ\036\020\013\032\b\022\004\022\0020\b0\0072\006\020\t\032\0020\n2\006\020\f\032\0020\004H\002J\026\020\r\032\0020\0162\006\020\017\032\0020\b2\006\020\t\032\0020\nJ\030\020\r\032\0020\0162\006\020\017\032\0020\b2\006\020\020\032\0020\021H\026J\030\020\022\032\0020\0162\006\020\023\032\0020\b2\006\020\t\032\0020\nH\002J\034\020\022\032\0020\0162\b\020\023\032\004\030\0010\b2\b\020\024\032\004\030\0010\bH\002J\030\020\025\032\0020\0162\006\020\026\032\0020\b2\006\020\t\032\0020\nH\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000¨\006\027"}, d2={"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "ALT_DNS_NAME", "", "ALT_IPA_NAME", "allSubjectAltNames", "", "", "certificate", "Ljava/security/cert/X509Certificate;", "getSubjectAltNames", "type", "verify", "", "host", "session", "Ljavax/net/ssl/SSLSession;", "verifyHostname", "hostname", "pattern", "verifyIpAddress", "ipAddress", "okhttp"}, k=1, mv={1, 1, 16})
public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  
  private final List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    try
    {
      Object localObject1 = paramX509Certificate.getSubjectAlternativeNames();
      if (localObject1 != null)
      {
        paramX509Certificate = (List)new ArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            return paramX509Certificate;
          }
          Object localObject2 = (List)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((List)localObject2).size() >= 2) && (!(Intrinsics.areEqual(((List)localObject2).get(0), Integer.valueOf(paramInt)) ^ true)))
          {
            localObject2 = ((List)localObject2).get(1);
            if (localObject2 != null)
            {
              if (localObject2 == null) {
                break;
              }
              paramX509Certificate.add((String)localObject2);
            }
          }
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      paramX509Certificate = CollectionsKt.emptyList();
      return paramX509Certificate;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      for (;;) {}
    }
    return CollectionsKt.emptyList();
    return paramX509Certificate;
  }
  
  private final boolean verifyHostname(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    paramString1 = (CharSequence)localObject;
    int i;
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!StringsKt.startsWith$default((String)localObject, ".", false, 2, null)))
    {
      if (StringsKt.endsWith$default((String)localObject, "..", false, 2, null)) {
        return false;
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (!StringsKt.startsWith$default(paramString2, ".", false, 2, null)))
      {
        if (StringsKt.endsWith$default(paramString2, "..", false, 2, null)) {
          return false;
        }
        paramString1 = (String)localObject;
        if (!StringsKt.endsWith$default((String)localObject, ".", false, 2, null))
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append(".");
          paramString1 = paramString1.toString();
        }
        localObject = paramString2;
        if (!StringsKt.endsWith$default(paramString2, ".", false, 2, null))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(".");
          localObject = ((StringBuilder)localObject).toString();
        }
        paramString2 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(paramString2, "Locale.US");
        if (localObject != null)
        {
          paramString2 = ((String)localObject).toLowerCase(paramString2);
          Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).toLowerCase(locale)");
          localObject = (CharSequence)paramString2;
          if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"*", false, 2, null)) {
            return Intrinsics.areEqual(paramString1, paramString2);
          }
          if (StringsKt.startsWith$default(paramString2, "*.", false, 2, null))
          {
            if (StringsKt.indexOf$default((CharSequence)localObject, '*', 1, false, 4, null) != -1) {
              return false;
            }
            if (paramString1.length() < paramString2.length()) {
              return false;
            }
            if (Intrinsics.areEqual("*.", paramString2)) {
              return false;
            }
            if (paramString2 != null)
            {
              paramString2 = paramString2.substring(1);
              Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).substring(startIndex)");
              if (!StringsKt.endsWith$default(paramString1, paramString2, false, 2, null)) {
                return false;
              }
              i = paramString1.length() - paramString2.length();
              return (i <= 0) || (StringsKt.lastIndexOf$default((CharSequence)paramString1, '.', i - 1, false, 4, null) == -1);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
          return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return false;
  }
  
  private final boolean verifyHostname(String paramString, X509Certificate paramX509Certificate)
  {
    Object localObject = Locale.US;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.US");
    if (paramString != null)
    {
      paramString = paramString.toLowerCase((Locale)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
      paramX509Certificate = (Iterable)getSubjectAltNames(paramX509Certificate, 2);
      boolean bool1 = paramX509Certificate instanceof Collection;
      boolean bool2 = false;
      if ((bool1) && (((Collection)paramX509Certificate).isEmpty())) {
        return false;
      }
      paramX509Certificate = paramX509Certificate.iterator();
      do
      {
        bool1 = bool2;
        if (!paramX509Certificate.hasNext()) {
          break;
        }
        localObject = (String)paramX509Certificate.next();
      } while (!INSTANCE.verifyHostname(paramString, (String)localObject));
      bool1 = true;
      return bool1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = (Iterable)getSubjectAltNames(paramX509Certificate, 7);
    if (((paramX509Certificate instanceof Collection)) && (((Collection)paramX509Certificate).isEmpty())) {}
    do
    {
      while (!paramX509Certificate.hasNext())
      {
        return false;
        paramX509Certificate = paramX509Certificate.iterator();
      }
    } while (!StringsKt.equals(paramString, (String)paramX509Certificate.next(), true));
    return true;
  }
  
  public final List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    Intrinsics.checkParameterIsNotNull(paramX509Certificate, "certificate");
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    return CollectionsKt.plus((Collection)localList, (Iterable)paramX509Certificate);
  }
  
  public final boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "host");
    Intrinsics.checkParameterIsNotNull(paramX509Certificate, "certificate");
    if (Util.canParseAsIpAddress(paramString)) {
      return verifyIpAddress(paramString, paramX509Certificate);
    }
    return verifyHostname(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "host");
    Intrinsics.checkParameterIsNotNull(paramSSLSession, "session");
    try
    {
      paramSSLSession = paramSSLSession.getPeerCertificates()[0];
      if (paramSSLSession != null) {
        return verify(paramString, (X509Certificate)paramSSLSession);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\tls\OkHostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */