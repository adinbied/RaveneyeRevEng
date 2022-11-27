package org.reactivestreams;

import java.util.Objects;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public final class FlowAdapters
{
  private FlowAdapters()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Flow.Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> paramProcessor)
  {
    Objects.requireNonNull(paramProcessor, "reactiveStreamsProcessor");
    if ((paramProcessor instanceof ReactiveToFlowProcessor)) {
      return ((ReactiveToFlowProcessor)paramProcessor).flow;
    }
    if ((paramProcessor instanceof Flow.Processor)) {
      return (Flow.Processor)paramProcessor;
    }
    return new FlowToReactiveProcessor(paramProcessor);
  }
  
  public static <T> Flow.Publisher<T> toFlowPublisher(Publisher<? extends T> paramPublisher)
  {
    Objects.requireNonNull(paramPublisher, "reactiveStreamsPublisher");
    if ((paramPublisher instanceof ReactivePublisherFromFlow)) {
      return ((ReactivePublisherFromFlow)paramPublisher).flow;
    }
    if ((paramPublisher instanceof Flow.Publisher)) {
      return (Flow.Publisher)paramPublisher;
    }
    return new FlowPublisherFromReactive(paramPublisher);
  }
  
  public static <T> Flow.Subscriber<T> toFlowSubscriber(Subscriber<T> paramSubscriber)
  {
    Objects.requireNonNull(paramSubscriber, "reactiveStreamsSubscriber");
    if ((paramSubscriber instanceof ReactiveToFlowSubscriber)) {
      return ((ReactiveToFlowSubscriber)paramSubscriber).flow;
    }
    if ((paramSubscriber instanceof Flow.Subscriber)) {
      return (Flow.Subscriber)paramSubscriber;
    }
    return new FlowToReactiveSubscriber(paramSubscriber);
  }
  
  public static <T, U> Processor<T, U> toProcessor(Flow.Processor<? super T, ? extends U> paramProcessor)
  {
    Objects.requireNonNull(paramProcessor, "flowProcessor");
    if ((paramProcessor instanceof FlowToReactiveProcessor)) {
      return ((FlowToReactiveProcessor)paramProcessor).reactiveStreams;
    }
    if ((paramProcessor instanceof Processor)) {
      return (Processor)paramProcessor;
    }
    return new ReactiveToFlowProcessor(paramProcessor);
  }
  
  public static <T> Publisher<T> toPublisher(Flow.Publisher<? extends T> paramPublisher)
  {
    Objects.requireNonNull(paramPublisher, "flowPublisher");
    if ((paramPublisher instanceof FlowPublisherFromReactive)) {
      return ((FlowPublisherFromReactive)paramPublisher).reactiveStreams;
    }
    if ((paramPublisher instanceof Publisher)) {
      return (Publisher)paramPublisher;
    }
    return new ReactivePublisherFromFlow(paramPublisher);
  }
  
  public static <T> Subscriber<T> toSubscriber(Flow.Subscriber<T> paramSubscriber)
  {
    Objects.requireNonNull(paramSubscriber, "flowSubscriber");
    if ((paramSubscriber instanceof FlowToReactiveSubscriber)) {
      return ((FlowToReactiveSubscriber)paramSubscriber).reactiveStreams;
    }
    if ((paramSubscriber instanceof Subscriber)) {
      return (Subscriber)paramSubscriber;
    }
    return new ReactiveToFlowSubscriber(paramSubscriber);
  }
  
  static final class FlowPublisherFromReactive<T>
    implements Flow.Publisher<T>
  {
    final Publisher<? extends T> reactiveStreams;
    
    public FlowPublisherFromReactive(Publisher<? extends T> paramPublisher)
    {
      this.reactiveStreams = paramPublisher;
    }
    
    public void subscribe(Flow.Subscriber<? super T> paramSubscriber)
    {
      Publisher localPublisher = this.reactiveStreams;
      if (paramSubscriber == null) {
        paramSubscriber = null;
      } else {
        paramSubscriber = new FlowAdapters.ReactiveToFlowSubscriber(paramSubscriber);
      }
      localPublisher.subscribe(paramSubscriber);
    }
  }
  
  static final class FlowToReactiveProcessor<T, U>
    implements Flow.Processor<T, U>
  {
    final Processor<? super T, ? extends U> reactiveStreams;
    
    public FlowToReactiveProcessor(Processor<? super T, ? extends U> paramProcessor)
    {
      this.reactiveStreams = paramProcessor;
    }
    
    public void onComplete()
    {
      this.reactiveStreams.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.reactiveStreams.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.reactiveStreams.onNext(paramT);
    }
    
    public void onSubscribe(Flow.Subscription paramSubscription)
    {
      Processor localProcessor = this.reactiveStreams;
      if (paramSubscription == null) {
        paramSubscription = null;
      } else {
        paramSubscription = new FlowAdapters.ReactiveToFlowSubscription(paramSubscription);
      }
      localProcessor.onSubscribe(paramSubscription);
    }
    
    public void subscribe(Flow.Subscriber<? super U> paramSubscriber)
    {
      Processor localProcessor = this.reactiveStreams;
      if (paramSubscriber == null) {
        paramSubscriber = null;
      } else {
        paramSubscriber = new FlowAdapters.ReactiveToFlowSubscriber(paramSubscriber);
      }
      localProcessor.subscribe(paramSubscriber);
    }
  }
  
  static final class FlowToReactiveSubscriber<T>
    implements Flow.Subscriber<T>
  {
    final Subscriber<? super T> reactiveStreams;
    
    public FlowToReactiveSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.reactiveStreams = paramSubscriber;
    }
    
    public void onComplete()
    {
      this.reactiveStreams.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.reactiveStreams.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.reactiveStreams.onNext(paramT);
    }
    
    public void onSubscribe(Flow.Subscription paramSubscription)
    {
      Subscriber localSubscriber = this.reactiveStreams;
      if (paramSubscription == null) {
        paramSubscription = null;
      } else {
        paramSubscription = new FlowAdapters.ReactiveToFlowSubscription(paramSubscription);
      }
      localSubscriber.onSubscribe(paramSubscription);
    }
  }
  
  static final class FlowToReactiveSubscription
    implements Flow.Subscription
  {
    final Subscription reactiveStreams;
    
    public FlowToReactiveSubscription(Subscription paramSubscription)
    {
      this.reactiveStreams = paramSubscription;
    }
    
    public void cancel()
    {
      this.reactiveStreams.cancel();
    }
    
    public void request(long paramLong)
    {
      this.reactiveStreams.request(paramLong);
    }
  }
  
  static final class ReactivePublisherFromFlow<T>
    implements Publisher<T>
  {
    final Flow.Publisher<? extends T> flow;
    
    public ReactivePublisherFromFlow(Flow.Publisher<? extends T> paramPublisher)
    {
      this.flow = paramPublisher;
    }
    
    public void subscribe(Subscriber<? super T> paramSubscriber)
    {
      Flow.Publisher localPublisher = this.flow;
      if (paramSubscriber == null) {
        paramSubscriber = null;
      } else {
        paramSubscriber = new FlowAdapters.FlowToReactiveSubscriber(paramSubscriber);
      }
      localPublisher.subscribe(paramSubscriber);
    }
  }
  
  static final class ReactiveToFlowProcessor<T, U>
    implements Processor<T, U>
  {
    final Flow.Processor<? super T, ? extends U> flow;
    
    public ReactiveToFlowProcessor(Flow.Processor<? super T, ? extends U> paramProcessor)
    {
      this.flow = paramProcessor;
    }
    
    public void onComplete()
    {
      this.flow.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.flow.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.flow.onNext(paramT);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      Flow.Processor localProcessor = this.flow;
      if (paramSubscription == null) {
        paramSubscription = null;
      } else {
        paramSubscription = new FlowAdapters.FlowToReactiveSubscription(paramSubscription);
      }
      localProcessor.onSubscribe(paramSubscription);
    }
    
    public void subscribe(Subscriber<? super U> paramSubscriber)
    {
      Flow.Processor localProcessor = this.flow;
      if (paramSubscriber == null) {
        paramSubscriber = null;
      } else {
        paramSubscriber = new FlowAdapters.FlowToReactiveSubscriber(paramSubscriber);
      }
      localProcessor.subscribe(paramSubscriber);
    }
  }
  
  static final class ReactiveToFlowSubscriber<T>
    implements Subscriber<T>
  {
    final Flow.Subscriber<? super T> flow;
    
    public ReactiveToFlowSubscriber(Flow.Subscriber<? super T> paramSubscriber)
    {
      this.flow = paramSubscriber;
    }
    
    public void onComplete()
    {
      this.flow.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.flow.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.flow.onNext(paramT);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      Flow.Subscriber localSubscriber = this.flow;
      if (paramSubscription == null) {
        paramSubscription = null;
      } else {
        paramSubscription = new FlowAdapters.FlowToReactiveSubscription(paramSubscription);
      }
      localSubscriber.onSubscribe(paramSubscription);
    }
  }
  
  static final class ReactiveToFlowSubscription
    implements Subscription
  {
    final Flow.Subscription flow;
    
    public ReactiveToFlowSubscription(Flow.Subscription paramSubscription)
    {
      this.flow = paramSubscription;
    }
    
    public void cancel()
    {
      this.flow.cancel();
    }
    
    public void request(long paramLong)
    {
      this.flow.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\reactivestreams\FlowAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */