package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class PKIArchiveOptions
  extends ASN1Object
  implements ASN1Choice
{
  public static final int archiveRemGenPrivKey = 2;
  public static final int encryptedPrivKey = 0;
  public static final int keyGenParameters = 1;
  private ASN1Encodable value;
  
  public PKIArchiveOptions(ASN1OctetString paramASN1OctetString)
  {
    this.value = paramASN1OctetString;
  }
  
  private PKIArchiveOptions(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramASN1TaggedObject = ASN1Boolean.getInstance(paramASN1TaggedObject, false);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown tag number: ");
          localStringBuilder.append(paramASN1TaggedObject.getTagNo());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      else {
        paramASN1TaggedObject = ASN1OctetString.getInstance(paramASN1TaggedObject, false);
      }
    }
    else {
      paramASN1TaggedObject = EncryptedKey.getInstance(paramASN1TaggedObject.getObject());
    }
    this.value = paramASN1TaggedObject;
  }
  
  public PKIArchiveOptions(EncryptedKey paramEncryptedKey)
  {
    this.value = paramEncryptedKey;
  }
  
  public PKIArchiveOptions(boolean paramBoolean)
  {
    this.value = ASN1Boolean.getInstance(paramBoolean);
  }
  
  public static PKIArchiveOptions getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof PKIArchiveOptions)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new PKIArchiveOptions((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object: ");
      localStringBuilder.append(paramObject);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (PKIArchiveOptions)paramObject;
  }
  
  public int getType()
  {
    ASN1Encodable localASN1Encodable = this.value;
    if ((localASN1Encodable instanceof EncryptedKey)) {
      return 0;
    }
    if ((localASN1Encodable instanceof ASN1OctetString)) {
      return 1;
    }
    return 2;
  }
  
  public ASN1Encodable getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1Encodable localASN1Encodable = this.value;
    if ((localASN1Encodable instanceof EncryptedKey)) {
      return new DERTaggedObject(true, 0, localASN1Encodable);
    }
    if ((localASN1Encodable instanceof ASN1OctetString)) {
      return new DERTaggedObject(false, 1, localASN1Encodable);
    }
    return new DERTaggedObject(false, 2, localASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\PKIArchiveOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */