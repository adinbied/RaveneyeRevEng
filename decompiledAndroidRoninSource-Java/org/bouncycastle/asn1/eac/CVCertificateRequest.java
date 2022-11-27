package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

public class CVCertificateRequest
  extends ASN1Object
{
  private static final int bodyValid = 1;
  private static final int signValid = 2;
  private CertificateBody certificateBody;
  private byte[] innerSignature = null;
  private final ASN1ApplicationSpecific original;
  private byte[] outerSignature = null;
  
  private CVCertificateRequest(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    this.original = paramASN1ApplicationSpecific;
    if ((paramASN1ApplicationSpecific.isConstructed()) && (paramASN1ApplicationSpecific.getApplicationTag() == 7))
    {
      paramASN1ApplicationSpecific = ASN1Sequence.getInstance(paramASN1ApplicationSpecific.getObject(16));
      initCertBody(ASN1ApplicationSpecific.getInstance(paramASN1ApplicationSpecific.getObjectAt(0)));
      this.outerSignature = ASN1ApplicationSpecific.getInstance(paramASN1ApplicationSpecific.getObjectAt(paramASN1ApplicationSpecific.size() - 1)).getContents();
      return;
    }
    initCertBody(paramASN1ApplicationSpecific);
  }
  
  public static CVCertificateRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof CVCertificateRequest)) {
      return (CVCertificateRequest)paramObject;
    }
    if (paramObject != null) {
      try
      {
        paramObject = new CVCertificateRequest(ASN1ApplicationSpecific.getInstance(paramObject));
        return (CVCertificateRequest)paramObject;
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
  
  private void initCertBody(ASN1ApplicationSpecific paramASN1ApplicationSpecific)
    throws IOException
  {
    if (paramASN1ApplicationSpecific.getApplicationTag() == 33)
    {
      int i = 0;
      Enumeration localEnumeration = ASN1Sequence.getInstance(paramASN1ApplicationSpecific.getObject(16)).getObjects();
      while (localEnumeration.hasMoreElements())
      {
        localObject = ASN1ApplicationSpecific.getInstance(localEnumeration.nextElement());
        int j = ((ASN1ApplicationSpecific)localObject).getApplicationTag();
        if (j != 55)
        {
          if (j == 78)
          {
            this.certificateBody = CertificateBody.getInstance(localObject);
            i |= 0x1;
          }
          else
          {
            paramASN1ApplicationSpecific = new StringBuilder();
            paramASN1ApplicationSpecific.append("Invalid tag, not an CV Certificate Request element:");
            paramASN1ApplicationSpecific.append(((ASN1ApplicationSpecific)localObject).getApplicationTag());
            throw new IOException(paramASN1ApplicationSpecific.toString());
          }
        }
        else
        {
          this.innerSignature = ((ASN1ApplicationSpecific)localObject).getContents();
          i |= 0x2;
        }
      }
      if ((i & 0x3) != 0) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid CARDHOLDER_CERTIFICATE in request:");
      ((StringBuilder)localObject).append(paramASN1ApplicationSpecific.getApplicationTag());
      throw new IOException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not a CARDHOLDER_CERTIFICATE in request:");
    ((StringBuilder)localObject).append(paramASN1ApplicationSpecific.getApplicationTag());
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public CertificateBody getCertificateBody()
  {
    return this.certificateBody;
  }
  
  public byte[] getInnerSignature()
  {
    return Arrays.clone(this.innerSignature);
  }
  
  public byte[] getOuterSignature()
  {
    return Arrays.clone(this.outerSignature);
  }
  
  public PublicKeyDataObject getPublicKey()
  {
    return this.certificateBody.getPublicKey();
  }
  
  public boolean hasOuterSignature()
  {
    return this.outerSignature != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    Object localObject = this.original;
    if (localObject != null) {
      return (ASN1Primitive)localObject;
    }
    localObject = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject).add(this.certificateBody);
    try
    {
      ((ASN1EncodableVector)localObject).add(new DERApplicationSpecific(false, 55, new DEROctetString(this.innerSignature)));
      return new DERApplicationSpecific(33, (ASN1EncodableVector)localObject);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("unable to convert signature!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\CVCertificateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */