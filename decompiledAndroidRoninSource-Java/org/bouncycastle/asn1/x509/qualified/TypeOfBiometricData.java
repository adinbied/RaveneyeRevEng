package org.bouncycastle.asn1.x509.qualified;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

public class TypeOfBiometricData
  extends ASN1Object
  implements ASN1Choice
{
  public static final int HANDWRITTEN_SIGNATURE = 1;
  public static final int PICTURE = 0;
  ASN1Encodable obj;
  
  public TypeOfBiometricData(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknow PredefinedBiometricType : ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.obj = new ASN1Integer(paramInt);
  }
  
  public TypeOfBiometricData(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.obj = paramASN1ObjectIdentifier;
  }
  
  public static TypeOfBiometricData getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof TypeOfBiometricData)))
    {
      if ((paramObject instanceof ASN1Integer)) {
        return new TypeOfBiometricData(ASN1Integer.getInstance(paramObject).getValue().intValue());
      }
      if ((paramObject instanceof ASN1ObjectIdentifier)) {
        return new TypeOfBiometricData(ASN1ObjectIdentifier.getInstance(paramObject));
      }
      throw new IllegalArgumentException("unknown object in getInstance");
    }
    return (TypeOfBiometricData)paramObject;
  }
  
  public ASN1ObjectIdentifier getBiometricDataOid()
  {
    return (ASN1ObjectIdentifier)this.obj;
  }
  
  public int getPredefinedBiometricType()
  {
    return ((ASN1Integer)this.obj).getValue().intValue();
  }
  
  public boolean isPredefined()
  {
    return this.obj instanceof ASN1Integer;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.obj.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\TypeOfBiometricData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */