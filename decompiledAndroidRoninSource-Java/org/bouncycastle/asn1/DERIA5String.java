package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class DERIA5String
  extends ASN1Primitive
  implements ASN1String
{
  private final byte[] string;
  
  public DERIA5String(String paramString)
  {
    this(paramString, false);
  }
  
  public DERIA5String(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if ((paramBoolean) && (!isIA5String(paramString))) {
        throw new IllegalArgumentException("string contains illegal characters");
      }
      this.string = Strings.toByteArray(paramString);
      return;
    }
    throw new NullPointerException("string cannot be null");
  }
  
  DERIA5String(byte[] paramArrayOfByte)
  {
    this.string = paramArrayOfByte;
  }
  
  public static DERIA5String getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERIA5String)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERIA5String)fromByteArray((byte[])paramObject);
          return (DERIA5String)paramObject;
        }
        catch (Exception paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoding error in getInstance: ");
          localStringBuilder.append(((Exception)paramObject).toString());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DERIA5String)paramObject;
  }
  
  public static DERIA5String getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERIA5String))) {
      return new DERIA5String(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  public static boolean isIA5String(String paramString)
  {
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      if (paramString.charAt(i) > '') {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERIA5String)) {
      return false;
    }
    paramASN1Primitive = (DERIA5String)paramASN1Primitive;
    return Arrays.areEqual(this.string, paramASN1Primitive.string);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(22, this.string);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
  }
  
  public byte[] getOctets()
  {
    return Arrays.clone(this.string);
  }
  
  public String getString()
  {
    return Strings.fromByteArray(this.string);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.string);
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERIA5String.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */