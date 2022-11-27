package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfo
  extends ASN1Object
{
  private AlgorithmIdentifier contentEncryptionAlgorithm;
  private ASN1ObjectIdentifier contentType;
  private ASN1OctetString encryptedContent;
  
  public EncryptedContentInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.contentType = paramASN1ObjectIdentifier;
    this.contentEncryptionAlgorithm = paramAlgorithmIdentifier;
    this.encryptedContent = paramASN1OctetString;
  }
  
  private EncryptedContentInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() >= 2)
    {
      this.contentType = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
      this.contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.size() > 2) {
        this.encryptedContent = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(2), false);
      }
      return;
    }
    throw new IllegalArgumentException("Truncated Sequence Found");
  }
  
  public static EncryptedContentInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedContentInfo)) {
      return (EncryptedContentInfo)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedContentInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getContentEncryptionAlgorithm()
  {
    return this.contentEncryptionAlgorithm;
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentType;
  }
  
  public ASN1OctetString getEncryptedContent()
  {
    return this.encryptedContent;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.contentType);
    localASN1EncodableVector.add(this.contentEncryptionAlgorithm);
    ASN1OctetString localASN1OctetString = this.encryptedContent;
    if (localASN1OctetString != null) {
      localASN1EncodableVector.add(new BERTaggedObject(false, 0, localASN1OctetString));
    }
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\EncryptedContentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */