package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class SignedData
  extends ASN1Object
  implements PKCSObjectIdentifiers
{
  private ASN1Set certificates;
  private ContentInfo contentInfo;
  private ASN1Set crls;
  private ASN1Set digestAlgorithms;
  private ASN1Set signerInfos;
  private ASN1Integer version;
  
  public SignedData(ASN1Integer paramASN1Integer, ASN1Set paramASN1Set1, ContentInfo paramContentInfo, ASN1Set paramASN1Set2, ASN1Set paramASN1Set3, ASN1Set paramASN1Set4)
  {
    this.version = paramASN1Integer;
    this.digestAlgorithms = paramASN1Set1;
    this.contentInfo = paramContentInfo;
    this.certificates = paramASN1Set2;
    this.crls = paramASN1Set3;
    this.signerInfos = paramASN1Set4;
  }
  
  public SignedData(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.version = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.digestAlgorithms = ((ASN1Set)paramASN1Sequence.nextElement());
    this.contentInfo = ContentInfo.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = (ASN1Primitive)paramASN1Sequence.nextElement();
      if ((localObject instanceof ASN1TaggedObject))
      {
        localObject = (ASN1TaggedObject)localObject;
        int i = ((ASN1TaggedObject)localObject).getTagNo();
        if (i != 0)
        {
          if (i == 1)
          {
            this.crls = ASN1Set.getInstance((ASN1TaggedObject)localObject, false);
          }
          else
          {
            paramASN1Sequence = new StringBuilder();
            paramASN1Sequence.append("unknown tag value ");
            paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
            throw new IllegalArgumentException(paramASN1Sequence.toString());
          }
        }
        else {
          this.certificates = ASN1Set.getInstance((ASN1TaggedObject)localObject, false);
        }
      }
      else
      {
        this.signerInfos = ((ASN1Set)localObject);
      }
    }
  }
  
  public static SignedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignedData)) {
      return (SignedData)paramObject;
    }
    if (paramObject != null) {
      return new SignedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Set getCRLs()
  {
    return this.crls;
  }
  
  public ASN1Set getCertificates()
  {
    return this.certificates;
  }
  
  public ContentInfo getContentInfo()
  {
    return this.contentInfo;
  }
  
  public ASN1Set getDigestAlgorithms()
  {
    return this.digestAlgorithms;
  }
  
  public ASN1Set getSignerInfos()
  {
    return this.signerInfos;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.digestAlgorithms);
    localASN1EncodableVector.add(this.contentInfo);
    ASN1Set localASN1Set = this.certificates;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1Set));
    }
    localASN1Set = this.crls;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localASN1Set));
    }
    localASN1EncodableVector.add(this.signerInfos);
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\SignedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */