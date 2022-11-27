package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertStatus
  extends ASN1Object
  implements ASN1Choice
{
  private int tagNo;
  private ASN1Encodable value;
  
  public CertStatus()
  {
    this.tagNo = 0;
    this.value = DERNull.INSTANCE;
  }
  
  public CertStatus(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    this.tagNo = paramInt;
    this.value = paramASN1Encodable;
  }
  
  private CertStatus(ASN1TaggedObject paramASN1TaggedObject)
  {
    this.tagNo = paramASN1TaggedObject.getTagNo();
    int i = paramASN1TaggedObject.getTagNo();
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown tag encountered: ");
          localStringBuilder.append(paramASN1TaggedObject.getTagNo());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      else
      {
        paramASN1TaggedObject = RevokedInfo.getInstance(paramASN1TaggedObject, false);
        break label83;
      }
    }
    paramASN1TaggedObject = DERNull.INSTANCE;
    label83:
    this.value = paramASN1TaggedObject;
  }
  
  public CertStatus(RevokedInfo paramRevokedInfo)
  {
    this.tagNo = 1;
    this.value = paramRevokedInfo;
  }
  
  public static CertStatus getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof CertStatus)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new CertStatus((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (CertStatus)paramObject;
  }
  
  public static CertStatus getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public ASN1Encodable getStatus()
  {
    return this.value;
  }
  
  public int getTagNo()
  {
    return this.tagNo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.tagNo, this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\CertStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */