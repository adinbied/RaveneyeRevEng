package org.msgpack.value;

import java.math.BigInteger;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.msgpack.value.impl.ImmutableArrayValueImpl;
import org.msgpack.value.impl.ImmutableBigIntegerValueImpl;
import org.msgpack.value.impl.ImmutableBinaryValueImpl;
import org.msgpack.value.impl.ImmutableBooleanValueImpl;
import org.msgpack.value.impl.ImmutableDoubleValueImpl;
import org.msgpack.value.impl.ImmutableExtensionValueImpl;
import org.msgpack.value.impl.ImmutableLongValueImpl;
import org.msgpack.value.impl.ImmutableMapValueImpl;
import org.msgpack.value.impl.ImmutableNilValueImpl;
import org.msgpack.value.impl.ImmutableStringValueImpl;

public final class ValueFactory
{
  public static ImmutableArrayValue emptyArray()
  {
    return ImmutableArrayValueImpl.empty();
  }
  
  public static ImmutableMapValue emptyMap()
  {
    return ImmutableMapValueImpl.empty();
  }
  
  public static ImmutableArrayValue newArray(List<? extends Value> paramList)
  {
    if (paramList.isEmpty()) {
      return ImmutableArrayValueImpl.empty();
    }
    return new ImmutableArrayValueImpl((Value[])paramList.toArray(new Value[paramList.size()]));
  }
  
  public static ImmutableArrayValue newArray(Value... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return ImmutableArrayValueImpl.empty();
    }
    return new ImmutableArrayValueImpl((Value[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public static ImmutableArrayValue newArray(Value[] paramArrayOfValue, boolean paramBoolean)
  {
    if (paramArrayOfValue.length == 0) {
      return ImmutableArrayValueImpl.empty();
    }
    if (paramBoolean) {
      return new ImmutableArrayValueImpl(paramArrayOfValue);
    }
    return new ImmutableArrayValueImpl((Value[])Arrays.copyOf(paramArrayOfValue, paramArrayOfValue.length));
  }
  
  public static ImmutableBinaryValue newBinary(byte[] paramArrayOfByte)
  {
    return newBinary(paramArrayOfByte, false);
  }
  
  public static ImmutableBinaryValue newBinary(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newBinary(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public static ImmutableBinaryValue newBinary(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length)) {
      return new ImmutableBinaryValueImpl(paramArrayOfByte);
    }
    return new ImmutableBinaryValueImpl(Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static ImmutableBinaryValue newBinary(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ImmutableBinaryValueImpl(paramArrayOfByte);
    }
    return new ImmutableBinaryValueImpl(Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length));
  }
  
  public static ImmutableBooleanValue newBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return ImmutableBooleanValueImpl.TRUE;
    }
    return ImmutableBooleanValueImpl.FALSE;
  }
  
  public static ImmutableExtensionValue newExtension(byte paramByte, byte[] paramArrayOfByte)
  {
    return new ImmutableExtensionValueImpl(paramByte, paramArrayOfByte);
  }
  
  public static ImmutableFloatValue newFloat(double paramDouble)
  {
    return new ImmutableDoubleValueImpl(paramDouble);
  }
  
  public static ImmutableFloatValue newFloat(float paramFloat)
  {
    return new ImmutableDoubleValueImpl(paramFloat);
  }
  
  public static ImmutableIntegerValue newInteger(byte paramByte)
  {
    return new ImmutableLongValueImpl(paramByte);
  }
  
  public static ImmutableIntegerValue newInteger(int paramInt)
  {
    return new ImmutableLongValueImpl(paramInt);
  }
  
  public static ImmutableIntegerValue newInteger(long paramLong)
  {
    return new ImmutableLongValueImpl(paramLong);
  }
  
  public static ImmutableIntegerValue newInteger(BigInteger paramBigInteger)
  {
    return new ImmutableBigIntegerValueImpl(paramBigInteger);
  }
  
  public static ImmutableIntegerValue newInteger(short paramShort)
  {
    return new ImmutableLongValueImpl(paramShort);
  }
  
  public static <K extends Value, V extends Value> ImmutableMapValue newMap(Map<K, V> paramMap)
  {
    Value[] arrayOfValue = new Value[paramMap.size() * 2];
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      arrayOfValue[i] = ((Value)localEntry.getKey());
      i += 1;
      arrayOfValue[i] = ((Value)localEntry.getValue());
      i += 1;
    }
    return new ImmutableMapValueImpl(arrayOfValue);
  }
  
  public static ImmutableMapValue newMap(Value... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return ImmutableMapValueImpl.empty();
    }
    return new ImmutableMapValueImpl((Value[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public static ImmutableMapValue newMap(Value[] paramArrayOfValue, boolean paramBoolean)
  {
    if (paramArrayOfValue.length == 0) {
      return ImmutableMapValueImpl.empty();
    }
    if (paramBoolean) {
      return new ImmutableMapValueImpl(paramArrayOfValue);
    }
    return new ImmutableMapValueImpl((Value[])Arrays.copyOf(paramArrayOfValue, paramArrayOfValue.length));
  }
  
  public static MapValue newMap(Map.Entry<? extends Value, ? extends Value>... paramVarArgs)
  {
    Value[] arrayOfValue = new Value[paramVarArgs.length * 2];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      int j = i * 2;
      arrayOfValue[j] = ((Value)paramVarArgs[i].getKey());
      arrayOfValue[(j + 1)] = ((Value)paramVarArgs[i].getValue());
      i += 2;
    }
    return newMap(arrayOfValue, true);
  }
  
  public static MapBuilder newMapBuilder()
  {
    return new MapBuilder();
  }
  
  public static Map.Entry<Value, Value> newMapEntry(Value paramValue1, Value paramValue2)
  {
    return new AbstractMap.SimpleEntry(paramValue1, paramValue2);
  }
  
  public static ImmutableNilValue newNil()
  {
    return ImmutableNilValueImpl.get();
  }
  
  public static ImmutableStringValue newString(String paramString)
  {
    return new ImmutableStringValueImpl(paramString);
  }
  
  public static ImmutableStringValue newString(byte[] paramArrayOfByte)
  {
    return new ImmutableStringValueImpl(paramArrayOfByte);
  }
  
  public static ImmutableStringValue newString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newString(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public static ImmutableStringValue newString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length)) {
      return new ImmutableStringValueImpl(paramArrayOfByte);
    }
    return new ImmutableStringValueImpl(Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static ImmutableStringValue newString(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ImmutableStringValueImpl(paramArrayOfByte);
    }
    return new ImmutableStringValueImpl(Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length));
  }
  
  public static class MapBuilder
  {
    private final Map<Value, Value> map = new LinkedHashMap();
    
    public MapValue build()
    {
      return ValueFactory.newMap(this.map);
    }
    
    public MapBuilder put(Map.Entry<? extends Value, ? extends Value> paramEntry)
    {
      put((Value)paramEntry.getKey(), (Value)paramEntry.getValue());
      return this;
    }
    
    public MapBuilder put(Value paramValue1, Value paramValue2)
    {
      this.map.put(paramValue1, paramValue2);
      return this;
    }
    
    public MapBuilder putAll(Iterable<? extends Map.Entry<? extends Value, ? extends Value>> paramIterable)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramIterable.next();
        put((Value)localEntry.getKey(), (Value)localEntry.getValue());
      }
      return this;
    }
    
    public MapBuilder putAll(Map<? extends Value, ? extends Value> paramMap)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        put((Map.Entry)paramMap.next());
      }
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\ValueFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */