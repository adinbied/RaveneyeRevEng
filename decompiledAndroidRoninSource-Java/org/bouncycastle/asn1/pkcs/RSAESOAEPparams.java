package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class RSAESOAEPparams
  extends ASN1Object
{
  public static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
  public static final AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, DEFAULT_HASH_ALGORITHM);
  public static final AlgorithmIdentifier DEFAULT_P_SOURCE_ALGORITHM = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(new byte[0]));
  private AlgorithmIdentifier hashAlgorithm;
  private AlgorithmIdentifier maskGenAlgorithm;
  private AlgorithmIdentifier pSourceAlgorithm;
  
  public RSAESOAEPparams()
  {
    this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
    this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
    this.pSourceAlgorithm = DEFAULT_P_SOURCE_ALGORITHM;
  }
  
  public RSAESOAEPparams(ASN1Sequence paramASN1Sequence)
  {
    this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
    this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
    this.pSourceAlgorithm = DEFAULT_P_SOURCE_ALGORITHM;
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(i);
      int j = localASN1TaggedObject.getTagNo();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            this.pSourceAlgorithm = AlgorithmIdentifier.getInstance(localASN1TaggedObject, true);
          } else {
            throw new IllegalArgumentException("unknown tag");
          }
        }
        else {
          this.maskGenAlgorithm = AlgorithmIdentifier.getInstance(localASN1TaggedObject, true);
        }
      }
      else {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(localASN1TaggedObject, true);
      }
      i += 1;
    }
  }
  
  public RSAESOAEPparams(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, AlgorithmIdentifier paramAlgorithmIdentifier3)
  {
    this.hashAlgorithm = paramAlgorithmIdentifier1;
    this.maskGenAlgorithm = paramAlgorithmIdentifier2;
    this.pSourceAlgorithm = paramAlgorithmIdentifier3;
  }
  
  public static RSAESOAEPparams getInstance(Object paramObject)
  {
    if ((paramObject instanceof RSAESOAEPparams)) {
      return (RSAESOAEPparams)paramObject;
    }
    if (paramObject != null) {
      return new RSAESOAEPparams(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public AlgorithmIdentifier getMaskGenAlgorithm()
  {
    return this.maskGenAlgorithm;
  }
  
  public AlgorithmIdentifier getPSourceAlgorithm()
  {
    return this.pSourceAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (!this.hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM)) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.hashAlgorithm));
    }
    if (!this.maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION)) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, this.maskGenAlgorithm));
    }
    if (!this.pSourceAlgorithm.equals(DEFAULT_P_SOURCE_ALGORITHM)) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, this.pSourceAlgorithm));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\RSAESOAEPparams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */