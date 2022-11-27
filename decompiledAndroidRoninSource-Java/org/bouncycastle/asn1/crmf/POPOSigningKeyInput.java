package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class POPOSigningKeyInput
  extends ASN1Object
{
  private SubjectPublicKeyInfo publicKey;
  private PKMACValue publicKeyMAC;
  private GeneralName sender;
  
  private POPOSigningKeyInput(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjectAt(0);
    if ((localObject instanceof ASN1TaggedObject))
    {
      localObject = (ASN1TaggedObject)localObject;
      if (((ASN1TaggedObject)localObject).getTagNo() == 0)
      {
        this.sender = GeneralName.getInstance(((ASN1TaggedObject)localObject).getObject());
      }
      else
      {
        paramASN1Sequence = new StringBuilder();
        paramASN1Sequence.append("Unknown authInfo tag: ");
        paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
        throw new IllegalArgumentException(paramASN1Sequence.toString());
      }
    }
    else
    {
      this.publicKeyMAC = PKMACValue.getInstance(localObject);
    }
    this.publicKey = SubjectPublicKeyInfo.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public POPOSigningKeyInput(PKMACValue paramPKMACValue, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.publicKeyMAC = paramPKMACValue;
    this.publicKey = paramSubjectPublicKeyInfo;
  }
  
  public POPOSigningKeyInput(GeneralName paramGeneralName, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.sender = paramGeneralName;
    this.publicKey = paramSubjectPublicKeyInfo;
  }
  
  public static POPOSigningKeyInput getInstance(Object paramObject)
  {
    if ((paramObject instanceof POPOSigningKeyInput)) {
      return (POPOSigningKeyInput)paramObject;
    }
    if (paramObject != null) {
      return new POPOSigningKeyInput(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public SubjectPublicKeyInfo getPublicKey()
  {
    return this.publicKey;
  }
  
  public PKMACValue getPublicKeyMAC()
  {
    return this.publicKeyMAC;
  }
  
  public GeneralName getSender()
  {
    return this.sender;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    GeneralName localGeneralName = this.sender;
    if (localGeneralName != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localGeneralName));
    } else {
      localASN1EncodableVector.add(this.publicKeyMAC);
    }
    localASN1EncodableVector.add(this.publicKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\POPOSigningKeyInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */