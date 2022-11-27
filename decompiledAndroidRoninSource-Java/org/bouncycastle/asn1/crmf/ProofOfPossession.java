package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

public class ProofOfPossession
  extends ASN1Object
  implements ASN1Choice
{
  public static final int TYPE_KEY_AGREEMENT = 3;
  public static final int TYPE_KEY_ENCIPHERMENT = 2;
  public static final int TYPE_RA_VERIFIED = 0;
  public static final int TYPE_SIGNING_KEY = 1;
  private ASN1Encodable obj;
  private int tagNo;
  
  public ProofOfPossession()
  {
    this.tagNo = 0;
    this.obj = DERNull.INSTANCE;
  }
  
  public ProofOfPossession(int paramInt, POPOPrivKey paramPOPOPrivKey)
  {
    this.tagNo = paramInt;
    this.obj = paramPOPOPrivKey;
  }
  
  private ProofOfPossession(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    this.tagNo = i;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i != 2) && (i != 3))
        {
          paramASN1TaggedObject = new StringBuilder();
          paramASN1TaggedObject.append("unknown tag: ");
          paramASN1TaggedObject.append(this.tagNo);
          throw new IllegalArgumentException(paramASN1TaggedObject.toString());
        }
        paramASN1TaggedObject = POPOPrivKey.getInstance(paramASN1TaggedObject, true);
      }
      else
      {
        paramASN1TaggedObject = POPOSigningKey.getInstance(paramASN1TaggedObject, false);
      }
    }
    else {
      paramASN1TaggedObject = DERNull.INSTANCE;
    }
    this.obj = paramASN1TaggedObject;
  }
  
  public ProofOfPossession(POPOSigningKey paramPOPOSigningKey)
  {
    this.tagNo = 1;
    this.obj = paramPOPOSigningKey;
  }
  
  public static ProofOfPossession getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ProofOfPossession)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new ProofOfPossession((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid object: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ProofOfPossession)paramObject;
  }
  
  public ASN1Encodable getObject()
  {
    return this.obj;
  }
  
  public int getType()
  {
    return this.tagNo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.tagNo, this.obj);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\ProofOfPossession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */