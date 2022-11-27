package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters
{
  public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
  public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
  public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
  public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
  public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
  public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
  public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
  public static final TypeAdapter<BigInteger> BIG_INTEGER;
  public static final TypeAdapter<BitSet> BIT_SET;
  public static final TypeAdapterFactory BIT_SET_FACTORY;
  public static final TypeAdapter<Boolean> BOOLEAN;
  public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
  public static final TypeAdapterFactory BOOLEAN_FACTORY;
  public static final TypeAdapter<Number> BYTE;
  public static final TypeAdapterFactory BYTE_FACTORY;
  public static final TypeAdapter<Calendar> CALENDAR;
  public static final TypeAdapterFactory CALENDAR_FACTORY;
  public static final TypeAdapter<Character> CHARACTER;
  public static final TypeAdapterFactory CHARACTER_FACTORY;
  public static final TypeAdapter<Class> CLASS;
  public static final TypeAdapterFactory CLASS_FACTORY;
  public static final TypeAdapter<Currency> CURRENCY;
  public static final TypeAdapterFactory CURRENCY_FACTORY;
  public static final TypeAdapter<Number> DOUBLE;
  public static final TypeAdapterFactory ENUM_FACTORY = new TypeAdapterFactory()
  {
    public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
    {
      paramAnonymousTypeToken = paramAnonymousTypeToken.getRawType();
      if ((Enum.class.isAssignableFrom(paramAnonymousTypeToken)) && (paramAnonymousTypeToken != Enum.class))
      {
        paramAnonymousGson = paramAnonymousTypeToken;
        if (!paramAnonymousTypeToken.isEnum()) {
          paramAnonymousGson = paramAnonymousTypeToken.getSuperclass();
        }
        return new TypeAdapters.EnumTypeAdapter(paramAnonymousGson);
      }
      return null;
    }
  };
  public static final TypeAdapter<Number> FLOAT;
  public static final TypeAdapter<InetAddress> INET_ADDRESS;
  public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
  public static final TypeAdapter<Number> INTEGER;
  public static final TypeAdapterFactory INTEGER_FACTORY;
  public static final TypeAdapter<JsonElement> JSON_ELEMENT;
  public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
  public static final TypeAdapter<Locale> LOCALE;
  public static final TypeAdapterFactory LOCALE_FACTORY;
  public static final TypeAdapter<Number> LONG;
  public static final TypeAdapter<Number> NUMBER;
  public static final TypeAdapterFactory NUMBER_FACTORY;
  public static final TypeAdapter<Number> SHORT;
  public static final TypeAdapterFactory SHORT_FACTORY;
  public static final TypeAdapter<String> STRING;
  public static final TypeAdapter<StringBuffer> STRING_BUFFER;
  public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
  public static final TypeAdapter<StringBuilder> STRING_BUILDER;
  public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
  public static final TypeAdapterFactory STRING_FACTORY;
  public static final TypeAdapterFactory TIMESTAMP_FACTORY;
  public static final TypeAdapter<URI> URI;
  public static final TypeAdapterFactory URI_FACTORY;
  public static final TypeAdapter<URL> URL;
  public static final TypeAdapterFactory URL_FACTORY;
  public static final TypeAdapter<UUID> UUID;
  public static final TypeAdapterFactory UUID_FACTORY;
  
  static
  {
    Object localObject = new TypeAdapter()
    {
      public Class read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Class paramAnonymousClass)
        throws IOException
      {
        paramAnonymousJsonWriter = new StringBuilder();
        paramAnonymousJsonWriter.append("Attempted to serialize java.lang.Class: ");
        paramAnonymousJsonWriter.append(paramAnonymousClass.getName());
        paramAnonymousJsonWriter.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(paramAnonymousJsonWriter.toString());
      }
    }.nullSafe();
    CLASS = (TypeAdapter)localObject;
    CLASS_FACTORY = newFactory(Class.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public BitSet read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        BitSet localBitSet = new BitSet();
        paramAnonymousJsonReader.beginArray();
        Object localObject = paramAnonymousJsonReader.peek();
        int i = 0;
        while (localObject != JsonToken.END_ARRAY)
        {
          int j = TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[localObject.ordinal()];
          boolean bool = true;
          if (j != 1) {
            if (j != 2) {
              if (j == 3) {
                localObject = paramAnonymousJsonReader.nextString();
              }
            }
          }
          while (paramAnonymousJsonReader.nextInt() == 0)
          {
            try
            {
              j = Integer.parseInt((String)localObject);
              if (j != 0) {
                break;
              }
              bool = false;
            }
            catch (NumberFormatException paramAnonymousJsonReader)
            {
              for (;;) {}
            }
            paramAnonymousJsonReader = new StringBuilder();
            paramAnonymousJsonReader.append("Error: Expecting: bitset number value (1, 0), Found: ");
            paramAnonymousJsonReader.append((String)localObject);
            throw new JsonSyntaxException(paramAnonymousJsonReader.toString());
            paramAnonymousJsonReader = new StringBuilder();
            paramAnonymousJsonReader.append("Invalid bitset value type: ");
            paramAnonymousJsonReader.append(localObject);
            throw new JsonSyntaxException(paramAnonymousJsonReader.toString());
            bool = paramAnonymousJsonReader.nextBoolean();
            break;
          }
          if (bool) {
            localBitSet.set(i);
          }
          i += 1;
          localObject = paramAnonymousJsonReader.peek();
        }
        paramAnonymousJsonReader.endArray();
        return localBitSet;
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, BitSet paramAnonymousBitSet)
        throws IOException
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
    }.nullSafe();
    BIT_SET = (TypeAdapter)localObject;
    BIT_SET_FACTORY = newFactory(BitSet.class, (TypeAdapter)localObject);
    BOOLEAN = new TypeAdapter()
    {
      public Boolean read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousJsonReader.peek();
        if (localJsonToken == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        if (localJsonToken == JsonToken.STRING) {
          return Boolean.valueOf(Boolean.parseBoolean(paramAnonymousJsonReader.nextString()));
        }
        return Boolean.valueOf(paramAnonymousJsonReader.nextBoolean());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Boolean paramAnonymousBoolean)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousBoolean);
      }
    };
    BOOLEAN_AS_STRING = new TypeAdapter()
    {
      public Boolean read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Boolean.valueOf(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Boolean paramAnonymousBoolean)
        throws IOException
      {
        if (paramAnonymousBoolean == null) {
          paramAnonymousBoolean = "null";
        } else {
          paramAnonymousBoolean = paramAnonymousBoolean.toString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousBoolean);
      }
    };
    BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    BYTE = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          byte b = (byte)paramAnonymousJsonReader.nextInt();
          return Byte.valueOf(b);
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
    SHORT = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          short s = (short)paramAnonymousJsonReader.nextInt();
          return Short.valueOf(s);
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
    INTEGER = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          int i = paramAnonymousJsonReader.nextInt();
          return Integer.valueOf(i);
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
    localObject = new TypeAdapter()
    {
      public AtomicInteger read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        try
        {
          paramAnonymousJsonReader = new AtomicInteger(paramAnonymousJsonReader.nextInt());
          return paramAnonymousJsonReader;
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, AtomicInteger paramAnonymousAtomicInteger)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousAtomicInteger.get());
      }
    }.nullSafe();
    ATOMIC_INTEGER = (TypeAdapter)localObject;
    ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public AtomicBoolean read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        return new AtomicBoolean(paramAnonymousJsonReader.nextBoolean());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, AtomicBoolean paramAnonymousAtomicBoolean)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousAtomicBoolean.get());
      }
    }.nullSafe();
    ATOMIC_BOOLEAN = (TypeAdapter)localObject;
    ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public AtomicIntegerArray read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousJsonReader.beginArray();
        while (paramAnonymousJsonReader.hasNext()) {
          try
          {
            localArrayList.add(Integer.valueOf(paramAnonymousJsonReader.nextInt()));
          }
          catch (NumberFormatException paramAnonymousJsonReader)
          {
            throw new JsonSyntaxException(paramAnonymousJsonReader);
          }
        }
        paramAnonymousJsonReader.endArray();
        int j = localArrayList.size();
        paramAnonymousJsonReader = new AtomicIntegerArray(j);
        int i = 0;
        while (i < j)
        {
          paramAnonymousJsonReader.set(i, ((Integer)localArrayList.get(i)).intValue());
          i += 1;
        }
        return paramAnonymousJsonReader;
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, AtomicIntegerArray paramAnonymousAtomicIntegerArray)
        throws IOException
      {
        paramAnonymousJsonWriter.beginArray();
        int j = paramAnonymousAtomicIntegerArray.length();
        int i = 0;
        while (i < j)
        {
          paramAnonymousJsonWriter.value(paramAnonymousAtomicIntegerArray.get(i));
          i += 1;
        }
        paramAnonymousJsonWriter.endArray();
      }
    }.nullSafe();
    ATOMIC_INTEGER_ARRAY = (TypeAdapter)localObject;
    ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, (TypeAdapter)localObject);
    LONG = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          long l = paramAnonymousJsonReader.nextLong();
          return Long.valueOf(l);
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    FLOAT = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Float.valueOf((float)paramAnonymousJsonReader.nextDouble());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    DOUBLE = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Double.valueOf(paramAnonymousJsonReader.nextDouble());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    localObject = new TypeAdapter()
    {
      public Number read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousJsonReader.peek();
        int i = TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[localJsonToken.ordinal()];
        if ((i != 1) && (i != 3))
        {
          if (i == 4)
          {
            paramAnonymousJsonReader.nextNull();
            return null;
          }
          paramAnonymousJsonReader = new StringBuilder();
          paramAnonymousJsonReader.append("Expecting number, got: ");
          paramAnonymousJsonReader.append(localJsonToken);
          throw new JsonSyntaxException(paramAnonymousJsonReader.toString());
        }
        return new LazilyParsedNumber(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
    NUMBER = (TypeAdapter)localObject;
    NUMBER_FACTORY = newFactory(Number.class, (TypeAdapter)localObject);
    CHARACTER = new TypeAdapter()
    {
      public Character read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
        if (paramAnonymousJsonReader.length() == 1) {
          return Character.valueOf(paramAnonymousJsonReader.charAt(0));
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Expecting character, got: ");
        localStringBuilder.append(paramAnonymousJsonReader);
        throw new JsonSyntaxException(localStringBuilder.toString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Character paramAnonymousCharacter)
        throws IOException
      {
        if (paramAnonymousCharacter == null) {
          paramAnonymousCharacter = null;
        } else {
          paramAnonymousCharacter = String.valueOf(paramAnonymousCharacter);
        }
        paramAnonymousJsonWriter.value(paramAnonymousCharacter);
      }
    };
    CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
    STRING = new TypeAdapter()
    {
      public String read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        JsonToken localJsonToken = paramAnonymousJsonReader.peek();
        if (localJsonToken == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        if (localJsonToken == JsonToken.BOOLEAN) {
          return Boolean.toString(paramAnonymousJsonReader.nextBoolean());
        }
        return paramAnonymousJsonReader.nextString();
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, String paramAnonymousString)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousString);
      }
    };
    BIG_DECIMAL = new TypeAdapter()
    {
      public BigDecimal read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          paramAnonymousJsonReader = new BigDecimal(paramAnonymousJsonReader.nextString());
          return paramAnonymousJsonReader;
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, BigDecimal paramAnonymousBigDecimal)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousBigDecimal);
      }
    };
    BIG_INTEGER = new TypeAdapter()
    {
      public BigInteger read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          paramAnonymousJsonReader = new BigInteger(paramAnonymousJsonReader.nextString());
          return paramAnonymousJsonReader;
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new JsonSyntaxException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, BigInteger paramAnonymousBigInteger)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousBigInteger);
      }
    };
    STRING_FACTORY = newFactory(String.class, STRING);
    localObject = new TypeAdapter()
    {
      public StringBuilder read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return new StringBuilder(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, StringBuilder paramAnonymousStringBuilder)
        throws IOException
      {
        if (paramAnonymousStringBuilder == null) {
          paramAnonymousStringBuilder = null;
        } else {
          paramAnonymousStringBuilder = paramAnonymousStringBuilder.toString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousStringBuilder);
      }
    };
    STRING_BUILDER = (TypeAdapter)localObject;
    STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public StringBuffer read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return new StringBuffer(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, StringBuffer paramAnonymousStringBuffer)
        throws IOException
      {
        if (paramAnonymousStringBuffer == null) {
          paramAnonymousStringBuffer = null;
        } else {
          paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousStringBuffer);
      }
    };
    STRING_BUFFER = (TypeAdapter)localObject;
    STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public URL read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
        if ("null".equals(paramAnonymousJsonReader)) {
          return null;
        }
        return new URL(paramAnonymousJsonReader);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, URL paramAnonymousURL)
        throws IOException
      {
        if (paramAnonymousURL == null) {
          paramAnonymousURL = null;
        } else {
          paramAnonymousURL = paramAnonymousURL.toExternalForm();
        }
        paramAnonymousJsonWriter.value(paramAnonymousURL);
      }
    };
    URL = (TypeAdapter)localObject;
    URL_FACTORY = newFactory(URL.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public URI read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        try
        {
          paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
          if ("null".equals(paramAnonymousJsonReader)) {
            return null;
          }
          paramAnonymousJsonReader = new URI(paramAnonymousJsonReader);
          return paramAnonymousJsonReader;
        }
        catch (URISyntaxException paramAnonymousJsonReader)
        {
          throw new JsonIOException(paramAnonymousJsonReader);
        }
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, URI paramAnonymousURI)
        throws IOException
      {
        if (paramAnonymousURI == null) {
          paramAnonymousURI = null;
        } else {
          paramAnonymousURI = paramAnonymousURI.toASCIIString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousURI);
      }
    };
    URI = (TypeAdapter)localObject;
    URI_FACTORY = newFactory(URI.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public InetAddress read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return InetAddress.getByName(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, InetAddress paramAnonymousInetAddress)
        throws IOException
      {
        if (paramAnonymousInetAddress == null) {
          paramAnonymousInetAddress = null;
        } else {
          paramAnonymousInetAddress = paramAnonymousInetAddress.getHostAddress();
        }
        paramAnonymousJsonWriter.value(paramAnonymousInetAddress);
      }
    };
    INET_ADDRESS = (TypeAdapter)localObject;
    INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public UUID read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return UUID.fromString(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, UUID paramAnonymousUUID)
        throws IOException
      {
        if (paramAnonymousUUID == null) {
          paramAnonymousUUID = null;
        } else {
          paramAnonymousUUID = paramAnonymousUUID.toString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousUUID);
      }
    };
    UUID = (TypeAdapter)localObject;
    UUID_FACTORY = newFactory(UUID.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Currency read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        return Currency.getInstance(paramAnonymousJsonReader.nextString());
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Currency paramAnonymousCurrency)
        throws IOException
      {
        paramAnonymousJsonWriter.value(paramAnonymousCurrency.getCurrencyCode());
      }
    }.nullSafe();
    CURRENCY = (TypeAdapter)localObject;
    CURRENCY_FACTORY = newFactory(Currency.class, (TypeAdapter)localObject);
    TIMESTAMP_FACTORY = new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        if (paramAnonymousTypeToken.getRawType() != Timestamp.class) {
          return null;
        }
        new TypeAdapter()
        {
          public Timestamp read(JsonReader paramAnonymous2JsonReader)
            throws IOException
          {
            paramAnonymous2JsonReader = (Date)this.val$dateTypeAdapter.read(paramAnonymous2JsonReader);
            if (paramAnonymous2JsonReader != null) {
              return new Timestamp(paramAnonymous2JsonReader.getTime());
            }
            return null;
          }
          
          public void write(JsonWriter paramAnonymous2JsonWriter, Timestamp paramAnonymous2Timestamp)
            throws IOException
          {
            this.val$dateTypeAdapter.write(paramAnonymous2JsonWriter, paramAnonymous2Timestamp);
          }
        };
      }
    };
    localObject = new TypeAdapter()
    {
      private static final String DAY_OF_MONTH = "dayOfMonth";
      private static final String HOUR_OF_DAY = "hourOfDay";
      private static final String MINUTE = "minute";
      private static final String MONTH = "month";
      private static final String SECOND = "second";
      private static final String YEAR = "year";
      
      public Calendar read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        paramAnonymousJsonReader.beginObject();
        int i2 = 0;
        int i1 = 0;
        int n = 0;
        int m = 0;
        int k = 0;
        int j = 0;
        while (paramAnonymousJsonReader.peek() != JsonToken.END_OBJECT)
        {
          String str = paramAnonymousJsonReader.nextName();
          int i = paramAnonymousJsonReader.nextInt();
          if ("year".equals(str)) {
            i2 = i;
          } else if ("month".equals(str)) {
            i1 = i;
          } else if ("dayOfMonth".equals(str)) {
            n = i;
          } else if ("hourOfDay".equals(str)) {
            m = i;
          } else if ("minute".equals(str)) {
            k = i;
          } else if ("second".equals(str)) {
            j = i;
          }
        }
        paramAnonymousJsonReader.endObject();
        return new GregorianCalendar(i2, i1, n, m, k, j);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Calendar paramAnonymousCalendar)
        throws IOException
      {
        if (paramAnonymousCalendar == null)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        paramAnonymousJsonWriter.beginObject();
        paramAnonymousJsonWriter.name("year");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(1));
        paramAnonymousJsonWriter.name("month");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(2));
        paramAnonymousJsonWriter.name("dayOfMonth");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(5));
        paramAnonymousJsonWriter.name("hourOfDay");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(11));
        paramAnonymousJsonWriter.name("minute");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(12));
        paramAnonymousJsonWriter.name("second");
        paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(13));
        paramAnonymousJsonWriter.endObject();
      }
    };
    CALENDAR = (TypeAdapter)localObject;
    CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public Locale read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        Object localObject1 = paramAnonymousJsonReader.peek();
        Object localObject2 = JsonToken.NULL;
        String str = null;
        if (localObject1 == localObject2)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        localObject2 = new StringTokenizer(paramAnonymousJsonReader.nextString(), "_");
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          paramAnonymousJsonReader = ((StringTokenizer)localObject2).nextToken();
        } else {
          paramAnonymousJsonReader = null;
        }
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          localObject1 = ((StringTokenizer)localObject2).nextToken();
        } else {
          localObject1 = null;
        }
        if (((StringTokenizer)localObject2).hasMoreElements()) {
          str = ((StringTokenizer)localObject2).nextToken();
        }
        if ((localObject1 == null) && (str == null)) {
          return new Locale(paramAnonymousJsonReader);
        }
        if (str == null) {
          return new Locale(paramAnonymousJsonReader, (String)localObject1);
        }
        return new Locale(paramAnonymousJsonReader, (String)localObject1, str);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, Locale paramAnonymousLocale)
        throws IOException
      {
        if (paramAnonymousLocale == null) {
          paramAnonymousLocale = null;
        } else {
          paramAnonymousLocale = paramAnonymousLocale.toString();
        }
        paramAnonymousJsonWriter.value(paramAnonymousLocale);
      }
    };
    LOCALE = (TypeAdapter)localObject;
    LOCALE_FACTORY = newFactory(Locale.class, (TypeAdapter)localObject);
    localObject = new TypeAdapter()
    {
      public JsonElement read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        Object localObject;
        switch (TypeAdapters.36.$SwitchMap$com$google$gson$stream$JsonToken[paramAnonymousJsonReader.peek().ordinal()])
        {
        default: 
          throw new IllegalArgumentException();
        case 6: 
          localObject = new JsonObject();
          paramAnonymousJsonReader.beginObject();
          while (paramAnonymousJsonReader.hasNext()) {
            ((JsonObject)localObject).add(paramAnonymousJsonReader.nextName(), read(paramAnonymousJsonReader));
          }
          paramAnonymousJsonReader.endObject();
          return (JsonElement)localObject;
        case 5: 
          localObject = new JsonArray();
          paramAnonymousJsonReader.beginArray();
          while (paramAnonymousJsonReader.hasNext()) {
            ((JsonArray)localObject).add(read(paramAnonymousJsonReader));
          }
          paramAnonymousJsonReader.endArray();
          return (JsonElement)localObject;
        case 4: 
          paramAnonymousJsonReader.nextNull();
          return JsonNull.INSTANCE;
        case 3: 
          return new JsonPrimitive(paramAnonymousJsonReader.nextString());
        case 2: 
          return new JsonPrimitive(Boolean.valueOf(paramAnonymousJsonReader.nextBoolean()));
        }
        return new JsonPrimitive(new LazilyParsedNumber(paramAnonymousJsonReader.nextString()));
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, JsonElement paramAnonymousJsonElement)
        throws IOException
      {
        if ((paramAnonymousJsonElement != null) && (!paramAnonymousJsonElement.isJsonNull()))
        {
          if (paramAnonymousJsonElement.isJsonPrimitive())
          {
            paramAnonymousJsonElement = paramAnonymousJsonElement.getAsJsonPrimitive();
            if (paramAnonymousJsonElement.isNumber())
            {
              paramAnonymousJsonWriter.value(paramAnonymousJsonElement.getAsNumber());
              return;
            }
            if (paramAnonymousJsonElement.isBoolean())
            {
              paramAnonymousJsonWriter.value(paramAnonymousJsonElement.getAsBoolean());
              return;
            }
            paramAnonymousJsonWriter.value(paramAnonymousJsonElement.getAsString());
            return;
          }
          if (paramAnonymousJsonElement.isJsonArray())
          {
            paramAnonymousJsonWriter.beginArray();
            paramAnonymousJsonElement = paramAnonymousJsonElement.getAsJsonArray().iterator();
            while (paramAnonymousJsonElement.hasNext()) {
              write(paramAnonymousJsonWriter, (JsonElement)paramAnonymousJsonElement.next());
            }
            paramAnonymousJsonWriter.endArray();
            return;
          }
          if (paramAnonymousJsonElement.isJsonObject())
          {
            paramAnonymousJsonWriter.beginObject();
            paramAnonymousJsonElement = paramAnonymousJsonElement.getAsJsonObject().entrySet().iterator();
            while (paramAnonymousJsonElement.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramAnonymousJsonElement.next();
              paramAnonymousJsonWriter.name((String)localEntry.getKey());
              write(paramAnonymousJsonWriter, (JsonElement)localEntry.getValue());
            }
            paramAnonymousJsonWriter.endObject();
            return;
          }
          paramAnonymousJsonWriter = new StringBuilder();
          paramAnonymousJsonWriter.append("Couldn't write ");
          paramAnonymousJsonWriter.append(paramAnonymousJsonElement.getClass());
          throw new IllegalArgumentException(paramAnonymousJsonWriter.toString());
        }
        paramAnonymousJsonWriter.nullValue();
      }
    };
    JSON_ELEMENT = (TypeAdapter)localObject;
    JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, (TypeAdapter)localObject);
  }
  
  private TypeAdapters()
  {
    throw new UnsupportedOperationException();
  }
  
  public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> paramTypeToken, final TypeAdapter<TT> paramTypeAdapter)
  {
    new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        if (paramAnonymousTypeToken.equals(TypeAdapters.this)) {
          return paramTypeAdapter;
        }
        return null;
      }
    };
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass, final TypeAdapter<TT> paramTypeAdapter)
  {
    new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        if (paramAnonymousTypeToken.getRawType() == TypeAdapters.this) {
          return paramTypeAdapter;
        }
        return null;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> TypeAdapterFactory newFactory(Class<TT> paramClass1, final Class<TT> paramClass2, final TypeAdapter<? super TT> paramTypeAdapter)
  {
    new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        paramAnonymousGson = paramAnonymousTypeToken.getRawType();
        if ((paramAnonymousGson != TypeAdapters.this) && (paramAnonymousGson != paramClass2)) {
          return null;
        }
        return paramTypeAdapter;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(paramClass2.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> paramClass, final Class<? extends TT> paramClass1, final TypeAdapter<? super TT> paramTypeAdapter)
  {
    new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        paramAnonymousGson = paramAnonymousTypeToken.getRawType();
        if ((paramAnonymousGson != TypeAdapters.this) && (paramAnonymousGson != paramClass1)) {
          return null;
        }
        return paramTypeAdapter;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(paramClass1.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> paramClass, final TypeAdapter<T1> paramTypeAdapter)
  {
    new TypeAdapterFactory()
    {
      public <T2> TypeAdapter<T2> create(final Gson paramAnonymousGson, TypeToken<T2> paramAnonymousTypeToken)
      {
        paramAnonymousGson = paramAnonymousTypeToken.getRawType();
        if (!TypeAdapters.this.isAssignableFrom(paramAnonymousGson)) {
          return null;
        }
        new TypeAdapter()
        {
          public T1 read(JsonReader paramAnonymous2JsonReader)
            throws IOException
          {
            paramAnonymous2JsonReader = TypeAdapters.35.this.val$typeAdapter.read(paramAnonymous2JsonReader);
            if (paramAnonymous2JsonReader != null)
            {
              if (paramAnonymousGson.isInstance(paramAnonymous2JsonReader)) {
                return paramAnonymous2JsonReader;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Expected a ");
              localStringBuilder.append(paramAnonymousGson.getName());
              localStringBuilder.append(" but was ");
              localStringBuilder.append(paramAnonymous2JsonReader.getClass().getName());
              throw new JsonSyntaxException(localStringBuilder.toString());
            }
            return paramAnonymous2JsonReader;
          }
          
          public void write(JsonWriter paramAnonymous2JsonWriter, T1 paramAnonymous2T1)
            throws IOException
          {
            TypeAdapters.35.this.val$typeAdapter.write(paramAnonymous2JsonWriter, paramAnonymous2T1);
          }
        };
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[typeHierarchy=");
        localStringBuilder.append(TypeAdapters.this.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramTypeAdapter);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  private static final class EnumTypeAdapter<T extends Enum<T>>
    extends TypeAdapter<T>
  {
    private final Map<T, String> constantToName = new HashMap();
    private final Map<String, T> nameToConstant = new HashMap();
    
    public EnumTypeAdapter(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (SerializedName)paramClass.getField((String)localObject1).getAnnotation(SerializedName.class);
          if (localObject2 != null)
          {
            String str = ((SerializedName)localObject2).value();
            localObject2 = ((SerializedName)localObject2).alternate();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.nameToConstant.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.nameToConstant.put(localObject1, localEnum);
          this.constantToName.put(localEnum, localObject1);
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public T read(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      return (Enum)this.nameToConstant.get(paramJsonReader.nextString());
    }
    
    public void write(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null) {
        paramT = null;
      } else {
        paramT = (String)this.constantToName.get(paramT);
      }
      paramJsonWriter.value(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\bind\TypeAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */