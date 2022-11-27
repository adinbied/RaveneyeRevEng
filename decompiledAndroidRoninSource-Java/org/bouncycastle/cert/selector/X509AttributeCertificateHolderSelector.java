package org.bouncycastle.cert.selector;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.Target;
import org.bouncycastle.asn1.x509.TargetInformation;
import org.bouncycastle.asn1.x509.Targets;
import org.bouncycastle.cert.AttributeCertificateHolder;
import org.bouncycastle.cert.AttributeCertificateIssuer;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.util.Selector;

public class X509AttributeCertificateHolderSelector
  implements Selector
{
  private final X509AttributeCertificateHolder attributeCert;
  private final Date attributeCertificateValid;
  private final AttributeCertificateHolder holder;
  private final AttributeCertificateIssuer issuer;
  private final BigInteger serialNumber;
  private final Collection targetGroups;
  private final Collection targetNames;
  
  X509AttributeCertificateHolderSelector(AttributeCertificateHolder paramAttributeCertificateHolder, AttributeCertificateIssuer paramAttributeCertificateIssuer, BigInteger paramBigInteger, Date paramDate, X509AttributeCertificateHolder paramX509AttributeCertificateHolder, Collection paramCollection1, Collection paramCollection2)
  {
    this.holder = paramAttributeCertificateHolder;
    this.issuer = paramAttributeCertificateIssuer;
    this.serialNumber = paramBigInteger;
    this.attributeCertificateValid = paramDate;
    this.attributeCert = paramX509AttributeCertificateHolder;
    this.targetNames = paramCollection1;
    this.targetGroups = paramCollection2;
  }
  
  public Object clone()
  {
    return new X509AttributeCertificateHolderSelector(this.holder, this.issuer, this.serialNumber, this.attributeCertificateValid, this.attributeCert, this.targetNames, this.targetGroups);
  }
  
  public X509AttributeCertificateHolder getAttributeCert()
  {
    return this.attributeCert;
  }
  
  public Date getAttributeCertificateValid()
  {
    if (this.attributeCertificateValid != null) {
      return new Date(this.attributeCertificateValid.getTime());
    }
    return null;
  }
  
  public AttributeCertificateHolder getHolder()
  {
    return this.holder;
  }
  
  public AttributeCertificateIssuer getIssuer()
  {
    return this.issuer;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public Collection getTargetGroups()
  {
    return this.targetGroups;
  }
  
  public Collection getTargetNames()
  {
    return this.targetNames;
  }
  
  public boolean match(Object paramObject)
  {
    if (!(paramObject instanceof X509AttributeCertificateHolder)) {
      return false;
    }
    paramObject = (X509AttributeCertificateHolder)paramObject;
    Object localObject = this.attributeCert;
    if ((localObject != null) && (!((X509AttributeCertificateHolder)localObject).equals(paramObject))) {
      return false;
    }
    if ((this.serialNumber != null) && (!((X509AttributeCertificateHolder)paramObject).getSerialNumber().equals(this.serialNumber))) {
      return false;
    }
    if ((this.holder != null) && (!((X509AttributeCertificateHolder)paramObject).getHolder().equals(this.holder))) {
      return false;
    }
    if ((this.issuer != null) && (!((X509AttributeCertificateHolder)paramObject).getIssuer().equals(this.issuer))) {
      return false;
    }
    localObject = this.attributeCertificateValid;
    if ((localObject != null) && (!((X509AttributeCertificateHolder)paramObject).isValidOn((Date)localObject))) {
      return false;
    }
    if ((!this.targetNames.isEmpty()) || (!this.targetGroups.isEmpty()))
    {
      paramObject = ((X509AttributeCertificateHolder)paramObject).getExtension(Extension.targetInformation);
      if (paramObject == null) {}
    }
    try
    {
      paramObject = TargetInformation.getInstance(((Extension)paramObject).getParsedValue());
      paramObject = ((TargetInformation)paramObject).getTargetsObjects();
      int i;
      int j;
      int m;
      int k;
      if (!this.targetNames.isEmpty())
      {
        i = 0;
        for (j = 0; i < paramObject.length; j = k)
        {
          localObject = paramObject[i].getTargets();
          m = 0;
          for (;;)
          {
            k = j;
            if (m >= localObject.length) {
              break;
            }
            if (this.targetNames.contains(GeneralName.getInstance(localObject[m].getTargetName())))
            {
              k = 1;
              break;
            }
            m += 1;
          }
          i += 1;
        }
        if (j == 0) {
          return false;
        }
      }
      if (!this.targetGroups.isEmpty())
      {
        i = 0;
        for (j = 0; i < paramObject.length; j = k)
        {
          localObject = paramObject[i].getTargets();
          m = 0;
          for (;;)
          {
            k = j;
            if (m >= localObject.length) {
              break;
            }
            if (this.targetGroups.contains(GeneralName.getInstance(localObject[m].getTargetGroup())))
            {
              k = 1;
              break;
            }
            m += 1;
          }
          i += 1;
        }
        if (j == 0) {
          return false;
        }
      }
      return true;
    }
    catch (IllegalArgumentException paramObject) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\selector\X509AttributeCertificateHolderSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */