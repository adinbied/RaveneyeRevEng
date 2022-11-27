package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CertificateStatusRequest
{
  protected Object request;
  protected short statusType;
  
  public CertificateStatusRequest(short paramShort, Object paramObject)
  {
    if (isCorrectType(paramShort, paramObject))
    {
      this.statusType = paramShort;
      this.request = paramObject;
      return;
    }
    throw new IllegalArgumentException("'request' is not an instance of the correct type");
  }
  
  protected static boolean isCorrectType(short paramShort, Object paramObject)
  {
    if (paramShort == 1) {
      return paramObject instanceof OCSPStatusRequest;
    }
    throw new IllegalArgumentException("'statusType' is an unsupported value");
  }
  
  public static CertificateStatusRequest parse(InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (s == 1) {
      return new CertificateStatusRequest(s, OCSPStatusRequest.parse(paramInputStream));
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.statusType, paramOutputStream);
    if (this.statusType == 1)
    {
      ((OCSPStatusRequest)this.request).encode(paramOutputStream);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public OCSPStatusRequest getOCSPStatusRequest()
  {
    if (isCorrectType(, this.request)) {
      return (OCSPStatusRequest)this.request;
    }
    throw new IllegalStateException("'request' is not an OCSPStatusRequest");
  }
  
  public Object getRequest()
  {
    return this.request;
  }
  
  public short getStatusType()
  {
    return this.statusType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CertificateStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */