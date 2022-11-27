package org.greenrobot.eventbus;

import java.util.concurrent.ExecutorService;

final class BackgroundPoster
  implements Runnable, Poster
{
  private final EventBus eventBus;
  private volatile boolean executorRunning;
  private final PendingPostQueue queue;
  
  BackgroundPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }
  
  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    paramSubscription = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    try
    {
      this.queue.enqueue(paramSubscription);
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        this.eventBus.getExecutorService().execute(this);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/greenrobot/eventbus/BackgroundPoster:queue	Lorg/greenrobot/eventbus/PendingPostQueue;
    //   4: sipush 1000
    //   7: invokevirtual 59	org/greenrobot/eventbus/PendingPostQueue:poll	(I)Lorg/greenrobot/eventbus/PendingPost;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: aload_2
    //   14: ifnonnull +40 -> 54
    //   17: aload_0
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 26	org/greenrobot/eventbus/BackgroundPoster:queue	Lorg/greenrobot/eventbus/PendingPostQueue;
    //   23: invokevirtual 62	org/greenrobot/eventbus/PendingPostQueue:poll	()Lorg/greenrobot/eventbus/PendingPost;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +16 -> 44
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 40	org/greenrobot/eventbus/BackgroundPoster:executorRunning	Z
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 40	org/greenrobot/eventbus/BackgroundPoster:executorRunning	Z
    //   43: return
    //   44: aload_0
    //   45: monitorexit
    //   46: goto +8 -> 54
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: aload_0
    //   55: getfield 21	org/greenrobot/eventbus/BackgroundPoster:eventBus	Lorg/greenrobot/eventbus/EventBus;
    //   58: aload_1
    //   59: invokevirtual 65	org/greenrobot/eventbus/EventBus:invokeSubscriber	(Lorg/greenrobot/eventbus/PendingPost;)V
    //   62: goto -62 -> 0
    //   65: astore_1
    //   66: goto +64 -> 130
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 21	org/greenrobot/eventbus/BackgroundPoster:eventBus	Lorg/greenrobot/eventbus/EventBus;
    //   74: invokevirtual 69	org/greenrobot/eventbus/EventBus:getLogger	()Lorg/greenrobot/eventbus/Logger;
    //   77: astore_2
    //   78: getstatic 75	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   81: astore_3
    //   82: new 77	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   89: astore 4
    //   91: aload 4
    //   93: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   96: invokevirtual 88	java/lang/Thread:getName	()Ljava/lang/String;
    //   99: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: ldc 94
    //   107: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_3
    //   113: aload 4
    //   115: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aload_1
    //   119: invokeinterface 103 4 0
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield 40	org/greenrobot/eventbus/BackgroundPoster:executorRunning	Z
    //   129: return
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 40	org/greenrobot/eventbus/BackgroundPoster:executorRunning	Z
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	BackgroundPoster
    //   12	16	1	localObject1	Object
    //   49	10	1	localPendingPost	PendingPost
    //   65	1	1	localObject2	Object
    //   69	67	1	localInterruptedException	InterruptedException
    //   10	102	2	localObject3	Object
    //   81	32	3	localLevel	java.util.logging.Level
    //   89	25	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	27	49	finally
    //   31	38	49	finally
    //   44	46	49	finally
    //   50	52	49	finally
    //   0	11	65	finally
    //   17	19	65	finally
    //   52	54	65	finally
    //   54	62	65	finally
    //   70	124	65	finally
    //   0	11	69	java/lang/InterruptedException
    //   17	19	69	java/lang/InterruptedException
    //   52	54	69	java/lang/InterruptedException
    //   54	62	69	java/lang/InterruptedException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\BackgroundPoster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */