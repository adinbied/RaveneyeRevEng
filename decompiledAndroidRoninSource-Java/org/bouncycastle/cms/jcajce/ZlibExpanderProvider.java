package org.bouncycastle.cms.jcajce;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.InputExpander;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.util.io.StreamOverflowException;

public class ZlibExpanderProvider
  implements InputExpanderProvider
{
  private final long limit;
  
  public ZlibExpanderProvider()
  {
    this.limit = -1L;
  }
  
  public ZlibExpanderProvider(long paramLong)
  {
    this.limit = paramLong;
  }
  
  public InputExpander get(final AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    new InputExpander()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier;
      }
      
      public InputStream getInputStream(InputStream paramAnonymousInputStream)
      {
        InflaterInputStream localInflaterInputStream = new InflaterInputStream(paramAnonymousInputStream);
        paramAnonymousInputStream = localInflaterInputStream;
        if (ZlibExpanderProvider.this.limit >= 0L) {
          paramAnonymousInputStream = new ZlibExpanderProvider.LimitedInputStream(localInflaterInputStream, ZlibExpanderProvider.this.limit);
        }
        return paramAnonymousInputStream;
      }
    };
  }
  
  private static class LimitedInputStream
    extends FilterInputStream
  {
    private long remaining;
    
    public LimitedInputStream(InputStream paramInputStream, long paramLong)
    {
      super();
      this.remaining = paramLong;
    }
    
    public int read()
      throws IOException
    {
      if (this.remaining >= 0L)
      {
        int i = this.in.read();
        if (i >= 0)
        {
          long l = this.remaining - 1L;
          this.remaining = l;
          if (l < 0L) {}
        }
        else
        {
          return i;
        }
      }
      throw new StreamOverflowException("expanded byte limit exceeded");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 < 1) {
        return super.read(paramArrayOfByte, paramInt1, paramInt2);
      }
      long l = this.remaining;
      if (l < 1L)
      {
        read();
        return -1;
      }
      if (l <= paramInt2) {
        paramInt2 = (int)l;
      }
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        this.remaining -= paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\ZlibExpanderProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */