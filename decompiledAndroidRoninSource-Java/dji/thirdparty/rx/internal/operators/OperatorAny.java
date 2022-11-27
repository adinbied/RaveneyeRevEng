package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.producers.SingleDelayedProducer;

public final class OperatorAny<T>
  implements Observable.Operator<Boolean, T>
{
  final Func1<? super T, Boolean> predicate;
  final boolean returnOnEmpty;
  
  public OperatorAny(Func1<? super T, Boolean> paramFunc1, boolean paramBoolean)
  {
    this.predicate = paramFunc1;
    this.returnOnEmpty = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Boolean> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorAny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */