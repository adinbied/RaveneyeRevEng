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
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey
  extends ASN1Object
{
  private final AlgorithmIdentifier digest;
  private final GF2Matrix g;
  private final int n;
  private final int t;
  
  public McElieceCCA2PublicKey(int paramInt1, int paramInt2, GF2Matrix paramGF2Matrix, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.n = paramInt1;
    this.t = paramInt2;
    this.g = new GF2Matrix(paramGF2Matrix.getEncoded());
    this.digest = paramAlgorithmIdentifier;
  }
  
  private McElieceCCA2PublicKey(ASN1Sequence paramASN1Sequence)
  {
    this.n = ((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue().intValue();
    this.t = ((ASN1Integer)paramASN1Sequence.getObjectAt(1)).getValue().intValue();
    this.g = new GF2Matrix(((ASN1OctetString)paramASN1Sequence.getObjectAt(2)).getOctets());
    this.digest = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(3));
  }
  
  public static McElieceCCA2PublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof McElieceCCA2PublicKey)) {
      return (McElieceCCA2PublicKey)paramObject;
    }
    if (paramObject != null) {
      return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getDigest()
  {
    return this.digest;
  }
  
  public GF2Matrix getG()
  {
    return this.g;
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public int getT()
  {
    return this.t;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.n));
    localASN1EncodableVector.add(new ASN1Integer(this.t));
    localASN1EncodableVector.add(new DEROctetString(this.g.getEncoded()));
    localASN1EncodableVector.add(this.digest);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\McElieceCCA2PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */