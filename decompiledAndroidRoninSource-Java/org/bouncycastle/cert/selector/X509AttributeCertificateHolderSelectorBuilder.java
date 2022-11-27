package org.bouncycastle.cert.selector;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.cert.AttributeCertificateHolder;
import org.bouncycastle.cert.AttributeCertificateIssuer;
import org.bouncycastle.cert.X509AttributeCertificateHolder;

public class X509AttributeCertificateHolderSelectorBuilder
{
  private X509AttributeCertificateHolder attributeCert;
  private Date attributeCertificateValid;
  private AttributeCertificateHolder holder;
  private AttributeCertificateIssuer issuer;
  private BigInteger serialNumber;
  private Collection targetGroups = new HashSet();
  private Collection targetNames = new HashSet();
  
  private Set extractGeneralNames(Collection paramCollection)
    throws IOException
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      HashSet localHashSet = new HashSet();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localHashSet.add(GeneralName.getInstance(paramCollection.next()));
      }
      return localHashSet;
    }
    return new HashSet();
  }
  
  public void addTargetGroup(GeneralName paramGeneralName)
  {
    this.targetGroups.add(paramGeneralName);
  }
  
  public void addTargetName(GeneralName paramGeneralName)
  {
    this.targetNames.add(paramGeneralName);
  }
  
  public X509AttributeCertificateHolderSelector build()
  {
    return new X509AttributeCertificateHolderSelector(this.holder, this.issuer, this.serialNumber, this.attributeCertificateValid, this.attributeCert, Collections.unmodifiableCollection(new HashSet(this.targetNames)), Collections.unmodifiableCollection(new HashSet(this.targetGroups)));
  }
  
  public void setAttributeCert(X509AttributeCertificateHolder paramX509AttributeCertificateHolder)
  {
    this.attributeCert = paramX509AttributeCertificateHolder;
  }
  
  public void setAttributeCertificateValid(Date paramDate)
  {
    if (paramDate != null)
    {
      this.attributeCertificateValid = new Date(paramDate.getTime());
      return;
    }
    this.attributeCertificateValid = null;
  }
  
  public void setHolder(AttributeCertificateHolder paramAttributeCertificateHolder)
  {
    this.holder = paramAttributeCertificateHolder;
  }
  
  public void setIssuer(AttributeCertificateIssuer paramAttributeCertificateIssuer)
  {
    this.issuer = paramAttributeCertificateIssuer;
  }
  
  public void setSerialNumber(BigInteger paramBigInteger)
  {
    this.serialNumber = paramBigInteger;
  }
  
  public void setTargetGroups(Collection paramCollection)
    throws IOException
  {
    this.targetGroups = extractGeneralNames(paramCollection);
  }
  
  public void setTargetNames(Collection paramCollection)
    throws IOException
  {
    this.targetNames = extractGeneralNames(paramCollection);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\X509AttributeCertificateHolderSelectorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */