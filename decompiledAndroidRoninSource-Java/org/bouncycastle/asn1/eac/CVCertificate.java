package org.bouncycastle.asn1.eac;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

public class CVCertificate
  extends ASN1Object
{
  private static int bodyValid = 1;
  private static int signValid = 2;
  private CertificateBody certificateBody;
  private byte[] signature;
  private int valid;
  
  private CVCertificate(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    setPrivateData(paramASN1ApplicationSpecific);
  }
  
  public CVCertificate(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    initFrom(paramASN1InputStream);
  }
  
  public CVCertificate(CertificateBody paramCertificateBody, byte[] paramArrayOfByte)
    throws IOException
  {
    this.certificateBody = paramCertificateBody;
    this.signature = Arrays.clone(paramArrayOfByte);
    int i = this.valid | bodyValid;
    this.valid = i;
    this.valid = (i | signValid);
  }
  
  public static CVCertificate getInstance(Object paramObject)
  {
    if ((paramObject instanceof CVCertificate)) {
      return (CVCertificate)paramObject;
    }
    if (paramObject != null) {
      try
      {
        paramObject = new CVCertificate(DERApplicationSpecific.getInstance(paramObject));
        return (CVCertificate)paramObject;
      }
      catch (IOException paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unable to parse data: ");
        localStringBuilder.append(((IOException)paramObject).getMessage());
        throw new ASN1ParsingException(localStringBuilder.toString(), (Throwable)paramObject);
      }
    }
    return null;
  }
  
  private void initFrom(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    for (;;)
    {
      ASN1Primitive localASN1Primitive = paramASN1InputStream.readObject();
      if (localASN1Primitive == null) {
        return;
      }
      if (!(localASN1Primitive instanceof DERApplicationSpecific)) {
        break;
      }
      setPrivateData((DERApplicationSpecific)localASN1Primitive);
    }
    throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
  }
  
  private void setPrivateData(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    this.valid = 0;
    if (paramASN1ApplicationSpecific.getApplicationTag() == 33)
    {
      localObject1 = new ASN1InputStream(paramASN1ApplicationSpecific.getContents());
      for (;;)
      {
        Object localObject2 = ((ASN1InputStream)localObject1).readObject();
        if (localObject2 == null) {
          break label168;
        }
        if (!(localObject2 instanceof DERApplicationSpecific)) {
          break;
        }
        localObject2 = (DERApplicationSpecific)localObject2;
        int i = ((DERApplicationSpecific)localObject2).getApplicationTag();
        int j;
        if (i != 55)
        {
          if (i == 78)
          {
            this.certificateBody = CertificateBody.getInstance(localObject2);
            i = this.valid;
            j = bodyValid;
          }
          else
          {
            paramASN1ApplicationSpecific = new StringBuilder();
            paramASN1ApplicationSpecific.append("Invalid tag, not an Iso7816CertificateStructure :");
            paramASN1ApplicationSpecific.append(((DERApplicationSpecific)localObject2).getApplicationTag());
            throw new IOException(paramASN1ApplicationSpecific.toString());
          }
        }
        else
        {
          this.signature = ((DERApplicationSpecific)localObject2).getContents();
          i = this.valid;
          j = signValid;
        }
        this.valid = (i | j);
      }
      throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
      label168:
      ((ASN1InputStream)localObject1).close();
      if (this.valid == (signValid | bodyValid)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("invalid CARDHOLDER_CERTIFICATE :");
      ((StringBuilder)localObject1).append(paramASN1ApplicationSpecific.getApplicationTag());
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("not a CARDHOLDER_CERTIFICATE :");
    ((StringBuilder)localObject1).append(paramASN1ApplicationSpecific.getApplicationTag());
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  public CertificationAuthorityReference getAuthorityReference()
    throws IOException
  {
    return this.certificateBody.getCertificationAuthorityReference();
  }
  
  public CertificateBody getBody()
  {
    return this.certificateBody;
  }
  
  public int getCertificateType()
  {
    return this.certificateBody.getCertificateType();
  }
  
  public PackedDate getEffectiveDate()
    throws IOException
  {
    return this.certificateBody.getCertificateEffectiveDate();
  }
  
  public PackedDate getExpirationDate()
    throws IOException
  {
    return this.certificateBody.getCertificateExpirationDate();
  }
  
  public ASN1ObjectIdentifier getHolderAuthorization()
    throws IOException
  {
    return this.certificateBody.getCertificateHolderAuthorization().getOid();
  }
  
  public Flags getHolderAuthorizationRights()
    throws IOException
  {
    return new Flags(this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 0x1F);
  }
  
  public int getHolderAuthorizationRole()
    throws IOException
  {
    return this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 0xC0;
  }
  
  public CertificateHolderReference getHolderReference()
    throws IOException
  {
    return this.certificateBody.getCertificateHolderReference();
  }
  
  public int getRole()
    throws IOException
  {
    return this.certificateBody.getCertificateHolderAuthorization().getAccessRights();
  }
  
  public byte[] getSignature()
  {
    return Arrays.clone(this.signature);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certificateBody);
    try
    {
      localASN1EncodableVector.add(new DERApplicationSpecific(false, 55, new DEROctetString(this.signature)));
      return new DERApplicationSpecific(33, localASN1EncodableVector);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("unable to convert signature!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\CVCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */