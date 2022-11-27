package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AccessDescription
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier id_ad_caIssuers = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.2");
  public static final ASN1ObjectIdentifier id_ad_ocsp = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");
  GeneralName accessLocation = null;
  ASN1ObjectIdentifier accessMethod = null;
  
  public AccessDescription(ASN1ObjectIdentifier paramASN1ObjectIdentifier, GeneralName paramGeneralName)
  {
    this.accessMethod = paramASN1ObjectIdentifier;
    this.accessLocation = paramGeneralName;
  }
  
  private AccessDescription(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.accessMethod = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.accessLocation = GeneralName.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("wrong number of elements in sequence");
  }
  
  public static AccessDescription getInstance(Object paramObject)
  {
    if ((paramObject instanceof AccessDescription)) {
      return (AccessDescription)paramObject;
    }
    if (paramObject != null) {
      return new AccessDescription(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralName getAccessLocation()
  {
    return this.accessLocation;
  }
  
  public ASN1ObjectIdentifier getAccessMethod()
  {
    return this.accessMethod;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.accessMethod);
    localASN1EncodableVector.add(this.accessLocation);
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccessDescription: Oid(");
    localStringBuilder.append(this.accessMethod.getId());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AccessDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */