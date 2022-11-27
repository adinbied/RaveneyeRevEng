package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class SignedData
  extends ASN1Object
{
  private static final ASN1Integer VERSION_1 = new ASN1Integer(1L);
  private static final ASN1Integer VERSION_3 = new ASN1Integer(3L);
  private static final ASN1Integer VERSION_4 = new ASN1Integer(4L);
  private static final ASN1Integer VERSION_5 = new ASN1Integer(5L);
  private ASN1Set certificates;
  private boolean certsBer;
  private ContentInfo contentInfo;
  private ASN1Set crls;
  private boolean crlsBer;
  private ASN1Set digestAlgorithms;
  private ASN1Set signerInfos;
  private ASN1Integer version;
  
  private SignedData(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.version = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
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
            this.crlsBer = (localObject instanceof BERTaggedObject);
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
        else
        {
          this.certsBer = (localObject instanceof BERTaggedObject);
          this.certificates = ASN1Set.getInstance((ASN1TaggedObject)localObject, false);
        }
      }
      else
      {
        this.signerInfos = ((ASN1Set)localObject);
      }
    }
  }
  
  public SignedData(ASN1Set paramASN1Set1, ContentInfo paramContentInfo, ASN1Set paramASN1Set2, ASN1Set paramASN1Set3, ASN1Set paramASN1Set4)
  {
    this.version = calculateVersion(paramContentInfo.getContentType(), paramASN1Set2, paramASN1Set3, paramASN1Set4);
    this.digestAlgorithms = paramASN1Set1;
    this.contentInfo = paramContentInfo;
    this.certificates = paramASN1Set2;
    this.crls = paramASN1Set3;
    this.signerInfos = paramASN1Set4;
    this.crlsBer = (paramASN1Set3 instanceof BERSet);
    this.certsBer = (paramASN1Set2 instanceof BERSet);
  }
  
  private ASN1Integer calculateVersion(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Set paramASN1Set1, ASN1Set paramASN1Set2, ASN1Set paramASN1Set3)
  {
    int i3 = 0;
    int i2 = 0;
    int i;
    if (paramASN1Set1 != null)
    {
      paramASN1Set1 = paramASN1Set1.getObjects();
      int k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        i1 = k;
        n = j;
        m = i;
        if (!paramASN1Set1.hasMoreElements()) {
          break;
        }
        Object localObject = paramASN1Set1.nextElement();
        if ((localObject instanceof ASN1TaggedObject))
        {
          localObject = ASN1TaggedObject.getInstance(localObject);
          if (((ASN1TaggedObject)localObject).getTagNo() == 1) {
            j = 1;
          } else if (((ASN1TaggedObject)localObject).getTagNo() == 2) {
            i = 1;
          } else if (((ASN1TaggedObject)localObject).getTagNo() == 3) {
            k = 1;
          }
        }
      }
    }
    int i1 = 0;
    int n = 0;
    int m = 0;
    if (i1 != 0) {
      return new ASN1Integer(5L);
    }
    int j = i3;
    if (paramASN1Set2 != null)
    {
      paramASN1Set1 = paramASN1Set2.getObjects();
      i = i2;
      for (;;)
      {
        j = i;
        if (!paramASN1Set1.hasMoreElements()) {
          break;
        }
        if ((paramASN1Set1.nextElement() instanceof ASN1TaggedObject)) {
          i = 1;
        }
      }
    }
    if (j != 0) {
      return VERSION_5;
    }
    if (m != 0) {
      return VERSION_4;
    }
    if (n != 0) {
      return VERSION_3;
    }
    if (checkForVersion3(paramASN1Set3)) {
      return VERSION_3;
    }
    if (!CMSObjectIdentifiers.data.equals(paramASN1ObjectIdentifier)) {
      return VERSION_3;
    }
    return VERSION_1;
  }
  
  private boolean checkForVersion3(ASN1Set paramASN1Set)
  {
    paramASN1Set = paramASN1Set.getObjects();
    while (paramASN1Set.hasMoreElements()) {
      if (SignerInfo.getInstance(paramASN1Set.nextElement()).getVersion().getValue().intValue() == 3) {
        return true;
      }
    }
    return false;
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
  
  public ASN1Set getDigestAlgorithms()
  {
    return this.digestAlgorithms;
  }
  
  public ContentInfo getEncapContentInfo()
  {
    return this.contentInfo;
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
      if (this.certsBer) {
        localASN1EncodableVector.add(new BERTaggedObject(false, 0, localASN1Set));
      } else {
        localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.certificates));
      }
    }
    localASN1Set = this.crls;
    if (localASN1Set != null) {
      if (this.crlsBer) {
        localASN1EncodableVector.add(new BERTaggedObject(false, 1, localASN1Set));
      } else {
        localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.crls));
      }
    }
    localASN1EncodableVector.add(this.signerInfos);
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\SignedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */