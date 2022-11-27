package com.squareup.wire;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public abstract class ProtoAdapter<E>
{
  public static final ProtoAdapter<Boolean> BOOL = new ProtoAdapter(FieldEncoding.VARINT, Boolean.class)
  {
    public Boolean decode(ProtoReader paramAnonymousProtoReader)
      throws IOException
    {
      int i = paramAnonymousProtoReader.readVarint32();
      if (i == 0) {
        return Boolean.FALSE;
      }
      if (i == 1) {
        return Boolean.TRUE;
      }
      throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[] { Integer.valueOf(i) }));
    }
    
    public void encode(ProtoWriter paramAnonymousProtoWriter, Boolean paramAnonymousBoolean)
      throws IOException
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public int encodedSize(Boolean paramAnonymousBoolean)
    {
      return 1;
    }
  };
  public static final ProtoAdapter<ByteString> BYTES = new ProtoAdapter(FieldEncoding.LENGTH_DELIMITED, ByteString.class)
  {
    public ByteString decode(ProtoReader paramAnonymousProtoReader)
      throws IOException
    {
      return paramAnonymousProtoReader.readBytes();
    }
    
    public void encode(ProtoWriter paramAnonymousProtoWriter, ByteString paramAnonymousByteString)
      throws IOException
    {
      paramAnonymousProtoWriter.writeBytes(paramAnonymousByteString);
    }
    
    public int encodedSize(ByteString paramAnonymousByteString)
    {
      return paramAnonymousByteString.size();
    }
  };
  public static final ProtoAdapter<Double> DOUBLE;
  public static final ProtoAdapter<Integer> FIXED32;
  public static final ProtoAdapter<Long> FIXED64;
  private static final int FIXED_32_SIZE = 4;
  private static final int FIXED_64_SIZE = 8;
  private static final int FIXED_BOOL_SIZE = 1;
  public static final ProtoAdapter<Float> FLOAT;
  public static final ProtoAdapter<Integer> INT32 = new ProtoAdapter(FieldEncoding.VARINT, Integer.class)
  {
    public Integer decode(ProtoReader paramAnonymousProtoReader)
      throws IOException
    {
      return Integer.valueOf(paramAnonymousProtoReader.readVarint32());
    }
    
    public void encode(ProtoWriter paramAnonymousProtoWriter, Integer paramAnonymousInteger)
      throws IOException
    {
      paramAnonymousProtoWriter.writeSignedVarint32(paramAnonymousInteger.intValue());
    }
    
    public int encodedSize(Integer paramAnonymousInteger)
    {
      return ProtoWriter.int32Size(paramAnonymousInteger.intValue());
    }
  };
  public static final ProtoAdapter<Long> INT64;
  public static final ProtoAdapter<Integer> SFIXED32;
  public static final ProtoAdapter<Long> SFIXED64;
  public static final ProtoAdapter<Integer> SINT32;
  public static final ProtoAdapter<Long> SINT64;
  public static final ProtoAdapter<String> STRING;
  public static final ProtoAdapter<Integer> UINT32 = new ProtoAdapter(FieldEncoding.VARINT, Integer.class)
  {
    public Integer decode(ProtoReader paramAnonymousProtoReader)
      throws IOException
    {
      return Integer.valueOf(paramAnonymousProtoReader.readVarint32());
    }
    
    public void encode(ProtoWriter paramAnonymousProtoWriter, Integer paramAnonymousInteger)
      throws IOException
    {
      paramAnonymousProtoWriter.writeVarint32(paramAnonymousInteger.intValue());
    }
    
    public int encodedSize(Integer paramAnonymousInteger)
    {
      return ProtoWriter.varint32Size(paramAnonymousInteger.intValue());
    }
  };
  public static final ProtoAdapter<Long> UINT64;
  private final FieldEncoding fieldEncoding;
  final Class<?> javaType;
  ProtoAdapter<List<E>> packedAdapter;
  ProtoAdapter<List<E>> repeatedAdapter;
  
  static
  {
    SINT32 = new ProtoAdapter(FieldEncoding.VARINT, Integer.class)
    {
      public Integer decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Integer.valueOf(ProtoWriter.decodeZigZag32(paramAnonymousProtoReader.readVarint32()));
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Integer paramAnonymousInteger)
        throws IOException
      {
        paramAnonymousProtoWriter.writeVarint32(ProtoWriter.encodeZigZag32(paramAnonymousInteger.intValue()));
      }
      
      public int encodedSize(Integer paramAnonymousInteger)
      {
        return ProtoWriter.varint32Size(ProtoWriter.encodeZigZag32(paramAnonymousInteger.intValue()));
      }
    };
    Object localObject = new ProtoAdapter(FieldEncoding.FIXED32, Integer.class)
    {
      public Integer decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Integer.valueOf(paramAnonymousProtoReader.readFixed32());
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Integer paramAnonymousInteger)
        throws IOException
      {
        paramAnonymousProtoWriter.writeFixed32(paramAnonymousInteger.intValue());
      }
      
      public int encodedSize(Integer paramAnonymousInteger)
      {
        return 4;
      }
    };
    FIXED32 = (ProtoAdapter)localObject;
    SFIXED32 = (ProtoAdapter)localObject;
    INT64 = new ProtoAdapter(FieldEncoding.VARINT, Long.class)
    {
      public Long decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Long.valueOf(paramAnonymousProtoReader.readVarint64());
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousProtoWriter.writeVarint64(paramAnonymousLong.longValue());
      }
      
      public int encodedSize(Long paramAnonymousLong)
      {
        return ProtoWriter.varint64Size(paramAnonymousLong.longValue());
      }
    };
    UINT64 = new ProtoAdapter(FieldEncoding.VARINT, Long.class)
    {
      public Long decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Long.valueOf(paramAnonymousProtoReader.readVarint64());
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousProtoWriter.writeVarint64(paramAnonymousLong.longValue());
      }
      
      public int encodedSize(Long paramAnonymousLong)
      {
        return ProtoWriter.varint64Size(paramAnonymousLong.longValue());
      }
    };
    SINT64 = new ProtoAdapter(FieldEncoding.VARINT, Long.class)
    {
      public Long decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Long.valueOf(ProtoWriter.decodeZigZag64(paramAnonymousProtoReader.readVarint64()));
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousProtoWriter.writeVarint64(ProtoWriter.encodeZigZag64(paramAnonymousLong.longValue()));
      }
      
      public int encodedSize(Long paramAnonymousLong)
      {
        return ProtoWriter.varint64Size(ProtoWriter.encodeZigZag64(paramAnonymousLong.longValue()));
      }
    };
    localObject = new ProtoAdapter(FieldEncoding.FIXED64, Long.class)
    {
      public Long decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Long.valueOf(paramAnonymousProtoReader.readFixed64());
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousProtoWriter.writeFixed64(paramAnonymousLong.longValue());
      }
      
      public int encodedSize(Long paramAnonymousLong)
      {
        return 8;
      }
    };
    FIXED64 = (ProtoAdapter)localObject;
    SFIXED64 = (ProtoAdapter)localObject;
    FLOAT = new ProtoAdapter(FieldEncoding.FIXED32, Float.class)
    {
      public Float decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Float.valueOf(Float.intBitsToFloat(paramAnonymousProtoReader.readFixed32()));
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Float paramAnonymousFloat)
        throws IOException
      {
        paramAnonymousProtoWriter.writeFixed32(Float.floatToIntBits(paramAnonymousFloat.floatValue()));
      }
      
      public int encodedSize(Float paramAnonymousFloat)
      {
        return 4;
      }
    };
    DOUBLE = new ProtoAdapter(FieldEncoding.FIXED64, Double.class)
    {
      public Double decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Double.valueOf(Double.longBitsToDouble(paramAnonymousProtoReader.readFixed64()));
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, Double paramAnonymousDouble)
        throws IOException
      {
        paramAnonymousProtoWriter.writeFixed64(Double.doubleToLongBits(paramAnonymousDouble.doubleValue()));
      }
      
      public int encodedSize(Double paramAnonymousDouble)
      {
        return 8;
      }
    };
    STRING = new ProtoAdapter(FieldEncoding.LENGTH_DELIMITED, String.class)
    {
      public String decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return paramAnonymousProtoReader.readString();
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, String paramAnonymousString)
        throws IOException
      {
        paramAnonymousProtoWriter.writeString(paramAnonymousString);
      }
      
      public int encodedSize(String paramAnonymousString)
      {
        return ProtoWriter.utf8Length(paramAnonymousString);
      }
    };
  }
  
  public ProtoAdapter(FieldEncoding paramFieldEncoding, Class<?> paramClass)
  {
    this.fieldEncoding = paramFieldEncoding;
    this.javaType = paramClass;
  }
  
  private ProtoAdapter<List<E>> createPacked()
  {
    if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) {
      new ProtoAdapter(FieldEncoding.LENGTH_DELIMITED, List.class)
      {
        public List<E> decode(ProtoReader paramAnonymousProtoReader)
          throws IOException
        {
          return Collections.singletonList(ProtoAdapter.this.decode(paramAnonymousProtoReader));
        }
        
        public void encode(ProtoWriter paramAnonymousProtoWriter, List<E> paramAnonymousList)
          throws IOException
        {
          int j = paramAnonymousList.size();
          int i = 0;
          while (i < j)
          {
            ProtoAdapter.this.encode(paramAnonymousProtoWriter, paramAnonymousList.get(i));
            i += 1;
          }
        }
        
        public void encodeWithTag(ProtoWriter paramAnonymousProtoWriter, int paramAnonymousInt, List<E> paramAnonymousList)
          throws IOException
        {
          if (!paramAnonymousList.isEmpty()) {
            super.encodeWithTag(paramAnonymousProtoWriter, paramAnonymousInt, paramAnonymousList);
          }
        }
        
        public int encodedSize(List<E> paramAnonymousList)
        {
          int k = paramAnonymousList.size();
          int i = 0;
          int j = 0;
          while (i < k)
          {
            j += ProtoAdapter.this.encodedSize(paramAnonymousList.get(i));
            i += 1;
          }
          return j;
        }
        
        public int encodedSizeWithTag(int paramAnonymousInt, List<E> paramAnonymousList)
        {
          if (paramAnonymousList.isEmpty()) {
            return 0;
          }
          return super.encodedSizeWithTag(paramAnonymousInt, paramAnonymousList);
        }
        
        public List<E> redact(List<E> paramAnonymousList)
        {
          return Collections.emptyList();
        }
      };
    }
    throw new IllegalArgumentException("Unable to pack a length-delimited type.");
  }
  
  private ProtoAdapter<List<E>> createRepeated()
  {
    new ProtoAdapter(this.fieldEncoding, List.class)
    {
      public List<E> decode(ProtoReader paramAnonymousProtoReader)
        throws IOException
      {
        return Collections.singletonList(ProtoAdapter.this.decode(paramAnonymousProtoReader));
      }
      
      public void encode(ProtoWriter paramAnonymousProtoWriter, List<E> paramAnonymousList)
      {
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
      }
      
      public void encodeWithTag(ProtoWriter paramAnonymousProtoWriter, int paramAnonymousInt, List<E> paramAnonymousList)
        throws IOException
      {
        int j = paramAnonymousList.size();
        int i = 0;
        while (i < j)
        {
          ProtoAdapter.this.encodeWithTag(paramAnonymousProtoWriter, paramAnonymousInt, paramAnonymousList.get(i));
          i += 1;
        }
      }
      
      public int encodedSize(List<E> paramAnonymousList)
      {
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
      }
      
      public int encodedSizeWithTag(int paramAnonymousInt, List<E> paramAnonymousList)
      {
        int k = paramAnonymousList.size();
        int i = 0;
        int j = 0;
        while (i < k)
        {
          j += ProtoAdapter.this.encodedSizeWithTag(paramAnonymousInt, paramAnonymousList.get(i));
          i += 1;
        }
        return j;
      }
      
      public List<E> redact(List<E> paramAnonymousList)
      {
        return Collections.emptyList();
      }
    };
  }
  
  public static <M extends Message> ProtoAdapter<M> get(M paramM)
  {
    return get(paramM.getClass());
  }
  
  public static <M> ProtoAdapter<M> get(Class<M> paramClass)
  {
    try
    {
      ProtoAdapter localProtoAdapter = (ProtoAdapter)paramClass.getField("ADAPTER").get(null);
      return localProtoAdapter;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}catch (IllegalAccessException localIllegalAccessException) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed to access ");
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("#ADAPTER");
    throw new IllegalArgumentException(localStringBuilder.toString(), localIllegalAccessException);
  }
  
  static ProtoAdapter<?> get(String paramString)
  {
    try
    {
      int i = paramString.indexOf('#');
      Object localObject1 = paramString.substring(0, i);
      localObject2 = paramString.substring(i + 1);
      localObject1 = (ProtoAdapter)Class.forName((String)localObject1).getField((String)localObject2).get(null);
      return (ProtoAdapter<?>)localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (NoSuchFieldException localNoSuchFieldException) {}catch (IllegalAccessException localIllegalAccessException) {}
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("failed to access ");
    ((StringBuilder)localObject2).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString(), localIllegalAccessException);
  }
  
  public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> paramClass)
  {
    return new RuntimeEnumAdapter(paramClass);
  }
  
  public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> paramProtoAdapter, ProtoAdapter<V> paramProtoAdapter1)
  {
    return new MapProtoAdapter(paramProtoAdapter, paramProtoAdapter1);
  }
  
  public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> paramClass)
  {
    return RuntimeMessageAdapter.create(paramClass);
  }
  
  public final ProtoAdapter<List<E>> asPacked()
  {
    ProtoAdapter localProtoAdapter = this.packedAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = createPacked();
    this.packedAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  public final ProtoAdapter<List<E>> asRepeated()
  {
    ProtoAdapter localProtoAdapter = this.repeatedAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = createRepeated();
    this.repeatedAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  public abstract E decode(ProtoReader paramProtoReader)
    throws IOException;
  
  public final E decode(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream, "stream == null");
    return (E)decode(Okio.buffer(Okio.source(paramInputStream)));
  }
  
  public final E decode(BufferedSource paramBufferedSource)
    throws IOException
  {
    Preconditions.checkNotNull(paramBufferedSource, "source == null");
    return (E)decode(new ProtoReader(paramBufferedSource));
  }
  
  public final E decode(ByteString paramByteString)
    throws IOException
  {
    Preconditions.checkNotNull(paramByteString, "bytes == null");
    return (E)decode(new Buffer().write(paramByteString));
  }
  
  public final E decode(byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramArrayOfByte, "bytes == null");
    return (E)decode(new Buffer().write(paramArrayOfByte));
  }
  
  public abstract void encode(ProtoWriter paramProtoWriter, E paramE)
    throws IOException;
  
  public final void encode(OutputStream paramOutputStream, E paramE)
    throws IOException
  {
    Preconditions.checkNotNull(paramE, "value == null");
    Preconditions.checkNotNull(paramOutputStream, "stream == null");
    paramOutputStream = Okio.buffer(Okio.sink(paramOutputStream));
    encode(paramOutputStream, paramE);
    paramOutputStream.emit();
  }
  
  public final void encode(BufferedSink paramBufferedSink, E paramE)
    throws IOException
  {
    Preconditions.checkNotNull(paramE, "value == null");
    Preconditions.checkNotNull(paramBufferedSink, "sink == null");
    encode(new ProtoWriter(paramBufferedSink), paramE);
  }
  
  public final byte[] encode(E paramE)
  {
    Preconditions.checkNotNull(paramE, "value == null");
    Buffer localBuffer = new Buffer();
    try
    {
      encode(localBuffer, paramE);
      return localBuffer.readByteArray();
    }
    catch (IOException paramE)
    {
      throw new AssertionError(paramE);
    }
  }
  
  public void encodeWithTag(ProtoWriter paramProtoWriter, int paramInt, E paramE)
    throws IOException
  {
    paramProtoWriter.writeTag(paramInt, this.fieldEncoding);
    if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
      paramProtoWriter.writeVarint32(encodedSize(paramE));
    }
    encode(paramProtoWriter, paramE);
  }
  
  public abstract int encodedSize(E paramE);
  
  public int encodedSizeWithTag(int paramInt, E paramE)
  {
    int j = encodedSize(paramE);
    int i = j;
    if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
      i = j + ProtoWriter.varint32Size(j);
    }
    return i + ProtoWriter.tagSize(paramInt);
  }
  
  public E redact(E paramE)
  {
    return null;
  }
  
  public String toString(E paramE)
  {
    return paramE.toString();
  }
  
  ProtoAdapter<?> withLabel(WireField.Label paramLabel)
  {
    if (paramLabel.isRepeated())
    {
      if (paramLabel.isPacked()) {
        return asPacked();
      }
      return asRepeated();
    }
    return this;
  }
  
  public static final class EnumConstantNotFoundException
    extends IllegalArgumentException
  {
    public final int value;
    
    EnumConstantNotFoundException(int paramInt, Class<?> paramClass)
    {
      super();
      this.value = paramInt;
    }
  }
  
  private static final class MapEntryProtoAdapter<K, V>
    extends ProtoAdapter<Map.Entry<K, V>>
  {
    final ProtoAdapter<K> keyAdapter;
    final ProtoAdapter<V> valueAdapter;
    
    MapEntryProtoAdapter(ProtoAdapter<K> paramProtoAdapter, ProtoAdapter<V> paramProtoAdapter1)
    {
      super(null);
      this.keyAdapter = paramProtoAdapter;
      this.valueAdapter = paramProtoAdapter1;
    }
    
    public Map.Entry<K, V> decode(ProtoReader paramProtoReader)
    {
      throw new UnsupportedOperationException();
    }
    
    public void encode(ProtoWriter paramProtoWriter, Map.Entry<K, V> paramEntry)
      throws IOException
    {
      this.keyAdapter.encodeWithTag(paramProtoWriter, 1, paramEntry.getKey());
      this.valueAdapter.encodeWithTag(paramProtoWriter, 2, paramEntry.getValue());
    }
    
    public int encodedSize(Map.Entry<K, V> paramEntry)
    {
      return this.keyAdapter.encodedSizeWithTag(1, paramEntry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, paramEntry.getValue());
    }
  }
  
  private static final class MapProtoAdapter<K, V>
    extends ProtoAdapter<Map<K, V>>
  {
    private final ProtoAdapter.MapEntryProtoAdapter<K, V> entryAdapter;
    
    MapProtoAdapter(ProtoAdapter<K> paramProtoAdapter, ProtoAdapter<V> paramProtoAdapter1)
    {
      super(null);
      this.entryAdapter = new ProtoAdapter.MapEntryProtoAdapter(paramProtoAdapter, paramProtoAdapter1);
    }
    
    public Map<K, V> decode(ProtoReader paramProtoReader)
      throws IOException
    {
      long l = paramProtoReader.beginMessage();
      Object localObject2 = null;
      Object localObject1 = null;
      for (;;)
      {
        int i = paramProtoReader.nextTag();
        if (i == -1) {
          break;
        }
        if (i != 1)
        {
          if (i == 2) {
            localObject1 = this.entryAdapter.valueAdapter.decode(paramProtoReader);
          }
        }
        else {
          localObject2 = this.entryAdapter.keyAdapter.decode(paramProtoReader);
        }
      }
      paramProtoReader.endMessage(l);
      if (localObject2 != null)
      {
        if (localObject1 != null) {
          return Collections.singletonMap(localObject2, localObject1);
        }
        throw new IllegalStateException("Map entry with null value");
      }
      throw new IllegalStateException("Map entry with null key");
    }
    
    public void encode(ProtoWriter paramProtoWriter, Map<K, V> paramMap)
    {
      throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }
    
    public void encodeWithTag(ProtoWriter paramProtoWriter, int paramInt, Map<K, V> paramMap)
      throws IOException
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        this.entryAdapter.encodeWithTag(paramProtoWriter, paramInt, localEntry);
      }
    }
    
    public int encodedSize(Map<K, V> paramMap)
    {
      throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }
    
    public int encodedSizeWithTag(int paramInt, Map<K, V> paramMap)
    {
      paramMap = paramMap.entrySet().iterator();
      int i = 0;
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        i += this.entryAdapter.encodedSizeWithTag(paramInt, localEntry);
      }
      return i;
    }
    
    public Map<K, V> redact(Map<K, V> paramMap)
    {
      return Collections.emptyMap();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\ProtoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */