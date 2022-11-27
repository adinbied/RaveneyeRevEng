package org.msgpack.value;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.impl.ImmutableBigIntegerValueImpl;

public class Variable
  implements Value
{
  private static final long BYTE_MAX = 127L;
  private static final long BYTE_MIN = -128L;
  private static final long INT_MAX = 2147483647L;
  private static final long INT_MIN = -2147483648L;
  private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
  private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
  private static final long SHORT_MAX = 32767L;
  private static final long SHORT_MIN = -32768L;
  private AbstractValueAccessor accessor;
  private final ArrayValueAccessor arrayAccessor = new ArrayValueAccessor(null);
  private final BinaryValueAccessor binaryAccessor = new BinaryValueAccessor(null);
  private final BooleanValueAccessor booleanAccessor = new BooleanValueAccessor(null);
  private double doubleValue;
  private final ExtensionValueAccessor extensionAccessor = new ExtensionValueAccessor(null);
  private final FloatValueAccessor floatAccessor = new FloatValueAccessor(null);
  private final IntegerValueAccessor integerAccessor = new IntegerValueAccessor(null);
  private long longValue;
  private final MapValueAccessor mapAccessor = new MapValueAccessor(null);
  private final NilValueAccessor nilAccessor = new NilValueAccessor(null);
  private Object objectValue;
  private final StringValueAccessor stringAccessor = new StringValueAccessor(null);
  private Type type;
  
  public Variable()
  {
    setNilValue();
  }
  
  public ArrayValue asArrayValue()
  {
    if (isArrayValue()) {
      return (ArrayValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public BinaryValue asBinaryValue()
  {
    if (isBinaryValue()) {
      return (BinaryValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public BooleanValue asBooleanValue()
  {
    if (isBooleanValue()) {
      return (BooleanValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public ExtensionValue asExtensionValue()
  {
    if (isExtensionValue()) {
      return (ExtensionValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public FloatValue asFloatValue()
  {
    if (isFloatValue()) {
      return (FloatValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public IntegerValue asIntegerValue()
  {
    if (isIntegerValue()) {
      return (IntegerValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public MapValue asMapValue()
  {
    if (isMapValue()) {
      return (MapValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public NilValue asNilValue()
  {
    if (isNilValue()) {
      return (NilValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public NumberValue asNumberValue()
  {
    if (isNumberValue()) {
      return (NumberValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public RawValue asRawValue()
  {
    if (isRawValue()) {
      return (RawValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public StringValue asStringValue()
  {
    if (isStringValue()) {
      return (StringValue)this.accessor;
    }
    throw new MessageTypeCastException();
  }
  
  public boolean equals(Object paramObject)
  {
    return immutableValue().equals(paramObject);
  }
  
  public ValueType getValueType()
  {
    return this.type.getValueType();
  }
  
  public int hashCode()
  {
    return immutableValue().hashCode();
  }
  
  public ImmutableValue immutableValue()
  {
    return this.accessor.immutableValue();
  }
  
  public boolean isArrayValue()
  {
    return getValueType().isArrayType();
  }
  
  public boolean isBinaryValue()
  {
    return getValueType().isBinaryType();
  }
  
  public boolean isBooleanValue()
  {
    return getValueType().isBooleanType();
  }
  
  public boolean isExtensionValue()
  {
    return getValueType().isExtensionType();
  }
  
  public boolean isFloatValue()
  {
    return getValueType().isFloatType();
  }
  
  public boolean isIntegerValue()
  {
    return getValueType().isIntegerType();
  }
  
  public boolean isMapValue()
  {
    return getValueType().isMapType();
  }
  
  public boolean isNilValue()
  {
    return getValueType().isNilType();
  }
  
  public boolean isNumberValue()
  {
    return getValueType().isNumberType();
  }
  
  public boolean isRawValue()
  {
    return getValueType().isRawType();
  }
  
  public boolean isStringValue()
  {
    return getValueType().isStringType();
  }
  
  public Variable setArrayValue(List<Value> paramList)
  {
    this.type = Type.LIST;
    this.accessor = this.arrayAccessor;
    this.objectValue = paramList;
    return this;
  }
  
  public Variable setBinaryValue(byte[] paramArrayOfByte)
  {
    this.type = Type.BYTE_ARRAY;
    this.accessor = this.binaryAccessor;
    this.objectValue = paramArrayOfByte;
    return this;
  }
  
  public Variable setBooleanValue(boolean paramBoolean)
  {
    this.type = Type.BOOLEAN;
    this.accessor = this.booleanAccessor;
    long l;
    if (paramBoolean) {
      l = 1L;
    } else {
      l = 0L;
    }
    this.longValue = l;
    return this;
  }
  
  public Variable setExtensionValue(byte paramByte, byte[] paramArrayOfByte)
  {
    this.type = Type.EXTENSION;
    this.accessor = this.extensionAccessor;
    this.objectValue = ValueFactory.newExtension(paramByte, paramArrayOfByte);
    return this;
  }
  
  public Variable setFloatValue(double paramDouble)
  {
    this.type = Type.DOUBLE;
    this.accessor = this.floatAccessor;
    this.doubleValue = paramDouble;
    this.longValue = (paramDouble);
    return this;
  }
  
  public Variable setFloatValue(float paramFloat)
  {
    this.type = Type.DOUBLE;
    this.accessor = this.floatAccessor;
    this.longValue = (paramFloat);
    return this;
  }
  
  public Variable setIntegerValue(long paramLong)
  {
    this.type = Type.LONG;
    this.accessor = this.integerAccessor;
    this.longValue = paramLong;
    return this;
  }
  
  public Variable setIntegerValue(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.compareTo(LONG_MIN) >= 0) && (paramBigInteger.compareTo(LONG_MAX) <= 0))
    {
      this.type = Type.LONG;
      this.accessor = this.integerAccessor;
      this.longValue = paramBigInteger.longValue();
      return this;
    }
    this.type = Type.BIG_INTEGER;
    this.accessor = this.integerAccessor;
    this.objectValue = paramBigInteger;
    return this;
  }
  
  public Variable setMapValue(Map<Value, Value> paramMap)
  {
    this.type = Type.MAP;
    this.accessor = this.mapAccessor;
    this.objectValue = paramMap;
    return this;
  }
  
  public Variable setNilValue()
  {
    this.type = Type.NULL;
    this.accessor = this.nilAccessor;
    return this;
  }
  
  public Variable setStringValue(String paramString)
  {
    return setStringValue(paramString.getBytes(MessagePack.UTF8));
  }
  
  public Variable setStringValue(byte[] paramArrayOfByte)
  {
    this.type = Type.RAW_STRING;
    this.accessor = this.stringAccessor;
    this.objectValue = paramArrayOfByte;
    return this;
  }
  
  public String toJson()
  {
    return immutableValue().toJson();
  }
  
  public String toString()
  {
    return immutableValue().toString();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    this.accessor.writeTo(paramMessagePacker);
  }
  
  private abstract class AbstractNumberValueAccessor
    extends Variable.AbstractValueAccessor
    implements NumberValue
  {
    private AbstractNumberValueAccessor()
    {
      super(null);
    }
    
    public NumberValue asNumberValue()
    {
      return this;
    }
    
    public BigInteger toBigInteger()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return (BigInteger)Variable.this.objectValue;
      }
      if (Variable.this.type == Variable.Type.DOUBLE) {
        return new BigDecimal(Variable.this.doubleValue).toBigInteger();
      }
      return BigInteger.valueOf(Variable.this.longValue);
    }
    
    public byte toByte()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).byteValue();
      }
      return (byte)(int)Variable.this.longValue;
    }
    
    public double toDouble()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).doubleValue();
      }
      if (Variable.this.type == Variable.Type.DOUBLE) {
        return Variable.this.doubleValue;
      }
      return Variable.this.longValue;
    }
    
    public float toFloat()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).floatValue();
      }
      if (Variable.this.type == Variable.Type.DOUBLE) {
        return (float)Variable.this.doubleValue;
      }
      return (float)Variable.this.longValue;
    }
    
    public int toInt()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).intValue();
      }
      return (int)Variable.this.longValue;
    }
    
    public long toLong()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).longValue();
      }
      return Variable.this.longValue;
    }
    
    public short toShort()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ((BigInteger)Variable.this.objectValue).shortValue();
      }
      return (short)(int)Variable.this.longValue;
    }
  }
  
  private abstract class AbstractRawValueAccessor
    extends Variable.AbstractValueAccessor
    implements RawValue
  {
    private AbstractRawValueAccessor()
    {
      super(null);
    }
    
    public byte[] asByteArray()
    {
      return (byte[])Variable.this.objectValue;
    }
    
    public ByteBuffer asByteBuffer()
    {
      return ByteBuffer.wrap(asByteArray());
    }
    
    public RawValue asRawValue()
    {
      return this;
    }
    
    public String asString()
    {
      Object localObject = (byte[])Variable.this.objectValue;
      try
      {
        localObject = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap((byte[])localObject)).toString();
        return (String)localObject;
      }
      catch (CharacterCodingException localCharacterCodingException)
      {
        throw new MessageStringCodingException(localCharacterCodingException);
      }
    }
    
    public String toString()
    {
      Object localObject = (byte[])Variable.this.objectValue;
      try
      {
        localObject = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(ByteBuffer.wrap((byte[])localObject)).toString();
        return (String)localObject;
      }
      catch (CharacterCodingException localCharacterCodingException)
      {
        throw new MessageStringCodingException(localCharacterCodingException);
      }
    }
  }
  
  private abstract class AbstractValueAccessor
    implements Value
  {
    private AbstractValueAccessor() {}
    
    public ArrayValue asArrayValue()
    {
      throw new MessageTypeCastException();
    }
    
    public BinaryValue asBinaryValue()
    {
      throw new MessageTypeCastException();
    }
    
    public BooleanValue asBooleanValue()
    {
      throw new MessageTypeCastException();
    }
    
    public ExtensionValue asExtensionValue()
    {
      throw new MessageTypeCastException();
    }
    
    public FloatValue asFloatValue()
    {
      throw new MessageTypeCastException();
    }
    
    public IntegerValue asIntegerValue()
    {
      throw new MessageTypeCastException();
    }
    
    public MapValue asMapValue()
    {
      throw new MessageTypeCastException();
    }
    
    public NilValue asNilValue()
    {
      throw new MessageTypeCastException();
    }
    
    public NumberValue asNumberValue()
    {
      throw new MessageTypeCastException();
    }
    
    public RawValue asRawValue()
    {
      throw new MessageTypeCastException();
    }
    
    public StringValue asStringValue()
    {
      throw new MessageTypeCastException();
    }
    
    public boolean equals(Object paramObject)
    {
      return Variable.this.equals(paramObject);
    }
    
    public int hashCode()
    {
      return Variable.this.hashCode();
    }
    
    public boolean isArrayValue()
    {
      return getValueType().isArrayType();
    }
    
    public boolean isBinaryValue()
    {
      return getValueType().isBinaryType();
    }
    
    public boolean isBooleanValue()
    {
      return getValueType().isBooleanType();
    }
    
    public boolean isExtensionValue()
    {
      return getValueType().isExtensionType();
    }
    
    public boolean isFloatValue()
    {
      return getValueType().isFloatType();
    }
    
    public boolean isIntegerValue()
    {
      return getValueType().isIntegerType();
    }
    
    public boolean isMapValue()
    {
      return getValueType().isMapType();
    }
    
    public boolean isNilValue()
    {
      return getValueType().isNilType();
    }
    
    public boolean isNumberValue()
    {
      return getValueType().isNumberType();
    }
    
    public boolean isRawValue()
    {
      return getValueType().isRawType();
    }
    
    public boolean isStringValue()
    {
      return getValueType().isStringType();
    }
    
    public String toJson()
    {
      return Variable.this.toJson();
    }
    
    public String toString()
    {
      return Variable.this.toString();
    }
  }
  
  private class ArrayValueAccessor
    extends Variable.AbstractValueAccessor
    implements ArrayValue
  {
    private ArrayValueAccessor()
    {
      super(null);
    }
    
    public ArrayValue asArrayValue()
    {
      return this;
    }
    
    public Value get(int paramInt)
    {
      return (Value)list().get(paramInt);
    }
    
    public Value getOrNilValue(int paramInt)
    {
      List localList = list();
      if ((localList.size() < paramInt) && (paramInt >= 0)) {
        return ValueFactory.newNil();
      }
      return (Value)localList.get(paramInt);
    }
    
    public ValueType getValueType()
    {
      return ValueType.ARRAY;
    }
    
    public ImmutableArrayValue immutableValue()
    {
      return ValueFactory.newArray(list());
    }
    
    public Iterator<Value> iterator()
    {
      return list().iterator();
    }
    
    public List<Value> list()
    {
      return (List)Variable.this.objectValue;
    }
    
    public int size()
    {
      return list().size();
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      Object localObject = list();
      paramMessagePacker.packArrayHeader(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Value)((Iterator)localObject).next()).writeTo(paramMessagePacker);
      }
    }
  }
  
  private class BinaryValueAccessor
    extends Variable.AbstractRawValueAccessor
    implements BinaryValue
  {
    private BinaryValueAccessor()
    {
      super(null);
    }
    
    public BinaryValue asBinaryValue()
    {
      return this;
    }
    
    public ValueType getValueType()
    {
      return ValueType.BINARY;
    }
    
    public ImmutableBinaryValue immutableValue()
    {
      return ValueFactory.newBinary(asByteArray());
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      byte[] arrayOfByte = (byte[])Variable.this.objectValue;
      paramMessagePacker.packBinaryHeader(arrayOfByte.length);
      paramMessagePacker.writePayload(arrayOfByte);
    }
  }
  
  private class BooleanValueAccessor
    extends Variable.AbstractValueAccessor
    implements BooleanValue
  {
    private BooleanValueAccessor()
    {
      super(null);
    }
    
    public BooleanValue asBooleanValue()
    {
      return this;
    }
    
    public boolean getBoolean()
    {
      return Variable.this.longValue == 1L;
    }
    
    public ValueType getValueType()
    {
      return ValueType.BOOLEAN;
    }
    
    public ImmutableBooleanValue immutableValue()
    {
      return ValueFactory.newBoolean(getBoolean());
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      boolean bool;
      if (Variable.this.longValue == 1L) {
        bool = true;
      } else {
        bool = false;
      }
      paramMessagePacker.packBoolean(bool);
    }
  }
  
  private class ExtensionValueAccessor
    extends Variable.AbstractValueAccessor
    implements ExtensionValue
  {
    private ExtensionValueAccessor()
    {
      super(null);
    }
    
    public ExtensionValue asExtensionValue()
    {
      return this;
    }
    
    public byte[] getData()
    {
      return ((ImmutableExtensionValue)Variable.this.objectValue).getData();
    }
    
    public byte getType()
    {
      return ((ImmutableExtensionValue)Variable.this.objectValue).getType();
    }
    
    public ValueType getValueType()
    {
      return ValueType.EXTENSION;
    }
    
    public ImmutableExtensionValue immutableValue()
    {
      return (ImmutableExtensionValue)Variable.this.objectValue;
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      ((ImmutableExtensionValue)Variable.this.objectValue).writeTo(paramMessagePacker);
    }
  }
  
  private class FloatValueAccessor
    extends Variable.AbstractNumberValueAccessor
    implements FloatValue
  {
    private FloatValueAccessor()
    {
      super(null);
    }
    
    public FloatValue asFloatValue()
    {
      return this;
    }
    
    public ValueType getValueType()
    {
      return ValueType.FLOAT;
    }
    
    public ImmutableFloatValue immutableValue()
    {
      return ValueFactory.newFloat(Variable.this.doubleValue);
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      paramMessagePacker.packDouble(Variable.this.doubleValue);
    }
  }
  
  private class IntegerValueAccessor
    extends Variable.AbstractNumberValueAccessor
    implements IntegerValue
  {
    private IntegerValueAccessor()
    {
      super(null);
    }
    
    public BigInteger asBigInteger()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return (BigInteger)Variable.this.objectValue;
      }
      return BigInteger.valueOf(Variable.this.longValue);
    }
    
    public byte asByte()
    {
      if (isInByteRange()) {
        return (byte)(int)Variable.this.longValue;
      }
      throw new MessageIntegerOverflowException(Variable.this.longValue);
    }
    
    public int asInt()
    {
      if (isInIntRange()) {
        return (int)Variable.this.longValue;
      }
      throw new MessageIntegerOverflowException(Variable.this.longValue);
    }
    
    public IntegerValue asIntegerValue()
    {
      return this;
    }
    
    public long asLong()
    {
      if (isInLongRange()) {
        return Variable.this.longValue;
      }
      throw new MessageIntegerOverflowException(Variable.this.longValue);
    }
    
    public short asShort()
    {
      if (isInByteRange()) {
        return (short)(int)Variable.this.longValue;
      }
      throw new MessageIntegerOverflowException(Variable.this.longValue);
    }
    
    public ValueType getValueType()
    {
      return ValueType.INTEGER;
    }
    
    public ImmutableIntegerValue immutableValue()
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER) {
        return ValueFactory.newInteger((BigInteger)Variable.this.objectValue);
      }
      return ValueFactory.newInteger(Variable.this.longValue);
    }
    
    public boolean isInByteRange()
    {
      Variable.Type localType1 = Variable.this.type;
      Variable.Type localType2 = Variable.Type.BIG_INTEGER;
      boolean bool2 = false;
      if (localType1 == localType2) {
        return false;
      }
      boolean bool1 = bool2;
      if (-128L <= Variable.this.longValue)
      {
        bool1 = bool2;
        if (Variable.this.longValue <= 127L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isInIntRange()
    {
      Variable.Type localType1 = Variable.this.type;
      Variable.Type localType2 = Variable.Type.BIG_INTEGER;
      boolean bool2 = false;
      if (localType1 == localType2) {
        return false;
      }
      boolean bool1 = bool2;
      if (-2147483648L <= Variable.this.longValue)
      {
        bool1 = bool2;
        if (Variable.this.longValue <= 2147483647L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean isInLongRange()
    {
      return Variable.this.type != Variable.Type.BIG_INTEGER;
    }
    
    public boolean isInShortRange()
    {
      Variable.Type localType1 = Variable.this.type;
      Variable.Type localType2 = Variable.Type.BIG_INTEGER;
      boolean bool2 = false;
      if (localType1 == localType2) {
        return false;
      }
      boolean bool1 = bool2;
      if (-32768L <= Variable.this.longValue)
      {
        bool1 = bool2;
        if (Variable.this.longValue <= 32767L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public MessageFormat mostSuccinctMessageFormat()
    {
      return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      if (Variable.this.type == Variable.Type.BIG_INTEGER)
      {
        paramMessagePacker.packBigInteger((BigInteger)Variable.this.objectValue);
        return;
      }
      paramMessagePacker.packLong(Variable.this.longValue);
    }
  }
  
  private class MapValueAccessor
    extends Variable.AbstractValueAccessor
    implements MapValue
  {
    private MapValueAccessor()
    {
      super(null);
    }
    
    public MapValue asMapValue()
    {
      return this;
    }
    
    public Set<Map.Entry<Value, Value>> entrySet()
    {
      return map().entrySet();
    }
    
    public Value[] getKeyValueArray()
    {
      Object localObject = map();
      Value[] arrayOfValue = new Value[((Map)localObject).size() * 2];
      localObject = ((Map)localObject).entrySet().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        arrayOfValue[i] = ((Value)localEntry.getKey());
        i += 1;
        arrayOfValue[i] = ((Value)localEntry.getValue());
        i += 1;
      }
      return arrayOfValue;
    }
    
    public ValueType getValueType()
    {
      return ValueType.MAP;
    }
    
    public ImmutableMapValue immutableValue()
    {
      return ValueFactory.newMap(map());
    }
    
    public Set<Value> keySet()
    {
      return map().keySet();
    }
    
    public Map<Value, Value> map()
    {
      return (Map)Variable.this.objectValue;
    }
    
    public int size()
    {
      return map().size();
    }
    
    public Collection<Value> values()
    {
      return map().values();
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      Object localObject = map();
      paramMessagePacker.packArrayHeader(((Map)localObject).size());
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        ((Value)localEntry.getKey()).writeTo(paramMessagePacker);
        ((Value)localEntry.getValue()).writeTo(paramMessagePacker);
      }
    }
  }
  
  private class NilValueAccessor
    extends Variable.AbstractValueAccessor
    implements NilValue
  {
    private NilValueAccessor()
    {
      super(null);
    }
    
    public NilValue asNilValue()
    {
      return this;
    }
    
    public ValueType getValueType()
    {
      return ValueType.NIL;
    }
    
    public ImmutableNilValue immutableValue()
    {
      return ValueFactory.newNil();
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      paramMessagePacker.packNil();
    }
  }
  
  private class StringValueAccessor
    extends Variable.AbstractRawValueAccessor
    implements StringValue
  {
    private StringValueAccessor()
    {
      super(null);
    }
    
    public StringValue asStringValue()
    {
      return this;
    }
    
    public ValueType getValueType()
    {
      return ValueType.STRING;
    }
    
    public ImmutableStringValue immutableValue()
    {
      return ValueFactory.newString((byte[])Variable.this.objectValue);
    }
    
    public void writeTo(MessagePacker paramMessagePacker)
      throws IOException
    {
      byte[] arrayOfByte = (byte[])Variable.this.objectValue;
      paramMessagePacker.packRawStringHeader(arrayOfByte.length);
      paramMessagePacker.writePayload(arrayOfByte);
    }
  }
  
  public static enum Type
  {
    private final ValueType valueType;
    
    static
    {
      BOOLEAN = new Type("BOOLEAN", 1, ValueType.BOOLEAN);
      LONG = new Type("LONG", 2, ValueType.INTEGER);
      BIG_INTEGER = new Type("BIG_INTEGER", 3, ValueType.INTEGER);
      DOUBLE = new Type("DOUBLE", 4, ValueType.FLOAT);
      BYTE_ARRAY = new Type("BYTE_ARRAY", 5, ValueType.BINARY);
      RAW_STRING = new Type("RAW_STRING", 6, ValueType.STRING);
      LIST = new Type("LIST", 7, ValueType.ARRAY);
      MAP = new Type("MAP", 8, ValueType.MAP);
      Type localType = new Type("EXTENSION", 9, ValueType.EXTENSION);
      EXTENSION = localType;
      $VALUES = new Type[] { NULL, BOOLEAN, LONG, BIG_INTEGER, DOUBLE, BYTE_ARRAY, RAW_STRING, LIST, MAP, localType };
    }
    
    private Type(ValueType paramValueType)
    {
      this.valueType = paramValueType;
    }
    
    public ValueType getValueType()
    {
      return this.valueType;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\Variable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */