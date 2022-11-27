package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1TaggedObject
  extends ASN1Primitive
  implements ASN1TaggedObjectParser
{
  boolean empty = false;
  boolean explicit = true;
  ASN1Encodable obj = null;
  int tagNo;
  
  public ASN1TaggedObject(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if ((paramASN1Encodable instanceof ASN1Choice)) {
      this.explicit = true;
    } else {
      this.explicit = paramBoolean;
    }
    this.tagNo = paramInt;
    if (this.explicit) {}
    for (;;)
    {
      this.obj = paramASN1Encodable;
      return;
      paramBoolean = paramASN1Encodable.toASN1Primitive() instanceof ASN1Set;
    }
  }
  
  public static ASN1TaggedObject getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1TaggedObject)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(fromByteArray((byte[])paramObject));
          return (ASN1TaggedObject)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to construct tagged object from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ASN1TaggedObject)paramObject;
  }
  
  public static ASN1TaggedObject getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (ASN1TaggedObject)paramASN1TaggedObject.getObject();
    }
    throw new IllegalArgumentException("implicitly tagged tagged object");
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1TaggedObject)) {
      return false;
    }
    paramASN1Primitive = (ASN1TaggedObject)paramASN1Primitive;
    if ((this.tagNo == paramASN1Primitive.tagNo) && (this.empty == paramASN1Primitive.empty))
    {
      if (this.explicit != paramASN1Primitive.explicit) {
        return false;
      }
      ASN1Encodable localASN1Encodable = this.obj;
      if (localASN1Encodable == null)
      {
        if (paramASN1Primitive.obj != null) {
          return false;
        }
      }
      else if (!localASN1Encodable.toASN1Primitive().equals(paramASN1Primitive.obj.toASN1Primitive())) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public ASN1Primitive getLoadedObject()
  {
    return toASN1Primitive();
  }
  
  public ASN1Primitive getObject()
  {
    ASN1Encodable localASN1Encodable = this.obj;
    if (localASN1Encodable != null) {
      return localASN1Encodable.toASN1Primitive();
    }
    return null;
  }
  
  public ASN1Encodable getObjectParser(int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramInt != 4)
    {
      if (paramInt != 16)
      {
        if (paramInt != 17)
        {
          if (paramBoolean) {
            return getObject();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("implicit tagging not implemented for tag: ");
          localStringBuilder.append(paramInt);
          throw new ASN1Exception(localStringBuilder.toString());
        }
        return ASN1Set.getInstance(this, paramBoolean).parser();
      }
      return ASN1Sequence.getInstance(this, paramBoolean).parser();
    }
    return ASN1OctetString.getInstance(this, paramBoolean).parser();
  }
  
  public int getTagNo()
  {
    return this.tagNo;
  }
  
  public int hashCode()
  {
    int j = this.tagNo;
    ASN1Encodable localASN1Encodable = this.obj;
    int i = j;
    if (localASN1Encodable != null) {
      i = j ^ localASN1Encodable.hashCode();
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return this.empty;
  }
  
  public boolean isExplicit()
  {
    return this.explicit;
  }
  
  ASN1Primitive toDERObject()
  {
    return new DERTaggedObject(this.explicit, this.tagNo, this.obj);
  }
  
  ASN1Primitive toDLObject()
  {
    return new DLTaggedObject(this.explicit, this.tagNo, this.obj);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.tagNo);
    localStringBuilder.append("]");
    localStringBuilder.append(this.obj);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1TaggedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */