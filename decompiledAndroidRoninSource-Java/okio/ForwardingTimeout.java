package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\030\002\n\002\b\007\n\002\020\t\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\b\026\030\0002\0020\001B\r\022\006\020\002\032\0020\001¢\006\002\020\003J\b\020\006\032\0020\001H\026J\b\020\007\032\0020\001H\026J\b\020\b\032\0020\tH\026J\020\020\b\032\0020\0012\006\020\b\032\0020\tH\026J\b\020\n\032\0020\013H\026J\016\020\005\032\0020\0002\006\020\002\032\0020\001J\b\020\f\032\0020\rH\026J\030\020\016\032\0020\0012\006\020\016\032\0020\t2\006\020\017\032\0020\020H\026J\b\020\021\032\0020\tH\026R\034\020\002\032\0020\0018\007X\016¢\006\016\n\000\032\004\b\002\020\004\"\004\b\005\020\003¨\006\022"}, d2={"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "okio"}, k=1, mv={1, 1, 16})
public class ForwardingTimeout
  extends Timeout
{
  private Timeout delegate;
  
  public ForwardingTimeout(Timeout paramTimeout)
  {
    this.delegate = paramTimeout;
  }
  
  public Timeout clearDeadline()
  {
    return this.delegate.clearDeadline();
  }
  
  public Timeout clearTimeout()
  {
    return this.delegate.clearTimeout();
  }
  
  public long deadlineNanoTime()
  {
    return this.delegate.deadlineNanoTime();
  }
  
  public Timeout deadlineNanoTime(long paramLong)
  {
    return this.delegate.deadlineNanoTime(paramLong);
  }
  
  public final Timeout delegate()
  {
    return this.delegate;
  }
  
  public boolean hasDeadline()
  {
    return this.delegate.hasDeadline();
  }
  
  public final ForwardingTimeout setDelegate(Timeout paramTimeout)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeout, "delegate");
    this.delegate = paramTimeout;
    return this;
  }
  
  public void throwIfReached()
    throws IOException
  {
    this.delegate.throwIfReached();
  }
  
  public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return this.delegate.timeout(paramLong, paramTimeUnit);
  }
  
  public long timeoutNanos()
  {
    return this.delegate.timeoutNanos();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\ForwardingTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */