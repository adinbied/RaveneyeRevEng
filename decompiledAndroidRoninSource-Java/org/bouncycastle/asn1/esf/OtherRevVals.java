package org.bouncycastle.asn1.esf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevVals
  extends ASN1Object
{
  private ASN1ObjectIdentifier otherRevValType;
  private ASN1Encodable otherRevVals;
  
  public OtherRevVals(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.otherRevValType = paramASN1ObjectIdentifier;
    this.otherRevVals = paramASN1Encodable;
  }
  
  private OtherRevVals(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2) {
      this.otherRevValType = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    }
    try
    {
      this.otherRevVals = ASN1Primitive.fromByteArray(paramASN1Sequence.getObjectAt(1).toASN1Primitive().getEncoded("DER"));
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
  
  public static OtherRevVals getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherRevVals)) {
      return (OtherRevVals)paramObject;
    }
    if (paramObject != null) {
      return new OtherRevVals(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getOtherRevValType()
  {
    return this.otherRevValType;
  }
  
  public ASN1Encodable getOtherRevVals()
  {
    return this.otherRevVals;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.otherRevValType);
    localASN1EncodableVector.add(this.otherRevVals);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OtherRevVals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */