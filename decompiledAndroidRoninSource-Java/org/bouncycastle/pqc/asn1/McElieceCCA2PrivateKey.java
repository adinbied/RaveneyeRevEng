package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2PrivateKey
  extends ASN1Object
{
  private AlgorithmIdentifier digest;
  private byte[] encField;
  private byte[] encGp;
  private byte[] encP;
  private int k;
  private int n;
  
  public McElieceCCA2PrivateKey(int paramInt1, int paramInt2, GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM, Permutation paramPermutation, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.n = paramInt1;
    this.k = paramInt2;
    this.encField = paramGF2mField.getEncoded();
    this.encGp = paramPolynomialGF2mSmallM.getEncoded();
    this.encP = paramPermutation.getEncoded();
    this.digest = paramAlgorithmIdentifier;
  }
  
  private McElieceCCA2PrivateKey(ASN1Sequence paramASN1Sequence)
  {
    this.n = ((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue().intValue();
    this.k = ((ASN1Integer)paramASN1Sequence.getObjectAt(1)).getValue().intValue();
    this.encField = ((ASN1OctetString)paramASN1Sequence.getObjectAt(2)).getOctets();
    this.encGp = ((ASN1OctetString)paramASN1Sequence.getObjectAt(3)).getOctets();
    this.encP = ((ASN1OctetString)paramASN1Sequence.getObjectAt(4)).getOctets();
    this.digest = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(5));
  }
  
  public static McElieceCCA2PrivateKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof McElieceCCA2PrivateKey)) {
      return (McElieceCCA2PrivateKey)paramObject;
    }
    if (paramObject != null) {
      return new McElieceCCA2PrivateKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getDigest()
  {
    return this.digest;
  }
  
  public GF2mField getField()
  {
    return new GF2mField(this.encField);
  }
  
  public PolynomialGF2mSmallM getGoppaPoly()
  {
    return new PolynomialGF2mSmallM(getField(), this.encGp);
  }
  
  public int getK()
  {
    return this.k;
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public Permutation getP()
  {
    return new Permutation(this.encP);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.n));
    localASN1EncodableVector.add(new ASN1Integer(this.k));
    localASN1EncodableVector.add(new DEROctetString(this.encField));
    localASN1EncodableVector.add(new DEROctetString(this.encGp));
    localASN1EncodableVector.add(new DEROctetString(this.encP));
    localASN1EncodableVector.add(this.digest);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\McElieceCCA2PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */