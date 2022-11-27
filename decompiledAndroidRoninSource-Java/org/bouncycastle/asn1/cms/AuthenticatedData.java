package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedData
  extends ASN1Object
{
  private ASN1Set authAttrs;
  private AlgorithmIdentifier digestAlgorithm;
  private ContentInfo encapsulatedContentInfo;
  private ASN1OctetString mac;
  private AlgorithmIdentifier macAlgorithm;
  private OriginatorInfo originatorInfo;
  private ASN1Set recipientInfos;
  private ASN1Set unauthAttrs;
  private ASN1Integer version;
  
  private AuthenticatedData(ASN1Sequence paramASN1Sequence)
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
    int k = i + 1;
    this.macAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
    int j = k + 1;
    localASN1Encodable2 = paramASN1Sequence.getObjectAt(k);
    localASN1Encodable1 = localASN1Encodable2;
    i = j;
    if ((localASN1Encodable2 instanceof ASN1TaggedObject))
    {
      this.digestAlgorithm = AlgorithmIdentifier.getInstance((ASN1TaggedObject)localASN1Encodable2, false);
      localASN1Encodable1 = paramASN1Sequence.getObjectAt(j);
      i = j + 1;
    }
    this.encapsulatedContentInfo = ContentInfo.getInstance(localASN1Encodable1);
    j = i + 1;
    localASN1Encodable2 = paramASN1Sequence.getObjectAt(i);
    i = j;
    localASN1Encodable1 = localASN1Encodable2;
    if ((localASN1Encodable2 instanceof ASN1TaggedObject))
    {
      this.authAttrs = ASN1Set.getInstance((ASN1TaggedObject)localASN1Encodable2, false);
      localASN1Encodable1 = paramASN1Sequence.getObjectAt(j);
      i = j + 1;
    }
    this.mac = ASN1OctetString.getInstance(localASN1Encodable1);
    if (paramASN1Sequence.size() > i) {
      this.unauthAttrs = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(i), false);
    }
  }
  
  public AuthenticatedData(OriginatorInfo paramOriginatorInfo, ASN1Set paramASN1Set1, AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, ContentInfo paramContentInfo, ASN1Set paramASN1Set2, ASN1OctetString paramASN1OctetString, ASN1Set paramASN1Set3)
  {
    if (((paramAlgorithmIdentifier2 == null) && (paramASN1Set2 == null)) || ((paramAlgorithmIdentifier2 != null) && (paramASN1Set2 != null)))
    {
      this.version = new ASN1Integer(calculateVersion(paramOriginatorInfo));
      this.originatorInfo = paramOriginatorInfo;
      this.macAlgorithm = paramAlgorithmIdentifier1;
      this.digestAlgorithm = paramAlgorithmIdentifier2;
      this.recipientInfos = paramASN1Set1;
      this.encapsulatedContentInfo = paramContentInfo;
      this.authAttrs = paramASN1Set2;
      this.mac = paramASN1OctetString;
      this.unauthAttrs = paramASN1Set3;
      return;
    }
    throw new IllegalArgumentException("digestAlgorithm and authAttrs must be set together");
  }
  
  public static int calculateVersion(OriginatorInfo paramOriginatorInfo)
  {
    int i = 0;
    if (paramOriginatorInfo == null) {
      return 0;
    }
    Object localObject1 = paramOriginatorInfo.getCertificates().getObjects();
    Object localObject2;
    do
    {
      for (;;)
      {
        j = i;
        if (!((Enumeration)localObject1).hasMoreElements()) {
          break label75;
        }
        localObject2 = ((Enumeration)localObject1).nextElement();
        if ((localObject2 instanceof ASN1TaggedObject))
        {
          localObject2 = (ASN1TaggedObject)localObject2;
          if (((ASN1TaggedObject)localObject2).getTagNo() != 2) {
            break;
          }
          i = 1;
        }
      }
    } while (((ASN1TaggedObject)localObject2).getTagNo() != 3);
    int j = 3;
    label75:
    if (paramOriginatorInfo.getCRLs() != null)
    {
      paramOriginatorInfo = paramOriginatorInfo.getCRLs().getObjects();
      while (paramOriginatorInfo.hasMoreElements())
      {
        localObject1 = paramOriginatorInfo.nextElement();
        if (((localObject1 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)localObject1).getTagNo() == 1)) {
          return 3;
        }
      }
    }
    return j;
  }
  
  public static AuthenticatedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof AuthenticatedData)) {
      return (AuthenticatedData)paramObject;
    }
    if (paramObject != null) {
      return new AuthenticatedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static AuthenticatedData getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Set getAuthAttrs()
  {
    return this.authAttrs;
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digestAlgorithm;
  }
  
  public ContentInfo getEncapsulatedContentInfo()
  {
    return this.encapsulatedContentInfo;
  }
  
  public ASN1OctetString getMac()
  {
    return this.mac;
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
  {
    return this.macAlgorithm;
  }
  
  public OriginatorInfo getOriginatorInfo()
  {
    return this.originatorInfo;
  }
  
  public ASN1Set getRecipientInfos()
  {
    return this.recipientInfos;
  }
  
  public ASN1Set getUnauthAttrs()
  {
    return this.unauthAttrs;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    Object localObject = this.originatorInfo;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localASN1EncodableVector.add(this.recipientInfos);
    localASN1EncodableVector.add(this.macAlgorithm);
    localObject = this.digestAlgorithm;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    localASN1EncodableVector.add(this.encapsulatedContentInfo);
    localObject = this.authAttrs;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
    }
    localASN1EncodableVector.add(this.mac);
    localObject = this.unauthAttrs;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 3, (ASN1Encodable)localObject));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\AuthenticatedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */