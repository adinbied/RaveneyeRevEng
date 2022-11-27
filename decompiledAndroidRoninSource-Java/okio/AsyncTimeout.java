package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\b\026\030\000 \0332\0020\001:\002\033\034B\005¢\006\002\020\002J\022\020\b\032\0020\t2\b\020\n\032\004\030\0010\tH\001J\006\020\013\032\0020\fJ\006\020\r\032\0020\004J\022\020\016\032\0020\t2\b\020\n\032\004\030\0010\tH\024J\020\020\017\032\0020\0072\006\020\020\032\0020\007H\002J\016\020\021\032\0020\0222\006\020\021\032\0020\022J\016\020\023\032\0020\0242\006\020\023\032\0020\024J\b\020\025\032\0020\fH\024J\"\020\026\032\002H\027\"\004\b\000\020\0272\f\020\030\032\b\022\004\022\002H\0270\031H\b¢\006\002\020\032R\016\020\003\032\0020\004X\016¢\006\002\n\000R\020\020\005\032\004\030\0010\000X\016¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000¨\006\035"}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k=1, mv={1, 1, 16})
public class AsyncTimeout
  extends Timeout
{
  public static final Companion Companion = new Companion(null);
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  private static AsyncTimeout head;
  private boolean inQueue;
  private AsyncTimeout next;
  private long timeoutAt;
  
  private final long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  public final IOException access$newTimeoutException(IOException paramIOException)
  {
    return newTimeoutException(paramIOException);
  }
  
  public final void enter()
  {
    if ((this.inQueue ^ true))
    {
      long l = timeoutNanos();
      boolean bool = hasDeadline();
      if ((l == 0L) && (!bool)) {
        return;
      }
      this.inQueue = true;
      Companion.access$scheduleTimeout(Companion, this, l, bool);
      return;
    }
    throw ((Throwable)new IllegalStateException("Unbalanced enter/exit".toString()));
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return Companion.access$cancelScheduledTimeout(Companion, this);
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause((Throwable)paramIOException);
    }
    return (IOException)localInterruptedIOException;
  }
  
  public final Sink sink(final Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    (Sink)new Sink()
    {
      /* Error */
      public void close()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 40	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 53	okio/AsyncTimeout:enter	()V
        //   9: aload_0
        //   10: getfield 42	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
        //   13: invokeinterface 55 1 0
        //   18: getstatic 61	kotlin/Unit:INSTANCE	Lkotlin/Unit;
        //   21: astore_1
        //   22: aload_2
        //   23: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   26: ifne +4 -> 30
        //   29: return
        //   30: aload_2
        //   31: aconst_null
        //   32: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   35: checkcast 71	java/lang/Throwable
        //   38: athrow
        //   39: astore_1
        //   40: goto +30 -> 70
        //   43: astore_1
        //   44: aload_2
        //   45: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   48: ifne +11 -> 59
        //   51: aload_1
        //   52: checkcast 71	java/lang/Throwable
        //   55: astore_1
        //   56: goto +12 -> 68
        //   59: aload_2
        //   60: aload_1
        //   61: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   64: astore_1
        //   65: goto -14 -> 51
        //   68: aload_1
        //   69: athrow
        //   70: aload_2
        //   71: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   74: pop
        //   75: aload_1
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	1
        //   21	1	1	localUnit	Unit
        //   39	1	1	localObject1	Object
        //   43	9	1	localIOException	IOException
        //   55	21	1	localObject2	Object
        //   4	67	2	localAsyncTimeout	AsyncTimeout
        // Exception table:
        //   from	to	target	type
        //   9	22	39	finally
        //   44	51	39	finally
        //   51	56	39	finally
        //   59	65	39	finally
        //   68	70	39	finally
        //   9	22	43	java/io/IOException
      }
      
      /* Error */
      public void flush()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 40	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 53	okio/AsyncTimeout:enter	()V
        //   9: aload_0
        //   10: getfield 42	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
        //   13: invokeinterface 73 1 0
        //   18: getstatic 61	kotlin/Unit:INSTANCE	Lkotlin/Unit;
        //   21: astore_1
        //   22: aload_2
        //   23: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   26: ifne +4 -> 30
        //   29: return
        //   30: aload_2
        //   31: aconst_null
        //   32: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   35: checkcast 71	java/lang/Throwable
        //   38: athrow
        //   39: astore_1
        //   40: goto +30 -> 70
        //   43: astore_1
        //   44: aload_2
        //   45: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   48: ifne +11 -> 59
        //   51: aload_1
        //   52: checkcast 71	java/lang/Throwable
        //   55: astore_1
        //   56: goto +12 -> 68
        //   59: aload_2
        //   60: aload_1
        //   61: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   64: astore_1
        //   65: goto -14 -> 51
        //   68: aload_1
        //   69: athrow
        //   70: aload_2
        //   71: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   74: pop
        //   75: aload_1
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	1
        //   21	1	1	localUnit	Unit
        //   39	1	1	localObject1	Object
        //   43	9	1	localIOException	IOException
        //   55	21	1	localObject2	Object
        //   4	67	2	localAsyncTimeout	AsyncTimeout
        // Exception table:
        //   from	to	target	type
        //   9	22	39	finally
        //   44	51	39	finally
        //   51	56	39	finally
        //   59	65	39	finally
        //   68	70	39	finally
        //   9	22	43	java/io/IOException
      }
      
      public AsyncTimeout timeout()
      {
        return this.this$0;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.sink(");
        localStringBuilder.append(paramSink);
        localStringBuilder.append(')');
        return localStringBuilder.toString();
      }
      
      /* Error */
      public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
      {
        // Byte code:
        //   0: aload_1
        //   1: ldc 99
        //   3: invokestatic 105	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
        //   6: aload_1
        //   7: invokevirtual 111	okio/Buffer:size	()J
        //   10: lconst_0
        //   11: lload_2
        //   12: invokestatic 117	okio/-Util:checkOffsetAndCount	(JJJ)V
        //   15: lconst_0
        //   16: lstore 6
        //   18: lload_2
        //   19: lconst_0
        //   20: lcmp
        //   21: ifle +205 -> 226
        //   24: aload_1
        //   25: getfield 121	okio/Buffer:head	Lokio/Segment;
        //   28: astore 9
        //   30: lload 6
        //   32: lstore 4
        //   34: aload 9
        //   36: astore 8
        //   38: aload 9
        //   40: ifnonnull +14 -> 54
        //   43: invokestatic 124	kotlin/jvm/internal/Intrinsics:throwNpe	()V
        //   46: aload 9
        //   48: astore 8
        //   50: lload 6
        //   52: lstore 4
        //   54: lload 4
        //   56: lstore 6
        //   58: lload 4
        //   60: ldc 125
        //   62: i2l
        //   63: lcmp
        //   64: ifge +67 -> 131
        //   67: lload 4
        //   69: aload 8
        //   71: getfield 131	okio/Segment:limit	I
        //   74: aload 8
        //   76: getfield 134	okio/Segment:pos	I
        //   79: isub
        //   80: i2l
        //   81: ladd
        //   82: lstore 6
        //   84: lload 6
        //   86: lload_2
        //   87: lcmp
        //   88: iflt +9 -> 97
        //   91: lload_2
        //   92: lstore 6
        //   94: goto +37 -> 131
        //   97: aload 8
        //   99: getfield 137	okio/Segment:next	Lokio/Segment;
        //   102: astore 9
        //   104: lload 6
        //   106: lstore 4
        //   108: aload 9
        //   110: astore 8
        //   112: aload 9
        //   114: ifnonnull -60 -> 54
        //   117: invokestatic 124	kotlin/jvm/internal/Intrinsics:throwNpe	()V
        //   120: lload 6
        //   122: lstore 4
        //   124: aload 9
        //   126: astore 8
        //   128: goto -74 -> 54
        //   131: aload_0
        //   132: getfield 40	okio/AsyncTimeout$sink$1:this$0	Lokio/AsyncTimeout;
        //   135: astore 8
        //   137: aload 8
        //   139: invokevirtual 53	okio/AsyncTimeout:enter	()V
        //   142: aload_0
        //   143: getfield 42	okio/AsyncTimeout$sink$1:$sink	Lokio/Sink;
        //   146: aload_1
        //   147: lload 6
        //   149: invokeinterface 139 4 0
        //   154: getstatic 61	kotlin/Unit:INSTANCE	Lkotlin/Unit;
        //   157: astore 9
        //   159: aload 8
        //   161: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   164: ifne +11 -> 175
        //   167: lload_2
        //   168: lload 6
        //   170: lsub
        //   171: lstore_2
        //   172: goto -157 -> 15
        //   175: aload 8
        //   177: aconst_null
        //   178: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   181: checkcast 71	java/lang/Throwable
        //   184: athrow
        //   185: astore_1
        //   186: goto +32 -> 218
        //   189: astore_1
        //   190: aload 8
        //   192: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   195: ifne +11 -> 206
        //   198: aload_1
        //   199: checkcast 71	java/lang/Throwable
        //   202: astore_1
        //   203: goto +13 -> 216
        //   206: aload 8
        //   208: aload_1
        //   209: invokevirtual 69	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   212: astore_1
        //   213: goto -15 -> 198
        //   216: aload_1
        //   217: athrow
        //   218: aload 8
        //   220: invokevirtual 65	okio/AsyncTimeout:exit	()Z
        //   223: pop
        //   224: aload_1
        //   225: athrow
        //   226: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	227	0	this	1
        //   0	227	1	paramAnonymousBuffer	Buffer
        //   0	227	2	paramAnonymousLong	long
        //   32	91	4	l1	long
        //   16	153	6	l2	long
        //   36	183	8	localObject1	Object
        //   28	130	9	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   142	159	185	finally
        //   190	198	185	finally
        //   198	203	185	finally
        //   206	213	185	finally
        //   216	218	185	finally
        //   142	159	189	java/io/IOException
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    (Source)new Source()
    {
      /* Error */
      public void close()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 39	okio/AsyncTimeout$source$1:this$0	Lokio/AsyncTimeout;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 52	okio/AsyncTimeout:enter	()V
        //   9: aload_0
        //   10: getfield 41	okio/AsyncTimeout$source$1:$source	Lokio/Source;
        //   13: invokeinterface 54 1 0
        //   18: getstatic 60	kotlin/Unit:INSTANCE	Lkotlin/Unit;
        //   21: astore_1
        //   22: aload_2
        //   23: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   26: ifne +4 -> 30
        //   29: return
        //   30: aload_2
        //   31: aconst_null
        //   32: invokevirtual 68	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   35: checkcast 70	java/lang/Throwable
        //   38: athrow
        //   39: astore_1
        //   40: goto +30 -> 70
        //   43: astore_1
        //   44: aload_2
        //   45: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   48: ifne +11 -> 59
        //   51: aload_1
        //   52: checkcast 70	java/lang/Throwable
        //   55: astore_1
        //   56: goto +12 -> 68
        //   59: aload_2
        //   60: aload_1
        //   61: invokevirtual 68	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   64: astore_1
        //   65: goto -14 -> 51
        //   68: aload_1
        //   69: athrow
        //   70: aload_2
        //   71: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   74: pop
        //   75: aload_1
        //   76: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	77	0	this	1
        //   21	1	1	localUnit	Unit
        //   39	1	1	localObject1	Object
        //   43	9	1	localIOException	IOException
        //   55	21	1	localObject2	Object
        //   4	67	2	localAsyncTimeout	AsyncTimeout
        // Exception table:
        //   from	to	target	type
        //   9	22	39	finally
        //   44	51	39	finally
        //   51	56	39	finally
        //   59	65	39	finally
        //   68	70	39	finally
        //   9	22	43	java/io/IOException
      }
      
      /* Error */
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
      {
        // Byte code:
        //   0: aload_1
        //   1: ldc 72
        //   3: invokestatic 78	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
        //   6: aload_0
        //   7: getfield 39	okio/AsyncTimeout$source$1:this$0	Lokio/AsyncTimeout;
        //   10: astore 4
        //   12: aload 4
        //   14: invokevirtual 52	okio/AsyncTimeout:enter	()V
        //   17: aload_0
        //   18: getfield 41	okio/AsyncTimeout$source$1:$source	Lokio/Source;
        //   21: aload_1
        //   22: lload_2
        //   23: invokeinterface 80 4 0
        //   28: lstore_2
        //   29: aload 4
        //   31: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   34: ifne +5 -> 39
        //   37: lload_2
        //   38: lreturn
        //   39: aload 4
        //   41: aconst_null
        //   42: invokevirtual 68	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   45: checkcast 70	java/lang/Throwable
        //   48: athrow
        //   49: astore_1
        //   50: goto +32 -> 82
        //   53: astore_1
        //   54: aload 4
        //   56: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   59: ifne +11 -> 70
        //   62: aload_1
        //   63: checkcast 70	java/lang/Throwable
        //   66: astore_1
        //   67: goto +13 -> 80
        //   70: aload 4
        //   72: aload_1
        //   73: invokevirtual 68	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
        //   76: astore_1
        //   77: goto -15 -> 62
        //   80: aload_1
        //   81: athrow
        //   82: aload 4
        //   84: invokevirtual 64	okio/AsyncTimeout:exit	()Z
        //   87: pop
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	1
        //   0	90	1	paramAnonymousBuffer	Buffer
        //   0	90	2	paramAnonymousLong	long
        //   10	73	4	localAsyncTimeout	AsyncTimeout
        // Exception table:
        //   from	to	target	type
        //   17	29	49	finally
        //   54	62	49	finally
        //   62	67	49	finally
        //   70	77	49	finally
        //   80	82	49	finally
        //   17	29	53	java/io/IOException
      }
      
      public AsyncTimeout timeout()
      {
        return this.this$0;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AsyncTimeout.source(");
        localStringBuilder.append(paramSource);
        localStringBuilder.append(')');
        return localStringBuilder.toString();
      }
    };
  }
  
  protected void timedOut() {}
  
  /* Error */
  public final <T> T withTimeout(kotlin.jvm.functions.Function0<? extends T> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -72
    //   3: invokestatic 171	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual 186	okio/AsyncTimeout:enter	()V
    //   10: aload_1
    //   11: invokeinterface 192 1 0
    //   16: astore_1
    //   17: iconst_1
    //   18: invokestatic 198	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   21: aload_0
    //   22: invokevirtual 200	okio/AsyncTimeout:exit	()Z
    //   25: ifne +9 -> 34
    //   28: iconst_1
    //   29: invokestatic 203	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: aconst_null
    //   36: invokevirtual 205	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   39: checkcast 148	java/lang/Throwable
    //   42: athrow
    //   43: astore_1
    //   44: goto +30 -> 74
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 200	okio/AsyncTimeout:exit	()Z
    //   52: ifne +11 -> 63
    //   55: aload_1
    //   56: checkcast 148	java/lang/Throwable
    //   59: astore_1
    //   60: goto +12 -> 72
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 205	okio/AsyncTimeout:access$newTimeoutException	(Ljava/io/IOException;)Ljava/io/IOException;
    //   68: astore_1
    //   69: goto -14 -> 55
    //   72: aload_1
    //   73: athrow
    //   74: iconst_1
    //   75: invokestatic 198	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   78: aload_0
    //   79: invokevirtual 200	okio/AsyncTimeout:exit	()Z
    //   82: pop
    //   83: iconst_1
    //   84: invokestatic 203	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	AsyncTimeout
    //   0	89	1	paramFunction0	kotlin.jvm.functions.Function0<? extends T>
    // Exception table:
    //   from	to	target	type
    //   10	17	43	finally
    //   48	55	43	finally
    //   55	60	43	finally
    //   63	69	43	finally
    //   72	74	43	finally
    //   10	17	47	java/io/IOException
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\020\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\017\020\n\032\004\030\0010\tH\000¢\006\002\b\013J\020\020\f\032\0020\r2\006\020\016\032\0020\tH\002J \020\017\032\0020\0202\006\020\016\032\0020\t2\006\020\021\032\0020\0042\006\020\022\032\0020\rH\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007XT¢\006\002\n\000R\020\020\b\032\004\030\0010\tX\016¢\006\002\n\000¨\006\023"}, d2={"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
    {
      try
      {
        for (AsyncTimeout localAsyncTimeout = AsyncTimeout.access$getHead$cp(); localAsyncTimeout != null; localAsyncTimeout = AsyncTimeout.access$getNext$p(localAsyncTimeout)) {
          if (AsyncTimeout.access$getNext$p(localAsyncTimeout) == paramAsyncTimeout)
          {
            AsyncTimeout.access$setNext$p(localAsyncTimeout, AsyncTimeout.access$getNext$p(paramAsyncTimeout));
            AsyncTimeout.access$setNext$p(paramAsyncTimeout, (AsyncTimeout)null);
            return false;
          }
        }
        return true;
      }
      finally {}
    }
    
    private final void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
    {
      try
      {
        if (AsyncTimeout.access$getHead$cp() == null)
        {
          AsyncTimeout.access$setHead$cp(new AsyncTimeout());
          new AsyncTimeout.Watchdog().start();
        }
        long l = System.nanoTime();
        boolean bool = paramLong < 0L;
        if ((bool) && (paramBoolean))
        {
          AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
        }
        else if (bool)
        {
          AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, paramLong + l);
        }
        else
        {
          if (!paramBoolean) {
            break label230;
          }
          AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, paramAsyncTimeout.deadlineNanoTime());
        }
        paramLong = AsyncTimeout.access$remainingNanos(paramAsyncTimeout, l);
        AsyncTimeout localAsyncTimeout2 = AsyncTimeout.access$getHead$cp();
        AsyncTimeout localAsyncTimeout1 = localAsyncTimeout2;
        if (localAsyncTimeout2 == null)
        {
          Intrinsics.throwNpe();
          localAsyncTimeout1 = localAsyncTimeout2;
        }
        while (AsyncTimeout.access$getNext$p(localAsyncTimeout1) != null)
        {
          localAsyncTimeout2 = AsyncTimeout.access$getNext$p(localAsyncTimeout1);
          if (localAsyncTimeout2 == null) {
            Intrinsics.throwNpe();
          }
          if (paramLong < AsyncTimeout.access$remainingNanos(localAsyncTimeout2, l)) {
            break;
          }
          localAsyncTimeout2 = AsyncTimeout.access$getNext$p(localAsyncTimeout1);
          localAsyncTimeout1 = localAsyncTimeout2;
          if (localAsyncTimeout2 == null)
          {
            Intrinsics.throwNpe();
            localAsyncTimeout1 = localAsyncTimeout2;
          }
        }
        AsyncTimeout.access$setNext$p(paramAsyncTimeout, AsyncTimeout.access$getNext$p(localAsyncTimeout1));
        AsyncTimeout.access$setNext$p(localAsyncTimeout1, paramAsyncTimeout);
        if (localAsyncTimeout1 == AsyncTimeout.access$getHead$cp()) {
          ((Object)AsyncTimeout.class).notify();
        }
        paramAsyncTimeout = Unit.INSTANCE;
        return;
        label230:
        throw ((Throwable)new AssertionError());
      }
      finally {}
    }
    
    public final AsyncTimeout awaitTimeout$okio()
      throws InterruptedException
    {
      Object localObject = AsyncTimeout.access$getHead$cp();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = AsyncTimeout.access$getNext$p((AsyncTimeout)localObject);
      AsyncTimeout localAsyncTimeout1 = null;
      if (localObject == null)
      {
        l1 = System.nanoTime();
        ((Object)AsyncTimeout.class).wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
        AsyncTimeout localAsyncTimeout2 = AsyncTimeout.access$getHead$cp();
        if (localAsyncTimeout2 == null) {
          Intrinsics.throwNpe();
        }
        localObject = localAsyncTimeout1;
        if (AsyncTimeout.access$getNext$p(localAsyncTimeout2) == null)
        {
          localObject = localAsyncTimeout1;
          if (System.nanoTime() - l1 >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) {
            localObject = AsyncTimeout.access$getHead$cp();
          }
        }
        return (AsyncTimeout)localObject;
      }
      long l1 = AsyncTimeout.access$remainingNanos((AsyncTimeout)localObject, System.nanoTime());
      if (l1 > 0L)
      {
        long l2 = l1 / 1000000L;
        ((Object)AsyncTimeout.class).wait(l2, (int)(l1 - 1000000L * l2));
        return null;
      }
      localAsyncTimeout1 = AsyncTimeout.access$getHead$cp();
      if (localAsyncTimeout1 == null) {
        Intrinsics.throwNpe();
      }
      AsyncTimeout.access$setNext$p(localAsyncTimeout1, AsyncTimeout.access$getNext$p((AsyncTimeout)localObject));
      AsyncTimeout.access$setNext$p((AsyncTimeout)localObject, (AsyncTimeout)null);
      return (AsyncTimeout)localObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\b\002\030\0002\0020\001B\007\b\000¢\006\002\020\002J\b\020\003\032\0020\004H\026¨\006\005"}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k=1, mv={1, 1, 16})
  private static final class Watchdog
    extends Thread
  {
    public Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          AsyncTimeout localAsyncTimeout = (AsyncTimeout)null;
          try
          {
            localAsyncTimeout = AsyncTimeout.Companion.awaitTimeout$okio();
            if (localAsyncTimeout == AsyncTimeout.access$getHead$cp())
            {
              AsyncTimeout.access$setHead$cp((AsyncTimeout)null);
              return;
            }
            Unit localUnit = Unit.INSTANCE;
            if (localAsyncTimeout != null) {
              localAsyncTimeout.timedOut();
            }
          }
          finally {}
        }
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */