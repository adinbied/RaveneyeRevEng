package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPublicKey
  extends ASN1Object
{
  private byte[][] coeffQuadratic;
  private byte[] coeffScalar;
  private byte[][] coeffSingular;
  private ASN1Integer docLength;
  private ASN1ObjectIdentifier oid;
  private ASN1Integer version;
  
  public RainbowPublicKey(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    this.version = new ASN1Integer(0L);
    this.docLength = new ASN1Integer(paramInt);
    this.coeffQuadratic = RainbowUtil.convertArray(paramArrayOfShort1);
    this.coeffSingular = RainbowUtil.convertArray(paramArrayOfShort2);
    this.coeffScalar = RainbowUtil.convertArray(paramArrayOfShort);
  }
  
  private RainbowPublicKey(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer)) {
      this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    } else {
      this.oid = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    }
    this.docLength = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
    ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(2));
    this.coeffQuadratic = new byte[localASN1Sequence.size()][];
    int i = 0;
    while (i < localASN1Sequence.size())
    {
      this.coeffQuadratic[i] = ASN1OctetString.getInstance(localASN1Sequence.getObjectAt(i)).getOctets();
      i += 1;
    }
    localASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(3);
    this.coeffSingular = new byte[localASN1Sequence.size()][];
    i = 0;
    while (i < localASN1Sequence.size())
    {
      this.coeffSingular[i] = ASN1OctetString.getInstance(localASN1Sequence.getObjectAt(i)).getOctets();
      i += 1;
    }
    this.coeffScalar = ASN1OctetString.getInstance(((ASN1Sequence)paramASN1Sequence.getObjectAt(4)).getObjectAt(0)).getOctets();
  }
  
  public static RainbowPublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof RainbowPublicKey)) {
      return (RainbowPublicKey)paramObject;
    }
    if (paramObject != null) {
      return new RainbowPublicKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public short[][] getCoeffQuadratic()
  {
    return RainbowUtil.convertArray(this.coeffQuadratic);
  }
  
  public short[] getCoeffScalar()
  {
    return RainbowUtil.convertArray(this.coeffScalar);
  }
  
  public short[][] getCoeffSingular()
  {
    return RainbowUtil.convertArray(this.coeffSingular);
  }
  
  public int getDocLength()
  {
    return this.docLength.getValue().intValue();
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.version;
    if (localObject == null) {
      localObject = this.oid;
    }
    localASN1EncodableVector.add((ASN1Encodable)localObject);
    localASN1EncodableVector.add(this.docLength);
    localObject = new ASN1EncodableVector();
    int j = 0;
    int i = 0;
    byte[][] arrayOfByte;
    for (;;)
    {
      arrayOfByte = this.coeffQuadratic;
      if (i >= arrayOfByte.length) {
        break;
      }
      ((ASN1EncodableVector)localObject).add(new DEROctetString(arrayOfByte[i]));
      i += 1;
    }
    localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    localObject = new ASN1EncodableVector();
    i = j;
    for (;;)
    {
      arrayOfByte = this.coeffSingular;
      if (i >= arrayOfByte.length) {
        break;
      }
      ((ASN1EncodableVector)localObject).add(new DEROctetString(arrayOfByte[i]));
      i += 1;
    }
    localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    localObject = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject).add(new DEROctetString(this.coeffScalar));
    localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\RainbowPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */