package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream
  extends ASN1OutputStream
{
  public DEROutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  ASN1OutputStream getDERSubStream()
  {
    return this;
  }
  
  ASN1OutputStream getDLSubStream()
  {
    return this;
  }
  
  public void writeObject(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null)
    {
      paramASN1Encodable.toASN1Primitive().toDERObject().encode(this);
      return;
    }
    throw new IOException("null object detected");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DEROutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */