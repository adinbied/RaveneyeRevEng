package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.bouncycastle.util.Arrays.Iterator;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Set
  extends ASN1Primitive
  implements Iterable<ASN1Encodable>
{
  private boolean isSorted;
  private Vector set;
  
  protected ASN1Set()
  {
    this.set = new Vector();
    this.isSorted = false;
  }
  
  protected ASN1Set(ASN1Encodable paramASN1Encodable)
  {
    Vector localVector = new Vector();
    this.set = localVector;
    this.isSorted = false;
    localVector.addElement(paramASN1Encodable);
  }
  
  protected ASN1Set(ASN1EncodableVector paramASN1EncodableVector, boolean paramBoolean)
  {
    this.set = new Vector();
    int i = 0;
    this.isSorted = false;
    while (i != paramASN1EncodableVector.size())
    {
      this.set.addElement(paramASN1EncodableVector.get(i));
      i += 1;
    }
    if (paramBoolean) {
      sort();
    }
  }
  
  protected ASN1Set(ASN1Encodable[] paramArrayOfASN1Encodable, boolean paramBoolean)
  {
    this.set = new Vector();
    int i = 0;
    this.isSorted = false;
    while (i != paramArrayOfASN1Encodable.length)
    {
      this.set.addElement(paramArrayOfASN1Encodable[i]);
      i += 1;
    }
    if (paramBoolean) {
      sort();
    }
  }
  
  private byte[] getDEREncoded(ASN1Encodable paramASN1Encodable)
  {
    try
    {
      paramASN1Encodable = paramASN1Encodable.toASN1Primitive().getEncoded("DER");
      return paramASN1Encodable;
    }
    catch (IOException paramASN1Encodable)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("cannot encode object added to SET");
  }
  
  public static ASN1Set getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1Set)))
    {
      if ((paramObject instanceof ASN1SetParser)) {
        return getInstance(((ASN1SetParser)paramObject).toASN1Primitive());
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
          return (ASN1Set)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to construct set from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1Set)) {
          return (ASN1Set)localObject;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (ASN1Set)paramObject;
  }
  
  public static ASN1Set getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramASN1TaggedObject.isExplicit()) {
        return (ASN1Set)paramASN1TaggedObject.getObject();
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    if (paramASN1TaggedObject.isExplicit())
    {
      if ((paramASN1TaggedObject instanceof BERTaggedObject)) {
        return new BERSet(paramASN1TaggedObject.getObject());
      }
      return new DLSet(paramASN1TaggedObject.getObject());
    }
    if ((paramASN1TaggedObject.getObject() instanceof ASN1Set)) {
      return (ASN1Set)paramASN1TaggedObject.getObject();
    }
    if ((paramASN1TaggedObject.getObject() instanceof ASN1Sequence))
    {
      localObject = (ASN1Sequence)paramASN1TaggedObject.getObject();
      if ((paramASN1TaggedObject instanceof BERTaggedObject)) {
        return new BERSet(((ASN1Sequence)localObject).toArray());
      }
      return new DLSet(((ASN1Sequence)localObject).toArray());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramASN1TaggedObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private ASN1Encodable getNext(Enumeration paramEnumeration)
  {
    ASN1Encodable localASN1Encodable = (ASN1Encodable)paramEnumeration.nextElement();
    paramEnumeration = localASN1Encodable;
    if (localASN1Encodable == null) {
      paramEnumeration = DERNull.INSTANCE;
    }
    return paramEnumeration;
  }
  
  private boolean lessThanOrEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    while (i != j)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        if ((paramArrayOfByte1[i] & 0xFF) < (paramArrayOfByte2[i] & 0xFF)) {
          bool1 = true;
        }
        return bool1;
      }
      i += 1;
    }
    bool1 = bool2;
    if (j == paramArrayOfByte1.length) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1Set)) {
      return false;
    }
    Object localObject1 = (ASN1Set)paramASN1Primitive;
    if (size() != ((ASN1Set)localObject1).size()) {
      return false;
    }
    paramASN1Primitive = getObjects();
    localObject1 = ((ASN1Set)localObject1).getObjects();
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
    return (ASN1Encodable)this.set.elementAt(paramInt);
  }
  
  public Enumeration getObjects()
  {
    return this.set.elements();
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
  
  public ASN1SetParser parser()
  {
    new ASN1SetParser()
    {
      private int index;
      private final int max = ASN1Set.this.size();
      
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
        Object localObject = ASN1Set.this;
        this.index = (i + 1);
        ASN1Encodable localASN1Encodable = ((ASN1Set)localObject).getObjectAt(i);
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
    return this.set.size();
  }
  
  protected void sort()
  {
    if (!this.isSorted)
    {
      this.isSorted = true;
      if (this.set.size() > 1)
      {
        int m = this.set.size() - 1;
        int i = 1;
        while (i != 0)
        {
          Object localObject1 = this.set;
          int j = 0;
          localObject1 = getDEREncoded((ASN1Encodable)((Vector)localObject1).elementAt(0));
          i = 0;
          int n;
          for (int k = 0; k != m; k = n)
          {
            Object localObject2 = this.set;
            n = k + 1;
            localObject2 = getDEREncoded((ASN1Encodable)((Vector)localObject2).elementAt(n));
            if (lessThanOrEqual((byte[])localObject1, (byte[])localObject2))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = this.set.elementAt(k);
              Vector localVector = this.set;
              localVector.setElementAt(localVector.elementAt(n), k);
              this.set.setElementAt(localObject2, n);
              j = k;
              i = 1;
            }
          }
          m = j;
        }
      }
    }
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
    if (this.isSorted)
    {
      localObject = new DERSet();
      ((ASN1Set)localObject).set = this.set;
      return (ASN1Primitive)localObject;
    }
    Object localObject = new Vector();
    int i = 0;
    while (i != this.set.size())
    {
      ((Vector)localObject).addElement(this.set.elementAt(i));
      i += 1;
    }
    DERSet localDERSet = new DERSet();
    localDERSet.set = ((Vector)localObject);
    localDERSet.sort();
    return localDERSet;
  }
  
  ASN1Primitive toDLObject()
  {
    DLSet localDLSet = new DLSet();
    localDLSet.set = this.set;
    return localDLSet;
  }
  
  public String toString()
  {
    return this.set.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Set.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */