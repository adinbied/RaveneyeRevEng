package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;

public abstract interface Variant
{
  public abstract Protocol getProtocol();
  
  public abstract FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);
  
  public abstract FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */