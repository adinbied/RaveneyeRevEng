package org.java_websocket.framing;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.util.Charsetfunctions;

public class FramedataImpl1
  implements FrameBuilder
{
  protected static byte[] emptyarray = new byte[0];
  protected boolean fin;
  protected Framedata.Opcode optcode;
  protected boolean transferemasked;
  private ByteBuffer unmaskedpayload;
  
  public FramedataImpl1() {}
  
  public FramedataImpl1(Framedata.Opcode paramOpcode)
  {
    this.optcode = paramOpcode;
    this.unmaskedpayload = ByteBuffer.wrap(emptyarray);
  }
  
  public FramedataImpl1(Framedata paramFramedata)
  {
    this.fin = paramFramedata.isFin();
    this.optcode = paramFramedata.getOpcode();
    this.unmaskedpayload = paramFramedata.getPayloadData();
    this.transferemasked = paramFramedata.getTransfereMasked();
  }
  
  public void append(Framedata paramFramedata)
    throws InvalidFrameException
  {
    ByteBuffer localByteBuffer1 = paramFramedata.getPayloadData();
    if (this.unmaskedpayload == null)
    {
      this.unmaskedpayload = ByteBuffer.allocate(localByteBuffer1.remaining());
      localByteBuffer1.mark();
      this.unmaskedpayload.put(localByteBuffer1);
      localByteBuffer1.reset();
    }
    else
    {
      localByteBuffer1.mark();
      ByteBuffer localByteBuffer2 = this.unmaskedpayload;
      localByteBuffer2.position(localByteBuffer2.limit());
      localByteBuffer2 = this.unmaskedpayload;
      localByteBuffer2.limit(localByteBuffer2.capacity());
      if (localByteBuffer1.remaining() > this.unmaskedpayload.remaining())
      {
        localByteBuffer2 = ByteBuffer.allocate(localByteBuffer1.remaining() + this.unmaskedpayload.capacity());
        this.unmaskedpayload.flip();
        localByteBuffer2.put(this.unmaskedpayload);
        localByteBuffer2.put(localByteBuffer1);
        this.unmaskedpayload = localByteBuffer2;
      }
      else
      {
        this.unmaskedpayload.put(localByteBuffer1);
      }
      this.unmaskedpayload.rewind();
      localByteBuffer1.reset();
    }
    this.fin = paramFramedata.isFin();
  }
  
  public Framedata.Opcode getOpcode()
  {
    return this.optcode;
  }
  
  public ByteBuffer getPayloadData()
  {
    return this.unmaskedpayload;
  }
  
  public boolean getTransfereMasked()
  {
    return this.transferemasked;
  }
  
  public boolean isFin()
  {
    return this.fin;
  }
  
  public void setFin(boolean paramBoolean)
  {
    this.fin = paramBoolean;
  }
  
  public void setOptcode(Framedata.Opcode paramOpcode)
  {
    this.optcode = paramOpcode;
  }
  
  public void setPayload(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    this.unmaskedpayload = paramByteBuffer;
  }
  
  public void setTransferemasked(boolean paramBoolean)
  {
    this.transferemasked = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Framedata{ optcode:");
    localStringBuilder.append(getOpcode());
    localStringBuilder.append(", fin:");
    localStringBuilder.append(isFin());
    localStringBuilder.append(", payloadlength:");
    localStringBuilder.append(this.unmaskedpayload.limit());
    localStringBuilder.append(", payload:");
    localStringBuilder.append(Arrays.toString(Charsetfunctions.utf8Bytes(new String(this.unmaskedpayload.array()))));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\framing\FramedataImpl1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */