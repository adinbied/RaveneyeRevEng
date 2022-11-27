package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\b&\030\0002\0020\001B\r\022\006\020\002\032\0020\001¢\006\002\020\003J\b\020\005\032\0020\006H\026J\r\020\002\032\0020\001H\007¢\006\002\b\007J\b\020\b\032\0020\006H\026J\b\020\t\032\0020\nH\026J\b\020\013\032\0020\fH\026J\030\020\r\032\0020\0062\006\020\016\032\0020\0172\006\020\020\032\0020\021H\026R\023\020\002\032\0020\0018\007¢\006\b\n\000\032\004\b\002\020\004¨\006\022"}, d2={"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "(Lokio/Sink;)V", "()Lokio/Sink;", "close", "", "-deprecated_delegate", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public abstract class ForwardingSink
  implements Sink
{
  private final Sink delegate;
  
  public ForwardingSink(Sink paramSink)
  {
    this.delegate = paramSink;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="delegate", imports={}))
  public final Sink -deprecated_delegate()
  {
    return this.delegate;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final Sink delegate()
  {
    return this.delegate;
  }
  
  public void flush()
    throws IOException
  {
    this.delegate.flush();
  }
  
  public Timeout timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('(');
    localStringBuilder.append(this.delegate);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    this.delegate.write(paramBuffer, paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\ForwardingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */