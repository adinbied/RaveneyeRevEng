package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class ContentHints
  extends ASN1Object
{
  private DERUTF8String contentDescription;
  private ASN1ObjectIdentifier contentType;
  
  public ContentHints(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.contentType = paramASN1ObjectIdentifier;
    this.contentDescription = null;
  }
  
  public ContentHints(ASN1ObjectIdentifier paramASN1ObjectIdentifier, DERUTF8String paramDERUTF8String)
  {
    this.contentType = paramASN1ObjectIdentifier;
    this.contentDescription = paramDERUTF8String;
  }
  
  private ContentHints(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    ASN1Encodable localASN1Encodable = paramASN1Sequence.getObjectAt(0);
    if ((localASN1Encodable.toASN1Primitive() instanceof DERUTF8String))
    {
      this.contentDescription = DERUTF8String.getInstance(localASN1Encodable);
      i = 1;
    }
    this.contentType = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
  }
  
  public static ContentHints getInstance(Object paramObject)
  {
    if ((paramObject instanceof ContentHints)) {
      return (ContentHints)paramObject;
    }
    if (paramObject != null) {
      return new ContentHints(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DERUTF8String getContentDescription()
  {
    return this.contentDescription;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentType;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    DERUTF8String localDERUTF8String = this.contentDescription;
    if (localDERUTF8String != null) {
      localASN1EncodableVector.add(localDERUTF8String);
    }
    localASN1EncodableVector.add(this.contentType);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\ContentHints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */