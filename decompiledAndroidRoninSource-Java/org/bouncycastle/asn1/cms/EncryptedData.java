package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;

public class EncryptedData
  extends ASN1Object
{
  private EncryptedContentInfo encryptedContentInfo;
  private ASN1Set unprotectedAttrs;
  private ASN1Integer version;
  
  private EncryptedData(ASN1Sequence paramASN1Sequence)
  {
    this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.encryptedContentInfo = EncryptedContentInfo.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() == 3) {
      this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(2), false);
    }
  }
  
  public EncryptedData(EncryptedContentInfo paramEncryptedContentInfo)
  {
    this(paramEncryptedContentInfo, null);
  }
  
  public EncryptedData(EncryptedContentInfo paramEncryptedContentInfo, ASN1Set paramASN1Set)
  {
    long l;
    if (paramASN1Set == null) {
      l = 0L;
    } else {
      l = 2L;
    }
    this.version = new ASN1Integer(l);
    this.encryptedContentInfo = paramEncryptedContentInfo;
    this.unprotectedAttrs = paramASN1Set;
  }
  
  public static EncryptedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedData)) {
      return (EncryptedData)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public EncryptedContentInfo getEncryptedContentInfo()
  {
    return this.encryptedContentInfo;
  }
  
  public ASN1Set getUnprotectedAttrs()
  {
    return this.unprotectedAttrs;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.encryptedContentInfo);
    ASN1Set localASN1Set = this.unprotectedAttrs;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new BERTaggedObject(false, 1, localASN1Set));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\EncryptedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */