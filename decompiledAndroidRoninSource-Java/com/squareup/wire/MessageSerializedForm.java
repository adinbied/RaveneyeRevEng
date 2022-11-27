package com.squareup.wire;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final byte[] bytes;
  private final Class<M> messageClass;
  
  public MessageSerializedForm(byte[] paramArrayOfByte, Class<M> paramClass)
  {
    this.bytes = paramArrayOfByte;
    this.messageClass = paramClass;
  }
  
  Object readResolve()
    throws ObjectStreamException
  {
    Object localObject = ProtoAdapter.get(this.messageClass);
    try
    {
      localObject = ((ProtoAdapter)localObject).decode(this.bytes);
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new StreamCorruptedException(localIOException.getMessage());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\MessageSerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */