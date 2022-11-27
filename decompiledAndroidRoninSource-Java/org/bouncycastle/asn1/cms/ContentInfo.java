package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;

public class ContentInfo
  extends ASN1Object
  implements CMSObjectIdentifiers
{
  private ASN1Encodable content;
  private ASN1ObjectIdentifier contentType;
  
  public ContentInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.contentType = paramASN1ObjectIdentifier;
    this.content = paramASN1Encodable;
  }
  
  public ContentInfo(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.contentType = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1)
      {
        paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(1);
        if ((paramASN1Sequence.isExplicit()) && (paramASN1Sequence.getTagNo() == 0))
        {
          this.content = paramASN1Sequence.getObject();
          return;
        }
        throw new IllegalArgumentException("Bad tag for 'content'");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static ContentInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof ContentInfo)) {
      return (ContentInfo)paramObject;
    }
    if (paramObject != null) {
      return new ContentInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ContentInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Encodable getContent()
  {
    return this.content;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentType;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.contentType);
    ASN1Encodable localASN1Encodable = this.content;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(new BERTaggedObject(0, localASN1Encodable));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\ContentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */