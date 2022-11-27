package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SMIMECapability
  extends ASN1Object
{
  public static final ASN1ObjectIdentifier aES128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
  public static final ASN1ObjectIdentifier aES192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
  public static final ASN1ObjectIdentifier aES256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
  public static final ASN1ObjectIdentifier canNotDecryptAny;
  public static final ASN1ObjectIdentifier dES_CBC;
  public static final ASN1ObjectIdentifier dES_EDE3_CBC;
  public static final ASN1ObjectIdentifier preferSignedData = PKCSObjectIdentifiers.preferSignedData;
  public static final ASN1ObjectIdentifier rC2_CBC;
  public static final ASN1ObjectIdentifier sMIMECapabilitiesVersions;
  private ASN1ObjectIdentifier capabilityID;
  private ASN1Encodable parameters;
  
  static
  {
    canNotDecryptAny = PKCSObjectIdentifiers.canNotDecryptAny;
    sMIMECapabilitiesVersions = PKCSObjectIdentifiers.sMIMECapabilitiesVersions;
    dES_CBC = new ASN1ObjectIdentifier("1.3.14.3.2.7");
    dES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
    rC2_CBC = PKCSObjectIdentifiers.RC2_CBC;
  }
  
  public SMIMECapability(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.capabilityID = paramASN1ObjectIdentifier;
    this.parameters = paramASN1Encodable;
  }
  
  public SMIMECapability(ASN1Sequence paramASN1Sequence)
  {
    this.capabilityID = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.parameters = ((ASN1Primitive)paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public static SMIMECapability getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof SMIMECapability)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new SMIMECapability((ASN1Sequence)paramObject);
      }
      throw new IllegalArgumentException("Invalid SMIMECapability");
    }
    return (SMIMECapability)paramObject;
  }
  
  public ASN1ObjectIdentifier getCapabilityID()
  {
    return this.capabilityID;
  }
  
  public ASN1Encodable getParameters()
  {
    return this.parameters;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.capabilityID);
    ASN1Encodable localASN1Encodable = this.parameters;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\smime\SMIMECapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */