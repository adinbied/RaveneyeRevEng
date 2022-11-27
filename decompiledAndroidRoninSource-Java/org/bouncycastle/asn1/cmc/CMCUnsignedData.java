package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CMCUnsignedData
  extends ASN1Object
{
  private final BodyPartPath bodyPartPath;
  private final ASN1Encodable content;
  private final ASN1ObjectIdentifier identifier;
  
  private CMCUnsignedData(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.bodyPartPath = BodyPartPath.getInstance(paramASN1Sequence.getObjectAt(0));
      this.identifier = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.content = paramASN1Sequence.getObjectAt(2);
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public CMCUnsignedData(BodyPartPath paramBodyPartPath, ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.bodyPartPath = paramBodyPartPath;
    this.identifier = paramASN1ObjectIdentifier;
    this.content = paramASN1Encodable;
  }
  
  public static CMCUnsignedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCUnsignedData)) {
      return (CMCUnsignedData)paramObject;
    }
    if (paramObject != null) {
      return new CMCUnsignedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartPath getBodyPartPath()
  {
    return this.bodyPartPath;
  }
  
  public ASN1Encodable getContent()
  {
    return this.content;
  }
  
  public ASN1ObjectIdentifier getIdentifier()
  {
    return this.identifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bodyPartPath);
    localASN1EncodableVector.add(this.identifier);
    localASN1EncodableVector.add(this.content);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCUnsignedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */