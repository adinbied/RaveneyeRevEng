package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class JsonValueObjectEncoderContext
  implements ObjectEncoderContext, ValueEncoderContext
{
  private boolean active = true;
  private JsonValueObjectEncoderContext childContext = null;
  private final ObjectEncoder<Object> fallbackEncoder;
  private final boolean ignoreNullValues;
  private final JsonWriter jsonWriter;
  private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
  private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
  
  private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext paramJsonValueObjectEncoderContext)
  {
    this.jsonWriter = paramJsonValueObjectEncoderContext.jsonWriter;
    this.objectEncoders = paramJsonValueObjectEncoderContext.objectEncoders;
    this.valueEncoders = paramJsonValueObjectEncoderContext.valueEncoders;
    this.fallbackEncoder = paramJsonValueObjectEncoderContext.fallbackEncoder;
    this.ignoreNullValues = paramJsonValueObjectEncoderContext.ignoreNullValues;
  }
  
  JsonValueObjectEncoderContext(Writer paramWriter, Map<Class<?>, ObjectEncoder<?>> paramMap, Map<Class<?>, ValueEncoder<?>> paramMap1, ObjectEncoder<Object> paramObjectEncoder, boolean paramBoolean)
  {
    this.jsonWriter = new JsonWriter(paramWriter);
    this.objectEncoders = paramMap;
    this.valueEncoders = paramMap1;
    this.fallbackEncoder = paramObjectEncoder;
    this.ignoreNullValues = paramBoolean;
  }
  
  private boolean cannotBeInline(Object paramObject)
  {
    return (paramObject == null) || (paramObject.getClass().isArray()) || ((paramObject instanceof Collection)) || ((paramObject instanceof Date)) || ((paramObject instanceof Enum)) || ((paramObject instanceof Number));
  }
  
  private JsonValueObjectEncoderContext internalAdd(String paramString, Object paramObject)
    throws IOException, EncodingException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    if (paramObject == null)
    {
      this.jsonWriter.nullValue();
      return this;
    }
    return add(paramObject, false);
  }
  
  private JsonValueObjectEncoderContext internalAddIgnoreNullValues(String paramString, Object paramObject)
    throws IOException, EncodingException
  {
    if (paramObject == null) {
      return this;
    }
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramObject, false);
  }
  
  private void maybeUnNest()
    throws IOException
  {
    if (this.active)
    {
      JsonValueObjectEncoderContext localJsonValueObjectEncoderContext = this.childContext;
      if (localJsonValueObjectEncoderContext != null)
      {
        localJsonValueObjectEncoderContext.maybeUnNest();
        this.childContext.active = false;
        this.childContext = null;
        this.jsonWriter.endObject();
      }
      return;
    }
    throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
  }
  
  public JsonValueObjectEncoderContext add(double paramDouble)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramDouble);
    return this;
  }
  
  public JsonValueObjectEncoderContext add(int paramInt)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramInt);
    return this;
  }
  
  public JsonValueObjectEncoderContext add(long paramLong)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramLong);
    return this;
  }
  
  JsonValueObjectEncoderContext add(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if ((paramBoolean) && (cannotBeInline(paramObject)))
    {
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.getClass();
      }
      throw new EncodingException(String.format("%s cannot be encoded inline", new Object[] { paramObject }));
    }
    if (paramObject == null)
    {
      this.jsonWriter.nullValue();
      return this;
    }
    if ((paramObject instanceof Number))
    {
      this.jsonWriter.value((Number)paramObject);
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof byte[])) {
        return add((byte[])paramObject);
      }
      this.jsonWriter.beginArray();
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        j = paramObject.length;
        while (i < j)
        {
          k = paramObject[i];
          this.jsonWriter.value(k);
          i += 1;
        }
      }
      if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        k = paramObject.length;
        i = j;
        while (i < k)
        {
          add(paramObject[i]);
          i += 1;
        }
      }
      if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        j = paramObject.length;
        i = k;
        while (i < j)
        {
          double d = paramObject[i];
          this.jsonWriter.value(d);
          i += 1;
        }
      }
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        j = paramObject.length;
        i = m;
        while (i < j)
        {
          paramBoolean = paramObject[i];
          this.jsonWriter.value(paramBoolean);
          i += 1;
        }
      }
      if ((paramObject instanceof Number[]))
      {
        paramObject = (Number[])paramObject;
        j = paramObject.length;
        i = 0;
        while (i < j)
        {
          add(paramObject[i], false);
          i += 1;
        }
      }
      paramObject = (Object[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        add(paramObject[i], false);
        i += 1;
      }
      this.jsonWriter.endArray();
      return this;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = (Collection)paramObject;
      this.jsonWriter.beginArray();
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        add(((Iterator)paramObject).next(), false);
      }
      this.jsonWriter.endArray();
      return this;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      this.jsonWriter.beginObject();
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramObject = localEntry.getKey();
        try
        {
          add((String)paramObject, localEntry.getValue());
        }
        catch (ClassCastException localClassCastException)
        {
          throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[] { paramObject, paramObject.getClass() }), localClassCastException);
        }
      }
      this.jsonWriter.endObject();
      return this;
    }
    Object localObject = (ObjectEncoder)this.objectEncoders.get(paramObject.getClass());
    if (localObject != null) {
      return doEncode((ObjectEncoder)localObject, paramObject, paramBoolean);
    }
    localObject = (ValueEncoder)this.valueEncoders.get(paramObject.getClass());
    if (localObject != null)
    {
      ((ValueEncoder)localObject).encode(paramObject, this);
      return this;
    }
    if ((paramObject instanceof Enum))
    {
      add(((Enum)paramObject).name());
      return this;
    }
    return doEncode(this.fallbackEncoder, paramObject, paramBoolean);
  }
  
  public JsonValueObjectEncoderContext add(String paramString)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramString);
    return this;
  }
  
  public JsonValueObjectEncoderContext add(String paramString, double paramDouble)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramDouble);
  }
  
  public JsonValueObjectEncoderContext add(String paramString, int paramInt)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramInt);
  }
  
  public JsonValueObjectEncoderContext add(String paramString, long paramLong)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramLong);
  }
  
  public JsonValueObjectEncoderContext add(String paramString, Object paramObject)
    throws IOException
  {
    if (this.ignoreNullValues) {
      return internalAddIgnoreNullValues(paramString, paramObject);
    }
    return internalAdd(paramString, paramObject);
  }
  
  public JsonValueObjectEncoderContext add(String paramString, boolean paramBoolean)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramBoolean);
  }
  
  public JsonValueObjectEncoderContext add(boolean paramBoolean)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramBoolean);
    return this;
  }
  
  public JsonValueObjectEncoderContext add(byte[] paramArrayOfByte)
    throws IOException
  {
    maybeUnNest();
    if (paramArrayOfByte == null)
    {
      this.jsonWriter.nullValue();
      return this;
    }
    this.jsonWriter.value(Base64.encodeToString(paramArrayOfByte, 2));
    return this;
  }
  
  void close()
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.flush();
  }
  
  JsonValueObjectEncoderContext doEncode(ObjectEncoder<Object> paramObjectEncoder, Object paramObject, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {
      this.jsonWriter.beginObject();
    }
    paramObjectEncoder.encode(paramObject, this);
    if (!paramBoolean) {
      this.jsonWriter.endObject();
    }
    return this;
  }
  
  public ObjectEncoderContext inline(Object paramObject)
    throws IOException
  {
    return add(paramObject, true);
  }
  
  public ObjectEncoderContext nested(String paramString)
    throws IOException
  {
    maybeUnNest();
    this.childContext = new JsonValueObjectEncoderContext(this);
    this.jsonWriter.name(paramString);
    this.jsonWriter.beginObject();
    return this.childContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\json\JsonValueObjectEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */