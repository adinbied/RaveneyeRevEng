package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ocsp.OCSPResponse;

public class CertificateStatus
{
  protected Object response;
  protected short statusType;
  
  public CertificateStatus(short paramShort, Object paramObject)
  {
    if (isCorrectType(paramShort, paramObject))
    {
      this.statusType = paramShort;
      this.response = paramObject;
      return;
    }
    throw new IllegalArgumentException("'response' is not an instance of the correct type");
  }
  
  protected static boolean isCorrectType(short paramShort, Object paramObject)
  {
    if (paramShort == 1) {
      return paramObject instanceof OCSPResponse;
    }
    throw new IllegalArgumentException("'statusType' is an unsupported value");
  }
  
  public static CertificateStatus parse(InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (s == 1) {
      return new CertificateStatus(s, OCSPResponse.getInstance(TlsUtils.readDERObject(TlsUtils.readOpaque24(paramInputStream))));
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.statusType, paramOutputStream);
    if (this.statusType == 1)
    {
      TlsUtils.writeOpaque24(((OCSPResponse)this.response).getEncoded("DER"), paramOutputStream);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public OCSPResponse getOCSPResponse()
  {
    if (isCorrectType(, this.response)) {
      return (OCSPResponse)this.response;
    }
    throw new IllegalStateException("'response' is not an OCSPResponse");
  }
  
  public Object getResponse()
  {
    return this.response;
  }
  
  public short getStatusType()
  {
    return this.statusType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CertificateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */