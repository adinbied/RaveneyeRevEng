package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okio.ForwardingSink;
import dji.thirdparty.okio.Sink;
import java.io.IOException;

class FaultHidingSink
  extends ForwardingSink
{
  private boolean hasErrors;
  
  public FaultHidingSink(Sink paramSink)
  {
    super(paramSink);
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
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void onException(IOException paramIOException) {}
  
  /* Error */
  public void write(dji.thirdparty.okio.Buffer arg1, long arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */