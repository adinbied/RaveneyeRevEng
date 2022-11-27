package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class OperatorToMultimap<T, K, V>
  implements Observable.Operator<Map<K, Collection<V>>, T>
{
  final Func1<? super K, ? extends Collection<V>> collectionFactory;
  final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, Collection<V>>> mapFactory;
  final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new DefaultToMultimapFactory(), new DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0)
  {
    this(paramFunc1, paramFunc11, paramFunc0, new DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0, Func1<? super K, ? extends Collection<V>> paramFunc12)
  {
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.mapFactory = paramFunc0;
    this.collectionFactory = paramFunc12;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Map<K, Collection<V>>> paramSubscriber)
  {
    return null;
  }
  
  public static final class DefaultMultimapCollectionFactory<K, V>
    implements Func1<K, Collection<V>>
  {
    public Collection<V> call(K paramK)
    {
      return new ArrayList();
    }
  }
  
  public static final class DefaultToMultimapFactory<K, V>
    implements Func0<Map<K, Collection<V>>>
  {
    public Map<K, Collection<V>> call()
    {
      return new HashMap();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorToMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */