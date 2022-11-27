package org.bouncycastle.cert.jcajce;

import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.util.CollectionStore;

public class JcaCRLStore
  extends CollectionStore
{
  public JcaCRLStore(Collection paramCollection)
    throws CRLException
  {
    super(convertCRLs(paramCollection));
  }
  
  private static Collection convertCRLs(Collection paramCollection)
    throws CRLException
  {
    Object localObject1 = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject2 = paramCollection.next();
      if ((localObject2 instanceof X509CRL)) {
        try
        {
          ((List)localObject1).add(new X509CRLHolder(((X509CRL)localObject2).getEncoded()));
        }
        catch (IOException paramCollection)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("cannot read encoding: ");
          ((StringBuilder)localObject1).append(paramCollection.getMessage());
          throw new CRLException(((StringBuilder)localObject1).toString());
        }
      } else {
        ((List)localObject1).add((X509CRLHolder)localObject2);
      }
    }
    return (Collection)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaCRLStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */