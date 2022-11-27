package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000D\n\002\030\002\n\002\020\000\n\000\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\004\n\002\030\002\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\036\032\0020\0372\006\020\021\032\0020\nJ\r\020\021\032\0020\nH\007¢\006\002\b J\r\020\030\032\0020\031H\007¢\006\002\b!J&\020\"\032\0020\037*\0020\n2\027\020#\032\023\022\004\022\0020\n\022\004\022\0020\0370$¢\006\002\b%H\bR\024\020\005\032\0020\006X\004¢\006\b\n\000\032\004\b\007\020\bR\034\020\t\032\004\030\0010\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\017\020\020R\023\020\021\032\0020\n8G¢\006\b\n\000\032\004\b\021\020\fR\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\023\020\030\032\0020\0318G¢\006\b\n\000\032\004\b\030\020\032R\032\020\033\032\0020\023X\016¢\006\016\n\000\032\004\b\034\020\025\"\004\b\035\020\027¨\006&"}, d2={"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "", "getSinkClosed$okio", "()Z", "setSinkClosed$okio", "(Z)V", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "fold", "", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k=1, mv={1, 1, 16})
public final class Pipe
{
  private final Buffer buffer;
  private Sink foldedSink;
  private final long maxBufferSize;
  private final Sink sink;
  private boolean sinkClosed;
  private final Source source;
  private boolean sourceClosed;
  
  public Pipe(long paramLong)
  {
    this.maxBufferSize = paramLong;
    this.buffer = new Buffer();
    int i;
    if (this.maxBufferSize >= 1L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.sink = ((Sink)new Sink()
      {
        private final Timeout timeout = new Timeout();
        
        public void close()
        {
          Object localObject1 = (Sink)null;
          synchronized (this.this$0.getBuffer$okio())
          {
            boolean bool = this.this$0.getSinkClosed$okio();
            if (bool) {
              return;
            }
            Object localObject5 = this.this$0.getFoldedSink$okio();
            if (localObject5 != null)
            {
              localObject1 = localObject5;
            }
            else
            {
              if ((this.this$0.getSourceClosed$okio()) && (this.this$0.getBuffer$okio().size() > 0L)) {
                throw ((Throwable)new IOException("source is closed"));
              }
              this.this$0.setSinkClosed$okio(true);
              localObject5 = this.this$0.getBuffer$okio();
              if (localObject5 == null) {
                break label385;
              }
              ((Object)localObject5).notifyAll();
            }
            localObject5 = Unit.INSTANCE;
            if (localObject1 != null)
            {
              ??? = this.this$0;
              localObject5 = ((Sink)localObject1).timeout();
              ??? = ((Pipe)???).sink().timeout();
              long l1 = ((Timeout)localObject5).timeoutNanos();
              ((Timeout)localObject5).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject5).timeoutNanos()), TimeUnit.NANOSECONDS);
              if (((Timeout)localObject5).hasDeadline())
              {
                long l2 = ((Timeout)localObject5).deadlineNanoTime();
                if (((Timeout)???).hasDeadline()) {
                  ((Timeout)localObject5).deadlineNanoTime(Math.min(((Timeout)localObject5).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
                }
                try
                {
                  ((Sink)localObject1).close();
                  return;
                }
                finally
                {
                  ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject5).deadlineNanoTime(l2);
                  }
                }
              }
              else
              {
                if (((Timeout)???).hasDeadline()) {
                  ((Timeout)localObject5).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
                }
                try
                {
                  ((Sink)localObject2).close();
                  return;
                }
                finally
                {
                  ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject5).clearDeadline();
                  }
                }
              }
            }
            return;
            label385:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
          }
        }
        
        public void flush()
        {
          Object localObject5 = (Sink)null;
          synchronized (this.this$0.getBuffer$okio())
          {
            if ((this.this$0.getSinkClosed$okio() ^ true))
            {
              Object localObject1 = this.this$0.getFoldedSink$okio();
              if (localObject1 == null)
              {
                localObject1 = localObject5;
                if (this.this$0.getSourceClosed$okio()) {
                  if (this.this$0.getBuffer$okio().size() <= 0L) {
                    localObject1 = localObject5;
                  } else {
                    throw ((Throwable)new IOException("source is closed"));
                  }
                }
              }
              localObject5 = Unit.INSTANCE;
              if (localObject1 != null)
              {
                ??? = this.this$0;
                localObject5 = ((Sink)localObject1).timeout();
                ??? = ((Pipe)???).sink().timeout();
                long l1 = ((Timeout)localObject5).timeoutNanos();
                ((Timeout)localObject5).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject5).timeoutNanos()), TimeUnit.NANOSECONDS);
                if (((Timeout)localObject5).hasDeadline())
                {
                  long l2 = ((Timeout)localObject5).deadlineNanoTime();
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject5).deadlineNanoTime(Math.min(((Timeout)localObject5).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
                  }
                  try
                  {
                    ((Sink)localObject1).flush();
                    return;
                  }
                  finally
                  {
                    ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
                    if (((Timeout)???).hasDeadline()) {
                      ((Timeout)localObject5).deadlineNanoTime(l2);
                    }
                  }
                }
                else
                {
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject5).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
                  }
                  try
                  {
                    ((Sink)localObject2).flush();
                    return;
                  }
                  finally
                  {
                    ((Timeout)localObject5).timeout(l1, TimeUnit.NANOSECONDS);
                    if (((Timeout)???).hasDeadline()) {
                      ((Timeout)localObject5).clearDeadline();
                    }
                  }
                }
              }
              return;
            }
            throw ((Throwable)new IllegalStateException("closed".toString()));
          }
        }
        
        public Timeout timeout()
        {
          return this.timeout;
        }
        
        public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousBuffer, "source");
          Object localObject2 = (Sink)null;
          synchronized (this.this$0.getBuffer$okio())
          {
            if ((this.this$0.getSinkClosed$okio() ^ true))
            {
              Object localObject1;
              long l1;
              for (;;)
              {
                localObject1 = localObject2;
                if (paramAnonymousLong <= 0L) {
                  break label191;
                }
                localObject1 = this.this$0.getFoldedSink$okio();
                if (localObject1 != null) {
                  break label191;
                }
                if (this.this$0.getSourceClosed$okio()) {
                  break label178;
                }
                l1 = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                if (l1 == 0L)
                {
                  this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                }
                else
                {
                  l1 = Math.min(l1, paramAnonymousLong);
                  this.this$0.getBuffer$okio().write(paramAnonymousBuffer, l1);
                  paramAnonymousLong -= l1;
                  localObject1 = this.this$0.getBuffer$okio();
                  if (localObject1 == null) {
                    break;
                  }
                  ((Object)localObject1).notifyAll();
                }
              }
              throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              label178:
              throw ((Throwable)new IOException("source is closed"));
              label191:
              localObject2 = Unit.INSTANCE;
              if (localObject1 != null)
              {
                ??? = this.this$0;
                localObject2 = ((Sink)localObject1).timeout();
                ??? = ((Pipe)???).sink().timeout();
                l1 = ((Timeout)localObject2).timeoutNanos();
                ((Timeout)localObject2).timeout(Timeout.Companion.minTimeout(((Timeout)???).timeoutNanos(), ((Timeout)localObject2).timeoutNanos()), TimeUnit.NANOSECONDS);
                if (((Timeout)localObject2).hasDeadline())
                {
                  long l2 = ((Timeout)localObject2).deadlineNanoTime();
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject2).deadlineNanoTime(Math.min(((Timeout)localObject2).deadlineNanoTime(), ((Timeout)???).deadlineNanoTime()));
                  }
                  try
                  {
                    ((Sink)localObject1).write(paramAnonymousBuffer, paramAnonymousLong);
                    return;
                  }
                  finally
                  {
                    ((Timeout)localObject2).timeout(l1, TimeUnit.NANOSECONDS);
                    if (((Timeout)???).hasDeadline()) {
                      ((Timeout)localObject2).deadlineNanoTime(l2);
                    }
                  }
                }
                else
                {
                  if (((Timeout)???).hasDeadline()) {
                    ((Timeout)localObject2).deadlineNanoTime(((Timeout)???).deadlineNanoTime());
                  }
                  try
                  {
                    ((Sink)localObject1).write(paramAnonymousBuffer, paramAnonymousLong);
                    return;
                  }
                  finally
                  {
                    ((Timeout)localObject2).timeout(l1, TimeUnit.NANOSECONDS);
                    if (((Timeout)???).hasDeadline()) {
                      ((Timeout)localObject2).clearDeadline();
                    }
                  }
                }
              }
              return;
            }
            throw ((Throwable)new IllegalStateException("closed".toString()));
          }
        }
      });
      this.source = ((Source)new Source()
      {
        private final Timeout timeout = new Timeout();
        
        public void close()
        {
          synchronized (this.this$0.getBuffer$okio())
          {
            this.this$0.setSourceClosed$okio(true);
            Object localObject1 = this.this$0.getBuffer$okio();
            if (localObject1 != null)
            {
              ((Object)localObject1).notifyAll();
              localObject1 = Unit.INSTANCE;
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
          }
        }
        
        public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousBuffer, "sink");
          synchronized (this.this$0.getBuffer$okio())
          {
            if ((this.this$0.getSourceClosed$okio() ^ true))
            {
              while (this.this$0.getBuffer$okio().size() == 0L)
              {
                boolean bool = this.this$0.getSinkClosed$okio();
                if (bool) {
                  return -1L;
                }
                this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
              }
              paramAnonymousLong = this.this$0.getBuffer$okio().read(paramAnonymousBuffer, paramAnonymousLong);
              paramAnonymousBuffer = this.this$0.getBuffer$okio();
              if (paramAnonymousBuffer != null)
              {
                ((Object)paramAnonymousBuffer).notifyAll();
                return paramAnonymousLong;
              }
              throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
            }
            throw ((Throwable)new IllegalStateException("closed".toString()));
          }
        }
        
        public Timeout timeout()
        {
          return this.timeout;
        }
      });
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxBufferSize < 1: ");
    localStringBuilder.append(this.maxBufferSize);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  private final void forward(Sink paramSink, Function1<? super Sink, Unit> paramFunction1)
  {
    Timeout localTimeout1 = paramSink.timeout();
    Timeout localTimeout2 = sink().timeout();
    long l1 = localTimeout1.timeoutNanos();
    localTimeout1.timeout(Timeout.Companion.minTimeout(localTimeout2.timeoutNanos(), localTimeout1.timeoutNanos()), TimeUnit.NANOSECONDS);
    if (localTimeout1.hasDeadline())
    {
      long l2 = localTimeout1.deadlineNanoTime();
      if (localTimeout2.hasDeadline()) {
        localTimeout1.deadlineNanoTime(Math.min(localTimeout1.deadlineNanoTime(), localTimeout2.deadlineNanoTime()));
      }
      try
      {
        paramFunction1.invoke(paramSink);
        return;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        localTimeout1.timeout(l1, TimeUnit.NANOSECONDS);
        if (localTimeout2.hasDeadline()) {
          localTimeout1.deadlineNanoTime(l2);
        }
        InlineMarker.finallyEnd(1);
      }
    }
    if (localTimeout2.hasDeadline()) {
      localTimeout1.deadlineNanoTime(localTimeout2.deadlineNanoTime());
    }
    try
    {
      paramFunction1.invoke(paramSink);
      return;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      localTimeout1.timeout(l1, TimeUnit.NANOSECONDS);
      if (localTimeout2.hasDeadline()) {
        localTimeout1.clearDeadline();
      }
      InlineMarker.finallyEnd(1);
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sink", imports={}))
  public final Sink -deprecated_sink()
  {
    return this.sink;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="source", imports={}))
  public final Source -deprecated_source()
  {
    return this.source;
  }
  
  public final void fold(Sink arg1)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(???, "sink");
    for (;;)
    {
      synchronized (this.buffer)
      {
        if (this.foldedSink == null)
        {
          i = 1;
          if (i != 0)
          {
            if (this.buffer.exhausted())
            {
              this.sourceClosed = true;
              this.foldedSink = ???;
              return;
            }
            boolean bool = this.sinkClosed;
            Object localObject3 = new Buffer();
            ((Buffer)localObject3).write(this.buffer, this.buffer.size());
            Object localObject4 = this.buffer;
            if (localObject4 != null)
            {
              ((Object)localObject4).notifyAll();
              localObject4 = Unit.INSTANCE;
              try
              {
                ???.write((Buffer)localObject3, ((Buffer)localObject3).size());
                if (bool)
                {
                  ???.close();
                  continue;
                }
                ???.flush();
                continue;
              }
              finally
              {
                synchronized (this.buffer)
                {
                  this.sourceClosed = true;
                  localObject3 = this.buffer;
                  if (localObject3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                  }
                  ((Object)localObject3).notifyAll();
                  localObject3 = Unit.INSTANCE;
                  throw ((Throwable)localObject1);
                }
              }
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
          }
          throw ((Throwable)new IllegalStateException("sink already folded".toString()));
        }
      }
      int i = 0;
    }
  }
  
  public final Buffer getBuffer$okio()
  {
    return this.buffer;
  }
  
  public final Sink getFoldedSink$okio()
  {
    return this.foldedSink;
  }
  
  public final long getMaxBufferSize$okio()
  {
    return this.maxBufferSize;
  }
  
  public final boolean getSinkClosed$okio()
  {
    return this.sinkClosed;
  }
  
  public final boolean getSourceClosed$okio()
  {
    return this.sourceClosed;
  }
  
  public final void setFoldedSink$okio(Sink paramSink)
  {
    this.foldedSink = paramSink;
  }
  
  public final void setSinkClosed$okio(boolean paramBoolean)
  {
    this.sinkClosed = paramBoolean;
  }
  
  public final void setSourceClosed$okio(boolean paramBoolean)
  {
    this.sourceClosed = paramBoolean;
  }
  
  public final Sink sink()
  {
    return this.sink;
  }
  
  public final Source source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Pipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */