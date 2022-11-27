package dji.thirdparty.okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class RealTrustRootIndex
  implements TrustRootIndex
{
  private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap();
  
  public RealTrustRootIndex(X509Certificate... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      List localList = (List)this.subjectToCaCerts.get(localX500Principal);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(1);
        this.subjectToCaCerts.put(localX500Principal, localObject);
      }
      ((List)localObject).add(localX509Certificate);
      i += 1;
    }
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\tls\RealTrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */