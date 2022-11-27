package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class BodyPartID
  extends ASN1Object
{
  public static final long bodyIdMax = 4294967295L;
  private final long id;
  
  public BodyPartID(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L))
    {
      this.id = paramLong;
      return;
    }
    throw new IllegalArgumentException("id out of range");
  }
  
  private BodyPartID(ASN1Integer paramASN1Integer)
  {
    this(convert(paramASN1Integer.getValue()));
  }
  
  private static long convert(BigInteger paramBigInteger)
  {
    if (paramBigInteger.bitLength() <= 32) {
      return paramBigInteger.longValue();
    }
    throw new IllegalArgumentException("id out of range");
  }
  
  public static BodyPartID getInstance(Object paramObject)
  {
    if ((paramObject instanceof BodyPartID)) {
      return (BodyPartID)paramObject;
    }
    if (paramObject != null) {
      return new BodyPartID(ASN1Integer.getInstance(paramObject));
    }
    return null;
  }
  
  public long getID()
  {
    return this.id;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new ASN1Integer(this.id);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\BodyPartID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */