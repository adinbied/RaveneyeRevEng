package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

public class X962Parameters
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Primitive params = null;
  
  public X962Parameters(ASN1Null paramASN1Null)
  {
    this.params = paramASN1Null;
  }
  
  public X962Parameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.params = paramASN1ObjectIdentifier;
  }
  
  public X962Parameters(ASN1Primitive paramASN1Primitive)
  {
    this.params = paramASN1Primitive;
  }
  
  public X962Parameters(X9ECParameters paramX9ECParameters)
  {
    this.params = paramX9ECParameters.toASN1Primitive();
  }
  
  public static X962Parameters getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof X962Parameters)))
    {
      if ((paramObject instanceof ASN1Primitive)) {
        return new X962Parameters((ASN1Primitive)paramObject);
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = new X962Parameters(ASN1Primitive.fromByteArray((byte[])paramObject));
          return (X962Parameters)paramObject;
        }
        catch (Exception paramObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unable to parse encoded data: ");
          localStringBuilder.append(((Exception)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      throw new IllegalArgumentException("unknown object in getInstance()");
    }
    return (X962Parameters)paramObject;
  }
  
  public static X962Parameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public ASN1Primitive getParameters()
  {
    return this.params;
  }
  
  public boolean isImplicitlyCA()
  {
    return this.params instanceof ASN1Null;
  }
  
  public boolean isNamedCurve()
  {
    return this.params instanceof ASN1ObjectIdentifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X962Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */