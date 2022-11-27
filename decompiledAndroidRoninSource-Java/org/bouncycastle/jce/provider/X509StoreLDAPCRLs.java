package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

public class X509StoreLDAPCRLs
  extends X509StoreSpi
{
  private LDAPStoreHelper helper;
  
  public Collection engineGetMatches(Selector paramSelector)
    throws StoreException
  {
    if (!(paramSelector instanceof X509CRLStoreSelector)) {
      return Collections.EMPTY_SET;
    }
    paramSelector = (X509CRLStoreSelector)paramSelector;
    HashSet localHashSet = new HashSet();
    if (paramSelector.isDeltaCRLIndicatorEnabled())
    {
      paramSelector = this.helper.getDeltaCertificateRevocationLists(paramSelector);
    }
    else
    {
      localHashSet.addAll(this.helper.getDeltaCertificateRevocationLists(paramSelector));
      localHashSet.addAll(this.helper.getAttributeAuthorityRevocationLists(paramSelector));
      localHashSet.addAll(this.helper.getAttributeCertificateRevocationLists(paramSelector));
      localHashSet.addAll(this.helper.getAuthorityRevocationLists(paramSelector));
      paramSelector = this.helper.getCertificateRevocationLists(paramSelector);
    }
    localHashSet.addAll(paramSelector);
    return localHashSet;
  }
  
  public void engineInit(X509StoreParameters paramX509StoreParameters)
  {
    if ((paramX509StoreParameters instanceof X509LDAPCertStoreParameters))
    {
      this.helper = new LDAPStoreHelper((X509LDAPCertStoreParameters)paramX509StoreParameters);
      return;
    }
    paramX509StoreParameters = new StringBuilder();
    paramX509StoreParameters.append("Initialization parameters must be an instance of ");
    paramX509StoreParameters.append(X509LDAPCertStoreParameters.class.getName());
    paramX509StoreParameters.append(".");
    throw new IllegalArgumentException(paramX509StoreParameters.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509StoreLDAPCRLs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */