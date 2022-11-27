package org.bouncycastle.eac;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.eac.CVCertificate;
import org.bouncycastle.asn1.eac.CertificateBody;
import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.bouncycastle.eac.operator.EACSignatureVerifier;

public class EACCertificateHolder
{
  private CVCertificate cvCertificate;
  
  public EACCertificateHolder(CVCertificate paramCVCertificate)
  {
    this.cvCertificate = paramCVCertificate;
  }
  
  public EACCertificateHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static CVCertificate parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = CVCertificate.getInstance(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (ASN1ParsingException paramArrayOfByte)
    {
      if ((paramArrayOfByte.getCause() instanceof IOException)) {
        throw ((IOException)paramArrayOfByte.getCause());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new EACIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new EACIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new EACIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public PublicKeyDataObject getPublicKeyDataObject()
  {
    return this.cvCertificate.getBody().getPublicKey();
  }
  
  public boolean isSignatureValid(EACSignatureVerifier paramEACSignatureVerifier)
    throws EACException
  {
    try
    {
      localObject = paramEACSignatureVerifier.getOutputStream();
      ((OutputStream)localObject).write(this.cvCertificate.getBody().getEncoded("DER"));
      ((OutputStream)localObject).close();
      boolean bool = paramEACSignatureVerifier.verify(this.cvCertificate.getSignature());
      return bool;
    }
    catch (Exception paramEACSignatureVerifier)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to process signature: ");
      ((StringBuilder)localObject).append(paramEACSignatureVerifier.getMessage());
      throw new EACException(((StringBuilder)localObject).toString(), paramEACSignatureVerifier);
    }
  }
  
  public CVCertificate toASN1Structure()
  {
    return this.cvCertificate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\EACCertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */