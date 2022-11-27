package org.bouncycastle.asn1.dvcs;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class DVCSResponse
  extends ASN1Object
  implements ASN1Choice
{
  private DVCSCertInfo dvCertInfo;
  private DVCSErrorNotice dvErrorNote;
  
  public DVCSResponse(DVCSCertInfo paramDVCSCertInfo)
  {
    this.dvCertInfo = paramDVCSCertInfo;
  }
  
  public DVCSResponse(DVCSErrorNotice paramDVCSErrorNotice)
  {
    this.dvErrorNote = paramDVCSErrorNotice;
  }
  
  public static DVCSResponse getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DVCSResponse)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
          return (DVCSResponse)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to construct sequence from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      if ((paramObject instanceof ASN1Sequence)) {
        return new DVCSResponse(DVCSCertInfo.getInstance(paramObject));
      }
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new DVCSResponse(DVCSErrorNotice.getInstance(ASN1TaggedObject.getInstance(paramObject), false));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Couldn't convert from object to DVCSResponse: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DVCSResponse)paramObject;
  }
  
  public static DVCSResponse getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public DVCSCertInfo getCertInfo()
  {
    return this.dvCertInfo;
  }
  
  public DVCSErrorNotice getErrorNotice()
  {
    return this.dvErrorNote;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    DVCSCertInfo localDVCSCertInfo = this.dvCertInfo;
    if (localDVCSCertInfo != null) {
      return localDVCSCertInfo.toASN1Primitive();
    }
    return new DERTaggedObject(false, 0, this.dvErrorNote);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.dvCertInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DVCSResponse {\ndvCertInfo: ");
    }
    for (String str = this.dvCertInfo.toString();; str = this.dvErrorNote.toString())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("}\n");
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DVCSResponse {\ndvErrorNote: ");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */