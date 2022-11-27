package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class EncryptedKey
  extends ASN1Object
  implements ASN1Choice
{
  private EncryptedValue encryptedValue;
  private EnvelopedData envelopedData;
  
  public EncryptedKey(EnvelopedData paramEnvelopedData)
  {
    this.envelopedData = paramEnvelopedData;
  }
  
  public EncryptedKey(EncryptedValue paramEncryptedValue)
  {
    this.encryptedValue = paramEncryptedValue;
  }
  
  public static EncryptedKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedKey)) {
      return (EncryptedKey)paramObject;
    }
    if ((paramObject instanceof ASN1TaggedObject)) {
      return new EncryptedKey(EnvelopedData.getInstance((ASN1TaggedObject)paramObject, false));
    }
    if ((paramObject instanceof EncryptedValue)) {
      return new EncryptedKey((EncryptedValue)paramObject);
    }
    return new EncryptedKey(EncryptedValue.getInstance(paramObject));
  }
  
  public ASN1Encodable getValue()
  {
    EncryptedValue localEncryptedValue = this.encryptedValue;
    if (localEncryptedValue != null) {
      return localEncryptedValue;
    }
    return this.envelopedData;
  }
  
  public boolean isEncryptedValue()
  {
    return this.encryptedValue != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    EncryptedValue localEncryptedValue = this.encryptedValue;
    if (localEncryptedValue != null) {
      return localEncryptedValue.toASN1Primitive();
    }
    return new DERTaggedObject(false, 0, this.envelopedData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\EncryptedKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */