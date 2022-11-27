package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000\\\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\002\b\007\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\t\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\013\b\000\030\0002\0020\001:\0012B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\026\020\036\032\0020\0372\006\020 \032\0020!2\006\020\"\032\0020#J\030\020$\032\0020%2\006\020&\032\0020!2\b\020'\032\004\030\0010(J\030\020)\032\0020%2\006\020*\032\0020!2\006\020+\032\0020(H\002J&\020,\032\0020%2\006\020 \032\0020!2\006\020-\032\0020#2\006\020.\032\0020\0032\006\020/\032\0020\003J\016\0200\032\0020%2\006\020+\032\0020(J\016\0201\032\0020%2\006\020+\032\0020(R\032\020\t\032\0020\003X\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\022\020\022\032\0060\023R\0020\000X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\020\020\024\032\004\030\0010\025X\004¢\006\002\n\000R\020\020\026\032\004\030\0010\027X\004¢\006\002\n\000R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\030\020\031R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\032\020\033R\016\020\034\032\0020\017X\004¢\006\002\n\000R\016\020\035\032\0020\003X\016¢\006\002\n\000¨\0063"}, d2={"Lokhttp3/internal/ws/WebSocketWriter;", "", "isClient", "", "sink", "Lokio/BufferedSink;", "random", "Ljava/util/Random;", "(ZLokio/BufferedSink;Ljava/util/Random;)V", "activeWriter", "getActiveWriter", "()Z", "setActiveWriter", "(Z)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "frameSink", "Lokhttp3/internal/ws/WebSocketWriter$FrameSink;", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "getRandom", "()Ljava/util/Random;", "getSink", "()Lokio/BufferedSink;", "sinkBuffer", "writerClosed", "newMessageSink", "Lokio/Sink;", "formatOpcode", "", "contentLength", "", "writeClose", "", "code", "reason", "Lokio/ByteString;", "writeControlFrame", "opcode", "payload", "writeMessageFrame", "byteCount", "isFirstFrame", "isFinal", "writePing", "writePong", "FrameSink", "okhttp"}, k=1, mv={1, 1, 16})
public final class WebSocketWriter
{
  private boolean activeWriter;
  private final Buffer buffer;
  private final FrameSink frameSink;
  private final boolean isClient;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  private final Random random;
  private final BufferedSink sink;
  private final Buffer sinkBuffer;
  private boolean writerClosed;
  
  public WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.random = paramRandom;
    this.sinkBuffer = paramBufferedSink.getBuffer();
    this.buffer = new Buffer();
    this.frameSink = new FrameSink();
    paramBoolean = this.isClient;
    paramRandom = null;
    if (paramBoolean) {
      paramBufferedSink = new byte[4];
    } else {
      paramBufferedSink = null;
    }
    this.maskKey = paramBufferedSink;
    paramBufferedSink = paramRandom;
    if (this.isClient) {
      paramBufferedSink = new Buffer.UnsafeCursor();
    }
    this.maskCursor = paramBufferedSink;
  }
  
  private final void writeControlFrame(int paramInt, ByteString paramByteString)
    throws IOException
  {
    if (!this.writerClosed)
    {
      int j = paramByteString.size();
      int i;
      if (j <= 125L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.sinkBuffer.writeByte(paramInt | 0x80);
        if (this.isClient)
        {
          this.sinkBuffer.writeByte(j | 0x80);
          Object localObject = this.random;
          byte[] arrayOfByte = this.maskKey;
          if (arrayOfByte == null) {
            Intrinsics.throwNpe();
          }
          ((Random)localObject).nextBytes(arrayOfByte);
          this.sinkBuffer.write(this.maskKey);
          if (j > 0)
          {
            long l = this.sinkBuffer.size();
            this.sinkBuffer.write(paramByteString);
            paramByteString = this.sinkBuffer;
            localObject = this.maskCursor;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            paramByteString.readAndWriteUnsafe((Buffer.UnsafeCursor)localObject);
            this.maskCursor.seek(l);
            WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
            this.maskCursor.close();
          }
        }
        else
        {
          this.sinkBuffer.writeByte(j);
          this.sinkBuffer.write(paramByteString);
        }
        this.sink.flush();
        return;
      }
      throw ((Throwable)new IllegalArgumentException("Payload size must be less than or equal to 125".toString()));
    }
    throw ((Throwable)new IOException("closed"));
  }
  
  public final boolean getActiveWriter()
  {
    return this.activeWriter;
  }
  
  public final Buffer getBuffer()
  {
    return this.buffer;
  }
  
  public final Random getRandom()
  {
    return this.random;
  }
  
  public final BufferedSink getSink()
  {
    return this.sink;
  }
  
  public final Sink newMessageSink(int paramInt, long paramLong)
  {
    if ((this.activeWriter ^ true))
    {
      this.activeWriter = true;
      this.frameSink.setFormatOpcode(paramInt);
      this.frameSink.setContentLength(paramLong);
      this.frameSink.setFirstFrame(true);
      this.frameSink.setClosed(false);
      return (Sink)this.frameSink;
    }
    throw ((Throwable)new IllegalStateException("Another message writer is active. Did you call close()?".toString()));
  }
  
  public final void setActiveWriter(boolean paramBoolean)
  {
    this.activeWriter = paramBoolean;
  }
  
  public final void writeClose(int paramInt, ByteString paramByteString)
    throws IOException
  {
    Object localObject = ByteString.EMPTY;
    if ((paramInt != 0) || (paramByteString != null))
    {
      if (paramInt != 0) {
        WebSocketProtocol.INSTANCE.validateCloseCode(paramInt);
      }
      localObject = new Buffer();
      ((Buffer)localObject).writeShort(paramInt);
      if (paramByteString != null) {
        ((Buffer)localObject).write(paramByteString);
      }
      localObject = ((Buffer)localObject).readByteString();
    }
    try
    {
      writeControlFrame(8, (ByteString)localObject);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }
  
  public final void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (!this.writerClosed)
    {
      int j = 0;
      if (!paramBoolean1) {
        paramInt = 0;
      }
      int i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(i);
      paramInt = j;
      if (this.isClient) {
        paramInt = 128;
      }
      if (paramLong <= 125L)
      {
        i = (int)paramLong;
        this.sinkBuffer.writeByte(i | paramInt);
      }
      else if (paramLong <= 65535L)
      {
        this.sinkBuffer.writeByte(paramInt | 0x7E);
        this.sinkBuffer.writeShort((int)paramLong);
      }
      else
      {
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
      }
      if (this.isClient)
      {
        Object localObject1 = this.random;
        Object localObject2 = this.maskKey;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((Random)localObject1).nextBytes((byte[])localObject2);
        this.sinkBuffer.write(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.size();
          this.sinkBuffer.write(this.buffer, paramLong);
          localObject1 = this.sinkBuffer;
          localObject2 = this.maskCursor;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((Buffer)localObject1).readAndWriteUnsafe((Buffer.UnsafeCursor)localObject2);
          this.maskCursor.seek(l);
          WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      else
      {
        this.sinkBuffer.write(this.buffer, paramLong);
      }
      this.sink.emit();
      return;
    }
    throw ((Throwable)new IOException("closed"));
  }
  
  public final void writePing(ByteString paramByteString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "payload");
    writeControlFrame(9, paramByteString);
  }
  
  public final void writePong(ByteString paramByteString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "payload");
    writeControlFrame(10, paramByteString);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\t\n\002\b\005\n\002\020\b\n\002\b\007\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J\b\020\027\032\0020\030H\026J\b\020\031\032\0020\030H\026J\b\020\032\032\0020\033H\026J\030\020\034\032\0020\0302\006\020\035\032\0020\0362\006\020\037\032\0020\nH\026R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\032\020\017\032\0020\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\032\020\025\032\0020\004X\016¢\006\016\n\000\032\004\b\025\020\006\"\004\b\026\020\b¨\006 "}, d2={"Lokhttp3/internal/ws/WebSocketWriter$FrameSink;", "Lokio/Sink;", "(Lokhttp3/internal/ws/WebSocketWriter;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "contentLength", "", "getContentLength", "()J", "setContentLength", "(J)V", "formatOpcode", "", "getFormatOpcode", "()I", "setFormatOpcode", "(I)V", "isFirstFrame", "setFirstFrame", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 1, 16})
  public final class FrameSink
    implements Sink
  {
    private boolean closed;
    private long contentLength;
    private int formatOpcode;
    private boolean isFirstFrame;
    
    public void close()
      throws IOException
    {
      if (!this.closed)
      {
        WebSocketWriter localWebSocketWriter = this.this$0;
        localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.getBuffer().size(), this.isFirstFrame, true);
        this.closed = true;
        this.this$0.setActiveWriter(false);
        return;
      }
      throw ((Throwable)new IOException("closed"));
    }
    
    public void flush()
      throws IOException
    {
      if (!this.closed)
      {
        WebSocketWriter localWebSocketWriter = this.this$0;
        localWebSocketWriter.writeMessageFrame(this.formatOpcode, localWebSocketWriter.getBuffer().size(), this.isFirstFrame, false);
        this.isFirstFrame = false;
        return;
      }
      throw ((Throwable)new IOException("closed"));
    }
    
    public final boolean getClosed()
    {
      return this.closed;
    }
    
    public final long getContentLength()
    {
      return this.contentLength;
    }
    
    public final int getFormatOpcode()
    {
      return this.formatOpcode;
    }
    
    public final boolean isFirstFrame()
    {
      return this.isFirstFrame;
    }
    
    public final void setClosed(boolean paramBoolean)
    {
      this.closed = paramBoolean;
    }
    
    public final void setContentLength(long paramLong)
    {
      this.contentLength = paramLong;
    }
    
    public final void setFirstFrame(boolean paramBoolean)
    {
      this.isFirstFrame = paramBoolean;
    }
    
    public final void setFormatOpcode(int paramInt)
    {
      this.formatOpcode = paramInt;
    }
    
    public Timeout timeout()
    {
      return this.this$0.getSink().timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
      if (!this.closed)
      {
        this.this$0.getBuffer().write(paramBuffer, paramLong);
        int i;
        if ((this.isFirstFrame) && (this.contentLength != -1L) && (this.this$0.getBuffer().size() > this.contentLength - ' ')) {
          i = 1;
        } else {
          i = 0;
        }
        paramLong = this.this$0.getBuffer().completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0))
        {
          this.this$0.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
          this.isFirstFrame = false;
        }
        return;
      }
      throw ((Throwable)new IOException("closed"));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\ws\WebSocketWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */