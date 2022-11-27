package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.x500.X500Name;

public class CertificateRequest
{
  protected Vector certificateAuthorities;
  protected short[] certificateTypes;
  protected Vector supportedSignatureAlgorithms;
  
  public CertificateRequest(short[] paramArrayOfShort, Vector paramVector1, Vector paramVector2)
  {
    this.certificateTypes = paramArrayOfShort;
    this.supportedSignatureAlgorithms = paramVector1;
    this.certificateAuthorities = paramVector2;
  }
  
  public static CertificateRequest parse(TlsContext paramTlsContext, InputStream paramInputStream)
    throws IOException
  {
    int j = TlsUtils.readUint8(paramInputStream);
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = TlsUtils.readUint8(paramInputStream);
      i += 1;
    }
    Vector localVector = null;
    if (TlsUtils.isTLSv12(paramTlsContext)) {
      localVector = TlsUtils.parseSupportedSignatureAlgorithms(false, paramInputStream);
    }
    paramTlsContext = new Vector();
    paramInputStream = new ByteArrayInputStream(TlsUtils.readOpaque16(paramInputStream));
    while (paramInputStream.available() > 0) {
      paramTlsContext.addElement(X500Name.getInstance(TlsUtils.readDERObject(TlsUtils.readOpaque16(paramInputStream))));
    }
    return new CertificateRequest(arrayOfShort, localVector, paramTlsContext);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    Object localObject = this.certificateTypes;
    int k = 0;
    if ((localObject != null) && (localObject.length != 0)) {
      TlsUtils.writeUint8ArrayWithUint8Length((short[])localObject, paramOutputStream);
    } else {
      TlsUtils.writeUint8(0, paramOutputStream);
    }
    localObject = this.supportedSignatureAlgorithms;
    if (localObject != null) {
      TlsUtils.encodeSupportedSignatureAlgorithms((Vector)localObject, false, paramOutputStream);
    }
    localObject = this.certificateAuthorities;
    int i;
    if ((localObject != null) && (!((Vector)localObject).isEmpty()))
    {
      localObject = new Vector(this.certificateAuthorities.size());
      i = 0;
      int j = 0;
      while (i < this.certificateAuthorities.size())
      {
        byte[] arrayOfByte = ((X500Name)this.certificateAuthorities.elementAt(i)).getEncoded("DER");
        ((Vector)localObject).addElement(arrayOfByte);
        j += arrayOfByte.length + 2;
        i += 1;
      }
      TlsUtils.checkUint16(j);
      TlsUtils.writeUint16(j, paramOutputStream);
      i = k;
    }
    while (i < ((Vector)localObject).size())
    {
      TlsUtils.writeOpaque16((byte[])((Vector)localObject).elementAt(i), paramOutputStream);
      i += 1;
      continue;
      TlsUtils.writeUint16(0, paramOutputStream);
    }
  }
  
  public Vector getCertificateAuthorities()
  {
    return this.certificateAuthorities;
  }
  
  public short[] getCertificateTypes()
  {
    return this.certificateTypes;
  }
  
  public Vector getSupportedSignatureAlgorithms()
  {
    return this.supportedSignatureAlgorithms;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\CertificateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */