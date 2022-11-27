package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\000\n\002\020\016\n\000\n\002\020\t\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\032\016\020\000\032\0020\0012\006\020\002\032\0020\003\032 \020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\001H\002\0322\020\013\032\002H\f\"\004\b\000\020\f2\006\020\006\032\0020\0072\006\020\b\032\0020\t2\f\020\r\032\b\022\004\022\002H\f0\016H\b¢\006\002\020\017\032'\020\020\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\t2\f\020\021\032\b\022\004\022\0020\0010\016H\b¨\006\022"}, d2={"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k=2, mv={1, 1, 16})
public final class TaskLoggerKt
{
  public static final String formatDuration(long paramLong)
  {
    if (paramLong <= -999500000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong - 500000000) / 1000000000);
      ((StringBuilder)localObject).append(" s ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramLong <= -999500)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong - 500000) / 1000000);
      ((StringBuilder)localObject).append(" ms");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramLong <= 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong - 'Ǵ') / 'Ϩ');
      ((StringBuilder)localObject).append(" µs");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramLong < 999500)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong + 'Ǵ') / 'Ϩ');
      ((StringBuilder)localObject).append(" µs");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramLong < 999500000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong + 500000) / 1000000);
      ((StringBuilder)localObject).append(" ms");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((paramLong + 500000000) / 1000000000);
      ((StringBuilder)localObject).append(" s ");
      localObject = ((StringBuilder)localObject).toString();
    }
    StringCompanionObject localStringCompanionObject = StringCompanionObject.INSTANCE;
    Object localObject = String.format("%6s", Arrays.copyOf(new Object[] { localObject }, 1));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return (String)localObject;
  }
  
  private static final void log(Task paramTask, TaskQueue paramTaskQueue, String paramString)
  {
    Logger localLogger = TaskRunner.Companion.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTaskQueue.getName$okhttp());
    localStringBuilder.append(' ');
    paramTaskQueue = StringCompanionObject.INSTANCE;
    paramTaskQueue = String.format("%-22s", Arrays.copyOf(new Object[] { paramString }, 1));
    Intrinsics.checkExpressionValueIsNotNull(paramTaskQueue, "java.lang.String.format(format, *args)");
    localStringBuilder.append(paramTaskQueue);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramTask.getName());
    localLogger.fine(localStringBuilder.toString());
  }
  
  public static final <T> T logElapsed(Task paramTask, TaskQueue paramTaskQueue, Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTask, "task");
    Intrinsics.checkParameterIsNotNull(paramTaskQueue, "queue");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    boolean bool = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
    long l1;
    if (bool)
    {
      l1 = paramTaskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
      access$log(paramTask, paramTaskQueue, "starting");
    }
    else
    {
      l1 = -1L;
    }
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      long l2;
      StringBuilder localStringBuilder;
      InlineMarker.finallyStart(1);
      if (bool)
      {
        l2 = paramTaskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed a run in ");
        localStringBuilder.append(formatDuration(l2 - l1));
        access$log(paramTask, paramTaskQueue, localStringBuilder.toString());
      }
      InlineMarker.finallyEnd(1);
    }
  }
  
  public static final void taskLog(Task paramTask, TaskQueue paramTaskQueue, Function0<String> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramTask, "task");
    Intrinsics.checkParameterIsNotNull(paramTaskQueue, "queue");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "messageBlock");
    if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
      access$log(paramTask, paramTaskQueue, (String)paramFunction0.invoke());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\concurrent\TaskLoggerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */