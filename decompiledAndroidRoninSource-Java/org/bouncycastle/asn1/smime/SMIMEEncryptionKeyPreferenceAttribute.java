package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.RecipientKeyIdentifier;

public class SMIMEEncryptionKeyPreferenceAttribute
  extends Attribute
{
  public SMIMEEncryptionKeyPreferenceAttribute(ASN1OctetString paramASN1OctetString)
  {
    super(SMIMEAttributes.encrypKeyPref, new DERSet(new DERTaggedObject(false, 2, paramASN1OctetString)));
  }
  
  public SMIMEEncryptionKeyPreferenceAttribute(IssuerAndSerialNumber paramIssuerAndSerialNumber)
  {
    super(SMIMEAttributes.encrypKeyPref, new DERSet(new DERTaggedObject(false, 0, paramIssuerAndSerialNumber)));
  }
  
  public SMIMEEncryptionKeyPreferenceAttribute(RecipientKeyIdentifier paramRecipientKeyIdentifier)
  {
    super(SMIMEAttributes.encrypKeyPref, new DERSet(new DERTaggedObject(false, 1, paramRecipientKeyIdentifier)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\smime\SMIMEEncryptionKeyPreferenceAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */