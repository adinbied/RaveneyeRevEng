package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class Certificate
{
  public static final Certificate EMPTY_CHAIN = new Certificate(new org.bouncycastle.asn1.x509.Certificate[0]);
  protected org.bouncycastle.asn1.x509.Certificate[] certificateList;
  
  public Certificate(org.bouncycastle.asn1.x509.Certificate[] paramArrayOfCertificate)
  {
    if (paramArrayOfCertificate != null)
    {
      this.certificateList = paramArrayOfCertificate;
      return;
    }
    throw new IllegalArgumentException("'certificateList' cannot be null");
  }
  
  public static Certificate parse(InputStream paramInputStream)
    throws IOException
  {
    int i = TlsUtils.readUint24(paramInputStream);
    if (i == 0) {
      return EMPTY_CHAIN;
    }
    Object localObject = new ByteArrayInputStream(TlsUtils.readFully(i, paramInputStream));
    paramInputStream = new Vector();
    while (((ByteArrayInputStream)localObject).available() > 0) {
      paramInputStream.addElement(org.bouncycastle.asn1.x509.Certificate.getInstance(TlsUtils.readDERObject(TlsUtils.readOpaque24((InputStream)localObject))));
    }
    localObject = new org.bouncycastle.asn1.x509.Certificate[paramInputStream.size()];
    i = 0;
    while (i < paramInputStream.size())
    {
      localObject[i] = ((org.bouncycastle.asn1.x509.Certificate)paramInputStream.elementAt(i));
      i += 1;
    }
    return new Certificate((org.bouncycastle.asn1.x509.Certificate[])localObject);
  }
  
  protected org.bouncycastle.asn1.x509.Certificate[] cloneCertificateList()
  {
    org.bouncycastle.asn1.x509.Certificate[] arrayOfCertificate1 = this.certificateList;
    int i = arrayOfCertificate1.length;
    org.bouncycastle.asn1.x509.Certificate[] arrayOfCertificate2 = new org.bouncycastle.asn1.x509.Certificate[i];
    System.arraycopy(arrayOfCertificate1, 0, arrayOfCertificate2, 0, i);
    return arrayOfCertificate2;
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    Vector localVector = new Vector(this.certificateList.length);
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = this.certificateList;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i].getEncoded("DER");
      localVector.addElement(localObject);
      j += localObject.length + 3;
      i += 1;
    }
    TlsUtils.checkUint24(j);
    TlsUtils.writeUint24(j, paramOutputStream);
    i = k;
    while (i < localVector.size())
    {
      TlsUtils.writeOpaque24((byte[])localVector.elementAt(i), paramOutputStream);
      i += 1;
    }
  }
  
  public org.bouncycastle.asn1.x509.Certificate getCertificateAt(int paramInt)
  {
    return this.certificateList[paramInt];
  }
  
  public org.bouncycastle.asn1.x509.Certificate[] getCertificateList()
  {
    return cloneCertificateList();
  }
  
  public int getLength()
  {
    return this.certificateList.length;
  }
  
  public boolean isEmpty()
  {
    return this.certificateList.length == 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\Certificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */