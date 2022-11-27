package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class PKIMessage
  extends ASN1Object
{
  private PKIBody body;
  private ASN1Sequence extraCerts;
  private PKIHeader header;
  private DERBitString protection;
  
  private PKIMessage(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.header = PKIHeader.getInstance(paramASN1Sequence.nextElement());
    this.body = PKIBody.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
      if (localASN1TaggedObject.getTagNo() == 0) {
        this.protection = DERBitString.getInstance(localASN1TaggedObject, true);
      } else {
        this.extraCerts = ASN1Sequence.getInstance(localASN1TaggedObject, true);
      }
    }
  }
  
  public PKIMessage(PKIHeader paramPKIHeader, PKIBody paramPKIBody)
  {
    this(paramPKIHeader, paramPKIBody, null, null);
  }
  
  public PKIMessage(PKIHeader paramPKIHeader, PKIBody paramPKIBody, DERBitString paramDERBitString)
  {
    this(paramPKIHeader, paramPKIBody, paramDERBitString, null);
  }
  
  public PKIMessage(PKIHeader paramPKIHeader, PKIBody paramPKIBody, DERBitString paramDERBitString, CMPCertificate[] paramArrayOfCMPCertificate)
  {
    this.header = paramPKIHeader;
    this.body = paramPKIBody;
    this.protection = paramDERBitString;
    if (paramArrayOfCMPCertificate != null)
    {
      paramPKIHeader = new ASN1EncodableVector();
      int i = 0;
      while (i < paramArrayOfCMPCertificate.length)
      {
        paramPKIHeader.add(paramArrayOfCMPCertificate[i]);
        i += 1;
      }
      this.extraCerts = new DERSequence(paramPKIHeader);
    }
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  public static PKIMessage getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIMessage)) {
      return (PKIMessage)paramObject;
    }
    if (paramObject != null) {
      return new PKIMessage(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public PKIBody getBody()
  {
    return this.body;
  }
  
  public CMPCertificate[] getExtraCerts()
  {
    Object localObject = this.extraCerts;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CMPCertificate[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = CMPCertificate.getInstance(this.extraCerts.getObjectAt(i));
      i += 1;
    }
    return (CMPCertificate[])localObject;
  }
  
  public PKIHeader getHeader()
  {
    return this.header;
  }
  
  public DERBitString getProtection()
  {
    return this.protection;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.header);
    localASN1EncodableVector.add(this.body);
    addOptional(localASN1EncodableVector, 0, this.protection);
    addOptional(localASN1EncodableVector, 1, this.extraCerts);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */