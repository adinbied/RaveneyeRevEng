package org.bouncycastle.cert.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Store;

public class JcaCertStoreBuilder
{
  private JcaX509CertificateConverter certificateConverter = new JcaX509CertificateConverter();
  private List certs = new ArrayList();
  private JcaX509CRLConverter crlConverter = new JcaX509CRLConverter();
  private List crls = new ArrayList();
  private Object provider;
  private String type = "Collection";
  
  private CollectionCertStoreParameters convertHolders(JcaX509CertificateConverter paramJcaX509CertificateConverter, JcaX509CRLConverter paramJcaX509CRLConverter)
    throws CertificateException, CRLException
  {
    ArrayList localArrayList = new ArrayList(this.certs.size() + this.crls.size());
    Iterator localIterator = this.certs.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(paramJcaX509CertificateConverter.getCertificate((X509CertificateHolder)localIterator.next()));
    }
    paramJcaX509CertificateConverter = this.crls.iterator();
    while (paramJcaX509CertificateConverter.hasNext()) {
      localArrayList.add(paramJcaX509CRLConverter.getCRL((X509CRLHolder)paramJcaX509CertificateConverter.next()));
    }
    return new CollectionCertStoreParameters(localArrayList);
  }
  
  public JcaCertStoreBuilder addCRL(X509CRLHolder paramX509CRLHolder)
  {
    this.crls.add(paramX509CRLHolder);
    return this;
  }
  
  public JcaCertStoreBuilder addCRLs(Store paramStore)
  {
    this.crls.addAll(paramStore.getMatches(null));
    return this;
  }
  
  public JcaCertStoreBuilder addCertificate(X509CertificateHolder paramX509CertificateHolder)
  {
    this.certs.add(paramX509CertificateHolder);
    return this;
  }
  
  public JcaCertStoreBuilder addCertificates(Store paramStore)
  {
    this.certs.addAll(paramStore.getMatches(null));
    return this;
  }
  
  public CertStore build()
    throws GeneralSecurityException
  {
    CollectionCertStoreParameters localCollectionCertStoreParameters = convertHolders(this.certificateConverter, this.crlConverter);
    Object localObject = this.provider;
    if ((localObject instanceof String)) {
      return CertStore.getInstance(this.type, localCollectionCertStoreParameters, (String)localObject);
    }
    if ((localObject instanceof Provider)) {
      return CertStore.getInstance(this.type, localCollectionCertStoreParameters, (Provider)localObject);
    }
    return CertStore.getInstance(this.type, localCollectionCertStoreParameters);
  }
  
  public JcaCertStoreBuilder setProvider(String paramString)
  {
    this.certificateConverter.setProvider(paramString);
    this.crlConverter.setProvider(paramString);
    this.provider = paramString;
    return this;
  }
  
  public JcaCertStoreBuilder setProvider(Provider paramProvider)
  {
    this.certificateConverter.setProvider(paramProvider);
    this.crlConverter.setProvider(paramProvider);
    this.provider = paramProvider;
    return this;
  }
  
  public JcaCertStoreBuilder setType(String paramString)
  {
    this.type = paramString;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaCertStoreBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */