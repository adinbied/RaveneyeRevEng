package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

class LazyEncodedSequence
  extends ASN1Sequence
{
  private byte[] encoded;
  
  LazyEncodedSequence(byte[] paramArrayOfByte)
    throws IOException
  {
    this.encoded = paramArrayOfByte;
  }
  
  private void parse()
  {
    LazyConstructionEnumeration localLazyConstructionEnumeration = new LazyConstructionEnumeration(this.encoded);
    while (localLazyConstructionEnumeration.hasMoreElements()) {
      this.seq.addElement(localLazyConstructionEnumeration.nextElement());
    }
    this.encoded = null;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    byte[] arrayOfByte = this.encoded;
    if (arrayOfByte != null)
    {
      paramASN1OutputStream.writeEncoded(48, arrayOfByte);
      return;
    }
    super.toDLObject().encode(paramASN1OutputStream);
  }
  
  int encodedLength()
    throws IOException
  {
    byte[] arrayOfByte = this.encoded;
    if (arrayOfByte != null) {
      return StreamUtil.calculateBodyLength(arrayOfByte.length) + 1 + this.encoded.length;
    }
    return super.toDLObject().encodedLength();
  }
  
  public ASN1Encodable getObjectAt(int paramInt)
  {
    try
    {
      if (this.encoded != null) {
        parse();
      }
      ASN1Encodable localASN1Encodable = super.getObjectAt(paramInt);
      return localASN1Encodable;
    }
    finally {}
  }
  
  public Enumeration getObjects()
  {
    try
    {
      if (this.encoded == null)
      {
        localObject1 = super.getObjects();
        return (Enumeration)localObject1;
      }
      Object localObject1 = new LazyConstructionEnumeration(this.encoded);
      return (Enumeration)localObject1;
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      if (this.encoded != null) {
        parse();
      }
      int i = super.size();
      return i;
    }
    finally {}
  }
  
  ASN1Primitive toDERObject()
  {
    if (this.encoded != null) {
      parse();
    }
    return super.toDERObject();
  }
  
  ASN1Primitive toDLObject()
  {
    if (this.encoded != null) {
      parse();
    }
    return super.toDLObject();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\LazyEncodedSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */