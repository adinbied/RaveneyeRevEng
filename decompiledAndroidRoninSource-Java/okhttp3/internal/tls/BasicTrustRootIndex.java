package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0008\n\002\030\002\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\020$\n\002\030\002\n\002\020\"\n\000\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\020\b\n\000\030\0002\0020\001B\031\022\022\020\002\032\n\022\006\b\001\022\0020\0040\003\"\0020\004¢\006\002\020\005J\023\020\n\032\0020\0132\b\020\f\032\004\030\0010\rH\002J\022\020\016\032\004\030\0010\0042\006\020\017\032\0020\004H\026J\b\020\020\032\0020\021H\026R \020\006\032\024\022\004\022\0020\b\022\n\022\b\022\004\022\0020\0040\t0\007X\004¢\006\002\n\000¨\006\022"}, d2={"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "", "equals", "", "other", "", "findByIssuerAndSignature", "cert", "hashCode", "", "okhttp"}, k=1, mv={1, 1, 16})
public final class BasicTrustRootIndex
  implements TrustRootIndex
{
  private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;
  
  public BasicTrustRootIndex(X509Certificate... paramVarArgs)
  {
    Map localMap = (Map)new LinkedHashMap();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      Intrinsics.checkExpressionValueIsNotNull(localX500Principal, "caCert.subjectX500Principal");
      Object localObject2 = localMap.get(localX500Principal);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (Set)new LinkedHashSet();
        localMap.put(localX500Principal, localObject1);
      }
      ((Set)localObject1).add(localX509Certificate);
      i += 1;
    }
    this.subjectToCaCerts = localMap;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == (BasicTrustRootIndex)this) || (((paramObject instanceof BasicTrustRootIndex)) && (Intrinsics.areEqual(((BasicTrustRootIndex)paramObject).subjectToCaCerts, this.subjectToCaCerts)));
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    Intrinsics.checkParameterIsNotNull(paramX509Certificate, "cert");
    Object localObject1 = paramX509Certificate.getIssuerX500Principal();
    Object localObject3 = (Set)this.subjectToCaCerts.get(localObject1);
    localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null)
    {
      localObject3 = ((Iterable)localObject3).iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject3).next();
        X509Certificate localX509Certificate = (X509Certificate)localObject1;
        try
        {
          paramX509Certificate.verify(localX509Certificate.getPublicKey());
          i = 1;
        }
        catch (Exception localException)
        {
          int i;
          for (;;) {}
        }
        i = 0;
      } while (i == 0);
      localObject1 = (X509Certificate)localObject1;
    }
    return (X509Certificate)localObject1;
  }
  
  public int hashCode()
  {
    return this.subjectToCaCerts.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\tls\BasicTrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */