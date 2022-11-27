package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ByteString;
import dji.thirdparty.okio.Source;
import dji.thirdparty.okio.Timeout;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public final class Http2
  implements Variant
{
  private static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;
  private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
  
  private static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException ioException(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
    throws IOException
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort <= s) {
      return (short)(s - paramShort);
    }
    throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
  }
  
  private static int readMedium(BufferedSource paramBufferedSource)
    throws IOException
  {
    int i = paramBufferedSource.readByte();
    int j = paramBufferedSource.readByte();
    return paramBufferedSource.readByte() & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  private static void writeMedium(BufferedSink paramBufferedSink, int paramInt)
    throws IOException
  {
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
  
  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class ContinuationSource
    implements Source
  {
    byte flags;
    int left;
    int length;
    short padding;
    private final BufferedSource source;
    int streamId;
    
    public ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }
    
    /* Error */
    private void readContinuationHeader()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void close()
      throws IOException
    {}
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      return 277867273L;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
  
  static final class FrameLogger
  {
    private static final String[] BINARY;
    private static final String[] FLAGS;
    private static final String[] TYPES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    
    static
    {
      FLAGS = new String[64];
      BINARY = new String['Ā'];
      int k = 0;
      int i = 0;
      for (;;)
      {
        localObject = BINARY;
        if (i >= localObject.length) {
          break;
        }
        localObject[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i += 1;
      }
      String[] arrayOfString = FLAGS;
      arrayOfString[0] = "";
      arrayOfString[1] = "END_STREAM";
      Object localObject = new int[1];
      localObject[0] = 1;
      arrayOfString[8] = "PADDED";
      i = 0;
      int j;
      StringBuilder localStringBuilder;
      while (i < 1)
      {
        j = localObject[i];
        arrayOfString = FLAGS;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(FLAGS[j]);
        localStringBuilder.append("|PADDED");
        arrayOfString[(j | 0x8)] = localStringBuilder.toString();
        i += 1;
      }
      arrayOfString = FLAGS;
      arrayOfString[4] = "END_HEADERS";
      arrayOfString[32] = "PRIORITY";
      arrayOfString[36] = "END_HEADERS|PRIORITY";
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= 3) {
          break;
        }
        int m = new int[] { 4, 32, 36 }[i];
        j = 0;
        while (j < 1)
        {
          int n = localObject[j];
          arrayOfString = FLAGS;
          int i1 = n | m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(FLAGS[n]);
          localStringBuilder.append('|');
          localStringBuilder.append(FLAGS[m]);
          arrayOfString[i1] = localStringBuilder.toString();
          arrayOfString = FLAGS;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(FLAGS[n]);
          localStringBuilder.append('|');
          localStringBuilder.append(FLAGS[m]);
          localStringBuilder.append("|PADDED");
          arrayOfString[(i1 | 0x8)] = localStringBuilder.toString();
          j += 1;
        }
        i += 1;
      }
      for (;;)
      {
        localObject = FLAGS;
        if (j >= localObject.length) {
          break;
        }
        if (localObject[j] == null) {
          localObject[j] = BINARY[j];
        }
        j += 1;
      }
    }
    
    static String formatFlags(byte paramByte1, byte paramByte2)
    {
      if (paramByte2 == 0) {
        return "";
      }
      if ((paramByte1 != 2) && (paramByte1 != 3)) {
        if ((paramByte1 != 4) && (paramByte1 != 6))
        {
          if ((paramByte1 != 7) && (paramByte1 != 8))
          {
            Object localObject = FLAGS;
            if (paramByte2 < localObject.length) {
              localObject = localObject[paramByte2];
            } else {
              localObject = BINARY[paramByte2];
            }
            if ((paramByte1 == 5) && ((paramByte2 & 0x4) != 0)) {
              return ((String)localObject).replace("HEADERS", "PUSH_PROMISE");
            }
            if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
              return ((String)localObject).replace("PRIORITY", "COMPRESSED");
            }
            return (String)localObject;
          }
        }
        else
        {
          if (paramByte2 == 1) {
            return "ACK";
          }
          return BINARY[paramByte2];
        }
      }
      return BINARY[paramByte2];
    }
    
    static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      Object localObject = TYPES;
      if (paramByte1 < localObject.length) {
        localObject = localObject[paramByte1];
      } else {
        localObject = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      }
      String str2 = formatFlags(paramByte1, paramByte2);
      String str1;
      if (paramBoolean) {
        str1 = "<<";
      } else {
        str1 = ">>";
      }
      return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, str2 });
    }
  }
  
  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final Http2.ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;
    
    Reader(BufferedSource paramBufferedSource, int paramInt, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.client = paramBoolean;
      paramBufferedSource = new Http2.ContinuationSource(paramBufferedSource);
      this.continuation = paramBufferedSource;
      this.hpackReader = new Hpack.Reader(paramInt, paramBufferedSource);
    }
    
    /* Error */
    private void readData(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readGoAway(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
      throws IOException
    {
      return null;
    }
    
    /* Error */
    private void readHeaders(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readPing(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readPriority(FrameReader.Handler arg1, int arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readPriority(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readPushPromise(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readRstStream(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readSettings(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readWindowUpdate(FrameReader.Handler arg1, int arg2, byte arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void close()
      throws IOException
    {
      this.source.close();
    }
    
    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      return false;
    }
    
    /* Error */
    public void readConnectionPreface()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;
    
    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      paramBufferedSink = new Buffer();
      this.hpackBuffer = paramBufferedSink;
      this.hpackWriter = new Hpack.Writer(paramBufferedSink);
      this.maxFrameSize = 16384;
    }
    
    /* Error */
    private void writeContinuationFrames(int arg1, long arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    /* Error */
    public void ackSettings(Settings arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void connectionPreface()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void data(boolean arg1, int arg2, Buffer arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    /* Error */
    void dataFrame(int arg1, byte arg2, Buffer arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void frameHeader(int arg1, int arg2, byte arg3, byte arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 5
      //   3: goto -3 -> 0
    }
    
    /* Error */
    public void goAway(int arg1, ErrorCode arg2, byte[] arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void headers(int arg1, List<Header> arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    void headers(boolean arg1, int arg2, List<Header> arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public int maxDataLength()
    {
      return this.maxFrameSize;
    }
    
    /* Error */
    public void ping(boolean arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: return
    }
    
    /* Error */
    public void pushPromise(int arg1, int arg2, List<Header> arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    /* Error */
    public void rstStream(int arg1, ErrorCode arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void settings(Settings arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void synReply(boolean arg1, int arg2, List<Header> arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      if (!paramBoolean2) {}
      try
      {
        if (!this.closed)
        {
          headers(paramBoolean1, paramInt1, paramList);
          return;
        }
        throw new IOException("closed");
      }
      finally
      {
        for (;;) {}
      }
      throw new UnsupportedOperationException();
      throw paramList;
    }
    
    /* Error */
    public void windowUpdate(int arg1, long arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Http2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */