package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Holder
  extends ASN1Object
{
  public static final int V1_CERTIFICATE_HOLDER = 0;
  public static final int V2_CERTIFICATE_HOLDER = 1;
  IssuerSerial baseCertificateID;
  GeneralNames entityName;
  ObjectDigestInfo objectDigestInfo;
  private int version = 1;
  
  private Holder(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      int i = 0;
      while (i != paramASN1Sequence.size())
      {
        localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
        int j = ((ASN1TaggedObject)localObject).getTagNo();
        if (j != 0)
        {
          if (j != 1)
          {
            if (j == 2) {
              this.objectDigestInfo = ObjectDigestInfo.getInstance((ASN1TaggedObject)localObject, false);
            } else {
              throw new IllegalArgumentException("unknown tag in Holder");
            }
          }
          else {
            this.entityName = GeneralNames.getInstance((ASN1TaggedObject)localObject, false);
          }
        }
        else {
          this.baseCertificateID = IssuerSerial.getInstance((ASN1TaggedObject)localObject, false);
        }
        i += 1;
      }
      this.version = 1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private Holder(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    if (i != 0)
    {
      if (i == 1) {
        this.entityName = GeneralNames.getInstance(paramASN1TaggedObject, true);
      } else {
        throw new IllegalArgumentException("unknown tag in Holder");
      }
    }
    else {
      this.baseCertificateID = IssuerSerial.getInstance(paramASN1TaggedObject, true);
    }
    this.version = 0;
  }
  
  public Holder(GeneralNames paramGeneralNames)
  {
    this(paramGeneralNames, 1);
  }
  
  public Holder(GeneralNames paramGeneralNames, int paramInt)
  {
    this.entityName = paramGeneralNames;
    this.version = paramInt;
  }
  
  public Holder(IssuerSerial paramIssuerSerial)
  {
    this(paramIssuerSerial, 1);
  }
  
  public Holder(IssuerSerial paramIssuerSerial, int paramInt)
  {
    this.baseCertificateID = paramIssuerSerial;
    this.version = paramInt;
  }
  
  public Holder(ObjectDigestInfo paramObjectDigestInfo)
  {
    this.objectDigestInfo = paramObjectDigestInfo;
  }
  
  public static Holder getInstance(Object paramObject)
  {
    if ((paramObject instanceof Holder)) {
      return (Holder)paramObject;
    }
    if ((paramObject instanceof ASN1TaggedObject)) {
      return new Holder(ASN1TaggedObject.getInstance(paramObject));
    }
    if (paramObject != null) {
      return new Holder(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public IssuerSerial getBaseCertificateID()
  {
    return this.baseCertificateID;
  }
  
  public GeneralNames getEntityName()
  {
    return this.entityName;
  }
  
  public ObjectDigestInfo getObjectDigestInfo()
  {
    return this.objectDigestInfo;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    if (this.version == 1)
    {
      localObject1 = new ASN1EncodableVector();
      Object localObject2 = this.baseCertificateID;
      if (localObject2 != null) {
        ((ASN1EncodableVector)localObject1).add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject2));
      }
      localObject2 = this.entityName;
      if (localObject2 != null) {
        ((ASN1EncodableVector)localObject1).add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject2));
      }
      localObject2 = this.objectDigestInfo;
      if (localObject2 != null) {
        ((ASN1EncodableVector)localObject1).add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject2));
      }
      return new DERSequence((ASN1EncodableVector)localObject1);
    }
    Object localObject1 = this.entityName;
    if (localObject1 != null) {
      return new DERTaggedObject(true, 1, (ASN1Encodable)localObject1);
    }
    return new DERTaggedObject(true, 0, this.baseCertificateID);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Holder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */