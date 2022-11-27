package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class POPOSigningKey
  extends ASN1Object
{
  private AlgorithmIdentifier algorithmIdentifier;
  private POPOSigningKeyInput poposkInput;
  private DERBitString signature;
  
  private POPOSigningKey(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject))
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(0);
      if (localASN1TaggedObject.getTagNo() == 0)
      {
        this.poposkInput = POPOSigningKeyInput.getInstance(localASN1TaggedObject.getObject());
        i = 1;
      }
      else
      {
        paramASN1Sequence = new StringBuilder();
        paramASN1Sequence.append("Unknown POPOSigningKeyInput tag: ");
        paramASN1Sequence.append(localASN1TaggedObject.getTagNo());
        throw new IllegalArgumentException(paramASN1Sequence.toString());
      }
    }
    this.algorithmIdentifier = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
    this.signature = DERBitString.getInstance(paramASN1Sequence.getObjectAt(i + 1));
  }
  
  public POPOSigningKey(POPOSigningKeyInput paramPOPOSigningKeyInput, AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString)
  {
    this.poposkInput = paramPOPOSigningKeyInput;
    this.algorithmIdentifier = paramAlgorithmIdentifier;
    this.signature = paramDERBitString;
  }
  
  public static POPOSigningKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof POPOSigningKey)) {
      return (POPOSigningKey)paramObject;
    }
    if (paramObject != null) {
      return new POPOSigningKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static POPOSigningKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return this.algorithmIdentifier;
  }
  
  public POPOSigningKeyInput getPoposkInput()
  {
    return this.poposkInput;
  }
  
  public DERBitString getSignature()
  {
    return this.signature;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    POPOSigningKeyInput localPOPOSigningKeyInput = this.poposkInput;
    if (localPOPOSigningKeyInput != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localPOPOSigningKeyInput));
    }
    localASN1EncodableVector.add(this.algorithmIdentifier);
    localASN1EncodableVector.add(this.signature);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\POPOSigningKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */