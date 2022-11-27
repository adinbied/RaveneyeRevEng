package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMsg;

public class TaggedRequest
  extends ASN1Object
  implements ASN1Choice
{
  public static final int CRM = 1;
  public static final int ORM = 2;
  public static final int TCR = 0;
  private final int tagNo;
  private final ASN1Encodable value;
  
  private TaggedRequest(ASN1Sequence paramASN1Sequence)
  {
    this.tagNo = 2;
    this.value = paramASN1Sequence;
  }
  
  public TaggedRequest(TaggedCertificationRequest paramTaggedCertificationRequest)
  {
    this.tagNo = 0;
    this.value = paramTaggedCertificationRequest;
  }
  
  public TaggedRequest(CertReqMsg paramCertReqMsg)
  {
    this.tagNo = 1;
    this.value = paramCertReqMsg;
  }
  
  public static TaggedRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof TaggedRequest)) {
      return (TaggedRequest)paramObject;
    }
    if (paramObject != null)
    {
      if ((paramObject instanceof ASN1Encodable))
      {
        paramObject = ASN1TaggedObject.getInstance(((ASN1Encodable)paramObject).toASN1Primitive());
        int i = ((ASN1TaggedObject)paramObject).getTagNo();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              return new TaggedRequest(ASN1Sequence.getInstance((ASN1TaggedObject)paramObject, false));
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknown tag in getInstance(): ");
            localStringBuilder.append(((ASN1TaggedObject)paramObject).getTagNo());
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return new TaggedRequest(CertReqMsg.getInstance((ASN1TaggedObject)paramObject, false));
        }
        return new TaggedRequest(TaggedCertificationRequest.getInstance((ASN1TaggedObject)paramObject, false));
      }
      if (!(paramObject instanceof byte[])) {}
    }
    try
    {
      paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (TaggedRequest)paramObject;
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("unknown encoding in getInstance()");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown object in getInstance(): ");
    localStringBuilder.append(paramObject.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
    return null;
  }
  
  public int getTagNo()
  {
    return this.tagNo;
  }
  
  public ASN1Encodable getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.tagNo, this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\TaggedRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */