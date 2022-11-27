package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute
  extends ASN1Object
{
  private Object[] values;
  
  private SignerAttribute(ASN1Sequence paramASN1Sequence)
  {
    this.values = new Object[paramASN1Sequence.size()];
    paramASN1Sequence = paramASN1Sequence.getObjects();
    int i = 0;
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.nextElement());
      if (((ASN1TaggedObject)localObject).getTagNo() == 0)
      {
        localObject = ASN1Sequence.getInstance((ASN1TaggedObject)localObject, true);
        int k = ((ASN1Sequence)localObject).size();
        Attribute[] arrayOfAttribute = new Attribute[k];
        int j = 0;
        while (j != k)
        {
          arrayOfAttribute[j] = Attribute.getInstance(((ASN1Sequence)localObject).getObjectAt(j));
          j += 1;
        }
        this.values[i] = arrayOfAttribute;
      }
      else
      {
        if (((ASN1TaggedObject)localObject).getTagNo() != 1) {
          break label142;
        }
        this.values[i] = AttributeCertificate.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject)localObject, true));
      }
      i += 1;
      continue;
      label142:
      paramASN1Sequence = new StringBuilder();
      paramASN1Sequence.append("illegal tag: ");
      paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
      throw new IllegalArgumentException(paramASN1Sequence.toString());
    }
  }
  
  public SignerAttribute(AttributeCertificate paramAttributeCertificate)
  {
    Object[] arrayOfObject = new Object[1];
    this.values = arrayOfObject;
    arrayOfObject[0] = paramAttributeCertificate;
  }
  
  public SignerAttribute(Attribute[] paramArrayOfAttribute)
  {
    Object[] arrayOfObject = new Object[1];
    this.values = arrayOfObject;
    arrayOfObject[0] = paramArrayOfAttribute;
  }
  
  public static SignerAttribute getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignerAttribute)) {
      return (SignerAttribute)paramObject;
    }
    if (paramObject != null) {
      return new SignerAttribute(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Object[] getValues()
  {
    Object[] arrayOfObject1 = this.values;
    int i = arrayOfObject1.length;
    Object[] arrayOfObject2 = new Object[i];
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
    return arrayOfObject2;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      Object localObject = this.values;
      if (i == localObject.length) {
        break;
      }
      if ((localObject[i] instanceof Attribute[])) {
        localObject = new DERTaggedObject(0, new DERSequence((Attribute[])localObject[i]));
      } else {
        localObject = new DERTaggedObject(1, (AttributeCertificate)localObject[i]);
      }
      localASN1EncodableVector.add((ASN1Encodable)localObject);
      i += 1;
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SignerAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */