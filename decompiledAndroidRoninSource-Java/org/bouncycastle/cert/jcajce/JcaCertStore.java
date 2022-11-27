package org.bouncycastle.cert.jcajce;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.CollectionStore;

public class JcaCertStore
  extends CollectionStore
{
  public JcaCertStore(Collection paramCollection)
    throws CertificateEncodingException
  {
    super(convertCerts(paramCollection));
  }
  
  private static Collection convertCerts(Collection paramCollection)
    throws CertificateEncodingException
  {
    Object localObject1 = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject2 = paramCollection.next();
      if ((localObject2 instanceof X509Certificate))
      {
        localObject2 = (X509Certificate)localObject2;
        try
        {
          ((List)localObject1).add(new X509CertificateHolder(((X509Certificate)localObject2).getEncoded()));
        }
        catch (IOException paramCollection)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("unable to read encoding: ");
          ((StringBuilder)localObject1).append(paramCollection.getMessage());
          throw new CertificateEncodingException(((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        ((List)localObject1).add((X509CertificateHolder)localObject2);
      }
    }
    return (Collection)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaCertStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */