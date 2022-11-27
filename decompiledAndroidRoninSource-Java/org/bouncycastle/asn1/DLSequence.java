package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DLSequence
  extends ASN1Sequence
{
  private int bodyLength = -1;
  
  public DLSequence() {}
  
  public DLSequence(ASN1Encodable paramASN1Encodable)
  {
    super(paramASN1Encodable);
  }
  
  public DLSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector);
  }
  
  public DLSequence(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    super(paramArrayOfASN1Encodable);
  }
  
  private int getBodyLength()
    throws IOException
  {
    if (this.bodyLength < 0)
    {
      int i = 0;
      Enumeration localEnumeration = getObjects();
      while (localEnumeration.hasMoreElements()) {
        i += ((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive().toDLObject().encodedLength();
      }
      this.bodyLength = i;
    }
    return this.bodyLength;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    ASN1OutputStream localASN1OutputStream = paramASN1OutputStream.getDLSubStream();
    int i = getBodyLength();
    paramASN1OutputStream.write(48);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DLSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */