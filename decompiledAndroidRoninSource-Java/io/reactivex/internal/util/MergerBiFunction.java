package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

public final class MergerBiFunction<T>
  implements BiFunction<List<T>, List<T>, List<T>>
{
  final Comparator<? super T> comparator;
  
  public MergerBiFunction(Comparator<? super T> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public List<T> apply(List<T> paramList1, List<T> paramList2)
    throws Exception
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\MergerBiFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */