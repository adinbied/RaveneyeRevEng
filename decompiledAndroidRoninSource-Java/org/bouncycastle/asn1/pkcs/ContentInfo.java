package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DLSequence;

public class ContentInfo
  extends ASN1Object
  implements PKCSObjectIdentifiers
{
  private ASN1Encodable content;
  private ASN1ObjectIdentifier contentType;
  private boolean isBer = true;
  
  public ContentInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.contentType = paramASN1ObjectIdentifier;
    this.content = paramASN1Encodable;
  }
  
  private ContentInfo(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    this.contentType = ((ASN1ObjectIdentifier)localEnumeration.nextElement());
    if (localEnumeration.hasMoreElements()) {
      this.content = ((ASN1TaggedObject)localEnumeration.nextElement()).getObject();
    }
    this.isBer = (paramASN1Sequence instanceof BERSequence);
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
      localASN1EncodableVector.add(new BERTaggedObject(true, 0, localASN1Encodable));
    }
    if (this.isBer) {
      return new BERSequence(localASN1EncodableVector);
    }
    return new DLSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\ContentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */