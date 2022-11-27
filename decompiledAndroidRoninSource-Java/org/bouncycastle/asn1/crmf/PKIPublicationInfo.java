package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIPublicationInfo
  extends ASN1Object
{
  private ASN1Integer action;
  private ASN1Sequence pubInfos;
  
  private PKIPublicationInfo(ASN1Sequence paramASN1Sequence)
  {
    this.action = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.pubInfos = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public static PKIPublicationInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIPublicationInfo)) {
      return (PKIPublicationInfo)paramObject;
    }
    if (paramObject != null) {
      return new PKIPublicationInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getAction()
  {
    return this.action;
  }
  
  public SinglePubInfo[] getPubInfos()
  {
    Object localObject = this.pubInfos;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new SinglePubInfo[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(i));
      i += 1;
    }
    return (SinglePubInfo[])localObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.action);
    localASN1EncodableVector.add(this.pubInfos);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\PKIPublicationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */