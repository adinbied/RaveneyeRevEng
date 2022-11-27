package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DERSet
  extends ASN1Set
{
  private int bodyLength = -1;
  
  public DERSet() {}
  
  public DERSet(ASN1Encodable paramASN1Encodable)
  {
    super(paramASN1Encodable);
  }
  
  public DERSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector, true);
  }
  
  DERSet(ASN1EncodableVector paramASN1EncodableVector, boolean paramBoolean)
  {
    super(paramASN1EncodableVector, paramBoolean);
  }
  
  public DERSet(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    super(paramArrayOfASN1Encodable, true);
  }
  
  private int getBodyLength()
    throws IOException
  {
    if (this.bodyLength < 0)
    {
      int i = 0;
      Enumeration localEnumeration = getObjects();
      while (localEnumeration.hasMoreElements()) {
        i += ((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive().toDERObject().encodedLength();
      }
      this.bodyLength = i;
    }
    return this.bodyLength;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    ASN1OutputStream localASN1OutputStream = paramASN1OutputStream.getDERSubStream();
    int i = getBodyLength();
    paramASN1OutputStream.write(49);
    paramASN1OutputStream.writeLength(i);
    paramASN1OutputStream = getObjects();
    while (paramASN1OutputStream.hasMoreElements()) {
      localASN1OutputStream.writeObject((ASN1Encodable)paramASN1OutputStream.nextElement());
    }
  }
  
  int encodedLength()
    throws IOException
  {
    int i = getBodyLength();
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */