package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSAlgorithmProtection
  extends ASN1Object
{
  public static final int MAC = 2;
  public static final int SIGNATURE = 1;
  private final AlgorithmIdentifier digestAlgorithm;
  private final AlgorithmIdentifier macAlgorithm;
  private final AlgorithmIdentifier signatureAlgorithm;
  
  private CMSAlgorithmProtection(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.digestAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      paramASN1Sequence = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.getTagNo() == 1)
      {
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence, false);
        this.macAlgorithm = null;
        return;
      }
      if (paramASN1Sequence.getTagNo() == 2)
      {
        this.signatureAlgorithm = null;
        this.macAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence, false);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown tag found: ");
      localStringBuilder.append(paramASN1Sequence.getTagNo());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("Sequence wrong size: One of signatureAlgorithm or macAlgorithm must be present");
  }
  
  public CMSAlgorithmProtection(AlgorithmIdentifier paramAlgorithmIdentifier1, int paramInt, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    if ((paramAlgorithmIdentifier1 != null) && (paramAlgorithmIdentifier2 != null))
    {
      this.digestAlgorithm = paramAlgorithmIdentifier1;
      if (paramInt == 1)
      {
        this.signatureAlgorithm = paramAlgorithmIdentifier2;
        this.macAlgorithm = null;
        return;
      }
      if (paramInt == 2)
      {
        this.signatureAlgorithm = null;
        this.macAlgorithm = paramAlgorithmIdentifier2;
        return;
      }
      paramAlgorithmIdentifier1 = new StringBuilder();
      paramAlgorithmIdentifier1.append("Unknown type: ");
      paramAlgorithmIdentifier1.append(paramInt);
      throw new IllegalArgumentException(paramAlgorithmIdentifier1.toString());
    }
    throw new NullPointerException("AlgorithmIdentifiers cannot be null");
  }
  
  public static CMSAlgorithmProtection getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMSAlgorithmProtection)) {
      return (CMSAlgorithmProtection)paramObject;
    }
    if (paramObject != null) {
      return new CMSAlgorithmProtection(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digestAlgorithm;
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
  {
    return this.macAlgorithm;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.signatureAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.digestAlgorithm);
    AlgorithmIdentifier localAlgorithmIdentifier = this.signatureAlgorithm;
    if (localAlgorithmIdentifier != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localAlgorithmIdentifier));
    }
    localAlgorithmIdentifier = this.macAlgorithm;
    if (localAlgorithmIdentifier != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, localAlgorithmIdentifier));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\CMSAlgorithmProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */