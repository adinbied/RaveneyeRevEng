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
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey
  extends ASN1Object
{
  private final GF2Matrix g;
  private final int n;
  private final int t;
  
  public McEliecePublicKey(int paramInt1, int paramInt2, GF2Matrix paramGF2Matrix)
  {
    this.n = paramInt1;
    this.t = paramInt2;
    this.g = new GF2Matrix(paramGF2Matrix);
  }
  
  private McEliecePublicKey(ASN1Sequence paramASN1Sequence)
  {
    this.n = ((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue().intValue();
    this.t = ((ASN1Integer)paramASN1Sequence.getObjectAt(1)).getValue().intValue();
    this.g = new GF2Matrix(((ASN1OctetString)paramASN1Sequence.getObjectAt(2)).getOctets());
  }
  
  public static McEliecePublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof McEliecePublicKey)) {
      return (McEliecePublicKey)paramObject;
    }
    if (paramObject != null) {
      return new McEliecePublicKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GF2Matrix getG()
  {
    return new GF2Matrix(this.g);
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
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\McEliecePublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */