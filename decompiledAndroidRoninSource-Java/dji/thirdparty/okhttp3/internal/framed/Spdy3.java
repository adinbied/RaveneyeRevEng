package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.DeflaterSink;
import dji.thirdparty.okio.Okio;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class Spdy3
  implements Variant
{
  static final byte[] DICTIONARY;
  static final int FLAG_FIN = 1;
  static final int FLAG_UNIDIRECTIONAL = 2;
  static final int TYPE_DATA = 0;
  static final int TYPE_GOAWAY = 7;
  static final int TYPE_HEADERS = 8;
  static final int TYPE_PING = 6;
  static final int TYPE_RST_STREAM = 3;
  static final int TYPE_SETTINGS = 4;
  static final int TYPE_SYN_REPLY = 2;
  static final int TYPE_SYN_STREAM = 1;
  static final int TYPE_WINDOW_UPDATE = 9;
  static final int VERSION = 3;
  
  static
  {
    try
    {
      DICTIONARY = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    throw new AssertionError();
  }
  
  public Protocol getProtocol()
  {
    return Protocol.SPDY_3;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final NameValueBlockReader headerBlockReader;
    private final BufferedSource source;
    
    Reader(BufferedSource paramBufferedSource, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.headerBlockReader = new NameValueBlockReader(paramBufferedSource);
      this.client = paramBoolean;
    }
    
    private static IOException ioException(String paramString, Object... paramVarArgs)
      throws IOException
    {
      throw new IOException(String.format(paramString, paramVarArgs));
    }
    
    /* Error */
    private void readGoAway(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readHeaders(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readPing(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readRstStream(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readSettings(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readSynReply(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readSynStream(FrameReader.Handler arg1, int arg2, int arg3)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void readWindowUpdate(FrameReader.Handler arg1, int arg2, int arg3)
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
      this.headerBlockReader.close();
    }
    
    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      return false;
    }
    
    public void readConnectionPreface() {}
  }
  
  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer headerBlockBuffer;
    private final BufferedSink headerBlockOut;
    private final BufferedSink sink;
    
    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      paramBufferedSink = new Deflater();
      paramBufferedSink.setDictionary(Spdy3.DICTIONARY);
      Buffer localBuffer = new Buffer();
      this.headerBlockBuffer = localBuffer;
      this.headerBlockOut = Okio.buffer(new DeflaterSink(localBuffer, paramBufferedSink));
    }
    
    /* Error */
    private void writeNameValueBlockToBuffer(List<Header> arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void ackSettings(Settings paramSettings) {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void connectionPreface() {}
    
    public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      try
      {
        sendDataFrame(paramInt1, i, paramBuffer, paramInt2);
        return;
      }
      finally
      {
        paramBuffer = finally;
        throw paramBuffer;
      }
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
    
    public int maxDataLength()
    {
      return 16383;
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
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {}
    
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
    void sendDataFrame(int arg1, int arg2, Buffer arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
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
    
    /* Error */
    public void synStream(boolean arg1, boolean arg2, int arg3, int arg4, List<Header> arg5)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore 5
      //   3: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Spdy3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */