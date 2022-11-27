package org.bouncycastle.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Store;

public class SimplePKIResponse
  implements Encodable
{
  private final CMSSignedData certificateResponse;
  
  public SimplePKIResponse(ContentInfo paramContentInfo)
    throws CMCException
  {
    try
    {
      paramContentInfo = new CMSSignedData(paramContentInfo);
      this.certificateResponse = paramContentInfo;
      if (paramContentInfo.getSignerInfos().size() == 0)
      {
        if (this.certificateResponse.getSignedContent() == null) {
          return;
        }
        throw new CMCException("malformed response: Signed Content found");
      }
      throw new CMCException("malformed response: SignerInfo structures found");
    }
    catch (CMSException paramContentInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed response: ");
      localStringBuilder.append(paramContentInfo.getMessage());
      throw new CMCException(localStringBuilder.toString(), paramContentInfo);
    }
  }
  
  public SimplePKIResponse(byte[] paramArrayOfByte)
    throws CMCException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static ContentInfo parseBytes(byte[] paramArrayOfByte)
    throws CMCException
  {
    try
    {
      paramArrayOfByte = ContentInfo.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CMCException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public Store<X509CRLHolder> getCRLs()
  {
    return this.certificateResponse.getCRLs();
  }
  
  public Store<X509CertificateHolder> getCertificates()
  {
    return this.certificateResponse.getCertificates();
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.certificateResponse.getEncoded();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cmc\SimplePKIResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */