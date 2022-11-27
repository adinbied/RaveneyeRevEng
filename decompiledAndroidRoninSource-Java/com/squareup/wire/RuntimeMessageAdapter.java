package com.squareup.wire;

import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>>
  extends ProtoAdapter<M>
{
  private static final String REDACTED = "██";
  private final Class<B> builderType;
  private final Map<Integer, FieldBinding<M, B>> fieldBindings;
  private final Class<M> messageType;
  
  RuntimeMessageAdapter(Class<M> paramClass, Class<B> paramClass1, Map<Integer, FieldBinding<M, B>> paramMap)
  {
    super(FieldEncoding.LENGTH_DELIMITED, paramClass);
    this.messageType = paramClass;
    this.builderType = paramClass1;
    this.fieldBindings = paramMap;
  }
  
  static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> paramClass)
  {
    Class localClass = getBuilderType(paramClass);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      WireField localWireField = (WireField)localField.getAnnotation(WireField.class);
      if (localWireField != null) {
        localLinkedHashMap.put(Integer.valueOf(localWireField.tag()), new FieldBinding(localWireField, localField, localClass));
      }
      i += 1;
    }
    return new RuntimeMessageAdapter(paramClass, localClass, Collections.unmodifiableMap(localLinkedHashMap));
  }
  
  private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> paramClass)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("$Builder");
      localObject = Class.forName(((StringBuilder)localObject).toString());
      return (Class<B>)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder class found for message type ");
    ((StringBuilder)localObject).append(paramClass.getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public M decode(ProtoReader paramProtoReader)
    throws IOException
  {
    Message.Builder localBuilder = newBuilder();
    long l = paramProtoReader.beginMessage();
    int i;
    for (;;)
    {
      i = paramProtoReader.nextTag();
      if (i == -1) {
        break;
      }
      FieldBinding localFieldBinding = (FieldBinding)this.fieldBindings.get(Integer.valueOf(i));
      if (localFieldBinding != null) {}
      try
      {
        if (localFieldBinding.isMap()) {
          localObject = localFieldBinding.adapter();
        } else {
          localObject = localFieldBinding.singleAdapter();
        }
        localFieldBinding.value(localBuilder, ((ProtoAdapter)localObject).decode(paramProtoReader));
      }
      catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
      {
        Object localObject;
        localBuilder.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
      }
      localObject = paramProtoReader.peekFieldEncoding();
      localBuilder.addUnknownField(i, (FieldEncoding)localObject, ((FieldEncoding)localObject).rawProtoAdapter().decode(paramProtoReader));
    }
    paramProtoReader.endMessage(l);
    return localBuilder.build();
  }
  
  public void encode(ProtoWriter paramProtoWriter, M paramM)
    throws IOException
  {
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null) {
        localFieldBinding.adapter().encodeWithTag(paramProtoWriter, localFieldBinding.tag, localObject);
      }
    }
    paramProtoWriter.writeBytes(paramM.unknownFields());
  }
  
  public int encodedSize(M paramM)
  {
    int i = paramM.cachedSerializedSize;
    if (i != 0) {
      return i;
    }
    i = 0;
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null) {
        i += localFieldBinding.adapter().encodedSizeWithTag(localFieldBinding.tag, localObject);
      }
    }
    i += paramM.unknownFields().size();
    paramM.cachedSerializedSize = i;
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof RuntimeMessageAdapter)) && (((RuntimeMessageAdapter)paramObject).messageType == this.messageType);
  }
  
  Map<Integer, FieldBinding<M, B>> fieldBindings()
  {
    return this.fieldBindings;
  }
  
  public int hashCode()
  {
    return this.messageType.hashCode();
  }
  
  B newBuilder()
  {
    try
    {
      Message.Builder localBuilder = (Message.Builder)this.builderType.newInstance();
      return localBuilder;
    }
    catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new AssertionError(localIllegalAccessException);
  }
  
  public M redact(M paramM)
  {
    paramM = paramM.newBuilder();
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      if ((localFieldBinding.redacted) && (localFieldBinding.label == WireField.Label.REQUIRED)) {
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[] { localFieldBinding.name, this.javaType.getName() }));
      }
      boolean bool = Message.class.isAssignableFrom(localFieldBinding.singleAdapter().javaType);
      if ((!localFieldBinding.redacted) && ((!bool) || (localFieldBinding.label.isRepeated())))
      {
        if ((bool) && (localFieldBinding.label.isRepeated())) {
          Internal.redactElements((List)localFieldBinding.getFromBuilder(paramM), localFieldBinding.singleAdapter());
        }
      }
      else
      {
        Object localObject = localFieldBinding.getFromBuilder(paramM);
        if (localObject != null) {
          localFieldBinding.set(paramM, localFieldBinding.adapter().redact(localObject));
        }
      }
    }
    paramM.clearUnknownFields();
    return paramM.build();
  }
  
  public String toString(M paramM)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.fieldBindings.values().iterator();
    while (localIterator.hasNext())
    {
      FieldBinding localFieldBinding = (FieldBinding)localIterator.next();
      Object localObject = localFieldBinding.get(paramM);
      if (localObject != null)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(localFieldBinding.name);
        localStringBuilder.append('=');
        if (localFieldBinding.redacted) {
          localObject = "██";
        }
        localStringBuilder.append(localObject);
      }
    }
    paramM = new StringBuilder();
    paramM.append(this.messageType.getSimpleName());
    paramM.append('{');
    localStringBuilder.replace(0, 2, paramM.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\RuntimeMessageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */