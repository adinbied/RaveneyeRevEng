package org.bouncycastle.asn1.esf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevRefs
  extends ASN1Object
{
  private ASN1ObjectIdentifier otherRevRefType;
  private ASN1Encodable otherRevRefs;
  
  public OtherRevRefs(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.otherRevRefType = paramASN1ObjectIdentifier;
    this.otherRevRefs = paramASN1Encodable;
  }
  
  private OtherRevRefs(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2) {
      this.otherRevRefType = new ASN1ObjectIdentifier(((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0)).getId());
    }
    try
    {
      this.otherRevRefs = ASN1Primitive.fromByteArray(paramASN1Sequence.getObjectAt(1).toASN1Primitive().getEncoded("DER"));
      return;
    }
    catch (IOException paramASN1Sequence)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    throw new IllegalStateException();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static OtherRevRefs getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherRevRefs)) {
      return (OtherRevRefs)paramObject;
    }
    if (paramObject != null) {
      return new OtherRevRefs(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getOtherRevRefType()
  {
    return this.otherRevRefType;
  }
  
  public ASN1Encodable getOtherRevRefs()
  {
    return this.otherRevRefs;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.otherRevRefType);
    localASN1EncodableVector.add(this.otherRevRefs);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OtherRevRefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */