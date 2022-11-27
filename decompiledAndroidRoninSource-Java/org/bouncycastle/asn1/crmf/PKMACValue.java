package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PKMACValue
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  private DERBitString value;
  
  private PKMACValue(ASN1Sequence paramASN1Sequence)
  {
    this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.value = DERBitString.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public PKMACValue(PBMParameter paramPBMParameter, DERBitString paramDERBitString)
  {
    this(new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, paramPBMParameter), paramDERBitString);
  }
  
  public PKMACValue(AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString)
  {
    this.algId = paramAlgorithmIdentifier;
    this.value = paramDERBitString;
  }
  
  public static PKMACValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKMACValue)) {
      return (PKMACValue)paramObject;
    }
    if (paramObject != null) {
      return new PKMACValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PKMACValue getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgId()
  {
    return this.algId;
  }
  
  public DERBitString getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algId);
    localASN1EncodableVector.add(this.value);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\PKMACValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */