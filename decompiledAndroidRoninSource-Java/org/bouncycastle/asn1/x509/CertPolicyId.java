package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

public class CertPolicyId
  extends ASN1Object
{
  private ASN1ObjectIdentifier id;
  
  private CertPolicyId(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.id = paramASN1ObjectIdentifier;
  }
  
  public static CertPolicyId getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertPolicyId)) {
      return (CertPolicyId)paramObject;
    }
    if (paramObject != null) {
      return new CertPolicyId(ASN1ObjectIdentifier.getInstance(paramObject));
    }
    return null;
  }
  
  public String getId()
  {
    return this.id.getId();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.id;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CertPolicyId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */