package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

public class PKIXCertPath
  extends CertPath
{
  static final List certPathEncodings;
  private List certificates;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("PkiPath");
    localArrayList.add("PEM");
    localArrayList.add("PKCS7");
    certPathEncodings = Collections.unmodifiableList(localArrayList);
  }
  
  PKIXCertPath(InputStream paramInputStream, String paramString)
    throws CertificateException
  {
    super("X.509");
    try
    {
      Object localObject;
      if (paramString.equalsIgnoreCase("PkiPath"))
      {
        paramInputStream = new ASN1InputStream(paramInputStream).readObject();
        if ((paramInputStream instanceof ASN1Sequence))
        {
          paramInputStream = ((ASN1Sequence)paramInputStream).getObjects();
          this.certificates = new ArrayList();
          paramString = this.helper.createCertificateFactory("X.509");
          while (paramInputStream.hasMoreElements())
          {
            localObject = ((ASN1Encodable)paramInputStream.nextElement()).toASN1Primitive().getEncoded("DER");
            this.certificates.add(0, paramString.generateCertificate(new ByteArrayInputStream((byte[])localObject)));
          }
        }
        throw new CertificateException("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
      }
      if ((!paramString.equalsIgnoreCase("PKCS7")) && (!paramString.equalsIgnoreCase("PEM")))
      {
        paramInputStream = new StringBuilder();
        paramInputStream.append("unsupported encoding: ");
        paramInputStream.append(paramString);
        throw new CertificateException(paramInputStream.toString());
      }
      paramInputStream = new BufferedInputStream(paramInputStream);
      this.certificates = new ArrayList();
      paramString = this.helper.createCertificateFactory("X.509");
      for (;;)
      {
        localObject = paramString.generateCertificate(paramInputStream);
        if (localObject == null) {
          break;
        }
        this.certificates.add(localObject);
      }
      this.certificates = sortCerts(this.certificates);
      return;
    }
    catch (NoSuchProviderException paramInputStream)
    {
      paramString = new StringBuilder();
      paramString.append("BouncyCastle provider not found while trying to get a CertificateFactory:\n");
      paramString.append(paramInputStream.toString());
      throw new CertificateException(paramString.toString());
    }
    catch (IOException paramInputStream)
    {
      paramString = new StringBuilder();
      paramString.append("IOException throw while decoding CertPath:\n");
      paramString.append(paramInputStream.toString());
      throw new CertificateException(paramString.toString());
    }
  }
  
  PKIXCertPath(List paramList)
  {
    super("X.509");
    this.certificates = sortCerts(new ArrayList(paramList));
  }
  
  private List sortCerts(List paramList)
  {
    if (paramList.size() < 2) {
      return paramList;
    }
    Object localObject1 = ((X509Certificate)paramList.get(0)).getIssuerX500Principal();
    int i = 1;
    while (i != paramList.size()) {
      if (((X500Principal)localObject1).equals(((X509Certificate)paramList.get(i)).getSubjectX500Principal()))
      {
        localObject1 = ((X509Certificate)paramList.get(i)).getIssuerX500Principal();
        i += 1;
      }
      else
      {
        i = 0;
        break label89;
      }
    }
    i = 1;
    label89:
    if (i != 0) {
      return paramList;
    }
    localObject1 = new ArrayList(paramList.size());
    ArrayList localArrayList = new ArrayList(paramList);
    i = 0;
    Object localObject2;
    Object localObject3;
    int j;
    while (i < paramList.size())
    {
      localObject2 = (X509Certificate)paramList.get(i);
      localObject3 = ((X509Certificate)localObject2).getSubjectX500Principal();
      j = 0;
      while (j != paramList.size())
      {
        if (((X509Certificate)paramList.get(j)).getIssuerX500Principal().equals(localObject3))
        {
          j = 1;
          break label198;
        }
        j += 1;
      }
      j = 0;
      label198:
      if (j == 0)
      {
        ((List)localObject1).add(localObject2);
        paramList.remove(i);
      }
      i += 1;
    }
    if (((List)localObject1).size() > 1) {
      return localArrayList;
    }
    i = 0;
    while (i != ((List)localObject1).size())
    {
      localObject2 = ((X509Certificate)((List)localObject1).get(i)).getIssuerX500Principal();
      j = 0;
      while (j < paramList.size())
      {
        localObject3 = (X509Certificate)paramList.get(j);
        if (((X500Principal)localObject2).equals(((X509Certificate)localObject3).getSubjectX500Principal()))
        {
          ((List)localObject1).add(localObject3);
          paramList.remove(j);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    if (paramList.size() > 0) {
      return localArrayList;
    }
    return (List)localObject1;
  }
  
  private ASN1Primitive toASN1Object(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    try
    {
      paramX509Certificate = new ASN1InputStream(paramX509Certificate.getEncoded()).readObject();
      return paramX509Certificate;
    }
    catch (Exception paramX509Certificate)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception while encoding certificate: ");
      localStringBuilder.append(paramX509Certificate.toString());
      throw new CertificateEncodingException(localStringBuilder.toString());
    }
  }
  
  private byte[] toDEREncoded(ASN1Encodable paramASN1Encodable)
    throws CertificateEncodingException
  {
    try
    {
      paramASN1Encodable = paramASN1Encodable.toASN1Primitive().getEncoded("DER");
      return paramASN1Encodable;
    }
    catch (IOException paramASN1Encodable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception thrown: ");
      localStringBuilder.append(paramASN1Encodable);
      throw new CertificateEncodingException(localStringBuilder.toString());
    }
  }
  
  public List getCertificates()
  {
    return Collections.unmodifiableList(new ArrayList(this.certificates));
  }
  
  public byte[] getEncoded()
    throws CertificateEncodingException
  {
    Object localObject = getEncodings();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Iterator)localObject).next();
      if ((localObject instanceof String)) {
        return getEncoded((String)localObject);
      }
    }
    return null;
  }
  
  public byte[] getEncoded(String paramString)
    throws CertificateEncodingException
  {
    if (paramString.equalsIgnoreCase("PkiPath"))
    {
      paramString = new ASN1EncodableVector();
      localObject = this.certificates;
      localObject = ((List)localObject).listIterator(((List)localObject).size());
      while (((ListIterator)localObject).hasPrevious()) {
        paramString.add(toASN1Object((X509Certificate)((ListIterator)localObject).previous()));
      }
      return toDEREncoded(new DERSequence(paramString));
    }
    boolean bool = paramString.equalsIgnoreCase("PKCS7");
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramString = new ContentInfo(PKCSObjectIdentifiers.data, null);
      localObject = new ASN1EncodableVector();
      while (i != this.certificates.size())
      {
        ((ASN1EncodableVector)localObject).add(toASN1Object((X509Certificate)this.certificates.get(i)));
        i += 1;
      }
      paramString = new SignedData(new ASN1Integer(1L), new DERSet(), paramString, new DERSet((ASN1EncodableVector)localObject), null, new DERSet());
      return toDEREncoded(new ContentInfo(PKCSObjectIdentifiers.signedData, paramString));
    }
    if (paramString.equalsIgnoreCase("PEM"))
    {
      paramString = new ByteArrayOutputStream();
      localObject = new PemWriter(new OutputStreamWriter(paramString));
      i = j;
    }
    try
    {
      while (i != this.certificates.size())
      {
        ((PemWriter)localObject).writeObject(new PemObject("CERTIFICATE", ((X509Certificate)this.certificates.get(i)).getEncoded()));
        i += 1;
      }
      ((PemWriter)localObject).close();
      return paramString.toByteArray();
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported encoding: ");
    ((StringBuilder)localObject).append(paramString);
    throw new CertificateEncodingException(((StringBuilder)localObject).toString());
  }
  
  public Iterator getEncodings()
  {
    return certPathEncodings.iterator();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\PKIXCertPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */