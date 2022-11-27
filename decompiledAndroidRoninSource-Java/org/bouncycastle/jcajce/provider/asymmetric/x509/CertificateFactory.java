package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.io.Streams;

public class CertificateFactory
  extends CertificateFactorySpi
{
  private static final PEMUtil PEM_CERT_PARSER = new PEMUtil("CERTIFICATE");
  private static final PEMUtil PEM_CRL_PARSER = new PEMUtil("CRL");
  private static final PEMUtil PEM_PKCS7_PARSER = new PEMUtil("PKCS7");
  private final JcaJceHelper bcHelper = new BCJcaJceHelper();
  private InputStream currentCrlStream = null;
  private InputStream currentStream = null;
  private ASN1Set sCrlData = null;
  private int sCrlDataObjectCount = 0;
  private ASN1Set sData = null;
  private int sDataObjectCount = 0;
  
  private CRL getCRL()
    throws CRLException
  {
    ASN1Set localASN1Set = this.sCrlData;
    if ((localASN1Set != null) && (this.sCrlDataObjectCount < localASN1Set.size()))
    {
      localASN1Set = this.sCrlData;
      int i = this.sCrlDataObjectCount;
      this.sCrlDataObjectCount = (i + 1);
      return createCRL(CertificateList.getInstance(localASN1Set.getObjectAt(i)));
    }
    return null;
  }
  
  private CRL getCRL(ASN1Sequence paramASN1Sequence)
    throws CRLException
  {
    if (paramASN1Sequence == null) {
      return null;
    }
    if ((paramASN1Sequence.size() > 1) && ((paramASN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier)) && (paramASN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)))
    {
      this.sCrlData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true)).getCRLs();
      return getCRL();
    }
    return createCRL(CertificateList.getInstance(paramASN1Sequence));
  }
  
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
          return new X509CertificateObject(this.bcHelper, org.bouncycastle.asn1.x509.Certificate.getInstance(localObject));
        }
      }
    }
    return null;
  }
  
  private java.security.cert.Certificate getCertificate(ASN1Sequence paramASN1Sequence)
    throws CertificateParsingException
  {
    if (paramASN1Sequence == null) {
      return null;
    }
    if ((paramASN1Sequence.size() > 1) && ((paramASN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier)) && (paramASN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)))
    {
      this.sData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true)).getCertificates();
      return getCertificate();
    }
    return new X509CertificateObject(this.bcHelper, org.bouncycastle.asn1.x509.Certificate.getInstance(paramASN1Sequence));
  }
  
  private CRL readDERCRL(ASN1InputStream paramASN1InputStream)
    throws IOException, CRLException
  {
    return getCRL(ASN1Sequence.getInstance(paramASN1InputStream.readObject()));
  }
  
  private java.security.cert.Certificate readDERCertificate(ASN1InputStream paramASN1InputStream)
    throws IOException, CertificateParsingException
  {
    return getCertificate(ASN1Sequence.getInstance(paramASN1InputStream.readObject()));
  }
  
  private CRL readPEMCRL(InputStream paramInputStream)
    throws IOException, CRLException
  {
    return getCRL(PEM_CRL_PARSER.readPEMObject(paramInputStream));
  }
  
  private java.security.cert.Certificate readPEMCertificate(InputStream paramInputStream)
    throws IOException, CertificateParsingException
  {
    return getCertificate(PEM_CERT_PARSER.readPEMObject(paramInputStream));
  }
  
  protected CRL createCRL(CertificateList paramCertificateList)
    throws CRLException
  {
    return new X509CRLObject(this.bcHelper, paramCertificateList);
  }
  
  public CRL engineGenerateCRL(InputStream paramInputStream)
    throws CRLException
  {
    InputStream localInputStream = this.currentCrlStream;
    if (localInputStream == null) {}
    while (localInputStream != paramInputStream)
    {
      this.currentCrlStream = paramInputStream;
      this.sCrlData = null;
      this.sCrlDataObjectCount = 0;
      break;
    }
    try
    {
      if (this.sCrlData != null)
      {
        if (this.sCrlDataObjectCount != this.sCrlData.size()) {
          return getCRL();
        }
        this.sCrlData = null;
        this.sCrlDataObjectCount = 0;
        return null;
      }
      if (!paramInputStream.markSupported()) {
        paramInputStream = new ByteArrayInputStream(Streams.readAll(paramInputStream));
      }
      paramInputStream.mark(1);
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      paramInputStream.reset();
      if (i != 48) {
        return readPEMCRL(paramInputStream);
      }
      paramInputStream = readDERCRL(new ASN1InputStream(paramInputStream, true));
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      throw new CRLException(paramInputStream.toString());
    }
    catch (CRLException paramInputStream)
    {
      throw paramInputStream;
    }
  }
  
  public Collection engineGenerateCRLs(InputStream paramInputStream)
    throws CRLException
  {
    ArrayList localArrayList = new ArrayList();
    paramInputStream = new BufferedInputStream(paramInputStream);
    for (;;)
    {
      CRL localCRL = engineGenerateCRL(paramInputStream);
      if (localCRL == null) {
        break;
      }
      localArrayList.add(localCRL);
    }
    return localArrayList;
  }
  
  public CertPath engineGenerateCertPath(InputStream paramInputStream)
    throws CertificateException
  {
    return engineGenerateCertPath(paramInputStream, "PkiPath");
  }
  
  public CertPath engineGenerateCertPath(InputStream paramInputStream, String paramString)
    throws CertificateException
  {
    return new PKIXCertPath(paramInputStream, paramString);
  }
  
  public CertPath engineGenerateCertPath(List paramList)
    throws CertificateException
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject != null) && (!(localObject instanceof X509Certificate)))
      {
        paramList = new StringBuilder();
        paramList.append("list contains non X509Certificate object while creating CertPath\n");
        paramList.append(localObject.toString());
        throw new CertificateException(paramList.toString());
      }
    }
    return new PKIXCertPath(paramList);
  }
  
  public java.security.cert.Certificate engineGenerateCertificate(InputStream paramInputStream)
    throws CertificateException
  {
    InputStream localInputStream = this.currentStream;
    if (localInputStream == null) {}
    while (localInputStream != paramInputStream)
    {
      this.currentStream = paramInputStream;
      this.sData = null;
      this.sDataObjectCount = 0;
      break;
    }
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
      if (!paramInputStream.markSupported()) {
        paramInputStream = new ByteArrayInputStream(Streams.readAll(paramInputStream));
      }
      paramInputStream.mark(1);
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      paramInputStream.reset();
      if (i != 48) {
        return readPEMCertificate(paramInputStream);
      }
      paramInputStream = readDERCertificate(new ASN1InputStream(paramInputStream));
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      throw new ExCertificateException(paramInputStream);
    }
  }
  
  public Collection engineGenerateCertificates(InputStream paramInputStream)
    throws CertificateException
  {
    paramInputStream = new BufferedInputStream(paramInputStream);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      java.security.cert.Certificate localCertificate = engineGenerateCertificate(paramInputStream);
      if (localCertificate == null) {
        break;
      }
      localArrayList.add(localCertificate);
    }
    return localArrayList;
  }
  
  public Iterator engineGetCertPathEncodings()
  {
    return PKIXCertPath.certPathEncodings.iterator();
  }
  
  private class ExCertificateException
    extends CertificateException
  {
    private Throwable cause;
    
    public ExCertificateException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public ExCertificateException(Throwable paramThrowable)
    {
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\CertificateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */