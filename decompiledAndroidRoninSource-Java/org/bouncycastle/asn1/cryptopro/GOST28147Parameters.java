package org.bouncycastle.asn1.cryptopro;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class GOST28147Parameters
  extends ASN1Object
{
  private ASN1OctetString iv;
  private ASN1ObjectIdentifier paramSet;
  
  public GOST28147Parameters(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.iv = ((ASN1OctetString)paramASN1Sequence.nextElement());
    this.paramSet = ((ASN1ObjectIdentifier)paramASN1Sequence.nextElement());
  }
  
  public static GOST28147Parameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof GOST28147Parameters)) {
      return (GOST28147Parameters)paramObject;
    }
    if (paramObject != null) {
      return new GOST28147Parameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static GOST28147Parameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1ObjectIdentifier getEncryptionParamSet()
  {
    return this.paramSet;
  }
  
  public byte[] getIV()
  {
    return Arrays.clone(this.iv.getOctets());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.iv);
    localASN1EncodableVector.add(this.paramSet);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cryptopro\GOST28147Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */