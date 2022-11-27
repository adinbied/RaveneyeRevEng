package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

public class ServiceType
  extends ASN1Object
{
  public static final ServiceType CCPD = new ServiceType(4);
  public static final ServiceType CPD = new ServiceType(1);
  public static final ServiceType VPKC;
  public static final ServiceType VSD = new ServiceType(2);
  private ASN1Enumerated value;
  
  static
  {
    VPKC = new ServiceType(3);
  }
  
  public ServiceType(int paramInt)
  {
    this.value = new ASN1Enumerated(paramInt);
  }
  
  private ServiceType(ASN1Enumerated paramASN1Enumerated)
  {
    this.value = paramASN1Enumerated;
  }
  
  public static ServiceType getInstance(Object paramObject)
  {
    if ((paramObject instanceof ServiceType)) {
      return (ServiceType)paramObject;
    }
    if (paramObject != null) {
      return new ServiceType(ASN1Enumerated.getInstance(paramObject));
    }
    return null;
  }
  
  public static ServiceType getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Enumerated.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getValue()
  {
    return this.value.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.value;
  }
  
  public String toString()
  {
    int i = this.value.getValue().intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    String str;
    if (i == CPD.getValue().intValue()) {
      str = "(CPD)";
    } else if (i == VSD.getValue().intValue()) {
      str = "(VSD)";
    } else if (i == VPKC.getValue().intValue()) {
      str = "(VPKC)";
    } else if (i == CCPD.getValue().intValue()) {
      str = "(CCPD)";
    } else {
      str = "?";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\ServiceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */