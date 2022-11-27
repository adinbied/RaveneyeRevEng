package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.GeneralName;

public class EncKeyWithID
  extends ASN1Object
{
  private final ASN1Encodable identifier;
  private final PrivateKeyInfo privKeyInfo;
  
  private EncKeyWithID(ASN1Sequence paramASN1Sequence)
  {
    this.privKeyInfo = PrivateKeyInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1)
    {
      boolean bool = paramASN1Sequence.getObjectAt(1) instanceof DERUTF8String;
      ASN1Encodable localASN1Encodable = paramASN1Sequence.getObjectAt(1);
      paramASN1Sequence = localASN1Encodable;
      if (!bool) {
        paramASN1Sequence = GeneralName.getInstance(localASN1Encodable);
      }
    }
    else
    {
      paramASN1Sequence = null;
    }
    this.identifier = paramASN1Sequence;
  }
  
  public EncKeyWithID(PrivateKeyInfo paramPrivateKeyInfo)
  {
    this.privKeyInfo = paramPrivateKeyInfo;
    this.identifier = null;
  }
  
  public EncKeyWithID(PrivateKeyInfo paramPrivateKeyInfo, DERUTF8String paramDERUTF8String)
  {
    this.privKeyInfo = paramPrivateKeyInfo;
    this.identifier = paramDERUTF8String;
  }
  
  public EncKeyWithID(PrivateKeyInfo paramPrivateKeyInfo, GeneralName paramGeneralName)
  {
    this.privKeyInfo = paramPrivateKeyInfo;
    this.identifier = paramGeneralName;
  }
  
  public static EncKeyWithID getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncKeyWithID)) {
      return (EncKeyWithID)paramObject;
    }
    if (paramObject != null) {
      return new EncKeyWithID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Encodable getIdentifier()
  {
    return this.identifier;
  }
  
  public PrivateKeyInfo getPrivateKey()
  {
    return this.privKeyInfo;
  }
  
  public boolean hasIdentifier()
  {
    return this.identifier != null;
  }
  
  public boolean isIdentifierUTF8String()
  {
    return this.identifier instanceof DERUTF8String;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.privKeyInfo);
    ASN1Encodable localASN1Encodable = this.identifier;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\EncKeyWithID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */