package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ByteString;
import dji.thirdparty.okio.ForwardingSource;
import dji.thirdparty.okio.InflaterSource;
import dji.thirdparty.okio.Okio;
import dji.thirdparty.okio.Source;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class NameValueBlockReader
{
  private int compressedLimit;
  private final InflaterSource inflaterSource;
  private final BufferedSource source;
  
  public NameValueBlockReader(BufferedSource paramBufferedSource)
  {
    paramBufferedSource = new InflaterSource(new ForwardingSource(paramBufferedSource)new Inflater
    {
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        return 277961422L;
      }
    }, new Inflater()
    {
      public int inflate(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws DataFormatException
      {
        return 0;
      }
    });
    this.inflaterSource = paramBufferedSource;
    this.source = Okio.buffer(paramBufferedSource);
  }
  
  /* Error */
  private void doneReading()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private ByteString readByteString()
    throws IOException
  {
    return null;
  }
  
  public void close()
    throws IOException
  {
    this.source.close();
  }
  
  public List<Header> readNameValueBlock(int paramInt)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\NameValueBlockReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */