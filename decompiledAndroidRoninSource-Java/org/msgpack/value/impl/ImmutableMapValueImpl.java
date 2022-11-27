package org.msgpack.value.impl;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableMapValueImpl
  extends AbstractImmutableValue
  implements ImmutableMapValue
{
  private static final ImmutableMapValueImpl EMPTY = new ImmutableMapValueImpl(new Value[0]);
  private final Value[] kvs;
  
  public ImmutableMapValueImpl(Value[] paramArrayOfValue)
  {
    this.kvs = paramArrayOfValue;
  }
  
  private static void appendJsonKey(StringBuilder paramStringBuilder, Value paramValue)
  {
    if (paramValue.isRawValue())
    {
      paramStringBuilder.append(paramValue.toJson());
      return;
    }
    ImmutableStringValueImpl.appendJsonString(paramStringBuilder, paramValue.toString());
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
  
  public static ImmutableMapValue empty()
  {
    return EMPTY;
  }
  
  public ImmutableMapValue asMapValue()
  {
    return this;
  }
  
  public Set<Map.Entry<Value, Value>> entrySet()
  {
    return new EntrySet(this.kvs);
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
    if (!((Value)paramObject).isMapValue()) {
      return false;
    }
    paramObject = ((Value)paramObject).asMapValue();
    return map().equals(((MapValue)paramObject).map());
  }
  
  public Value[] getKeyValueArray()
  {
    Value[] arrayOfValue = this.kvs;
    return (Value[])Arrays.copyOf(arrayOfValue, arrayOfValue.length);
  }
  
  public ValueType getValueType()
  {
    return ValueType.MAP;
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      Value[] arrayOfValue = this.kvs;
      if (i >= arrayOfValue.length) {
        break;
      }
      j += (arrayOfValue[i].hashCode() ^ this.kvs[(i + 1)].hashCode());
      i += 2;
    }
    return j;
  }
  
  public ImmutableMapValue immutableValue()
  {
    return this;
  }
  
  public Set<Value> keySet()
  {
    return new KeySet(this.kvs);
  }
  
  public Map<Value, Value> map()
  {
    return new ImmutableMapValueMap(this.kvs);
  }
  
  public int size()
  {
    return this.kvs.length / 2;
  }
  
  public String toJson()
  {
    if (this.kvs.length == 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    appendJsonKey(localStringBuilder, this.kvs[0]);
    localStringBuilder.append(":");
    localStringBuilder.append(this.kvs[1].toJson());
    int i = 2;
    while (i < this.kvs.length)
    {
      localStringBuilder.append(",");
      appendJsonKey(localStringBuilder, this.kvs[i]);
      localStringBuilder.append(":");
      localStringBuilder.append(this.kvs[(i + 1)].toJson());
      i += 2;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    if (this.kvs.length == 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    appendString(localStringBuilder, this.kvs[0]);
    localStringBuilder.append(":");
    appendString(localStringBuilder, this.kvs[1]);
    int i = 2;
    while (i < this.kvs.length)
    {
      localStringBuilder.append(",");
      appendString(localStringBuilder, this.kvs[i]);
      localStringBuilder.append(":");
      appendString(localStringBuilder, this.kvs[(i + 1)]);
      i += 2;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public Collection<Value> values()
  {
    return new ValueCollection(this.kvs);
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packMapHeader(this.kvs.length / 2);
    int i = 0;
    for (;;)
    {
      Value[] arrayOfValue = this.kvs;
      if (i >= arrayOfValue.length) {
        break;
      }
      arrayOfValue[i].writeTo(paramMessagePacker);
      i += 1;
    }
  }
  
  private static class EntryIterator
    implements Iterator<Value>
  {
    private int index;
    private Value[] kvs;
    
    public EntryIterator(Value[] paramArrayOfValue, int paramInt)
    {
      this.kvs = paramArrayOfValue;
      this.index = paramInt;
    }
    
    public boolean hasNext()
    {
      return this.index < this.kvs.length;
    }
    
    public Value next()
    {
      int i = this.index;
      Value[] arrayOfValue = this.kvs;
      if (i < arrayOfValue.length)
      {
        this.index = (i + 2);
        return arrayOfValue[i];
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class EntrySet
    extends AbstractSet<Map.Entry<Value, Value>>
  {
    private final Value[] kvs;
    
    EntrySet(Value[] paramArrayOfValue)
    {
      this.kvs = paramArrayOfValue;
    }
    
    public Iterator<Map.Entry<Value, Value>> iterator()
    {
      return new ImmutableMapValueImpl.EntrySetIterator(this.kvs);
    }
    
    public int size()
    {
      return this.kvs.length / 2;
    }
  }
  
  private static class EntrySetIterator
    implements Iterator<Map.Entry<Value, Value>>
  {
    private int index;
    private final Value[] kvs;
    
    EntrySetIterator(Value[] paramArrayOfValue)
    {
      this.kvs = paramArrayOfValue;
      this.index = 0;
    }
    
    public boolean hasNext()
    {
      return this.index < this.kvs.length;
    }
    
    public Map.Entry<Value, Value> next()
    {
      int i = this.index;
      Object localObject = this.kvs;
      if (i < localObject.length)
      {
        localObject = new AbstractMap.SimpleImmutableEntry(localObject[i], localObject[(i + 1)]);
        this.index += 2;
        return (Map.Entry<Value, Value>)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class ImmutableMapValueMap
    extends AbstractMap<Value, Value>
  {
    private final Value[] kvs;
    
    public ImmutableMapValueMap(Value[] paramArrayOfValue)
    {
      this.kvs = paramArrayOfValue;
    }
    
    public Set<Map.Entry<Value, Value>> entrySet()
    {
      return new ImmutableMapValueImpl.EntrySet(this.kvs);
    }
  }
  
  private static class KeySet
    extends AbstractSet<Value>
  {
    private Value[] kvs;
    
    KeySet(Value[] paramArrayOfValue)
    {
      this.kvs = paramArrayOfValue;
    }
    
    public Iterator<Value> iterator()
    {
      return new ImmutableMapValueImpl.EntryIterator(this.kvs, 0);
    }
    
    public int size()
    {
      return this.kvs.length / 2;
    }
  }
  
  private static class ValueCollection
    extends AbstractCollection<Value>
  {
    private Value[] kvs;
    
    ValueCollection(Value[] paramArrayOfValue)
    {
      this.kvs = paramArrayOfValue;
    }
    
    public Iterator<Value> iterator()
    {
      return new ImmutableMapValueImpl.EntryIterator(this.kvs, 1);
    }
    
    public int size()
    {
      return this.kvs.length / 2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableMapValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */