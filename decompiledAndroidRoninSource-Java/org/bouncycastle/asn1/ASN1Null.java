package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Null
  extends ASN1Primitive
{
  public static ASN1Null getInstance(Object paramObject)
  {
    if ((paramObject instanceof ASN1Null)) {
      return (ASN1Null)paramObject;
    }
    if (paramObject != null) {}
    try
    {
      localObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (ASN1Null)localObject;
    }
    catch (IOException paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed to construct NULL from byte[]: ");
      ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      return null;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance(): ");
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    return (paramASN1Primitive instanceof ASN1Null);
  }
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public int hashCode()
  {
    return -1;
  }
  
  public String toString()
  {
    return "NULL";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Null.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */