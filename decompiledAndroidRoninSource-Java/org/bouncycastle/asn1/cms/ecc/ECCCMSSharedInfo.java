package org.bouncycastle.asn1.cms.ecc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class ECCCMSSharedInfo
  extends ASN1Object
{
  private final byte[] entityUInfo;
  private final AlgorithmIdentifier keyInfo;
  private final byte[] suppPubInfo;
  
  private ECCCMSSharedInfo(ASN1Sequence paramASN1Sequence)
  {
    this.keyInfo = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2)
    {
      this.entityUInfo = null;
      this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true).getOctets();
      return;
    }
    this.entityUInfo = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true).getOctets();
    this.suppPubInfo = ASN1OctetString.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(2), true).getOctets();
  }
  
  public ECCCMSSharedInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.keyInfo = paramAlgorithmIdentifier;
    this.entityUInfo = null;
    this.suppPubInfo = Arrays.clone(paramArrayOfByte);
  }
  
  public ECCCMSSharedInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.keyInfo = paramAlgorithmIdentifier;
    this.entityUInfo = Arrays.clone(paramArrayOfByte1);
    this.suppPubInfo = Arrays.clone(paramArrayOfByte2);
  }
  
  public static ECCCMSSharedInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof ECCCMSSharedInfo)) {
      return (ECCCMSSharedInfo)paramObject;
    }
    if (paramObject != null) {
      return new ECCCMSSharedInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ECCCMSSharedInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyInfo);
    byte[] arrayOfByte = this.entityUInfo;
    if (arrayOfByte != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(arrayOfByte)));
    }
    localASN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(this.suppPubInfo)));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\ecc\ECCCMSSharedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */