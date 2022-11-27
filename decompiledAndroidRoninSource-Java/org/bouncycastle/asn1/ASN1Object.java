package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Encodable;

public abstract class ASN1Object
  implements ASN1Encodable, Encodable
{
  protected static boolean hasEncodedTagValue(Object paramObject, int paramInt)
  {
    boolean bool3 = paramObject instanceof byte[];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((byte[])(byte[])paramObject)[0] == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ASN1Encodable)) {
      return false;
    }
    paramObject = (ASN1Encodable)paramObject;
    return toASN1Primitive().equals(((ASN1Encodable)paramObject).toASN1Primitive());
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ASN1OutputStream(localByteArrayOutputStream).writeObject(this);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] getEncoded(String paramString)
    throws IOException
  {
    if (paramString.equals("DER"))
    {
      paramString = new ByteArrayOutputStream();
      new DEROutputStream(paramString).writeObject(this);
    }
    for (;;)
    {
      return paramString.toByteArray();
      if (!paramString.equals("DL")) {
        break;
      }
      paramString = new ByteArrayOutputStream();
      new DLOutputStream(paramString).writeObject(this);
    }
    return getEncoded();
  }
  
  public int hashCode()
  {
    return toASN1Primitive().hashCode();
  }
  
  public ASN1Primitive toASN1Object()
  {
    return toASN1Primitive();
  }
  
  public abstract ASN1Primitive toASN1Primitive();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Object.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */