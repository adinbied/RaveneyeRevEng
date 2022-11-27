package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T>
  extends Flowable<T>
{
  final boolean emitLast;
  final Publisher<?> other;
  final Publisher<T> source;
  
  public FlowableSamplePublisher(Publisher<T> paramPublisher, Publisher<?> paramPublisher1, boolean paramBoolean)
  {
    this.source = paramPublisher;
    this.other = paramPublisher1;
    this.emitLast = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SampleMainEmitLast<T>
    extends FlowableSamplePublisher.SamplePublisherSubscriber<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip = new AtomicInteger();
    
    SampleMainEmitLast(Subscriber<? super T> paramSubscriber, Publisher<?> paramPublisher)
    {
      super(paramPublisher);
    }
    
    /* Error */
    void completion()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SampleMainNoLast<T>
    extends FlowableSamplePublisher.SamplePublisherSubscriber<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    
    SampleMainNoLast(Subscriber<? super T> paramSubscriber, Publisher<?> paramPublisher)
    {
      super(paramPublisher);
    }
    
    void completion()
    {
      this.downstream.onComplete();
    }
    
    void run()
    {
      emit();
    }
  }
  
  static abstract class SamplePublisherSubscriber<T>
    extends AtomicReference<T>
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> other = new AtomicReference();
    final AtomicLong requested = new AtomicLong();
    final Publisher<?> sampler;
    Subscription upstream;
    
    SamplePublisherSubscriber(Subscriber<? super T> paramSubscriber, Publisher<?> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.sampler = paramPublisher;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void completion();
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(T paramT)
    {
      lazySet(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    abstract void run();
    
    /* Error */
    void setOther(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SamplerSubscriber<T>
    implements FlowableSubscriber<Object>
  {
    final FlowableSamplePublisher.SamplePublisherSubscriber<T> parent;
    
    SamplerSubscriber(FlowableSamplePublisher.SamplePublisherSubscriber<T> paramSamplePublisherSubscriber)
    {
      this.parent = paramSamplePublisherSubscriber;
    }
    
    public void onComplete()
    {
      this.parent.complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.parent.run();
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      this.parent.setOther(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSamplePublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */