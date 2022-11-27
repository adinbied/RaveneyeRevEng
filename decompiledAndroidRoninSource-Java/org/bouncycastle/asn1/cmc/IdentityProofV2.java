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

public class IdentityProofV2
  extends ASN1Object
{
  private final AlgorithmIdentifier macAlgId;
  private final AlgorithmIdentifier proofAlgID;
  private final byte[] witness;
  
  private IdentityProofV2(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.proofAlgID = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.macAlgId = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.witness = Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(2)).getOctets());
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public IdentityProofV2(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
  {
    this.proofAlgID = paramAlgorithmIdentifier1;
    this.macAlgId = paramAlgorithmIdentifier2;
    this.witness = Arrays.clone(paramArrayOfByte);
  }
  
  public static IdentityProofV2 getInstance(Object paramObject)
  {
    if ((paramObject instanceof IdentityProofV2)) {
      return (IdentityProofV2)paramObject;
    }
    if (paramObject != null) {
      return new IdentityProofV2(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getMacAlgId()
  {
    return this.macAlgId;
  }
  
  public AlgorithmIdentifier getProofAlgID()
  {
    return this.proofAlgID;
  }
  
  public byte[] getWitness()
  {
    return Arrays.clone(this.witness);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.proofAlgID);
    localASN1EncodableVector.add(this.macAlgId);
    localASN1EncodableVector.add(new DEROctetString(getWitness()));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\IdentityProofV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */