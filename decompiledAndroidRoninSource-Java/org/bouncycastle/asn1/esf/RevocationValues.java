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
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevocationValues
  extends ASN1Object
{
  private ASN1Sequence crlVals;
  private ASN1Sequence ocspVals;
  private OtherRevVals otherRevVals;
  
  private RevocationValues(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      while (paramASN1Sequence.hasMoreElements())
      {
        localObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
        int i = ((ASN1TaggedObject)localObject).getTagNo();
        Enumeration localEnumeration;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              this.otherRevVals = OtherRevVals.getInstance(((ASN1TaggedObject)localObject).getObject());
            }
            else
            {
              paramASN1Sequence = new StringBuilder();
              paramASN1Sequence.append("invalid tag: ");
              paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
              throw new IllegalArgumentException(paramASN1Sequence.toString());
            }
          }
          else
          {
            localObject = (ASN1Sequence)((ASN1TaggedObject)localObject).getObject();
            localEnumeration = ((ASN1Sequence)localObject).getObjects();
            while (localEnumeration.hasMoreElements()) {
              BasicOCSPResponse.getInstance(localEnumeration.nextElement());
            }
            this.ocspVals = ((ASN1Sequence)localObject);
          }
        }
        else
        {
          localObject = (ASN1Sequence)((ASN1TaggedObject)localObject).getObject();
          localEnumeration = ((ASN1Sequence)localObject).getObjects();
          while (localEnumeration.hasMoreElements()) {
            CertificateList.getInstance(localEnumeration.nextElement());
          }
          this.crlVals = ((ASN1Sequence)localObject);
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public RevocationValues(CertificateList[] paramArrayOfCertificateList, BasicOCSPResponse[] paramArrayOfBasicOCSPResponse, OtherRevVals paramOtherRevVals)
  {
    if (paramArrayOfCertificateList != null) {
      this.crlVals = new DERSequence(paramArrayOfCertificateList);
    }
    if (paramArrayOfBasicOCSPResponse != null) {
      this.ocspVals = new DERSequence(paramArrayOfBasicOCSPResponse);
    }
    this.otherRevVals = paramOtherRevVals;
  }
  
  public static RevocationValues getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevocationValues)) {
      return (RevocationValues)paramObject;
    }
    if (paramObject != null) {
      return new RevocationValues(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertificateList[] getCrlVals()
  {
    Object localObject = this.crlVals;
    int i = 0;
    if (localObject == null) {
      return new CertificateList[0];
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CertificateList[j];
    while (i < j)
    {
      localObject[i] = CertificateList.getInstance(this.crlVals.getObjectAt(i));
      i += 1;
    }
    return (CertificateList[])localObject;
  }
  
  public BasicOCSPResponse[] getOcspVals()
  {
    Object localObject = this.ocspVals;
    int i = 0;
    if (localObject == null) {
      return new BasicOCSPResponse[0];
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new BasicOCSPResponse[j];
    while (i < j)
    {
      localObject[i] = BasicOCSPResponse.getInstance(this.ocspVals.getObjectAt(i));
      i += 1;
    }
    return (BasicOCSPResponse[])localObject;
  }
  
  public OtherRevVals getOtherRevVals()
  {
    return this.otherRevVals;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.crlVals;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.ocspVals;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    localObject = this.otherRevVals;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, ((OtherRevVals)localObject).toASN1Primitive()));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\RevocationValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */