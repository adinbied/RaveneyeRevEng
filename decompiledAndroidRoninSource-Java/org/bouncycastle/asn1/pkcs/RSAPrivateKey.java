package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class RSAPrivateKey
  extends ASN1Object
{
  private BigInteger coefficient;
  private BigInteger exponent1;
  private BigInteger exponent2;
  private BigInteger modulus;
  private ASN1Sequence otherPrimeInfos = null;
  private BigInteger prime1;
  private BigInteger prime2;
  private BigInteger privateExponent;
  private BigInteger publicExponent;
  private BigInteger version;
  
  public RSAPrivateKey(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6, BigInteger paramBigInteger7, BigInteger paramBigInteger8)
  {
    this.version = BigInteger.valueOf(0L);
    this.modulus = paramBigInteger1;
    this.publicExponent = paramBigInteger2;
    this.privateExponent = paramBigInteger3;
    this.prime1 = paramBigInteger4;
    this.prime2 = paramBigInteger5;
    this.exponent1 = paramBigInteger6;
    this.exponent2 = paramBigInteger7;
    this.coefficient = paramBigInteger8;
  }
  
  private RSAPrivateKey(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    BigInteger localBigInteger = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    if ((localBigInteger.intValue() != 0) && (localBigInteger.intValue() != 1)) {
      throw new IllegalArgumentException("wrong version for RSA private key");
    }
    this.version = localBigInteger;
    this.modulus = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.publicExponent = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.privateExponent = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.prime1 = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.prime2 = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.exponent1 = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.exponent2 = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    this.coefficient = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue();
    if (paramASN1Sequence.hasMoreElements()) {
      this.otherPrimeInfos = ((ASN1Sequence)paramASN1Sequence.nextElement());
    }
  }
  
  public static RSAPrivateKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof RSAPrivateKey)) {
      return (RSAPrivateKey)paramObject;
    }
    if (paramObject != null) {
      return new RSAPrivateKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static RSAPrivateKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getCoefficient()
  {
    return this.coefficient;
  }
  
  public BigInteger getExponent1()
  {
    return this.exponent1;
  }
  
  public BigInteger getExponent2()
  {
    return this.exponent2;
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPrime1()
  {
    return this.prime1;
  }
  
  public BigInteger getPrime2()
  {
    return this.prime2;
  }
  
  public BigInteger getPrivateExponent()
  {
    return this.privateExponent;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public BigInteger getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.version));
    localASN1EncodableVector.add(new ASN1Integer(getModulus()));
    localASN1EncodableVector.add(new ASN1Integer(getPublicExponent()));
    localASN1EncodableVector.add(new ASN1Integer(getPrivateExponent()));
    localASN1EncodableVector.add(new ASN1Integer(getPrime1()));
    localASN1EncodableVector.add(new ASN1Integer(getPrime2()));
    localASN1EncodableVector.add(new ASN1Integer(getExponent1()));
    localASN1EncodableVector.add(new ASN1Integer(getExponent2()));
    localASN1EncodableVector.add(new ASN1Integer(getCoefficient()));
    ASN1Sequence localASN1Sequence = this.otherPrimeInfos;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(localASN1Sequence);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\RSAPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */