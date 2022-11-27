package org.bouncycastle.voms;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.IetfAttrSyntax;
import org.bouncycastle.cert.X509AttributeCertificateHolder;

public class VOMSAttribute
{
  public static final String VOMS_ATTR_OID = "1.3.6.1.4.1.8005.100.100.4";
  private X509AttributeCertificateHolder myAC;
  private List myFQANs = new ArrayList();
  private String myHostPort;
  private List myStringList = new ArrayList();
  private String myVo;
  
  public VOMSAttribute(X509AttributeCertificateHolder paramX509AttributeCertificateHolder)
  {
    Object localObject1;
    int i;
    if (paramX509AttributeCertificateHolder != null)
    {
      this.myAC = paramX509AttributeCertificateHolder;
      localObject1 = paramX509AttributeCertificateHolder.getAttributes(new ASN1ObjectIdentifier("1.3.6.1.4.1.8005.100.100.4"));
      if (localObject1 == null) {
        return;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i == localObject1.length) {
          continue;
        }
        localObject3 = IetfAttrSyntax.getInstance(localObject1[i].getAttributeValues()[0]);
        localObject2 = ((DERIA5String)localObject3.getPolicyAuthority().getNames()[0].getName()).getString();
        j = ((String)localObject2).indexOf("://");
        if ((j < 0) || (j == ((String)localObject2).length() - 1)) {
          continue;
        }
        this.myVo = ((String)localObject2).substring(0, j);
        this.myHostPort = ((String)localObject2).substring(j + 3);
        if (((IetfAttrSyntax)localObject3).getValueType() != 1) {
          continue;
        }
        localObject2 = (ASN1OctetString[])((IetfAttrSyntax)localObject3).getValues();
        j = 0;
      }
      catch (IllegalArgumentException paramX509AttributeCertificateHolder)
      {
        Object localObject3;
        Object localObject2;
        FQAN localFQAN;
        StringBuilder localStringBuilder;
        throw paramX509AttributeCertificateHolder;
        throw new IllegalArgumentException("VOMSAttribute: AttributeCertificate is NULL");
      }
      catch (Exception localException)
      {
        int j;
        continue;
        j += 1;
        continue;
        i += 1;
      }
      if (j != localObject2.length)
      {
        localObject3 = new String(localObject2[j].getOctets());
        localFQAN = new FQAN((String)localObject3);
        if (!this.myStringList.contains(localObject3))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("/");
          localStringBuilder.append(this.myVo);
          localStringBuilder.append("/");
          if (((String)localObject3).startsWith(localStringBuilder.toString()))
          {
            this.myStringList.add(localObject3);
            this.myFQANs.add(localFQAN);
            continue;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("VOMS attribute values are not encoded as octet strings, policyAuthority = ");
            ((StringBuilder)localObject1).append((String)localObject2);
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Bad encoding of VOMS policyAuthority : [");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("]");
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
            return;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Badly encoded VOMS extension in AC issued by ");
            ((StringBuilder)localObject1).append(paramX509AttributeCertificateHolder.getIssuer());
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  public X509AttributeCertificateHolder getAC()
  {
    return this.myAC;
  }
  
  public List getFullyQualifiedAttributes()
  {
    return this.myStringList;
  }
  
  public String getHostPort()
  {
    return this.myHostPort;
  }
  
  public List getListOfFQAN()
  {
    return this.myFQANs;
  }
  
  public String getVO()
  {
    return this.myVo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VO      :");
    localStringBuilder.append(this.myVo);
    localStringBuilder.append("\n");
    localStringBuilder.append("HostPort:");
    localStringBuilder.append(this.myHostPort);
    localStringBuilder.append("\n");
    localStringBuilder.append("FQANs   :");
    localStringBuilder.append(this.myFQANs);
    return localStringBuilder.toString();
  }
  
  public class FQAN
  {
    String capability;
    String fqan;
    String group;
    String role;
    
    public FQAN(String paramString)
    {
      this.fqan = paramString;
    }
    
    public FQAN(String paramString1, String paramString2, String paramString3)
    {
      this.group = paramString1;
      this.role = paramString2;
      this.capability = paramString3;
    }
    
    public String getCapability()
    {
      if ((this.group == null) && (this.fqan != null)) {
        split();
      }
      return this.capability;
    }
    
    public String getFQAN()
    {
      Object localObject = this.fqan;
      if (localObject != null) {
        return (String)localObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.group);
      localStringBuilder.append("/Role=");
      localObject = this.role;
      String str = "";
      if (localObject == null) {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localObject = str;
      if (this.capability != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("/Capability=");
        ((StringBuilder)localObject).append(this.capability);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      this.fqan = ((String)localObject);
      return (String)localObject;
    }
    
    public String getGroup()
    {
      if ((this.group == null) && (this.fqan != null)) {
        split();
      }
      return this.group;
    }
    
    public String getRole()
    {
      if ((this.group == null) && (this.fqan != null)) {
        split();
      }
      return this.role;
    }
    
    protected void split()
    {
      this.fqan.length();
      int i = this.fqan.indexOf("/Role=");
      if (i < 0) {
        return;
      }
      this.group = this.fqan.substring(0, i);
      String str = this.fqan;
      int j = i + 6;
      i = str.indexOf("/Capability=", j);
      str = this.fqan;
      if (i < 0) {
        str = str.substring(j);
      } else {
        str = str.substring(j, i);
      }
      j = str.length();
      Object localObject2 = null;
      if (j == 0) {
        str = null;
      }
      this.role = str;
      if (i < 0) {
        str = null;
      } else {
        str = this.fqan.substring(i + 12);
      }
      Object localObject1 = localObject2;
      if (str != null) {
        if (str.length() == 0) {
          localObject1 = localObject2;
        } else {
          localObject1 = str;
        }
      }
      this.capability = ((String)localObject1);
    }
    
    public String toString()
    {
      return getFQAN();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\voms\VOMSAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */