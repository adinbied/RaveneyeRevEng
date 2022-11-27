package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class ThreadHandoffProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
  private final Producer<T> mInputProducer;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  
  public ThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
  }
  
  @Nullable
  private static String getInstrumentationTag(ProducerContext paramProducerContext)
  {
    if (FrescoInstrumenter.isTracing())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ThreadHandoffProducer_produceResults_");
      localStringBuilder.append(paramProducerContext.getId());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public void produceResults(final Consumer<T> paramConsumer, final ProducerContext paramProducerContext)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
      }
      final ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
      paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener2, paramProducerContext, "BackgroundThreadHandoffProducer")
      {
        protected void disposeResult(T paramAnonymousT) {}
        
        @Nullable
        protected T getResult()
          throws Exception
        {
          return null;
        }
        
        protected void onSuccess(T paramAnonymousT)
        {
          localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "BackgroundThreadHandoffProducer", null);
          ThreadHandoffProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
        }
      };
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          paramConsumer.cancel();
          ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(paramConsumer);
        }
      });
      this.mThreadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(paramConsumer, getInstrumentationTag(paramProducerContext)));
      return;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ThreadHandoffProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */