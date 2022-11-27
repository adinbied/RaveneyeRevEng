package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificateInfo
  extends ASN1Object
{
  private AttCertValidityPeriod attrCertValidityPeriod;
  private ASN1Sequence attributes;
  private Extensions extensions;
  private Holder holder;
  private AttCertIssuer issuer;
  private DERBitString issuerUniqueID;
  private ASN1Integer serialNumber;
  private AlgorithmIdentifier signature;
  private ASN1Integer version;
  
  private AttributeCertificateInfo(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 6) && (paramASN1Sequence.size() <= 9))
    {
      int i = 0;
      if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer))
      {
        this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
        i = 1;
      }
      else
      {
        this.version = new ASN1Integer(0L);
      }
      this.holder = Holder.getInstance(paramASN1Sequence.getObjectAt(i));
      this.issuer = AttCertIssuer.getInstance(paramASN1Sequence.getObjectAt(i + 1));
      this.signature = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i + 2));
      this.serialNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i + 3));
      this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(paramASN1Sequence.getObjectAt(i + 4));
      this.attributes = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(i + 5));
      i += 6;
      while (i < paramASN1Sequence.size())
      {
        localObject = paramASN1Sequence.getObjectAt(i);
        if ((localObject instanceof DERBitString)) {
          this.issuerUniqueID = DERBitString.getInstance(paramASN1Sequence.getObjectAt(i));
        } else if (((localObject instanceof ASN1Sequence)) || ((localObject instanceof Extensions))) {
          this.extensions = Extensions.getInstance(paramASN1Sequence.getObjectAt(i));
        }
        i += 1;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static AttributeCertificateInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof AttributeCertificateInfo)) {
      return (AttributeCertificateInfo)paramObject;
    }
    if (paramObject != null) {
      return new AttributeCertificateInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static AttributeCertificateInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AttCertValidityPeriod getAttrCertValidityPeriod()
  {
    return this.attrCertValidityPeriod;
  }
  
  public ASN1Sequence getAttributes()
  {
    return this.attributes;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public Holder getHolder()
  {
    return this.holder;
  }
  
  public AttCertIssuer getIssuer()
  {
    return this.issuer;
  }
  
  public DERBitString getIssuerUniqueID()
  {
    return this.issuerUniqueID;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public AlgorithmIdentifier getSignature()
  {
    return this.signature;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.version.getValue().intValue() != 0) {
      localASN1EncodableVector.add(this.version);
    }
    localASN1EncodableVector.add(this.holder);
    localASN1EncodableVector.add(this.issuer);
    localASN1EncodableVector.add(this.signature);
    localASN1EncodableVector.add(this.serialNumber);
    localASN1EncodableVector.add(this.attrCertValidityPeriod);
    localASN1EncodableVector.add(this.attributes);
    Object localObject = this.issuerUniqueID;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.extensions;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AttributeCertificateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */