package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.x509.X509StreamParserSpi;
import org.bouncycastle.x509.util.StreamParsingException;

public class X509CertParser
  extends X509StreamParserSpi
{
  private static final PEMUtil PEM_PARSER = new PEMUtil("CERTIFICATE");
  private InputStream currentStream = null;
  private ASN1Set sData = null;
  private int sDataObjectCount = 0;
  
  private java.security.cert.Certificate getCertificate()
    throws CertificateParsingException
  {
    if (this.sData != null) {
      while (this.sDataObjectCount < this.sData.size())
      {
        Object localObject = this.sData;
        int i = this.sDataObjectCount;
        this.sDataObjectCount = (i + 1);
        localObject = ((ASN1Set)localObject).getObjectAt(i);
        if ((localObject instanceof ASN1Sequence)) {
          return new X509CertificateObject(org.bouncycastle.asn1.x509.Certificate.getInstance(localObject));
        }
      }
    }
    return null;
  }
  
  private java.security.cert.Certificate readDERCertificate(InputStream paramInputStream)
    throws IOException, CertificateParsingException
  {
    paramInputStream = (ASN1Sequence)new ASN1InputStream(paramInputStream).readObject();
    if ((paramInputStream.size() > 1) && ((paramInputStream.getObjectAt(0) instanceof ASN1ObjectIdentifier)) && (paramInputStream.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)))
    {
      this.sData = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject)paramInputStream.getObjectAt(1), true)).getCertificates();
      return getCertificate();
    }
    return new X509CertificateObject(org.bouncycastle.asn1.x509.Certificate.getInstance(paramInputStream));
  }
  
  private java.security.cert.Certificate readPEMCertificate(InputStream paramInputStream)
    throws IOException, CertificateParsingException
  {
    paramInputStream = PEM_PARSER.readPEMObject(paramInputStream);
    if (paramInputStream != null) {
      return new X509CertificateObject(org.bouncycastle.asn1.x509.Certificate.getInstance(paramInputStream));
    }
    return null;
  }
  
  public void engineInit(InputStream paramInputStream)
  {
    this.currentStream = paramInputStream;
    this.sData = null;
    this.sDataObjectCount = 0;
    if (!paramInputStream.markSupported()) {
      this.currentStream = new BufferedInputStream(this.currentStream);
    }
  }
  
  public Object engineRead()
    throws StreamParsingException
  {
    try
    {
      if (this.sData != null)
      {
        if (this.sDataObjectCount != this.sData.size()) {
          return getCertificate();
        }
        this.sData = null;
        this.sDataObjectCount = 0;
        return null;
      }
      this.currentStream.mark(10);
      int i = this.currentStream.read();
      if (i == -1) {
        return null;
      }
      if (i != 48)
      {
        this.currentStream.reset();
        return readPEMCertificate(this.currentStream);
      }
      this.currentStream.reset();
      java.security.cert.Certificate localCertificate = readDERCertificate(this.currentStream);
      return localCertificate;
    }
    catch (Exception localException)
    {
      throw new StreamParsingException(localException.toString(), localException);
    }
  }
  
  public Collection engineReadAll()
    throws StreamParsingException
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      java.security.cert.Certificate localCertificate = (java.security.cert.Certificate)engineRead();
      if (localCertificate == null) {
        break;
      }
      localArrayList.add(localCertificate);
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509CertParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */