package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class GMSSPublicKey
  extends ASN1Object
{
  private byte[] publicKey;
  private ASN1Integer version;
  
  private GMSSPublicKey(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
      this.publicKey = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1)).getOctets();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size of seq = ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public GMSSPublicKey(byte[] paramArrayOfByte)
  {
    this.version = new ASN1Integer(0L);
    this.publicKey = paramArrayOfByte;
  }
  
  public static GMSSPublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof GMSSPublicKey)) {
      return (GMSSPublicKey)paramObject;
    }
    if (paramObject != null) {
      return new GMSSPublicKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getPublicKey()
  {
    return Arrays.clone(this.publicKey);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(new DEROctetString(this.publicKey));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\GMSSPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */