package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class MetaData
  extends ASN1Object
{
  private DERUTF8String fileName;
  private ASN1Boolean hashProtected;
  private DERIA5String mediaType;
  private Attributes otherMetaData;
  
  public MetaData(ASN1Boolean paramASN1Boolean, DERUTF8String paramDERUTF8String, DERIA5String paramDERIA5String, Attributes paramAttributes)
  {
    this.hashProtected = paramASN1Boolean;
    this.fileName = paramDERUTF8String;
    this.mediaType = paramDERIA5String;
    this.otherMetaData = paramAttributes;
  }
  
  private MetaData(ASN1Sequence paramASN1Sequence)
  {
    this.hashProtected = ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(0));
    int k = paramASN1Sequence.size();
    int j = 1;
    int i = j;
    if (1 < k)
    {
      i = j;
      if ((paramASN1Sequence.getObjectAt(1) instanceof DERUTF8String))
      {
        this.fileName = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(1));
        i = 2;
      }
    }
    j = i;
    if (i < paramASN1Sequence.size())
    {
      j = i;
      if ((paramASN1Sequence.getObjectAt(i) instanceof DERIA5String))
      {
        this.mediaType = DERIA5String.getInstance(paramASN1Sequence.getObjectAt(i));
        j = i + 1;
      }
    }
    if (j < paramASN1Sequence.size()) {
      this.otherMetaData = Attributes.getInstance(paramASN1Sequence.getObjectAt(j));
    }
  }
  
  public static MetaData getInstance(Object paramObject)
  {
    if ((paramObject instanceof MetaData)) {
      return (MetaData)paramObject;
    }
    if (paramObject != null) {
      return new MetaData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DERUTF8String getFileName()
  {
    return this.fileName;
  }
  
  public DERIA5String getMediaType()
  {
    return this.mediaType;
  }
  
  public Attributes getOtherMetaData()
  {
    return this.otherMetaData;
  }
  
  public boolean isHashProtected()
  {
    return this.hashProtected.isTrue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashProtected);
    Object localObject = this.fileName;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.mediaType;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.otherMetaData;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\MetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */