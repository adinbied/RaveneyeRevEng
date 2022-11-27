package org.bouncycastle.asn1.isismtt.ocsp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Certificate;

public class RequestedCertificate
  extends ASN1Object
  implements ASN1Choice
{
  public static final int attributeCertificate = 1;
  public static final int certificate = -1;
  public static final int publicKeyCertificate = 0;
  private byte[] attributeCert;
  private Certificate cert;
  private byte[] publicKeyCert;
  
  public RequestedCertificate(int paramInt, byte[] paramArrayOfByte)
  {
    this(new DERTaggedObject(paramInt, new DEROctetString(paramArrayOfByte)));
  }
  
  private RequestedCertificate(ASN1TaggedObject paramASN1TaggedObject)
  {
    if (paramASN1TaggedObject.getTagNo() == 0)
    {
      this.publicKeyCert = ASN1OctetString.getInstance(paramASN1TaggedObject, true).getOctets();
      return;
    }
    if (paramASN1TaggedObject.getTagNo() == 1)
    {
      this.attributeCert = ASN1OctetString.getInstance(paramASN1TaggedObject, true).getOctets();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown tag number: ");
    localStringBuilder.append(paramASN1TaggedObject.getTagNo());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public RequestedCertificate(Certificate paramCertificate)
  {
    this.cert = paramCertificate;
  }
  
  public static RequestedCertificate getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof RequestedCertificate)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new RequestedCertificate(Certificate.getInstance(paramObject));
      }
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new RequestedCertificate((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (RequestedCertificate)paramObject;
  }
  
  public static RequestedCertificate getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getInstance(paramASN1TaggedObject.getObject());
    }
    throw new IllegalArgumentException("choice item must be explicitly tagged");
  }
  
  public byte[] getCertificateBytes()
  {
    Object localObject = this.cert;
    if (localObject != null) {
      try
      {
        localObject = ((Certificate)localObject).getEncoded();
        return (byte[])localObject;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can't decode certificate: ");
        localStringBuilder.append(localIOException);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    byte[] arrayOfByte = this.publicKeyCert;
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    return this.attributeCert;
  }
  
  public int getType()
  {
    if (this.cert != null) {
      return -1;
    }
    if (this.publicKeyCert != null) {
      return 0;
    }
    return 1;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    byte[] arrayOfByte = this.publicKeyCert;
    if (arrayOfByte != null) {
      return new DERTaggedObject(0, new DEROctetString(arrayOfByte));
    }
    arrayOfByte = this.attributeCert;
    if (arrayOfByte != null) {
      return new DERTaggedObject(1, new DEROctetString(arrayOfByte));
    }
    return this.cert.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\ocsp\RequestedCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */