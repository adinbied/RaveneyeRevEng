package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000H\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\n\002\020 \n\002\030\002\n\002\b\f\030\000 #2\0020\001:\003#$%B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\013\032\0020\fH\026J\026\020\r\032\0020\0052\006\020\016\032\0020\0052\006\020\017\032\0020\020J\016\020\021\032\0020\f2\006\020\017\032\0020\020J(\020\022\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020\027\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J.\020\030\032\b\022\004\022\0020\0320\0312\006\020\023\032\0020\0242\006\020\033\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020\034\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020\035\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J\030\020\036\032\0020\f2\006\020\017\032\0020\0202\006\020\026\032\0020\024H\002J(\020\036\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020\037\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020 \032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020!\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002J(\020\"\032\0020\f2\006\020\017\032\0020\0202\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\002R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006&"}, d2={"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "close", "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", "flags", "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k=1, mv={1, 1, 16})
public final class Http2Reader
  implements Closeable
{
  public static final Companion Companion = new Companion(null);
  private static final Logger logger;
  private final boolean client;
  private final ContinuationSource continuation;
  private final Hpack.Reader hpackReader;
  private final BufferedSource source;
  
  static
  {
    Logger localLogger = Logger.getLogger(Http2.class.getName());
    Intrinsics.checkExpressionValueIsNotNull(localLogger, "Logger.getLogger(Http2::class.java.name)");
    logger = localLogger;
  }
  
  public Http2Reader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    this.source = paramBufferedSource;
    this.client = paramBoolean;
    paramBufferedSource = new ContinuationSource(paramBufferedSource);
    this.continuation = paramBufferedSource;
    this.hpackReader = new Hpack.Reader((Source)paramBufferedSource, 4096, 0, 4, null);
  }
  
  private final void readData(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt3 != 0)
    {
      int j = 0;
      int i = 1;
      boolean bool;
      if ((paramInt2 & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramInt2 & 0x20) == 0) {
        i = 0;
      }
      if (i == 0)
      {
        i = j;
        if ((paramInt2 & 0x8) != 0) {
          i = Util.and(this.source.readByte(), 255);
        }
        paramInt1 = Companion.lengthWithoutPadding(paramInt1, paramInt2, i);
        paramHandler.data(bool, paramInt3, this.source, paramInt1);
        this.source.skip(i);
        return;
      }
      throw ((Throwable)new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"));
    }
    throw ((Throwable)new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0"));
  }
  
  private final void readGoAway(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 >= 8)
    {
      if (paramInt3 == 0)
      {
        paramInt2 = this.source.readInt();
        paramInt3 = this.source.readInt();
        paramInt1 -= 8;
        ErrorCode localErrorCode = ErrorCode.Companion.fromHttp2(paramInt3);
        if (localErrorCode != null)
        {
          ByteString localByteString = ByteString.EMPTY;
          if (paramInt1 > 0) {
            localByteString = this.source.readByteString(paramInt1);
          }
          paramHandler.goAway(paramInt2, localErrorCode, localByteString);
          return;
        }
        paramHandler = new StringBuilder();
        paramHandler.append("TYPE_GOAWAY unexpected error code: ");
        paramHandler.append(paramInt3);
        throw ((Throwable)new IOException(paramHandler.toString()));
      }
      throw ((Throwable)new IOException("TYPE_GOAWAY streamId != 0"));
    }
    paramHandler = new StringBuilder();
    paramHandler.append("TYPE_GOAWAY length < 8: ");
    paramHandler.append(paramInt1);
    throw ((Throwable)new IOException(paramHandler.toString()));
  }
  
  private final List<Header> readHeaderBlock(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    this.continuation.setLeft(paramInt1);
    ContinuationSource localContinuationSource = this.continuation;
    localContinuationSource.setLength(localContinuationSource.getLeft());
    this.continuation.setPadding(paramInt2);
    this.continuation.setFlags(paramInt3);
    this.continuation.setStreamId(paramInt4);
    this.hpackReader.readHeaders();
    return this.hpackReader.getAndResetHeaderList();
  }
  
  private final void readHeaders(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt3 != 0)
    {
      int i = 0;
      boolean bool;
      if ((paramInt2 & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramInt2 & 0x8) != 0) {
        i = Util.and(this.source.readByte(), 255);
      }
      int j = paramInt1;
      if ((paramInt2 & 0x20) != 0)
      {
        readPriority(paramHandler, paramInt3);
        j = paramInt1 - 5;
      }
      paramHandler.headers(bool, paramInt3, -1, readHeaderBlock(Companion.lengthWithoutPadding(j, paramInt2, i), i, paramInt2, paramInt3));
      return;
    }
    throw ((Throwable)new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"));
  }
  
  private final void readPing(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 == 8)
    {
      if (paramInt3 == 0)
      {
        paramInt1 = this.source.readInt();
        paramInt3 = this.source.readInt();
        boolean bool = true;
        if ((paramInt2 & 0x1) == 0) {
          bool = false;
        }
        paramHandler.ping(bool, paramInt1, paramInt3);
        return;
      }
      throw ((Throwable)new IOException("TYPE_PING streamId != 0"));
    }
    paramHandler = new StringBuilder();
    paramHandler.append("TYPE_PING length != 8: ");
    paramHandler.append(paramInt1);
    throw ((Throwable)new IOException(paramHandler.toString()));
  }
  
  private final void readPriority(Handler paramHandler, int paramInt)
    throws IOException
  {
    int i = this.source.readInt();
    boolean bool;
    if ((i & (int)2147483648L) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramHandler.priority(paramInt, i & 0x7FFFFFFF, Util.and(this.source.readByte(), 255) + 1, bool);
  }
  
  private final void readPriority(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 == 5)
    {
      if (paramInt3 != 0)
      {
        readPriority(paramHandler, paramInt3);
        return;
      }
      throw ((Throwable)new IOException("TYPE_PRIORITY streamId == 0"));
    }
    paramHandler = new StringBuilder();
    paramHandler.append("TYPE_PRIORITY length: ");
    paramHandler.append(paramInt1);
    paramHandler.append(" != 5");
    throw ((Throwable)new IOException(paramHandler.toString()));
  }
  
  private final void readPushPromise(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt3 != 0)
    {
      int i;
      if ((paramInt2 & 0x8) != 0) {
        i = Util.and(this.source.readByte(), 255);
      } else {
        i = 0;
      }
      paramHandler.pushPromise(paramInt3, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock(Companion.lengthWithoutPadding(paramInt1 - 4, paramInt2, i), i, paramInt2, paramInt3));
      return;
    }
    throw ((Throwable)new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"));
  }
  
  private final void readRstStream(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 == 4)
    {
      if (paramInt3 != 0)
      {
        paramInt1 = this.source.readInt();
        ErrorCode localErrorCode = ErrorCode.Companion.fromHttp2(paramInt1);
        if (localErrorCode != null)
        {
          paramHandler.rstStream(paramInt3, localErrorCode);
          return;
        }
        paramHandler = new StringBuilder();
        paramHandler.append("TYPE_RST_STREAM unexpected error code: ");
        paramHandler.append(paramInt1);
        throw ((Throwable)new IOException(paramHandler.toString()));
      }
      throw ((Throwable)new IOException("TYPE_RST_STREAM streamId == 0"));
    }
    paramHandler = new StringBuilder();
    paramHandler.append("TYPE_RST_STREAM length: ");
    paramHandler.append(paramInt1);
    paramHandler.append(" != 4");
    throw ((Throwable)new IOException(paramHandler.toString()));
  }
  
  private final void readSettings(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt3 == 0)
    {
      if ((paramInt2 & 0x1) != 0)
      {
        if (paramInt1 == 0)
        {
          paramHandler.ackSettings();
          return;
        }
        throw ((Throwable)new IOException("FRAME_SIZE_ERROR ack frame should be empty!"));
      }
      if (paramInt1 % 6 == 0)
      {
        Settings localSettings = new Settings();
        IntProgression localIntProgression = RangesKt.step((IntProgression)RangesKt.until(0, paramInt1), 6);
        paramInt2 = localIntProgression.getFirst();
        int i = localIntProgression.getLast();
        int j = localIntProgression.getStep();
        if (j >= 0 ? paramInt2 <= i : paramInt2 >= i) {
          for (;;)
          {
            paramInt3 = Util.and(this.source.readShort(), 65535);
            int k = this.source.readInt();
            if (paramInt3 != 2)
            {
              if (paramInt3 != 3)
              {
                if (paramInt3 != 4)
                {
                  if (paramInt3 != 5)
                  {
                    paramInt1 = paramInt3;
                  }
                  else if ((k >= 16384) && (k <= 16777215))
                  {
                    paramInt1 = paramInt3;
                  }
                  else
                  {
                    paramHandler = new StringBuilder();
                    paramHandler.append("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ");
                    paramHandler.append(k);
                    throw ((Throwable)new IOException(paramHandler.toString()));
                  }
                }
                else
                {
                  paramInt1 = 7;
                  if (k < 0) {
                    throw ((Throwable)new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"));
                  }
                }
              }
              else {
                paramInt1 = 4;
              }
            }
            else
            {
              paramInt1 = paramInt3;
              if (k != 0) {
                if (k == 1) {
                  paramInt1 = paramInt3;
                } else {
                  throw ((Throwable)new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"));
                }
              }
            }
            localSettings.set(paramInt1, k);
            if (paramInt2 == i) {
              break;
            }
            paramInt2 += j;
          }
        }
        paramHandler.settings(false, localSettings);
        return;
      }
      paramHandler = new StringBuilder();
      paramHandler.append("TYPE_SETTINGS length % 6 != 0: ");
      paramHandler.append(paramInt1);
      throw ((Throwable)new IOException(paramHandler.toString()));
    }
    throw ((Throwable)new IOException("TYPE_SETTINGS streamId != 0"));
  }
  
  private final void readWindowUpdate(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramInt1 == 4)
    {
      long l = Util.and(this.source.readInt(), 2147483647L);
      if (l != 0L)
      {
        paramHandler.windowUpdate(paramInt3, l);
        return;
      }
      throw ((Throwable)new IOException("windowSizeIncrement was 0"));
    }
    paramHandler = new StringBuilder();
    paramHandler.append("TYPE_WINDOW_UPDATE length !=4: ");
    paramHandler.append(paramInt1);
    throw ((Throwable)new IOException(paramHandler.toString()));
  }
  
  public void close()
    throws IOException
  {
    this.source.close();
  }
  
  public final boolean nextFrame(boolean paramBoolean, Handler paramHandler)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramHandler, "handler");
    try
    {
      this.source.require(9L);
      int i = Util.readMedium(this.source);
      if (i <= 16384)
      {
        int j = Util.and(this.source.readByte(), 255);
        if ((paramBoolean) && (j != 4))
        {
          paramHandler = new StringBuilder();
          paramHandler.append("Expected a SETTINGS frame but was ");
          paramHandler.append(j);
          throw ((Throwable)new IOException(paramHandler.toString()));
        }
        int k = Util.and(this.source.readByte(), 255);
        int m = this.source.readInt() & 0x7FFFFFFF;
        if (logger.isLoggable(Level.FINE)) {
          logger.fine(Http2.INSTANCE.frameLog(true, m, i, j, k));
        }
        switch (j)
        {
        default: 
          this.source.skip(i);
          break;
        case 8: 
          readWindowUpdate(paramHandler, i, k, m);
          break;
        case 7: 
          readGoAway(paramHandler, i, k, m);
          break;
        case 6: 
          readPing(paramHandler, i, k, m);
          break;
        case 5: 
          readPushPromise(paramHandler, i, k, m);
          break;
        case 4: 
          readSettings(paramHandler, i, k, m);
          break;
        case 3: 
          readRstStream(paramHandler, i, k, m);
          break;
        case 2: 
          readPriority(paramHandler, i, k, m);
          break;
        case 1: 
          readHeaders(paramHandler, i, k, m);
          break;
        case 0: 
          readData(paramHandler, i, k, m);
        }
        return true;
      }
      paramHandler = new StringBuilder();
      paramHandler.append("FRAME_SIZE_ERROR: ");
      paramHandler.append(i);
      throw ((Throwable)new IOException(paramHandler.toString()));
    }
    catch (EOFException paramHandler)
    {
      for (;;) {}
    }
    return false;
  }
  
  public final void readConnectionPreface(Handler paramHandler)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramHandler, "handler");
    if (this.client)
    {
      if (nextFrame(true, paramHandler)) {
        return;
      }
      throw ((Throwable)new IOException("Required SETTINGS preface not received"));
    }
    paramHandler = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
    if (logger.isLoggable(Level.FINE))
    {
      localObject = logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<< CONNECTION ");
      localStringBuilder.append(paramHandler.hex());
      ((Logger)localObject).fine(Util.format(localStringBuilder.toString(), new Object[0]));
    }
    if (!(Intrinsics.areEqual(Http2.CONNECTION_PREFACE, paramHandler) ^ true)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a connection header but was ");
    ((StringBuilder)localObject).append(paramHandler.utf8());
    throw ((Throwable)new IOException(((StringBuilder)localObject).toString()));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\007\032\0020\b2\006\020\t\032\0020\b2\006\020\n\032\0020\b2\006\020\013\032\0020\bR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\f"}, d2={"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", "flags", "padding", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Logger getLogger()
    {
      return Http2Reader.access$getLogger$cp();
    }
    
    public final int lengthWithoutPadding(int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      int i = paramInt1;
      if ((paramInt2 & 0x8) != 0) {
        i = paramInt1 - 1;
      }
      if (paramInt3 <= i) {
        return i - paramInt3;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PROTOCOL_ERROR padding ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" > remaining length ");
      localStringBuilder.append(i);
      throw ((Throwable)new IOException(localStringBuilder.toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\021\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\b\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\027\032\0020\030H\026J\030\020\031\032\0020\0322\006\020\033\032\0020\0342\006\020\035\032\0020\032H\026J\b\020\036\032\0020\030H\002J\b\020\037\032\0020 H\026R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\0020\006X\016¢\006\016\n\000\032\004\b\f\020\b\"\004\b\r\020\nR\032\020\016\032\0020\006X\016¢\006\016\n\000\032\004\b\017\020\b\"\004\b\020\020\nR\032\020\021\032\0020\006X\016¢\006\016\n\000\032\004\b\022\020\b\"\004\b\023\020\nR\016\020\002\032\0020\003X\004¢\006\002\n\000R\032\020\024\032\0020\006X\016¢\006\016\n\000\032\004\b\025\020\b\"\004\b\026\020\n¨\006!"}, d2={"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "flags", "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", "length", "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", "timeout", "Lokio/Timeout;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class ContinuationSource
    implements Source
  {
    private int flags;
    private int left;
    private int length;
    private int padding;
    private final BufferedSource source;
    private int streamId;
    
    public ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }
    
    private final void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = Util.readMedium(this.source);
      this.left = j;
      this.length = j;
      j = Util.and(this.source.readByte(), 255);
      this.flags = Util.and(this.source.readByte(), 255);
      if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE)) {
        Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, j, this.flags));
      }
      int k = this.source.readInt() & 0x7FFFFFFF;
      this.streamId = k;
      if (j == 9)
      {
        if (k == i) {
          return;
        }
        throw ((Throwable)new IOException("TYPE_CONTINUATION streamId changed"));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append(" != TYPE_CONTINUATION");
      throw ((Throwable)new IOException(localStringBuilder.toString()));
    }
    
    public void close()
      throws IOException
    {}
    
    public final int getFlags()
    {
      return this.flags;
    }
    
    public final int getLeft()
    {
      return this.left;
    }
    
    public final int getLength()
    {
      return this.length;
    }
    
    public final int getPadding()
    {
      return this.padding;
    }
    
    public final int getStreamId()
    {
      return this.streamId;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      int i;
      for (;;)
      {
        i = this.left;
        if (i != 0) {
          break;
        }
        this.source.skip(this.padding);
        this.padding = 0;
        if ((this.flags & 0x4) != 0) {
          return -1L;
        }
        readContinuationHeader();
      }
      paramLong = this.source.read(paramBuffer, Math.min(paramLong, i));
      if (paramLong == -1L) {
        return -1L;
      }
      this.left -= (int)paramLong;
      return paramLong;
    }
    
    public final void setFlags(int paramInt)
    {
      this.flags = paramInt;
    }
    
    public final void setLeft(int paramInt)
    {
      this.left = paramInt;
    }
    
    public final void setLength(int paramInt)
    {
      this.length = paramInt;
    }
    
    public final void setPadding(int paramInt)
    {
      this.padding = paramInt;
    }
    
    public final void setStreamId(int paramInt)
    {
      this.streamId = paramInt;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000X\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\020 \n\002\030\002\n\002\b\016\n\002\030\002\n\002\b\003\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J8\020\004\032\0020\0032\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\b2\006\020\f\032\0020\0062\006\020\r\032\0020\016H&J(\020\017\032\0020\0032\006\020\020\032\0020\0212\006\020\005\032\0020\0062\006\020\022\032\0020\0232\006\020\024\032\0020\006H&J \020\025\032\0020\0032\006\020\026\032\0020\0062\006\020\027\032\0020\0302\006\020\031\032\0020\nH&J.\020\032\032\0020\0032\006\020\020\032\0020\0212\006\020\005\032\0020\0062\006\020\033\032\0020\0062\f\020\034\032\b\022\004\022\0020\0360\035H&J \020\037\032\0020\0032\006\020 \032\0020\0212\006\020!\032\0020\0062\006\020\"\032\0020\006H&J(\020#\032\0020\0032\006\020\005\032\0020\0062\006\020$\032\0020\0062\006\020%\032\0020\0062\006\020&\032\0020\021H&J&\020'\032\0020\0032\006\020\005\032\0020\0062\006\020(\032\0020\0062\f\020)\032\b\022\004\022\0020\0360\035H&J\030\020*\032\0020\0032\006\020\005\032\0020\0062\006\020\027\032\0020\030H&J\030\020+\032\0020\0032\006\020,\032\0020\0212\006\020+\032\0020-H&J\030\020.\032\0020\0032\006\020\005\032\0020\0062\006\020/\032\0020\016H&¨\0060"}, d2={"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "data", "inFinished", "", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract interface Handler
  {
    public abstract void ackSettings();
    
    public abstract void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong);
    
    public abstract void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException;
    
    public abstract void goAway(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString);
    
    public abstract void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList);
    
    public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException;
    
    public abstract void rstStream(int paramInt, ErrorCode paramErrorCode);
    
    public abstract void settings(boolean paramBoolean, Settings paramSettings);
    
    public abstract void windowUpdate(int paramInt, long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Http2Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */