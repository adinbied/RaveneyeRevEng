package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\003\030\000 \0252\0020\001:\001\025B\r\022\006\020\002\032\0020\003¢\006\002\020\004J$\020\005\032\b\022\004\022\0020\0070\0062\f\020\b\032\b\022\004\022\0020\0070\0062\006\020\t\032\0020\nH\026J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002J\b\020\017\032\0020\020H\026J\030\020\021\032\0020\f2\006\020\022\032\0020\0232\006\020\024\032\0020\023H\002R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\026"}, d2={"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class BasicCertificateChainCleaner
  extends CertificateChainCleaner
{
  public static final Companion Companion = new Companion(null);
  private static final int MAX_SIGNERS = 9;
  private final TrustRootIndex trustRootIndex;
  
  public BasicCertificateChainCleaner(TrustRootIndex paramTrustRootIndex)
  {
    this.trustRootIndex = paramTrustRootIndex;
  }
  
  private final boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if ((Intrinsics.areEqual(paramX509Certificate1.getIssuerDN(), paramX509Certificate2.getSubjectDN()) ^ true)) {
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1)
    {
      for (;;) {}
    }
    return false;
  }
  
  public List<Certificate> clean(List<? extends Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "chain");
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    paramString = (Deque)new ArrayDeque((Collection)paramList);
    paramList = (List)new ArrayList();
    Object localObject1 = paramString.removeFirst();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "queue.removeFirst()");
    paramList.add(localObject1);
    int i = 0;
    int j = 0;
    while (i < 9)
    {
      localObject1 = paramList.get(paramList.size() - 1);
      if (localObject1 != null)
      {
        localObject1 = (X509Certificate)localObject1;
        Object localObject2 = this.trustRootIndex.findByIssuerAndSignature((X509Certificate)localObject1);
        if (localObject2 != null)
        {
          if ((paramList.size() > 1) || ((Intrinsics.areEqual(localObject1, localObject2) ^ true))) {
            paramList.add(localObject2);
          }
          if (verifySignature((X509Certificate)localObject2, (X509Certificate)localObject2)) {
            return paramList;
          }
          j = 1;
        }
        else
        {
          localObject2 = paramString.iterator();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "queue.iterator()");
          Object localObject3;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label259;
            }
            localObject3 = ((Iterator)localObject2).next();
            if (localObject3 == null) {
              break;
            }
            localObject3 = (X509Certificate)localObject3;
          } while (!verifySignature((X509Certificate)localObject1, (X509Certificate)localObject3));
          ((Iterator)localObject2).remove();
          paramList.add(localObject3);
        }
        i += 1;
        continue;
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        label259:
        if (j != 0) {
          return paramList;
        }
        paramList = new StringBuilder();
        paramList.append("Failed to find a trusted cert that signed ");
        paramList.append(localObject1);
        throw ((Throwable)new SSLPeerUnverifiedException(paramList.toString()));
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
      }
    }
    paramString = new StringBuilder();
    paramString.append("Certificate chain too long: ");
    paramString.append(paramList);
    throw ((Throwable)new SSLPeerUnverifiedException(paramString.toString()));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == (BasicCertificateChainCleaner)this) {
      return true;
    }
    return ((paramObject instanceof BasicCertificateChainCleaner)) && (Intrinsics.areEqual(((BasicCertificateChainCleaner)paramObject).trustRootIndex, this.trustRootIndex));
  }
  
  public int hashCode()
  {
    return this.trustRootIndex.hashCode();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\tls\BasicCertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */