package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocket.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft
{
  public static final byte[] FLASH_POLICY_REQUEST = Charsetfunctions.utf8Bytes("<policy-file-request/>\000");
  public static int INITIAL_FAMESIZE = 64;
  public static int MAX_FAME_SIZE = 1000;
  protected WebSocket.Role role = null;
  
  public static ByteBuffer readLine(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b;
    for (int i = 48; paramByteBuffer.hasRemaining(); i = b)
    {
      b = paramByteBuffer.get();
      localByteBuffer.put(b);
      if ((i == 13) && (b == 10))
      {
        localByteBuffer.limit(localByteBuffer.position() - 2);
        localByteBuffer.position(0);
        return localByteBuffer;
      }
    }
    paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
    return null;
  }
  
  public static String readStringLine(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = readLine(paramByteBuffer);
    if (paramByteBuffer == null) {
      return null;
    }
    return Charsetfunctions.stringAscii(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public static HandshakeBuilder translateHandshakeHttp(ByteBuffer paramByteBuffer, WebSocket.Role paramRole)
    throws InvalidHandshakeException, IncompleteHandshakeException
  {
    Object localObject = readStringLine(paramByteBuffer);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(" ", 3);
      if (localObject.length == 3)
      {
        if (paramRole == WebSocket.Role.CLIENT)
        {
          paramRole = new HandshakeImpl1Server();
          ServerHandshakeBuilder localServerHandshakeBuilder = (ServerHandshakeBuilder)paramRole;
          localServerHandshakeBuilder.setHttpStatus(Short.parseShort(localObject[1]));
          localServerHandshakeBuilder.setHttpStatusMessage(localObject[2]);
        }
        else
        {
          paramRole = new HandshakeImpl1Client();
          paramRole.setResourceDescriptor(localObject[1]);
        }
        localObject = readStringLine(paramByteBuffer);
        while ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split(":", 2);
          if (localObject.length == 2)
          {
            paramRole.put(localObject[0], localObject[1].replaceFirst("^ +", ""));
            localObject = readStringLine(paramByteBuffer);
          }
          else
          {
            throw new InvalidHandshakeException("not an http header");
          }
        }
        if (localObject != null) {
          return paramRole;
        }
        throw new IncompleteHandshakeException();
      }
      throw new InvalidHandshakeException();
    }
    throw new IncompleteHandshakeException(paramByteBuffer.capacity() + 128);
  }
  
  public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidHandshakeException;
  
  public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException;
  
  protected boolean basicAccept(Handshakedata paramHandshakedata)
  {
    return (paramHandshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket")) && (paramHandshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public int checkAlloc(int paramInt)
    throws LimitExedeedException, InvalidDataException
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new InvalidDataException(1002, "Negative count");
  }
  
  public abstract Draft copyInstance();
  
  public abstract ByteBuffer createBinaryFrame(Framedata paramFramedata);
  
  public abstract List<Framedata> createFrames(String paramString, boolean paramBoolean);
  
  public abstract List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, WebSocket.Role paramRole)
  {
    return createHandshake(paramHandshakedata, paramRole, true);
  }
  
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, WebSocket.Role paramRole, boolean paramBoolean)
  {
    paramRole = new StringBuilder(100);
    if ((paramHandshakedata instanceof ClientHandshake))
    {
      paramRole.append("GET ");
      paramRole.append(((ClientHandshake)paramHandshakedata).getResourceDescriptor());
      paramRole.append(" HTTP/1.1");
    }
    else
    {
      if (!(paramHandshakedata instanceof ServerHandshake)) {
        break label264;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HTTP/1.1 101 ");
      ((StringBuilder)localObject).append(((ServerHandshake)paramHandshakedata).getHttpStatusMessage());
      paramRole.append(((StringBuilder)localObject).toString());
    }
    paramRole.append("\r\n");
    Object localObject = paramHandshakedata.iterateHttpFields();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = paramHandshakedata.getFieldValue(str1);
      paramRole.append(str1);
      paramRole.append(": ");
      paramRole.append(str2);
      paramRole.append("\r\n");
    }
    paramRole.append("\r\n");
    paramRole = Charsetfunctions.asciiBytes(paramRole.toString());
    if (paramBoolean) {
      paramHandshakedata = paramHandshakedata.getContent();
    } else {
      paramHandshakedata = null;
    }
    int i;
    if (paramHandshakedata == null) {
      i = 0;
    } else {
      i = paramHandshakedata.length;
    }
    localObject = ByteBuffer.allocate(i + paramRole.length);
    ((ByteBuffer)localObject).put(paramRole);
    if (paramHandshakedata != null) {
      ((ByteBuffer)localObject).put(paramHandshakedata);
    }
    ((ByteBuffer)localObject).flip();
    return Collections.singletonList(localObject);
    label264:
    throw new RuntimeException("unknow role");
  }
  
  public abstract CloseHandshakeType getCloseHandshakeType();
  
  public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
    throws InvalidHandshakeException;
  
  public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException;
  
  public abstract void reset();
  
  public void setParseMode(WebSocket.Role paramRole)
  {
    this.role = paramRole;
  }
  
  public abstract List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException;
  
  public Handshakedata translateHandshake(ByteBuffer paramByteBuffer)
    throws InvalidHandshakeException
  {
    return translateHandshakeHttp(paramByteBuffer, this.role);
  }
  
  public static enum CloseHandshakeType
  {
    static
    {
      CloseHandshakeType localCloseHandshakeType = new CloseHandshakeType("TWOWAY", 2);
      TWOWAY = localCloseHandshakeType;
      $VALUES = new CloseHandshakeType[] { NONE, ONEWAY, localCloseHandshakeType };
    }
    
    private CloseHandshakeType() {}
  }
  
  public static enum HandshakeState
  {
    static
    {
      HandshakeState localHandshakeState = new HandshakeState("NOT_MATCHED", 1);
      NOT_MATCHED = localHandshakeState;
      $VALUES = new HandshakeState[] { MATCHED, localHandshakeState };
    }
    
    private HandshakeState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\drafts\Draft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */