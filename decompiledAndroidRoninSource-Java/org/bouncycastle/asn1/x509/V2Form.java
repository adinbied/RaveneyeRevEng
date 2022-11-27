package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class V2Form
  extends ASN1Object
{
  IssuerSerial baseCertificateID;
  GeneralNames issuerName;
  ObjectDigestInfo objectDigestInfo;
  
  public V2Form(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      int i;
      if (!(paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject))
      {
        this.issuerName = GeneralNames.getInstance(paramASN1Sequence.getObjectAt(0));
        i = 1;
      }
      else
      {
        i = 0;
      }
      while (i != paramASN1Sequence.size())
      {
        localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
        if (((ASN1TaggedObject)localObject).getTagNo() == 0)
        {
          this.baseCertificateID = IssuerSerial.getInstance((ASN1TaggedObject)localObject, false);
        }
        else
        {
          if (((ASN1TaggedObject)localObject).getTagNo() != 1) {
            break label102;
          }
          this.objectDigestInfo = ObjectDigestInfo.getInstance((ASN1TaggedObject)localObject, false);
        }
        i += 1;
        continue;
        label102:
        paramASN1Sequence = new StringBuilder();
        paramASN1Sequence.append("Bad tag number: ");
        paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
        throw new IllegalArgumentException(paramASN1Sequence.toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public V2Form(GeneralNames paramGeneralNames)
  {
    this(paramGeneralNames, null, null);
  }
  
  public V2Form(GeneralNames paramGeneralNames, IssuerSerial paramIssuerSerial)
  {
    this(paramGeneralNames, paramIssuerSerial, null);
  }
  
  public V2Form(GeneralNames paramGeneralNames, IssuerSerial paramIssuerSerial, ObjectDigestInfo paramObjectDigestInfo)
  {
    this.issuerName = paramGeneralNames;
    this.baseCertificateID = paramIssuerSerial;
    this.objectDigestInfo = paramObjectDigestInfo;
  }
  
  public V2Form(GeneralNames paramGeneralNames, ObjectDigestInfo paramObjectDigestInfo)
  {
    this(paramGeneralNames, null, paramObjectDigestInfo);
  }
  
  public static V2Form getInstance(Object paramObject)
  {
    if ((paramObject instanceof V2Form)) {
      return (V2Form)paramObject;
    }
    if (paramObject != null) {
      return new V2Form(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static V2Form getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public IssuerSerial getBaseCertificateID()
  {
    return this.baseCertificateID;
  }
  
  public GeneralNames getIssuerName()
  {
    return this.issuerName;
  }
  
  public ObjectDigestInfo getObjectDigestInfo()
  {
    return this.objectDigestInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.issuerName;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.baseCertificateID;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localObject = this.objectDigestInfo;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\V2Form.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */