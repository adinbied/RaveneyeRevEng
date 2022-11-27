package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import java.util.HashMap;
import java.util.Map;

public final class OperatorToMap<T, K, V>
  implements Observable.Operator<Map<K, V>, T>
{
  final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, V>> mapFactory;
  final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new DefaultToMapFactory());
  }
  
  public OperatorToMap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, V>> paramFunc0)
  {
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.mapFactory = paramFunc0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Map<K, V>> paramSubscriber)
  {
    return null;
  }
  
  public static final class DefaultToMapFactory<K, V>
    implements Func0<Map<K, V>>
  {
    public Map<K, V> call()
    {
      return new HashMap();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorToMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */