package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.util.Charsetfunctions;

public class CloseFrameBuilder
  extends FramedataImpl1
  implements CloseFrame
{
  static final ByteBuffer emptybytebuffer = ByteBuffer.allocate(0);
  private int code;
  private String reason;
  
  public CloseFrameBuilder()
  {
    super(Framedata.Opcode.CLOSING);
    setFin(true);
  }
  
  public CloseFrameBuilder(int paramInt)
    throws InvalidDataException
  {
    super(Framedata.Opcode.CLOSING);
    setFin(true);
    setCodeAndMessage(paramInt, "");
  }
  
  public CloseFrameBuilder(int paramInt, String paramString)
    throws InvalidDataException
  {
    super(Framedata.Opcode.CLOSING);
    setFin(true);
    setCodeAndMessage(paramInt, paramString);
  }
  
  private void initCloseCode()
    throws InvalidFrameException
  {
    this.code = 1005;
    Object localObject = super.getPayloadData();
    ((ByteBuffer)localObject).mark();
    if (((ByteBuffer)localObject).remaining() >= 2)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.position(2);
      localByteBuffer.putShort(((ByteBuffer)localObject).getShort());
      localByteBuffer.position(0);
      int i = localByteBuffer.getInt();
      this.code = i;
      if ((i == 1006) || (i == 1015) || (i == 1005) || (i > 4999) || (i < 1000) || (i == 1004))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("closecode must not be sent over the wire: ");
        ((StringBuilder)localObject).append(this.code);
        throw new InvalidFrameException(((StringBuilder)localObject).toString());
      }
    }
    ((ByteBuffer)localObject).reset();
  }
  
  /* Error */
  private void initMessage()
    throws InvalidDataException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	org/java_websocket/framing/CloseFrameBuilder:code	I
    //   4: sipush 1005
    //   7: if_icmpne +15 -> 22
    //   10: aload_0
    //   11: aload_0
    //   12: invokespecial 56	org/java_websocket/framing/FramedataImpl1:getPayloadData	()Ljava/nio/ByteBuffer;
    //   15: invokestatic 111	org/java_websocket/util/Charsetfunctions:stringUtf8	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   18: putfield 113	org/java_websocket/framing/CloseFrameBuilder:reason	Ljava/lang/String;
    //   21: return
    //   22: aload_0
    //   23: invokespecial 56	org/java_websocket/framing/FramedataImpl1:getPayloadData	()Ljava/nio/ByteBuffer;
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 115	java/nio/ByteBuffer:position	()I
    //   31: istore_1
    //   32: aload_2
    //   33: aload_2
    //   34: invokevirtual 115	java/nio/ByteBuffer:position	()I
    //   37: iconst_2
    //   38: iadd
    //   39: invokevirtual 68	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   42: pop
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 111	org/java_websocket/util/Charsetfunctions:stringUtf8	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   48: putfield 113	org/java_websocket/framing/CloseFrameBuilder:reason	Ljava/lang/String;
    //   51: aload_2
    //   52: iload_1
    //   53: invokevirtual 68	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   56: pop
    //   57: return
    //   58: astore_3
    //   59: goto +13 -> 72
    //   62: astore_3
    //   63: new 50	org/java_websocket/exceptions/InvalidFrameException
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 118	org/java_websocket/exceptions/InvalidFrameException:<init>	(Ljava/lang/Throwable;)V
    //   71: athrow
    //   72: aload_2
    //   73: iload_1
    //   74: invokevirtual 68	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   77: pop
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	CloseFrameBuilder
    //   31	43	1	i	int
    //   26	47	2	localByteBuffer	ByteBuffer
    //   58	1	3	localObject	Object
    //   62	17	3	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   32	51	58	finally
    //   63	72	58	finally
    //   32	51	62	java/lang/IllegalArgumentException
  }
  
  private void setCodeAndMessage(int paramInt, String paramString)
    throws InvalidDataException
  {
    Object localObject2 = "";
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    if (paramInt == 1015)
    {
      paramInt = 1005;
      localObject1 = localObject2;
    }
    if (paramInt == 1005)
    {
      if (((String)localObject1).length() <= 0) {
        return;
      }
      throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
    }
    paramString = Charsetfunctions.utf8Bytes((String)localObject1);
    localObject1 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject1).putInt(paramInt);
    ((ByteBuffer)localObject1).position(2);
    localObject2 = ByteBuffer.allocate(paramString.length + 2);
    ((ByteBuffer)localObject2).put((ByteBuffer)localObject1);
    ((ByteBuffer)localObject2).put(paramString);
    ((ByteBuffer)localObject2).rewind();
    setPayload((ByteBuffer)localObject2);
  }
  
  public int getCloseCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.reason;
  }
  
  public ByteBuffer getPayloadData()
  {
    if (this.code == 1005) {
      return emptybytebuffer;
    }
    return super.getPayloadData();
  }
  
  public void setPayload(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    super.setPayload(paramByteBuffer);
    initCloseCode();
    initMessage();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("code: ");
    localStringBuilder.append(this.code);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\framing\CloseFrameBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */