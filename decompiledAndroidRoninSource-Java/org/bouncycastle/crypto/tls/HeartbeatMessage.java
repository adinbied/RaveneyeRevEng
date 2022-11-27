package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public class HeartbeatMessage
{
  protected int paddingLength;
  protected byte[] payload;
  protected short type;
  
  public HeartbeatMessage(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    if (HeartbeatMessageType.isValid(paramShort))
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length < 65536))
      {
        if (paramInt >= 16)
        {
          this.type = paramShort;
          this.payload = paramArrayOfByte;
          this.paddingLength = paramInt;
          return;
        }
        throw new IllegalArgumentException("'paddingLength' must be at least 16");
      }
      throw new IllegalArgumentException("'payload' must have length < 2^16");
    }
    throw new IllegalArgumentException("'type' is not a valid HeartbeatMessageType value");
  }
  
  public static HeartbeatMessage parse(InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (HeartbeatMessageType.isValid(s))
    {
      int i = TlsUtils.readUint16(paramInputStream);
      PayloadBuffer localPayloadBuffer = new PayloadBuffer();
      Streams.pipeAll(paramInputStream, localPayloadBuffer);
      paramInputStream = localPayloadBuffer.toTruncatedByteArray(i);
      if (paramInputStream == null) {
        return null;
      }
      return new HeartbeatMessage(s, paramInputStream, localPayloadBuffer.size() - paramInputStream.length);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public void encode(TlsContext paramTlsContext, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.type, paramOutputStream);
    TlsUtils.checkUint16(this.payload.length);
    TlsUtils.writeUint16(this.payload.length, paramOutputStream);
    paramOutputStream.write(this.payload);
    byte[] arrayOfByte = new byte[this.paddingLength];
    paramTlsContext.getNonceRandomGenerator().nextBytes(arrayOfByte);
    paramOutputStream.write(arrayOfByte);
  }
  
  static class PayloadBuffer
    extends ByteArrayOutputStream
  {
    byte[] toTruncatedByteArray(int paramInt)
    {
      if (this.count < paramInt + 16) {
        return null;
      }
      return Arrays.copyOf(this.buf, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\HeartbeatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */