package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class RSAPublicKeyStructure
  extends ASN1Object
{
  private BigInteger modulus;
  private BigInteger publicExponent;
  
  public RSAPublicKeyStructure(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.modulus = paramBigInteger1;
    this.publicExponent = paramBigInteger2;
  }
  
  public RSAPublicKeyStructure(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      this.modulus = ASN1Integer.getInstance(paramASN1Sequence.nextElement()).getPositiveValue();
      this.publicExponent = ASN1Integer.getInstance(paramASN1Sequence.nextElement()).getPositiveValue();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static RSAPublicKeyStructure getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof RSAPublicKeyStructure)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new RSAPublicKeyStructure((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid RSAPublicKeyStructure: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (RSAPublicKeyStructure)paramObject;
  }
  
  public static RSAPublicKeyStructure getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(getModulus()));
    localASN1EncodableVector.add(new ASN1Integer(getPublicExponent()));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\RSAPublicKeyStructure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */