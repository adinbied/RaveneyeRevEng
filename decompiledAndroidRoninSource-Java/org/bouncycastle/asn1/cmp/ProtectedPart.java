package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ProtectedPart
  extends ASN1Object
{
  private PKIBody body;
  private PKIHeader header;
  
  private ProtectedPart(ASN1Sequence paramASN1Sequence)
  {
    this.header = PKIHeader.getInstance(paramASN1Sequence.getObjectAt(0));
    this.body = PKIBody.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public ProtectedPart(PKIHeader paramPKIHeader, PKIBody paramPKIBody)
  {
    this.header = paramPKIHeader;
    this.body = paramPKIBody;
  }
  
  public static ProtectedPart getInstance(Object paramObject)
  {
    if ((paramObject instanceof ProtectedPart)) {
      return (ProtectedPart)paramObject;
    }
    if (paramObject != null) {
      return new ProtectedPart(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public PKIBody getBody()
  {
    return this.body;
  }
  
  public PKIHeader getHeader()
  {
    return this.header;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.header);
    localASN1EncodableVector.add(this.body);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\ProtectedPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */