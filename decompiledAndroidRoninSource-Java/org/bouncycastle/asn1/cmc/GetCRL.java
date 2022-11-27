package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.ReasonFlags;

public class GetCRL
  extends ASN1Object
{
  private GeneralName cRLName;
  private final X500Name issuerName;
  private ReasonFlags reasons;
  private ASN1GeneralizedTime time;
  
  private GetCRL(ASN1Sequence paramASN1Sequence)
  {
    int i = paramASN1Sequence.size();
    int j = 1;
    if ((i >= 1) && (paramASN1Sequence.size() <= 4))
    {
      this.issuerName = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
      i = j;
      if (paramASN1Sequence.size() > 1)
      {
        i = j;
        if ((paramASN1Sequence.getObjectAt(1).toASN1Primitive() instanceof ASN1TaggedObject))
        {
          this.cRLName = GeneralName.getInstance(paramASN1Sequence.getObjectAt(1));
          i = 2;
        }
      }
      j = i;
      if (paramASN1Sequence.size() > i)
      {
        j = i;
        if ((paramASN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1GeneralizedTime))
        {
          this.time = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(i));
          j = i + 1;
        }
      }
      if ((paramASN1Sequence.size() > j) && ((paramASN1Sequence.getObjectAt(j).toASN1Primitive() instanceof DERBitString))) {
        this.reasons = new ReasonFlags(DERBitString.getInstance(paramASN1Sequence.getObjectAt(j)));
      }
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public GetCRL(X500Name paramX500Name, GeneralName paramGeneralName, ASN1GeneralizedTime paramASN1GeneralizedTime, ReasonFlags paramReasonFlags)
  {
    this.issuerName = paramX500Name;
    this.cRLName = paramGeneralName;
    this.time = paramASN1GeneralizedTime;
    this.reasons = paramReasonFlags;
  }
  
  public static GetCRL getInstance(Object paramObject)
  {
    if ((paramObject instanceof GetCRL)) {
      return (GetCRL)paramObject;
    }
    if (paramObject != null) {
      return new GetCRL(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public X500Name getIssuerName()
  {
    return this.issuerName;
  }
  
  public ReasonFlags getReasons()
  {
    return this.reasons;
  }
  
  public ASN1GeneralizedTime getTime()
  {
    return this.time;
  }
  
  public GeneralName getcRLName()
  {
    return this.cRLName;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.issuerName);
    Object localObject = this.cRLName;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.time;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.reasons;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\GetCRL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */