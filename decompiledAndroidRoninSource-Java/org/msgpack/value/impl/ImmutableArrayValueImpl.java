package org.msgpack.value.impl;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableArrayValueImpl
  extends AbstractImmutableValue
  implements ImmutableArrayValue
{
  private static final ImmutableArrayValueImpl EMPTY = new ImmutableArrayValueImpl(new Value[0]);
  private final Value[] array;
  
  public ImmutableArrayValueImpl(Value[] paramArrayOfValue)
  {
    this.array = paramArrayOfValue;
  }
  
  private static void appendString(StringBuilder paramStringBuilder, Value paramValue)
  {
    if (paramValue.isRawValue())
    {
      paramStringBuilder.append(paramValue.toJson());
      return;
    }
    paramStringBuilder.append(paramValue.toString());
  }
  
  public static ImmutableArrayValue empty()
  {
    return EMPTY;
  }
  
  public ImmutableArrayValue asArrayValue()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return false;
    }
    paramObject = (Value)paramObject;
    if ((paramObject instanceof ImmutableArrayValueImpl))
    {
      paramObject = (ImmutableArrayValueImpl)paramObject;
      return Arrays.equals(this.array, ((ImmutableArrayValueImpl)paramObject).array);
    }
    if (!((Value)paramObject).isArrayValue()) {
      return false;
    }
    paramObject = ((Value)paramObject).asArrayValue();
    if (size() != ((ArrayValue)paramObject).size()) {
      return false;
    }
    paramObject = ((ArrayValue)paramObject).iterator();
    int i = 0;
    while (i < this.array.length) {
      if (((Iterator)paramObject).hasNext())
      {
        if (!this.array[i].equals(((Iterator)paramObject).next())) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public Value get(int paramInt)
  {
    return this.array[paramInt];
  }
  
  public Value getOrNilValue(int paramInt)
  {
    Value[] arrayOfValue = this.array;
    if ((paramInt < arrayOfValue.length) && (paramInt >= 0)) {
      return arrayOfValue[paramInt];
    }
    return ImmutableNilValueImpl.get();
  }
  
  public ValueType getValueType()
  {
    return ValueType.ARRAY;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    for (;;)
    {
      Value[] arrayOfValue = this.array;
      if (i >= arrayOfValue.length) {
        break;
      }
      j = j * 31 + arrayOfValue[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public ImmutableArrayValue immutableValue()
  {
    return this;
  }
  
  public Iterator<Value> iterator()
  {
    return new Ite(this.array);
  }
  
  public List<Value> list()
  {
    return new ImmutableArrayValueList(this.array);
  }
  
  public int size()
  {
    return this.array.length;
  }
  
  public String toJson()
  {
    if (this.array.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.array[0].toJson());
    int i = 1;
    while (i < this.array.length)
    {
      localStringBuilder.append(",");
      localStringBuilder.append(this.array[i].toJson());
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    if (this.array.length == 0) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    appendString(localStringBuilder, this.array[0]);
    int i = 1;
    while (i < this.array.length)
    {
      localStringBuilder.append(",");
      appendString(localStringBuilder, this.array[i]);
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packArrayHeader(this.array.length);
    int i = 0;
    for (;;)
    {
      Value[] arrayOfValue = this.array;
      if (i >= arrayOfValue.length) {
        break;
      }
      arrayOfValue[i].writeTo(paramMessagePacker);
      i += 1;
    }
  }
  
  private static class ImmutableArrayValueList
    extends AbstractList<Value>
  {
    private final Value[] array;
    
    public ImmutableArrayValueList(Value[] paramArrayOfValue)
    {
      this.array = paramArrayOfValue;
    }
    
    public Value get(int paramInt)
    {
      return this.array[paramInt];
    }
    
    public int size()
    {
      return this.array.length;
    }
  }
  
  private static class Ite
    implements Iterator<Value>
  {
    private final Value[] array;
    private int index;
    
    public Ite(Value[] paramArrayOfValue)
    {
      this.array = paramArrayOfValue;
      this.index = 0;
    }
    
    public boolean hasNext()
    {
      return this.index != this.array.length;
    }
    
    public Value next()
    {
      int i = this.index;
      Value[] arrayOfValue = this.array;
      if (i < arrayOfValue.length)
      {
        this.index = (i + 1);
        return arrayOfValue[i];
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableArrayValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */