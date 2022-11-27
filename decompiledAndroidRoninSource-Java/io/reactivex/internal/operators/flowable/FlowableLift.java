package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;

public final class FlowableLift<R, T>
  extends AbstractFlowableWithUpstream<T, R>
{
  final FlowableOperator<? extends R, ? super T> operator;
  
  public FlowableLift(Flowable<T> paramFlowable, FlowableOperator<? extends R, ? super T> paramFlowableOperator)
  {
    super(paramFlowable);
    this.operator = paramFlowableOperator;
  }
  
  /* Error */
  public void subscribeActual(org.reactivestreams.Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */