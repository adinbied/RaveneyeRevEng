package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract interface Framedata
{
  public abstract void append(Framedata paramFramedata)
    throws InvalidFrameException;
  
  public abstract Opcode getOpcode();
  
  public abstract ByteBuffer getPayloadData();
  
  public abstract boolean getTransfereMasked();
  
  public abstract boolean isFin();
  
  public static enum Opcode
  {
    static
    {
      BINARY = new Opcode("BINARY", 2);
      PING = new Opcode("PING", 3);
      PONG = new Opcode("PONG", 4);
      Opcode localOpcode = new Opcode("CLOSING", 5);
      CLOSING = localOpcode;
      $VALUES = new Opcode[] { CONTINUOUS, TEXT, BINARY, PING, PONG, localOpcode };
    }
    
    private Opcode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\framing\Framedata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */