package com.squareup.wire;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final transient ProtoAdapter<M> adapter;
  transient int cachedSerializedSize = 0;
  protected transient int hashCode = 0;
  private final transient ByteString unknownFields;
  
  protected Message(ProtoAdapter<M> paramProtoAdapter, ByteString paramByteString)
  {
    if (paramProtoAdapter != null)
    {
      if (paramByteString != null)
      {
        this.adapter = paramProtoAdapter;
        this.unknownFields = paramByteString;
        return;
      }
      throw new NullPointerException("unknownFields == null");
    }
    throw new NullPointerException("adapter == null");
  }
  
  public final ProtoAdapter<M> adapter()
  {
    return this.adapter;
  }
  
  public final void encode(OutputStream paramOutputStream)
    throws IOException
  {
    this.adapter.encode(paramOutputStream, this);
  }
  
  public final void encode(BufferedSink paramBufferedSink)
    throws IOException
  {
    this.adapter.encode(paramBufferedSink, this);
  }
  
  public final byte[] encode()
  {
    return this.adapter.encode(this);
  }
  
  public abstract Builder<M, B> newBuilder();
  
  public String toString()
  {
    return this.adapter.toString(this);
  }
  
  public final ByteString unknownFields()
  {
    ByteString localByteString = this.unknownFields;
    if (localByteString != null) {
      return localByteString;
    }
    return ByteString.EMPTY;
  }
  
  public final M withoutUnknownFields()
  {
    return newBuilder().clearUnknownFields().build();
  }
  
  protected final Object writeReplace()
    throws ObjectStreamException
  {
    return new MessageSerializedForm(encode(), getClass());
  }
  
  public static abstract class Builder<T extends Message<T, B>, B extends Builder<T, B>>
  {
    Buffer unknownFieldsBuffer;
    ProtoWriter unknownFieldsWriter;
    
    public final Builder<T, B> addUnknownField(int paramInt, FieldEncoding paramFieldEncoding, Object paramObject)
    {
      if (this.unknownFieldsWriter == null)
      {
        Buffer localBuffer = new Buffer();
        this.unknownFieldsBuffer = localBuffer;
        this.unknownFieldsWriter = new ProtoWriter(localBuffer);
      }
      try
      {
        paramFieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, paramInt, paramObject);
        return this;
      }
      catch (IOException paramFieldEncoding)
      {
        for (;;) {}
      }
      throw new AssertionError();
    }
    
    public final Builder<T, B> addUnknownFields(ByteString paramByteString)
    {
      if (paramByteString.size() > 0) {
        if (this.unknownFieldsWriter == null)
        {
          Buffer localBuffer = new Buffer();
          this.unknownFieldsBuffer = localBuffer;
          this.unknownFieldsWriter = new ProtoWriter(localBuffer);
        }
      }
      try
      {
        this.unknownFieldsWriter.writeBytes(paramByteString);
        return this;
      }
      catch (IOException paramByteString)
      {
        for (;;) {}
      }
      throw new AssertionError();
      return this;
    }
    
    public abstract T build();
    
    public final ByteString buildUnknownFields()
    {
      Buffer localBuffer = this.unknownFieldsBuffer;
      if (localBuffer != null) {
        return localBuffer.clone().readByteString();
      }
      return ByteString.EMPTY;
    }
    
    public final Builder<T, B> clearUnknownFields()
    {
      this.unknownFieldsWriter = null;
      this.unknownFieldsBuffer = null;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */