package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class EnvelopedData
  extends ASN1Object
{
  private EncryptedContentInfo encryptedContentInfo;
  private OriginatorInfo originatorInfo;
  private ASN1Set recipientInfos;
  private ASN1Set unprotectedAttrs;
  private ASN1Integer version;
  
  public EnvelopedData(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    ASN1Encodable localASN1Encodable2 = paramASN1Sequence.getObjectAt(1);
    boolean bool = localASN1Encodable2 instanceof ASN1TaggedObject;
    int i = 2;
    ASN1Encodable localASN1Encodable1 = localASN1Encodable2;
    if (bool)
    {
      this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject)localASN1Encodable2, false);
      localASN1Encodable1 = paramASN1Sequence.getObjectAt(2);
      i = 3;
    }
    this.recipientInfos = ASN1Set.getInstance(localASN1Encodable1);
    int j = i + 1;
    this.encryptedContentInfo = EncryptedContentInfo.getInstance(paramASN1Sequence.getObjectAt(i));
    if (paramASN1Sequence.size() > j) {
      this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(j), false);
    }
  }
  
  public EnvelopedData(OriginatorInfo paramOriginatorInfo, ASN1Set paramASN1Set1, EncryptedContentInfo paramEncryptedContentInfo, ASN1Set paramASN1Set2)
  {
    this.version = new ASN1Integer(calculateVersion(paramOriginatorInfo, paramASN1Set1, paramASN1Set2));
    this.originatorInfo = paramOriginatorInfo;
    this.recipientInfos = paramASN1Set1;
    this.encryptedContentInfo = paramEncryptedContentInfo;
    this.unprotectedAttrs = paramASN1Set2;
  }
  
  public EnvelopedData(OriginatorInfo paramOriginatorInfo, ASN1Set paramASN1Set, EncryptedContentInfo paramEncryptedContentInfo, Attributes paramAttributes)
  {
    this.version = new ASN1Integer(calculateVersion(paramOriginatorInfo, paramASN1Set, ASN1Set.getInstance(paramAttributes)));
    this.originatorInfo = paramOriginatorInfo;
    this.recipientInfos = paramASN1Set;
    this.encryptedContentInfo = paramEncryptedContentInfo;
    this.unprotectedAttrs = ASN1Set.getInstance(paramAttributes);
  }
  
  public static int calculateVersion(OriginatorInfo paramOriginatorInfo, ASN1Set paramASN1Set1, ASN1Set paramASN1Set2)
  {
    int i = 2;
    if (paramOriginatorInfo == null)
    {
      if (paramASN1Set2 != null) {
        return 2;
      }
      paramOriginatorInfo = paramASN1Set1.getObjects();
      while (paramOriginatorInfo.hasMoreElements()) {
        if (RecipientInfo.getInstance(paramOriginatorInfo.nextElement()).getVersion().getValue().intValue() != 0) {
          return 2;
        }
      }
      i = 0;
    }
    return i;
  }
  
  public static EnvelopedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof EnvelopedData)) {
      return (EnvelopedData)paramObject;
    }
    if (paramObject != null) {
      return new EnvelopedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static EnvelopedData getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public EncryptedContentInfo getEncryptedContentInfo()
  {
    return this.encryptedContentInfo;
  }
  
  public OriginatorInfo getOriginatorInfo()
  {
    return this.originatorInfo;
  }
  
  public ASN1Set getRecipientInfos()
  {
    return this.recipientInfos;
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
    if (this.originatorInfo != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.originatorInfo));
    }
    localASN1EncodableVector.add(this.recipientInfos);
    localASN1EncodableVector.add(this.encryptedContentInfo);
    if (this.unprotectedAttrs != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.unprotectedAttrs));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\EnvelopedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */