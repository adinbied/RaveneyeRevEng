package com.squareup.wire;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class RuntimeEnumAdapter<E extends WireEnum>
  extends ProtoAdapter<E>
{
  private Method fromValueMethod;
  private final Class<E> type;
  
  RuntimeEnumAdapter(Class<E> paramClass)
  {
    super(FieldEncoding.VARINT, paramClass);
    this.type = paramClass;
  }
  
  private Method getFromValueMethod()
  {
    Method localMethod = this.fromValueMethod;
    if (localMethod != null) {
      return localMethod;
    }
    try
    {
      localMethod = this.type.getMethod("fromValue", new Class[] { Integer.TYPE });
      this.fromValueMethod = localMethod;
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
  }
  
  public E decode(ProtoReader paramProtoReader)
    throws IOException
  {
    int i = paramProtoReader.readVarint32();
    try
    {
      paramProtoReader = (WireEnum)getFromValueMethod().invoke(null, new Object[] { Integer.valueOf(i) });
      if (paramProtoReader != null) {
        return paramProtoReader;
      }
      throw new ProtoAdapter.EnumConstantNotFoundException(i, this.type);
    }
    catch (InvocationTargetException paramProtoReader) {}catch (IllegalAccessException paramProtoReader) {}
    throw new AssertionError(paramProtoReader);
  }
  
  public void encode(ProtoWriter paramProtoWriter, E paramE)
    throws IOException
  {
    paramProtoWriter.writeVarint32(paramE.getValue());
  }
  
  public int encodedSize(E paramE)
  {
    return ProtoWriter.varint32Size(paramE.getValue());
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof RuntimeEnumAdapter)) && (((RuntimeEnumAdapter)paramObject).type == this.type);
  }
  
  public int hashCode()
  {
    return this.type.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\RuntimeEnumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */