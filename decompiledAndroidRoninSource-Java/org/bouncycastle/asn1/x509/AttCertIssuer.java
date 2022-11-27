package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class AttCertIssuer
  extends ASN1Object
  implements ASN1Choice
{
  ASN1Primitive choiceObj;
  ASN1Encodable obj;
  
  public AttCertIssuer(GeneralNames paramGeneralNames)
  {
    this.obj = paramGeneralNames;
    this.choiceObj = paramGeneralNames.toASN1Primitive();
  }
  
  public AttCertIssuer(V2Form paramV2Form)
  {
    this.obj = paramV2Form;
    this.choiceObj = new DERTaggedObject(false, 0, paramV2Form);
  }
  
  public static AttCertIssuer getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof AttCertIssuer)))
    {
      if ((paramObject instanceof V2Form)) {
        return new AttCertIssuer(V2Form.getInstance(paramObject));
      }
      if ((paramObject instanceof GeneralNames)) {
        return new AttCertIssuer((GeneralNames)paramObject);
      }
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject)paramObject, false));
      }
      if ((paramObject instanceof ASN1Sequence)) {
        return new AttCertIssuer(GeneralNames.getInstance(paramObject));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (AttCertIssuer)paramObject;
  }
  
  public static AttCertIssuer getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public ASN1Encodable getIssuer()
  {
    return this.obj;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.choiceObj;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AttCertIssuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */