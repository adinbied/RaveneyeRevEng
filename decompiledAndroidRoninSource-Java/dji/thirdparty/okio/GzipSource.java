package dji.thirdparty.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource
  implements Source
{
  private static final byte FCOMMENT = 4;
  private static final byte FEXTRA = 2;
  private static final byte FHCRC = 1;
  private static final byte FNAME = 3;
  private static final byte SECTION_BODY = 1;
  private static final byte SECTION_DONE = 3;
  private static final byte SECTION_HEADER = 0;
  private static final byte SECTION_TRAILER = 2;
  private final CRC32 crc = new CRC32();
  private final Inflater inflater;
  private final InflaterSource inflaterSource;
  private int section = 0;
  private final BufferedSource source;
  
  public GzipSource(Source paramSource)
  {
    if (paramSource != null)
    {
      this.inflater = new Inflater(true);
      paramSource = Okio.buffer(paramSource);
      this.source = paramSource;
      this.inflaterSource = new InflaterSource(paramSource, this.inflater);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  /* Error */
  private void checkEqual(String arg1, int arg2, int arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void consumeHeader()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void consumeTrailer()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateCrc(Buffer arg1, long arg2, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void close()
    throws IOException
  {
    this.inflaterSource.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    return 277870021L;
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\GzipSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */