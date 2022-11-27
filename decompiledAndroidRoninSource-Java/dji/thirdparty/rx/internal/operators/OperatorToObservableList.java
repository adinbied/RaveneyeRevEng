package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.internal.producers.SingleDelayedProducer;
import java.util.LinkedList;
import java.util.List;

public final class OperatorToObservableList<T>
  implements Observable.Operator<List<T>, T>
{
  public static <T> OperatorToObservableList<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    return null;
  }
  
  private static final class Holder
  {
    static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorToObservableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */