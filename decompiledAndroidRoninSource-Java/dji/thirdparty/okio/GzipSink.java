package dji.thirdparty.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc = new CRC32();
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final BufferedSink sink;
  
  public GzipSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      this.deflater = new Deflater(-1, true);
      paramSink = Okio.buffer(paramSink);
      this.sink = paramSink;
      this.deflaterSink = new DeflaterSink(paramSink, this.deflater);
      writeHeader();
      return;
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  /* Error */
  private void updateCrc(Buffer arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeFooter()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeHeader()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public void flush()
    throws IOException
  {
    this.deflaterSink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  /* Error */
  public void write(Buffer arg1, long arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\GzipSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */