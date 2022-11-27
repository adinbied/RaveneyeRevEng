package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobScheduler
{
  static final String QUEUE_TIME_KEY = "queueTime";
  private final Runnable mDoJobRunnable;
  EncodedImage mEncodedImage;
  private final Executor mExecutor;
  private final JobRunnable mJobRunnable;
  long mJobStartTime;
  JobState mJobState;
  long mJobSubmitTime;
  private final int mMinimumJobIntervalMs;
  int mStatus;
  private final Runnable mSubmitJobRunnable;
  
  public JobScheduler(Executor paramExecutor, JobRunnable paramJobRunnable, int paramInt)
  {
    this.mExecutor = paramExecutor;
    this.mJobRunnable = paramJobRunnable;
    this.mMinimumJobIntervalMs = paramInt;
    this.mDoJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.doJob();
      }
    };
    this.mSubmitJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.submitJob();
      }
    };
    this.mEncodedImage = null;
    this.mStatus = 0;
    this.mJobState = JobState.IDLE;
    this.mJobSubmitTime = 0L;
    this.mJobStartTime = 0L;
  }
  
  /* Error */
  private void doJob()
  {
    // Byte code:
    //   0: invokestatic 87	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 61	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 63	com/facebook/imagepipeline/producers/JobScheduler:mStatus	I
    //   16: istore_1
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 61	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 63	com/facebook/imagepipeline/producers/JobScheduler:mStatus	I
    //   27: aload_0
    //   28: getstatic 90	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   31: putfield 68	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   34: aload_0
    //   35: lload_2
    //   36: putfield 72	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: iload_1
    //   44: invokestatic 94	com/facebook/imagepipeline/producers/JobScheduler:shouldProcess	(Lcom/facebook/imagepipeline/image/EncodedImage;I)Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: getfield 49	com/facebook/imagepipeline/producers/JobScheduler:mJobRunnable	Lcom/facebook/imagepipeline/producers/JobScheduler$JobRunnable;
    //   54: aload 4
    //   56: iload_1
    //   57: invokeinterface 98 3 0
    //   62: aload 4
    //   64: invokestatic 104	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   67: aload_0
    //   68: invokespecial 107	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   71: return
    //   72: astore 5
    //   74: aload 4
    //   76: invokestatic 104	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   79: aload_0
    //   80: invokespecial 107	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   83: aload 5
    //   85: athrow
    //   86: astore 4
    //   88: aload_0
    //   89: monitorexit
    //   90: aload 4
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	JobScheduler
    //   16	41	1	i	int
    //   3	33	2	l	long
    //   10	65	4	localEncodedImage	EncodedImage
    //   86	5	4	localObject1	Object
    //   72	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	62	72	finally
    //   6	41	86	finally
    //   88	90	86	finally
  }
  
  private void enqueueJob(long paramLong)
  {
    Runnable localRunnable = FrescoInstrumenter.decorateRunnable(this.mSubmitJobRunnable, "JobScheduler_enqueueJob");
    if (paramLong > 0L)
    {
      JobStartExecutorSupplier.get().schedule(localRunnable, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    localRunnable.run();
  }
  
  private void onJobFinished()
  {
    long l2 = SystemClock.uptimeMillis();
    try
    {
      long l1;
      int i;
      if (this.mJobState == JobState.RUNNING_AND_PENDING)
      {
        l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l2);
        i = 1;
        this.mJobSubmitTime = l2;
        this.mJobState = JobState.QUEUED;
      }
      else
      {
        this.mJobState = JobState.IDLE;
        l1 = 0L;
        i = 0;
      }
      if (i != 0) {
        enqueueJob(l1 - l2);
      }
      return;
    }
    finally {}
  }
  
  private static boolean shouldProcess(EncodedImage paramEncodedImage, int paramInt)
  {
    return (BaseConsumer.isLast(paramInt)) || (BaseConsumer.statusHasFlag(paramInt, 4)) || (EncodedImage.isValid(paramEncodedImage));
  }
  
  private void submitJob()
  {
    this.mExecutor.execute(FrescoInstrumenter.decorateRunnable(this.mDoJobRunnable, "JobScheduler_submitJob"));
  }
  
  public void clearJob()
  {
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = null;
      this.mStatus = 0;
      EncodedImage.closeSafely(localEncodedImage);
      return;
    }
    finally {}
  }
  
  public long getQueuedTime()
  {
    try
    {
      long l1 = this.mJobStartTime;
      long l2 = this.mJobSubmitTime;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean scheduleJob()
  {
    long l2 = SystemClock.uptimeMillis();
    for (;;)
    {
      try
      {
        boolean bool = shouldProcess(this.mEncodedImage, this.mStatus);
        int i = 0;
        if (!bool) {
          return false;
        }
        int j = 3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
        if (j != 1)
        {
          if (j == 3) {
            this.mJobState = JobState.RUNNING_AND_PENDING;
          }
        }
        else
        {
          l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l2);
          this.mJobSubmitTime = l2;
          this.mJobState = JobState.QUEUED;
          i = 1;
          if (i != 0) {
            enqueueJob(l1 - l2);
          }
          return true;
        }
      }
      finally {}
      long l1 = 0L;
    }
  }
  
  public boolean updateJob(EncodedImage paramEncodedImage, int paramInt)
  {
    if (!shouldProcess(paramEncodedImage, paramInt)) {
      return false;
    }
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      this.mStatus = paramInt;
      EncodedImage.closeSafely(localEncodedImage);
      return true;
    }
    finally {}
  }
  
  public static abstract interface JobRunnable
  {
    public abstract void run(EncodedImage paramEncodedImage, int paramInt);
  }
  
  static class JobStartExecutorSupplier
  {
    private static ScheduledExecutorService sJobStarterExecutor;
    
    static ScheduledExecutorService get()
    {
      if (sJobStarterExecutor == null) {
        sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
      }
      return sJobStarterExecutor;
    }
  }
  
  static enum JobState
  {
    static
    {
      JobState localJobState = new JobState("RUNNING_AND_PENDING", 3);
      RUNNING_AND_PENDING = localJobState;
      $VALUES = new JobState[] { IDLE, QUEUED, RUNNING, localJobState };
    }
    
    private JobState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\JobScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */