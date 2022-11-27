package org.java_websocket.drafts;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.WebSocket.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public class Draft_76
  extends Draft_75
{
  private static final byte[] closehandshake = { -1, 0 };
  private boolean failed = false;
  private final Random reuseableRandom = new Random();
  
  public static byte[] createChallenge(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws InvalidHandshakeException
  {
    paramString1 = getPart(paramString1);
    paramString2 = getPart(paramString2);
    int i = paramString1[0];
    int j = paramString1[1];
    int k = paramString1[2];
    int m = paramString1[3];
    int n = paramString2[0];
    int i1 = paramString2[1];
    int i2 = paramString2[2];
    int i3 = paramString2[3];
    int i4 = paramArrayOfByte[0];
    int i5 = paramArrayOfByte[1];
    int i6 = paramArrayOfByte[2];
    int i7 = paramArrayOfByte[3];
    int i8 = paramArrayOfByte[4];
    int i9 = paramArrayOfByte[5];
    int i10 = paramArrayOfByte[6];
    int i11 = paramArrayOfByte[7];
    try
    {
      paramString1 = MessageDigest.getInstance("MD5");
      return paramString1.digest(new byte[] { i, j, k, m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11 });
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  private static String generateKey()
  {
    Random localRandom = new Random();
    long l = localRandom.nextInt(12) + 1;
    String str1 = Long.toString((localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue())) + 1) * l);
    int m = localRandom.nextInt(12);
    int k = 0;
    int i = 0;
    String str2;
    int j;
    for (;;)
    {
      str2 = str1;
      j = k;
      if (i >= m + 1) {
        break;
      }
      j = Math.abs(localRandom.nextInt(str1.length()));
      char c2 = (char)(localRandom.nextInt(95) + 33);
      char c1 = c2;
      if (c2 >= '0')
      {
        c1 = c2;
        if (c2 <= '9') {
          c1 = (char)(c2 - '\017');
        }
      }
      str1 = new StringBuilder(str1).insert(j, c1).toString();
      i += 1;
    }
    while (j < l)
    {
      i = Math.abs(localRandom.nextInt(str2.length() - 1) + 1);
      str2 = new StringBuilder(str2).insert(i, " ").toString();
      j += 1;
    }
    return str2;
  }
  
  private static byte[] getPart(String paramString)
    throws InvalidHandshakeException
  {
    try
    {
      long l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      long l2 = paramString.split(" ").length - 1;
      if (l2 != 0L)
      {
        l1 = new Long(l1 / l2).longValue();
        return new byte[] { (byte)(int)(l1 >> 24), (byte)(int)(l1 << 8 >> 24), (byte)(int)(l1 << 16 >> 24), (byte)(int)(l1 << 24 >> 24) };
      }
      throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
  }
  
  public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
  {
    if (this.failed) {
      return Draft.HandshakeState.NOT_MATCHED;
    }
    try
    {
      if ((paramServerHandshake.getFieldValue("Sec-WebSocket-Origin").equals(paramClientHandshake.getFieldValue("Origin"))) && (basicAccept(paramServerHandshake)))
      {
        paramServerHandshake = paramServerHandshake.getContent();
        if ((paramServerHandshake != null) && (paramServerHandshake.length != 0))
        {
          if (Arrays.equals(paramServerHandshake, createChallenge(paramClientHandshake.getFieldValue("Sec-WebSocket-Key1"), paramClientHandshake.getFieldValue("Sec-WebSocket-Key2"), paramClientHandshake.getContent()))) {
            return Draft.HandshakeState.MATCHED;
          }
          return Draft.HandshakeState.NOT_MATCHED;
        }
        throw new IncompleteHandshakeException();
      }
      paramClientHandshake = Draft.HandshakeState.NOT_MATCHED;
      return paramClientHandshake;
    }
    catch (InvalidHandshakeException paramClientHandshake)
    {
      throw new RuntimeException("bad handshakerequest", paramClientHandshake);
    }
  }
  
  public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
  {
    if ((paramClientHandshake.getFieldValue("Upgrade").equals("WebSocket")) && (paramClientHandshake.getFieldValue("Connection").contains("Upgrade")) && (paramClientHandshake.getFieldValue("Sec-WebSocket-Key1").length() > 0) && (!paramClientHandshake.getFieldValue("Sec-WebSocket-Key2").isEmpty()) && (paramClientHandshake.hasFieldValue("Origin"))) {
      return Draft.HandshakeState.MATCHED;
    }
    return Draft.HandshakeState.NOT_MATCHED;
  }
  
  public Draft copyInstance()
  {
    return new Draft_76();
  }
  
  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    if (paramFramedata.getOpcode() == Framedata.Opcode.CLOSING) {
      return ByteBuffer.wrap(closehandshake);
    }
    return super.createBinaryFrame(paramFramedata);
  }
  
  public Draft.CloseHandshakeType getCloseHandshakeType()
  {
    return Draft.CloseHandshakeType.ONEWAY;
  }
  
  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    paramClientHandshakeBuilder.put("Upgrade", "WebSocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key1", generateKey());
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key2", generateKey());
    if (!paramClientHandshakeBuilder.hasFieldValue("Origin"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("random");
      ((StringBuilder)localObject).append(this.reuseableRandom.nextInt());
      paramClientHandshakeBuilder.put("Origin", ((StringBuilder)localObject).toString());
    }
    Object localObject = new byte[8];
    this.reuseableRandom.nextBytes((byte[])localObject);
    paramClientHandshakeBuilder.setContent((byte[])localObject);
    return paramClientHandshakeBuilder;
  }
  
  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramServerHandshakeBuilder.setHttpStatusMessage("WebSocket Protocol Handshake");
    paramServerHandshakeBuilder.put("Upgrade", "WebSocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramServerHandshakeBuilder.put("Sec-WebSocket-Origin", paramClientHandshake.getFieldValue("Origin"));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ws://");
    ((StringBuilder)localObject).append(paramClientHandshake.getFieldValue("Host"));
    ((StringBuilder)localObject).append(paramClientHandshake.getResourceDescriptor());
    paramServerHandshakeBuilder.put("Sec-WebSocket-Location", ((StringBuilder)localObject).toString());
    localObject = paramClientHandshake.getFieldValue("Sec-WebSocket-Key1");
    String str = paramClientHandshake.getFieldValue("Sec-WebSocket-Key2");
    paramClientHandshake = paramClientHandshake.getContent();
    if ((localObject != null) && (str != null) && (paramClientHandshake != null) && (paramClientHandshake.length == 8))
    {
      paramServerHandshakeBuilder.setContent(createChallenge((String)localObject, str, paramClientHandshake));
      return paramServerHandshakeBuilder;
    }
    throw new InvalidHandshakeException("Bad keys");
  }
  
  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    paramByteBuffer.mark();
    List localList = super.translateRegularFrame(paramByteBuffer);
    if (localList == null)
    {
      paramByteBuffer.reset();
      localList = this.readyframes;
      this.readingState = true;
      if (this.currentFrame == null)
      {
        this.currentFrame = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() <= this.currentFrame.remaining())
        {
          this.currentFrame.put(paramByteBuffer);
          if (!this.currentFrame.hasRemaining())
          {
            if (Arrays.equals(this.currentFrame.array(), closehandshake))
            {
              localList.add(new CloseFrameBuilder(1000));
              return localList;
            }
            throw new InvalidFrameException();
          }
          this.readyframes = new LinkedList();
          return localList;
        }
        throw new InvalidFrameException();
      }
      throw new InvalidFrameException();
    }
    return localList;
  }
  
  public Handshakedata translateHandshake(ByteBuffer paramByteBuffer)
    throws InvalidHandshakeException
  {
    HandshakeBuilder localHandshakeBuilder = translateHandshakeHttp(paramByteBuffer, this.role);
    byte[] arrayOfByte;
    if (((localHandshakeBuilder.hasFieldValue("Sec-WebSocket-Key1")) || (this.role == WebSocket.Role.CLIENT)) && (!localHandshakeBuilder.hasFieldValue("Sec-WebSocket-Version")))
    {
      int i;
      if (this.role == WebSocket.Role.SERVER) {
        i = 8;
      } else {
        i = 16;
      }
      arrayOfByte = new byte[i];
    }
    try
    {
      paramByteBuffer.get(arrayOfByte);
      localHandshakeBuilder.setContent(arrayOfByte);
      return localHandshakeBuilder;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      for (;;) {}
    }
    throw new IncompleteHandshakeException(paramByteBuffer.capacity() + 16);
    return localHandshakeBuilder;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\drafts\Draft_76.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */