package dji.thirdparty.okio;

import java.io.IOException;

public class AsyncTimeout
  extends Timeout
{
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  private static AsyncTimeout head;
  private boolean inQueue;
  private AsyncTimeout next;
  private long timeoutAt;
  
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    try
    {
      AsyncTimeout localAsyncTimeout = head.next;
      if (localAsyncTimeout == null)
      {
        AsyncTimeout.class.wait();
        return null;
      }
      long l1 = localAsyncTimeout.remainingNanos(System.nanoTime());
      if (l1 > 0L)
      {
        long l2 = l1 / 1000000L;
        Long.signum(l2);
        int i = (int)(l1 - 1000000L * l2);
        AsyncTimeout.class.wait(l2, i);
        return null;
      }
      head.next = localAsyncTimeout.next;
      localAsyncTimeout.next = null;
      return localAsyncTimeout;
    }
    finally {}
  }
  
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    try
    {
      for (AsyncTimeout localAsyncTimeout = head; localAsyncTimeout != null; localAsyncTimeout = localAsyncTimeout.next) {
        if (localAsyncTimeout.next == paramAsyncTimeout)
        {
          localAsyncTimeout.next = paramAsyncTimeout.next;
          paramAsyncTimeout.next = null;
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (head == null)
      {
        head = new AsyncTimeout();
        new Watchdog().start();
      }
      long l = System.nanoTime();
      boolean bool = paramLong < 0L;
      if ((bool) && (paramBoolean))
      {
        paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
      }
      else if (bool)
      {
        paramAsyncTimeout.timeoutAt = (paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label177;
        }
        paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      }
      paramLong = paramAsyncTimeout.remainingNanos(l);
      for (AsyncTimeout localAsyncTimeout = head; (localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l)); localAsyncTimeout = localAsyncTimeout.next) {}
      paramAsyncTimeout.next = localAsyncTimeout.next;
      localAsyncTimeout.next = paramAsyncTimeout;
      if (localAsyncTimeout == head) {
        AsyncTimeout.class.notify();
      }
      return;
      label177:
      throw new AssertionError();
    }
    finally {}
  }
  
  /* Error */
  public final void enter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final IOException exit(IOException paramIOException)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  final void exit(boolean arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public final boolean exit()
  {
    return false;
  }
  
  protected IOException newTimeoutException(IOException paramIOException)
  {
    return null;
  }
  
  public final Sink sink(final Sink paramSink)
  {
    new Sink()
    {
      /* Error */
      public void close()
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      /* Error */
      public void flush()
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return null;
      }
      
      /* Error */
      public void write(Buffer arg1, long arg2)
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    new Source()
    {
      /* Error */
      public void close()
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        return 277869549L;
      }
      
      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }
      
      public String toString()
      {
        return null;
      }
    };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog
    extends Thread
  {
    public Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */