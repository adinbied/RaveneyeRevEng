package dji.thirdparty.okio;

import java.io.IOException;

public abstract class ForwardingSource
  implements Source
{
  private final Source delegate;
  
  public ForwardingSource(Source paramSource)
  {
    if (paramSource != null)
    {
      this.delegate = paramSource;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final Source delegate()
  {
    return this.delegate;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    return this.delegate.read(paramBuffer, paramLong);
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\ForwardingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */