package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableAutoConnect<T>
  extends Flowable<T>
{
  final AtomicInteger clients;
  final Consumer<? super Disposable> connection;
  final int numberOfSubscribers;
  final ConnectableFlowable<? extends T> source;
  
  public FlowableAutoConnect(ConnectableFlowable<? extends T> paramConnectableFlowable, int paramInt, Consumer<? super Disposable> paramConsumer)
  {
    this.source = paramConnectableFlowable;
    this.numberOfSubscribers = paramInt;
    this.connection = paramConsumer;
    this.clients = new AtomicInteger();
  }
  
  /* Error */
  public void subscribeActual(org.reactivestreams.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAutoConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */