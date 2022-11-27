package org.msgpack.core.buffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayBufferOutput
  implements MessageBufferOutput
{
  private int bufferSize;
  private MessageBuffer lastBuffer;
  private List<MessageBuffer> list;
  
  public ArrayBufferOutput()
  {
    this(8192);
  }
  
  public ArrayBufferOutput(int paramInt)
  {
    this.bufferSize = paramInt;
    this.list = new ArrayList();
  }
  
  public void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = MessageBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    this.list.add(paramArrayOfByte);
  }
  
  public void clear()
  {
    this.list.clear();
  }
  
  public void close() {}
  
  public void flush() {}
  
  public int getSize()
  {
    Iterator localIterator = this.list.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((MessageBuffer)localIterator.next()).size();
    }
    return i;
  }
  
  public MessageBuffer next(int paramInt)
  {
    MessageBuffer localMessageBuffer = this.lastBuffer;
    if ((localMessageBuffer != null) && (localMessageBuffer.size() > paramInt)) {
      return this.lastBuffer;
    }
    localMessageBuffer = MessageBuffer.allocate(Math.max(this.bufferSize, paramInt));
    this.lastBuffer = localMessageBuffer;
    return localMessageBuffer;
  }
  
  public List<MessageBuffer> toBufferList()
  {
    return new ArrayList(this.list);
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[getSize()];
    Iterator localIterator = this.list.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MessageBuffer localMessageBuffer = (MessageBuffer)localIterator.next();
      localMessageBuffer.getBytes(0, arrayOfByte, i, localMessageBuffer.size());
      i += localMessageBuffer.size();
    }
    return arrayOfByte;
  }
  
  public MessageBuffer toMessageBuffer()
  {
    if (this.list.size() == 1) {
      return (MessageBuffer)this.list.get(0);
    }
    if (this.list.isEmpty()) {
      return MessageBuffer.allocate(0);
    }
    return MessageBuffer.wrap(toByteArray());
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    MessageBuffer localMessageBuffer = MessageBuffer.allocate(paramInt2);
    localMessageBuffer.putBytes(0, paramArrayOfByte, paramInt1, paramInt2);
    this.list.add(localMessageBuffer);
  }
  
  public void writeBuffer(int paramInt)
  {
    this.list.add(this.lastBuffer.slice(0, paramInt));
    if (this.lastBuffer.size() - paramInt > this.bufferSize / 4)
    {
      MessageBuffer localMessageBuffer = this.lastBuffer;
      this.lastBuffer = localMessageBuffer.slice(paramInt, localMessageBuffer.size() - paramInt);
      return;
    }
    this.lastBuffer = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\ArrayBufferOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */