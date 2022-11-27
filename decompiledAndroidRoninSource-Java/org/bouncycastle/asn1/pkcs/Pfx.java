package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;

public class Pfx
  extends ASN1Object
  implements PKCSObjectIdentifiers
{
  private ContentInfo contentInfo;
  private MacData macData = null;
  
  private Pfx(ASN1Sequence paramASN1Sequence)
  {
    if (((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue().intValue() == 3)
    {
      this.contentInfo = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.size() == 3) {
        this.macData = MacData.getInstance(paramASN1Sequence.getObjectAt(2));
      }
      return;
    }
    throw new IllegalArgumentException("wrong version for PFX PDU");
  }
  
  public Pfx(ContentInfo paramContentInfo, MacData paramMacData)
  {
    this.contentInfo = paramContentInfo;
    this.macData = paramMacData;
  }
  
  public static Pfx getInstance(Object paramObject)
  {
    if ((paramObject instanceof Pfx)) {
      return (Pfx)paramObject;
    }
    if (paramObject != null) {
      return new Pfx(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ContentInfo getAuthSafe()
  {
    return this.contentInfo;
  }
  
  public MacData getMacData()
  {
    return this.macData;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(3L));
    localASN1EncodableVector.add(this.contentInfo);
    MacData localMacData = this.macData;
    if (localMacData != null) {
      localASN1EncodableVector.add(localMacData);
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\Pfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */