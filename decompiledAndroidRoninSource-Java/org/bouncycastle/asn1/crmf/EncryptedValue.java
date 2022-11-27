package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedValue
  extends ASN1Object
{
  private DERBitString encSymmKey;
  private DERBitString encValue;
  private AlgorithmIdentifier intendedAlg;
  private AlgorithmIdentifier keyAlg;
  private AlgorithmIdentifier symmAlg;
  private ASN1OctetString valueHint;
  
  private EncryptedValue(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    while ((paramASN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject))
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(i);
      int j = localASN1TaggedObject.getTagNo();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j == 4)
              {
                this.valueHint = ASN1OctetString.getInstance(localASN1TaggedObject, false);
              }
              else
              {
                paramASN1Sequence = new StringBuilder();
                paramASN1Sequence.append("Unknown tag encountered: ");
                paramASN1Sequence.append(localASN1TaggedObject.getTagNo());
                throw new IllegalArgumentException(paramASN1Sequence.toString());
              }
            }
            else {
              this.keyAlg = AlgorithmIdentifier.getInstance(localASN1TaggedObject, false);
            }
          }
          else {
            this.encSymmKey = DERBitString.getInstance(localASN1TaggedObject, false);
          }
        }
        else {
          this.symmAlg = AlgorithmIdentifier.getInstance(localASN1TaggedObject, false);
        }
      }
      else {
        this.intendedAlg = AlgorithmIdentifier.getInstance(localASN1TaggedObject, false);
      }
      i += 1;
    }
    this.encValue = DERBitString.getInstance(paramASN1Sequence.getObjectAt(i));
  }
  
  public EncryptedValue(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, DERBitString paramDERBitString1, AlgorithmIdentifier paramAlgorithmIdentifier3, ASN1OctetString paramASN1OctetString, DERBitString paramDERBitString2)
  {
    if (paramDERBitString2 != null)
    {
      this.intendedAlg = paramAlgorithmIdentifier1;
      this.symmAlg = paramAlgorithmIdentifier2;
      this.encSymmKey = paramDERBitString1;
      this.keyAlg = paramAlgorithmIdentifier3;
      this.valueHint = paramASN1OctetString;
      this.encValue = paramDERBitString2;
      return;
    }
    throw new IllegalArgumentException("'encValue' cannot be null");
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(false, paramInt, paramASN1Encodable));
    }
  }
  
  public static EncryptedValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedValue)) {
      return (EncryptedValue)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DERBitString getEncSymmKey()
  {
    return this.encSymmKey;
  }
  
  public DERBitString getEncValue()
  {
    return this.encValue;
  }
  
  public AlgorithmIdentifier getIntendedAlg()
  {
    return this.intendedAlg;
  }
  
  public AlgorithmIdentifier getKeyAlg()
  {
    return this.keyAlg;
  }
  
  public AlgorithmIdentifier getSymmAlg()
  {
    return this.symmAlg;
  }
  
  public ASN1OctetString getValueHint()
  {
    return this.valueHint;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    addOptional(localASN1EncodableVector, 0, this.intendedAlg);
    addOptional(localASN1EncodableVector, 1, this.symmAlg);
    addOptional(localASN1EncodableVector, 2, this.encSymmKey);
    addOptional(localASN1EncodableVector, 3, this.keyAlg);
    addOptional(localASN1EncodableVector, 4, this.valueHint);
    localASN1EncodableVector.add(this.encValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\EncryptedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */