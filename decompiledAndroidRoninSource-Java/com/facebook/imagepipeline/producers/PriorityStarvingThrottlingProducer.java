package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.Priority;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PriorityStarvingThrottlingProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
  private final Executor mExecutor;
  private final Producer<T> mInputProducer;
  private final int mMaxSimultaneousRequests;
  private int mNumCurrentRequests;
  private final Queue<Item<T>> mPendingRequests;
  
  public PriorityStarvingThrottlingProducer(int paramInt, Executor paramExecutor, Producer<T> paramProducer)
  {
    this.mMaxSimultaneousRequests = paramInt;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mPendingRequests = new PriorityQueue(11, new PriorityComparator());
    this.mNumCurrentRequests = 0;
  }
  
  private void produceResultsInternal(Item<T> paramItem)
  {
    paramItem.producerContext.getProducerListener().onProducerFinishWithSuccess(paramItem.producerContext, "PriorityStarvingThrottlingProducer", null);
    this.mInputProducer.produceResults(new ThrottlerConsumer(paramItem.consumer, null), paramItem.producerContext);
  }
  
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    long l = System.nanoTime();
    paramProducerContext.getProducerListener().onProducerStart(paramProducerContext, "PriorityStarvingThrottlingProducer");
    try
    {
      int j = this.mNumCurrentRequests;
      int k = this.mMaxSimultaneousRequests;
      int i = 1;
      if (j >= k)
      {
        this.mPendingRequests.add(new Item(paramConsumer, paramProducerContext, l));
      }
      else
      {
        this.mNumCurrentRequests += 1;
        i = 0;
      }
      if (i == 0) {
        produceResultsInternal(new Item(paramConsumer, paramProducerContext, l));
      }
      return;
    }
    finally {}
  }
  
  static class Item<T>
  {
    final Consumer<T> consumer;
    final ProducerContext producerContext;
    final long time;
    
    Item(Consumer<T> paramConsumer, ProducerContext paramProducerContext, long paramLong)
    {
      this.consumer = paramConsumer;
      this.producerContext = paramProducerContext;
      this.time = paramLong;
    }
  }
  
  static class PriorityComparator<T>
    implements Comparator<PriorityStarvingThrottlingProducer.Item<T>>
  {
    public int compare(PriorityStarvingThrottlingProducer.Item<T> paramItem1, PriorityStarvingThrottlingProducer.Item<T> paramItem2)
    {
      Priority localPriority1 = paramItem1.producerContext.getPriority();
      Priority localPriority2 = paramItem2.producerContext.getPriority();
      if (localPriority1 == localPriority2) {
        return Double.compare(paramItem1.time, paramItem2.time);
      }
      if (localPriority1.ordinal() > localPriority2.ordinal()) {
        return -1;
      }
      return 1;
    }
  }
  
  private class ThrottlerConsumer
    extends DelegatingConsumer<T, T>
  {
    private ThrottlerConsumer()
    {
      super();
    }
    
    private void onRequestFinished()
    {
      synchronized (PriorityStarvingThrottlingProducer.this)
      {
        final PriorityStarvingThrottlingProducer.Item localItem = (PriorityStarvingThrottlingProducer.Item)PriorityStarvingThrottlingProducer.this.mPendingRequests.poll();
        if (localItem == null) {
          PriorityStarvingThrottlingProducer.access$210(PriorityStarvingThrottlingProducer.this);
        }
        if (localItem != null) {
          PriorityStarvingThrottlingProducer.this.mExecutor.execute(new Runnable()
          {
            public void run()
            {
              PriorityStarvingThrottlingProducer.this.produceResultsInternal(localItem);
            }
          });
        }
        return;
      }
    }
    
    protected void onCancellationImpl()
    {
      getConsumer().onCancellation();
      onRequestFinished();
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      getConsumer().onFailure(paramThrowable);
      onRequestFinished();
    }
    
    protected void onNewResultImpl(T paramT, int paramInt)
    {
      getConsumer().onNewResult(paramT, paramInt);
      if (isLast(paramInt)) {
        onRequestFinished();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\PriorityStarvingThrottlingProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */