package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class KeyAgreeRecipientIdentifier
  extends ASN1Object
  implements ASN1Choice
{
  private IssuerAndSerialNumber issuerSerial;
  private RecipientKeyIdentifier rKeyID;
  
  public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber paramIssuerAndSerialNumber)
  {
    this.issuerSerial = paramIssuerAndSerialNumber;
    this.rKeyID = null;
  }
  
  public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier paramRecipientKeyIdentifier)
  {
    this.issuerSerial = null;
    this.rKeyID = paramRecipientKeyIdentifier;
  }
  
  public static KeyAgreeRecipientIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof KeyAgreeRecipientIdentifier)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(paramObject));
      }
      if ((paramObject instanceof ASN1TaggedObject))
      {
        localObject = (ASN1TaggedObject)paramObject;
        if (((ASN1TaggedObject)localObject).getTagNo() == 0) {
          return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance((ASN1TaggedObject)localObject, false));
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid KeyAgreeRecipientIdentifier: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (KeyAgreeRecipientIdentifier)paramObject;
  }
  
  public static KeyAgreeRecipientIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public IssuerAndSerialNumber getIssuerAndSerialNumber()
  {
    return this.issuerSerial;
  }
  
  public RecipientKeyIdentifier getRKeyID()
  {
    return this.rKeyID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    IssuerAndSerialNumber localIssuerAndSerialNumber = this.issuerSerial;
    if (localIssuerAndSerialNumber != null) {
      return localIssuerAndSerialNumber.toASN1Primitive();
    }
    return new DERTaggedObject(false, 0, this.rKeyID);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\KeyAgreeRecipientIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */