package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.Arrays.Iterator;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Sequence
  extends ASN1Primitive
  implements Iterable<ASN1Encodable>
{
  protected Vector seq;
  
  protected ASN1Sequence()
  {
    this.seq = new Vector();
  }
  
  protected ASN1Sequence(ASN1Encodable paramASN1Encodable)
  {
    Vector localVector = new Vector();
    this.seq = localVector;
    localVector.addElement(paramASN1Encodable);
  }
  
  protected ASN1Sequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    this.seq = new Vector();
    int i = 0;
    while (i != paramASN1EncodableVector.size())
    {
      this.seq.addElement(paramASN1EncodableVector.get(i));
      i += 1;
    }
  }
  
  protected ASN1Sequence(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    this.seq = new Vector();
    int i = 0;
    while (i != paramArrayOfASN1Encodable.length)
    {
      this.seq.addElement(paramArrayOfASN1Encodable[i]);
      i += 1;
    }
  }
  
  public static ASN1Sequence getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1Sequence)))
    {
      if ((paramObject instanceof ASN1SequenceParser)) {
        return getInstance(((ASN1SequenceParser)paramObject).toASN1Primitive());
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(fromByteArray((byte[])paramObject));
          return (ASN1Sequence)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to construct sequence from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1Sequence)) {
          return (ASN1Sequence)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (ASN1Sequence)paramObject;
  }
  
  public static ASN1Sequence getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramASN1TaggedObject.isExplicit()) {
        return getInstance(paramASN1TaggedObject.getObject().toASN1Primitive());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    if (paramASN1TaggedObject.isExplicit())
    {
      if ((paramASN1TaggedObject instanceof BERTaggedObject)) {
        return new BERSequence(paramASN1TaggedObject.getObject());
      }
      return new DLSequence(paramASN1TaggedObject.getObject());
    }
    if ((paramASN1TaggedObject.getObject() instanceof ASN1Sequence)) {
      return (ASN1Sequence)paramASN1TaggedObject.getObject();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown object in getInstance: ");
    localStringBuilder.append(paramASN1TaggedObject.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private ASN1Encodable getNext(Enumeration paramEnumeration)
  {
    return (ASN1Encodable)paramEnumeration.nextElement();
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1Sequence)) {
      return false;
    }
    Object localObject1 = (ASN1Sequence)paramASN1Primitive;
    if (size() != ((ASN1Sequence)localObject1).size()) {
      return false;
    }
    paramASN1Primitive = getObjects();
    localObject1 = ((ASN1Sequence)localObject1).getObjects();
    while (paramASN1Primitive.hasMoreElements())
    {
      Object localObject3 = getNext(paramASN1Primitive);
      Object localObject2 = getNext((Enumeration)localObject1);
      localObject3 = ((ASN1Encodable)localObject3).toASN1Primitive();
      localObject2 = ((ASN1Encodable)localObject2).toASN1Primitive();
      if ((localObject3 != localObject2) && (!((ASN1Primitive)localObject3).equals(localObject2))) {
        return false;
      }
    }
    return true;
  }
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public ASN1Encodable getObjectAt(int paramInt)
  {
    return (ASN1Encodable)this.seq.elementAt(paramInt);
  }
  
  public Enumeration getObjects()
  {
    return this.seq.elements();
  }
  
  public int hashCode()
  {
    Enumeration localEnumeration = getObjects();
    for (int i = size(); localEnumeration.hasMoreElements(); i = i * 17 ^ getNext(localEnumeration).hashCode()) {}
    return i;
  }
  
  boolean isConstructed()
  {
    return true;
  }
  
  public Iterator<ASN1Encodable> iterator()
  {
    return new Arrays.Iterator(toArray());
  }
  
  public ASN1SequenceParser parser()
  {
    new ASN1SequenceParser()
    {
      private int index;
      private final int max = ASN1Sequence.this.size();
      
      public ASN1Primitive getLoadedObject()
      {
        return jdField_this;
      }
      
      public ASN1Encodable readObject()
        throws IOException
      {
        int i = this.index;
        if (i == this.max) {
          return null;
        }
        Object localObject = ASN1Sequence.this;
        this.index = (i + 1);
        ASN1Encodable localASN1Encodable = ((ASN1Sequence)localObject).getObjectAt(i);
        if ((localASN1Encodable instanceof ASN1Sequence)) {
          return ((ASN1Sequence)localASN1Encodable).parser();
        }
        localObject = localASN1Encodable;
        if ((localASN1Encodable instanceof ASN1Set)) {
          localObject = ((ASN1Set)localASN1Encodable).parser();
        }
        return (ASN1Encodable)localObject;
      }
      
      public ASN1Primitive toASN1Primitive()
      {
        return jdField_this;
      }
    };
  }
  
  public int size()
  {
    return this.seq.size();
  }
  
  public ASN1Encodable[] toArray()
  {
    ASN1Encodable[] arrayOfASN1Encodable = new ASN1Encodable[size()];
    int i = 0;
    while (i != size())
    {
      arrayOfASN1Encodable[i] = getObjectAt(i);
      i += 1;
    }
    return arrayOfASN1Encodable;
  }
  
  ASN1Primitive toDERObject()
  {
    DERSequence localDERSequence = new DERSequence();
    localDERSequence.seq = this.seq;
    return localDERSequence;
  }
  
  ASN1Primitive toDLObject()
  {
    DLSequence localDLSequence = new DLSequence();
    localDLSequence.seq = this.seq;
    return localDLSequence;
  }
  
  public String toString()
  {
    return this.seq.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Sequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */