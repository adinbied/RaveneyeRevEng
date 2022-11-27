package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.OriginatorInfo;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;

public class OriginatorInformation
{
  private OriginatorInfo originatorInfo;
  
  OriginatorInformation(OriginatorInfo paramOriginatorInfo)
  {
    this.originatorInfo = paramOriginatorInfo;
  }
  
  public Store getCRLs()
  {
    Object localObject = this.originatorInfo.getCRLs();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList(((ASN1Set)localObject).size());
      localObject = ((ASN1Set)localObject).getObjects();
      while (((Enumeration)localObject).hasMoreElements())
      {
        ASN1Primitive localASN1Primitive = ((ASN1Encodable)((Enumeration)localObject).nextElement()).toASN1Primitive();
        if ((localASN1Primitive instanceof ASN1Sequence)) {
          localArrayList.add(new X509CRLHolder(CertificateList.getInstance(localASN1Primitive)));
        }
      }
      return new CollectionStore(localArrayList);
    }
    return new CollectionStore(new ArrayList());
  }
  
  public Store getCertificates()
  {
    Object localObject = this.originatorInfo.getCertificates();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList(((ASN1Set)localObject).size());
      localObject = ((ASN1Set)localObject).getObjects();
      while (((Enumeration)localObject).hasMoreElements())
      {
        ASN1Primitive localASN1Primitive = ((ASN1Encodable)((Enumeration)localObject).nextElement()).toASN1Primitive();
        if ((localASN1Primitive instanceof ASN1Sequence)) {
          localArrayList.add(new X509CertificateHolder(Certificate.getInstance(localASN1Primitive)));
        }
      }
      return new CollectionStore(localArrayList);
    }
    return new CollectionStore(new ArrayList());
  }
  
  public OriginatorInfo toASN1Structure()
  {
    return this.originatorInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\OriginatorInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */