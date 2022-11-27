package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;

public abstract interface FrameBuilder
  extends Framedata
{
  public abstract void setFin(boolean paramBoolean);
  
  public abstract void setOptcode(Framedata.Opcode paramOpcode);
  
  public abstract void setPayload(ByteBuffer paramByteBuffer)
    throws InvalidDataException;
  
  public abstract void setTransferemasked(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\framing\FrameBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */