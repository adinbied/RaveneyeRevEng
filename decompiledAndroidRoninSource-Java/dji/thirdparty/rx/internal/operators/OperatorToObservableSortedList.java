package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.producers.SingleDelayedProducer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class OperatorToObservableSortedList<T>
  implements Observable.Operator<List<T>, T>
{
  private static Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
  final int initialCapacity;
  final Comparator<? super T> sortFunction;
  
  public OperatorToObservableSortedList(int paramInt)
  {
    this.sortFunction = DEFAULT_SORT_FUNCTION;
    this.initialCapacity = paramInt;
  }
  
  public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> paramFunc2, int paramInt)
  {
    this.initialCapacity = paramInt;
    this.sortFunction = new Comparator()
    {
      public int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return 0;
      }
    };
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    return null;
  }
  
  private static class DefaultComparableFunction
    implements Comparator<Object>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorToObservableSortedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */