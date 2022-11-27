package org.bouncycastle.asn1.eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class RSAPublicKey
  extends PublicKeyDataObject
{
  private static int exponentValid = 2;
  private static int modulusValid = 1;
  private BigInteger exponent;
  private BigInteger modulus;
  private ASN1ObjectIdentifier usage;
  private int valid = 0;
  
  public RSAPublicKey(ASN1ObjectIdentifier paramASN1ObjectIdentifier, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.usage = paramASN1ObjectIdentifier;
    this.modulus = paramBigInteger1;
    this.exponent = paramBigInteger2;
  }
  
  RSAPublicKey(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    this.usage = ASN1ObjectIdentifier.getInstance(((Enumeration)localObject).nextElement());
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = UnsignedInteger.getInstance(((Enumeration)localObject).nextElement());
      int i = paramASN1Sequence.getTagNo();
      if (i != 1)
      {
        if (i == 2)
        {
          setExponent(paramASN1Sequence);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown DERTaggedObject :");
          ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
          ((StringBuilder)localObject).append("-> not an Iso7816RSAPublicKeyStructure");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        setModulus(paramASN1Sequence);
      }
    }
    if (this.valid == 3) {
      return;
    }
    throw new IllegalArgumentException("missing argument -> not an Iso7816RSAPublicKeyStructure");
  }
  
  private void setExponent(UnsignedInteger paramUnsignedInteger)
  {
    int i = this.valid;
    int j = exponentValid;
    if ((i & j) == 0)
    {
      this.valid = (i | j);
      this.exponent = paramUnsignedInteger.getValue();
      return;
    }
    throw new IllegalArgumentException("Exponent already set");
  }
  
  private void setModulus(UnsignedInteger paramUnsignedInteger)
  {
    int i = this.valid;
    int j = modulusValid;
    if ((i & j) == 0)
    {
      this.valid = (i | j);
      this.modulus = paramUnsignedInteger.getValue();
      return;
    }
    throw new IllegalArgumentException("Modulus already set");
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.exponent;
  }
  
  public ASN1ObjectIdentifier getUsage()
  {
    return this.usage;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.usage);
    localASN1EncodableVector.add(new UnsignedInteger(1, getModulus()));
    localASN1EncodableVector.add(new UnsignedInteger(2, getPublicExponent()));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\RSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */