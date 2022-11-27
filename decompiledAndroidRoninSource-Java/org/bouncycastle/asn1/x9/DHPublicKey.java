package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

public class DHPublicKey
  extends ASN1Object
{
  private ASN1Integer y;
  
  public DHPublicKey(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null)
    {
      this.y = new ASN1Integer(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("'y' cannot be null");
  }
  
  private DHPublicKey(ASN1Integer paramASN1Integer)
  {
    if (paramASN1Integer != null)
    {
      this.y = paramASN1Integer;
      return;
    }
    throw new IllegalArgumentException("'y' cannot be null");
  }
  
  public static DHPublicKey getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DHPublicKey)))
    {
      if ((paramObject instanceof ASN1Integer)) {
        return new DHPublicKey((ASN1Integer)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid DHPublicKey: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DHPublicKey)paramObject;
  }
  
  public static DHPublicKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Integer.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getY()
  {
    return this.y.getPositiveValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.y;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\DHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */