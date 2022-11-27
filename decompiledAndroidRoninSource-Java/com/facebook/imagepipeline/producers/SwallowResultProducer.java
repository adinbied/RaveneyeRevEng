package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T>
  implements Producer<Void>
{
  private final Producer<T> mInputProducer;
  
  public SwallowResultProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<Void> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new DelegatingConsumer(paramConsumer)
    {
      protected void onNewResultImpl(T paramAnonymousT, int paramAnonymousInt)
      {
        if (isLast(paramAnonymousInt)) {
          getConsumer().onNewResult(null, paramAnonymousInt);
        }
      }
    };
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\SwallowResultProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */