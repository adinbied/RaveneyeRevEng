package org.bouncycastle.cert.path;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.cert.X509CertificateHolder;

class CertPathUtils
{
  static Set getCriticalExtensionsOIDs(X509CertificateHolder[] paramArrayOfX509CertificateHolder)
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    while (i != paramArrayOfX509CertificateHolder.length)
    {
      localHashSet.addAll(paramArrayOfX509CertificateHolder[i].getCriticalExtensionOIDs());
      i += 1;
    }
    return localHashSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */