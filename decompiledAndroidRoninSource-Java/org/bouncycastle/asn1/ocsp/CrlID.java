package org.bouncycastle.asn1.ocsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CrlID
  extends ASN1Object
{
  private ASN1Integer crlNum;
  private ASN1GeneralizedTime crlTime;
  private DERIA5String crlUrl;
  
  private CrlID(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = (ASN1TaggedObject)((Enumeration)localObject).nextElement();
      int i = paramASN1Sequence.getTagNo();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            this.crlTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence, true);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag number: ");
            ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else {
          this.crlNum = ASN1Integer.getInstance(paramASN1Sequence, true);
        }
      }
      else {
        this.crlUrl = DERIA5String.getInstance(paramASN1Sequence, true);
      }
    }
  }
  
  public static CrlID getInstance(Object paramObject)
  {
    if ((paramObject instanceof CrlID)) {
      return (CrlID)paramObject;
    }
    if (paramObject != null) {
      return new CrlID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getCrlNum()
  {
    return this.crlNum;
  }
  
  public ASN1GeneralizedTime getCrlTime()
  {
    return this.crlTime;
  }
  
  public DERIA5String getCrlUrl()
  {
    return this.crlUrl;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.crlUrl;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.crlNum;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    localObject = this.crlTime;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\CrlID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */