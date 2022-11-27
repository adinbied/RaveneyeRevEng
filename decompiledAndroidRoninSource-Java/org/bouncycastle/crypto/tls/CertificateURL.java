package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class CertificateURL
{
  protected short type;
  protected Vector urlAndHashList;
  
  public CertificateURL(short paramShort, Vector paramVector)
  {
    if (CertChainType.isValid(paramShort))
    {
      if ((paramVector != null) && (!paramVector.isEmpty()))
      {
        this.type = paramShort;
        this.urlAndHashList = paramVector;
        return;
      }
      throw new IllegalArgumentException("'urlAndHashList' must have length > 0");
    }
    throw new IllegalArgumentException("'type' is not a valid CertChainType value");
  }
  
  public static CertificateURL parse(TlsContext paramTlsContext, InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (CertChainType.isValid(s))
    {
      int i = TlsUtils.readUint16(paramInputStream);
      if (i >= 1)
      {
        paramInputStream = new ByteArrayInputStream(TlsUtils.readFully(i, paramInputStream));
        Vector localVector = new Vector();
        while (paramInputStream.available() > 0) {
          localVector.addElement(URLAndHash.parse(paramTlsContext, paramInputStream));
        }
        return new CertificateURL(s, localVector);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.type, paramOutputStream);
    ListBuffer16 localListBuffer16 = new ListBuffer16();
    int i = 0;
    while (i < this.urlAndHashList.size())
    {
      ((URLAndHash)this.urlAndHashList.elementAt(i)).encode(localListBuffer16);
      i += 1;
    }
    localListBuffer16.encodeTo(paramOutputStream);
  }
  
  public short getType()
  {
    return this.type;
  }
  
  public Vector getURLAndHashList()
  {
    return this.urlAndHashList;
  }
  
  class ListBuffer16
    extends ByteArrayOutputStream
  {
    ListBuffer16()
      throws IOException
    {
      TlsUtils.writeUint16(0, this);
    }
    
    void encodeTo(OutputStream paramOutputStream)
      throws IOException
    {
      int i = this.count - 2;
      TlsUtils.checkUint16(i);
      TlsUtils.writeUint16(i, this.buf, 0);
      paramOutputStream.write(this.buf, 0, this.count);
      this.buf = null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CertificateURL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */