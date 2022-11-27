package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableMaterialize<T>
  extends AbstractFlowableWithUpstream<T, Notification<T>>
{
  public FlowableMaterialize(Flowable<T> paramFlowable)
  {
    super(paramFlowable);
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Notification<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MaterializeSubscriber<T>
    extends SinglePostCompleteSubscriber<T, Notification<T>>
  {
    private static final long serialVersionUID = -3740826063558713822L;
    
    MaterializeSubscriber(Subscriber<? super Notification<T>> paramSubscriber)
    {
      super();
    }
    
    public void onComplete()
    {
      complete(Notification.createOnComplete());
    }
    
    /* Error */
    protected void onDrop(Notification<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      complete(Notification.createOnError(paramThrowable));
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMaterialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */