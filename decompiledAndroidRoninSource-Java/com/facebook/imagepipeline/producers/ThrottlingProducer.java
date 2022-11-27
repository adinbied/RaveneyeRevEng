package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThrottlingProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "ThrottlingProducer";
  private final Executor mExecutor;
  private final Producer<T> mInputProducer;
  private final int mMaxSimultaneousRequests;
  private int mNumCurrentRequests;
  private final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;
  
  public ThrottlingProducer(int paramInt, Executor paramExecutor, Producer<T> paramProducer)
  {
    this.mMaxSimultaneousRequests = paramInt;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mPendingRequests = new ConcurrentLinkedQueue();
    this.mNumCurrentRequests = 0;
  }
  
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getProducerListener().onProducerStart(paramProducerContext, "ThrottlingProducer");
    try
    {
      int j = this.mNumCurrentRequests;
      int k = this.mMaxSimultaneousRequests;
      int i = 1;
      if (j >= k)
      {
        this.mPendingRequests.add(Pair.create(paramConsumer, paramProducerContext));
      }
      else
      {
        this.mNumCurrentRequests += 1;
        i = 0;
      }
      if (i == 0) {
        produceResultsInternal(paramConsumer, paramProducerContext);
      }
      return;
    }
    finally {}
  }
  
  void produceResultsInternal(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getProducerListener().onProducerFinishWithSuccess(paramProducerContext, "ThrottlingProducer", null);
    this.mInputProducer.produceResults(new ThrottlerConsumer(paramConsumer, null), paramProducerContext);
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
      synchronized (ThrottlingProducer.this)
      {
        final Pair localPair = (Pair)ThrottlingProducer.this.mPendingRequests.poll();
        if (localPair == null) {
          ThrottlingProducer.access$210(ThrottlingProducer.this);
        }
        if (localPair != null) {
          ThrottlingProducer.this.mExecutor.execute(new Runnable()
          {
            public void run()
            {
              ThrottlingProducer.this.produceResultsInternal((Consumer)localPair.first, (ProducerContext)localPair.second);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ThrottlingProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */