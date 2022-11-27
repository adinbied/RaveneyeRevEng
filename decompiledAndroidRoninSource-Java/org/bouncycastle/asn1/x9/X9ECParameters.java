package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;

public class X9ECParameters
  extends ASN1Object
  implements X9ObjectIdentifiers
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private ECCurve curve;
  private X9FieldID fieldID;
  private X9ECPoint g;
  private BigInteger h;
  private BigInteger n;
  private byte[] seed;
  
  private X9ECParameters(ASN1Sequence paramASN1Sequence)
  {
    if (((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer)) && (((ASN1Integer)paramASN1Sequence.getObjectAt(0)).getValue().equals(ONE)))
    {
      X9Curve localX9Curve = new X9Curve(X9FieldID.getInstance(paramASN1Sequence.getObjectAt(1)), ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(2)));
      this.curve = localX9Curve.getCurve();
      ASN1Encodable localASN1Encodable = paramASN1Sequence.getObjectAt(3);
      if ((localASN1Encodable instanceof X9ECPoint)) {
        this.g = ((X9ECPoint)localASN1Encodable);
      } else {
        this.g = new X9ECPoint(this.curve, (ASN1OctetString)localASN1Encodable);
      }
      this.n = ((ASN1Integer)paramASN1Sequence.getObjectAt(4)).getValue();
      this.seed = localX9Curve.getSeed();
      if (paramASN1Sequence.size() == 6) {
        this.h = ((ASN1Integer)paramASN1Sequence.getObjectAt(5)).getValue();
      }
      return;
    }
    throw new IllegalArgumentException("bad version in X9ECParameters");
  }
  
  public X9ECParameters(ECCurve paramECCurve, X9ECPoint paramX9ECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramECCurve, paramX9ECPoint, paramBigInteger1, paramBigInteger2, null);
  }
  
  public X9ECParameters(ECCurve paramECCurve, X9ECPoint paramX9ECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.curve = paramECCurve;
    this.g = paramX9ECPoint;
    this.n = paramBigInteger1;
    this.h = paramBigInteger2;
    this.seed = paramArrayOfByte;
    if (ECAlgorithms.isFpCurve(paramECCurve)) {
      paramECCurve = new X9FieldID(paramECCurve.getField().getCharacteristic());
    }
    for (;;)
    {
      this.fieldID = paramECCurve;
      return;
      if (!ECAlgorithms.isF2mCurve(paramECCurve)) {
        break label148;
      }
      paramECCurve = ((PolynomialExtensionField)paramECCurve.getField()).getMinimalPolynomial().getExponentsPresent();
      if (paramECCurve.length == 3)
      {
        paramECCurve = new X9FieldID(paramECCurve[2], paramECCurve[1]);
      }
      else
      {
        if (paramECCurve.length != 5) {
          break;
        }
        paramECCurve = new X9FieldID(paramECCurve[4], paramECCurve[1], paramECCurve[2], paramECCurve[3]);
      }
    }
    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
    label148:
    throw new IllegalArgumentException("'curve' is of an unsupported type");
  }
  
  public X9ECParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    this(paramECCurve, paramECPoint, paramBigInteger, null, null);
  }
  
  public X9ECParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramECCurve, paramECPoint, paramBigInteger1, paramBigInteger2, null);
  }
  
  public X9ECParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this(paramECCurve, new X9ECPoint(paramECPoint), paramBigInteger1, paramBigInteger2, paramArrayOfByte);
  }
  
  public static X9ECParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof X9ECParameters)) {
      return (X9ECParameters)paramObject;
    }
    if (paramObject != null) {
      return new X9ECParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public X9ECPoint getBaseEntry()
  {
    return this.g;
  }
  
  public ECCurve getCurve()
  {
    return this.curve;
  }
  
  public X9Curve getCurveEntry()
  {
    return new X9Curve(this.curve, this.seed);
  }
  
  public X9FieldID getFieldIDEntry()
  {
    return this.fieldID;
  }
  
  public ECPoint getG()
  {
    return this.g.getPoint();
  }
  
  public BigInteger getH()
  {
    return this.h;
  }
  
  public BigInteger getN()
  {
    return this.n;
  }
  
  public byte[] getSeed()
  {
    return this.seed;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(ONE));
    localASN1EncodableVector.add(this.fieldID);
    localASN1EncodableVector.add(new X9Curve(this.curve, this.seed));
    localASN1EncodableVector.add(this.g);
    localASN1EncodableVector.add(new ASN1Integer(this.n));
    BigInteger localBigInteger = this.h;
    if (localBigInteger != null) {
      localASN1EncodableVector.add(new ASN1Integer(localBigInteger));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9ECParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */