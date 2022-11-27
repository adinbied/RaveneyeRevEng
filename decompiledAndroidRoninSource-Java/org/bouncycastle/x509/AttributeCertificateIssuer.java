package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AttCertIssuer;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.V2Form;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Selector;

public class AttributeCertificateIssuer
  implements CertSelector, Selector
{
  final ASN1Encodable form;
  
  public AttributeCertificateIssuer(X500Principal paramX500Principal)
    throws IOException
  {
    this(new X509Principal(paramX500Principal.getEncoded()));
  }
  
  public AttributeCertificateIssuer(AttCertIssuer paramAttCertIssuer)
  {
    this.form = paramAttCertIssuer.getIssuer();
  }
  
  public AttributeCertificateIssuer(X509Principal paramX509Principal)
  {
    this.form = new V2Form(GeneralNames.getInstance(new DERSequence(new GeneralName(paramX509Principal))));
  }
  
  private Object[] getNames()
  {
    Object localObject = this.form;
    if ((localObject instanceof V2Form)) {
      localObject = ((V2Form)localObject).getIssuerName();
    } else {
      localObject = (GeneralNames)localObject;
    }
    localObject = ((GeneralNames)localObject).getNames();
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i = 0;
    for (;;)
    {
      if ((i == localObject.length) || (localObject[i].getTagNo() == 4)) {}
      try
      {
        localArrayList.add(new X500Principal(localObject[i].getName().toASN1Primitive().getEncoded()));
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      throw new RuntimeException("badly formed Name object");
      i += 1;
    }
    return localArrayList.toArray(new Object[localArrayList.size()]);
  }
  
  private boolean matchesDN(X500Principal paramX500Principal, GeneralNames paramGeneralNames)
  {
    paramGeneralNames = paramGeneralNames.getNames();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      Object localObject = paramGeneralNames[i];
      if (((GeneralName)localObject).getTagNo() == 4) {}
      try
      {
        boolean bool = new X500Principal(((GeneralName)localObject).getName().toASN1Primitive().getEncoded()).equals(paramX500Principal);
        if (bool) {
          return true;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return false;
  }
  
  public Object clone()
  {
    return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.form));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof AttributeCertificateIssuer)) {
      return false;
    }
    paramObject = (AttributeCertificateIssuer)paramObject;
    return this.form.equals(((AttributeCertificateIssuer)paramObject).form);
  }
  
  public Principal[] getPrincipals()
  {
    Object[] arrayOfObject = getNames();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != arrayOfObject.length)
    {
      if ((arrayOfObject[i] instanceof Principal)) {
        localArrayList.add(arrayOfObject[i]);
      }
      i += 1;
    }
    return (Principal[])localArrayList.toArray(new Principal[localArrayList.size()]);
  }
  
  public int hashCode()
  {
    return this.form.hashCode();
  }
  
  public boolean match(Object paramObject)
  {
    if (!(paramObject instanceof X509Certificate)) {
      return false;
    }
    return match((Certificate)paramObject);
  }
  
  public boolean match(Certificate paramCertificate)
  {
    boolean bool1 = paramCertificate instanceof X509Certificate;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramCertificate = (X509Certificate)paramCertificate;
    Object localObject = this.form;
    if ((localObject instanceof V2Form))
    {
      localObject = (V2Form)localObject;
      if (((V2Form)localObject).getBaseCertificateID() != null)
      {
        bool1 = bool2;
        if (((V2Form)localObject).getBaseCertificateID().getSerial().getValue().equals(paramCertificate.getSerialNumber()))
        {
          bool1 = bool2;
          if (matchesDN(paramCertificate.getIssuerX500Principal(), ((V2Form)localObject).getBaseCertificateID().getIssuer())) {
            bool1 = true;
          }
        }
        return bool1;
      }
      localObject = ((V2Form)localObject).getIssuerName();
      if (matchesDN(paramCertificate.getSubjectX500Principal(), (GeneralNames)localObject)) {
        return true;
      }
    }
    else
    {
      localObject = (GeneralNames)localObject;
      if (matchesDN(paramCertificate.getSubjectX500Principal(), (GeneralNames)localObject)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\AttributeCertificateIssuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */