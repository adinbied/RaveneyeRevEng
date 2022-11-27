package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERSet
  extends ASN1Set
{
  public BERSet() {}
  
  public BERSet(ASN1Encodable paramASN1Encodable)
  {
    super(paramASN1Encodable);
  }
  
  public BERSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector, false);
  }
  
  public BERSet(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    super(paramArrayOfASN1Encodable, false);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.write(49);
    paramASN1OutputStream.write(128);
    Enumeration localEnumeration = getObjects();
    while (localEnumeration.hasMoreElements()) {
      paramASN1OutputStream.writeObject((ASN1Encodable)localEnumeration.nextElement());
    }
    paramASN1OutputStream.write(0);
    paramASN1OutputStream.write(0);
  }
  
  int encodedLength()
    throws IOException
  {
    Enumeration localEnumeration = getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive().encodedLength();
    }
    return i + 2 + 2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */