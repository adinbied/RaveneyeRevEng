package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.IOException;

public abstract interface MessageBufferInput
  extends Closeable
{
  public abstract MessageBuffer next()
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\MessageBufferInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */