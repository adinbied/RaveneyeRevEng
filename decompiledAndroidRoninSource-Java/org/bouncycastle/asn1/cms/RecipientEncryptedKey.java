package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class RecipientEncryptedKey
  extends ASN1Object
{
  private ASN1OctetString encryptedKey;
  private KeyAgreeRecipientIdentifier identifier;
  
  private RecipientEncryptedKey(ASN1Sequence paramASN1Sequence)
  {
    this.identifier = KeyAgreeRecipientIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.encryptedKey = ((ASN1OctetString)paramASN1Sequence.getObjectAt(1));
  }
  
  public RecipientEncryptedKey(KeyAgreeRecipientIdentifier paramKeyAgreeRecipientIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.identifier = paramKeyAgreeRecipientIdentifier;
    this.encryptedKey = paramASN1OctetString;
  }
  
  public static RecipientEncryptedKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof RecipientEncryptedKey)) {
      return (RecipientEncryptedKey)paramObject;
    }
    if (paramObject != null) {
      return new RecipientEncryptedKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static RecipientEncryptedKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1OctetString getEncryptedKey()
  {
    return this.encryptedKey;
  }
  
  public KeyAgreeRecipientIdentifier getIdentifier()
  {
    return this.identifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.identifier);
    localASN1EncodableVector.add(this.encryptedKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\RecipientEncryptedKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */