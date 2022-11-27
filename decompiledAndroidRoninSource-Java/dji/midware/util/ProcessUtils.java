package dji.midware.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ProcessUtils
{
  /* Error */
  public static int executeCommand(String paramString, long paramLong)
    throws IOException, java.lang.InterruptedException, java.util.concurrent.TimeoutException
  {
    // Byte code:
    //   0: invokestatic 28	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: aload_0
    //   4: invokevirtual 32	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   7: astore_0
    //   8: new 8	dji/midware/util/ProcessUtils$Worker
    //   11: dup
    //   12: aload_0
    //   13: aconst_null
    //   14: invokespecial 35	dji/midware/util/ProcessUtils$Worker:<init>	(Ljava/lang/Process;Ldji/midware/util/ProcessUtils$1;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 38	dji/midware/util/ProcessUtils$Worker:start	()V
    //   24: aload 4
    //   26: lload_1
    //   27: invokevirtual 42	dji/midware/util/ProcessUtils$Worker:join	(J)V
    //   30: aload 4
    //   32: invokestatic 46	dji/midware/util/ProcessUtils$Worker:access$100	(Ldji/midware/util/ProcessUtils$Worker;)Ljava/lang/Integer;
    //   35: ifnull +18 -> 53
    //   38: aload 4
    //   40: invokestatic 46	dji/midware/util/ProcessUtils$Worker:access$100	(Ldji/midware/util/ProcessUtils$Worker;)Ljava/lang/Integer;
    //   43: invokevirtual 52	java/lang/Integer:intValue	()I
    //   46: istore_3
    //   47: aload_0
    //   48: invokevirtual 57	java/lang/Process:destroy	()V
    //   51: iload_3
    //   52: ireturn
    //   53: new 22	java/util/concurrent/TimeoutException
    //   56: dup
    //   57: invokespecial 58	java/util/concurrent/TimeoutException:<init>	()V
    //   60: athrow
    //   61: astore 4
    //   63: goto +19 -> 82
    //   66: astore 5
    //   68: aload 4
    //   70: invokevirtual 61	dji/midware/util/ProcessUtils$Worker:interrupt	()V
    //   73: invokestatic 67	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   76: invokevirtual 68	java/lang/Thread:interrupt	()V
    //   79: aload 5
    //   81: athrow
    //   82: aload_0
    //   83: invokevirtual 57	java/lang/Process:destroy	()V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramString	String
    //   0	89	1	paramLong	long
    //   46	6	3	i	int
    //   17	22	4	localWorker	Worker
    //   61	26	4	localObject	Object
    //   66	14	5	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   24	47	61	finally
    //   53	61	61	finally
    //   68	82	61	finally
    //   24	47	66	java/lang/InterruptedException
    //   53	61	66	java/lang/InterruptedException
  }
  
  public static boolean isReachable(String paramString, int paramInt)
    throws UnknownHostException, IOException
  {
    return InetAddress.getByName(paramString).isReachable(paramInt);
  }
  
  private static class Worker
    extends Thread
  {
    private Integer exit;
    private final Process process;
    
    private Worker(Process paramProcess)
    {
      this.process = paramProcess;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */