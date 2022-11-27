package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SPHINCS256KeyParams
  extends ASN1Object
{
  private final AlgorithmIdentifier treeDigest;
  private final ASN1Integer version;
  
  private SPHINCS256KeyParams(ASN1Sequence paramASN1Sequence)
  {
    this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.treeDigest = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public SPHINCS256KeyParams(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.version = new ASN1Integer(0L);
    this.treeDigest = paramAlgorithmIdentifier;
  }
  
  public static final SPHINCS256KeyParams getInstance(Object paramObject)
  {
    if ((paramObject instanceof SPHINCS256KeyParams)) {
      return (SPHINCS256KeyParams)paramObject;
    }
    if (paramObject != null) {
      return new SPHINCS256KeyParams(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getTreeDigest()
  {
    return this.treeDigest;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.treeDigest);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\SPHINCS256KeyParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */