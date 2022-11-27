package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class DSTU4145ECBinary
  extends ASN1Object
{
  ASN1Integer a;
  ASN1OctetString b;
  ASN1OctetString bp;
  DSTU4145BinaryField f;
  ASN1Integer n;
  BigInteger version = BigInteger.valueOf(0L);
  
  private DSTU4145ECBinary(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject))
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(0);
      if ((localASN1TaggedObject.isExplicit()) && (localASN1TaggedObject.getTagNo() == 0))
      {
        this.version = ASN1Integer.getInstance(localASN1TaggedObject.getLoadedObject()).getValue();
        i = 1;
      }
      else
      {
        throw new IllegalArgumentException("object parse error");
      }
    }
    this.f = DSTU4145BinaryField.getInstance(paramASN1Sequence.getObjectAt(i));
    i += 1;
    this.a = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i));
    i += 1;
    this.b = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i));
    i += 1;
    this.n = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i));
    this.bp = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i + 1));
  }
  
  public DSTU4145ECBinary(ECDomainParameters paramECDomainParameters)
  {
    ECCurve localECCurve = paramECDomainParameters.getCurve();
    if (ECAlgorithms.isF2mCurve(localECCurve))
    {
      Object localObject = ((PolynomialExtensionField)localECCurve.getField()).getMinimalPolynomial().getExponentsPresent();
      if (localObject.length == 3) {}
      for (localObject = new DSTU4145BinaryField(localObject[2], localObject[1]);; localObject = new DSTU4145BinaryField(localObject[4], localObject[1], localObject[2], localObject[3]))
      {
        this.f = ((DSTU4145BinaryField)localObject);
        break;
        if (localObject.length != 5) {
          break label169;
        }
      }
      this.a = new ASN1Integer(localECCurve.getA().toBigInteger());
      this.b = new DEROctetString(localECCurve.getB().getEncoded());
      this.n = new ASN1Integer(paramECDomainParameters.getN());
      this.bp = new DEROctetString(DSTU4145PointEncoder.encodePoint(paramECDomainParameters.getG()));
      return;
      label169:
      throw new IllegalArgumentException("curve must have a trinomial or pentanomial basis");
    }
    throw new IllegalArgumentException("only binary domain is possible");
  }
  
  public static DSTU4145ECBinary getInstance(Object paramObject)
  {
    if ((paramObject instanceof DSTU4145ECBinary)) {
      return (DSTU4145ECBinary)paramObject;
    }
    if (paramObject != null) {
      return new DSTU4145ECBinary(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getA()
  {
    return this.a.getValue();
  }
  
  public byte[] getB()
  {
    return Arrays.clone(this.b.getOctets());
  }
  
  public DSTU4145BinaryField getField()
  {
    return this.f;
  }
  
  public byte[] getG()
  {
    return Arrays.clone(this.bp.getOctets());
  }
  
  public BigInteger getN()
  {
    return this.n.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.version.compareTo(BigInteger.valueOf(0L)) != 0) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, new ASN1Integer(this.version)));
    }
    localASN1EncodableVector.add(this.f);
    localASN1EncodableVector.add(this.a);
    localASN1EncodableVector.add(this.b);
    localASN1EncodableVector.add(this.n);
    localASN1EncodableVector.add(this.bp);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\DSTU4145ECBinary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */