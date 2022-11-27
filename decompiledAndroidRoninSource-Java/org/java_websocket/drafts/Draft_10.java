package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.WebSocket.Role;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;

public class Draft_10
  extends Draft
{
  private Framedata fragmentedframe = null;
  private ByteBuffer incompleteframe;
  private final Random reuseableRandom = new Random();
  
  private byte fromOpcode(Framedata.Opcode paramOpcode)
  {
    if (paramOpcode == Framedata.Opcode.CONTINUOUS) {
      return 0;
    }
    if (paramOpcode == Framedata.Opcode.TEXT) {
      return 1;
    }
    if (paramOpcode == Framedata.Opcode.BINARY) {
      return 2;
    }
    if (paramOpcode == Framedata.Opcode.CLOSING) {
      return 8;
    }
    if (paramOpcode == Framedata.Opcode.PING) {
      return 9;
    }
    if (paramOpcode == Framedata.Opcode.PONG) {
      return 10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Don't know how to handle ");
    localStringBuilder.append(paramOpcode.toString());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private String generateFinalKey(String paramString)
  {
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = MessageDigest.getInstance("SHA1");
      return Base64.encodeBytes(((MessageDigest)localObject).digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static int readVersion(Handshakedata paramHandshakedata)
  {
    paramHandshakedata = paramHandshakedata.getFieldValue("Sec-WebSocket-Version");
    if (paramHandshakedata.length() > 0) {}
    try
    {
      int i = new Integer(paramHandshakedata.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramHandshakedata) {}
    return -1;
    return -1;
  }
  
  private byte[] toByteArray(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private Framedata.Opcode toOpcode(byte paramByte)
    throws InvalidFrameException
  {
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2)
        {
          switch (paramByte)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknow optcode ");
            localStringBuilder.append((short)paramByte);
            throw new InvalidFrameException(localStringBuilder.toString());
          case 10: 
            return Framedata.Opcode.PONG;
          case 9: 
            return Framedata.Opcode.PING;
          }
          return Framedata.Opcode.CLOSING;
        }
        return Framedata.Opcode.BINARY;
      }
      return Framedata.Opcode.TEXT;
    }
    return Framedata.Opcode.CONTINUOUS;
  }
  
  public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidHandshakeException
  {
    if ((paramClientHandshake.hasFieldValue("Sec-WebSocket-Key")) && (paramServerHandshake.hasFieldValue("Sec-WebSocket-Accept")))
    {
      paramServerHandshake = paramServerHandshake.getFieldValue("Sec-WebSocket-Accept");
      if (generateFinalKey(paramClientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(paramServerHandshake)) {
        return Draft.HandshakeState.MATCHED;
      }
      return Draft.HandshakeState.NOT_MATCHED;
    }
    return Draft.HandshakeState.NOT_MATCHED;
  }
  
  public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException
  {
    int i = readVersion(paramClientHandshake);
    if ((i != 7) && (i != 8)) {
      return Draft.HandshakeState.NOT_MATCHED;
    }
    if (basicAccept(paramClientHandshake)) {
      return Draft.HandshakeState.MATCHED;
    }
    return Draft.HandshakeState.NOT_MATCHED;
  }
  
  public Draft copyInstance()
  {
    return new Draft_10();
  }
  
  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    ByteBuffer localByteBuffer = paramFramedata.getPayloadData();
    Object localObject = this.role;
    WebSocket.Role localRole = WebSocket.Role.CLIENT;
    int n = 0;
    int k;
    if (localObject == localRole) {
      k = 1;
    } else {
      k = 0;
    }
    int i;
    if (localByteBuffer.remaining() <= 125) {
      i = 1;
    } else if (localByteBuffer.remaining() <= 65535) {
      i = 2;
    } else {
      i = 8;
    }
    if (i > 1) {
      j = i + 1;
    } else {
      j = i;
    }
    int m;
    if (k != 0) {
      m = 4;
    } else {
      m = 0;
    }
    localObject = ByteBuffer.allocate(j + 1 + m + localByteBuffer.remaining());
    int i1 = fromOpcode(paramFramedata.getOpcode());
    boolean bool = paramFramedata.isFin();
    int j = -128;
    if (bool) {
      m = -128;
    } else {
      m = 0;
    }
    ((ByteBuffer)localObject).put((byte)((byte)m | i1));
    paramFramedata = toByteArray(localByteBuffer.remaining(), i);
    if (i == 1)
    {
      i = paramFramedata[0];
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(i | j));
    }
    else if (i == 2)
    {
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(j | 0x7E));
      ((ByteBuffer)localObject).put(paramFramedata);
    }
    else
    {
      if (i != 8) {
        break label369;
      }
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(j | 0x7F));
      ((ByteBuffer)localObject).put(paramFramedata);
    }
    if (k != 0)
    {
      paramFramedata = ByteBuffer.allocate(4);
      paramFramedata.putInt(this.reuseableRandom.nextInt());
      ((ByteBuffer)localObject).put(paramFramedata.array());
      i = n;
      while (i < localByteBuffer.limit())
      {
        ((ByteBuffer)localObject).put((byte)(localByteBuffer.get() ^ paramFramedata.get(i % 4)));
        i += 1;
      }
    }
    ((ByteBuffer)localObject).put(localByteBuffer);
    ((ByteBuffer)localObject).flip();
    return (ByteBuffer)localObject;
    label369:
    throw new RuntimeException("Size representation not supported/specified");
  }
  
  public List<Framedata> createFrames(String paramString, boolean paramBoolean)
  {
    FramedataImpl1 localFramedataImpl1 = new FramedataImpl1();
    try
    {
      localFramedataImpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(paramString)));
      localFramedataImpl1.setFin(true);
      localFramedataImpl1.setOptcode(Framedata.Opcode.TEXT);
      localFramedataImpl1.setTransferemasked(paramBoolean);
      return Collections.singletonList(localFramedataImpl1);
    }
    catch (InvalidDataException paramString)
    {
      throw new NotSendableException(paramString);
    }
  }
  
  public List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    FramedataImpl1 localFramedataImpl1 = new FramedataImpl1();
    try
    {
      localFramedataImpl1.setPayload(paramByteBuffer);
      localFramedataImpl1.setFin(true);
      localFramedataImpl1.setOptcode(Framedata.Opcode.BINARY);
      localFramedataImpl1.setTransferemasked(paramBoolean);
      return Collections.singletonList(localFramedataImpl1);
    }
    catch (InvalidDataException paramByteBuffer)
    {
      throw new NotSendableException(paramByteBuffer);
    }
  }
  
  public Draft.CloseHandshakeType getCloseHandshakeType()
  {
    return Draft.CloseHandshakeType.TWOWAY;
  }
  
  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    paramClientHandshakeBuilder.put("Upgrade", "websocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    paramClientHandshakeBuilder.put("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.reuseableRandom.nextBytes(arrayOfByte);
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes(arrayOfByte));
    return paramClientHandshakeBuilder;
  }
  
  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramServerHandshakeBuilder.put("Upgrade", "websocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramServerHandshakeBuilder.setHttpStatusMessage("Switching Protocols");
    paramClientHandshake = paramClientHandshake.getFieldValue("Sec-WebSocket-Key");
    if (paramClientHandshake != null)
    {
      paramServerHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(paramClientHandshake));
      return paramServerHandshakeBuilder;
    }
    throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
  }
  
  public void reset()
  {
    this.incompleteframe = null;
  }
  
  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws LimitExedeedException, InvalidDataException
  {
    LinkedList localLinkedList = new LinkedList();
    ByteBuffer localByteBuffer1;
    if (this.incompleteframe != null) {
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.incompleteframe.remaining();
        if (j > i)
        {
          this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(paramByteBuffer.position() + i);
          return Collections.emptyList();
        }
        this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(translateSingleFrame((ByteBuffer)this.incompleteframe.duplicate().position(0)));
        this.incompleteframe = null;
      }
      catch (IncompleteException localIncompleteException1)
      {
        this.incompleteframe.limit();
        localByteBuffer1 = ByteBuffer.allocate(checkAlloc(localIncompleteException1.getPreferedSize()));
        this.incompleteframe.rewind();
        localByteBuffer1.put(this.incompleteframe);
        this.incompleteframe = localByteBuffer1;
        return translateFrame(paramByteBuffer);
      }
    }
    while (paramByteBuffer.hasRemaining())
    {
      paramByteBuffer.mark();
      try
      {
        localByteBuffer1.add(translateSingleFrame(paramByteBuffer));
      }
      catch (IncompleteException localIncompleteException2)
      {
        paramByteBuffer.reset();
        ByteBuffer localByteBuffer2 = ByteBuffer.allocate(checkAlloc(localIncompleteException2.getPreferedSize()));
        this.incompleteframe = localByteBuffer2;
        localByteBuffer2.put(paramByteBuffer);
      }
    }
    return localByteBuffer1;
  }
  
  public Framedata translateSingleFrame(ByteBuffer paramByteBuffer)
    throws Draft_10.IncompleteException, InvalidDataException
  {
    int i1 = paramByteBuffer.remaining();
    int j = 2;
    if (i1 >= 2)
    {
      int m = paramByteBuffer.get();
      int n = 0;
      boolean bool;
      if (m >> 8 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i = (byte)((m & 0x7F) >> 4);
      if (i == 0)
      {
        i = paramByteBuffer.get();
        int k;
        if ((i & 0xFFFFFF80) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        i = (byte)(i & 0x7F);
        Framedata.Opcode localOpcode = toOpcode((byte)(m & 0xF));
        if ((!bool) && ((localOpcode == Framedata.Opcode.PING) || (localOpcode == Framedata.Opcode.PONG) || (localOpcode == Framedata.Opcode.CLOSING))) {
          throw new InvalidFrameException("control frames may no be fragmented");
        }
        Object localObject;
        if ((i < 0) || (i > 125))
        {
          if ((localOpcode == Framedata.Opcode.PING) || (localOpcode == Framedata.Opcode.PONG) || (localOpcode == Framedata.Opcode.CLOSING)) {
            break label511;
          }
          if (i == 126)
          {
            if (i1 >= 4)
            {
              localObject = new byte[3];
              localObject[1] = paramByteBuffer.get();
              localObject[2] = paramByteBuffer.get();
              i = new BigInteger((byte[])localObject).intValue();
              j = 4;
            }
            else
            {
              throw new IncompleteException(4);
            }
          }
          else
          {
            j = 10;
            if (i1 < 10) {
              break label500;
            }
            localObject = new byte[8];
            i = 0;
            while (i < 8)
            {
              localObject[i] = paramByteBuffer.get();
              i += 1;
            }
            long l = new BigInteger((byte[])localObject).longValue();
            if (l > 2147483647L) {
              break label489;
            }
            i = (int)l;
          }
        }
        if (k != 0) {
          m = 4;
        } else {
          m = 0;
        }
        j = j + m + i;
        if (i1 >= j)
        {
          localObject = ByteBuffer.allocate(checkAlloc(i));
          if (k != 0)
          {
            byte[] arrayOfByte = new byte[4];
            paramByteBuffer.get(arrayOfByte);
            j = n;
            while (j < i)
            {
              ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(j % 4)]));
              j += 1;
            }
          }
          ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
          paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
          if (localOpcode == Framedata.Opcode.CLOSING)
          {
            paramByteBuffer = new CloseFrameBuilder();
          }
          else
          {
            paramByteBuffer = new FramedataImpl1();
            paramByteBuffer.setFin(bool);
            paramByteBuffer.setOptcode(localOpcode);
          }
          ((ByteBuffer)localObject).flip();
          paramByteBuffer.setPayload((ByteBuffer)localObject);
          return paramByteBuffer;
        }
        throw new IncompleteException(j);
        label489:
        throw new LimitExedeedException("Payloadsize is to big...");
        label500:
        throw new IncompleteException(10);
        label511:
        throw new InvalidFrameException("more than 125 octets");
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("bad rsv ");
      paramByteBuffer.append(i);
      throw new InvalidFrameException(paramByteBuffer.toString());
    }
    throw new IncompleteException(2);
  }
  
  private class IncompleteException
    extends Throwable
  {
    private static final long serialVersionUID = 7330519489840500997L;
    private int preferedsize;
    
    public IncompleteException(int paramInt)
    {
      this.preferedsize = paramInt;
    }
    
    public int getPreferedSize()
    {
      return this.preferedsize;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\drafts\Draft_10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */