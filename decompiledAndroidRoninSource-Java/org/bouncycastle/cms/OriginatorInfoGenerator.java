package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.cms.OriginatorInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Store;

public class OriginatorInfoGenerator
{
  private final List origCRLs;
  private final List origCerts;
  
  public OriginatorInfoGenerator(X509CertificateHolder paramX509CertificateHolder)
  {
    ArrayList localArrayList = new ArrayList(1);
    this.origCerts = localArrayList;
    this.origCRLs = null;
    localArrayList.add(paramX509CertificateHolder.toASN1Structure());
  }
  
  public OriginatorInfoGenerator(Store paramStore)
    throws CMSException
  {
    this(paramStore, null);
  }
  
  public OriginatorInfoGenerator(Store paramStore1, Store paramStore2)
    throws CMSException
  {
    this.origCerts = CMSUtils.getCertificatesFromStore(paramStore1);
    if (paramStore2 != null) {
      paramStore1 = CMSUtils.getCRLsFromStore(paramStore2);
    } else {
      paramStore1 = null;
    }
    this.origCRLs = paramStore1;
  }
  
  public OriginatorInformation generate()
  {
    if (this.origCRLs != null) {
      return new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), CMSUtils.createDerSetFromList(this.origCRLs)));
    }
    return new OriginatorInformation(new OriginatorInfo(CMSUtils.createDerSetFromList(this.origCerts), null));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\OriginatorInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */