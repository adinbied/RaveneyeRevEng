package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okio.Buffer;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public abstract interface FrameWriter
  extends Closeable
{
  public abstract void ackSettings(Settings paramSettings)
    throws IOException;
  
  public abstract void connectionPreface()
    throws IOException;
  
  public abstract void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract void headers(int paramInt, List<Header> paramList)
    throws IOException;
  
  public abstract int maxDataLength();
  
  public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException;
  
  public abstract void rstStream(int paramInt, ErrorCode paramErrorCode)
    throws IOException;
  
  public abstract void settings(Settings paramSettings)
    throws IOException;
  
  public abstract void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
    throws IOException;
  
  public abstract void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
    throws IOException;
  
  public abstract void windowUpdate(int paramInt, long paramLong)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\FrameWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */