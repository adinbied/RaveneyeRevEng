package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class SinglePubInfo
  extends ASN1Object
{
  private GeneralName pubLocation;
  private ASN1Integer pubMethod;
  
  private SinglePubInfo(ASN1Sequence paramASN1Sequence)
  {
    this.pubMethod = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2) {
      this.pubLocation = GeneralName.getInstance(paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public static SinglePubInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof SinglePubInfo)) {
      return (SinglePubInfo)paramObject;
    }
    if (paramObject != null) {
      return new SinglePubInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralName getPubLocation()
  {
    return this.pubLocation;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pubMethod);
    GeneralName localGeneralName = this.pubLocation;
    if (localGeneralName != null) {
      localASN1EncodableVector.add(localGeneralName);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\SinglePubInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */