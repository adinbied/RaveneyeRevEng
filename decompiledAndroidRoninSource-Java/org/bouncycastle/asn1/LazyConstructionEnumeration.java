package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

class LazyConstructionEnumeration
  implements Enumeration
{
  private ASN1InputStream aIn;
  private Object nextObj;
  
  public LazyConstructionEnumeration(byte[] paramArrayOfByte)
  {
    this.aIn = new ASN1InputStream(paramArrayOfByte, true);
    this.nextObj = readObject();
  }
  
  private Object readObject()
  {
    try
    {
      ASN1Primitive localASN1Primitive = this.aIn.readObject();
      return localASN1Primitive;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed DER construction: ");
      localStringBuilder.append(localIOException);
      throw new ASN1ParsingException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public boolean hasMoreElements()
  {
    return this.nextObj != null;
  }
  
  public Object nextElement()
  {
    Object localObject = this.nextObj;
    this.nextObj = readObject();
    return localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\LazyConstructionEnumeration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */