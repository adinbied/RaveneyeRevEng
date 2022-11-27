package com.squareup.wire;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>>
{
  private ProtoAdapter<Object> adapter;
  private final String adapterString;
  private final Field builderField;
  private final Method builderMethod;
  private ProtoAdapter<?> keyAdapter;
  private final String keyAdapterString;
  public final WireField.Label label;
  private final Field messageField;
  public final String name;
  public final boolean redacted;
  private ProtoAdapter<?> singleAdapter;
  public final int tag;
  
  FieldBinding(WireField paramWireField, Field paramField, Class<B> paramClass)
  {
    this.label = paramWireField.label();
    this.name = paramField.getName();
    this.tag = paramWireField.tag();
    this.keyAdapterString = paramWireField.keyAdapter();
    this.adapterString = paramWireField.adapter();
    this.redacted = paramWireField.redacted();
    this.messageField = paramField;
    this.builderField = getBuilderField(paramClass, this.name);
    this.builderMethod = getBuilderMethod(paramClass, this.name, paramField.getType());
  }
  
  private static Field getBuilderField(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject = paramClass.getField(paramString);
      return (Field)localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder field ");
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString);
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  private static Method getBuilderMethod(Class<?> paramClass1, String paramString, Class<?> paramClass2)
  {
    try
    {
      localObject = paramClass1.getMethod(paramString, new Class[] { paramClass2 });
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No builder method ");
    ((StringBuilder)localObject).append(paramClass1.getName());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(paramClass2.getName());
    ((StringBuilder)localObject).append(")");
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  ProtoAdapter<Object> adapter()
  {
    ProtoAdapter localProtoAdapter = this.adapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    if (isMap())
    {
      localProtoAdapter = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
      this.adapter = localProtoAdapter;
      return localProtoAdapter;
    }
    localProtoAdapter = singleAdapter().withLabel(this.label);
    this.adapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  Object get(M paramM)
  {
    try
    {
      paramM = this.messageField.get(paramM);
      return paramM;
    }
    catch (IllegalAccessException paramM)
    {
      throw new AssertionError(paramM);
    }
  }
  
  Object getFromBuilder(B paramB)
  {
    try
    {
      paramB = this.builderField.get(paramB);
      return paramB;
    }
    catch (IllegalAccessException paramB)
    {
      throw new AssertionError(paramB);
    }
  }
  
  boolean isMap()
  {
    return this.keyAdapterString.isEmpty() ^ true;
  }
  
  ProtoAdapter<?> keyAdapter()
  {
    ProtoAdapter localProtoAdapter = this.keyAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = ProtoAdapter.get(this.keyAdapterString);
    this.keyAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  void set(B paramB, Object paramObject)
  {
    try
    {
      if (this.label.isOneOf())
      {
        this.builderMethod.invoke(paramB, new Object[] { paramObject });
        return;
      }
      this.builderField.set(paramB, paramObject);
      return;
    }
    catch (InvocationTargetException paramB) {}catch (IllegalAccessException paramB) {}
    throw new AssertionError(paramB);
  }
  
  ProtoAdapter<?> singleAdapter()
  {
    ProtoAdapter localProtoAdapter = this.singleAdapter;
    if (localProtoAdapter != null) {
      return localProtoAdapter;
    }
    localProtoAdapter = ProtoAdapter.get(this.adapterString);
    this.singleAdapter = localProtoAdapter;
    return localProtoAdapter;
  }
  
  void value(B paramB, Object paramObject)
  {
    if (this.label.isRepeated())
    {
      ((List)getFromBuilder(paramB)).add(paramObject);
      return;
    }
    if (!this.keyAdapterString.isEmpty())
    {
      ((Map)getFromBuilder(paramB)).putAll((Map)paramObject);
      return;
    }
    set(paramB, paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\FieldBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */