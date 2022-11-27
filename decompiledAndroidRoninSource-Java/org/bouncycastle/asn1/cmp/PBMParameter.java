package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PBMParameter
  extends ASN1Object
{
  private ASN1Integer iterationCount;
  private AlgorithmIdentifier mac;
  private AlgorithmIdentifier owf;
  private ASN1OctetString salt;
  
  public PBMParameter(ASN1OctetString paramASN1OctetString, AlgorithmIdentifier paramAlgorithmIdentifier1, ASN1Integer paramASN1Integer, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    this.salt = paramASN1OctetString;
    this.owf = paramAlgorithmIdentifier1;
    this.iterationCount = paramASN1Integer;
    this.mac = paramAlgorithmIdentifier2;
  }
  
  private PBMParameter(ASN1Sequence paramASN1Sequence)
  {
    this.salt = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(0));
    this.owf = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.iterationCount = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(2));
    this.mac = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(3));
  }
  
  public PBMParameter(byte[] paramArrayOfByte, AlgorithmIdentifier paramAlgorithmIdentifier1, int paramInt, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    this(new DEROctetString(paramArrayOfByte), paramAlgorithmIdentifier1, new ASN1Integer(paramInt), paramAlgorithmIdentifier2);
  }
  
  public static PBMParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof PBMParameter)) {
      return (PBMParameter)paramObject;
    }
    if (paramObject != null) {
      return new PBMParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getIterationCount()
  {
    return this.iterationCount;
  }
  
  public AlgorithmIdentifier getMac()
  {
    return this.mac;
  }
  
  public AlgorithmIdentifier getOwf()
  {
    return this.owf;
  }
  
  public ASN1OctetString getSalt()
  {
    return this.salt;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.salt);
    localASN1EncodableVector.add(this.owf);
    localASN1EncodableVector.add(this.iterationCount);
    localASN1EncodableVector.add(this.mac);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PBMParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */