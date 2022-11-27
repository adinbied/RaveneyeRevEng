package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\020\013\n\002\b\006\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\004\b&\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005¢\006\002\020\006J\025\020\027\032\0020\0302\006\020\021\032\0020\022H\000¢\006\002\b\031J\b\020\032\032\0020\fH&J\b\020\033\032\0020\003H\026R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\032\020\013\032\0020\fX\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020R\034\020\021\032\004\030\0010\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026¨\006\034"}, d2={"Lokhttp3/internal/concurrent/Task;", "", "name", "", "cancelable", "", "(Ljava/lang/String;Z)V", "getCancelable", "()Z", "getName", "()Ljava/lang/String;", "nextExecuteNanoTime", "", "getNextExecuteNanoTime$okhttp", "()J", "setNextExecuteNanoTime$okhttp", "(J)V", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "initQueue", "", "initQueue$okhttp", "runOnce", "toString", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class Task
{
  private final boolean cancelable;
  private final String name;
  private long nextExecuteNanoTime;
  private TaskQueue queue;
  
  public Task(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.cancelable = paramBoolean;
    this.nextExecuteNanoTime = -1L;
  }
  
  public final boolean getCancelable()
  {
    return this.cancelable;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final long getNextExecuteNanoTime$okhttp()
  {
    return this.nextExecuteNanoTime;
  }
  
  public final TaskQueue getQueue$okhttp()
  {
    return this.queue;
  }
  
  public final void initQueue$okhttp(TaskQueue paramTaskQueue)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskQueue, "queue");
    TaskQueue localTaskQueue = this.queue;
    if (localTaskQueue == paramTaskQueue) {
      return;
    }
    int i;
    if (localTaskQueue == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.queue = paramTaskQueue;
      return;
    }
    throw ((Throwable)new IllegalStateException("task is in multiple queues".toString()));
  }
  
  public abstract long runOnce();
  
  public final void setNextExecuteNanoTime$okhttp(long paramLong)
  {
    this.nextExecuteNanoTime = paramLong;
  }
  
  public final void setQueue$okhttp(TaskQueue paramTaskQueue)
  {
    this.queue = paramTaskQueue;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\concurrent\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */