package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class DecryptedPOP
  extends ASN1Object
{
  private final BodyPartID bodyPartID;
  private final byte[] thePOP;
  private final AlgorithmIdentifier thePOPAlgID;
  
  private DecryptedPOP(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.bodyPartID = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.thePOPAlgID = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.thePOP = Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(2)).getOctets());
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public DecryptedPOP(BodyPartID paramBodyPartID, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.bodyPartID = paramBodyPartID;
    this.thePOPAlgID = paramAlgorithmIdentifier;
    this.thePOP = Arrays.clone(paramArrayOfByte);
  }
  
  public static DecryptedPOP getInstance(Object paramObject)
  {
    if ((paramObject instanceof DecryptedPOP)) {
      return (DecryptedPOP)paramObject;
    }
    if (paramObject != null) {
      return new DecryptedPOP(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartID getBodyPartID()
  {
    return this.bodyPartID;
  }
  
  public byte[] getThePOP()
  {
    return Arrays.clone(this.thePOP);
  }
  
  public AlgorithmIdentifier getThePOPAlgID()
  {
    return this.thePOPAlgID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bodyPartID);
    localASN1EncodableVector.add(this.thePOPAlgID);
    localASN1EncodableVector.add(new DEROctetString(this.thePOP));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\DecryptedPOP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */