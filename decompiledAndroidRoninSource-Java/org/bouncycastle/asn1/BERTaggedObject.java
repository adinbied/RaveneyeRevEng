package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject
  extends ASN1TaggedObject
{
  public BERTaggedObject(int paramInt)
  {
    super(false, paramInt, new BERSequence());
  }
  
  public BERTaggedObject(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(true, paramInt, paramASN1Encodable);
  }
  
  public BERTaggedObject(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(paramBoolean, paramInt, paramASN1Encodable);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeTag(160, this.tagNo);
    paramASN1OutputStream.write(128);
    if (!this.empty)
    {
      if (!this.explicit)
      {
        Enumeration localEnumeration;
        if ((this.obj instanceof ASN1OctetString))
        {
          if ((this.obj instanceof BEROctetString)) {
            localEnumeration = ((BEROctetString)this.obj).getObjects();
          } else {
            localEnumeration = new BEROctetString(((ASN1OctetString)this.obj).getOctets()).getObjects();
          }
        }
        else if ((this.obj instanceof ASN1Sequence))
        {
          localEnumeration = ((ASN1Sequence)this.obj).getObjects();
        }
        else
        {
          if (!(this.obj instanceof ASN1Set)) {
            break label160;
          }
          localEnumeration = ((ASN1Set)this.obj).getObjects();
        }
        while (localEnumeration.hasMoreElements()) {
          paramASN1OutputStream.writeObject((ASN1Encodable)localEnumeration.nextElement());
        }
        label160:
        paramASN1OutputStream = new StringBuilder();
        paramASN1OutputStream.append("not implemented: ");
        paramASN1OutputStream.append(this.obj.getClass().getName());
        throw new ASN1Exception(paramASN1OutputStream.toString());
      }
      paramASN1OutputStream.writeObject(this.obj);
    }
    paramASN1OutputStream.write(0);
    paramASN1OutputStream.write(0);
  }
  
  int encodedLength()
    throws IOException
  {
    if (!this.empty)
    {
      int i = this.obj.toASN1Primitive().encodedLength();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERTaggedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */