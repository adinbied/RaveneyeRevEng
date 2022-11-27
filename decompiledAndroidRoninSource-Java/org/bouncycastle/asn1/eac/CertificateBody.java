package org.bouncycastle.asn1.eac;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;

public class CertificateBody
  extends ASN1Object
{
  private static final int CAR = 2;
  private static final int CEfD = 32;
  private static final int CExD = 64;
  private static final int CHA = 16;
  private static final int CHR = 8;
  private static final int CPI = 1;
  private static final int PK = 4;
  public static final int profileType = 127;
  public static final int requestType = 13;
  private DERApplicationSpecific certificateEffectiveDate;
  private DERApplicationSpecific certificateExpirationDate;
  private CertificateHolderAuthorization certificateHolderAuthorization;
  private DERApplicationSpecific certificateHolderReference;
  private DERApplicationSpecific certificateProfileIdentifier;
  private int certificateType = 0;
  private DERApplicationSpecific certificationAuthorityReference;
  private PublicKeyDataObject publicKey;
  ASN1InputStream seq;
  
  private CertificateBody(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    setIso7816CertificateBody(paramASN1ApplicationSpecific);
  }
  
  public CertificateBody(DERApplicationSpecific paramDERApplicationSpecific, CertificationAuthorityReference paramCertificationAuthorityReference, PublicKeyDataObject paramPublicKeyDataObject, CertificateHolderReference paramCertificateHolderReference, CertificateHolderAuthorization paramCertificateHolderAuthorization, PackedDate paramPackedDate1, PackedDate paramPackedDate2)
  {
    setCertificateProfileIdentifier(paramDERApplicationSpecific);
    setCertificationAuthorityReference(new DERApplicationSpecific(2, paramCertificationAuthorityReference.getEncoded()));
    setPublicKey(paramPublicKeyDataObject);
    setCertificateHolderReference(new DERApplicationSpecific(32, paramCertificateHolderReference.getEncoded()));
    setCertificateHolderAuthorization(paramCertificateHolderAuthorization);
    try
    {
      setCertificateEffectiveDate(new DERApplicationSpecific(false, 37, new DEROctetString(paramPackedDate1.getEncoding())));
      setCertificateExpirationDate(new DERApplicationSpecific(false, 36, new DEROctetString(paramPackedDate2.getEncoding())));
      return;
    }
    catch (IOException paramDERApplicationSpecific)
    {
      paramCertificationAuthorityReference = new StringBuilder();
      paramCertificationAuthorityReference.append("unable to encode dates: ");
      paramCertificationAuthorityReference.append(paramDERApplicationSpecific.getMessage());
      throw new IllegalArgumentException(paramCertificationAuthorityReference.toString());
    }
  }
  
  public static CertificateBody getInstance(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof CertificateBody)) {
      return (CertificateBody)paramObject;
    }
    if (paramObject != null) {
      return new CertificateBody(ASN1ApplicationSpecific.getInstance(paramObject));
    }
    return null;
  }
  
  private ASN1Primitive profileToASN1Object()
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certificateProfileIdentifier);
    localASN1EncodableVector.add(this.certificationAuthorityReference);
    localASN1EncodableVector.add(new DERApplicationSpecific(false, 73, this.publicKey));
    localASN1EncodableVector.add(this.certificateHolderReference);
    localASN1EncodableVector.add(this.certificateHolderAuthorization);
    localASN1EncodableVector.add(this.certificateEffectiveDate);
    localASN1EncodableVector.add(this.certificateExpirationDate);
    return new DERApplicationSpecific(78, localASN1EncodableVector);
  }
  
  private ASN1Primitive requestToASN1Object()
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certificateProfileIdentifier);
    localASN1EncodableVector.add(new DERApplicationSpecific(false, 73, this.publicKey));
    localASN1EncodableVector.add(this.certificateHolderReference);
    return new DERApplicationSpecific(78, localASN1EncodableVector);
  }
  
  private void setCertificateEffectiveDate(DERApplicationSpecific paramDERApplicationSpecific)
    throws IllegalArgumentException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 37)
    {
      this.certificateEffectiveDate = paramDERApplicationSpecific;
      this.certificateType |= 0x20;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :");
    localStringBuilder.append(EACTags.encodeTag(paramDERApplicationSpecific));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void setCertificateExpirationDate(DERApplicationSpecific paramDERApplicationSpecific)
    throws IllegalArgumentException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 36)
    {
      this.certificateExpirationDate = paramDERApplicationSpecific;
      this.certificateType |= 0x40;
      return;
    }
    throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
  }
  
  private void setCertificateHolderAuthorization(CertificateHolderAuthorization paramCertificateHolderAuthorization)
  {
    this.certificateHolderAuthorization = paramCertificateHolderAuthorization;
    this.certificateType |= 0x10;
  }
  
  private void setCertificateHolderReference(DERApplicationSpecific paramDERApplicationSpecific)
    throws IllegalArgumentException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 32)
    {
      this.certificateHolderReference = paramDERApplicationSpecific;
      this.certificateType |= 0x8;
      return;
    }
    throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
  }
  
  private void setCertificateProfileIdentifier(DERApplicationSpecific paramDERApplicationSpecific)
    throws IllegalArgumentException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 41)
    {
      this.certificateProfileIdentifier = paramDERApplicationSpecific;
      this.certificateType |= 0x1;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :");
    localStringBuilder.append(EACTags.encodeTag(paramDERApplicationSpecific));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void setCertificationAuthorityReference(DERApplicationSpecific paramDERApplicationSpecific)
    throws IllegalArgumentException
  {
    if (paramDERApplicationSpecific.getApplicationTag() == 2)
    {
      this.certificationAuthorityReference = paramDERApplicationSpecific;
      this.certificateType |= 0x2;
      return;
    }
    throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
  }
  
  private void setIso7816CertificateBody(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    if (paramASN1ApplicationSpecific.getApplicationTag() == 78)
    {
      Object localObject1 = new ASN1InputStream(paramASN1ApplicationSpecific.getContents());
      Object localObject2;
      for (;;)
      {
        localObject2 = ((ASN1InputStream)localObject1).readObject();
        if (localObject2 == null) {
          break label260;
        }
        if (!(localObject2 instanceof DERApplicationSpecific)) {
          break;
        }
        localObject2 = (DERApplicationSpecific)localObject2;
        int i = ((DERApplicationSpecific)localObject2).getApplicationTag();
        if (i != 2)
        {
          if (i != 32)
          {
            if (i != 41)
            {
              if (i != 73)
              {
                if (i != 76)
                {
                  if (i != 36)
                  {
                    if (i == 37)
                    {
                      setCertificateEffectiveDate((DERApplicationSpecific)localObject2);
                    }
                    else
                    {
                      this.certificateType = 0;
                      paramASN1ApplicationSpecific = new StringBuilder();
                      paramASN1ApplicationSpecific.append("Not a valid iso7816 DERApplicationSpecific tag ");
                      paramASN1ApplicationSpecific.append(((DERApplicationSpecific)localObject2).getApplicationTag());
                      throw new IOException(paramASN1ApplicationSpecific.toString());
                    }
                  }
                  else {
                    setCertificateExpirationDate((DERApplicationSpecific)localObject2);
                  }
                }
                else {
                  setCertificateHolderAuthorization(new CertificateHolderAuthorization((DERApplicationSpecific)localObject2));
                }
              }
              else {
                setPublicKey(PublicKeyDataObject.getInstance(((DERApplicationSpecific)localObject2).getObject(16)));
              }
            }
            else {
              setCertificateProfileIdentifier((DERApplicationSpecific)localObject2);
            }
          }
          else {
            setCertificateHolderReference((DERApplicationSpecific)localObject2);
          }
        }
        else {
          setCertificationAuthorityReference((DERApplicationSpecific)localObject2);
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Not a valid iso7816 content : not a DERApplicationSpecific Object :");
      ((StringBuilder)localObject1).append(EACTags.encodeTag(paramASN1ApplicationSpecific));
      ((StringBuilder)localObject1).append(localObject2.getClass());
      throw new IOException(((StringBuilder)localObject1).toString());
      label260:
      ((ASN1InputStream)localObject1).close();
      return;
    }
    throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
  }
  
  private void setPublicKey(PublicKeyDataObject paramPublicKeyDataObject)
  {
    this.publicKey = PublicKeyDataObject.getInstance(paramPublicKeyDataObject);
    this.certificateType |= 0x4;
  }
  
  public PackedDate getCertificateEffectiveDate()
  {
    if ((this.certificateType & 0x20) == 32) {
      return new PackedDate(this.certificateEffectiveDate.getContents());
    }
    return null;
  }
  
  public PackedDate getCertificateExpirationDate()
    throws IOException
  {
    if ((this.certificateType & 0x40) == 64) {
      return new PackedDate(this.certificateExpirationDate.getContents());
    }
    throw new IOException("certificate Expiration Date not set");
  }
  
  public CertificateHolderAuthorization getCertificateHolderAuthorization()
    throws IOException
  {
    if ((this.certificateType & 0x10) == 16) {
      return this.certificateHolderAuthorization;
    }
    throw new IOException("Certificate Holder Authorisation not set");
  }
  
  public CertificateHolderReference getCertificateHolderReference()
  {
    return new CertificateHolderReference(this.certificateHolderReference.getContents());
  }
  
  public DERApplicationSpecific getCertificateProfileIdentifier()
  {
    return this.certificateProfileIdentifier;
  }
  
  public int getCertificateType()
  {
    return this.certificateType;
  }
  
  public CertificationAuthorityReference getCertificationAuthorityReference()
    throws IOException
  {
    if ((this.certificateType & 0x2) == 2) {
      return new CertificationAuthorityReference(this.certificationAuthorityReference.getContents());
    }
    throw new IOException("Certification authority reference not set");
  }
  
  public PublicKeyDataObject getPublicKey()
  {
    return this.publicKey;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1Primitive localASN1Primitive = null;
    try
    {
      if (this.certificateType == 127) {
        return profileToASN1Object();
      }
      if (this.certificateType == 13) {
        localASN1Primitive = requestToASN1Object();
      }
      return localASN1Primitive;
    }
    catch (IOException localIOException) {}
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\CertificateBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */