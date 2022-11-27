package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b&\030\0002\0020\001B\r\022\006\020\002\032\0020\001¢\006\002\020\003J\b\020\005\032\0020\006H\026J\r\020\002\032\0020\001H\007¢\006\002\b\007J\030\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\tH\026J\b\020\r\032\0020\016H\026J\b\020\017\032\0020\020H\026R\023\020\002\032\0020\0018\007¢\006\b\n\000\032\004\b\002\020\004¨\006\021"}, d2={"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, k=1, mv={1, 1, 16})
public abstract class ForwardingSource
  implements Source
{
  private final Source delegate;
  
  public ForwardingSource(Source paramSource)
  {
    this.delegate = paramSource;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="delegate", imports={}))
  public final Source -deprecated_delegate()
  {
    return this.delegate;
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
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    return this.delegate.read(paramBuffer, paramLong);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\ForwardingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */