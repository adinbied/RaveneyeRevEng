package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class AuthEnvelopedData
  extends ASN1Object
{
  private ASN1Set authAttrs;
  private EncryptedContentInfo authEncryptedContentInfo;
  private ASN1OctetString mac;
  private OriginatorInfo originatorInfo;
  private ASN1Set recipientInfos;
  private ASN1Set unauthAttrs;
  private ASN1Integer version;
  
  private AuthEnvelopedData(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = (ASN1Integer)paramASN1Sequence.getObjectAt(0).toASN1Primitive();
    this.version = ((ASN1Integer)localObject);
    if (((ASN1Integer)localObject).getValue().intValue() == 0)
    {
      int i = 2;
      ASN1Primitive localASN1Primitive = paramASN1Sequence.getObjectAt(1).toASN1Primitive();
      localObject = localASN1Primitive;
      if ((localASN1Primitive instanceof ASN1TaggedObject))
      {
        this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject)localASN1Primitive, false);
        localObject = paramASN1Sequence.getObjectAt(2).toASN1Primitive();
        i = 3;
      }
      localObject = ASN1Set.getInstance(localObject);
      this.recipientInfos = ((ASN1Set)localObject);
      if (((ASN1Set)localObject).size() != 0)
      {
        int k = i + 1;
        this.authEncryptedContentInfo = EncryptedContentInfo.getInstance(paramASN1Sequence.getObjectAt(i).toASN1Primitive());
        int j = k + 1;
        localASN1Primitive = paramASN1Sequence.getObjectAt(k).toASN1Primitive();
        if ((localASN1Primitive instanceof ASN1TaggedObject))
        {
          this.authAttrs = ASN1Set.getInstance((ASN1TaggedObject)localASN1Primitive, false);
          localObject = paramASN1Sequence.getObjectAt(j).toASN1Primitive();
          i = j + 1;
        }
        else
        {
          i = j;
          localObject = localASN1Primitive;
          if (!this.authEncryptedContentInfo.getContentType().equals(CMSObjectIdentifiers.data))
          {
            localObject = this.authAttrs;
            if ((localObject != null) && (((ASN1Set)localObject).size() != 0))
            {
              i = j;
              localObject = localASN1Primitive;
            }
            else
            {
              throw new IllegalArgumentException("authAttrs must be present with non-data content");
            }
          }
        }
        this.mac = ASN1OctetString.getInstance(localObject);
        if (paramASN1Sequence.size() > i) {
          this.unauthAttrs = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(i).toASN1Primitive(), false);
        }
        return;
      }
      throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
    }
    throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
  }
  
  public AuthEnvelopedData(OriginatorInfo paramOriginatorInfo, ASN1Set paramASN1Set1, EncryptedContentInfo paramEncryptedContentInfo, ASN1Set paramASN1Set2, ASN1OctetString paramASN1OctetString, ASN1Set paramASN1Set3)
  {
    this.version = new ASN1Integer(0L);
    this.originatorInfo = paramOriginatorInfo;
    this.recipientInfos = paramASN1Set1;
    if (paramASN1Set1.size() != 0)
    {
      this.authEncryptedContentInfo = paramEncryptedContentInfo;
      this.authAttrs = paramASN1Set2;
      if ((!paramEncryptedContentInfo.getContentType().equals(CMSObjectIdentifiers.data)) && ((paramASN1Set2 == null) || (paramASN1Set2.size() == 0))) {
        throw new IllegalArgumentException("authAttrs must be present with non-data content");
      }
      this.mac = paramASN1OctetString;
      this.unauthAttrs = paramASN1Set3;
      return;
    }
    throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
  }
  
  public static AuthEnvelopedData getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof AuthEnvelopedData)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new AuthEnvelopedData((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid AuthEnvelopedData: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (AuthEnvelopedData)paramObject;
  }
  
  public static AuthEnvelopedData getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Set getAuthAttrs()
  {
    return this.authAttrs;
  }
  
  public EncryptedContentInfo getAuthEncryptedContentInfo()
  {
    return this.authEncryptedContentInfo;
  }
  
  public ASN1OctetString getMac()
  {
    return this.mac;
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
    if (this.originatorInfo != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.originatorInfo));
    }
    localASN1EncodableVector.add(this.recipientInfos);
    localASN1EncodableVector.add(this.authEncryptedContentInfo);
    if (this.authAttrs != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.authAttrs));
    }
    localASN1EncodableVector.add(this.mac);
    if (this.unauthAttrs != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, this.unauthAttrs));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\AuthEnvelopedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */