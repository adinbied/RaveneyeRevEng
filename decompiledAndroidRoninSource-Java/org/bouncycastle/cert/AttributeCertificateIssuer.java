package org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AttCertIssuer;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.V2Form;
import org.bouncycastle.util.Selector;

public class AttributeCertificateIssuer
  implements Selector
{
  final ASN1Encodable form;
  
  public AttributeCertificateIssuer(X500Name paramX500Name)
  {
    this.form = new V2Form(new GeneralNames(new GeneralName(paramX500Name)));
  }
  
  public AttributeCertificateIssuer(AttCertIssuer paramAttCertIssuer)
  {
    this.form = paramAttCertIssuer.getIssuer();
  }
  
  private boolean matchesDN(X500Name paramX500Name, GeneralNames paramGeneralNames)
  {
    paramGeneralNames = paramGeneralNames.getNames();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      Object localObject = paramGeneralNames[i];
      if ((((GeneralName)localObject).getTagNo() == 4) && (X500Name.getInstance(((GeneralName)localObject).getName()).equals(paramX500Name))) {
        return true;
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
  
  public X500Name[] getNames()
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
    while (i != localObject.length)
    {
      if (localObject[i].getTagNo() == 4) {
        localArrayList.add(X500Name.getInstance(localObject[i].getName()));
      }
      i += 1;
    }
    return (X500Name[])localArrayList.toArray(new X500Name[localArrayList.size()]);
  }
  
  public int hashCode()
  {
    return this.form.hashCode();
  }
  
  public boolean match(Object paramObject)
  {
    boolean bool1 = paramObject instanceof X509CertificateHolder;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (X509CertificateHolder)paramObject;
    Object localObject = this.form;
    if ((localObject instanceof V2Form))
    {
      localObject = (V2Form)localObject;
      if (((V2Form)localObject).getBaseCertificateID() != null)
      {
        bool1 = bool2;
        if (((V2Form)localObject).getBaseCertificateID().getSerial().getValue().equals(((X509CertificateHolder)paramObject).getSerialNumber()))
        {
          bool1 = bool2;
          if (matchesDN(((X509CertificateHolder)paramObject).getIssuer(), ((V2Form)localObject).getBaseCertificateID().getIssuer())) {
            bool1 = true;
          }
        }
        return bool1;
      }
      localObject = ((V2Form)localObject).getIssuerName();
      if (matchesDN(((X509CertificateHolder)paramObject).getSubject(), (GeneralNames)localObject)) {
        return true;
      }
    }
    else
    {
      localObject = (GeneralNames)localObject;
      if (matchesDN(((X509CertificateHolder)paramObject).getSubject(), (GeneralNames)localObject)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\AttributeCertificateIssuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */