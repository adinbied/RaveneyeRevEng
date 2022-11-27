package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class EncryptedPOP
  extends ASN1Object
{
  private final ContentInfo cms;
  private final TaggedRequest request;
  private final AlgorithmIdentifier thePOPAlgID;
  private final byte[] witness;
  private final AlgorithmIdentifier witnessAlgID;
  
  private EncryptedPOP(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 5)
    {
      this.request = TaggedRequest.getInstance(paramASN1Sequence.getObjectAt(0));
      this.cms = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(1));
      this.thePOPAlgID = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(2));
      this.witnessAlgID = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(3));
      this.witness = Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(4)).getOctets());
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public EncryptedPOP(TaggedRequest paramTaggedRequest, ContentInfo paramContentInfo, AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
  {
    this.request = paramTaggedRequest;
    this.cms = paramContentInfo;
    this.thePOPAlgID = paramAlgorithmIdentifier1;
    this.witnessAlgID = paramAlgorithmIdentifier2;
    this.witness = Arrays.clone(paramArrayOfByte);
  }
  
  public static EncryptedPOP getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedPOP)) {
      return (EncryptedPOP)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedPOP(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ContentInfo getCms()
  {
    return this.cms;
  }
  
  public TaggedRequest getRequest()
  {
    return this.request;
  }
  
  public AlgorithmIdentifier getThePOPAlgID()
  {
    return this.thePOPAlgID;
  }
  
  public byte[] getWitness()
  {
    return Arrays.clone(this.witness);
  }
  
  public AlgorithmIdentifier getWitnessAlgID()
  {
    return this.witnessAlgID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.request);
    localASN1EncodableVector.add(this.cms);
    localASN1EncodableVector.add(this.thePOPAlgID);
    localASN1EncodableVector.add(this.witnessAlgID);
    localASN1EncodableVector.add(new DEROctetString(this.witness));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\EncryptedPOP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */