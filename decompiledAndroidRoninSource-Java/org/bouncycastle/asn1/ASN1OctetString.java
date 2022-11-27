package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public abstract class ASN1OctetString
  extends ASN1Primitive
  implements ASN1OctetStringParser
{
  byte[] string;
  
  public ASN1OctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.string = paramArrayOfByte;
      return;
    }
    throw new NullPointerException("string cannot be null");
  }
  
  public static ASN1OctetString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1OctetString)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
          return (ASN1OctetString)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to construct OCTET STRING from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1OctetString)) {
          return (ASN1OctetString)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegal object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (ASN1OctetString)paramObject;
  }
  
  public static ASN1OctetString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof ASN1OctetString))) {
      return BEROctetString.fromSequence(ASN1Sequence.getInstance(paramASN1TaggedObject));
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1OctetString)) {
      return false;
    }
    paramASN1Primitive = (ASN1OctetString)paramASN1Primitive;
    return Arrays.areEqual(this.string, paramASN1Primitive.string);
  }
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public ASN1Primitive getLoadedObject()
  {
    return toASN1Primitive();
  }
  
  public InputStream getOctetStream()
  {
    return new ByteArrayInputStream(this.string);
  }
  
  public byte[] getOctets()
  {
    return this.string;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(getOctets());
  }
  
  public ASN1OctetStringParser parser()
  {
    return this;
  }
  
  ASN1Primitive toDERObject()
  {
    return new DEROctetString(this.string);
  }
  
  ASN1Primitive toDLObject()
  {
    return new DEROctetString(this.string);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(Strings.fromByteArray(Hex.encode(this.string)));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1OctetString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */