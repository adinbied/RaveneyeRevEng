package org.bouncycastle.cert.ocsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.ocsp.OCSPResponseStatus;
import org.bouncycastle.asn1.ocsp.ResponseBytes;
import org.bouncycastle.cert.CertIOException;

public class OCSPResp
{
  public static final int INTERNAL_ERROR = 2;
  public static final int MALFORMED_REQUEST = 1;
  public static final int SIG_REQUIRED = 5;
  public static final int SUCCESSFUL = 0;
  public static final int TRY_LATER = 3;
  public static final int UNAUTHORIZED = 6;
  private OCSPResponse resp;
  
  public OCSPResp(InputStream paramInputStream)
    throws IOException
  {
    this(new ASN1InputStream(paramInputStream));
  }
  
  private OCSPResp(ASN1InputStream paramASN1InputStream)
    throws IOException
  {
    try
    {
      paramASN1InputStream = OCSPResponse.getInstance(paramASN1InputStream.readObject());
      this.resp = paramASN1InputStream;
      if (paramASN1InputStream != null) {
        return;
      }
      throw new CertIOException("malformed response: no response data found");
    }
    catch (ASN1Exception paramASN1InputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed response: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
    catch (ClassCastException paramASN1InputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed response: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
    catch (IllegalArgumentException paramASN1InputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed response: ");
      localStringBuilder.append(paramASN1InputStream.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramASN1InputStream);
    }
  }
  
  public OCSPResp(OCSPResponse paramOCSPResponse)
  {
    this.resp = paramOCSPResponse;
  }
  
  public OCSPResp(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof OCSPResp)) {
      return false;
    }
    paramObject = (OCSPResp)paramObject;
    return this.resp.equals(((OCSPResp)paramObject).resp);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.resp.getEncoded();
  }
  
  public Object getResponseObject()
    throws OCSPException
  {
    Object localObject = this.resp.getResponseBytes();
    if (localObject == null) {
      return null;
    }
    if (((ResponseBytes)localObject).getResponseType().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
      try
      {
        localObject = new BasicOCSPResp(BasicOCSPResponse.getInstance(ASN1Primitive.fromByteArray(((ResponseBytes)localObject).getResponse().getOctets())));
        return localObject;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem decoding object: ");
        localStringBuilder.append(localException);
        throw new OCSPException(localStringBuilder.toString(), localException);
      }
    }
    return localException.getResponse();
  }
  
  public int getStatus()
  {
    return this.resp.getResponseStatus().getValue().intValue();
  }
  
  public int hashCode()
  {
    return this.resp.hashCode();
  }
  
  public OCSPResponse toASN1Structure()
  {
    return this.resp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\OCSPResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */