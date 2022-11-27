package org.bouncycastle.asn1;

import java.io.IOException;

public class DERTaggedObject
  extends ASN1TaggedObject
{
  private static final byte[] ZERO_BYTES = new byte[0];
  
  public DERTaggedObject(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(true, paramInt, paramASN1Encodable);
  }
  
  public DERTaggedObject(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(paramBoolean, paramInt, paramASN1Encodable);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    boolean bool = this.empty;
    int i = 160;
    if (!bool)
    {
      ASN1Primitive localASN1Primitive = this.obj.toASN1Primitive().toDERObject();
      if (this.explicit)
      {
        paramASN1OutputStream.writeTag(160, this.tagNo);
        paramASN1OutputStream.writeLength(localASN1Primitive.encodedLength());
        paramASN1OutputStream.writeObject(localASN1Primitive);
        return;
      }
      if (!localASN1Primitive.isConstructed()) {
        i = 128;
      }
      paramASN1OutputStream.writeTag(i, this.tagNo);
      paramASN1OutputStream.writeImplicitObject(localASN1Primitive);
      return;
    }
    paramASN1OutputStream.writeEncoded(160, this.tagNo, ZERO_BYTES);
  }
  
  int encodedLength()
    throws IOException
  {
    if (!this.empty)
    {
      int i = this.obj.toASN1Primitive().toDERObject().encodedLength();
      if (this.explicit) {}
      for (int j = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(i);; j = StreamUtil.calculateTagLength(this.tagNo))
      {
        return j + i;
        i -= 1;
      }
    }
    return StreamUtil.calculateTagLength(this.tagNo) + 1;
  }
  
  boolean isConstructed()
  {
    if (!this.empty)
    {
      if (this.explicit) {
        return true;
      }
      return this.obj.toASN1Primitive().toDERObject().isConstructed();
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERTaggedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */