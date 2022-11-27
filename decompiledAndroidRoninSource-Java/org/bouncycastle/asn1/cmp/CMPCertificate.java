package org.bouncycastle.asn1.cmp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;

public class CMPCertificate
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Object otherCert;
  private int otherTagValue;
  private Certificate x509v3PKCert;
  
  public CMPCertificate(int paramInt, ASN1Object paramASN1Object)
  {
    this.otherTagValue = paramInt;
    this.otherCert = paramASN1Object;
  }
  
  public CMPCertificate(AttributeCertificate paramAttributeCertificate)
  {
    this(1, paramAttributeCertificate);
  }
  
  public CMPCertificate(Certificate paramCertificate)
  {
    if (paramCertificate.getVersionNumber() == 3)
    {
      this.x509v3PKCert = paramCertificate;
      return;
    }
    throw new IllegalArgumentException("only version 3 certificates allowed");
  }
  
  public static CMPCertificate getInstance(Object paramObject)
  {
    Object localObject;
    if ((paramObject != null) && (!(paramObject instanceof CMPCertificate)))
    {
      localObject = paramObject;
      if (!(paramObject instanceof byte[])) {}
    }
    try
    {
      localObject = ASN1Primitive.fromByteArray((byte[])paramObject);
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Invalid encoding in CMPCertificate");
    if ((localObject instanceof ASN1Sequence)) {
      return new CMPCertificate(Certificate.getInstance(localObject));
    }
    if ((localObject instanceof ASN1TaggedObject))
    {
      paramObject = (ASN1TaggedObject)localObject;
      return new CMPCertificate(((ASN1TaggedObject)paramObject).getTagNo(), ((ASN1TaggedObject)paramObject).getObject());
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("Invalid object: ");
    ((StringBuilder)paramObject).append(localObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    return (CMPCertificate)paramObject;
  }
  
  public ASN1Object getOtherCert()
  {
    return this.otherCert;
  }
  
  public int getOtherCertTag()
  {
    return this.otherTagValue;
  }
  
  public AttributeCertificate getX509v2AttrCert()
  {
    return AttributeCertificate.getInstance(this.otherCert);
  }
  
  public Certificate getX509v3PKCert()
  {
    return this.x509v3PKCert;
  }
  
  public boolean isX509v3PKCert()
  {
    return this.x509v3PKCert != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1Object localASN1Object = this.otherCert;
    if (localASN1Object != null) {
      return new DERTaggedObject(true, this.otherTagValue, localASN1Object);
    }
    return this.x509v3PKCert.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CMPCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */