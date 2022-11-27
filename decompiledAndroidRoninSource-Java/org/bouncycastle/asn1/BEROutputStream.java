package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROutputStream
  extends DEROutputStream
{
  public BEROutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void writeObject(Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      writeNull();
      return;
    }
    if ((paramObject instanceof ASN1Primitive)) {}
    for (paramObject = (ASN1Primitive)paramObject;; paramObject = ((ASN1Encodable)paramObject).toASN1Primitive())
    {
      ((ASN1Primitive)paramObject).encode(this);
      return;
      if (!(paramObject instanceof ASN1Encodable)) {
        break;
      }
    }
    throw new IOException("object not BEREncodable");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BEROutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */